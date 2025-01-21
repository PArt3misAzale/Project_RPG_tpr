package com.azale.engine;

import com.azale.engine.inputs.Input;

public class GameContainer implements Runnable {

    private Thread thread;
    private Window window;
    public Renderer renderer;
    private Input input;

    private static AbstractGame game;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;

    private int width = 1600; // 16 * 75
    private int height = 900; // 9 *
    private float scale = 1;
    private String title = "Azale Engine v1.0";

    //
    public int fps = 0;

    public boolean showSpecs = true;

    public GameContainer(AbstractGame game) {

        this.game = game;

    }

    public void start() {

        window = new Window(this);

        renderer = new Renderer(this);

        input = new Input(this);

        thread = new Thread(this);
        thread.run();

    }

    public void stop() {



    }

    public void run() {

        running = true;

        boolean render = false;

        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passTime = 0;
        double unProcessedTime = 0;

        double frameTime = 0;
        int frames = 0;

        // TEST VARIABLES

        String text = "Put text : ";

        int i = 0;
        // END OF TEST VARIABLES

        while (running) {

            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passTime = firstTime - lastTime;
            lastTime = firstTime;

            unProcessedTime += passTime;

            frameTime += passTime;

            while (unProcessedTime >= UPDATE_CAP) {

                unProcessedTime -= UPDATE_CAP;

                render = true;

                game.update(this, (float)UPDATE_CAP);
                input.update();

                if (frameTime >= 1.0) {

                    frameTime = 0;
                    fps = frames;
                    frames = 0;

                    System.out.println("Fps : " + fps);

                }

            }
            if (render) {

                // Clear the window
                renderer.clear();

                game.render(this, renderer);

                window.update();
                frames ++;

            } else {

                try {

                    Thread.sleep(1);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

            }

        }

        dispose();

    }

    public void dispose() {



    }

    public static void main(String[] args) {

        GameContainer gc = new GameContainer(game);
        gc.start();

    }

    /*

    GETTERS AND SETTERS

     */

    // WIDTH
    public int getWidth() {

        return width;

    }

    public void setWidth(int width) {

        this.width = width;

    }

    // HEIGHT
    public int getHeight() {

        return height;

    }

    public void setHeight(int height) {

        this.height = height;

    }

    // TITLE
    public String getTitle() {

        return title;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    // SCALE
    public float getScale() {

        return scale;

    }

    // WINDOW
    public Window getWindow() {

        return window;

    }

    // INPUT
    public Input getInput() {

        return input;

    }


}
