package ru.geekbrains.lesson_6.hw;

public class Cat extends Animals {

    public Cat(String breed, String name, int maxRun, int maxSwim) {
        super(breed, name, maxRun, maxSwim);
    }

    void swim(int length) {
        System.out.println("Кошки плавать не умеют!");
    }

}
