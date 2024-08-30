package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.gameFramework.GameEngine;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.v
public strictfp class class_601 {
    String a;
    String b;
    String c;
    class_31 d;
    boolean e;
    public boolean f;

    @SneakyThrows
    public strictfp void a() {
        if (!this.e) {
            this.d = class_591.s(this.c);
            if (this.d == null) {
                GameEngine.log("AllUnitTypes: " + class_591.E());
                if (this.f) {
                    throw new CustomException("Could not find unit type:" + this.c + " used on:" + this.a + " in section:" + this.b + " (Note: Prefix with 'unitref' if not using a unit type here)");
                }

                throw new CustomException("Could not find unit type:" + this.c + " used on:" + this.a + " in section:" + this.b);
            }
        }

    }

    public strictfp void b() {
    }

    public strictfp class_31 c() {
        return this.d;
    }

    public strictfp String d() {
        if (this.e) {
            return this.d != null ? this.d.i() : "(Error: known type is null)";
        } else {
            return this.c;
        }
    }
}
