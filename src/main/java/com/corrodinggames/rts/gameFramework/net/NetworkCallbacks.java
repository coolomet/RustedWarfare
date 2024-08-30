package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.game.Player;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.ac
public strictfp class NetworkCallbacks {
    public boolean a(PlayerConnect var1, String var2, String var3) {
        return true;
    }

    public boolean a(PlayerConnect var1, PlayerData var2, String var3, boolean var4) {
        return true;
    }

    public void b(PlayerConnect var1, String var2, String var3) {
    }

    public void a(int var1, String var2, String var3, PlayerConnect var4) {
    }

    public String a(PlayerConnect var1, String var2) {
        return null;
    }

    public void c(PlayerConnect var1, String var2, String var3) {
    }

    public void b(PlayerConnect var1, String var2) {
    }

    public void a(PlayerData var1) {
    }

    public String a(PlayerConnect var1, String var2, int var3, int var4, String var5, Player var6) {
        GameEngine.log("new player Joining packageName:" + var5 + ", appVersion:" + var4 + ", playerName:" + var2 + " ip:" + var1.g() + " id:" + var1.connectIndex);
        return null;
    }

    public void a() {
    }

    public boolean a(PlayerConnect var1) {
        return false;
    }

    public boolean b(PlayerConnect var1) {
        return false;
    }

    public void startGame() {
        GameEngine.log("NetworkCallbacks:startGameEvent()");
    }

    public void c() {
    }

    public void a(EnterPasswordCallback var1) {
    }

    public void d() {
    }

    public boolean e() {
        return false;
    }
}
