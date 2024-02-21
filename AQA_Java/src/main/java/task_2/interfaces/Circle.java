package task_2.interfaces;

public interface Circle {
    double calculationArea();

    default double calculationPerimeter(int radius) {
        return 2 * Math.PI * radius;
    }

    void setColorFill(String colorFill);

    void setColorBorder(String colorBorder);

    void info();
}
