package ru.academits.evdoshenko.shapes_main;

import ru.academits.evdoshenko.shapes.*;

import java.util.Arrays;

public class ShapesMain {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Triangle(10, 20, 10, 80, 52, 140),
                new Square(9.23),
                new Rectangle(1, 1),
                new Circle(0.1), new Circle(3)
        };

        Arrays.sort(shapes, new AreaComparator());
        System.out.println("Largest shape (Area comparison): " + shapes[shapes.length - 1]);

        Arrays.sort(shapes, new PerimeterComparator());
        System.out.println("Second largest shape (Perimeter comparison): " + shapes[shapes.length - 2]);
    }
}