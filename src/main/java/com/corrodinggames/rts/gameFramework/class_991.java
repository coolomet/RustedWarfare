package com.corrodinggames.rts.gameFramework;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.af
public abstract strictfp class class_991 {
    public int a = -1;
    public int b = 0;
    protected boolean c;
    public boolean d;

    public abstract boolean a();

    public boolean a(class_991 var1) {
        if (this.b != var1.b) {
            return false;
        } else {
            return this.a == var1.a;
        }
    }

    public abstract boolean b();

    public abstract String c();

    public abstract boolean d();
}
