package herobattle2d.observers;

public class BattleAnnouncer implements Observer {
    @Override
    public void update(String event) {
        System.out.println("[Announcement] " + event);
    }
}
