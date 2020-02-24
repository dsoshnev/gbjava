package lesson8;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public final int GAME_SIZE = 4;
    public final int COUNT_TO_WIN = 3;
    public final char CELL_EMPTY = '*';
    public final char CELL_X = 'X';
    public final char CELL_O = 'O';

    private char[][] gameField;
    private boolean gameActive;
    private JFrame window;

    public Game() {
        this.gameActive = false;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public void initGame() {
        gameSay("ИГРА", "Поиграй с БОТом в крестики-нолики");
        gameField = new char[GAME_SIZE][GAME_SIZE];
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                gameField[i][j] = CELL_EMPTY;
            }
        }
        gameActive = true;
    }

    private void gameSay(String name, String text) {
        if(window == null) {
            System.out.println(name + ": " + text);
        } else {
            window.setTitle(name + ": " + text);
        }
    }

    public void playTerminalGame() {
        initGame();
        printGameField();

        do {
            humanMove(CELL_X);
            printGameField();
            botMove(CELL_O);
            printGameField();
        } while (!isEnd());
        printGameField();
    }

    public void botMove(char c) {
        //botBlockMove(c);
        botRandomMove(c);
    }

    private void botBlockMove(char c) {
        int i;
        i = checkColumns(CELL_X,COUNT_TO_WIN-1);
        if (i >= 0) {
            gameSay("БОТ", "Я начинаю проигрывать в столбце: " + (i+1));
            //TODO
        }

        i = checkRows(CELL_X,COUNT_TO_WIN-1);
        if (i >= 0) {
            gameSay("БОТ", "Я начинаю проигрывать в строке: " +(i+1));
            //TODO
        }

        i = checkMainDiagonal(CELL_X,COUNT_TO_WIN-1);
        if (i >= 0) {
            gameSay("БОТ", "Я начинаю проигрывать по главной диагонали");
            //TODO
        }

        i = checkDiagonal(CELL_X,COUNT_TO_WIN-1);
        if (i >= 0) {
            gameSay("БОТ", "Я начинаю проигрывать диагонали");
            //TODO
        }
    }

    private void botRandomMove(char c) {
        if(!isEnd()) {
            Random rand = new Random();
            do {
            } while (!set(c, (rand.nextInt(GAME_SIZE) + 1) + ":" + (rand.nextInt(GAME_SIZE) + 1)));
        }
    }

    private void humanMove(char c) {
        if(!isEnd()) {
            Scanner sc = new Scanner(System.in);
            gameSay("ИНФОРМАЦИЯ", "ВАШ ХОД в формате Строка:Колонка (" + c + ")");
            do {
            } while (!set(c, sc.nextLine()));
        }
    }

    public char get(String name) {
        int i = name.indexOf(":");
        int x,y;
        try {
            y = Integer.parseInt(name.substring(0, i))-1;
            x = Integer.parseInt(name.substring(i + 1))-1;
            return gameField[y][x];
        } catch(Exception ex) {
            gameSay("ИГРА", "Ошибка. Попробуй еще раз!");
        }
        return 0x00;
    }
    public boolean set(char c, String name) {
        if(!isEnd()) {
            int i = name.indexOf(":");
            int x, y;
            try {
                y = Integer.parseInt(name.substring(0, i)) - 1;
                x = Integer.parseInt(name.substring(i + 1)) - 1;
                if (gameField[y][x] == CELL_EMPTY) {
                    gameField[y][x] = c;
                    isFull();
                    isWin(c);
                    return true;
                } else {
                    gameSay("ИГРА", "Клетка занята. Попробуй еще раз!");
                }
            } catch (Exception ex) {
                gameSay("ИГРА", "Ошибка. Попробуй еще раз!");
                //System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public boolean isEnd() {
        return !gameActive;
    }

    private boolean isFull() {
        for (char[] c1: gameField) {
            for (char c: c1) {
                if (c == CELL_EMPTY) {
                    return false;
                }
            }
        }
        gameSay("ИГРА","Вот и все!");
        gameActive = false;
        return true;
    }

    private boolean isWin(char c) {

        if (checkRows(c, COUNT_TO_WIN)>=0 ||
                checkColumns(c, COUNT_TO_WIN)>=0 ||
                checkMainDiagonal(c, COUNT_TO_WIN)>=0 ||
                checkDiagonal(c, COUNT_TO_WIN)>=0) {
            gameSay("ИГРА","Выиграл "  + c);
            gameActive = false;
            return true;
        }
        return false;
    }

    private int checkDiagonal(char c, int countToWin) {
        //Проверка диагонали на победу
        int count = 0;
        for (int i = 0; i < GAME_SIZE; i++) {
            if (gameField[i][GAME_SIZE-1-i] == c) {
                count++;
                if (count == countToWin) return i;
            } else {
                count = 0;
            }
        }
        return -1;
    }

    private int checkMainDiagonal(char c, int countToWin) {
        //Проверка главной диагонали на победу
        int count = 0;
        for (int i = 0; i < GAME_SIZE; i++) {
            if (gameField[i][i] == c) {
                count++;
                if (count == countToWin) return i;
            } else {
                count = 0;
            }
        }
        return -1;
    }

    private int checkColumns(char c, int countToWin) {
        //Проверка столбцов на победу
        for (int  j = 0; j < GAME_SIZE; j++) {
            int count = 0;
            for (int i = 0; i < GAME_SIZE; i++) {
                if (gameField[i][j] == c) {
                    count++;
                    if (count == countToWin) return j;
                } else {
                    count = 0;
                }
            }
        }
        return -1;
    }

    private int checkRows(char c, int countToWin) {
        //Проверка строк на победу
        for (int i = 0; i < GAME_SIZE; i++) {
            int count = 0;
            for (int j = 0; j < GAME_SIZE; j++) {
                if(gameField[i][j] == c) {
                    count++;
                    if (count == countToWin) return i;
                } else {
                    count = 0;
                }
            }
        }
        return -1;
    }

    private void printGameField() {
        //Шапка
        System.out.print(" ");
        for (int j = 0; j < GAME_SIZE; j++) {
            System.out.print(" " + (j+1));
        }
        System.out.println();
        //Строки
        for (int i = 0; i < GAME_SIZE; i++) {
            System.out.print((i+1));
            //Столбцы
            for (int j = 0; j < GAME_SIZE; j++) {
                System.out.print(" " + gameField[i][j]);
            }
            System.out.println();
        }
    }
}

