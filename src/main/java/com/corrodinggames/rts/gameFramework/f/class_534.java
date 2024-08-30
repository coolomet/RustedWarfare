package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Paint;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.l
public strictfp class class_534 {
    Paint a;
    String b;
    int c = -1;
    float d;
    Paint e;
    String f;
    int g = -1;
    float h;

    public class_534(String var1, Paint var2, String var3, Paint var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        this.a = var2;
        this.b = var1;
        this.d = (float)var5.bO.b(var1, var2);
        this.e = var4;
        this.f = var3;
        this.h = (float)var5.bO.b(var3, var4);
    }
}
