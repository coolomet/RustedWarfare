package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Paint;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.ag
public strictfp class class_511 extends class_510 {
    public Paint a;
    public int b;
    // $FF: synthetic field
    final class_523 c;

    class_511(class_523 var1, String var2, Paint var3) {
        super(var1, var2);
        this.c = var1;
        this.b = 0;
        this.a = var3;
    }

    class_511(class_523 var1, String var2, Paint var3, int var4) {
        super(var1, var2);
        this.c = var1;
        this.b = 0;
        this.a = var3;
        this.b = var4;
    }

    public Paint b(Paint var1) {
        if (this.a == null) {
            if (this.b != 0) {
                class_523.f.a(var1);
                class_523.f.b(this.b);
                return class_523.f;
            } else {
                return var1;
            }
        } else if (this.b != 0) {
            class_523.f.a(this.a);
            class_523.f.b(this.b);
            return class_523.f;
        } else {
            return this.a;
        }
    }

    public class_511 a(String var1) {
        class_511 var2 = new class_511(this.c, var1, this.a, this.b);
        return var2;
    }

    // $FF: synthetic method
    public class_510 b(String var1) {
        return this.a(var1);
    }
}
