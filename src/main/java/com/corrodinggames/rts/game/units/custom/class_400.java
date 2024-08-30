package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.ax
public abstract strictfp class class_400 extends class_399 {
    public class_400(int var1, String var2) {
        super(var1, var2);
    }

    public double a(class_113 var1, class_398 var2) {
        return this.a(var1);
    }

    public void a(class_113 var1, double var2) {
        var1.dJ();
        this.b(var1, var2);
    }

    public abstract double a(class_113 var1);

    public abstract void b(class_113 var1, double var2);

    public boolean b() {
        return true;
    }
}
