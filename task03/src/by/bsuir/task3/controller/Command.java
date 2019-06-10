package by.bsuir.task3.controller;


import org.apache.log4j.Logger;

public interface Command {
     Logger LOGGER
            = Logger.getLogger(Command.class.getSimpleName());
    int execute(String request);
}
