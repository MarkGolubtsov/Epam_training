package by.bsuir.task3.service;

import by.bsuir.task3.exc.MatrixException;
import by.bsuir.task3.exc.SizeCountException;


public interface MatrixService {

    void setMainMatrix(String path) throws SizeCountException;
    void saveMatrix(String path) throws MatrixException;
    void printMatrix() throws MatrixException;
}
