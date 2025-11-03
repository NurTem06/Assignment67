package com.example.herobattle;

public class MagicAttack implements AttackStrategy {
    @Override
    public void attack(Hero attacker, Hero target) {
        target.takeDamage(20);
        System.out.println(attacker.getName() + " casts Fireball on " + target.getName());
    }

    @Override
    public String getName() {
        return "Fireball (Magic)";
    }
}
