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
    public static int minMapSize = 3; // минимальное количество ячеек в карте
    public static int maxMapSize = 5; // максимальное количество ячеек в карте.
    public static int countMapLevel = 0; // начальный уровень карты.

    // параметры точки выхода из карты
    public static char exit = 'Q'; // создаём символ точки выхода из карты.
    public static boolean exitPoint = false; //создаём логическую переменную точки выхода.

    // опишем параметры для создания игрока
    public static char player = '@'; // создаём символ видимости игрока
    public static int healthPlayer = 100; // задаём уровень здоровья игрока
    public static int powerPlayer = 30; // задаём уровень мощности нанесения урона
    public static int positionPlayerX; // координата игрока по Х
    public static int positionPlayerY; // координата игрока по У
    public static int countPlayerStep = 0;
    public static boolean setRandomStartPositionPlayer = false;

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
    public static int valueEnemyMin = 15; // минимальный уровень параметров врага
    public static int valueEnemyMax = 20; // максимальный уровень параметров врага

    // опишем, как будем отмечать посещённые ячейки
    public static char readyCell = '*'; // пройденная ячейка
    public static char emptyCell = '_'; // не пройденная ячейка

    public static void main(String[] args) {

        while (isPlayerAlive()) {
            ++countMapLevel;
            System.out.println("***** Игра началась. Текущий уровень карты " + countMapLevel + " *****");
            gameCycle();
        }
        System.out.println("***** Игра закончена! Количество пройденных шагов : " + countPlayerStep +
                " Пройдено " + countMapLevel + " уровней.");
    }

    public static void gameCycle() {
        createMap();
        createPlayer(setRandomStartPositionPlayer);
        createEnemies();
        pointExit();

        // зацикливаем передвижения игрока при помощи цикла while и проверяем при этом уровень здоровья игрока
        // и заполнение (прохождение) игроком карты
        while (true) {
            printMap();
            System.out.println("Текущий уровень здоровья игрока - " + healthPlayer + " Количество пройденных шагов - " + countPlayerStep);
            changingPlayerPosition();

            if (!isPlayerAlive()) {
                System.out.println("Игрок погиб!");
                break;
            }

            if (isFullMap()) {
                System.out.println("Задание выполнено! Вы победили!");
                break;
            }

            if (exitPoint) {
                System.out.println("БОНУС! Игрок перешёл на следующий уровень!");
                break;
            }
        }
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
    public static void printMap() {
        System.out.println("***** ТЕКУЩАЯ КАРТА *****");
        for (int y = 0; y < heightMap; y++) {
            for (int x = 0; x < widthMap; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("*************************");
    }

    // размещаем игрока на карте
    public static void createPlayer(boolean randomPositionPlayer) {
        if (randomPositionPlayer) { // если передаём в метод true, то игрок размещается на карте рэндомно
            positionPlayerX = randomRange(0, widthMap - 1);
            positionPlayerY = randomRange(0, heightMap - 1);
        } else { // если передаём в метод false, то игрок размещается в центре карты
            positionPlayerX = widthMap / 2;
            positionPlayerY = heightMap / 2;
        }
        map[positionPlayerY][positionPlayerX] = player;
    }

    // размещаем на карте врага (врагов)
    public static void createEnemies() {
        healthEnemy = randomRange(valueEnemyMin, valueEnemyMax); // генерируем уровень здоровья врага
        powerEnemy = randomRange(valueEnemyMin, valueEnemyMax); // генерируем силу нанесения урона врагом

        int enemyPozX; // объявляем переменные в которые передадим координаты врага
        int enemyPozY;

        int countEnemies = (maxMapSize + minMapSize) / 4; // задаём количество врагов на карте в зависимости от размеров карты
        // расставляем врагов на карте применяя цикл for
        for (int i = 0; i < countEnemies; i++) {
            // и do-while, для того чтобы исключить расположение игрока и врага в одной и той же ячейке
            do {
                enemyPozX = random.nextInt(widthMap);
                enemyPozY = random.nextInt(heightMap);
            } while (enemyPozX == positionPlayerX && enemyPozY == positionPlayerY);

            invisibleMap[enemyPozY][enemyPozX] = enemy;
        }
        System.out.println("Количество врагов на карте: " + countEnemies + ". Уровень здоровья врага: " + healthEnemy +
                ". Уровень наносимого урона: " + powerEnemy);
    }

    public static void pointExit() { //метод определения координат точки выхода
        int exitX;
        int exitY;

        do {
            exitX = random.nextInt(widthMap);
            exitY = random.nextInt(heightMap);
        } while (invisibleMap[exitY][exitX] == enemy || map[exitY][exitX] == player);

        invisibleMap[exitY][exitX] = exit;

    }

    // организуем движение игрока по карте
    public static void changingPlayerPosition() {
        int currentX = positionPlayerX;
        int currentY = positionPlayerY;

        int playerMove;

        do {
            //делаем первый шаг игрока по карте
            System.out.print("Введите Ваш ход (UP = " + moveUp + "," +
                    " DOWN = " + moveDown + "," +
                    " LEFT = " + moveLeft + "," +
                    " RIGHT = " + moveRight + "," +
                    " RIGHT UP = " + moveRightUp + "," +
                    " LEFT UP = " + moveLeftUp + "," +
                    " RIGHT DOWN = " + moveRightDown + "," +
                    " LEFT DOWN = " + moveLeftDown + ".) >>> "
            );
            playerMove = scanner.nextInt();

            switch (playerMove) {
                case moveUp:
                    positionPlayerY -= 1;
                    break;
                case moveDown:
                    positionPlayerY += 1;
                    break;
                case moveLeft:
                    positionPlayerX -= 1;
                    break;
                case moveRight:
                    positionPlayerX += 1;
                    break;
                case moveRightUp:
                    positionPlayerY -= 1;
                    positionPlayerX += 1;
                    break;
                case moveLeftUp:
                    positionPlayerY -= 1;
                    positionPlayerX -= 1;
                    break;
                case moveRightDown:
                    positionPlayerY += 1;
                    positionPlayerX += 1;
                    break;
                case moveLeftDown:
                    positionPlayerY += 1;
                    positionPlayerX -= 1;
                    break;
            }
        } while (!isValidNextMove(currentY, currentX, positionPlayerY, positionPlayerX));

        playerActionAfterMove(currentY, currentX, positionPlayerY, positionPlayerX);
        ++countPlayerStep;
    }

    // проверка нахождения игрока в пределах карты
    public static boolean isValidNextMove(int currentY, int currentX, int nextY, int nextX) {
        if (nextY >= 0 && nextY < heightMap && nextX >= 0 && nextX < widthMap) {
            // если игрок сделал ход и остался в пределах карты возвращаем true, т.е. игрок может совершать движение дальше
            System.out.println("Игрок перешел по координатам [ " + (nextY + 1) + " : " + (nextX + 1) + " ] удачно.");
            return true;
        } else {
            // если игрок сделал ход и вышел за пределы карты возвращаем false и возвращаем его на прежнее поле
            positionPlayerY = currentY;
            positionPlayerX = currentX;
            System.out.println("Неверный ход! Повторите ход ещё раз!");
            return false;
        }
    }

    // создаём метод действий игрока после совершения передвижения по карте
    public static void playerActionAfterMove(int currentY, int currentX, int nextY, int nextX) {
        // осуществляем проверку есть ли в ячейке враг
        if (invisibleMap[nextY][nextX] == enemy) { // если в ячейке невидимой карты стоит враг
            healthPlayer -= powerEnemy;
            System.out.println("Вас атаковал враг и нанёс урон " + powerEnemy + ". " +
                    "Уровень Вашего здоровья " + healthPlayer);
        }

        if (invisibleMap[nextY][nextX] == enemy) { // если в ячейке невидимой карты стоит враг, игрок его атакует
            healthEnemy -= powerPlayer;
            System.out.println("Вы атаковали врага и он получили урон " + powerPlayer + ". " +
                    "Уровень здоровья врага " + healthEnemy);
        }

        if (invisibleMap[nextY][nextX] == exit) { // попадание в точку выхода
            exitPoint = true;
        }

        map[positionPlayerY][positionPlayerX] = player;
        invisibleMap[positionPlayerY][positionPlayerX] = readyCell;
        map[currentY][currentX] = readyCell;

    }

    // создаём метод для генерации числа в пределах граничных значений
    public static int randomRange(int min, int max) {
        int diff = max - min;
        int value = random.nextInt(diff + 1);
        return min + value;
    }

    // реализуем метод проверки окончания карты (т.е. окончание игры)
    public static boolean isFullMap() {
        for (int y = 0; y < heightMap; y++) {
            for (int x = 0; x < widthMap; x++) {
                if (map[y][x] == emptyCell)
                    return false;
            }
        }
        return true;
    }

    // реализуем метод проверки жизни игрока (жив игрок ещё или уже склеил ласты...)
    public static boolean isPlayerAlive() {
        return healthPlayer > 0;
    }

}
