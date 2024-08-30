package com.corrodinggames.rts.java;

import org.newdawn.slick.Font;

// $FF: renamed from: com.corrodinggames.rts.java.f
class class_377 {
    int a;
    boolean b;
    boolean c;
    Font d;
    int e;
    String[] f;
    // $FF: synthetic field
    final class_368 g;

    class_377(class_368 var1) {
        this.g = var1;
        this.f = new String[30];
    }

    public class_377 a() {
        class_377 var1 = new class_377(this.g);
        var1.a = this.a;
        var1.b = this.b;
        var1.c = this.c;
        return var1;
    }

    public String toString() {
        return "FontKey:(size:" + this.a + ",  bold:" + this.b + " fallback:" + this.c + ")";
    }

    boolean a(String var1) {
        if (var1 == null) {
            return true;
        } else {
            boolean var2 = class_368.a(var1);
            if (!var2) {
                return true;
            } else {
                for(int var3 = 0; var3 < this.f.length; ++var3) {
                    String var4 = this.f[var3];
                    if (var4 != null && var4.equals(var1)) {
                        return true;
                    }
                }

                return false;
            }
        }
    }

    void b(String var1) {
        this.f[this.e] = var1;
        ++this.e;
        if (this.e >= this.f.length) {
            this.e = 0;
        }

    }

    // $FF: synthetic method
    public Object clone() {
        return this.a();
    }
}
