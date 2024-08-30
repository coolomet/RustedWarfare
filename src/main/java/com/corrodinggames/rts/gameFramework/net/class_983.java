package com.corrodinggames.rts.gameFramework.net;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.aj
public strictfp class class_983 {
    String a;
    long b;
    String c;

    public strictfp String a() {
        return this.c != null ? this.c : "Active ban";
    }

    public strictfp float b() {
        long var1 = System.currentTimeMillis();
        return (float)(this.b - var1) / 1000.0F;
    }
}
