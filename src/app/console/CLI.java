package app.console;

import app.console.exceptions.NotRegisteredCommandException;
import app.console.exceptions.ValidationException;

final public class CLI
{
    final private CommandBag commands;

    public CLI(CLIConfigurator config)
    {
        this.commands = config.commands();
    }

    public void handle(String[] parameters) throws NotRegisteredCommandException
    {
        String cmdName = parameters.length > 0 ? parameters[0] : null;
        ICommand command = this.commands.find(cmdName);

        if (command == null) {
            throw new NotRegisteredCommandException(
                "\t** CLI don't have the command " + cmdName
            );
        }

        Input input = new Input(parameters);
        Definition definition = new Definition();
        InputValidator validator = new InputValidator();

        // define the input
        definition.arguments.add(new ArgumentDefinition("command", false, cmdName));
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
}
