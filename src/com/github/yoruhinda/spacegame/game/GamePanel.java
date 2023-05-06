package com.github.yoruhinda.spacegame.game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final int WIDTH = 600, HEIGHT = 600;
    private Game game;

    public GamePanel(Game game){
        this.game = game;
        initialize();
    }

    public void initialize(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }

    public Game getGame() {
        return game;
    }
}
