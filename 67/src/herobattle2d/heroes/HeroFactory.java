package herobattle2d.heroes;

public class HeroFactory {
    public static Hero createHero(String type, String name, int x, int y) {
        switch (type.toLowerCase()) {
            case "warrior": return new Warrior(name, x, y);
            case "mage": return new Mage(name, x, y);
            default: throw new IllegalArgumentException("Unknown hero type: " + type);
        }
    }
}
