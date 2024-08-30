package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_62;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.am
public strictfp class class_72 extends class_62 {
    private final class_71 i;
    public ArrayList a = new ArrayList();
    public float b;
    public long c;
    public float d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;

    public class_72(class_71 var1, boolean var2) {
        this.i = var1;
        this.g = var2;
    }

    public void a() {
        Unit var1 = null;
        Iterator var2 = this.a.iterator();

        while(var2.hasNext()) {
            Unit var3 = (Unit)var2.next();
            if (!var3.bV && var3.cN == null) {
                boolean var4 = this.i.a.j(var3);
                if (var4 && var3.cf()) {
                    var1 = var3;
                }
            }
        }

        if (this.c > GameEngine.millis() - 700L && var1 != null) {
            this.i.b.b(var1.xCord, var1.yCord);
        }

        this.c = GameEngine.millis();
    }

    public void b() {
        this.a.clear();
    }

    public void c() {
        Iterator var1 = GameObject.er.iterator();

        while(var1.hasNext()) {
            GameObject var2 = (GameObject)var1.next();
            if (var2 instanceof OrderableUnit) {
                OrderableUnit var3 = (OrderableUnit)var2;
                if (var3.cG && !this.a.contains(var3)) {
                    this.a.add(var3);
                }
            }
        }

    }

    public void a(GameOutputStream var1) {
        this.d();
        var1.writeFloat(this.b);
        var1.writeLong(this.c);
        int var2 = this.a.size();
        var1.writeInt(var2);
        Iterator var3 = this.a.iterator();

        while(var3.hasNext()) {
            Unit var4 = (Unit)var3.next();
            var1.a(var4);
        }

        var1.writeByte(0);
    }

    public void a(GameInputStream var1) {
        this.b = var1.readFloat();
        this.c = var1.readLong();
        this.a.clear();
        int var2 = var1.readInt();

        for(int var3 = 0; var3 < var2; ++var3) {
            Unit var4 = var1.o();
            if (var4 != null) {
                this.a.add(var4);
            }
        }

        var1.readByte();
    }

    public void d() {
        if (this.a.size() != 0) {
            Iterator var1 = this.a.iterator();

            while(var1.hasNext()) {
                Unit var2 = (Unit)var1.next();
                if (var2.bV) {
                    var1.remove();
                }
            }

        }
    }

    public void e() {
        if (this.a.size() != 0) {
            ArrayList var1 = new ArrayList();
            Iterator var2 = this.a.iterator();

            while(var2.hasNext()) {
                Unit var3 = (Unit)var2.next();
                Unit var4 = GameObject.a(var3.id, true);
                if (var4 != null && !var4.bV) {
                    var1.add(var4);
                }
            }

            this.a = var1;
        }
    }
}
