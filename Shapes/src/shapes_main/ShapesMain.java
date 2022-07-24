package shapes_main;

import shapes.*;

import java.util.Arrays;

public class ShapesMain {
    public static void main(String[] args) {
        double x1 = 1;
        double y1 = 2;
        double x2 = 10;
        double y2 = 8;
        double x3 = 5;
        double y3 = 14;
        Triangle triangle = new Triangle(x1, y1, x2, y2, x3, y3);

        double squareSideLength = 9.23;
        Square square = new Square(squareSideLength);

        double rectangleHeight = 8;
        double rectangleWidth = 10;
        Rectangle rectangle = new Rectangle(rectangleWidth, rectangleHeight);

        double circleRadius1 = 2;
        Circle circle1 = new Circle(circleRadius1);

        double circleRadius2 = 1;
        Circle circle2 = new Circle(circleRadius2);

        Shape[] shapes = {triangle, square, rectangle, circle1, circle2};

        Arrays.sort(shapes, new AreaComparator());

        System.out.println("Largest shape (Area comparison): " + shapes[0].toString());

        Arrays.sort(shapes, new PerimeterComparator());

        System.out.println("Second largest shape (Perimeter comparison): " + shapes[1].toString());
    }
}