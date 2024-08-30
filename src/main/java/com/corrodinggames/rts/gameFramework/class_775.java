package com.corrodinggames.rts.gameFramework;

import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.bm
public strictfp class class_775 extends TeamStats {
    public class_775(ArrayList var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            TeamStats var3 = (TeamStats)var2.next();
            this.a += var3.a;
            this.b += var3.b;
            this.unitsKilled += var3.unitsKilled;
            this.buildingsKilled += var3.buildingsKilled;
            this.experimentalsKilled += var3.experimentalsKilled;
            this.unitsLost += var3.unitsLost;
            this.buildingsLost += var3.buildingsLost;
            this.experimentalsLost += var3.experimentalsLost;
            this.i += var3.i;
            this.j = Math.max(this.j, var3.j);
            this.k += var3.k;
            this.l.a(var3.l);
        }

    }
}
