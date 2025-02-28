package app.concretes.commands;

import app.concretes.rules.IntegerRule;
import app.console.ArgumentDefinition;
import app.console.Definition;
import app.console.ICommand;
import app.console.Input;
import app.console.InputValidator;

public class SumCommand implements ICommand
{
    @Override
    public void execute(Input input)
    {
        int num1 = Integer.parseInt(input.argument("num1"));
        int num2 = Integer.parseInt(input.argument("num2"));

        System.out.println("The result of the sum is " + (num1 + num2));
    }

    @Override
    public void defineInput(Definition definition)
    {
        definition.arguments.add(new ArgumentDefinition("num1", false, null));
        definition.arguments.add(new ArgumentDefinition("num2", false, null));
    }

    @Override
    public void validateInput(InputValidator validator)
    {
        validator.arguments.put("num1", new IntegerRule());
        validator.arguments.put("num2", new IntegerRule());
    }
}
