package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.ay
public abstract strictfp class class_76 extends class_75 {
    public int es;
    public int et;
    public float eu;
    public float ev;
    public boolean ew;

    public strictfp void b(TeamImageCache var1) {
        this.T(var1.p);
        this.U(var1.q);
        this.ew = true;
    }

    public strictfp void a(TeamImageCache var1, int var2) {
        this.T(var1.p / var2);
        this.U(var1.q);
        this.ew = false;
    }

    public strictfp void T(int var1) {
        this.es = var1;
        this.eu = (float)(var1 / 2);
    }

    public strictfp void U(int var1) {
        this.et = var1;
        this.ev = (float)(var1 / 2);
    }

    public strictfp void V(int var1) {
        this.es = var1;
        this.eu = (float)var1 / 2.0F;
    }

    public strictfp void W(int var1) {
        this.et = var1;
        this.ev = (float)var1 / 2.0F;
    }

    protected class_76(boolean var1) {
        super(var1);
    }

    public strictfp void a() {
        super.a();
    }
}
