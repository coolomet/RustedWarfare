package com.corrodinggames.rts.gameFramework.utility;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.n
class class_685 implements Iterator {
    private int b;
    private int c;
    private int d;
    // $FF: synthetic field
    final class_684 a;

    private class_685(class_684 var1) {
        this.a = var1;
        this.b = this.a.a;
        this.c = -1;
        this.d = class_684.a(this.a);
    }

    public boolean hasNext() {
        return this.b != 0;
    }

    public Object next() {
        class_684 var1 = this.a;
        int var2 = this.b;
        if (class_684.b(var1) != this.d) {
            throw new ConcurrentModificationException();
        } else if (var2 == 0) {
            throw new NoSuchElementException();
        } else {
            this.b = var2 - 1;
            return var1.b[this.c = var1.a - var2];
        }
    }

    public void remove() {
        Object[] var1 = this.a.b;
        int var2 = this.c;
        if (class_684.c(this.a) != this.d) {
            throw new ConcurrentModificationException();
        } else if (var2 < 0) {
            throw new IllegalStateException();
        } else {
            System.arraycopy(var1, var2 + 1, var1, var2, this.b);
            var1[--this.a.a] = null;
            this.c = -1;
            this.d = class_684.d(this.a);
        }
    }

    // $FF: synthetic method
    class_685(class_684 var1, class_142 var2) {
        this(var1);
    }
}
