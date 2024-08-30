package com.corrodinggames.rts.game.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.a.a.class_462;
import com.corrodinggames.rts.game.a.a.class_1002;
import com.corrodinggames.rts.game.units.WaypointType;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_1050;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.AttackMovementType;
import com.corrodinggames.rts.game.units.AttackMode;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.DamagingBorder;
import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.air.AmphibiousJet;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.buildings.LandFactory;
import com.corrodinggames.rts.game.units.buildings.SeaFactory;
import com.corrodinggames.rts.game.units.buildings.class_8;
import com.corrodinggames.rts.game.units.buildings.AirFactory;
import com.corrodinggames.rts.game.units.buildings.CommandCenter;
import com.corrodinggames.rts.game.units.sea.AttackSubmarine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.k.PathEngine;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_692;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

// $FF: renamed from: com.corrodinggames.rts.game.a.a
public final strictfp class class_138 extends PlayerData {
    public static boolean as;
    final int at;
    int serverHostFlag;
    int av;
    int aw;
    int ax;
    int ay;
    int az;
    int aA;
    int aB;
    int aC;
    int aD;
    int aE;
    int aF;
    int aG;
    int aH;
    public int aI;
    int aJ;
    boolean aK;
    float aL;
    float aM;
    float aN;
    float aO;
    float aP;
    float aQ;
    float aR;
    float aS;
    float aT;
    float aU;
    int aV;
    float aW;
    public boolean aX;
    public boolean aY;
    public boolean aZ;
    int ba;
    int bb;
    int bc;
    boolean bd;
    boolean be;
    boolean bf;
    DamagingBorder bg;
    boolean bh;
    boolean bi;
    boolean bj;
    boolean bk;
    int bl;
    ConcurrentLinkedQueue bm;
    ArrayList bn;
    PointF bo;
    Paint bp;
    ArrayList bq;
    class_564 br;
    class_564 bs;
    class_564 bt;
    class_564 bu;
    class_564 bv;
    class_564 bw;
    class_564 bx;
    class_564 by;
    class_564 bz;
    class_564 bA;
    class_564 bB;
    class_564 bC;
    class_564 bD;
    public class_655 bE;
    int bF;
    public float bG;
    ArrayList bH;
    private static ArrayList bK = new ArrayList();
    public static final class_692 bI = new class_692();
    public final class_684 bJ;

    public boolean ac() {
        int var1 = this.ag();
        return this.ag() == 3 || var1 > 300;
    }

    public boolean ad() {
        return this.ag() >= 2;
    }

    public boolean ae() {
        return (1 & this.aJ) == 1;
    }

    public boolean af() {
        return this.ae();
    }

    public int ag() {
        return this.bF;
    }

    public boolean ah() {
        PathEngine var1 = GameEngine.getGameEngine().bU;
        return var1.A.i > 3000;
    }

    public boolean ai() {
        if (this.ah()) {
            return true;
        } else if (this.bh && this.bi) {
            if (!this.bj) {
                return true;
            } else {
                return !this.bk;
            }
        } else {
            return true;
        }
    }

    public boolean aj() {
        if (!this.bk) {
            return false;
        } else {
            return this.ai() && this.bi;
        }
    }

    public boolean a(float var1, float var2, class_63 var3, MovementType var4) {
        if (this.a(var1, var2, var3.S, var3.T, var4)) {
            return true;
        } else {
            for(float var5 = -180.0F; var5 < 180.0F; var5 += 90.0F) {
                float var6 = var3.S + class_340.k(var5) * var3.U * 0.4F;
                float var7 = var3.T + class_340.j(var5) * var3.U * 0.4F;
                if (this.a(var1, var2, var6, var7, var4)) {
                    return true;
                }
            }

            return false;
        }
    }

    public boolean a(float var1, float var2, float var3, float var4, MovementType var5) {
        if (var5 != MovementType.AIR && var5 != MovementType.NONE) {
            short var6 = class_694.b(var1, var2, var5);
            short var7 = class_694.b(var3, var4, var5);
            if (var6 == -3 || var7 == -3) {
                String var8 = "null";
                if (var5 != null) {
                    var8 = var5.name();
                }

                this.d("pathPossible: no isolatedGroups found! (" + var8 + ")");
                GameEngine.T();
            }

            if (var6 != -1 && var7 != -1) {
                if (var6 == -2) {
                    return false;
                } else if (var7 == -2) {
                    return false;
                } else {
                    return var6 == var7;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public boolean a(Unit var1, float var2, float var3) {
        return this.a(var1.xCord, var1.yCord, var2, var3, var1.h());
    }

    public boolean b(Unit var1, float var2, float var3) {
        float var4 = 60.0F;
        MovementType var5 = var1.h();
        if (this.a(var1.xCord, var1.yCord, var2, var3, var5)) {
            return true;
        } else if (this.a(var1.xCord, var1.yCord, var2 + var4, var3, var5)) {
            return true;
        } else if (this.a(var1.xCord, var1.yCord, var2 - var4, var3, var5)) {
            return true;
        } else if (this.a(var1.xCord, var1.yCord, var2, var3 + var4, var5)) {
            return true;
        } else {
            return this.a(var1.xCord, var1.yCord, var2, var3 - var4, var5);
        }
    }

    public boolean a(Unit var1, Unit var2) {
        return this.b(var1, var2.xCord, var2.yCord);
    }

    public void a(GameOutputStream var1) {
        var1.writeBoolean(this.aK);
        var1.writeFloat(this.aL);
        var1.writeFloat(this.aM);
        var1.writeFloat(this.aN);
        var1.writeFloat(this.aO);
        var1.writeFloat(this.aT);
        var1.writeInt(this.aV);
        var1.writeFloat(this.aW);
        var1.writeBoolean(this.aX);
        var1.writeInt(this.ba);
        var1.writeInt(this.bm.size());
        Iterator var2 = this.bm.iterator();

        class_63 var3;
        while(var2.hasNext()) {
            var3 = (class_63)var2.next();
            boolean var4 = true;
            byte var7;
            if (var3 instanceof class_69) {
                var7 = 1;
            } else if (var3 instanceof class_68) {
                var7 = 2;
            } else if (var3 instanceof class_66) {
                var7 = 3;
            } else if (var3 instanceof PlainZone) {
                var7 = 4;
            } else {
                if (!(var3 instanceof class_67)) {
                    throw new RuntimeException("zone not instance not supported:" + var3.getClass().getName());
                }

                var7 = 5;
            }

            var1.writeByte(var7);
            var1.writeInt(var3.Q);
        }

        var2 = this.bm.iterator();

        while(var2.hasNext()) {
            var3 = (class_63)var2.next();
            var1.writeInt(var3.Q);
            var3.a(var1);
        }

        var1.writeByte(9);
        var1.writeInt(this.aI);
        var1.writeBoolean(this.bd);
        var1.writeBoolean(this.bh);
        var1.writeBoolean(this.bi);
        var1.writeBoolean(this.bj);
        var1.writeBoolean(this.bk);
        var1.writeFloat(this.aU);
        var1.writeInt(this.bl);
        var1.writeInt(this.serverHostFlag);
        var1.writeInt(this.av);
        var1.writeInt(this.aw);
        var1.writeBoolean(this.aY);
        var1.writeInt(this.aJ);
        var1.e();
        var1.writeInt(this.bJ.a);

        for(int var5 = 0; var5 < this.bJ.a; ++var5) {
            class_1002 var6 = (class_1002)this.bJ.get(var5);
            var1.writeSimilarEnum(var6.a());
            var6.a(var1);
        }

        var1.e();
        super.a(var1);
    }

    public class_63 l(int var1) {
        if (var1 == 1) {
            return new class_69(this, -1.0F, -1.0F);
        } else if (var1 == 2) {
            return new class_68(this);
        } else if (var1 == 3) {
            return new class_66(this);
        } else if (var1 == 4) {
            return new PlainZone(this);
        } else if (var1 == 5) {
            return new class_67(this);
        } else if (var1 == 0) {
            GameEngine.print("Found zone type 0, loading PlainZone instead");
            return new PlainZone(this);
        } else {
            throw new RuntimeException("Unknown zone type:" + var1);
        }
    }

    public void c(GameInputStream var1) {
        this.aK = var1.readBoolean();
        this.aL = var1.readFloat();
        this.aM = var1.readFloat();
        this.aN = var1.readFloat();
        this.aO = var1.readFloat();
        this.aT = var1.readFloat();
        this.aV = var1.readInt();
        this.aW = var1.readFloat();
        this.aX = var1.readBoolean();
        this.ba = var1.readInt();
        int var2 = var1.readInt();
        this.bm.clear();
        boolean var3 = false;
        int var4;
        int var5;
        if (var1.b() >= 20) {
            var3 = true;

            for(var4 = 0; var4 < var2; ++var4) {
                var5 = var1.readByte();
                class_63 var6 = this.l(var5);
                var6.Q = var1.readInt();
            }
        }

        int var11;
        for(var4 = 0; var4 < var2; ++var4) {
            class_63 var10;
            if (!var3) {
                var11 = var1.readByte();
                var10 = this.l(var11);
            } else {
                var10 = this.m(var1.readInt());
            }

            var10.a(var1);
        }

        byte var9 = var1.readByte();
        if (var9 >= 1) {
            this.aI = var1.readInt();
        }

        this.bn.clear();
        this.bn.addAll(this.bm);
        if (var9 >= 2) {
            this.bd = var1.readBoolean();
            this.bh = var1.readBoolean();
            this.bi = var1.readBoolean();
        }

        if (var9 >= 3) {
            this.bj = var1.readBoolean();
            this.bk = var1.readBoolean();
        }

        if (var9 >= 4) {
            this.aU = var1.readFloat();
        }

        if (var9 >= 5) {
            this.bl = var1.readInt();
        }

        if (var9 >= 6) {
            this.serverHostFlag = var1.readInt();
            this.av = var1.readInt();
            this.aw = var1.readInt();
        }

        if (var9 >= 7) {
            this.aY = var1.readBoolean();
        }

        if (var9 >= 8) {
            this.aJ = var1.readInt();
        }

        if (var9 >= 9) {
            var1.checkMark("ai-c s");
            this.bJ.clear();
            var5 = var1.readInt();

            for(var11 = 0; var11 < var5; ++var11) {
                class_462 var7 = (class_462)var1.readSimilarEnum(class_462.class);
                class_1002 var8 = var7.a();
                var8.a(var1);
                this.a(var8);
            }

            var1.checkMark("ai-c e");
        }

        super.c(var1);
        this.ak();
    }

    public class_63 m(int var1) {
        Iterator var2 = this.bm.iterator();

        class_63 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_63)var2.next();
        } while(var3.Q != var1);

        return var3;
    }

    public int a(class_63 var1) {
        return var1 == null ? -1 : var1.Q;
    }

    void ak() {
        this.az = 0;
        this.aC = 0;
        this.aD = 0;
        this.aE = 0;
        this.aA = 0;
        this.aB = 0;
        this.aF = 0;
        this.aG = 0;
        this.ax = 0;
        this.ay = 0;
        this.aH = 0;
        Iterator var1 = this.bn.iterator();

        while(true) {
            class_63 var2;
            while(true) {
                if (!var1.hasNext()) {
                    return;
                }

                var2 = (class_63)var1.next();
                if (var2 instanceof class_69) {
                    class_69 var3 = (class_69)var2;
                    ++this.ax;
                    if (var3.u() >= 2) {
                        ++this.ay;
                    }

                    if (var3.n) {
                        ++this.aH;
                    }
                }

                if (!(var2 instanceof class_68)) {
                    break;
                }

                class_68 var4 = (class_68)var2;
                if (!var4.a) {
                    if (var4.h) {
                        ++this.az;
                        if (!var4.v && !var4.d()) {
                            if (!var4.B) {
                                ++this.aA;
                            } else {
                                ++this.aB;
                            }
                        }
                    } else {
                        ++this.aC;
                        if (var4.d()) {
                            ++this.aD;
                        }

                        this.aE += var4.l();
                    }
                    break;
                }
            }

            if (var2 instanceof class_66) {
                class_65 var5 = (class_65)var2;
                ++this.aF;
                if (var5.l() > 0) {
                    ++this.aG;
                }
            }
        }
    }

    private boolean a(class_31 var1) {
        Unit var2 = Unit.b(var1);
        if (!var2.bI() && var2 instanceof OrderableUnit && !this.g(var2) && !var2.aj() && ((OrderableUnit)var2).l()) {
            if (var1 instanceof class_591) {
                class_591 var3 = (class_591)var1;
                if (var3.fw || !var3.fs) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public class_138(int var1) {
        this(var1, true);
    }

    public class_138(int var1, boolean var2) {
        super(var1, var2);
        this.at = 3000;
        this.aJ = 0;
        this.aR = 0.0F;
        this.aS = 0.0F;
        this.bd = true;
        this.be = true;
        this.bf = false;
        this.bm = new ConcurrentLinkedQueue();
        this.bn = new ArrayList();
        this.bo = new PointF();
        this.bq = new ArrayList();
        this.br = new class_572(this, "attackingUnitsLand");
        this.bs = new class_571(this, "attackingUnitsHover");
        this.bt = new class_565(this, "attackingUnitsAir");
        this.bu = new class_566(this, "attackingUnitsWater");
        this.bv = new class_567(this, "buildingUnits");
        this.bw = new class_577(this, "transportUnits");
        this.bx = new class_576(this, "transportUnitsFlying");
        this.by = new class_575(this, "transportUnitsNonFlying");
        this.bz = new class_574(this, "builderUnits");
        this.bA = new class_573(this, "harvesterUnits");
        this.bB = new class_568(this, "extractorUnits");
        this.bC = new class_569(this, "buildingFactories");
        this.bD = new class_570(this, "buildingFactoriesForBuilders");
        this.bE = new class_655();
        this.bG = 0.0F;
        this.bH = new ArrayList();
        this.bJ = new class_684();
        this.av();
    }

    private void av() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.aL = (float)(100 + this.site * 9);
        this.aN = (float)(202 + this.site * 19);
        this.aP = (float)(50 + this.site * 2);
        this.aW = (float)(4200 + this.site * 5);
        this.aT = (float)(3500 + this.site * 5);
        this.aU = (float)(7500 + this.site * 5);
        this.bp = new Paint();
        this.bp.b(Color.a(0, 255, 0));
        this.bp.a(Paint$Style.b);
        this.bp.a(true);
        var1.b(this.bp, 14.0F);
        this.al();
    }

    public void al() {
        Iterator var1 = this.bq.iterator();

        while(var1.hasNext()) {
            class_564 var2 = (class_564)var1.next();
            var2.b();
        }

    }

    public void d(String var1) {
        GameEngine.b("ai_debug(" + this.site + ")", var1);
    }

    public PointF am() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bL.a(class_340.rand(0, var1.bL.width), class_340.rand(0, var1.bL.height));
        this.bo.setSite((float)var1.bL.T, (float)var1.bL.U);
        return this.bo;
    }

    public PointF an() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.bL.A.size() == 0) {
            return null;
        } else {
            int var2 = class_340.c(var1.bL.A.size());
            Point var3 = (Point)var1.bL.A.get(var2);
            var1.bL.a(var3.a, var3.b);
            this.bo.setSite((float)var1.bL.T, (float)var1.bL.U);
            return this.bo;
        }
    }

    public PointF a(float var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        float var4 = -1.0F;
        PointF var5 = new PointF();

        for(int var6 = 0; var6 < var3.bL.A.size(); ++var6) {
            Point var7 = (Point)var3.bL.A.get(var6);
            var3.bL.a(var7.a, var7.b);
            this.bo.setSite((float)var3.bL.T, (float)var3.bL.U);
            PointF var8 = this.bo;
            float var9 = class_340.a(var8.x, var8.y, var1, var2);
            if (var9 < var4 || var4 == -1.0F) {
                var4 = var9;
                var5.setSite(var8);
            }
        }

        if (var4 == -1.0F) {
            return null;
        } else {
            return var5;
        }
    }

    class_69 e(Unit var1) {
        Iterator var2 = this.bn.iterator();

        while(var2.hasNext()) {
            class_63 var3 = (class_63)var2.next();
            if (var3 instanceof class_69) {
                class_69 var4 = (class_69)var3;
                if (var4.b(var1)) {
                    return var4;
                }
            }
        }

        return null;
    }

    class_69 b(float var1, float var2) {
        Iterator var3 = this.bn.iterator();

        while(var3.hasNext()) {
            class_63 var4 = (class_63)var3.next();
            if (var4 instanceof class_69) {
                class_69 var5 = (class_69)var4;
                if (var5.c(var1, var2)) {
                    return var5;
                }
            }
        }

        return null;
    }

    class_69 f(Unit var1) {
        return this.c(var1.xCord, var1.yCord);
    }

    class_69 c(float var1, float var2) {
        float var3 = -1.0F;
        class_69 var4 = null;
        Iterator var5 = this.bn.iterator();

        while(true) {
            class_69 var7;
            float var8;
            do {
                class_63 var6;
                do {
                    if (!var5.hasNext()) {
                        return var4;
                    }

                    var6 = (class_63)var5.next();
                } while(!(var6 instanceof class_69));

                var7 = (class_69)var6;
                var8 = var7.d(var1, var2);
            } while(var4 != null && !(var8 < var3));

            var3 = var8;
            var4 = var7;
        }
    }

    class_69 a(MovementType var1, float var2, float var3, boolean var4) {
        float var5 = -1.0F;
        class_69 var6 = null;
        Iterator var7 = this.bn.iterator();

        while(true) {
            class_69 var9;
            float var10;
            do {
                do {
                    do {
                        class_63 var8;
                        do {
                            if (!var7.hasNext()) {
                                return var6;
                            }

                            var8 = (class_63)var7.next();
                        } while(!(var8 instanceof class_69));

                        var9 = (class_69)var8;
                        var10 = var9.d(var2, var3);
                    } while(!this.a(var2, var3, var9, var1));
                } while(var4 && var9.t);
            } while(var6 != null && !(var10 < var5));

            var5 = var10;
            var6 = var9;
        }
    }

    public static boolean a(Unit var0, float var1, float var2, float var3) {
        float var4 = class_340.a(var0.xCord, var0.yCord, var1, var2);
        return var4 < var3 * var3;
    }

    private boolean a(PointF var1) {
        if (a((PlayerData)this, var1.x, var1.y, 290.0F) != null) {
            return false;
        } else {
            class_69 var2 = this.c(var1.x, var1.y);
            if (var2 != null && var2.d(var1.x, var1.y) < 490000.0F) {
                return false;
            } else {
                PointF var3 = this.a(var1.x, var1.y);
                float var4;
                if (var3 != null) {
                    var4 = class_340.a(var1.x, var1.y, var3.x, var3.y);
                    if (var4 < 160000.0F) {
                        return false;
                    }
                }

                var4 = 60.0F;
                return !class_694.d(var1.x, var1.y) && !class_694.d(var1.x + var4, var1.y) && !class_694.d(var1.x, var1.y + var4) && !class_694.d(var1.x - var4, var1.y) && !class_694.d(var1.x, var1.y + var4);
            }
        }
    }

    private boolean b(PointF var1) {
        Iterator var2 = Unit.bE.iterator();

        while(var2.hasNext()) {
            Unit var3 = (Unit)var2.next();
            if (var3.bX != this && var3 instanceof CommandCenter) {
                if (var3.bX.c((PlayerData)this) && a(var3, var1.x, var1.y, 300.0F)) {
                    return false;
                }

                if (var3.bX.d((PlayerData)this) && a(var3, var1.x, var1.y, 320.0F)) {
                    return false;
                }
            }
        }

        if (b(this, var1.x, var1.y, 360.0F) >= 4) {
            return false;
        } else {
            boolean var4 = true;
            if (a(this, var1.x, var1.y, 360.0F, var4) >= 2) {
                return false;
            } else {
                return true;
            }
        }
    }

    public int a(class_564 var1, class_656 var2) {
        int var3 = 0;

        class_659 var5;
        for(Iterator var4 = var1.c.iterator(); var4.hasNext(); var3 += this.a(var5.a, var2)) {
            var5 = (class_659)var4.next();
        }

        return var3;
    }

    public int a(class_31 var1, class_656 var2) {
        return this.a(var1, true, var2);
    }

    public int a(class_31 var1, boolean var2, class_656 var3) {
        boolean var4 = var1.j();
        Integer var5 = this.bE.a(var4, var1, var2);
        if (var5 != null) {
            return var5;
        } else {
            int var6 = 0;
            if (var4) {
                var2 = false;
            }

            Unit[] var7 = Unit.bE.a();
            int var8 = 0;

            for(int var9 = Unit.bE.size(); var8 < var9; ++var8) {
                Unit var10 = var7[var8];
                if (var10.bX == this && (var3 == class_656.INCLUDE || !var10.bM)) {
                    if (var10.dz == var1) {
                        ++var6;
                    }

                    if (var2 && var10 instanceof class_8) {
                        class_8 var11 = (class_8)var10;
                        var6 += var11.h(var1);
                    }
                }
            }

            this.bE.a(var4, var1, var2, var6);
            return var6;
        }
    }

    public int ao() {
        int var1 = 0;
        Iterator var2 = this.bn.iterator();

        while(var2.hasNext()) {
            class_63 var3 = (class_63)var2.next();
            if (var3 instanceof class_68) {
                class_68 var4 = (class_68)var3;
                var1 += var4.G.size();
            }
        }

        return var1;
    }

    public boolean g(Unit var1) {
        if (var1 instanceof OrderableUnit) {
            OrderableUnit var2 = (OrderableUnit)var1;
            if (var2.cr()) {
                class_31 var3 = var2.r();
                if (var3 instanceof class_591) {
                    class_591 var4 = (class_591)var3;
                    if (!var4.ft) {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }

    public boolean h(Unit var1) {
        if (var1 instanceof OrderableUnit) {
            OrderableUnit var2 = (OrderableUnit)var1;
            if (!var2.bI() && var2.l() && !this.g(var2) && !var2.aj()) {
                class_31 var3 = var2.r();
                if (var3 instanceof class_591) {
                    class_591 var4 = (class_591)var3;
                    if (!var4.fs) {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }

    public boolean b(Unit var1, Unit var2) {
        OrderableUnit var3;
        if (this.U) {
            if (var1 instanceof OrderableUnit) {
                var3 = (OrderableUnit)var1;
                if (var3.aq() && class_1050.a(var3, var2)) {
                    return true;
                }
            }

            return false;
        } else {
            if (this.h(var1) && var1 instanceof OrderableUnit) {
                var3 = (OrderableUnit)var1;
                if (class_1050.a(var3, var2)) {
                    return true;
                }
            }

            return false;
        }
    }

    public void i(float var1) {
        if (as && GameEngine.getGameEngine().bl) {
            if (!this.aZ && !this.aX) {
                GameEngine var2 = GameEngine.getGameEngine();
                Unit[] var3 = Unit.bE.a();
                int var4 = 0;

                float var9;
                String[] var10;
                int var11;
                int var12;
                String var13;
                float var14;
                float var15;
                float var16;
                String var21;
                for(int var5 = Unit.bE.size(); var4 < var5; ++var4) {
                    Unit var6 = var3[var4];
                    if (var6.bX == this) {
                        float var7 = 200.0F;
                        if (var2.cN.b((int)(var6.xCord - var7), (int)(var6.yCord - var7), (int)(var6.xCord + var7), (int)(var6.yCord + var7))) {
                            if (var6 instanceof OrderableUnit) {
                                OrderableUnit var8 = (OrderableUnit)var6;
                            }

                            var21 = "";
                            var9 = var6.yCord - var2.cx - 60.0F;
                            this.bp.b(Color.a(0, 255, 0));
                            if (var6 instanceof CommandCenter) {
                                var9 -= 80.0F;
                                var21 = var21 + "Base ( Team:" + this.site + " )";
                                var21 = var21 + "\nuseTransportsOnThisMap: " + this.ai();
                                var21 = var21 + "\nuseHoverTransportsOnThisMap: " + this.aj();
                                var21 = var21 + "\nattackingCount: " + this.ba;
                                var21 = var21 + "\ndefendingCount: " + this.bb;
                                var21 = var21 + "\nnumOfUnitsNeedingTransport: " + this.ao();
                                var21 = var21 + "\ntransport: " + this.aG;
                                if (this.ae()) {
                                    var21 = var21 + "\nTurtling: true";
                                }

                                this.bp.b(Color.a(255, 255, 255));
                            }

                            if (var21.length() != 0) {
                                var10 = var21.split("\n");
                                var11 = var10.length;

                                for(var12 = 0; var12 < var11; ++var12) {
                                    var13 = var10[var12];
                                    var14 = var6.xCord - var2.cw;
                                    var15 = var9;
                                    var16 = -this.bp.l() + this.bp.m();
                                    var2.bO.k();
                                    if (var2.cX > 1.0F) {
                                        var2.S();
                                        var14 *= var2.cX;
                                        var15 = var9 * var2.cX;
                                        var16 /= var2.cX;
                                    }

                                    var2.bO.a(var13, var14, var15, this.bp);
                                    var2.bO.l();
                                    var9 += var16;
                                }
                            }
                        }
                    }
                }

                Iterator var17 = this.bm.iterator();

                while(true) {
                    class_63 var18;
                    do {
                        if (!var17.hasNext()) {
                            return;
                        }

                        var18 = (class_63)var17.next();
                    } while(!var2.cN.b((int)(var18.S - var18.U), (int)(var18.T - var18.U), (int)(var18.S + var18.U), (int)(var18.T + var18.U)));

                    this.bp.b(this.K());
                    var2.bO.a(var18.S - var2.cw, var18.T - var2.cx, var18.U + 2.0F, this.bp);
                    int var19 = Color.a(0, 255, 0);
                    String var20 = "";
                    var21 = var18.getClass().getSimpleName();
                    var20 = var20 + "\n" + var21 + " ( Team:" + this.site + " )";
                    var9 = var18.T - var2.cx;
                    if (var18 instanceof class_69) {
                        var9 -= 50.0F;
                        class_69 var22 = (class_69)var18;
                        var20 = var20 + "\nState: " + var22.b.name() + "(id:" + var22.Q + ")";
                        var20 = var20 + "\nunsafe: " + var22.f() + " (" + var22.s + ")";
                        var20 = var20 + "\nunsafeBaseTimer: " + var22.v;
                        var20 = var20 + "\nallowedUnits: " + var22.d;
                        if (var22.z != null) {
                            var20 = var20 + "\nlastAttemptedBuilding: " + var22.z.i();
                        }

                        if (var22.A != null) {
                            var20 = var20 + "\nlastAttemptedBuilding-cannotAffordPrice: " + var22.A.a(false, true, 4, true);
                        }

                        if (var22.B != null) {
                            var20 = var20 + "\nlastAttemptedBuilding-cannotAffordBy: " + var22.B.a(false, true, 4, true);
                        }

                        var20 = var20 + "\nlastAttemptedBuildingCount: " + var22.C;
                        var20 = var20 + "\nlastAttemptedBuildingFailed: " + var22.D;
                        var20 = var20 + "\nlastUnitAttempt: " + var22.E + " (" + var22.F + " - " + var22.G + ")";
                        var20 = var20 + "\nbuildBuildingDelay: " + var22.e;
                        var20 = var20 + "\ncredits: " + class_340.c(this.credits) + " (x" + class_340.g(this.E()) + ")";
                        if (var22.b == class_658.PRE) {
                            var20 = var20 + "\nclaimedBaseTimer: " + var22.l;
                        }

                        if (var22.k > 100.0F) {
                            var20 = var20 + "\nabandonedTimer: " + var22.k;
                        }

                        if (var22.g > 0.0F) {
                            var20 = var20 + "\nrequestedBuildersDelay: " + var22.g + " (" + var22.h + ")";
                        }

                        var20 = var20 + "\nBuilders: " + var22.J;
                        var20 = var20 + "\nIdle Builders: " + var22.K;
                    }

                    if (var18 instanceof class_68) {
                        class_68 var23 = (class_68)var18;
                        if (var23.c) {
                            var20 = var20 + "\nVIP Mode";
                        }

                        var20 = var20 + "\n" + (var23.b() ? "Defensive Type" : "Attack Type");
                        var20 = var20 + "\nUnits: " + var23.F.size() + " / " + var23.A;
                        var20 = var20 + "\nStagingForAttack: " + var23.q;
                        var20 = var20 + "\nAttackDelay: " + var23.l;
                        if (var23.u != 0.0F) {
                            var20 = var20 + "\nStagingTimer: " + var23.u;
                        }

                        var20 = var20 + "\nStagingTargetFound: " + var23.r;
                        if (var23.o != 0.0F) {
                            var20 = var20 + "\nattackingFor: " + var23.o;
                        }

                        var20 = var20 + "\ncommonMovement: " + var23.i().name();
                        if (var23.B) {
                            var20 = var20 + " (seaGroup)";
                        }

                        if (var23.G.size() > 0) {
                            var20 = var20 + "\nunitsNeedingTransport:" + var23.G.size();
                        }

                        if (var23.b != null) {
                            var20 = var20 + "\nlast action:" + var23.b;
                        }

                        if (!var23.v && !var23.q) {
                            var20 = var20 + "\nnext move:" + (int)this.k(var23.n) + "s";
                        }
                    }

                    if (var18 instanceof class_66) {
                        class_66 var24 = (class_66)var18;
                        var20 = var20 + "\nUnitsWanted: " + var24.l;
                        var20 = var20 + "\nunits: " + var24.F.size();
                        var20 = var20 + "\nreadyToMoveOut: " + var24.q;
                        if (var24.m != null) {
                            var20 = var20 + "\nCurrentlyHelping: " + var24.m.Q;
                        }
                    }

                    if (var18 instanceof class_67) {
                        class_67 var25 = (class_67)var18;
                        var20 = var20 + "\nneedsTransportGroup: " + var25.a;
                    }

                    this.bp.b(this.K());
                    var10 = var20.split("\n");
                    var11 = var10.length;

                    for(var12 = 0; var12 < var11; ++var12) {
                        var13 = var10[var12];
                        if (!var13.trim().equals("")) {
                            var14 = var18.S - var2.cw;
                            var15 = var9;
                            var16 = -this.bp.l() + this.bp.m();
                            var2.bO.k();
                            if (var2.cX > 1.0F) {
                                var2.S();
                                var14 *= var2.cX;
                                var15 = var9 * var2.cX;
                                var16 /= var2.cX;
                            }

                            var2.bO.a(var13, var14, var15, this.bp);
                            var2.bO.l();
                            var9 += var16;
                            this.bp.b(var19);
                        }
                    }
                }
            }
        }
    }

    public Unit e(PlayerData var1) {
        Iterator var2 = Unit.bE.iterator();

        Unit var3;
        do {
            do {
                if (!var2.hasNext()) {
                    var2 = Unit.bE.iterator();

                    do {
                        if (!var2.hasNext()) {
                            return null;
                        }

                        var3 = (Unit)var2.next();
                    } while(var3.bX != var1 || !var3.bO);

                    return var3;
                }

                var3 = (Unit)var2.next();
            } while(var3.bX != var1);
        } while(!(var3 instanceof CommandCenter) && !var3.bP);

        return var3;
    }

    public void a(float var1) {
        super.a(var1);
        GameEngine var2 = GameEngine.getGameEngine();
        if (!this.aX && !this.aZ) {
            if (var2.netEngine.B) {
                if (!var2.netEngine.isServer) {
                    return;
                }

                if (var2.replayEngine.j()) {
                    return;
                }
            }

            if (this.bG > 0.0F) {
                this.bG -= var1;
            } else {
                this.bF = this.C();
                int var4;
                int var5;
                Unit var6;
                if (this.be && var2.by > 3000) {
                    this.be = false;
                    Unit[] var3 = Unit.bE.a();
                    var4 = 0;

                    for(var5 = Unit.bE.size(); var4 < var5; ++var4) {
                        var6 = var3[var4];
                        if (var6 instanceof DamagingBorder) {
                            this.d("firstRunDelayed: Found damagingBorder");
                            this.bg = (DamagingBorder)var6;
                            break;
                        }
                    }
                }

                if (this.bd) {
                    this.bd = false;
                    this.bh = true;
                    this.bi = true;
                    this.bj = true;
                    this.bk = true;
                    Unit var10 = this.e((PlayerData)this);
                    if (var10 == null) {
                        this.d("firstRun: no command center found");
                    }

                    if (var10 != null) {
                        for(var4 = 0; var4 < PlayerData.c; ++var4) {
                            PlayerData var13 = PlayerData.getPlayerData(var4);
                            if (var13 != null && var13 != this) {
                                var6 = this.e(var13);
                                if (var6 != null) {
                                    if (!this.a(var10.xCord, var10.yCord, var6.xCord, var6.yCord, MovementType.LAND)) {
                                        this.bh = false;
                                    }

                                    if (!this.a(var10.xCord, var10.yCord, var6.xCord, var6.yCord, MovementType.HOVER)) {
                                        this.bi = false;
                                    }
                                }
                            }
                        }

                        Iterator var12 = var2.bL.A.iterator();

                        while(var12.hasNext()) {
                            Point var15 = (Point)var12.next();
                            PointF var17 = var2.bL.a(var15);
                            if (!this.a(var10.xCord, var10.yCord, var17.x, var17.y + (float)var2.bL.o, MovementType.LAND)) {
                                this.bj = false;
                            }

                            if (!this.a(var10.xCord, var10.yCord, var17.x, var17.y + (float)var2.bL.o, MovementType.HOVER)) {
                                this.bk = false;
                            }
                        }
                    }
                }

                this.aP += var1;
                this.aQ += var1;
                if (this.aP > 25.0F) {
                    this.aP -= 25.0F;
                    if (this.aP > 25.0F) {
                        this.aP = 25.0F;
                    }

                    if (this.aP < -1.0F) {
                        this.aP = -1.0F;
                    }

                    boolean var11 = false;
                    boolean var14 = false;
                    Iterator var16 = this.bm.iterator();

                    while(var16.hasNext()) {
                        class_63 var18 = (class_63)var16.next();
                        if (var18 instanceof class_69) {
                            class_69 var7 = (class_69)var18;
                            var7.a += this.aQ;
                        }
                    }

                    label134:
                    for(var5 = 0; var5 < 2; ++var5) {
                        class_69 var19 = null;
                        Iterator var20 = this.bm.iterator();

                        while(true) {
                            class_69 var9;
                            do {
                                class_63 var8;
                                do {
                                    if (!var20.hasNext()) {
                                        if (var19 == null || var19.a < 50.0F) {
                                            break label134;
                                        }

                                        var19.b(var19.a);
                                        var19.d(var19.a);
                                        var19.a = 0.0F;
                                        continue label134;
                                    }

                                    var8 = (class_63)var20.next();
                                } while(!(var8 instanceof class_69));

                                var9 = (class_69)var8;
                            } while(var19 != null && !(var19.a < var9.a));

                            var19 = var9;
                        }
                    }

                    this.aQ = 0.0F;
                }

                this.aL += var1;
                this.aM += var1;
                if (this.aL > 80.0F) {
                    this.n(this.aM);
                    this.aL -= 80.0F;
                    if (this.aL > 80.0F) {
                        this.aL = 80.0F;
                    }

                    if (this.aL < -1.0F) {
                        this.aL = -1.0F;
                    }

                    this.aM = 0.0F;
                }

                this.aN += var1;
                this.aO += var1;
                if (this.aN > 250.0F) {
                    this.m(this.aO);
                    this.aN -= 250.0F;
                    if (this.aN > 250.0F) {
                        this.aN = 250.0F;
                    }

                    if (this.aN < -1.0F) {
                        this.aN = -1.0F;
                    }

                    this.aO = 0.0F;
                }

            }
        }
    }

    public float j(float var1) {
        return var1 / 60.0F * 1000.0F;
    }

    public float k(float var1) {
        return var1 / 60.0F;
    }

    public void a(OrderableUnit var1, class_1059 var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        SyncPacket var4 = var3.cf.a((PlayerData)this);
        var4.a(var1);
        var4.a(var2);
    }

    public void l(float var1) {
        Iterator var2 = Unit.bE.iterator();

        while(var2.hasNext()) {
            Unit var3 = (Unit)var2.next();
            if (var3.bX == this && var3 instanceof OrderableUnit && this.i(var3)) {
                OrderableUnit var4 = (OrderableUnit)var3;
                boolean var5;
                Unit var6;
                boolean var7;
                if (var4 instanceof AttackSubmarine) {
                    var5 = false;
                    var6 = var4.ab();
                    if (var6 != null && var4.h(var6)) {
                        var5 = !var6.cH();
                    }

                    var7 = !var4.Q();
                    if (var5 && var5 != var7) {
                        this.a(var4, AttackSubmarine.j.N());
                    }

                    if (!var5 && var5 != var7) {
                        this.a(var4, AttackSubmarine.k.N());
                    }
                }

                if (var4 instanceof AmphibiousJet) {
                    var5 = true;
                    var6 = var4.ab();
                    if (var6 != null && var4.h(var6)) {
                        var5 = !var6.Q();
                    }

                    var7 = !var4.Q();
                    if (var5 && var5 != var7) {
                        this.a(var4, AmphibiousJet.y.N());
                    }

                    if (!var5 && var5 != var7) {
                        this.a(var4, AmphibiousJet.z.N());
                    }
                }

                if (var4.be() == AttackMovementType.BOMBER && var4.aq() && var4.ab() != null) {
                    GameEngine var9 = GameEngine.getGameEngine();
                    SyncPacket var8 = var9.cf.a((PlayerData)this);
                    var8.a(var4);
                    var8.a(var4.ab());
                }
            }
        }

    }

    public AttackMode c(OrderableUnit var1) {
        if (var1.aS()) {
            boolean var2 = true;
            if (var1.aj()) {
                var2 = false;
            }

            if (this.g(var1)) {
                var2 = false;
            }

            if (var2) {
                if (this.aY) {
                    return AttackMode.aggressive;
                }

                return AttackMode.outOfRange;
            }
        }

        return AttackMode.onlyInRange;
    }

    public ArrayList ap() {
        bK.clear();
        return bK;
    }

    public void d(OrderableUnit var1) {
        Iterator var2 = this.bJ.iterator();

        while(var2.hasNext()) {
            class_1002 var3 = (class_1002)var2.next();
            var3.a(this, var1);
        }

    }

    public void e(OrderableUnit var1) {
        Iterator var2 = this.bJ.iterator();

        while(var2.hasNext()) {
            class_1002 var3 = (class_1002)var2.next();
            var3.b(this, var1);
        }

    }

    public void m(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.bE.b();
        Iterator var3 = this.bJ.iterator();

        while(var3.hasNext()) {
            class_1002 var4 = (class_1002)var3.next();
            var4.b(this.j(var1), this);
        }

        int var23 = 0;
        Unit[] var24 = Unit.bE.a();
        int var5 = 0;

        int var6;
        Unit var7;
        OrderableUnit var8;
        for(var6 = Unit.bE.size(); var5 < var6; ++var5) {
            var7 = var24[var5];
            if (var7.bX == this && !var7.u()) {
                ++var23;
                if (var7 instanceof OrderableUnit) {
                    var8 = (OrderableUnit)var7;
                    if (!var8.bD) {
                        var8.bD = true;
                        this.d(var8);
                    }

                    if (var7.cN == null) {
                        class_69 var9 = var8.aC;
                        var8.aC = this.f(var8);
                        if (var8.aC != null && var9 != var8.aC) {
                            if (var8.bI()) {
                                var8.aD = this.a(var7.xCord, var7.yCord, var8.aC.S, var8.aC.T, MovementType.LAND);
                                if (!var8.aD && var8.r().p()) {
                                    var8.aD = this.a(var7.xCord, var7.yCord + 15.0F, var8.aC.S, var8.aC.T, MovementType.LAND);
                                }
                            } else {
                                var8.aD = this.a(var7.xCord, var7.yCord, var8.aC.S, var8.aC.T, MovementType.LAND);
                            }
                        }
                    }
                }
            }
        }

        this.l(var1);
        Iterator var25 = Unit.bE.iterator();

        Unit var27;
        while(var25.hasNext()) {
            var27 = (Unit)var25.next();
            if (var27.bX == this && var27 instanceof OrderableUnit) {
                OrderableUnit var29 = (OrderableUnit)var27;
                AttackMode var33 = this.c(var29);
                if (var29.P != var33 && this.i(var29)) {
                    SyncPacket var35 = var2.cf.a((PlayerData)this);
                    var35.a(var29);
                    var35.a(var33);
                }

                if (var29.aj() && var29.dd() && var29.aB == null && this.i(var29)) {
                    class_68.a(this, var29);
                }
            }
        }

        if (var23 == 0 && !this.U) {
            this.aZ = true;
        }

        this.aU = class_340.a(this.aU, var1);
        this.aT = class_340.a(this.aT, var1);
        if (this.ac()) {
            this.aT = class_340.a(this.aT, 4.0F * var1);
        }

        int var26;
        Iterator var28;
        class_63 var31;
        PointF var32;
        class_69 var34;
        if (this.aT == 0.0F) {
            var26 = 0;
            var28 = this.bn.iterator();

            while(var28.hasNext()) {
                var31 = (class_63)var28.next();
                if (var31 instanceof class_69) {
                    var34 = (class_69)var31;
                    if (var34.b == class_658.PRE) {
                        ++var26;
                    }
                }
            }

            boolean var30 = false;
            if (var26 > 2) {
                var30 = true;
            }

            if (var30) {
                this.aT = 300.0F;
            } else {
                var32 = this.an();
                if (var32 != null) {
                    var32.y += (float)var2.bL.o;
                    if (this.b(var32.x, var32.y) == null && this.b(var32)) {
                        this.aT = 2000.0F;
                        var34 = new class_69(this, var32.x, var32.y);
                        var34.U = 360.0F;
                        var34.b = class_658.PRE;
                        var34.c = class_657.RESOURCE_OUTPOST;
                        ++this.aw;
                    }
                }
            }
        }

        if (this.aU == 0.0F) {
            this.aU = 100.0F;
            var26 = 0;
            var28 = this.bn.iterator();

            while(var28.hasNext()) {
                var31 = (class_63)var28.next();
                if (var31 instanceof class_69) {
                    var34 = (class_69)var31;
                    if (var34.c == class_657.FORWARD_OUTPOST) {
                        ++var26;
                    }
                }
            }

            if (var26 < 3) {
                var27 = this.ar();
                if (var27 != null) {
                    var32 = new PointF();
                    var32.x = var27.xCord;
                    var32.y = var27.yCord;
                    if (var32 != null && this.b(var32.x, var32.y) == null && this.a(var32)) {
                        this.aU = 5000.0F;
                        var34 = new class_69(this, var32.x, var32.y);
                        var34.U = 310.0F;
                        var34.b = class_658.PRE;
                        var34.c = class_657.FORWARD_OUTPOST;
                        ++this.aw;
                    }
                }
            }
        }

        this.bc = 0;
        this.ba = 0;
        this.bb = 0;
        var24 = Unit.bE.a();
        var5 = 0;

        for(var6 = Unit.bE.size(); var5 < var6; ++var5) {
            var7 = var24[var5];
            if (var7.bX == this && var7 instanceof OrderableUnit) {
                var8 = (OrderableUnit)var7;
                if (!var7.bI()) {
                    if (var8.aB != null && var8.aB.b()) {
                        ++this.bb;
                    } else if (this.h(var8) && !var8.bM) {
                        if (var8.h() == MovementType.WATER) {
                            ++this.bc;
                        } else {
                            ++this.ba;
                        }
                    }
                }
            }
        }

        this.aR = class_340.a(this.aR, var1);
        this.aS += var1;
        if (this.aR == 0.0F) {
            var26 = 0;
            var5 = 0;
            var6 = 0;
            int var38 = 0;
            Iterator var36 = Unit.bE.iterator();

            label317:
            while(true) {
                Unit var39;
                do {
                    do {
                        if (!var36.hasNext()) {
                            if (this.a(4100.0) || this.aS > 2400.0F || this.aH == 0) {
                                var36 = Unit.bE.iterator();

                                while(true) {
                                    OrderableUnit var44;
                                    do {
                                        do {
                                            do {
                                                if (!var36.hasNext()) {
                                                    boolean var41 = false;
                                                    if (this.a(30000.0)) {
                                                        var41 = true;
                                                    }

                                                    Iterator var42 = Unit.bE.iterator();

                                                    while(var42.hasNext()) {
                                                        Unit var45 = (Unit)var42.next();
                                                        if (var45.bX == this && var45 instanceof OrderableUnit) {
                                                            OrderableUnit var46 = (OrderableUnit)var45;
                                                            class_1059 var47 = var46.cm();
                                                            if (class_226.c(var47)) {
                                                                float var49 = var46.cn();
                                                                boolean var48;
                                                                if (var49 < 0.0F) {
                                                                    var49 = 6.0F;
                                                                    var48 = false;
                                                                } else {
                                                                    var48 = true;
                                                                }

                                                                if (var49 != 0.0F) {
                                                                    boolean var15 = false;
                                                                    int var16 = class_340.c(100);
                                                                    float var17 = 100.0F - var49;
                                                                    if (var41) {
                                                                        var17 -= 4.0F;
                                                                    }

                                                                    if (!var48) {
                                                                        if (var45.r().p() && var38 > 0) {
                                                                            var17 = 50.0F;
                                                                        }

                                                                        if (var5 > 0 && var26 == 0) {
                                                                            var17 = 99.0F;
                                                                            if (var45 instanceof AirFactory) {
                                                                                var17 = 40.0F;
                                                                            }
                                                                        }
                                                                    }

                                                                    if (var17 < 10.0F) {
                                                                        var17 = 10.0F;
                                                                    }

                                                                    var15 = (float)var16 > var17;
                                                                    if (var15) {
                                                                        boolean var18 = var46.co();
                                                                        if (var18) {
                                                                        }

                                                                        if (class_340.c(100) > 50) {
                                                                            var46.a((ArrayList)this.bH);
                                                                            if (this.bH.size() != 0) {
                                                                                var47 = (class_1059)this.bH.get((new Random()).nextInt(this.bH.size()));
                                                                            }
                                                                        }

                                                                        boolean var19 = false;
                                                                        class_226 var20 = var46.a((class_1059)var47);
                                                                        if (var20 != null) {
                                                                            if (var20.m(var46)) {
                                                                                var19 = true;
                                                                            }

                                                                            if (var20.e() == class_1052.targetGround) {
                                                                                var19 = true;
                                                                            }

                                                                            if (!var20.b((Unit)var46)) {
                                                                                var19 = true;
                                                                            }

                                                                            if (!var20.a(var46, false)) {
                                                                                var19 = true;
                                                                            }
                                                                        } else {
                                                                            var19 = true;
                                                                        }

                                                                        if (!var19) {
                                                                            this.a(var46, var47);
                                                                            class_447 var21 = var20.B();
                                                                            boolean var22 = true;
                                                                            this.a(var46, var21, var22);
                                                                            this.aR = 900.0F;
                                                                            this.aS = 0.0F;
                                                                            if (!var41) {
                                                                                break label317;
                                                                            }

                                                                            if (this.a(40000.0)) {
                                                                                if (class_340.c(100) > 95) {
                                                                                    break label317;
                                                                                }
                                                                            } else if (class_340.c(100) > 80) {
                                                                                break label317;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break label317;
                                                }

                                                var39 = (Unit)var36.next();
                                            } while(var39.bX != this);
                                        } while(!(var39 instanceof OrderableUnit));

                                        var44 = (OrderableUnit)var39;
                                    } while(!var44.cl());

                                    ArrayList var11 = var44.N();
                                    ArrayList var12 = this.ap();
                                    Iterator var13 = var11.iterator();

                                    while(var13.hasNext()) {
                                        class_226 var14 = (class_226)var13.next();
                                        if (var14.n(var44)) {
                                            var12.add(var14);
                                        }
                                    }

                                    if (var12.size() > 0) {
                                        this.a(var44, (class_226)class_660.a((AbstractList)var12));
                                    }
                                }
                            }
                            break label317;
                        }

                        var39 = (Unit)var36.next();
                    } while(var39.bX != this);
                } while(!var39.bT());

                if ((var39 instanceof LandFactory || var39 instanceof AirFactory || var39 instanceof SeaFactory) && var39 instanceof AirFactory) {
                    ++var5;
                    AirFactory var10 = (AirFactory)var39;
                    if (var10.V() > 1) {
                        ++var26;
                    }
                }

                if (var39.r().p()) {
                    ++var6;
                    class_1059 var43 = var39.cm();
                    if (class_226.c(var43)) {
                        ++var38;
                    }
                }
            }
        }

        var25 = this.bm.iterator();

        while(var25.hasNext()) {
            class_63 var40 = (class_63)var25.next();
            if (var40 instanceof class_65) {
                class_65 var37 = (class_65)var40;
                var37.b(var1);
            }
        }

    }

    public boolean a(OrderableUnit var1, class_226 var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (var2.b((Unit)var1) && var2.a(var1, false)) {
            SyncPacket var4 = var3.cf.a((PlayerData)this);
            var4.a(var1);
            var4.a(var2.z());
            return true;
        } else {
            return false;
        }
    }

    public boolean a(OrderableUnit var1, class_226 var2, PointF var3, Unit var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        if (var2.b((Unit)var1) && var2.a(var1, false)) {
            SyncPacket var6 = var5.cf.a((PlayerData)this);
            var6.a(var1);
            var6.a(var2.z(), var3, var4);
            return true;
        } else {
            return false;
        }
    }

    public void aq() {
        Iterator var1 = this.bm.iterator();

        class_63 var2;
        while(var1.hasNext()) {
            var2 = (class_63)var1.next();
            if (var2 instanceof class_69) {
                ((class_69)var2).t();
            }
        }

        var1 = this.bm.iterator();

        Iterator var3;
        class_63 var4;
        while(var1.hasNext()) {
            var2 = (class_63)var1.next();
            var3 = this.bm.iterator();

            while(var3.hasNext()) {
                var4 = (class_63)var3.next();
                if (var2 != var4 && var2.Q == var4.Q) {
                    GameEngine.a("Id overlap on:" + var2.Q);
                    GameEngine.a("zone x:" + var2.S);
                    GameEngine.a("zone y:" + var2.T);
                    GameEngine.a("zone radius:" + var2.U);
                    GameEngine.a("zone type:" + var2.getClass().getName());
                }
            }
        }

        int var8 = 0;
        Iterator var9 = this.bm.iterator();

        while(var9.hasNext()) {
            class_63 var11 = (class_63)var9.next();
            if (var11 instanceof class_69) {
                ++var8;
            }
        }

        int var10 = 0;
        var3 = this.bm.iterator();

        while(true) {
            do {
                if (!var3.hasNext()) {
                    if (var10 > 0) {
                        this.d("baseOverlapCount:" + var10);
                    }

                    return;
                }

                var4 = (class_63)var3.next();
            } while(!(var4 instanceof class_69));

            Iterator var5 = this.bm.iterator();

            while(var5.hasNext()) {
                class_63 var6 = (class_63)var5.next();
                if (var6 instanceof class_69 && var4 != var6) {
                    float var7 = class_340.a(var4.S, var4.T, var6.S, var6.T);
                    if (var7 < 400.0F) {
                        ++var10;
                    }
                }
            }
        }
    }

    public void a(OrderableUnit var1) {
        if (var1.bX == this) {
            this.bE.a(var1);
        }

    }

    public void n(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.bE.a();
        Iterator var3 = this.bJ.iterator();

        class_1002 var4;
        while(var3.hasNext()) {
            var4 = (class_1002)var3.next();
            var4.a(this.j(var1), this);
        }

        var3 = this.bm.iterator();

        class_65 var5;
        class_63 var16;
        while(var3.hasNext()) {
            var16 = (class_63)var3.next();
            if (var16 instanceof class_65) {
                var5 = (class_65)var16;
                var5.c(var1);
            }
        }

        if (this.bg != null) {
            var3 = this.bm.iterator();

            while(var3.hasNext()) {
                var16 = (class_63)var3.next();
                if (this.bg.a(var16.S, var16.T)) {
                    if (var16 instanceof class_69) {
                        var16.p();
                        break;
                    }

                    if (var16 instanceof class_68) {
                        PointF var18 = this.bg.a(var16.S, var16.T, var16.U + 20.0F);
                        var16.S = var18.x;
                        var16.T = var18.y;
                    }
                }
            }
        }

        this.aW = class_340.a(this.aW, var1);
        int var15 = 0;
        Iterator var17 = this.bn.iterator();

        while(var17.hasNext()) {
            class_63 var19 = (class_63)var17.next();
            if (var19 instanceof class_69) {
                ++var15;
            }
        }

        if (var15 < 1) {
            var17 = Unit.bE.iterator();

            class_69 var6;
            Unit var20;
            while(var17.hasNext()) {
                var20 = (Unit)var17.next();
                if (var20.bX == this && var20 instanceof CommandCenter) {
                    var6 = new class_69(this, var20.xCord, var20.yCord);
                    var6.U = 420.0F;
                    var6.b = class_658.ACTIVE;
                    var6.c = class_657.MAIN;
                    ++var15;
                    break;
                }
            }

            if (var15 < 1) {
                var17 = Unit.bE.iterator();

                while(var17.hasNext()) {
                    var20 = (Unit)var17.next();
                    if (var20.bX == this && this.bz.b(var20.r())) {
                        var6 = new class_69(this, var20.xCord, var20.yCord);
                        var6.U = 420.0F;
                        var6.b = class_658.ACTIVE;
                        var6.c = class_657.MAIN;
                        ++var15;
                        break;
                    }
                }
            }

            OrderableUnit var22;
            class_69 var28;
            if (var15 < 1) {
                var17 = Unit.bE.iterator();

                label299:
                while(true) {
                    do {
                        do {
                            if (!var17.hasNext()) {
                                break label299;
                            }

                            var20 = (Unit)var17.next();
                        } while(var20.bX != this);
                    } while(!(var20 instanceof OrderableUnit));

                    var22 = (OrderableUnit)var20;
                    boolean var7 = false;
                    Iterator var8 = this.bz.c.iterator();

                    while(var8.hasNext()) {
                        class_659 var9 = (class_659)var8.next();
                        if (var22.b(var9.a, true)) {
                            var7 = true;
                            break;
                        }
                    }

                    if (var7) {
                        var28 = new class_69(this, var20.xCord, var20.yCord);
                        var28.U = 420.0F;
                        var28.b = class_658.ACTIVE;
                        var28.c = class_657.MAIN;
                        ++var15;
                        break;
                    }
                }
            }

            if (var15 < 1) {
                var17 = Unit.bE.iterator();

                while(var17.hasNext()) {
                    var20 = (Unit)var17.next();
                    if (var20.bX == this && var20 instanceof OrderableUnit) {
                        var22 = (OrderableUnit)var20;
                        if (var22.ai()) {
                            class_69 var26 = new class_69(this, var20.xCord, var20.yCord);
                            var26.U = 420.0F;
                            var26.b = class_658.ACTIVE;
                            var26.c = class_657.MAIN;
                            ++var15;
                            break;
                        }
                    }
                }
            }

            if (!this.bf) {
                this.bf = true;
                int var21 = this.a(this.bB, class_656.INCLUDE);
                if (var21 >= 1) {
                    for(int var23 = 0; var23 < var2.bL.A.size(); ++var23) {
                        Point var24 = (Point)var2.bL.A.get(var23);
                        var2.bL.a(var24.a, var24.b);
                        this.bo.setSite((float)var2.bL.T, (float)var2.bL.U);
                        PointF var27 = this.bo;
                        var27.y += (float)var2.bL.o;
                        if (this.b(var27.x, var27.y) == null && this.a((class_564)this.bB, var27.x, var27.y, 200) >= 1 && this.b(var27)) {
                            var28 = new class_69(this, var27.x, var27.y);
                            var28.U = 360.0F;
                            var28.b = class_658.PRE;
                            var28.c = class_657.RESOURCE_OUTPOST;
                        }
                    }
                }
            }
        }

        var4 = null;
        var5 = null;
        Unit[] var25 = Unit.bE.a();
        int var29 = 0;

        OrderableUnit var10;
        int var30;
        Unit var31;
        for(var30 = Unit.bE.size(); var29 < var30; ++var29) {
            var31 = var25[var29];
            if (var31.bX == this && var31.cN == null && var31 instanceof OrderableUnit && var31.aj() && this.i(var31)) {
                var10 = (OrderableUnit)var31;
                class_69 var11 = this.e((Unit)var10);
                if (var11 != null) {
                    if (var10.aq()) {
                        ;
                    }
                } else if (var10.aq()) {
                    class_69 var12 = this.f(var10);
                    if (var12 != null) {
                        PointF var13 = var12.w();
                        SyncPacket var14 = var2.cf.a((PlayerData)this);
                        var14.a(var10);
                        var14.a(var13.x, var13.y);
                    }
                }
            }
        }

        var29 = 0;

        for(var30 = Unit.bE.size(); var29 < var30; ++var29) {
            var31 = var25[var29];
            if (var31.bX == this && var31 instanceof OrderableUnit) {
                var10 = (OrderableUnit)var31;
                if (var10.V > 2400.0F && this.i(var10)) {
                    if (var10.aN && var10.V < 24000.0F) {
                        continue;
                    }

                    SyncPacket var35 = var2.cf.a((PlayerData)this);
                    var35.a(var10);
                    var35.h();
                }

                if (var10.aj() && this.i(var10)) {
                    class_1042 var37 = var10.ar();
                    if (var37 != null && var37.d() == WaypointType.build && var10.V > 700.0F) {
                        SyncPacket var42 = var2.cf.a((PlayerData)this);
                        var42.a(var10);
                        var42.h();
                    }
                }
            }
        }

        if (!this.U) {
            this.ak();
            var29 = 1;
            boolean var32 = this.af();
            boolean var33 = true;
            if (var32) {
                ++var29;
                var33 = false;
            }

            if (this.ay > 6) {
                var29 = 2;
            }

            if (this.ay > 11) {
                var29 = 3;
            }

            class_68 var34;
            if (this.aC < var29) {
                var34 = new class_68(this, false);
                var34.A = 8;
                if (this.ac()) {
                    var34.A = 10;
                }

                var34.k();
                ++this.av;
            }

            if ((this.aD >= var29 || this.aE > 6) && this.aA < 1 && var33) {
                var34 = new class_68(this, true);
                if (this.serverHostFlag < 2) {
                    var34.A = 3;
                } else if (this.serverHostFlag < 5) {
                    var34.A = 5;
                } else {
                    var34.A = 7;
                    if (this.ac()) {
                        if (this.serverHostFlag < 25) {
                            var34.A = 14;
                        } else {
                            var34.A = 18;
                        }
                    }
                }

                var34.k();
                ++this.serverHostFlag;
            }

            if (this.ah() && this.aB < 1 && var33) {
                var34 = new class_68(this, true);
                var34.B = true;
                var34.A = 5;
                if (this.ac()) {
                    var34.A = 10;
                }

                var34.k();
            }

            if (this.ai() && this.aF < 3) {
                class_66 var39 = new class_66(this);
                var39.l = 1;
                var39.f();
            }
        }

        if (this.U) {
            if (this.aW > 30.0F) {
                this.aW = 30.0F;
            }

            if (this.aW == 0.0F) {
                ++this.aV;
                if (this.aV == 1) {
                    this.aW = 1000.0F;
                } else if (this.aV == 2) {
                    this.aW = 3000.0F;
                    Unit var38 = this.as();
                    if (var38 != null) {
                        if (this.U) {
                            var30 = 0;
                        } else {
                            var30 = 2;
                            if (this.ba < 4) {
                                var30 = 5;
                            }
                        }

                        SyncPacket var36 = var2.cf.a((PlayerData)this);
                        int var40 = 0;

                        for(int var41 = Unit.bE.size(); var40 < var41; ++var40) {
                            Unit var43 = var25[var40];
                            if (var43.bX == this && var43 instanceof OrderableUnit) {
                                OrderableUnit var44 = (OrderableUnit)var43;
                                if (!var44.bM && this.b(var44, var38)) {
                                    if (var30 <= 0) {
                                        var36.a(var44);
                                    } else {
                                        --var30;
                                    }
                                }
                            }
                        }

                        var36.b(var38.xCord, var38.yCord);
                    }
                } else {
                    this.aV = 0;
                }
            }
        }

    }

    public boolean i(Unit var1) {
        if (!var1.u() && !var1.t()) {
            if (var1.cW()) {
                return false;
            } else {
                return !var1.bN;
            }
        } else {
            return false;
        }
    }

    public Unit ar() {
        Unit var1 = null;
        int var2 = 0;
        Unit[] var3 = Unit.bE.a();
        int var4 = 0;

        int var5;
        for(var5 = Unit.bE.size(); var4 < var5; ++var4) {
            Unit var6 = var3[var4];
            if (!var6.bV && var6.cN == null && this == var6.bX && this.h(var6)) {
                ++var2;
            }
        }

        var4 = (int)(Math.random() * (double)var2);
        var5 = 0;
        Iterator var8 = Unit.bE.iterator();

        while(var8.hasNext()) {
            Unit var7 = (Unit)var8.next();
            if (!var7.bV && var7.cN == null && this == var7.bX && this.h(var7)) {
                if (var5 == var4) {
                    var1 = var7;
                    break;
                }

                ++var5;
            }
        }

        return var1;
    }

    public Unit as() {
        Unit var1 = null;
        int var2 = 0;
        Unit[] var3 = Unit.bE.a();
        int var4 = 0;

        int var5;
        for(var5 = Unit.bE.size(); var4 < var5; ++var4) {
            Unit var6 = var3[var4];
            if (!var6.bV && var6.cN == null && !var6.u() && this.c((PlayerData)var6.bX) && this.j(var6)) {
                ++var2;
            }
        }

        var4 = (int)(Math.random() * (double)var2);
        var5 = 0;
        Iterator var8 = Unit.bE.iterator();

        while(var8.hasNext()) {
            Unit var7 = (Unit)var8.next();
            if (!var7.bV && var7.cN == null && !var7.u() && this.c((PlayerData)var7.bX) && this.j(var7)) {
                if (var5 == var4) {
                    var1 = var7;
                    break;
                }

                ++var5;
            }
        }

        return var1;
    }

    public PointF at() {
        Unit var1 = null;
        int var2 = 0;
        Unit[] var3 = Unit.bE.a();
        int var4 = 0;

        int var5;
        for(var5 = Unit.bE.size(); var4 < var5; ++var4) {
            Unit var6 = var3[var4];
            if (!var6.bV && var6.cN == null && !var6.u() && this.c((PlayerData)var6.bX) && this.j(var6)) {
                ++var2;
            }
        }

        var4 = (int)(Math.random() * (double)var2);
        var5 = 0;
        Iterator var8 = Unit.bE.iterator();

        while(var8.hasNext()) {
            Unit var7 = (Unit)var8.next();
            if (!var7.bV && var7.cN == null && !var7.u() && this.c((PlayerData)var7.bX) && this.j(var7)) {
                if (var5 == var4) {
                    var1 = var7;
                    break;
                }

                ++var5;
            }
        }

        return var1 != null ? new PointF(var1.xCord, var1.yCord) : null;
    }

    public static Unit a(PlayerData var0, float var1, float var2, float var3) {
        float var4 = var3;
        Unit[] var5 = Unit.bE.a();
        int var6 = 0;

        for(int var7 = Unit.bE.size(); var6 < var7; ++var6) {
            Unit var8 = var5[var6];
            if (var8.xCord + var4 > var1 && var8.xCord - var4 < var1 && var8.yCord + var4 > var2 && var8.yCord - var4 < var2 && var8.bX != var0 && a(var8, var1, var2, var3) && var8.bX.c(var0)) {
                return var8;
            }
        }

        return null;
    }

    public static int a(PlayerData var0, float var1, float var2, float var3, boolean var4) {
        int var5 = 0;
        float var6 = var3;
        Unit[] var7 = Unit.bE.a();
        int var8 = 0;

        for(int var9 = Unit.bE.size(); var8 < var9; ++var8) {
            Unit var10 = var7[var8];
            if (var10.xCord + var6 > var1 && var10.xCord - var6 < var1 && var10.yCord + var6 > var2 && var10.yCord - var6 < var2 && var10.bX != var0 && a(var10, var1, var2, var3) && var10.bX.d(var0) && (!var4 || var10.bI())) {
                ++var5;
            }
        }

        return var5;
    }

    public static int b(PlayerData var0, float var1, float var2, float var3) {
        int var4 = 0;
        float var5 = var3;
        Unit[] var6 = Unit.bE.a();
        int var7 = 0;

        for(int var8 = Unit.bE.size(); var7 < var8; ++var7) {
            Unit var9 = var6[var7];
            if (var9.xCord + var5 > var1 && var9.xCord - var5 < var1 && var9.yCord + var5 > var2 && var9.yCord - var5 < var2 && var9.bX != var0 && a(var9, var1, var2, var3) && var9.bX.c(var0)) {
                ++var4;
            }
        }

        return var4;
    }

    public int a(class_564 var1, float var2, float var3, int var4) {
        int var5 = 0;

        class_659 var7;
        for(Iterator var6 = var1.c.iterator(); var6.hasNext(); var5 += this.a(var7.a, var2, var3, var4)) {
            var7 = (class_659)var6.next();
        }

        return var5;
    }

    public int a(class_31 var1, float var2, float var3, int var4) {
        int var5 = 0;
        GameEngine var6 = GameEngine.getGameEngine();
        bI.clear();
        var6.cc.a(this, var2, var3, (float)var4, bI);
        Unit[] var7 = bI.a();
        int var8 = 0;

        for(int var9 = bI.size(); var8 < var9; ++var8) {
            Unit var10 = var7[var8];
            if (var10.bX == this && var10.dz == var1 && a(var10, var2, var3, (float)var4)) {
                ++var5;
            }
        }

        return var5;
    }

    public int au() {
        int var1 = 0;
        Unit[] var2 = Unit.bE.a();
        int var3 = 0;

        for(int var4 = Unit.bE.size(); var3 < var4; ++var3) {
            Unit var10000 = var2[var3];
            ++var1;
        }

        return var1;
    }

    public void T() {
        if (this.aZ && this.au() != 0) {
            GameEngine.log("waking up AI");
            this.aZ = false;
        }

    }

    public void d(Unit var1) {
        if (var1 instanceof OrderableUnit) {
            OrderableUnit var2 = (OrderableUnit)var1;
            var2.bD = false;
            if (var2.aC != null) {
                var2.aC.a(var2);
                var2.aC = null;
            }

            if (var2.aB != null) {
                var2.aB.b(var2);
                var2.aB = null;
            }

            this.e(var2);
        }
    }

    public void a(OrderableUnit var1, class_447 var2, boolean var3) {
        if (var1.aC != null) {
            var1.aC.a(var1, var2, var3);
        }

    }

    public boolean j(Unit var1) {
        return var1.cg() || !this.c((PlayerData)var1.bX);
    }

    public boolean a(class_447 var1, Unit var2) {
        return this.a(var1, var2, false);
    }

    public boolean a(class_447 var1, Unit var2, boolean var3) {
        return var1.b(var2);
    }

    public void a(class_1002 var1) {
        if (!this.bJ.contains(var1)) {
            this.bJ.add(var1);
        } else {
            this.c((String)("Skipping add of component: " + var1.a().name()));
        }

    }

    // $FF: synthetic method
    static boolean a(class_138 var0, class_31 var1) {
        return var0.a(var1);
    }
}
