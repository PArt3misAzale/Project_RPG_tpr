package com.azale.game.entities;

import com.azale.engine.gfx.ImageTile;

public class Entity {

    int x, y;
    int width, height = 92;
    ImageTile entityImage;

    public Entity(int x, int y, int width, int height, ImageTile entityImage) {

        this.x = x; this.y = y;
        this.width = width; this.height = height;

        this.entityImage = entityImage;

    }

    // COORDINATES
    // x
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void goRight(int i){
        this.x += i;
    }

    public void goLeft(int i){
        this.x -= i;
    }

    // y
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void goDown(int i){
        this.y += i;
    }

    public void goUp(int i){
        this.y -= i;
    }

    // DIMENSIONS
    // width
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    // height
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // VISUAL
    // image
    public ImageTile getImage() {
        return entityImage;
    }

    public void setImage(ImageTile entityImage) {
        this.entityImage = entityImage;
    }
}
