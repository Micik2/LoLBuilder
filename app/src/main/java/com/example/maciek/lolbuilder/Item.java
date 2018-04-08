package com.example.maciek.lolbuilder;

import java.util.ArrayDeque;

/**
 * Created by Maciek on 2017-05-28.
 */

public class Item {
    private int id;
    private String name;
    private int health;
    private double healthRegen;
    private int mana;
    private double manaRegen;
    private int moveSpeed;
    private double attackDamage;    // a co ze Sterakiem???
    private double attackSpeed;
    private int armor;
    private int magicResist;
    private int cost;
    private ArrayDeque<Item> items = new ArrayDeque<Item>();

    public Item(int id, String name, int health, double healthRegen, int mana, double manaRegen, int moveSpeed, double attackDamage, double attackSpeed, int armor, int magicResist, int cost, ArrayDeque<Item> items) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.healthRegen = healthRegen;
        this.mana = mana;
        this.manaRegen = manaRegen;
        this.moveSpeed = moveSpeed;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.armor = armor;
        this.magicResist = magicResist;
        this.cost = cost;
        items.add(new Item(id, name, health, healthRegen, mana, manaRegen, moveSpeed, attackDamage, attackSpeed, armor, magicResist, cost));
    }

    public Item(int i, String n, int h, double hR, int m, double mRn, int mS, double aD, double aS, int a, int mRt, int c) {
        this.id = i;
        this.name = n;
        this.health = h;
        this.healthRegen = hR;
        this.mana = m;
        this.manaRegen = mRn;
        this.moveSpeed = mS;
        this.attackDamage = aD;
        this.attackSpeed = aS;
        this.armor = a;
        this.magicResist = mRt;
        this.cost = c;
    }


}
