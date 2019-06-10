package by.bsuir.task3.service;

import by.bsuir.task3.dao.Dao;
import by.bsuir.task3.dao.FileDao;
import by.bsuir.task3.bin.FactoryThread;
import by.bsuir.task3.exc.SizeCountException;
import by.bsuir.task3.exc.ThreadRunException;
import org.apache.log4j.Logger;

import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadServiceImpl implements ThreadService{


    public void createAndRunThreads(String path) throws ThreadRunException, SizeCountException {
        Dao dao=FileDao.getInstance();
        int count=dao.countThread(path);

        if ((count>7) || (count<4)) {
            throw new SizeCountException("Thread count is't correct!");
        }
        FactoryThread factoryThread = FactoryThread.getInstance();
        CopyOnWriteArrayList<Thread> list= new CopyOnWriteArrayList<>();

        Thread thread;
        for (int i = 0; i <count; i++) {
            list.add(factoryThread.createThread());
        }
        if (factoryThread.getMatrix().getMatrix()==null) {
            throw new ThreadRunException("Set matrix pls!");
        }
        for (Thread t:
                list) {
            t.start();
        }

        try {
            list.get(list.size()-1).join();
        } catch (InterruptedException e) {
            throw new ThreadRunException("problem with join");
        }
    }


}
