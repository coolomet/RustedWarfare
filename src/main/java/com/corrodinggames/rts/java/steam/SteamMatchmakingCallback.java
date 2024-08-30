package com.corrodinggames.rts.java.steam;

import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamMatchmaking$ChatEntryType;
import com.codedisaster.steamworks.SteamMatchmaking$ChatMemberStateChange;
import com.codedisaster.steamworks.SteamMatchmaking$ChatRoomEnterResponse;
import com.codedisaster.steamworks.SteamResult;
import com.corrodinggames.rts.gameFramework.GameEngine;

public strictfp class SteamMatchmakingCallback implements com.codedisaster.steamworks.SteamMatchmakingCallback {
    SteamEngine a;

    public SteamMatchmakingCallback(SteamEngine var1) {
        this.a = var1;
    }

    public void onFavoritesListChanged(int var1, int var2, int var3, int var4, int var5, boolean var6, int var7) {
        GameEngine.log("onFavoritesListChanged");
    }

    public void onLobbyInvite(SteamID var1, SteamID var2, long var3) {
        GameEngine.log("onLobbyInvite");
        SteamData var5 = new SteamData(this.a, var1, var2, var3);
        var5.a();
    }

    public void onLobbyEnter(SteamID var1, int var2, boolean var3, SteamMatchmaking$ChatRoomEnterResponse var4) {
        GameEngine.log("onLobbyEnter");
        if (var3) {
            GameEngine.log("onLobbyEnter blocked: " + var4);
        }

        this.a.c(var1);
    }

    public void onLobbyDataUpdate(SteamID var1, SteamID var2, boolean var3) {
        GameEngine.log("onLobbyDataUpdate success: " + var3);
    }

    public void onLobbyChatUpdate(SteamID var1, SteamID var2, SteamID var3, SteamMatchmaking$ChatMemberStateChange var4) {
        GameEngine.log("onLobbyChatUpdate steamIDUserChanged: " + var2 + " stateChange:" + var4);
    }

    public void onLobbyChatMessage(SteamID var1, SteamID var2, SteamMatchmaking$ChatEntryType var3, int var4) {
        GameEngine.log("onLobbyChatMessage");
    }

    public void onLobbyGameCreated(SteamID var1, SteamID var2, int var3, short var4) {
        GameEngine.log("onLobbyGameCreated");
        this.a.a(var1);
    }

    public void onLobbyMatchList(int var1) {
        GameEngine.log("onLobbyMatchList");
    }

    public void onLobbyKicked(SteamID var1, SteamID var2, boolean var3) {
        GameEngine.log("onLobbyKicked");
    }

    public void onLobbyCreated(SteamResult var1, SteamID var2) {
        GameEngine.log("onLobbyCreated");
        this.a.a(var2);
    }

    public void onFavoritesListAccountsUpdated(SteamResult var1) {
        GameEngine.log("onFavoritesListAccountsUpdated");
    }
}
