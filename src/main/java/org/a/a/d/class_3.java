package org.a.a.d;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.a.a.a.a;
import org.a.a.e.class_17;

// $FF: renamed from: org.a.a.d.a
public interface class_3 extends a, class_2 {
    org.a.a.c.a a();

    class_17 b();

    class_17 a(int var1);

    class_3 a(int var1, int var2);

    @Deprecated
    Float b(int var1);

    // $FF: synthetic method
    default Iterator iterator() {
        return this.a();
    }

    // $FF: synthetic method
    default List subList(int var1, int var2) {
        return this.a(var1, var2);
    }

    // $FF: synthetic method
    default ListIterator listIterator(int var1) {
        return this.a(var1);
    }

    // $FF: synthetic method
    default ListIterator listIterator() {
        return this.b();
    }

    // $FF: synthetic method
    @Deprecated
    default Object remove(int var1) {
        return this.b(var1);
    }
}
