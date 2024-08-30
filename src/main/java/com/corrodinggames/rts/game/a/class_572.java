package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_31;

// $FF: renamed from: com.corrodinggames.rts.game.a.a.1
class class_572 extends class_564 {
    // $FF: synthetic field
    final class_138 a;

    class_572(class_138 var1, String var2) {
        super(var1, var2);
        this.a = var1;
    }

    public boolean a(class_31 var1) {
        return class_138.a(this.a, var1) && this.a(var1, MovementType.LAND);
    }
}
