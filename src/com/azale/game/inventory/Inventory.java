package com.azale.game.inventory;

public class Inventory {

    public Slot[] slots;
    int nbSlots;

    int maxQuantityPerSlot;

    public Inventory(int nbSlots, int maxQuantityPerSlot) {
        this.slots = new Slot[nbSlots];
        this.nbSlots = nbSlots;

        this.maxQuantityPerSlot = maxQuantityPerSlot;

        for (int i = 0; i < nbSlots; i++) {
            this.slots[i] = new Slot(this.maxQuantityPerSlot);
        }
    }

    public boolean isEmpty() {
        int i = 0;
        while (i < nbSlots && slots[i].isEmpty()) { i++; }
        if (i == nbSlots) { return true; }
        else { return false; }
    }

    public boolean isFull() {
        int i = 0;
        while (i < nbSlots && !slots[i].isEmpty()) { i++; }
        if (i == nbSlots) { return true; }
        else { return false; }
    }

    public boolean slotsFull() {
        int i = 0;
        while (i < nbSlots && slots[i].isFull()) { i++; }
        if (i == nbSlots) { return true; }
        else { return false; }
    }

    public void consoleOut() {
        for (int i = 0; i < nbSlots; i++) {
            System.out.println(slots[i].quantity);
        }
    }

    public void consoleOutNb(int i) {
        System.out.println(slots[i].quantity);
    }

}
