package lesson31;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {
    private final ArrayList<T> content = new ArrayList<>();

    public Box() {
    }

    public Box(T[] array) {
        content.addAll(Arrays.asList(array));
    }

    public void add(T fruit) {
        content.add(fruit);
    }

    public void addAllFrom(Box<T> fromBox) {
        if(!this.equals(fromBox)) {
            content.addAll(fromBox.getContent());
            fromBox.getContent().clear();
        }
    }

    public void addAllTo(Box<T> toBox) {
        if(!this.equals(toBox)) {
            toBox.getContent().addAll(content);
            content.clear();
        }
    }

    public double getWeight() {
        double weight = 0;
        for (T fruit : content) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public ArrayList<T> getContent() {
        return content;
    }

    public<M extends Fruit> boolean compare(Box<M> box) {
        System.out.printf("compare %s -> %s%n", this, box);
        if(this.getWeight() == box.getWeight()) {
            return true;
        }
       return false;
    }

    @Override
    public String toString() {
        return "lesson31.Box{" +
                "content=" + getContent() +
                "}=" + getWeight();
    }
}
