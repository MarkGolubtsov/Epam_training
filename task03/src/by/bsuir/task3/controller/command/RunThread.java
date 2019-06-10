package by.bsuir.task3.controller.command;

import by.bsuir.task3.controller.Command;
import by.bsuir.task3.exc.SizeCountException;
import by.bsuir.task3.exc.ThreadRunException;
import by.bsuir.task3.service.ServiceFactory;
import by.bsuir.task3.service.ThreadService;

public class RunThread implements Command {
    @Override
    public int execute(String request) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ThreadService threadService = serviceFactory.getThreadService();
        try {
            threadService.createAndRunThreads(request);
        } catch (ThreadRunException e) {
            LOGGER.error(e.getMessage());
            return -1;
        } catch (SizeCountException e) {
            LOGGER.error(e.getMessage());
            return -1;
        }
        return 0;
    }
}
