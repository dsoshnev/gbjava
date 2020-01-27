package lesson4;

import java.util.Random;
import java.util.Scanner;

public class App4 {
    public static final int GAME_SIZE = 5;
    public static final int COUNT_TO_WIN = 4;
    public static final char CELL_EMPTY = '*';
    public static final char CELL_X = 'X';
    public static final char CELL_O = 'O';

    public static char[][] gameField;

    public static void main(String[] args) {
        //Игра крестики-нолики

        //1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
        //2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например,
        // с использованием циклов.
        //3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
        // Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
        //4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

        System.out.println("Игра крестики-нолики");
        initGameField();
        printGameField();
        playGame();
        System.out.println("Конец игры");
    }

    public static void playGame() {
        do {
            humanMove(CELL_X);
            printGameField();
            if (isWin(CELL_X, COUNT_TO_WIN)) {
                System.out.println("Вы победили!");
                break;
            }
            if(isEnd()) {
                break;
            }

            botMove(CELL_O);
            printGameField();
            if (isWin(CELL_O, COUNT_TO_WIN)) {
                System.out.println("Вы проиграли!");
                break;
            }

            if(isEnd()) {
                break;
            }

        } while (true);
        printGameField();
    }

    private static void botMove(char c) {
        boolean repeat;
        Random rand = new Random();
        int x,y;
        do {
            repeat = false;
            y = rand.nextInt(GAME_SIZE);
            x = rand.nextInt(GAME_SIZE);
            if (gameField[y][x] == CELL_EMPTY) {
                gameField[y][x] = c;
                System.out.println("ХОД БОТА (" + c + ") " + (y+1) + ":" + (x+1));
            } else {
                //System.out.println("Клетка занята. БОТ попробует еще раз");;
                repeat = true;
            }
        } while(repeat);
    }

    private static void humanMove(char c) {
        Scanner sc = new Scanner(System.in);
        boolean repeat;
        do {
            repeat = false;
            System.out.println("ВАШ ХОД в формате Строка:Колонка (" + c + ")");
            String s = sc.nextLine();
            int i = s.indexOf(":");
            int x,y;
            try {
                y = Integer.parseInt(s.substring(0, i))-1;
                x = Integer.parseInt(s.substring(i + 1))-1;
                if (gameField[y][x] == CELL_EMPTY) {
                    gameField[y][x] = c;
                } else {
                    System.out.println("Клетка занята. Попробуй еще раз!");
                    repeat = true;
                }

            } catch(Exception ex) {
                System.out.println("Попробуй еще раз!");
                System.out.println(ex.getMessage());
                repeat = true;
            }
        } while (repeat);

    }
    private static boolean isEnd() {
        for (char[] c1: gameField) {
            for (char c: c1) {
                if (c == CELL_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isWin(char c, int countToWin) {

        //1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
        /*if(gameField[0][0] == c && gameField[0][1] == c && gameField[0][2] == c ) return true;
        if(gameField[1][0] == c && gameField[1][1] == c && gameField[1][2] == c ) return true;
        if(gameField[2][0] == c && gameField[2][1] == c && gameField[2][2] == c ) return true;

        if(gameField[0][0] == c && gameField[1][0] == c && gameField[2][0] == c ) return true;
        if(gameField[0][1] == c && gameField[1][1] == c && gameField[2][1] == c ) return true;
        if(gameField[0][2] == c && gameField[1][2] == c && gameField[2][2] == c ) return true;

        if(gameField[0][0] == c && gameField[1][1] == c && gameField[2][2] == c ) return true;
        if(gameField[0][2] == c && gameField[1][1] == c && gameField[2][0] == c ) return true;
        */


        //2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например,
        // с использованием циклов.
        //3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
        // Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
        //Проверка строк на победу
        for (int i = 0; i < GAME_SIZE; i++) {
            int count = 0;
            for (int j = 0; j < GAME_SIZE; j++) {
                if(gameField[i][j] == c) {
                    count++;
                    if (count == countToWin) return true;
                } else {
                    count = 0;
                }
            }
        }
        //Проверка столбцов на победу
        for (int  j = 0; j < GAME_SIZE; j++) {
            int count = 0;
            for (int i = 0; i < GAME_SIZE; i++) {
                if (gameField[i][j] == c) {
                    count++;
                    if (count == countToWin) return true;
                } else {
                    count = 0;
                }
            }
        }
        //Проверка диагонали на победу
        int count = 0;
        for (int i = 0; i < GAME_SIZE; i++) {
            if (gameField[i][i] == c) {
                count++;
                if (count == countToWin) return true;
            } else {
                count = 0;
            }
        }

        count = 0;
        for (int i = 0; i < GAME_SIZE; i++) {
            if (gameField[i][GAME_SIZE-1-i] == c) {
                count++;
                if (count == countToWin) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static void initGameField() {
        gameField = new char[GAME_SIZE][GAME_SIZE];
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                gameField[i][j] = CELL_EMPTY;
            }
        }
    }

    public static void printGameField() {
        System.out.print(" ");
        for (int i = 0; i < GAME_SIZE; i++) {
            System.out.print(" " + (i+1));
        }
        System.out.println();

        for (int i = 0; i < GAME_SIZE; i++) {
            System.out.print((i+1));
            for (int j = 0; j < GAME_SIZE; j++) {
                System.out.print(" " + gameField[i][j]);
            }
            System.out.println();
        }
    }
}
