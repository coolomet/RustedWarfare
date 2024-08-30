package com.corrodinggames.rts.game.units.custom.c;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.utility.class_684;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.c.e
public strictfp class class_630 {
    class_634 a;
    class_684 b = new class_684();

    public class_630(class_634 var1) {
        this.a = var1;
    }

    public strictfp class_631 a(Unit var1) {
        int var2 = this.b.a;
        Object[] var3 = this.b.a();

        for(int var4 = 0; var4 < var2; ++var4) {
            class_631 var5 = (class_631)var3[var4];
            if (var5.a == var1) {
                return var5;
            }
        }

        return null;
    }
}
