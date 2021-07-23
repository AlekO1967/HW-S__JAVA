package ru.geekbrains.lesson_2.hw;

public class HomeWork_2 {
    public static void main(String[] args) {
        System.out.println(within10and20(5, 5));

        System.out.println("********************");

        PositiveOrNegative1(1967);

        System.out.println("********************");

        String result = (PositiveOrNegative2(-1967)) ? "false" : "true";
        System.out.println(result);

        System.out.println("********************");

        MethodPrintResultLoop("Привет участникам соревнований!" , 5);

        System.out.println("********************");

        int currentYear = 2021;
        System.out.println("Is " + currentYear + " year leap? " + HowIsYear(currentYear));
    }

    public static boolean within10and20(int x1, int x2) {
        int sum = x1 + x2;
        return (sum <= 20) && (sum >= 10);
    }

    public static void PositiveOrNegative1(int variable) {
        if (variable >= 0) {
            System.out.println(variable + " is positive");
        } else {
            System.out.println(variable + " is negative");
        }
    }

    public static boolean PositiveOrNegative2(int a) {
        return a >= 0;
    }

    public static void MethodPrintResultLoop(String value, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Приветствие № " + i + ": " + value);
        }
    }

    public static boolean HowIsYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }
}
