package com.tatianomnom.uselessinvaders;

public class Creature {


    private final int initialHp;
    private int hp;

    public Creature(int initialHp) {
        this.initialHp = initialHp;
        this.hp = initialHp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public void receiveDamage(int damage) {
        hp -= damage;
    }

    public void restoreHealth(int amount) {
        hp += amount;
        if (hp > initialHp) {
            hp = initialHp;
        }
    }
}
