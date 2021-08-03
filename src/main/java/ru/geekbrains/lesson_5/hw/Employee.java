package ru.geekbrains.lesson_5.hw;

public class Employee {
    private String fullName;
    private String position;
    private String eMail;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String eMail, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    void printToConsole() {
        System.out.println("Имя сотрудника: " + fullName + "; Должность: " + position + "; EMail: " + eMail +
                "; Номер телефона: " + phone + "; Заработная плата: " + salary + "; Возраст: " + age);

    }

    public int getAge() {
        return age;
    }

}
