package com.corrodinggames.rts.gameFramework.steam;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.i.class_800;

public strictfp class SteamEngine {
    public static SteamEngine steamEngine = new SteamEngine();

    public static SteamEngine getSteamEngine() {
        return steamEngine;
    }

    public void b() {
        GameEngine.log("SteamEngine - blank init");
    }

    public void a(float var1) {
    }

    public String c() {
        return null;
    }

    public void d() {
        GameEngine.log("SteamEngine - disableSteam - already disabled");
    }

    public boolean e() {
        return !this.f();
    }

    public boolean f() {
        return true;
    }

    public void g() {
        GameEngine.log("disabledSteam - showInviteDialog");
        GameEngine.getGameEngine().i("steam API not connected");
    }

    public void h() {
        GameEngine.log("Steam: alertNotEnabled");
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1 != null) {
            var1.i("steam API not connected");
        }

    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
        GameEngine.log("disabledSteam - loadWorkshopMods");
    }

    public void m() {
        GameEngine.log("disabledSteam - showWorkshop");
    }

    public void a(class_800 var1) {
        GameEngine.log("disabledSteam - showWorkshopMod");
    }

    public void b(class_800 var1) {
        GameEngine.log("disabledSteam - publishWorkshopMod");
    }

    public void a(class_800 var1, boolean var2, String var3) {
        GameEngine.log("disabledSteam - uploadWorkshopMod");
    }
}
