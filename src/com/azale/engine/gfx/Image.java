package com.azale.engine.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {

    private int w, h;
    private int[] p;

    public Image(String path) {

        BufferedImage image = null;

        try {

            image = ImageIO.read(Image.class.getResourceAsStream(path));

        } catch (IOException e) {

            e.printStackTrace();

        }

        w = image.getWidth();
        h = image.getHeight();
        p = image.getRGB(0, 0, w, h, null, 0, w);

        image.flush();

    }

    /*

    GETTERS AND SETTERS

     */

    // WIDTH
    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    // HEIGHT
    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    // PIXELS
    public int[] getP() {
        return p;
    }

    public void setP(int[] p) {
        this.p = p;
    }

}
