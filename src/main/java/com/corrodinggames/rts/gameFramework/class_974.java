package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.bl
public strictfp class class_974 {
    class_684 a = new class_684();

    public strictfp void a(Unit var1, Unit var2) {
        if (this.a.a > 0) {
            Iterator var3 = this.a.iterator();

            while(var3.hasNext()) {
                class_973 var4 = (class_973)var3.next();
                var4.a(var1, var2, (Object)null);
            }
        }

    }
}
