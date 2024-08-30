package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.u
public strictfp class FogRevealer extends class_83 {
    public int a = 14;
    public float b = 60.0F;

    public strictfp void a(GameOutputStream var1) {
        var1.writeByte(0);
        var1.writeInt(this.a);
        var1.writeFloat(this.b);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        var1.readByte();
        this.a = var1.readInt();
        this.b = var1.readFloat();
        super.a(var1);
    }

    public strictfp UnitType b() {
        return UnitType.fogRevealer;
    }

    public static strictfp void f() {
        GameEngine var0 = GameEngine.getGameEngine();
    }

    public FogRevealer(boolean var1) {
        super(var1);
    }

    public strictfp void a(float var1) {
        super.a(var1);
        this.b -= var1;
        if (this.b < 0.0F) {
            this.ci();
        }

    }

    public strictfp int s() {
        return this.a;
    }

    public strictfp boolean t() {
        return true;
    }

    public strictfp boolean u() {
        return true;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
