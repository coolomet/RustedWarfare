package com.corrodinggames.rts.gameFramework.f.a;

import android.graphics.Color;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.m.class_28;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.a.f
public strictfp class class_177 extends class_176 {
    class_175 a;

    public static class_177 a(String var0, boolean var1) {
        class_177 var2 = new class_177();
        var2.b = class_186.n;
        var2.i = 200.0F;
        var2.j = 200.0F;
        class_178 var3 = new class_178();
        var3.a(var0);
        var3.e(5.0F);
        var3.f(5.0F);
        var3.a(-1);
        var2.a(var3);
        var2.a = new class_175(class_192.c);
        var2.a(var2.a);
        if (var1) {
            class_179 var4 = var2.b(class_1009.a("menus.common.cancel"));
            var4.a(new class_190(var2));
        }

        return var2;
    }

    public class_179 a(String var1) {
        class_179 var2 = new class_179();
        var2.a(var1);
        var2.e(5.0F);
        var2.f(5.0F);
        var2.a(Color.a(255, 30, 240, 30));
        return var2;
    }

    public class_179 b(String var1) {
        return this.a(var1, (class_189)null);
    }

    public class_179 a(String var1, class_189 var2) {
        class_179 var3 = this.a(var1);
        var3.a(var2);
        this.a.a(var3);
        return var3;
    }

    public void u_() {
        if (this.s) {
            this.b();
        }
    }

    public void b() {
        super.b();
        class_28 var1 = this.d();
        this.i = this.z;
        this.j = this.y;
        this.i += this.m + this.n;
        this.j += this.k + this.l;
    }
}
