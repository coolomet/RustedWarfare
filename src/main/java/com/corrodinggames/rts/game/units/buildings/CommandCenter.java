package com.corrodinggames.rts.game.units.buildings;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_237;
import com.corrodinggames.rts.game.units.a.class_282;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.Emitter;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.e
public strictfp class CommandCenter extends class_91 {
    static TeamImageCache a = null;
    static TeamImageCache[] b = new TeamImageCache[10];
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    float e;
    public float f;
    public float g;
    public int h;
    public float i;
    public float j;
    float k = 20.0F;
    int l = 0;

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.e);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.e = var1.readFloat();
        super.a(var1);
    }

    public static strictfp void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.base);
        c = var0.bO.a(AssetsID$drawable.base_dead);
        d = var0.bO.a(AssetsID$drawable.base_back);
        b = PlayerData.a(a);
    }

    public strictfp UnitType K() {
        return UnitType.commandCenter;
    }

    public strictfp boolean L() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.M = c;
        this.m = null;
        this.S(0);
        this.bT = false;
        this.a((ExplodeType) ExplodeType.large);
        float var2 = this.xCord;
        float var3 = this.yCord;
        float var4 = 0.0F;
        var1.bR.b(Priority.critical);
        class_998 var5 = var1.bR.a(var2, var3, this.zCord, Color.a(255, 255, 255, 255));
        if (var5 != null) {
            var5.G = 8.0F;
            var5.F = 5.0F;
            var5.E = 0.9F;
            var5.V = 20.0F;
            var5.W = var5.V;
            var5.r = true;
        }

        var1.bR.b(Priority.critical);
        var5 = var1.bR.c(var2, var3, var4, -1127220);
        if (var5 != null) {
            var5.G = 0.2F;
            var5.F = 2.0F;
            var5.ar = 2;
            var5.V = 45.0F;
            var5.W = var5.V;
            var5.U = 0.0F;
        }

        float var6 = 40.0F;
        float var7 = 70.0F;
        var1.bR.a(this.xCord, this.yCord, this.zCord, var6, var7);
        Emitter.a(this.xCord, this.yCord);
        Emitter.b(this.xCord, this.yCord).a = 800.0F;
        return true;
    }

    public strictfp void a(int var1) {
    }

    public strictfp void S() {
        super.S();
        if (this.bV) {
            this.m = null;
        } else {
            this.m = d;
        }

    }

    public strictfp TeamImageCache d() {
        return this.bV ? c : b[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public CommandCenter(boolean var1) {
        super(var1);
        this.M = a;
        this.m = d;
        this.T(53);
        this.U(68);
        this.cj = 30.0F;
        this.ck = this.cj;
        this.totalHealth = 4000.0F;
        this.health = this.totalHealth;
        this.S(3);
        this.n.a(-1, -1, 1, 1);
        this.o.a(-1, -1, 1, 2);
    }

    public strictfp RectF cF() {
        RectF var1 = super.cF();
        var1.a(6.0F, 0.0F);
        return var1;
    }

    public strictfp void a(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        super.a(var1);
        if (this.bT() && !this.bV) {
            this.k = class_340.a(this.k, var1);
            if (this.k == 0.0F) {
                this.k = 5.0F;
                ++this.l;
                if (this.l > 6) {
                    this.l = 0;
                    this.k = 70.0F;
                }

                if (this.l <= 3) {
                    this.s = this.l;
                } else {
                    this.s = 6 - this.l;
                }
            }

            this.f += var1;
            ++this.h;
            this.i += 10.0F;
            if (this.j > var1) {
                this.j = var1;
            }

            this.g += var1;
            this.e += var1;
            if (this.e > PlayerData.ap - 0.1F) {
                this.e -= PlayerData.ap;
                this.bX.b(this.cy() * (PlayerData.ap / PlayerData.ao));
            }

        }
    }

    public strictfp float cy() {
        return 18.0F;
    }

    public strictfp float q(int var1) {
        return 70.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        Projectile var3 = Projectile.a(this, this.xCord, this.yCord);
        PointF var4 = this.K(var2);
        var3.K = var4.x;
        var3.L = var4.y;
        var3.ar = Color.a(255, 230, 230, 50);
        var3.U = this.q(var2);
        var3.l = var1;
        var3.h = 180.0F;
        var3.t = 2.0F;
        var3.r = 5.0F;
        var3.aH = true;
        var3.aM = true;
        var3.aQ = true;
        var3.aG = true;
        GameEngine var5 = GameEngine.getGameEngine();
        var5.bR.a(var3, -1118720);
        var5.bM.a(class_648.m, 0.8F, this.xCord, this.yCord);
    }

    public strictfp float attackRange() {
        return 280.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 70.0F;
    }

    public strictfp float c(int var1) {
        return 999.0F;
    }

    public strictfp boolean b(int var1, float var2) {
        return false;
    }

    public strictfp boolean l() {
        return true;
    }

    public static strictfp void a(ArrayList var0, int var1) {
        var0.add(new class_237());
        var0.add(new class_282(UnitType.builder, 1.0F));
    }

    public strictfp ArrayList N() {
        return this.K().a(this.V());
    }

    public strictfp float a(Unit var1, float var2, Projectile var3) {
        if (var2 > 2500.0F) {
            var2 = 2500.0F;
        }

        return super.a(var1, var2, var3);
    }

    public strictfp boolean bJ() {
        return true;
    }

    public strictfp void e(float var1) {
        super.e(var1);
        float var2 = this.attackRange();
        class_694.a(this, var2);
    }

    public strictfp int s() {
        return 20;
    }

    public strictfp int bp() {
        return 35;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }
}
