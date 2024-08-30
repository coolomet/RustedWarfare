package com.corrodinggames.rts.game.units.a;

import android.graphics.Rect;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.d.class_986;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.j
public strictfp class class_233 extends class_226 {
    public class_1058 a;
    static ArrayList b = new ArrayList();
    static Rect c;

    public class_233() {
        this(class_1058.NORMAL);
    }

    public class_233(class_1058 var1) {
        super("c_6_" + var1.name());
        this.a = var1;
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public int c() {
        return 0;
    }

    public UnitType w() {
        return null;
    }

    public class_1052 e() {
        return class_1052.pingMap;
    }

    public DisplayType f() {
        return DisplayType.none;
    }

    public boolean g() {
        return false;
    }

    public String type() {
        return "Ping Map" + this.a.type();
    }

    public String b() {
        return this.a.b();
    }

    public String K() {
        return this.a.c();
    }

    public boolean h_() {
        return false;
    }

    public boolean s() {
        return true;
    }

    public static class_233 a(class_1059 var0) {
        Iterator var1 = b.iterator();

        class_226 var2;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            var2 = (class_226)var1.next();
        } while(!var2.d(var0));

        return (class_233)var2;
    }

    public ArrayList q(Unit var1) {
        return b;
    }

    public TeamImageCache j() {
        return class_986.s[9].i;
    }

    public Rect v() {
        int var1 = 7 + this.a.ordinal();
        c.a(29 * var1, 0, 29 * var1 + 28, 28);
        return c;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.w();
    }

    static {
        class_1058[] var0 = class_1058.values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            class_1058 var3 = var0[var2];
            b.add(new class_233(var3));
        }

        c = new Rect();
    }
}
