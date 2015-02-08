package com.tatianomnom.uselessinvaders.things;

//TODO write an article about creating flexible items with bonus stats (modifiers)
public abstract class Armor {
    abstract int getHp();

    abstract int getStrength();

    abstract int getAgility();

    public String getStatsDescription() {
        return this.toString() + "\nStats: " +
                "hp = " + getHp() + ", str = " + getStrength() + ", agi = " + getAgility();
    }
}
