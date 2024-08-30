package com.corrodinggames.rts.game.units.f;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.utility.class_692;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.f.f
public strictfp class class_1019 implements Iterable, Iterator {
    int a;
    Unit[] b;

    public boolean hasNext() {
        return this.a > 0;
    }

    public Unit a() {
        --this.a;
        return this.b[this.a];
    }

    public void remove() {
        throw new RuntimeException("Not supported");
    }

    public Iterator iterator() {
        return this;
    }

    public void a(class_692 var1) {
        this.b = var1.a();
        this.a = var1.b;
    }

    // $FF: synthetic method
    public Object next() {
        return this.a();
    }
}
