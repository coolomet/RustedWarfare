package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.game.units.custom.class_591;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.a.a.5
class class_570 extends class_564 {
    // $FF: synthetic field
    final class_138 a;

    class_570(class_138 var1, String var2) {
        super(var1, var2);
        this.a = var1;
    }

    public boolean a(class_31 var1) {
        Unit var2 = Unit.b(var1);
        if (var2.bI()) {
            if (var1 instanceof class_591) {
                class_591 var3 = (class_591)var1;
                if (var3.fw) {
                    return false;
                }
            }

            boolean var8 = false;
            Iterator var4 = var2.N().iterator();

            while(var4.hasNext()) {
                class_226 var5 = (class_226)var4.next();
                if (var5 != null && var5 instanceof class_281) {
                    class_281 var6 = (class_281)var5;
                    if (!var6.F()) {
                        class_31 var7 = var6.i();
                        if (var7 != null && !var7.j() && var7.m()) {
                            var8 = true;
                        }
                    }
                }
            }

            if (var8) {
                return true;
            }
        }

        return false;
    }
}
