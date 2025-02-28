package app.console;

public class ArgumentDefinition
{
    /**
     * name of argument to define
     */
    public final String name;

    /**
     * indicate if the argument is optional
     */
    public final boolean optional;

    /**
     * the value used by default
     */
    public final String value;

    public ArgumentDefinition(String name, boolean optional, String value)
    {
        this.name = name;
        this.optional = optional;
        this.value = value;
    }
}
