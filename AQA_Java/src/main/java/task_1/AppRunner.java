package task_1;

public class AppRunner {
    public static void main(String[] args) {

        Dog pes = new Dog("pes");
        Dog barbos = new Dog("barbos");
        Cat murzik = new Cat("murzik");
        Cat barsik = new Cat("barsik");

        murzik.run(44);
        murzik.swim(6);
        barsik.run(555);

        pes.run(10);
        pes.swim(7);
        barbos.run(1111);
        barbos.swim(1);

        System.out.println("Number of animals -  " + Animal.getAnimalCount());
        System.out.println("Number of dogs -  " + Dog.getDogCount());
        System.out.println("Number of cats -  " + Cat.getCatCount());

        Food food = new Food();
        food.addFood(15);

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("myrzik");
        cats[1] = new Cat("barsik");
        cats[2] = new Cat("martun");

        for (Cat cat : cats) cat.eat(food, 7);

    }
}
