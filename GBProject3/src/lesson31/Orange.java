package lesson31;

import lesson31.Fruit;

public class Orange extends Fruit {
    public Orange() {
        super(1.5);
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                '}';
    }
}
