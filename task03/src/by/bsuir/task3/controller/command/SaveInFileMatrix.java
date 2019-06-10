package by.bsuir.task3.controller.command;

import by.bsuir.task3.controller.Command;
import by.bsuir.task3.exc.MatrixException;
import by.bsuir.task3.service.MatrixService;
import by.bsuir.task3.service.ServiceFactory;

public class SaveInFileMatrix implements Command {
    @Override
    public int execute(String path) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        MatrixService matrixService = serviceFactory.getMatrixService();

        try {
            matrixService.saveMatrix(path);
        } catch (MatrixException e) {
            LOGGER.error(e.getMessage());
            return -1;
        }
        return 0;
    }
}
