package ir.sharif.math.ap2023.mafia.model;

public class Doctor extends Citizen {
    // TODO
    protected int numberOfSelfSave;

    @Override
    public String action(Player target) {
        if(target == this) {
            if (this.numberOfSelfSave >0) {
                /** SHOOTING **/
                numberOfSelfSave--;
            }
            if (this.numberOfSelfSave<=0) {
                return "NO_SAVE";
            }
        }
        if(!target.isDeadBySniper()) {
            target.setAlive(true);
            target.setHeal(true);
        }
        return "";
    }

    public Doctor(String name, int id) {
        super(name, id);
        this.numberOfSelfSave=2;
    }

    public int getNumberOfSelfSave() {
        return numberOfSelfSave;
    }

    public void setNumberOfSelfSave(int numberOfSelfSave) {
        this.numberOfSelfSave = numberOfSelfSave;
    }
}