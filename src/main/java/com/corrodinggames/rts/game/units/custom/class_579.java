package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a
class class_579 implements Comparable {
    public float a;
    public float b;
    public float c;
    public float d;

    public class_579(float var1, float var2) {
        this.a = var1;
        this.b = var2;
    }

    public int a(class_579 var1) {
        if (this.a == var1.a) {
            return 0;
        } else {
            return this.a > var1.a ? 1 : -1;
        }
    }

    // $FF: synthetic method
    public int compareTo(Object var1) {
        return this.a((class_579)var1);
    }
}
