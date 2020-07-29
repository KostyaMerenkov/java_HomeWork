import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Ты победил! ");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил! ");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }

        }
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;

        do {
            System.out.println("Input X, Y ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static int aiTurn() {
        int x, y;
        for (int i = 0; i < SIZE; i++) {    //Победить
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        map[i][j] = DOT_O;
                        return 0;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {    //Не проиграть
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        return 0;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        do {                                //Как попало
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
        return 0;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char c) {
        int win1 = 0;
        int win2 = 0;
        int win3 = 0;
        int win4 = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == c) {
                    win1 = win2 = win3 = win4 = 0;
                    for (int k = 0; k < DOTS_TO_WIN; k++) { // диагональ наверх
                        if (i - k <= SIZE || j + k >= SIZE) break;
                        else if (map[i - k][j + k] == c) {
                            win1++;
                        } else break;
                    }
                    for (int k = 0; k < DOTS_TO_WIN; k++) { // диагональ вниз
                        if (i + k >= SIZE || j + k >= SIZE) break;
                        else if (map[i + k][j + k] == c) {
                            win2++;
                        } else break;
                    }

                    for (int k = 0; k < DOTS_TO_WIN; k++) { // горизонталь
                        if (j + k >= SIZE) break;
                        else if (map[i][j + k] == c) {
                            win3++;
                        } else break;
                    }
                    for (int k = 0; k < DOTS_TO_WIN; k++) { // вертикаль
                        if (i + k >= SIZE) break;
                        else if (map[i + k][j] == c) {
                            win4++;
                        } else break;
                    }
                    if (win1 == 3 || win2 == 3 || win3 == 3 || win4 == 3) return true;
                }
            }
        }
        return false;
    }
}
