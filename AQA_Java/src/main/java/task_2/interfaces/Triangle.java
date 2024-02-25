package task_2.interfaces;

public interface Triangle {
    double calculationArea();

    default double calculationPerimeter(int sideA, int sideB, int sideC) {
        return sideA + sideB + sideC;
    }

    void setColorFill(String colorFill);

    void setColorBorder(String colorBorder);

    void info();
}

