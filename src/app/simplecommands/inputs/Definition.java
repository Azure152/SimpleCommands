package app.simplecommands.inputs;

import java.util.LinkedList;
import java.util.List;

public class Definition
{
    public final List<ArgumentDefinition> arguments;
    public final List<OptionDefinition> options;

    public Definition()
    {
        this.arguments = new LinkedList<>();
        this.options = new LinkedList<>();
    }
}
