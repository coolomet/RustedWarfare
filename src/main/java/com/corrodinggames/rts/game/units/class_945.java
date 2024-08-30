package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.custom.d.class_447;
import java.util.Comparator;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar.49
final class class_945 implements Comparator {
    public int a(class_31 var1, class_31 var2) {
        class_447 var3 = var1.u();
        class_447 var4 = var2.u();
        int var5 = var3.a(var4);
        return var5;
    }

    // $FF: synthetic method
    public int compare(Object var1, Object var2) {
        return this.a((class_31)var1, (class_31)var2);
    }
}
