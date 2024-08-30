package com.corrodinggames.rts.game.units.f;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;

// $FF: renamed from: com.corrodinggames.rts.game.units.f.a
public strictfp class class_1021 {
    public final class_1020 a = new class_1020();
    public final class_1020[] b;
    public final class_1020 c;
    public final class_1020 d;
    float e;

    public class_1021() {
        this.b = new class_1020[PlayerData.e];
        this.c = new class_1020();
        this.d = new class_1020();

        for(int var1 = 0; var1 < this.b.length; ++var1) {
            this.b[var1] = new class_1020();
        }

    }

    public void a(Unit var1) {
        this.a.a(var1);
        int var2 = var1.dn;
        if (var2 >= 0) {
            this.b[var2].a(var1);
        } else if (var2 == -1) {
            this.d.a(var1);
        } else if (var2 == -2) {
            this.c.a(var1);
        }

        if (var1.cj > this.e) {
            this.e = var1.cj;
        }

    }

    public void b(Unit var1) {
        this.a.b(var1);
        int var2 = var1.dn;
        if (var2 >= 0) {
            this.b[var2].b(var1);
        } else if (var2 == -1) {
            this.d.b(var1);
        } else if (var2 == -2) {
            this.c.b(var1);
        }

        if (this.a.b == 0) {
            this.e = 0.0F;
        }

    }
}
