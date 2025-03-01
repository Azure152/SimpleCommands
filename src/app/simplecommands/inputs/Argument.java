package app.simplecommands.inputs;

public class Argument
{
    private String name;
    private String value;

    public Argument(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public String getName()
    {
        return name;
    }
}
