package com.corrodinggames.rts.game.units.f;

import android.graphics.RectF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.game.units.f.d
public final strictfp class class_1013 extends class_1012 {
    public RectF a = new RectF();
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;

    public final boolean a(Unit var1) {
        float var2 = var1.xCord;
        float var3 = var1.yCord;
        if (this.b <= var2 && var2 <= this.c && this.d <= var3 && var3 <= this.e) {
            float var4 = class_340.a(this.f, this.g, var2, var3);
            return var4 < this.h;
        } else {
            return false;
        }
    }
}
