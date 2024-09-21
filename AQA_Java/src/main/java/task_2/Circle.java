package task_2;

public class Circle extends Figure {
    private final int radius;
    private String colorFill;
    private String colorBorder;

    public Circle(int radius, String colorFill, String colorBorder) {
        this.radius = radius;
        ColorFill(colorFill);
        ColorBorder(colorBorder);
    }

    @Override
    public double calculationArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculationPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void ColorFill(String colorFill) {
        this.colorFill = colorFill;

    }

    @Override
    public void ColorBorder(String colorBorder) {
        this.colorBorder = colorBorder;

    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", colorFill='" + colorFill + '\'' +
                ", colorBorder='" + colorBorder + '\'' +
                ", calculatePerimeter='" + calculationPerimeter() + '\'' +
                ", calculateSquare='" + calculationArea() + '\'' +
                '}';
    }
}
