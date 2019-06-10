package by.bsuir.task3.dao;

import by.bsuir.task3.exc.SizeCountException;

import java.io.IOException;

public interface Dao {

    int[][] readMatrix(String path) throws SizeCountException ;
    void saveMatrix( String path,int[][] matrix) throws IOException;
    int countThread(String path)  throws SizeCountException;

}
