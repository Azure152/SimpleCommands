package app.simplecommands;

import app.simplecommands.commands.CommandBag;

public class InterpreterConfigurator
{
    public InterpreterConfigurator() {}

    /**
     * configurate the cli commands
     */
    public CommandBag commands()
    {
        return new CommandBag();
    }
}
