package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.class_31;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.w
public strictfp class class_602 extends class_601 {
    @SneakyThrows
    public strictfp void a() {
        if (!this.e) {
            this.d = class_591.n(this.c);
            if (this.d == null) {
                throw new CustomException("Could not find customUnit target:" + this.d() + " used on:" + this.a + " in section:" + this.b);
            }
        }

    }

    public strictfp class_591 e() {
        return (class_591)this.d;
    }

    // $FF: synthetic method
    public class_31 c() {
        return this.e();
    }
}
