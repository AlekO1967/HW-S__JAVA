package ru.geekbrains.lesson_7.hw;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private int winWidth = 1024;  // задаем размеры окна,
    private int winHeight = 768;  // размеры окна указываются в пикселях.
    private int winPozX = 250;  // задаём начальную координату окна по оси X
    private int winPozY = 25;  // задаём начальную координату окна по оси Y

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

    private JPanel enemyInfo;
    private JLabel enemyType;
    private JLabel enemyHealthInfo;

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
        gui.setLayout(new GridLayout(6, 1));

        prepareGameControls();
        prepareGameInfo();
        preparePlayerInfo();
        prepareEnemyInfo();
        preparePlayerAction();
        prepareGameActionsLog();

        gui.add(gameControl);
        gui.add(gameInfo);
        gui.add(playerInfo);
        gui.add(enemyInfo);
        gui.add(playerAction);
        gui.add(areaForGameLogs, BorderLayout.SOUTH);
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
        gameInfo.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        gameRoundInfo = new JLabel("Current round: ");
        mapSizeInfo = new JLabel("Current size map: ");
        countEnemyInfo = new JLabel("Current enemy count: ");

        gameInfo.add(new JLabel("***** Game Info *****"));
        gameInfo.add(gameRoundInfo);
        gameInfo.add(mapSizeInfo);
        gameInfo.add(countEnemyInfo);

    }

    private void preparePlayerInfo() {
        playerInfo = new JPanel();
        playerInfo.setLayout(new GridLayout(3, 1));
        playerInfo.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        playerHealthInfo = new JLabel("Current health: -");
        playerStepsInfo = new JLabel("Current step: -");

        playerInfo.add(new JLabel("***** Player Info *****"));
        playerInfo.add(playerHealthInfo);
        playerInfo.add(playerStepsInfo);

    }

    private void prepareEnemyInfo() {
        enemyInfo = new JPanel();
        enemyInfo.setLayout(new GridLayout(3, 1));
        enemyInfo.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        enemyType = new JLabel("Enemy type: -");
        enemyHealthInfo = new JLabel("Health enemy: -");

        enemyInfo.add(new JLabel("***** Enemy Info *****"));
        enemyInfo.add(enemyType);
        enemyInfo.add(enemyHealthInfo);
    }

    private void preparePlayerAction() {
        playerAction = new JPanel();
        playerAction.setLayout(new GridLayout(3, 3));
        playerAction.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        moveUp = new JButton("\uD83E\uDC81");
        moveDown = new JButton("\uD83E\uDC83");
        moveLeft = new JButton("\uD83E\uDC80");
        moveRight = new JButton("\uD83E\uDC82");
        moveUpRight = new JButton("\uD83E\uDC85");
        moveDownRight = new JButton("\uD83E\uDC86");
        moveUpLeft = new JButton("\uD83E\uDC84");
        moveDownLeft = new JButton("\uD83E\uDC87");

        playerAction.add(moveUpLeft);
        playerAction.add(moveUp);
        playerAction.add(moveUpRight);
        playerAction.add(moveLeft);
        playerAction.add(new JPanel());
        playerAction.add(moveRight);
        playerAction.add(moveDownLeft);
        playerAction.add(moveDown);
        playerAction.add(moveDownRight);

    }

    private void prepareGameActionsLog() {
        gameLogs = new JTextArea("Current logs game");
        areaForGameLogs = new JScrollPane(gameLogs); // устанавливаем управление, чтобы ScrollPane управляла GameLogs
        gameLogs.setEditable(false); // запрещаем редактирование логов, gameLogs только для чтения
        gameLogs.setLineWrap(true); // устанавливаем запись каждого слова лога в отдельную строку
    }

    private void prepareWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); // вызываем метод дефолтной операции по закрытию окна
        setLocation(winPozX, winPozY);  // вызываем метод создания окна с установленными размерами
        setSize(winWidth, winHeight);  // вызываем метод позиционирования окна на экране
        setTitle("Graphic Interface Game");  // выводим в окно Title
        setResizable(false);  // запрещаем пользователю изменять размер окна.
    }

}
