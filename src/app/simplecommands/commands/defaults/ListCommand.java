package app.simplecommands.commands.defaults;

import java.util.Collection;

import app.simplecommands.commands.CommandBag;
import app.simplecommands.commands.CommandDescriptor;
import app.simplecommands.commands.ICommand;
import app.simplecommands.inputs.Input;

public class ListCommand implements ICommand
{
    private CommandBag commands;

    public ListCommand(CommandBag commands)
    {
        this.commands = commands;
    }

    @Override
    public void execute(Input input)
    {
        int maxLength = this.findMaxLength(commands.commands());

        StringBuilder builder = new StringBuilder();
        builder.append("-------------------------------------------\n");

        for (String key : commands.commands()) {
            ICommand command = commands.find(key);

            builder.append(String.format("* %-" + maxLength + "s", key));
            builder.append("  | " + command.descriptor().getBasic());
            builder.append("\r\n");
        }

        builder.append("-------------------------------------------");

        System.out.println(builder.toString());
    }

    private int findMaxLength(Collection<String> strings)
    {
        return strings.stream().mapToInt((s) -> s.length()).max().getAsInt();
    }

    @Override
    public CommandDescriptor descriptor()
    {
        CommandDescriptor descriptor = new CommandDescriptor(
            "List the available commands"
        );
    
        return descriptor;
    }
}
