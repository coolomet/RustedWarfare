package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_349;
import com.corrodinggames.rts.gameFramework.a.class_355;
import com.corrodinggames.rts.java.audio.Sound;

// $FF: renamed from: com.corrodinggames.rts.java.q
public strictfp class class_358 extends class_355 {
    Sound a;
    // $FF: synthetic field
    final class_352 b;

    public class_358(class_352 var1, String var2, class_349 var3) {
        super(var2, var3);
        this.b = var1;
    }

    public void a(float var1, float var2, int var3, int var4, float var5) {
        class_354 var6 = (class_354)this.b.c.a();
        if (var6 != null) {
            var6.b = var1;
            var6.c = var2;
            var6.d = var3;
            var6.e = var4;
            var6.f = var5;
            var6.a = this;
            this.b.b.offer(var6);
        }
    }

    public void b(float var1, float var2, int var3, int var4, float var5) {
        if (this.a == null) {
            GameEngine.log("Sound not loaded");
        } else {
            synchronized(this.b.b()) {
                float var7 = 0.0F;
                float var8 = class_340.f(var1, var2);
                this.a.play(var8, var5, var7);
            }
        }
    }

    public int a() {
        return this.a.getBytesUsed();
    }
}
