package vector_main;

import java.util.Scanner;

import vector_classes.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] array1 = {1, 2, 3, 4};
        double[] array2 = {1, 2, 3, 4};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);

        System.out.printf("The first vector size is %d%n", vector1.getSize());

        System.out.printf("The first vector length is %f%n", vector1.getLength());

        System.out.println("Enter the index of component, what you want to replace: ");
        int getIndex = scanner.nextInt();

        System.out.println("Enter the index, where you want to put the component: ");
        int setIndex = scanner.nextInt();

        System.out.printf("Replace result is %s%n", vector1.getAndSet(getIndex, setIndex));

        System.out.printf("Reverse result is %s%n", vector1.reverse());

        System.out.printf("Result of multiply of vector and scalar is %s%n", vector1.scalarMultiply(2));

        Vector subtractionResult = Vector.subtract(vector1, vector2);
        System.out.printf("The result of subtract of two vectors is vector: %s%n", subtractionResult);

        Vector vector3 = new Vector(5);
        Vector vector4 = new Vector(4, array1);

        Vector additionResult = Vector.add(vector4, vector3);
        System.out.printf("The result of addition of two vectors is vector: %s%n", additionResult);

        double multiplyResult = Vector.scalarMultiply(vector4, vector3);
        System.out.printf("Vectors multiply result = %f%n", multiplyResult);

        System.out.printf("Subtract result of two vectors is %s%n", vector4.subtract(vector3));
    }
}