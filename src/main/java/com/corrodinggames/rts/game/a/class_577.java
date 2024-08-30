package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_591;

// $FF: renamed from: com.corrodinggames.rts.game.a.a.10
class class_577 extends class_564 {
    // $FF: synthetic field
    final class_138 a;

    class_577(class_138 var1, String var2) {
        super(var1, var2);
        this.a = var1;
    }

    public boolean a(class_31 var1) {
        Unit var2 = Unit.b(var1);
        if (this.a.g(var2)) {
            if (var1 instanceof class_591) {
                class_591 var3 = (class_591)var1;
                if (var3.fw) {
                    return false;
                }
            }

            if (var1.o() == MovementType.AIR || var1.o() == MovementType.HOVER || var1.o() == MovementType.OVER_CLIFF_WATER) {
                return true;
            }
        }

        return false;
    }
}
