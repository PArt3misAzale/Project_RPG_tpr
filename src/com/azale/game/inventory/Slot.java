package com.azale.game.inventory;

import com.azale.game.objects.Item;

public class Slot {

    int quantity = 0;
    int maxQuantity;
    Item item;

    int returnedAddItems;

    public Slot(int maxQuantity) { this.maxQuantity = maxQuantity; }

    public void setItemIn(Item itemIn){ this.item = itemIn; }
    public Item getItemIn() { return this.item; }

    public void addItems(int quantity) {
        returnedAddItems = 0;
        if (this.quantity + quantity <= this.maxQuantity) {
            this.quantity += quantity;
        } else {
            returnedAddItems = -(this.maxQuantity - (this.quantity + quantity));
        }
    }

    public int subItems(int quantity) {
        if (this.quantity == 0) { return 0; }
        else {
            this.quantity -= quantity;
            return quantity;
        }

    }

    public int getReturnedAddItems() { return returnedAddItems; }

    public boolean isEmpty() {
        if (quantity == 0) { return true; }
        else { return false; }
    }

    public boolean isFull() {
        if (quantity == maxQuantity) { return true; }
        else { return false; }
    }

}
