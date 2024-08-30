package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.v
public strictfp class SupplyDepot extends class_91 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache[] c = new TeamImageCache[10];
    static TeamImageCache[] d = new TeamImageCache[10];
    static TeamImageCache e = null;
    int f = 1;
    float g = 0.0F;
    int h = 0;
    public static int i = 0;
    static class_226 j = new class_295(102);
    static ArrayList k = new ArrayList();

    public void a(GameOutputStream var1) {
        var1.writeInt(this.f);
        super.a(var1);
    }

    public void a(GameInputStream var1) {
        int var2 = var1.readInt();
        this.a(var2);
        super.a(var1);
    }

    public UnitType b() {
        return UnitType.supplyDepot;
    }

    public static void K() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.supply_depot);
        b = var0.bO.a(AssetsID$drawable.supply_depot_t2);
        c = PlayerData.a(a);
        d = PlayerData.a(b);
        e = var0.bO.a(AssetsID$drawable.supply_depot_dead);
    }

    public boolean L() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.a(this.xCord, this.yCord, this.zCord);
        this.M = e;
        this.S(0);
        this.bT = false;
        var1.bM.a(class_648.p, 0.8F, this.xCord, this.yCord);
        return false;
    }

    public TeamImageCache d() {
        if (this.bV) {
            return e;
        } else if (this.bX == null) {
            return c[c.length - 1];
        } else {
            return this.f == 1 ? c[this.bX.R()] : d[this.bX.R()];
        }
    }

    public TeamImageCache k() {
        return null;
    }

    public SupplyDepot(boolean var1) {
        super(var1);
        this.M = a;
        this.a(this.M, 1);
        this.cj = 20.0F;
        this.ck = this.cj;
        this.totalHealth = 800.0F;
        this.health = this.totalHealth;
        this.n.a(-1, -1, 0, 0);
        this.o.a(this.n);
    }

    public void a(float var1) {
        super.a(var1);
        if (!this.bT() || this.bV) {
            ;
        }
    }

    public void a(class_73 var1) {
        if (var1.j.equals(j.N())) {
            this.M();
            this.W();
        }

    }

    public void a(int var1) {
        this.f = var1;
    }

    public void M() {
        if (this.f == 1) {
            this.f = 2;
            this.S();
        }

    }

    public class_1059 cm() {
        return this.f == 1 ? j.N() : class_226.i;
    }

    public ArrayList N() {
        return k;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }

    static {
        k.add(j);
    }
}
