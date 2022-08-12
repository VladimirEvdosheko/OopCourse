package ru.academits.evdoshenko.shapes;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Shape name - Rectangle. Parameters: Width = %.3f; Height = %.3f; " +
                "Area = %.3f; Perimeter = %.3f.", width, height, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) object;

        return height == rectangle.height && width == rectangle.width;
    }

    @Override
    public int hashCode() {
        final int prime = 37;

        int hash = 1;
        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);

        return hash;
    }
}