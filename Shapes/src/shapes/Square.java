package shapes;

public class Square implements Shape {
    private final double length;

    public double getWidth() {
        return length;
    }

    public double getHeight() {
        return length;
    }

    public double getArea() {
        return Math.pow(length, 2);
    }

    public double getPerimeter() {
        return 4 * length;
    }

    public Square(double length) {
        this.length = length;
    }

    public String toString() {
        return String.format("Shape name - Circle. Parameters: Width =%.3f; Height =%.3f; " +
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

        Square square = (Square) shape;

        return this.length == square.length;
    }

    @Override
    public int hashCode() {
        final int prime = 37;

        int hash = 1;
        hash = prime * hash + Double.hashCode(length);

        return hash;
    }
}