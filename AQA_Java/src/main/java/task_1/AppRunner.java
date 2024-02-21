package task_1;

public class AppRunner {
    public static void main(String[] args) {

        Dog pes = new Dog();
        Dog barbos = new Dog();

        pes.run(10);
        pes.swim(7);

        barbos.run(1111);
        barbos.swim(1);

        System.out.println("Number of animals -  " + Animal.getAnimalCount());
        System.out.println("Number of dogs -  " + Dog.getDogCount());
    }
}
