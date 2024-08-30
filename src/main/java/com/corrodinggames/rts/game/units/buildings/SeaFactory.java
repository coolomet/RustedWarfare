package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_237;
import com.corrodinggames.rts.game.units.a.class_282;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.t
public strictfp class SeaFactory extends class_91 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    static TeamImageCache[] e = new TeamImageCache[10];
    static TeamImageCache f = null;
    static final class_1059 g = class_1059.a(String.valueOf(110));

    public static strictfp void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.sea_factory);
        b = var0.bO.a(AssetsID$drawable.sea_factory_t2);
        f = var0.bO.a(AssetsID$drawable.sea_factory_dead);
        d = PlayerData.a(a);
        e = PlayerData.a(b);
    }

    public strictfp UnitType K() {
        return UnitType.seaFactory;
    }

    public strictfp boolean L() {
        this.m = null;
        this.M = f;
        this.S(0);
        this.bT = false;
        this.a(ExplodeType.large);
        return true;
    }

    public strictfp TeamImageCache d() {
        if (this.bV) {
            return f;
        } else if (this.bX == null) {
            return d[d.length - 1];
        } else {
            return this.r == 1 ? d[this.bX.R()] : e[this.bX.R()];
        }
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public SeaFactory(boolean var1) {
        super(var1);
        this.M = a;
        this.b(a);
        this.cj = 45.0F;
        this.ck = this.cj;
        this.totalHealth = 1000.0F;
        this.health = this.totalHealth;
        this.S(2);
        this.n.a(-1, -1, 1, 2);
        this.o.a(-2, -1, 2, 4);
    }

    public strictfp void a(class_73 var1) {
        if (var1.j.equals(g)) {
            PlayerData.b((Unit)this);
            this.a(2);
            PlayerData.c((Unit)this);
            this.W();
        } else {
            super.a(var1);
        }

    }

    public strictfp int dv() {
        return -20;
    }

    public strictfp int V() {
        return this.r;
    }

    public strictfp void a(int var1) {
        if (var1 == 1) {
            this.r = 1;
        } else if (var1 == 2 && this.r == 1) {
            this.r = 2;
        }

        this.S();
    }

    public strictfp class_1059 cm() {
        return this.r == 1 ? g : class_226.i;
    }

    public static strictfp void a(ArrayList var0, int var1) {
        var0.add(new class_237());
        var0.add(new class_300());
        var0.add(new class_282(UnitType.builderShip, 1.0F));
        var0.add(new class_282(UnitType.gunBoat, 2.0F));
        var0.add(new class_282(UnitType.missileShip, 3.0F));
        var0.add(new class_282(UnitType.hovercraft, 4.0F));
        var0.add(new class_282(UnitType.battleShip, 5.0F));
        var0.add(new class_282(UnitType.attackSubmarine, 6.0F));
        if (var1 > 1) {
        }

    }

    public strictfp ArrayList N() {
        return this.K().a(this.V());
    }

    public strictfp boolean bJ() {
        return true;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }
}
