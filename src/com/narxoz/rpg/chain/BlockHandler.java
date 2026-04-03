package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class BlockHandler extends DefenseHandler {
    private final double blockPercent;

    public BlockHandler(double blockPercent) {
        this.blockPercent = blockPercent;
    }

    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        int reduced = (int) Math.round(incomingDamage * (1.0 - blockPercent));
        System.out.println(target.getName() + " blocked! Damage reduced from "
                + incomingDamage + " → " + reduced);
        passToNext(reduced, target);
    }
}
