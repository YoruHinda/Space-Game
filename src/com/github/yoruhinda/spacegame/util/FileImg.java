package com.github.yoruhinda.spacegame.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class FileImg {
    public static final String BACKGROUND = "background.jpg";
    public static final String ASTEROID = "Asteroid.png";
    public static final String PLAYER = "Player.png";
    public static final String SECOND_PLAYER = "PlayerCoop.png";


    public static Image getImage(String imageName) {
        BufferedImage image = null;
        InputStream resourceAsStream = FileImg.class.getResourceAsStream("/resources/"+imageName);
        try  {

                image = ImageIO.read(resourceAsStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
