package ru.geekbrains.lesson_6.hw;

public class Animals {
    private String breed;
    private String name;
    private int maxRun;
    private int maxSwim;
    private int distanceRun;
    private int distanceSwim;
    public static int countAnimal = 0;

    public Animals(String breed, String name, int maxRun, int maxSwim) {
        this.breed = breed;
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;
        countAnimal++;
    }

    void run(int distance) {
        if (distanceRun + distance < maxRun) {
            distanceRun += distance;
            System.out.println(breed + " " + name + " пробежала " + distanceRun + " метров");
        } else {
            distanceRun = maxRun;
            System.out.println(breed + " " + name + " справилась с дистанцией!");
        }
    }

    void swim(int distance) {
        if (distanceSwim + distance < maxSwim) {
            distanceSwim += distance;
            System.out.println(breed + " " + name + " проплыла " + distanceSwim+ " метров");
        } else {
            distanceSwim = maxSwim;
            System.out.println(breed + " " + name + " справилась с дистанцией!");
        }
    }

    public static int getNumOfInstances() {

        return countAnimal;
    }


}