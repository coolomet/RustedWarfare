package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_243;
import com.corrodinggames.rts.game.units.custom.class_387;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.ar
// class_712
public abstract strictfp class UnitType implements class_31 {
    public static final UnitType extractor = new class_754("extractor", 0);
    public static final UnitType landFactory = new class_750("landFactory", 1);
    public static final UnitType airFactory = new class_740("airFactory", 2);
    public static final UnitType seaFactory = new class_730("seaFactory", 3);
    public static final UnitType commandCenter = new class_720("commandCenter", 4);
    public static final UnitType turret = new class_761("turret", 5);
    public static final UnitType antiAirTurret = new class_762("antiAirTurret", 6);
    public static final UnitType builder = new class_763("builder", 7);
    public static final UnitType tank = new class_764("tank", 8);
    public static final UnitType hoverTank = new class_755("hoverTank", 9);
    public static final UnitType artillery = new class_752("artillery", 10);
    public static final UnitType helicopter = new class_753("helicopter", 11);
    public static final UnitType airShip = new class_758("airShip", 12);
    public static final UnitType gunShip = new class_759("gunShip", 13);
    public static final UnitType missileShip = new class_756("missileShip", 14);
    public static final UnitType gunBoat = new class_757("gunBoat", 15);
    public static final UnitType megaTank = new class_760("megaTank", 16);
    public static final UnitType laserTank = new class_748("laserTank", 17);
    public static final UnitType hovercraft = new class_749("hovercraft", 18);
    public static final UnitType ladybug = new class_751("ladybug", 19);
    public static final UnitType battleShip = new class_742("battleShip", 20);
    public static final UnitType tankDestroyer = new class_743("tankDestroyer", 21);
    public static final UnitType heavyTank = new class_744("heavyTank", 22);
    public static final UnitType heavyHoverTank = new class_745("heavyHoverTank", 23);
    public static final UnitType laserDefence = new class_746("laserDefence", 24);
    public static final UnitType dropship = new class_747("dropship", 25);
    public static final UnitType tree = new class_737("tree", 26);
    public static final UnitType repairbay = new class_738("repairbay", 27);
    public static final UnitType NukeLaucher = new class_739("NukeLaucher", 28);
    public static final UnitType AntiNukeLaucher = new class_741("AntiNukeLaucher", 29);
    public static final UnitType mammothTank = new class_732("mammothTank", 30);
    public static final UnitType experimentalTank = new class_733("experimentalTank", 31);
    public static final UnitType experimentalLandFactory = new class_734("experimentalLandFactory", 32);
    public static final UnitType crystalResource = new class_735("crystalResource", 33);
    public static final UnitType wall_v = new class_736("wall_v", 34);
    public static final UnitType fabricator = new class_726("fabricator", 35);
    public static final UnitType attackSubmarine = new class_727("attackSubmarine", 36);
    public static final UnitType builderShip = new class_728("builderShip", 37);
    public static final UnitType amphibiousJet = new class_729("amphibiousJet", 38);
    public static final UnitType supplyDepot = new class_731("supplyDepot", 39);
    public static final UnitType experimentalHoverTank = new class_722("experimentalHoverTank", 40);
    public static final UnitType turret_artillery = new class_723("turret_artillery", 41);
    public static final UnitType turret_flamethrower = new class_724("turret_flamethrower", 42);
    public static final UnitType fogRevealer = new class_725("fogRevealer", 43);
    public static final UnitType spreadingFire = new class_715("spreadingFire", 44);
    public static final UnitType antiAirTurretT2 = new class_716("antiAirTurretT2", 45);
    public static final UnitType turretT2 = new class_717("turretT2", 46);
    public static final UnitType turretT3 = new class_718("turretT3", 47);
    public static final UnitType damagingBorder = new class_719("damagingBorder", 48);
    public static final UnitType zoneMarker = new class_721("zoneMarker", 49);
    public static final UnitType editorOrBuilder = new class_713("editorOrBuilder", 50);
    public static final UnitType dummyNonUnitWithTeam = new class_714("dummyNonUnitWithTeam", 51);
    class_243 aa;
    int ab;
    String ac;
    String ad;
    final String name;
    public String name() { return name; }
    final int ordinal;
    public int ordinal() { return ordinal; }
    public static ArrayList ae;
    class_1040[] af;
    public static boolean ag;
    class_447 ah;
    // $FF: synthetic field
    private static final UnitType[] ai = new UnitType[]{extractor, landFactory, airFactory, seaFactory, commandCenter, turret, antiAirTurret, builder, tank, hoverTank, artillery, helicopter, airShip, gunShip, missileShip, gunBoat, megaTank, laserTank, hovercraft, ladybug, battleShip, tankDestroyer, heavyTank, heavyHoverTank, laserDefence, dropship, tree, repairbay, NukeLaucher, AntiNukeLaucher, mammothTank, experimentalTank, experimentalLandFactory, crystalResource, wall_v, fabricator, attackSubmarine, builderShip, amphibiousJet, supplyDepot, experimentalHoverTank, turret_artillery, turret_flamethrower, fogRevealer, spreadingFire, antiAirTurretT2, turretT2, turretT3, damagingBorder, zoneMarker, editorOrBuilder, dummyNonUnitWithTeam};

    public static UnitType[] values() {
        return (UnitType[])ai.clone();
    }

    private UnitType(String var1, int var2) {
        this.name = var1;
        ordinal = var2;
        this.aa = new class_243(this);
        this.ab = -1;
    }

    public Unit a() {
        return this.a(false);
    }

    public abstract Unit a(boolean var1);

    public abstract void b();

    public abstract int price();

    public class_243 d() {
        return this.aa;
    }

    public String e() {
        if (this.ab != class_1009.c || this.ac == null) {
            this.ab = class_1009.c;
            String var1 = "units." + this.name() + ".name";
            this.ac = class_1009.a(var1, (String)null);
            if (this.ac == null) {
                if (GameEngine.getGameEngine().as() && !this.A()) {
                    throw new RuntimeException("Can't find translation text for: " + var1);
                }

                this.ac = this.name();
            }
        }

        return this.ac;
    }

    public String f() {
        if (this.ab != class_1009.c || this.ad == null) {
            this.ab = class_1009.c;
            String var1 = "units." + this.name() + ".description";
            this.ad = class_1009.a(var1, (String)null);
            if (this.ad == null) {
                if (GameEngine.getGameEngine().as() && !this.A()) {
                    throw new RuntimeException("Can't find translation text for: " + var1);
                }

                this.ad = "";
            }
        }

        return this.ad;
    }

    public int g() {
        return 1;
    }

    public void a(ArrayList var1, int var2) {
    }

    public void h() {
        class_1040[] var1 = new class_1040[3];

        for(int var2 = 1; var2 <= 3; ++var2) {
            class_1040 var3 = new class_1040();
            this.a(var3.a, var2);
            var1[var2 - 1] = var3;
        }

        this.af = var1;
    }

    public ArrayList a(int var1) {
        if (var1 > 3) {
            throw new RuntimeException("Tech level:" + var1 + " greater than maxTechLevel");
        } else {
            return this.af[var1 - 1].a;
        }
    }

    public String i() {
        return this.name();
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this.j();
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public MovementType o() {
        Unit var1 = Unit.a((class_31)this);
        if (var1 == null) {
            throw new RuntimeException("Shared unit is null for:" + this.name());
        } else {
            return var1.h();
        }
    }

    public boolean p() {
        return false;
    }

    public class_387 q() {
        return null;
    }

    public static class_31 a(String var0) {
        return a(var0, true);
    }

    public static class_31 a(String var0, boolean var1) {
        if (var1) {
            class_31 var2 = class_591.m(var0);
            if (var2 != null) {
                return var2;
            }
        }

        UnitType[] var6 = values();
        int var3 = var6.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            UnitType var5 = var6[var4];
            if (var5.name().equalsIgnoreCase(var0)) {
                return var5;
            }
        }

        class_591 var7 = class_591.n(var0);
        if (var7 != null) {
            return var7;
        } else {
            return null;
        }
    }

    private static String a(String var0, float var1) {
        return a(var0, var1, "");
    }

    private static String a(String var0, float var1, String var2) {
        String var3 = "" + var1;
        if (var1 % 1.0F == 0.0F) {
            var3 = "" + (int)var1;
        }

        return a(var0, var3, var2);
    }

    private static String a(String var0, String var1, String var2) {
        return var0 + ": " + var1 + var2 + "\n";
    }

    private static int a(OrderableUnit var0) {
        class_1059 var1 = var0.cm();
        if (var1 != null) {
            class_226 var2 = var0.a((class_1059)var1);
            if (var2 != null) {
                return var2.c();
            }
        }

        return 0;
    }

    public static void r() {
        String var0 = "output_all_unit_images/";
        (new File(var0)).mkdirs();

        for(int var1 = 0; var1 < 50; ++var1) {
            GameEngine.a("running outputUnitImages()");
        }

        String[] var21 = new String[]{"carrier", "experimentalGunship", "experimentalGunshipLanded", "mech_gun", "ladybug", "spiderBot", "wall_v", "crystalResource", "test_tank", "missing", "fogRevealer", "supplyDepot", "tankDestroyer", "megaTank", "crystal_mid", "mechFlyingLanded"};
        Iterator var2 = ae.iterator();

        while(true) {
            class_31 var3;
            Unit var4;
            class_31 var5;
            do {
                do {
                    do {
                        do {
                            if (!var2.hasNext()) {
                                return;
                            }

                            var3 = (class_31)var2.next();
                            var4 = Unit.a(var3);
                        } while(!(var4 instanceof OrderableUnit));
                    } while(var3.i().startsWith("bug"));

                    var5 = class_591.c(var3);
                } while(var5 != null);
            } while(var3 instanceof class_591 && !((class_591)var3).aF);

            OrderableUnit var6 = (OrderableUnit)var4;
            boolean var7 = false;
            String[] var8 = var21;
            int var9 = var21.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                String var11 = var8[var10];
                if (var11.equals(var3.i())) {
                    var7 = true;
                }
            }

            if (!var7) {
                String var22 = var0 + var3.i().replace("/", "_").replace("\\", "_") + ".png";
                GameEngine var23 = GameEngine.getGameEngine();
                byte var24 = 100;
                TeamImageCache var25 = var23.bO.b(var24, var24, true);
                class_28 var12 = var23.bO.b(var25);
                class_28 var13 = var23.bO;
                var23.bO = var12;
                float var14 = 0.0F;
                float var15 = 0.0F;
                PlayerData var16 = PlayerData.getPlayerData(0);
                boolean var17 = false;
                boolean var18 = false;
                byte var19 = 1;
                boolean var20 = true;
                a(var3, (float)var25.r, (float)var25.s, var14, var15, var16, 20.0F, (float)var24, var17, var18, var19, var20, (Unit)null);
                var23.bO = var13;
                var12.p();
                var23.bO.a(var25, new File(var22));
            }
        }
    }

    public static void printForHelp() {
        for(int var0 = 0; var0 < 50; ++var0) {
            GameEngine.a("running printForHelp()");
        }

        String[] var18 = new String[]{"carrier", "experimentalGunship", "experimentalGunshipLanded", "mech_gun", "ladybug", "spiderBot", "wall_v", "crystalResource", "test_tank", "missing", "fogRevealer", "supplyDepot", "tankDestroyer", "megaTank", "crystal_mid", "mechFlyingLanded"};
        String var1 = "";
        ArrayList var2 = new ArrayList();
        var2.addAll(ae);
        Collections.sort(var2, new class_945());
        Iterator var3 = var2.iterator();

        while(true) {
            class_31 var4;
            OrderableUnit var7;
            boolean var8;
            int var11;
            do {
                Unit var5;
                do {
                    class_31 var6;
                    do {
                        do {
                            do {
                                do {
                                    if (!var3.hasNext()) {
                                        GameEngine.log(var1);
                                        return;
                                    }

                                    var4 = (class_31)var3.next();
                                    var5 = Unit.a(var4);
                                } while(!(var5 instanceof OrderableUnit));
                            } while(var4.i().startsWith("bug"));

                            var6 = class_591.c(var4);
                        } while(var6 != null);
                    } while(var4 instanceof class_591 && !((class_591)var4).aF);
                } while(var4 == editorOrBuilder);

                var7 = (OrderableUnit)var5;
                var8 = false;
                String[] var9 = var18;
                int var10 = var18.length;

                for(var11 = 0; var11 < var10; ++var11) {
                    String var12 = var9[var11];
                    if (var12.equals(var4.i())) {
                        var8 = true;
                    }
                }
            } while(var8);

            var1 = var1 + "\n";
            var1 = var1 + "<div class=\"unit\">\n";
            var1 = var1 + "<img src=\"unit:" + var4.i() + "\" />\n";
            var1 = var1 + "<h4>" + var4.e() + "</h4>\n";
            var1 = var1 + "<p>" + var4.f().replace("\n", "<br/>") + "</p>\n";
            var1 = var1 + "<pre>";
            var1 = var1 + a("Price", "$" + var4.price(), "");
            int var19 = a(var7);
            if (var19 > 0) {
                var1 = var1 + a("T2 Upgrade Price", "$" + var19, "");
                OrderableUnit var20 = (OrderableUnit)var4.a();
                var20.a((int)2);
                if (var20.V() == 2) {
                    var11 = a(var20);
                    if (var11 > 0) {
                        var1 = var1 + a("T3 Upgrade Price", "$" + var11, "");
                    }
                }
            }

            var1 = var1 + a("Hp", var7.totalHealth);
            var1 = var1 + a("Speed", var7.speed());
            var1 = var1 + a("Turn speed", var7.turnSpeed());
            var1 = var1 + a("Mass", var7.mass());
            if (var7.l()) {
                var1 = var1 + a("Shoot Delay", var7.shootDelay(0));
                var1 = var1 + a("Attack Range", var7.attackRange());
                float var21 = 0.0F;
                float var22 = 0.0F;
                float var23 = 0.0F;
                float var13 = 0.0F;
                int var14 = var7.bl();

                for(int var15 = 0; var15 < var14; ++var15) {
                    int var16 = Projectile.a.a;
                    var7.a(var7, var15);
                    if (var16 != Projectile.a.a) {
                        Projectile var17 = (Projectile)Projectile.a.get(Projectile.a.a - 1);
                        if (var17.U > var21) {
                            var21 = var17.U;
                        }

                        if (var17.Y > var22) {
                            var22 = var17.Y;
                        }

                        var23 += var17.U;
                        var13 += var17.Y;
                    }
                }

                String var24;
                if (var23 != 0.0F) {
                    var24 = "";
                    if (var23 != var21) {
                        var24 = " (total:" + var23 + ")";
                    }

                    var1 = var1 + a("Direct Damage", var21, var24);
                }

                if (var13 != 0.0F) {
                    var24 = "";
                    if (var13 != var22) {
                        var24 = " (total:" + var13 + ")";
                    }

                    var1 = var1 + a("Area Damage", var22, var24);
                }
            }

            var1 = var1 + "</pre>";
            var1 = var1 + "</div>\n";
        }
    }

    public static void t() {
        UnitType[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            UnitType var3 = var0[var2];
            var3.name();
            var3.e();
            var3.f();
        }

    }

    public static boolean a(class_31 var0, float var1, float var2, float var3, float var4, PlayerData var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        Unit var7 = Unit.a(var0);
        if (var7 == null) {
            GameEngine.log("isValidHere: Failed to get unit from type:" + var0);
            return false;
        } else {
            var7.b(var5);
            var7.zCord = var4;
            var7.xCord = var1;
            var7.yCord = var2;
            if (!var7.bI()) {
                var7.cg = var3;
                if (var7 instanceof OrderableUnit) {
                    OrderableUnit var8 = (OrderableUnit)var7;
                    var8.j(var3);
                }
            }

            boolean var10 = true;
            if (var7 instanceof OrderableUnit) {
                OrderableUnit var9 = (OrderableUnit)var7;
                var10 = var9.c(var5);
            }

            var7.zCord = 0.0F;
            var7.cg = 0.0F;
            return var10;
        }
    }

    public static void a(class_31 var0, float var1, float var2, float var3, float var4, PlayerData var5, float var6, float var7, boolean var8, boolean var9, int var10, Unit var11) {
        boolean var12 = true;
        a(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var12, var11);
    }

    public static strictfp void a(class_31 var0, float var1, float var2, float var3, float var4, PlayerData var5, float var6, float var7, boolean var8, boolean var9, int var10, boolean var11, Unit var12) {
        GameEngine var13 = GameEngine.getGameEngine();
        Unit var14 = Unit.c(var0);
        boolean var15 = var14.bI();
        var14.b(var5);
        OrderableUnit var16;
        if (var14 instanceof OrderableUnit) {
            var16 = (OrderableUnit)var14;
            var16.a(var10);
        }

        var14.zCord = var4;
        if (var14.h() == MovementType.HOVER || var14.h() == MovementType.OVER_CLIFF || var14.h() == MovementType.OVER_CLIFF_WATER) {
            var14.zCord += 4.0F;
        }

        if (var14.h() == MovementType.AIR) {
            var14.zCord += 10.0F;
        }

        if (!var15) {
            var14.cg = var3;
            if (var14 instanceof OrderableUnit) {
                var16 = (OrderableUnit)var14;
                var16.j(var3);
            }
        } else {
            var14.cg = -90.0F;
        }

        boolean var25 = true;
        boolean var17 = var14.cp;
        var14.cp = true;
        var14.cs = false;
        var14.ct = false;
        if (!var11) {
            var14.ct = true;
        }

        var14.co = false;
        var14.cq = false;
        var14.cr = false;
        if (!var8 && !var9) {
            var14.co = true;
        } else {
            var14.cq = var9;
            var14.cr = var8;
            var25 = false;
        }

        if (!var25) {
            var14.xCord = var1;
            var14.yCord = var2;
        } else {
            var14.xCord = var13.cw + var1;
            var14.yCord = var13.cx + var2;
        }

        float var18 = var14.cj * 2.0F * 0.8F;
        if (var14 instanceof OrderableUnit) {
            OrderableUnit var19 = (OrderableUnit)var14;
            if (var19.M != null) {
                float var20 = (float)var19.et * var19.cD();
                if (var20 > var18) {
                    var18 = var20;
                }
            }
        }

        float var26 = 1.0F;
        if (var18 < var6) {
            var26 = var6 / var18;
        }

        if (var18 > var7) {
            var26 = var7 / var18;
        }

        var13.bO.k();
        if (var25) {
        }

        if (var26 != 1.0F) {
            var13.bO.a(var26, var26, var1, var2);
        }

        if (var26 < 1.0F) {
            ag = true;
        } else {
            ag = false;
        }

        if (var12 != null) {
            class_1069 var27 = var14.dH;
            var14.dH = var12.dH;
            int var21 = var14.cE;
            var14.cE = var12.cE;
            float var22 = var14.health;
            var14.health = var12.health;
            float var23 = var14.cB;
            var14.cB = var12.cB;
            VariableScope var24 = var14.bw;
            var14.bw = var12.bw;
            var14.d(0.0F);
            var14.c(0.0F);
            var14.a(0.0F, false);
            var14.dH = var27;
            var14.cE = var21;
            var14.health = var22;
            var14.cB = var23;
            var14.bw = var24;
        } else {
            var14.d(0.0F);
            var14.c(0.0F);
            var14.a(0.0F, false);
        }

        var13.bO.l();
        var14.zCord = 0.0F;
        if (!var15) {
            var14.cg = 0.0F;
        } else {
            var14.cg = -90.0F;
        }

        if (var14 instanceof OrderableUnit) {
            OrderableUnit var28 = (OrderableUnit)var14;
            var28.j(0.0F);
            var28.a((int)1);
        }

        var14.cq = false;
        var14.cr = false;
        var14.cp = var17;
        var14.co = false;
    }

    public int b(int var1) {
        int var2 = this.price();
        if (var1 >= 2) {
            var2 += this.upgradePrice(2);
        }

        if (var1 >= 3) {
            var2 += this.upgradePrice(2);
        }

        return var2;
    }

    public int upgradePrice(int var1) {
        return 0;
    }

    public class_447 u() {
        int var1 = this.price();
        if (var1 == 0) {
            return class_447.a;
        } else {
            if (this.ah == null || this.ah.a() != var1) {
                this.ah = class_447.a(var1);
            }

            return this.ah;
        }
    }

    public class_447 d(int var1) {
        int var2 = this.b(var1);
        return class_447.a(var2);
    }

    public String v() {
        return this.name();
    }

    public boolean w() {
        return false;
    }

    public class_588 x() {
        return null;
    }

    public boolean y() {
        return true;
    }

    public TeamImageCache z() {
        return null;
    }

    public int a(Unit var1) {
        return 0;
    }

    public boolean A() {
        return false;
    }

    public class_447 B() {
        return null;
    }

    // $FF: synthetic method
    UnitType(String var1, int var2, class_754 var3) {
        this(var1, var2);
    }
}
