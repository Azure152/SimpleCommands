package app.concretes.rules;

import app.simplecommands.inputs.IValidationRule;

public class IntegerRule implements IValidationRule
{
    @Override
    public boolean validate(String data)
    {
        return data.matches("[0-9]+");
    }
}
