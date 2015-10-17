package fedosov.xmlparser;

import fedosov.xmlparser.figures.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

        Shape currentShape = null;
        int currentShapeId = 0;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader =
                factory.createXMLStreamReader(new FileInputStream(args[0]));

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT: {

                    switch (reader.getLocalName()) {

                        case "triangle":
                            currentShape = new Triangle();
                            currentShapeId++;
                            break;
                        case "rectangle":
                            currentShape = new Rectangle();
                            currentShapeId++;
                            break;
                        case "square":
                            currentShape = new Square();
                            currentShapeId++;
                            break;
                        case "circle":
                            currentShape = new Circle();
                            currentShapeId++;
                            break;


                        case "color":
                            currentShape.setColor(reader.getElementText());
                            break;
                        case "diameter":
                            Circle circle = (Circle) currentShape;
                            circle.setDiameter((Float.parseFloat(reader.getElementText())));

                            break;

                        case "side": {
                            if (currentShape instanceof Triangle) {
                                Triangle triangle = (Triangle) currentShape;
                                triangle.getSides().add(Float.parseFloat(reader.getElementText()));
                            } else if (currentShape instanceof Rectangle) {
                                Rectangle rectangle = (Rectangle) currentShape;
                                rectangle.getSides().add(Float.parseFloat(reader.getElementText()));
                            } else if (currentShape instanceof Square) {
                                Square square = (Square) currentShape;
                                square.setSide((Float.parseFloat(reader.getElementText())));
                            }

                            break;
                        }

                    }

                    break;
                }

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "triangle":
                        case "rectangle":
                        case "circle":
                        case "square":

                            ExecutorService executor = Executors.newFixedThreadPool(1);
                            final Shape finalCurrentShape = currentShape;
                            final int finalId = currentShapeId;
                            final String finalColor = currentShape.getColor();
                            final float finalArea = currentShape.getArea();
                            executor.submit(new Runnable() {
                                public void run() {
                                    try {
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("<i>:" + finalId + "<color>" + finalColor + "-<area>" + finalArea+ "/n");
                                    } catch (InterruptedException e) {
                                        System.err.println("task interrupted");
                                    }
                                }
                            });
                            break;
                    }

            }

        }
        reader.close();
    }
}
