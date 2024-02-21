package task_2;

public class Rectangle implements task_2.interfaces.Rectangle {
    private int side_a;
    private int side_b;
    String colorFill;
    String colorBorder;

    public Rectangle(int side_a, int side_b, String colorFill, String colorBorder) {
        this.side_a = side_a;
        this.side_b = side_b;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    @Override
    public double calculationArea() {
        return side_a * side_b;
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
                "side_a=" + side_a +
                ", side_b=" + side_b +
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
