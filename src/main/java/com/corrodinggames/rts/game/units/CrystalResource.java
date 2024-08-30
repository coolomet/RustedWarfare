package com.corrodinggames.rts.game.units;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.PorterDuff.Mode;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.units.buildings.class_88;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.e
public strictfp class CrystalResource extends class_88 {
    static TeamImageCache a = null;
    float b;
    static PorterDuffColorFilter c;

    public UnitType b() {
        return UnitType.crystalResource;
    }

    public static void a_() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.crystal);
    }

    public TeamImageCache d() {
        return a;
    }

    public boolean e() {
        return true;
    }

    public void a(int var1) {
    }

    public CrystalResource(boolean var1) {
        super(var1);
        this.M = a;
        this.b(a);
        this.cj = 11.0F;
        this.ck = this.cj + 1.0F;
        this.totalHealth = 600.0F;
        this.health = this.totalHealth;
        this.S(1);
        this.n.a(0, -1, 0, 0);
        this.o.a(this.n);
    }

    public Paint f() {
        Paint var1 = super.f();
        return var1;
    }

    public void a(float var1) {
        super.a(var1);
        this.b += 0.01F * var1;
        if (this.b > 1.0F) {
            --this.b;
            if (this.b > 1.0F) {
                this.b = 0.0F;
            }
        }

    }

    public float g() {
        return 0.02F;
    }

    public MovementType h() {
        return MovementType.NONE;
    }

    public boolean i() {
        return false;
    }

    public boolean s_() {
        GameEngine var1 = GameEngine.getGameEngine();
        du.a(this.cE());
        return RectF.a(var1.cM, du);
    }

    public TeamImageCache k() {
        return null;
    }

    public boolean l() {
        return false;
    }

    public float attackRange() {
        return 0.0F;
    }

    public float shootDelay(int var1) {
        return 0.0F;
    }

    public float c(int var1) {
        return 0.0F;
    }

    public void a(Unit var1, int var2) {
    }

    public void n() {
        super.n();
        this.b = (this.yCord * 5.0F + this.xCord * 3.0F) % 1.0F;
    }

    public boolean o() {
        return true;
    }

    public boolean p() {
        return true;
    }

    public boolean q() {
        return true;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }

    static {
        c = new PorterDuffColorFilter(Color.a(200, 200, 200), Mode.MULTIPLY);
    }
}
