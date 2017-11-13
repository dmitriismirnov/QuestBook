package ru.mvp;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import io.reactivex.Observable;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function3;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;

public class OperatorFreeze<T> implements ObservableOperator<T, T> {
    private final Observable<Boolean> mFreezeSelector;
    private final Function3<T, T, T, Boolean> mReplaceFrozenEventPredicate;

    public OperatorFreeze(Observable<Boolean> freezeSelector, Function3<T, T, T, Boolean> replaceFrozenEventPredicate) {
        this.mFreezeSelector = freezeSelector;
        this.mReplaceFrozenEventPredicate = replaceFrozenEventPredicate;
    }

    public OperatorFreeze(Observable<Boolean> freezeSelector) {
        this(freezeSelector, (frozenEvent, newEvent, value) -> false);
    }

    @Override
    public Observer<? super T> apply(@NonNull Observer<? super T> observer) throws Exception {
        final FreezeSubscriber<T> freezeSubscriber = new FreezeSubscriber<>(new SerializedObserver<>(observer), mReplaceFrozenEventPredicate);

        DisposableObserver<Boolean> freezeSelectorSubscriber = new DisposableObserver<Boolean>() {
            @Override
            public void onNext(@NonNull Boolean aBoolean) {
                freezeSubscriber.setFrozen(aBoolean);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                freezeSubscriber.forceOnError(e);
            }

            @Override
            public void onComplete() {
                freezeSubscriber.forceOnComplete();
            }
        };
        observer.onSubscribe(freezeSubscriber);
        observer.onSubscribe(freezeSelectorSubscriber);
        mFreezeSelector.subscribe(freezeSelectorSubscriber);
        return freezeSubscriber;
    }

    private static final class FreezeSubscriber<T> extends DisposableObserver<T> {

        private final Observer<T> mChild;
        private final Function3<T, T, T, Boolean> mReplaceFrozenEventPredicate;
        private final List<T> mFrozenEventsBuffer = new LinkedList<>();

        private boolean mIsFrozen = true;
        private boolean mIsFinished = false;
        private Throwable mError = null;

        public FreezeSubscriber(Observer<T> child, Function3<T, T, T, Boolean> replaceFrozenEventPredicate) {
            this.mChild = child;
            this.mReplaceFrozenEventPredicate = replaceFrozenEventPredicate;
        }

        @Override
        public void onError(Throwable e) {
            if (mIsFinished || mError != null) {
                return;
            }
            synchronized (this) {
                if (mIsFrozen) {
                    mError = e;
                } else {
                    mChild.onError(e);
                    dispose();
                }
            }
        }

        @Override
        public void onComplete() {
            if (mIsFinished || mError != null) {
                return;
            }
            synchronized (this) {
                if (mIsFrozen) {
                    mIsFinished = true;
                } else {
                    mChild.onComplete();
                    dispose();
                }
            }
        }

        @Override
        public void onNext(T event) {
            if (mIsFinished || mError != null) {
                return;
            }
            synchronized (this) {
                if (mIsFrozen) {
                    bufferEvent(event);
                } else {
                    mChild.onNext(event);
                }
            }
        }

        private void bufferEvent(T event) {
            for (ListIterator<T> it = mFrozenEventsBuffer.listIterator(); it.hasNext(); ) {
                T frozenEvent = it.next();
                try {
                    if (mReplaceFrozenEventPredicate.apply(frozenEvent, event, null)) {
                        it.remove();
                    }
                } catch (Throwable ex) {
                    Exceptions.throwIfFatal(ex);
                    dispose();
                    onError(ex);
                    return;
                }
            }
            mFrozenEventsBuffer.add(event);
        }

        public void forceOnComplete() {
            mChild.onComplete();
            dispose();
        }

        public void forceOnError(Throwable e) {
            mChild.onError(e);
            dispose();
        }

        public synchronized void setFrozen(boolean frozen) {
            this.mIsFrozen = frozen;
            if (!frozen) {
                emitFrozenEvents();
                if (mError != null) {
                    forceOnError(mError);
                }
                if (mIsFinished) {
                    forceOnComplete();
                }
            }
        }

        private void emitFrozenEvents() {
            mFrozenEventsBuffer.forEach(mChild::onNext);
            mFrozenEventsBuffer.clear();
        }
    }
}
