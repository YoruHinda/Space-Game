package com.github.yoruhinda.spacegame.entity;

import com.github.yoruhinda.spacegame.util.FileImg;

import java.awt.*;

public class Player extends Entity{
    private float playerSpeed = 5f;
    public boolean left, right;

    public Player(int x, int y) {
        super(x, y);
    }

    public void update(){
        move();
    }

    public void render(Graphics g){
        g.drawImage(FileImg.getImage(FileImg.FIRST_PLAYER), x, y, 100,100,null);
    }

    public void move(){
        if(x >= 490){
            x = 490;
        }else if(x <= 10){
            x = 10;
        }
        if(left && !right){
            x -= playerSpeed;
        }
        if(right && !left){
            x += playerSpeed;
        }
    }
}
