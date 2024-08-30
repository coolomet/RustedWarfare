package com.corrodinggames.rts.game.units.custom;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.ScorchMark;
import com.corrodinggames.rts.game.units.WaypointType;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.OrderType;
import com.corrodinggames.rts.game.units.class_1048;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_106;
import com.corrodinggames.rts.game.units.class_26;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.class_32;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.SpreadingFire;
import com.corrodinggames.rts.game.units.AttackMovementType;
import com.corrodinggames.rts.game.units.AttackMode;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.a.AIUse;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_283;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.game.units.custom.b.class_826;
import com.corrodinggames.rts.game.units.custom.b.class_827;
import com.corrodinggames.rts.game.units.custom.b.class_833;
import com.corrodinggames.rts.game.units.custom.b.class_834;
import com.corrodinggames.rts.game.units.custom.b.class_928;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.buildings.NukeLaucher;
import com.corrodinggames.rts.game.units.buildings.class_320;
import com.corrodinggames.rts.game.units.buildings.class_73;
import com.corrodinggames.rts.game.units.buildings.class_8;
import com.corrodinggames.rts.game.units.buildings.class_91;
import com.corrodinggames.rts.game.units.land.Builder;
import com.corrodinggames.rts.game.units.land.Hovercraft;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_984;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.Emitter;
import com.corrodinggames.rts.gameFramework.d.class_989;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.Point3DF;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.j
public strictfp class class_113 extends class_106 implements class_32, class_26, class_8 {
    public int a;
    public final class_583 b = new class_583(this);
    float c = 1.0F;
    float d;
    float e;
    public float f;
    boolean g;
    public boolean h = true;
    public boolean i = true;
    float j = 1.0F;
    boolean k = false;
    boolean l;
    float m;
    boolean n;
    float o;
    public boolean p = true;
    float q;
    boolean r;
    float s;
    float t;
    public float u;
    public boolean v;
    float w;
    public class_591 x;
    public class_398 y;
    public class_591 z;
    public class_399[] A;
    public final class_684 B = new class_684();
    public class_684 C = null;
    public float D;
    PointF[] E = null;
    PointF[] F = null;
    Projectile[] G;
    static final PointF H = new PointF();
    static final PointF I = new PointF();
    Paint J;
    protected static final PointF K = new PointF();
    protected static final Point3DF dK = new Point3DF();
    final class_320 dL = new class_320(this);
    public static PointF dM;
    public static Unit dN;
    public static int dO;
    public float dP;
    public float dQ;
    public float dR;
    public float dS;
    public class_928[] dT = null;
    static ArrayList dU = new ArrayList();
    public static class_684 dV = new class_684();
    public static class_684 dW = new class_684();
    public static class_684 dX = new class_684();
    static boolean dY;
    static final HashMap dZ;
    static int ea;
    static String eb;
    static final PointF ec;
    class_588 ed;
    protected static final Point3DF ee;
    protected static final PointF ef;
    class_684 eg = new class_684();

    public strictfp void K() {
        this.E = new PointF[6];
        this.F = new PointF[this.E.length];

        for(int var1 = 0; var1 < this.E.length; ++var1) {
            this.E[var1] = new PointF();
            this.F[var1] = new PointF();
        }

    }

    public strictfp PointF[] b() {
        if (this.E == null) {
            this.K();
        }

        return this.E;
    }

    public strictfp PointF[] e_() {
        if (this.E == null) {
            this.K();
        }

        return this.F;
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeInt(11);
        var1.writeFloat(this.e);
        var1.writeFloat(this.m);
        var1.writeBoolean(this.n);
        var1.writeInt(this.B.size());
        Iterator var2 = this.B.iterator();

        while(var2.hasNext()) {
            Unit var3 = (Unit)var2.next();
            var1.a(var3);
        }

        var1.writeBoolean(this.r);
        var1.writeFloat(this.o);
        var1.writeFloat(this.f);
        var1.writeFloat(this.s);
        var1.writeBoolean(this.v);
        byte var5 = 0;
        if (this.dT != null) {
            var5 = (byte)this.dT.length;
        }

        var1.writeByte(var5);
        if (this.dT != null) {
            for(int var6 = 0; var6 < var5; ++var6) {
                class_928 var4 = this.dT[var6];
                var1.writeFloat(var4.b);
                var1.writeFloat(var4.c);
                var1.writeFloat(var4.d);
                var1.writeFloat(var4.i);
                var1.writeBoolean(var4.k);
                var1.writeBoolean(var4.j);
                var1.writeBoolean(var4.m);
                var1.writeBoolean(var4.n);
            }
        }

        this.dL.a(var1);
        var1.a((class_31)this.z);
        var1.writeBoolean(this.i);
        var1.writeBoolean(this.h);
        boolean var7 = this.ed != this.x.O;
        var1.writeBoolean(var7);
        if (var7) {
            class_585.a(this.ed, var1);
        }

        class_398.a(this.y, this, var1);
        var1.writeFloat(this.q);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        if (var1.b() >= 32) {
            int var2 = var1.readInt();
            this.e = var1.readFloat();
            this.m = var1.readFloat();
            this.n = var1.readBoolean();
            this.B.clear();
            int var3 = var1.readInt();

            for(int var4 = 0; var4 < var3; ++var4) {
                Unit var5 = var1.o();
                if (var5 != null) {
                    this.B.add(var5);
                }
            }

            if (var2 >= 1) {
                this.r = var1.readBoolean();
            }

            if (var2 >= 2) {
                this.o = var1.readFloat();
            }

            if (var2 >= 3) {
                this.f = var1.readFloat();
                this.s = var1.readFloat();
            }

            if (var2 >= 4) {
                this.v = var1.readBoolean();
            }

            if (var2 >= 5) {
                byte var7 = var1.readByte();
                if (var7 != 0) {
                    this.du();
                    if (this.dT == null) {
                        GameEngine.log("readIn: legs==null but leg data found in save, this might be due to missing or changed mods");
                    }

                    for(int var9 = 0; var9 < var7; ++var9) {
                        class_928 var6;
                        if (this.dT == null) {
                            var6 = new class_928();
                        } else if (var9 >= this.dT.length) {
                            GameEngine.log("readIn: legs " + var9 + ">=" + this.dT.length);
                            var6 = new class_928();
                        } else {
                            var6 = this.dT[var9];
                        }

                        var6.b = var1.readFloat();
                        var6.c = var1.readFloat();
                        var6.d = var1.readFloat();
                        var6.i = var1.readFloat();
                        var6.k = var1.readBoolean();
                        var6.o = true;
                        var6.j = var1.readBoolean();
                        var6.m = var1.readBoolean();
                        var6.n = var1.readBoolean();
                    }
                }
            }

            if (var2 >= 6) {
                this.dL.a(var1);
            }

            if (var2 >= 7) {
                class_31 var8 = var1.q();
                if (var8 != null) {
                    if (var8 instanceof class_591) {
                        this.z = (class_591)var8;
                    } else {
                        GameEngine.print("Got non CustomUnitMetadata object of:" + var8.i() + " loading real_meta");
                        this.z = class_591.b;
                    }
                }
            }

            if (var2 >= 8) {
                this.i = var1.readBoolean();
                this.h = var1.readBoolean();
            }

            if (var2 >= 9) {
                boolean var10 = var1.readBoolean();
                if (var10) {
                    this.a(class_585.a(var1), true);
                }
            }

            if (var2 >= 10) {
                class_398.a(this, var1, var2);
            }

            if (var2 >= 11) {
                this.q = var1.readFloat();
            }
        }

        super.a(var1);
        if (this.dT != null) {
            this.dP = this.xCord;
            this.dQ = this.yCord;
            this.dR = this.zCord;
            this.dS = this.cg;
        }

    }

    public strictfp boolean cr() {
        return this.x.eM > 0;
    }

    public strictfp int bB() {
        return this.B.size();
    }

    public strictfp boolean bA() {
        return this.n;
    }

    public strictfp boolean d(Unit var1, boolean var2) {
        if (this.x.eM == 0) {
            return false;
        } else if (this.n) {
            return false;
        } else if (this.cm < 1.0F) {
            return false;
        } else if (!this.G(var1)) {
            return false;
        } else if (var1 == this) {
            return false;
        } else if (this.bX == var1.bX || var2 || this.x.cB && this.bX == PlayerData.i) {
            if (this.x.eP != null && !this.x.eP.a() && !class_585.a(this.x.eP, var1.de())) {
                return false;
            } else {
                boolean var3;
                if (this.x.eQ.size() > 0) {
                    var3 = false;
                    Iterator var4 = this.x.eQ.iterator();

                    while(var4.hasNext()) {
                        MovementType var5 = (MovementType)var4.next();
                        if (var5 == var1.h()) {
                            var3 = true;
                            break;
                        }
                    }

                    if (!var3) {
                        return false;
                    }
                }

                var3 = this.x.eR;
                return class_694.a(var1, var3, this.x.eS);
            }
        } else {
            return false;
        }
    }

    public strictfp boolean e(Unit var1, boolean var2) {
        if (!this.d(var1, var2)) {
            return false;
        } else {
            this.C(var1);
            return true;
        }
    }

    public strictfp void C(Unit var1) {
        var1.cN = this;
        this.B.add(var1);
        if (this.x.cC && this.bX == PlayerData.i) {
            this.e(var1.bX);
        }

        this.a(GameEvent.transportingNewUnit, var1);
        var1.a((GameEvent) GameEvent.enteredTransport, (Unit)this);
        GameEngine var2 = GameEngine.getGameEngine();
        var2.bS.l(var1);
    }

    public strictfp void D(Unit var1) {
        this.a(GameEvent.transportUnloadedOrRemovedUnit, var1);
        var1.a((GameEvent) GameEvent.leftTransport, (Unit)this);
        if (this.x.cD && this.B.size() == 0) {
            this.e(PlayerData.i);
        }

    }

    public strictfp void e(Unit var1) {
        if (var1.cN == this) {
            this.B.remove(var1);
            var1.cN = null;
            this.D(var1);
        } else {
            GameEngine.warn("Unit is not being transported");
        }

    }

    public strictfp void L() {
        if (this.x.eM != 0) {
            this.n = true;
            this.m = 30.0F;
        }
    }

    public strictfp void M() {
        if (this.x.eM != 0) {
            this.n = false;
        }
    }

    public strictfp boolean g(boolean var1) {
        if (this.B.size() == 0) {
            return false;
        } else {
            boolean var2 = this.B.size() % 2 == 0;
            Unit var3 = (Unit)this.B.remove(this.B.size() - 1);
            return this.b(var3, var1, var2);
        }
    }

    public strictfp boolean a(Unit var1, boolean var2, boolean var3) {
        this.B.remove(var1);
        return this.b(var1, var2, var3);
    }

    private strictfp boolean b(Unit var1, boolean var2, boolean var3) {
        float var4 = 180.0F;
        if (this.x.dk != null) {
            var4 = this.x.dk;
        }

        float var5 = 70.0F;
        if (this.x.dn != null) {
            var5 = this.x.dn;
        }

        float var6 = 7.0F;
        float var7 = this.x.di;
        float var8 = this.x.dj;
        float var9 = this.xCord + class_340.k(this.cg + var4) * var8 - class_340.j(this.cg + var4) * var7;
        float var10 = this.yCord + class_340.j(this.cg + var4) * var8 + class_340.k(this.cg + var4) * var7;
        var9 += class_340.k(this.cg + 90.0F) * (var3 ? -var6 : var6);
        var10 += class_340.j(this.cg + 90.0F) * (var3 ? -var6 : var6);
        if (!var2 && !this.bI()) {
            if (!class_694.a(var1, var9, var10)) {
                var9 += 10.0F;
            }

            if (!class_694.a(var1, var9, var10)) {
                var9 -= 20.0F;
            }

            if (!class_694.a(var1, var9, var10)) {
                var9 -= 10.0F;
                var10 += 10.0F;
            }

            if (!class_694.a(var1, var9, var10)) {
                var10 -= 20.0F;
            }
        }

        boolean var11;
        if (!var2 && !class_694.a(var1, var9, var10) && !this.bI()) {
            var11 = false;
        } else {
            var11 = true;
            boolean var12 = false;
            class_826 var13 = null;
            if (var1 instanceof OrderableUnit) {
                OrderableUnit var14 = (OrderableUnit)var1;
                if (var14.cO == this) {
                    var13 = var14.dn();
                    if (var13 == null) {
                        GameEngine.log("Unload, attachment data is null");
                    }

                    if (var13 != null) {
                        var12 = var13.E;
                    }
                }
            }

            class_694.a((Unit)var1, (OrderableUnit)this);
            float var16 = this.cg + var4;
            if (!var12) {
                var1.xCord = var9;
                var1.yCord = var10;
                var1.cg = var16;
                var1.cd = 0.0F;
                var1.cc = 0.0F;
                var1.bZ = 0.0F;
                var1.ca = 0.0F;
                var1.bZ += 0.1F;
            }

            var1.bR = this;
            var1.bS = 45.0F;
            if (var12) {
                var1.bS = 85.0F;
            }

            if (var1 instanceof OrderableUnit) {
                OrderableUnit var15 = (OrderableUnit)var1;
                if (!var12) {
                    var15.j(var1.cg);
                }

                if (!this.x.eW.read(this)) {
                    var15.az();
                    if (var5 != 0.0F) {
                        var15.d(var1.xCord + class_340.k(var16 + (var3 ? -var6 : var6)) * var5, var1.yCord + class_340.j(var16 + (var3 ? -var6 : var6)) * var5);
                    }

                    var15.ac = 0;
                } else {
                    var15.aH();
                }
            }

            if (!var12) {
                if (!this.x.dm) {
                    var1.zCord = this.zCord;
                }

                var1.zCord += this.x.dl;
            }

            if (var1 instanceof class_113) {
                ((class_113)var1).dF();
            }
        }

        if (!var11) {
            this.B.add(var1);
        } else {
            this.D(var1);
        }

        return var11;
    }

    public strictfp int bY() {
        return this.x.eM != 0 && this.x.x ? this.dI() : -1;
    }

    public strictfp int bZ() {
        return this.x.eM != 0 && this.x.x ? this.x.eM : -1;
    }

    public strictfp void ds() {
        if (this.B.a > 0) {
            boolean var1 = this.x.eV.read(this);
            this.h(var1);
        }

    }

    public strictfp void h(boolean var1) {
        Iterator var2 = this.B.iterator();

        while(var2.hasNext()) {
            Unit var3 = (Unit)var2.next();
            var3.cN = null;
            var3.xCord = this.xCord + class_340.k(this.cg) * -9.0F;
            var3.yCord = this.yCord + class_340.j(this.cg) * -9.0F;
            if (var1) {
                var3.cj();
            }
        }

        this.B.clear();
    }

    public strictfp void bu() {
        if (!this.bV) {
            this.a((GameEvent) GameEvent.destroyed);
        }

        Object[] var1 = this.x.h.a();

        for(int var2 = this.x.h.a - 1; var2 >= 0; --var2) {
            class_827 var3 = (class_827)var1[var2];
            var3.b(this);
        }

        super.bu();
    }

    public strictfp void a() {
        this.ds();
        Object[] var1 = this.x.h.a();

        for(int var2 = this.x.h.a - 1; var2 >= 0; --var2) {
            class_827 var3 = (class_827)var1[var2];
            var3.c(this);
        }

        PlayerData.a((Unit)this);
        this.dL.a(true);
        super.a();
    }

    public strictfp class_591 dt() {
        return this.x;
    }

    public strictfp boolean I() {
        if (this.x.aH) {
            return false;
        } else if (this.g) {
            return false;
        } else {
            return this.cO == null;
        }
    }

    public strictfp boolean aR() {
        if (this.x.dP) {
            return false;
        } else {
            class_826 var1 = this.dn();
            return var1 == null || var1.O;
        }
    }

    public strictfp boolean aS() {
        if (this.x.aH) {
            return false;
        } else {
            class_826 var1 = this.dn();
            return var1 == null || var1.H;
        }
    }

    public strictfp MovementType h() {
        return this.x.fh;
    }

    public strictfp boolean i() {
        if (this.x.fh == MovementType.AIR) {
            return this.zCord >= 4.0F;
        } else {
            return false;
        }
    }

    public strictfp boolean Q() {
        return this.zCord <= -1.0F;
    }

    public strictfp boolean cv() {
        return this.h() == MovementType.WATER;
    }

    public strictfp boolean ct() {
        return this.h() == MovementType.AIR;
    }

    public strictfp TeamImageCache v() {
        return this.bX.site != -1 && this.x.as != null ? this.x.as[this.bX.R()] : null;
    }

    public strictfp TeamImageCache d() {
        return this.bV && this.x.an != null ? this.x.an : this.x.ar[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return this.x.ap;
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && (!this.bV || this.zCord >= 1.0F) && this.zCord >= -1.0F;
    }

    public strictfp TeamImageCache d(int var1) {
        class_397 var2 = this.x.fQ[var1];
        if (var2.C != null && var2.C.read(this)) {
            return null;
        } else if (var2.aE != null) {
            return var2.aE[this.bX.R()];
        } else if (var2.aD != null) {
            return var2.aD;
        } else {
            return this.x.at != null ? this.x.at[this.bX.R()] : this.x.ao;
        }
    }

    public strictfp float h(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.aG;
    }

    public strictfp float i(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.aH;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.bI()) {
            var1.bU.a((OrderableUnit)this);
        }

        if (this.cm < 1.0F) {
            if (this.x.bx != null && this.x.bx.b()) {
                this.x.bx.a(this.xCord, this.yCord, this.zCord, this.cg, (GameObject)null);
                return false;
            } else if (this.x.by != null && this.x.by.b()) {
                this.x.by.a(this.xCord, this.yCord, this.zCord, this.cg, (GameObject)null);
                return false;
            } else {
                this.a((ExplodeType) ExplodeType.verysmall);
                return false;
            }
        } else {
            if (!this.x.fi) {
                this.S(0);
            }

            if (this.x.by != null && this.x.by.b()) {
                this.x.by.a(this.xCord, this.yCord, this.zCord, this.cg, (GameObject)null);
            }

            if (this.x.bB != -1) {
                this.a((Unit)null, this.xCord, this.yCord, this.x.bB, (class_164)null, 0);
            }

            if (this.x.bC != null) {
                PlayerData var2;
                if (this.x.bD && this.bt != null && this.bt.bX != null) {
                    var2 = this.bt.bX;
                } else {
                    var2 = this.bX;
                }

                if (!var2.E) {
                    this.x.bC.spawnUnitsAt(this.xCord, this.yCord, this.zCord, this.cg, var2, this.cG, this);
                }
            }

            this.bT = false;
            if (!this.x.fi) {
                this.ds();
            }

            if (this.x.bn) {
                boolean var7 = false;
                if (this.x.br && var1.O() && var1.netEngine.gameMapData.nukes) {
                    var7 = true;
                }

                if (!var7) {
                    Projectile var3 = NukeLaucher.a(this, this.xCord, this.yCord, this.xCord, this.yCord);
                    var3.aH = false;
                    var3.Z = this.x.bo;
                    var3.Y = this.x.bp;
                }
            }

            if (this.x.bm != 0) {
                SpreadingFire var9 = new SpreadingFire(false);
                var9.xCord = this.xCord;
                var9.yCord = this.yCord;
                var9.b(PlayerData.h);
                PlayerData.c((Unit)var9);
            }

            if (this.x.bz != null) {
                this.x.bz.a(this.xCord, this.yCord, 1.0F);
            }

            int var10;
            if (this.x.eD) {
                if (this.x.bz == null) {
                    var1.bM.a(class_648.A, 0.8F, this.xCord, this.yCord);
                }

                if (this.x.bu) {
                    if (!this.i() && !this.x.eJ) {
                        ScorchMark.a(this, 1);
                    }

                    if (this.x.bt != null) {
                        this.a((ExplodeType)this.x.bt, true);
                    } else if (this.x.bj) {
                        this.a((ExplodeType) ExplodeType.large);
                    }
                }

                if (this.x.eE) {
                    for(var10 = 0; var10 < this.bp(); ++var10) {
                        var1.bR.d(this.xCord, this.yCord, this.zCord);
                    }
                }
            } else {
                if (this.dT != null) {
                    this.dv();

                    for(var10 = 0; var10 < this.dT.length; ++var10) {
                        class_928 var8 = this.dT[var10];
                        class_431 var4 = this.x.ax[var10];
                        float var5 = this.xCord + var8.b;
                        float var6 = this.yCord + var8.c;
                        if (var4.J && !var4.p && (var4.q == null || !var4.q.read(this))) {
                            if (!class_694.d(var5, var6) && !this.x.eJ) {
                                ScorchMark.a(var5, var6);
                            }

                            var1.bR.b(var5, var6, 0.0F);
                        }
                    }
                }

                if (!this.i()) {
                    if (this.x.bu) {
                        if (this.x.bt != null) {
                            this.a((ExplodeType)this.x.bt, true);
                        } else {
                            this.a((ExplodeType) ExplodeType.small);
                        }
                    }
                } else {
                    if (this.x.bu) {
                        if (this.x.bt != null) {
                            this.a((ExplodeType)this.x.bt, false);
                        } else {
                            var1.bR.b(this.xCord, this.yCord, this.zCord);
                        }
                    }

                    for(var10 = 0; var10 < this.bp(); ++var10) {
                        var1.bR.e(this.xCord, this.yCord, this.zCord);
                    }
                }
            }

            if (this.x.fi) {
                return true;
            } else if (this.x.an != null) {
                this.M = this.x.an;
                this.a = 0;
                this.ew = true;
                return true;
            } else {
                return false;
            }
        }
    }

    public strictfp void bq() {
        if (!this.x.eJ) {
            super.bq();
        }

    }

    public strictfp void U() {
        super.U();

        for(int var1 = 0; var1 < this.x.fQ.length; ++var1) {
            class_1048 var2 = this.cL[var1];
            GameEngine.log("Dir was:" + var2.a + " for name:" + this.x.fQ[var1].a);
            GameEngine.log("lockDelay:" + var2.d + " shootCooldown:" + var2.e);
            GameEngine.log("updateAndShouldResetTurret:" + this.b(var1, 0.0F));
            float var3 = this.C(var1);
            GameEngine.log("idleDir:" + var3);
            float var4 = class_340.c(var2.a, var3, 360.0F);
            GameEngine.log("diffDir:" + var4);
        }

    }

    public strictfp void a(class_591 var1, boolean var2, boolean var3) {
        this.a(var1, var2, var3, (class_399[])null);
    }

    public strictfp void a(class_591 var1, boolean var2, boolean var3, class_399[] var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        class_591 var6 = this.x;
        class_398 var7 = this.y;
        this.x = var1;
        this.dz = this.x;
        this.y = var1.cL;
        if (var3) {
            class_398.a(this, var7, var6);
        } else if (var4 != null) {
            class_398.a(this, var7, var4);
        }

        this.bS();
        if (!var3) {
            this.j(true);
        }

        float var16;
        int var18;
        int var19;
        if (!var2) {
            if (var1.fQ.length > 1) {
                boolean var8 = true;
                class_397 var11;
                if (var1.fQ.length != var6.fQ.length) {
                    var8 = false;
                } else {
                    for(int var9 = 0; var9 < var1.fQ.length; ++var9) {
                        class_397 var10 = var1.fQ[var9];
                        var11 = var6.fQ[var9];
                        if (!var10.a.equalsIgnoreCase(var11.a)) {
                            var8 = false;
                            break;
                        }
                    }
                }

                if (!var8) {
                    class_1048[] var15 = new class_1048[var1.fQ.length];

                    for(var18 = 0; var18 < var1.fQ.length; ++var18) {
                        var11 = var1.fQ[var18];
                        class_397 var12 = var6.e(var11.a);
                        if (var12 != null) {
                            var15[var11.e] = this.cL[var12.e];
                            this.cL[var12.e] = null;
                        }
                    }

                    for(var18 = 0; var18 < var1.fQ.length; ++var18) {
                        if (var15[var18] == null) {
                            for(var19 = 0; var19 < var1.fQ.length; ++var19) {
                                if (this.cL[var19] != null) {
                                    var15[var18] = this.cL[var19];
                                    this.cL[var19] = null;
                                    break;
                                }
                            }

                            if (var15[var18] == null) {
                                var15[var18] = new class_1048();
                            }

                            var15[var18].a(this.cg);
                        }
                    }

                    this.cL = var15;
                }
            }
        } else {
            for(int var14 = 0; var14 < var1.fQ.length; ++var14) {
                var16 = this.cg + this.B(var14);
                this.cL[var14].a(var16);
            }
        }

        if (this.x.ae) {
            this.V(this.x.af);
            this.W(this.x.ag);
        } else {
            this.T(this.x.af);
            this.U(this.x.ag);
        }

        this.ew = false;
        this.cj = (float)this.x.cW;
        this.ck = (float)this.x.dd;
        if (this.bV) {
            this.a = 0;
        } else {
            this.a = this.x.Y;
        }

        this.g = false;
        if (var2) {
            this.zCord += this.x.dS;
        }

        float var17 = this.totalHealth;
        this.totalHealth = (float)this.y.c;
        if (var2) {
            this.o(this.totalHealth);
        } else if (var17 == 0.0F) {
            this.o(this.totalHealth);
        } else {
            this.o(this.health / var17 * this.totalHealth);
        }

        var16 = this.cA;
        this.cA = (float)this.y.g;
        if (this.x.cM) {
            if (this.cx > this.cA) {
                this.cx = this.cA;
            }
        } else if (var2) {
            this.cx = this.cA;
        } else if (var16 == 0.0F) {
            this.cx = this.cA;
        } else {
            this.cx = this.cx / var16 * this.cA;
        }

        if (this.x.cO) {
            if (this.cB > this.y.d) {
                this.cB = this.y.d;
            }
        } else if (var2) {
            this.cB = this.y.d * this.x.cS;
        } else if (var7.d == 0.0F) {
            this.cB = this.y.d;
        } else {
            this.cB = this.cB / var7.d * this.y.d;
        }

        if (this.bX == null) {
            this.M = this.x.ad;
        } else {
            this.S();
        }

        if (this.x.aH && var2) {
            this.cg = -90.0F;
        }

        this.f_();
        if (!var2 && (this.bx != null || this.by != null) && (!class_447.b(this.x.ch, var6.ch) || !class_447.b(this.x.cj, var6.cj))) {
            this.bx = null;
            this.by = null;
        }

        if (!var2) {
            boolean var20 = this.x.j() != var6.j();
            if (this.x.j()) {
                this.cd = 0.0F;
                this.cc = 0.0F;
                if (var6.j() && !this.x.cX.equals(var6.cX)) {
                    var20 = true;
                }
            }

            if (var20) {
                var5.bU.a((OrderableUnit)this);
            }
        }

        this.j = 1.0F;
        if (this.x.cI != -2) {
        }

        if (!this.bV) {
            this.dF();
        }

        if (this.x.eF) {
        }

        this.du();
        this.dg().a(this.x);
        if (!var2) {
            var18 = this.bl();

            for(var19 = 0; var19 < var18; ++var19) {
                class_1048 var21 = this.cL[var19];
                class_397 var13 = this.x.fQ[var19];
                if (var13 != null) {
                    if (var21.e > var13.m) {
                        var21.e = var13.m;
                    }

                    if (var21.f > var13.n) {
                        var21.f = var13.n;
                    }
                }
            }
        }

        if (!var2) {
            if (!this.x.dc) {
                this.dL.b = null;
            }

            if (this.x.fg != var6.fg) {
                this.aH();
            }
        }

        if (this.x.cD && this.B.size() == 0) {
            this.b((PlayerData)PlayerData.i);
        }

        if (this.cG && !var5.bS.i(this)) {
            var5.bS.l(this);
        }

        if (!var2) {
            Object[] var23 = this.x.h.a();

            for(var19 = this.x.h.a - 1; var19 >= 0; --var19) {
                class_827 var22 = (class_827)var23[var19];
                var22.a(this, var6);
            }

            if (this.cm >= 1.0F) {
                if (this.y.n > var7.n) {
                    this.c(false);
                }
            } else {
                var19 = var6.dh != -1 ? var6.dh : var7.n;
                int var24 = this.x.dh != -1 ? this.x.dh : this.y.n;
                if (var24 > var19) {
                    this.c(false);
                }
            }
        }

        if (this.i && this.x.dv != null) {
            this.b.a(this.x.dv, 7, true);
        }

    }

    public strictfp void f_() {
        if (this.x.aH) {
            this.bT = false;
        } else if (!this.bV) {
            this.bT = true;
            if (this.x.eC) {
                this.bT = false;
            }
        } else {
            this.bT = false;
        }

        if (this.cO != null) {
            this.bT = false;
        }

    }

    public class_113(boolean var1, class_591 var2) {
        super(var1);
        this.a(var2, true, false);
    }

    public strictfp void a(float var1) {
        boolean var2 = this.i;
        if (var2) {
            this.i = false;
            Object[] var3 = this.x.h.a();

            for(int var4 = this.x.h.a - 1; var4 >= 0; --var4) {
                class_827 var5 = (class_827)var3[var4];
                var5.a(this);
            }

            this.b(GameEvent.created);
        }

        class_591 var21 = this.x;
        super.a(var1);
        GameEngine var23;
        if (this.bV && !this.l) {
            if (this.zCord > 0.0F) {
                if (var21.fi && (this.cf != 0.0F || this.cc != 0.0F || this.cd != 0.0F)) {
                    this.f += 0.017F * var1;
                    this.zCord -= this.f * var1;
                    PointF var22 = this.n(var1);
                    this.xCord += var22.x;
                    this.yCord += var22.y;
                    if (var21.fg == MovementType.AIR) {
                        GameEngine var24 = GameEngine.getGameEngine();
                        this.dq += var1;
                        this.doo += var1;
                        class_998 var6;
                        if (var21.fj && this.dq > 9.0F) {
                            this.dq = class_340.c(1.0F, 3.0F);
                            var6 = var24.bR.b(this.xCord, this.yCord, this.zCord, class_989.CUSTOM, false, Priority.low);
                            if (var6 != null) {
                                var6.aq = 0;
                                var6.ap = 0;
                                var6.ar = 2;
                                var6.r = true;
                                var6.E = 0.5F;
                                var6.W = 60.0F;
                                var6.V = 60.0F;
                                var6.G = 0.9F;
                                var6.F = 1.2F;
                                var6.as = false;
                                var6.P = 0.0F;
                                var6.Q = 0.0F;
                            }
                        }

                        if (this.doo > 7.0F) {
                            this.doo = 0.0F;
                            var6 = var24.bR.b(this.xCord, this.yCord, this.zCord, class_989.CUSTOM, false, Priority.verylow);
                            if (var6 != null) {
                                Emitter.b(var6, true);
                                var6.I = this.xCord;
                                var6.J = this.yCord;
                                var6.K = this.zCord;
                                var6.P += class_340.c(-0.1F, 0.1F) + this.cc;
                                var6.Q += class_340.c(-0.1F, 0.1F) + this.cd;
                                var6.I += class_340.c(-4.0F, 4.0F);
                                var6.J += class_340.c(-4.0F, 4.0F);
                            }
                        }
                    }
                } else {
                    this.f += var21.dW * var1;
                    this.zCord -= this.f * var1;
                }
            } else if (!this.k) {
                this.k = true;
                if (var21.fi) {
                    this.ds();
                    this.S(0);
                    if (var21.an != null) {
                        this.M = var21.an;
                        this.a = 0;
                        this.ew = true;
                    } else {
                        this.ci();
                    }
                }

                if ((double)this.f > 0.5) {
                    if (var21.bw != null && var21.bw.a()) {
                        var21.bw.a(this.xCord, this.yCord, this.zCord, this.cg, (GameObject)null);
                    }

                    if (this.cK()) {
                        if (var21.bv) {
                            this.a((ExplodeType) ExplodeType.verysmall);
                        }

                        if (this.cJ()) {
                            GameEngine.getGameEngine().bR.a(this.xCord, this.yCord, 0.0F, 0, 0.0F, 0.0F, this.cg);
                        }
                    } else if (var21.bv) {
                        this.a((ExplodeType) ExplodeType.small);
                    }
                }

                this.f = 0.0F;
            } else if (this.cK()) {
                if (this.zCord > -10.0F) {
                    this.f += 8.0E-4F * var1;
                    this.zCord -= this.f * var1;
                    if (this.cJ()) {
                        this.t += var1;
                        if (this.t > 30.0F) {
                            this.t = 0.0F;
                            if (this.s_()) {
                                var23 = GameEngine.getGameEngine();
                                class_998 var25 = var23.bR.b(this.xCord, this.yCord, this.zCord, this.cg);
                                if (var25 != null) {
                                    var25.P = 0.0F;
                                    var25.Q = -0.1F;
                                }
                            }
                        }
                    }
                } else {
                    this.l = true;
                }
            } else {
                this.zCord = 0.0F;
                this.l = true;
            }
        }

        if (!this.bV) {
            var23 = GameEngine.getGameEngine();
            if (var21.bh != 0.0F && this.cm < 1.0F) {
                float var26 = this.cm + var21.bh * var1;
                if (var26 >= 1.0F) {
                    PlayerData.b((Unit)this);
                    this.cm = 1.0F;
                    this.cn = 1.0F;
                    PlayerData.c((Unit)this);
                } else {
                    this.cm = var26;
                    this.cn = var26;
                }
            }

            class_827 var7;
            Object[] var27;
            int var28;
            boolean var29;
            if (!this.bT()) {
                if (this.cm < 1.0F) {
                    if (var21.dw != null) {
                        this.b.a(var21.dw, 8);
                        this.b.a(var1);
                    } else if (var21.dx != null) {
                        this.b.a(var21.dx, 99);
                        this.b.b = this.cm;
                        this.b.d = 0.0F;
                        this.b.a(var1);
                    }
                }

                var27 = var21.h.a();

                for(var28 = var21.h.a - 1; var28 >= 0; --var28) {
                    var7 = (class_827)var27[var28];
                    var7.a(this, var1);
                }

                var29 = true;
                if (this.cm < 1.0F && !var21.cd || this.cN != null && !var21.cc) {
                    var29 = false;
                }

                if (var29) {
                    this.b(var1, var2);
                    var21 = this.x;
                }

            } else {
                var27 = var21.h.a();

                for(var28 = var21.h.a - 1; var28 >= 0; --var28) {
                    var7 = (class_827)var27[var28];
                    var7.b(this, var1);
                }

                var29 = this.h;
                if (var29) {
                    this.h = false;
                    this.a((GameEvent) GameEvent.completeAndActive);
                }

                if (this.y.p != 0.0F && (this.health < this.totalHealth || this.y.p < 0.0F)) {
                    this.health += this.y.p * var1;
                    if (this.health > this.totalHealth) {
                        this.health = this.totalHealth;
                    }
                }

                float var30;
                if (this.y.d != 0.0F) {
                    if (!this.v) {
                        var30 = var21.cP;
                    } else {
                        var30 = var21.cQ;
                    }

                    if (this.cB < this.y.d || var30 < 0.0F) {
                        this.cB += var30 * var1;
                    }

                    if (this.cB >= this.y.d) {
                        this.cB = this.y.d;
                        this.v = false;
                    }

                    if (this.cB <= 0.0F) {
                        if (var21.bk) {
                            this.bv();
                            return;
                        }

                        this.cB = 0.0F;
                    }
                }

                if (this.cA != 0.0F) {
                    if (this.y.h != 0.0F) {
                        this.cx += this.y.h * var1;
                        if (this.cx > this.cA) {
                            this.cx = this.cA;
                        }
                    }

                    if (this.cx < 0.0F) {
                        this.cx = 0.0F;
                    }

                    if (this.cy != 0.0F) {
                        this.cy -= this.cy * 0.02F * var1;
                        this.cy = class_340.a(this.cy, 0.0F, var21.cV * var1);
                        if (this.cy > 50.0F) {
                            this.cy = 50.0F;
                        }
                    }
                }

                this.dL.a(var1);
                var21 = this.x;
                if (var21.fp) {
                    Builder.a(var1, this);
                }

                boolean var31;
                if (var21.cn) {
                    this.o += var1;
                    if (this.o > (float)var21.cr - 0.1F) {
                        this.o -= (float)var21.cr;
                        var31 = var21.cx.read(this);
                        if (this.p != var31) {
                            PlayerData.a((Unit)this);
                            this.p = var31;
                            PlayerData.c((Unit)this);
                        }

                        if (this.p) {
                            var21.co.g(this);
                        }
                    }
                }

                if (var21.ct != null) {
                    this.q += var1;
                    if (this.q >= var21.cu) {
                        this.q = 0.0F;
                        var21.ct.writeToUnit(this);
                    }
                }

                if (this.cK) {
                    this.b.a(var21.ds, 3);
                } else if (!this.b.e || this.b.a == var21.dt) {
                    this.b.a(var21.dt, 2);
                }

                float var8;
                float var9;
                float var10;
                float var11;
                class_998 var12;
                if (var21.bL) {
                    if (var21.bJ && var23.dd) {
                        if (this.cf > 0.0F || this.cf < 0.0F && var21.bK) {
                            this.t += var1;
                        }

                        if (this.t > 10.0F) {
                            this.t = 0.0F;
                            if (this.el && this.cJ()) {
                                var30 = this.cg + 180.0F;
                                if (this.cf < 0.0F) {
                                    var30 += 180.0F;
                                }

                                var8 = this.cj - 6.0F;
                                if (var8 < 4.0F) {
                                    var8 = 4.0F;
                                }

                                var9 = this.xCord + class_340.k(var30) * var8;
                                var10 = this.yCord + class_340.j(var30) * var8;
                                var23.bR.b(var9, var10, 0.0F, var30);
                            }
                        }
                    }

                    if (var23.dc && (this.cf > 0.0F || this.cf < 0.0F) && this.el) {
                        this.d += var1;
                        if (this.d > var21.bR) {
                            this.d = 0.0F;
                            if (this.cf > 0.0F) {
                                if (var21.bO != null) {
                                    var21.bO.a(this.xCord, this.yCord, this.zCord, this.cg, this);
                                }
                            } else if (var21.bP != null) {
                                var30 = this.cg;
                                if (var21.bQ) {
                                    var30 += 180.0F;
                                }

                                var21.bP.a(this.xCord, this.yCord, this.zCord, var30, this);
                            }

                            if (var21.bM && (this.cf > 0.0F || var21.bN) && !this.cJ()) {
                                for(int var34 = 0; var34 <= 1; ++var34) {
                                    var8 = (float)(var34 == 0 ? -20 : 20);
                                    var9 = this.cg + 180.0F;
                                    if (this.cf < 0.0F) {
                                        var8 += 180.0F;
                                        var9 += 180.0F;
                                    }

                                    var9 += class_340.c(-7.0F, 7.0F);
                                    var10 = this.xCord + class_340.k(this.cg + 180.0F + var8) * (this.cj - 1.0F);
                                    var11 = this.yCord + class_340.j(this.cg + 180.0F + var8) * (this.cj - 1.0F);
                                    var12 = var23.bR.c(var10, var11, this.zCord, var9, 0);
                                    if (var12 != null) {
                                        var12.P += class_340.c(-0.15F, 0.15F);
                                        var12.Q += class_340.c(-0.15F, 0.15F);
                                    }
                                }
                            }
                        }
                    }
                }

                if (var21.eM > 0) {
                    if (var21.eY != 0.0F && this.B.a > 0) {
                        Object[] var37 = this.B.a();

                        for(int var32 = 0; var32 < this.B.a; ++var32) {
                            Unit var33 = (Unit)var37[var32];
                            if (var33.health < var33.totalHealth || var21.eY < 0.0F) {
                                var33.health += var21.eY * var1;
                                if (var33.health > var33.totalHealth) {
                                    var33.health = var33.totalHealth;
                                }
                            }
                        }
                    }

                    if (this.n && var21.fc.read(this)) {
                        this.m = class_340.a(this.m, var1);
                        if (this.m == 0.0F) {
                            this.m = var21.eN;
                            if (this.B.size() == 0) {
                                this.n = false;
                            } else {
                                this.g(false);
                                if (this.B.size() == 0) {
                                    this.n = false;
                                }
                            }
                        }
                    }
                }

                if (!this.cK) {
                    this.s += var1;
                } else {
                    this.s = 0.0F;
                }

                if (var21.fg != MovementType.AIR && this.cO == null) {
                    this.dF();
                }

                if ((var21.fg == MovementType.OVER_CLIFF || var21.fg == MovementType.OVER_CLIFF_WATER) && this.cK) {
                    if (this.cI()) {
                        this.j = 0.7F;
                    } else {
                        this.j = 1.0F;
                    }
                }

                boolean var35;
                if (var21.fg == MovementType.AIR) {
                    this.e += 2.0F * var1;
                    if (this.e > 360.0F) {
                        this.e -= 360.0F;
                    }

                    var31 = this.i();
                    var35 = false;
                    if (var21.dQ) {
                        boolean var36 = this.cK();
                        if (!this.cK && !var36 && this.s > 3.0F && (!var21.dR || this.aq())) {
                            var35 = true;
                        }
                    }

                    if (this.cO == null) {
                        if (var35) {
                            if (var21.dU < 0.0F) {
                                var9 = class_340.c(this.zCord - 2.0F) * 0.05F * 0.4F + 0.2F;
                            } else {
                                var9 = var21.dU;
                            }

                            this.zCord = class_340.a(this.zCord, 2.0F, var9 * var1);
                        } else {
                            var9 = this.y.q + class_340.j(this.e) * var21.dT;
                            if (var21.dU < 0.0F) {
                                var10 = class_340.c(this.zCord - 2.0F) * 0.05F * 0.4F + 0.2F;
                            } else {
                                var10 = var21.dU;
                            }

                            var11 = class_340.c(this.zCord - var9) * 0.05F * 0.3F + 0.1F;
                            var10 = class_340.b(var10, var11);
                            this.zCord = class_340.a(this.zCord, var9, var10 * var1);
                        }

                        if (var31 != this.i()) {
                            this.ay = true;
                            this.dF();
                        }
                    }
                } else {
                    var30 = this.y.q - var21.dT;
                    if (this.zCord < var30) {
                        this.zCord += 0.2F * var1;
                        if (this.zCord >= var30) {
                            this.zCord = var30;
                        }
                    }

                    if ((this.y.q != 0.0F || var21.dT != 0.0F || this.zCord > 0.0F) && this.cO == null) {
                        var8 = this.y.q;
                        if (var21.dT != 0.0F) {
                            this.e += 2.0F * var1;
                            if (this.e > 360.0F) {
                                this.e -= 360.0F;
                            }

                            var8 += class_340.j(this.e) * var21.dT;
                        }

                        if (var21.dU < 0.0F) {
                            var9 = class_340.c(this.zCord - 2.0F) * 0.05F * 0.4F + 0.2F;
                        } else {
                            var9 = var21.dU;
                        }

                        var10 = class_340.c(this.zCord - var8) * 0.05F * 0.3F + 0.1F;
                        var9 = class_340.b(var9, var10);
                        this.zCord = class_340.a(this.zCord, var8, var9 * var1);
                        boolean var38 = false;
                        if (this.zCord > this.y.q + var21.dT + 1.0F) {
                            this.f += var21.dV * var1;
                            if (this.zCord < 0.0F) {
                                this.f = class_340.b(this.f, 0.2F);
                            }

                            this.zCord -= this.f * var1;
                            if ((double)this.f > 1.5) {
                                this.dq += var1;
                                if ((double)this.dq > 0.5) {
                                    this.dq = 0.0F;
                                    var12 = var23.bR.b(this.xCord + class_340.c(-this.cj, this.cj), this.yCord + class_340.c(-this.cj, this.cj), this.zCord, class_989.CUSTOM, false, Priority.high);
                                    if (var12 != null) {
                                        var12.aq = 0;
                                        var12.ap = 0;
                                        var12.ar = 2;
                                        var12.r = true;
                                        var12.s = true;
                                        var12.t = 40.0F;
                                        var12.an = true;
                                        var12.P = 0.1F;
                                        var12.R = 0.0F;
                                        var12.u = true;
                                        var12.E = 0.4F;
                                        var12.W = 380.0F;
                                        var12.V = var12.W;
                                        var12.G = 0.8F;
                                        var12.F = 1.7F;
                                        var12.as = false;
                                        var12.P += class_340.c(-0.04F, 0.04F);
                                        var12.Q += class_340.c(-0.04F, 0.04F);
                                    }
                                }
                            }

                            if (this.zCord <= this.y.q + var21.dT + 1.0F) {
                                if (this.f > 2.0F) {
                                    var38 = true;
                                }

                                if (this.zCord < this.y.q + var21.dT) {
                                    this.zCord = this.y.q + var21.dT;
                                }

                                this.f = 0.0F;
                            }
                        } else {
                            if (this.f > 2.0F) {
                                var38 = true;
                            }

                            this.f = 0.0F;
                        }

                        if (var38) {
                            var12 = var23.bR.c(this.xCord, this.yCord, this.zCord, 0);
                            if (var12 != null) {
                                var12.G = 0.8F;
                                var12.F = 1.4F;
                                var12.V = 60.0F;
                                var12.W = var12.V;
                            }
                        }
                    }
                }

                var31 = false;
                var35 = false;
                if (var21.bg) {
                    var35 = true;
                }

                if (this.z != null && this.z.bg) {
                    var35 = true;
                }

                if (var35) {
                    class_226 var42 = this.dL.d();
                    boolean var39 = false;
                    if (var42 != null) {
                        if (var42 instanceof class_283) {
                            class_283 var40 = (class_283)var42;
                            class_1037 var41 = var40.a;
                            boolean var13 = false;
                            var39 = var40.L();
                            if (var41.l != null) {
                                class_31 var14 = var41.l.c();
                                if (var14 != null && var14 instanceof class_591) {
                                    var31 = true;
                                    if (var14 != var21) {
                                        if (this.z != null) {
                                            PlayerData.b((Unit)this);
                                            this.a(this.z, false, false, this.A);
                                            this.z = null;
                                            this.A = null;
                                            var21 = this.x;
                                            PlayerData.c((Unit)this);
                                        }

                                        PlayerData.b((Unit)this);
                                        this.z = var21;
                                        this.A = var41.m;
                                        this.a((class_591)var14, false, false, var41.m);
                                        var21 = this.x;
                                        PlayerData.c((Unit)this);
                                    }
                                }
                            }

                            if (var41.W != null) {
                                float var43 = var41.W;
                                float var15;
                                if (var41.Z) {
                                    var15 = this.xCord;
                                    float var16 = this.yCord;
                                    class_73 var17 = this.dL.b();
                                    if (var17 != null) {
                                        float var18 = Float.MIN_VALUE;
                                        float var19 = Float.MIN_VALUE;
                                        if (var17.i != null) {
                                            var18 = var17.i.xCord;
                                            var19 = var17.i.yCord;
                                        } else if (var17.h != null) {
                                            var18 = var17.h.x;
                                            var19 = var17.h.y;
                                        }

                                        if (var18 > Float.MIN_VALUE) {
                                            float var20 = class_340.d(var15, var16, var18, var19);
                                            var43 += var20;
                                        }
                                    }
                                }

                                if (var41.aa == null) {
                                    var15 = this.a(var1, var43, true, var41.X);
                                } else {
                                    int var44 = var41.aa.e;
                                    var15 = this.a(var1, var43, var44);
                                    class_1048 var45 = this.cL[var44];
                                    var45.b(5);
                                    var45.b = var45.a;
                                }

                                if (var41.Y && class_340.c(var15) > 5.0F) {
                                    var13 = true;
                                }
                            }

                            if (var41.V != null && !var13) {
                                this.b.a(var41.V.b(), 10);
                            }

                            if (var13) {
                                this.dL.e = 0.0F;
                            }
                        }

                        if (var21.dy != null && var42.i() != null && this.dL.e >= var21.dy.q) {
                            this.b.a(var21.dy, 5);
                        }
                    }

                    this.g = var39;
                    if (this.g) {
                        this.cc = 0.0F;
                        this.cd = 0.0F;
                        this.cf = 0.0F;
                    }
                }

                if (this.z != null && !var31) {
                    PlayerData.b((Unit)this);
                    this.a(this.z, false, false, this.A);
                    this.z = null;
                    this.A = null;
                    var21 = this.x;
                    PlayerData.c((Unit)this);
                }

                this.b.a(var1);
                this.b(var1, var2);
                var21 = this.x;
            }
        }
    }

    public strictfp float cy() {
        int var1 = this.x.co.b;
        return !this.p ? 0.0F : (float)var1 * this.x.cs;
    }

    public strictfp class_1069 cz() {
        return !this.p ? class_1069.a : this.x.cp;
    }

    public strictfp class_1069 cA() {
        return !this.p ? class_1069.a : this.x.cq;
    }

    public strictfp boolean a(int var1, Unit var2, boolean var3, boolean var4) {
        class_397 var5 = this.x.fQ[var1];
        return this.a(var5, var1, var2, var3, var4);
    }

    public final strictfp boolean a(class_397 var1, int var2, float var3, float var4, boolean var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        float var7 = class_340.a(this.xCord, this.yCord, var3, var4);
        if (var7 > var1.ae) {
            if (this.bX == var6.playerTeam) {
                var6.bS.b("Location too far");
            }

            return false;
        } else if (var7 < var1.ah) {
            if (this.bX == var6.playerTeam) {
                var6.bS.b("Location too close");
            }

            return false;
        } else {
            return true;
        }
    }

    public final strictfp boolean a(class_397 var1, int var2, Unit var3, boolean var4, boolean var5) {
        float var6;
        if (!var4 && (var1.I || var5)) {
            var6 = class_340.a(this.xCord, this.yCord, var3.xCord, var3.yCord);
            if (var6 > var1.ae) {
                return false;
            }

            if (var6 < var1.ah) {
                return false;
            }
        }

        if (!var1.H) {
            return true;
        } else {
            if (var1.ai != -1.0F) {
                if (var1.w != -1) {
                    var6 = this.cL[var1.w].a + var1.j;
                } else {
                    var6 = this.cg + var1.j;
                }

                float var7 = class_340.d(this.xCord, this.yCord, var3.xCord, var3.yCord);
                float var8 = class_340.c(var6, var7, 360.0F);
                if (class_340.c(var8) > var1.ai) {
                    return false;
                }
            }

            if (var1.N != null && !var1.N.read(this)) {
                return false;
            } else if (var1.O != null && !class_585.a(var1.O, var3.de())) {
                return false;
            } else if (var1.P != null && class_585.a(var1.P, var3.de())) {
                return false;
            } else if (var3.i()) {
                return var1.J != null ? var1.J.read(this) : true;
            } else if (var3.Q()) {
                return var1.L != null ? var1.L.read(this) : true;
            } else if (var1.M != null && !var1.M.read(this) && !var3.cH()) {
                return false;
            } else {
                return var1.K != null ? var1.K.read(this) : true;
            }
        }
    }

    public strictfp void a(Unit var1, int var2) {
        class_397 var3 = this.x.fQ[var2];
        if (var3.B) {
            if (this.a(var3, var2, var1, false, false)) {
                for(int var4 = 0; var4 < this.x.fQ.length; ++var4) {
                    class_397 var5 = this.x.fQ[var4];
                    if (var5 != null && var4 != var2 && var5.ao != null && var5.ao == var3 && this.cL[var4].e < 9000.0F - (this.shootDelay(var2) * 0.5F - var5.n)) {
                        this.cL[var4].e = 0.0F;
                    }
                }

                if (var3.w != -1) {
                    class_397 var6 = this.x.fQ[var3.w];
                    if (!var6.B && var6.p != 0.0F) {
                        this.cL[var3.w].e = this.shootDelay(var3.w) + this.t(var3.w);
                    }
                }

                this.b.a(this.x.du, 11, true);
                this.b(var3);
                this.a(var1, -1.0F, -1.0F, var2, (class_164)null, 0);
            }
        }
    }

    public strictfp boolean a(class_397 var1) {
        if (var1.u > 0.0F) {
            if (var1.u > this.cB) {
                return false;
            }

            if (this.v) {
                return false;
            }
        }

        return var1.v == null || var1.v.b((Unit)this);
    }

    public strictfp void b(class_397 var1) {
        if (var1.u > 0.0F) {
            this.cB -= var1.u;
            if (this.cB < var1.u && this.x.cR) {
                this.v = true;
            }
        }

        if (var1.v != null) {
            var1.v.a((Unit)this);
        }

    }

    public static strictfp Projectile a(Unit var0, int var1, class_164 var2, float var3, float var4, float var5, float var6) {
        Projectile var7 = Projectile.a(var0, var3, var4, var5, var1);
        a(var7, var0, var1, var2, var3, var4, var5, var6);
        return var7;
    }

    public static strictfp void a(Projectile var0, Unit var1, int var2, class_164 var3, float var4, float var5, float var6, float var7) {
        GameEngine var8 = GameEngine.getGameEngine();
        var0.az = var7;
        var0.aT = var7;
        if (var1 == null) {
            throw new RuntimeException("Source cannot be null");
        } else {
            var0.g = var3;
            var0.G = var3.aI;
            var0.aR = var3.aJ;
            var0.U = (float)var3.b;
            var0.Y = (float)var3.c;
            if (!var3.aN && var1 instanceof class_113) {
                class_113 var9 = (class_113)var1;
                var0.U *= var9.y.f;
                var0.Y *= var9.y.f;
            }

            var0.Z = (float)var3.i;
            if (var3.l) {
                var0.aa = false;
                var0.ab = true;
            } else {
                var0.aa = !var3.k;
            }

            var0.ac = var3.n;
            if (var3.m) {
                var0.ad = true;
                var0.ae = false;
            }

            var0.D = var3.p;
            var0.aY = var3.q;
            var0.aZ = var3.r;
            if ((double)var3.o < 0.5) {
                var0.C = true;
            } else {
                var0.H = var3.o;
            }

            var0.h = var3.v;
            var0.i = var3.u;
            var0.t = var3.w;
            if (var3.aM != 0.0F) {
                var0.t += class_340.a(var1, -var3.aM * 100.0F, (int)(var3.aM * 100.0F), 1) / 100.0F;
            }

            if (var3.T && var2 != -1) {
                var0.au = var1;
                if (var1 instanceof OrderableUnit) {
                    OrderableUnit var15 = (OrderableUnit)var1;
                    var0.av = var2;
                    Point3DF var10 = var15.D(var2);
                    var0.aw = var10.x;
                    var0.ax = var10.y;
                    var0.ay = var1.zCord + var10.z;
                } else {
                    var0.aw = var1.xCord;
                    var0.ax = var1.yCord;
                    var0.ay = var1.zCord;
                }
            }

            var0.w = var3.D;
            var0.u = var3.E;
            var0.v = var3.F;
            var0.af = var3.aO;
            var0.ag = var3.aP;
            var0.ah = var3.aQ;
            var0.ai = var3.aR;
            var0.ak = var3.aS;
            var0.al = var3.aT;
            var0.am = var3.aU;
            var0.an = var3.aV;
            if (var3.aW > 0.0F) {
                var0.ao = true;
                var0.W = var3.aW;
                var0.X = var0.W;
            }

            var0.ar = var3.aE;
            if (var3.aG != 0.0F) {
                float var16 = var3.aH;
                int var18 = Color.a(var0.ar);
                int var11 = (int)((float)Color.b(var0.ar) * var16);
                int var12 = (int)((float)Color.c(var0.ar) * var16);
                int var13 = (int)((float)Color.d(var0.ar) * var16);
                int var14 = var1.bX.K();
                var11 = (int)((float)var11 + (float)Color.b(var14) * var3.aG);
                var12 = (int)((float)var12 + (float)Color.c(var14) * var3.aG);
                var13 = (int)((float)var13 + (float)Color.d(var14) * var3.aG);
                var11 = class_340.b(var11, 0, 255);
                var12 = class_340.b(var12, 0, 255);
                var13 = class_340.b(var13, 0, 255);
                var0.ar = Color.a(var18, var11, var12, var13);
            }

            var0.P = var3.x;
            var0.R = var3.y;
            var0.S = !var3.A;
            var0.Q = var3.z;
            if (var3.B != null) {
                var0.P = 0;
                var0.R = 0;
            }

            var0.x = var3.aF;
            var0.m = var3.s;
            var0.A = var3.I;
            var0.M = var3.V;
            var0.B = var3.W;
            var0.aH = var3.ae;
            var0.aG = var3.aw;
            var0.aM = var3.af;
            if (var3.ai != null) {
                var3.ai.a(var0.xCord, var0.yCord, var0.zCord, var0.az, var0);
            }

            if (var3.ao != -1) {
                boolean var17 = false;
                class_998 var19 = var0.aP;
                if (var19 != null && var19.b == var0 && var19.d && var19 != null) {
                    if (var19.V < 150.0F) {
                        var19.V = 200.0F;
                    }

                    var17 = true;
                }

                if (!var17) {
                    class_998 var20 = var8.bR.a(var0, var3.ao, var3.ap);
                    if (var20 != null) {
                        if (var3.aq) {
                            var20.c = true;
                        }

                        if (var3.L) {
                            var0.aP = var20;
                        }
                    }
                }
            }

            var0.aQ = var3.ar;
            if (var3.as != -1.0F) {
                var0.aI = var3.as;
            }

            if (var3.at != -1.0F) {
                var0.aJ = var3.at;
            }

            var0.aL = -1.0F;
            if (var3.au != -1.0F) {
                var0.r = var3.au;
            }

            var0.s = var3.av;
            if (var3.aZ != null) {
            }

            var0.aE = var3.bd;
            var0.em = var1.em;
            if (var0.em < 4 && var6 >= -1.0F) {
                var0.em = 4;
            }

            if (var3.U) {
                var0.em = 1;
            }

        }
    }

    public strictfp Projectile a(Unit var1, float var2, float var3, int var4, class_164 var5, int var6) {
        GameEngine var7 = GameEngine.getGameEngine();
        class_397 var8 = this.x.fQ[var4];
        if (var8.aA != null) {
            this.b.a(var8.aA.b(), 6, true);
        }

        if (var8.aB > 0.0F) {
            this.b(var8.aB);
        }

        if (var8.aC != null) {
            PointF var9 = new PointF(var2, var3);
            var8.aC.a(this, var9, var1, var6 + 1, 0);
        }

        class_164 var16;
        if (var5 == null) {
            var16 = this.x.fR[var8.a(this)];
        } else {
            var16 = var5;
        }

        PointF var10 = this.K(var4);
        Point3DF var11 = this.D(var4);
        if (var8.aI > 0) {
            for(int var12 = 0; var12 < var8.aI; ++var12) {
                if (this.B != null && this.B.size() > 0) {
                    Unit var13 = (Unit)this.B.remove(this.B.size() - 1);
                    class_1048 var14 = this.cL[var4];
                    class_694.a((Unit)var13, (OrderableUnit)this);
                    var13.xCord = var11.x;
                    var13.yCord = var11.y;
                    var13.cg = var14.a;
                    if (var13 instanceof OrderableUnit) {
                        OrderableUnit var15 = (OrderableUnit)var13;
                        var15.az();
                        if (var1 != null) {
                            var15.n(var1);
                        } else {
                            var15.e(var2, var3);
                        }
                    }
                }
            }
        }

        Projectile var17 = null;
        if (var16.L && var5 == null) {
            if (this.G == null) {
                this.G = new Projectile[31];
            }

            if (this.G[var4] != null && !this.G[var4].ej) {
                var17 = this.G[var4];
                var17.a(this, var11.x, var11.y, this.zCord + var11.z);
                if (!var16.N && var17.ap != null) {
                    var17.ap.clear();
                }
            }
        }

        this.bC = (int)((long)this.bC + 1L + this.id);
        float var18 = this.cL[var4].a;
        boolean var19 = false;
        if (var17 == null) {
            var17 = Projectile.a(this, var11.x, var11.y, this.zCord + var11.z, var4);
            if (var16.L && var5 == null) {
                this.G[var4] = var17;
            }
        } else {
            var17.g = var16;
            var19 = true;
        }

        a(var17, this, var4, var16, var11.x, var11.y, this.zCord + var11.z, var18);
        var16.a(this, var17, var1, var2, var3, this.attackRange());
        if (!var19 && var16.R == 0.0F && var16.S == 0.0F) {
            var17.K = var10.x;
            var17.L = var10.y;
        }

        if (var8.G != null) {
            var7.bR.a(var11.x, var11.y, this.zCord + var11.z, var8.G);
        }

        if (var8.E != null) {
            var8.E.a(var11.x, var11.y, this.zCord + var11.z, this.cL[var4].a, this);
        }

        if (var8.D != null) {
            float var20 = 1.0F + class_340.c(-0.07F, 0.07F);
            var8.D.a(var11.x, var11.y, var20);
        }

        if (this.x.eg) {
            this.R = null;
        }

        if (var8.ay) {
            this.cL[var4].j = null;
        }

        if (this.x.bj && !this.bV) {
            this.bv();
        }

        if (this.x.bl && !this.bV) {
            this.a();
            this.bV = true;
        }

        return var17;
    }

    public strictfp float attackRange() {
        return this.y.i;
    }

    public strictfp int y() {
        return this.y.o != -1 ? this.y.o : super.y();
    }

    public strictfp int u(Unit var1) {
        int var2 = var1.r().a(this);
        if (this.x.aX != -1) {
            if (this.x.aY) {
                int var3 = (int)((float)this.x.aX + this.cj);
                if (var1 != null) {
                    var3 = (int)((float)var3 + var1.cj);
                }

                return var3 + var2;
            } else {
                return this.x.aX + var2;
            }
        } else {
            return this.y() + var2;
        }
    }

    public strictfp int v(Unit var1) {
        int var2 = var1.r().a(this);
        if (this.x.aZ != -1) {
            if (this.x.ba) {
                int var3 = (int)((float)this.x.aZ + this.cj);
                if (var1 != null) {
                    var3 = (int)((float)var3 + var1.cj);
                }

                return var3 + var2;
            } else {
                return this.x.aZ + var2;
            }
        } else {
            return this.y() + var2;
        }
    }

    public strictfp boolean w(Unit var1) {
        return this.x.ba;
    }

    public strictfp boolean x(Unit var1) {
        return this.x.aY;
    }

    public strictfp float cx() {
        return this.y.r;
    }

    public strictfp float c(Unit var1) {
        return this.x.bb;
    }

    public strictfp float z(Unit var1) {
        float var2 = this.x.bc;
        boolean var3 = var1.g() > 0.0F;
        if (var3) {
            var2 = var1.g() * this.x.bd;
        }

        return var2;
    }

    public strictfp float f(Unit var1) {
        return this.x.be;
    }

    public strictfp float b(Unit var1) {
        return this.x.bf;
    }

    public strictfp float speed() {
        return this.y.j * this.j;
    }

    public strictfp float aZ() {
        return this.x.ej;
    }

    public strictfp float ba() {
        return this.x.ek;
    }

    public strictfp float turnSpeed() {
        return this.y.k;
    }

    public strictfp float c(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.U != null ? var2.U : this.x.eb;
    }

    public strictfp float x(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.Q;
    }

    public strictfp float w(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.V;
    }

    public strictfp float y(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.W;
    }

    public strictfp float B() {
        return this.x.eo;
    }

    public strictfp float cD() {
        return this.x.bH * this.c;
    }

    public strictfp float p(int var1) {
        return this.x.bI;
    }

    public strictfp float d(boolean var1) {
        if (!this.x.dB) {
            return 0.0F;
        } else if (var1 && this.x.dD) {
            return this.cL[this.x.dG].a + 90.0F;
        } else {
            return this.x.dC ? this.cL[this.x.dG].a + 90.0F : super.d(var1);
        }
    }

    public strictfp PointF cY() {
        PointF var1 = H;
        class_591 var2 = this.x;
        if (var2.dC && this.cL[var2.dG].e != 0.0F) {
            class_397 var3 = var2.dF;
            if (var3.p != 0.0F) {
                var1.setSite(this.G(var2.dG));
                var1.moveAdd(-this.xCord, -this.yCord);
                return var1;
            }
        }

        var1.x = 0.0F;
        var1.y = 0.0F;
        return var1;
    }

    public strictfp PointF aP() {
        class_591 var1 = this.x;
        PointF var2 = this.cY();
        I.x = var2.x + var1.cJ;
        I.y = var2.y + var1.cK;
        return I;
    }

    public strictfp boolean c(float var1) {
        class_591 var2 = this.x;
        boolean var3 = this.bV;
        if (this.dT != null && !var3) {
            class_833.a(this, var1, false, false);
        }

        GameEngine var4 = GameEngine.getGameEngine();
        class_28 var5 = var4.bO;
        Paint var6 = this.aN();
        float var7 = this.cD();
        PointF var8 = this.cY();
        this.aQ();
        class_684 var9 = var2.i;
        int var10 = var9.a;
        Object[] var11;
        int var12;
        class_827 var13;
        if (var10 > 0) {
            var11 = var2.i.a();

            for(var12 = var10 - 1; var12 >= 0; --var12) {
                var13 = (class_827)var11[var12];
                var13.d(this, var1);
            }
        }

        float var15;
        float var16;
        float var18;
        float var20;
        float var23;
        if (this.ew) {
            var18 = this.xCord + var8.x - var4.cw;
            var20 = this.yCord + var8.y - var4.cx - this.zCord;
            if (var7 != 1.0F) {
                var5.k();
                var5.a(var7, var7, var18, var20);
            }

            var5.a(this.M, var18, var20, this.d(false) - 90.0F, var6);
            if (var7 != 1.0F) {
                var5.l();
            }
        } else {
            RectF var19 = this.cF();
            var20 = var8.x;
            var23 = var8.y - this.zCord;
            var19.a += var20;
            var19.b += var23;
            var19.c += var20;
            var19.d += var23;
            Rect var14 = this.a_(false);
            var15 = (var19.a + var19.c) * 0.5F;
            var16 = (var19.b + var19.d) * 0.5F;
            var5.k();
            if (var7 != 1.0F) {
                var5.a(var7, var7, var15, var16);
            }

            var5.a(this.d(false), var15, var16);
            var5.a(this.M, var14, var19, var6);
            var5.l();
        }

        if (var10 > 0) {
            var11 = var2.i.a();

            for(var12 = var10 - 1; var12 >= 0; --var12) {
                var13 = (class_827)var11[var12];
                var13.e(this, var1);
            }
        }

        class_694.a((OrderableUnit)this);
        if (this.dT != null && !var3 && var2.ay) {
            class_833.a(this, var1, true, false);
        }

        if (this.ak() && var2.fV != null && !var3) {
            var18 = this.cL[var2.fV.e].f / this.e(var2.fV.e);
            if (var18 != 0.0F) {
                boolean var24 = true;
                boolean var25 = this.Y();
                if (var25 && var2.bW) {
                    var24 = false;
                } else if (!var25 && var2.bS) {
                    var24 = false;
                }

                if (var24 && var2.fQ[var2.fV.e].aF == null) {
                    Point3DF var26 = this.bn();
                    var4.bO.k();
                    var4.bO.b(var26.x - var4.cw, var26.y - var26.z - var4.cx - this.zCord);
                    var4.bO.a(var18, var18);
                    if (var25) {
                        var4.bO.a((TeamImageCache) Builder.f, 0.0F, 0.0F, (Paint)null);
                    } else {
                        var4.bO.a((TeamImageCache) Builder.e, 0.0F, 0.0F, (Paint)null);
                    }

                    var4.bO.l();
                }
            }
        }

        if (var2.fP && !var3) {
            int var21 = this.bl();

            for(var12 = 0; var12 < var21; ++var12) {
                var23 = this.cL[var12].f / this.e(var12);
                class_397 var27 = var2.fQ[var12];
                if (var27 != null && var23 != 0.0F && var27.aF != null) {
                    class_694.a(this, var27.aF, var23, var12);
                }
            }
        }

        if (!var3 && this.cx > 0.0F && this.cz == 0.0F) {
            TeamImageCache var22 = this.T();
            if (var22 != null) {
                var20 = 0.0F;
                if (!var2.cU) {
                    var20 += 0.09F;
                    var20 += this.cx / this.cA * 0.4F;
                    var20 += class_340.b(this.cy, 50.0F) / 50.0F * 0.5F;
                } else {
                    var20 += class_340.b(this.cy, 50.0F) / 50.0F * 0.5F;
                    var23 = this.cy;
                    if (var23 > 5.0F) {
                        var23 = 5.0F;
                    }

                    var20 += var23 / 5.0F * 0.2F;
                }

                if (var20 > 0.0F) {
                    if (var20 > 1.0F) {
                        var20 = 1.0F;
                    }

                    if (this.J == null) {
                        this.J = class_694.a();
                    }

                    Paint var29 = this.J;
                    var29.a((int)(var20 * 255.0F), 255, 255, 255);
                    float var28 = this.xCord - var4.cw;
                    var15 = this.yCord - var4.cx - this.zCord;
                    float var17;
                    if (!var2.av) {
                        var17 = 87.0F;
                        var16 = (float)(var2.df * 2) / var17 * 1.25F;
                    } else {
                        var17 = (float)var22.p;
                        var16 = (float)(var2.df * 2) / var17 * 1.25F;
                    }

                    var4.bO.k();
                    var4.bO.a(var16, var16, var28, var15);
                    var4.bO.a(var22, var28, var15, this.d(false) - 90.0F, var29);
                    var4.bO.l();
                }
            }
        }

        if (var10 > 0) {
            var11 = var2.i.a();

            for(var12 = var10 - 1; var12 >= 0; --var12) {
                var13 = (class_827)var11[var12];
                var13.c(this, var1);
            }
        }

        return true;
    }

    public strictfp TeamImageCache T() {
        return this.x.au;
    }

    public strictfp float C() {
        return this.x.dN;
    }

    public strictfp float D() {
        return this.x.dO;
    }

    public strictfp boolean bi() {
        return this.x.dX;
    }

    public strictfp boolean bj() {
        return this.x.dY;
    }

    public strictfp boolean l() {
        return this.x.ep;
    }

    public strictfp boolean ag() {
        return this.x.er.read(this);
    }

    public strictfp boolean af() {
        return this.x.eq.read(this);
    }

    public strictfp boolean ae() {
        return this.x.es.read(this);
    }

    public strictfp boolean ah() {
        return this.x.et == null ? true : this.x.et.read(this);
    }

    public strictfp boolean k(Unit var1) {
        class_591 var2 = this.x;
        if (var2.eu) {
            if (var2.ev != null && !class_585.a(var2.ev, var1.de())) {
                return false;
            }

            if (var2.ew != null && class_585.a(var2.ew, var1.de())) {
                return false;
            }

            if (var2.ex) {
                boolean var3 = false;

                for(int var4 = 0; var4 < var2.fQ.length; ++var4) {
                    class_397 var5 = var2.fQ[var4];
                    if ((var5.P == null || !class_585.a(var5.P, var1.de())) && (var5.O == null || class_585.a(var5.O, var1.de()))) {
                        var3 = true;
                        break;
                    }
                }

                if (!var3) {
                    return false;
                }
            }
        }

        if (var1.i()) {
            return this.af();
        } else if (var1.Q()) {
            return this.ae();
        } else {
            return !this.ah() && !var1.cH() ? false : this.ag();
        }
    }

    public strictfp boolean E() {
        return this.x.ey;
    }

    public strictfp float g(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.X;
    }

    public strictfp float z(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.ab;
    }

    public strictfp float A(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.ah;
    }

    public strictfp float B(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.j;
    }

    public strictfp float C(int var1) {
        class_397 var2 = this.x.fQ[var1];
        float var3;
        if (var2.w != -1) {
            var3 = this.cL[var2.w].a;
        } else {
            var3 = this.cg;
        }

        if (this.ci && (double)this.bc() > 0.95) {
            var3 += var2.k;
        } else {
            var3 += var2.j;
        }

        return var2.ar != 0.0F ? 999.0F : var3;
    }

    public strictfp boolean bm() {
        return this.x.dL;
    }

    public strictfp float q(int var1) {
        class_397 var2 = this.x.fQ[var1];
        if (!var2.B) {
            return 0.0F;
        } else {
            class_164 var3 = this.x.fR[var2.a(this)];
            float var4 = 0.0F;
            if (!var3.s) {
                var4 += (float)var3.b;
            }

            var4 += (float)var3.c;
            if (!var3.aN) {
                var4 *= this.y.f;
            }

            return var4;
        }
    }

    public strictfp float shootDelay(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.m * this.y.e;
    }

    public strictfp float e(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.n;
    }

    public strictfp float f(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.o;
    }

    public strictfp boolean s(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.s;
    }

    public strictfp float t(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.t != 0.0F && var2.n != 0.0F ? -(var2.t * (this.cL[var1].f / var2.n)) : 0.0F;
    }

    public strictfp boolean r(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.B;
    }

    public strictfp void b(Unit var1, int var2) {
        class_397 var3 = this.x.fQ[var2];
        if (var3.F != null) {
            PointF var4 = this.E(var2);
            var3.F.a(var4.x, var4.y, this.zCord, this.cL[var2].a, this);
        }

    }

    public strictfp boolean u(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return !this.a(var2) ? false : super.u(var1);
    }

    public strictfp int s(Unit var1) {
        return this.x.eB;
    }

    public strictfp boolean bO() {
        return this.x.eD;
    }

    public strictfp boolean bP() {
        return this.x.eE;
    }

    public strictfp float mass() {
        return this.y.b;
    }

    public strictfp boolean cG() {
        return this.x.aq;
    }

    public strictfp Rect a_(boolean var1) {
        if (var1 && !this.x.aq) {
            return super.a_(var1);
        } else if (this.bV) {
            return super.a_(var1);
        } else {
            class_591 var2 = this.x;
            int var3 = this.a;
            int var4 = 0;
            class_590 var5 = var2.dI;
            if (this.b.a != null && this.b.a.k != null) {
                var5 = this.b.a.k;
            }

            if (var5 != null) {
                float var6 = var5.b;
                float var7;
                if (var6 < 0.0F) {
                    var6 = -var6;
                    var7 = -this.cg;
                    if (var5.a) {
                        var7 = -this.cL[var2.dG].a;
                    }
                } else {
                    var7 = this.cg;
                    if (var5.a) {
                        var7 = this.cL[var2.dG].a;
                    }
                }

                int var8 = (int)((var7 - var5.e - var6 * 0.5F) / var6);
                int var9 = (int)(360.0F / var6);
                var8 %= var9;
                if (var8 < 0) {
                    var8 += var9;
                }

                if (var5.c > 0) {
                    var3 += var8 * var5.c;
                }

                if (var5.d > 0) {
                    var4 += var8 * var5.d;
                }
            }

            if (var3 >= var2.V) {
                var4 += var3 / var2.V;
                var3 %= var2.V;
            }

            return super.a(var1, var3, var4);
        }
    }

    public strictfp RectF cF() {
        RectF var1 = super.cF();
        if (this.x.ak) {
            var1.a((float)this.x.ah, (float)this.x.ai - this.x.aj);
        }

        return var1;
    }

    public strictfp int bl() {
        return this.x == null ? 1 : this.x.fQ.length;
    }

    public strictfp int v(int var1) {
        return this.x.fQ[var1].x;
    }

    public strictfp Point3DF F(int var1) {
        return this.a(var1, false);
    }

    public strictfp PointF G(int var1) {
        Point3DF var2 = this.a(var1, false);
        K.x = var2.x;
        K.y = var2.y;
        return K;
    }

    public strictfp Point3DF a(int var1, boolean var2) {
        class_397 var3 = this.x.fQ[var1];
        float var4;
        float var5;
        float var6;
        float var7;
        if (var3.w == -1) {
            var4 = this.xCord;
            var5 = this.yCord;
            var6 = 0.0F;
            var7 = this.cg;
        } else {
            if (var2) {
                throw new RuntimeException("Turret can not be attached to turret that is not attached to the body");
            }

            Point3DF var8 = this.a(var3.w, true);
            var4 = var8.x;
            var5 = var8.y;
            var6 = var8.z;
            var7 = this.cL[var3.w].a;
        }

        float var9;
        float var13;
        if (this.cL[var1].e > 0.0F && var3.p != 0.0F) {
            var13 = 0.0F;
            var9 = this.shootDelay(var1) + this.t(var1) - this.cL[var1].e;
            if (var9 < var3.q) {
                var13 = var9 / var3.q * var3.p;
            } else if (var9 < var3.q + var3.r) {
                var13 = var3.p - (var9 - var3.q) / var3.r * var3.p;
            }

            if (var13 != 0.0F) {
                var4 += class_340.k(this.cL[var1].a) * var13;
                var5 += class_340.j(this.cL[var1].a) * var13;
            }
        }

        var13 = var3.f;
        var9 = var3.g;
        float var10 = var3.h;
        if (var13 != 0.0F || var9 != 0.0F) {
            float var11 = class_340.j(var7);
            float var12 = class_340.k(var7);
            var4 += var12 * var9 - var11 * var13;
            var5 += (var11 * var9 + var12 * var13) * var3.i;
        }

        var6 += var10;
        dK.x = var4;
        dK.y = var5;
        dK.z = var6;
        return dK;
    }

    public strictfp ArrayList N() {
        return this.z != null ? this.z.a(this.V()) : this.x.a(this.V());
    }

    public strictfp class_226 a(class_1059 var1) {
        class_591 var2;
        if (this.z != null) {
            var2 = this.z;
        } else {
            var2 = this.x;
        }

        return var2.a(var1);
    }

    public strictfp int V() {
        return this.x.cl;
    }

    public strictfp class_226 e(class_31 var1) {
        return this.dL.b(var1);
    }

    public strictfp void a(class_226 var1, boolean var2, PointF var3, Unit var4) {
        if (var1 == Hovercraft.i) {
            if (!var2) {
                this.L();
            } else {
                this.M();
            }

        } else if (var1 == Hovercraft.j) {
            if (!var2) {
                this.M();
            }

        } else {
            class_283 var5;
            if (!var2) {
                if (var3 != null && !this.a(var1, var3.x, var3.y)) {
                    return;
                }

                if (var1 instanceof class_283) {
                    var5 = (class_283)var1;
                    if (var5.a.ax != null) {
                        GameEngine var6 = GameEngine.getGameEngine();
                        if (this.bX == var6.playerTeam && !var6.I()) {
                            var5.a.ax.a();
                        }
                    }

                    if (var5.a.at != null) {
                        var5.a.at.a(this.xCord, this.yCord, this.zCord, this.cg, this);
                    }
                }
            }

            if (var2 && var1 instanceof class_283) {
                var5 = (class_283)var1;
                if (!var5.a.M) {
                    return;
                }
            }

            class_73 var7 = this.dL.a(var1, var2, var3, var4);
            if (!var2) {
                if (var7 != null) {
                    class_588 var8 = var1.P();
                    this.a(GameEvent.queueItemAdded, (Unit)null, var8, (VariableScope)null);
                }
            } else if (var7 != null) {
                this.a(GameEvent.queueItemCancelled, (Unit)null, var1.P(), (VariableScope)null);
            }

        }
    }

    public strictfp void a(class_226 var1, boolean var2) {
        this.a(var1, var2, (PointF)null, (Unit)null);
    }

    public strictfp void b(class_226 var1, boolean var2) {
        this.dL.a(var1, var2);
    }

    public strictfp void a(class_226 var1) {
        this.dL.a(var1);
    }

    public strictfp boolean a(class_226 var1, float var2, float var3) {
        if (var1 instanceof class_283) {
            GameEngine var4 = GameEngine.getGameEngine();
            class_283 var5 = (class_283)var1;
            if (var5.a.ag != null && var5.a.ah == null) {
                if (var5.a.ag >= this.x.fQ.length) {
                    this.a((String)("checkTargetedActionOrder: " + var5.a.ag + " larger than max turret size"));
                    return true;
                }

                class_397 var6 = this.x.fQ[var5.a.ag];
                boolean var7 = true;
                if (!this.a(var6, var5.a.ag, var2, var3, var7)) {
                    return false;
                }

                if (var5.a.al != null && class_694.a(var2, var3, var5.a.al)) {
                    if (this.bX == var4.playerTeam) {
                        var4.bS.b("Invalid map location (Must be passable by " + var5.a.al.name() + ")");
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public strictfp void a(class_226 var1, boolean var2, float var3, float var4) {
        if (var1 instanceof class_283) {
            class_226 var5 = this.a(var1.N());
            if (var5 != null) {
                class_283 var6 = (class_283)var5;
                Integer var7 = var6.a.ag;
                if (var7 != null && var6.a.ah == null && var7 < this.x.fQ.length) {
                    class_397 var8 = this.x.fQ[var7];
                    if (var8.ag > 0.0F) {
                        class_694.b(this, var8.ag, true);
                    }

                    class_694.a(this, var8.ad, true, true);
                }

                if (var2 && var6.a.am != null) {
                    var6.a.am.a(this, var3, var4);
                }
            }
        }

        super.a(var1, var2, var3, var4);
    }

    public strictfp boolean a(class_226 var1, PointF var2, Unit var3, int var4, int var5) {
        PointF var6 = null;
        Unit var7 = null;
        int var8 = 0;
        if (var4 > 0) {
            var6 = dM;
            var7 = dN;
            var8 = dO;
        }

        dM = var2;
        dN = var3;
        dO = var5;
        boolean var9 = this.a(var1, var2, var3, var4);
        dM = var6;
        dN = var7;
        dO = var8;
        return var9;
    }

    public strictfp boolean a(class_226 var1, PointF var2, Unit var3, int var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        if (var4 > 10) {
            return false;
        } else {
            var1.a((Unit)this, (Unit)var3);
            if (var1 instanceof class_283) {
                class_283 var6 = (class_283)var1;
                class_1037 var7 = var6.a;
                if (var7.t != null && !var7.t.read(this)) {
                    return true;
                } else {
                    boolean var8 = false;
                    if (var7.ad != null) {
                        this.cB += var6.a.ad;
                        var8 = true;
                    }

                    if (var7.ae != null) {
                        var7.ae.h(this);
                        var8 = true;
                    }

                    if (var7.af != null) {
                        var7.af.a(this, (double)this.bX.E(), true);
                        var8 = true;
                    }

                    if (var7.aH != null) {
                        if (var7.aH.read(this)) {
                            this.bA = var5.by;
                        }

                        var8 = true;
                    }

                    PointF var9;
                    int var10;
                    float var13;
                    float var14;
                    if (var7.ag != null) {
                        var9 = var2;

                        for(var10 = 0; var10 < var7.ak; ++var10) {
                            if (var7.ah != null) {
                                var9 = new PointF();
                                if (var7.ai == null) {
                                    var9.setSite(this.xCord, this.yCord);
                                } else {
                                    Unit var11 = var7.ai.readUnit(this);
                                    if (var11 != null) {
                                        var9.setSite(var11.xCord, var11.yCord);
                                    } else {
                                        var9.setSite(this.xCord, this.yCord);
                                    }
                                }

                                float var18 = class_340.k(this.cg);
                                float var12 = class_340.j(this.cg);
                                var13 = var7.ah.x;
                                var14 = var7.ah.y;
                                float var15 = var18 * var14 - var12 * var13;
                                float var16 = var12 * var14 + var18 * var13;
                                var9.moveAdd(var15, var16);
                            }

                            if (var9 == null) {
                                GameNetEngine.g("completeQueueItem:" + var6.N() + " for fireTurretXAtGround needs points but it is missing");
                            } else {
                                this.a((Unit)null, var9.x, var9.y, var6.a.ag, var6.a.aj, var4);
                            }
                        }

                        var8 = true;
                    }

                    if (var7.as != null) {
                        var7.as.a(this.xCord, this.yCord, this.zCord, this.cg, this);
                        var8 = true;
                    }

                    if (var7.au != null) {
                        var7.au.a(this.xCord, this.yCord, 1.0F);
                        var8 = true;
                    }

                    if (var7.av != null && !var5.I()) {
                        var7.av.a();
                        var8 = true;
                    }

                    if (var7.aw != null) {
                        if (this.bX == var5.playerTeam && !var5.I()) {
                            var7.aw.a();
                        }

                        var8 = true;
                    }

                    if (var7.ac.a > 0) {
                        Object[] var17 = var7.ac.a();

                        for(var10 = 0; var10 < var7.ac.a; ++var10) {
                            class_776 var20 = (class_776)var17[var10];
                            if (var20.a(this, var1, var2, var3, var4)) {
                                var8 = true;
                            }
                        }
                    }

                    var9 = var2;
                    Unit var19 = var3;
                    if ((var7.ap != null || var6.a.aq != null) && var7.an != null) {
                        var19 = var7.an.readUnit(this);
                        var9 = new PointF();
                        if (var19 != null) {
                            var9.x = var19.xCord;
                            var9.y = var19.yCord;
                        } else {
                            var9.x = this.xCord;
                            var9.y = this.yCord;
                        }
                    }

                    if (var7.ap != null) {
                        if (var7.ao == null || var7.ao.read(this)) {
                            int var21 = 1;
                            if (var7.ar != null) {
                                var21 = (int)var7.ar.readNumber(this);
                                if (var21 > 10000) {
                                    var21 = 10000;
                                }
                            }

                            for(int var22 = 0; var22 < var21; ++var22) {
                                var6.a.ap.a(this, var9, var19, var4 + 1, var22);
                            }
                        }

                        var8 = true;
                    }

                    if (var6.a.aq != null) {
                        if (var7.ao == null || var7.ao.read(this)) {
                            var6.a.aq.a(this, var9, var19);
                        }

                        var8 = true;
                    }

                    class_31 var24 = null;
                    if (var7.H != null) {
                        var24 = var7.H.c();
                    }

                    if (var24 != null) {
                        if (GameEngine.aw) {
                            String var23 = this.c() + ": converting unit: " + var1.O();
                            GameEngine.print(var23);
                        }

                        if (!(var24 instanceof class_591)) {
                            Unit var25 = var24.a();
                            var25.xCord = this.xCord;
                            var25.yCord = this.yCord;
                            if (!var25.bI()) {
                                var25.cg = this.cg;
                            }

                            var25.f(this.bX);
                            var25.B((Unit)null);
                            var13 = this.totalHealth;
                            var14 = var25.totalHealth;
                            if (var13 == 0.0F) {
                                var25.o(var25.totalHealth);
                            } else {
                                var25.o(this.health / var13 * var14);
                            }

                            if (this.cG) {
                                GameEngine.getGameEngine().bS.k(var25);
                            }

                            PlayerData.c(var25);
                            this.ci();
                        } else {
                            class_588 var26 = null;
                            if (var7.Q) {
                                var26 = this.de();
                            }

                            PlayerData.b((Unit)this);
                            this.z = null;
                            this.a((class_591)var24, false, false, var7.R);
                            if (var26 != null) {
                                this.a(var26, true);
                            }

                            this.S();
                            this.dL.e();
                            this.bB = GameEngine.getGameEngine().by;
                            PlayerData.c((Unit)this);
                        }

                        var8 = true;
                        if (!var6.B().c()) {
                            this.W();
                        }
                    }

                    if (!var8 && var7.n) {
                        GameEngine.log("completeQueueItem:" + var6.N() + " had no effect (but should have)");
                    }

                    return true;
                }
            } else {
                return false;
            }
        }
    }

    public strictfp void b(class_73 var1) {
        class_226 var2 = this.a(var1.j);
        if (var2 != null && var2 instanceof class_283) {
            class_283 var3 = (class_283)var2;
            class_1037 var4 = var3.a;
            if (var4.ab != null) {
                ec.x = this.xCord;
                ec.y = this.yCord;
                PointF var5 = ec;
                Object var6 = null;
                var4.ab.a(this, var5, (Unit)var6, 0, 0);
            }
        }

    }

    public strictfp boolean c(class_73 var1) {
        return true;
    }

    public strictfp void i(boolean var1) {
        this.dL.a(var1);
    }

    public strictfp void a(class_73 var1) {
        class_226 var2 = this.a(var1.j);
        if (var2 != null) {
            boolean var3 = this.a(var2, var1.h, var1.i, 0, 0);
            if (var3) {
                return;
            }
        }

        float var6 = 0.0F;
        if (this.x.aH && this.x.dk != null) {
            var6 = this.cg + this.x.dk;
            var6 += 90.0F;
        }

        float var4;
        if (this.x.dn != null) {
            var4 = this.x.dn;
        } else if (this.dL.b != null) {
            var4 = this.cj * 3.0F;
        } else {
            var4 = this.cj * 2.0F;
        }

        Unit var5 = this.dL.a(var1, var4, this.r, var6);
        if (var5 != null) {
            this.F(var5);
            PlayerData.c(var5);
            this.a(GameEvent.queuedUnitFinished, var5);
        }

    }

    public strictfp void E(Unit var1) {
        float var2 = 0.0F;
        if (this.x.aH && this.x.dk != null) {
            var2 = this.cg + this.x.dk;
            var2 += 90.0F;
        }

        var1.cg = 90.0F + var2;
        float var3 = 70.0F;
        if (this.x.dn != null) {
            var3 = this.x.dn;
        }

        this.dL.a(var1, var3, this.r);
    }

    public strictfp void F(Unit var1) {
        var1.xCord = this.xCord + this.x.di;
        var1.yCord = this.yCord + this.x.dj;
        if (!this.x.aH) {
            float var2 = 180.0F;
            if (this.x.dk != null) {
                var2 = this.x.dk;
            }

            float var3 = 70.0F;
            if (this.x.dn != null) {
                var3 = this.x.dn;
            }

            float var4 = 7.0F;
            boolean var5 = Hovercraft.a(this, var1, this.r, var4, var2, var3, this.x.di, this.x.dj);
            if (!this.x.dm) {
                var1.zCord = this.zCord;
            }

            var1.zCord += this.x.dl;
            if (var1 instanceof class_113) {
                ((class_113)var1).dF();
            }

            if ((this.i() || !var5 || this.x.eU.read(this)) && this.cr()) {
                this.C(var1);
            }
        }

        this.r = !this.r;
    }

    public strictfp class_447 by() {
        class_684 var1 = this.dL.g();
        int var2 = var1.size();
        if (var2 == 0) {
            return class_447.a;
        } else {
            class_447 var3 = new class_447();
            Object[] var4 = var1.a();

            for(int var5 = 0; var5 < var2; ++var5) {
                class_73 var6 = (class_73)var4[var5];
                class_226 var7 = this.a(var6.j);
                if (var7 != null && var7 instanceof class_283) {
                    class_283 var8 = (class_283)var7;
                    if (var8.a.ad != null) {
                        var3.c += var8.a.ad;
                    }

                    class_447 var9;
                    if (var8.a.ae != null) {
                        var9 = var8.a.ae;
                        if (!var9.c()) {
                            var3 = class_447.a(var3, var9);
                        }
                    }

                    if (var8.a.af != null) {
                        var9 = var8.a.af;
                        if (!var9.c()) {
                            var3 = class_447.a(var3, var9);
                        }
                    }
                }
            }

            return var3;
        }
    }

    public strictfp boolean dA() {
        if (this.x.eM > 0) {
            return this.dI() > this.x.eM;
        } else {
            return false;
        }
    }

    public strictfp int h(class_31 var1) {
        return this.dL.a(var1);
    }

    public strictfp int f(boolean var1) {
        return this.dL.a(class_226.i, var1, true);
    }

    public strictfp int a(class_1059 var1, boolean var2) {
        return this.dL.a(var1, var2);
    }

    public strictfp class_73 dw() {
        return this.dL.b();
    }

    public strictfp class_447 bD() {
        return this.dL.c();
    }

    public strictfp class_684 dx() {
        return this.dL.c;
    }

    public strictfp void dz() {
        this.dL.e = 1.0F;
    }

    public strictfp boolean dy() {
        return this.dL.a();
    }

    public strictfp int a(class_585 var1) {
        return this.dL.a(var1);
    }

    public strictfp void a(PointF var1) {
        if (this.x.dc) {
            this.dL.b = var1;
        }

    }

    public strictfp float x() {
        return !this.x.t ? -1.0F : super.x();
    }

    public strictfp boolean bU() {
        return this.x.u;
    }

    public strictfp float bV() {
        return this.bT() && !this.dL.a() && this.x.z ? this.dL.e : super.bV();
    }

    public strictfp float bW() {
        if (this.y.d > 0.0F && this.cB < this.y.d && this.x.v) {
            return this.cB / this.y.d;
        } else if (this.cA > 0.0F && this.cx < this.cA && this.x.y) {
            return this.cx / this.cA;
        } else {
            if (this.y.d == 0.0F && this.cA == 0.0F) {
                if (this.x.em != -1 && this.cL[this.x.em].e > 0.0F) {
                    return 1.0F - this.cL[this.x.em].e / this.shootDelay(this.x.em);
                }

                if (this.x.en != -1 && this.cL[this.x.en].f != 0.0F) {
                    return this.cL[this.x.en].f / this.e(this.x.en);
                }
            }

            return super.bW();
        }
    }

    public strictfp boolean f(float var1) {
        return super.f(var1);
    }

    public strictfp void p(float var1) {
        class_684 var2 = this.x.i;
        int var3 = var2.a;
        if (var3 > 0) {
            Object[] var4 = this.x.i.a();

            for(int var5 = var3 - 1; var5 >= 0; --var5) {
                class_827 var6 = (class_827)var4[var5];
                var6.f(this, var1);
            }
        }

        super.p(var1);
    }

    public strictfp void e(float var1) {
        super.e(var1);
    }

    public strictfp void ca() {
        if (this.dL.b != null) {
            GameEngine var1 = GameEngine.getGameEngine();
            float var2 = (float)((int)(this.xCord - var1.cw));
            float var3 = (float)((int)(this.yCord - var1.cx));
            float var4 = (float)((int)(this.dL.b.x - var1.cw));
            float var5 = (float)((int)(this.dL.b.y - var1.cx));
            var1.bO.a(var2, var3, var4, var5, class_91.y);
        }

    }

    public strictfp void cb() {
        boolean var1 = true;
        boolean var2 = false;
        float var3;
        if (this.y.i > 70.0F && this.x.ep && this.x.dK == null || this.x.dK != null && this.x.dK) {
            var3 = this.attackRange();
            class_694.a(this, var3, var1);
            var2 = true;
        } else if (this.x.aH && this.y.o > 50 && !this.x.ep) {
            var3 = (float)this.y.o;
            class_694.a(this, var3, var1);
            var2 = true;
        }

        if (this.x.o.size() != 0) {
            for(Iterator var7 = this.x.o.iterator(); var7.hasNext(); var2 = true) {
                class_604 var4 = (class_604)var7.next();
                class_694.a(this, var4.a, var1);
            }
        }

        if (this.x.bF) {
            int var8 = this.bl();

            for(int var9 = 0; var9 < var8; ++var9) {
                class_397 var5 = this.x.fQ[var9];
                if (var5.ak != null && var5.al > 0.0F) {
                    byte var6 = 90;
                    if (var2) {
                        var6 = 40;
                    }

                    class_694.a(this, var5.al, Color.a(var6, 35, 235, 35), 1, var1);
                }
            }
        }

    }

    public strictfp void d(float var1) {
        super.d(var1);
        if (!this.bV) {
            this.dI.a(var1, this);
            if (this.x.al != null) {
                GameEngine var2 = GameEngine.getGameEngine();
                byte var3 = 0;
                byte var4 = 0;
                float var5 = this.xCord - var2.cw;
                float var6 = this.yCord - var2.cx - this.zCord;
                float var7 = this.cD();
                if (var7 != 1.0F) {
                    var2.bO.k();
                    var2.bO.a(var7, var7, var5, var6);
                }

                if (this.x.am) {
                    int var8 = this.x.al.p;
                    int var9 = this.x.al.q;
                    int var10 = var8 / 2;
                    int var11 = var9 / 2;
                    du.a(var5 - (float)var10, var6 - (float)var11, var5 + (float)var10, var6 + (float)var11);
                    dv.a(var3, var4, var3 + var8, var4 + var9);
                } else {
                    du.a(var5 - this.eu, var6 - this.ev, var5 + this.eu, var6 + this.ev);
                    dv.a(var3, var4, var3 + this.es, var4 + this.et);
                }

                var2.bO.a(this.x.al, dv, du, this.aN());
                if (var7 != 1.0F) {
                    var2.bO.l();
                }
            }

            if (this.x.az && this.dT != null && !this.bV) {
                class_833.a(this, var1, false, true);
            }

        }
    }

    public strictfp float aM() {
        return this.x.dH;
    }

    public strictfp Paint aN() {
        Paint var1 = super.aN();
        return var1;
    }

    public strictfp boolean aV() {
        return this.x.eF;
    }

    public strictfp boolean bI() {
        return this.x.aH;
    }

    public strictfp boolean q() {
        return this.cO != null && this.cO.cm < 1.0F ? true : this.x.aK;
    }

    private strictfp boolean H(Unit var1) {
        if (var1.q()) {
            return false;
        } else if (var1 == this) {
            return false;
        } else {
            if (var1.bI()) {
                if (this.x.aU) {
                    return true;
                }
            } else if (this.x.aV) {
                return true;
            }

            return false;
        }
    }

    public strictfp boolean a(Unit var1) {
        return this.x.fo != null && !class_585.a(this.x.fo, var1.de()) ? false : this.H(var1);
    }

    public strictfp boolean l(Unit var1) {
        if (var1.g() != 0.0F && this.h(var1, true)) {
            return true;
        } else {
            return this.x.fn != null && !class_585.a(this.x.fn, var1.de()) ? false : this.H(var1);
        }
    }

    public strictfp void m(Unit var1) {
        if (this.x.bi) {
            class_1042 var2 = this.ar();
            if (var2 != null) {
                class_984 var3 = var2.i;
                if (var3 != null) {
                    var3.a(var2);
                }
            }

            if (this.cG && var1 != null) {
                GameEngine.getGameEngine().bS.k(var1);
            }

            this.ci();
        }

    }

    public strictfp boolean al() {
        return this.x.bi;
    }

    public strictfp boolean aj() {
        return this.x.fq;
    }

    public strictfp boolean cu() {
        return this.x.fN;
    }

    public strictfp boolean ak() {
        return this.x.fp;
    }

    public strictfp boolean g(Unit var1, boolean var2) {
        if (!this.h(var1, var2)) {
            return false;
        } else {
            return !var2 || !var1.c((OrderableUnit)this);
        }
    }

    public strictfp boolean h(Unit var1, boolean var2) {
        if (!this.x.fk) {
            return false;
        } else {
            return this.x.fl == null || class_585.a(this.x.fl, var1.de());
        }
    }

    public strictfp int cS() {
        return this.x.fm;
    }

    public strictfp boolean bJ() {
        return this.x.fu;
    }

    public strictfp void a(float var1, boolean var2) {
        super.a(var1, var2);
        if (!this.bV && this.ak()) {
            if (this.Y()) {
                if (!this.x.bW) {
                    Builder.b(var1, this);
                }
            } else if (!this.x.bS) {
                Builder.b(var1, this);
            }
        }

    }

    public strictfp boolean o() {
        return this.x.cy;
    }

    public strictfp boolean p() {
        return this.x.cz;
    }

    public strictfp boolean cO() {
        return this.x.cA;
    }

    public strictfp void f(PlayerData var1) {
        if (this.x.cE) {
            this.b((PlayerData)PlayerData.h);
        } else if (this.x.cD && this.B.size() == 0) {
            this.b((PlayerData)PlayerData.i);
        } else {
            super.f(var1);
        }
    }

    public strictfp void B(Unit var1) {
        super.B(var1);
    }

    public strictfp float g() {
        return this.x.cF;
    }

    public strictfp int cQ() {
        return this.x.cG;
    }

    public strictfp class_588 cR() {
        return this.x.cH;
    }

    public strictfp void cP() {
        if (this.x.bh == 0.0F && this.g() > 0.0F) {
            PlayerData.b((Unit)this);
            this.cm = 1.0F;
            PlayerData.c((Unit)this);
        }

    }

    public strictfp class_1059 cp() {
        return this.x.eM != 0 ? Hovercraft.i.N() : super.cp();
    }

    public strictfp float L(int var1) {
        return this.x.fQ[var1].af;
    }

    public strictfp PointF K(int var1) {
        PointF var2 = super.K(var1);
        if (this.x.eA) {
            class_397 var3 = this.x.fQ[var1];
            class_164 var4 = this.x.fR[var3.a(this)];
            if (var4.M && this.G != null) {
                Projectile var5 = this.G[var1];
                if (var5 != null && !var5.ej) {
                    var2.x += var5.K;
                    var2.y += var5.L;
                }
            }
        }

        return var2;
    }

    public strictfp float bd() {
        return this.y.d;
    }

    public strictfp AttackMovementType be() {
        return this.x.ec;
    }

    public strictfp boolean bf() {
        if (this.x.ef) {
            return false;
        } else if (this.x.ec != AttackMovementType.BOMBER) {
            return true;
        } else {
            class_1042 var1 = this.ar();
            if (var1 != null && (var1.d() == WaypointType.attackMove || var1.d() == WaypointType.patrol)) {
                return true;
            } else {
                return this.P == AttackMode.outOfRange;
            }
        }
    }

    public strictfp boolean bX() {
        return this.v;
    }

    public strictfp boolean bg() {
        return this.x.ei;
    }

    public strictfp float bc() {
        return this.x.el;
    }

    public strictfp void f(float var1, float var2) {
        super.f(var1, var2);
        this.a((GameEvent) GameEvent.teleported);
        float var3 = this.cg;
        if (this.x.dE) {
            var3 = this.cL[this.x.dG].a;
        }

        this.dP = this.xCord;
        this.dQ = this.yCord;
        this.dR = this.zCord;
        this.dS = var3;
    }

    public strictfp void du() {
        if (this.x.ax != null || this.dT != null) {
            if (this.x.ax != null && this.x.ax.length != 0) {
                if (this.dT == null || this.dT.length != this.x.ax.length) {
                    this.dT = new class_928[this.x.ax.length];

                    for(int var1 = 0; var1 < this.x.ax.length; ++var1) {
                        class_928 var2 = new class_928();
                        this.dT[var1] = var2;
                        var2.a = var1;
                        var2.s = this.x.ax[var1].r;
                    }

                    float var3 = this.cg;
                    if (this.x.dE) {
                        var3 = this.cL[this.x.dG].a;
                    }

                    this.dP = this.xCord;
                    this.dQ = this.yCord;
                    this.dR = this.zCord;
                    this.dS = var3;
                    this.dv();

                    for(int var4 = 0; var4 < this.x.ax.length; ++var4) {
                        this.dT[var4].m = true;
                    }

                }
            } else {
                this.dT = null;
            }
        }
    }

    public strictfp void dv() {
        class_833.a.b(this, 0.0F);
    }

    public strictfp void dB() {
        if (this.dT != null) {
            for(int var1 = 0; var1 < this.dT.length; ++var1) {
                this.dT[var1].n = true;
                this.dT[var1].m = true;
            }

            this.dv();
        }

    }

    public strictfp int aT() {
        return this.x.fV == null ? -1 : this.x.fV.e;
    }

    public strictfp int s() {
        return this.y.n;
    }

    public strictfp void c(boolean var1) {
        class_591 var2 = this.x;
        GameEngine var3 = GameEngine.getGameEngine();
        if (this.cN == null && this.cO == null) {
            int var4 = this.y.n;
            if (this.cm < 1.0F && var2.dh != -1) {
                var4 = var2.dh;
            }

            if (var4 > 0) {
                var3.bL.a(this.xCord, this.yCord, var4, this.bX, var1);
            }

        }
    }

    public strictfp Rect cc() {
        return this.x.cX;
    }

    public strictfp Rect ce() {
        return this.x.cZ;
    }

    public strictfp Rect cd() {
        return this.x.cY;
    }

    public strictfp boolean b(int var1, float var2) {
        class_397 var3 = this.x.fQ[var1];
        if (var3.as != 0.0F) {
            boolean var4 = true;
            if (var3.av != null && !var3.av.read(this)) {
                var4 = false;
            }

            if (var4) {
                class_1048 var5 = this.cL[var1];
                float var6;
                if (var3.ar != 0.0F) {
                    var6 = var5.a;
                } else if (!var3.aq) {
                    var6 = var5.b;
                } else {
                    var6 = this.C(var1);
                }

                var5.k += var2;
                float var7 = var2 * var3.au;
                float var8;
                if (var5.l > 0.0F) {
                    if (var5.l < Float.POSITIVE_INFINITY) {
                        var8 = this.a(var7, var6 + var5.l, var1);
                        if (var8 == 0.0F) {
                            var5.l = Float.POSITIVE_INFINITY;
                        }
                    }
                } else if (var5.l > Float.NEGATIVE_INFINITY) {
                    var8 = this.a(var7, var6 + var5.l, var1);
                    if (var8 == 0.0F) {
                        var5.l = Float.NEGATIVE_INFINITY;
                    }
                }

                if (var5.k > var3.at) {
                    var5.k = (float)(-class_340.a(this, 0, (int)var3.aw));
                    var8 = var3.as;
                    if (var3.ax > 0.0F) {
                        var8 += class_340.b(this, 0.0F, var3.ax, var1);
                    }

                    var5.l = var5.l > 0.0F ? -var8 : var8;
                }

                return false;
            }
        }

        if (var3.ar != 0.0F) {
            class_1048 var10000 = this.cL[var1];
            var10000.a += var3.ar * var2;
            if (this.cL[var1].a > 180.0F) {
                var10000 = this.cL[var1];
                var10000.a -= 360.0F;
            }

            if (this.cL[var1].a < -180.0F) {
                var10000 = this.cL[var1];
                var10000.a += 360.0F;
            }

            return false;
        } else {
            return var3.aq;
        }
    }

    public strictfp int cw() {
        return this.x.eZ;
    }

    public strictfp ArrayList dC() {
        dU.clear();
        ArrayList var1 = this.N();
        if (var1.size() != 0) {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
                class_226 var3 = (class_226)var2.next();
                if (var3 instanceof class_283) {
                    class_283 var4 = (class_283)var3;
                    if (var4.c == AIUse.upgrade) {
                        dU.add(var4);
                    }
                }
            }
        }

        return dU;
    }

    public strictfp class_1059 cm() {
        ArrayList var1 = this.dC();
        return var1.size() > 0 ? ((class_226)var1.get(0)).N() : null;
    }

    public strictfp void a(ArrayList var1) {
        var1.clear();
        ArrayList var2 = this.dC();
        if (var2.size() >= 2) {
            var2.remove(0);
            Iterator var3 = var2.iterator();

            while(var3.hasNext()) {
                class_226 var4 = (class_226)var3.next();
                var1.add(var4.N());
            }

        }
    }

    public strictfp float cZ() {
        return this.x.da;
    }

    public strictfp float da() {
        return this.x.db;
    }

    public strictfp void bv() {
        PlayerData.a((Unit)this);
        this.dL.a(true);
        super.bv();
    }

    public strictfp void dc() {
        this.zCord = 170.0F;
        this.f = 1.5F;
        this.dB();
        super.dc();
    }

    public strictfp boolean dd() {
        return this.x.cm;
    }

    public strictfp int bp() {
        return this.x.bq;
    }

    public strictfp void a(int var1, float var2) {
        class_1048 var10000 = this.cL[var1];
        var10000.a += var2;
        if (this.x.fU) {
            for(int var3 = 0; var3 < this.x.fQ.length; ++var3) {
                class_397 var4 = this.x.fQ[var3];
                if (var4.w == var1) {
                    var10000 = this.cL[var3];
                    var10000.a += var2;
                    this.cL[var3].a(2);
                }
            }
        }

    }

    public strictfp float db() {
        return super.db() + (float)this.x.dg;
    }

    public strictfp float H(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.p;
    }

    public strictfp float I(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.q;
    }

    public strictfp float J(int var1) {
        class_397 var2 = this.x.fQ[var1];
        return var2.r;
    }

    public strictfp float a(Unit var1, float var2, Projectile var3) {
        class_826 var4 = this.dn();
        if (var4 != null && this.cO != null && var4.j) {
            int var5 = 0;
            if (var3 != null) {
                var5 = var3.aD;
            }

            if (var5 >= 0) {
                Projectile var6 = Projectile.a(var3);
                if (var4.k) {
                    var6.am = 0.0F;
                }

                float var7 = this.cO.a(var1, var2, var6);
                var2 = var7;
                if (var7 < 0.0F) {
                    var2 = 0.0F;
                }
            }
        }

        if (this.J()) {
            var2 = 0.0F;
        }

        if (this.y.l > 0.0F && var2 > this.x.cN) {
            float var8 = this.y.l;
            if (var3 != null) {
                var8 -= var3.an;
            }

            if (var8 < 0.0F) {
                var8 = 0.0F;
            }

            var2 -= var8;
            if (var2 < this.x.cN) {
                var2 = this.x.cN;
            }
        }

        if (var3 != null) {
            this.a(GameEvent.tookDamage, var1, var3.aE, (VariableScope)null);
        } else {
            this.a(GameEvent.tookDamage, var1);
        }

        return super.a(var1, var2, var3);
    }

    public strictfp float aU() {
        return this.x.dJ;
    }

    public strictfp boolean ac() {
        return !this.x.eh ? false : super.ac();
    }

    public strictfp boolean a(OrderType var1) {
        if (var1 == OrderType.ATTACK) {
            return this.x.doo.a();
        } else if (var1 == OrderType.MOVE) {
            return this.x.dp.a();
        } else {
            return var1 == OrderType.NEW_SELECTION ? this.x.dq.a() : false;
        }
    }

    public strictfp void b(GameEvent var1) {
        class_591 var2 = this.x;
        if (var2.gq.a != 0) {
            Object[] var3 = var2.gq.a();

            for(int var4 = var2.gq.a - 1; var4 >= 0; --var4) {
                class_438 var5 = (class_438)var3[var4];
                if (var5.a == var1) {
                    ec.x = this.xCord;
                    ec.y = this.yCord;
                    PointF var6 = ec;
                    Object var7 = null;
                    this.a(var5.b, var6, (Unit)var7, 0, 0);
                }
            }

        }
    }

    public strictfp void a(GameEvent var1, Unit var2, class_588 var3, VariableScope var4) {
        class_591 var5 = this.x;
        if (var5.gq.a != 0) {
            Object[] var6 = var5.gq.a();

            for(int var7 = var5.gq.a - 1; var7 >= 0; --var7) {
                class_438 var8 = (class_438)var6[var7];
                if (var8.a == var1 && (var8.d == null || class_585.a(var8.d, var3))) {
                    class_589 var9;
                    if (dX.size() > 0) {
                        var9 = (class_589)dX.b();
                    } else {
                        var9 = new class_589();
                    }

                    var9.a = var8;
                    var9.b = this;
                    var9.c = var2;
                    var9.d = var3;
                    var9.e = var4;
                    dW.add(var9);
                }
            }

        }
    }

    public static strictfp void s(float var0) {
    }

    public static strictfp void dD() {
        if (dW.a != 0) {
            dW = new class_684();
        }
    }

    public static strictfp void a(float var0, int var1) {
        if (dW.a != 0) {
            int var3;
            for(int var2 = 0; var2 < 105; ++var2) {
                var3 = dW.a;
                if (var3 == 0) {
                    break;
                }

                Object[] var4 = dW.a();

                int var5;
                for(var5 = var3 - 1; var5 >= 0; --var5) {
                    class_589 var6 = (class_589)var4[var5];
                    class_438 var7 = var6.a;
                    class_113 var8 = var6.b;
                    if (var7.c == var8.x) {
                        ec.x = var8.xCord;
                        ec.y = var8.yCord;
                        PointF var9 = ec;
                        Object var10 = null;
                        LogicBoolean.setContextEventSource(var6);
                        var8.a(var7.b, var9, (Unit)var10, 0, 0);
                        LogicBoolean.clearContext();
                    }
                }

                if (var2 >= 105) {
                    GameEngine.log("processAllQueuedEvents: recursion limit reached");
                    break;
                }

                if (var3 == dW.a) {
                    break;
                }

                var4 = dW.a();
                var5 = 0;

                int var13;
                class_589 var14;
                for(var13 = var3; var13 < dW.a; ++var13) {
                    var14 = (class_589)var4[var13];
                    class_438 var16 = var14.a;
                    if (var2 < var16.e) {
                        ++var5;
                    }
                }

                if (var5 <= 0) {
                    break;
                }

                dV.clear();

                for(var13 = 0; var13 < dW.a; ++var13) {
                    var14 = (class_589)var4[var13];
                    boolean var17 = true;
                    if (var13 < var3) {
                        var17 = false;
                    } else {
                        class_438 var18 = var14.a;
                        if (var2 >= var18.e) {
                            var17 = false;
                        }
                    }

                    if (!var17) {
                        var14.a();
                        dX.add(var14);
                    } else {
                        dV.add(var14);
                    }
                }

                dW.clear();
                class_684 var15 = dV;
                dV = dW;
                dW = var15;
                if (var5 != dW.a) {
                    GameEngine.log("processAllQueuedEvents: " + var5 + "!=" + dW.a);
                }
            }

            Object[] var11 = dW.a();

            for(var3 = dW.a - 1; var3 >= 0; --var3) {
                class_589 var12 = (class_589)var11[var3];
                var12.a();
                dX.add(var12);
            }

            dW.clear();
        }
    }

    public static strictfp void dE() {
    }

    public strictfp void b(float var1, boolean var2) {
        class_591 var3 = this.x;
        if (var3.fX) {
            if (this.w != 0.0F) {
                this.w = class_340.a(this.w, var1);
                if (this.w != 0.0F) {
                    return;
                }

                var2 = true;
            }

            class_597[] var4 = var3.fY;
            if (var4 != null) {
                this.a(var1, var4);
                if (var3 != this.x) {
                    return;
                }
            }

            class_597[] var5 = var3.fZ;
            if (var5 != null) {
                GameEngine var6 = GameEngine.getGameEngine();
                int var7 = (int)((long)var6.tick + this.id) % 4;
                if (var7 == 0 || var2) {
                    this.a(var1, var5);
                    if (var3 != this.x) {
                        return;
                    }
                }
            }

            class_597[] var9 = var3.ga;
            if (var9 != null) {
                GameEngine var10 = GameEngine.getGameEngine();
                int var8 = (int)((long)var10.tick + this.id) % 8;
                if (var8 == 0 || var2) {
                    this.a(var1, var9);
                    if (var3 != this.x) {
                        return;
                    }
                }
            }

        }
    }

    public strictfp void a(float var1, class_597[] var2) {
        class_591 var3 = this.x;
        GameEngine var4 = GameEngine.getGameEngine();
        boolean var5 = false;

        for(int var6 = 0; var6 < var2.length; ++var6) {
            class_597 var7 = var2[var6];
            long var8 = 0L;
            boolean var10 = var7.a.read(this);
            if (var10) {
                PointF var11;
                String var12;
                if (var4.bl && var4.bn && this.cG) {
                    var11 = null;
                    if (var7.d != null) {
                        (new StringBuilder()).append("").append(var7.d.O()).toString();
                    }

                    var12 = "autoTrigger fired on: " + this.cB() + " details: " + var7.a.getDebugDetails(this);
                    GameEngine.log(var12);
                    var4.bS.i.a(var12, 2000);
                }

                ec.x = this.xCord;
                ec.y = this.yCord;
                var11 = ec;
                var12 = null;
                long var13 = 0L;
                this.a(var7.d, var11, null, 0, 0);
                this.w = this.x.ca;
                if (var3 != this.x) {
                    return;
                }
            }
        }

    }

    public strictfp class_588 de() {
        return this.ed;
    }

    public strictfp void a(class_588 var1, boolean var2) {
        if (var2) {
            this.ed = var1;
        } else {
            PlayerData.b((Unit)this);
            this.ed = var1;
            PlayerData.c((Unit)this);
        }
    }

    public strictfp void j(boolean var1) {
        this.a(this.x.O, var1);
    }

    public strictfp void a(class_588 var1) {
        class_588 var2 = this.de();
        if (var2 != null && var2.b() != 0) {
            if (!class_585.b(var2, var1)) {
                class_587 var3 = new class_587(var2);
                if (var3.a(var1)) {
                    this.a(var3.a(), false);
                }
            }
        } else {
            this.a(var1, false);
        }
    }

    public strictfp void b(class_588 var1) {
        class_588 var2 = this.de();
        if (var2 != null && var2.b() != 0) {
            if (class_585.a(var1, var2)) {
                class_587 var3 = new class_587(var2);
                if (var3.b(var1)) {
                    this.a(var3.a(), false);
                }
            }
        }
    }

    public final strictfp void dF() {
        if (this.x.fg == MovementType.AIR) {
            if (this.i()) {
                this.S(5);
            } else if (this.cr() && this.cl == 0.0F) {
                this.S(3);
            } else {
                this.S(2);
            }
        } else if (this.cl == 0.0F) {
            this.S(this.x.cI);
        } else {
            this.S(2);
        }

        this.en = 0;
    }

    public strictfp boolean ck() {
        return this.x.gi;
    }

    public strictfp boolean f() {
        return this.x.fd.read(this);
    }

    public strictfp boolean j() {
        return true;
    }

    public strictfp Point3DF D(int var1) {
        class_1048 var2 = this.cL[var1];
        class_397 var3 = this.x.fQ[var1];
        float var4 = var3.X;
        float var5 = var3.Y;
        if (var3.Z != 0.0F && var2.m) {
            var5 += var3.Z;
        }

        float var6 = this.E() ? this.cg : var2.a;
        Point3DF var7 = this.F(var1);
        float var8 = class_340.k(var6);
        float var9 = class_340.j(var6);
        float var10 = var7.x;
        float var11 = var7.y;
        float var12 = var7.z;
        var10 += var8 * var4 - var9 * var5;
        var11 += var9 * var4 + var8 * var5;
        ee.x = var10;
        ee.y = var11;
        ee.z = var12 + var3.aa;
        return ee;
    }

    public strictfp PointF E(int var1) {
        Point3DF var2 = this.D(var1);
        ef.x = var2.x;
        ef.y = var2.y;
        return ef;
    }

    public strictfp boolean cl() {
        return this.x.fJ;
    }

    public strictfp float cn() {
        return this.x.fK;
    }

    public strictfp void a(Unit var1, float var2, int var3) {
        if (this.x.dz != null) {
            this.b.a(this.x.dz, 5);
        }

        if (this.x.bS) {
            this.U = class_340.a(this.U, var2);
            if (this.U == 0.0F) {
                this.U = this.x.bT;
                if (this.x.bU != null) {
                    class_1048 var4 = this.cL[var3];
                    PointF var5 = this.E(var3);
                    this.x.bU.a(var5.x, var5.y, this.zCord, var4.a, this);
                }

                if (this.x.bV != null) {
                    this.x.bV.a(var1.xCord, var1.yCord, var1.zCord, var1.cg, var1);
                }
            }
        } else {
            super.a(var1, var2, var3);
        }

    }

    public strictfp void b(Unit var1, float var2, int var3) {
        if (this.x.dA != null) {
            this.b.a(this.x.dA, 5);
        }

        if (this.x.bW) {
            this.U = class_340.a(this.U, var2);
            if (this.U == 0.0F) {
                this.U = this.x.bX;
                if (this.x.bY != null) {
                    class_1048 var4 = this.cL[var3];
                    PointF var5 = this.E(var3);
                    this.x.bY.a(var5.x, var5.y, this.zCord, var4.a, this);
                }

                if (this.x.bZ != null) {
                    this.x.bZ.a(var1.xCord, var1.yCord, var1.zCord, var1.cg, var1);
                }
            }
        } else {
            super.b(var1, var2, var3);
        }

    }

    public strictfp boolean cg() {
        return this.y.m;
    }

    public strictfp boolean dG() {
        if (this.x.Z != null && !this.x.Z.read(this)) {
            return false;
        } else {
            if (!this.y.m) {
                GameEngine var1 = GameEngine.getGameEngine();
                if (var1.playerTeam.c(this.bX) && !var1.playerTeam.b()) {
                    return false;
                }
            }

            class_826 var2 = this.dn();
            return var2 == null || var2.o;
        }
    }

    public strictfp boolean t() {
        class_826 var1 = this.dn();
        return var1 != null && var1.m ? true : this.x.aM;
    }

    public strictfp boolean cV() {
        class_826 var1 = this.dn();
        return var1 != null && var1.n ? true : this.x.aN;
    }

    public strictfp boolean d(Unit var1) {
        class_591 var2 = this.x;
        if (var2.aS != null && !class_585.a(var2.aS, var1.de())) {
            return false;
        } else if (this.dH()) {
            return false;
        } else {
            return !var2.aO;
        }
    }

    public strictfp boolean cW() {
        return this.x.aT;
    }

    public strictfp boolean cT() {
        if (this.x.aO) {
            return true;
        } else {
            return this.u() || this.cm < 1.0F && this.x.bh <= 0.0F;
        }
    }

    public strictfp class_588 dh() {
        return this.x.P;
    }

    public strictfp float am() {
        return this.x.eG;
    }

    public strictfp boolean an() {
        return super.an() || this.x.eF;
    }

    public strictfp boolean a(GameEngine var1) {
        if (!var1.cO.b(this.xCord, this.yCord)) {
            if (!this.x.B) {
                return false;
            }

            boolean var2 = false;
            if (this.x.C != null) {
                class_591.a.a(this.x.C);
                class_591.a.a((int)this.xCord, (int)this.yCord);
                if (var1.cQ.b(class_591.a)) {
                    var2 = true;
                }
            }

            if (var1.cO.b(this.xCord, this.yCord - this.zCord)) {
                var2 = true;
            }

            if (!var2) {
                return false;
            }
        }

        if (this.cN != null) {
            return false;
        } else if (this.cP != null && this.cP.I) {
            return false;
        } else if (!this.d(var1.playerTeam)) {
            return false;
        } else {
            return this.dG();
        }
    }

    public strictfp OrderableUnit a(class_826 var1) {
        OrderableUnit var2 = class_834.a(this, var1);
        return var2;
    }

    public strictfp class_826 a(short var1) {
        class_826 var2 = class_834.a(this, var1);
        return var2;
    }

    public strictfp boolean a(OrderableUnit var1, class_826 var2) {
        if (var1 == this) {
            return false;
        } else if (var2 == null) {
            GameEngine.print("attachRequest: No attachedSlotData");
            return false;
        } else {
            OrderableUnit var3 = class_834.a(this, var2);
            if (var3 != null) {
                GameEngine.print("attachRequest: a unit is already in slot (parent:" + this.cB() + " slot:" + var2.b() + " existing:" + var3.cC() + ")");
                return false;
            } else {
                GameEngine var4 = GameEngine.getGameEngine();
                class_834.a(this, var2, var1);
                var1.cO = this;
                var1.cP = var2;
                var1.cQ = var4.by;
                var1.bT = false;
                return true;
            }
        }
    }

    public strictfp boolean b(OrderableUnit var1) {
        if (var1.cO != this) {
            GameEngine.print("deattachRequest: unit is not attached");
            return false;
        } else {
            class_826 var2 = var1.cP;
            if (var2 == null) {
                GameEngine.print("deattachRequest: unit has no attachedSlotData");
                return false;
            } else {
                OrderableUnit var3 = class_834.a(this, var2);
                if (var3 == null) {
                    GameEngine.print("deattachRequest: Failed, no unit in slot");
                    GameEngine.warn("deattachRequest");
                    return false;
                } else if (var1 != var3) {
                    String var4 = "null";
                    if (var3 != null) {
                        var4 = var3.cB();
                    }

                    GameEngine.print("deattachRequest: unit and slot don't match - requested:" + var1.cB() + " current:" + var4);
                    return false;
                } else {
                    if (this.B.remove(var1)) {
                        this.D(var1);
                    }

                    class_834.a(this, var2, (OrderableUnit)null);
                    var1.cO = null;
                    var1.cP = null;
                    var1.f_();
                    this.a(GameEvent.attachmentRemoved, this);
                    return true;
                }
            }
        }
    }

    public strictfp boolean dH() {
        class_826 var1 = this.dn();
        return var1 != null && !var1.l;
    }

    public strictfp boolean J() {
        if (this.dH()) {
            return true;
        } else {
            return this.x.aP;
        }
    }

    public strictfp void di() {
        class_591 var1 = this.x;
        if (!var1.cv.c()) {
            var1.cv.a((Unit)this);
        }

        if (!var1.cw.c() && this.cm >= 1.0F) {
            var1.cw.a((Unit)this);
        }

        super.di();
    }

    public strictfp void dj() {
        class_591 var1 = this.x;
        if (!var1.cv.c()) {
            var1.cv.h(this);
        }

        if (!var1.cw.c() && this.cm >= 1.0F) {
            var1.cw.h(this);
        }

        super.dj();
    }

    public strictfp void a(class_1042 var1) {
        this.a((GameEvent) GameEvent.newWaypointGivenByPlayer);
        class_826 var2 = this.dn();
        if (var2 != null && var2.H) {
            WaypointType var3 = var1.d();
            if (var3 == WaypointType.attackMove || var3 == WaypointType.move) {
                this.bx();
            }
        }

    }

    public strictfp boolean c_() {
        class_591 var1 = this.x;
        if (!var1.aR) {
            GameEngine var2 = GameEngine.getGameEngine();
            if (var2.playerTeam.c(this.bX)) {
                return false;
            }
        }

        return var1.aQ;
    }

    public strictfp boolean dk() {
        return this.x.aa;
    }

    public strictfp boolean dl() {
        return this.x.eK;
    }

    public strictfp boolean dm() {
        return this.x.eL;
    }

    public strictfp boolean G(Unit var1) {
        int var2 = this.dI();
        int var3 = var1.cw();
        if (this.x.eO) {
            var3 = 1;
        }

        return var2 + var3 <= this.x.eM;
    }

    public strictfp int dI() {
        int var1 = 0;
        if (this.x.eO) {
            var1 += this.B.size();
        } else {
            Unit var3;
            if (this.B.a > 0) {
                for(Iterator var2 = this.B.iterator(); var2.hasNext(); var1 += var3.cw()) {
                    var3 = (Unit)var2.next();
                }
            }
        }

        return var1;
    }

    public strictfp void e(PlayerData var1) {
        if (this.bX != var1) {
            super.e(var1);
            Iterator var2;
            Unit var3;
            if (this.B != null && !this.x.eX) {
                var2 = this.B.iterator();

                while(var2.hasNext()) {
                    var3 = (Unit)var2.next();
                    var3.e(var1);
                }
            }

            if (this.C != null) {
                var2 = this.C.iterator();

                while(var2.hasNext()) {
                    var3 = (Unit)var2.next();
                    if (var3 != null) {
                        class_826 var4 = var3.dn();
                        if (var4 != null && !var4.z) {
                            var3.e(var1);
                        }
                    }
                }
            }

            this.a((GameEvent) GameEvent.teamChanged);
        }
    }

    public strictfp class_447 cN() {
        return this.x.ci;
    }

    public strictfp void ch() {
        if (this.x.bs) {
            if (this.health <= -1.0F) {
                this.health = -1.0F;
            }

        } else {
            super.ch();
        }
    }

    public strictfp class_684 bz() {
        return this.B;
    }

    public strictfp class_684 e(boolean var1) {
        this.eg.clear();
        if (this.x.aA.a > 0) {
            class_834.a(this, this.eg, var1);
        }

        return this.eg.a > 0 ? this.eg : null;
    }

    public strictfp float doo() {
        return this.x.de;
    }

    public strictfp boolean dp() {
        return this.x.A;
    }

    public strictfp void dJ() {
        if (this.y.a) {
            this.y = this.y.b();
        }

    }

    // $FF: synthetic method
    public class_31 r() {
        return this.dt();
    }

    static {
        for(int var0 = 0; var0 < 10; ++var0) {
            dX.add(new class_589());
        }

        dY = true;
        dZ = new HashMap();
        ea = 0;
        eb = "";
        ec = new PointF();
        ee = new Point3DF();
        ef = new PointF();
    }
}
