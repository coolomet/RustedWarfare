package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.as.7
final class class_413 extends class_404 {
    class_413(int var1, String var2) {
        super(var1, var2);
    }

    public double a(class_398 var1) {
        return (double)var1.n;
    }

    public void a(class_398 var1, double var2) {
        var1.n = (int)var2;
    }

    public void a(class_113 var1, double var2) {
        int var4 = var1.s();
        super.a(var1, var2);
        if (var1.s() > var4 && !var1.ax) {
            var1.c(false);
        }

    }
}
