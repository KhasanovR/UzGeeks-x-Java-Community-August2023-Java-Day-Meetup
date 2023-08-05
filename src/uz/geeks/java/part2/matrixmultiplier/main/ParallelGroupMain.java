package uz.geeks.java.part2.matrixmultiplier.main;

import uz.geeks.java.part2.matrixmultiplier.parallel.group.ParallelGroupMultiplier;
import uz.geeks.java.part2.matrixmultiplier.util.MatrixGenerator;

import java.util.Date;

public class ParallelGroupMain {
    //
    public static final int MATRIX_SIZE = 500;

    public static void main(String[] args) {
        //
        double[][] matrix1 = MatrixGenerator.generate(MATRIX_SIZE, MATRIX_SIZE);
        double[][] matrix2 = MatrixGenerator.generate(MATRIX_SIZE, MATRIX_SIZE);
        double[][] resultParallelGroup = new double[MATRIX_SIZE][MATRIX_SIZE];

        Date start = new Date();
        ParallelGroupMultiplier.multiply(matrix1, matrix2, resultParallelGroup);
        Date end = new Date();
        System.out.printf("Parallel Group: %d%n", end.getTime() - start.getTime());
    }
}
