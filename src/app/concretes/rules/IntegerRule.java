package app.concretes.rules;

import app.console.IValidationRule;

public class IntegerRule implements IValidationRule
{
    @Override
    public boolean validate(String data)
    {
        return data.matches("[0-9]+");
    }
}
