package com.corrodinggames.rts.gameFramework.utility;

import java.util.Comparator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.a.1
final class class_1070 implements Comparator {
    // $FF: synthetic field
    final Thread a;

    class_1070(Thread var1) {
        this.a = var1;
    }

    public int a(Thread var1, Thread var2) {
        if (var1 == var2) {
            return 0;
        } else if (var1 == this.a) {
            return 1;
        } else {
            return var2 == this.a ? -1 : var2.getName().compareTo(var1.getName());
        }
    }

    // $FF: synthetic method
    public int compare(Object var1, Object var2) {
        return this.a((Thread)var1, (Thread)var2);
    }
}
