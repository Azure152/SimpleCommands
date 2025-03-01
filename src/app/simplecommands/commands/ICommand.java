package app.simplecommands.commands;

import app.simplecommands.inputs.Definition;
import app.simplecommands.inputs.Input;
import app.simplecommands.inputs.InputValidator;

public interface ICommand
{
    public void execute(Input input);

    /**
     * used by the command for define the input
     * 
     * @param definition definition
     */
    public default void defineInput(Definition definition)
    {
        // 
    }

    /**
     * used by command for validate the input
     * 
     * @param validator the input validator
     */
    public default void validateInput(InputValidator validator)
    {
        // 
    }
}
