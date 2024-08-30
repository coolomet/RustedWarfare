package com.corrodinggames.rts.gameFramework;

import android.graphics.Paint;
import com.corrodinggames.rts.gameFramework.m.class_525;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.m
class class_365 {
    float a;
    Paint b;
    // $FF: synthetic field
    final GameEngine c;

    class_365(GameEngine var1) {
        this.c = var1;
    }

    strictfp void a() {
        float var1 = (float)this.c.e(this.a);
        if (this.b.k() != var1) {
            if (this.b instanceof class_525) {
                ((class_525)this.b).c(var1);
            } else {
                this.b.b(var1);
            }
        }

    }
}
