package ru.academits.evdsohenko.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("The vector size must be > 0. Current vector size is" + vectorSize);
        }

        components = new double[vectorSize];
    }

    public Vector(Vector vector) {
        components = vector.components;
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("The array size must be > 0. Current array size is " + array.length);
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int vectorSize, double[] array) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("The vector size must be > 0. Current vector size is" + vectorSize);
        }

        components = Arrays.copyOf(array, vectorSize);
    }

    public int getSize() {
        return components.length;
    }

    public void extend(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }
    }

    public Vector getSum(Vector vector) {
        this.extend(vector);

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }

        return this;
    }

    public Vector getSubtraction(Vector vector) {
        this.extend(vector);

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }

        return this;
    }

    public Vector getScalarMultiplyResult(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }

        return this;
    }

    public Vector reverse() {
        getScalarMultiplyResult(-1);

        return this;
    }

    public double getSum() {
        int sum = 0;

        for (double vectorComponent : components) {
            sum += Math.pow(vectorComponent, 2);
        }

        return Math.sqrt(sum);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vectorResult = new Vector(vector1);

        return vectorResult.getSum(vector2);
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        Vector vectorResult = new Vector(vector1);

        return vectorResult.getSubtraction(vector2);
    }

    public static double getScalarMultiplyResult(Vector vector1, Vector vector2) {
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

    public double getComponent(int componentIndex) {
        return components[componentIndex];
    }

    public void setComponent(int settingComponentIndex, double component) {
        components[settingComponentIndex] = component;
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