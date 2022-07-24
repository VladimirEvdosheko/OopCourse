package shapes;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * this.radius;
    }

    @Override
    public double getHeight() {
        return 2 * this.radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return String.format("Shape name - Circle. Parameters: Width =%.3f; Height =%.3f; " +
                        "Area = %.3f; Perimeter = %.3f.",
                this.getWidth(), this.getHeight(), this.getArea(), this.getPerimeter());
    }

    @Override
    public boolean equals(Shape shape){
      if (this == shape){
        return true;
      }

      if (this.getClass() != shape.getClass()){
          return false;
      }

      Circle circle = (Circle) shape;

      return  this.radius == circle.radius;
    }

    @Override
    public int hashCode(){
        final int prime = 37;
        int hash = 1;
        return prime * hash + Double.hashCode(radius);
    }
}