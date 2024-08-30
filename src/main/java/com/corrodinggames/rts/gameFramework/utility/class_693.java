package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.game.units.Unit;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.v
class class_693 implements Iterator {
    private int b;
    private int c;
    private int d;
    // $FF: synthetic field
    final class_692 a;

    private class_693(class_692 var1) {
        this.a = var1;
        this.b = this.a.b;
        this.c = -1;
        this.d = class_692.a(this.a);
    }

    public boolean hasNext() {
        return this.b != 0;
    }

    public Unit a() {
        class_692 var1 = this.a;
        int var2 = this.b;
        if (class_692.b(var1) != this.d) {
            throw new ConcurrentModificationException();
        } else if (var2 == 0) {
            throw new NoSuchElementException();
        } else {
            this.b = var2 - 1;
            return var1.c[this.c = var1.b - var2];
        }
    }

    public void remove() {
        Unit[] var1 = this.a.c;
        int var2 = this.c;
        if (class_692.c(this.a) != this.d) {
            throw new ConcurrentModificationException();
        } else if (var2 < 0) {
            throw new IllegalStateException();
        } else {
            System.arraycopy(var1, var2 + 1, var1, var2, this.b);
            var1[--this.a.b] = null;
            this.c = -1;
            this.d = class_692.d(this.a);
        }
    }

    // $FF: synthetic method
    public Object next() {
        return this.a();
    }

    // $FF: synthetic method
    class_693(class_692 var1, class_444 var2) {
        this(var1);
    }
}
