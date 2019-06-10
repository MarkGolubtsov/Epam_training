package by.bsuir.task3.service;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ThreadService threadService = new ThreadServiceImpl();
    private final MatrixService matrixService = new MatrixServiceImpl();
    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public ThreadService getThreadService() {
        return threadService;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }
}
