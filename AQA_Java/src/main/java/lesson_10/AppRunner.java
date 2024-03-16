package lesson_10;

public class AppRunner {
    public static void main(String[] args) {
        Apple apple1 = new Apple(2);
        Apple apple2 = new Apple(3);
        Apple apple3 = new Apple(4);
        Apple apple4 = new Apple(5);
        Orange orange1 = new Orange(55);
        Orange orange2 = new Orange(3);

        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.add(apple1);
        appleBox.add(apple2);
        appleBox1.add(apple3);
        appleBox1.add(apple4);
        orangeBox.add(orange1);
        orangeBox.add(orange2);

        System.out.println("orangeBox: " + orangeBox.getWeight());
        System.out.println("appleBox: " + appleBox.getWeight());
        System.out.println("appleBox1: " + appleBox1.getWeight());

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.compare(appleBox));

        appleBox.pourTo(appleBox1);
        System.out.println("after moving: " + appleBox.getWeight() + " appleBox");
        System.out.println("after moving: " + appleBox1.getWeight() + " appleBox1");
    }
}
