package task_2;

import java.awt.*;

public class Circle implements task_2.interfaces.Circle {
    private int radius;
    String colorFill;
    String colorBorder;

    public Circle(int radius, String colorFill, String colorBorder) {
        this.radius = radius;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    @Override
    public double calculationArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void setColorFill(String colorFill) {
        this.colorFill = colorFill;
    }

    @Override
    public void setColorBorder(String colorBorder) {
        this.colorBorder = colorBorder;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", colorFill='" + colorFill + '\'' +
                ", colorBorder='" + colorBorder + '\'' +
                '}';
    }

    @Override
    public void info() {
        System.out.println("Perimeter of a circle : " + calculationPerimeter(7));
        System.out.println("Area of a circle: " + calculationArea());
        System.out.println("Color fill: " + colorFill);
        System.out.println("Color border : " + colorBorder);
    }
}
