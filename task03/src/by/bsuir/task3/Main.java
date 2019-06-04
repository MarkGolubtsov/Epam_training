package by.bsuir.task3;

import by.bsuir.task3.ent.Matrix;
import by.bsuir.task3.reader.ReaderMatrix;

public class Main {
    public static void main(String[] args) {
        ReaderMatrix readerMatrix= new ReaderMatrix();
        readerMatrix.setPath("data\\input.txt");

        int[][] buf = readerMatrix.createMatrix();

        for (int i = 0; i <buf.length; i++) {
            for (int j = 0; j <buf[i].length ; j++) {
                System.out.print(" "+buf[i][j]);
            }
            System.out.println();
        }
        Matrix matrix = Matrix.getInstance();
        matrix.setMatrix(buf);
    }
}
