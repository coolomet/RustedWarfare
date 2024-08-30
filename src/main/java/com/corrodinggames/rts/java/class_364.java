package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_363;
import com.corrodinggames.rts.gameFramework.utility.SlickToAndroidKeycodes;

// $FF: renamed from: com.corrodinggames.rts.java.v
public strictfp class class_364 extends class_363 {
    public boolean a(int var1, int var2, boolean var3) {
        return super.a(var1, var2, var3);
    }

    public boolean a(int var1, int var2) {
        return false;
    }

    public int a() {
        return 0;
    }

    public float b(int var1, int var2) {
        return 0.0F;
    }

    public String c(int var1, int var2) {
        return GameEngine.j(var2) + SlickToAndroidKeycodes.a(var1);
    }
}
