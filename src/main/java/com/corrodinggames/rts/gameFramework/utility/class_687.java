package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.GameObject;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.t
class class_687 implements Iterator {
    private int b;
    private int c;
    private int d;
    // $FF: synthetic field
    final class_686 a;

    private class_687(class_686 var1) {
        this.a = var1;
        this.b = this.a.b;
        this.c = -1;
        this.d = class_686.a(this.a);
    }

    public boolean hasNext() {
        return this.b != 0;
    }

    public GameObject a() {
        class_686 var1 = this.a;
        int var2 = this.b;
        if (class_686.b(var1) != this.d) {
            throw new ConcurrentModificationException("on:" + this.a.d + " (modCount:" + class_686.c(this.a) + " expectedModCount:" + this.d + ")");
        } else if (var2 == 0) {
            throw new NoSuchElementException();
        } else {
            this.b = var2 - 1;
            return var1.c[this.c = var1.b - var2];
        }
    }

    public void remove() {
        GameObject[] var1 = this.a.c;
        int var2 = this.c;
        if (class_686.d(this.a) != this.d) {
            throw new ConcurrentModificationException("on:" + this.a.d + " (modCount:" + class_686.e(this.a) + " expectedModCount:" + this.d + ")");
        } else if (var2 < 0) {
            throw new IllegalStateException();
        } else {
            System.arraycopy(var1, var2 + 1, var1, var2, this.b);
            var1[--this.a.b] = null;
            this.c = -1;
            this.d = class_686.f(this.a);
        }
    }

    // $FF: synthetic method
    public Object next() {
        return this.a();
    }

    // $FF: synthetic method
    class_687(class_686 var1, class_947 var2) {
        this(var1);
    }
}
