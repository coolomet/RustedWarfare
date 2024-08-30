package com.corrodinggames.rts.game.units.f;

import com.corrodinggames.rts.game.units.Unit;

// $FF: renamed from: com.corrodinggames.rts.game.units.f.b
public final strictfp class class_1020 {
    public static final Unit[] a = new Unit[0];
    public int b;
    transient Unit[] c;

    public class_1020() {
        this.c = a;
    }

    public boolean a(Unit var1) {
        Unit[] var2 = this.c;
        int var3 = this.b;
        if (var3 == var2.length) {
            Unit[] var4 = new Unit[var3 + (var3 < 6 ? 12 : var3 >> 1)];
            System.arraycopy(var2, 0, var4, 0, var3);
            var2 = var4;
            this.c = var4;
        }

        var2[var3] = var1;
        this.b = var3 + 1;
        return true;
    }

    public boolean b(Unit var1) {
        Unit[] var2 = this.c;
        int var3 = this.b;
        int var10001;
        int var4;
        if (var1 != null) {
            for(var4 = 0; var4 < var3; ++var4) {
                if (var1.equals(var2[var4])) {
                    var10001 = var4 + 1;
                    --var3;
                    System.arraycopy(var2, var10001, var2, var4, var3 - var4);
                    var2[var3] = null;
                    this.b = var3;
                    return true;
                }
            }
        } else {
            for(var4 = 0; var4 < var3; ++var4) {
                if (var2[var4] == null) {
                    var10001 = var4 + 1;
                    --var3;
                    System.arraycopy(var2, var10001, var2, var4, var3 - var4);
                    var2[var3] = null;
                    this.b = var3;
                    return true;
                }
            }
        }

        return false;
    }

    public final Unit[] a() {
        return this.c;
    }
}
