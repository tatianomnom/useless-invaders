package com.tatianomnom.uselessinvaders;

import java.util.HashMap;
import java.util.Map;

public class Equipment {
    private Map<String, Integer> stats = new HashMap<>();

    public Equipment(Map<String, Integer> stats) {
        this.stats = stats;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }
}
