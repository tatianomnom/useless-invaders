package com.tatianomnom.uselessinvaders;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hero extends Creature {

    private Map<String, Integer> baseStats;
    private Map<String, Integer> stats;

    public Map<String, Integer> getStats() {
        return stats;
    }

    public Hero(int initialHp, Map<String, Integer> baseStats) {
        super(initialHp);
        this.baseStats = baseStats;
        this.stats = baseStats;
    }

    private Set<Equipment> equippedItems = new HashSet<>();

    private Set<Equipment> inventory = new HashSet<>();

    public Set<Equipment> getInventory() {
        return inventory;
    }

    public void addToInventory(Equipment equipment) {
        inventory.add(equipment);
    }

    public void equip(Equipment equipment) {
        inventory.remove(equipment);
        equippedItems.add(equipment);
        recalculateEquipmentStats();
    }

    //necessary to consider set bonuses etc
    private void recalculateEquipmentStats() {
        stats = new HashMap<>(baseStats);

        equippedItems.forEach(e ->
                e.getStats().forEach((k, v) ->
                                stats.put(k, stats.get(k) + v)
                ));
    }

    public void unequip(Equipment equipment) {
        equippedItems.remove(equipment);
        inventory.add(equipment);
        recalculateEquipmentStats();
    }

}
