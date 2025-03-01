package app.simplecommands.inputs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final public class TokenParser
{
    private List<String> arguments;
    private Map<String, String> options;

    private TokenParser()
    {
        this.arguments = new LinkedList<>();
        this.options = new HashMap<>();
    }

    public static TokenParser parse(String[] tokens)
    {
        TokenParser parser = new TokenParser();
        parser.parseTokens(tokens, 0);

        return parser;
    }

    private void parseTokens(String[] tokens, int index)
    {
        if (index >= tokens.length) return;

        String token = tokens[index];

        if (token != null) {
            if (this.isOption(token)) {
                this.addOptionFromToken(token);
            } else {
                this.arguments.add(token);
            }
        }

        this.parseTokens(tokens, index + 1);
    }

    private void addOptionFromToken(String token)
    {
        String[] parts = token.substring(2).split("=");
        String name = parts[0];
        String value = parts.length > 1 ? parts[1] : null;

        this.options.put(name, value);
    }

    private boolean isOption(String token)
    {
        return token.matches("--.+");
    }

    public List<String> getArguments()
    {
        return arguments;
    }

    public Map<String, String> getOptions()
    {
        return options;
    }
}
