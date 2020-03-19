package java2.lesson25;

public class App25 {
    //1. Необходимо написать два метода, которые делают следующее:
    //1) Создают одномерный длинный массив, например:
    //
    //static final int size = 10000000;
    //static final int h = size / 2;
    //float[] arr = new float[size];
    //
    //2) Заполняют этот массив единицами;
    //3) Засекают время выполнения: long a = System.currentTimeMillis();
    //4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
    //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    //5) Проверяется время окончания метода System.currentTimeMillis();
    //6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
    //
    //Отличие первого метода от второго:
    //Первый просто бежит по массиву и вычисляет значения.
    //Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
    //
    //Пример деления одного массива на два:
    //
    //System.arraycopy(arr, 0, a1, 0, h);
    //System.arraycopy(arr, h, a2, 0, h);
    //
    //Пример обратной склейки:
    //
    //System.arraycopy(a1, 0, arr, 0, h);
    //System.arraycopy(a2, 0, arr, h, h);
    //
    //Примечание:
    //System.arraycopy() – копирует данные из одного массива в другой:
    //System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
    //По замерам времени:
    //Для первого метода надо считать время только на цикл расчета:
    //
    //for (int i = 0; i < size; i++) {
    //arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    //}
    //
    //Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

    static final int ARRAY_SIZE = 10000000;
    static final int ARRAY_HALF = ARRAY_SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[ARRAY_SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        method1(arr);
        method2(arr);
    }

    public static void method1(float[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.printf("Задача 1 завершена за: %s мс\n", (System.currentTimeMillis()-start));
    }

    public static void method2(float[] arr) throws InterruptedException {
        long start = System.currentTimeMillis();

        float[] a1 = new float[ARRAY_HALF];
        float[] a2 = new float[ARRAY_HALF];

        System.arraycopy(arr, 0, a1, 0, ARRAY_HALF);
        System.arraycopy(arr, ARRAY_HALF, a2, 0, ARRAY_HALF);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(a1, 0, arr, 0, ARRAY_HALF);
        System.arraycopy(a2, 0, arr, ARRAY_HALF, ARRAY_HALF);

        System.out.printf("Задача 2 завершена за: %s мс\n", (System.currentTimeMillis()-start));
    }
}

