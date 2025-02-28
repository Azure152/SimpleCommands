package app.console;

public class OptionDefinition
{
    /**
     * name of option to define
     */
    public final String name;

    /**
     * the value used by default
     */
    public final String value;

    /**
     * @param name name of option to define
     * @param value default value for option
     */
    public OptionDefinition(String name, String value)
    {
        this.name = name;
        this.value = value;
    }
}
