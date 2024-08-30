package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Paint;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.ai
public strictfp class class_510 extends class_508 {
    String d;
    // $FF: synthetic field
    final class_523 e;

    public int a(Paint var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        Paint var3 = this.b(var1);
        int var4 = var2.bO.b(this.d, var3);
        if (GameEngine.at()) {
        }

        return var4;
    }

    public Paint b(Paint var1) {
        return var1;
    }

    class_510(class_523 var1, String var2) {
        this.e = var1;
        this.d = var2;
    }

    public class_510 b(String var1) {
        class_510 var2 = new class_510(this.e, var1);
        return var2;
    }
}
