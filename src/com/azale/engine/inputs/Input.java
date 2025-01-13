package com.azale.engine.inputs;

import com.azale.engine.GameContainer;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private GameContainer gc;

    private final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    private final int NUM_BUTTONS = 6;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];

    private int mouseX, mouseY;
    private int scroll;

    public Input(GameContainer gc) {

        this.gc = gc;

        mouseX = 0;
        mouseY = 0;

        scroll = 0;

        gc.getWindow().getCanvas().addKeyListener(this);
        gc.getWindow().getCanvas().addMouseListener(this);
        gc.getWindow().getCanvas().addMouseMotionListener(this);
        gc.getWindow().getCanvas().addMouseWheelListener(this);

    }

    public void update() {

        scroll = 0;

        for (int i = 0; i < NUM_KEYS; i++) {

            keysLast[i] = keys[i];

        }

        for (int i = 0; i < NUM_BUTTONS; i++) {

            buttonsLast[i] = buttons[i];

        }

    }

    public int getKeysToWrite(Boolean isWritting, String[] mainText, int i) {

        if (isWritting == true) {

            /*

            LETTERS

             */

            // A
            if (gc.getInput().isKeyDown(KeyEvent.VK_A) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "A";

                } else {

                    mainText[i] += "a";

                }

            }

            // B
            if (gc.getInput().isKeyDown(KeyEvent.VK_B) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "B";

                } else {

                    mainText[i] += "b";

                }

            }

            // C
            if (gc.getInput().isKeyDown(KeyEvent.VK_C) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "C";

                } else {

                    mainText[i] += "c";

                }

            }

            // D
            if (gc.getInput().isKeyDown(KeyEvent.VK_D) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "D";

                } else {

                    mainText[i] += "d";

                }

            }

            // E
            if (gc.getInput().isKeyDown(KeyEvent.VK_E) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "E";

                } else {

                    mainText[i] += "e";

                }

            }

            // F
            if (gc.getInput().isKeyDown(KeyEvent.VK_F) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "F";

                } else {

                    mainText[i] += "f";

                }

            }

            // G
            if (gc.getInput().isKeyDown(KeyEvent.VK_G) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "G";

                } else {

                    mainText[i] += "g";

                }

            }

            // H
            if (gc.getInput().isKeyDown(KeyEvent.VK_H) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "H";

                } else {

                    mainText[i] += "h";

                }

            }

            // I
            if (gc.getInput().isKeyDown(KeyEvent.VK_I) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "I";

                } else {

                    mainText[i] += "i";

                }

            }

            // J
            if (gc.getInput().isKeyDown(KeyEvent.VK_J) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "J";

                } else {

                    mainText[i] += "j";

                }

            }

            // K
            if (gc.getInput().isKeyDown(KeyEvent.VK_K) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "K";

                } else {

                    mainText[i] += "k";

                }

            }

            // L
            if (gc.getInput().isKeyDown(KeyEvent.VK_L) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "L";

                } else {

                    mainText[i] += "l";

                }

            }

            // M
            if (gc.getInput().isKeyDown(KeyEvent.VK_M) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "M";

                } else {

                    mainText[i] += "m";

                }

            }

            // N
            if (gc.getInput().isKeyDown(KeyEvent.VK_N) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "N";

                } else {

                    mainText[i] += "n";

                }

            }

            // O
            if (gc.getInput().isKeyDown(KeyEvent.VK_O) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "O";

                } else {

                    mainText[i] += "o";

                }

            }

            // P
            if (gc.getInput().isKeyDown(KeyEvent.VK_P) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "P";

                } else {

                    mainText[i] += "p";

                }

            }

            // Q
            if (gc.getInput().isKeyDown(KeyEvent.VK_Q) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "Q";

                } else {

                    mainText[i] += "q";

                }

            }

            // R
            if (gc.getInput().isKeyDown(KeyEvent.VK_R) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "R";

                } else {

                    mainText[i] += "r";

                }

            }

            // S
            if (gc.getInput().isKeyDown(KeyEvent.VK_S) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "S";

                } else {

                    mainText[i] += "s";

                }

            }

            // T
            if (gc.getInput().isKeyDown(KeyEvent.VK_T) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "T";

                } else {

                    mainText[i] += "t";

                }

            }

            // U
            if (gc.getInput().isKeyDown(KeyEvent.VK_U) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "U";

                } else {

                    mainText[i] += "u";

                }

            }

            // V
            if (gc.getInput().isKeyDown(KeyEvent.VK_V) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "V";

                } else {

                    mainText[i] += "v";

                }

            }

            // W
            if (gc.getInput().isKeyDown(KeyEvent.VK_W) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "W";

                } else {

                    mainText[i] += "w";

                }

            }

            // X
            if (gc.getInput().isKeyDown(KeyEvent.VK_X) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "X";

                } else {

                    mainText[i] += "x";

                }

            }

            // Y
            if (gc.getInput().isKeyDown(KeyEvent.VK_Y) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "Y";

                } else {

                    mainText[i] += "y";

                }

            }

            // Z
            if (gc.getInput().isKeyDown(KeyEvent.VK_Z) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                if (gc.getInput().isKey(KeyEvent.VK_SHIFT)) {

                    mainText[i] += "Z";

                } else {

                    mainText[i] += "z";

                }

            }

            /*

            SYSTEM KEYS

             */

            // ENTER
            if (gc.getInput().isKeyDown((KeyEvent.VK_ENTER)) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                i ++;

            }

            // SPACE
            if (gc.getInput().isKeyDown(KeyEvent.VK_SPACE) && !gc.getInput().isKeyDown(KeyEvent.VK_CONTROL)) {

                mainText[i] += " ";

            }

        }

        return i;

    }

    /*

    GET THE STATES OF THE KEYS

     */
    public boolean isKey(int keyCode) {

        return keys[keyCode];

    }

    public boolean isKeyUp(int keyCode) {

        return !keys[keyCode] && keysLast[keyCode];

    }

    public boolean isKeyDown(int keyCode) {

        return keys[keyCode] && !keysLast[keyCode];

    }

    /*

    GET THE STATES OF THE BUTTONS

     */
    public boolean isButton(int buttonCode) {

        return buttons[buttonCode];

    }

    public boolean isButtonUp(int buttonCode) {

        return !buttons[buttonCode] && buttonsLast[buttonCode];

    }

    public boolean isButtonDown(int buttonCode) {

        return buttons[buttonCode] && buttonsLast[buttonCode];

    }

    /*

    KEYS

     */

    // TYPED KEYS
    @Override
    public void keyTyped(KeyEvent e) {



    }

    // PRESSED KEYS
    @Override
    public void keyPressed(KeyEvent e) {

        keys[e.getKeyCode()] = true;

    }

    // RELEASED KEYS
    @Override
    public void keyReleased(KeyEvent e) {

        keys[e.getKeyCode()] = false;

    }

    /*

    MOUSE

     */

    // MOUSE CLICKED
    @Override
    public void mouseClicked(MouseEvent e) {



    }

    // MOUSE PRESSED
    @Override
    public void mousePressed(MouseEvent e) {

        buttons[e.getButton()] = true;

    }

    // MOUSE RELEASED
    @Override
    public void mouseReleased(MouseEvent e) {

        buttons[e.getButton()] = false;

    }

    /*

    MOUSE MOVEMENTS

     */

    @Override
    public void mouseEntered(MouseEvent e) {



    }

    @Override
    public void mouseExited(MouseEvent e) {



    }

    // MOVING THE MOUSE WHILE CLICKING
    @Override
    public void mouseDragged(MouseEvent e) {

        mouseX = (int)(e.getX() / gc.getScale());
        mouseY = (int)(e.getY() / gc.getScale());

    }

    // MOVING THE MOUSE WITHOUT CLICKING
    @Override
    public void mouseMoved(MouseEvent e) {

        mouseX = (int)(e.getX() / gc.getScale());
        mouseY = (int)(e.getY() / gc.getScale());

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        scroll = e.getWheelRotation();

    }

    /*

    GETTERS AND SETTERS

     */

    // MOUSE COORDINATES
    public int getMouseX() {

        return mouseX;

    }

    public int getMouseY() {

        return mouseY;

    }

    // WHEEL INFORMATION
    public int getScroll() {

        return scroll;

    }
}
