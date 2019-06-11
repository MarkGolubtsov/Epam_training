package by.bsuir.task3.controller;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    public int command(final String[] request) {
        Command executionCommand;
        executionCommand = provider.getCommand(request[0]);
        int response;
        response = executionCommand.execute(request[1]);
        return response;
    }
}
