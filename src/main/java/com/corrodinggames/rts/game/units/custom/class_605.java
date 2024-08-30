package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.d.class_998;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.z
public strictfp class class_605 {
    public String a;
    public class_429[] b;
    // $FF: synthetic field
    final class_591 c;

    public strictfp boolean a() {
        return this.b != null && this.b.length != 0;
    }

    public strictfp boolean b() {
        return this.b != null && (this.b.length != 0 || this.b == class_591.gf);
    }

    private class_605(class_591 var1, String var2) {
        this.c = var1;
        this.a = var2;
        var1.gc.add(this);
    }

    public strictfp void c() {
        if (this.a != null && !this.a.equals("")) {
            if (this.a.equalsIgnoreCase("NONE")) {
                this.b = class_591.gf;
            } else {
                ArrayList var1 = new ArrayList();
                String[] var2 = this.a.split(",");
                String[] var3 = var2;
                int var4 = var2.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    String var6 = var3[var5];
                    var6 = var6.trim();
                    String[] var7 = var6.split("\\*");
                    String var8 = var7[0];
                    int var9 = 1;
                    if (var7.length >= 2) {
                        var9 = Integer.parseInt(var7[1]);
                    }

                    class_429 var10 = this.c.d(var8);

                    for(int var11 = 0; var11 < var9; ++var11) {
                        var1.add(var10);
                    }
                }

                this.b = (class_429[])var1.toArray(class_591.ge);
            }
        } else {
            this.b = class_591.ge;
        }
    }

    public strictfp class_998 a(float var1, float var2, float var3, float var4, GameObject var5) {
        return this.a(var1, var2, var3, var4, var5, 0, (short)0);
    }

    public strictfp class_998 a(float var1, float var2, float var3, float var4, GameObject var5, int var6, short var7) {
        class_998 var8 = null;
        class_429[] var9 = this.b;
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            class_429 var12 = var9[var11];
            class_998 var13 = var12.a(var1, var2, var3, var4, var5, var6, var7);
            if (var13 != null && var8 == null) {
                var8 = var13;
            }
        }

        return var8;
    }

    // $FF: synthetic method
    class_605(class_591 var1, String var2, class_607 var3) {
        this(var1, var2);
    }
}
