package com.tatianomnom.uselessinvaders;

import java.util.HashSet;
import java.util.Set;

public class Hero {

    //todo take a look at observable lists from javafx?
    private Set<Equipment> equippedItems = new HashSet<>();


    public void equip(Equipment equipment) {
        //remove from inventory first
        equippedItems.add(equipment);
        recalculateEquipmentStats();
    }

    //necessary to consider set bonuses etc
    private void recalculateEquipmentStats() {

    }

    public void unequip(Equipment equipment) {
        equippedItems.remove(equipment);
        //and put back into inventory
        recalculateEquipmentStats();
    }

}
