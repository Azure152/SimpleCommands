package app.simplecommands.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandBag
{
    private Map<String, ICommand> commands;

    public CommandBag()
    {
        this.commands = new HashMap<>();
    }

    public void set(String name, ICommand command)
    {
        this.commands.put(name, command);
    }

    public ICommand find(String name)
    {
        return this.commands.get(name);
    }
}
