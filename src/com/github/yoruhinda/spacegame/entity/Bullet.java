package com.github.yoruhinda.spacegame.entity;

import java.awt.*;

public class Bullet {
    private int x;
    private int y;
    private float bulletSpeed = 10f;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tick() {
        y -= bulletSpeed;
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 2, 20);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
