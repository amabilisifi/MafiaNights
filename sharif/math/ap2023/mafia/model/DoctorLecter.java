package ir.sharif.math.ap2023.mafia.model;

public class DoctorLecter extends Mafia {
    // TODO
    public DoctorLecter(String name, int id) {
        super(name, id);
    }
    @Override
    public String action(Player target) {
        if(!(target.isDeadByGodfather)) {
            target.setHeal(true);
            target.setAlive(true);
        }
        return "";
    }

}