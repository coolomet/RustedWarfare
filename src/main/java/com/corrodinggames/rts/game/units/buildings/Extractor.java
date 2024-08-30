package com.corrodinggames.rts.game.units.buildings;

import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.class_482;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.Emitter;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.g
public strictfp class Extractor extends class_91 {
    float a;
    int b = 1;
    float c = 0.0F;
    int d = 0;
    static TeamImageCache[] e = new TeamImageCache[10];
    static TeamImageCache[] f = new TeamImageCache[10];
    static TeamImageCache[] g = new TeamImageCache[10];
    static TeamImageCache h = null;
    static TeamImageCache i = null;
    Rect j = new Rect();
    Rect k = new Rect();
    public static int l = 0;
    static class_226 t = new class_284(102);
    static class_226 u = new class_285(103);
    static ArrayList v = new ArrayList();
    static ArrayList w;
    static ArrayList x;

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.a);
        var1.writeBoolean(this.b > 1);
        var1.writeInt(this.b);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.a = var1.readFloat();
        int var2 = 1;
        boolean var3 = var1.readBoolean();
        if (var3) {
            var2 = 2;
        }

        if (var1.b() >= 31) {
            var2 = var1.readInt();
        }

        if (var2 != 1) {
            this.a(var2);
        }

        super.a(var1);
    }

    public strictfp UnitType b() {
        return UnitType.extractor;
    }

    public strictfp boolean c(PlayerData var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var2.bL.a(this.xCord, this.yCord);
        class_482 var3 = var2.bL.e(var2.bL.T, var2.bL.U);
        return var3 != null && var3.i ? super.c(var1) : false;
    }

    public static strictfp void K() {
        GameEngine var0 = GameEngine.getGameEngine();
        TeamImageCache var1 = var0.bO.a(AssetsID$drawable.extractor);
        TeamImageCache var2 = var0.bO.a(AssetsID$drawable.extractor_t2);
        TeamImageCache var3 = var0.bO.a(AssetsID$drawable.extractor_t3);
        i = var0.bO.a(AssetsID$drawable.extractor_dead);
        e = PlayerData.a(var1);
        f = PlayerData.a(var2);
        g = PlayerData.a(var3);
        var1.n();
        var2.n();
        var3.n();
        h = var0.bO.a(AssetsID$drawable.extractor_back);
    }

    public strictfp boolean L() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.a(this.xCord, this.yCord, this.zCord);
        this.M = i;
        this.m = null;
        this.S(0);
        this.bT = false;
        var1.bM.a(class_648.p, 0.8F, this.xCord, this.yCord);
        Emitter var2 = Emitter.a(this.xCord, this.yCord);
        var2.j = -6684775;
        Emitter var3 = Emitter.b(this.xCord, this.yCord);
        var3.a = 500.0F;
        var3.j = -6684775;
        var1.bR.b(Priority.critical);
        class_998 var4 = var1.bR.c(this.xCord, this.yCord, this.zCord, -1127220);
        if (var4 != null) {
            var4.G = 0.15F;
            var4.F = 1.0F;
            var4.ar = 2;
            var4.V = 35.0F;
            var4.W = var4.V;
            var4.U = 0.0F;
            var4.x = -13378253;
        }

        this.bo();
        return false;
    }

    public strictfp int bp() {
        return 16;
    }

    public strictfp void S() {
        super.S();
        if (this.bV) {
            this.m = null;
        } else {
            this.m = h;
        }

    }

    public strictfp boolean ds() {
        return true;
    }

    public strictfp TeamImageCache d() {
        if (this.bV) {
            return i;
        } else if (this.bX == null) {
            return e[e.length - 1];
        } else if (this.b == 3) {
            return g[this.bX.R()];
        } else {
            return this.b == 2 ? f[this.bX.R()] : e[this.bX.R()];
        }
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public Extractor(boolean var1) {
        super(var1);
        this.M = e[9];
        this.T(37);
        this.U(56);
        this.cj = 18.0F;
        this.ck = this.cj;
        this.totalHealth = 800.0F;
        this.health = this.totalHealth;
        this.n.a(0, -1, 0, 0);
        this.o.a(this.n);
        this.S();
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.bT() && !this.bV) {
            this.c = class_340.a(this.c, var1 * (float)this.b);
            if (this.c == 0.0F) {
                this.c = 17.0F;
                ++this.d;
                if (this.d > 7) {
                    this.d = 0;
                }

                if (this.d <= 3) {
                    this.s = this.d;
                } else {
                    this.s = 7 - this.d;
                }
            }

            this.a += var1;
            if (this.a > PlayerData.ap - 0.1F) {
                this.a -= PlayerData.ap;
                this.bX.b(this.cy() * (PlayerData.ap / PlayerData.ao));
            }

        }
    }

    public strictfp float cy() {
        if (this.b == 3) {
            return 18.0F;
        } else {
            return this.b == 2 ? 12.0F : 8.0F;
        }
    }

    public strictfp boolean c(float var1) {
        return super.c(var1);
    }

    public strictfp boolean l() {
        return false;
    }

    public strictfp void a(Unit var1, int var2) {
        throw new RuntimeException("Unit cannot shoot");
    }

    public strictfp float attackRange() {
        return 0.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 0.0F;
    }

    public strictfp float c(int var1) {
        return 0.0F;
    }

    public strictfp void a(class_73 var1) {
        if (var1.j.equals(t.N())) {
            this.a(2);
            this.W();
        }

        if (var1.j.equals(u.N())) {
            this.a(3);
            this.W();
        }

    }

    public strictfp class_1059 cm() {
        if (this.b == 1) {
            return t.N();
        } else {
            return this.b == 2 ? u.N() : class_226.i;
        }
    }

    public strictfp int V() {
        return this.b;
    }

    public strictfp void a(int var1) {
        PlayerData.b((Unit)this);
        if (this.b > var1) {
            this.b = 1;
            this.totalHealth = 800.0F;
            if (this.health > this.totalHealth) {
                this.health = this.totalHealth;
            }
        }

        if (this.b < 2 && var1 >= 2) {
            this.totalHealth += 200.0F;
            this.health += 200.0F;
        }

        if (this.b < 3 && var1 >= 3) {
            this.totalHealth += 1000.0F;
            this.health += 1000.0F;
        }

        this.b = var1;
        PlayerData.c((Unit)this);
        this.S();
    }

    public strictfp ArrayList N() {
        if (this.b == 1) {
            return v;
        } else {
            return this.b == 2 ? w : x;
        }
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }

    static {
        v.add(t);
        w = new ArrayList();
        w.add(u);
        x = new ArrayList();
    }
}
