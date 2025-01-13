package com.azale.engine;

import com.azale.engine.gfx.Image;
import com.azale.engine.gfx.ImageTile;
import com.azale.engine.gfx.fonts.Font_14P;
import com.azale.engine.gfx.fonts.Font_6P;

import java.awt.image.DataBufferInt;

public class Renderer {

    private int pW, pH;
    private int[] p;

    private Font_6P font_standard_6p = Font_6P.STANDARD;
    private Font_14P font_standard_14p = Font_14P.STANDARD;

    public Renderer(GameContainer gc) {

        pW = gc.getWidth();
        pH = gc.getHeight();

        p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();

    }

    public void clear() {

        for (int i =0; i < p.length; i++) {

            p[i] = 0;

        }

    }

    public void setPixel(int x, int y, int value) {

        if (x < 0 || x >= pW || y < 0 || y >= pH || value == 0xffff00ff ) {

            return;

        }

        p[x + y * pW] = value;

    }

    public void drawImage(Image image, int offX, int offY) {

        // DON'T RENDER CODE
        if (offX < -image.getW()) return;
        if (offY < -image.getH()) return;

        if (offX >= pW) return;
        if (offY >= pH) return;

        //
        int newX = 0;
        int newY = 0;
        int newWidth = image.getW();
        int newHeight = image.getH();

        // CLIPPING CODE
        if (newX + offX < 0) {

            newX -= offX;

        }

        if (newY + offY < 0) {

            newY -= offY;

        }

        if (newWidth + offX > pW) {

            newWidth -= newWidth + offX - pW;

        }

        if (newHeight + offY > pH) {

            newHeight -= newHeight + offY - pH;

        }

        // RENDER IMAGE
        for (newY = 0; newY < newHeight; newY++) {

            for (newX = 0; newX < newWidth; newX ++) {

                setPixel(newX + offX, newY + offY, image.getP()[newX + newY * image.getW()]);

            }

        }

    }

    public void drawText6P(String text, int offX, int offY, int color) {

        text = text.toUpperCase();
        int offset = 0;

        for (int i = 0; i < text.length(); i ++) {

            int unicode = text.codePointAt(i) - 32;

            for (int y = 0; y < font_standard_6p.getFontImage().getH(); y++) {

                for (int x = 0; x < font_standard_6p.getWidths()[unicode]; x++) {

                    if (font_standard_6p.getFontImage().getP()[(x + font_standard_6p.getOffsets()[unicode]) + y * font_standard_6p.getFontImage().getW()] == 0xffffffff) {

                        setPixel(x + offX + offset, y + offY, color);

                    }

                }

            }

            offset += font_standard_6p.getWidths()[unicode];

        }

    }

    public void drawText14P(String text, int offX, int offY, int color) {

        int offset = 0;

        for (int i = 0; i < text.length(); i ++) {

            int unicode = text.codePointAt(i) - 32;

            for (int y = 0; y < font_standard_14p.getFontImage().getH(); y++) {

                for (int x = 0; x < font_standard_14p.getWidths()[unicode]; x++) {

                    if (font_standard_14p.getFontImage().getP()[(x + font_standard_14p.getOffsets()[unicode]) + y * font_standard_14p.getFontImage().getW()] == 0xffffffff) {

                        setPixel(x + offX + offset, y + offY, color);

                    }

                }

            }

            offset += font_standard_14p.getWidths()[unicode];

        }

    }

    public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY) {

        // DON'T RENDER CODE
        if (offX < -image.getTileW()) return;
        if (offY < -image.getTileH()) return;

        if (offX >= pW) return;
        if (offY >= pH) return;

        //
        int newX = 0;
        int newY = 0;
        int newWidth = image.getTileW();
        int newHeight = image.getTileH();

        // CLIPPING CODE
        if (newX + offX < 0) {

            newX -= offX;

        }

        if (newY + offY < 0) {

            newY -= offY;

        }

        if (newWidth + offX > pW) {

            newWidth -= newWidth + offX - pW;

        }

        if (newHeight + offY > pH) {

            newHeight -= newHeight + offY - pH;

        }

        // RENDER IMAGE
        for (newY = 0; newY < newHeight; newY++) {

            for (newX = 0; newX < newWidth; newX ++) {

                setPixel(newX + offX, newY + offY, image.getP()[(newX + tileX * image.getTileW()) + (newY + tileY * image.getTileH()) * image.getW()]);

            }

        }

    }

    public void drawRect(int offX, int offY, int width, int height, int color) {

        // RENDER
        for (int y = 0; y <= height; y ++) {

            setPixel(offX, y + offY, color);
            setPixel(offX + width, y + offY, color);

        }

        for (int x = 0; x <= width; x++) {

            setPixel(x + offX, offY, color);
            setPixel(x + offX, offY + height, color);

        }

    }

    public void drawfillRect(int offX, int offY, int width, int height, int color) {

        // DON'T RENDER CODE
        if (offX < -width) return;
        if (offY < -height) return;

        if (offX >= pW) return;
        if (offY >= pH) return;

        //
        int newX = 0;
        int newY = 0;
        int newWidth = width;
        int newHeight = height;

        // CLIPPING CODE
        if (newX + offX < 0) {

            newX -= offX;

        }

        if (newY + offY < 0) {

            newY -= offY;

        }

        if (newWidth + offX > pW) {

            newWidth -= newWidth + offX - pW;

        }

        if (newHeight + offY > pH) {

            newHeight -= newHeight + offY - pH;

        }

        // RENDER
        for (int y = newY; y <= newHeight; y ++) {

            for (int x = newX; x <= newWidth; x++) {

                setPixel(x + offX, y + offY, color);

            }

        }

    }

}
