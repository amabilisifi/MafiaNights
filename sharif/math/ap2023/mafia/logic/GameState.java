package ir.sharif.math.ap2023.mafia.logic;

import ir.sharif.math.ap2023.mafia.model.*;

import java.util.*;

public class GameState {
    protected List<Player> ListOfPlayers = new ArrayList<>();
    protected List<Player> ListOfAlivePlayers = new ArrayList<>();
    protected List<Player> ListOfDeadPlayersInLastRound = new ArrayList<>();
    protected Player executedPlayer;

    protected Player SilentPlayer;

    protected int round = 0;

    protected boolean IsDayNow = true;

    public GameState(List<Player> players) {
        // TODO
        for (int i = 0; i < players.size(); i++) {
            ListOfPlayers.add(players.get(i));
            ListOfAlivePlayers.add(players.get(i));
        }
    }

    public List<Player> allPlayers() {
        // TODO
        return ListOfPlayers;
    }

    public void nextDay() {
        // TODO
        round++;
        IsDayNow = true;
        int maxMafiaVote = 0;
        Player selectedPlayer = null;
        List<Player> deadOnes = new ArrayList<>();
        for (int i = 0; i < ListOfAlivePlayers.size(); i++) {
            if (ListOfAlivePlayers.get(i).getMafiaVote() > maxMafiaVote) {
                selectedPlayer = ListOfAlivePlayers.get(i);
                maxMafiaVote = selectedPlayer.getMafiaVote();
            }
        }
        if (selectedPlayer != null && !selectedPlayer.isHeal()) {
            selectedPlayer.setAlive(false);
            deadOnes.add(selectedPlayer);
            ListOfAlivePlayers.remove(selectedPlayer);
        }
        for (int i = 0; i < ListOfAlivePlayers.size(); i++) {
            if (!ListOfAlivePlayers.get(i).isAlive() && !ListOfAlivePlayers.get(i).isDeadByVote()) {
                deadOnes.add(ListOfAlivePlayers.get(i));
            }
        }
        ListOfDeadPlayersInLastRound = deadOnes;
        for (int i = 0; i < ListOfPlayers.size(); i++) {
            if (ListOfPlayers.get(i).isMute()) {
                SilentPlayer = ListOfPlayers.get(i);
            }
        }
        for (int i = 0; i < ListOfAlivePlayers.size(); i++) {
            if (ListOfAlivePlayers.get(i).getVoteNum() > ListOfAlivePlayers.size() / 2) {
                ListOfAlivePlayers.get(i).setAlive(false);
                ListOfAlivePlayers.remove(i);
                ListOfAlivePlayers.get(i).setDeadByVote(true);
                ListOfAlivePlayers.get(i).setDeadLastRound(false);
                ListOfAlivePlayers.remove(ListOfAlivePlayers.get(i));
            }
            ListOfPlayers.get(i).setVoteNum(0);
        }
    }

    public void nextNight() {
        // TODO
        executedPlayer = null;
        SilentPlayer = null;
        if (ListOfAlivePlayers.size() != 0) {
            for (int i = 0; i < ListOfAlivePlayers.size(); i++) {
                if (ListOfAlivePlayers.get(i).getVoteNum() > (double) ListOfAlivePlayers.size() / 2) {
                    ListOfAlivePlayers.get(i).setAlive(false);
                    ListOfAlivePlayers.get(i).setDeadByVote(true);
                    executedPlayer = ListOfAlivePlayers.get(i);
                    ListOfAlivePlayers.remove(i);
                }
            }
        }
        ListOfDeadPlayersInLastRound.clear();
        executedPlayer = getExecutedPlayer();
        IsDayNow = false;
        for (int i = 0; i < ListOfAlivePlayers.size(); i++) {
            ListOfAlivePlayers.get(i).setHeal(false);
            ListOfAlivePlayers.get(i).setMute(false);
            ListOfAlivePlayers.get(i).setDeadLastRound(false);
            ListOfAlivePlayers.get(i).setMafiaVote(0);
        }
    }

    public int getRound() {
        // TODO
        return round;
    }

    public List<Player> getAlivePlayers() {
        // TODO
        List<Player> AlivePlayers = new ArrayList<>();
        for (int i = 0; i < ListOfPlayers.size(); i++) {
            if (ListOfPlayers.get(i).isAlive()) {
                AlivePlayers.add(ListOfPlayers.get(i));
            }
        }
        ListOfAlivePlayers = AlivePlayers;
        return AlivePlayers;
    }

    public boolean isDay() {
        // TODO
        return IsDayNow;
    }

    public List<Player> getDeadPlayersInLastRound() {
        // TODO
        /**List<Player> deadPlayers = new ArrayList<>();
         for (int i = 0; i < ListOfPlayers.size(); i++) {
         if (!ListOfPlayers.get(i).isAlive() ) {
         //&& !ListOfPlayers.get(i).isDeadByVote()
         deadPlayers.add(ListOfPlayers.get(i));
         }
         }
         return deadPlayers;**/
        /***ListOfDeadPlayersInLastRound.add(getExecutedPlayer());
         for (int i = 0; i < ListOfDeadPlayersInLastRound.size(); i++) {
         Player temp = ListOfDeadPlayersInLastRound.get(i);
         ListOfDeadPlayersInLastRound.remove(i);
         if(!ListOfPlayers.contains(temp)){
         ListOfDeadPlayersInLastRound.add(temp);
         }
         }***/
        return ListOfDeadPlayersInLastRound;
    }

    public Player getSilentPlayerInLastRound() {
        // TODO
        return SilentPlayer;
    }

    public List<Player> getWinners() {
        // TODO
        int mafiaAlive = 0;
        int citizenAlive = 0;
        int jokerAlive = 0;
        List<Player> listOfCitizens = new ArrayList<>();
        List<Player> listOfMafias = new ArrayList<>();
        List<Player> listOfJokers = new ArrayList<>();
        for (int i = 0; i < ListOfPlayers.size(); i++) {
            if (ListOfPlayers.get(i) instanceof Mafia) {
                listOfMafias.add(ListOfPlayers.get(i));
                if (ListOfPlayers.get(i).isAlive())
                    mafiaAlive++;
            }
            if (ListOfPlayers.get(i) instanceof Citizen) {
                listOfCitizens.add(ListOfPlayers.get(i));
                if (ListOfPlayers.get(i).isAlive())
                    citizenAlive++;
            }
            if (ListOfPlayers.get(i) instanceof Joker) {
                listOfJokers.add(ListOfPlayers.get(i));
                jokerAlive++;
            }
        }
        if (executedPlayer instanceof Joker) {
            /** WINNER IS JOKER **/
            return listOfJokers;
        }
        if (mafiaAlive >= jokerAlive + citizenAlive) {
            /** WINNER IS MAFIA **/
            return listOfMafias;
        }
        if (mafiaAlive == 0) {
            /** WINNER IS CITIZENS **/
            return listOfCitizens;
        }
        return new ArrayList<>();

    }

    public List<Player> getListOfAlivePlayers() {
        return ListOfAlivePlayers;
    }

    public Player getExecutedPlayer() {
        return executedPlayer;
    }

}