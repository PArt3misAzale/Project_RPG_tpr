package com.azale.game.objects;

public class Item {

    String name;

    public Item(String name) { this.name = name; }

    public String getName(){ return this.name; }
    public void setName(String newName){ this.name = newName; }

    public void consoleOut() { System.out.println(this.name); }

}
