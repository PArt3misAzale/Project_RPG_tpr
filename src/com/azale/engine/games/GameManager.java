package com.azale.engine.games;

import com.azale.engine.AbstractGame;
import com.azale.engine.GameContainer;
import com.azale.engine.Renderer;
import com.azale.engine.audio.SoundClip;
import com.azale.engine.gfx.ImageTile;

public class GameManager extends AbstractGame {

    private ImageTile cursorImage;
    private int cursorX, cursorY;
    private int CursorFrame = 0;

    private SoundClip menuBackgroundMusic;

    /*

    private boolean isWritting;
    private String[] mainText = new String[26];
    int mainTextLine = 0;

     */

    public GameManager() {

        cursorImage = new ImageTile("/images/cursor/cursorImage.png", 6, 6);

        menuBackgroundMusic = new SoundClip("/sounds/background sounds/menu/menu_background_music.wav");
        menuBackgroundMusic.setVolume(-20f);

    }


    @Override
    public void update(GameContainer gc, float dt) {

        //mainTextLine = gc.getInput().getKeysToWrite(isWritting, mainText, mainTextLine);

        cursorX = gc.getInput().getMouseX();
        cursorY = gc.getInput().getMouseY();

        if (!menuBackgroundMusic.isRunning()) {

            menuBackgroundMusic.loop();

        }


    }

    @Override
    public void render(GameContainer gc, Renderer r) {

        /*

        for (int i = 0; i < mainText.length; i++) {

            if (mainText[i] != null) {

                gc.renderer.drawText14P(mainText[i], 100, 100 + i * (int)gc.getScale() * 12, 0xff00ff00);

            } else {

                mainText[i] = "";

            }

        }

         */

        // UI
        r.drawRect(100, 100, 64, 64, 0xffff0000);
        r.drawfillRect(116, 116, 32, 32, 0xff00ff00);

        // ON ALL THINGS
        r.drawImageTile(cursorImage, cursorX, cursorY, CursorFrame, 0);

        if (gc.showSpecs) {

            gc.renderer.drawText6P("FPS : " + gc.fps, 0, 0, 0xff00ffff);
            gc.renderer.drawText6P("Mouse coordinates : ( " + cursorX + " ; " + cursorY + " )",0, 10, 0xff00ffff);
            gc.renderer.drawText6P("(hide)", 0, 20, 0xff00ffff);

        } else {

            gc.renderer.drawText6P("(show)", 0, 0, 0xff00ffff);

        }

    }

    public static void main(String[] args) {

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();

    }
}
