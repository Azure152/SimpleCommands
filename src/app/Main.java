package app;

import app.concretes.config.CLIConfig;
import app.console.CLI;
import app.console.exceptions.NotRegisteredCommandException;

public class Main
{
    public static void main(String[] args)
    {
        CLI cli = new CLI(new CLIConfig());

        try {
            cli.handle(args);
        } catch (NotRegisteredCommandException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }
    }
}
