package com.corrodinggames.rts.game.units.buildings;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.i
public abstract strictfp class class_91 extends class_88 implements class_8 {
    public static final Paint y = new Paint();
    class_320 z = this.du();
    Rect A = new Rect();
    Rect B = new Rect();

    public class_91(boolean var1) {
        super(var1);
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeInt(this.r);
        this.z.a(var1);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        if (var1.b() >= 69) {
            int var2 = var1.readInt();
            this.R(var2);
        }

        this.z.a(var1);
        super.a(var1);
    }

    public strictfp class_320 du() {
        return new class_320(this);
    }

    public strictfp void b(class_73 var1) {
    }

    public strictfp boolean c(class_73 var1) {
        return true;
    }

    public strictfp void a(class_73 var1) {
        float var2;
        if (this.z.b != null) {
            var2 = this.cj * 2.0F;
        } else {
            var2 = this.cj * 3.0F;
        }

        Unit var3 = this.z.a(var1, var2, false, 0.0F);
        if (var3 != null) {
            if (var3.yCord - var3.cj < this.yCord + (float)this.dv()) {
                var3.yCord = this.yCord + (float)this.dv() + var3.cj;
            }

            PlayerData.c(var3);
        }

    }

    public strictfp int dv() {
        return -100;
    }

    public strictfp int f(boolean var1) {
        return this.z.a(class_226.i, var1, true);
    }

    public final strictfp int a(class_1059 var1, boolean var2) {
        return this.z.a(var1, var2);
    }

    public strictfp class_73 dw() {
        return this.z.b();
    }

    public strictfp class_447 bD() {
        return this.z.c();
    }

    public strictfp class_684 dx() {
        return this.z.c;
    }

    public strictfp int h(class_31 var1) {
        return this.z.a(var1);
    }

    public strictfp boolean dy() {
        return this.z.a();
    }

    public strictfp void dz() {
        this.z.e = 1.0F;
    }

    public strictfp void a(PointF var1) {
        this.z.b = var1;
    }

    public strictfp boolean dA() {
        return false;
    }

    public strictfp float bV() {
        return this.bT() && !this.z.a() ? this.z.e : super.bV();
    }

    public strictfp class_226 e(class_31 var1) {
        return this.z.b(var1);
    }

    public strictfp void a(class_226 var1, boolean var2) {
        this.z.a((class_226)var1, var2, (PointF)null, (Unit)null);
    }

    public strictfp void b(class_226 var1, boolean var2) {
        this.z.a(var1, var2);
    }

    public strictfp void a(class_226 var1) {
        this.z.a(var1);
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.bT() && !this.bV) {
            this.z.a(var1);
        }
    }

    public strictfp boolean c(float var1) {
        return super.c(var1);
    }

    public strictfp void bv() {
        PlayerData.a((Unit)this);
        this.z.a(true);
        super.bv();
    }

    public strictfp void a() {
        PlayerData.a((Unit)this);
        this.z.a(true);
        super.a();
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

    public strictfp void ca() {
        if (this.z.b != null) {
            GameEngine var1 = GameEngine.getGameEngine();
            float var2 = (float)((int)(this.xCord - var1.cw));
            float var3 = (float)((int)(this.yCord - var1.cx));
            float var4 = (float)((int)(this.z.b.x - var1.cw));
            float var5 = (float)((int)(this.z.b.y - var1.cx));
            var1.bO.a(var2, var3, var4, var5, y);
        }

    }

    public strictfp int a(class_585 var1) {
        return this.z.a(var1);
    }

    static {
        y.a(255, 0, 255, 0);
        y.a(1.5F);
        y.a(true);
    }
}
