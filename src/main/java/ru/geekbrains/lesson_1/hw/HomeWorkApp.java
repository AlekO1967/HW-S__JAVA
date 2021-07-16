package ru.geekbrains.lesson_1.hw;

import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void printThreeWords() {
        System.out.println("_Orange");
        System.out.println("_ Banana");
        System.out.println("_ Apple");
    }

    private static void checkSumSign() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter please first number");
        int a = scanner.nextInt();
        System.out.println("Enter please second number");
        int b = scanner.nextInt();
        int c = a + b;

        if (c > 0) {
            System.out.println("This amount is positive " + c);
        } else if (c == 0) {
            System.out.println("This amount is " + c);
        } else {
            System.out.println("This amount is negative " + c);
        }
    }

    private static void printColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter please number");
        int value = scanner.nextInt();
        if (value <= 0) {
            System.out.println("Color is red.");
        } else if (value > 0 && value <= 100) {
            System.out.println("Color is yellow.");
        } else {
            System.out.println("Color is green.");
        }
    }

    private static void compareNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter please number a");
        int a = scanner.nextInt();
        System.out.println("Enter please number b");
        int b = scanner.nextInt();
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
