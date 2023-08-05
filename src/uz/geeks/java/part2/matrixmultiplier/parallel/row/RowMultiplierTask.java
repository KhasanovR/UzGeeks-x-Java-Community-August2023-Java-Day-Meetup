package uz.geeks.java.part2.matrixmultiplier.parallel.row;

public class RowMultiplierTask implements Runnable {
    //
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;

    private final int rowIndex;

    public RowMultiplierTask(
            double[][] result,
            double[][] matrix1,
            double[][] matrix2,
            int rowIndex
    ) {
        //
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.rowIndex = rowIndex;
    }

    public void run() {
        //
        for (int j = 0; j < matrix2[0].length; j++) {
            result[rowIndex][j] = 0;
            for (int k = 0; k < matrix1[rowIndex].length; k++) {
                result[rowIndex][j] += matrix1[rowIndex][k] * matrix2[k][j];
            }
        }
    }
}
