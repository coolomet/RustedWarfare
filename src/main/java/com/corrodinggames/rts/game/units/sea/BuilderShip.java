package com.corrodinggames.rts.game.units.sea;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_26;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_234;
import com.corrodinggames.rts.game.units.a.class_241;
import com.corrodinggames.rts.game.units.land.Builder;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.b
public strictfp class BuilderShip extends class_114 implements class_26 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static TeamImageCache[] e = new TeamImageCache[10];
    PointF[] f = new PointF[6];
    PointF[] g;
    Rect h;
    static class_226 i = new class_234(false);

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : Builder.h[this.bX.R()];
    }

    public strictfp UnitType f() {
        return UnitType.builderShip;
    }

    public strictfp PointF[] b() {
        return this.f;
    }

    public strictfp PointF[] e_() {
        return this.g;
    }

    public strictfp float mass() {
        return 6000.0F;
    }

    public static strictfp void t_() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.builder_ship);
        a = var0.bO.a(AssetsID$drawable.builder_ship_dead);
        c = var0.bO.a(AssetsID$drawable.builder_ship_turret);
        e = PlayerData.a(b);
        d = a(b, b.m(), b.l());
    }

    public strictfp TeamImageCache d() {
        return this.bV ? a : e[this.bX.R()];
    }

    public strictfp TeamImageCache d(int var1) {
        return c;
    }

    public strictfp TeamImageCache k() {
        return d;
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && this.zCord > -2.0F;
    }

    public strictfp float G() {
        return 3.0F;
    }

    public strictfp float H() {
        return 3.0F;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        this.M = a;
        this.S(0);
        this.bT = false;
        return true;
    }

    public BuilderShip(boolean var1) {
        super(var1);
        this.g = new PointF[this.f.length];
        this.h = new Rect();
        this.b(b);
        this.cj = 13.0F;
        this.ck = this.cj;
        this.totalHealth = 500.0F;
        this.health = this.totalHealth;
        this.M = b;

        for(int var2 = 0; var2 < this.f.length; ++var2) {
            this.f[var2] = new PointF();
            this.g[var2] = new PointF();
        }

    }

    public strictfp float attackRange() {
        return 240.0F;
    }

    public strictfp float speed() {
        return 0.8F;
    }

    public strictfp float turnSpeed() {
        return 1.9F;
    }

    public strictfp float B() {
        return 0.12F;
    }

    public strictfp float c(int var1) {
        return 3.5F;
    }

    public strictfp float w(int var1) {
        return 0.25F;
    }

    public strictfp float C() {
        return 0.03F;
    }

    public strictfp float D() {
        return 0.1F;
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV) {
            Builder.a(var1, this);
        }

    }

    public strictfp void a(float var1, boolean var2) {
        super.a(var1, var2);
        if (!this.bV) {
            Builder.b(var1, this);
        }

    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            GameEngine var2 = GameEngine.getGameEngine();
            class_694.a((OrderableUnit)this);
            if (!this.bV) {
                float var3 = this.cL[0].f / this.e(0);
                if (var3 != 0.0F) {
                    PointF var4 = this.E(0);
                    var2.bO.i();
                    var2.bO.b(var4.x - var2.cw, var4.y - var2.cx - this.zCord);
                    var2.bO.a(var3, var3);
                    if (this.Y()) {
                        var2.bO.a((TeamImageCache) Builder.f, 0.0F, 0.0F, (Paint)null);
                    } else {
                        var2.bO.a((TeamImageCache) Builder.e, 0.0F, 0.0F, (Paint)null);
                    }

                    var2.bO.j();
                }
            }

            return true;
        }
    }

    public strictfp boolean l() {
        return false;
    }

    public strictfp float g(int var1) {
        return 11.0F;
    }

    public strictfp int bl() {
        return 1;
    }

    public strictfp PointF G(int var1) {
        float var2 = 8.0F;
        float var3 = this.xCord + class_340.k(this.cg) * var2;
        float var4 = this.yCord + class_340.j(this.cg) * var2;
        bh.setSite(var3, var4);
        return bh;
    }

    public strictfp float shootDelay(int var1) {
        return (float)(120 - var1 * 28);
    }

    public strictfp float e(int var1) {
        return 30.0F;
    }

    public strictfp float f(int var1) {
        return 1.3F;
    }

    public strictfp boolean a(Unit var1) {
        if (var1.q()) {
            return false;
        } else {
            return var1.bI();
        }
    }

    public strictfp void a(class_226 var1, boolean var2) {
    }

    public static strictfp void a(ArrayList var0, int var1) {
        var0.add(i);
        var0.add(new class_241(UnitType.extractor, 1, 1));
        var0.add(new class_241(UnitType.turret, 1, 2));
        var0.add(new class_241(UnitType.antiAirTurret, 1, 3));
        var0.add(new class_241(UnitType.landFactory, 1, 4));
        var0.add(new class_241(UnitType.airFactory, 1, 5));
        var0.add(new class_241(UnitType.seaFactory, 1, 6));
        var0.add(new class_241(UnitType.fabricator, 1, 7));
        var0.add(new class_241(UnitType.laserDefence, 1, 8));
        var0.add(new class_241(UnitType.repairbay, 1, 9));
    }

    public strictfp ArrayList N() {
        return this.f().a(this.V());
    }

    public strictfp void a(Unit var1, int var2) {
    }

    public strictfp int y() {
        return 145;
    }

    public strictfp boolean g(Unit var1, boolean var2) {
        return true;
    }

    public strictfp float f(class_31 var1) {
        int var2 = this.y();
        int var3 = var1.a(this);
        if (var3 == 0 && var1.p()) {
            var3 = 110;
        }

        var2 += var3;
        return (float)var2;
    }

    public strictfp int u(Unit var1) {
        return (int)this.f(var1.r());
    }

    public strictfp int v(Unit var1) {
        return (int)this.f(var1.r());
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.f();
    }
}
