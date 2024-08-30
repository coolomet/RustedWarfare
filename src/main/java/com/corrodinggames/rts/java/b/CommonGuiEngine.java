package com.corrodinggames.rts.java.b;

import com.corrodinggames.librocket.class_790;
import com.corrodinggames.rts.java.Main;

public strictfp class CommonGuiEngine extends class_790 {
    public Main f;
    boolean g = false;

    public static synchronized CommonGuiEngine p() {
        if (a != null) {
            throw new RuntimeException("CommonGuiEngine already exists");
        } else {
            CommonGuiEngine var0 = new CommonGuiEngine();
            a = var0;
            return var0;
        }
    }

    public void g() {
        this.f.i();
    }

    public void h() {
        this.f.u = true;
    }

    public int i() {
        return this.f.j.e();
    }

    public void d(boolean var1) {
        this.f.a(var1);
    }
}
