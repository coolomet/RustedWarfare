package com.corrodinggames.rts.java.audio.a;

import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.corrodinggames.rts.java.audio.a.p
public strictfp class class_51 extends class_50 {
    class_52 a = new class_52();

    public class_51(class_53 var1) {
        super(var1);
    }

    public class_52 a() {
        if (!this.b) {
            throw new NoSuchElementException();
        } else if (!this.f) {
            throw new class_34("#iterator() cannot be used nested.");
        } else {
            Object[] var1 = this.c.b;
            this.a.a = var1[this.d];
            this.a.b = this.c.c[this.d];
            this.e = this.d;
            this.d();
            return this.a;
        }
    }

    public boolean hasNext() {
        if (!this.f) {
            throw new class_34("#iterator() cannot be used nested.");
        } else {
            return this.b;
        }
    }

    public class_51 b() {
        return this;
    }

    // $FF: synthetic method
    public Iterator iterator() {
        return this.b();
    }

    // $FF: synthetic method
    public Object next() {
        return this.a();
    }
}
