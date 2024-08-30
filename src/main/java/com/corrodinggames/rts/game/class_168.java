package com.corrodinggames.rts.game;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_605;
import com.corrodinggames.rts.game.units.custom.d.class_447;

// $FF: renamed from: com.corrodinggames.rts.game.h
public strictfp class class_168 {
    public class_588 a;
    public class_588 b;
    public float c;
    public float d;
    public class_447 e;
    public class_447 f;
    public class_605 g;

    public boolean a(Unit var1) {
        if (this.b != null && class_585.a(this.b, var1.de())) {
            return false;
        } else {
            return this.a == null || class_585.a(this.a, var1.de());
        }
    }
}
