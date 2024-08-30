package com.corrodinggames.rts.gameFramework.f.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.a.h
public strictfp class class_186 {
    public static final class_186 j = new class_186();
    public static final class_186 k = new class_186();
    public static final class_186 l = new class_186();
    public static final class_186 m = new class_186();
    public static final class_186 n = new class_186();
    Paint o = new class_525();
    TeamImageCache p;
    Paint q = new class_525();
    public class_186 r;
    public int s = 3;
    public int t = 3;
    public int u;
    public class_186 v;
    static Rect w = new Rect();
    static Rect x = new Rect();
    static Rect y = new Rect();

    public void a(TeamImageCache var1) {
        this.p = var1;
    }

    public void a(class_186 var1) {
        this.p = var1.p;
        if (var1.o != null) {
            this.o = new Paint(var1.o);
        } else {
            this.o = null;
        }

        if (var1.q != null) {
            this.q = new Paint(var1.q);
        } else {
            this.q = null;
        }

    }

    public static void b() {
        class_186 var0 = j;
        var0.o.b(Color.a(140, 100, 100, 100));
        var0.q.b(-16777216);
        var0.q.a(Paint$Style.b);
        var0 = k;
        var0.o.b(Color.a(180, 100, 100, 190));
        var0.q.b(-16777216);
        var0.q.a(Paint$Style.b);
        var0 = l;
        var0.o = null;
        var0.q = null;
        var0 = m;
        var0.o = null;
        var0.q.b(-65536);
        var0.q.c(127);
        var0.q.a(Paint$Style.b);
        var0 = n;
        var0.o.c(255);
        var0.p = GameEngine.getGameEngine().bS.bl;
        var0.q.b(-7829368);
        var0.q.c(255);
        var0.q.a(Paint$Style.b);
    }

    public void a(class_28 var1, RectF var2) {
        x.a = (int)var2.a;
        x.b = (int)var2.b;
        x.c = (int)var2.c;
        x.d = (int)var2.d;
        this.a(var1, x, class_188.NORMAL);
    }

    public void c(class_28 var1, Rect var2) {
        this.a(var1, var2, class_188.NORMAL);
    }

    public void a(class_28 var1, Rect var2, class_188 var3) {
        if (this.u > 0) {
            y.a(var2);
            var2 = y;
            class_340.a(var2, (float)this.u);
        }

        if (this.r != null) {
            w.a(var2);
            w.a(this.s, this.t);
            this.r.a(var1, w);
        }

        if (var3 == class_188.HOVERED && this.v != null) {
            this.v.a(var1, var2);
        } else {
            this.a(var1, var2);
        }
    }

    public void a(class_28 var1, Rect var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (this.p != null) {
            var3.bO.a(this.p, var2, this.o, 0, 0, 0, 0);
        } else if (this.o != null) {
            var1.b(var2, this.o);
        }

        if (this.q != null) {
            var1.b(var2, this.q);
        }

    }
}
