package com.corrodinggames.rts.gameFramework.utility;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.p
class class_683 implements Iterator {
    private int b;
    private int c;
    private int d;
    // $FF: synthetic field
    final class_682 a;

    private class_683(class_682 var1) {
        this.a = var1;
        this.b = this.a.c;
        this.c = -1;
        this.d = class_682.a(this.a);
    }

    public boolean hasNext() {
        return this.b != 0;
    }

    public Object next() {
        class_682 var1 = this.a;
        int var2 = this.b;
        if (class_682.b(var1) != this.d) {
            throw new ConcurrentModificationException();
        } else if (var2 == 0) {
            throw new NoSuchElementException();
        } else {
            this.b = var2 - 1;
            return var1.d[this.c = var1.c - var2];
        }
    }

    public void remove() {
        Object[] var1 = this.a.d;
        int var2 = this.c;
        if (class_682.c(this.a) != this.d) {
            throw new ConcurrentModificationException();
        } else if (var2 < 0) {
            throw new IllegalStateException();
        } else {
            System.arraycopy(var1, var2 + 1, var1, var2, this.b);
            var1[--this.a.c] = null;
            this.c = -1;
            this.d = class_682.d(this.a);
        }
    }

    // $FF: synthetic method
    class_683(class_682 var1, class_674 var2) {
        this(var1);
    }
}
