package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.gameFramework.k.PathEngine;
import com.corrodinggames.rts.gameFramework.k.class_224;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.d
public strictfp class class_353 {
    public class_224 a;
    public long b;
    public float c;
    public float d;
    public float e;
    public float f;
    public int g;
    public MovementType h;

    public strictfp void a(GameOutputStream var1) {
        var1.writeLong(this.b);
        var1.writeFloat(this.c);
        var1.writeFloat(this.d);
        var1.writeFloat(this.e);
        var1.writeFloat(this.f);
        var1.writeInt(this.g);
        var1.writeEnum(this.h);
        var1.writeBoolean(this.a != null);
        if (this.a != null) {
            this.a.a(var1);
        }

    }

    public strictfp void a(GameInputStream var1) {
        this.b = var1.readLong();
        this.c = var1.readFloat();
        this.d = var1.readFloat();
        this.e = var1.readFloat();
        this.f = var1.readFloat();
        this.g = var1.readInt();
        this.h = (MovementType)var1.readEnum(MovementType.class);
        boolean var2 = var1.readBoolean();
        if (var2) {
            boolean var3 = false;
            this.a = new class_224((PathEngine)null, var3);
            this.a.a(var1);
        }

    }
}
