package com.corrodinggames.rts.gameFramework.b;

import android.opengl.GLES20;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.t
public strictfp class class_461 implements class_9 {
    private final int[] a = new int[1];

    public int a() {
        GLES20.glGenTextures(1, this.a, 0);
        class_480.q();
        return this.a[0];
    }
}
