package lesson2;

import java.util.Arrays;

public class App2 {
    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("Задание №1:");
        int[] a1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(a1));
        for (int i = 0; i < a1.length; i++) {
            switch (a1[i]) {
                case 0:
                    ++a1[i];
                    break;
                case 1:
                    --a1[i];
                    break;
            }
        }
        System.out.println(Arrays.toString(a1));

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("Задание №2:");
        int[] a2 = new int[8];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = i * 3;
        }
        System.out.println(Arrays.toString(a2));

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("Задание №3:");
        int[] a3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(a3));
        for (int i = 0; i < a3.length; i++) {
            if (a3[i] < 6) {
                a3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(a3));

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("Задание №4:");
        int[][] a4 = new int[5][5];
        for (int i = 0; i < a4.length; i++) {
            a4[i][i] = 1;
        }
        for (int[] a5 : a4) {
            System.out.println(Arrays.toString(a5));
        }

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("Задание №5:");
        int valueMIN, valueMAХ;
        valueMIN = valueMAХ = a3[0];
        for (int i = 1; i < a3.length; i++) {
            if (a3[i] < valueMIN) {
                valueMIN = a3[i];
            }
            if (a3[i] > valueMAХ) {
                valueMAХ = a3[i];
            }
        }
        System.out.println(Arrays.toString(a3));
        System.out.println("min:" + valueMIN + ",max:" + valueMAХ);
        //Вариант 2
        Arrays.sort(a3);
        System.out.println(Arrays.toString(a3));
        System.out.println("min:" + a3[0] + ",max:" + a3[a3.length-1]);

        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        int[] a6 = {2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2};
        System.out.println("Задание №6:");
        System.out.println(Arrays.toString(a6));
        System.out.println(checkBalance(a6));

        //7. **** Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        System.out.println("Задание №7:");
        System.out.println(Arrays.toString(a3));
        shiftArray(a3, -5);
        System.out.println(Arrays.toString(a3));
        shiftArray(a3, 3);
        System.out.println(Arrays.toString(a3));
        shiftArray(a3, -50);
        System.out.println(Arrays.toString(a3));
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] a) {
        int valueLeftSum = 0;
        int valueCount = 0;
        int valueSum = Arrays.stream(a).sum();
        for (int i = 0; i < a.length-1; i++) {
            valueLeftSum += a[i];
            System.out.println(valueLeftSum + "||" + (valueSum - valueLeftSum));
            if (valueLeftSum == (valueSum - valueLeftSum)) {
                valueCount++;
            }
        }
        System.out.println(valueCount);
        return valueCount>0;

    }
    //7. **** Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static void shiftArray(int[] a, int n) {
        if (n < 0) {
            for (int i = 0; i < a.length; i++) {
                if((i + n)>=0) {
                    a[i + n] = a[i];
                }
                a[i] = 0;
            }
        } else {
            for (int i = a.length-1; i >= 0 ; i--) {
                if((i + n) < a.length) {
                    a[i + n] = a[i];
                }
                a[i] = 0;
            }
        }
    }
}

