package ru.utils.data;

// FIXME: code refactoring is needed
public class InvalidPathException extends Exception
{
// -- construction

    public InvalidPathException() {
        super();
    }

    public InvalidPathException(String detailMessage) {
        super(detailMessage);
    }

    public InvalidPathException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public InvalidPathException(Throwable throwable) {
        super(throwable);
    }

// -- variables

    private static final long serialVersionUID = 8039716174434082237L;

}
