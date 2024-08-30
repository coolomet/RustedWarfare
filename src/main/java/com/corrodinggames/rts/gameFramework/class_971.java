package com.corrodinggames.rts.gameFramework;

import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.bi
public strictfp class class_971 extends ArrayList {
    public strictfp int a(int var1) {
        if (this.isEmpty()) {
            return 0;
        } else {
            int var2 = ((class_970)this.get(0)).b;

            class_970 var4;
            for(Iterator var3 = this.iterator(); var3.hasNext(); var2 = var4.b) {
                var4 = (class_970)var3.next();
                if (var4.a > var1) {
                    return var2;
                }
            }

            return var2;
        }
    }
}
