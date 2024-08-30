package com.corrodinggames.rts.game.units.custom.e;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_388;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.e.a.EnergyResource;
import com.corrodinggames.rts.game.units.custom.e.a.HPResource;
import com.corrodinggames.rts.game.units.custom.e.a.ShieldResource;
import com.corrodinggames.rts.game.units.custom.e.a.AmmoResource;
import com.corrodinggames.rts.game.units.custom.e.a.CreditsResource;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e.a
public strictfp class BuiltInResource {
    public boolean a;
    protected String b;
    protected class_388 c;
    protected class_388 d;
    protected boolean e;
    protected boolean f;
    protected class_388 g;
    protected class_388 h;
    public BuiltInResource i;
    public boolean j;
    public boolean k;
    public boolean l = true;
    Integer m;
    public boolean n;
    public boolean o;
    public boolean p;
    public GroupingStyle q;
    boolean r;
    float s;
    protected boolean t;
    protected boolean u;
    BuiltInResource v;
    public boolean w;
    public float x;
    public TeamImageCache y;
    public boolean z;
    static ArrayList A = new ArrayList();
    static ArrayList B = new ArrayList();
    public static ArrayList C = new ArrayList();
    public static final BuiltInResource D = a((BuiltInResource)(new CreditsResource()));
    public static final BuiltInResource E = a((BuiltInResource)(new EnergyResource()));
    public static final BuiltInResource F = a((BuiltInResource)(new AmmoResource()));
    public static final BuiltInResource G = a((BuiltInResource)(new HPResource()));
    public static final BuiltInResource H = a((BuiltInResource)(new ShieldResource()));

    public strictfp boolean a() {
        return this.r;
    }

    public strictfp float b() {
        return this.s;
    }

    public strictfp boolean c() {
        return this.u;
    }

    public strictfp boolean d() {
        return this.t;
    }

    public static strictfp void e() {
        Iterator var0 = A.iterator();

        while(var0.hasNext()) {
            BuiltInResource var1 = (BuiltInResource)var0.next();
            var1.g();
        }

        ArrayList var3 = new ArrayList();
        Iterator var4 = A.iterator();

        while(var4.hasNext()) {
            BuiltInResource var2 = (BuiltInResource)var4.next();
            if (var2.a) {
                var3.add(var2);
            }
        }

        B = var3;
    }

    public static strictfp ArrayList f() {
        return B;
    }

    public strictfp void g() {
        if (this.u) {
            this.a = true;
        } else {
            class_1068 var1 = null;
            Iterator var2 = class_591.d.iterator();

            while(true) {
                class_1068 var4;
                do {
                    do {
                        if (!var2.hasNext()) {
                            this.a = var1 != null;
                            if (var1 != null) {
                                this.c = var1.g;
                                this.d = var1.h;
                                this.e = var1.i;
                                this.f = var1.j;
                                this.m = var1.d;
                                this.n = var1.e;
                                this.o = var1.o;
                                this.p = var1.p;
                                this.q = var1.r;
                                this.g = var1.t;
                                this.h = var1.u;
                                this.i = var1.w;
                                this.j = var1.y;
                                this.l = var1.q;
                                this.k = var1.x;
                                this.r = var1.l;
                                this.s = var1.m;
                                this.v = var1.A;
                                this.w = var1.k;
                                this.x = (float)var1.s;
                                this.y = var1.B;
                                this.z = var1.C;
                            }

                            return;
                        }

                        class_591 var3 = (class_591)var2.next();
                        var4 = var3.a(this);
                    } while(var4 == null);
                } while(var1 != null && !(var1.c < var4.c));

                var1 = var4;
            }
        }
    }

    public strictfp Integer h() {
        return this.m;
    }

    public strictfp String i() {
        return this.c == null ? this.b : this.c.b();
    }

    public strictfp String j() {
        return this.d != null ? this.d.b() : this.i();
    }

    public strictfp String a(double var1, boolean var3) {
        String var4;
        if (this.o) {
            var4 = "" + (int)var1;
        } else {
            var4 = class_340.c(var1);
        }

        var4 = a(var4, this.q);
        return this.a(var3) + var4 + this.b(var3);
    }

    public static strictfp String a(String var0, GroupingStyle var1) {
        if (var1 == GroupingStyle.NONE) {
            return var0;
        } else {
            GameEngine var2 = GameEngine.getGameEngine();
            if (var2.settingsEngine.disableDigitGrouping) {
                return var0;
            } else {
                String var3 = var0;
                String var4 = "";
                String var5 = "";
                int var6 = var0.indexOf(".");
                if (var6 != -1) {
                    var5 = var0.substring(var6);
                    var3 = var0.substring(0, var6);
                }

                if (var3.length() <= 3) {
                    return var0;
                } else {
                    String var7;
                    if (var1 == GroupingStyle.SPACE) {
                        var7 = " ";
                    } else {
                        if (var1 != GroupingStyle.COMMA) {
                            throw new RuntimeException("Unhandled grouping style: " + var1);
                        }

                        var7 = ",";
                    }

                    StringBuilder var8 = new StringBuilder();
                    int var9 = var3.length() % 3;
                    if (var9 != 0) {
                        var8.append(var3.substring(0, var9));
                    }

                    for(int var10 = var9; var10 < var3.length(); var10 += 3) {
                        if (var10 != 0) {
                            var8.append(var7);
                        }

                        var8.append(var3.substring(var10, var10 + 3));
                    }

                    if (var5 == "") {
                        return var8.toString();
                    } else {
                        return var8.toString() + var5;
                    }
                }
            }
        }
    }

    public static strictfp String a(long var0, GroupingStyle var2) {
        if (var2 == GroupingStyle.NONE) {
            return "" + var0;
        } else if (var2 == GroupingStyle.SPACE) {
            return String.format(Locale.US, "%,d", var0).replace(",", " ");
        } else if (var2 == GroupingStyle.COMMA) {
            return String.format(Locale.US, "%,d", var0);
        } else {
            throw new RuntimeException("Unhandled grouping style: " + var2);
        }
    }

    public strictfp String a(boolean var1) {
        if (this.g != null) {
            return this.g.b();
        } else {
            return var1 && this.e ? "" : this.i() + ": ";
        }
    }

    public strictfp String b(boolean var1) {
        return this.h != null ? this.h.b() : "";
    }

    public strictfp TeamImageCache k() {
        return this.y;
    }

    protected BuiltInResource() {
        this.q = GroupingStyle.NONE;
    }

    public static strictfp BuiltInResource a(String var0) {
        var0 = var0.toLowerCase(Locale.ENGLISH);
        Iterator var1 = C.iterator();

        BuiltInResource var2;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            var2 = (BuiltInResource)var1.next();
        } while(!var2.b.equalsIgnoreCase(var0));

        return var2;
    }

    public static strictfp BuiltInResource a(BuiltInResource var0) {
        Iterator var1 = A.iterator();

        BuiltInResource var2;
        do {
            if (!var1.hasNext()) {
                A.add(var0);
                C.add(var0);
                return var0;
            }

            var2 = (BuiltInResource)var1.next();
        } while(!var2.b.equals(var0.b));

        throw new RuntimeException("Built in resource already exists:" + var0.b);
    }

    public static strictfp BuiltInResource a(String var0, boolean var1, boolean var2) {
        Iterator var3 = A.iterator();

        BuiltInResource var4;
        do {
            if (!var3.hasNext()) {
                BuiltInResource var5 = new BuiltInResource();
                var5.b = var0;
                var5.u = var1;
                var5.t = var2;
                A.add(var5);
                return var5;
            }

            var4 = (BuiltInResource)var3.next();
        } while(!var4.b.equals(var0));

        return var4;
    }

    public static strictfp BuiltInResource b(String var0) {
        Iterator var1 = A.iterator();

        BuiltInResource var2;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            var2 = (BuiltInResource)var1.next();
        } while(!var2.b.equals(var0));

        return var2;
    }

    private strictfp String a(double var1) {
        String var3 = class_340.a(var1, 1);
        return a(var3, this.q);
    }

    public strictfp String a(double var1, boolean var3, boolean var4) {
        String var5;
        if (var4 && this.f) {
            var5 = "";
        } else {
            var5 = this.j() + ": ";
        }

        if (this == D) {
            var5 = "$";
        }

        if (var3) {
            return var1 > 0.0 ? "+" + var5 + this.a(var1) : "-" + var5 + this.a(-var1);
        } else {
            return var1 > 0.0 ? var5 + this.a(var1) : var5 + this.a(var1);
        }
    }

    public strictfp String toString() {
        return "resource(" + this.b + ")";
    }

    public strictfp double a(Unit var1) {
        return this.t ? var1.bX.c(this) : var1.a(this);
    }

    public strictfp void a(Unit var1, double var2) {
        if (this.t) {
            var1.bX.V().a(this, var2);
        } else {
            var1.df().a(this, var2);
        }

    }

    public strictfp void b(Unit var1, double var2) {
        if (this.t) {
            var1.bX.V().b(this, var2);
        } else {
            var1.df().b(this, var2);
        }

    }
}
