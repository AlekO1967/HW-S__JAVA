package ru.geekbrains.lesson_5.hw;

public class HomeWork_5 {
    public static void main(String[] args) {

        Employee[] persArray = new Employee[5];

        persArray[0] = new Employee("Ivanov Ivan", "developer", "ivanov@email.com",
                "89001234567", 30000, 30);
        persArray[1] = new Employee("Petrov Petr", "engneer", "petrov@email.com",
                "89002345678", 35000, 33);
        persArray[2] = new Employee("Sidorov Sidor", "analist", "sidorov@email.com",
                "893456789", 38000, 40);
        persArray[3] = new Employee("Gavrilov Gavrila", "developer", "gavrilov@email.com",
                "894567890", 40000, 42);
        persArray[4] = new Employee("Rasputin Grigory", "medium", "rasputin@medium.net",
                "no_phone", 100000, 152);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                persArray[i].printToConsole();
            }
        }
    }
}
