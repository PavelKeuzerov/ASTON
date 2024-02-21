package task_2.interfaces;

public interface Triangle {
    double calculationArea();

    default double calculationPerimeter(int side_a, int side_b, int side_c) {
        return side_a + side_b + side_c;
    }

    void setColorFill(String colorFill);

    void setColorBorder(String colorBorder);

    void info();
}

