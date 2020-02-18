package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        setFood(food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food <= 0 ? 0 : food;
    }

    public void decreaseFood(int n) {
        setFood(food - n);
    }

    public void increaseFood(int n) {
        setFood(food + n);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + getFood() +
                '}';
    }
}
