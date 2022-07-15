package ru.academits.evdoshenko.range_main;

import ru.academits.evdoshenko.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range = new Range(0, 10);

        System.out.println("������� ������ ���������:");
        range.setFrom(scanner.nextDouble());

        System.out.println("������� ����� ���������:");
        range.setTo(scanner.nextDouble());

        System.out.println("������� �����:");
        double enteredNumber = scanner.nextDouble();

        System.out.printf("������ ���������: %f.%n����� ���������: %f.%n��������� �����: %f.%n����� ��������� = %f.%n",
                range.getFrom(), range.getTo(), enteredNumber, range.getLength());

        if (range.isInside(enteredNumber)) {
            System.out.printf("����� %f ����������� ���������!%n", enteredNumber);
        } else {
            System.out.printf("����� %f �� ����������� ���������!%n", enteredNumber);
        }
    }
}