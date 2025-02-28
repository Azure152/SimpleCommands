package app.console.exceptions;

public class NotRegisteredCommandException extends Exception
{
    public NotRegisteredCommandException()
    {
    }

    public NotRegisteredCommandException(String message)
    {
        super(message);
    }
}
