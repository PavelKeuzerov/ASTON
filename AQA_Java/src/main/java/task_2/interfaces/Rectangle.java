package task_2.interfaces;

public interface Rectangle {
    double calculationArea();

    default double calculationPerimeter(int side_a, int side_b) {
        return 2 * (side_a + side_b);
    }

    void setColorFill(String colorFill);

    void setColorBorder(String colorBorder);

    void info();
}

