package com.corrodinggames.rts.gameFramework.b;

import android.opengl.GLES20;
import android.util.Log;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.s
class class_456 extends class_455 {
    public class_456(String var1) {
        super(var1);
    }

    public void a(int var1) {
        if (this.c != var1) {
            this.a = GLES20.glGetUniformLocation(var1, this.b);
            this.c = var1;
            class_480.r();
            if (this.a == -1) {
                Log.d(class_480.s(), "loadHandle: Failed to find: " + this.b);
            }
        }

    }
}
