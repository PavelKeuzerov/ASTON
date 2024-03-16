package lesson_10;

public class AppRunner {
    public static void main(String[] args) {
        //Инициализируем объекты
        Apple a1 = new Apple(2);
        Apple a2 = new Apple(3);
        Apple a3 = new Apple(4);
        Apple a4 = new Apple(2);
        Apple a5 = new Apple(3);
        Orange o1 = new Orange(55);
        Orange o2 = new Orange(3);
        //Создаем коробки
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        //Заполняем коробки
        orangeBox.add(o1);
        orangeBox.add(o2);
        appleBox.add(a1);
        appleBox.add(a2);
        appleBox.add(a3);
        appleBox1.add(a4);
        appleBox1.add(a5);
        //Результаты
        System.out.println("appleBox: " + appleBox.getWeight());
        System.out.println("orangeBox: " + orangeBox.getWeight());
        System.out.println("appleBox1: " + appleBox1.getWeight());
//        System.out.print("Compare: ");
//        System.out.println(appleBox.compare(orangeBox));
//        System.out.println(appleBox.compare(appleBox));
//




//        System.out.println("***Before union boxes***");
//        System.out.println("appleBox:");
//        System.out.println(appleBox.getFruitInBox());
//        System.out.println("appleBox1:");
//        System.out.println(appleBox1.getFruitInBox());
//        System.out.println("*Union*");
        appleBox.pourTo(appleBox1);

//        orangeBox.unionFruitBox(appleBox1); - так нельзя <Orange> не будет сравнивать с <Apple>
//        orangeBox.pourTo(orangeBox);
//        System.out.println("appleBox:");
//        System.out.println(appleBox.getFruitInBox());
//        System.out.println("appleBox1:");
//        System.out.println(appleBox1.getFruitInBox());
//        System.out.print("appleBox.getBoxWeight() after union: ");
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());
    }
}
