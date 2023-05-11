package com.github.yoruhinda.spacegame.game;

import com.github.yoruhinda.spacegame.entity.Player;

import java.awt.*;

public class Game extends Thread {
    private boolean running = true;
    private final int MAX_FPS = 60;
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Player player = new Player(10,490);

    public Game() {
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        startGameLoop();
    }

    public void startGameLoop(){
        start();
    }

    public void update(){
        player.update();
    }

    public void render(Graphics g){
        player.render(g);
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / MAX_FPS;
        long lastFrame = System.nanoTime();
        long now;

        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        while (running) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                update();
                lastFrame = now;
                frames++;
            }
            gamePanel.repaint();
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }

    public Player getPlayer() {
        return player;
    }
}
