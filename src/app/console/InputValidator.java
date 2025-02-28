package app.console;

import java.util.HashMap;
import java.util.Map;

import app.console.exceptions.ValidationException;

public class InputValidator
{
    public final Map<String, IValidationRule> arguments;
    public final Map<String, IValidationRule> options;

    public InputValidator()
    {
        this.arguments = new HashMap<>();
        this.options = new HashMap<>();
    }

    /**
     * validate the given input
     * 
     * @param input input to validate
     */
    public void validate(Input input) throws ValidationException
    {
        this.validateArguments(input);
        this.validateOptions(input);
    }

    private void validateArguments(Input input) throws ValidationException
    {
        for (String arg : arguments.keySet()) {
            IValidationRule rule = arguments.get(arg);

            if (! rule.validate(input.argument(arg))) {
                throw new ValidationException(
                    "Validation fail for argument " + arg + " using " + rule.getClass().getName()
                );
            }
        }
    }

    private void validateOptions(Input input) throws ValidationException
    {
        for (String opt : options.keySet()) {
            IValidationRule rule = options.get(opt);

            if (! rule.validate(input.option(opt))) {
                throw new ValidationException(
                    "Validation fail for option " + opt + " using " + rule.getClass()
                );
            }
        }
    }
}
