package shapes_classes;

public class Square implements Shape {
    private final double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return String.format("Shape name - Circle. Parameters: Width =%.3f; Height =%.3f; " +
                "Area = %.3f; Perimeter = %.3f.", getWidth(), getHeight(), getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Square square = (Square) object;

        return this.sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 37;

        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);

        return hash;
    }
}