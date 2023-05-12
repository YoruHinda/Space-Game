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
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                gamePanel.getGame().getPlayer().left = true;
                break;
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().right = true;
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.getGame().getPlayer().shooting = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                gamePanel.getGame().getPlayer().left = false;
                break;
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().right = false;
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.getGame().getPlayer().shooting = false;
                break;
        }
    }


}
