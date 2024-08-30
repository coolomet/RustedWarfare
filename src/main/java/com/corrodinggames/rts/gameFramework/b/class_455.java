package com.corrodinggames.rts.gameFramework.b;

import android.opengl.GLES20;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.q
abstract class class_455 {
    public int a = -1;
    protected final String b;
    public int c = -1;

    public class_455(String var1) {
        this.b = var1;
    }

    public abstract void a(int var1);

    public void a(float[] var1) {
        GLES20.glUniformMatrix4fv(this.a, 1, false, var1, 0);
    }
}
