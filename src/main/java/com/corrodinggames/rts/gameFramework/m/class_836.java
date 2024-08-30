package com.corrodinggames.rts.gameFramework.m;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.m.f
public strictfp class class_836 {
    public TeamImageCache a;
    public class_28 b;
    public Paint c;
    int d = 0;
    boolean e;
    int f;
    boolean g = false;
    int h = 0;
    int i = 0;
    int j = 0;
    int k = 1;
    HashMap l = new HashMap();
    ArrayList m = new ArrayList();

    public class_836(int var1, int var2) {
        this.a(var1, var2);
    }

    public void a(int var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        GameEngine.log("Creating BitmapOrTextureAlias: " + var1 + "x" + var2);
        this.a = var3.bO.a(var1, var2, true);
        this.b = var3.bO.b(this.a);
        this.c = new class_525();
        this.c.a((ColorFilter)(new class_561(class_922.COPY)));
    }

    public void a(TeamImageCache var1, int var2, int var3) {
        this.b.b(var1, (float)var2, (float)var3, this.c);
        this.b.p();
    }

    public void a() {
        this.b.a(0, Mode.CLEAR);
    }

    public void b() {
        this.d = 0;
        this.e = false;
        this.f = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.l.clear();
        this.a();
    }

    public void c() {
        ++this.f;
        if (this.e && this.f > 600) {
            this.g = true;
            this.m.clear();
        }

    }

    public void d() {
        if (this.g) {
            this.g = false;
            this.b();
            Iterator var1 = this.m.iterator();

            while(var1.hasNext()) {
                TeamImageCache var2 = (TeamImageCache)var1.next();
                this.a(var2);
            }

            this.m.clear();
        }

    }

    public class_837 a(TeamImageCache var1) {
        class_837 var2 = (class_837)this.l.get(var1);
        if (var2 != null) {
            if (this.g) {
                this.m.add(var1);
            }

            if (var2.f == var1.e) {
                return var2;
            }

            GameEngine.log("BitmapOrTextureAlias: Image was updated: " + var1.a());
            this.l.remove(var1);
        }

        var2 = this.b(var1);
        return var2 != null ? var2 : null;
    }

    public class_837 b(TeamImageCache var1) {
        int var2 = var1.m();
        int var3 = var1.l();
        int var4 = this.a.m();
        int var5 = this.a.l();
        if (this.h + var2 > var4) {
            this.h = 0;
            this.i += this.j + this.k;
            this.j = 0;
        }

        if (this.i + var3 > var5) {
            if (!this.e) {
                this.e = true;
            }

            return null;
        } else {
            class_837 var6 = new class_837();
            var6.a = this.a;
            int var7 = this.h;
            int var8 = this.i;
            this.h += var2 + this.k;
            if (this.j < var3) {
                this.j = var3;
            }

            this.a(var1, var7, var8);
            var6.b = var7;
            var6.c = var8;
            var6.d = (float)var2;
            var6.e = (float)var3;
            var6.f = var1.e;
            ++this.d;
            this.l.put(var1, var6);
            return var6;
        }
    }
}
