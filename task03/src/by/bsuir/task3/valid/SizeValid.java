package by.bsuir.task3.valid;

public class SizeValid {

    public boolean isMatrixCorrect(int[][] mat) {
        int N=mat.length;

        if ((N<8) ||(N>12)) {
            return false;
        }

        for (int i = 0; i <mat.length; i++) {
                if (mat[i].length!=mat.length){
                    return false;
                }
        }

        return true;
    }
}
