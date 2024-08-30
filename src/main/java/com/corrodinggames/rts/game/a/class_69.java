package com.corrodinggames.rts.game.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.class_482;
import com.corrodinggames.rts.game.units.WaypointType;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.buildings.class_8;
import com.corrodinggames.rts.game.units.buildings.class_88;
import com.corrodinggames.rts.game.units.buildings.CommandCenter;
import com.corrodinggames.rts.game.units.f.class_1019;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_692;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.a.i
public strictfp class class_69 extends class_63 {
    float a;
    class_658 b;
    class_657 c;
    float d = -1.0F;
    float e;
    float f;
    float g = 100.0F;
    int h;
    float i = 50.0F;
    float j = 50.0F;
    float k;
    float l;
    float m;
    boolean n;
    boolean o;
    class_684 p = new class_684();
    class_692 q = new class_692();
    class_692 r = new class_692();
    boolean s;
    boolean t;
    float u;
    float v = 0.0F;
    PointF w = new PointF();
    PointF x = new PointF();
    int y;
    class_31 z;
    class_447 A;
    class_447 B;
    int C;
    int D;
    String E;
    int F;
    int G;
    boolean H = false;
    int I;
    int J;
    int K;
    int L;
    boolean M;
    ArrayList N = new ArrayList();
    class_31 O;
    class_447 P;

    public void a(GameOutputStream var1) {
        var1.writeEnum(this.b);
        var1.writeEnum(this.c);
        var1.writeFloat(this.d);
        var1.writeFloat(this.e);
        var1.writeFloat(this.f);
        var1.writeFloat(this.g);
        var1.writeFloat(this.i);
        var1.writeFloat(this.j);
        var1.writeFloat(this.k);
        var1.writeFloat(this.l);
        var1.writeByte(4);
        var1.writeFloat(this.v);
        var1.writeFloat(this.m);
        var1.writeBoolean(this.n);
        var1.writeBoolean(this.o);
        var1.writeInt(this.h);
        super.a(var1);
    }

    public void a(GameInputStream var1) {
        this.b = (class_658)var1.readEnum(class_658.class);
        this.c = (class_657)var1.readEnum(class_657.class);
        this.d = var1.readFloat();
        this.e = var1.readFloat();
        this.f = var1.readFloat();
        this.g = var1.readFloat();
        this.i = var1.readFloat();
        this.j = var1.readFloat();
        this.k = var1.readFloat();
        this.l = var1.readFloat();
        byte var2 = var1.readByte();
        if (var2 >= 1) {
            this.v = var1.readFloat();
        }

        if (var2 >= 2) {
            this.m = var1.readFloat();
        }

        if (var2 >= 3) {
            this.n = var1.readBoolean();
            this.o = var1.readBoolean();
        }

        if (var2 >= 4) {
            this.h = var1.readInt();
        }

        super.a(var1);
    }

    public class_69(class_138 var1, float var2, float var3) {
        super(var1, var2, var3);
    }

    public PointF a() {
        GameEngine var1 = GameEngine.getGameEngine();
        PointF var2 = null;
        int var3 = (int)(this.U * var1.bL.r);
        var1.bL.a(this.S, this.T);
        int var4 = var1.bL.T;
        int var5 = var1.bL.U;

        for(int var6 = var4 - var3; var6 <= var4 + var3; ++var6) {
            for(int var7 = var5 - var3; var7 <= var5 + var3; ++var7) {
                if (var1.bL.c(var6, var7)) {
                    class_482 var8 = var1.bL.e(var6, var7);
                    if (var8 != null && var8.i) {
                        Unit var9 = class_88.b(var6, var7);
                        boolean var10 = false;
                        if (var9 == null) {
                            var10 = true;
                        }

                        if (var9 != null && var9 instanceof OrderableUnit) {
                            OrderableUnit var11 = (OrderableUnit)var9;
                            if (!var11.r().p()) {
                                var10 = true;
                            }
                        }

                        if (var10) {
                            var1.bL.a(var6, var7);
                            if (var2 == null || class_340.rand(0, 100) < 50) {
                                this.w.setSite((float)(var1.bL.T + var1.bL.p), (float)(var1.bL.U + var1.bL.q));
                                var2 = this.w;
                            }
                        }
                    }
                }
            }
        }

        return var2;
    }

    public void a(OrderableUnit var1) {
        this.q.remove(var1);
    }

    public void b() {
        this.p.clear();
        this.q.clear();
        Unit[] var1 = Unit.bE.a();
        int var2 = 0;

        for(int var3 = Unit.bE.size(); var2 < var3; ++var2) {
            Unit var4 = var1[var2];
            if (var4.bX == this.R && !var4.bV && !var4.u() && this.a(var4)) {
                this.q.a(var4);
                class_31 var5 = var4.dz;
                if (!this.p.contains(var5)) {
                    this.p.add(var5);
                }
            }
        }

    }

    public boolean a(class_31 var1) {
        return this.a(var1, false, true) != null;
    }

    public boolean b(class_31 var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if ((!var2.ar || var1.C()) && !var1.w()) {
            Object[] var3 = this.p.a();
            int var4 = 0;

            for(int var5 = this.p.size(); var4 < var5; ++var4) {
                class_31 var6 = (class_31)var3[var4];
                Unit[] var7 = this.q.a();
                int var8 = 0;

                for(int var9 = this.q.size(); var8 < var9; ++var8) {
                    Unit var10 = var7[var8];
                    if (var10.r() == var6 && var10 instanceof OrderableUnit) {
                        OrderableUnit var11 = (OrderableUnit)var10;
                        if (var11.b(var1, true)) {
                            return true;
                        }
                        break;
                    }
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public class_31 c() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.R.aY) {
            return null;
        } else {
            int var2 = this.a(this.R.bC);
            class_31 var3 = null;
            float var4 = -1.0F;
            Iterator var5 = UnitType.ae.iterator();

            while(true) {
                class_31 var6;
                float var13;
                do {
                    do {
                        do {
                            do {
                                if (!var5.hasNext()) {
                                    this.f = var4;
                                    return var3;
                                }

                                var6 = (class_31)var5.next();
                            } while(!var6.j());
                        } while(!this.b(var6));

                        int var7 = this.R.a(var6, class_656.INCLUDE);
                        int var8 = this.c(var6);
                        boolean var9 = false;
                        if (var6 instanceof class_591) {
                            var9 = true;
                            class_591 var10 = (class_591)var6;
                            class_31 var12;
                            if (var10.fL.size() != 0) {
                                for(Iterator var11 = var10.fL.iterator(); var11.hasNext(); var8 += this.c(var12)) {
                                    var12 = (class_31)var11.next();
                                    var7 += this.R.a(var12, class_656.INCLUDE);
                                }
                            }
                        }

                        var13 = -2.0F;
                        if (var6.p() && !var9 && this.a() != null && class_340.rand(0, 100) < 90) {
                            if (var8 == 0) {
                                if (this.R.credits < 5000.0) {
                                    var13 = 0.98F;
                                } else {
                                    var13 = 0.58F;
                                }
                            }

                            if (var8 == 1) {
                                var13 = 0.55F;
                            }

                            if (var8 == 2) {
                                var13 = 0.4F;
                            }

                            if (var8 >= 3) {
                                var13 = 0.25F / (float)var8;
                            }

                            if (var7 >= 3) {
                                var13 = (float)((double)var13 * 0.6);
                            }
                        }

                        if (var6 == UnitType.landFactory && (var7 < 5 || var2 == 0)) {
                            if (var7 == 0) {
                                var13 = 0.8F;
                            } else if (var8 < 2) {
                                var13 = 0.46F / (float)(var7 + var8 * 2);
                            }
                        }

                        if (var6 == UnitType.seaFactory && this.R.ah() && (var7 < 5 || var2 == 0)) {
                            if (var7 == 0) {
                                var13 = 0.3F;
                            } else if (var8 < 1) {
                                var13 = 0.1F / (float)(var7 + var8 * 2);
                            }
                        }

                        if (var6 == UnitType.airFactory && (var7 < 5 || var2 == 0)) {
                            if (var7 == 0) {
                                var13 = 0.48F;
                            } else if (var8 < 2) {
                                var13 = 0.29F / (float)(var7 + var8);
                            }
                        }

                        if (var6 == UnitType.turret) {
                            if (var8 == 0) {
                                var13 = 0.47F;
                            } else if (var8 < 3) {
                                var13 = 0.35F / (float)var8;
                            } else if (var8 < 4) {
                                var13 = 0.025F / (float)var8;
                            }
                        }

                        if (var6 == UnitType.laserDefence && var8 == 0) {
                            var13 = 0.018F;
                        }

                        if (var6 == UnitType.repairbay && var8 == 0) {
                            var13 = 0.02F;
                        }

                        if (var6 == UnitType.antiAirTurret) {
                            if (var8 == 0) {
                                var13 = 0.42F;
                            } else if (this.R.ac()) {
                                if (var8 < 4) {
                                    var13 = 0.3F / (float)var8;
                                }
                            } else if (var8 < 3) {
                                var13 = 0.3F / (float)var8;
                            } else if (var8 < 4) {
                                var13 = 0.02F / (float)var8;
                            }
                        }

                        if (var6 == UnitType.fabricator && this.R.credits > 2000.0 && var8 < 5) {
                            if (var7 == 0) {
                                var13 = 0.11F;
                            } else {
                                var13 = 0.07F / (0.2F * (float)var7 + (float)var8);
                            }
                        }

                        if (var6 == UnitType.AntiNukeLaucher && (!var1.O() || !var1.netEngine.gameMapData.nukes) && this.R.credits > 2200.0 && var7 < 4) {
                            if (var7 == 0) {
                                var13 = 0.06F;
                            } else if (var8 < 1) {
                                var13 = 0.05F / (float)(var7 + var8 * 2);
                            }
                        }

                        if (var9) {
                            class_591 var14 = (class_591)var6;
                            if (!var14.fw && (var7 < var14.fx || var14.fx == -1) && (var8 < var14.fy || var14.fy == -1)) {
                                var13 = var14.fz;
                                if (var8 < var14.fA) {
                                    var13 = var14.fB;
                                }

                                if (var8 == 0) {
                                    var13 += var14.fC;
                                }

                                if (var7 == 0) {
                                    var13 += var14.fD;
                                }

                                if (var6.p() && this.a() == null) {
                                    var13 = -2.0F;
                                }
                            }
                        }

                        if (this.R.ad() && var6 == UnitType.experimentalLandFactory && this.R.credits > 15000.0) {
                            if (var7 == 0) {
                                var13 = 0.04F;
                            }

                            if (this.R.credits > 55000.0 && var7 == 1) {
                                var13 = 0.03F;
                            }
                        }
                    } while(!(var13 >= 0.0F));
                } while(!(var13 > var4) && !((double)class_340.c(0.0F, 1.0F) < 0.01));

                var4 = var13;
                var3 = var6;
            }
        }
    }

    public int a(class_564 var1) {
        int var2 = 0;

        class_659 var4;
        for(Iterator var3 = var1.c.iterator(); var3.hasNext(); var2 += this.c(var4.a)) {
            var4 = (class_659)var3.next();
        }

        return var2;
    }

    public int c(class_31 var1) {
        int var2 = 0;
        class_692 var3 = this.q;
        Unit[] var4 = var3.a();
        int var5 = 0;

        for(int var6 = var3.size(); var5 < var6; ++var5) {
            Unit var7 = var4[var5];
            if (var7.bX == this.R && var7.dz == var1 && this.a(var7)) {
                ++var2;
            }
        }

        return var2;
    }

    public int d() {
        int var1 = 0;
        class_692 var2 = this.q;
        Unit[] var3 = var2.a();
        int var4 = 0;

        for(int var5 = var2.size(); var4 < var5; ++var4) {
            Unit var6 = var3[var4];
            if (var6.bX == this.R && var6 instanceof OrderableUnit) {
                OrderableUnit var7 = (OrderableUnit)var6;
                if (this.a(var7, false) && !var7.bM && var7.aB == null && this.R.h(var7) && this.R.i(var7)) {
                    ++var1;
                }
            }
        }

        return var1;
    }

    public int e() {
        return this.K;
    }

    public boolean f() {
        int var1 = this.h();
        return var1 != 0;
    }

    public Unit g() {
        float var1 = this.U + 120.0F;
        Unit[] var2 = Unit.bE.a();
        int var3 = 0;

        for(int var4 = Unit.bE.size(); var3 < var4; ++var3) {
            Unit var5 = var2[var3];
            if (var5.xCord + var1 > this.S && var5.xCord - var1 < this.S && var5.yCord + var1 > this.T && var5.yCord - var1 < this.T && var5.bX != this.R && this.a(var5, 120.0F) && var5.bX.c((PlayerData)this.R) && this.R.j(var5)) {
                return var5;
            }
        }

        return null;
    }

    public int h() {
        return this.a(60.0F);
    }

    public int a(float var1) {
        int var2 = 0;
        float var3 = this.U + var1;
        Unit[] var4 = Unit.bE.a();
        int var5 = 0;

        for(int var6 = Unit.bE.size(); var5 < var6; ++var5) {
            Unit var7 = var4[var5];
            if (var7.xCord + var3 > this.S && var7.xCord - var3 < this.S && var7.yCord + var3 > this.T && var7.yCord - var3 < this.T && var7.bX != this.R && this.a(var7, var1) && var7.bX.c((PlayerData)this.R) && var7.l() && this.R.j(var7)) {
                ++var2;
            }
        }

        return var2;
    }

    public void i() {
        GameEngine var1 = GameEngine.getGameEngine();
        Unit var2 = this.g();
        if (var2 != null) {
            SyncPacket var3 = var1.cf.a((PlayerData)this.R);
            Unit[] var4 = Unit.bE.a();
            int var5 = 0;

            for(int var6 = Unit.bE.size(); var5 < var6; ++var5) {
                Unit var7 = var4[var5];
                if (var7 instanceof OrderableUnit) {
                    OrderableUnit var8 = (OrderableUnit)var7;
                    if (var7.bX == this.R && this.R.b(var7, var2) && this.R.i(var8) && var8.aq()) {
                        if (!var7.bM) {
                            if (class_138.a(var7, this.S, this.T, 800.0F)) {
                                var3.a(var8);
                            }
                        } else if (class_138.a(var7, this.S, this.T, 540.0F)) {
                            var3.a(var8);
                        }
                    }
                }
            }

            var3.a(var2);
        }

    }

    public boolean a(Unit var1) {
        return this.a(var1, false);
    }

    public boolean a(Unit var1, boolean var2) {
        return var1 instanceof OrderableUnit && ((OrderableUnit)var1).aC == this && (!var2 || this.b(var1));
    }

    public boolean a(OrderableUnit var1, boolean var2) {
        return var1.aC == this && (!var2 || this.b(var1));
    }

    public int j() {
        int var1 = 0;
        Iterator var2 = this.k().iterator();

        while(var2.hasNext()) {
            Unit var3 = (Unit)var2.next();
            if (this.R != var3.bX && var3.bX.c((PlayerData)this.R) && var3 instanceof OrderableUnit && this.b(var3)) {
                ++var1;
            }
        }

        return var1;
    }

    public class_1019 k() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.cc.b(this.S, this.T, this.U);
    }

    private OrderableUnit x() {
        return this.a((class_31)null, (PointF)null, true);
    }

    private OrderableUnit y() {
        return this.f((class_31)null);
    }

    private OrderableUnit f(class_31 var1) {
        return this.a((class_31)var1, (PointF)null, false);
    }

    private OrderableUnit a(class_31 var1, PointF var2, boolean var3) {
        if (this.K == 0) {
            return null;
        } else {
            this.y = 0;
            float var4 = Float.MAX_VALUE;
            OrderableUnit var5 = null;
            GameEngine var6 = GameEngine.getGameEngine();
            if (var1 == null || (!var6.ar || var1.C()) && !var1.w()) {
                Unit[] var7 = Unit.bE.a();
                int var8 = 0;

                for(int var9 = Unit.bE.size(); var8 < var9; ++var8) {
                    Unit var10 = var7[var8];
                    if (var10.bX == this.R && this.a(var10) && var10.cN == null && var10.aj() && var10 instanceof OrderableUnit && this.R.i(var10)) {
                        OrderableUnit var11 = (OrderableUnit)var10;
                        boolean var12 = class_660.a(var11);
                        if (var12 && (!var3 || var11.I())) {
                            ++this.y;
                            if (var1 == null || var11.b(var1, true)) {
                                boolean var13 = false;
                                float var14 = -1.0F;
                                if (var2 != null) {
                                    var14 = class_340.a(var2.x, var2.y, var10.xCord, var10.yCord);
                                }

                                if (var5 == null) {
                                    var13 = true;
                                } else {
                                    if (var2 != null && var14 < var4) {
                                        var13 = true;
                                    }

                                    if ((double)class_340.c(0.0F, 1.0F) < 0.2) {
                                        var13 = true;
                                    }
                                }

                                if (var13) {
                                    var5 = (OrderableUnit)var10;
                                    if (var2 != null) {
                                        var4 = var14;
                                    }
                                }
                            }
                        }
                    }
                }

                return var5;
            } else {
                return null;
            }
        }
    }

    private OrderableUnit a(Unit var1, PointF var2, boolean var3) {
        if (this.L == 0) {
            return null;
        } else {
            float var4 = Float.MAX_VALUE;
            OrderableUnit var5 = null;
            GameEngine var6 = GameEngine.getGameEngine();
            Unit[] var7 = this.q.a();
            int var8 = 0;

            for(int var9 = this.q.size(); var8 < var9; ++var8) {
                Unit var10 = var7[var8];
                if (var10.bX == this.R && this.a(var10) && var10.cN == null) {
                    class_31 var11 = var10.r();
                    if (var11.n() && var10 instanceof OrderableUnit && this.R.i(var10)) {
                        OrderableUnit var12 = (OrderableUnit)var10;
                        boolean var13 = class_660.b(var12);
                        if (var13 && (!var3 || var12.I()) && (var1 == null || var12.h(var1, true))) {
                            boolean var14 = false;
                            if (var11 instanceof class_591) {
                                class_591 var15 = (class_591)var11;
                                if (var15.fH != null && !this.a(var15.fH)) {
                                    continue;
                                }
                            }

                            float var16 = -1.0F;
                            if (var2 != null) {
                                var16 = class_340.a(var2.x, var2.y, var10.xCord, var10.yCord);
                            }

                            if (var5 == null) {
                                var14 = true;
                            } else {
                                if (var2 != null && var16 < var4) {
                                    var14 = true;
                                }

                                if ((double)class_340.c(0.0F, 1.0F) < 0.2) {
                                    var14 = true;
                                }
                            }

                            if (var14) {
                                var5 = (OrderableUnit)var10;
                                if (var2 != null) {
                                    var4 = var16;
                                }
                            }
                        }
                    }
                }
            }

            return var5;
        }
    }

    private boolean g(class_31 var1) {
        this.z = var1;
        this.A = null;
        this.B = null;
        GameEngine var2 = GameEngine.getGameEngine();
        PointF var3;
        if (var1.p()) {
            var3 = this.a();
        } else {
            var3 = this.e(var1);
        }

        if (var3 == null) {
            return false;
        } else {
            OrderableUnit var4 = this.a(var1, var3, false);
            if (var4 == null) {
                return false;
            } else {
                if (var1 == UnitType.seaFactory) {
                    int var10000 = class_694.c(var3.x, var3.y, MovementType.WATER);
                    this.R.getClass();
                    if (var10000 < 3000) {
                        return false;
                    }
                }

                int var5 = 1;
                class_226 var6 = var4.a(var1, true);
                if (var6 != null) {
                    var5 = var6.t();
                } else {
                    GameEngine.print("buildBuilding: could not find getBuildUnitAction for builder this shouldn't happen:" + var1.i());
                }

                if (var6.b((Unit)var4) && var6.a(var4, false)) {
                    SyncPacket var7;
                    if (var6.A()) {
                        var7 = var2.cf.a((PlayerData)this.R);
                        var7.a(var4);
                        var7.a(var6.N(), var3, (Unit)null);
                    } else {
                        var7 = var2.cf.a((PlayerData)this.R);
                        var7.a(var4);
                        var7.a(var3.x, var3.y, var1, var5);
                    }
                } else if (!this.R.a((class_447)var6.B(), (Unit)var4)) {
                    this.A = var6.B();
                    this.B = this.A.i(var4);
                }

                return true;
            }
        }
    }

    private boolean z() {
        Unit[] var1 = Unit.bE.a();
        int var2 = 0;

        for(int var3 = Unit.bE.size(); var2 < var3; ++var2) {
            Unit var4 = var1[var2];
            if (var4.bX == this.R && this.a(var4) && var4.bT() && !var4.u() && var4 instanceof OrderableUnit) {
                OrderableUnit var5 = (OrderableUnit)var4;
                if (var5.ai()) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean a(class_588 var1) {
        Unit[] var2 = this.q.a();
        int var3 = 0;

        for(int var4 = this.q.size(); var3 < var4; ++var3) {
            Unit var5 = var2[var3];
            if (var5.bX == this.R && var5.bT()) {
                class_588 var6 = var5.de();
                if (var6 != null && class_585.a(var1, var6)) {
                    return true;
                }
            }
        }

        return false;
    }

    private OrderableUnit a(class_31 var1, boolean var2, boolean var3) {
        Unit[] var4 = this.q.a();
        int var5 = 0;

        for(int var6 = this.q.size(); var5 < var6; ++var5) {
            Unit var7 = var4[var5];
            if (var7.bX == this.R && var7.bT() && this.R.i(var7) && var7 instanceof class_8 && var7 instanceof OrderableUnit) {
                OrderableUnit var8 = (OrderableUnit)var7;
                class_8 var9 = (class_8)var7;
                class_226 var10 = var7.e(var1);
                if (var10 != null && (var9.dy() || !var2) && !var10.m(var7) && var10.b((Unit)var8) && var10.a(var8, false) && (!(var7 instanceof CommandCenter) || var1.m() || this.u() <= 2 || this.s || !var2) && (!var3 || var8.aD)) {
                    return var8;
                }
            }
        }

        return null;
    }

    private boolean a(class_564 var1, boolean var2) {
        ArrayList var3 = var1.a();
        Iterator var4 = var3.iterator();

        class_659 var5;
        do {
            if (!var4.hasNext()) {
                return false;
            }

            var5 = (class_659)var4.next();
        } while(!this.a(var5.a, var2));

        return true;
    }

    private boolean a(class_31 var1, boolean var2) {
        byte var3 = 1;
        return this.a(var1, var2, var3);
    }

    private boolean a(class_31 var1, boolean var2, int var3) {
        if (var3 < 1) {
            GameEngine.b("AI", "buildUnit: quantity cannot be < 1");
            return false;
        } else {
            OrderableUnit var4 = this.a(var1, true, var2);
            if (var4 == null) {
            }

            if (var4 == null) {
                return false;
            } else {
                GameEngine var5 = GameEngine.getGameEngine();
                class_226 var6 = var4.e(var1);
                if (var6 == null) {
                    GameEngine.b("AI", "buildUnit: action is null!");
                    return false;
                } else if (!var6.b((Unit)var4)) {
                    GameEngine.b("AI", "buildUnit: isAvailable==false");
                    return false;
                } else if (!var6.a(var4, false)) {
                    GameEngine.b("AI", "buildUnit: isActive==false");
                    return false;
                } else if (!var6.g(var4) && (!var6.n_() || !var5.ar)) {
                    for(int var7 = 0; var7 < var3; ++var7) {
                        SyncPacket var8 = var5.cf.a((PlayerData)this.R);
                        var8.a(var4);
                        var8.a(var6.z());
                    }

                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    class_69 l() {
        float var1 = -1.0F;
        class_69 var2 = null;
        Iterator var3 = this.R.bn.iterator();

        while(true) {
            class_69 var5;
            float var6;
            do {
                do {
                    do {
                        class_63 var4;
                        do {
                            if (!var3.hasNext()) {
                                return var2;
                            }

                            var4 = (class_63)var3.next();
                        } while(!(var4 instanceof class_69));

                        var5 = (class_69)var4;
                    } while(var5 == this);
                } while(var5.e() <= 1);

                var6 = var5.a((class_69)this);
            } while(var2 != null && !(var6 < var1));

            var1 = var6;
            var2 = var5;
        }
    }

    public void m() {
        GameEngine var1 = GameEngine.getGameEngine();
        class_69 var2 = this.l();
        if (var2 != null && var2.e() > 1) {
            OrderableUnit var3 = var2.x();
            if (var3 != null) {
                PointF var4 = this.w();
                if (class_694.a(var3, var4.x, var4.y)) {
                    boolean var5 = this.R.a(var3, var4.x, var4.y);
                    if (var5 || this.R.aG != 0) {
                        SyncPacket var6 = var1.cf.a((PlayerData)this.R);
                        var6.a(var3);
                        var6.a(var4.x, var4.y);
                        ++this.h;
                        this.g = (float)class_340.rand(1800, 2500);
                        if (this.h >= 2) {
                            this.g += 11000.0F;
                        }

                        --var2.K;
                        if (!var5) {
                            boolean var7 = true;
                            if (var3.aB != null) {
                                if (!var3.aB.a()) {
                                    var3.aB.b(var3);
                                } else {
                                    var7 = false;
                                    if (!var3.aB.G.contains(var3)) {
                                        var3.aB.G.add(var3);
                                    }
                                }
                            }

                            if (var7) {
                                class_67 var8 = new class_67(this.R);
                                var8.c(var3);
                                var8.S = var4.x;
                                var8.T = var4.y;
                            }

                            this.g = (float)class_340.rand(12000, 14000);
                        }
                    }
                }
            }
        }

    }

    private Unit A() {
        Unit[] var1 = Unit.bE.a();
        int var2 = 0;

        for(int var3 = Unit.bE.size(); var2 < var3; ++var2) {
            Unit var4 = var1[var2];
            if (var4.bX == this.R && this.a(var4, true) && var4.bI() && (var4.health < var4.totalHealth - 1.0F || var4.cm < 1.0F)) {
                return var4;
            }
        }

        return null;
    }

    public void n() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.r.size() != 0) {
            if (!this.s) {
                for(int var2 = 0; var2 < 8; ++var2) {
                    class_31 var3 = this.R.bA.c();
                    if (var3 != null && this.a(var3)) {
                        boolean var4 = this.d(var3);
                        if (var4) {
                            break;
                        }
                    }
                }

            }
        }
    }

    public boolean d(class_31 var1) {
        if (!(var1 instanceof class_591)) {
            return false;
        } else {
            class_591 var2 = (class_591)var1;
            if (var2.fE == -1 && var2.fF == -1) {
                return false;
            } else {
                int var3 = 0;
                int var4 = 0;
                boolean var5 = var2.fG;
                Unit[] var6 = Unit.bE.a();
                int var7 = 0;

                for(int var8 = Unit.bE.size(); var7 < var8; ++var7) {
                    Unit var9 = var6[var7];
                    if (var9.bX == this.R && var9.cN == null && var9 instanceof OrderableUnit && this.R.i(var9)) {
                        OrderableUnit var10 = (OrderableUnit)var9;
                        class_31 var11 = var9.r();
                        if (var5) {
                            if (!var11.n()) {
                                continue;
                            }
                        } else if (var11 != var2 && !var2.fL.contains(var11)) {
                            continue;
                        }

                        ++var4;
                        if (this.a(var9)) {
                            ++var3;
                        }
                    }
                }

                if (var2.fE != -1 && var3 >= var2.fE) {
                    return false;
                } else if (var2.fF != -1 && var4 >= var2.fF) {
                    return false;
                } else {
                    boolean var12 = this.a((class_31)var2, true);
                    return var12;
                }
            }
        }
    }

    public void o() {
        if (this.r.size() != 0) {
            Unit var1 = this.r();
            if (var1 != null) {
                this.x.setSite(var1.xCord, var1.yCord);
                OrderableUnit var2 = this.a(var1, this.x, true);
                if (var2 != null) {
                    this.a(var2, var1);
                }
            }

        }
    }

    public void q() {
        if (this.r.size() != 0) {
            if (this.B != null) {
                Unit[] var1 = this.q.a();
                int var2 = 0;

                for(int var3 = this.q.size(); var2 < var3; ++var2) {
                    Unit var4 = var1[var2];
                    if (var4.bX == this.R && this.a(var4) && var4.cN == null) {
                        class_31 var5 = var4.r();
                        if (var5.n() && var4 instanceof OrderableUnit && this.R.i(var4) && !((double)class_340.c(0.0F, 1.0F) > 0.3)) {
                            OrderableUnit var6 = (OrderableUnit)var4;
                            class_1042 var7 = var6.ar();
                            if (var7 != null && var7.d() == WaypointType.reclaim) {
                                Unit var8 = var7.i();
                                if (var8 != null && var8.g() > 0.0F && !this.B.c(var8.cM())) {
                                    Unit var9 = this.r();
                                    this.a(var6, var9);
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public Unit r() {
        Unit var1 = null;

        for(int var2 = 0; var2 < 20; ++var2) {
            var1 = this.r.a(class_340.rand(0, this.r.size() - 1));
            if (var1 == null || this.B == null || this.B.c(var1.cM())) {
                break;
            }
        }

        return var1;
    }

    public void a(OrderableUnit var1, Unit var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (var1.g(var2, true)) {
            SyncPacket var4 = var3.cf.a((PlayerData)this.R);
            var4.a(var1);
            var4.d(var2);
        }

    }

    public void s() {
        GameEngine var1 = GameEngine.getGameEngine();
        Unit var2 = this.A();
        if (var2 != null) {
            this.x.setSite(var2.xCord, var2.yCord);
            OrderableUnit var3 = this.a((class_31)null, (PointF)this.x, true);
            if (var3 != null && var3.a(var2) && var2.e(var3) < 2) {
                SyncPacket var4 = var1.cf.a((PlayerData)this.R);
                var4.a(var3);
                var4.b(var2);
            }
        }

    }

    public void b(float var1) {
        this.c(var1);
        int var2 = this.J;
        int var3 = this.I;
        this.b();
        this.n = this.z();
        if (this.n) {
            this.o = true;
        }

        if (var2 >= 1) {
            this.s();
        }

        if (this.M && this.I > 0) {
            this.n();
            this.q();
            this.o();
        }

        byte var4 = 2;
        int var5;
        if (var2 < var4 && this.i == 0.0F) {
            this.i = 300.0F;
            var5 = this.R.a(this.R.bz, class_656.INCLUDE);
            if (!this.s || var5 <= 2) {
                boolean var6 = true;
                boolean var7 = class_340.rand(0, 100) < 5;
                if (!var7 && this.a(this.R.bz, var6)) {
                    this.H = false;
                    this.i = 900.0F;
                } else {
                    if (!var7) {
                        this.H = true;
                    }

                    if (!this.s && this.v == 0.0F && var2 < 1 && this.g == 0.0F) {
                        this.m();
                    }
                }
            }
        }

        var5 = this.j();
        if (var2 == 0 && var3 == 0) {
            this.k += var1;
            if (var5 > 2) {
                this.k += 2.0F * var1;
            }

            if (var5 > 5) {
                this.k += 4.0F * var1;
            }
        } else {
            this.k = class_340.a(this.k, var1);
        }

        if (this.k > 11000.0F) {
            this.p();
        }

        if (this.b == class_658.PRE && (var2 != 0 && var3 != 0 || var3 > 5 && var5 == 0)) {
            this.l += var1;
            if (this.l > 2000.0F) {
                this.b = class_658.ACTIVE;
            }
        }

        this.t();
    }

    public void t() {
        if (this.b == null) {
            GameEngine.a("fixOverlaps: this.state==null");
            GameEngine.a("id:" + this.Q);
            GameEngine.a("x:" + this.S);
            GameEngine.a("y:" + this.T);
            GameEngine.a("radius:" + this.U);
            if (this.R != null) {
                GameEngine.a("team:" + this.R.site);
            }

        } else {
            Iterator var1 = this.R.bm.iterator();

            while(var1.hasNext()) {
                class_63 var2 = (class_63)var1.next();
                if (var2 instanceof class_69 && var2 != this) {
                    class_69 var3 = (class_69)var2;
                    float var4 = class_340.a(this.S, this.T, var3.S, var3.T);
                    if (var4 < 400.0F) {
                        if (var3.b == null) {
                            GameEngine.a("fixOverlaps: targetBase.state==null");
                        } else if (var3.b.a() < this.b.a()) {
                            var3.p();
                        } else {
                            this.p();
                        }
                    }
                }
            }

        }
    }

    public int u() {
        return this.I;
    }

    public void c(float var1) {
        this.I = 0;
        this.J = 0;
        this.L = 0;
        this.K = 0;
        this.M = false;
        this.r.clear();
        boolean var2 = true;
        if (var2) {
            Iterator var3 = this.k().iterator();

            while(var3.hasNext()) {
                Unit var4 = (Unit)var3.next();
                if (var4.g() > 0.0F && this.b(var4)) {
                    this.M = true;
                    this.r.a(var4);
                }
            }
        }

        Unit[] var10 = Unit.bE.a();
        int var11 = 0;

        for(int var5 = Unit.bE.size(); var11 < var5; ++var11) {
            Unit var6 = var10[var11];
            if (var6.bX == this.R && var6 instanceof OrderableUnit) {
                OrderableUnit var7 = (OrderableUnit)var6;
                if (this.a(var7, false) && var6.bT() && this.R.i(var6) && !var6.u()) {
                    class_31 var8 = var6.r();
                    if (var8.j()) {
                        ++this.I;
                    }

                    if (var8.m()) {
                        ++this.J;
                        boolean var9 = class_660.a(var7);
                        if (var9) {
                            ++this.K;
                        }
                    }

                    if (var8.n()) {
                        ++this.L;
                    }

                    if (var6 instanceof class_8) {
                        class_8 var12 = (class_8)var6;
                        this.J += var12.h(UnitType.builder);
                    }
                }
            }
        }

    }

    public void d(float var1) {
        this.s = this.f();
        this.t = this.s;
        if (this.s) {
            this.v += var1;
            this.u = 100.0F;
        } else {
            this.v = 0.0F;
        }

        if (this.v > 6000.0F) {
            this.s = false;
        }

        this.m = class_340.a(this.m, var1);
        this.e = class_340.a(this.e, var1);
        this.g = class_340.a(this.g, var1);
        this.i = class_340.a(this.i, var1);
        this.j = class_340.a(this.j, var1);
        if (this.s && this.j == 0.0F) {
            this.j = (float)(100 + this.Q % 15);
            if (!this.R.aY) {
                this.i();
            }
        }

        if (this.e <= 0.0F) {
            this.e = (float)(270 + this.Q % 15);
            if (this.R.ac()) {
                this.e = (float)(190 + this.Q % 15);
            }

            if ((double)this.f < 0.2) {
                this.e += 180.0F;
            }

            if ((double)this.f < 0.08) {
                this.e += 180.0F;
            }

            boolean var2 = this.y() != null;
            if (var2) {
                class_31 var3 = null;
                var3 = this.c();
                if (var3 != null && ((double)this.f > 0.8 || this.R.a(1300.0)) && ((double)this.f > 0.4 || this.R.a(1700.0)) && ((double)this.f > 0.2 || this.R.a(2100.0)) && ((double)this.f > 0.1 || this.R.a(2800.0)) && ((double)this.f > 0.05 || this.R.a(3100.0)) && ((double)this.f > 0.01 || this.R.a(4800.0))) {
                    ++this.C;
                    if (!this.g(var3)) {
                        this.e -= 120.0F;
                        ++this.D;
                    }
                }
            }
        }

        float var4 = (float)this.u();
        var4 /= 3.0F;
        if (var4 < 1.0F) {
            var4 = 1.0F;
        }

        if (this.s) {
            this.d = (float)((double)this.d + (double)var1 * 0.015);
        }

        if ((double)this.f < 0.6) {
            if (this.R.bb < 2) {
                this.d = (float)((double)this.d + (double)var1 * 7.0E-4 * (double)var4);
            } else if (this.R.a(1200.0)) {
                this.d = (float)((double)this.d + (double)var1 * 1.0E-4 * (double)var4);
            }

            if (this.R.a(1600.0)) {
                this.d = (float)((double)this.d + (double)var1 * 0.001);
            }

            if (this.R.a(2200.0)) {
                this.d = (float)((double)this.d + (double)var1 * 0.001);
            }

            if (this.R.a(2600.0)) {
                this.d = (float)((double)this.d + (double)var1 * 0.001);
            }

            if (this.R.a(8000.0)) {
                this.d = (float)((double)this.d + (double)var1 * 0.005);
            }

            if (this.R.a(9000.0)) {
                this.d = (float)((double)this.d + (double)var1 * 0.01);
            }

            if (this.R.a(10100.0)) {
                this.d = (float)((double)this.d + (double)var1 * 0.01);
            }

            if (this.R.a(30000.0)) {
                this.d = (float)((double)this.d + (double)var1 * 0.05);
            }
        }

        if (this.R.a(5000.0)) {
            this.d = (float)((double)this.d + (double)var1 * 0.001);
        }

        if (!this.R.a(800.0) && !this.s && this.d > 1.2F) {
            this.d = 1.2F;
        }

        if (this.d > 3.5F) {
            this.d = 3.5F;
        }

        for(int var5 = 0; var5 < 12; ++var5) {
            this.v();
            if (!(this.d >= 3.0F)) {
                break;
            }
        }

    }

    public void a(ArrayList var1, class_564 var2, MovementType var3, int var4) {
        this.N.clear();

        for(int var5 = 0; var5 < var4; ++var5) {
            class_31 var6 = var2.a(var3);
            if (var6 != null && !this.N.contains(var6)) {
                this.N.add(var6);
            }
        }

        var1.addAll(this.N);
    }

    public void v() {
        int var1 = this.d();
        byte var2 = 12;
        byte var3 = 50;
        if (this.R.ac()) {
            var3 = 65;
            var2 = 16;
        }

        boolean var4 = this.R.a(25000.0);
        boolean var5 = false;
        ArrayList var6 = new ArrayList();
        boolean var7 = this.R.ai();
        boolean var8 = this.R.aj();
        float var9 = 0.4F;
        float var10 = 0.3F;
        float var11 = 0.2F;
        if (!this.R.bh) {
            var9 = 0.1F;
            var10 = 0.5F;
            var11 = 0.4F;
        }

        if (!this.R.bi) {
            var9 = 0.2F;
            var10 = 0.1F;
            var11 = 0.7F;
        }

        float var13 = class_340.c(0.0F, 1.0F);
        MovementType var12;
        if (var13 < var9) {
            var12 = MovementType.LAND;
        } else if (var13 < var9 + var10) {
            var12 = MovementType.HOVER;
        } else {
            var12 = MovementType.AIR;
        }

        if (this.R.a(1300.0) && this.d >= 1.0F || this.R.a(300.0) && this.d >= 3.0F) {
            int var14;
            if (this.R.ah() && this.R.bc < var2) {
                var14 = class_340.c(100);
                if (var14 < 35) {
                    this.a(var6, this.R.bu, (MovementType)null, 2);
                    if (var4) {
                        var5 = true;
                    }
                }
            }

            if (var1 < 3 && this.R.ba < var3) {
                if (var12 == MovementType.LAND) {
                    this.a(var6, this.R.br, (MovementType)null, 4);
                    if (var4) {
                        var5 = true;
                    }
                } else if (var12 == MovementType.HOVER) {
                    this.a(var6, this.R.bs, (MovementType)null, 4);
                    if (var4) {
                        var5 = true;
                    }
                } else {
                    this.a(var6, this.R.bt, (MovementType)null, 4);
                    if (var4) {
                        var5 = true;
                    }
                }
            }

            if (this.d >= 1.0F && var7 && this.m == 0.0F) {
                var14 = this.R.a(this.R.bx, class_656.INCLUDE);
                int var15 = this.R.a(this.R.by, class_656.INCLUDE);
                int var16 = var14 + var15;
                int var17 = this.R.ao();
                if ((this.R.a(1700.0) || var17 > 10 || this.R.bl == 0 && var17 >= 1 && var14 == 0) && (var16 < 3 || var17 > 20 && var16 < 5)) {
                    if (var8 && var16 < 2) {
                        this.a(var6, this.R.bw, (MovementType)null, 2);
                    } else {
                        this.a(var6, this.R.bw, MovementType.AIR, 2);
                    }
                }
            }
        }

        if (var6.size() == 0) {
            ++this.F;
        }

        while(var6.size() != 0) {
            class_31 var18 = (class_31)var6.remove(var6.size() - 1);
            Unit var19 = Unit.b(var18);
            boolean var20 = true;
            if (this.s && class_340.c(100) < 10) {
                Unit var21 = this.g();
                if (var21 != null && !this.R.b(var19, var21)) {
                    ++this.F;
                    var20 = false;
                }
            }

            if (var20) {
                boolean var22 = false;
                if (this.a(var18, var22)) {
                    ++this.F;
                    this.R.bE.a(var18);
                    --this.d;
                    if (this.R.g(var19)) {
                        this.m = 1000.0F;
                        ++this.R.bl;
                    }
                    break;
                }

                ++this.G;
            }
        }

    }

    public void a(OrderableUnit var1, class_447 var2, boolean var3) {
        this.O = var1.r();
        if (var3) {
            this.P = null;
            this.B = null;
        } else {
            this.P = var2;
            this.B = var2.i(var1);
        }

    }
}
