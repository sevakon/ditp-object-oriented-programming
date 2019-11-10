package battle;

public class Battle {
    private BattleArmy firstArmy;
    private BattleArmy secondArmy;
    private Status status;

    public Battle(BattleArmy firstArmy, BattleArmy secondArmy) {
        this.firstArmy = firstArmy;
        this.secondArmy = secondArmy;
        this.status = Status.IN_ACTION;
    }

    public Status getStatus() {
        return status;
    }
}
