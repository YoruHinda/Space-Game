package com.github.yoruhinda.spacegame.entity;

import java.awt.*;

public abstract class Entity {
    protected int x;
    protected int y;

    public Entity(int x,int y){
        this.x = x;
        this.y = y;
    }

    protected void update(){

    }

    protected void render(Graphics g){

    }
}
