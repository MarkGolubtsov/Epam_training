package by.bsuir.task3.service;

public final class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private final ThreadService threadService = new ThreadServiceImpl();
    private final MatrixService matrixService = new MatrixServiceImpl();
    private ServiceFactory() { }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public ThreadService getThreadService() {
        return threadService;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }
}
