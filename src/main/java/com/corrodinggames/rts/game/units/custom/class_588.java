package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.h
public final strictfp class class_588 {
    public final class_585[] a;

    public class_588(class_585[] var1) {
        this.a = var1;
    }

    public boolean a() {
        return this.a.length == 0;
    }

    public boolean a(class_588 var1) {
        if (var1 == null) {
            return this.a();
        } else if (this.a.length != var1.a.length) {
            return false;
        } else {
            class_585[] var2 = this.a;
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                class_585 var5 = var2[var4];
                boolean var6 = false;
                class_585[] var7 = var1.a;
                int var8 = var7.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    class_585 var10 = var7[var9];
                    if (var5 == var10) {
                        var6 = true;
                        break;
                    }
                }

                if (!var6) {
                    return false;
                }
            }

            return true;
        }
    }

    public int b() {
        return this.a.length;
    }

    public String toString() {
        String var1 = "";
        boolean var2 = true;
        class_585[] var3 = this.a;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            class_585 var6 = var3[var5];
            if (!var2) {
                var1 = var1 + ", ";
            }

            var2 = false;
            var1 = var1 + var6.a;
        }

        return "{" + var1 + "}";
    }
}
