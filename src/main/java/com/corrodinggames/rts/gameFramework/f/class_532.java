package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.n
public strictfp class class_532 {
    String a;
    String b;
    long c;
    String d;
    public int e = -1;
    public int f = -1;

    public int a() {
        return (int)(System.currentTimeMillis() - this.c);
    }

    public boolean b() {
        short var1 = 14000;
        GameEngine var2 = GameEngine.getGameEngine();
        if (var2.a()) {
            return true;
        } else {
            return this.c + (long)var1 > System.currentTimeMillis();
        }
    }
}
