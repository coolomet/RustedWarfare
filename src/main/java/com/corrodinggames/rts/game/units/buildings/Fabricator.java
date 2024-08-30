package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.h
public strictfp class Fabricator extends class_91 {
    private static TeamImageCache a = null;
    private static TeamImageCache b = null;
    private static TeamImageCache c = null;
    private static TeamImageCache[] d = new TeamImageCache[10];
    private static TeamImageCache[] e = new TeamImageCache[10];
    private static TeamImageCache[] f = new TeamImageCache[10];
    private static TeamImageCache g = null;
    float h;
    float i = 0.0F;
    int j = 0;
    static class_226 k = new class_293(102);
    static class_226 l = new class_292(103);
    static ArrayList t = new ArrayList();

    public void a(GameOutputStream var1) {
        var1.writeFloat(this.h);
        var1.writeBoolean(this.r == 2);
        super.a(var1);
    }

    public void a(GameInputStream var1) {
        this.h = var1.readFloat();
        boolean var2 = var1.readBoolean();
        if (var1.b() < 51 && var2) {
            this.a(2);
        }

        super.a(var1);
    }

    public void R(int var1) {
        this.a(var1);
    }

    public UnitType b() {
        return UnitType.fabricator;
    }

    public static void K() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.power);
        b = var0.bO.a(AssetsID$drawable.power_t2);
        c = var0.bO.a(AssetsID$drawable.power_t3);
        d = PlayerData.a(a);
        e = PlayerData.a(b);
        f = PlayerData.a(c);
        g = var0.bO.a(AssetsID$drawable.power_dead);
    }

    public boolean L() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.a(this.xCord, this.yCord, this.zCord);
        this.M = g;
        this.S(0);
        this.bT = false;
        var1.bM.a(class_648.p, 0.8F, this.xCord, this.yCord);
        var1.bR.b(Priority.critical);
        class_998 var2 = var1.bR.c(this.xCord, this.yCord, this.zCord, -1127220);
        if (var2 != null) {
            var2.G = 0.15F;
            var2.F = 1.0F;
            var2.ar = 2;
            var2.V = 35.0F;
            var2.W = var2.V;
            var2.U = 0.0F;
            var2.x = -14492382;
        }

        this.bo();
        return true;
    }

    public TeamImageCache d() {
        if (this.bV) {
            return g;
        } else if (this.bX == null) {
            return d[d.length - 1];
        } else if (this.r == 1) {
            return d[this.bX.R()];
        } else if (this.r == 2) {
            return e[this.bX.R()];
        } else if (this.r == 3) {
            return f[this.bX.R()];
        } else {
            GameEngine.log("Unknown tech level:" + this.r);
            return d[this.bX.R()];
        }
    }

    public TeamImageCache k() {
        return null;
    }

    public Fabricator(boolean var1) {
        super(var1);
        this.M = a;
        this.a(this.M, 3);
        this.cj = 25.0F;
        this.ck = this.cj;
        this.totalHealth = 800.0F;
        this.health = this.totalHealth;
        this.n.a(-1, -1, 1, 1);
        this.o.a(this.n);
    }

    public void a(float var1) {
        super.a(var1);
        if (this.bT() && !this.bV) {
            this.i = class_340.a(this.i, var1);
            if (this.i == 0.0F) {
                this.i = 17.0F;
                ++this.j;
                if (this.j > 5) {
                    this.j = 0;
                }

                if (this.j <= 2) {
                    this.s = this.j;
                } else {
                    this.s = 5 - this.j;
                }
            }

            this.h += var1;
            if (this.h > PlayerData.ap - 0.1F) {
                this.h -= PlayerData.ap;
                this.bX.b(this.cy() * (PlayerData.ap / PlayerData.ao));
            }

        }
    }

    public float cy() {
        if (this.r == 1) {
            return 2.0F;
        } else {
            return this.r == 2 ? 7.0F : 14.0F;
        }
    }

    public void a(class_73 var1) {
        if (var1.j.equals(k.N())) {
            this.a(2);
            this.W();
        }

        if (var1.j.equals(l.N())) {
            this.a(3);
            this.W();
        }

    }

    public class_1059 cm() {
        if (this.r == 1) {
            return k.N();
        } else {
            return this.r == 2 ? l.N() : class_226.i;
        }
    }

    public int V() {
        return this.r;
    }

    public void a(int var1) {
        PlayerData.b((Unit)this);
        if (this.r > var1) {
            this.r = 1;
            this.totalHealth = 800.0F;
            if (this.health > this.totalHealth) {
                this.health = this.totalHealth;
            }
        }

        if (this.r < 2 && var1 >= 2) {
            this.totalHealth += 500.0F;
            this.health += 500.0F;
        }

        if (this.r < 3 && var1 >= 3) {
            this.totalHealth += 1300.0F;
            this.health += 1300.0F;
        }

        this.r = var1;
        PlayerData.c((Unit)this);
        this.S();
    }

    public ArrayList N() {
        return t;
    }

    public float db() {
        return super.db() - 8.0F;
    }

    public int bp() {
        return 12;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }

    static {
        t.add(k);
        t.add(l);
    }
}
