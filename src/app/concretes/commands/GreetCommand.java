package app.concretes.commands;

import app.console.Definition;
import app.console.ICommand;
import app.console.Input;
import app.console.OptionDefinition;

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
