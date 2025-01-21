package com.azale.game.inventory;

import com.azale.game.objects.Item;

public class Slot {

    int quantity = 0;
    int maxQuantity;
    Item item;

    public Slot(int maxQuantity) { this.maxQuantity = maxQuantity; }

    public void setItemIn(Item itemIn){ this.item = itemIn; }
    public Item getItemIn() { return this.item; }

    public int addItems(int quantity) {
        if (this.quantity + quantity > maxQuantity) {
            int addedQuantity = maxQuantity - this.quantity;
            this.quantity += addedQuantity;
            quantity -= addedQuantity;
            return quantity;
        } else { return 0; }
    }

    public int subItems(int quantity) {
        if (this.quantity == 0) { return 0; }
        else {
            this.quantity -= quantity;
            return quantity;
        }

    }

    public boolean isEmpty() {
        if (quantity == 0) { return true; }
        else { return false; }
    }

    public boolean isFull() {
        if (quantity == maxQuantity) { return true; }
        else { return false; }
    }

}
