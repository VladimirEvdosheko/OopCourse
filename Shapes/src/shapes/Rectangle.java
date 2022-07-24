package shapes;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getArea() {
        return this.height * this.width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public String toString() {
        return String.format("Shape name - Rectangle. Parameters: Width =%.3f; Height =%.3f; " +
                "Area = %.3f; Perimeter = %.3f.", this.getWidth(), this.getHeight(), this.getArea(), this.getPerimeter());
    }

    @Override
    public boolean equals(Shape shape) {
        if (this == shape) {
            return true;
        }

        if (shape == null || getClass() != shape.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) shape;

        return this.getArea() == rectangle.getArea() && this.width == rectangle.width;
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