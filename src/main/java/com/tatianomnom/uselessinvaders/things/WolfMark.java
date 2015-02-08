package com.tatianomnom.uselessinvaders.things;

public class WolfMark extends StatsDecorator {
    private Armor armor;

    public WolfMark(Armor armor) {
        this.armor = armor;
    }

    @Override
    public int getHp() {
        return armor.getHp() + 20;
    }

    @Override
    public int getStrength() {
        return armor.getStrength() + 30;
    }

    @Override
    public int getAgility() {
        return armor.getAgility() + 10;
    }

    @Override
    public String toString() {
        return armor.toString() + " with Wolf Mark";
    }

}
