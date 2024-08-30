package com.corrodinggames.rts.gameFramework.g;

import com.corrodinggames.rts.game.PlayerData;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.g.e
public strictfp class class_167 extends class_165 {
    private final PlayerData a;

    public class_167(PlayerData var1) {
        this.a = var1;
    }

    public boolean a() {
        return false;
    }

    public String b() {
        return this.a.name == null ? "" : this.a.name;
    }

    public int c() {
        return this.a.K();
    }

    public int d() {
        return -1;
    }

    public int a(class_173 var1) {
        return var1.a(this.a);
    }
}
