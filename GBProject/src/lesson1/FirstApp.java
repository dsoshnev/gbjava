package lesson1;

public class FirstApp {
    public static void main(String[] args) {
        //Задание 2
        // Целочисленные
        byte a = 127;
        short b = 32767;
        int c = 10;
        long d = 10L;
        // C плавающей запятой
        float e = 7.5f;
        double f = 7.5;
        // Символьный
        char g = 'a';
        // Логический
        boolean h = false;
        // Ссылочные (объектные)
        String j = "Дмитрий";

        System.out.println("byte:" + a + ",short:" + b + ",int:" + c + ",long:" + d);
        System.out.println("float:" + e + ",double:" + f);
        System.out.println("char:" + g);
        System.out.println("boolean:" + h);
        System.out.println("String:" + j);

        //Задание 3
        System.out.println(calculate(e, e, e, e));

        //Задание 4
        System.out.println(checkRange(1, 1));
        System.out.println(checkRange(5, 5));
        System.out.println(checkRange(10, 10));
        System.out.println(checkRange(20, 20));

        //Задание 5
        checkPositiveNumber(-1);
        checkPositiveNumber(0);

        //Задание 6
        System.out.println(checkNegativeNumber(-1));
        System.out.println(checkNegativeNumber(0));

        //Задание 7
        sayHi(j);

        //Задание 8
        checkLeapYear(4);
        checkLeapYear(100);
        checkLeapYear(400);
    }

    // 3. метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    // где a, b, c, d – аргументы этого метода, имеющие тип float.
    public static float calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    // 4. метод, принимающий на вход два целых числа и проверяющий,
    // что их сумма лежит в пределах от 10 до 20 (включительно),
    // если да – вернуть true, в противном случае – false.
    public static boolean checkRange(int a, int b) {
        int c = a + b;
        return c>=10 && c<=20;
    }

    // 5. метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    public static void checkPositiveNumber(int a) {
        if (a>=0) {
            System.out.println("положительное число:" + a);
        } else{
            System.out.println("отрицательное число:" + a);
        }
    }

    // 6. метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное.
    public static boolean checkNegativeNumber(int a) {
        return a<0;
    }

    // 7. метод, которому в качестве параметра передается строка, обозначающая имя.
    // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    public static void sayHi(String name) {
        System.out.println("Привет, " + name + "!");
    }
    // 8. метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный
    public static void checkLeapYear(long year) {
        boolean result = false;
        if (year>0) {
            if((year%4)==0) {
                result = true;
                if(year%100==0) {
                    result = false;
                    if(year%400==0) {
                        result = true;
                    }
                }
            }
        }
        if (result) {
            System.out.println("високосный год:" + year);
        } else{
            System.out.println("невисокосный год:" + year);
        }
    }
}
