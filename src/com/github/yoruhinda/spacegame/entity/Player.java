package com.github.yoruhinda.spacegame.entity;

import com.github.yoruhinda.spacegame.util.FileImg;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
    private float playerSpeed = 5f;
    private BufferedImage playerSprite = FileImg.getImage(FileImg.SECOND_PLAYER);
    private List<Bullet> bullets = new ArrayList<>();
    private long timeOfLastProjectile;
    public boolean left, right, shooting;

    public Player(int x, int y) {
        super(x, y);
    }

    public void update() {
        move();
        shoot();
        for (int i = 0; i < bullets.size(); i++){
            Bullet bullet = bullets.get(i);
            if (bullet.getY() < 0) {
                bullets.remove(bullet);
            }
            bullet.tick();
        }
    }

    public void render(Graphics g) {
        g.drawImage(playerSprite, x, y,null);
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.render(g);
        }
    }

    public void shoot() {
        long timeNow = System.currentTimeMillis();
        long time = timeNow - timeOfLastProjectile;
        if (time < 0 || time > 150) {
            timeOfLastProjectile = timeNow;
            if (shooting) {
                bullets.add(new Bullet(x + 48, y - 20));
            }
        }
    }

    public void move() {
        if (x >= 490) {
            x = 490;
        } else if (x <= 10) {
            x = 10;
        }
        if (left && !right) {
            x -= playerSpeed;
        }
        if (right && !left) {
            x += playerSpeed;
        }
    }

    public List<Bullet> getBullets() {
        return bullets;
    }
}
