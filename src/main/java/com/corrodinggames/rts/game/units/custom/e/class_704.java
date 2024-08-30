package com.corrodinggames.rts.game.units.custom.e;

import java.util.Comparator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e.f.1
class class_704 implements Comparator {
    // $FF: synthetic field
    final class_1069 a;

    class_704(class_1069 var1) {
        this.a = var1;
    }

    public strictfp int a(class_1067 var1, class_1067 var2) {
        return var1.a != null && var2.a != null ? Float.compare(var1.a.x, var2.a.x) : 0;
    }

    // $FF: synthetic method
    public int compare(Object var1, Object var2) {
        return this.a((class_1067)var1, (class_1067)var2);
    }
}
