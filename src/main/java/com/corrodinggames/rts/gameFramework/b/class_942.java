package com.corrodinggames.rts.gameFramework.b;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.al
// maybe error maybe
public strictfp class class_942 {

    public FloatBuffer a;
    public ShortBuffer b;
    public int c;
    int[] d;
    int e;
    // $FF: synthetic field
    class_943 f;

    public void a(float[] var1, int var2, int var3) {
        this.a.clear();
        int var10000 = var2 + var3;
        this.a.put(var1, 0, var3);
        this.a.flip();
        this.c = var3;
    }

    public void a() {
        GLES20.glEnableVertexAttribArray(this.f.h.a.a);
        GLES20.glEnableVertexAttribArray(this.f.h.b.a);
    }

    public void b() {
        class_480.q();
        if (this.d == null) {
            this.d = new int[1];
            GLES20.glGenBuffers(1, this.d, 0);
            class_480.r();
        }

        ++this.e;
        if (this.e >= 1) {
            this.e = 0;
        }

        GLES20.glBindBuffer(34962, this.d[this.e]);
        GLES20.glBufferData(34962, this.c * 4, this.a, 35040);
        GLES20.glVertexAttribPointer(this.f.h.a.a, 2, 5126, false, 32, 0);
        class_480.q();
        class_480.q();
        GLES20.glVertexAttribPointer(this.f.h.b.a, 4, 5126, false, 32, 16);
        class_480.q();
    }

    public void a(int var1, int var2, int var3) {
        if (this.b != null) {
            this.b.position(var2);
            GLES20.glDrawElements(var1, var3, 5123, this.b);
        } else {
            GLES20.glDrawArrays(var1, var2, var3);
        }

    }

    public void c() {
        GLES20.glBindBuffer(34962, 0);
    }

    public void d() {
        this.a();
    }

    public void e() {
        GLES20.glDisableVertexAttribArray(this.f.h.b.a);
    }
}
