package ru.geekbrains.lesson_6.hw;

public class HomeWork_6 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Golden Retriver", "Origami", 500, 10, 0, 0);
        Dog dog2 = new Dog("Golden Retriver", "Little Miracle", 500, 10, 0, 0);
        Cat cat1 = new Cat("Maikun", "Nova", 200, 0, 0, 0);
        Cat cat2 = new Cat("SredneRusskaia", "Murka", 200, 0, 0, 0);

        dog1.run(350);
        dog1.swim(8);
        dog2.run(500);
        dog2.swim(10);
        cat1.run(150);
        cat1.swim(0);
        cat2.run(200);
        cat2.swim(0);

        System.out.println("Всего создано " + Animals.getNumOfInstances() + " животных");

    }
}
