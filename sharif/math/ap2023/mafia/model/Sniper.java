package ir.sharif.math.ap2023.mafia.model;

public class Sniper extends Citizen{
    // TODO
    protected int numberOfBulletsLeft;

    @Override
    public String action(Player target) {
        if(this.numberOfBulletsLeft>0){
            /** SHOOTING **/
            numberOfBulletsLeft--;
            if(!target.isHeal()) {
                target.setDeadBySniper(true);
                target.setAlive(false);
                target.setDeadLastRound(true);
            }
        } else {
            return "NO_BULLETS";
        }
        return "";
    }

    public Sniper(String name, int id) {
        super(name, id);
        this.numberOfBulletsLeft=2;
    }

    public int getNumberOfBulletsLeft() {
        return numberOfBulletsLeft;
    }

    public void setNumberOfBulletsLeft(int numberOfBulletsLeft) {
        this.numberOfBulletsLeft = numberOfBulletsLeft;
    }
}