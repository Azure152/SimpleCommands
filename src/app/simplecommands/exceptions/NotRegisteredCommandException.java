package app.simplecommands.exceptions;

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
