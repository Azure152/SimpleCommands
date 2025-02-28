package app.console;

public class CLIConfigurator
{
    public CLIConfigurator() {}

    /**
     * configurate the cli commands
     */
    public CommandBag commands()
    {
        return new CommandBag();
    }
}
