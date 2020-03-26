package lesson31;

import java.util.ArrayList;
import java.util.Arrays;

public class App31 {

    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    //2. Написать метод, который преобразует массив в ArrayList;

    //3. Интересная задача:
    //a. Есть классы lesson31.Fruit -> lesson31.Apple, lesson31.Orange;(больше фруктов не надо)
    //b. Класс lesson31.Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
    //   нельзя сложить и яблоки, и апельсины;
    //c. Для хранения фруктов внутри коробки можете использовать ArrayList;
    //d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного
    //   фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
    //e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
    //   которую подадут в compare в качестве параметра, true - если их веса равны, false в противном
    //   случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    //f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов,
    //   нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
    //   а в другую перекидываются объекты, которые были в этой коробке;
    //g. Не забываем про метод добавления фрукта в коробку.

    public static void main(String[] args) {
        String[] arr1 = {"1A","2A"};
        Integer[] arr2 = {1,2};

        // Задача 1
        change2elements(arr1, 0,1);
        System.out.println(Arrays.toString(arr1));
        change2elements(arr2, 0,1);
        System.out.println(Arrays.toString(arr2));

        // Задача 2
        System.out.println(toArrayList(arr1));
        System.out.println(toArrayList(arr2));

        // Задание 3
        Box<Apple> appleBox1 = new Box<>(new Apple[]{new Apple(), new Apple()});
        Box<Apple> appleBox2 = new Box<>(new Apple[]{new Apple(), new Apple(), new Apple()});
        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println(appleBox1);
        System.out.println(appleBox2);
        System.out.println(orangeBox);

        System.out.println(appleBox2.compare(orangeBox));
        System.out.println(appleBox1.compare(orangeBox));

        appleBox2.addAllFrom(appleBox1);
        System.out.println(appleBox1);
        System.out.println(appleBox2);

        appleBox2.addAllTo(appleBox1);
        System.out.println(appleBox1);
        System.out.println(appleBox2);;

    }

    public static<T> void change2elements(T[] array, int first, int second) {
        T element;
        element = array[first];
        array[first] = array[second];
        array[second] = element;
    }

    public static<T> ArrayList<T> toArrayList(T[] array) {
        return new ArrayList<T>(Arrays.asList(array));
    }
}
