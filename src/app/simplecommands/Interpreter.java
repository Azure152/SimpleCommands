package app.simplecommands;

import app.simplecommands.commands.CommandBag;
import app.simplecommands.commands.ICommand;
import app.simplecommands.exceptions.NotRegisteredCommandException;
import app.simplecommands.exceptions.ValidationException;
import app.simplecommands.inputs.ArgumentDefinition;
import app.simplecommands.inputs.Definition;
import app.simplecommands.inputs.Input;
import app.simplecommands.inputs.InputValidator;

final public class Interpreter
{
    final private CommandBag commands;

    public Interpreter(InterpreterConfigurator config)
    {
        this.commands = config.commands();
    }

    public void handle(String[] parameters) throws NotRegisteredCommandException
    {
        ICommand command = this.findCommand(parameters);

        Input input = new Input(parameters);
        Definition definition = new Definition();
        InputValidator validator = new InputValidator();

        // define the input
        definition.arguments.add(new ArgumentDefinition("command", false, null));
        command.defineInput(definition);
        input.bind(definition);

        // rules of validation for input
        command.validateInput(validator);

        try {
            validator.validate(input); // validate input
            command.execute(input);
        } catch (ValidationException e) {
            System.out.println("\n  ** ValidationFail => " + e.getMessage() + "\n");
        }
    }

    private ICommand findCommand(String[] parameters) throws NotRegisteredCommandException
    {
        String cmdName = parameters.length > 0 ? parameters[0] : null;
        ICommand command = this.commands.find(cmdName);

        if (command == null) {
            throw new NotRegisteredCommandException("CLI don't have the command " + cmdName);
        }

        return command;
    }
}
