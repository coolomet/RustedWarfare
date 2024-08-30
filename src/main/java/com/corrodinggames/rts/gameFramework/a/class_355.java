package com.corrodinggames.rts.gameFramework.a;

import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.a.i
public abstract strictfp class class_355 {
    public float d = 1.0F;
    public String e;
    public boolean f = false;
    public boolean g;

    public class_355(String var1, class_349 var2) {
        this.e = class_340.g(var1);
        if (var2 != null) {
            var2.h.put(this.e, this);
        }

    }

    public abstract void a(float var1, float var2, int var3, int var4, float var5);

    public abstract int a();
}
