package com.corrodinggames.rts.game.units.buildings;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.gameFramework.class_62;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.j
public strictfp class class_73 extends class_62 {
    public int a;
    public float b;
    public class_447 c;
    public class_447 d;
    public class_588 e;
    public boolean f;
    public class_31 g;
    public PointF h;
    public Unit i;
    public class_1059 j;
    public boolean k;
    public boolean l;
    public float m;
    public double n;

    public class_73() {
        this.c = class_447.a;
        this.d = null;
        this.j = class_226.i;
        this.m = -1.0F;
        this.n = 0.0;
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeInt(-1);
        var1.writeInt(this.a);
        var1.writeFloat(this.b);
        var1.writeInt(-1);
        var1.writeInt(this.c.a());
        var1.writeBoolean(this.f);
        var1.writeString(this.j.a());
        var1.writeString(this.j.a());
        var1.b(this.i);
        var1.writeIsPointF(this.h);
        var1.writeBoolean(this.l);
        var1.writeFloat(this.m);
        var1.a(this.g);
        this.c.a(var1);
        class_447.a(var1, this.d);
        class_585.a(this.e, var1);
    }

    public strictfp void a(GameInputStream var1) {
        String.valueOf(var1.readInt());
        this.a = var1.readInt();
        this.b = var1.readFloat();
        int var2 = 0;
        if (var1.b() >= 4) {
            this.j = class_1059.a(String.valueOf(var1.readInt()));
        }

        if (var1.b() >= 6) {
            var2 = var1.readInt();
        }

        if (var1.b() >= 25) {
            this.f = var1.readBoolean();
        }

        if (var1.b() >= 33) {
            var1.readString();
            this.j = class_1059.a(var1.readString());
        }

        if (var1.b() >= 61) {
            this.i = var1.o();
            this.h = var1.getPointF();
        }

        if (var1.b() >= 64) {
            this.l = var1.readBoolean();
            this.m = var1.readFloat();
        }

        if (var1.b() >= 71) {
            this.g = var1.q();
        }

        if (var1.b() >= 73) {
            this.c = class_447.b(var1);
        } else {
            this.c = class_447.a(var2);
        }

        if (var1.b() >= 91) {
            this.d = class_447.a(var1);
        }

        if (var1.b() >= 95) {
            this.e = class_585.a(var1);
        }

    }
}
