package app.concretes.commands.bags;

import app.concretes.commands.GreetCommand;
import app.concretes.commands.SumCommand;
import app.simplecommands.commands.CommandBag;
import app.simplecommands.commands.defaults.DescriptorCommand;
import app.simplecommands.commands.defaults.ListCommand;

public class DefaultCommnads extends CommandBag
{
    public DefaultCommnads()
    {
        this.set("list", new ListCommand(this));
        this.set("descriptor", new DescriptorCommand(this));
        this.set("greet", new GreetCommand());
        this.set("sum", new SumCommand());
    }
}
