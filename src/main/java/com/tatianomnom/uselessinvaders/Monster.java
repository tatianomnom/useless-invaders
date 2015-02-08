package com.tatianomnom.uselessinvaders;

import java.util.*;

public class Monster extends Creature {

    private Map<Loot, Integer> lootTable;

    public Monster(int initialHp) {
        super(initialHp);
        this.lootTable = new HashMap<>();
    }

    public Monster(int initialHp, Map<Loot, Integer> lootTable) {
        super(initialHp);
        this.lootTable = lootTable;
    }

    public List<Loot> takeLoot() {
        if (isAlive()) {
            throw new IllegalStateException("No looting before killing!");
        }
        List<Loot> loot = new ArrayList<>();
        //todo separate generator + look at java 8 random features
        lootTable.forEach((k, v) -> {
                    Random random = new Random();
                    if (v >= random.nextInt(100)) {
                        loot.add(k);
                    }
                }
        );
        return loot;
    }
}
