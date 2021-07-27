package ru.geekbrains.lesson_3.hw;


public class HomeWork_3 {
    public static void main(String[] args) {

        System.out.println("Task № 1");
        int[] array1 = {1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0};
        printArrayFirst("Before:\t", array1);
        change(array1);
        printArrayFirst("After:\t", array1);

        System.out.println("===============");

        System.out.println("Task № 2");
        int[] array2 = new int[100];
        fillIn(array2);
        printArrayFirst("Array is filled:\t", array2);

        System.out.println("===============");

        System.out.println("Task № 3");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArrayFirst("Before:\t", array3);
        doubling(array3);
        printArrayFirst("After:\t", array3);

        System.out.println("===============");

        System.out.println("Task № 4");
        int side = 5;
        int[][] array4 = new int[side][side];
        crossFill(array4);
        printArraySecond("Result fill diagonals", array4);

        System.out.println("===============");

        System.out.println("Task № 5");
        int[] returnArrayFromMethod = returnArray(10, 123);
        printArrayFirst("Array from method", returnArrayFromMethod);

        System.out.println("===============");

        System.out.println("Task № 6");
        printArrayFirst("Find min & max in array\t", array3);
        System.out.println("Minimum: " + findMin(array3));
        System.out.println("Maximum: " + findMax(array3));

    }

    public static void printArrayFirst(String msg, int[] inputArray) {
        System.out.print(msg + ": ");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }

    public static void printArraySecond(String msg, int[][] inputArray) {
        System.out.println(msg);
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void change(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
    }

    public static void fillIn(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;
    }

    public static void doubling(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6)
                array[i] *= 2;
    }

    public static void crossFill(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
    }

    public static int[] returnArray(int len, int initValue) {
        int[] tempArray = new int[len];

        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = initValue;
        }
        return tempArray;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
