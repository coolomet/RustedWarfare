package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.as.14
final class class_417 extends class_404 {
    class_417(int var1, String var2) {
        super(var1, var2);
    }

    public double a(class_398 var1) {
        return (double)var1.c;
    }

    public void a(class_398 var1, double var2) {
        var1.c = (int)var2;
    }

    public void a(class_113 var1, double var2) {
        super.a(var1, var2);
        var1.totalHealth = (float)var2;
    }
}
