package by.bsuir.task3.service;

import by.bsuir.task3.dao.Dao;
import by.bsuir.task3.dao.FileDao;
import by.bsuir.task3.bin.FactoryThread;
import by.bsuir.task3.bin.Matrix;
import by.bsuir.task3.exc.MatrixException;
import by.bsuir.task3.exc.SizeCountException;
import by.bsuir.task3.valid.SizeValid;


import java.io.IOException;

public final class MatrixServiceImpl implements MatrixService {


    public void setMainMatrix(final String path) throws SizeCountException {
        Dao dao = FileDao.getInstance();
        int[][] matrix = dao.readMatrix(path);
        SizeValid sizeValid = new SizeValid();
        if (!sizeValid.isMatrixCorrect(matrix)) {
            throw new SizeCountException("Matrix not correcr");
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 0;
        }
        FactoryThread factoryThread = FactoryThread.getInstance();
        Matrix matrixForThread = new Matrix(matrix);
        factoryThread.setMatrix(matrixForThread);
    }

    public void saveMatrix(final String path) throws MatrixException {
            Dao dao = FileDao.getInstance();
            FactoryThread factoryThread = FactoryThread.getInstance();
            Matrix matrix = factoryThread.getMatrix();
            int[][] mat = matrix.getMatrix();

            try {
                dao.saveMatrix(path, mat);
            } catch (IOException e) {
                throw new MatrixException("problem with write");
            }

    }

    public void printMatrix() throws MatrixException {
        FactoryThread factoryThread = FactoryThread.getInstance();
        if (factoryThread.getMatrix() == null) {
            throw new MatrixException("setMatrix");
        }
        Matrix m = factoryThread.getMatrix();
        int[][] matrix = m.getMatrix();
        if (matrix == null) {
            throw new MatrixException("setMatrix");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                    System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }

    }

}
