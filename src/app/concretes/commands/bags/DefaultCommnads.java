package app.concretes.commands.bags;

import app.concretes.commands.GreetCommand;
import app.concretes.commands.SumCommand;
import app.console.CommandBag;

public class DefaultCommnads extends CommandBag
{
    public DefaultCommnads()
    {
        this.set("greet", new GreetCommand());
        this.set("sum", new SumCommand());
    }
}
