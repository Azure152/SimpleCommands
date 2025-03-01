package app.simplecommands.inputs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Input
{
    private Map<String, Argument> arguments;
    private Map<String, Option> options;
    private TokenParser parser;

    public Input(String[] tokens)
    {
        this.arguments = new HashMap<>();
        this.options = new HashMap<>();
        this.parser = TokenParser.parse(tokens);
    }

    /**
     * bind arguments and options to the definition
     * 
     * @param definition reference definition
     */
    public void bind(Definition definition)
    {
        this.arguments.clear();
        this.options.clear();

        this.bindArguments(definition, parser.getArguments());
        this.bindOptions(definition, parser.getOptions());
    }

    private void bindArguments(Definition definition, List<String> arguments)
    {
        int i = 0;

        for (ArgumentDefinition arg : definition.arguments) {
            if (i >= arguments.size()) {
                if (! arg.optional) {
                    throw new RuntimeException("Missing parameter " + arg.name);
                }

                this.arguments.put(arg.name, new Argument(arg.name, arg.value));
            } else {
                this.arguments.put(arg.name, new Argument(arg.name, arguments.get(i)));
            }

            i++;
        }
    }

    private void bindOptions(Definition definition, Map<String, String> options)
    {
        for (OptionDefinition opt : definition.options) {
            String token = options.get(opt.name);

            if (token == null) {
                this.options.put(opt.name, new Option(opt.name, opt.value));
            } else {
                this.options.put(opt.name, new Option(opt.name, token));
            }
        }
    }

    public String argument(String name)
    {
        return this.arguments.get(name).getValue();
    }

    public String option(String name)
    {
        return this.options.get(name).getValue();
    }
}
