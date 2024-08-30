package com.corrodinggames.rts.game.a.a;

import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_692;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.a.a.c
public abstract strictfp class class_1003 extends class_1002 {
    class_692 a = new class_692();

    public void a(GameInputStream var1) {
        super.a(var1);
        int var2 = var1.readInt();

        for(int var3 = 0; var3 < var2; ++var3) {
            OrderableUnit var4 = var1.p();
            if (var4 != null) {
                this.a.a((Unit)var4);
            }
        }

    }

    public void a(GameOutputStream var1) {
        super.a(var1);
        int var2 = this.a.size();
        var1.writeInt(var2);
        Iterator var3 = this.a.iterator();

        while(var3.hasNext()) {
            OrderableUnit var4 = (OrderableUnit)var3.next();
            var1.a(var4);
        }

    }

    public abstract boolean c(class_138 var1, OrderableUnit var2);

    public void a(class_138 var1, OrderableUnit var2) {
        if (this.c(var1, var2) && !this.a.contains(var2)) {
            this.a.a((Unit)var2);
        }

    }

    public void b(class_138 var1, OrderableUnit var2) {
    }
}
