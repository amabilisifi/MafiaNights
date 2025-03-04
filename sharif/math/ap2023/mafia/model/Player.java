package ir.sharif.math.ap2023.mafia.model;

public abstract class Player {
    protected int id;
    protected String name;
    protected boolean alive = true;
    protected boolean mute = false;
    protected boolean heal = false;
    protected int voteNum = 0;
    protected boolean deadByVote = false;
    protected int mafiaVote = 0;
    protected boolean isDeadBySniper = false;
    protected boolean isDeadByGodfather = false;
    protected boolean isDeadLastRound = false;

    public Player(String name, int id) {
        // TODO
        this.name = name;
        this.id = id;

    }

    public abstract String action(Player target);

    public void vote(Player target) {
        // TODO
        target.voteNum++;
    }
    // TODO:
    //  add getter setters and other methods you need

    public boolean isHeal() {
        return heal;
    }

    public boolean isDeadByGodfather() {
        return isDeadByGodfather;
    }

    public void setDeadByGodfather(boolean deadByGodfather) {
        isDeadByGodfather = deadByGodfather;
    }

    public boolean isDeadLastRound() {
        return isDeadLastRound;
    }

    public void setDeadLastRound(boolean deadLastRound) {
        isDeadLastRound = deadLastRound;
    }

    public int getMafiaVote() {
        return mafiaVote;
    }

    public void setMafiaVote(int mafiaVote) {
        this.mafiaVote = mafiaVote;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setHeal(boolean heal) {
        this.heal = heal;
    }

    public boolean isDeadByVote() {
        return deadByVote;
    }

    public void setDeadByVote(boolean deadByVote) {
        this.deadByVote = deadByVote;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(Boolean s) {
        this.alive = s;
    }

    public boolean isMute() {
        return mute;
    }

    public boolean isDeadBySniper() {
        return isDeadBySniper;
    }

    public void setDeadBySniper(boolean deadBySniper) {
        isDeadBySniper = deadBySniper;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }
}