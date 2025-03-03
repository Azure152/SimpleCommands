package app.simplecommands.commands.defaults;

import app.simplecommands.commands.CommandBag;
import app.simplecommands.commands.CommandDescriptor;
import app.simplecommands.commands.ICommand;
import app.simplecommands.inputs.ArgumentDefinition;
import app.simplecommands.inputs.Definition;
import app.simplecommands.inputs.Input;
import app.simplecommands.inputs.OptionDefinition;

public class DescriptorCommand implements ICommand
{
    private CommandBag commands;

    public DescriptorCommand(CommandBag commands)
    {
        this.commands = commands;
    }

    @Override
    public void execute(Input input)
    {
        ICommand command = this.commands.find(input.argument("cmd"));
        CommandDescriptor descriptor = command.descriptor();
        StringBuilder builder = new StringBuilder();
        Definition definition = new Definition();
        command.defineInput(definition);

        builder.append("\n* Description \n");
        builder.append("|   " + descriptor.getBasic() + "\n");

        if (! definition.arguments.isEmpty()) {
            builder.append("* arguments\n");

            for (ArgumentDefinition item : definition.arguments) {
                String text = item.name + " (" + (item.optional ? "optional" : "required") + ")";
                builder.append("|   " + text + " : " + descriptor.getArgument(item.name));
                builder.append("\n");
            }
        }

        if (! definition.options.isEmpty()) {
            builder.append("* options \n");

            for (OptionDefinition item : definition.options) {
                builder.append("|   --" + item.name + " : " + descriptor.getOption(item.name));
                builder.append("\n");
            }
        }

        System.out.println(builder.toString());
    }

    @Override
    public void defineInput(Definition definition)
    {
        definition.arguments.add(new ArgumentDefinition("cmd", false, null));
    }

    @Override
    public CommandDescriptor descriptor()
    {
        CommandDescriptor descriptor = new CommandDescriptor(
            "show the arguments and options description of a command"
        );

        descriptor.setArgument("cmd", "the command to describe");

        return descriptor;
    }
}
