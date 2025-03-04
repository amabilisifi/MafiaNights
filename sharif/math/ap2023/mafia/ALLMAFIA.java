package ir.sharif.math.ap2023.mafia;

import ir.sharif.math.ap2023.mafia.logic.GameState;
import ir.sharif.math.ap2023.mafia.model.GodFather;
import ir.sharif.math.ap2023.mafia.model.OrdinaryCitizen;
import ir.sharif.math.ap2023.mafia.model.OrdinaryMafia;
import ir.sharif.math.ap2023.mafia.model.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ALLMAFIA {
    public static void main(String[] args) {

        GodFather godFather = new GodFather("GF", 4);
        OrdinaryMafia ordinaryMafia = new OrdinaryMafia("OM", 5);

        List<Player> players = new ArrayList<>();
        players.add(godFather);
        players.add(ordinaryMafia);


        GameState gameState = new GameState(players);
        gameState.nextNight();
        System.out.println(gameState.getWinners());
    }
}
