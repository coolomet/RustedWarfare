package com.corrodinggames.rts.game.units.c;

import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.ScorchMark;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.AttackMode;
import com.corrodinggames.rts.game.units.land.class_120;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.class_989;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.c.a
public strictfp class Ladybug extends class_120 {
    static TeamImageCache a = null;
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache[] d = new TeamImageCache[10];
    int e = 0;
    float f = 0.0F;
    Rect g = new Rect();
    Rect h = new Rect();

    public UnitType b() {
        return UnitType.ladybug;
    }

    public static void f() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.ladybug);
        d = PlayerData.a(b);
    }

    public TeamImageCache d() {
        return this.bV ? a : d[this.bX.R()];
    }

    public TeamImageCache k() {
        return null;
    }

    public TeamImageCache d(int var1) {
        return null;
    }

    public boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        class_998 var2 = var1.bR.b(this.xCord, this.yCord, this.zCord, class_989.BLOOD, false, Priority.high);
        if (var2 != null) {
        }

        var1.bM.a(class_648.A, 0.8F, this.xCord, this.yCord);
        ScorchMark.a(this, 1);
        return false;
    }

    public Ladybug(boolean var1) {
        super(var1);
        this.T(17);
        this.U(26);
        this.cj = 5.0F;
        this.ck = this.cj + 3.0F;
        this.totalHealth = 130.0F;
        this.health = this.totalHealth;
        this.M = b;
        this.P = AttackMode.outOfRange;
    }

    public Rect a_(boolean var1) {
        int var2 = this.e * this.es;
        byte var3 = 0;
        this.g.a(var2, var3, var2 + this.es, var3 + this.et);
        return this.g;
    }

    public boolean bP() {
        return true;
    }

    public boolean bO() {
        return true;
    }

    public void a(float var1) {
        super.a(var1);
        if (this.cK) {
            if (this.e == 0) {
                this.e = 1;
            } else {
                this.e = 0;
            }
        }

        if (this.f != 0.0F) {
            this.f = class_340.a(this.f, var1);
            this.e = 2;
        }

    }

    public void a(Unit var1, int var2) {
        Projectile.a(this, var1, 14.0F, (Projectile)null, false);
        this.f = 4.0F;
        PointF var3 = this.E(var2);
        GameEngine var4 = GameEngine.getGameEngine();
        var4.bM.a(class_648.B, 0.3F, var3.x, var3.y);
    }

    public float attackRange() {
        return 43.0F;
    }

    public float shootDelay(int var1) {
        return 17.0F;
    }

    public float speed() {
        return 1.7F;
    }

    public float turnSpeed() {
        return 5.5F;
    }

    public float c(int var1) {
        return 99.0F;
    }

    public boolean c(float var1) {
        return super.c(var1);
    }

    public float C() {
        return 0.07F;
    }

    public float D() {
        return 0.12F;
    }

    public boolean l() {
        return true;
    }

    public boolean af() {
        return false;
    }

    public float g(int var1) {
        return 7.0F;
    }

    public boolean E() {
        return true;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
