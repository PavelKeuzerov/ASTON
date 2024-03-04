package task_2;

public class Rectangle implements FormulaAndColorFigures {
    private final int sideA;
    private final int sideB;
    String colorFill;
    String colorBorder;

    public Rectangle(int sideA, int sideB, String colorFill, String colorBorder) {
        this.sideA = sideA;
        this.sideB = sideB;
        setColorFill(colorFill);
        setColorBorder(colorBorder);
    }

    @Override
    public double calculationArea() {
        return sideA * sideB;
    }

    @Override
    public double calculationPerimeter() {
        return 2 * (sideA + sideB);
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
        return "Rectangle{" +
                "side_a=" + sideA +
                ", side_b=" + sideB +
                ", colorFill='" + colorFill + '\'' +
                ", colorBorder='" + colorBorder + '\'' +
                ", calculatePerimeter='" + calculationPerimeter() + '\'' +
                ", calculateSquare='" + calculationArea() + '\'' +
                '}';
    }
}
