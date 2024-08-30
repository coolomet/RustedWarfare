package com.corrodinggames.rts.game.units;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.maps.MapException;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.air.class_107;
import com.corrodinggames.rts.game.units.custom.GameEvent;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.b.class_826;
import com.corrodinggames.rts.game.units.custom.c.class_635;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.buildings.LaserDefence;
import com.corrodinggames.rts.game.units.buildings.class_88;
import com.corrodinggames.rts.game.units.buildings.RepairBay;
import com.corrodinggames.rts.game.units.land.class_120;
import com.corrodinggames.rts.game.units.land.Builder;
import com.corrodinggames.rts.game.units.land.class_128;
import com.corrodinggames.rts.game.units.sea.class_114;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.class_76;
import com.corrodinggames.rts.gameFramework.d.Emitter;
import com.corrodinggames.rts.gameFramework.d.class_989;
import com.corrodinggames.rts.gameFramework.d.class_990;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_682;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_692;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.am
public abstract strictfp class Unit extends class_76 {
    public float br;
    public int bs = -9999;
    public Unit bt = null;
    public Unit bu = null;
    public Unit bv = null;
    public VariableScope bw;
    public class_447 bx;
    public class_447 by;
    public int bz = -9999;
    public int bA = -9999;
    public int bB = -9999;
    public int bC;
    public boolean bD;
    public static final class_692 bE = new class_692();
    private static final class_682 a = new class_682();
    public static HashMap bF = new HashMap();
    public static HashMap bG = new HashMap();
    public static HashMap bH = new HashMap();
    public static final Paint bI = new class_525();
    public static final Paint bJ;
    static final LightingColorFilter bK;
    public boolean bL;
    public boolean bM = false;
    public boolean bN = false;
    public boolean bO = false;
    public boolean bP = false;
    public Unit bQ = null;
    public Unit bR;
    public float bS;
    public boolean bT = true;
    public int bU = 1;
    public boolean bV = false;
    public long bW = 0L;
    public PlayerData bX;
    public boolean bY;
    public float bZ = 0.0F;
    public float ca = 0.0F;
    public boolean cb = false;
    public float cc = 0.0F;
    public float cd = 0.0F;
    public float ce = 0.0F;
    public float cf = 0.0F;
    public float cg;
    public float ch;
    public boolean ci;
    public float cj;
    public float ck;
    public float cl;
    public float cm = 1.0F;
    public float cn = 1.0F;
    public boolean co = false;
    public boolean cp = false;
    public boolean cq = false;
    public boolean cr = false;
    public boolean cs = false;
    public boolean ct = false;
    public float health;
    public float totalHealth;
    public float cw;
    public float cx;
    public float cy;
    public float cz;
    public float cA;
    public float cB;
    public float cC;
    public float cD;
    public int cE;
    public int cF;
    public boolean cG;
    public int cH = -9999;
    public boolean cI;
    public float cJ = 0.0F;
    public boolean cK = true;
    public class_1048[] cL;
    public boolean cM;
    public Unit cN = null;
    public OrderableUnit cO = null;
    public class_826 cP = null;
    public int cQ = -9999;
    public boolean cR;
    public int cS;
    public int cT;
    public int cU;
    public float cV;
    public static final Paint cW;
    public static final Paint cX;
    public static final Paint cY;
    public static final Paint cZ;
    public static final Paint da;
    public static final Paint db;
    public static final Paint dc;
    public static final Paint dd;
    public static final Paint de;
    public static final Paint df;
    public static final Paint dg;
    public static final Paint dh;
    public static final Paint di;
    public static final Paint dj;
    public static final Paint dk;
    public int dl = -1;
    public int dm = -1;
    public int dn = -99;
    public float doo;
    public float dp;
    public float dq = 70.0F;
    static final RectF dr;
    static Paint ds;
    static Paint dt;
    public static final RectF du;
    public static final Rect dv;
    static final Rect dw;
    static final ArrayList dx;
    static ArrayList dy;
    public class_31 dz;
    static final RectF dA;
    static final RectF dB;
    static final Rect dC;
    static final PointF dD;
    static final PointF dE;
    class_1047[] dF;
    static final PointF dG;
    class_1069 dH = new class_1069();
    public class_635 dI = new class_635();
    class_447 dJ = null;

    public strictfp void a(GameOutputStream var1) {
        var1.writeBoolean(this.bM);
        var1.a(this.bQ);
        var1.a(this.bR);
        var1.writeFloat(this.bS);
        var1.writeBoolean(this.bT);
        var1.writeBoolean(this.bV);
        var1.writeLong(this.bW);
        var1.a(this.bX);
        var1.writeFloat(this.bZ);
        var1.writeFloat(this.ca);
        var1.writeFloat(this.cc);
        var1.writeFloat(this.cd);
        var1.writeFloat(this.cf);
        var1.writeFloat(this.cg);
        var1.writeFloat(this.cj);
        var1.writeFloat(this.ck);
        var1.writeFloat(this.cl);
        var1.writeFloat(this.cm);
        var1.writeBoolean(this.cp);
        var1.writeBoolean(this.cs);
        var1.writeFloat(this.health);
        var1.writeFloat(this.totalHealth);
        var1.writeBoolean(this.cK);
        var1.writeFloat(this.cL[0].a);
        var1.writeFloat(this.cL[0].d);
        var1.a(this.cN);
        var1.writeByte(26);
        var1.writeInt(this.cU);
        var1.writeFloat(this.cV);
        var1.writeFloat(this.ce);
        var1.writeFloat(this.ch);
        int var2 = this.bl();
        var1.writeInt(var2);

        int var3;
        for(var3 = 0; var3 < var2; ++var3) {
            class_1048 var4 = this.cL[var3];
            var1.writeFloat(var4.a);
            var1.writeFloat(var4.c);
            var1.writeFloat(var4.d);
            var1.writeFloat(var4.e);
            var1.writeFloat(var4.f);
            var1.writeFloat(var4.h);
            var1.writeFloat(var4.i);
            Unit var5 = var4.j;
            if (var5 != null && var5.bV) {
                var5 = null;
            }

            var1.a(var5);
            var1.writeBoolean(this.cM);
        }

        var1.writeInt(this.bs);
        var1.writeFloat(this.cx);
        var1.writeFloat(this.cy);
        var1.writeFloat(this.cz);
        var1.writeFloat(this.cA);
        var1.writeBoolean(this.cq);
        var1.writeBoolean(this.cr);
        var1.writeBoolean(this.ct);
        var1.writeBoolean(this.bN);
        var1.writeFloat(this.cB);
        var1.writeBoolean(this.ci);
        var1.writeBoolean(this.dF != null);
        if (this.dF != null) {
            var1.writeInt(this.dF.length);

            for(var3 = 0; var3 < this.dF.length; ++var3) {
                class_1047 var7 = this.dF[var3];
                var1.writeBoolean(var7.a);
                var1.writeInt(var7.b);
            }
        }

        var1.writeFloat(this.cw);
        var1.b(this.bt);
        var1.writeInt(this.cE);
        var1.writeInt(this.cF);
        var1.writeInt(this.bz);
        var1.writeInt(this.bA);
        var1.writeInt(this.bB);
        var1.writeInt(this.bC);
        var1.writeBoolean(this.bO);
        var1.writeBoolean(this.bP);
        this.dH.a(var1);
        this.dI.a(var1);
        var1.b((Unit)this.cO);
        short var6 = -1;
        if (this.cO != null && this.cP != null) {
            var6 = this.cP.a();
        }

        var1.a(var6);
        var1.writeInt(this.cQ);
        VariableScope.writeOutUnitOrPlaceholder(var1, this.bu);
        VariableScope.writeOutUnitOrPlaceholder(var1, this.bv);
        VariableScope.writeOut(var1, this.bw);
        class_447.a(var1, this.bx);
        class_447.a(var1, this.by);
        var1.writeFloat(this.cn);
        super.a(var1);
    }

    @SneakyThrows
    public strictfp void a(GameInputStream var1) {
        this.bM = var1.readBoolean();
        this.bQ = var1.o();
        this.bR = var1.o();
        this.bS = var1.readFloat();
        this.bT = var1.readBoolean();
        this.bV = var1.readBoolean();
        this.bW = var1.readLong();
        this.b(var1.r());
        this.bZ = var1.readFloat();
        this.ca = var1.readFloat();
        this.cc = var1.readFloat();
        this.cd = var1.readFloat();
        this.cf = var1.readFloat();
        this.cg = var1.readFloat();
        float var2 = var1.readFloat();
        float var3 = var1.readFloat();
        this.cl = var1.readFloat();
        this.cm = var1.readFloat();
        this.cp = var1.readBoolean();
        this.cs = var1.readBoolean();
        this.o(var1.readFloat());
        this.totalHealth = var1.readFloat();
        this.cK = var1.readBoolean();
        this.cL[0].a = var1.readFloat();
        this.cL[0].d = var1.readFloat();
        this.cN = var1.o();
        byte var4 = var1.readByte();
        if (var4 >= 1) {
            this.cU = var1.readInt();
            this.cV = var1.readFloat();
        }

        int var6;
        if (var4 >= 2) {
            this.ce = var1.readFloat();
            this.ch = var1.readFloat();
            int var5 = var1.readInt();
            this.O(var5);

            for(var6 = 0; var6 < var5; ++var6) {
                class_1048 var7 = this.cL[var6];
                var7.a = var1.readFloat();
                var7.c = var1.readFloat();
                var7.d = var1.readFloat();
                var7.e = var1.readFloat();
                var7.f = var1.readFloat();
                if (var4 >= 8) {
                    var7.h = var1.readFloat();
                    var7.i = var1.readFloat();
                    var7.j = var1.o();
                }

                if (var4 >= 12) {
                    this.cM = var1.readBoolean();
                }
            }
        }

        if (var4 >= 3) {
            this.bs = var1.readInt();
        }

        if (var4 >= 4) {
            this.cx = var1.readFloat();
            this.cy = var1.readFloat();
            this.cz = var1.readFloat();
            this.cA = var1.readFloat();
        }

        if (var4 >= 5) {
            this.cq = var1.readBoolean();
            this.cr = var1.readBoolean();
        }

        if (var4 >= 6) {
            this.ct = var1.readBoolean();
        }

        if (var4 >= 7) {
            this.bN = var1.readBoolean();
        }

        if (var4 >= 9) {
            this.cB = var1.readFloat();
        }

        if (var4 >= 10) {
            this.ci = var1.readBoolean();
        }

        if (var4 >= 11) {
            boolean var9 = var1.readBoolean();
            if (var9) {
                this.dF = new class_1047[var1.readInt()];

                for(var6 = 0; var6 < this.dF.length; ++var6) {
                    this.dF[var6] = new class_1047();
                    class_1047 var12 = this.dF[var6];
                    var12.a = var1.readBoolean();
                    var12.b = var1.readInt();
                }
            }
        }

        if (var4 >= 13) {
            this.cw = var1.readFloat();
        }

        if (var4 >= 14) {
            this.bt = var1.o();
        }

        if (var4 >= 15) {
            this.cE = var1.readInt();
            this.cF = var1.readInt();
        }

        if (var4 >= 16) {
            this.bz = var1.readInt();
            this.bA = var1.readInt();
            this.bB = var1.readInt();
        }

        if (var4 >= 17) {
            this.bC = var1.readInt();
        }

        if (var4 >= 18) {
            this.bO = var1.readBoolean();
            this.bP = var1.readBoolean();
        }

        if (var4 >= 19) {
            this.dH.a(var1);
            this.dI.a(this, var1);
        }

        if (var4 >= 20) {
            OrderableUnit var10 = var1.p();
            short var13 = var1.readShort();
            if (var13 != -1) {
                boolean var14 = false;
                if (var10 != null && this instanceof OrderableUnit) {
                    class_826 var8 = var10.a(var13);
                    if (var8 != null && var10.a((OrderableUnit)this, var8)) {
                        var14 = true;
                    }
                }

                if (!var14) {
                    this.cj();
                }
            }
        }

        if (var4 >= 21) {
            this.cQ = var1.readInt();
        }

        if (var4 >= 22) {
            if (var4 < 24) {
                throw new IOException("extension >=22 but <24");
            }

            this.bu = VariableScope.readInUnitOrPlaceholder(var1);
            this.bv = VariableScope.readInUnitOrPlaceholder(var1);
        }

        if (var4 >= 23) {
            this.bw = VariableScope.readIn(var1);
        }

        if (var4 >= 25) {
            this.bx = class_447.a(var1);
            this.by = class_447.a(var1);
        }

        if (var4 >= 26) {
            this.cn = var1.readFloat();
        }

        if (this.bV) {
            GameEngine var11 = GameEngine.getGameEngine();
            bE.remove(this);
            var11.cc.a(this);
        }

        super.a(var1);
    }

    public static strictfp TeamImageCache a(TeamImageCache var0) {
        return a(var0, var0.m(), var0.l());
    }

    public static strictfp TeamImageCache a(TeamImageCache var0, int var1, int var2) {
        TeamImageCache var3 = var0.getTeamImageCache(var1, var2, false);
        var0.x();
        var3.j();
        int var4 = var3.m();
        int var5 = var3.l();

        for(int var6 = 0; var6 < var4; ++var6) {
            for(int var7 = 0; var7 < var5; ++var7) {
                int var8 = var0.a(var6, var7);
                var3.a(var6, var7, Color.a(Color.a(var8), 0, 0, 0));
            }
        }

        var3.p();
        var3.s();
        var0.y();
        var3.a("shadow:" + var0.a());
        var3.n = true;
        return var3;
    }

    public static strictfp class_682 bF() {
        a.a();
        return a;
    }

    public static strictfp void bG() {
        a.a();
    }

    public static strictfp void bH() {
        class_120.dt();
        class_88.dt();
        class_128.K();
        class_114.M();
        class_107.K();
        GameEngine var0 = GameEngine.getGameEngine();
        if (var0.as()) {
            Iterator var1 = Arrays.stream(UnitType.values()).iterator();

            while(var1.hasNext()) {
                UnitType var2 = (UnitType)var1.next();
                var2.b();
            }
        } else {
            Builder.K();
            LaserDefence.b();
            RepairBay.M();
            Tree.b();
        }

        UnitType.t();
    }

    public strictfp boolean bI() {
        return false;
    }

    public strictfp boolean bJ() {
        return false;
    }

    public static strictfp HashMap bK() {
        HashMap var0 = new HashMap();
        GameEngine var1 = GameEngine.getGameEngine();
        Iterator var2;
        Unit var4;
        if (var1.as()) {
            var2 = Arrays.stream(UnitType.values()).iterator();

            while(var2.hasNext()) {
                UnitType var3 = (UnitType)var2.next();
                var4 = var3.a(true);
                var4.a();
                var4.b(PlayerData.i);
                var4.cp = true;
                var0.put(var3, var4);
            }
        }

        var2 = class_591.d.iterator();

        while(var2.hasNext()) {
            class_591 var5 = (class_591)var2.next();
            var4 = var5.a(true);
            var4.a();
            var4.b(PlayerData.i);
            var4.cp = true;
            var0.put(var5, var4);
        }

        return var0;
    }

    public static strictfp void bL() {
        bG = bK();
        bH = bK();
        bF = bK();
    }

    public static strictfp Unit a(class_31 var0) {
        Unit var1 = (Unit)bF.get(var0);
        return var1;
    }

    public static strictfp Unit b(class_31 var0) {
        return c(var0);
    }

    public static strictfp Unit c(class_31 var0) {
        Unit var1 = (Unit)bG.get(var0);
        if (var1 == null) {
            if (class_591.b == null) {
                GameEngine.log("Could not find:" + var0.i() + " and missing place holder is null");
                return null;
            }

            var1 = (Unit)bG.get(class_591.b);
            if (var1 == null) {
                GameEngine.log("name: " + class_591.b.M);
                GameEngine.log("contains:" + bG.containsKey(class_591.b));
                Iterator var2 = bG.keySet().iterator();

                while(var2.hasNext()) {
                    class_31 var3 = (class_31)var2.next();
                    GameEngine.log("has:" + var3.i());
                }

                GameEngine.log("Could not find:" + var0.i() + " and missing place holder could not be found");
            }
        }

        return var1;
    }

    public static strictfp Unit d(class_31 var0) {
        Unit var1 = (Unit)bH.get(var0);
        if (var1 == null) {
            var1 = (Unit)bH.get(class_591.b);
        }

        return var1;
    }

    public static strictfp int bM() {
        int var0 = 0;
        GameEngine var1 = GameEngine.getGameEngine();
        Unit var4;
        if (var1.as()) {
            for(Iterator var2 = Arrays.stream(UnitType.values()).iterator(); var2.hasNext(); var0 = var0 * 31 + var4.bw()) {
                UnitType var3 = (UnitType)var2.next();
                var4 = a((class_31)var3);
            }
        }

        return var0;
    }

    protected Unit(boolean var1) {
        super(var1);
        this.bS();
        if (!var1) {
            this.bL = true;
            bE.a(this);
            a.a((Object)this);
        }

        this.bz = GameEngine.getGameEngine().by;
        this.dz = this.r();
    }

    public strictfp void a() {
        PlayerData.a(this);
        if (this.bL) {
            bE.remove(this);
            a.b((Object)this);
        }

        GameEngine var1 = GameEngine.getGameEngine();
        var1.bS.l(this);
        super.a();
    }

    public strictfp float mass() {
        return 3000.0F;
    }

    public strictfp int s(Unit var1) {
        return 0;
    }

    public strictfp boolean bO() {
        return false;
    }

    public strictfp boolean bP() {
        return false;
    }

    public strictfp float bQ() {
        return -1.0F;
    }

    final strictfp void bR() {
        byte var1 = 1;
        if (this.i()) {
            var1 = 3;
        } else if (this.Q()) {
            var1 = 2;
        }

        if (this.cN != null) {
            var1 = -1;
        }

        if (!this.bT) {
            var1 = -1;
        }

        this.bU = var1;
    }

    public strictfp void o(float var1) {
        this.health = var1;
    }

    public strictfp void bS() {
        this.O(1);
    }

    public strictfp void O(int var1) {
        int var2 = this.bl();
        if (var2 < var1) {
            var2 = var1;
        }

        int var3;
        if (this.cL == null) {
            var3 = 0;
            this.cL = new class_1048[var2];
        } else {
            if (this.cL.length >= var2) {
                return;
            }

            var3 = this.cL.length;
            this.cL = (class_1048[])Arrays.copyOf(this.cL, var2);
        }

        for(int var4 = var3; var4 < this.cL.length; ++var4) {
            this.cL[var4] = new class_1048();
        }

    }

    public static strictfp void a(Paint var0) {
        a(var0, false);
    }

    public static strictfp void a(Paint var0, boolean var1) {
        if (!GameEngine.av() && var1) {
            var0.a(0.0F);
        }

    }

    public strictfp float d(boolean var1) {
        return this.cg + 90.0F;
    }

    public final strictfp boolean bT() {
        if (this.cN != null) {
            return false;
        } else {
            return this.cm >= 1.0F;
        }
    }

    public strictfp float x() {
        return this.health < this.totalHealth ? this.health / this.totalHealth : -1.0F;
    }

    public strictfp boolean bU() {
        return true;
    }

    public strictfp float bV() {
        return !(this.cm < 1.0F) || this.cO != null && !(this.cO.cm >= 1.0F) ? -1.0F : this.cm;
    }

    public strictfp float bW() {
        return -1.0F;
    }

    public strictfp boolean bX() {
        return false;
    }

    public strictfp int bY() {
        return -1;
    }

    public strictfp int bZ() {
        return -1;
    }

    public strictfp void a(float var1, boolean var2) {
        if (!this.bV && this.cN == null) {
            GameEngine var3 = GameEngine.getGameEngine();
            float var4 = this.cj;
            if (!var2) {
                boolean var5 = false;
                int var6 = this.bY();
                if (this.bV() >= 0.0F) {
                    var5 = true;
                }

                if (this.bW() >= 0.0F) {
                    var5 = true;
                }

                if (this.cG || var3.settingsEngine.showHp) {
                    if (this.x() >= 0.0F) {
                        var5 = true;
                    }

                    if (var6 >= 0) {
                        var5 = true;
                    }
                }

                if (var5) {
                    float var7 = this.xCord - var3.cw;
                    float var8 = this.yCord - var3.cx - this.zCord;
                    float var9 = var4 + 4.0F;
                    boolean var10 = true;
                    boolean var11 = true;
                    byte var12 = 4;
                    float var13 = 2.0F * var4;
                    float var14;
                    if (this.co) {
                        var14 = 1.0F;
                    } else {
                        var14 = var3.cX;
                    }

                    if (var14 < 1.0F) {
                        var3.bO.k();
                        var3.S();
                        var7 *= var3.cX;
                        var8 *= var3.cX;
                        var9 *= var3.cX;
                    }

                    float var15 = 3.0F;
                    int var19;
                    int var28;
                    if (this.cG || var3.settingsEngine.showHp) {
                        if (this.x() >= 0.0F) {
                            boolean var16 = false;
                            boolean var17 = false;
                            class_826 var18 = this.dn();
                            if (var18 != null) {
                                var16 = var18.p;
                                var17 = var18.q;
                            }

                            if (!var17) {
                                int var20;
                                if (var3.playerTeam.c(this.bX)) {
                                    var19 = class_340.b(200, 183, 44, 44);
                                    var20 = class_340.b(120, 255, 60, 60);
                                } else {
                                    var19 = class_340.b(200, 0, 150, 0);
                                    var20 = class_340.b(120, 0, 230, 0);
                                }

                                Paint var21 = class_694.a(var19, Paint$Style.a);
                                Paint var22 = class_694.a(var20, Paint$Style.b);
                                byte var23 = var12;
                                if (var16) {
                                    var23 = 1;
                                }

                                dr.a(var7 - var4, var8 + var9, var7 - var4 + var13 * this.x(), var8 + var9 + (float)var23);
                                var3.bO.a(dr, var21);
                                dr.a(var7 - var4, var8 + var9, var7 - var4 + var13, var8 + var9 + (float)var23);
                                var3.bO.a(dr, var22);
                                if (this.cC != 0.0F && this.bU() && var3.settingsEngine.showHpChanges) {
                                    float var24 = this.x();
                                    float var25 = var24 + -this.cC / this.totalHealth;
                                    if (var25 < 0.0F) {
                                        var25 = 0.0F;
                                    }

                                    if (var25 >= 1.0F) {
                                        var25 = 1.0F;
                                    }

                                    int var26 = class_340.b(100, 232, 208, 26);
                                    Paint var27 = class_694.a(var26, Paint$Style.a);
                                    dr.a(var7 - var4 + var13 * var24, var8 + var9, var7 - var4 + var13 * var25, var8 + var9 + (float)var23);
                                    var3.bO.a(dr, var27);
                                }
                            }
                        }

                        if (var6 >= 0) {
                            var28 = this.bZ();
                            float var30 = var13;
                            if (var28 > 10) {
                                var30 = var13 + 20.0F;
                            }

                            float var31 = var7 - var30 / 2.0F;
                            float var34 = (float)((int)(var30 / (float)var28 + 0.5F));
                            float var35 = var34 - 2.0F;
                            float var36 = 3.0F;

                            for(int var37 = 1; var37 <= var28; ++var37) {
                                float var38 = var31 + (float)(var37 - 1) * var34;
                                dr.a(var38, var8 + var9 + var15, var38 + var35, var8 + var9 + var15 + 3.0F);
                                if (var6 >= var37) {
                                    var3.bO.a(dr, class_694.a(240, 0, 0, 255, Paint$Style.a));
                                }

                                var3.bO.a(dr, class_694.a(110, 0, 0, 210, Paint$Style.b));
                            }

                            var15 += 5.0F;
                        }
                    }

                    if (this.bW() >= 0.0F) {
                        byte var29 = var12;
                        var12 = 2;
                        int var33 = var12 + 1;
                        boolean var32 = this.bX();
                        dr.a(var7 - var4, var8 + var9 + (float)var33 + var15, var7 - var4 + var13 * this.bW(), var8 + var9 + (float)var33 + (float)var12 + var15);
                        if (var32) {
                            var19 = class_340.b(185, 103, 117, 119);
                        } else {
                            var19 = class_340.b(200, 23, 179, 207);
                        }

                        var3.bO.a(dr, class_694.a(var19, Paint$Style.a));
                        dr.a(var7 - var4, var8 + var9 + (float)var33 + var15, var7 - var4 + var13, var8 + var9 + (float)var33 + (float)var12 + var15);
                        if (var32) {
                            var19 = class_340.b(105, 123, 182, 193);
                        } else {
                            var19 = class_340.b(120, 45, 211, 241);
                        }

                        var3.bO.a(dr, class_694.a(var19, Paint$Style.b));
                        var15 += (float)var12;
                        var12 = var29;
                    }

                    if (this.bV() >= 0.0F) {
                        var28 = var12 + 1;
                        dr.a(var7 - var4, var8 + var9 + (float)var28 + var15, var7 - var4 + var13 * this.bV(), var8 + var9 + (float)var28 + (float)var12 + var15);
                        var3.bO.a(dr, class_694.a(200, 0, 0, 150, Paint$Style.a));
                        dr.a(var7 - var4, var8 + var9 + (float)var28 + var15, var7 - var4 + var13, var8 + var9 + (float)var28 + (float)var12 + var15);
                        var3.bO.a(dr, class_694.a(120, 0, 0, 230, Paint$Style.b));
                        float var10000 = var15 + (float)var12;
                    }

                    if (var14 < 1.0F) {
                        var3.bO.l();
                    }

                }
            }
        }
    }

    public strictfp void d(float var1) {
    }

    public strictfp void p(float var1) {
        if (!this.bV && this.cN == null) {
            if (this.cG) {
                GameEngine var2 = GameEngine.getGameEngine();
                if (this.bX == var2.playerTeam || var2.bS.m(this)) {
                    if (var2.settingsEngine.showUnitWaypoints && var2.dw <= 40) {
                        ++var2.dw;
                        this.O();
                    }

                    this.ca();
                }

                if (class_694.a(this)) {
                    this.cb();
                }
            }

        }
    }

    public strictfp void ca() {
    }

    public strictfp void O() {
        GameEngine var1 = GameEngine.getGameEngine();
        class_1042 var2 = null;
        class_1042 var3 = null;
        if (this instanceof OrderableUnit) {
            OrderableUnit var4 = (OrderableUnit)this;
            int var5 = var4.av();
            float var6 = this.xCord;
            float var7 = this.yCord;

            for(int var8 = 0; var8 < var5; ++var8) {
                class_1042 var9 = var4.k(var8);
                if (var9 != null) {
                    if (GameEngine.av()) {
                        ds.a(2.0F);
                    } else {
                        ds.a(0.0F);
                    }

                    short var10 = 160;
                    if (var9.d() == WaypointType.attack) {
                        ds.b(Color.a(var10, 180, 0, 0));
                    } else if (var9.d() == WaypointType.attackMove) {
                        ds.b(Color.a(var10, 180, 180, 0));
                    } else if (var9.d() == WaypointType.build) {
                        ds.b(Color.a(var10, 0, 0, 180));
                    } else if (var9.d() == WaypointType.repair) {
                        ds.b(Color.a(var10, 0, 0, 180));
                    } else if (var9.d() != WaypointType.loadInto && var9.d() != WaypointType.loadUp) {
                        if (var9.d() == WaypointType.reclaim) {
                            ds.b(Color.a(var10, 180, 0, 42));
                        } else if (var9.d() != WaypointType.guard && var9.d() != WaypointType.guardAt) {
                            if (var9.d() == WaypointType.patrol) {
                                ds.b(Color.a(var10, 0, 210, 210));
                                if (var2 == null) {
                                    var2 = var9;
                                } else {
                                    var3 = var9;
                                }
                            } else {
                                ds.b(Color.a(var10, 0, 180, 0));
                            }
                        } else {
                            ds.b(Color.a(var10, 97, 20, 229));
                        }
                    } else {
                        ds.b(Color.a(var10, 0, 180, 180));
                    }

                    float var11 = var9.g();
                    float var12 = var9.h();
                    Unit var13 = var9.i();
                    float var15;
                    if (var13 != null && var9.f() && !var13.bI() && !var13.d(var1.playerTeam)) {
                        float var14 = 400.0F;
                        var15 = class_340.d(var6, var7, var11, var12);
                        var11 = var6 + class_340.k(var15) * var14;
                        var12 = var7 + class_340.j(var15) * var14;
                    }

                    var1.bO.a(var6 - var1.cw, var7 - var1.cx, var11 - var1.cw, var12 - var1.cx, ds);
                    boolean var22 = false;
                    if (var22) {
                        var15 = class_340.b(var6, var7, var11, var12);
                        float var16 = class_340.d(var6, var7, var11, var12);
                        float var17 = var1.bS.aT * var15;
                        float var18 = var6 + class_340.k(var16) * var17;
                        float var19 = var7 + class_340.j(var16) * var17;
                        dr.a(var18 - 1.0F, var19 - 1.0F, var18 + 1.0F, var19 + 1.0F);
                        dr.a(-var1.cw, -var1.cx);
                        var1.bO.a(dr, ds);
                    }

                    var6 = var11;
                    var7 = var12;
                }
            }
        }

        if (var2 != null && var3 != null && var2 != var3) {
            ds.b(Color.a(50, 0, 210, 210));
            float var20 = var3.g();
            float var21 = var3.h();
            var1.bO.a(var20 - var1.cw, var21 - var1.cx, var2.g() - var1.cw, var2.h() - var1.cx, ds);
        }

    }

    public strictfp void cb() {
    }

    public strictfp void e(float var1) {
        boolean var2 = false;
        if (this.cJ != 0.0F) {
            this.cJ = class_340.a(this.cJ, var1);
            if (this.cJ % 15.0F < 7.0F) {
                var2 = true;
            }
        }

        if (this.cG || var2) {
            GameEngine var3 = GameEngine.getGameEngine();
            if (this.dp()) {
                float var4 = this.xCord - var3.cw;
                float var5 = this.yCord - var3.cx - this.zCord;
                PlayerData var7 = var3.playerTeam;
                Paint var6;
                if (var7 == this.bX) {
                    if (this.ck < 8.0F) {
                        var6 = cX;
                    } else {
                        var6 = cY;
                    }
                } else if (var7.c(this.bX)) {
                    var6 = da;
                } else if (this.bX != null && var3.replayEngine.j()) {
                    cW.b(PlayerData.i(this.bX.team));
                    var6 = cW;
                } else {
                    var6 = dc;
                }

                if (var2) {
                    var6 = db;
                }

                if (this.bI()) {
                    if (var6 == cY) {
                        var6 = cZ;
                    }

                    Rect var8 = this.ce();
                    if (var8 != null) {
                        dr.a(var8);
                        RectF var10000 = dr;
                        var10000.b *= (float)var3.bL.o;
                        var10000 = dr;
                        var10000.d *= (float)var3.bL.o;
                        var10000 = dr;
                        var10000.a *= (float)var3.bL.n;
                        var10000 = dr;
                        var10000.c *= (float)var3.bL.n;
                        float var9 = this.db();
                        dr.a(-(this.cZ() - (float)var3.bL.p), -(this.da() - (float)var3.bL.q));
                        class_340.a(dr, var9);
                        dr.a(var4, var5);
                        float var10 = 11.0F;
                        var3.bO.a(dr.a - var10, dr.b, dr.c + var10, dr.b, var6);
                        var3.bO.a(dr.a - var10, dr.d, dr.c + var10, dr.d, var6);
                        var3.bO.a(dr.a, dr.b - var10, dr.a, dr.d + var10, var6);
                        var3.bO.a(dr.c, dr.b - var10, dr.c, dr.d + var10, var6);
                    }
                } else {
                    float var11 = this.ck + var3.bS.r(this);
                    if (var3.a(var4, var5, var11)) {
                        var3.bO.a(var4, var5, var11, var6);
                    }
                }
            }
        }

    }

    public strictfp boolean c(float var1) {
        return true;
    }

    public strictfp Rect cc() {
        return dw;
    }

    public strictfp Rect cd() {
        return dw;
    }

    public strictfp Rect ce() {
        return this.cc();
    }

    public strictfp TeamImageCache v() {
        return null;
    }

    public strictfp boolean f(float var1) {
        TeamImageCache var2 = this.v();
        if (var2 == null) {
            return false;
        } else if (this.bV) {
            return true;
        } else {
            GameEngine var3 = GameEngine.getGameEngine();
            var3.bO.l();
            float var4 = (float)((int)(this.xCord - var3.cw));
            float var5 = (float)((int)(this.yCord - var3.cx));
            var4 *= var3.cX;
            var5 *= var3.cX;
            Paint var6 = null;
            if (this.cG) {
                var6 = bJ;
            } else {
                var6 = bI;
            }

            var3.bO.a(var2, var4, var5, var6);
            var3.bO.k();
            var3.R();
            return true;
        }
    }

    public strictfp boolean a(GameEngine var1) {
        if (!var1.cO.b(this.xCord, this.yCord)) {
            return false;
        } else if (this.cN != null) {
            return false;
        } else if (this.cP != null && (this.cP.I || this.cP.C)) {
            return false;
        } else {
            return this.d(var1.playerTeam);
        }
    }

    public strictfp boolean c_() {
        return true;
    }

    public final strictfp boolean cf() {
        GameEngine var1 = GameEngine.getGameEngine();
        return this.d(var1.playerTeam);
    }

    public strictfp boolean d(PlayerData var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_484 var3 = var2.bL;
        if ((this.bX != var1 || this.cO != null) && var3.E && var1.N != null) {
            var3.a(this.xCord, this.yCord);
            int var4 = var3.T;
            int var5 = var3.U;
            if (var3.c(var4, var5) && var1.N[var4][var5] >= 5) {
                return false;
            }
        }

        return true;
    }

    public strictfp boolean cg() {
        return true;
    }

    public strictfp void f_() {
        if (this.bV) {
            this.bT = false;
        } else {
            this.bT = true;
        }
    }

    public strictfp void a(float var1) {
        if (!this.bV) {
            if (this.cw > 0.0F) {
                if (this.cw > this.totalHealth * 2.0F) {
                    this.cw = this.totalHealth * 2.0F;
                }

                this.cw = class_340.a(this.cw, var1);
            }

            if (this.health < this.totalHealth * 0.33F && this.zCord > -1.0F) {
                GameEngine var2 = GameEngine.getGameEngine();
                this.doo += var1;
                this.dp += var1;
                this.dq += var1;
                class_998 var3;
                if (this.doo > 10.0F && this.dp < 300.0F && !this.dl()) {
                    this.doo = 0.0F;
                    if (this.el && var2.dd) {
                        var3 = var2.bR.b(this.xCord, this.yCord, this.zCord, class_989.CUSTOM, false, Priority.verylow);
                        if (var3 != null) {
                            Emitter.b(var3, true);
                            var3.I = this.xCord;
                            var3.J = this.yCord;
                            var3.K = this.zCord;
                            var3.P += class_340.c(-0.1F, 0.1F) + this.cc;
                            var3.Q += class_340.c(-0.1F, 0.1F) + this.cd;
                            var3.I += class_340.c(-4.0F, 4.0F);
                            var3.J += class_340.c(-4.0F, 4.0F);
                        }
                    }
                }

                if (this.dq > 30.0F && this.dp < 600.0F && !this.dm()) {
                    this.dq = 0.0F;
                    var2.bR.a();
                    var3 = var2.bR.b(this.xCord, this.yCord, this.zCord, class_989.CUSTOM, false, Priority.verylow);
                    if (var3 != null) {
                        Emitter.a(var3, true);
                        var3.I = this.xCord;
                        var3.J = this.yCord;
                        var3.K = this.zCord;
                        var3.P += class_340.c(-0.1F, 0.1F);
                        var3.Q += class_340.c(-0.1F, 0.1F);
                        var3.I += class_340.c(-4.0F, 4.0F);
                        var3.J += class_340.c(-4.0F, 4.0F);
                    }
                }
            } else if (this.dp != 0.0F) {
                this.dp = 0.0F;
            }

            if (this.cC != 0.0F) {
                this.cC = class_340.a(this.cC, this.totalHealth * this.cD * 0.005F * var1);
                this.cD += var1 + 0.2F * this.cD * var1;
                if (this.cC == 0.0F) {
                    this.cD = 0.0F;
                }
            }

            if (this.health <= 0.0F) {
                this.ch();
            }
        }

    }

    public strictfp float b(Unit var1, float var2, Projectile var3) {
        float var4 = var2;
        float var5 = 1.0F;
        float var6 = 1.0F;
        float var7 = 1.0F;
        if (var3 != null) {
            var5 = var3.ak;
            var6 = var3.al;
            var7 = var3.am;
        }

        float var8;
        float var9;
        if (this.cx < this.cA) {
            var8 = this.cA - this.cx;
            var9 = var2 * var5;
            if (var8 > var9) {
                this.cx += var9;
                var4 = var2 - var9 * var6;
            } else {
                this.cx = this.cA;
                var4 = var2 - var9 * var6;
            }
        }

        if (var4 > 0.0F && this.health < this.totalHealth) {
            var8 = var4 * var7;
            var9 = this.totalHealth - this.health;
            if (var9 > var8) {
                this.o(this.health + var8);
                var4 = 0.0F;
            } else {
                this.o(this.totalHealth);
                float var10000 = var4 - var9;
            }
        }

        return 0.0F;
    }

    public strictfp boolean J() {
        return false;
    }

    public strictfp float a(Unit var1, float var2, Projectile var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        if (this.cm < 1.0F) {
            var2 *= 1.75F;
        }

        float var5 = 1.0F;
        float var6 = 1.0F;
        float var7 = 1.0F;
        if (var3 != null) {
            var5 = var3.ak;
            var6 = var3.al;
            var7 = var3.am;
        }

        float var8 = var2;
        float var9 = 0.0F;
        float var10;
        if (this.cz == 0.0F && this.cx > 0.0F) {
            var10 = var2 * var5;
            if (this.cx < var10) {
                var8 = var2 - this.cx * var6;
                var9 += this.cx;
                this.cy += this.cx;
                this.cx = 0.0F;
            } else {
                this.cx -= var10;
                this.cy += var10;
                var9 += var10;
                var8 = var2 - var2 * var6;
            }
        }

        if (var8 > 0.0F) {
            var10 = var8 * var7;
            float var10000;
            if (this.health < var10) {
                var8 -= this.health;
                var10000 = var9 + this.health;
                this.o(0.0F);
                this.cC += this.health;
            } else {
                this.o(this.health - var10);
                var10000 = var9 + var10;
                var8 -= var10;
                this.cC -= var10;
            }
        }

        this.bs = var4.by;
        if (var1 != null) {
            this.bt = var1;
        } else {
            this.bt = null;
        }

        this.ch();
        return var8;
    }

    public strictfp Unit q(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        return (float)var2.by - var1 * 1000.0F < (float)this.bs ? this.bt : null;
    }

    public strictfp void ch() {
        if (!this.bV && this.health <= 0.0F) {
            this.bv();
        }

    }

    public strictfp void n() {
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        return false;
    }

    public strictfp void bt() {
    }

    public strictfp void bu() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bS.l(this);
        PlayerData.a(this);
        if (bE.remove(this)) {
        }

        this.bV = true;
        this.bW = (long)var1.by;
        if (this.health > 0.0F) {
            this.health = 0.0F;
        }

        if (this.cL != null) {
            int var2 = this.bl();

            for(int var3 = 0; var3 < var2; ++var3) {
                this.cL[var3].j = null;
            }
        }

        var1.cc.a(this);
    }

    public strictfp void ci() {
        this.bu();
        this.a();
        this.bt();
    }

    public strictfp void cj() {
        this.health = -1.0F;
    }

    public strictfp void bv() {
        this.bu();
        if (!this.e()) {
            this.a();
        }

        this.bt();
    }

    public strictfp boolean a(RectF var1) {
        return this.xCord + this.cj > var1.a && this.xCord - this.cj < var1.c && this.yCord + this.cj > var1.b && this.yCord - this.cj < var1.d;
    }

    public final strictfp boolean c(float var1, float var2, float var3) {
        float var4 = class_340.a(this.xCord, this.yCord, var1, var2);
        float var5 = this.cj + var3;
        return var4 < var5 * var5;
    }

    public strictfp boolean t(Unit var1) {
        float var2 = class_340.a(this.xCord, this.yCord, var1.xCord, var1.yCord);
        float var3 = this.cj + var1.cj;
        return var2 < var3 * var3;
    }

    @SneakyThrows
    public final strictfp void P(int var1) {
        PlayerData var2 = PlayerData.getPlayerData(var1);
        if (var2 == null) {
            throw new MapException("Could not find team with id: " + var1);
        } else {
            this.e(var2);
        }
    }

    public strictfp void e(PlayerData var1) {
        if (this.bX != var1) {
            if (var1 == null) {
                throw new RuntimeException("Could not set team to null");
            } else {
                if (this.bX != null) {
                    PlayerData.b(this);
                    this.bX.d(this);
                }

                this.b(var1);
                PlayerData.c(this);
                if (var1 != PlayerData.i) {
                    this.c(false);
                }

            }
        }
    }

    public strictfp void b(PlayerData var1) {
        if (var1 == null) {
            throw new RuntimeException("Could not set team to null");
        } else {
            this.bX = var1;
        }
    }

    @SneakyThrows
    public final strictfp void Q(int var1) {
        this.bX = PlayerData.getPlayerData(var1);
        if (this.bX == null) {
            throw new MapException("Could not find team with id: " + var1);
        } else {
            this.b(this.bX);
        }
    }

    public strictfp ArrayList N() {
        return dx;
    }

    public strictfp int V() {
        return 1;
    }

    public strictfp void a(class_226 var1, boolean var2) {
    }

    public strictfp void a(class_226 var1, boolean var2, PointF var3, Unit var4) {
        this.a(var1, var2);
    }

    public strictfp void b(class_226 var1, boolean var2) {
    }

    public strictfp void a(class_226 var1) {
    }

    public strictfp class_226 a(class_1059 var1) {
        ArrayList var2 = this.N();
        int var3 = 0;

        for(int var4 = var2.size(); var3 < var4; ++var3) {
            class_226 var5 = (class_226)var2.get(var3);
            if (var5.d(var1)) {
                return var5;
            }
        }

        return null;
    }

    public strictfp boolean ck() {
        return this.bI() ? class_226.c(this.cm()) : false;
    }

    public strictfp boolean cl() {
        return false;
    }

    public strictfp class_1059 cm() {
        return class_226.i;
    }

    public strictfp float cn() {
        return -1.0F;
    }

    public strictfp boolean co() {
        return false;
    }

    public strictfp void a(ArrayList var1) {
        var1.clear();
    }

    public strictfp class_1059 cp() {
        return class_226.i;
    }

    public strictfp class_226 e(class_31 var1) {
        return null;
    }

    public final strictfp int cq() {
        int var1 = 0;
        Iterator var2 = this.N().iterator();

        while(true) {
            class_226 var3;
            do {
                if (!var2.hasNext()) {
                    return var1;
                }

                var3 = (class_226)var2.next();
            } while(!var3.b(this) && !var3.s());

            ++var1;
        }
    }

    public strictfp boolean c(Unit var1, boolean var2) {
        Unit var3 = var1.cN;
        OrderableUnit var4 = var1.cO;
        var1.cN = null;
        var1.cO = null;
        boolean var5 = this.d(var1, var2);
        var1.cN = var3;
        var1.cO = var4;
        return var5;
    }

    public strictfp boolean d(Unit var1, boolean var2) {
        return false;
    }

    public strictfp boolean e(Unit var1, boolean var2) {
        return false;
    }

    public strictfp boolean cr() {
        return false;
    }

    public strictfp float cs() {
        return 21.0F;
    }

    public abstract MovementType h();

    public abstract boolean i();

    public strictfp boolean ct() {
        return this.i();
    }

    public abstract boolean Q();

    public abstract boolean aj();

    public abstract boolean ak();

    public strictfp boolean cu() {
        return false;
    }

    public strictfp boolean cv() {
        return false;
    }

    public strictfp boolean P() {
        return false;
    }

    public strictfp int cw() {
        return 1;
    }

    public abstract boolean s_();

    public strictfp int y() {
        return 85;
    }

    public strictfp float f(class_31 var1) {
        int var2 = var1.a(this) + this.y();
        return (float)var2;
    }

    public strictfp int u(Unit var1) {
        return this.y() + var1.r().a(this);
    }

    public strictfp int v(Unit var1) {
        return this.y() + var1.r().a(this);
    }

    public strictfp boolean w(Unit var1) {
        return false;
    }

    public strictfp boolean x(Unit var1) {
        return false;
    }

    public strictfp float b(Unit var1) {
        return 1.0F;
    }

    public strictfp float c(Unit var1) {
        return 0.2F;
    }

    public strictfp boolean y(Unit var1) {
        boolean var2 = false;
        boolean var3 = var1.g() > 0.0F;
        if (var3) {
            var2 = true;
        }

        return var2;
    }

    public strictfp float z(Unit var1) {
        float var2 = 5.1F;
        float var3 = this.c(var1) * var2;
        boolean var4 = var1.g() > 0.0F;
        if (var4) {
            var3 = var1.g();
        }

        return var3;
    }

    public strictfp float cx() {
        return 1.0F;
    }

    public strictfp float cy() {
        return 0.0F;
    }

    public strictfp class_1069 cz() {
        float var1 = this.cy();
        if (var1 == 0.0F) {
            return class_1069.a;
        } else {
            class_1069 var2 = new class_1069();
            var2.b(BuiltInResource.D, (double)var1);
            return var2;
        }
    }

    public strictfp class_1069 cA() {
        return class_1069.a;
    }

    public abstract class_31 r();

    public strictfp String cB() {
        return this.r().i() + "(id:" + this.id + ")";
    }

    public static strictfp String f(Unit var0, boolean var1) {
        return var0 != null ? var0.r().e() : "No unit";
    }

    public static strictfp String A(Unit var0) {
        return var0 != null ? var0.c() : "<null unit>";
    }

    public strictfp String c() {
        String var1 = this.r().i() + "(pos:" + (int)this.xCord + "," + (int)this.yCord + " id:" + this.id + "";
        if (this.bX != null) {
            var1 = var1 + " t:" + this.bX.site;
        }

        if (this.bV) {
            var1 = var1 + " [dead]";
        }

        if (this.ej) {
            var1 = var1 + " [deleted]";
        }

        var1 = var1 + ")";
        return var1;
    }

    public strictfp String cC() {
        String var1 = this.r().i() + "(pos:" + (int)this.xCord + "," + (int)this.yCord + " id:" + this.id + "";
        var1 = var1 + ", hp:" + this.health + ", dead:" + this.bV + ", deleted:" + this.ej + " tags:" + this.de();
        if (this.bX != null) {
            var1 = var1 + " t:" + this.bX.site;
        }

        var1 = var1 + ")";
        return var1;
    }

    public strictfp float cD() {
        return 1.0F;
    }

    public strictfp RectF cE() {
        GameEngine var1 = GameEngine.getGameEngine();
        float var2 = this.cD();
        dA.a(this.xCord - this.eu * var2 - var1.cw, this.yCord - this.ev * var2 - var1.cx, this.xCord + this.eu * var2 - var1.cw, this.yCord + this.ev * var2 - var1.cx);
        return dA;
    }

    public strictfp RectF cF() {
        GameEngine var1 = GameEngine.getGameEngine();
        RectF var2 = dA;
        float var3 = var1.cw;
        float var4 = var1.cx;
        float var5 = this.eu;
        float var6 = this.ev;
        var2.a = this.xCord - var5 - var3;
        var2.c = this.xCord + var5 - var3;
        var2.b = this.yCord - var6 - var4;
        var2.d = this.yCord + var6 - var4;
        return var2;
    }

    public strictfp boolean cG() {
        return false;
    }

    public strictfp Rect a_(boolean var1) {
        byte var2 = 0;
        byte var3 = 0;
        dC.a = var2;
        dC.b = var3;
        dC.c = var2 + this.es;
        dC.d = var3 + this.et;
        return dC;
    }

    public strictfp Rect a(boolean var1, int var2) {
        int var3 = 0;
        byte var4 = 0;
        var3 += var2 * this.es;
        dC.a(var3, var4, var3 + this.es, var4 + this.et);
        return dC;
    }

    public strictfp Rect a(boolean var1, int var2, int var3) {
        int var4 = this.es;
        int var5 = this.et;
        int var6 = var2 * var4;
        int var7 = var3 * var5;
        dC.a = var6;
        dC.b = var7;
        dC.c = var6 + var4;
        dC.d = var7 + var5;
        return dC;
    }

    public strictfp boolean a(Unit var1, float var2) {
        return false;
    }

    public strictfp void a_(String var1) {
    }

    public final strictfp boolean cH() {
        return this.cJ() && !(this.zCord > 2.0F);
    }

    public strictfp boolean cI() {
        return class_694.b(this.xCord, this.yCord);
    }

    public strictfp boolean cJ() {
        return class_694.c(this.xCord, this.yCord);
    }

    public strictfp boolean cK() {
        return class_694.d(this.xCord, this.yCord);
    }

    public strictfp int bw() {
        int var1 = 0;
        var1 = var1 * 31 + (int)this.mass();
        var1 = var1 * 31 + (int)this.totalHealth;
        return var1;
    }

    public strictfp int cL() {
        return this.r().b(this.V());
    }

    public strictfp class_447 cM() {
        return this.r().d(this.V());
    }

    public strictfp class_447 cN() {
        return null;
    }

    public strictfp PointF a(float var1, float var2, float var3, float var4, float var5) {
        float var6 = 0.0F;
        if ((double)var3 > 0.1 && this.cK) {
            float var7 = 1.0F / var3;

            for(int var8 = 0; var8 < 3; ++var8) {
                PointF var9 = this.m(var6);
                float var10 = class_340.b(var1, var2, var9.x, var9.y);
                var6 = var10 * var7;
            }
        }

        if (var6 > var4) {
            var6 = var4;
        }

        PointF var11 = this.m(var6);
        float var12 = class_340.a(var1, var2, var11.x, var11.y);
        if (var5 >= 0.0F && var5 * var5 < var12) {
            float var13 = class_340.d(var1, var2, var11.x, var11.y);
            var11.x = var1 + class_340.k(var13) * var5;
            var11.y = var2 + class_340.j(var13) * var5;
        }

        dD.setSite(var11);
        return dD;
    }

    strictfp PointF m(float var1) {
        dE.setSite(this.xCord + this.cc * var1, this.yCord + this.cd * var1);
        return dE;
    }

    public abstract boolean l();

    public strictfp boolean o() {
        return false;
    }

    public strictfp boolean p() {
        return false;
    }

    public strictfp boolean cO() {
        return false;
    }

    public strictfp void f(PlayerData var1) {
        if (this.p()) {
            this.b(PlayerData.i);
        } else {
            this.b(var1);
        }
    }

    public strictfp void B(Unit var1) {
        if (var1 instanceof EditorOrBuilder) {
            var1 = null;
        }

        this.bu = var1;
    }

    public strictfp void cP() {
    }

    public strictfp float g() {
        return 0.0F;
    }

    public strictfp int cQ() {
        return Integer.MAX_VALUE;
    }

    public strictfp class_588 cR() {
        return null;
    }

    public strictfp boolean g(Unit var1, boolean var2) {
        return false;
    }

    public strictfp boolean h(Unit var1, boolean var2) {
        return this.g(var1, var2);
    }

    public strictfp int cS() {
        return 500;
    }

    public strictfp boolean c(OrderableUnit var1) {
        int var2 = this.cQ();
        if (var2 < Integer.MAX_VALUE) {
            int var3 = this.d(var1);
            if (var3 >= var2) {
                return true;
            }
        }

        return false;
    }

    public strictfp int d(OrderableUnit var1) {
        int var2 = 0;
        PlayerData var3 = var1.bX;
        Unit[] var4 = bE.a();
        int var5 = 0;

        for(int var6 = bE.size(); var5 < var6; ++var5) {
            Unit var7 = var4[var5];
            if (var7.bX == var3 && var7 instanceof OrderableUnit) {
                OrderableUnit var8 = (OrderableUnit)var7;
                class_1042 var9 = var8.ar();
                if (var9 != null && var9.d() == WaypointType.reclaim && var9.h == this && var7 != var1) {
                    ++var2;
                }
            }
        }

        return var2;
    }

    public strictfp int e(OrderableUnit var1) {
        int var2 = 0;
        PlayerData var3 = var1.bX;
        Unit[] var4 = bE.a();
        int var5 = 0;

        for(int var6 = bE.size(); var5 < var6; ++var5) {
            Unit var7 = var4[var5];
            if (var7.bX == var3 && var7 instanceof OrderableUnit) {
                OrderableUnit var8 = (OrderableUnit)var7;
                class_1042 var9 = var8.ar();
                if (var9 != null && var9.d() == WaypointType.repair && var9.h == this && var7 != var1) {
                    ++var2;
                }
            }
        }

        return var2;
    }

    public strictfp int bl() {
        return 1;
    }

    public strictfp boolean u() {
        return false;
    }

    public strictfp boolean cT() {
        return this.u() || this.cm < 1.0F || this.bX == PlayerData.h;
    }

    public strictfp boolean cU() {
        return !this.u();
    }

    public strictfp boolean t() {
        return false;
    }

    public strictfp boolean cV() {
        return this.t();
    }

    public strictfp boolean cW() {
        return false;
    }

    public strictfp boolean d(Unit var1) {
        return true;
    }

    public strictfp void g(PlayerData var1) {
        if (this.dF == null || this.dF.length != PlayerData.c) {
            this.dF = new class_1047[PlayerData.c];

            for(int var2 = 0; var2 < this.dF.length; ++var2) {
                this.dF[var2] = new class_1047();
            }
        }

        class_1047 var4 = this.dF[var1.site];
        boolean var3;
        if (this.bV) {
            if (var4.a) {
                var3 = this.d(var1);
                if (var3) {
                    var4.a = false;
                }
            }
        } else {
            var3 = this.d(var1);
            if (var3) {
                var4.a = true;
                var4.b = this.V();
            }
        }

    }

    public strictfp void cX() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.playerTeam != null && this.bX != var1.playerTeam && var1.playerTeam.site >= 0 && var1.playerTeam.site < PlayerData.c) {
            class_1047 var2 = this.dF[var1.playerTeam.site];
            if (var2.c != null && var2.c.c) {
                var2.c = null;
            }

            if (var2.c == null && var2.a) {
                boolean var3 = this.d(var1.playerTeam);
                if (!var3) {
                    class_990 var4 = new class_990();
                    var2.c = var4;
                    var4.d = this.r();
                    var4.g = this.xCord;
                    var4.h = this.yCord;
                    var4.n = false;
                    var4.e = this.bX;
                    var4.f = var2.b;
                    var4.j = var1.playerTeam;
                    var4.u = this.c_();
                    var4.v = this;
                }
            }
        }

    }

    public strictfp PointF cY() {
        dG.setSite(0.0F, 0.0F);
        return dG;
    }

    public strictfp float cZ() {
        return (float)GameEngine.getGameEngine().bL.p;
    }

    public strictfp float da() {
        return (float)GameEngine.getGameEngine().bL.q;
    }

    public strictfp float db() {
        GameEngine var1 = GameEngine.getGameEngine();
        return (float)(var1.bL.p + 2) + var1.bS.r(this);
    }

    public strictfp Point a(class_484 var1, Point var2) {
        var2.a = (int)((this.xCord - this.cZ() + 1.0F) * var1.r);
        var2.b = (int)((this.yCord - this.da() + 1.0F) * var1.s);
        return var2;
    }

    public strictfp RectF a(class_484 var1, RectF var2) {
        int var3 = (int)((this.xCord - this.cZ() + 1.0F) * var1.r);
        int var4 = (int)((this.yCord - this.da() + 1.0F) * var1.s);
        var1.a(var3, var4);
        float var5 = (float)var1.T;
        float var6 = (float)var1.U;
        Rect var7 = this.cd();
        var2.a(var5 + (float)(var7.a * var1.n), var6 + (float)(var7.b * var1.o), var5 + (float)((var7.c + 1) * var1.n), var6 + (float)((var7.d + 1) * var1.o));
        return var2;
    }

    public strictfp void dc() {
    }

    public strictfp boolean dd() {
        return false;
    }

    public strictfp boolean q() {
        return false;
    }

    public strictfp class_588 de() {
        return null;
    }

    public strictfp class_1069 df() {
        return this.dH;
    }

    public strictfp double a(BuiltInResource var1) {
        return this.dH.a(var1);
    }

    public strictfp class_635 dg() {
        return this.dI;
    }

    public strictfp class_588 dh() {
        return null;
    }

    public strictfp float bd() {
        return 0.0F;
    }

    public strictfp void di() {
    }

    public strictfp void dj() {
    }

    public strictfp boolean dk() {
        return false;
    }

    public strictfp boolean dl() {
        return this.bO();
    }

    public strictfp boolean dm() {
        return this.bO();
    }

    public final strictfp class_826 dn() {
        return this.cP;
    }

    public strictfp String toString() {
        return "unit(id=" + this.id + ",type=" + this.r().i() + ")";
    }

    public strictfp void r(float var1) {
        boolean var2;
        if (var1 >= 1.0F) {
            var2 = this.cm >= 1.0F;
            if (!var2) {
                PlayerData.b(this);
                this.cm = 1.0F;
                PlayerData.c(this);
            }
        } else {
            var2 = this.cm >= 1.0F;
            if (var2) {
                PlayerData.b(this);
                this.cm = var1;
                PlayerData.c(this);
            } else {
                this.cm = var1;
            }
        }

    }

    public final strictfp void a(GameEvent var1) {
        this.a(var1, (Unit)null, (class_588)null, (VariableScope)null);
    }

    public final strictfp void a(GameEvent var1, Unit var2) {
        this.a(var1, var2, (class_588)null, (VariableScope)null);
    }

    public strictfp void a(GameEvent var1, Unit var2, class_588 var3, VariableScope var4) {
    }

    public strictfp void h(float var1) {
        this.cg = var1;
    }

    public strictfp int a(class_585 var1) {
        return 0;
    }

    public strictfp class_684 e(boolean var1) {
        return null;
    }

    public strictfp boolean a(int var1, int var2) {
        return false;
    }

    public strictfp void c(boolean var1) {
    }

    public strictfp float doo() {
        return this.cj;
    }

    public strictfp boolean dp() {
        return true;
    }

    public strictfp void bC() {
    }

    public final strictfp class_447 dq() {
        return this.dJ;
    }

    public final strictfp Unit dr() {
        Object var1 = this.cO;
        if (var1 == null && this.cN != null) {
            var1 = this.cN;
        }

        return (Unit)var1;
    }

    public strictfp void f(float var1, float var2) {
        this.xCord = var1;
        this.yCord = var2;
        this.c(true);
    }

    static {
        bI.a(true);
        bI.a(255, 195, 195, 195);
        bJ = new class_525();
        bJ.a(true);
        bK = new LightingColorFilter(Color.a(255, 255, 255), Color.a(100, 100, 100));
        bJ.a(255, 255, 255, 255);
        bJ.a((ColorFilter)bK);
        cW = new Paint();
        cX = new class_525();
        cY = new class_525();
        cZ = new class_525();
        da = new class_525();
        db = new class_525();
        dc = new class_525();
        dd = new Paint();
        de = new Paint();
        df = new Paint();
        dg = new class_525();
        dh = new class_525();
        di = new class_525();
        dj = new class_525();
        dk = new Paint();
        cW.a(Paint$Style.b);
        cW.a(2.0F);
        a(cW);
        cX.a(180, 0, 255, 0);
        cX.a(Paint$Style.b);
        cX.a(2.0F);
        a(cX, true);
        cY.a(180, 0, 255, 0);
        cY.a(Paint$Style.b);
        cY.a(2.0F);
        a(cY);
        cZ.a(130, 0, 255, 0);
        cZ.a(Paint$Style.b);
        cZ.a(2.0F);
        a(cZ);
        dd.a(70, 0, 255, 0);
        dd.a(Paint$Style.b);
        dd.a(1.0F);
        a(dd);
        da.a(180, 255, 0, 0);
        da.a(Paint$Style.b);
        da.a(2.0F);
        a(da);
        de.a(70, 255, 0, 0);
        de.a(Paint$Style.b);
        de.a(1.0F);
        a(de);
        dc.a(180, 255, 255, 0);
        dc.a(Paint$Style.b);
        dc.a(2.0F);
        a(dc);
        df.a(70, 255, 255, 0);
        df.a(Paint$Style.b);
        df.a(1.0F);
        a(df);
        db.a(180, 255, 255, 255);
        db.a(Paint$Style.b);
        db.a(2.0F);
        a(db);
        dg.a(90, 235, 235, 235);
        dg.a(Paint$Style.b);
        dg.a(1.0F);
        a(dg);
        dh.a(100, 235, 235, 235);
        dh.a(Paint$Style.b);
        dh.a(2.0F);
        a(dh);
        di.a(90, 235, 0, 0);
        di.a(Paint$Style.b);
        di.a(1.0F);
        a(di);
        dj.a(Paint$Style.b);
        dk.a(Paint$Style.b);
        dr = new RectF();
        ds = new Paint();
        dt = new Paint();
        du = new RectF();
        dv = new Rect();
        dw = new Rect();
        dx = new ArrayList();
        dy = new ArrayList();
        dA = new RectF();
        dB = new RectF();
        dC = new Rect();
        dD = new PointF();
        dE = new PointF();
        dG = new PointF();
    }
}
