package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.as.13
final class class_403 extends class_400 {
    class_403(int var1, String var2) {
        super(var1, var2);
    }

    public double a(class_113 var1) {
        return (double)var1.cB;
    }

    public void b(class_113 var1, double var2) {
        var1.cB = (float)var2;
    }

    public void a(class_113 var1, double var2) {
        super.a(var1, var2);
        var1.cB = (float)var2;
    }
}
