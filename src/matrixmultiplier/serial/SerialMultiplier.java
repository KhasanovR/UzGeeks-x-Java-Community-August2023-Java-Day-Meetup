package matrixmultiplier.serial;

public class SerialMultiplier {
    //
    public static void multiply(
            double[][] matrix1,
            double[][] matrix2,
            double[][] result
    ) {
        //
        int rowLengthOfMatrix1 = matrix1.length;
        int columnLengthOfMatrix1 = matrix1[0].length;
        int columnLengthOfMatrix2 = matrix2[0].length;

        for (int i = 0; i < rowLengthOfMatrix1; i++) {
            for (int j = 0; j < columnLengthOfMatrix2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < columnLengthOfMatrix1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
}
