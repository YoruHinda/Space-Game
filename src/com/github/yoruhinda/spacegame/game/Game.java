package com.github.yoruhinda.spacegame.game;

import java.awt.*;

public class Game extends Thread {
    private boolean running = true;
    private final int MAX_FPS = 60;
    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game() {
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        startGameLoop();
    }

    public void startGameLoop(){
        start();
    }

    public void update(){

    }

    public void render(Graphics g){

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
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }
}
