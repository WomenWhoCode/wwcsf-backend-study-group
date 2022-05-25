package coding.problems;

import java.util.Random;

public class MatricesAddSubtract {
    public static void main(String[] args) {
        MatricesAddSubtract matricesOperations = new MatricesAddSubtract();
        int[][] matrixA = matricesOperations.createMatrix(2);
        matricesOperations.printMatrix(matrixA);
        int[][] matrixB = matricesOperations.createMatrix(2);
        matricesOperations.printMatrix(matrixB);
        int[][] resultAddition = matricesOperations.matrixAddition(matrixA, matrixB);
        int[][] resultSubtraction = matricesOperations.matrixSubtraction(matrixA, matrixB);
        matricesOperations.printMatrix(resultAddition);
        matricesOperations.printMatrix(resultSubtraction);
        int[][] resultMultiplication = matricesOperations.matrixMultiplication(matrixA, matrixB);
        matricesOperations.printMatrix(resultMultiplication);
    }

    private int[][] createMatrix(int length) {
        int[][] matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Random r = new Random();
                matrix[i][j] = r.nextInt(10);
                //matrix[i][j] = (int) (Math.random() * 1000);
            }
        }
        return matrix;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    private int[][] matrixAddition(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    private int[][] matrixSubtraction(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    private int[][] matrixMultiplication(int[][] A, int[][] B) {
        // TODO
        return new int[][]{};
    }

}
