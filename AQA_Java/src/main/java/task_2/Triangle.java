package task_2;

public class Triangle extends Figure  {
    private final int sideA;
    private final int sideB;
    private final int sideC;
    private String colorFill;
    private String colorBorder;


    public Triangle(int sideA, int sideB, int sideC, String colorFill, String colorBorder) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        ColorFill(colorFill);
        ColorBorder(colorBorder);
    }

    @Override
    public double calculationArea() {
            double p = (double) (sideA + sideB + sideC) / 2;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double calculationPerimeter() {
        return sideA + sideB + sideC;
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
        return "Triangle{" +
                "side_a=" + sideA +
                ", side_b=" + sideB +
                ", side_c=" + sideC +
                ", colorFill='" + colorFill + '\'' +
                ", colorBorder='" + colorBorder + '\'' +
                ", calculatePerimeter='" + calculationPerimeter() + '\'' +
                ", calculateSquare='" + calculationArea() + '\'' +
                '}';
    }
}



