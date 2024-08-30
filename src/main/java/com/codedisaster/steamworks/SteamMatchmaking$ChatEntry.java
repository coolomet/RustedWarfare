package com.codedisaster.steamworks;

public class SteamMatchmaking$ChatEntry {
    private long steamIDUser;
    private int chatEntryType;

    public SteamID getSteamIDUser() {
        return new SteamID(this.steamIDUser);
    }

    public SteamMatchmaking$ChatEntryType getChatEntryType() {
        return SteamMatchmaking$ChatEntryType.byCode(this.chatEntryType);
    }
}
