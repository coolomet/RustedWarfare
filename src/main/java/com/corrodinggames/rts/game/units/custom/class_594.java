package com.corrodinggames.rts.game.units.custom;

import java.util.Comparator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.q
class class_594 implements Comparator {
    public class_594() {
    }

    public strictfp int a(class_591 var1, class_591 var2) {
        return var1.M != null && var2.M != null ? var1.M.compareTo(var2.M) : 0;
    }

    // $FF: synthetic method
    public int compare(Object var1, Object var2) {
        return this.a((class_591)var1, (class_591)var2);
    }
}
