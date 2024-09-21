package lesson_10;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruitInBox = new ArrayList<>();
    private float weight;

    public float getWeight() {
        return weight;
    }

    public void add(T fruit) {
        fruitInBox.add(fruit);
        weight += fruit.getWeight();
    }

    public boolean compare(Box<?> box) {
        return weight == box.getWeight();
    }

    public void pourTo(Box<T> box) {
        if (!box.fruitInBox.isEmpty()) {
            this.fruitInBox.addAll(box.fruitInBox);
            this.weight += box.getWeight();
            box.weight = 0f;
        }
    }
}
