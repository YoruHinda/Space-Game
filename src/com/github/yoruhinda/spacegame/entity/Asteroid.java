package com.github.yoruhinda.spacegame.entity;

import com.github.yoruhinda.spacegame.util.FileImg;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Asteroid{
    private float asteroidSpeed = 2f;
    private BufferedImage asteroid = FileImg.getImage(FileImg.ASTEROID);
    private int x;
    private int y;

    public Asteroid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tick(){
        y += asteroidSpeed;
    }

    public void render(Graphics g){
        g.drawImage(asteroid, x, y,null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
