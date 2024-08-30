package com.codedisaster.steamworks;

public class SteamLeaderboardEntry {
    long steamIDUser;
    int globalRank;
    int score;
    int details;

    public SteamID getSteamIDUser() {
        return new SteamID(this.steamIDUser);
    }

    public int getGlobalRank() {
        return this.globalRank;
    }

    public int getScore() {
        return this.score;
    }

    public int getNumDetails() {
        return this.details;
    }
}
