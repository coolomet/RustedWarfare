package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.aw
public abstract strictfp class class_404 extends class_399 {
    public class_404(int var1, String var2) {
        super(var1, var2);
    }

    public double a(class_113 var1, class_398 var2) {
        return this.a(var2);
    }

    public void a(class_113 var1, double var2) {
        var1.dJ();
        this.a(var1.y, var2);
    }

    public abstract double a(class_398 var1);

    public abstract void a(class_398 var1, double var2);

    public boolean b() {
        return false;
    }
}
