package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.class_970;
import com.corrodinggames.rts.gameFramework.class_971;
import com.corrodinggames.rts.gameFramework.class_972;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.ab
public strictfp class class_520 {
    private class_972 a;
    private int b;
    private int c;
    private int d;
    private ArrayList e = new ArrayList();

    public class_520(class_972 var1, ArrayList var2) {
        this.a = var1;
        ArrayList var3 = new ArrayList();
        Iterator var4 = var2.iterator();

        while(var4.hasNext()) {
            class_524 var5 = (class_524)var4.next();
            class_971 var6 = var5.a.a(var1);
            var3.add(var6);
            Iterator var7 = var6.iterator();

            while(var7.hasNext()) {
                class_970 var8 = (class_970)var7.next();
                if (var8.b > this.b) {
                    this.b = var8.b;
                }

                if (var8.b < this.c) {
                    this.c = var8.b;
                }

                if (var8.a > this.d) {
                    this.d = var8.a;
                }
            }
        }

        this.a(var3);
    }

    private void a(ArrayList var1) {
        int var2 = var1.size();
        class_522 var3 = new class_522(var2);
        int[] var4 = new int[var2];
        int var5 = 0;

        boolean var12;
        do {
            ++var5;
            if (var5 > 1000000) {
                throw new RuntimeException("loopIndex: " + var5);
            }

            boolean var6 = true;

            for(int var7 = 0; var7 < var2; ++var7) {
                class_971 var8 = (class_971)var1.get(var7);
                if (var4[var7] < var8.size()) {
                    class_970 var9 = (class_970)var8.get(var4[var7]);
                    if (var9.a <= class_522.a(var3)) {
                        var3.a(var7, var9.b);
                        int var10002 = var4[var7]++;
                        var6 = false;
                    }
                }
            }

            var12 = var6;
            int var13 = Integer.MAX_VALUE;
            if (var6) {
                this.e.add(var3);

                for(int var14 = 0; var14 < var2; ++var14) {
                    class_971 var10 = (class_971)var1.get(var14);
                    if (var4[var14] < var10.size()) {
                        class_970 var11 = (class_970)var10.get(var4[var14]);
                        if (var11.a < var13) {
                            var13 = var11.a;
                            var12 = false;
                        }
                    }
                }

                var3 = new class_522(var13, var3);
            }
        } while(!var12);

    }

    // $FF: synthetic method
    static int a(class_520 var0) {
        return var0.b;
    }

    // $FF: synthetic method
    static int b(class_520 var0) {
        return var0.c;
    }

    // $FF: synthetic method
    static class_972 c(class_520 var0) {
        return var0.a;
    }

    // $FF: synthetic method
    static int d(class_520 var0) {
        return var0.d;
    }

    // $FF: synthetic method
    static ArrayList e(class_520 var0) {
        return var0.e;
    }
}
