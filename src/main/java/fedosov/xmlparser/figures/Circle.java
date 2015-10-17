package fedosov.xmlparser.figures;
import java.lang.Math.*;
public class Circle extends Shape {

    private float diameter;



    public float getDiameter(float v) {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }
    @Override
    public float getArea() {
        return (float)Math.PI*this.diameter;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "diameter=" + diameter +
                '}';
    }
}
