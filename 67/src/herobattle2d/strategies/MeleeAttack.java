package herobattle2d.strategies;

public class MeleeAttack implements AttackStrategy {
    @Override
    public void attack(String attacker, String target) {
        System.out.println(attacker + " strikes " + target + " with a sword!");
    }
}
