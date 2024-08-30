package com.corrodinggames.rts.gameFramework.b;

import android.graphics.Bitmap;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.ai
class class_940 implements Cloneable {
    public boolean a;
    public Bitmap.Config b;
    public int c;

    private class_940() {
    }

    public int hashCode() {
        int var1 = this.b.hashCode() ^ this.c;
        return this.a ? var1 : -var1;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof class_940)) {
            return false;
        } else {
            class_940 var2 = (class_940)var1;
            return this.a == var2.a && this.b == var2.b && this.c == var2.c;
        }
    }

    public class_940 a() {
        try {
            return (class_940)super.clone();
        } catch (CloneNotSupportedException var2) {
            throw new AssertionError(var2);
        }
    }

    // $FF: synthetic method
    public Object clone() {
        return this.a();
    }

    // $FF: synthetic method
    class_940(class_608 var1) {
        this();
    }
}
