package task_2;

public class Rectangle implements task_2.interfaces.Rectangle {
    private int sideA;
    private int sideB;
    String colorFill;
    String colorBorder;

    public Rectangle(int sideA, int sideB, String colorFill, String colorBorder) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    @Override
    public double calculationArea() {
        return sideA * sideB;
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
                '}';
    }

    @Override
    public void info() {
        System.out.println("Perimeter of a rectangle : " + calculationPerimeter(2,4));
        System.out.println("Area of a rectangle: " + calculationArea());
        System.out.println("Color fill: " + colorFill);
        System.out.println("Color border : " + colorBorder);
    }
}
