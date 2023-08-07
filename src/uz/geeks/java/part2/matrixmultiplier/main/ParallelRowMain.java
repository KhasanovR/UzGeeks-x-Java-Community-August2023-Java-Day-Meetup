package uz.geeks.java.part2.matrixmultiplier.main;

import uz.geeks.java.part2.matrixmultiplier.parallel.row.ParallelRowMultiplier;
import uz.geeks.java.part2.matrixmultiplier.util.MatrixGenerator;

import java.util.Date;

public class ParallelRowMain {
    //
    public static final int MATRIX_SIZE = 500;

    public static void main(String[] args) {
        //
        double[][] matrix1 = MatrixGenerator.generate(MATRIX_SIZE, MATRIX_SIZE);
        double[][] matrix2 = MatrixGenerator.generate(MATRIX_SIZE, MATRIX_SIZE);
        double[][] resultParallelRow = new double[MATRIX_SIZE][MATRIX_SIZE];

        Date start = new Date();
        ParallelRowMultiplier.multiply(matrix1, matrix2, resultParallelRow);
        Date end = new Date();
        System.out.printf("Parallel Row: %d%n", end.getTime() - start.getTime());
    }
}
