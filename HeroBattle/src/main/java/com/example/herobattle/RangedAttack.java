package com.example.herobattle;

public class RangedAttack implements AttackStrategy {
    @Override
    public void attack(Hero attacker, Hero target) {
        target.takeDamage(10);
        System.out.println(attacker.getName() + " shoots an arrow at " + target.getName());
    }

    @Override
    public String getName() {
        return "Bow (Ranged)";
    }
}
