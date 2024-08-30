package com.corrodinggames.rts.gameFramework.utility;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.ac
public final strictfp class class_672 {
    String a;
    String b;

    public class_672(String var1, String var2) {
        this.a = var1;
        this.b = var2;
    }

    public String toString() {
        return "[" + this.a + "]" + this.b;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof class_672)) {
            return false;
        } else {
            class_672 var2 = (class_672)var1;
            return this.b.equals(var2.b) && this.a.equals(var2.a);
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
