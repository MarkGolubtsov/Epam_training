package by.bsuir.task3.bin;

import org.apache.log4j.Logger;

public class Matrix {

    private static  final Logger LOGGER
            = Logger.getLogger(Matrix.class.getSimpleName());

    private int[][] matrix = null;

    private  int current =0;

    public Matrix(int[][] matrix)
    {
        this.matrix=matrix;
    }

    public void changeElementOnDiagonal(final int i,final int value ) {
            matrix[i][i] = value;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public boolean isRepeatChange()
    {
        boolean result = false;
        for (int i = 0; i <matrix.length; i++) {
            if (matrix[i][i]==0) {
                result=true;
            }
        }
        return result;
    }
    public  int getCurrent() {
        return current;
    }

    public  void setCurrent(int current) {
        this.current = current;
    }
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
