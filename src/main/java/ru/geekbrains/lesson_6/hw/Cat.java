package ru.geekbrains.lesson_6.hw;

public class Cat extends Animals {

    public Cat(String breed, String name, int maxRun, int maxSwim, int distanceRun, int distanceSwim) {
        super(breed, name, maxRun, maxSwim, distanceRun, distanceSwim);
    }

    void swim(int length) {
        System.out.println("Кошки плавать не умеют!");
    }

}
