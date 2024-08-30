package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_237;
import com.corrodinggames.rts.game.units.a.class_282;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.m
public strictfp class LandFactory extends class_91 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    static TeamImageCache[] e = new TeamImageCache[10];
    static TeamImageCache f = null;
    boolean g;
    static final class_1059 h = class_1059.a(String.valueOf(110));

    public strictfp void a(GameOutputStream var1) {
        var1.writeBoolean(this.g);
        var1.writeByte(0);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        boolean var2 = var1.readBoolean();
        if (var2) {
            this.a(2);
        }

        var1.readByte();
        super.a(var1);
    }

    public static strictfp void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.land_factory_front);
        b = var0.bO.a(AssetsID$drawable.land_factory_front_t2);
        c = var0.bO.a(AssetsID$drawable.land_factory_back);
        f = var0.bO.a(AssetsID$drawable.land_factory_dead);
        d = PlayerData.a(a);
        e = PlayerData.a(b);
    }

    public strictfp UnitType K() {
        return UnitType.landFactory;
    }

    public strictfp boolean L() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.a(this.xCord, this.yCord, this.zCord);
        this.m = null;
        this.M = f;
        this.S(0);
        this.bT = false;
        var1.bM.a(class_648.p, 0.8F, this.xCord, this.yCord);
        return true;
    }

    public strictfp void S() {
        super.S();
        if (this.bV) {
            this.m = null;
        } else {
            this.m = c;
        }

    }

    public strictfp TeamImageCache d() {
        if (this.bV) {
            return f;
        } else if (this.bX == null) {
            return d[d.length - 1];
        } else {
            return !this.g ? d[this.bX.R()] : e[this.bX.R()];
        }
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public LandFactory(boolean var1) {
        super(var1);
        this.M = a;
        this.m = c;
        this.b(this.M);
        this.cj = 30.0F;
        this.ck = this.cj;
        this.totalHealth = 1200.0F;
        this.health = this.totalHealth;
        this.S(3);
        this.n.a(-1, -1, 1, 1);
        this.o.a(-1, -1, 1, 3);
    }

    public strictfp void a(class_73 var1) {
        if (h.a(var1.j)) {
            PlayerData.b((Unit)this);
            this.a(2);
            PlayerData.c((Unit)this);
            this.W();
        } else {
            super.a(var1);
        }

    }

    public strictfp void a(int var1) {
        if (var1 == 1) {
            this.g = false;
        } else if (var1 == 2 && !this.g) {
            this.g = true;
        }

        this.S();
    }

    public strictfp class_1059 cm() {
        return !this.g ? h : class_226.i;
    }

    public static strictfp void a(ArrayList var0, int var1) {
        var0.add(new class_237());
        if (var1 == 1) {
            var0.add(new class_299());
        }

        var0.add(new class_282(UnitType.builder, 1.0F));
        var0.add(new class_282(UnitType.tank, 2.0F));
        var0.add(new class_282(UnitType.hoverTank, 3.0F));
        var0.add(new class_282(UnitType.artillery, 4.0F));
        if (var1 >= 2) {
            var0.add(new class_282(UnitType.hovercraft, 5.0F));
            var0.add(new class_282(UnitType.heavyTank, 6.0F));
            var0.add(new class_282(UnitType.heavyHoverTank, 7.0F));
            var0.add(new class_282(UnitType.laserTank, 8.0F));
        }

    }

    public strictfp ArrayList N() {
        return this.K().a(this.V());
    }

    public strictfp int V() {
        return this.g ? 2 : 1;
    }

    public strictfp class_320 du() {
        return new class_321(this);
    }

    public strictfp boolean bJ() {
        return true;
    }

    public strictfp float db() {
        return super.db() - 8.0F;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }
}
