package by.bsuir.task3.service;

import by.bsuir.task3.exc.SizeCountException;
import by.bsuir.task3.exc.ThreadRunException;

public interface ThreadService {
    void createAndRunThreads(String path) throws ThreadRunException, SizeCountException;
}
