package com.github.yoruhinda.spacegame.game;

import com.github.yoruhinda.spacegame.game.handlers.KeyHandler;
import com.github.yoruhinda.spacegame.util.FileImg;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    private final int WIDTH = 600, HEIGHT = 600;
    private BufferedImage background = FileImg.getImage(FileImg.BACKGROUND);
    private KeyHandler keyHandler;
    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        keyHandler = new KeyHandler(this);
        initialize();
    }

    public void initialize() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(keyHandler);
        setFocusable(true);
        requestFocus();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
        game.render(g);
    }

    public Game getGame() {
        return game;
    }
}
