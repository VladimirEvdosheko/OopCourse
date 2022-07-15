package ru.academits.evdoshenko.range_main;

import ru.academits.evdoshenko.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range = new Range(0, 10);

        System.out.println("Введите начало диапазона:");
        range.setFrom(scanner.nextDouble());

        System.out.println("Введите конец диапазона:");
        range.setTo(scanner.nextDouble());

        System.out.println("Введите число:");
        double enteredNumber = scanner.nextDouble();

        System.out.printf("Начало диапазона: %f.%nКонец диапазона: %f.%nВведенное число: %f.%nДлина диапазона = %f.%n",
                range.getFrom(), range.getTo(), enteredNumber, range.getLength());

        if (range.isInside(enteredNumber)) {
            System.out.printf("Число %f принадлежит диапазону!%n", enteredNumber);
        } else {
            System.out.printf("Число %f не принадлежит диапазону!%n", enteredNumber);
        }
    }
}