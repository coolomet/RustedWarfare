package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.gameFramework.utility.class_684;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.i
public strictfp class class_587 {
    public class_684 a = new class_684();

    public class_587() {
    }

    public class_587(class_588 var1) {
        if (var1 != null) {
            class_585[] var2 = var1.a;
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                class_585 var5 = var2[var4];
                this.a.add(var5);
            }

        }
    }

    public boolean a(class_588 var1) {
        if (var1 == null) {
            return false;
        } else {
            boolean var2 = false;
            class_585[] var3 = var1.a;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                class_585 var6 = var3[var5];
                if (this.a(var6)) {
                    var2 = true;
                }
            }

            return var2;
        }
    }

    public boolean a(class_585 var1) {
        if (!this.a.contains(var1)) {
            this.a.add(var1);
            return true;
        } else {
            return false;
        }
    }

    public boolean b(class_588 var1) {
        if (var1 == null) {
            return false;
        } else {
            boolean var2 = false;
            class_585[] var3 = var1.a;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                class_585 var6 = var3[var5];
                if (this.a.remove(var6)) {
                    var2 = true;
                }
            }

            return var2;
        }
    }

    public class_588 a() {
        return this.a.size() == 0 ? class_585.d : new class_588((class_585[])this.a.toArray(class_585.c));
    }
}
