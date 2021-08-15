package ru.geekbrains.lesson_4.hw;

import java.util.Random;
import java.util.Scanner;

public class ConsoleGameApp {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    // опишем параметры для создания карты
    public static char[][] map; // создаём карту посредством двумерного массива.
    public static char[][] invisibleMap; // в игре существует невидимая копия карты на которой располагаются враги
    public static int widthMap; // у карты есть ширина
    public static int heightMap; // и высота
    public static int minMapSize = 5; // минимальное количество ячеек в карте
    public static int maxMapSize = 7; // максимальное количество ячеек в карте.

    // опишем параметры для создания игрока
    public static char player = '@'; // создаём символ видимости игрока
    public static int healthPlayer = 100; // задаём уровень здоровья игрока
    public static int powerPointPlayer = 30; // задаём уровень мощности нанесения урона
    public static int positionPlayerX; // координата игрока по Х
    public static int positionPlayerY; // координата игрока по У

    // опишем параметры движения игрока по карте
    // особенность этих переменных в том, что они всегда должны быть постоянными,
    // чтобы их где-то в коде случайно не перезаписать!
    public static final int moveUp = 8;
    public static final int moveDown = 2;
    public static final int moveLeft = 4;
    public static final int moveRight = 6;
    public static final int moveLeftUp = 7;
    public static final int moveRightUp = 9;
    public static final int moveLeftDown = 1;
    public static final int moveRightDown = 3;

    //опишем параметры врага
    public static char enemy = 'E'; // создаём символ видимости игрока
    public static int healthEnemy; // задаём уровень здоровья игрока
    public static int powerEnemy; // задаём уровень мощности нанесения урона
    public static int powerEnemyMin = 15; // координата игрока по Х
    public static int powerEnemyMax = 30; // координата игрока по Y

    // опишем, как будем отмечать посещённые ячейки
    public static char readyCell = '*'; // пройденная ячейка
    public static char emptyCell = '_'; // не пройденная ячейка

    public static void main(String[] args) {
        createMap();
        printMap();

    }

    // создаём карту
    public static void createMap() {
        heightMap = randomRange(minMapSize, maxMapSize); // генерируем высоту карты используя min и max параметры карты
        widthMap = randomRange(minMapSize, maxMapSize); // генерируем ширину карты используя min и max параметры карты
        map = new char[heightMap][widthMap]; // используем сгенерированные числа для создания массива (карты)
        invisibleMap = new char[heightMap][widthMap]; // используем сгенерированные числа для создания массива (скрытой карты)

        // используем вложенные циклы для прорисовки карты и заполняем ячейки карты "пустотой" emptyCell
        for (int y = 0; y < heightMap; y++) {
            for (int x = 0; x < widthMap; x++) {
                map[y][x] = emptyCell;
            }
        }

        System.out.println("Создана карта размером: " + widthMap + "x" + heightMap);

    }

    // создаём метод прорисовки карты в консоли, для этого используем вложенные циклы for
    public static void printMap(){
        System.out.println("***** ТЕКУЩАЯ КАРТА *****");
        for (int y = 0; y < heightMap; y++) {
            for (int x = 0; x < widthMap; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("*************************");
    }




    // создаём метод для генерации числа в пределах граничных значений
    public static int randomRange (int min, int max) {
        int diff = max - min;
        int value = random.nextInt(diff +1);
        return min + value ;
    }

}
