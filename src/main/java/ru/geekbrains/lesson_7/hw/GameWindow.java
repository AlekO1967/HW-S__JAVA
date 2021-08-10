package ru.geekbrains.lesson_7.hw;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private int winWidth = 800;  // задаем размеры окна,
    private int winHeight = 600;  // размеры окна указываются в пикселях.
    private int winPozX = 350;  // задаём начальную координату окна по оси X
    private int winPozY = 100;  // задаём начальную координату окна по оси Y

    private GameMap map; // создаём переменную GameMap
    private JPanel gui;

    private JPanel gameControl;
    private JButton btnStartGame;
    private JButton btnExitGame;
    private JButton btnRestartGame;

    private JPanel gameInfo;
    private JLabel mapSizeInfo;
    private JLabel countEnemyInfo;
    private JLabel gameRoundInfo;

    private JPanel playerInfo;
    private JLabel playerHealthInfo;
    private JLabel playerStepsInfo;

    private JPanel playerAction;
    private JButton moveUp;
    private JButton moveDown;
    private JButton moveLeft;
    private JButton moveRight;
    private JButton moveUpRight;
    private JButton moveDownRight;
    private JButton moveUpLeft;
    private JButton moveDownLeft;

    private JScrollPane areaForGameLogs;
    private JTextArea gameLogs;


    GameWindow() {
        prepareWindow();

        map = new GameMap(); // в конструкторе создаём объект

        prepareGUI();

        add(gui, BorderLayout.EAST);
        add(map);


        setVisible(true); // вызываем метод открытия окна
    }

    private void prepareGUI() {       // создаём метод для управления графическим интерфейсом пользователя (GUI)
        gui = new JPanel();
        gui.setLayout(new GridLayout(5, 1));

        prepareGameControls();
        prepareGameInfo();
        preparePlayerInfo();
        preparePlayerAction();
        prepareGameActionsLog();

        gui.add(gameControl);
        gui.add(gameInfo);
    }


    private void prepareGameControls() {
        gameControl = new JPanel();
        gameControl.setLayout(new GridLayout(3, 1));
        btnStartGame = new JButton("Start Game!"); // создаем кнопки
        btnExitGame = new JButton("Exit Game! ");
        btnRestartGame = new JButton("Restart Game");

        gameControl.add(btnStartGame);
        gameControl.add(btnExitGame);
        gameControl.add(btnRestartGame);


    }

    private void prepareGameInfo() {
        gameInfo = new JPanel();
        gameInfo.setLayout(new GridLayout(4, 1));

        gameRoundInfo = new JLabel("Current round: ");
        mapSizeInfo = new JLabel("Current size map: ");
        countEnemyInfo = new JLabel("Current enemy count: ");

        gameInfo.add(new JLabel("***** Game Info *****"));
        gameInfo.add(gameRoundInfo);
        gameInfo.add(mapSizeInfo);
        gameInfo.add(countEnemyInfo);


    }

    private void preparePlayerInfo() {

    }

    private void preparePlayerAction() {

    }

    private void prepareGameActionsLog() {

    }

    private void prepareWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); // вызываем метод дефолтной операции по закрытию окна
        setLocation(winPozX, winPozY);  // вызываем метод создания окна с установленными размерами
        setSize(winWidth, winHeight);  // вызываем метод позиционирования окна на экране
        setTitle("Graphic Interface Game");  // выводим в окно Title
        setResizable(false);  // запрещаем пользователю изменят размер окна.
    }

}
