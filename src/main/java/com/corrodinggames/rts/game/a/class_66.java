package com.corrodinggames.rts.game.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_32;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.a.n
public strictfp class class_66 extends class_65 {
    boolean a;
    int b;
    int c;
    class_69 d;
    float e = 100.0F;
    float f = 4000.0F;
    float g = 100.0F;
    float h;
    float i;
    float j;
    float k;
    int l;
    class_65 m;
    OrderableUnit n;
    float o = 0.0F;
    boolean p = false;
    boolean q;
    float r;
    float s;

    public void a(GameOutputStream var1) {
        var1.writeBoolean(this.a);
        var1.writeInt(this.b);
        var1.writeInt(this.c);
        int var2 = this.F.size();
        var1.writeInt(var2);
        Iterator var3 = this.F.iterator();

        while(var3.hasNext()) {
            OrderableUnit var4 = (OrderableUnit)var3.next();
            var1.a(var4);
        }

        var1.writeByte(5);
        var1.writeInt(this.R.a((class_63)this.m));
        var1.writeBoolean(this.q);
        var1.a(this.n);
        var1.writeFloat(this.o);
        var1.writeBoolean(this.p);
        var1.writeFloat(this.r);
        var1.writeFloat(this.s);
        super.a(var1);
    }

    public void a(GameInputStream var1) {
        this.a = var1.readBoolean();
        this.b = var1.readInt();
        this.c = var1.readInt();
        this.q();
        int var2 = var1.readInt();

        for(int var3 = 0; var3 < var2; ++var3) {
            OrderableUnit var4 = var1.p();
            if (var4 != null) {
                if (!this.R.g(var4)) {
                    GameEngine.print("TransporterGroup:readIn: Unit is not transporterUnit");
                } else {
                    this.a((OrderableUnit)var4);
                }
            }
        }

        byte var5 = var1.readByte();
        if (var5 >= 1) {
            this.m = (class_65)this.R.m(var1.readInt());
        }

        if (var5 >= 2) {
            this.q = var1.readBoolean();
        }

        if (var5 >= 3) {
            this.n = var1.p();
        }

        if (var5 >= 4) {
            this.o = var1.readFloat();
            this.p = var1.readBoolean();
        }

        if (var5 >= 5) {
            this.r = var1.readFloat();
            this.s = var1.readFloat();
        }

        super.a(var1);
    }

    public class_66(class_138 var1) {
        super(var1);
    }

    public void c() {
        Iterator var1 = Unit.bE.iterator();

        while(var1.hasNext()) {
            Unit var2 = (Unit)var1.next();
            if (!var2.bV && var2.bX == this.R && this.l > this.F.size() && var2 instanceof OrderableUnit) {
                OrderableUnit var3 = (OrderableUnit)var2;
                if (!var3.bN && var3.aB == null && this.R.g(var3) && this.R.i(var3)) {
                    this.a((OrderableUnit)var3);
                }
            }
        }

    }

    public boolean d() {
        return this.m != null;
    }

    public void c(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.h += var1;
        this.n();
        if (this.l <= this.F.size()) {
        }

        this.i = class_340.a(this.i, var1);
        this.j = class_340.a(this.j, var1);
        this.k = class_340.a(this.k, var1);
        if (!this.d() && !this.q && this.l > this.F.size() && this.i == 0.0F) {
            this.i = 300.0F;
            this.c();
        }

        Iterator var4;
        OrderableUnit var5;
        class_32 var6;
        if (!this.d() && this.F.size() != 0) {
            if (!this.d()) {
                this.f = class_340.a(this.f, var1);
                if (this.f == 0.0F) {
                    this.f = 4000.0F;
                    if (this.d != null) {
                        PointF var3 = this.d.w();
                        this.S = var3.x;
                        this.T = var3.y;
                    }
                }
            }

            if (this.j == 0.0F) {
                this.j = 400.0F;
                SyncPacket var10 = var2.cf.a((PlayerData)this.R);
                var4 = this.F.iterator();

                while(true) {
                    while(var4.hasNext()) {
                        var5 = (OrderableUnit)var4.next();
                        if (this.c(var5) > 28900.0F && !var5.aw()) {
                            var10.a(var5);
                        } else {
                            var6 = (class_32)var5;
                            if (var6.bB() != 0) {
                                class_1059 var7 = var5.cp();
                                SyncPacket var8 = var2.cf.a((PlayerData)this.R);
                                var8.a(var5);
                                var8.a(var7);
                            }
                        }
                    }

                    var10.a(this.S, this.T);
                    break;
                }
            }

            if (this.m == null) {
                this.g = class_340.a(this.g, var1);
                if (this.g == 0.0F) {
                    this.g = 100.0F;
                    if (class_340.rand(0, 100) < 80) {
                        this.a(var1, true);
                    }

                    if (this.m == null) {
                        this.a(var1, false);
                    }
                }
            }
        }

        if (this.m != null && this.m.V) {
            this.m = null;
        }

        SyncPacket var9;
        Iterator var17;
        OrderableUnit var21;
        if (!this.q) {
            if (this.m != null) {
                ArrayList var11 = this.m.G;
                if (this.n != null && (this.n.bV || this.n.cN != null || this.n.cO != null)) {
                    var11.remove(this.n);
                    this.n = null;
                }

                if (this.n == null) {
                    var4 = var11.iterator();

                    label204:
                    while(true) {
                        while(true) {
                            do {
                                if (!var4.hasNext()) {
                                    if (this.n == null) {
                                        this.q = true;
                                        this.j = 0.0F;
                                        this.k = 0.0F;
                                        this.r = this.m.S;
                                        this.s = this.m.T;
                                    }
                                    break label204;
                                }

                                var5 = (OrderableUnit)var4.next();
                            } while(var5.cN != null);

                            var17 = this.F.iterator();

                            while(var17.hasNext()) {
                                var21 = (OrderableUnit)var17.next();
                                if (var21.d(var5, false)) {
                                    this.n = var5;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (this.n != null) {
                    Iterator var15;
                    OrderableUnit var18;
                    if (this.j == 0.0F) {
                        this.j = 400.0F;
                        SyncPacket var13 = var2.cf.a((PlayerData)this.R);
                        var15 = this.F.iterator();

                        while(var15.hasNext()) {
                            var18 = (OrderableUnit)var15.next();
                            var13.a(var18);
                        }

                        var13.a(this.n.xCord, this.n.yCord);
                    }

                    if (this.k == 0.0F) {
                        this.k = 80.0F;
                        var4 = var11.iterator();

                        while(true) {
                            while(var4.hasNext()) {
                                var5 = (OrderableUnit)var4.next();
                                var17 = this.F.iterator();

                                while(var17.hasNext()) {
                                    var21 = (OrderableUnit)var17.next();
                                    if (var21.d(var5, false)) {
                                        float var26 = class_340.a(var21.xCord, var21.yCord, var5.xCord, var5.yCord);
                                        if (var26 < 14400.0F) {
                                            var9 = var2.cf.a((PlayerData)this.R);
                                            var9.a(var5);
                                            var9.e(var21);
                                            break;
                                        }
                                    }
                                }
                            }

                            boolean var14 = false;
                            var15 = this.F.iterator();

                            while(var15.hasNext()) {
                                var18 = (OrderableUnit)var15.next();
                                if (var18.d(this.n, false)) {
                                    var14 = true;
                                }
                            }

                            if (!var14) {
                                this.n = null;
                            }
                            break;
                        }
                    }
                }
            }
        } else if (this.m == null) {
            this.e();
        } else {
            if (this.j == 0.0F) {
                this.j = 400.0F;
                float var12 = this.m.S + class_340.c(-40.0F, 40.0F);
                float var16 = this.m.T + class_340.c(-40.0F, 40.0F);
                if (this.o > 600.0F) {
                    var12 += class_340.c(-300.0F, 300.0F);
                    var16 += class_340.c(-300.0F, 300.0F);
                }

                if (this.o > 1200.0F) {
                    var12 += class_340.c(-300.0F, 300.0F);
                    var16 += class_340.c(-300.0F, 300.0F);
                }

                if (class_694.a(var12, var16, MovementType.LAND)) {
                    var12 += class_340.c(-100.0F, 100.0F);
                    var16 += class_340.c(-100.0F, 100.0F);
                }

                if (class_694.a(var12, var16, MovementType.LAND)) {
                    var12 += class_340.c(-200.0F, 200.0F);
                    var16 += class_340.c(-200.0F, 200.0F);
                }

                if (class_694.a(var12, var16, MovementType.LAND)) {
                    var12 += class_340.c(-200.0F, 200.0F);
                    var16 += class_340.c(-200.0F, 200.0F);
                }

                if (class_694.a(var12, var16, MovementType.LAND)) {
                    this.j = 30.0F;
                } else {
                    this.r = var12;
                    this.s = var16;
                    SyncPacket var19 = var2.cf.a((PlayerData)this.R);
                    var17 = this.F.iterator();

                    while(var17.hasNext()) {
                        var21 = (OrderableUnit)var17.next();
                        class_32 var27 = (class_32)var21;
                        if (var27.bB() != 0) {
                            float var28 = class_340.a(var21.xCord, var21.yCord, this.r, this.s);
                            if (var28 > 1600.0F) {
                                var19.a(var21);
                            }
                        } else {
                            var9 = var2.cf.a((PlayerData)this.R);
                            var9.a(var21);
                            var9.a(this.S, this.T);
                        }
                    }

                    var19.a(this.r, this.s);
                }
            }

            if (this.k == 0.0F) {
                this.k = 100.0F;
                Iterator var22 = this.F.iterator();

                while(var22.hasNext()) {
                    OrderableUnit var29 = (OrderableUnit)var22.next();
                    float var20 = class_340.a(var29.xCord, var29.yCord, this.r, this.s);
                    if (var20 < 6400.0F) {
                        this.p = true;
                        class_1059 var24 = var29.cp();
                        SyncPacket var25 = var2.cf.a((PlayerData)this.R);
                        var25.a(var29);
                        var25.a(var24);
                    }
                }
            }

            if (this.p) {
                this.m.o();
                this.o += var1;
            }

            boolean var23 = false;
            var4 = this.F.iterator();

            while(var4.hasNext()) {
                var5 = (OrderableUnit)var4.next();
                if (!var5.bV) {
                    var6 = (class_32)var5;
                    if (var6.bB() != 0) {
                        var23 = true;
                    }
                }
            }

            if (!var23 || this.o > 1700.0F) {
                this.e();
            }
        }

        if (this.h > 1500.0F && this.F.size() == 0) {
            this.p();
        }

    }

    public void e() {
        this.q = false;
        this.m = null;
        this.o = 0.0F;
        this.j = 0.0F;
        this.k = 0.0F;
        this.p = false;
        this.f();
    }

    public void a(float var1, boolean var2) {
        Iterator var3 = this.R.bn.iterator();

        class_65 var5;
        do {
            class_63 var4;
            do {
                do {
                    do {
                        if (!var3.hasNext()) {
                            return;
                        }

                        var4 = (class_63)var3.next();
                    } while(!(var4 instanceof class_65));
                } while(var4 instanceof class_66);
            } while(var2 && !(var4 instanceof class_67));

            var5 = (class_65)var4;
        } while(var5.G.size() == 0 || var5.m());

        this.m = var5;
        this.n = null;
    }

    public class_69 a(boolean var1) {
        class_69 var2 = null;
        Iterator var3 = this.R.bn.iterator();

        while(true) {
            class_69 var5;
            do {
                class_63 var4;
                do {
                    if (!var3.hasNext()) {
                        return var2;
                    }

                    var4 = (class_63)var3.next();
                } while(!(var4 instanceof class_69));

                var5 = (class_69)var4;
            } while(var5.s && var1);

            if (var5.b == class_658.ACTIVE) {
                var2 = var5;
                if (class_340.c(3) == 0) {
                    return var5;
                }
            }
        }
    }

    public void f() {
        boolean var1 = true;
        PointF var2 = null;
        if (var1) {
            this.d = this.a(true);
            if (this.d == null) {
                this.d = this.a(false);
            }

            if (this.d != null) {
                var2 = this.d.w();
            }
        }

        if (var2 == null) {
            var2 = this.R.am();
            this.d = null;
        }

        this.S = var2.x;
        this.T = var2.y;
    }
}
