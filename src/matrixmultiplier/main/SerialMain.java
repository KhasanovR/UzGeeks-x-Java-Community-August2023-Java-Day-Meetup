package matrixmultiplier.main;

import matrixmultiplier.serial.SerialMultiplier;
import matrixmultiplier.util.MatrixGenerator;

import java.util.Date;

public class SerialMain {
    //
    public static final int MATRIX_SIZE = 500;

    public static void main(String[] args) {
        //
        double[][] matrix1 = MatrixGenerator.generate(MATRIX_SIZE, MATRIX_SIZE);
        double[][] matrix2 = MatrixGenerator.generate(MATRIX_SIZE, MATRIX_SIZE);
        double[][] resultSerial = new double[MATRIX_SIZE][MATRIX_SIZE];

        Date start = new Date();
        SerialMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end = new Date();
        System.out.printf("Serial: %d%n", end.getTime() - start.getTime());
    }
}
