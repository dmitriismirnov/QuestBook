package ru.utils.data.validator;

public class JsonValidationException extends Exception
{
// -- construction

    public JsonValidationException() {
        super();
    }

    public JsonValidationException(String detailMessage) {
        super(detailMessage);
    }

    public JsonValidationException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public JsonValidationException(Throwable throwable) {
        super(throwable);
    }

// -- variables

    private static final long serialVersionUID = 2237443408803971617L;

}
