package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.OrderableUnit;
import java.util.HashMap;

// $FF: renamed from: com.corrodinggames.rts.game.a.c
public strictfp class class_655 {
    HashMap a = new HashMap();
    HashMap b = new HashMap();
    HashMap c = new HashMap();

    public Integer a(boolean var1, class_31 var2, boolean var3) {
        if (var1) {
            return (Integer)this.c.get(var2);
        } else {
            return !var3 ? (Integer)this.b.get(var2) : (Integer)this.a.get(var2);
        }
    }

    public void a(boolean var1, class_31 var2, boolean var3, Integer var4) {
        if (var1) {
            this.c.put(var2, var4);
        } else if (!var3) {
            this.b.put(var2, var4);
        } else {
            this.a.put(var2, var4);
        }

    }

    public void a() {
        this.a.clear();
        this.b.clear();
    }

    public void a(class_31 var1) {
        this.a.put(var1, (Object)null);
        this.b.put(var1, (Object)null);
    }

    public void a(OrderableUnit var1) {
        this.c.put(var1.dz, (Object)null);
    }

    public void b() {
        this.c.clear();
    }
}
