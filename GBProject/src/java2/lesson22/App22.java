package java2.lesson22;

import java.util.Arrays;
import java.util.Random;

public class App22 {
    //1.Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    //При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    //2.Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    //Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    //должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
    //3.В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException
    //и вывести результат расчета.

    public static void main(String[] args) {

        try {
            String[][] array1 =new String[4][4];
            initRandomArray(array1);
            printArray(array1);
            System.out.println("Сумма массива 1=" + sumArray(array1));

            String[][] array2 = new String[4][4];
            initRandomArray(array2);
            array2[3][3] = "XX";
            printArray(array2);
            System.out.println("Сумма массива 2=" + sumArray(array2));

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            String[][] array3 =new String[4][];
            array3[0] = new String[4];
            array3[1] = new String[4];
            array3[2] = new String[4];
            array3[3] = new String[1];
            initRandomArray(array3);
            printArray(array3);
            System.out.println("Сумма массива 3=" + sumArray(array3));

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    public static void initRandomArray(String[][] array) throws MyArraySizeException {

        Random r = new Random();
        for (String[] a : array) {
            if(a == null) { throw new MyArraySizeException(); }
            for (int i = 0; i < a.length; i++) {
                a[i] = String.valueOf(r.nextInt(100));
            }
        }

    }

    public static void printArray(String[][] array) throws MyArraySizeException {
        for (String[] a : array) {
            if(a == null) { throw new MyArraySizeException(); }
            System.out.println(Arrays.toString(a));
        }

    }

    public static long sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        long sum = 0;
        if(array.length != 4) { throw new MyArraySizeException(); }
        for (int i = 0; i < array.length; i++) {
            if(array[i].length != 4 || array[i] == null) { throw new MyArraySizeException(); }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) { throw new MyArrayDataException(i, j); }
            }
        }
        return sum;
    }
}
