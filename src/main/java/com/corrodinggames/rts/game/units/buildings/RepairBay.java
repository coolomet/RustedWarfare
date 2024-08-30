package com.corrodinggames.rts.game.units.buildings;

import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_26;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_234;
import com.corrodinggames.rts.game.units.a.class_235;
import com.corrodinggames.rts.game.units.land.Builder;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.r
public strictfp class RepairBay extends class_88 implements class_26 {
    static TeamImageCache a = null;
    static TeamImageCache[] b = new TeamImageCache[10];
    static TeamImageCache c = null;
    float d;
    public static class_314 e = new class_314(true);
    Rect f = new Rect();
    Rect g = new Rect();
    static ArrayList h = new ArrayList();
    PointF[] i = new PointF[6];
    PointF[] j;

    public strictfp void a(GameOutputStream var1) {
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        super.a(var1);
    }

    public strictfp UnitType K() {
        return UnitType.repairbay;
    }

    public static strictfp void M() {
        GameEngine var0 = GameEngine.getGameEngine();
        a = var0.bO.a(AssetsID$drawable.repair_bay);
        c = var0.bO.a(AssetsID$drawable.repair_bay_dead);
        b = PlayerData.a(a);
    }

    public strictfp boolean L() {
        this.M = c;
        this.S(0);
        this.bT = false;
        this.a((ExplodeType) ExplodeType.normal);
        return true;
    }

    public strictfp TeamImageCache d() {
        if (this.bV) {
            return c;
        } else {
            return this.bX == null ? b[b.length - 1] : b[this.bX.R()];
        }
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public strictfp void a(int var1) {
    }

    public RepairBay(boolean var1) {
        super(var1);
        this.j = new PointF[this.i.length];
        this.M = a;
        this.b(a);
        this.cj = 30.0F;
        this.ck = this.cj;
        this.totalHealth = 1000.0F;
        this.health = this.totalHealth;
        this.n.a(-1, -1, 1, 1);
        this.o.a(-1, -1, 1, 1);

        for(int var2 = 0; var2 < this.i.length; ++var2) {
            this.i[var2] = new PointF();
            this.j[var2] = new PointF();
        }

    }

    public strictfp int y() {
        return 230;
    }

    public strictfp float c(Unit var1) {
        return 0.2F;
    }

    public strictfp boolean a(Unit var1) {
        return !var1.q();
    }

    public static strictfp class_1042 a(OrderableUnit var0, float var1, float var2, boolean var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        e.a((float)var0.y() + var2, var3);
        var4.cc.a(var0.xCord, var0.yCord, (float)var0.y() + var2, var0, var1, e);
        Unit var5 = e.e;
        if (var5 != null) {
            class_1042 var6 = var0.ao();
            var6.b(var5);
            if (var6 != null) {
                var6.k = var2;
                var6.m = true;
                return var6;
            }
        }

        return null;
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.bT() && !this.bV) {
            this.d += var1;
            if (this.aq() && this.d > 40.0F) {
                this.d = 0.0F;
                a(this, var1, 0.0F, false);
            }

            if (!this.bV) {
                Builder.a(var1, this);
            }

        }
    }

    public strictfp boolean c(float var1) {
        return super.c(var1);
    }

    public strictfp void a(float var1, boolean var2) {
        super.a(var1, var2);
        if (!this.bV) {
            Builder.b(var1, this);
        }

    }

    public strictfp boolean l() {
        return false;
    }

    public strictfp void a(Unit var1, int var2) {
        throw new RuntimeException("Unit cannot shoot");
    }

    public strictfp float shootDelay(int var1) {
        return 0.0F;
    }

    public strictfp float c(int var1) {
        return 0.0F;
    }

    public strictfp PointF E(int var1) {
        PointF var2 = this.G(var1);
        float var3 = var2.x + 0.0F;
        float var4 = var2.y - 33.0F;
        bg.setSite(var3, var4);
        return bg;
    }

    public strictfp ArrayList N() {
        return h;
    }

    public strictfp PointF[] b() {
        return this.i;
    }

    public strictfp PointF[] e_() {
        return this.j;
    }

    public strictfp float attackRange() {
        return (float)this.y();
    }

    public strictfp void e(float var1) {
        super.e(var1);
        float var2 = (float)this.y();
        class_694.a(this, var2);
    }

    public strictfp boolean g(Unit var1, boolean var2) {
        return true;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.K();
    }

    static {
        h.add(new class_234(true));
        h.add(new class_235());
    }
}
