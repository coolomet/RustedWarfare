package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bb
public strictfp class class_388 {
    public static final class_388 a = a("");
    public class_389[] b;
    public String c;
    public int d = -1;
    public String e;

    public static class_388 a(String var0) {
        class_388 var1 = new class_388();
        ArrayList var2 = new ArrayList();
        class_389 var3 = new class_389();
        var3.a = null;
        var3.b = var0;
        var2.add(var3);
        var1.b = (class_389[])var2.toArray(new class_389[0]);
        var1.b();
        return var1;
    }

    public static class_388 b(String var0) {
        class_388 var1 = new class_388();
        var1.e = var0;
        var1.b();
        return var1;
    }

    public class_388() {
    }

    public class_388(class_389[] var1) {
        this.b = var1;
    }

    public boolean a() {
        if (this.b != null) {
            class_389[] var1 = this.b;
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                class_389 var4 = var1[var3];
                if (var4.b != null && !"".equals(var4.b)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void a(String var1, String var2) {
        if (this.b != null) {
            class_389[] var3 = this.b;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                class_389 var6 = var3[var5];
                var6.a(var1, var2);
            }
        } else {
            GameEngine.print("LocaleString: replaceAll with null strings");
        }

        this.d = -1;
    }

    public String b() {
        if (this.d == class_1009.c) {
            return this.c;
        } else if (this.e != null) {
            this.d = class_1009.c;
            this.c = class_1009.a(this.e);
            return this.c;
        } else {
            String var1 = class_1009.c();
            class_389[] var2 = this.b;
            int var3 = var2.length;

            int var4;
            class_389 var5;
            for(var4 = 0; var4 < var3; ++var4) {
                var5 = var2[var4];
                if (var1.equals(var5.a)) {
                    this.d = class_1009.c;
                    this.c = var5.b;
                    return this.c;
                }
            }

            var2 = this.b;
            var3 = var2.length;

            for(var4 = 0; var4 < var3; ++var4) {
                var5 = var2[var4];
                if (var5.a == null) {
                    this.d = class_1009.c;
                    this.c = var5.b;
                    return this.c;
                }
            }

            this.d = class_1009.c;
            this.c = "<NO DEFAULT TEXT FOUND>";
            return this.c;
        }
    }
}
