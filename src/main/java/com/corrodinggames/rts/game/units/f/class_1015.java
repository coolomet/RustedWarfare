package com.corrodinggames.rts.game.units.f;

import android.graphics.RectF;
import com.corrodinggames.rts.game.units.Unit;

// $FF: renamed from: com.corrodinggames.rts.game.units.f.h
public final strictfp class class_1015 extends class_1012 {
    public RectF a = new RectF();
    public float b;
    public float c;
    public float d;
    public float e;

    public final boolean a(Unit var1) {
        float var2 = var1.cj;
        float var3 = var1.xCord;
        float var4 = var1.yCord;
        return this.b - var2 <= var3 && var3 <= this.c + var2 && this.d - var2 <= var4 && var4 <= this.e + var2;
    }
}
