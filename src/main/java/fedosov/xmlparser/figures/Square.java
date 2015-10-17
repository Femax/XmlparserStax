package fedosov.xmlparser.figures;

public class Square extends Shape {

    private float side;

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }


    @Override
    public float getArea() {
        return side*side;
    }
}
