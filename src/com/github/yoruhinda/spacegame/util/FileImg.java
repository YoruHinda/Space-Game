package com.github.yoruhinda.spacegame.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class FileImg {
    public static final String BACKGROUND = "Background.jpg";
    public static final String ASTEROID = "Asteroid.png";
    public static final String FIRST_PLAYER = "FirstPlayer.png";
    public static final String SECOND_PLAYER = "SecondPlayer.png";
    public static final String ICON = "Icon.png";


    public static BufferedImage getImage(String imageName) {
        BufferedImage image = null;
        InputStream resourceAsStream = FileImg.class.getResourceAsStream("/resources/" + imageName);
        try {
            if (resourceAsStream != null) {
                image = ImageIO.read(resourceAsStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
