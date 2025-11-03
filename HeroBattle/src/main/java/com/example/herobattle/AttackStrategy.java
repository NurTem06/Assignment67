package com.example.herobattle;

public interface AttackStrategy {
    void attack(Hero attacker, Hero target);
    String getName();
}
