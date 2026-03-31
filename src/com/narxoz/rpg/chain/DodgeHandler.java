package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;
import java.util.Random;

public class DodgeHandler extends DefenseHandler {
    private final double dodgeChance;
    private final Random random;

    public DodgeHandler(double dodgeChance, long seed) {
        this.dodgeChance = dodgeChance;
        this.random = new Random(seed);
    }

    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        // TODO: Generate a random double between 0.0 and 1.0 using random.nextDouble().
        // TODO: If the roll is less than dodgeChance, the attack is fully dodged:
        //       - Print a dodge message (e.g. "[Dodge] Attack evaded!")
        //       - Stop the chain — do NOT call passToNext.
        // TODO: If the dodge fails, pass the full incomingDamage to the next handler.
        double roll= random.nextDouble();
        if (roll < dodgeChance) {
            System.out.println("[Dodge] " + target.getName() + " evaded the attack!");
            return;
        }
        passToNext(incomingDamage, target);
    }
}
