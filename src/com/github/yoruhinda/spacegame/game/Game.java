package com.github.yoruhinda.spacegame.game;

import javax.swing.*;

public class Game extends JFrame {
    private GamePanel gamePanel = new GamePanel();

    public Game(){
        initialize();
    }

    public void initialize(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Space Game");
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
