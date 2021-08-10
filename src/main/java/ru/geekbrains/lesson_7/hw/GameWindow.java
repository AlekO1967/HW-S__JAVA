package ru.geekbrains.lesson_7.hw;

import javax.swing.*;

public class GameWindow extends JFrame {

    private int winWidth = 800;  // задаем размеры окна,
    private int winHeight = 600;  // размеры окна указываются в пикселях.
    private int winPozX = 350;  // задаём начальную координату окна по оси X
    private int winPozY = 100;  // задаём начальную координату окна по оси Y

    GameWindow() {
        prepareWindow();

        setVisible(true); // вызываем метод открытия окна
    }

    private void prepareWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); // вызываем метод дефолтной операции по закрытию окна
        setLocation(winPozX, winPozY);  // вызываем метод создания окна с установленными размерами
        setSize(winWidth, winHeight);  // вызываем метод позиционирования окна на экране
        setTitle("Graphic Interface Game");  // выводим в окно Title
        setResizable(false);  // запрещаем пользователю изменят размер окна.
    }
}
