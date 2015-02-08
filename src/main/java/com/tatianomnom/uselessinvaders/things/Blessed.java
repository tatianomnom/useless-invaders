package com.tatianomnom.uselessinvaders.things;

public class Blessed extends StatsDecorator {

    private Armor armor;

    @Override
    int getHp() {
        return armor.getHp();
    }

    @Override
    int getStrength() {
        return armor.getStrength();
    }

    @Override
    int getAgility() {
        return armor.getAgility();
    }
}
