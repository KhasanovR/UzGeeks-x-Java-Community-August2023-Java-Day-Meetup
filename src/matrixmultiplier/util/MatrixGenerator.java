package matrixmultiplier.util;

import java.util.Random;

public class MatrixGenerator {
    //
    private static final Random random = new Random();

    public static double[][] generate(int rowLength, int columnLength) {
        //
        double[][] ret = new double[rowLength][columnLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                ret[i][j] = random.nextDouble() * 10;
            }
        }
        return ret;
    }
}
