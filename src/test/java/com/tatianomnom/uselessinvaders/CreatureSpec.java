package com.tatianomnom.uselessinvaders;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tatiana on 07.02.15.
 */
@RunWith(JUnitParamsRunner.class)
public class CreatureSpec {

    @Test
    public void isAliveAfterCreation() {
        assertThat(new Creature(56).isAlive()).isTrue();
    }

    @Test
    @Parameters({"100|30|70", "10|100|-90"})
    public void hpIsReducedUponReceivingDamage(int initialHp, int damage, int remainingHp) {
        Creature vlad = new Creature(initialHp);
        assertThat(vlad.getHp()).isEqualTo(initialHp);

        vlad.receiveDamage(damage);
        assertThat(vlad.getHp()).isEqualTo(remainingHp);
    }

    @Test
    @Parameters({"80|79|1", "100|1|100"})
    public void diesWhenZeroHp(int initialHp, int damage, int killingBlowDamage) {
        Creature vlad = new Creature(initialHp);
        vlad.receiveDamage(damage);
        assertThat(vlad.isAlive()).isTrue();
        vlad.receiveDamage(killingBlowDamage);
        assertThat(vlad.isAlive()).isFalse();
    }

    @Test
    @Parameters({"10|7|2|5", "100|30|40|100"})
    public void hpIsRestoredUpToMaxWhenHealed(int initialHp, int damage, int healing, int expectedHp) {
        Creature vlad = new Creature(initialHp);
        vlad.receiveDamage(damage);
        vlad.restoreHealth(healing);
        assertThat(vlad.getHp()).isEqualTo(expectedHp);
    }
}
