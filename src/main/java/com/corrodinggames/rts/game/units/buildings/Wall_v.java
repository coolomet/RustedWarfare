package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.w
public strictfp class Wall_v extends class_91 {
    static TeamImageCache a = null;
    static TeamImageCache[] b = new TeamImageCache[10];
    static TeamImageCache c = null;

    public static strictfp void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.wall_v);
        c = var0.bO.a(AssetsID$drawable.wall_v);
        b = PlayerData.a(a);
    }

    public strictfp TeamImageCache d() {
        if (this.bV) {
            return c;
        } else {
            return this.bX == null ? b[b.length - 1] : b[this.bX.R()];
        }
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public strictfp void a(int var1) {
    }

    public Wall_v(boolean var1) {
        super(var1);
        this.b(a);
        this.cj = 15.0F;
        this.ck = this.cj;
        this.totalHealth = 700.0F;
        this.health = this.totalHealth;
        this.M = a;
        this.n.a(0, 0, 1, 0);
        this.o.a(0, 0, 1, 0);
    }

    public strictfp UnitType K() {
        return UnitType.wall_v;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }
}
