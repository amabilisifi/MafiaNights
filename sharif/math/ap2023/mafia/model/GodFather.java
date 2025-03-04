package ir.sharif.math.ap2023.mafia.model;

public class GodFather extends Mafia {
    // TODO
    protected boolean asked = false;

    @Override
    public String action(Player target) {
        if (!target.heal) {
            target.setAlive(false);
            target.setDeadLastRound(true);
        }
        return super.action(target);
    }

    public GodFather(String name, int id) {
        super(name, id);
    }

    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }
}