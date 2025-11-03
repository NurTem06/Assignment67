package com.example.herobattle;

public class MeleeAttack implements AttackStrategy {
    @Override
    public void attack(Hero attacker, Hero target) {
        target.takeDamage(15);
        System.out.println(attacker.getName() + " attacks " + target.getName() + " with a sword!");
    }

    @Override
    public String getName() {
        return "Sword (Melee)";
    }
}
