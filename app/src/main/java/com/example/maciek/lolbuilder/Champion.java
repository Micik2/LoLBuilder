package com.example.maciek.lolbuilder;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Maciek on 2017-05-28.
 */

public class Champion {
    private int id;
    private String name;
    private String type;    // tylko Marksman
    private double health;
    private double healthRegen;
    private double mana;
    private double manaRegen;
    private int moveSpeed;
    private double attackDamage;
    private double attackSpeed;
    private int range;
    private double armor;
    private double magicResist;
    private ArrayDeque<Champion> champions = new ArrayDeque<Champion>();

    public Champion(int id, String name, double health, double healthRegen, double mana, double manaRegen, int moveSpeed, double attackDamage, double attackSpeed, final int range, double armor, double magicResist, ArrayDeque<Champion> champions) {
        this.id = id;
        this.name = name;
        this.type = "Marksman";
        this.health = health;
        this.healthRegen = healthRegen;
        this.mana = mana;
        this.manaRegen = manaRegen;
        this.moveSpeed = moveSpeed;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.armor = armor;
        this.magicResist = magicResist;
        champions.add(new Champion(id, name, health, healthRegen, mana, manaRegen, moveSpeed, attackDamage, attackSpeed, range, armor, magicResist));
    }

    public Champion(int i, String n, double h, double hR, double m, double mRn, int mS, double aD, double aS, final int r, double a, double mRt) {
        this.id = i;
        this.name = n;
        this.health = h;
        this.healthRegen = hR;
        this.mana = m;
        this.manaRegen = mRn;
        this.moveSpeed = mS;
        this.attackDamage = aD;
        this.attackSpeed = aS;
        this.range = r;
        this.armor = a;
        this.magicResist = mRt;
    }

}
