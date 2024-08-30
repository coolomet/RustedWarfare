package com.corrodinggames.rts.gameFramework.b;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.aa
public strictfp class class_946 {
    // maybe error
    public FloatBuffer a;
    public ShortBuffer b;
    public int c;
    public int d;
    int[] e;
    int f;
    // $FF: synthetic field
    class_465 g;

    public void a(float[] var1, int var2, int var3) {
        this.a.clear();
        int var10000 = var2 + var3;
        this.a.put(var1, 0, var3);
        this.a.flip();
        this.d = var3;
    }

    public void a() {
        GLES20.glEnableVertexAttribArray(this.g.j.a.a);
        GLES20.glEnableVertexAttribArray(this.g.j.b.a);
        GLES20.glEnableVertexAttribArray(this.g.j.c.a);
    }

    public void b() {
        class_480.q();
        if (this.e == null) {
            this.e = new int[1];
            GLES20.glGenBuffers(1, this.e, 0);
            class_480.r();
        }

        ++this.f;
        if (this.f >= 1) {
            this.f = 0;
        }

        GLES20.glBindBuffer(34962, this.e[this.f]);
        GLES20.glBufferData(34962, this.d * 4, this.a, 35040);
        GLES20.glVertexAttribPointer(this.g.j.a.a, 2, 5126, false, 32, 0);
        class_480.q();
        GLES20.glVertexAttribPointer(this.g.j.b.a, 2, 5126, false, 32, 8);
        class_480.q();
        GLES20.glVertexAttribPointer(this.g.j.c.a, 4, 5126, false, 32, 16);
        class_480.q();
    }

    public void a(int var1, int var2, int var3) {
        if (this.b != null) {
            GLES20.glDrawElements(var1, var3, 5123, 0);
        } else {
            GLES20.glDrawArrays(var1, var2, var3);
        }

    }

    public void c() {
        GLES20.glBindBuffer(34962, 0);
    }

    public void d() {
        GLES20.glBindBuffer(34963, this.c);
        this.a();
    }

    public void e() {
        GLES20.glDisableVertexAttribArray(this.g.j.b.a);
        GLES20.glDisableVertexAttribArray(this.g.j.c.a);
        GLES20.glBindBuffer(34963, 0);
    }
}
