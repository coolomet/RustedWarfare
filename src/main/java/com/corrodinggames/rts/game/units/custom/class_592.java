package com.corrodinggames.rts.game.units.custom;

import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.o
public strictfp class class_592 {
    String a;
    class_586 b;
    // $FF: synthetic field
    final class_591 c;

    public class_592(class_591 var1) {
        this.c = var1;
    }

    public strictfp void a() {
        if (this.a != null && this.b() == null) {
            throw new RuntimeException("Failed to find animation:" + this.a);
        }
    }

    public strictfp class_586 b() {
        if (this.a == null) {
            return null;
        } else if (this.b != null) {
            return this.b;
        } else {
            Iterator var1 = this.c.dr.iterator();

            class_586 var2;
            do {
                if (!var1.hasNext()) {
                    return null;
                }

                var2 = (class_586)var1.next();
            } while(!var2.a.equalsIgnoreCase(this.a));

            this.b = var2;
            return var2;
        }
    }
}
