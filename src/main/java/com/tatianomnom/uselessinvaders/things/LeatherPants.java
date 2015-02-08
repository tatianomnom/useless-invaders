package com.tatianomnom.uselessinvaders.things;

public class LeatherPants extends Armor {

    @Override
    public int getHp() {
        return 50;
    }

    @Override
    public int getStrength() {
        return 0;
    }

    @Override
    public int getAgility() {
        return 20;
    }

    @Override
    public String toString() {
        return "Leather Pants";
    }
}
