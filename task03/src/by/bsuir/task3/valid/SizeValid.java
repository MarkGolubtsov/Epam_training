package by.bsuir.task3.valid;

public final class SizeValid {

    private static final int MIN_SIZE = 8;
    private static final int MAX_SIZE = 12;
    public boolean isMatrixCorrect(final int[][] mat) {
        int length = mat.length;

        if ((length < MIN_SIZE) || (length > MAX_SIZE)) {
            return false;
        }

        for (int i = 0; i < mat.length; i++) {
                if (mat[i].length != mat.length) {
                    return false;
                }
        }

        return true;
    }
}
