package task_2;

public class Triangle implements FormulaAndColorFigures {
    private int sideA;
    private int sideB;
    private int sideC;
    boolean possible;
    String colorFill;
    String colorBorder;

    public Triangle(int sideA, int sideB, int sideC, String colorFill, String colorBorder) {
        possible = sideA + sideB > sideC && sideC + sideB > sideA &&
                sideA + sideC > sideB;
        if (possible) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            setColorFill(colorFill);
            setColorBorder(colorBorder);

        } else {
            System.out.println("It is not possible to construct a triangle");
        }
    }

    @Override
    public double calculationArea() {
        double area = 0;
        if (possible) {
            double p = (double) (sideA + sideB + sideC) / 2;
            area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        }
        return area;
    }

    @Override
    public double calculationPerimeter() {
        return sideA + sideB + sideC;
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
        return "Triangle{" +
                "side_a=" + sideA +
                ", side_b=" + sideB +
                ", side_c=" + sideC +
                ", possible=" + possible +
                ", colorFill='" + colorFill + '\'' +
                ", colorBorder='" + colorBorder + '\'' +
                ", calculatePerimeter='" + calculationPerimeter() + '\'' +
                ", calculateSquare='" + calculationArea() + '\'' +
                '}';
    }
}



