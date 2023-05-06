package com.github.yoruhinda.spacegame.game;

import javax.swing.*;

public class GameWindow extends JFrame {
    private GamePanel gamePanel;

    public GameWindow(GamePanel gamePanel){
        this.gamePanel = gamePanel;
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
