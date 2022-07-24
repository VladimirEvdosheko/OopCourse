package shapes;

public class Triangle implements Shape {
    private final double x1;
    private final double x2;
    private final double x3;

    private final double y1;
    private final double y2;
    private final double y3;

    public double getWidth() {
        return Math.max(Math.max(this.x1, this.x2), this.x3) - Math.min(Math.min(this.x1, this.x2), this.x3);
    }

    public double getHeight() {
        return Math.max(Math.max(this.y1, this.y2), this.y3) - Math.min(Math.min(this.y1, this.y2), this.y3);
    }

    public double getArea() {
        return 0.5 * (this.x1 * (y2 - y3) + this.x2 * (this.y3 - this.y1) + this.x3 * (this.y1 - y2));
    }

    public double getPerimeter() {
        return Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2)) +
                Math.sqrt(Math.pow(this.x3 - this.x2, 2) + Math.pow(this.y3 - this.y2, 2)) +
                Math.sqrt(Math.pow(this.x3 - this.x1, 2) + Math.pow(this.y3 - this.y1, 2));
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;

        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public String toString() {
        return String.format("Shape name - Triangle. Parameters: Width =%.3f; Height =%.3f; " +
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

        Triangle triangle = (Triangle) shape;

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