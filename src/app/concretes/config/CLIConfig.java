package app.concretes.config;

// import app.concretes.commands.GreetCommand;
// import app.concretes.commands.SumCommand;
import app.concretes.commands.bags.DefaultCommnads;
import app.console.CLIConfigurator;
import app.console.CommandBag;

public class CLIConfig extends CLIConfigurator
{
    @Override
    public CommandBag commands()
    {
        // CommandBag bag = new CommandBag();

        // bag.set("greet", new GreetCommand());
        // bag.set("sum", new SumCommand());

        // return bag;
        
        return new DefaultCommnads();
    }
}
