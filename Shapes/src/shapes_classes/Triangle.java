package shapes_classes;

public class Triangle implements Shape {
    private final double x1;
    private final double x2;
    private final double x3;

    private final double y1;
    private final double y2;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;

        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX3() {
        return x3;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public double getY3() {
        return y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x2, x1, y2, y1) + getSideLength(x3, x2, y3, y2) + getSideLength(x3, x1, y3, y1);
    }

    public static double getSideLength(double x1, double x2, double y1, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    @Override
    public String toString() {
        return String.format("Shape name - Triangle. Coordinates: (%f; %f), (%f; %f), (%f; %f); Area = %.3f; " +
                "Perimeter = %.3f.", getX1(), getY1(), getX2(), getY2(), getX3(), getY3(), getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) object;

        return this.x1 == triangle.x1 && this.x2 == triangle.x2 && this.x3 == triangle.x3 &&
                this.y1 == triangle.y1 && this.y2 == triangle.y2 && this.y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 37;

        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(x3);

        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(y3);

        return hash;
    }
}