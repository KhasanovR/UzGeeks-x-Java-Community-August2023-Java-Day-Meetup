package uz.geeks.java.part2.matrixmultiplier.parallel.individual;

public class IndividualMultiplierTask implements Runnable {
    //
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;

    private final int rowIndex;
    private final int columnIndex;

    public IndividualMultiplierTask(
            double[][] result,
            double[][] matrix1,
            double[][] matrix2,
            int rowIndex,
            int columnIndex
    ) {
        //
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public void run() {
        //
        result[rowIndex][columnIndex] = 0;
        for (int k = 0; k < matrix1[rowIndex].length; k++) {
            result[rowIndex][columnIndex] += matrix1[rowIndex][k] * matrix2[k][columnIndex];
        }
    }
}
