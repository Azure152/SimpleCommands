package app.concretes.commands;

import app.simplecommands.commands.ICommand;
import app.simplecommands.inputs.Definition;
import app.simplecommands.inputs.Input;
import app.simplecommands.inputs.OptionDefinition;

public class GreetCommand implements ICommand
{
    @Override
    public void execute(Input input)
    {
        // System.out.println("Hello from GreetCommand!");

        System.out.println("Hello " + input.option("name"));
    }

    @Override
    public void defineInput(Definition definition)
    {
        definition.options.add(new OptionDefinition("name", "World"));
    }
}
