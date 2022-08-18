package ru.academits.evdsohenko.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("The vector size must be > 0. Current vector size is " + vectorSize);
        }

        components = new double[vectorSize];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("The array size must be > 0. Current array size is " + array.length);
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int vectorSize, double[] array) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("The vector size must be > 0. Current vector size is " + vectorSize);
        }

        components = Arrays.copyOf(array, vectorSize);
    }

    public int getSize() {
        return components.length;
    }

    private void extend(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }
    }

    public Vector add(Vector vector) {
        extend(vector);

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }

        return this;
    }

    public Vector subtract(Vector vector) {
        extend(vector);

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }

        return this;
    }

    public Vector multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }

        return this;
    }

    public Vector reverse() {
        multiplyByScalar(-1);

        return this;
    }

    public double getLength() {
        int sum = 0;

        for (double vectorComponent : components) {
            sum += vectorComponent * vectorComponent;
        }

        return Math.sqrt(sum);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vectorResult = new Vector(vector1);

        return vectorResult.add(vector2);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vectorResult = new Vector(vector1);

        return vectorResult.subtract(vector2);
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int minVectorSize = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < minVectorSize; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Vector vector = (Vector) object;

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        components[index] = component;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (double component : components) {
            stringBuilder.append(String.format("%.3f; ", component));
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}