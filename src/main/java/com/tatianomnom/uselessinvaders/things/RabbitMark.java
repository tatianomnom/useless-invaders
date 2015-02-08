package com.tatianomnom.uselessinvaders.things;

public class RabbitMark extends StatsDecorator {

    private Armor armor;

    public RabbitMark(Armor armor) {
        this.armor = armor;
    }

    @Override
    public int getHp() {
        return armor.getHp();
    }

    @Override
    public int getStrength() {
        return armor.getStrength();
    }

    @Override
    public int getAgility() {
        return armor.getAgility() + 50;
    }

    @Override
    public String toString() {
        return armor.toString() + " with Rabbit Mark";
    }
}
