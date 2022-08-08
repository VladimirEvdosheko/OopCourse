package ru.academits.evdoshenko.range_main;

import ru.academits.evdoshenko.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the beginning of first range:");
        double from = scanner.nextDouble();

        System.out.println("Enter the ending of first range:");
        double to = scanner.nextDouble();

        Range range1 = new Range(from, to);

        System.out.println("Enter the beginning of second range:");
        from = scanner.nextDouble();

        System.out.println("Enter the ending of second range:");
        to = scanner.nextDouble();

        Range range2 = new Range(from, to);

        System.out.println("Enter your number:");
        double enteredNumber = scanner.nextDouble();

        System.out.printf("Range beginning: %f.%nRange ending: %f.%nEntered number: %f.%nRange length = %f.%n",
                range1.getFrom(), range1.getTo(), enteredNumber, range1.getLength());

        if (range1.isInside(enteredNumber)) {
            System.out.printf("Number %f belongs to range !%n", enteredNumber);
        } else {
            System.out.printf("Number %f does not belongs to range !%n", enteredNumber);
        }

        Range intersectionResult = range1.getIntersection(range2);

        if (intersectionResult == null) {
            System.out.println("There are no intersection between range1 and range2!");
        } else {
            System.out.printf("The result of intersection between two ranges is range3: [%s]%n",
                    intersectionResult);
        }

        Range[] unionResult = range1.getUnion(range2);

        Range[] differenceResult = range1.getDifference(range2);

        System.out.print("The union result ");
        print(unionResult);

        System.out.println();

        System.out.print("The difference result ");
        print(differenceResult);
    }

    public static void print(Range[] range) {
        if (range.length == 0) {
            System.out.println("[];");
        } else if (range.length == 1) {
            System.out.printf("[%s];",
                    range[0]);
        } else {
            for (int i = 0; i < range.length - 1; i++) {
                System.out.printf("[%s, %s]; ", range[i], range[i + 1]);
            }
        }
    }
}