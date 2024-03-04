package task_2;

public class Circle implements FormulaAndColorFigures {
    private final int radius;
    String colorFill;
    String colorBorder;

    public Circle(int radius, String colorFill, String colorBorder) {
        this.radius = radius;
        setColorFill(colorFill);
        setColorBorder(colorBorder);
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
                ", calculatePerimeter='" + calculationPerimeter() + '\'' +
                ", calculateSquare='" + calculationArea() + '\'' +
                '}';
    }
}
