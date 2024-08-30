package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.as.15
final class class_402 extends class_400 {
    class_402(int var1, String var2) {
        super(var1, var2);
    }

    public double a(class_113 var1) {
        return (double)var1.health;
    }

    public void b(class_113 var1, double var2) {
        var1.health = (float)var2;
    }

    public void a(class_113 var1, double var2) {
        super.a(var1, var2);
        var1.o((float)var2);
    }
}
