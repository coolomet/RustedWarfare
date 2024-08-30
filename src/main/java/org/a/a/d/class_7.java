package org.a.a.d;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.a.a.a.class_6;
import org.a.a.c.class_19;
import org.a.a.e.class_20;

// $FF: renamed from: org.a.a.d.d
public interface class_7 extends class_6, class_2 {
    class_19 a();

    class_20 b();

    class_20 a(int var1);

    class_7 a(int var1, int var2);

    @Deprecated
    Short b(int var1);

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
