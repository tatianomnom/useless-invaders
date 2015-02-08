package com.tatianomnom.uselessinvaders

import spock.lang.Specification


class EquipmentSpec extends Specification {

    private Hero hero = new Hero(100, [agility: 100, strength: 20, intelligence: 0])

    def "Item in the inventory doesn't modify hero stats"() {
        given:
        Equipment equipment = new Equipment(equipmentStats)
        when:
        hero.addToInventory(equipment)
        then:
        hero.getStats().equals(expectedStats)

        where:
        equipmentStats               | expectedStats
        [agility: 0, strength: 80]   | [agility: 100, strength: 20, intelligence: 0]
        [agility: 0, strength: -5]   | [agility: 100, strength: 20, intelligence: 0]
        [agility: -10, strength: -5] | [agility: 100, strength: 20, intelligence: 0]

    }

    def "Equipped item modifies hero stats"() {
        given:
        Equipment equipment = new Equipment(equipmentStats)
        when:
        hero.addToInventory(equipment)
        hero.equip(equipment)
        then:
        hero.getStats().equals(expectedStats)

        where:
        equipmentStats               | expectedStats
        [agility: 0, strength: 80]   | [agility: 100, strength: 100, intelligence: 0]
        [agility: 10, strength: -10] | [agility: 110, strength: 10, intelligence: 0]
        [intelligence: 1000]         | [agility: 100, strength: 20, intelligence: 1000]
    }

    def "Unequipped item doesn't modify hero stats no more"() {
        given:
        Equipment equipment = new Equipment(equipmentStats)
        when:
        hero.addToInventory(equipment)
        hero.equip(equipment)
        hero.unequip(equipment)
        then:
        hero.getStats().equals(expectedStats)

        where:
        equipmentStats               | expectedStats
        [agility: 0, strength: 80]   | [agility: 100, strength: 20, intelligence: 0]
        [agility: -10, strength: -5] | [agility: 100, strength: 20, intelligence: 0]
    }


}