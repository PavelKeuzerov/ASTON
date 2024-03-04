package task_2;


public class AppRunner {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(7, 9, 5, "red", "black");
        System.out.println(triangle);

        Rectangle rectangle = new Rectangle( 9, 5, "yellow", "green");
        System.out.println(rectangle);

        Circle circle = new Circle(5, "grey", "pink");
        System.out.println(circle);

    }
}
