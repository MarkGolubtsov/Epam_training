package by.bsuir.task3.controller;

import by.bsuir.task3.controller.command.InitializeMatrix;
import by.bsuir.task3.controller.command.PrintMatrix;
import by.bsuir.task3.controller.command.RunThread;
import by.bsuir.task3.controller.command.SaveInFileMatrix;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {

    private final Map<Commands, Command> repository = new HashMap<>();
    CommandProvider() {
        repository.put(Commands.INITIAL, new InitializeMatrix());
        repository.put(Commands.PRINT, new PrintMatrix());
        repository.put(Commands.RUN, new RunThread());
        repository.put(Commands.SAVE, new SaveInFileMatrix());
    }
    Command getCommand(final String name) {
        Commands commandName;
        Command command;
        try {
            commandName = Commands.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(Commands.WRONG);
        }
        return command;
    }
}
