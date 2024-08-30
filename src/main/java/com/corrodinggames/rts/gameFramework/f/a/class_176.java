package com.corrodinggames.rts.gameFramework.f.a;

import android.graphics.RectF;
import com.corrodinggames.rts.gameFramework.m.class_28;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.a.n
public strictfp class class_176 extends class_174 {
    class_186 b;

    public class_176() {
        this.b = class_186.j;
    }

    public void a(float var1, float var2) {
        super.a(var1, var2);
        class_28 var3 = this.d();
        RectF var4 = this.a(new RectF(), var1, var2);
        this.b.a(var3, var4);
    }
}
