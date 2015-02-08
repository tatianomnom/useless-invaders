package com.tatianomnom.uselessinvaders

import spock.lang.Specification

class LootingSpec extends Specification {

    def "Monster is unlootable when alive"() {
        given:
        Monster goblin = new Monster(100);
        goblin.receiveDamage(goblin.getHp() - 1)
        when:
        goblin.takeLoot()
        then:
        thrown(IllegalStateException)
    }

    def "Monster drops loot upon death according to loot table probabilities"() {
        given:
        Monster goblin = new Monster(100, lootTable);
        goblin.receiveDamage(goblin.getHp())
        when:
        def loot = goblin.takeLoot()
        then:
        loot.size() == lootItemsAmount

        where:
        lootTable             | lootItemsAmount
        [(new Money(4)): 100] | 1
        [(new Money(4)): 0]   | 0
        [:]                   | 0

    }
}