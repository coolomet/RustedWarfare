package com.corrodinggames.rts.game.units.g;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.g.d
public strictfp class class_793 extends class_792 {
    float b;

    public StatusEffectType b() {
        return StatusEffectType.MOVEMENT_SPEED;
    }

    public void a(OrderableUnit var1, GameOutputStream var2) {
        var2.writeFloat(this.b);
        super.a(var1, var2);
    }

    public void a(OrderableUnit var1, GameInputStream var2) {
        this.b = var2.readFloat();
        super.a(var1, var2);
    }
}
