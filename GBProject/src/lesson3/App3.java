package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Task 1
        gameNumbers(sc);

        //Task 2
        gameWords(sc);
        sc.close();
    }

    //Написать программу, которая загадывает случайное число от 0 до 9
    // и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число,
    // чем загаданное, или меньше. После победы или проигрыша выводится запрос
    // – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)
    public static void gameNumbers(Scanner sc) {
        int x, answer;
        do {
            x = new Random().nextInt(9);
            System.out.println("Игра №1: Я загадал число от 0-9, у вас три попытки отгадать его");
            for (int i = 0; i < 3; i++) {
                answer = sc.nextInt();
                if(answer == x) {
                    System.out.println("Правильный ответ");
                    break;
                }
                if (answer > x) {
                    System.out.println("Ваше число больше загаданного");
                } else {
                    System.out.println("Ваше число меньше загаданного");
                }
            }
            System.out.println("«Повторить игру еще раз? 1 – да / 0 – нет»");
        } while (sc.nextInt()==1);
        System.out.println("Конец игры");

    }

    //* Создать массив из слов
    //String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
    // "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
    // "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    // сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
    // Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно можно пользоваться:
    //String str = "apple";
    //char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово.
    //Используем только маленькие буквы.
    public static void gameWords(Scanner sc) {
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int x = new Random().nextInt(words.length-1);
        String answer;
        System.out.println("Игра №2: Отгадай задуманное слово");
        char[] result = "###############".toCharArray();
        do {
            answer = sc.nextLine();
            for (int i = 0; i < words[x].length() && i < answer.length(); i++) {
                if(words[x].charAt(i)==answer.charAt(i)) {
                    result[i] = answer.charAt(i);
                }
            }
            System.out.println(new String(result));
        } while (!answer.equals(words[x]));
        System.out.println("Правильный ответ");
    }
}
