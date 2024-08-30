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
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.a
public strictfp class AirFactory extends class_91 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache[] c = new TeamImageCache[10];
    static TeamImageCache[] d = new TeamImageCache[10];
    static TeamImageCache e = null;
    int f = 1;
    float g = 0.0F;
    static final class_1059 h = class_1059.a(String.valueOf(110));

    public strictfp void a(GameOutputStream var1) {
        var1.writeInt(this.f);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        if (var1.b() >= 17) {
            int var2 = var1.readInt();
            this.a(var2);
        }

        super.a(var1);
    }

    public static strictfp void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.air_factory);
        b = var0.bO.a(AssetsID$drawable.air_factory_t2);
        e = var0.bO.a(AssetsID$drawable.air_factory_dead);
        c = PlayerData.a(a);
        d = PlayerData.a(b);
    }

    public strictfp UnitType K() {
        return UnitType.airFactory;
    }

    public strictfp boolean L() {
        this.M = e;
        this.S(0);
        this.bT = false;
        this.a((ExplodeType) ExplodeType.large);
        return true;
    }

    public strictfp TeamImageCache d() {
        if (this.bV) {
            return e;
        } else if (this.bX == null) {
            return c[c.length - 1];
        } else {
            return this.f == 1 ? c[this.bX.R()] : d[this.bX.R()];
        }
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public AirFactory(boolean var1) {
        super(var1);
        this.M = a;
        this.T(40);
        this.U(61);
        this.cj = 30.0F;
        this.ck = this.cj;
        this.totalHealth = 1000.0F;
        this.health = this.totalHealth;
        this.n.a(-1, -1, 1, 1);
        this.o.a(-1, -1, 1, 2);
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.bT() && !this.bV) {
            this.g = class_340.a(this.g, var1);
            if (this.g == 0.0F) {
                this.g = 27.0F;
                ++this.s;
                if (this.s > 4) {
                    this.s = 0;
                }
            }

        }
    }

    public strictfp void a(class_73 var1) {
        if (var1.j.equals(h)) {
            PlayerData.b((Unit)this);
            this.a(2);
            PlayerData.c((Unit)this);
            this.W();
        } else {
            super.a(var1);
        }

    }

    public strictfp int V() {
        return this.f;
    }

    public strictfp void a(int var1) {
        if (var1 == 1) {
            this.f = 1;
        } else if (var1 == 2 && this.f == 1) {
            this.f = 2;
        }

        this.S();
    }

    public strictfp class_1059 cm() {
        return this.f == 1 ? h : class_226.i;
    }

    public static strictfp void a(ArrayList var0, int var1) {
        var0.add(new class_237());
        if (var1 == 1) {
            var0.add(new class_297());
        }

        if (var1 > 1) {
            var0.add(new class_282(UnitType.dropship, 3.2F));
            var0.add(new class_282(UnitType.gunShip, 4.0F));
            var0.add(new class_282(UnitType.amphibiousJet, 5.0F));
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
