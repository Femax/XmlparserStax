package fedosov.xmlparser.figures;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Shape {

    private List<Float> sides;

    public Rectangle() {
        sides = new ArrayList<>(2);
    }

    public List<Float> getSides() {
        return sides;
    }

    public void setSides(List<Float> sides) {
        this.sides = sides;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sides=" + sides +
                '}';
    }

    @Override
    public float getArea() {
        return sides.get(0) * sides.get(1);
    }
}
