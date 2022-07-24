package shapes_main;

import shapes.Shape;

import java.util.Comparator;

public class PerimeterComparator  implements Comparator<Shape> {
    @Override
    public int compare(Shape object1, Shape object2) {
        return (int) (object2.getPerimeter() - object1.getPerimeter());
    }
}