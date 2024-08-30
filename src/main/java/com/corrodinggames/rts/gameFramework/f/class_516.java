package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.at
class class_516 extends class_515 {
    public class_516(float var1, float var2, class_31 var3) {
        super(var1, var2, var3);
    }

    public strictfp String type() {
        if (this.g == null) {
            this.g = String.format(class_1009.a("gui.log.upgradeCompleted"), this.a.e(), this.b);
        }

        return this.g;
    }
}
