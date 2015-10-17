package fedosov.xmlparser.figures;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Shape {

    private List<Float> sides;

    public Triangle() {
        sides = new ArrayList<>(3);
    }

    public List<Float> getSides() {
        return sides;
    }

    public void setSides(List<Float> sides) {
        this.sides = sides;
    }

    public float getArea() {
        float p = sides.get(0) + sides.get(1) + sides.get(2);
        float area = (float) Math.sqrt((double) p * (p - sides.get(0)) * (p - sides.get(1)) * (p - sides.get(2)));
        return area;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sides=" + sides +
                '}';
    }
}