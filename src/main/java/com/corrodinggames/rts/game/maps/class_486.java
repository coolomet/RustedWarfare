package com.corrodinggames.rts.game.maps;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;

// $FF: renamed from: com.corrodinggames.rts.game.maps.d
public strictfp class class_486 {
    public class_28 a;
    int b;
    int c;
    public TeamImageCache d;
    public TeamImageCache e;
    public class_28 f;
    public float g;
    public Paint h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;
    public boolean n;
    public final Rect o;
    public final Rect p;
    public final RectF q;
    public final Rect r;
    // $FF: synthetic field
    final class_485 s;

    public strictfp void a() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.e = var1.bO.a(this.d.p, this.d.q, true);
        if (this.e != null && !this.e.A()) {
            this.e.a("fadeOutBitmap");
        }

        if (this.e != null && !this.e.A()) {
            this.e.b(true);
            this.f = var1.bO.b(this.e);
        } else {
            throw new OutOfMemoryError("Failed to create fade out bitmap");
        }
    }

    public strictfp Rect b() {
        this.r.a(this.c(), this.d(), this.c() + this.s.i, this.d() + this.s.i);
        return this.r;
    }

    public class_486(class_485 var1, int var2, int var3) {
        this.s = var1;
        this.h = new class_525();
        this.k = true;
        this.l = true;
        this.m = 0;
        this.n = false;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new RectF();
        this.r = new Rect();
        this.i = var2;
        this.j = var3;
    }

    public strictfp int c() {
        return this.s.f + this.i * this.s.k;
    }

    public strictfp int d() {
        return this.s.g + this.j * this.s.k;
    }
}
