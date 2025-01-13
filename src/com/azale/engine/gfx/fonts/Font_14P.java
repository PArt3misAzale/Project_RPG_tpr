package com.azale.engine.gfx.fonts;

import com.azale.engine.gfx.Image;

public class Font_14P {

    public static final Font_14P STANDARD = new Font_14P("/fonts/standard_14p.png");

    private Image fontImage;
    private int[] offsets;
    private int[] widths;

    public Font_14P(String path) {

        fontImage = new Image(path);

        offsets = new int[95];
        widths = new int[95];

        int unicode = 0;

        for (int i = 0; i < fontImage.getW(); i ++) {

            if (fontImage.getP()[i] == 0xff0000ff) {

                offsets[unicode] = i;

            }

            if (fontImage.getP()[i] == 0xffffff00) {

                widths[unicode] = i - offsets[unicode];
                unicode ++;

            }

        }

    }

    /*

    GETTERS AND SETTERS

     */

    // FONT IMAGE
    public Image getFontImage() {
        return fontImage;
    }

    public void setFontImage(Image fontImage) {
        this.fontImage = fontImage;
    }

    // OFFSETS
    public int[] getOffsets() {
        return offsets;
    }

    public void setOffsets(int[] offsets) {
        this.offsets = offsets;
    }

    // WIDTHS
    public int[] getWidths() {
        return widths;
    }

    public void setWidths(int[] widths) {
        this.widths = widths;
    }
}
