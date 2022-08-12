package ru.academits.evdsohenko.vector_main;

import ru.academits.evdsohenko.vector.Vector;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] array1 = {1, 1, 1, 1};
        double[] array2 = {1, 2, 3, 4};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);
        Vector vector3 = new Vector(4, array1);

        System.out.printf("The first vector size is %d%n", vector1.getSize());

        System.out.printf("The first vector length is %f%n", vector1.getSum());

        System.out.println("Enter the index of component, what you want to replace:");
        int gettingIndex = scanner.nextInt();

        System.out.printf("The component in %d position is %f%n", gettingIndex, vector1.getComponent(gettingIndex));

        System.out.println("Enter the index, where you want to put the component, and its value:");
        int settingIndex = scanner.nextInt();
        double settingComponentValue = scanner.nextDouble();

        vector1.setComponent(settingIndex, settingComponentValue);

        System.out.printf("Reverse result is %s%n", vector1.reverse());

        System.out.printf("Result of multiply of vector and scalar is %s%n", vector1.getScalarMultiplyResult(2));

        Vector subtractionResult = Vector.getSubtraction(vector1, vector2);
        System.out.printf("The result of subtract of two vectors is vector: %s%n", subtractionResult);

        Vector additionResult = Vector.getSum(vector1, vector3);
        System.out.printf("The result of addition of two vectors is vector: %s%n", additionResult);

        double multiplyResult = Vector.getScalarMultiplyResult(vector1, vector3);
        System.out.printf("Vectors multiply result = %f%n", multiplyResult);

        System.out.printf("Subtract result of two vectors is %s%n", vector1.getSubtraction(vector3));
    }
}