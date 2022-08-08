package ru.academits.evdoshenko.matrix_main;

import ru.academits.evdoshenko.matrix_class.Matrix;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 5);

        double[][] array = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        double[][] array2 = new double[10][10];
        double[] array3 = {1,2};
        Matrix matrix1 = new Matrix(array);

        Matrix matrix3 = Matrix.subtract(matrix1, matrix1);
    }
}
