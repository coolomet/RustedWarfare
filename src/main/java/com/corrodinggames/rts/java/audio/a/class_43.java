package com.corrodinggames.rts.java.audio.a;

import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.corrodinggames.rts.java.audio.a.f
public strictfp class class_43 extends class_42 implements Iterable, Iterator {
    private class_44 f = new class_44();

    public class_43(class_47 var1) {
        super(var1);
    }

    public class_44 a() {
        if (!this.a) {
            throw new NoSuchElementException();
        } else if (!this.e) {
            throw new class_34("#iterator() cannot be used nested.");
        } else {
            int[] var1 = this.b.b;
            if (this.c == -1) {
                this.f.a = 0;
                this.f.b = this.b.f;
            } else {
                this.f.a = var1[this.c];
                this.f.b = this.b.c[this.c];
            }

            this.d = this.c;
            this.c();
            return this.f;
        }
    }

    public boolean hasNext() {
        if (!this.e) {
            throw new class_34("#iterator() cannot be used nested.");
        } else {
            return this.a;
        }
    }

    public Iterator iterator() {
        return this;
    }

    public void remove() {
        super.remove();
    }

    // $FF: synthetic method
    public Object next() {
        return this.a();
    }
}
