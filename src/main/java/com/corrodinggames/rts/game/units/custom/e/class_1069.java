package com.corrodinggames.rts.game.units.custom.e;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.f.class_523;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Collections;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e.f
public final strictfp class class_1069 {
    public static final class_1069 a = (new class_1069()).a();
    public final class_684 b = new class_684();
    boolean c;

    public strictfp class_1069 a() {
        this.c = true;
        return this;
    }

    public strictfp void b() {
        this.b.clear();
    }

    public strictfp boolean c() {
        if (this.b.a == 0) {
            return true;
        } else {
            int var1 = this.b.a;
            Object[] var2 = this.b.a();

            for(int var3 = 0; var3 < var1; ++var3) {
                class_1067 var4 = (class_1067)var2[var3];
                if (var4.b != 0.0) {
                    return false;
                }
            }

            return true;
        }
    }

    public strictfp double a(BuiltInResource var1) {
        int var2 = this.b.a;
        Object[] var3 = this.b.a();

        for(int var4 = 0; var4 < var2; ++var4) {
            class_1067 var5 = (class_1067)var3[var4];
            if (var5.a == var1) {
                return var5.b;
            }
        }

        return 0.0;
    }

    public strictfp double b(BuiltInResource var1) {
        int var2 = this.b.a;
        Object[] var3 = this.b.a();
        int var4 = 0;

        for(int var5 = 0; var5 < var2; ++var5) {
            class_1067 var6 = (class_1067)var3[var5];
            if (var6.a == var1) {
                var4 = (int)((double)var4 + var6.b);
            }

            if (var6.a.v == var1) {
                var4 = (int)((double)var4 + var6.b);
            }
        }

        return (double)var4;
    }

    public strictfp void a(class_1069 var1) {
        this.b();
        this.b(var1);
    }

    public strictfp void a(BuiltInResource var1, double var2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else {
            int var4 = this.b.a;
            Object[] var5 = this.b.a();

            for(int var6 = 0; var6 < var4; ++var6) {
                class_1067 var7 = (class_1067)var5[var6];
                if (var7.a == var1) {
                    var7.b = var2;
                    return;
                }
            }

            class_1067 var8 = new class_1067(var1);
            var8.b = var2;
            this.b.add(var8);
        }
    }

    public strictfp void a(double var1) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else {
            int var3 = this.b.a;
            Object[] var4 = this.b.a();

            for(int var5 = 0; var5 < var3; ++var5) {
                class_1067 var6 = (class_1067)var4[var5];
                var6.b *= var1;
            }

        }
    }

    public strictfp void b(BuiltInResource var1, double var2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else if (var2 != 0.0) {
            class_684 var4 = this.b;
            int var5 = var4.a;
            Object[] var6 = var4.a();

            for(int var7 = 0; var7 < var5; ++var7) {
                class_1067 var8 = (class_1067)var6[var7];
                if (var8.a == var1) {
                    var8.b += var2;
                    return;
                }
            }

            class_1067 var9 = new class_1067(var1);
            var9.b = var2;
            var4.add(var9);
        }
    }

    public strictfp void c(BuiltInResource var1, double var2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else if (var2 != 0.0) {
            class_684 var4 = this.b;
            int var5 = var4.a;
            Object[] var6 = var4.a();

            for(int var7 = 0; var7 < var5; ++var7) {
                class_1067 var8 = (class_1067)var6[var7];
                if (var8.a == var1) {
                    var8.b += var2;
                    return;
                }
            }

            class_1067 var9 = new class_1067(var1);
            var9.b = var2;
            var4.add(var9);
        }
    }

    public strictfp void d(BuiltInResource var1, double var2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else {
            this.b(var1, -var2);
        }
    }

    public strictfp void a(class_447 var1, double var2, double var4) {
        if ((double)var1.b >= var2 && (double)var1.b <= var4) {
            this.c(BuiltInResource.D, (double)var1.b);
        }

        this.a(var1.k, var2, var4);
    }

    public strictfp void b(class_447 var1, double var2, double var4) {
        if ((double)var1.b >= var2 && (double)var1.b <= var4) {
            this.c(BuiltInResource.D, (double)(-var1.b));
        }

        this.b(var1.k, var2, var4);
    }

    public strictfp void a(class_447 var1) {
        this.c(BuiltInResource.D, (double)var1.b);
        this.b(var1.k);
    }

    public strictfp void b(class_1069 var1) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else {
            int var2 = var1.b.a;
            Object[] var3 = var1.b.a();

            for(int var4 = 0; var4 < var2; ++var4) {
                class_1067 var5 = (class_1067)var3[var4];
                this.b(var5.a, var5.b);
            }

        }
    }

    public strictfp void a(class_1069 var1, double var2, double var4) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else {
            int var6 = var1.b.a;
            Object[] var7 = var1.b.a();

            for(int var8 = 0; var8 < var6; ++var8) {
                class_1067 var9 = (class_1067)var7[var8];
                if (var9.b >= var2 && var9.b <= var4) {
                    this.b(var9.a, var9.b);
                }
            }

        }
    }

    public strictfp void a(class_1069 var1, double var2) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else {
            int var4 = var1.b.a;
            Object[] var5 = var1.b.a();

            for(int var6 = 0; var6 < var4; ++var6) {
                class_1067 var7 = (class_1067)var5[var6];
                this.b(var7.a, var7.b * var2);
            }

        }
    }

    public strictfp void c(class_1069 var1) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else {
            int var2 = var1.b.a;
            Object[] var3 = var1.b.a();

            for(int var4 = 0; var4 < var2; ++var4) {
                class_1067 var5 = (class_1067)var3[var4];
                this.d(var5.a, var5.b);
            }

        }
    }

    public strictfp void b(class_1069 var1, double var2, double var4) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else {
            int var6 = var1.b.a;
            Object[] var7 = var1.b.a();

            for(int var8 = 0; var8 < var6; ++var8) {
                class_1067 var9 = (class_1067)var7[var8];
                if (var9.b >= var2 && var9.b <= var4) {
                    this.d(var9.a, var9.b);
                }
            }

        }
    }

    public static strictfp class_1069 a(class_1069 var0, class_1069 var1) {
        class_1069 var2 = new class_1069();
        var2.b(var0);
        var2.b(var1);
        return var2;
    }

    public static strictfp class_1069 b(class_1069 var0, class_1069 var1) {
        class_1069 var2 = new class_1069();
        var2.b(var0);
        var2.c(var1);
        return var2;
    }

    public static strictfp class_1069 b(class_1069 var0, double var1) {
        class_1069 var3 = new class_1069();
        var3.a(var0, var1);
        return var3;
    }

    public static strictfp class_1069 d(class_1069 var0) {
        class_1069 var1 = new class_1069();
        var1.b(var0);
        return var1;
    }

    public static strictfp int a(class_1069 var0, Unit var1) {
        int var2 = 9999;
        int var3 = var0.b.a;
        Object[] var4 = var0.b.a();

        for(int var5 = 0; var5 < var3; ++var5) {
            class_1067 var6 = (class_1067)var4[var5];
            if (var6.b > 0.0) {
                double var7;
                if (var6.a.t) {
                    var7 = var1.bX.c(var6.a);
                } else {
                    var7 = var1.a(var6.a);
                }

                int var9 = (int)(var7 / var6.b);
                var2 = class_340.c(var2, var9);
            }
        }

        return var2;
    }

    public static strictfp boolean b(class_1069 var0, Unit var1) {
        int var2 = var0.b.a;
        Object[] var3 = var0.b.a();

        for(int var4 = 0; var4 < var2; ++var4) {
            class_1067 var5 = (class_1067)var3[var4];
            double var6;
            if (var5.a.t) {
                var6 = var1.bX.c(var5.a);
            } else {
                var6 = var1.a(var5.a);
            }

            if (var5.b > var6) {
                return false;
            }
        }

        return true;
    }

    public static strictfp boolean a(class_1069 var0, Unit var1, double var2) {
        int var4 = var0.b.a;
        Object[] var5 = var0.b.a();

        for(int var6 = 0; var6 < var4; ++var6) {
            class_1067 var7 = (class_1067)var5[var6];
            double var8;
            if (var7.a.t) {
                var8 = var1.bX.c(var7.a);
            } else {
                var8 = var1.a(var7.a);
            }

            if (var7.b * var2 > var8) {
                return false;
            }
        }

        return true;
    }

    public static strictfp void c(class_1069 var0, Unit var1) {
        int var2 = var0.b.a;
        Object[] var3 = var0.b.a();

        for(int var4 = 0; var4 < var2; ++var4) {
            class_1067 var5 = (class_1067)var3[var4];
            class_1069 var6;
            if (var5.a.t) {
                var6 = var1.bX.V();
                var6.d(var5.a, var5.b);
            } else {
                var6 = var1.df();
                var6.d(var5.a, var5.b);
            }
        }

    }

    public static strictfp void b(class_1069 var0, Unit var1, double var2) {
        int var4 = var0.b.a;
        Object[] var5 = var0.b.a();

        for(int var6 = 0; var6 < var4; ++var6) {
            class_1067 var7 = (class_1067)var5[var6];
            class_1069 var8;
            if (var7.a.t) {
                var8 = var1.bX.V();
                var8.d(var7.a, var7.b * var2);
            } else {
                var8 = var1.df();
                var8.d(var7.a, var7.b * var2);
            }
        }

    }

    public static strictfp void d(class_1069 var0, Unit var1) {
        int var2 = var0.b.a;
        Object[] var3 = var0.b.a();

        for(int var4 = 0; var4 < var2; ++var4) {
            class_1067 var5 = (class_1067)var3[var4];
            class_1069 var6;
            if (var5.a.t) {
                var6 = var1.bX.V();
                var6.b(var5.a, var5.b);
            } else {
                var6 = var1.df();
                var6.b(var5.a, var5.b);
            }
        }

    }

    public static strictfp void c(class_1069 var0, Unit var1, double var2) {
        int var4 = var0.b.a;
        Object[] var5 = var0.b.a();

        for(int var6 = 0; var6 < var4; ++var6) {
            class_1067 var7 = (class_1067)var5[var6];
            class_1069 var8;
            if (var7.a.t) {
                var8 = var1.bX.V();
                var8.b(var7.a, var7.b * var2);
            } else {
                var8 = var1.df();
                var8.b(var7.a, var7.b * var2);
            }
        }

    }

    public static strictfp boolean a(class_1069 var0, Unit var1, Unit var2) {
        boolean var3 = false;
        int var4 = var0.b.a;
        Object[] var5 = var0.b.a();

        for(int var6 = 0; var6 < var4; ++var6) {
            class_1067 var7 = (class_1067)var5[var6];
            BuiltInResource var8 = var7.a;
            double var9 = var7.b;
            if (var9 != 0.0) {
                double var11 = var8.a(var1);
                double var13 = var8.a(var2);
                double var15;
                if (var9 >= 0.0) {
                    if (!(var11 <= 0.0)) {
                        var15 = class_340.a(var11, var9);
                        var8.b(var1, -var15);
                        var8.b(var2, var15);
                        var3 = true;
                    }
                } else if (!(var13 <= 0.0)) {
                    var9 = -var9;
                    var15 = class_340.a(var13, var9);
                    var8.b(var2, -var15);
                    var8.b(var1, var15);
                    var3 = true;
                }
            }
        }

        return var3;
    }

    public strictfp String a(boolean var1, boolean var2, int var3, boolean var4, boolean var5) {
        class_523 var6 = new class_523();
        this.a(var6, var1, var2, var3, var4, var5, (Unit)null, 0);
        return var6.a();
    }

    public strictfp void a(class_523 var1, boolean var2, boolean var3, int var4, boolean var5, boolean var6, Unit var7, int var8) {
        int var9 = this.b.a;
        if (var9 != 0) {
            String var10;
            if (var2) {
                var10 = "\n";
            } else {
                var10 = " | ";
            }

            int var11 = 0;
            Object[] var12 = this.b.a();

            for(int var13 = 0; var13 < var9; ++var13) {
                class_1067 var14 = (class_1067)var12[var13];
                if ((var14.b > 0.0 || var6) && var11 < var4) {
                    BuiltInResource var15 = var14.a;
                    if (var5 || !var15.a()) {
                        boolean var16 = false;
                        if (var15.y != null && var15.z) {
                            var16 = true;
                            int var17 = var1.c() - 2;
                            if (var17 < 2) {
                                var17 = 2;
                            }

                            var1.a(var15.y, var17 * 3, var17);
                        }

                        String var22 = var15.a(var14.b, false, var16) + var10;
                        boolean var18 = false;
                        int var19 = 0;
                        if (var15.m != null && var15.n) {
                            var18 = true;
                            var19 = var15.m;
                        }

                        if (var7 != null) {
                            double var20 = var15.a(var7);
                            if (var20 < var14.b) {
                                var18 = true;
                                var19 = var8;
                            }
                        }

                        if (var18) {
                            var1.a(var22, var19);
                        } else {
                            var1.b(var22);
                        }

                        ++var11;
                    }
                }
            }

        }
    }

    public strictfp void a(GameOutputStream var1) {
        if (this.b.a == 0) {
            var1.writeByte(-1);
        } else {
            var1.writeByte(0);
            var1.a((short)this.b.a);
            int var2 = this.b.a;
            Object[] var3 = this.b.a();

            for(int var4 = 0; var4 < var2; ++var4) {
                class_1067 var5 = (class_1067)var3[var4];
                var1.writeString(var5.a.b);
                var1.writeDouble(var5.b);
            }

        }
    }

    public strictfp void a(GameInputStream var1) {
        if (this.c) {
            throw new RuntimeException("StoredResources are locked");
        } else {
            byte var2 = var1.readByte();
            if (var2 != -1) {
                short var3 = var1.readShort();
                this.b.clear();

                for(int var4 = 0; var4 < var3; ++var4) {
                    BuiltInResource var5 = BuiltInResource.b(var1.readString());
                    double var6 = var1.readDouble();
                    if (var5 != null && var6 != 0.0) {
                        class_1067 var8 = new class_1067(var5, var6);
                        this.b.add(var8);
                    }
                }

            }
        }
    }

    public strictfp int d() {
        int var1 = 0;
        int var2 = this.b.a;
        Object[] var3 = this.b.a();

        for(int var4 = 0; var4 < var2; ++var4) {
            class_1067 var5 = (class_1067)var3[var4];
            if (var5.b != 0.0) {
                ++var1;
            }
        }

        return var1;
    }

    public strictfp boolean e(class_1069 var1) {
        if (this.d() != var1.d()) {
            return false;
        } else {
            int var2 = this.b.a;
            Object[] var3 = this.b.a();

            for(int var4 = 0; var4 < var2; ++var4) {
                class_1067 var5 = (class_1067)var3[var4];
                double var6 = var1.a(var5.a);
                if (!class_340.b(var5.b, var6)) {
                    return false;
                }
            }

            return true;
        }
    }

    public strictfp boolean f(class_1069 var1) {
        int var2 = this.b.a;
        Object[] var3 = this.b.a();

        for(int var4 = 0; var4 < var2; ++var4) {
            class_1067 var5 = (class_1067)var3[var4];
            if (var5.b > 0.0) {
                double var6 = var1.b(var5.a);
                if (var6 > 0.0) {
                    return true;
                }
            }
        }

        return false;
    }

    public strictfp class_1069 a(Unit var1) {
        class_1069 var2 = new class_1069();
        int var3 = this.b.a;
        Object[] var4 = this.b.a();

        for(int var5 = 0; var5 < var3; ++var5) {
            class_1067 var6 = (class_1067)var4[var5];
            double var7;
            if (var6.a.t) {
                var7 = var1.bX.c(var6.a);
            } else {
                var7 = var1.a(var6.a);
            }

            if (var7 < var6.b) {
                double var9 = var6.b - var7;
                var2.b(var6.a, var9);
            }
        }

        if (var2.c()) {
            return a;
        } else {
            return var2;
        }
    }

    public strictfp String a(Unit var1, String var2, int var3, boolean var4) {
        String var5 = null;
        int var6 = 0;
        int var7 = this.b.a;
        Object[] var8 = this.b.a();

        for(int var9 = 0; var9 < var7; ++var9) {
            class_1067 var10 = (class_1067)var8[var9];
            if (var4 || !var10.a.a()) {
                double var11;
                if (var10.a.t) {
                    var11 = var1.bX.c(var10.a);
                } else {
                    var11 = var1.a(var10.a);
                }

                if (var11 < var10.b) {
                    double var10000 = var10.b - var11;
                    String var15 = var10.a.i();
                    if (var5 == null) {
                        var5 = var15;
                    } else {
                        var5 = var5 + var2 + var15;
                    }

                    ++var6;
                    if (var6 > var3) {
                        break;
                    }
                }
            }
        }

        return var5;
    }

    public strictfp void g(class_1069 var1) {
        this.b();
        this.b(var1);
    }

    public strictfp void c(BuiltInResource var1) {
        class_684 var2 = this.b;
        int var3 = var2.a;
        Object[] var4 = var2.a();

        for(int var5 = 0; var5 < var3; ++var5) {
            class_1067 var6 = (class_1067)var4[var5];
            if (var6.a == var1) {
                return;
            }
        }

        class_1067 var7 = new class_1067(var1);
        var7.b = 0.0;
        var2.add(var7);
    }

    public strictfp void e() {
        Collections.sort(this.b, new class_704(this));
    }
}
