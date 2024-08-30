package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.af
public strictfp class class_1045 {
    public float a;
    public float b;

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.a);
        var1.writeFloat(this.b);
    }

    public strictfp void a(GameInputStream var1) {
        this.a = var1.readFloat();
        this.b = var1.readFloat();
    }
}
