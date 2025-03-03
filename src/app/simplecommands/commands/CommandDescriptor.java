package app.simplecommands.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandDescriptor
{
    /**
     * basic command description
     */
    private String basic;

    /**
     * arguments description
     */
    private Map<String, String> arguments;

    /**
     * options description
     */
    private Map<String, String> options;

    public CommandDescriptor(String description)
    {
        this.basic = description;
        this.arguments = new HashMap<>();
        this.options = new HashMap<>();
    }

    /**
     * set the description for argument
     * 
     * @param name name of the argument described
     * @param description description
     */
    public void setArgument(String name, String description)
    {
        this.arguments.put(name, description);
    }

    /**
     * set the description for argument
     * 
     * @param name name of the option described
     * @param description description/funtionality
     */
    public void setOption(String name, String description)
    {
        this.options.put(name, description);
    }

    /**
     * get description of argument
     * 
     * @param name name of the argument to get description
     * 
     * @return description for argument or null otherwise
     */
    public String getArgument(String name)
    {
        return this.arguments.get(name);
    }

    /**
     * get description of argument
     * 
     * @param name name of the argument to get description
     * 
     * @return description for option or null otherwise
     */
    public String getOption(String name)
    {
        return this.options.get(name);
    }

    public String getBasic()
    {
        return basic;
    }

    public Map<String, String> getArguments() {
        return arguments;
    }

    public Map<String, String> getOptions() {
        return options;
    }
}
