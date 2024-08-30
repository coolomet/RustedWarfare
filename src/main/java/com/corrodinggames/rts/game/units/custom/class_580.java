package com.corrodinggames.rts.game.units.custom;

import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.b
class class_580 extends class_579 {
    public class_605 e;
    public float f;
    public float g;
    public boolean h;

    public class_580(float var1, float var2) {
        super(var1, var2);
    }

    @SneakyThrows
    public void a(class_591 var1, String var2, String var3) {
        try {
            if (var2.equalsIgnoreCase("x")) {
                this.f = Float.parseFloat(var3);
                return;
            }

            if (var2.equalsIgnoreCase("y")) {
                this.g = Float.parseFloat(var3);
                return;
            }
        } catch (NumberFormatException var5) {
            throw new CustomException("Failed to parse float:" + var3);
        }

        if (var2.equalsIgnoreCase("name")) {
            this.e = var1.a((String)var3, (class_605)null);
        } else {
            throw new CustomException("Unknown event key:" + var2 + " on animation");
        }
    }

    @SneakyThrows
    public void finalize() {
        this.h = true;
        if (this.e == null) {
            throw new CustomException("Animation effect missing key 'name'");
        }
    }

    public void a(class_113 var1) {
        if (this.e != null) {
            float var2 = var1.xCord;
            float var3 = var1.yCord;
            var2 += this.f;
            var3 += this.g;
            this.e.a(var2, var3, var1.zCord, var1.cg, var1);
        }

    }
}
