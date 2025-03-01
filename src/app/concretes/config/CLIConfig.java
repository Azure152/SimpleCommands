package app.concretes.config;

// import app.concretes.commands.GreetCommand;
// import app.concretes.commands.SumCommand;
import app.concretes.commands.bags.DefaultCommnads;
import app.simplecommands.InterpreterConfigurator;
import app.simplecommands.commands.CommandBag;

public class CLIConfig extends InterpreterConfigurator
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
