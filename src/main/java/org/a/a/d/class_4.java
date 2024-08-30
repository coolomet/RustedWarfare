package org.a.a.d;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.a.a.a.b;
import org.a.a.e.class_18;

// $FF: renamed from: org.a.a.d.b
public interface class_4 extends b, class_2 {
    org.a.a.c.b a();

    class_18 b();

    class_18 a(int var1);

    class_4 a(int var1, int var2);

    @Deprecated
    Integer b(int var1);

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
