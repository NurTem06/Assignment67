package herobattle2d.strategies;

public class MagicAttack implements AttackStrategy {
    @Override
    public void attack(String attacker, String target) {
        System.out.println(attacker + " casts a spell on " + target + "!");
    }
}
