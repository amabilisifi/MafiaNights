package ir.sharif.math.ap2023.mafia;

import ir.sharif.math.ap2023.mafia.logic.GameState;
import ir.sharif.math.ap2023.mafia.model.*;

import java.util.ArrayList;
import java.util.List;

public class newM {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("doctor", 1);
        Detective detective = new Detective("detective", 2);
        OrdinaryCitizen citizen = new OrdinaryCitizen("citizen", 4);
        DoctorLecter doctorLecter = new DoctorLecter("doctorLecter", 5);
        GodFather godFather = new GodFather("father",3);
        Sniper sniper = new Sniper("sniper", 6);
        OrdinaryMafia ordinaryMafia = new OrdinaryMafia("ordinaryMafia", 7);
        Natasha natasha = new Natasha("natasha", 8);
        Joker joker = new Joker("joker", 9);
        List<Player> players = new ArrayList<>();
        players.add(doctor);
        players.add(detective);
        players.add(citizen);
        players.add(doctorLecter);
        players.add(sniper);
        players.add(ordinaryMafia);
        players.add(natasha);
        players.add(joker);

        GameState gameState = new GameState(players);

        gameState.nextNight();
        godFather.action(citizen);
        doctorLecter.action(citizen);
        sniper.action(citizen);
        doctor.action(citizen);

        gameState.nextDay();
        System.out.println(citizen.isAlive());
    }
}
