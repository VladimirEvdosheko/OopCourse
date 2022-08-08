package ru.academits.evdoshenko.matrix_class;

import ru.academits.evdsohenko.vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsNumber, int columnsNumber) {
        this.rows = new Vector[rowsNumber];

        for (int i = 0; i < rowsNumber; i++) {
            this.rows[i] = new Vector(columnsNumber);
        }
    }

    public Matrix(Matrix matrix) {
        this.rows = new Vector[matrix.rows.length];

        this.rows = matrix.rows;
    }

    public Matrix(double[][] array) {
        this.rows = new Vector[array.length];

        for (int i = 0; i < rows.length; i++) {
            this.rows[i] = new Vector(array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        this.rows = new Vector[vectors.length];

        System.arraycopy(vectors, 0, this.rows, 0, vectors.length);
    }

    public int[] getSize() {
        return new int[]{rows.length, rows[0].getSize()};
    }

    public void getAndSet(int getIndex, int setIndex) {
        rows[setIndex] = rows[getIndex];
    }


    public Vector getVectorColumn(int columnIndex) {
        double[] array = new double[this.rows.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = this.rows[i].getComponent(columnIndex);
        }

        return new Vector(array);
    }

    public Matrix transport() {
        double[][] array = new double[rows[0].getSize()][rows.length];

        for (int i = 0; i < rows[0].getSize(); i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = rows[j].getComponent(i);
            }
        }

        for (int i = 0; i < array.length; i++) {
            this.rows[i] = new Vector(array[i]);
        }

        return this;
    }

    public Matrix multiply(double scalar) {
        double[][] array = new double[rows.length][rows[0].getSize()];

        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < rows[0].getSize(); j++) {
                array[i][j] = rows[i].getComponent(j) * scalar;
            }
        }

        for (int i = 0; i < array.length; i++) {
            this.rows[i] = new Vector(array[i]);
        }

        return this;
    }

    public Vector multiply(Vector vector) {
        double[] multiplyResultArray = new double[this.rows.length];
        for (int i = 0; i < this.rows.length; i++) {
            for (int j = 0; j < vector.getSize(); j++) {
                for (int k = 0; k < this.rows[0].getSize(); k++) {
                    multiplyResultArray[i] += this.rows[i].getComponent(k) * vector.getComponent(1);
                }
            }
        }

        return new Vector(multiplyResultArray);
    }

    public Matrix add(Matrix matrix) {
        for (int i = 0; i < this.rows.length; i++) {
            this.rows[i].getSum(matrix.rows[i]);

        }

        return this;
    }

    public Matrix subtract(Matrix matrix) {
        for (int i = 0; i < this.rows.length; i++) {
            this.rows[i].getSubtraction(matrix.rows[i]);

        }

        return this;
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        double[][] array = new double[matrix1.rows[0].getSize()][matrix1.rows[0].getSize()];

        for (int i = 0; i < matrix1.rows[0].getSize(); i++) {
            for (int j = 0; j < matrix1.rows[i].getSize(); j++) {
                array[i][j] = matrix1.rows[i].getComponent(j) + matrix2.rows[i].getComponent(j);
            }
        }

        return new Matrix(array);
    }

    public static Matrix subtract(Matrix matrix1, Matrix matrix2) {
        double[][] array = new double[matrix1.rows[0].getSize()][matrix1.rows[0].getSize()];

        for (int i = 0; i < matrix1.rows[0].getSize(); i++) {
            for (int j = 0; j < matrix1.rows[i].getSize(); j++) {
                array[i][j] = matrix1.rows[i].getComponent(j) - matrix2.rows[i].getComponent(j);
            }
        }

        return new Matrix(array);
    }
}
