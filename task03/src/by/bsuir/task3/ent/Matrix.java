package by.bsuir.task3.ent;

public class Matrix {

    private Matrix()
    { }
    private static class LazySomethingHolder {
        public static Matrix singletonInstance = new Matrix();
    }

    public static Matrix getInstance() {
        return LazySomethingHolder.singletonInstance ;
    }

    private int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
