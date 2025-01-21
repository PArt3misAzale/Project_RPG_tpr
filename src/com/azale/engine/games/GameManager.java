package com.azale.engine.games;

import com.azale.engine.AbstractGame;
import com.azale.engine.GameContainer;
import com.azale.engine.Renderer;
import com.azale.engine.gfx.ImageTile;
import com.azale.game.entities.player.Player;
import com.azale.game.entitystats.EntityStats;
import com.azale.game.inventory.Inventory;
import com.azale.game.objects.items.ItemFireGem;

public class GameManager extends AbstractGame {

    private int cursorX, cursorY;
    // GAME //
    int FPS = 0;
    // PLAYER
    Player player;
    // STATS
    EntityStats health;
    EntityStats attack;
    EntityStats mana;
    EntityStats stamina;
    EntityStats strength;
    EntityStats dexterity;
    EntityStats agility;
    EntityStats intelligence;
    EntityStats speed;
    EntityStats defense;
    EntityStats magicalDefense;
    EntityStats luck;
    EntityStats magic;

    Inventory playerInventory;

    ItemFireGem ITEMFIREGEM;

    public GameManager() {

        // GAME //
        // PLAYER
        this.player = new Player(0, 0, 96, 96, new ImageTile("/images/entities/player/player.png", 96, 96));
        player.setX(100); player.setY(100);
        // STATS
        this.health = new EntityStats("health");
        this.attack = new EntityStats("attack");
        this.mana = new EntityStats("mana");
        this.stamina = new EntityStats("stamina");
        this.strength = new EntityStats("strength");
        this.dexterity = new EntityStats("dexterity");
        this.agility = new EntityStats("agility");
        this.intelligence = new EntityStats("intelligence");
        this.speed = new EntityStats("speed");
        this.defense = new EntityStats("defense");
        this.magicalDefense = new EntityStats("magicalDefense");
        this.luck = new EntityStats("luck");
        this.magic = new EntityStats("magic");

        this.playerInventory = new Inventory(60, 50); // nbSlots to redefine

        this.ITEMFIREGEM = new ItemFireGem(1, "Fire Gem");
        this.playerInventory.slots[0].setItemIn(ITEMFIREGEM);

    }


    @Override
    public void update(GameContainer gc, float dt) {

        cursorX = gc.getInput().getMouseX();
        cursorY = gc.getInput().getMouseY();

        FPS++;
        if(FPS%30 == 1) {
            this.playerInventory.slots[0].addItems(1);
            this.playerInventory.consoleOutNb(0);
        }

    }

    @Override
    public void render(GameContainer gc, Renderer r) {

        // PLAYER
        gc.renderer.drawImage(player.getImage(), player.getX(), player.getY());

        // UI

        // ON ALL THINGS
        gc.renderer.drawText6P("FPS : " + gc.fps, 0, 0, 0xff00ffff);
        gc.renderer.drawText6P("Mouse coordinates : ( " + cursorX + " ; " + cursorY + " )",0, 10, 0xff00ffff);

    }

    public static void main(String[] args) {

        GameContainer gc = new GameContainer(new GameManager());
        gc.start();

    }
}
