package matrixmultiplier.main;

import matrixmultiplier.parallel.individual.ParallelIndividualMultiplier;
import matrixmultiplier.util.MatrixGenerator;

import java.util.Date;

public class ParallelIndividualMain {
    //
    public static final int MATRIX_SIZE = 500;

    public static void main(String[] args) {
        //
        double[][] matrix1 = MatrixGenerator.generate(MATRIX_SIZE, MATRIX_SIZE);
        double[][] matrix2 = MatrixGenerator.generate(MATRIX_SIZE, MATRIX_SIZE);
        double[][] resultParallel = new double[MATRIX_SIZE][MATRIX_SIZE];

        Date start = new Date();
        ParallelIndividualMultiplier.multiply(matrix1, matrix2, resultParallel);
        Date end = new Date();
        System.out.printf("Parallel Individual: %d%n", end.getTime() - start.getTime());
    }
}
