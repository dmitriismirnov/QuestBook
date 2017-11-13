package ru.utils.events;

public abstract class BaseTimestampEvent
{
// -- Construction

    public BaseTimestampEvent() {
        mEventTimestamp = System.currentTimeMillis();
    }

    public BaseTimestampEvent(long eventTimestamp) {
        mEventTimestamp = eventTimestamp;
    }

// -- Functions

    public boolean isEventNewer(long previousTimestamp)  {
        return mEventTimestamp > previousTimestamp;
    }

    public long getEventTimestamp() {
        return mEventTimestamp;
    }

// -- Variables

    private long mEventTimestamp;

}

