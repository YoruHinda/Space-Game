package com.github.yoruhinda.spacegame.game.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean left, right;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
            left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
            left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            right = false;
        }
    }
}
