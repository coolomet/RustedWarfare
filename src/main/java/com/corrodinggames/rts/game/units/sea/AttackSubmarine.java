package com.corrodinggames.rts.game.units.sea;

import android.graphics.Color;
import android.graphics.PointF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.e
public strictfp class AttackSubmarine extends class_114 {
    boolean a = false;
    boolean b = true;
    float c = 0.0F;
    static TeamImageCache d = null;
    static TeamImageCache e = null;
    static TeamImageCache f = null;
    public static TeamImageCache g = null;
    public static TeamImageCache[] h = new TeamImageCache[10];
    static TeamImageCache[] i = new TeamImageCache[10];
    public static final class_226 j = new class_270(151);
    public static final class_226 k = new class_269(152);
    static ArrayList l = new ArrayList();

    public strictfp void a(GameOutputStream var1) {
        var1.writeBoolean(this.a);
        var1.writeFloat(this.c);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.a = var1.readBoolean();
        this.b = !this.Q();
        if (var1.b() >= 21) {
            this.c = var1.readFloat();
        }

        this.L();
        super.a(var1);
    }

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : h[this.bX.R()];
    }

    public static strictfp void b() {
        GameEngine var0 = GameEngine.getGameEngine();
        e = var0.bO.a(AssetsID$drawable.attack_submarine);
        f = a(e, e.m(), e.l());
        d = var0.bO.a(AssetsID$drawable.attack_submarine_dead);
        g = var0.bO.a(AssetsID$drawable.unit_icon_water);
        h = PlayerData.a(g);
        i = PlayerData.a(e);
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && this.zCord >= 0.0F;
    }

    public strictfp float G() {
        return 0.0F;
    }

    public strictfp float H() {
        return 0.0F;
    }

    public strictfp TeamImageCache d() {
        return this.bV ? d : i[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return f;
    }

    public strictfp MovementType h() {
        return MovementType.WATER;
    }

    public strictfp UnitType f() {
        return UnitType.attackSubmarine;
    }

    public strictfp boolean K() {
        return !this.Q();
    }

    public AttackSubmarine(boolean var1) {
        super(var1);
        this.b(e);
        this.cj = 15.0F;
        this.ck = this.cj - 2.0F;
        this.totalHealth = 260.0F;
        this.health = this.totalHealth;
        this.M = e;
    }

    public strictfp void L() {
        if (!this.b) {
            this.S(1);
        } else {
            this.S(2);
        }

    }

    public strictfp void s(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        float var3;
        if (this.a) {
            var3 = 1.0F;
        } else {
            var3 = -8.0F;
        }

        if (class_340.c(this.zCord - var3) > 2.0F) {
            this.c = class_340.a(this.c, 0.08F, 0.003F * var1);
        } else {
            this.c = class_340.a(this.c, 0.02F, 0.003F * var1);
        }

        this.zCord = class_340.a(this.zCord, var3, this.c * var1);
        boolean var4 = false;
        if (this.b && this.Q()) {
            this.b = false;
            this.L();
            var4 = true;
        }

        if (!this.b && !this.Q()) {
            this.b = true;
            this.L();
            var4 = true;
        }

        if (var4) {
            var2.bR.a(this.xCord, this.yCord, 0.0F, 0, 0.0F, 0.0F, this.cg);
        }

    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bT() || this.bV) {
            ;
        }
    }

    public strictfp float attackRange() {
        return !this.Q() ? 250.0F : 180.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 170.0F;
    }

    public strictfp float e(int var1) {
        return 10.0F;
    }

    public strictfp float speed() {
        return !this.Q() ? 0.8F : 0.45F;
    }

    public strictfp float turnSpeed() {
        return 1.2F;
    }

    public strictfp float B() {
        return 0.06F;
    }

    public strictfp float c(int var1) {
        return 2.5F;
    }

    public strictfp float w(int var1) {
        return 0.08F;
    }

    public strictfp float C() {
        return 0.018F;
    }

    public strictfp float D() {
        return 0.1F;
    }

    public strictfp TeamImageCache d(int var1) {
        return null;
    }

    public strictfp boolean l() {
        return true;
    }

    public strictfp boolean Q() {
        return this.zCord < -1.0F;
    }

    public strictfp boolean ah() {
        return !this.Q();
    }

    public strictfp boolean ae() {
        return this.Q();
    }

    public strictfp boolean af() {
        return !this.Q();
    }

    public strictfp boolean ag() {
        return !this.Q() ? true : true;
    }

    public strictfp float q(int var1) {
        return 42.0F;
    }

    public strictfp void a(Unit var1, int var2) {
        PointF var3;
        Projectile var4;
        PointF var5;
        GameEngine var6;
        if (!this.Q()) {
            var3 = this.E(var2);
            var4 = Projectile.a(this, var3.x, var3.y, this.zCord, var2);
            var5 = this.K(var2);
            var4.K = var5.x;
            var4.L = var5.y;
            var4.ar = Color.a(255, 230, 230, 50);
            var4.U = 42.0F;
            var4.l = var1;
            var4.h = 190.0F;
            var4.t = 2.0F;
            var4.aH = true;
            var4.aM = true;
            var4.aQ = true;
            var6 = GameEngine.getGameEngine();
            var6.bM.a(class_648.m, 0.8F, this.xCord, this.yCord);
            var6.bR.a(this.xCord, this.yCord, this.zCord, -1118720);
        } else {
            var3 = this.E(var2);
            var4 = Projectile.a(this, var3.x, var3.y, this.zCord, var2);
            var5 = this.K(var2);
            var4.K = var5.x;
            var4.L = var5.y;
            var4.ar = Color.a(255, 30, 30, 150);
            var4.x = 1.0F;
            var4.U = 42.0F;
            var4.l = var1;
            var4.h = 250.0F;
            var4.t = 1.3F;
            var4.aH = false;
            var4.aM = true;
            var4.aQ = true;
            var6 = GameEngine.getGameEngine();
        }

    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        this.M = d;
        this.S(0);
        this.bT = false;
        return true;
    }

    public strictfp void a(class_226 var1, boolean var2) {
        if (var1 == j) {
            this.a = true;
        }

        if (var1 == k) {
            this.a = false;
        }

    }

    public strictfp ArrayList N() {
        return l;
    }

    public strictfp void e(float var1) {
        super.e(var1);
        float var2 = this.attackRange();
        class_694.a(this, var2);
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.f();
    }

    static {
        l.add(j);
        l.add(k);
    }
}
