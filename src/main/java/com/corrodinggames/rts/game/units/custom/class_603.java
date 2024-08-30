package com.corrodinggames.rts.game.units.custom;

import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.x
public strictfp class class_603 extends class_602 {
    String g;
    class_164 h;

    public strictfp void a() {
    }

    @SneakyThrows
    public strictfp void b() {
        super.a();
        class_591 var1 = this.e();
        this.h = var1.f(this.g);
        if (this.h == null) {
            throw new CustomException("Could not find projectile:" + this.g + " on unit target:" + this.d() + " used on:" + this.a + " in section:" + this.b);
        }
    }

    public strictfp class_164 f() {
        return this.h;
    }
}
