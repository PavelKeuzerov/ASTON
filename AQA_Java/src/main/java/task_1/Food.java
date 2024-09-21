package task_1;

public class Food {
    private int quantityFood;

    public void addFood(int portion) {
        this.quantityFood += portion;
    }

    public int getQuantityFood() {
        return quantityFood;
    }

    public void setQuantityFood(int quantityFood) {
        this.quantityFood = quantityFood;
    }
}