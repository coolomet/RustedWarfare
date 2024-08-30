package com.corrodinggames.rts.gameFramework.b.a.a;

import com.corrodinggames.rts.gameFramework.b.a.class_495;
import com.corrodinggames.rts.gameFramework.b.a.class_497;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.a.a.b
public abstract strictfp class class_562 {
    private int a;
    private int b;
    private int c;
    private boolean d = false;

    public void a() {
        this.a((String)null, (String)null, (class_495[])null);
    }

    public void a(String var1, String var2, class_495[] var3) {
        this.b = class_497.a(35633, var1);
        this.c = class_497.a(35632, var2);
        this.a = class_497.a(this.b, this.c, var3);
        this.d = true;
    }

    public int b() {
        return this.a;
    }
}
