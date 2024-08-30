package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Unit;
import com.corrodinggames.rts.gameFramework.class_1001;
import com.corrodinggames.rts.gameFramework.class_345;
import com.corrodinggames.rts.gameFramework.class_373;
import com.corrodinggames.rts.gameFramework.class_976;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio;

// $FF: renamed from: com.corrodinggames.rts.java.l
public strictfp class class_376 extends class_373 {
    volatile boolean a;
    public OpenALAudio b;
    boolean c = false;

    public Object f() {
        return this.b;
    }

    public void a(float var1) {
        synchronized(this.f()) {
            if (this.a) {
                return;
            }

            long var3 = Unit.loadAllUnitsTook();
            this.b.update();
            double var5 = (double)Unit.a(var3);
            if (var5 > 16.0) {
                GameEngine.log("music poll took:" + Unit.a(var5));
            }
        }

        super.a(var1);
    }

    public void a(int var1) {
    }

    public class_376(OpenALAudio var1) {
        this.b = var1;
    }

    public class_976 a(String var1) {
        return new LoadMusic(var1, this);
    }

    public class_345 a() {
        class_348 var1 = new class_348(this);
        return var1;
    }

    public void a(class_1001 var1) {
        this.e = var1;
    }

    public void b() {
        synchronized(this.f()) {
            this.a = true;
        }
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return 100;
    }
}
