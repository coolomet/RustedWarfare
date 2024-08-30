package com.corrodinggames.rts.game.units.custom.d;

import android.graphics.Color;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.e.class_1067;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.f.class_517;
import com.corrodinggames.rts.gameFramework.f.class_523;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.d.b
public strictfp class class_447 extends class_446 implements Comparable {
    private static final class_1069 m = (new class_1069()).a();
    public static final class_447 a = a(0);
    public int b;
    public float c;
    public float d;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public class_1069 k;
    static final int l = Color.a(255, 0, 100, 0);

    public class_447() {
        this.k = m;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        if (this.k == m) {
            return this.b;
        } else {
            int var1 = this.b;
            int var2 = this.k.b.a;
            Object[] var3 = this.k.b.a();

            for(int var4 = 0; var4 < var2; ++var4) {
                class_1067 var5 = (class_1067)var3[var4];
                if (var5.b > 0.0) {
                    float var6 = var5.a.b();
                    if (var6 != 0.0F) {
                        var1 += (int)((double)var6 * var5.b);
                    }
                }
            }

            return var1;
        }
    }

    public static class_447 a(class_447 var0, class_447 var1) {
        class_447 var2 = new class_447();
        var2.b = var0.b + var1.b;
        var2.c = var0.c + var1.c;
        var2.d = var0.d + var1.d;
        var2.e = var0.e + var1.e;
        var2.f = var0.f + var1.f;
        if (!var0.k.c() || !var1.k.c()) {
            var2.k = class_1069.a(var0.k, var1.k);
        }

        return var2;
    }

    public static class_447 a(class_447 var0, float var1) {
        class_447 var2 = new class_447();
        var2.b = (int)((float)var0.b * var1);
        var2.c = var0.c * var1;
        var2.d = var0.d * var1;
        var2.e = var0.e * var1;
        var2.f = (int)((float)var0.f * var1);
        if (!var0.k.c()) {
            var2.k = class_1069.b(var0.k, (double)var1);
        }

        return var2;
    }

    public static class_447 a(int var0) {
        class_447 var1 = new class_447();
        var1.b = var0;
        return var1;
    }

    @SneakyThrows
    public static class_447 a(class_591 var0, UnitConfig var1, String var2, String var3, boolean var4) {
        String var5 = var1.getValueAsStaticString(var2, var3, (String)null);
        if (var5 == null && !var4) {
            throw new RuntimeException("Could not find " + var3 + " in configuration file under:" + var2);
        } else {
            try {
                class_447 var6 = b(var0, var5);
                return var6;
            } catch (Exception var7) {
                throw new CustomException("[" + var2 + "]" + var3 + ": " + var7.getMessage());
            }
        }
    }

    @SneakyThrows
    public static class_447 a(class_591 var0, UnitConfig var1, String var2, String var3, class_447 var4) {
        String var5 = var1.getValueAsStaticString(var2, var3, (String)null);
        if (var5 == null) {
            return var4;
        } else {
            try {
                class_447 var6 = b(var0, var5);
                return var6;
            } catch (Exception var7) {
                throw new CustomException("[" + var2 + "]" + var3 + ": " + var7.getMessage());
            }
        }
    }

    @SneakyThrows
    public static class_447 b(class_591 var0, UnitConfig var1, String var2, String var3, class_447 var4) {
        String var5 = var1.getValueAsStaticString(var2, var3, (String)null);
        if (var5 == null) {
            return var4;
        } else {
            try {
                class_447 var6 = a(var0, var5);
                return var6;
            } catch (Exception var7) {
                throw new CustomException("[" + var2 + "]" + var3 + ": " + var7.getMessage());
            }
        }
    }

    @SneakyThrows
    public static void b(int var0) {
        if (var0 < 0 || var0 > 31) {
            throw new CustomException("Flag id must be between 0-31 (is:" + var0 + ")");
        }
    }

    @SneakyThrows
    public static int a(int var0, String var1) {
        if (!var1.contains("-")) {
            int var6 = Integer.parseInt(var1);
            b(var6);
            var0 |= 1 << var6;
            return var0;
        } else {
            String[] var2 = class_340.c(var1, '-');
            if (var2.length != 2) {
                throw new CustomException("Unexpected flag id: " + var1);
            } else {
                int var3 = Integer.parseInt(var2[0]);
                int var4 = Integer.parseInt(var2[1]);
                b(var3);
                b(var4);
                if (var4 < var3) {
                    throw new CustomException("end<start in flag id: " + var1);
                } else {
                    for(int var5 = var3; var5 <= var4; ++var5) {
                        var0 |= 1 << var5;
                    }

                    return var0;
                }
            }
        }
    }

    @SneakyThrows
    public static class_447 a(class_591 var0, String var1) {
        class_447 var2 = b(var0, var1);
        if (var2 != null && var2.f != 0) {
            throw new CustomException("Ammo not supported on streaming price:" + var1);
        } else {
            return var2;
        }
    }

    @SneakyThrows
    public static class_447 b(class_591 var0, String var1) {
        if (var1 == null) {
            return a;
        } else {
            class_447 var2 = new class_447();
            String[] var3 = var1.split(",|\\|");
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String var6 = var3[var5];
                var6 = var6.trim();
                if (!var6.equals("")) {
                    String[] var9 = var6.split("=|:");
                    String var7;
                    String var8;
                    if (var9.length == 1) {
                        var7 = "credits";
                        var8 = var9[0];
                    } else {
                        if (var9.length != 2) {
                            throw new CustomException("Unknown price format:" + var1);
                        }

                        var7 = var9[0].trim();
                        var8 = var9[1].trim();
                    }

                    boolean var10 = false;

                    try {
                        int var11;
                        if (var7.equals("credits")) {
                            var10 = true;
                            var11 = Integer.parseInt(var8);
                            var2.b = var11;
                        } else {
                            float var14;
                            if (var7.equals("energy")) {
                                var14 = Float.parseFloat(var8);
                                var2.c = var14;
                            } else if (var7.equals("hp")) {
                                var14 = Float.parseFloat(var8);
                                var2.d = var14;
                            } else if (var7.equals("shield")) {
                                var14 = Float.parseFloat(var8);
                                var2.e = var14;
                            } else if (var7.equals("ammo")) {
                                var10 = true;
                                var11 = Integer.parseInt(var8);
                                var2.f = var11;
                            } else if (var7.equals("hasFlag")) {
                                var10 = true;
                                var2.i = a(var2.i, var8);
                            } else if (var7.equals("hasMissingFlag")) {
                                var10 = true;
                                var2.j = a(var2.j, var8);
                            } else if (var7.equals("setFlag")) {
                                var10 = true;
                                var2.g = a(var2.g, var8);
                            } else if (var7.equals("unsetFlag")) {
                                var10 = true;
                                var2.h = a(var2.h, var8);
                            } else {
                                BuiltInResource var15 = var0.k(var7);
                                if (var15 == null) {
                                    throw new CustomException("Unknown price type:" + var7);
                                }

                                float var16 = Float.parseFloat(var8);
                                if (var2.k == m) {
                                    var2.k = new class_1069();
                                }

                                var2.k.a(var15, (double)var16);
                            }
                        }
                    } catch (NumberFormatException var13) {
                        var13.printStackTrace();
                        String var12 = "Bad price number:" + var8 + " in " + var1;
                        if (var10) {
                            var12 = var12 + " (Hint: A whole number was expected)";
                        }

                        throw new CustomException(var12);
                    }
                }
            }

            if (var2.k != m) {
                var2.k.a();
            }

            if (!var2.d()) {
                return a;
            } else {
                return var2;
            }
        }
    }

    public int a(Unit var1, boolean var2) {
        int var3 = 9999;
        int var4;
        if (!var2 && this.b > 0) {
            var4 = (int)(var1.bX.credits / (double)this.b);
            var3 = class_340.c(var3, var4);
        }

        if (this.c > 0.0F) {
            var4 = (int)(var1.cB / this.c);
            var3 = class_340.c(var3, var4);
        }

        if (this.d > 0.0F) {
            var4 = (int)(var1.health / this.d);
            var3 = class_340.c(var3, var4);
        }

        if (this.e > 0.0F) {
            var4 = (int)(var1.cx / this.e);
            var3 = class_340.c(var3, var4);
        }

        if (this.f > 0) {
            var4 = var1.cE / this.f;
            var3 = class_340.c(var3, var4);
        }

        if (!this.k.c()) {
            var4 = class_1069.a(this.k, var1);
            var3 = class_340.c(var3, var4);
        }

        if (!this.f(var1)) {
            var3 = 0;
        }

        return var3;
    }

    public boolean b(Unit var1, double var2) {
        if (this.b > 0 && !var1.bX.a((double)this.b * var2)) {
            return false;
        } else if (this.c > 0.0F && (double)var1.cB < (double)this.c * var2) {
            return false;
        } else if (this.d > 0.0F && (double)var1.health < (double)this.d * var2) {
            return false;
        } else if (this.e > 0.0F && (double)var1.cx < (double)this.e * var2) {
            return false;
        } else if (this.f > 0 && (double)var1.cE < (double)this.f * var2) {
            return false;
        } else if (!this.f(var1)) {
            return false;
        } else {
            return this.k.c() || class_1069.a(this.k, var1, var2);
        }
    }

    public boolean b(Unit var1) {
        if (this.b > 0 && !var1.bX.a((double)this.b)) {
            return false;
        } else if (this.c > 0.0F && var1.cB < this.c) {
            return false;
        } else if (this.d > 0.0F && var1.health < this.d) {
            return false;
        } else if (this.e > 0.0F && var1.cx < this.e) {
            return false;
        } else if (this.f > 0 && var1.cE < this.f) {
            return false;
        } else if (!this.f(var1)) {
            return false;
        } else {
            return this.k.c() || class_1069.b(this.k, var1);
        }
    }

    public boolean a(Unit var1, Unit var2) {
        boolean var3 = false;
        if (!this.k.c() && class_1069.a(this.k, var1, var2)) {
            var3 = true;
        }

        return var3;
    }

    public static void d(Unit var0) {
        if (var0.cB < 0.0F) {
            var0.cB = 0.0F;
        }

        if (var0.cB > var0.bd()) {
            var0.cB = var0.bd();
        }

        if (var0.cx < 0.0F) {
            var0.cx = 0.0F;
        }

        if (var0.cx > var0.cA) {
            var0.cx = var0.cA;
        }

        if (var0.health > var0.totalHealth) {
            var0.health = var0.totalHealth;
        }

        if (var0.cE < 0) {
            var0.cE = 0;
        }

    }

    public void e(Unit var1) {
        if (this.h != 0) {
            var1.cF &= ~this.h;
        }

        if (this.g != 0) {
            var1.cF |= this.g;
        }

    }

    public int c(int var1) {
        if (this.h != 0) {
            var1 &= ~this.h;
        }

        if (this.g != 0) {
            var1 |= this.g;
        }

        return var1;
    }

    public static boolean a(int var0, int var1) {
        int var2 = 1 << var1;
        return (var0 & var2) != 0;
    }

    public boolean f(Unit var1) {
        if (this.i != 0 && !b(var1.cF, this.i)) {
            return false;
        } else {
            return this.j == 0 || !c(var1.cF, this.j);
        }
    }

    public static boolean b(int var0, int var1) {
        return (var1 & var0) == var1;
    }

    public static boolean c(int var0, int var1) {
        return (var1 & var0) != 0;
    }

    public void a(Unit var1) {
        PlayerData var10000 = var1.bX;
        var10000.credits -= (double)this.b;
        var1.cB -= this.c;
        var1.health -= this.d;
        var1.cx -= this.e;
        var1.cE -= this.f;
        this.e(var1);
        if (!this.k.c()) {
            class_1069.c(this.k, var1);
        }

        d(var1);
    }

    public void a(Unit var1, double var2) {
        PlayerData var10000 = var1.bX;
        var10000.credits -= (double)this.b * var2;
        var1.cB = (float)((double)var1.cB - (double)this.c * var2);
        var1.health = (float)((double)var1.health - (double)this.d * var2);
        var1.cx = (float)((double)var1.cx - (double)this.e * var2);
        var1.cE = (int)((double)var1.cE - (double)this.f * var2);
        this.e(var1);
        if (!this.k.c()) {
            class_1069.b(this.k, var1, var2);
        }

        d(var1);
    }

    public void g(Unit var1) {
        if (this.b > 0) {
            var1.bX.b((float)this.b);
        } else {
            PlayerData var10000 = var1.bX;
            var10000.credits += (double)this.b;
        }

        var1.cB += this.c;
        var1.health += this.d;
        var1.cx += this.e;
        var1.cE += this.f;
        this.e(var1);
        if (!this.k.c()) {
            class_1069.d(this.k, var1);
        }

        d(var1);
    }

    public void h(Unit var1) {
        PlayerData var10000 = var1.bX;
        var10000.credits += (double)this.b;
        var1.cB += this.c;
        var1.health += this.d;
        var1.cx += this.e;
        var1.cE += this.f;
        this.e(var1);
        if (!this.k.c()) {
            class_1069.d(this.k, var1);
        }

        d(var1);
    }

    public void a(Unit var1, double var2, boolean var4) {
        if (var4) {
            PlayerData var10000 = var1.bX;
            var10000.credits += (double)this.b * var2;
        }

        var1.cB = (float)((double)var1.cB + (double)this.c * var2);
        var1.health = (float)((double)var1.health + (double)this.d * var2);
        var1.cx = (float)((double)var1.cx + (double)this.e * var2);
        var1.cE = (int)((double)var1.cE + (double)this.f * var2);
        this.e(var1);
        if (!this.k.c()) {
            class_1069.c(this.k, var1, var2);
        }

        d(var1);
    }

    public boolean c() {
        if (this == a) {
            return true;
        } else if (this.b == 0 && this.c == 0.0F && this.d == 0.0F && this.e == 0.0F && this.f == 0) {
            return this.k.c();
        } else {
            return false;
        }
    }

    public boolean d() {
        if (this == a) {
            return false;
        } else if (this.b == 0 && this.c == 0.0F && this.d == 0.0F && this.e == 0.0F && this.f == 0) {
            if (this.g == 0 && this.h == 0 && this.i == 0 && this.j == 0) {
                return !this.k.c();
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean e() {
        if (this == a) {
            return false;
        } else if (this.b == 0 && this.c == 0.0F && this.d == 0.0F && this.e == 0.0F && this.f == 0) {
            return this.g != 0 || this.h != 0;
        } else {
            return true;
        }
    }

    public String a(boolean var1, boolean var2, int var3, boolean var4) {
        class_523 var5 = new class_523();
        this.a(var5, var1, var2, var3, var4);
        return var5.a();
    }

    public void a(class_523 var1, boolean var2, boolean var3, int var4, boolean var5, Unit var6, int var7) {
        this.b(var1, var2, var3, var4, var5, var6, var7);
    }

    private void a(class_523 var1, boolean var2, boolean var3, int var4, boolean var5) {
        this.b(var1, var2, var3, var4, var5, (Unit)null, 0);
    }

    private void b(class_523 var1, boolean var2, boolean var3, int var4, boolean var5, Unit var6, int var7) {
        String var8;
        if (var2) {
            var8 = "\n";
        } else {
            var8 = " | ";
        }

        int var9 = 0;
        if (this.b > 0 && var9 < var4) {
            int var10 = l;
            if (var6 != null) {
                double var11 = var6.bX.credits;
                if (var11 < (double)this.b) {
                    var10 = var7;
                }
            }

            var1.a("$" + this.b + var8, var10);
            ++var9;
        }

        if (var3) {
            if (this.c > 0.0F && var9 < var4) {
                var1.b(class_340.g(this.c) + " energy" + var8);
                ++var9;
            }

            if (this.d > 0.0F && var9 < var4) {
                var1.b(class_340.g(this.d) + " hp" + var8);
                ++var9;
            }

            if (this.e > 0.0F && var9 < var4) {
                var1.b(class_340.g(this.e) + " shield" + var8);
                ++var9;
            }

            if (this.f > 0 && var9 < var4) {
                var1.b(class_340.g((float)this.f) + " ammo" + var8);
                ++var9;
            }
        }

        if (!this.k.c()) {
            this.k.a(var1, var2, var3, var4 - var9, var5, false, var6, var7);
        }

        var1.a(var8);
    }

    public class_447 i(Unit var1) {
        class_447 var2 = new class_447();
        if (this.b > 0 && var1.bX.credits < (double)this.b) {
            var2.b = this.b - (int)var1.bX.credits;
        }

        if (!this.k.c()) {
            var2.k = this.k.a(var1);
        }

        return var2;
    }

    public String a(Unit var1, int var2, boolean var3) {
        String var4 = null;
        String var5 = ", ";
        int var6 = 0;
        if (this.b > 0 && var6 < var2 && var1.bX.credits < (double)this.b) {
            if (var4 == null) {
                var4 = "";
            }

            var4 = var4 + "credits" + var5;
            ++var6;
        }

        if (!this.k.c()) {
            String var7 = this.k.a(var1, var5, var2, var3);
            if (var7 != null) {
                if (var4 == null) {
                    var4 = "";
                }

                var4 = var4 + var7;
            }
        }

        if (var4 == null) {
            return null;
        } else {
            var4 = class_340.a(var4, var5);
            return var4;
        }
    }

    public int a(class_447 var1) {
        return this.b - var1.b;
    }

    public static void a(GameOutputStream var0, class_447 var1) {
        var0.writeBoolean(var1 != null);
        if (var1 != null) {
            var1.a(var0);
        }

    }

    public void a(GameOutputStream var1) {
        boolean var2 = false;
        boolean var3 = false;
        if (this.c != 0.0F || this.d != 0.0F || this.e != 0.0F || this.f != 0) {
            var2 = true;
        }

        if (this.g != 0 || this.h != 0 || this.i != 0 || this.j != 0) {
            var2 = true;
        }

        if (!this.k.c()) {
            var3 = true;
        }

        byte var4 = 0;
        if (var2) {
            var4 = (byte)(var4 | 1);
        }

        if (var3) {
            var4 = (byte)(var4 | 2);
        }

        var1.writeByte(var4);
        var1.writeInt(this.b);
        if (var2) {
            var1.writeFloat(this.c);
            var1.writeFloat(this.d);
            var1.writeFloat(this.e);
            var1.writeInt(this.f);
            var1.writeInt(this.g);
            var1.writeInt(this.h);
            var1.writeInt(this.i);
            var1.writeInt(this.j);
        }

        if (var3) {
            this.k.a(var1);
        }

    }

    public static class_447 a(GameInputStream var0) {
        boolean var1 = var0.readBoolean();
        return var1 ? b(var0) : null;
    }

    public static class_447 b(GameInputStream var0) {
        class_447 var1 = new class_447();
        byte var2 = var0.readByte();
        boolean var3 = b(var2, 1);
        boolean var4 = b(var2, 2);
        var1.b = var0.readInt();
        if (var3) {
            var1.c = var0.readFloat();
            var1.d = var0.readFloat();
            var1.e = var0.readFloat();
            var1.f = var0.readInt();
            var1.g = var0.readInt();
            var1.h = var0.readInt();
            var1.i = var0.readInt();
            var1.j = var0.readInt();
        }

        if (var4) {
            var1.k = new class_1069();
            var1.k.a(var0);
        }

        return var1;
    }

    public boolean b(Unit var1, boolean var2) {
        if (this.c(var1, var2)) {
            this.d(var1, var2);
            return true;
        } else {
            return false;
        }
    }

    public boolean c(Unit var1, boolean var2) {
        if (this.b > 0 && !var1.bX.g(this.b)) {
            return false;
        } else {
            return var2 ? class_517.c(var1, this) : this.b(var1);
        }
    }

    public void d(Unit var1, boolean var2) {
        PlayerData var10000 = var1.bX;
        var10000.p -= (double)this.b;
        var1.bX.q = 0;
        if (var2) {
            class_517.a(var1, this);
        }

    }

    public void e(Unit var1, boolean var2) {
        PlayerData var10000 = var1.bX;
        var10000.p += (double)this.b;
        var1.bX.q = 0;
        if (var2) {
            class_517.b(var1, this);
        }

    }

    public static boolean b(class_447 var0, class_447 var1) {
        if (var1 == var0) {
            return true;
        } else {
            return var1 != null && var0 != null ? var1.b(var0) : false;
        }
    }

    public boolean b(class_447 var1) {
        if (this.b != var1.b) {
            return false;
        } else if (this.d != var1.d) {
            return false;
        } else if (this.e != var1.e) {
            return false;
        } else if (this.f != var1.f) {
            return false;
        } else if (this.k.c() != var1.k.c()) {
            return false;
        } else {
            return this.k.c() || var1.k.c() || this.k.e(var1.k);
        }
    }

    public boolean c(class_447 var1) {
        if (this.b > 0 && var1.b > 0) {
            return true;
        } else if (this.d > 0.0F && var1.d > 0.0F) {
            return true;
        } else if (this.e > 0.0F && var1.e > 0.0F) {
            return true;
        } else if (this.f > 0 && var1.f > 0) {
            return true;
        } else {
            return !this.k.c() && !var1.k.c() && this.k.f(var1.k);
        }
    }

    // $FF: synthetic method
    public int compareTo(Object var1) {
        return this.a((class_447)var1);
    }
}
