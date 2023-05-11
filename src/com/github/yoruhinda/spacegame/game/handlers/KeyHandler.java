package com.github.yoruhinda.spacegame.game.handlers;

import com.github.yoruhinda.spacegame.game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GamePanel gamePanel;

    public KeyHandler(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
            gamePanel.getGame().getPlayer().left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            gamePanel.getGame().getPlayer().right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
            gamePanel.getGame().getPlayer().left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            gamePanel.getGame().getPlayer().right = false;
        }
    }
}
