package vector_classes;

public class Vector {
    private double[] components;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("The vector size must be > 0");
        }

        this.components = new double[vectorSize];
    }

    public Vector(Vector vector) {
        this.components = vector.components;
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("The array size must be > 0");
        }

        this.components = new double[array.length];

        System.arraycopy(array, 0, this.components, 0, this.components.length);
    }

    public Vector(int vectorSize, double[] array) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("The vector size must be > 0");
        }

        this.components = new double[vectorSize];

        for (int i = 0; i < vectorSize; i++) {
            if (i > array.length - 1) {
                this.components[i] = 0;
            } else {
                this.components[i] = array[i];
            }
        }
    }

    public int getSize() {
        return this.components.length;
    }

    public void sizeAligning(Vector vector) {
        if (this.components.length == vector.components.length) {
            return;
        }
        if (this.components.length < vector.components.length) {
            double[] temp = this.components;

            this.components = new double[vector.components.length];

            for (int i = 0; i < temp.length; i++) {
                this.components[i] += temp[i];
            }
        } else {
            double[] temp = vector.components;

            vector.components = new double[this.components.length];

            for (int i = 0; i < temp.length; i++) {
                vector.components[i] += temp[i];
            }
        }
    }

    public Vector add(Vector vector) {
        this.sizeAligning(vector);

        for (int i = 0; i < this.components.length; i++) {
            this.components[i] += vector.components[i];
        }

        return this;
    }

    public Vector subtract(Vector vector) {
        this.sizeAligning(vector);

        for (int i = 0; i < vector.components.length; i++) {
            this.components[i] -= vector.components[i];
        }

        return this;
    }

    public Vector scalarMultiply(double scalar) {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] *= scalar;
        }

        return this;
    }

    public Vector reverse() {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] *= -1;
        }

        return this;
    }

    public double getLength() {
        int length = 0;

        for (double vectorComponent : this.components) {
            length += Math.pow(vectorComponent, 2);
        }

        return Math.sqrt(length);
    }

    public Vector getAndSet(int getComponentIndex, int setComponentIndex) {
        this.components[setComponentIndex] = this.components[getComponentIndex];

        return this;
    }

    public static Vector add(Vector vector1, Vector vector2) {
        Vector vectorResult = new Vector(vector1);

        return vectorResult.add(vector2);
    }

    public static Vector subtract(Vector vector1, Vector vector2) {
        Vector vectorResult = new Vector(vector1);

        return vectorResult.subtract(vector2);
    }

    public static double scalarMultiply(Vector vector1, Vector vector2) {
        double scalarMultiplyResult = 0;
        int minVectorLength = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < minVectorLength; i++) {
            scalarMultiplyResult += vector1.components[i] * vector2.components[i];
        }

        return scalarMultiplyResult;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        Vector vector = (Vector) object;

        if (this.components.length != vector.components.length) {
            return false;
        }

        for (int i = 0; i < this.components.length; i++) {
            if (this.components[i] != vector.components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        final int prime = 37;

        for (double vectorComponent : this.components) {
            hash = hash * prime + Double.hashCode(vectorComponent);
        }

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");

        double[] components = this.components;

        for (int i = 0; i < components.length - 1; i++) {
            double vectorComponent = components[i];

            str.append(String.format("%.3f; ", vectorComponent));
        }

        str.append(String.format("%f}", components[components.length - 1]));

        return str.toString();
    }
}