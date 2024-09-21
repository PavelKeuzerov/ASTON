package task_1;

public class Cat extends Animal {
    private static final int CAT_MAX_RUN = 200;
    private static int catCount;
    private boolean satiety = true;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

      @Override
    public void run(int distance) {
        if (distance < CAT_MAX_RUN && distance > 0) {
            System.out.println(name + " Cat ran " + distance + " m.");
        } else if (distance < 0) {
            System.out.println("Incorrect data " + distance + " m.");
        } else if (distance == 0) {
            System.out.println("Enter distance");
        } else {
            System.out.println("Distance too far");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("The cat can't swim");
    }

    void eat(Food food, int quantityFood) {
        if (satiety && food.getQuantityFood() - quantityFood <= 0) {
            System.out.println("The cat has nothing to eat");
        } else if (satiety) {
            food.setQuantityFood(food.getQuantityFood() - quantityFood);
            satiety = true;
            System.out.println("The cat has eaten and is resting");
        } else {
            System.out.println("The cat is full");
        }
    }
}
