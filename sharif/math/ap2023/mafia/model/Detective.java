package ir.sharif.math.ap2023.mafia.model;

public class Detective extends Citizen {
    // TODO
    public Detective(String name, int id) {
        super(name, id);
    }

    @Override
    public String action(Player target) {
        if(target instanceof Mafia ){
            if(target instanceof GodFather){
                if(!((GodFather) target).asked){
                    ((GodFather) target).asked=true;
                    return "NO_MAFIA";
                }
            }
            return "MAFIA";
        }
        return "NO_MAFIA";
    }

}