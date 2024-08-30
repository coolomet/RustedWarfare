package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.a.l
public strictfp class class_67 extends class_65 {
    float a = 0.0F;

    public void a(GameOutputStream var1) {
        int var2 = this.F.size();
        var1.writeInt(var2);
        Iterator var3 = this.F.iterator();

        OrderableUnit var4;
        while(var3.hasNext()) {
            var4 = (OrderableUnit)var3.next();
            var1.a(var4);
        }

        var1.writeByte(1);
        var1.writeInt(this.G.size());
        var3 = this.G.iterator();

        while(var3.hasNext()) {
            var4 = (OrderableUnit)var3.next();
            var1.a(var4);
        }

        var1.writeFloat(this.a);
        super.a(var1);
    }

    public void a(GameInputStream var1) {
        this.q();
        int var2 = var1.readInt();

        for(int var3 = 0; var3 < var2; ++var3) {
            OrderableUnit var4 = var1.p();
            if (var4 != null) {
                this.a((OrderableUnit)var4);
            }
        }

        byte var7 = var1.readByte();
        if (var7 >= 1) {
            this.G.clear();
            int var8 = var1.readInt();

            for(int var5 = 0; var5 < var8; ++var5) {
                OrderableUnit var6 = var1.p();
                if (var6 != null) {
                    this.G.add(var6);
                }
            }

            this.a = var1.readFloat();
        }

        super.a(var1);
    }

    public class_67(class_138 var1) {
        super(var1);
    }

    public void c(float var1) {
        this.n();
        if (!this.m()) {
            this.a += var1;
        }

        Iterator var2 = this.F.iterator();

        while(var2.hasNext()) {
            OrderableUnit var3 = (OrderableUnit)var2.next();
            if (this.c((Unit)var3) < 3600.0F && var3.cN == null) {
                if (var3.aB == this) {
                    var3.aB = null;
                }

                var2.remove();
            }
        }

        if (this.F.size() == 0 || this.a > 5000.0F) {
            this.p();
        }

    }

    public void c(OrderableUnit var1) {
        this.a((OrderableUnit)var1);
        this.G.add(var1);
    }
}
