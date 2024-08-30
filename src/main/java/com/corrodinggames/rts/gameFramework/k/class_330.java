package com.corrodinggames.rts.gameFramework.k;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.k.b
class class_330 implements Iterator {
    private int b;
    private int c;
    private int d;
    // $FF: synthetic field
    final class_329 a;

    private class_330(class_329 var1) {
        this.a = var1;
        this.b = this.a.b;
        this.c = -1;
        this.d = class_329.a(this.a);
    }

    public boolean hasNext() {
        return this.b != 0;
    }

    public class_322 a() {
        class_329 var1 = this.a;
        int var2 = this.b;
        if (class_329.b(var1) != this.d) {
            throw new ConcurrentModificationException();
        } else if (var2 == 0) {
            throw new NoSuchElementException();
        } else {
            this.b = var2 - 1;
            return var1.c[this.c = var1.b - var2];
        }
    }

    public void remove() {
        class_322[] var1 = this.a.c;
        int var2 = this.c;
        if (class_329.c(this.a) != this.d) {
            throw new ConcurrentModificationException();
        } else if (var2 < 0) {
            throw new IllegalStateException();
        } else {
            System.arraycopy(var1, var2 + 1, var1, var2, this.b);
            var1[--this.a.b] = null;
            this.c = -1;
            this.d = class_329.d(this.a);
        }
    }

    // $FF: synthetic method
    public Object next() {
        return this.a();
    }

    // $FF: synthetic method
    class_330(class_329 var1, class_578 var2) {
        this(var1);
    }
}
