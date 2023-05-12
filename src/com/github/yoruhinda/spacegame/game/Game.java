package com.github.yoruhinda.spacegame.game;

import com.github.yoruhinda.spacegame.entity.Asteroid;
import com.github.yoruhinda.spacegame.entity.Bullet;
import com.github.yoruhinda.spacegame.entity.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends Thread {
    private boolean running = true;
    private final int MAX_FPS = 60;
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private List<Asteroid> asteroids = new ArrayList<>();
    private Player player = new Player(10, 490);

    public Game() {
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        startGameLoop();
    }

    public void startGameLoop() {
        start();
    }

    public void update() {
        player.update();
        if (asteroids.size() <= 5) {
            asteroids.add(new Asteroid(ThreadLocalRandom.current().nextInt(500), 0));
        }
        if (asteroids.size() != 0) {
            for (int i = 0; i < asteroids.size(); i++) {
                Asteroid asteroid = asteroids.get(i);
                if (asteroid.getY() > 600) {
                    asteroids.remove(asteroid);
                }
                asteroid.tick();
            }
        }
        for (int i = 0; i < player.getBullets().size(); i++) {
            Bullet bullet = player.getBullets().get(i);
            for (int j = 0; j < asteroids.size(); j++) {
                Asteroid asteroid = asteroids.get(j);
                if (((asteroid.getX() > bullet.getX() && asteroid.getX() < bullet.getX() + 2)
                        && (asteroid.getY() > bullet.getY() && asteroid.getY() < bullet.getY() + 20))
                        || ((bullet.getX() > asteroid.getX() && bullet.getX() < asteroid.getX() + 70)
                        && (bullet.getY() > asteroid.getY() && bullet.getY() < asteroid.getY() + 70))) {
                    player.getBullets().remove(bullet);
                    asteroids.remove(asteroid);
                }
            }
        }
    }

    public void render(Graphics g) {
        player.render(g);
        for (int i = 0; i < asteroids.size(); i++) {
            Asteroid asteroid = asteroids.get(i);
            asteroid.render(g);
        }
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
            if (System.currentTimeMillis() - lastCheck >= 1000) {
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
