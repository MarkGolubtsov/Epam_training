package by.bsuir.task3.controller.command;

import by.bsuir.task3.controller.Command;
import by.bsuir.task3.exc.SizeCountException;
import by.bsuir.task3.service.MatrixService;
import by.bsuir.task3.service.ServiceFactory;

public class InitializeMatrix implements Command {
    @Override
    public int execute(final String path) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        MatrixService matrixService = serviceFactory.getMatrixService();

        try {
            matrixService.setMainMatrix(path);
        } catch (SizeCountException e) {
            LOGGER.error(e.getMessage());
            return -1;
        }

        return 0;
    }
}
