package task_2;


public class AppRunner {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(7, 9, 5, "red", "black");
        triangle.info();

        Rectangle rectangle = new Rectangle( 9, 5, "yellow", "green");
        rectangle.info();

        Circle circle = new Circle(5, "grey", "pink");
        circle.info();

    }
}
