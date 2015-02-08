package com.tatianomnom.uselessinvaders.things;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TestItemModifiers {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Armor simplePants = new LeatherPants();
        System.out.println(simplePants.getStatsDescription());

        Armor megaPants = new RabbitMark(new WolfMark(new LeatherPants()));
        System.out.println(megaPants.getStatsDescription());

        List<Class<? extends Armor>> armorList = new ArrayList<>();
        armorList.add(RabbitMark.class);
        armorList.add(WolfMark.class);

        Armor paaants = new LeatherPants();

        //ouch!!!
        for (Class<? extends Armor> aClass : armorList) {
            Constructor<?> cons = aClass.getConstructor(Armor.class);
            paaants = ((Armor) cons.newInstance(paaants));
        }

        System.out.println(paaants.getStatsDescription());

    }
}
