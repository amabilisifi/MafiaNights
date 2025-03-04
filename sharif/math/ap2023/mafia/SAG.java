package ir.sharif.math.ap2023.mafia;

import ir.sharif.math.ap2023.mafia.logic.GameState;
import ir.sharif.math.ap2023.mafia.model.*;

import java.util.ArrayList;
import java.util.List;

public class SAG {
    public static void main(String[] args){
        Doctor doctor = new Doctor("doctor", 1);
        Detective detective = new Detective("detective", 2);
        GodFather godFather = new GodFather("father", 3);
        OrdinaryCitizen citizen = new OrdinaryCitizen("citizen", 4);
        DoctorLecter doctorLecter = new DoctorLecter("doctorLecter", 5);
        Sniper sniper = new Sniper("sniper", 6);
        OrdinaryMafia ordinaryMafia = new OrdinaryMafia("ordinaryMafia", 7);
        OrdinaryMafia ordinaryMafia1 = new OrdinaryMafia("ordinarymafiaa",10);
        OrdinaryMafia ordinaryMafia2 = new OrdinaryMafia("ordinarymafiaaa",11);
        Natasha natasha = new Natasha("natasha", 8);
        Joker joker = new Joker("joker", 9);
        List<Player> players = new ArrayList<>();
        players.add(doctor);
        players.add(godFather);
        players.add(detective);
        players.add(citizen);
        players.add(doctorLecter);
        players.add(sniper);
        players.add(ordinaryMafia);
        players.add(natasha);
        players.add(joker);

        GameState gameState = new GameState(players);

        gameState.nextNight();

        gameState.nextDay();

        gameState.nextNight();
        ordinaryMafia.action(citizen);
        ordinaryMafia1.action(citizen);
        ordinaryMafia2.action(natasha);


        gameState.nextDay();
        System.out.println(gameState.getDeadPlayersInLastRound());

    }
}
