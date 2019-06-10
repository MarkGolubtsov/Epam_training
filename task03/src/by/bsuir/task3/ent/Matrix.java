package by.bsuir.task3.ent;

import org.apache.log4j.Logger;

public class Matrix {

    private static  final Logger LOGGER
            = Logger.getLogger(Matrix.class.getSimpleName());
    private int[][] matrix;

    public Matrix(int[][] matrix)
    {
        this.matrix=matrix;
    }

    public void changeElementOnDiagonal(final int i,final int value ) {
            LOGGER.info("change "+i);
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

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
