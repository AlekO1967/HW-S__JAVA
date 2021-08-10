package ru.geekbrains.lesson_7.hw;

import javax.swing.*;

public class GameWindow extends JFrame {

    GameWindow() {
        System.out.println("Hello! I'm window.");

        setDefaultCloseOperation(EXIT_ON_CLOSE); // вызываем метод дефолтной операции по закрытию окна
        setVisible(true); // вызываем метод открытия окна
    }

}
