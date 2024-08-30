package com.corrodinggames.rts.gameFramework.b;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.w
public strictfp class class_467 {
    private int[] a;
    private int b;

    public void a(int var1) {
        if (this.a.length == this.b) {
            int[] var2 = new int[this.b + this.b];
            System.arraycopy(this.a, 0, var2, 0, this.b);
            this.a = var2;
        }

        this.a[this.b++] = var1;
    }
}
