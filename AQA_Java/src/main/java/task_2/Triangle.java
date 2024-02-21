package task_2;

public class Triangle implements task_2.interfaces.Triangle {
    private int side_a;
    private int side_b;
    private int side_c;
    boolean possible;
    String colorFill;
    String colorBorder;

    public Triangle(int side_a, int side_b, int side_c, String colorFill, String colorBorder) {
        possible = side_a + side_b > side_c && side_c + side_b > side_a &&
                side_a + side_c > side_b;
        if (possible) {
            this.side_a = side_a;
            this.side_b = side_b;
            this.side_c = side_c;
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
            double p = (double) (side_a + side_b + side_c) / 2;
            area = Math.sqrt(p * (p - side_a) * (p - side_b) * (p - side_c));
        }
        return area;
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
                "side_a=" + side_a +
                ", side_b=" + side_b +
                ", side_c=" + side_c +
                ", possible=" + possible +
                ", colorFill='" + colorFill + '\'' +
                ", colorBorder='" + colorBorder + '\'' +
                '}';
    }

    @Override
    public void info() {
        System.out.println("Perimeter of a triangle : " + calculationPerimeter(2,4,5));
        System.out.println("Area of a triangle: " + calculationArea());
        System.out.println("Color fill: " + colorFill);
        System.out.println("Color border : " + colorBorder);
    }
}



