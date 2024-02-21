package task_1;

public class Animal {
    private static int animalCount;

    public Animal() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
    }

    public void swim(int distance) {
    }
}
