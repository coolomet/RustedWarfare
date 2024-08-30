package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bc
public strictfp class class_389 {
    public String a;
    public String b;

    public class_389() {
    }

    public class_389(String var1, String var2) {
        this.a = var1;
        this.b = var2;
    }

    public void a(String var1, String var2) {
        if (this.b != null) {
            this.b = this.b.replaceAll(var1, var2);
        }

    }
}
