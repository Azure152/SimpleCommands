package app;

import app.concretes.config.CLIConfig;
import app.simplecommands.Interpreter;
import app.simplecommands.exceptions.NotRegisteredCommandException;

public class Main
{
    public static void main(String[] args)
    {
        Interpreter cli = new Interpreter(new CLIConfig());

        try {
            cli.handle(args);
        } catch (NotRegisteredCommandException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }
    }
}
