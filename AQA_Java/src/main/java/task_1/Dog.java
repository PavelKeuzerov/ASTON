package task_1;

public class Dog extends Animal {
    private static final int DOG_MAX_RUN = 500;
    private static final int DOG_MAX_SWIM = 10;
    private static int dogCount;

    public Dog(String name) {
        super (name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance < DOG_MAX_RUN && distance > 0) {
            System.out.println(name + " Dog ran " + distance + " m.");
        } else if (distance < 0 ) {
            System.out.println("Incorrect data " + distance + " m.");
        } else if  (distance == 0) {
            System.out.println("Enter distance");
        } else {
            System.out.println("Distance too far");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < DOG_MAX_SWIM && distance > 0) {
            System.out.println("Dog swim " + distance + " m.");
        } else if (distance < 0 ) {
            System.out.println("Incorrect data " + distance + " m.");
        } else if (distance == 0) {
            System.out.println("Enter distance");
        } else {
            System.out.println("Distance too far");
        }
    }
}
