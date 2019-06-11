package by.bsuir.task3.controller.command;

import by.bsuir.task3.controller.Command;

public class Wrong implements Command {
    @Override
    public int execute(final String request) {
        LOGGER.error("Not correct request");
        return -1;
    }
}
