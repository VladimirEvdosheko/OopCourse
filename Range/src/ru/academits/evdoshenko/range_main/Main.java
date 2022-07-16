package ru.academits.evdoshenko.range_main;

import ru.academits.evdoshenko.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range1 = new Range(0, 10);
        Range range2 = new Range(0, 10);

        System.out.println("Enter the beginning of first range:");
        range1.setFrom(scanner.nextDouble());

        System.out.println("Enter the ending of first range:");
        range1.setTo(scanner.nextDouble());

        System.out.println("Enter the beginning of second range:");
        range2.setFrom(scanner.nextDouble());

        System.out.println("Enter the ending of first range:");

        range2.setTo(scanner.nextDouble());

        System.out.println("Enter your number:");
        double enteredNumber = scanner.nextDouble();

        System.out.printf("Range beginning: %f.%nRange ending: %f.%nEntered number: %f.%nRange length = %f.%n",
                range1.getFrom(), range1.getTo(), enteredNumber, range1.getLength());

        if (range1.isInside(enteredNumber)) {
            System.out.printf("Number %f belongs to range !%n", enteredNumber);
        } else {
            System.out.printf("Number %f does not belongs to range !%n", enteredNumber);
        }

        Range intersectionResult = range1.getIntersection(range1.getFrom(), range1.getTo(), range2.getFrom(),
                range2.getTo());

        if (intersectionResult == null) {
            System.out.println("There are no intersection between range1 and range2!");
        } else {
            System.out.printf("The result of intersection between two ranges is range3: [%.3f; %.3f]%n",
                    intersectionResult.getFrom(), intersectionResult.getTo());
        }

        Range[] unionResult = range1.getUnion(range1.getFrom(), range1.getTo(), range2.getFrom(), range2.getTo());

        if (unionResult.length == 1) {
            System.out.printf("The union result is: [%f, %f]%n", unionResult[0].getFrom(), unionResult[0].getTo());
        } else {
            System.out.printf("The union result are ranges: [%.3f; %.3f] and [%.3f; %.3f]%n",
                    unionResult[0].getFrom(), unionResult[0].getTo(), unionResult[1].getFrom(), unionResult[1].getTo());
        }

        Range[] differenceResult = range1.getDifference(range1.getFrom(), range1.getTo(), range2.getFrom(),
                range2.getTo());

        if (differenceResult == null) {
            System.out.println("It is impossible to difference.");
        } else if (differenceResult.length == 0) {
            System.out.println("The difference result is 0");
        } else if (differenceResult.length == 1) {
            System.out.printf("The difference result of two ranges without intersection is range: [%.3f; %.3f]",
                    differenceResult[0].getFrom(), differenceResult[0].getTo());
        } else {
            System.out.printf("The difference result are ranges: [%.3f; %.3f] and [%.3f; %.3f]",
                    differenceResult[0].getFrom(), differenceResult[0].getTo(), differenceResult[1].getFrom(),
                    differenceResult[1].getTo());
        }
    }
}