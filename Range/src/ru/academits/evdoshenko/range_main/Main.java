package ru.academits.evdoshenko.range_main;

import ru.academits.evdoshenko.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the beginning of first range:");
        double beginning = scanner.nextDouble();

        System.out.println("Enter the ending of first range:");
        double ending = scanner.nextDouble();

        Range range1 = new Range(beginning, ending);

        System.out.println("Enter the beginning of second range:");
        beginning = scanner.nextDouble();

        System.out.println("Enter the ending of second range:");
        ending = scanner.nextDouble();

        Range range2 = new Range(beginning, ending);

        System.out.println("Enter your number:");
        double enteredNumber = scanner.nextDouble();

        System.out.printf("Range beginning: %f.%nRange ending: %f.%nEntered number: %f.%nRange length = %f.%n",
                range1.from(), range1.to(), enteredNumber, range1.getLength());

        if (range1.isInside(enteredNumber)) {
            System.out.printf("Number %f belongs to range !%n", enteredNumber);
        } else {
            System.out.printf("Number %f does not belongs to range !%n", enteredNumber);
        }

        Range[] intersectionResult = range1.getIntersection(range2);

        if (intersectionResult == null) {
            System.out.println("There are no intersection between range1 and range2!");
        } else {
            System.out.printf("The result of intersection between two ranges is range3: [%s]%n",
                    intersectionResult[0].toString());
        }

        Range[] unionResult = range1.getUnion(range2);

        if (unionResult.length == 1) {
            System.out.printf("The union result is: [%s]%n", unionResult[0].toString());
        } else {
            System.out.printf("The union result are ranges: [%s] and [%s]%n",
                    unionResult[0].toString(), unionResult[1].toString());
        }

        Range[] differenceResult = range1.getDifference(range2);

        if (differenceResult.length == 0) {
            System.out.println("The difference result is empty range");
        } else if (differenceResult.length == 1) {
            System.out.printf("The difference result of two ranges without intersection is range: [%s]",
                    differenceResult[0].toString());
        } else {
            System.out.printf("The difference result are ranges: [%s] and [%s]",
                    differenceResult[0].toString(), differenceResult[1].toString());
        }
    }
}