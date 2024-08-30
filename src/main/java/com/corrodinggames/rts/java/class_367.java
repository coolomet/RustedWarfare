package com.corrodinggames.rts.java;

import com.corrodinggames.rts.appFramework.class_0;
import com.corrodinggames.rts.appFramework.class_198;
import com.corrodinggames.rts.appFramework.class_212;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.class_27;
import com.corrodinggames.rts.gameFramework.m.class_843;
import com.corrodinggames.rts.gameFramework.m.class_933;

// $FF: renamed from: com.corrodinggames.rts.java.d
public strictfp class class_367 implements class_0 {
    public int a;
    public int b;
    class_199 c = new class_199();
    class_212 d;
    public Object e = new Object();
    public Object f = new Object();
    class_843 g = new class_843();

    public void j() {
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        return false;
    }

    public class_933 d() {
        return null;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1 != null && var1.settingsEngine.slick2dFullScreen;
    }

    public Object g() {
        return null;
    }

    public int o() {
        return this.a;
    }

    public int p() {
        return this.b;
    }

    public void h() {
    }

    public class_198 i() {
        return this.c;
    }

    public class_212 k() {
        return this.d;
    }

    public void a(float var1, int var2) {
        synchronized(this.f) {
            this.f.notifyAll();
        }
    }

    public void b(float var1, int var2) {
    }

    public void l() {
    }

    public class_27 b(boolean var1) {
        return this.g;
    }

    public void a(class_27 var1, boolean var2) {
    }

    public void m() {
    }

    public boolean n() {
        return true;
    }

    public void a(boolean var1) {
    }
}
