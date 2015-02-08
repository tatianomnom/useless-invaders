package com.tatianomnom.uselessinvaders;

public class Money implements Loot {
    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
