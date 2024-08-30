package com.corrodinggames.rts.gameFramework.utility;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.h
class class_677 implements Iterator {
    private int b;
    private int c;
    private int d;
    // $FF: synthetic field
    final class_676 a;

    private class_677(class_676 var1) {
        this.a = var1;
        this.b = class_676.a(this.a);
        this.c = class_676.b(this.a);
        this.d = -1;
    }

    public boolean hasNext() {
        return this.b != this.c;
    }

    public Object next() {
        if (this.b == this.c) {
            throw new NoSuchElementException();
        } else {
            Object var1 = class_676.c(this.a)[this.b];
            if (class_676.b(this.a) == this.c && var1 != null) {
                this.d = this.b;
                this.b = this.b + 1 & class_676.c(this.a).length - 1;
                return var1;
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }

    public void remove() {
        if (this.d < 0) {
            throw new IllegalStateException();
        } else {
            if (class_676.a(this.a, this.d)) {
                this.b = this.b - 1 & class_676.c(this.a).length - 1;
                this.c = class_676.b(this.a);
            }

            this.d = -1;
        }
    }

    // $FF: synthetic method
    class_677(class_676 var1, class_606 var2) {
        this(var1);
    }
}
