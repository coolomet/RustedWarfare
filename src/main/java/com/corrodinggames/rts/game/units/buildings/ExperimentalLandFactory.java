package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_237;
import com.corrodinggames.rts.game.units.a.class_282;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.f
public strictfp class ExperimentalLandFactory extends class_91 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache[] c = new TeamImageCache[10];
    static TeamImageCache[] d = new TeamImageCache[10];
    static TeamImageCache e = null;
    boolean f;
    static class_226 g = new class_296(110);

    public strictfp void a(GameOutputStream var1) {
        var1.writeBoolean(this.f);
        var1.writeByte(0);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        boolean var2 = var1.readBoolean();
        if (var2) {
            this.M();
        }

        var1.readByte();
        super.a(var1);
    }

    public static strictfp void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.experimental_unit_factory_front);
        b = var0.bO.a(AssetsID$drawable.experimental_unit_factory_base);
        e = var0.bO.a(AssetsID$drawable.experimental_unit_factory_dead);
        c = PlayerData.a(a);
    }

    public strictfp UnitType K() {
        return UnitType.experimentalLandFactory;
    }

    public strictfp boolean L() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.m = null;
        this.M = e;
        this.S(0);
        this.bT = false;
        this.a((ExplodeType) ExplodeType.verylargeBuilding);
        return true;
    }

    public strictfp void a(int var1) {
    }

    public strictfp TeamImageCache d() {
        if (this.bV) {
            return e;
        } else if (this.bX == null) {
            return c[c.length - 1];
        } else {
            return !this.f ? c[this.bX.R()] : d[this.bX.R()];
        }
    }

    public strictfp void S() {
        super.S();
        if (this.bV) {
            this.m = null;
        } else {
            this.m = b;
        }

    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public ExperimentalLandFactory(boolean var1) {
        super(var1);
        this.M = a;
        this.m = b;
        this.b(this.M);
        this.cj = 55.0F;
        this.ck = this.cj;
        this.totalHealth = 3200.0F;
        this.health = this.totalHealth;
        this.S(4);
        this.n.a(-2, -2, 2, 2);
        this.o.a(-2, -2, 2, 4);
    }

    public strictfp void a(class_73 var1) {
        if (var1.j.equals(g.N())) {
            this.M();
        } else {
            super.a(var1);
        }

    }

    public strictfp void M() {
        if (!this.f) {
            this.f = true;
            this.S();
        }

    }

    public strictfp class_1059 cm() {
        return class_226.i;
    }

    public static strictfp void a(ArrayList var0, int var1) {
        var0.add(new class_237());
        var0.add(new class_282(UnitType.experimentalTank, 2.0F));
        var0.add(new class_282(UnitType.experimentalHoverTank, 3.0F));
    }

    public strictfp ArrayList N() {
        return this.K().a(this.V());
    }

    public strictfp boolean bJ() {
        return true;
    }

    public strictfp int V() {
        return 2;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }
}
