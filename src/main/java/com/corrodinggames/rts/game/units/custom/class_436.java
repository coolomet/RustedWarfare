package com.corrodinggames.rts.game.units.custom;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.ColoringMode;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.AttackMovementType;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_234;
import com.corrodinggames.rts.game.units.a.class_235;
import com.corrodinggames.rts.game.units.a.class_237;
import com.corrodinggames.rts.game.units.a.class_241;
import com.corrodinggames.rts.game.units.a.class_282;
import com.corrodinggames.rts.game.units.air.class_107;
import com.corrodinggames.rts.game.units.custom.a.class_1032;
import com.corrodinggames.rts.game.units.custom.a.class_1034;
import com.corrodinggames.rts.game.units.custom.a.class_1035;
import com.corrodinggames.rts.game.units.custom.a.AIUse;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_283;
import com.corrodinggames.rts.game.units.custom.a.a.class_777;
import com.corrodinggames.rts.game.units.custom.a.a.class_778;
import com.corrodinggames.rts.game.units.custom.a.a.class_779;
import com.corrodinggames.rts.game.units.custom.a.a.class_780;
import com.corrodinggames.rts.game.units.custom.a.a.class_781;
import com.corrodinggames.rts.game.units.custom.a.a.class_782;
import com.corrodinggames.rts.game.units.custom.a.a.class_783;
import com.corrodinggames.rts.game.units.custom.a.a.class_784;
import com.corrodinggames.rts.game.units.custom.a.a.class_785;
import com.corrodinggames.rts.game.units.custom.a.a.class_786;
import com.corrodinggames.rts.game.units.custom.a.a.class_787;
import com.corrodinggames.rts.game.units.custom.a.a.class_788;
import com.corrodinggames.rts.game.units.custom.a.a.class_789;
import com.corrodinggames.rts.game.units.custom.b.class_828;
import com.corrodinggames.rts.game.units.custom.b.class_829;
import com.corrodinggames.rts.game.units.custom.b.class_831;
import com.corrodinggames.rts.game.units.custom.b.class_832;
import com.corrodinggames.rts.game.units.custom.b.class_833;
import com.corrodinggames.rts.game.units.custom.b.class_834;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.e.class_1067;
import com.corrodinggames.rts.game.units.custom.e.class_1068;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.game.units.custom.f.class_957;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference$UnitReferenceOrUnitType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.buildings.class_88;
import com.corrodinggames.rts.game.units.land.class_120;
import com.corrodinggames.rts.game.units.land.Builder;
import com.corrodinggames.rts.game.units.land.class_128;
import com.corrodinggames.rts.game.units.land.ExperimentalHoverTank;
import com.corrodinggames.rts.game.units.sea.class_114;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_355;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import com.corrodinggames.rts.gameFramework.i.class_800;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_371;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_672;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.ag
// ModLoader?
public strictfp class class_436 {
    static boolean a = false;
    static int b;
    static int c;
    public static int d;
    static class_800 e;
    static boolean f;
    public static HashMap g = new HashMap();
    public static HashMap h = new HashMap();
    static int i;
    static int j;
    static boolean k;
    static int l;
    public static class_684 m = new class_684();
    static HashMap n = new HashMap();
    static final Object o = new Object();
    public static float p = 50.0F;
    public static float q = 50.0F;
    static class_800 r = null;
    static String s = null;

    public static void a(int var0) {
        if (e != null) {
            class_800 var10000 = e;
            var10000.G += (long)var0;
        }

    }

    public static void a() {
        i();
        j();
    }

    public static void a(TeamImageCache var0) {
        if (var0 != null && !var0.v) {
            if (GameEngine.az() && var0 instanceof class_371) {
                return;
            }

            var0.v = true;
            a(var0.u());
        }

    }

    public static void a(TeamImageCache[] var0) {
        if (var0 != null) {
            TeamImageCache var1 = null;
            TeamImageCache[] var2 = var0;
            int var3 = var0.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                TeamImageCache var5 = var2[var4];
                if (var5 != var1) {
                    a(var5);
                }

                if (var1 == null) {
                    var1 = var5;
                }
            }
        }

    }

    public static void a(class_355 var0) {
        if (!var0.g) {
            var0.g = true;
            if (e != null) {
                class_800 var10000 = e;
                var10000.H += (long)var0.a();
            }
        }

    }

    public static boolean a(class_684 var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        boolean var2 = false;
        boolean var3 = false;
        boolean var4 = false;
        ArrayList var5 = new ArrayList(class_591.c);
        ArrayList var6 = new ArrayList(class_591.d);
        class_684 var7 = new class_684();
        String var8 = null;
        Iterator var9 = var0.iterator();

        class_591 var10;
        while(var9.hasNext()) {
            var10 = (class_591)var9.next();
            class_591 var11 = a(var10);
            if (var11 == null) {
                GameEngine.log("Failed to apply changes to unit type: " + var10.M);
                var2 = true;
                if (var8 == null && s != null) {
                    var8 = s;
                }
            } else {
                GameEngine.log("Changes applied to unit type: " + var10.M);
                var3 = true;
                var7.add(var11);
            }
        }

        if (var8 != null && GameEngine.at()) {
            var1.c("Unit errors", var8);
        }

        if (var3 && !c(false)) {
            var2 = true;
        }

        if (var3 && !var2) {
            class_591.e = null;
            e();
            s = null;
            PlayerData.P();
            InterfaceEngine.K();
            var4 = true;
            if (!var2) {
                var9 = var7.iterator();

                while(var9.hasNext()) {
                    var10 = (class_591)var9.next();
                    if (var10.gt.size() > 0) {
                        var1.log(var10.gt.size() + " Warning(s) loading: " + var10.b() + " \n" + (String)var10.gt.get(0), 1);
                        var10.gt.clear();
                        var4 = false;
                        break;
                    }
                }
            }
        }

        if (var2) {
            GameEngine.log("Failed to load some units, keeping old config");
            synchronized(class_591.c) {
                class_591.c.clear();
                class_591.c.addAll(var5);
            }

            class_591.d = var6;
        }

        return var4;
    }

    public static void b() {
        class_684 var0 = new class_684();
        b = 0;
        c = 0;
        d = 0;
        Iterator var1 = Unit.bF().iterator();

        while(var1.hasNext()) {
            Unit var2 = (Unit)var1.next();
            class_31 var3 = var2.r();
            if (var3 instanceof class_591 && !var0.contains(var3)) {
                var0.add((class_591)var3);
            }
        }

        if (var0.size() > 0) {
            boolean var4 = a(var0);
        }

    }

    public static void c() {
        boolean var0 = false;
        class_684 var1 = new class_684();
        Iterator var2 = class_591.c.iterator();

        while(var2.hasNext()) {
            class_591 var3 = (class_591)var2.next();
            boolean var4 = false;
            Iterator var5 = var3.k.iterator();

            while(var5.hasNext()) {
                class_434 var6 = (class_434)var5.next();
                long var7 = var6.a(false);
                if (var7 != var6.a) {
                    var4 = true;
                    var6.a = var7;
                }
            }

            if (var4) {
                if (!var0) {
                    GameEngine.log("Detected unit changes");
                    var0 = true;
                }

                var1.add(var3);
            }
        }

        if (var1.size() > 0) {
            a(var1);
        }

    }

    public static void d() {
        if (class_591.e != null) {
            GameEngine.log("applyPendingNetworkUnits: Applying new network units from server (" + class_591.e.size() + " units)");
            class_591.d = class_591.e;
            class_591.e = null;
            e();
        } else {
            GameEngine.log("applyPendingNetworkUnits: no server units list found");
        }

    }

    public static ArrayList a(boolean var0) {
        ArrayList var1 = new ArrayList();
        synchronized(class_591.c) {
            Iterator var3 = class_591.c.iterator();

            while(true) {
                class_591 var4;
                do {
                    if (!var3.hasNext()) {
                        return var1;
                    }

                    var4 = (class_591)var3.next();
                } while(var4.J != null && (!var4.J.m() || !var0));

                var1.add(var4);
            }
        }
    }

    @SneakyThrows
    public static UnitConfig a(String var0) {
        synchronized(n) {
            UnitConfig var2 = (UnitConfig)n.get(var0);
            if (var2 != null) {
                return var2;
            } else {
                AssetInputStream var3 = b(var0);
                if (var3 == null) {
                    return null;
                } else {
                    BufferedInputStream var4 = new BufferedInputStream(var3);

                    UnitConfig var5;
                    try {
                        var5 = new UnitConfig(var4, var0);
                        var5.a();
                        var5.f = var3.d();
                    } catch (Exception var8) {
                        var8.printStackTrace();
                        throw new CustomException("Load of '" + var0 + "' failed: " + var8.getMessage());
                    }

                    n.put(var0, var5);
                    return var5;
                }
            }
        }
    }

    @SneakyThrows
    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, boolean var4) {
        UnitConfig var5 = a(var2);
        if (var5 == null) {
            if (!var4) {
                throw new CustomException("[" + var3 + "] Could not find conf target:" + var2);
            }
        } else {
            var0.o(var5.f);
            var1.a(var5);
            a(var0, var1, (UnitConfig)var5, var2, 1);
        }
    }

    @SneakyThrows
    public static void a(class_591 var0, UnitConfig var1, UnitConfig var2, String var3, int var4) {
        if (var4 > 10) {
            throw new CustomException("copyFrom can only be 10 levels deep, maybe you have a loop?");
        } else {
            String var5 = var2.getValueAsStaticString("core", "copyFrom", (String)null);
            if (var5 != null) {
                String[] var6 = var5.split(",");
                Collections.reverse(Arrays.asList(var6));
                String[] var7 = var6;
                int var8 = var6.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    String var10 = var7[var9];
                    var10 = var10.trim();
                    if (!var10.equals("")) {
                        if (var10.contains("..")) {
                            throw new CustomException("'..' not supported in copyFrom");
                        }

                        String var11;
                        String var12;
                        if (var10.startsWith("ROOT:")) {
                            var10 = var10.substring("ROOT:".length());
                            if (var0.J == null) {
                                var12 = "units/common.ini";
                            } else {
                                var12 = var0.J.q + "/common.ini";
                            }

                            var11 = a(class_340.getDirctory(var12), var10);
                        } else if (var10.startsWith("CORE:")) {
                            var10 = var10.substring("CORE:".length());
                            var12 = "units/common.ini";
                            var11 = a(class_340.getDirctory(var12), var10);
                        } else {
                            var11 = a(class_340.getDirctory(var3), var10);
                        }

                        UnitConfig var14 = a(var11);
                        if (var14 == null) {
                            String var13 = "Could not find copyFrom target:" + var11;
                            if (var4 != 0) {
                                var13 = var13 + " (while loading: " + var3 + ")";
                            }

                            throw new CustomException(var13);
                        }

                        var0.o(var14.f);
                        var1.a(var14);
                        a(var0, var1, var14, var11, var4 + 1);
                    }
                }
            }

        }
    }

    @SneakyThrows
    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, int var4) {
        if (var4 > 10) {
            throw new CustomException("@copyFromSection can only be 10 levels deep, maybe you have a loop?");
        } else {
            String var5 = var1.getValueAsStaticString(var3, "@copyFromSection", (String)null);
            if (var5 != null && !var5.equals("")) {
                String[] var6 = var5.split(",");
                Collections.reverse(Arrays.asList(var6));
                String[] var7 = var6;
                int var8 = var6.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    String var10 = var7[var9];
                    var10 = var10.trim();
                    if (!var10.equals("")) {
                        class_684 var11 = var1.k(var10, "");
                        if (var11.size() == 0) {
                            throw new CustomException("[" + var3 + "]@copyFromSection: Could not find keys in target section: " + var10);
                        }

                        Iterator var12 = var11.iterator();

                        while(var12.hasNext()) {
                            String var13 = (String)var12.next();
                            String var14 = var1.getValueDirectly(var10, var13);
                            if (var14 != null) {
                                var1.d(var2, var13, var14);
                            }
                        }

                        a(var0, var1, var2, var10, var4 + 1);
                    }
                }

            }
        }
    }

    public static class_388 a(UnitConfig var0, String var1, String var2, String var3) {
        return var0.a(var1, var2, var3, false);
    }

    public static class_441 a(class_591 var0, UnitConfig var1, String var2, String var3, String var4) {
        return var1.a(var0, var2, var3, var4);
    }

    public static class_591 a(class_591 var0) {
        String var1 = var0.D;
        GameEngine var2 = GameEngine.getGameEngine();
        class_591 var3 = null;
        String var4 = null;
        if (var0.J != null) {
            var4 = var0.J.R;
        }

        synchronized(n) {
            n.clear();
        }

        s = null;

        try {
            var3 = a(var1, var0.J, var0.K, var0.L);
        } catch (RuntimeException var10) {
            var10.printStackTrace();
            if (s == null) {
                String var6 = "Error loading unit:" + a(var0.J, var1, true) + "\n" + var10.getMessage();
                var2.log(var6, 1);
            }
        }

        if (var3 == null && var0.J != null) {
            var0.J.R = var4;
        }

        if (var3 != null) {
            synchronized(class_591.c) {
                class_591.c.remove(var0);
            }

            a((class_31)var0, (class_591)var3, true);
            if (class_591.d.remove(var0)) {
                class_591.d.add(var3);
                if (var0.H != var3.H) {
                    ++d;
                }
            } else {
                GameEngine.log("Changed unit was not enabled (original not found in customUnitTypes)");
            }

            PlayerData.P();
            InterfaceEngine.K();
        }

        return var3;
    }

    public static void a(class_31 var0, class_591 var1, boolean var2) {
        Iterator var3 = Unit.bF().iterator();

        while(var3.hasNext()) {
            Unit var4 = (Unit)var3.next();
            if (var4 instanceof class_113) {
                class_113 var5 = (class_113)var4;
                if (var5.x == var0) {
                    PlayerData.b((Unit)var5);
                    var5.a(var1, false, var2);
                    var5.S();
                    if (var5.dg() != null) {
                        var5.dg().a(var1);
                    }

                    PlayerData.c((Unit)var5);
                }

                if (var5.z == var0) {
                    var5.z = var1;
                }
            }
        }

    }

    public static String a(ArrayList var0) {
        HashMap var1 = new HashMap();
        Iterator var2 = var0.iterator();

        class_800 var4;
        Integer var5;
        while(var2.hasNext()) {
            class_591 var3 = (class_591)var2.next();
            var4 = var3.J;
            if (var4 != null) {
                var5 = (Integer)var1.get(var4);
                if (var5 == null) {
                    var5 = 1;
                } else {
                    var5 = var5 + 1;
                }

                var1.put(var4, var5);
            }
        }

        String var6 = "";

        for(Iterator var7 = var1.keySet().iterator(); var7.hasNext(); var6 = var6 + var4.modName() + "(unitCount: " + var5 + (var4.m() ? "" : "[disabled]") + "), ") {
            var4 = (class_800)var7.next();
            var5 = (Integer)var1.get(var4);
        }

        return var6;
    }

    public static String b(boolean var0) {
        ArrayList var1 = a(var0);
        class_591.e = null;
        class_591.d = var1;
        s = null;
        GameEngine.log("enableAll: " + a(class_591.d));
        e();
        return s;
    }

    public static boolean c(boolean var0) {
        ArrayList var1 = class_591.d;
        ArrayList var2;
        if (var0) {
            var2 = a(true);
        } else {
            var2 = class_591.d;
        }

        boolean var3 = true;
        s = null;
        class_591.d = var2;
        g();
        if (s != null) {
            var3 = false;
        }

        class_591.d = var1;
        g();
        return var3;
    }

    public static void e() {
        synchronized(o) {
            n();
        }
    }

    private static void n() {
        class_591 var0 = null;
        ArrayList var1 = new ArrayList();
        GameEngine var2 = GameEngine.getGameEngine();
        if (var2.as()) {
            UnitType[] var3 = UnitType.values();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                UnitType var6 = var3[var5];
                var1.add(var6);
            }
        }

        Iterator var7 = class_591.d.iterator();

        class_591 var8;
        while(var7.hasNext()) {
            var8 = (class_591)var7.next();
            var1.add(var8);
            if (var8.M.equals("missing") && var8.J == null) {
                var0 = var8;
            }
        }

        UnitType.ae = var1;
        Unit.bL();
        g();
        f();
        BuiltInResource.e();
        if (var0 == null) {
            GameEngine.log("missingPlaceHolder is not an active unit, searching for new target");
            var7 = class_591.d.iterator();

            while(var7.hasNext()) {
                var8 = (class_591)var7.next();
                if (var8.M.equals("missing")) {
                    GameEngine.log("Found a missing placeholder");
                    var0 = var8;
                }
            }
        }

        class_591.b = var0;
    }

    public static void f() {
        float var0 = 50.0F;
        float var1 = 50.0F;
        Iterator var2 = class_591.d.iterator();

        while(var2.hasNext()) {
            class_591 var3 = (class_591)var2.next();
            float var4 = (float)var3.cW;
            if (var4 > 250.0F) {
                var4 = 250.0F;
            }

            if (var0 < var4) {
                var0 = var4;
            }

            if (var3.aH && var1 < var4) {
                var1 = var4;
            }
        }

        p = var0;
        q = var1;
    }

    public static AssetInputStream b(String var0) {
        String var1 = "" + var0;
        return class_697.k(var1);
    }

    public static void b(ArrayList var0) {
        Collections.sort(var0);
    }

    public static void a(class_31 var0) {
        GameEngine var1 = GameEngine.getGameEngine();

        try {
            var0.h();
            class_591 var2;
            class_601 var4;
            Iterator var17;
            if (var0 instanceof class_591) {
                var2 = (class_591)var0;
                if (var2.fI != null) {
                    class_31 var3 = class_591.s(var2.fI);
                    if (var3 == null) {
                        throw new CustomException("Could not find [ai]upgradedFrom target:" + var2.fI);
                    }

                    var2.b(var3);
                }

                var17 = var2.p.iterator();

                while(var17.hasNext()) {
                    var4 = (class_601)var17.next();
                    var4.a();
                }

                if (var2.eH) {
                    class_591.g.add(var2);
                }
            }

            Iterator var16 = class_591.d.iterator();

            label298:
            while(var16.hasNext()) {
                class_591 var19 = (class_591)var16.next();
                if (var0 instanceof class_591) {
                    class_591 var20 = (class_591)var0;
                    if (var19.fI != null && var19.fI.equalsIgnoreCase(var20.i())) {
                        var20.b((class_31)var19);
                    }
                }

                Iterator var22 = var19.gg.iterator();

                while(true) {
                    class_595 var5;
                    do {
                        if (!var22.hasNext()) {
                            continue label298;
                        }

                        var5 = (class_595)var22.next();
                    } while(!var5.a.equalsIgnoreCase(var0.i()));

                    var5.e = true;
                    int var6 = var19.cl;
                    boolean var7 = false;

                    for(int var8 = var6; var8 <= 3; ++var8) {
                        ArrayList var9 = var0.a(var8);
                        Object var10;
                        if (!var19.aH && !var5.c) {
                            var10 = new class_282(var19);
                        } else {
                            var10 = new class_241(var19);
                        }

                        if (var5.b != -999.0F) {
                            ((class_226)var10).g = var5.b;
                        }

                        boolean var11;
                        if (var5.f != null) {
                            var11 = false;
                            if (!(var0 instanceof class_591)) {
                                Unit var12 = Unit.a(var0);
                                if (!(var12 instanceof OrderableUnit)) {
                                    var11 = true;
                                }
                            }

                            if (!var11) {
                                ((class_226)var10).h = class_1035.a(var5);
                            } else if (!var7) {
                                var7 = true;
                                var19.r("builtFrom isLocked currently cannot be used when targeting old-style unit:" + var0.i());
                            }
                        }

                        var11 = false;
                        Iterator var41 = var9.iterator();

                        while(var41.hasNext()) {
                            class_226 var13 = (class_226)var41.next();
                            if (((class_226)var10).equals(var13)) {
                                var11 = true;
                            }
                        }

                        if (!var11) {
                            var9.add(var10);
                        }

                        b(var9);
                    }
                }
            }

            if (var0 instanceof class_591) {
                var2 = (class_591)var0;
                var17 = var2.gh.iterator();

                label267:
                while(true) {
                    while(true) {
                        if (!var17.hasNext()) {
                            break label267;
                        }

                        class_1037 var23 = (class_1037)var17.next();
                        int var27;
                        ArrayList var28;
                        if (var23.k != null && var23.k.equalsIgnoreCase("setRally")) {
                            for(var27 = 1; var27 <= 3; ++var27) {
                                var28 = var0.a(var27);
                                class_237 var35 = new class_237();
                                if (var23.p != -999.0F) {
                                    var35.g = var23.p;
                                }

                                var28.add(var35);
                                var2.dc = true;
                                b(var28);
                            }
                        } else if (var23.k != null && var23.k.equalsIgnoreCase("reclaim")) {
                            for(var27 = 1; var27 <= 3; ++var27) {
                                var28 = var0.a(var27);
                                class_234 var33 = new class_234(true);
                                if (var23.p != -999.0F) {
                                    var33.g = var23.p;
                                }

                                var28.add(var33);
                                b(var28);
                            }
                        } else if (var23.k != null && var23.k.equalsIgnoreCase("repair")) {
                            for(var27 = 1; var27 <= 3; ++var27) {
                                var28 = var0.a(var27);
                                class_235 var31 = new class_235();
                                if (var23.p != -999.0F) {
                                    var31.g = var23.p;
                                }

                                var28.add(var31);
                                b(var28);
                            }
                        } else {
                            class_31 var25 = null;
                            if (var23.k != null) {
                                var25 = UnitType.a(var23.k);
                                if (var25 == null) {
                                    throw new CustomException("Could not find canBuild target:" + var23.k);
                                }
                            } else if (var23.aM != class_1032.convert) {
                                throw new CustomException("'Target' required for action:" + var23.a());
                            }

                            byte var26 = 1;

                            for(int var30 = var26; var30 <= 3; ++var30) {
                                ArrayList var34 = var0.a(var30);
                                Object var38;
                                if (var23.aM == class_1032.build) {
                                    if (!var25.j() && !var23.aK) {
                                        var38 = new class_282(var25);
                                        ((class_226)var38).h = class_1035.a(var23);
                                    } else {
                                        var38 = new class_241(var25, var23.aJ, (Integer)null);
                                        ((class_226)var38).h = class_1035.a(var23);
                                    }
                                } else {
                                    if (var23.aM != class_1032.convert) {
                                        throw new CustomException("Could not find actionType:" + var23.aM);
                                    }

                                    var38 = new class_283(var23, class_591.a(var25));
                                }

                                if (var23.p != -999.0F) {
                                    ((class_226)var38).g = var23.p;
                                }

                                boolean var40 = false;
                                Iterator var42 = var34.iterator();

                                while(var42.hasNext()) {
                                    class_226 var43 = (class_226)var42.next();
                                    if (((class_226)var38).equals(var43)) {
                                        var40 = true;
                                    }
                                }

                                if (!var40) {
                                    var34.add(var38);
                                }

                                b(var34);
                            }
                        }
                    }
                }
            }

            int var21;
            ArrayList var24;
            class_226 var29;
            Iterator var32;
            if (var0 instanceof class_591) {
                var2 = (class_591)var0;
                var2.fu = false;
                var21 = 1;

                label217:
                while(true) {
                    if (var21 > 3) {
                        var17 = var2.p.iterator();

                        while(true) {
                            if (!var17.hasNext()) {
                                break label217;
                            }

                            var4 = (class_601)var17.next();
                            var4.b();
                        }
                    }

                    var24 = var0.a(var21);
                    var32 = var24.iterator();

                    while(var32.hasNext()) {
                        var29 = (class_226)var32.next();
                        if (!(var29 instanceof class_283) && var29.i() != null) {
                            var2.fu = true;
                        }
                    }

                    ++var21;
                }
            }

            boolean var18 = var1.O() && var1.netEngine.gameMapData.k;

            for(var21 = 1; var21 <= 3; ++var21) {
                var24 = var0.a(var21);
                var32 = var24.iterator();

                while(var32.hasNext()) {
                    var29 = (class_226)var32.next();
                    if (var29.h instanceof class_1034) {
                        GameEngine.a("=== ChainedActionConfig already on: " + var0.i() + " action:" + var29.b());
                        var29.h = ((class_1034)var29.h).b;
                    }

                    if (var18) {
                        class_447 var37 = var29.B();
                        class_447 var36 = var29.r_();
                        if (!var37.c() && var36 == null) {
                            class_1034 var39 = new class_1034(var29.h);
                            var29.h = var39;
                            var39.c = class_447.a;
                            var39.d = var37;
                        }
                    }
                }
            }
        } catch (CustomException var14) {
            a((String)var0.i(), (Exception)var14, (class_31)var0);
        } catch (RuntimeException var15) {
            a((String)var0.i(), (Exception)var15, (class_31)var0);
        }

    }

    public static void g() {
        synchronized(o) {
            o();
        }
    }

    private static void o() {
        class_591.g.clear();
        class_591.f.clear();
        Iterator var0 = class_591.d.iterator();

        class_591 var1;
        class_595 var3;
        Iterator var13;
        while(var0.hasNext()) {
            var1 = (class_591)var0.next();
            if (var1.J != null) {
                String var2 = var1.J.R;
                if (var2 != null) {
                    GameEngine.print(var1.i() + "(mod:" + var1.t() + "): Getting setup while mod has error: " + var2);
                }
            }

            for(var13 = var1.gg.iterator(); var13.hasNext(); var3.e = false) {
                var3 = (class_595)var13.next();
            }

            var1.fL.clear();
        }

        var0 = class_591.d.iterator();

        while(var0.hasNext()) {
            var1 = (class_591)var0.next();

            try {
                if (var1.Q != null) {
                    String[] var14 = var1.Q.split(",");
                    String[] var16 = var14;
                    int var4 = var14.length;

                    for(int var5 = 0; var5 < var4; ++var5) {
                        String var6 = var16[var5];
                        var6 = var6.trim();
                        boolean var7 = false;
                        class_31 var8 = class_591.a(var6, var7);
                        if (var8 == null) {
                            throw new CustomException("Could not find overrideAndReplace target:" + var6);
                        }

                        if (var8 instanceof class_591) {
                            GameEngine.log("Replacing:" + var8.i() + " with " + var1.i());
                        }

                        class_591.f.put(var8, var1);
                    }
                }
            } catch (CustomException var10) {
                a((String)var1.i(), (Exception)var10, (class_31)var1);
            }
        }

        UnitType[] var11 = UnitType.values();
        int var12 = var11.length;

        for(int var15 = 0; var15 < var12; ++var15) {
            UnitType var17 = var11[var15];
            a((class_31)var17);
        }

        var0 = class_591.d.iterator();

        while(var0.hasNext()) {
            var1 = (class_591)var0.next();
            a((class_31)var1);
        }

        var0 = class_591.d.iterator();

        while(true) {
            do {
                do {
                    if (!var0.hasNext()) {
                        var0 = class_591.d.iterator();

                        while(var0.hasNext()) {
                            var1 = (class_591)var0.next();
                            var1.r();
                        }

                        Collections.sort(class_591.g, new class_594());
                        return;
                    }

                    var1 = (class_591)var0.next();
                    var13 = var1.gg.iterator();

                    while(var13.hasNext()) {
                        var3 = (class_595)var13.next();
                        if (!var3.e) {
                            String var18 = var3.d + " failed to find target:" + var3.a;
                            var1.q(var18);
                            if (var1.R >= 1) {
                                GameEngine.log("Converting warning to error (meta.strictLevel=" + var1.R + ")");
                                var1.p(var18);
                            }
                        }
                    }
                } while(var1.gp == null);
            } while(var1.gp.size() <= 0);

            var13 = var1.gp.iterator();

            while(var13.hasNext()) {
                class_598 var19 = (class_598)var13.next();

                try {
                    var19.b(var1);
                } catch (Exception var9) {
                    a((String)var1.i(), (Exception)var9, (class_31)var1);
                }
            }
        }
    }

    public static class_591 a(String var0, class_800 var1, String var2, String var3) {
        try {
            long var4 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
            AssetInputStream var6 = b(var0);
            if (var6 == null) {
                throw new RuntimeException("Failed to open unit config file:" + var0);
            } else {
                BufferedInputStream var7 = new BufferedInputStream(var6);
                a(var4, class_437.INI_OPEN);
                ++b;
                if (var1 != null) {
                    ++c;
                }

                GameEngine var8 = GameEngine.getGameEngine();
                String var9 = "core units";
                if (var1 != null) {
                    var9 = var1.modName();
                }

                var8.h("Loading units - " + b + " (" + var9 + ")");
                class_591 var10 = a(var0, var7, var6.c(), var1, var6, var2, var3);
                long var11 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();

                try {
                    var7.close();
                    var6.close();
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                a(var11, class_437.INI_CLOSE);
                return var10;
            }
        } catch (RuntimeException var15) {
            a((String)var0, (Exception)var15, (class_800)var1);
            return null;
        }
    }

    public static void h() {
        GameEngine var0 = GameEngine.getGameEngine();
        ArrayList var1 = var0.bZ.k();
        j = 0;
        i = 0;
        l = 0;
        k = false;
        long var2 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
        Iterator var4 = g.values().iterator();

        while(true) {
            TeamImageCache var5;
            TeamImageCache[] var6;
            int var7;
            int var8;
            TeamImageCache var9;
            do {
                if (!var4.hasNext()) {
                    class_355 var16;
                    for(var4 = h.values().iterator(); var4.hasNext(); var16.g = false) {
                        var16 = (class_355)var4.next();
                    }

                    byte[] var15 = null;
                    byte[][] var17 = (byte[][])null;
                    ByteBuffer[] var18 = null;

                    try {
                        var15 = new byte[8000000];
                        var15[0] = var0.dZ;
                        var0.ea = var15[1];
                        var17 = new byte[][]{new byte[3000000], new byte[3000000]};
                        var17[0][0] = var0.dZ;
                        var17[1][0] = var0.dZ;
                        if (!GameEngine.at()) {
                            var18 = new ByteBuffer[]{ByteBuffer.allocateDirect(5000000), ByteBuffer.allocateDirect(5000000), ByteBuffer.allocateDirect(5000000), ByteBuffer.allocateDirect(5000000)};
                        }
                    } catch (OutOfMemoryError var14) {
                        System.gc();
                        GameEngine.log("Failed to reserve memory pre-mod load");
                    }

                    synchronized(class_591.c) {
                        class_591.c.clear();
                    }

                    class_591.d.clear();
                    class_591.e = null;
                    class_591.f.clear();
                    var0.bZ.n();
                    b = 0;
                    c = 0;
                    synchronized(n) {
                        n.clear();
                    }

                    a(class_697.p("units"), 1, false, (class_800)null, class_697.p("units"), (String)null);
                    if (!GameEngine.aJ && !var0.ar) {
                        String var19 = m();
                        if (!class_697.f(var19)) {
                            GameEngine.log("Modded Custom '" + var19 + "' directory not found");
                        }

                        Iterator var21 = var1.iterator();

                        String var10;
                        class_800 var22;
                        while(var21.hasNext()) {
                            var22 = (class_800)var21.next();
                            if (!var22.y && var22.q != null) {
                                var10 = var22.j();
                                if (var22.m) {
                                    var10 = class_697.p(var10);
                                }

                                if (var22.f) {
                                    GameEngine.log("Disabled mod at:" + var10 + " (name:" + var22.modName() + ")");
                                } else {
                                    GameEngine.log("Loading mod at:" + var10 + " (name:" + var22.modName() + ")");
                                }

                                a(var10, 2, true, var22, var10, (String)null);
                            }
                        }

                        var21 = var1.iterator();

                        while(var21.hasNext()) {
                            var22 = (class_800)var21.next();
                            if (var22.y && var22.q != null) {
                                var10 = var22.i();
                                if (var22.f) {
                                    GameEngine.log("Disabled workshop mod at:" + var10 + " (name:" + var22.modName() + ")");
                                } else {
                                    GameEngine.log("Loading workshop mod at:" + var10 + " (name:" + var22.modName() + ")");
                                }

                                a(var10, 2, true, var22, var10, (String)null);
                            }
                        }
                    }

                    a();
                    b(true);
                    GameEngine.log("Done loading custom units. image cacheHits:" + j + " image cacheMisses:" + i + " (in: " + com.corrodinggames.rts.gameFramework.Unit.a(var2) + "ms)");
                    GameEngine.log("========= Mods data loaded ===========");
                    GameEngine.log("Number of mods:" + var1.size());
                    Iterator var20 = var1.iterator();

                    while(var20.hasNext()) {
                        class_800 var23 = (class_800)var20.next();
                        var23.t();
                    }

                    GameEngine.log("================================");
                    if (var18 != null) {
                        var18[0] = null;
                        var18[1] = null;
                        var18[2] = null;
                        var18[3] = null;
                        var6 = null;
                    }

                    if (var17 != null) {
                        var17[0] = null;
                        var17[1] = null;
                        var17 = (byte[][])null;
                    }

                    if (var15 != null) {
                        var15[1] = var0.dZ;
                        var0.ea = var15[1];
                        var4 = null;
                        System.gc();
                        System.gc();
                    }

                    return;
                }

                var5 = (TeamImageCache)var4.next();
                var5.v = false;
                if (var5.a != null) {
                    var6 = var5.a;
                    var7 = var6.length;

                    for(var8 = 0; var8 < var7; ++var8) {
                        var9 = var6[var8];
                        var9.v = false;
                    }
                }

                if (var5.b != null) {
                    var6 = var5.b;
                    var7 = var6.length;

                    for(var8 = 0; var8 < var7; ++var8) {
                        var9 = var6[var8];
                        var9.v = false;
                    }
                }
            } while(var5.c == null);

            var6 = var5.c;
            var7 = var6.length;

            for(var8 = 0; var8 < var7; ++var8) {
                var9 = var6[var8];
                var9.v = false;
            }
        }
    }

    public static void a(String var0, int var1, boolean var2, class_800 var3, String var4, String var5) {
        boolean var6 = var2 && var1 == 1;
        GameEngine var7 = GameEngine.getGameEngine();
        if (var3 != null) {
            if (var3.f && !var7.settingsEngine.loadDisabledModData) {
                var3.C = true;
                return;
            }

            var3.C = false;
        }

        if (var3 != null && var3.f) {
            GameEngine.log("Note: Loading disabled mod: " + var0);
        }

        class_697.c();
        String[] var8 = class_697.h(var0);
        if (var8 == null) {
            String var21 = class_697.c();
            GameEngine.print("readAllCustomUnitConfigs: ERROR");
            GameEngine.print("readAllCustomUnitConfigs: Failed to load:" + var0);
            if (var3 != null) {
                if (!var3.D) {
                    if (var21 == null) {
                        var3.R = "Failed to list directory, check file permissions";
                    } else {
                        var3.R = "Failed to list directory: " + var21;
                    }
                } else {
                    var3.S = "Failed to list subdirectory: '" + var0 + "' check file permissions";
                    if (var21 != null) {
                        var3.S = var3.S + ": " + var21;
                    }
                }
            }

        } else {
            if (var3 != null) {
                var3.D = true;
            }

            String[] var9;
            int var10;
            int var11;
            String var12;
            if (!var6) {
                var9 = var8;
                var10 = var8.length;

                for(var11 = 0; var11 < var10; ++var11) {
                    var12 = var9[var11];
                    if (var12.equalsIgnoreCase("all-units.template")) {
                        var5 = var0;
                    }
                }
            }

            var9 = var8;
            var10 = var8.length;

            for(var11 = 0; var11 < var10; ++var11) {
                var12 = var9[var11];
                if (!var12.equals("custom_units_here.txt") && !var12.equals("mods_here_will_be_enabled_by_default.txt") && !var12.equals("__MACOSX")) {
                    boolean var13 = false;
                    class_800 var14 = var3;
                    if (var2 && var1 == 1 && var3 == null) {
                        var14 = var7.bZ.e(var12);
                        if (var14 == null) {
                            GameEngine.print("readAllCustomUnitConfigs: Could not find linked mod:" + var12);
                            var14 = var7.bZ.c;
                        }

                        var13 = true;
                    }

                    String var15;
                    if (var12.toLowerCase(Locale.ENGLISH).endsWith(".ini") && !var6) {
                        var15 = var0 + "/" + var12;
                        if (r != var14 && var14 != null) {
                            r = var14;
                            a();
                            GameEngine.log("Loading units from mod: " + var14.c);
                        }

                        if (var12.equalsIgnoreCase("desktop.ini")) {
                            GameEngine.log("Skipping possible system file: " + var15);
                        } else {
                            long var22 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                            a(var15, var14, var4, var5);
                            a(var22, class_437.UNIT_PARSE);
                        }
                    } else if (var12.toLowerCase(Locale.ENGLISH).endsWith(".tmx")) {
                        var15 = var0 + "/" + var12;
                        GameEngine.log("Found map: " + var15);
                        if (var14 != null && var14.B) {
                            var7.bZ.a(var15, var14);
                        } else {
                            GameEngine.log("Skipping map due to mod settings");
                        }
                    } else {
                        var15 = var0 + "/" + var12;
                        if (var1 < 10) {
                            if (class_697.f(var15)) {
                                String var16 = var4;
                                if (var4 == null) {
                                    var16 = var15;
                                }

                                long var17 = -1L;
                                if (var13) {
                                    var17 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                                    GameEngine.log("============");
                                    GameEngine.log(">>> Mod '" + var14.c() + "'" + (var14.m() ? "" : " (disabled)"));
                                }

                                a(var15, var1 + 1, var2, var14, var16, var5);
                                if (var13 && var14 != null && var14.m()) {
                                    double var19 = (double) com.corrodinggames.rts.gameFramework.Unit.a(var17);
                                    GameEngine.log("Mod '" + var14.c() + "' load took:" + com.corrodinggames.rts.gameFramework.Unit.a(var19));
                                }
                            }
                        } else {
                            GameEngine.log("Too many levels:" + var15);
                        }
                    }
                }
            }

        }
    }

    public static class_591 a(String var0, InputStream var1, long var2, class_800 var4, AssetInputStream var5, String var6, String var7) {
        GameEngine var8 = GameEngine.getGameEngine();

        try {
            if (a) {
                String var9 = "CORE";
                if (var4 != null) {
                    var9 = var4.j();
                }

                GameEngine.log("Loading unit config: " + var0 + " [" + var9 + "]");
            }

            var8.bO.e();
            long var94 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();

            UnitConfig var11;
            try {
                var11 = new UnitConfig(var1, var0);
            } catch (Exception var90) {
                throw new RuntimeException(var90);
            }

            a(var94, class_437.INI_PARSE);
            String var12 = "core";
            String var13 = "graphics";
            String var14 = "attack";
            String var15 = "movement";
            String var16 = "ai";
            class_591 var17 = new class_591();
            if (var11.getValueAsBoolean(var12, "dont_load", false)) {
                return null;
            } else {
                var17.D = var0;
                var17.E = var5.d();
                var17.F = var17.D;
                var17.J = var4;
                var17.K = var6;
                var17.L = var7;
                e = var4;
                f = false;
                if (var17.J != null) {
                }

                long var18 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                a(var17, var11, (UnitConfig)var11, var0, 0);
                if (var17.L != null) {
                    a(var17, var11, var17.L + "/" + "all-units.template", "AUTO units.template", true);
                }

                var11.addKeyValuePairToTextsDefaultsUnknown("core", "copyFrom");
                var17.R = var11.getValueAsIntegerOrDefault(var12, "strictLevel", 0);
                if (var17.R < 0) {
                    throw new CustomException("[core]strictLevel cannot be < 0");
                } else if (var17.R > 1) {
                    throw new CustomException("[core]strictLevel cannot yet be > 1");
                } else {
                    var17.gs = var11.getValueAsBoolean(var12, "logIfCreditResourceUsed", false);
                    var11.addKeyValuePairToTextsDefaultsUnknown(var12, "dont_load");
                    var11.getValueAsStaticString(var12, "class", "CustomUnitMetadata");
                    class_684 var21 = var11.c("@copyFrom_skipThisSection");
                    Iterator var22 = var21.iterator();

                    String var23;
                    while(var22.hasNext()) {
                        var23 = (String)var22.next();
                        var11.addKeyValuePairToTextsDefaultsUnknown(var23, "@copyFrom_skipThisSection");
                    }

                    class_684 var95 = var11.c("@copyFromSection");
                    Iterator var96 = var95.iterator();

                    String var24;
                    while(var96.hasNext()) {
                        var24 = (String)var96.next();
                        a(var17, var11, (String)var24, var24, 0);
                    }

                    class_957.a(var17, var11);
                    var23 = var11.getValueAsStaticString(var12, "overrideResourceLoadPath", (String)null);
                    if (var23 != null) {
                        var17.F = a(var17, var0, var23);
                    }

                    a(var18, class_437.INI_SETUP);
                    var17.M = var11.e(var12, "name");
                    var17.H = var11.c();
                    if (var17.M.equals("self")) {
                        throw new CustomException("Unit name: " + var17.M + " is reserved");
                    } else if (var17.M.startsWith("self.")) {
                        throw new CustomException("Unit name cannot start with self.");
                    } else {
                        var24 = var11.getValueAsStaticString(var12, "altNames", (String)null);
                        int var26;
                        int var27;
                        String var28;
                        if (var24 != null && !var24.equalsIgnoreCase("NONE")) {
                            String[] var25 = var24.split(",");
                            var26 = var25.length;

                            for(var27 = 0; var27 < var26; ++var27) {
                                var28 = var25[var27];
                                var28 = var28.trim();
                                var17.N.add(var28);
                            }
                        }

                        var17.O = class_585.a(var11.getValueAsStaticString(var12, "tags", (String)null));
                        if (var17.R >= 1 && var17.O != null) {
                            class_585[] var97 = var17.O.a;
                            var26 = var97.length;

                            for(var27 = 0; var27 < var26; ++var27) {
                                class_585 var102 = var97[var27];
                                if (var102.a.contains(" ")) {
                                    throw new CustomException("(strictLevel 1) [core]tags: space in tag: '" + var102.a + "'");
                                }
                            }
                        }

                        var17.Q = var11.getValueAsStaticString(var12, "overrideAndReplace", (String)null);
                        if (var17.Q != null && var17.Q.equalsIgnoreCase("NONE")) {
                            var17.Q = null;
                        }

                        String var98 = var11.getValueAsStaticString(var12, "defineUnitMemory", (String)null);
                        if (var98 != null) {
                            var17.r.addDefineValue(var17, var12, "defineUnitMemory", var98);
                            if (var17.r.hasArrays()) {
                                var17.a("1.15p11", 115011, var12, "Memory arrays (in defineUnitMemory)");
                            }
                        }

                        Iterator var99 = var11.k(var12, "@memory ").iterator();

                        String var29;
                        String var101;
                        while(var99.hasNext()) {
                            var101 = (String)var99.next();
                            var28 = var101.substring("@memory ".length()).trim();
                            var29 = var11.getValueAsStaticString(var12, var101, (String)null);
                            if (var29 != null) {
                                if (var29.contains(",")) {
                                    throw new CustomException("[" + var12 + "]" + var101 + ": Only a single variable can be defined per @memory");
                                }

                                var17.r.addSingleDefine(var17, var28, var29, var12, var101);
                                if (var17.r.hasArrays()) {
                                    var17.a("1.15p11", 115011, var12, "Memory arrays (in " + var101 + ")");
                                }
                            }
                        }

                        var17.T = (class_433)var11.a((String)var12, "onNewMapSpawn", (Enum)null, (Class)class_433.class);
                        var17.aG = var11.getValueAsFloatOrDefault(var12, "globalScale", 1.0F);
                        var17.o(var17.E);
                        if (var17.M.equals("missing")) {
                            if (var4 == null) {
                                GameEngine.log("Setting missingPlaceHolder");
                                class_591.b = var17;
                            } else {
                                GameEngine.log("Not setting missingPlaceHolder, as we are in a mod");
                            }
                        }

                        var17.aE = var11.getValueAsStaticString(var12, "displayLocaleKey", (String)null);
                        var17.aC = a((UnitConfig)var11, (String)var12, "displayText", (String)null);
                        var17.aD = a((UnitConfig)var11, (String)var12, "displayDescription", (String)null);
                        var17.eD = var11.getValueAsBoolean(var12, "isBio", false);
                        var17.eE = var11.getValueAsBoolean(var12, "isBug", false);
                        var17.eH = var11.getValueAsBoolean(var12, "isPickableStartingUnit", false);
                        var17.eI = var11.getValueAsBoolean(var12, "startFallingWhenStartingUnit", false);
                        var17.cy = var11.getValueAsBoolean(var12, "stayNeutral", false);
                        var17.cz = var11.getValueAsBoolean(var12, "createNeutral", false);
                        var17.cA = var11.getValueAsBoolean(var12, "allowCaptureWhenNeutralByAI", false);
                        if (var11.getValueAsBoolean(var12, "createOnNeutralTeam", false)) {
                            var17.cz = true;
                        }

                        var17.cB = var11.getValueAsBoolean(var12, "whileNeutralTransportAnyTeam", false);
                        var17.cC = var11.getValueAsBoolean(var12, "whileNeutralConvertToTransportedTeam", false);
                        var17.cD = var11.getValueAsBoolean(var12, "convertToNeutralIfNotTransporting", false);
                        if (var17.cD) {
                            var17.cy = true;
                        }

                        var17.cE = var11.getValueAsBoolean(var12, "createOnAggressiveTeam", false);
                        var17.aF = var11.getValueAsBoolean(var12, "showInEditor", true);
                        var17.U = var11.getValueAsIntegerOrDefault(var13, "total_frames", 1);
                        if (var17.U < 1) {
                            throw new CustomException("TOTAL_FRAMES cannot be: " + var17.U + " (must be 1 or more)");
                        } else {
                            var17.W = var11.getValueAsIntegerOrDefault(var13, "frame_width", -1);
                            var17.X = var11.getValueAsIntegerOrDefault(var13, "frame_height", -1);
                            var17.Y = var11.getValueAsIntegerOrDefault(var13, "default_frame", 0);
                            var17.ah = var11.getValueAsIntegerOrDefault(var13, "image_offsetX", 0);
                            var17.ai = var11.getValueAsIntegerOrDefault(var13, "image_offsetY", 0);
                            var17.aj = var11.getValueAsFloatOrDefault(var13, "image_offsetH", 0.0F);
                            if (var17.ah != 0 || var17.ai != 0 || var17.aj != 0.0F) {
                                var17.ak = true;
                            }

                            var17.ac = ColoringMode.PURE_GREEN;
                            if (var11.getValueAsBoolean(var13, "teamColorsUseHue", false)) {
                                var17.ac = ColoringMode.HUE_ADD;
                            }

                            String var100 = var11.getValueAsStaticString(var13, "teamColoringMode", (String)null);
                            if (var100 != null) {
                                if (var11.getValueAsBoolean(var13, "teamColorsUseHue", (Boolean)null) != null) {
                                    throw new CustomException("Cannot use teamColoringMode and teamColorsUseHue at the same time");
                                }

                                if (var100.equalsIgnoreCase("pureGreen")) {
                                    var17.ac = ColoringMode.PURE_GREEN;
                                } else if (var100.equalsIgnoreCase("hueAdd")) {
                                    var17.ac = ColoringMode.HUE_ADD;
                                } else if (var100.equalsIgnoreCase("hueShift")) {
                                    var17.ac = ColoringMode.HUE_SHIFT;
                                } else {
                                    if (!var100.equalsIgnoreCase("disabled")) {
                                        throw new CustomException("Unknown teamColoringMode:" + var100);
                                    }

                                    var17.ac = ColoringMode.DISABLED;
                                }
                            }

                            var17.ab = var11.getValueAsBoolean(var13, "imageSmoothing", false);
                            var17.aa = var11.getValueAsBoolean(var13, "imageSmoothingWhenZoomedIn", false);
                            var17.Z = var11.a((class_591)var17, var13, (String)"isVisible", (LogicBoolean)null);
                            if (var17.Z == LogicBoolean.trueBoolean) {
                                var17.Z = null;
                            }

                            var17.cL.m = var11.getValueAsBoolean(var13, "isVisibleToEnemies", true);
                            var101 = var11.e(var13, "image");
                            var17.ad = var17.a(var17.F, var101, var17.ab, var13, "image");
                            if (var17.ad == null) {
                                throw new CustomException("Main unit image must be set on custom unit");
                            } else {
                                var17.ae = var11.getValueAsBoolean(var13, "image_floatingPointSize", false);
                                var17.af = var17.ad.m() / var17.U;
                                var17.ag = var17.ad.l();
                                if (var17.af < 1) {
                                    var17.af = 1;
                                }

                                if (var17.W > 0) {
                                    var17.af = var17.W;
                                }

                                if (var17.X > 0) {
                                    var17.ag = var17.X;
                                    if (var17.ag < var17.ad.l()) {
                                        var17.V = var17.ad.m() / var17.af;
                                        if (var17.V < 1) {
                                            var17.V = 1;
                                        }
                                    }
                                }

                                var17.al = var17.a(var11, var13, "image_back");
                                var17.am = var11.getValueAsBoolean(var13, "image_back_always_use_full_image", false);
                                var17.an = var17.a(var11, var13, "image_wreak");
                                var17.ao = var17.a(var11, var13, "image_turret");
                                var17.as = class_120.dN;
                                var28 = var11.getValueAsStaticString(var13, "image_shadow", "NONE");
                                TeamImageCache var30;
                                if (var28.equalsIgnoreCase("AUTO")) {
                                    var29 = "[autoShadow:" + var17.af + "," + var17.ag + "]" + var17.ad.d + "-" + var17.ad.e;
                                    var30 = c(var29);
                                    if (var30 != null) {
                                        var17.ap = var30;
                                    } else {
                                        var17.ap = Unit.a(var17.ad, var17.af, var17.ag);
                                        a(var17.ap);
                                        if (var17.ap != null) {
                                            a(var29, var17.ap);
                                        }
                                    }
                                } else if (var28.equalsIgnoreCase("AUTO_ANIMATED")) {
                                    var29 = "[autoShadowAnimated:" + var17.af + "," + var17.ag + "]" + var17.ad.d + "-" + var17.ad.e;
                                    var30 = c(var29);
                                    if (var30 != null) {
                                        var17.ap = var30;
                                    } else {
                                        var17.ap = Unit.a(var17.ad, var17.ad.m(), var17.ad.l());
                                        a(var17.ap);
                                        if (var17.ap != null) {
                                            a(var29, var17.ap);
                                        }
                                    }

                                    var17.aq = true;
                                } else {
                                    var17.ap = var17.a(var17.F, var28, var17.ab, var13, "image_shadow");
                                }

                                if (var11.getValueAsBoolean(var13, "image_shadow_frames", false)) {
                                    var17.aq = true;
                                }

                                var17.ar = var17.a(var17.ad, var17.ac);
                                var17.s = var11.getValueAsBoolean(var13, "teamColorsOnTurret", false);
                                if (var17.s && var17.ao != null) {
                                    var17.at = var17.a(var17.ao, var17.ac);
                                }

                                float var103 = var11.getValueAsFloatOrDefault(var13, "scaleImagesTo", -1.0F);
                                if (var103 > 0.0F) {
                                    var103 *= var17.aG;
                                    var17.bH = var103 / (float)var17.af;
                                }

                                float var104 = var11.getValueAsFloatOrDefault(var13, "imageScale", 1.0F);
                                if (var104 != 1.0F) {
                                    var17.bH *= var104;
                                }

                                float var31 = var11.getValueAsFloatOrDefault(var13, "scaleTurretImagesTo", -1.0F);
                                if (var31 > 0.0F) {
                                    var31 *= var17.aG;
                                    if (var17.ao == null) {
                                        throw new RuntimeException("scaleTurretImagesTo needs image_turret set");
                                    }

                                    var17.bI = var31 / (float)var17.ao.p;
                                }

                                float var32 = var11.getValueAsFloatOrDefault(var13, "turretImageScale", 1.0F);
                                if (var32 != 1.0F) {
                                    var17.bI *= var32;
                                }

                                var17.au = ExperimentalHoverTank.e;
                                TeamImageCache var33 = var17.a(var11, var13, "image_shield");
                                if (var33 != null) {
                                    var17.au = var33;
                                    var17.av = true;
                                }

                                var17.aw = var17.a(var11, var13, "icon_build", false);
                                float var34 = (float)var17.ad.m() * var17.bH;
                                float var35 = (float)var17.ad.l() * var17.bH;
                                if (var34 / 2.0F > 90.0F || var35 / 2.0F > 90.0F) {
                                    var17.C = new Rect();
                                    var17.C.a = (int)(-var34 / 2.0F);
                                    var17.C.c = (int)(var34 / 2.0F);
                                    var17.C.b = (int)(-var35 / 2.0F);
                                    var17.C.d = (int)(var35 / 2.0F);
                                    var17.B = true;
                                }

                                Iterator var36 = var11.m("resource_", "global_resource_").iterator();

                                while(true) {
                                    String var108;
                                    if (var36.hasNext()) {
                                        String var107 = (String)var36.next();
                                        boolean var110;
                                        if (var107.startsWith("resource_")) {
                                            var108 = var107.substring("resource_".length());
                                            var110 = false;
                                        } else {
                                            var108 = var107.substring("global_resource_".length());
                                            var110 = true;
                                        }

                                        var108 = var108.trim();
                                        if (var108.contains(" ")) {
                                            throw new RuntimeException("[" + var107 + "] resource codename cannot contain a space");
                                        }

                                        if (!var108.contains("=") && !var108.contains("|") && !var108.contains(":") && !var108.contains(",") && !var108.contains("(") && !var108.contains(")") && !var108.contains("<") && !var108.contains(">") && !var108.contains("$")) {
                                            class_1068 var112 = new class_1068(var110);
                                            var112.a(var17, var11, var107, var108);
                                            if (var17.k(var112.a) != null) {
                                                throw new RuntimeException("[" + var107 + "] resource with name:" + var112.a + " already exists in this file");
                                            }

                                            var17.j.add(var112);
                                            continue;
                                        }

                                        throw new RuntimeException("[" + var107 + "] resource codename cannot contain the symbols: =|:,()<>$");
                                    }

                                    var36 = var17.j.iterator();

                                    while(var36.hasNext()) {
                                        class_1068 var37 = (class_1068)var36.next();
                                        var37.a(var17);
                                    }

                                    if (var8.p()) {
                                        class_831.a(var17, var11);
                                        class_832.a(var17, var11);
                                    }

                                    class_834.a(var17, var11);
                                    var17.ca = var11.b(var12, "autoTriggerCooldownTime", 60.0F);
                                    if (var17.ca < 0.0F) {
                                        throw new RuntimeException("autoTriggerCooldownTime cannot be < 0");
                                    }

                                    if (var17.ca > 120.0F) {
                                        throw new RuntimeException("autoTriggerCooldownTime cannot be more than 2 seconds");
                                    }

                                    if (!var11.getValueAsBoolean(var12, "autoTriggerCooldownTime_allowDangerousHighCPU", false) && var17.ca < 5.0F) {
                                        throw new RuntimeException("autoTriggerCooldownTime cannot be this low (without override). Note this cooldown is only applied after triggering an action not for the detection.");
                                    }

                                    var17.cb = (CheckRate)var11.a((String)var12, "autoTriggerCheckRate", (Enum) CheckRate.EVERY_FRAME, (Class)CheckRate.class);
                                    var17.cd = var11.getValueAsBoolean(var12, "autoTriggerCheckWhileNotBuilt", false);
                                    var17.cL.b = (float)var11.g(var12, "mass");
                                    var17.ce = var11.getValueAsBoolean(var12, "availableInDemo", true);
                                    var17.cf = var11.getValueAsBoolean(var12, "isLocked", false);
                                    var17.cg = var11.getValueAsBoolean(var12, "isLockedIfGameModeNoNuke", false);
                                    var17.ch = class_447.a(var17, var11, var12, "price", false);
                                    var17.ci = class_447.a(var17, var11, var12, "reclaimPrice", (class_447)null);
                                    var17.cj = class_447.b(var17, var11, var12, "streamingCost", (class_447)null);
                                    boolean var105 = var11.getValueAsBoolean(var12, "switchPriceWithStreamingCost", false);
                                    if (var105) {
                                        if (var17.cj != null) {
                                            throw new RuntimeException("[" + var12 + "]streamingCost and switchPriceWithStreamingCost=true cannot be used at the same time");
                                        }

                                        var17.cj = class_447.b(var17, var11, var12, "price", (class_447)null);
                                        var17.ch = class_447.a;
                                    }

                                    var17.ck = var11.d(var12, "buildSpeed", 1.0F);
                                    var17.cl = var11.getValueAsIntegerOrDefault(var12, "techLevel", 1);
                                    if (var17.cl > 3) {
                                        throw new RuntimeException("techLevel cannot be greater than max tech level of:3");
                                    }

                                    if (var17.cl < 1) {
                                        throw new RuntimeException("techLevel cannot be less than 1, it is:" + var17.cl);
                                    }

                                    var17.cm = var11.getValueAsBoolean(var12, "experimental", false);
                                    var17.cv = class_447.a(var17, var11, var12, "borrowResourcesWhileAlive", true);
                                    var17.cw = class_447.a(var17, var11, var12, "borrowResourcesWhileBuilt", true);
                                    var17.co = class_447.a(var17, var11, var12, "generation_resources", true);
                                    int var106 = var11.getValueAsIntegerOrDefault(var12, "generation_credits", 0);
                                    if (var106 != 0) {
                                        var17.co = class_447.a(var17.co, class_447.a(var106));
                                    }

                                    var17.cr = var11.getValueAsIntegerOrDefault(var12, "generation_delay", 40);
                                    if (var17.cr == 0) {
                                        var17.cr = 1;
                                    }

                                    if (var17.cr < 0) {
                                        throw new RuntimeException("[" + var12 + "]generation_delay cannot be < 0");
                                    }

                                    var17.cs = 40.0F / (float)var17.cr;
                                    if (!var17.co.c()) {
                                        var17.cp = new class_1069();
                                        var17.cp.a(var17.co);
                                        var17.cp.a((double)var17.cs);
                                        var17.cn = true;
                                    }

                                    if (!var17.cp.c()) {
                                        Iterator var38 = var17.cp.b.iterator();

                                        while(var38.hasNext()) {
                                            class_1067 var39 = (class_1067)var38.next();
                                            if (!var39.a.c() && var39.a.d()) {
                                                if (var17.cq == class_1069.a) {
                                                    var17.cq = new class_1069();
                                                }

                                                var17.cq.b(var39.a, var39.b);
                                            }
                                        }
                                    }

                                    var17.cx = var11.a((class_591)var17, var12, (String)"generation_active", (LogicBoolean)LogicBoolean.trueBoolean);
                                    var17.a(var17.co);
                                    var17.cF = var11.getValueAsFloatOrDefault(var12, "resourceRate", 0.0F);
                                    if (var105 && var17.cF != 0.0F) {
                                        throw new RuntimeException("To avoid mistakes [" + var12 + "]resourceRate cannot be used with switchPriceWithStreamingCost=true");
                                    }

                                    var108 = var11.getValueAsStaticString(var12, "updateUnitMemory", (String)null);
                                    if (var108 != null) {
                                        var17.ct = VariableScope.createMemoryWriter(var108, var17, var12, "updateUnitMemory");
                                    }

                                    var17.cu = var11.b(var12, "updateUnitMemoryRate", 60.0F);
                                    var17.cG = var11.getValueAsIntegerOrDefault(var12, "resourceMaxConcurrentReclaimingThis", Integer.MAX_VALUE);
                                    var17.cH = var11.a((class_591)var17, var12, (String)"similarResourcesHaveTag", (class_588)null);
                                    var17.doo = class_392.a(var17, var11.getValueAsStaticString(var12, "soundOnAttackOrder", (String)null));
                                    var17.dp = class_392.a(var17, var11.getValueAsStaticString(var12, "soundOnMoveOrder", (String)null));
                                    var17.dq = class_392.a(var17, var11.getValueAsStaticString(var12, "soundOnNewSelection", (String)null));
                                    String var109 = var11.getValueAsStaticString(var13, "drawLayer", (String)null);
                                    if (var109 != null) {
                                        if (var109.equals("experimentals")) {
                                            var17.cI = 4;
                                        } else if (var109.equals("underwater")) {
                                            var17.cI = 1;
                                        } else if (var109.equals("bottom")) {
                                            var17.cI = 1;
                                        } else if (var109.equals("ground")) {
                                            var17.cI = 2;
                                        } else if (var109.equals("ground2")) {
                                            var17.cI = 3;
                                        } else if (var109.equals("air")) {
                                            var17.cI = 5;
                                        } else if (var109.equals("top")) {
                                            var17.cI = 10;
                                        } else {
                                            if (!var109.equals("wreaks")) {
                                                throw new RuntimeException("unknown drawLayer:" + var109);
                                            }

                                            var17.cI = 0;
                                        }
                                    }

                                    var17.cJ = var11.getValueAsFloatOrDefault(var13, "shadowOffsetX", 0.0F);
                                    var17.cK = var11.getValueAsFloatOrDefault(var13, "shadowOffsetY", 0.0F);
                                    var17.dB = var11.getValueAsBoolean(var13, "rotate_with_direction", true);
                                    var17.dC = var11.getValueAsBoolean(var13, "lock_body_rotation_with_main_turret", false);
                                    var17.dD = var11.getValueAsBoolean(var13, "lock_shadow_rotation_with_main_turret", var17.dC);
                                    var17.dE = var11.getValueAsBoolean(var13, "lock_leg_rotation_with_main_turret", false);
                                    var17.dH = var11.getValueAsFloatOrDefault(var13, "whenBeingBuiltMakeTransparentTill", 1.0F);
                                    var17.dI = class_590.a(var17, var11, var13, "animation_", false);
                                    Iterator var40 = var11.e("effect_").iterator();

                                    String var41;
                                    String var42;
                                    while(var40.hasNext()) {
                                        var41 = (String)var40.next();
                                        var42 = var41.substring("effect_".length());
                                        class_429 var43 = new class_429(var42);
                                        var43.a(var17, var11, var41);
                                        var17.gd.add(var43);
                                    }

                                    var40 = var17.gd.iterator();

                                    while(var40.hasNext()) {
                                        class_429 var113 = (class_429)var40.next();
                                        if (var113.alsoEmitEffects != null) {
                                            var113.alsoEmitEffects.c();
                                        }

                                        if (var113.alsoEmitEffectsOnDeath != null) {
                                            var113.alsoEmitEffectsOnDeath.c();
                                        }

                                        if (var113.ifSpawnFailsEmitEffects != null) {
                                            var113.ifSpawnFailsEmitEffects.c();
                                        }

                                        if (var113.trailEffect != null) {
                                            var113.trailEffect.c();
                                        }
                                    }

                                    var17.bJ = var11.getValueAsBoolean(var13, "splastEffect", false);
                                    var17.bM = var11.getValueAsBoolean(var13, "dustEffect", false);
                                    var17.bK = var11.getValueAsBoolean(var13, "splastEffectReverse", true);
                                    var17.bN = var11.getValueAsBoolean(var13, "dustEffectReverse", true);
                                    var17.bL = var17.bM || var17.bJ;
                                    String var111 = var11.getValueAsStaticString(var13, "movementEffect", (String)null);
                                    if (var111 != null) {
                                        var17.bO = var17.a((String)var111, (class_605)null);
                                        if (var17.bO != null && var17.bO.a()) {
                                            var17.bL = true;
                                        }
                                    }

                                    var41 = var11.getValueAsStaticString(var13, "movementEffectReverse", (String)null);
                                    if (var41 != null) {
                                        var17.bP = var17.a((String)var41, (class_605)null);
                                        if (var17.bP != null && var17.bP.a()) {
                                            var17.bL = true;
                                        }
                                    }

                                    var17.bR = var11.getValueAsFloatOrDefault(var13, "movementEffectRate", 11.0F);
                                    var17.bQ = var11.getValueAsBoolean(var13, "movementEffectReverseFlipEffects", false);
                                    var17.bT = var11.getValueAsFloatOrDefault(var13, "repairEffectRate", 5.0F);
                                    var42 = var11.getValueAsStaticString(var13, "repairEffect", (String)null);
                                    if (var42 != null) {
                                        var17.bU = var17.a((String)var42, (class_605)null);
                                        if (var17.bU != null && var17.bU.b()) {
                                            var17.bS = true;
                                        }
                                    }

                                    String var114 = var11.getValueAsStaticString(var13, "repairEffectAtTarget", (String)null);
                                    if (var114 != null) {
                                        var17.bV = var17.a((String)var114, (class_605)null);
                                        if (var17.bV != null && var17.bV.b()) {
                                            var17.bS = true;
                                        }
                                    }

                                    var17.bX = var11.getValueAsFloatOrDefault(var13, "reclaimEffectRate", 5.0F);
                                    String var44 = var11.getValueAsStaticString(var13, "reclaimEffect", (String)null);
                                    if (var44 != null) {
                                        var17.bY = var17.a((String)var44, (class_605)null);
                                        if (var17.bY != null && var17.bY.b()) {
                                            var17.bW = true;
                                        }
                                    }

                                    String var45 = var11.getValueAsStaticString(var13, "reclaimEffectAtTarget", (String)null);
                                    if (var45 != null) {
                                        var17.bZ = var17.a((String)var45, (class_605)null);
                                        if (var17.bZ != null && var17.bZ.b()) {
                                            var17.bW = true;
                                        }
                                    }

                                    var17.ds.a(var17, var11, var13, "animation_" + var17.ds.a + "_");
                                    var17.dt.a(var17, var11, var13, "animation_" + var17.dt.a + "_");
                                    var17.du.a(var17, var11, var13, "animation_" + var17.du.a + "_");
                                    Iterator var46 = var11.e("animation_").iterator();

                                    while(var46.hasNext()) {
                                        String var47 = (String)var46.next();
                                        String var48 = var47.substring("animation_".length());
                                        class_586 var49 = new class_586(var48);
                                        var49.a(var17, var11, var47, "");
                                        var17.dr.add(var49);
                                    }

                                    var17.ds = var17.a(ActionType.move, var17.ds, true);
                                    var17.dt = var17.a(ActionType.idle, var17.dt, true);
                                    var17.du = var17.a(ActionType.attack, var17.du, true);
                                    var17.dw = var17.a(ActionType.underConstruction);
                                    var17.dx = var17.a(ActionType.underConstructionWithLinkedBuiltTime);
                                    if (var17.dw != null && var17.dx != null) {
                                        throw new RuntimeException("Cannot use underConstruction and underConstructionWithLinkedBuiltTime animations at the same time");
                                    }

                                    var17.dv = var17.a(ActionType.created);
                                    var17.dy = var17.a(ActionType.queuedUnits);
                                    if (var17.dy != null) {
                                        var17.bg = true;
                                    }

                                    var17.dz = var17.a(ActionType.repair);
                                    var17.dA = var17.a(ActionType.reclaim);
                                    var17.cL.c = var11.g(var12, "maxHp");
                                    var17.cL.g = var11.getValueAsIntegerOrDefault(var12, "maxShield", 0);
                                    var17.cM = var11.getValueAsBoolean(var12, "startShieldAtZero", false);
                                    var17.cL.h = var11.getValueAsFloatOrDefault(var12, "shieldRegen", 0.25F);
                                    var17.cU = var11.getValueAsBoolean(var12, "shieldDisplayOnlyDeflection", false);
                                    var17.cV = var11.getValueAsFloatOrDefault(var12, "shieldDeflectionDisplayRate", 4.0F);
                                    var17.cL.l = var11.getValueAsFloatOrDefault(var12, "armour", 0.0F);
                                    var17.cN = var11.getValueAsFloatOrDefault(var12, "armourMinDamageToKeep", 1.0F);
                                    var17.cL.d = var11.getValueAsFloatOrDefault(var12, "energyMax", 0.0F);
                                    var17.cO = var11.getValueAsBoolean(var12, "startEnergyAtZero", false);
                                    var17.cP = var11.getValueAsFloatOrDefault(var12, "energyRegen", 0.0F);
                                    var17.cS = var11.getValueAsFloatOrDefault(var12, "energyStartingPercentage", 1.0F);
                                    var17.cR = var11.getValueAsBoolean(var12, "energyNeedsToRechargeToFull", false);
                                    var17.cQ = var11.getValueAsFloatOrDefault(var12, "energyRegenWhenRecharging", var17.cP);
                                    var17.cT = a((UnitConfig)var11, (String)var12, "energyDisplayName", (String)null);
                                    var17.cW = var11.g(var12, "radius");
                                    var17.dd = var11.getValueAsIntegerOrDefault(var12, "displayRadius", var17.cW);
                                    float var115 = (float)var17.cW;
                                    if (var115 < 6.0F) {
                                        var115 = 6.0F;
                                    }

                                    var17.de = var11.getValueAsFloatOrDefault(var12, "uiTargetRadius", var115);
                                    var17.df = var11.getValueAsIntegerOrDefault(var12, "shieldRenderRadius", var17.cW);
                                    var17.dg = var11.getValueAsIntegerOrDefault(var12, "buildingSelectionOffset", 0);
                                    var17.cX = var11.getValueAsRectOrDefault(var12, "footprint", var17.cX);
                                    var17.cY = var11.getValueAsRectOrDefault(var12, "constructionFootprint", var17.cY);
                                    var17.cZ.a(var17.cX);
                                    var17.cZ = var11.getValueAsRectOrDefault(var12, "displayFootprint", var17.cZ);
                                    var17.da = var11.getValueAsFloatOrDefault(var12, "buildingToFootprintOffsetX", 10.0F);
                                    var17.db = var11.getValueAsFloatOrDefault(var12, "buildingToFootprintOffsetY", 10.0F);
                                    var17.cW = (int)((float)var17.cW * var17.aG);
                                    var17.dd = (int)((float)var17.dd * var17.aG);
                                    var17.cL.n = var11.getValueAsIntegerOrDefault(var12, "fogOfWarSightRange", 15);
                                    var17.dh = var11.getValueAsIntegerOrDefault(var12, "fogOfWarSightRangeWhileNotBuilt", -1);
                                    var17.di = var11.getValueAsFloatOrDefault(var12, "exit_x", 0.0F);
                                    var17.dj = var11.getValueAsFloatOrDefault(var12, "exit_y", 9.0F);
                                    var17.dk = var11.getValueAsFloatOrDefault(var12, "exit_dirOffset", (Float)null);
                                    var17.dl = var11.getValueAsFloatOrDefault(var12, "exit_heightOffset", 0.0F);
                                    var17.dm = var11.getValueAsBoolean(var12, "exitHeightIgnoreParent", false);
                                    var17.dn = var11.getValueAsFloatOrDefault(var12, "exit_moveAwayAmount", 70.0F);
                                    var17.eB = var11.getValueAsIntegerOrDefault(var12, "softCollisionOnAll", 0);
                                    var17.eC = var11.getValueAsBoolean(var12, "disableAllUnitCollisions", false);
                                    if (var17.eC) {
                                        var17.cX.a(0, 0, -1, -1);
                                    }

                                    var17.eJ = var11.getValueAsBoolean(var12, "hideScorchMark", false);
                                    var17.eK = var11.getValueAsBoolean(var13, "disableLowHpFire", var17.eD);
                                    var17.eL = var11.getValueAsBoolean(var13, "disableLowHpSmoke", var17.eD);
                                    var17.aH = var11.getValueAsBoolean(var12, "isBuilding", false);
                                    var17.aI = var11.getValueAsBoolean(var12, "ignoreInUnitCapCalculation", var17.aH);
                                    var17.aJ = var11.getValueAsBoolean(var12, "placeOnlyOnResPool", false);
                                    var17.aK = var11.getValueAsBoolean(var12, "isUnrepairableUnit", false);
                                    var17.aL = var11.getValueAsFloatOrDefault(var12, "extraBuildRangeWhenBuildingThis", 0.0F);
                                    var17.aM = var11.getValueAsBoolean(var12, "isUnselectable", false);
                                    var17.aN = var11.getValueAsBoolean(var12, "isUnselectableAsTarget", var17.aM);
                                    var17.fO = var11.a((class_591)var17, var12, (String)"showActionsWithMixedSelectionIfOtherUnitsHaveTag", (class_588)null);
                                    var17.aO = var11.getValueAsBoolean(var12, "canNotBeDirectlyAttacked", false);
                                    var17.aP = var11.getValueAsBoolean(var12, "canNotBeDamaged", var17.aO);
                                    var17.aQ = var11.getValueAsBoolean(var12, "showOnMinimap", true);
                                    var17.aR = var11.getValueAsBoolean(var12, "showOnMinimapToEnemies", var17.cL.m);
                                    var17.aS = var11.a((class_591)var17, var12, (String)"canOnlyBeAttackedByUnitsWithTags", (class_588)null);
                                    if (var17.aO && var17.aS != null) {
                                        throw new RuntimeException("canNotBeDirectlyAttacked and canOnlyBeAttackedByUnitsWithTags cannot be used at the same time");
                                    }

                                    var17.aT = var11.getValueAsBoolean(var12, "canNotBeGivenOrdersByPlayer", false);
                                    var17.aU = var11.getValueAsBoolean(var12, "canRepairBuildings", false);
                                    var17.aV = var11.getValueAsBoolean(var12, "canRepairUnits", false);
                                    var17.aW = var11.getValueAsBoolean(var12, "autoRepair", false);
                                    if (var17.aW) {
                                        var17.a(class_829.a);
                                    }

                                    var17.cL.o = var11.getValueAsIntegerOrDefault(var12, "nanoRange", -1);
                                    if (var17.cL.o != -1) {
                                        class_398 var10000 = var17.cL;
                                        var10000.o = (int)((float)var10000.o * var17.aG);
                                    }

                                    var17.aY = var11.getValueAsBoolean(var12, "nanoRangeForRepairIsMelee", false);
                                    if (var17.aY) {
                                        var17.aX = 5;
                                    }

                                    int var116 = var11.getValueAsIntegerOrDefault(var12, "nanoRangeForRepair", -1);
                                    if (var116 != -1) {
                                        var17.aX = var116;
                                        var17.aX = (int)((float)var17.aX * var17.aG);
                                    }

                                    var17.ba = var11.getValueAsBoolean(var12, "nanoRangeForReclaimIsMelee", false);
                                    if (var17.ba) {
                                        var17.aZ = 5;
                                    }

                                    int var117 = var11.getValueAsIntegerOrDefault(var12, "nanoRangeForReclaim", -1);
                                    if (var117 != -1) {
                                        var17.aZ = var117;
                                        var17.aZ = (int)((float)var17.aZ * var17.aG);
                                    }

                                    var17.bb = var11.getValueAsFloatOrDefault(var12, "nanoRepairSpeed", 0.2F);
                                    float var118 = 5.1F;
                                    var17.bc = var11.getValueAsFloatOrDefault(var12, "nanoReclaimSpeed", var17.bb * 5.1F);
                                    var17.bd = var11.getValueAsFloatOrDefault(var12, "resourceReclaimMultiplier", 1.0F);
                                    var17.be = var11.getValueAsFloatOrDefault(var12, "nanoUnbuildSpeed", 1.0F) * 0.001F * 5.1F;
                                    var17.bf = var11.getValueAsFloatOrDefault(var12, "nanoBuildSpeed", 1.0F);
                                    var17.cL.r = var11.getValueAsFloatOrDefault(var12, "nanoFactorySpeed", 1.0F);
                                    var17.cL.p = var11.getValueAsFloatOrDefault(var12, "selfRegenRate", 0.0F);
                                    var17.bh = var11.d(var12, "selfBuildRate", 0.0F);
                                    var17.bi = var11.getValueAsBoolean(var12, "dieOnConstruct", false);
                                    var17.bk = var11.getValueAsBoolean(var12, "dieOnZeroEnergy", false);
                                    byte var50 = 4;
                                    if (var17.cL.b > 30000.0F) {
                                        var50 = 8;
                                    }

                                    if (var17.aH) {
                                        var50 = 7;
                                    }

                                    var17.bq = var11.getValueAsIntegerOrDefault(var12, "numBitsOnDeath", Integer.valueOf(var50));
                                    var17.bn = var11.getValueAsBoolean(var12, "nukeOnDeath", false);
                                    var17.bo = var11.getValueAsFloatOrDefault(var12, "nukeOnDeathRange", 250.0F);
                                    var17.bp = var11.getValueAsFloatOrDefault(var12, "nukeOnDeathDamage", 5400.0F);
                                    var17.br = var11.getValueAsBoolean(var12, "nukeOnDeathDisableWhenNoNuke", false);
                                    var17.bm = var11.getValueAsIntegerOrDefault(var12, "fireOnDeath", 0);
                                    var17.bt = (ExplodeType)var11.a((String)var12, "explodeTypeOnDeath", (Enum)null, (Class) ExplodeType.class);
                                    var17.bu = var11.getValueAsBoolean(var12, "explodeOnDeath", true);
                                    var17.bs = var11.getValueAsBoolean(var12, "disableDeathOnZeroHp", false);
                                    boolean var51 = var11.getValueAsBoolean(var12, "explodeOnDeathGroundCollosion", true);
                                    var51 = var11.getValueAsBoolean(var12, "explodeOnDeathGroundCollision", var51);
                                    var17.bv = var51;
                                    var17.by = var17.a((String)var11.getValueAsStaticString(var12, "effectOnDeath", (String)null), (class_605)null);
                                    var17.bx = var17.a((String)var11.getValueAsStaticString(var12, "effectOnDeathIfUnbuilt", (String)null), (class_605)null);
                                    var17.bz = class_392.a(var17, var11.getValueAsStaticString(var12, "soundOnDeath", (String)null));
                                    String var52 = var11.getValueAsStaticString(var12, "effectOnDeathGroundCollosion", (String)null);
                                    var52 = var11.getValueAsStaticString(var12, "effectOnDeathGroundCollision", var52);
                                    var17.bw = var17.a((String)var52, (class_605)null);
                                    var17.bC = class_395.a(var17, var11, var12, "unitsSpawnedOnDeath");
                                    var17.bD = var11.getValueAsBoolean(var12, "unitsSpawnedOnDeath_setToTeamOfLastAttacker", false);
                                    var17.fk = var11.getValueAsBoolean(var12, "canReclaimResources", false);
                                    var17.fl = var11.a((class_591)var17, var12, (String)"canReclaimResourcesOnlyWithTags", (class_588)null);
                                    var17.fm = var11.getValueAsIntegerOrDefault(var12, "canReclaimResourcesNextSearchRange", 500);
                                    var17.fn = var11.a((class_591)var17, var12, (String)"canReclaimUnitsOnlyWithTags", (class_588)null);
                                    var17.fo = var11.a((class_591)var17, var12, (String)"canRepairUnitsOnlyWithTags", (class_588)null);
                                    if (var17.fn != null && !var17.aV && !var17.aU) {
                                        throw new RuntimeException("canReclaimUnitsOnlyWithTags requires canRepairUnits:true or canRepairBuildings:true");
                                    }

                                    if (var17.fo != null && !var17.aV && !var17.aU) {
                                        throw new RuntimeException("canRepairUnitsOnlyWithTags requires canRepairUnits:true or canRepairBuildings:true");
                                    }

                                    var17.eM = var11.getValueAsIntegerOrDefault(var12, "maxTransportingUnits", 0);
                                    if (var17.eM < 0) {
                                        throw new RuntimeException("maxTransportingUnits cannot be < 0");
                                    }

                                    var17.eN = var11.b(var12, "transportUnitsUnloadDelayBetweenEachUnit", 30.0F);
                                    var17.eP = class_585.a(var11.getValueAsStaticString(var12, "transportUnitsRequireTag", (String)null));
                                    String var53 = var11.getValueAsStaticString(var12, "transportUnitsRequireMovementType", (String)null);
                                    String var57;
                                    if (var53 != null) {
                                        String[] var54 = var53.split(",");
                                        int var55 = var54.length;

                                        for(int var56 = 0; var56 < var55; ++var56) {
                                            var57 = var54[var56];
                                            var57 = var57.trim();
                                            var17.eQ.add(MovementType.a(var57, "transportUnitsRequireMovementType"));
                                        }
                                    }

                                    var17.eO = var11.getValueAsBoolean(var12, "transportUnitsEachUnitAlwaysUsesSingleSlot", false);
                                    var17.eR = var11.getValueAsBoolean(var12, "transportUnitsBlockAirAndWaterUnits", var17.eQ.size() == 0);
                                    var17.eS = var11.getValueAsBoolean(var12, "transportUnitsBlockOtherTransports", true);
                                    var17.eU = var11.a((class_591)var17, var12, (String)"transportUnitsKeepBuiltUnits", (LogicBoolean)LogicBoolean.falseBoolean);
                                    var17.eV = var11.a((class_591)var17, var12, (String)"transportUnitsKillOnDeath", (LogicBoolean)LogicBoolean.trueBoolean);
                                    var17.eW = var11.a((class_591)var17, var12, (String)"transportUnitsKeepWaypoints", (LogicBoolean)LogicBoolean.falseBoolean);
                                    var17.eY = var11.getValueAsFloatOrDefault(var12, "transportUnitsHealBy", 0.0F);
                                    var17.fc = var11.a((class_591)var17, var12, (String)"transportUnitsCanUnloadUnits", (LogicBoolean)null);
                                    if (var17.fc != null) {
                                        var17.fd = var17.fc;
                                    } else {
                                        var17.fc = class_591.fa;
                                        var17.fd = class_591.fb;
                                    }

                                    var17.eT = var11.getValueAsBoolean(var12, "transportUnitsAddUnloadOption", var17.fc != LogicBoolean.falseBoolean);
                                    var17.eX = var11.getValueAsBoolean(var12, "transportUnitsOnTeamChangeKeepCurrentTeam", var17.eX);
                                    var17.eZ = var11.getValueAsIntegerOrDefault(var12, "transportSlotsNeeded", 1);

                                    int var119;
                                    String var120;
                                    String var123;
                                    for(var119 = -1; var119 <= 29; ++var119) {
                                        var120 = "builtFrom_" + var119 + "_";
                                        if (var119 == -1) {
                                            var120 = "builtFrom_";
                                        }

                                        var123 = var120 + "name";
                                        var57 = var11.getValueAsStaticString(var12, var123, (String)null);
                                        if (var57 != null) {
                                            String[] var58 = var57.split(",");
                                            String[] var59 = var58;
                                            int var60 = var58.length;

                                            for(int var61 = 0; var61 < var60; ++var61) {
                                                String var62 = var59[var61];
                                                var62 = var62.trim();
                                                if (!var62.equals("")) {
                                                    class_595 var63 = new class_595();
                                                    var63.a = var62;
                                                    var63.b = var11.getValueAsFloatOrDefault(var12, var120 + "pos", 999.0F);
                                                    var63.c = var11.getValueAsBoolean(var12, var120 + "forceNano", false);
                                                    var63.d = "[" + var12 + "]" + var123;
                                                    var63.f = var11.a((class_591)var17, var12, (String)(var120 + "isLocked"), (LogicBoolean)null);
                                                    var63.g = a((UnitConfig)var11, (String)var12, var120 + "isLockedMessage", (String)null);
                                                    if (var63.f == LogicBoolean.falseBoolean) {
                                                        var63.f = null;
                                                    }

                                                    if (!"NONE".equalsIgnoreCase(var62)) {
                                                        var17.gg.add(var63);
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    for(var119 = 0; var119 <= 50; ++var119) {
                                        var120 = var11.getValueAsStaticString(var12, "canBuild_" + var119 + "_name", (String)null);
                                        if (var120 != null) {
                                            var123 = "canBuild_" + var119 + "_";
                                            b(var17, var11, var12, var123, false);
                                        }
                                    }

                                    Iterator var121 = var11.e("canBuild_").iterator();

                                    while(var121.hasNext()) {
                                        var120 = (String)var121.next();
                                        b(var17, var11, var120, "", true);
                                    }

                                    var17.ff = class_387.a(var17, var11);
                                    String var122 = var11.e(var15, "movementType");
                                    var17.fg = MovementType.a(var122, "movementType");
                                    if (!var17.aH) {
                                        var17.fh = var17.fg;
                                    } else {
                                        var17.fh = MovementType.NONE;
                                    }

                                    Boolean var124 = var11.getValueAsBoolean(var16, "useAsBuilder", (Boolean)null);
                                    var17.fs = var11.getValueAsBoolean(var16, "useAsAttacker", true);
                                    Boolean var125 = var11.getValueAsBoolean(var12, "isBuilder", (Boolean)null);
                                    if (var125 == null) {
                                        if (var124 == null) {
                                            var125 = false;
                                        } else {
                                            var125 = var124;
                                        }
                                    } else if (var124 == null) {
                                        var124 = var125;
                                    }

                                    if (var124 == null) {
                                        var124 = false;
                                    }

                                    var17.fp = var125;
                                    var17.fq = var124;
                                    if (!var17.fp && var17.fq) {
                                        throw new RuntimeException("Cannot tell AI to use a non-builder as builder [ai]useAsBuilder:" + var17.fq + " [core]isBuilder:" + var17.fp);
                                    }

                                    if (var17.fk) {
                                        var17.fr = true;
                                    }

                                    Boolean var126 = var11.getValueAsBoolean(var16, "useAsHarvester", (Boolean)null);
                                    if (var126 != null) {
                                        var17.fr = var126;
                                    }

                                    Boolean var127 = var11.getValueAsBoolean(var16, "useAsTransport", (Boolean)null);
                                    if (var127 == null) {
                                        var127 = var17.eM > 0 && !var17.fq && !var17.aH;
                                        if (!var17.eT) {
                                            var127 = false;
                                        }
                                    }

                                    var17.ft = var127;
                                    if (var17.aH) {
                                        var17.as = class_88.q;
                                    } else if (var17.fg == MovementType.AIR) {
                                        var17.as = class_107.n;
                                    } else if (var17.fg == MovementType.WATER) {
                                        var17.as = class_114.q;
                                    } else if (var17.fg == MovementType.HOVER) {
                                        if (var17.cm) {
                                            var17.as = class_120.dO;
                                        } else if (var17.l()) {
                                            var17.as = Builder.h;
                                        } else {
                                            var17.as = class_128.n;
                                        }
                                    } else if (var17.cm) {
                                        var17.as = class_120.dO;
                                    } else if (var17.l()) {
                                        var17.as = Builder.h;
                                    } else {
                                        var17.as = class_120.dN;
                                    }

                                    TeamImageCache var128 = var17.a(var11, var13, "icon_zoomed_out", false);
                                    if (var128 != null) {
                                        var17.as = var17.a(var128, var17.ac);
                                    }

                                    if (var11.getValueAsBoolean(var13, "icon_zoomed_out_neverShow", false)) {
                                        var17.as = null;
                                    }

                                    var17.t = var11.getValueAsBoolean(var13, "showHealthBar", true);
                                    var17.u = var11.getValueAsBoolean(var13, "showHealthBarChanges", true);
                                    var17.v = var11.getValueAsBoolean(var13, "showEnergyBar", true);
                                    var17.w = var11.getValueAsBoolean(var13, "showShotDelayBar", true);
                                    var17.x = var11.getValueAsBoolean(var13, "showTransportBar", true);
                                    var17.y = var11.getValueAsBoolean(var13, "showShieldBar", true);
                                    var17.z = var11.getValueAsBoolean(var13, "showQueueBar", true);
                                    var17.A = var11.getValueAsBoolean(var13, "showSelectionIndicator", true);
                                    var17.fi = var11.getValueAsBoolean(var15, "slowDeathFall", false);
                                    var17.fj = var11.getValueAsBoolean(var15, "slowDeathFallSmoke", true);
                                    var17.cL.j = var11.getValueAsFloatOrDefault(var15, "moveSpeed", 1.0F) * var17.aG;
                                    var17.dN = var11.getValueAsFloatOrDefault(var15, "moveAccelerationSpeed", 1.0F) * var17.aG;
                                    var17.dO = var11.getValueAsFloatOrDefault(var15, "moveDecelerationSpeed", 1.0F) * var17.aG;
                                    Boolean var129 = var11.getValueAsBoolean(var15, "ignoreMoveOrders", (Boolean)null);
                                    if (var17.aH) {
                                        var17.dP = true;
                                    }

                                    if (var129 != null) {
                                        if (var129) {
                                            var17.dP = true;
                                            if (var17.cL.j > 0.0F) {
                                                throw new RuntimeException("[movement]ignoreMoveOrders expects moveSpeed=0");
                                            }
                                        } else if (var17.aH) {
                                            throw new RuntimeException("[movement]ignoreMoveOrders=false not yet supported on buildings");
                                        }
                                    }

                                    var17.ej = var11.getValueAsFloatOrDefault(var15, "moveYAxisScaling", 1.0F);
                                    if (var17.ej <= 0.0F) {
                                        throw new RuntimeException("[movement]moveYAxisScaling must be > 0");
                                    }

                                    var17.ek = 1.0F / var17.ej;
                                    var17.el = var11.getValueAsFloatOrDefault(var15, "reverseSpeedPercentage", 0.6F);
                                    String var130 = var11.getValueAsStaticString(var15, "landOnGround", "false");
                                    if (var130.equalsIgnoreCase("false")) {
                                        var17.dQ = false;
                                    } else if (var130.equalsIgnoreCase("onlyIdle")) {
                                        var17.dQ = true;
                                        var17.dR = true;
                                    } else {
                                        if (!var130.equalsIgnoreCase("true")) {
                                            throw new RuntimeException("landOnGround expected:true, false, onlyIdle, not:" + var130);
                                        }

                                        var17.dQ = true;
                                    }

                                    float var131 = 0.0F;
                                    float var132 = 0.0F;
                                    if (var17.fg == MovementType.AIR) {
                                        var131 = 35.0F;
                                        var132 = 1.5F;
                                    }

                                    var17.dS = var11.getValueAsFloatOrDefault(var15, "startingHeightOffset", 0.0F);
                                    var17.cL.q = var11.getValueAsFloatOrDefault(var15, "targetHeight", var131);
                                    var17.dT = var11.getValueAsFloatOrDefault(var15, "targetHeightDrift", var132);
                                    if (var17.cL.q > 80.0F) {
                                        var17.B = true;
                                    }

                                    var17.dU = var11.getValueAsFloatOrDefault(var15, "heightChangeRate", var17.dU);
                                    var17.dV = var11.getValueAsFloatOrDefault(var15, "fallingAcceleration", var17.dV);
                                    var17.dW = var11.getValueAsFloatOrDefault(var15, "fallingAccelerationDead", var17.dW);
                                    var17.cL.k = var11.getValueAsFloatOrDefault(var15, "maxTurnSpeed", 1.0F);
                                    var17.eo = var11.getValueAsFloatOrDefault(var15, "turnAcceleration", 1.0F);
                                    var17.dX = var11.getValueAsBoolean(var15, "moveSlidingMode", false);
                                    var17.dY = var11.getValueAsBoolean(var15, "moveIgnoringBody", false);
                                    var17.dZ = var11.getValueAsIntegerOrDefault(var15, "moveSlidingDir", -1);
                                    var17.ei = var11.getValueAsBoolean(var15, "joinsGroupFormations", true);
                                    var17.ea = var11.getValueAsFloatOrDefault(var14, "turretSize", 1.0F) * var17.aG;
                                    var17.eb = var11.getValueAsFloatOrDefault(var14, "turretTurnSpeed", 8.0F);
                                    var17.dL = var11.getValueAsBoolean(var14, "turretRotateWithBody", true);
                                    String var64 = var11.getValueAsStaticString(var14, "attackMovement", "normal");
                                    var17.ec = AttackMovementType.NORMAL;
                                    if (var64.equalsIgnoreCase("normal")) {
                                        var17.ec = AttackMovementType.NORMAL;
                                    }

                                    if (var64.equalsIgnoreCase("strafing")) {
                                        var17.ec = AttackMovementType.STRAFING;
                                    }

                                    if (var64.equalsIgnoreCase("bomber")) {
                                        var17.ec = AttackMovementType.BOMBER;
                                    }

                                    var17.ef = var11.getValueAsBoolean(var14, "disablePassiveTargeting", false);
                                    var17.eg = var11.getValueAsBoolean(var14, "stopTargetingAfterFiring", false);
                                    var17.eh = var11.getValueAsBoolean(var14, "turretMultiTargeting", false);
                                    var17.ed = var11.getValueAsFloatOrDefault(var14, "attackMovementSpeed", 1.0F);
                                    var17.ee = var11.getValueAsFloatOrDefault(var14, "attackMovementSpread", 1.0F);
                                    Float var65 = var11.getValueAsFloatOrDefault(var14, "maxAttackRange", (Float)null);
                                    boolean var66;
                                    if (var65 != null) {
                                        var66 = true;
                                        var17.cL.i = var65 * var17.aG;
                                    } else {
                                        var66 = false;
                                        var17.cL.i = 100.0F * var17.aG;
                                    }

                                    var17.ez = var11.getValueAsFloatOrDefault(var14, "aimOffsetSpread", 0.6F);
                                    var17.dM = var11.b(var14, "shootDelay", 50.0F);
                                    var17.cL.e = var11.getValueAsFloatOrDefault(var14, "shootDelayMultiplier", 1.0F);
                                    var17.cL.f = var11.getValueAsFloatOrDefault(var14, "shootDamageMultiplier", 1.0F);
                                    var17.dK = var11.getValueAsBoolean(var14, "showRangeUIGuide", (Boolean)null);
                                    var17.eF = var11.getValueAsBoolean(var14, "isMelee", false);
                                    var17.eG = 0.0F;
                                    Float var67 = var11.getValueAsFloatOrDefault(var14, "meleeEngangementDistance", (Float)null);
                                    if (var17.eF) {
                                        var17.eG = 250.0F;
                                        if (var67 != null) {
                                            var17.eG = var67;
                                        }
                                    } else if (var67 != null) {
                                        throw new RuntimeException("[attack]meleeEngangementDistance can only be used with isMelee:true");
                                    }

                                    a(var94, class_437.UNIT_PARSE_PART_A);
                                    Iterator var68 = var11.e("projectile_").iterator();

                                    while(var68.hasNext()) {
                                        String var69 = (String)var68.next();
                                        String var70 = var69.substring("projectile_".length());
                                        if (var17.f(var70) != null) {
                                            throw new RuntimeException("Two projectiles found with the same name:" + var70);
                                        }

                                        class_164 var71 = new class_164();
                                        var71.bh = var70;
                                        var71.bj = var17;
                                        class_164.a(var71, var17, var11, var69);
                                    }

                                    int var133 = var17.fT.size();
                                    if (var133 < 1) {
                                        var133 = 1;
                                    }

                                    var17.fR = new class_164[var133];

                                    int var134;
                                    class_164 var135;
                                    for(var134 = 0; var134 < var17.fT.size(); ++var134) {
                                        var135 = (class_164)var17.fT.get(var134);
                                        var135.bi = var134;
                                        var17.fR[var134] = var135;
                                    }

                                    for(var134 = 0; var134 < var17.fR.length; ++var134) {
                                        var135 = var17.fR[var134];
                                        if (var135 != null) {
                                            var135.w *= var17.aG;
                                            var135.au *= var17.aG;
                                            var135.aF *= var17.aG;
                                        }
                                    }

                                    if (var17.fR[0] == null) {
                                        class_164 var136 = new class_164();
                                        var136.bi = 0;
                                        var136.bh = "1";
                                        var136.b = 10;
                                        var17.fT.add(var136);
                                        var17.fR[0] = var136;
                                    }

                                    ArrayList var137 = var17.fS;
                                    Iterator var138 = var11.e("turret_").iterator();

                                    while(var138.hasNext()) {
                                        String var139 = (String)var138.next();
                                        String var72 = var139.substring("turret_".length());
                                        if (var17.e(var72) != null) {
                                            throw new RuntimeException("Two turrets found with the same name:" + var72);
                                        }

                                        class_397 var73 = new class_397();
                                        var73.a = var72;
                                        var73.b = var139;
                                        var137.add(var73);
                                    }

                                    var138 = var137.iterator();

                                    class_397 var140;
                                    while(var138.hasNext()) {
                                        var140 = (class_397)var138.next();
                                        class_397.a(var140, var17, var11, var140.b);
                                    }

                                    if (var137.size() == 0) {
                                        class_397 var141 = new class_397();
                                        var141.f = 0.0F;
                                        var141.g = 0.0F;
                                        var141.a = "1";
                                        var141.m = var17.dM;
                                        var137.add(var141);
                                    }

                                    int var142;
                                    for(var142 = var137.size() - 1; var142 >= 0; --var142) {
                                        if (var137.get(var142) != null) {
                                            ((class_397)var137.get(var142)).e = var142;
                                        }
                                    }

                                    for(var142 = var137.size() - 1; var142 >= 0; --var142) {
                                        if (var137.get(var142) != null) {
                                            var140 = (class_397)var137.get(var142);
                                            if (var140.y != null) {
                                                var140.w = var140.y.e;
                                                if (var140.y.y != null) {
                                                    throw new RuntimeException(var140.a + ": Turret can not be attached to turret that is also attached to a turret");
                                                }
                                            }

                                            if (var140.z != null) {
                                                var140.x = var140.z.e;
                                            }

                                            if (var140.W < 0.0F) {
                                                var140.W = var140.V;
                                            }
                                        }
                                    }

                                    if (var137.size() > 31) {
                                        throw new RuntimeException("Turret max count per unit is: 31");
                                    }

                                    var17.fQ = (class_397[])var137.toArray(new class_397[0]);
                                    var17.dJ = var17.cL.i;
                                    float var145 = -1.0F;
                                    boolean var143 = true;
                                    boolean var144 = false;
                                    Iterator var146 = var137.iterator();

                                    while(var146.hasNext()) {
                                        class_397 var74 = (class_397)var146.next();
                                        var74.X *= var17.aG;
                                        var74.f *= var17.aG;
                                        var74.g *= var17.aG;
                                        var74.Y *= var17.aG;
                                        var74.Z *= var17.aG;
                                        boolean var75 = false;
                                        if (var74.B) {
                                            if (var74.ab >= 99999.0F) {
                                                var143 = false;
                                            } else {
                                                var144 = true;
                                                if (var17.dJ > var74.ab) {
                                                    var17.dJ = var74.ab;
                                                }

                                                if (var145 < var74.ab) {
                                                    var145 = var74.ab;
                                                }

                                                if (class_340.c(var74.ab - var17.cL.i) > 5.0F) {
                                                    boolean var76 = false;
                                                    Iterator var77 = var17.o.iterator();

                                                    while(var77.hasNext()) {
                                                        class_604 var78 = (class_604)var77.next();
                                                        if (class_340.c(var74.ab - var78.a) < 5.0F) {
                                                            var76 = true;
                                                        }
                                                    }

                                                    if (!var76) {
                                                        var75 = true;
                                                    }
                                                }
                                            }
                                        }

                                        if (var74.ac != null) {
                                            var75 = var74.ac;
                                        }

                                        if (var75) {
                                            class_604 var149 = new class_604();
                                            var149.a = var74.ab;
                                            var17.o.add(var149);
                                        }
                                    }

                                    if (var144 && var143) {
                                        if (!var66) {
                                            var17.cL.i = var145;
                                        } else if (var145 < var17.cL.i) {
                                            throw new RuntimeException("limitingRange as been applied to all turrets but is less than maxAttackRange (hint: unset maxAttackRange or a limitingRange, or make values match)");
                                        }
                                    }

                                    String var147 = var11.getValueAsStaticString(var14, "setMainTurretAs", (String)null);
                                    if (var147 != null) {
                                        var17.dF = var17.e(var147);
                                        if (var17.dF == null) {
                                            throw new RuntimeException("[attack] Could not find setMainTurretAs with name: " + var147);
                                        }
                                    } else {
                                        var17.dF = var17.e("1");
                                        if (var17.dF == null) {
                                            var17.dF = var17.fQ[0];
                                        }
                                    }

                                    var17.dG = var17.dF.e;
                                    a(var94, class_437.UNIT_PARSE_PART_B);
                                    long var148 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                                    if (var11.l(var12, "action_")) {
                                        for(int var150 = 0; var150 <= 50; ++var150) {
                                            a(var17, var11, var12, "action_" + var150 + "_", "" + var150, false, false);
                                        }
                                    }

                                    Iterator var152 = var11.e("action_").iterator();

                                    String var151;
                                    String var154;
                                    while(var152.hasNext()) {
                                        var151 = (String)var152.next();
                                        var154 = var151.substring("action_".length());
                                        if (var17.g(var154) != null) {
                                            throw new RuntimeException("Two actions found with the same name:" + var154);
                                        }

                                        a(var17, var11, var151, "", var154, true, false);
                                    }

                                    var152 = var11.e("hiddenAction_").iterator();

                                    while(var152.hasNext()) {
                                        var151 = (String)var152.next();
                                        var154 = var151.substring("hiddenAction_".length());
                                        if (var17.g(var154) != null) {
                                            throw new RuntimeException("Two actions found with the same name:" + var154);
                                        }

                                        a(var17, var11, var151, "", var154, true, true);
                                    }

                                    a(var148, class_437.ACTION_PARSE);
                                    ArrayList var155 = new ArrayList();
                                    ArrayList var153 = new ArrayList();

                                    for(int var156 = 0; var156 <= 1; ++var156) {
                                        boolean var79 = var156 == 0;
                                        ArrayList var80 = var79 ? var155 : var153;

                                        for(int var81 = 1; var81 < 21; ++var81) {
                                            String var82 = var79 ? "leg_" + var81 : "arm_" + var81;
                                            if (var11.g(var82)) {
                                                class_431 var83 = new class_431();
                                                class_431.a(var83, var17, var11, var82, var79, var80);
                                                var80.add(var83);
                                            } else {
                                                var80.add((Object)null);
                                            }
                                        }
                                    }

                                    ArrayList var158 = new ArrayList();
                                    Iterator var157 = var155.iterator();

                                    class_431 var160;
                                    while(var157.hasNext()) {
                                        var160 = (class_431)var157.next();
                                        if (var160 != null) {
                                            var158.add(var160);
                                        }
                                    }

                                    var157 = var153.iterator();

                                    while(var157.hasNext()) {
                                        var160 = (class_431)var157.next();
                                        if (var160 != null) {
                                            var158.add(var160);
                                        }
                                    }

                                    for(int var159 = var158.size() - 1; var159 >= 0; var160.a = var159--) {
                                        var160 = (class_431)var158.get(var159);
                                    }

                                    var17.ax = (class_431[])var158.toArray(new class_431[0]);
                                    if (var17.ax.length > 0) {
                                        var17.a(class_833.a);
                                    }

                                    var157 = var17.dr.iterator();

                                    while(var157.hasNext()) {
                                        class_586 var162 = (class_586)var157.next();
                                        var162.a(var17);
                                    }

                                    b(var17);
                                    String var161 = var11.getValueAsStaticString(var12, "fireTurretXAtSelfOnDeath", (String)null);
                                    if (var161 != null && !"NONE".equalsIgnoreCase(var161)) {
                                        class_397 var163 = var17.e(var161);
                                        if (var163 == null) {
                                            throw new RuntimeException("Cannot find turret:" + var161 + " for [" + var12 + "]fireTurretXAtSelfOnDeath");
                                        }

                                        var17.bB = var163.e;
                                    }

                                    class_828.a(var17, var11);
                                    var17.bj = var11.getValueAsBoolean(var14, "dieOnAttack", false);
                                    var17.bl = var11.getValueAsBoolean(var14, "removeOnAttack", false);
                                    var17.ep = var11.getValueAsPrimeBoolean(var14, "canAttack");
                                    if (var17.ep) {
                                        var17.eq = var11.a(var17, var14, "canAttackFlyingUnits");
                                        var17.er = var11.a(var17, var14, "canAttackLandUnits");
                                        var17.es = var11.a(var17, var14, "canAttackUnderwaterUnits");
                                    } else {
                                        var17.eq = var11.a((class_591)var17, var14, (String)"canAttackFlyingUnits", (LogicBoolean)LogicBoolean.falseBoolean);
                                        var17.er = var11.a((class_591)var17, var14, (String)"canAttackLandUnits", (LogicBoolean)LogicBoolean.falseBoolean);
                                        var17.es = var11.a((class_591)var17, var14, (String)"canAttackUnderwaterUnits", (LogicBoolean)LogicBoolean.falseBoolean);
                                    }

                                    var17.et = var11.a((class_591)var17, var14, (String)"canAttackNotTouchingWaterUnits", (LogicBoolean)null);
                                    if (LogicBoolean.isStaticTrue(var17.et)) {
                                        var17.et = null;
                                    }

                                    var17.ev = var11.a((class_591)var17, var14, (String)"canOnlyAttackUnitsWithTags", (class_588)null);
                                    var17.ew = var11.a((class_591)var17, var14, (String)"canOnlyAttackUnitsWithoutTags", (class_588)null);
                                    if (var17.ev != null || var17.ew != null) {
                                        var17.eu = true;
                                    }

                                    boolean var165 = false;
                                    boolean var164 = false;
                                    Iterator var166 = var137.iterator();

                                    while(true) {
                                        while(true) {
                                            class_397 var168;
                                            do {
                                                if (!var166.hasNext()) {
                                                    if (var165 && !var164) {
                                                        var17.ex = true;
                                                        var17.eu = true;
                                                    }

                                                    var17.ey = var11.getValueAsBoolean(var14, "isFixedFiring", false);
                                                    var17.fM = var11.getValueAsBoolean(var16, "lowPriorityTargetForOtherUnits", false);
                                                    var17.fN = var11.getValueAsBoolean(var16, "notPassivelyTargetedByOtherUnits", false);
                                                    if (var17.ep && var17.fN) {
                                                        throw new RuntimeException("[ai]notPassivelyTargetedByOtherUnits is cannot currently supported on units that can attack");
                                                    }

                                                    var17.fv = var11.a((class_591)var17, var16, (String)"aiTags", (class_588)null);
                                                    var17.fw = var11.getValueAsBoolean(var16, "disableUse", false);
                                                    var17.fz = var11.getValueAsFloatOrDefault(var16, "buildPriority", 0.05F);
                                                    var17.fA = var11.getValueAsIntegerOrDefault(var16, "recommendedInEachBaseNum", 0);
                                                    var17.fB = var11.getValueAsFloatOrDefault(var16, "recommendedInEachBasePriorityIfUnmet", 0.5F);
                                                    var17.fy = var11.getValueAsIntegerOrDefault(var16, "maxEachBase", class_340.b(2, var17.fA));
                                                    var17.fx = var11.getValueAsIntegerOrDefault(var16, "maxGlobal", -1);
                                                    if (var17.fy < var17.fA) {
                                                        throw new RuntimeException("[ai]recommendedInEachBaseNum is smaller than maxEachBase");
                                                    }

                                                    if (!var17.aH) {
                                                        if (var11.n(var16, "recommendedInEachBaseNum")) {
                                                            throw new RuntimeException("[ai]recommendedInEachBaseNum currently only applies to buildings");
                                                        }

                                                        if (var11.n(var16, "recommendedInEachBasePriorityIfUnmet")) {
                                                            throw new RuntimeException("[ai]recommendedInEachBasePriorityIfUnmet currently only applies to buildings");
                                                        }
                                                    }

                                                    var17.fE = var11.getValueAsIntegerOrDefault(var16, "whenUsingAsHarvester_recommendedInEachBase", -1);
                                                    var17.fF = var11.getValueAsIntegerOrDefault(var16, "whenUsingAsHarvester_recommendedGlobal", -1);
                                                    var17.fG = var11.getValueAsBoolean(var16, "whenUsingAsHarvester_includeOtherHarvesterCounts", false);
                                                    var17.fH = var11.a((class_591)var17, var16, (String)"onlyUseAsHarvester_ifBaseHasUnitTagged", (class_588)null);
                                                    var17.fC = var11.getValueAsFloatOrDefault(var16, "nonInBaseExtraPriority", 0.04F);
                                                    var17.fC = var11.getValueAsFloatOrDefault(var16, "noneInBaseExtraPriority", var17.fC);
                                                    var17.fD = var11.getValueAsFloatOrDefault(var16, "nonGlobalExtraPriority", 0.0F);
                                                    var17.fD = var11.getValueAsFloatOrDefault(var16, "noneGlobalExtraPriority", var17.fD);
                                                    var17.fI = var11.getValueAsStaticString(var16, "upgradedFrom", (String)null);
                                                    Float var167 = var11.getValueAsFloatOrDefault(var16, "ai_upgradePriority", (Float)null);
                                                    if (var167 != null && var167 != -1.0F) {
                                                        if (!(var167 >= 0.0F) || !(var167 <= 1.0F)) {
                                                            throw new RuntimeException("[ai]ai_upgradePriority: " + var17.fK + " must be between 0-1 or -1 for default");
                                                        }

                                                        var17.fK = var167 * 100.0F;
                                                    }

                                                    if (var17.ep) {
                                                        for(int var169 = 0; var169 < var17.fQ.length; ++var169) {
                                                            class_397 var84 = var17.fQ[var169];
                                                            if (var84.B && var84.ao == null && var17.w) {
                                                                if (var84.m > 140.0F && (var17.em == -1 || var17.fQ[var17.em].m < var84.m)) {
                                                                    var17.em = var169;
                                                                }

                                                                if (var84.n > 80.0F) {
                                                                    var17.en = var169;
                                                                }
                                                            }
                                                        }
                                                    }

                                                    if (var17.cI == -2) {
                                                        if (var17.fg == MovementType.AIR) {
                                                            var17.cI = 5;
                                                        } else if (var17.j()) {
                                                            if (var17.al != null) {
                                                                var17.cI = 3;
                                                            } else {
                                                                var17.cI = 2;
                                                            }
                                                        } else if (var17.cL.q < -2.0F) {
                                                            var17.cI = 1;
                                                        } else if (var17.eM > 0) {
                                                            var17.cI = 3;
                                                        } else {
                                                            var17.cI = 2;
                                                        }
                                                    }

                                                    if (var17.fW.size() > 0) {
                                                        var17.fX = true;
                                                        class_684 var170 = new class_684();
                                                        class_684 var171 = new class_684();
                                                        class_684 var85 = new class_684();
                                                        Iterator var86 = var17.fW.iterator();

                                                        while(var86.hasNext()) {
                                                            class_597 var87 = (class_597)var86.next();
                                                            if (var87.c == CheckRate.EVERY_FRAME) {
                                                                var170.add(var87);
                                                            } else if (var87.c == CheckRate.EVERY_4_FRAMES) {
                                                                var171.add(var87);
                                                            } else {
                                                                if (var87.c != CheckRate.EVERY_8_FRAMES) {
                                                                    throw new RuntimeException("Unknown check rate:" + var87.c);
                                                                }

                                                                var85.add(var87);
                                                            }
                                                        }

                                                        var17.fY = (class_597[])var170.toArray(new class_597[0]);
                                                        var17.fZ = (class_597[])var171.toArray(new class_597[0]);
                                                        var17.ga = (class_597[])var85.toArray(new class_597[0]);
                                                    }

                                                    Iterator var172;
                                                    if (var17.gp != null && var17.gp.size() > 0) {
                                                        var172 = var17.gp.iterator();

                                                        while(var172.hasNext()) {
                                                            class_598 var173 = (class_598)var172.next();
                                                            var173.a(var17);
                                                        }
                                                    }

                                                    if (var17.gb.a > 0) {
                                                        var172 = var17.gb.iterator();

                                                        while(var172.hasNext()) {
                                                            class_599 var174 = (class_599)var172.next();
                                                            var174.a(var17);
                                                        }

                                                        var17.gb.clear();
                                                    }

                                                    a(var94, class_437.UNIT_PARSE_PART_C);
                                                    var11.b();
                                                    var172 = var11.d.iterator();

                                                    String var176;
                                                    do {
                                                        if (!var172.hasNext()) {
                                                            var172 = var11.e.iterator();

                                                            do {
                                                                if (!var172.hasNext()) {
                                                                    if (var4 != null) {
                                                                        ++var4.E;
                                                                    }

                                                                    synchronized(class_591.c) {
                                                                        class_591.c.add(var17);
                                                                    }

                                                                    a(var94, class_437.UNIT_PARSE_PART_D);
                                                                    return var17;
                                                                }

                                                                String var177 = (String)var172.next();
                                                                var176 = "Skipping line, unexpected format: '" + var177 + "'";
                                                                var17.r(var176);
                                                            } while(var17.R < 1);

                                                            GameEngine.log("Converting warning to error (meta.strictLevel=" + var17.R + ")");
                                                            throw new CustomException(var176);
                                                        }

                                                        class_672 var175 = (class_672)var172.next();
                                                        if (var175.a() != null && (var175.a().startsWith("hiddenAction_") || var175.a().startsWith("canBuild_"))) {
                                                            throw new RuntimeException("Error [" + var175.a() + "]" + var175.b() + " has been repeated");
                                                        }

                                                        var176 = "Repeated key " + var175;
                                                        var17.r(var176);
                                                    } while(var17.R < 1);

                                                    GameEngine.log("Converting warning to error (meta.strictLevel=" + var17.R + ")");
                                                    throw new CustomException(var176);
                                                }

                                                var168 = (class_397)var166.next();
                                                if (var168.O != null && var168.O.a(var17.ev)) {
                                                    var168.O = null;
                                                }

                                                if (var168.P != null && var168.P.a(var17.ew)) {
                                                    var168.P = null;
                                                }
                                            } while(!var168.B);

                                            if (var168.O == null && var168.P == null) {
                                                var164 = true;
                                            } else {
                                                var165 = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (RuntimeException var91) {
            a((String)var0, (Exception)var91, (class_800)var4);
            return null;
        } catch (OutOfMemoryError var92) {
            ++l;
            a((String)var0, (Exception)(new RuntimeException(var92)), (class_800)var4);
            return null;
        } catch (CustomException var93) {
            a((String)var0, (Exception)var93, (class_800)var4);
            return null;
        }
    }

    public static void a(String var0, Exception var1, class_31 var2) {
        class_800 var3 = null;
        if (var2 instanceof class_591) {
            class_591 var4 = (class_591)var2;
            var3 = var4.J;
        }

        a(var0, var1, var3);
    }

    public static String a(class_800 var0, String var1, boolean var2) {
        if (var0 != null) {
            String var3 = var0.q;
            var3 = class_697.o(var3);
            var1 = class_697.o(var1);
            if (var1.startsWith(var3)) {
                var1 = var1.substring(var3.length());
                if (var1.startsWith("/")) {
                    var1 = var1.substring(1);
                }

                if (var1.startsWith("\\")) {
                    var1 = var1.substring(1);
                }
            }

            if (var2) {
                var1 = var1 + " (in mod " + var0.modName() + ")";
            }
        }

        return var1;
    }

    public static void a(String var0, Exception var1, class_800 var2) {
        GameEngine.print("Error while loading unit:" + var0);
        GameEngine.c((Throwable)var1);
        if (var0 == null) {
            var0 = "<null>";
        }

        String var3;
        if (var1 instanceof CustomException) {
            var3 = var1.getMessage();
        } else {
            var3 = class_340.b(var1);
        }

        if (var3 == null) {
            var3 = "<No error cause>";
        }

        if (!var3.contains("unit config file")) {
            var3 = var3.replace(var0 + ": ", "");
            var3 = var3.replace(var0, "");
        }

        var0 = a(var2, var0, true);
        String var4;
        if (var2 != null) {
            var4 = "Error loading unit: " + var0 + ": \n" + var3;
        } else if (var3.contains("Error loading core unit")) {
            var4 = var3;
        } else {
            var4 = "Error loading core unit: " + var0 + ": \n" + var3 + " (This might be from placing a mod in 'assets/', they should go under 'mods/')";
        }

        if (var1 instanceof CustomException) {
            CustomException var5 = (CustomException)var1;
            if (var5.c != null || var5.d != null) {
                var4 = var4 + " (section:" + var5.c + ", key:" + var5.d + ")";
            }
        }

        boolean var8 = false;
        if (var2 != null) {
            var8 = var2.f;
        }

        if (!var8) {
        }

        if (s != null) {
            s = var4;
        }

        if (var2 != null) {
            var2.a(var4);
        } else {
            try {
                Thread.sleep(2L);
            } catch (InterruptedException var7) {
            }

            throw new RuntimeException(var4, var1);
        }
    }

    public static void b(class_591 var0, UnitConfig var1, String var2, String var3, boolean var4) {
        String var5 = var1.getValueAsStaticString(var2, var3 + "name", (String)null);
        if (var5 != null) {
            String[] var6 = var5.split(",");
            String[] var7 = var6;
            int var8 = var6.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                String var10 = var7[var9];
                var10 = var10.trim();
                class_1037 var11 = new class_1037();
                var11.k = var10;
                var11.o = var1.getValueAsBoolean(var2, var3 + "extraLagHidingInUI", false);
                var11.p = var1.getValueAsFloatOrDefault(var2, var3 + "pos", 999.0F);
                var11.aJ = var1.getValueAsIntegerOrDefault(var2, var3 + "tech", 1);
                var11.aK = var1.getValueAsBoolean(var2, var3 + "forceNano", false);
                var11.aL = var1.getValueAsStaticString(var2, var3 + "type", (String)null);
                var11.q = class_447.a(var0, var1, var2, var3 + "price", (class_447)null);
                var11.aF = var1.a((class_591)var0, var2, (String)(var3 + "isGuiBlinking"), (LogicBoolean)null);
                var11.v = var1.a((class_591)var0, var2, (String)(var3 + "isVisible"), (LogicBoolean)null);
                var11.z = var1.a((class_591)var0, var2, (String)(var3 + "isLocked"), (LogicBoolean)null);
                var11.A = a(var0, var1, var2, var3 + "isLockedMessage", (String)null);
                if (var11.z != null) {
                    var11.y = true;
                }

                if (var11.z == LogicBoolean.falseBoolean) {
                    var11.z = null;
                }

                var11.B = var1.a((class_591)var0, var2, (String)(var3 + "isLockedAlt"), (LogicBoolean)null);
                var11.C = a(var0, var1, var2, var3 + "isLockedAltMessage", (String)null);
                if (var11.B != null) {
                    var11.y = true;
                }

                if (var11.B == LogicBoolean.falseBoolean) {
                    var11.B = null;
                }

                var11.D = var1.a((class_591)var0, var2, (String)(var3 + "isLockedAlt2"), (LogicBoolean)null);
                var11.E = a(var0, var1, var2, var3 + "isLockedAlt2Message", (String)null);
                if (var11.D != null) {
                    var11.y = true;
                }

                if (var11.D == LogicBoolean.falseBoolean) {
                    var11.D = null;
                }

                class_447 var12 = class_447.a(var0, var1, var2, var3 + "addResources", true);
                if (var12 != null && var12.d()) {
                    var11.ae = var12;
                }

                var11.aM = class_1032.build;
                if (!"NONE".equalsIgnoreCase(var10)) {
                    var0.gh.add(var11);
                }
            }

        }
    }

    @SneakyThrows
    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, String var4, boolean var5, boolean var6) {
        class_1037 var7 = new class_1037();
        String var8 = var1.getValueAsStaticString(var2, var3 + "convertTo", (String)null);
        String var9 = var1.getValueAsStaticString(var2, var3 + "whenBuilding_temporarilyConvertTo", (String)null);
        class_399[] var10 = class_398.a((UnitConfig)var1, (String)var2, var3 + "whenBuilding_temporarilyConvertTo_keepFields", (class_399[])null);
        Float var11 = var1.getValueAsFloatOrDefault(var2, var3 + "addEnergy", (Float)null);
        class_447 var12 = class_447.a(var0, var1, var2, var3 + "addResources", true);
        var0.a(var12);
        class_447 var13 = class_447.a(var0, var1, var2, var3 + "addResourcesScaledByAIHandicaps", true);
        var0.a(var13);
        String var14 = var1.getValueAsStaticString(var2, var3 + "fireTurretXAtGround", (String)null);
        LogicBoolean var15 = var1.b(var0, var2, var3 + "alsoTriggerOrQueueActionWithTarget", (LogicBoolean)null);
        LogicBoolean var16 = var1.a((class_591)var0, var2, (String)(var3 + "alsoTriggerOrQueueActionConditional"), (LogicBoolean)null);
        String var17 = var1.getValueAsStaticString(var2, var3 + "alsoTriggerAction", (String)null);
        LogicBoolean var18 = var1.c(var0, var2, var3 + "alsoTriggerActionRepeat", (LogicBoolean)null);
        Object var19 = null;
        String var20 = var1.getValueAsStaticString(var2, var3 + "alsoQueueAction", (String)null);
        String var21 = var1.getValueAsStaticString(var2, var3 + "spawnEffects", (String)null);
        String var22 = var1.getValueAsStaticString(var2, var3 + "spawnEffectsOnQueue", (String)null);
        String var23 = var1.getValueAsStaticString(var2, var3 + "playSoundAtUnit", (String)null);
        String var24 = var1.getValueAsStaticString(var2, var3 + "playSoundGlobally", (String)null);
        String var25 = var1.getValueAsStaticString(var2, var3 + "playSoundToPlayer", (String)null);
        String var26 = var1.getValueAsStaticString(var2, var3 + "playSoundToPlayerOnQueue", (String)null);
        class_789.a(var0, var1, var2, var3, var7, var4, var5);
        class_782.a(var0, var1, var2, var3, var7, var4, var5);
        class_777.a(var0, var1, var2, var3, var7, var4, var5);
        class_785.a(var0, var1, var2, var3, var7, var4, var5);
        class_780.a(var0, var1, var2, var3, var7, var4, var5);
        class_786.a(var0, var1, var2, var3, var7, var4, var5);
        class_781.a(var0, var1, var2, var3, var7, var4, var5);
        class_787.a(var0, var1, var2, var3, var7, var4, var5);
        class_784.a(var0, var1, var2, var3, var7, var4, var5);
        class_788.a(var0, var1, var2, var3, var7, var4, var5);
        class_783.a(var0, var1, var2, var3, var7, var4, var5);
        class_779.a(var0, var1, var2, var3, var7, var4, var5);
        class_778.a(var0, var1, var2, var3, var7, var4, var5);
        LogicBoolean var27 = var1.a((class_591)var0, var2, (String)(var3 + "resetCustomTimer"), (LogicBoolean)null);
        boolean var28 = false;
        if (var5) {
            var28 = true;
        } else {
            if (var8 != null || var9 != null || var11 != null || var14 != null) {
                var28 = true;
            }

            if (var12.d() || var13.d()) {
                var28 = true;
            }

            if (var17 != null || var20 != null || var21 != null || var19 != null) {
                var28 = true;
            }

            if (var23 != null || var24 != null || var25 != null || var26 != null) {
                var28 = true;
            }

            if (var7.ac.size() > 0) {
                var28 = true;
            }
        }

        if (var28) {
            if ("NONE".equalsIgnoreCase(var8)) {
                var8 = null;
            }

            if ("NONE".equalsIgnoreCase(var9)) {
                var9 = null;
            }

            if (var14 != null && var14.equalsIgnoreCase("NONE")) {
                var14 = null;
            }

            var7.a = var0.gh.size();
            String var29 = var1.getValueAsStaticString(var2, var3 + "id", (String)null);
            if (var29 != null) {
                var7.b = "c" + var29;
                if (var7.b.contains(" ")) {
                    throw new RuntimeException("[" + var2 + "]id cannot contain space");
                }

                if (var7.b.contains(",")) {
                    throw new RuntimeException("[" + var2 + "]id cannot contain ,");
                }

                if (var7.b.contains(":")) {
                    throw new RuntimeException("[" + var2 + "]id cannot contain :");
                }

                if (var7.b.contains("(")) {
                    throw new RuntimeException("[" + var2 + "]id cannot contain (");
                }

                if (var7.b.contains("\u0000")) {
                    throw new RuntimeException("[" + var2 + "]id cannot contain null");
                }

                if (var7.b.length() > 15) {
                    throw new RuntimeException("[" + var2 + "]id cannot be longer than 15 characters");
                }

                Iterator var30 = var0.gh.iterator();

                while(var30.hasNext()) {
                    class_1037 var31 = (class_1037)var30.next();
                    if (var7.b.equalsIgnoreCase(var31.b)) {
                        throw new RuntimeException("[" + var2 + "]id more than one action exists with id: " + var29);
                    }
                }
            }

            var7.c = var4;
            var7.o = var1.getValueAsBoolean(var2, var3 + "extraLagHidingInUI", false);
            var7.s = class_585.a(var1.getValueAsStaticString(var2, var3 + "tags", (String)null));
            var7.p = var1.getValueAsFloatOrDefault(var2, var3 + "pos", 999.0F);
            var7.q = class_447.a(var0, var1, var2, var3 + "price", true);
            var7.r = class_447.b(var0, var1, var2, var3 + "streamingCost", (class_447)null);
            boolean var49 = var1.getValueAsBoolean(var2, var3 + "switchPriceWithStreamingCost", false);
            if (var49) {
                if (var7.r != null) {
                    throw new RuntimeException("[" + var2 + "]streamingCost and switchPriceWithStreamingCost=true cannot be used at the same time");
                }

                var7.r = class_447.b(var0, var1, var2, var3 + "price", (class_447)null);
                var7.q = class_447.a;
            }

            var0.a(var7.q);
            if (var7.r != null) {
                var0.a(var7.r);
            }

            var7.K = var1.getValueAsBoolean(var2, var3 + "highPriorityQueue", false);
            var7.L = var1.getValueAsBoolean(var2, var3 + "onlyOneUnitAtATime", false);
            var7.M = var1.getValueAsBoolean(var2, var3 + "canPlayerCancel", true);
            var7.O = var1.getValueAsBoolean(var2, var3 + "alwaysSinglePress", false);
            var7.N = var1.getValueAsBoolean(var2, var3 + "allowMultipleInQueue", true);
            if (!var7.M && !var7.N && var7.O) {
                var7.P = true;
            }

            if (!var7.M) {
                var7.j = class_1052.none;
            } else {
                var7.j = class_1052.popupQueue;
            }

            var7.t = var1.a((class_591)var0, var2, (String)(var3 + "requireConditional"), (LogicBoolean)null);
            var7.u = var1.a((class_591)var0, var2, (String)(var3 + "isActive"), (LogicBoolean)null);
            var7.v = var1.a((class_591)var0, var2, (String)(var3 + "isVisible"), (LogicBoolean)null);
            var7.x = var1.getValueAsBoolean(var2, var3 + "isAlsoViewableByEnemies", false);
            var7.w = var1.getValueAsBoolean(var2, var3 + "isAlsoViewableByAllies", var7.x);
            if (var6) {
                if (var7.v != null && !LogicBoolean.isStaticFalse(var7.v)) {
                    throw new RuntimeException("[" + var2 + "]isVisible doesn't make sense to use in hidden actions");
                }

                var7.v = LogicBoolean.falseBoolean;
            }

            var7.z = var1.a((class_591)var0, var2, (String)(var3 + "isLocked"), (LogicBoolean)null);
            var7.A = a(var0, var1, var2, var3 + "isLockedMessage", (String)null);
            if (var7.z != null) {
                var7.y = true;
            }

            if (var7.z == LogicBoolean.falseBoolean) {
                var7.z = null;
            }

            var7.B = var1.a((class_591)var0, var2, (String)(var3 + "isLockedAlt"), (LogicBoolean)null);
            var7.C = a(var0, var1, var2, var3 + "isLockedAltMessage", (String)null);
            if (var7.B != null) {
                var7.y = true;
            }

            if (var7.B == LogicBoolean.falseBoolean) {
                var7.B = null;
            }

            var7.D = var1.a((class_591)var0, var2, (String)(var3 + "isLockedAlt2"), (LogicBoolean)null);
            var7.E = a(var0, var1, var2, var3 + "isLockedAlt2Message", (String)null);
            if (var7.D != null) {
                var7.y = true;
            }

            if (var7.D == LogicBoolean.falseBoolean) {
                var7.D = null;
            }

            var7.F = LogicBoolean.create(var0, var1.getValueAsStaticString(var2, var3 + "ai_isHighPriority", (String)null), (LogicBoolean)null);
            if (var7.F == LogicBoolean.falseBoolean) {
                var7.F = null;
            }

            if (var7.F != null) {
                var0.fJ = true;
            }

            var7.G = var1.a((class_591)var0, var2, (String)(var3 + "ai_isDisabled"), (LogicBoolean)LogicBoolean.falseBoolean);
            var7.aN = (AIUse)var1.a((String)var2, var3 + "aiUse", (Enum)var7.aN, (Class)AIUse.class);
            var7.J = var0.a(var1.getValueAsStaticString(var2, var3 + "guiBuildUnit", (String)null), var3 + "guiBuildUnit", var2);
            if (var7.J != null) {
                var7.j = class_1052.placeBuilding;
                if (var8 != null) {
                    throw new RuntimeException("[" + var2 + "]guiBuildUnit and convertTo cannot currently be used the same action");
                }
            }

            var7.I = var0.a(var1.getValueAsStaticString(var2, var3 + "ai_considerSameAsBuilding", (String)null), var3 + "ai_considerSameAsBuilding", var2);
            var7.aF = var1.a((class_591)var0, var2, (String)(var3 + "isGuiBlinking"), (LogicBoolean)null);
            var7.ay = a(var0.F, var1.getValueAsStaticString(var2, var3 + "iconImage", "NONE"), var0.ab, var0, var2, var3 + "iconImage");
            var7.aB = var1.a((class_591)var0, var2, (String)(var3 + "iconExtraIsVisible"), (LogicBoolean)null);
            if (var7.aB == LogicBoolean.trueBoolean) {
                var7.aB = null;
            }

            var7.az = var0.a(var1, var2, var3 + "iconExtraImage");
            var7.aA = var1.a(var2, var3 + "iconExtraColor", Color.a(100, 255, 255, 255));
            var7.aC = UnitReference.parseUnitTypeOrReferenceFromConf(var0, var1, var2, var3 + "unitShownInUI", (UnitReference$UnitReferenceOrUnitType)null);
            if (var7.aC != null && var7.ay != null) {
                throw new RuntimeException("[" + var2 + "]unitShownInUI and iconImage: doesn't make sense to use both at the same time");
            }

            var7.aD = var1.getValueAsBoolean(var2, var3 + "unitShownInUIWithHpBar", true);
            var7.aE = var1.getValueAsBoolean(var2, var3 + "unitShownInUIWithProgressBar", true);
            var7.aG = (DisplayType)var1.a((String)var2, var3 + "displayType", (Enum)var7.aG, (Class) DisplayType.class);
            var7.aI = var1.getValueAsBoolean(var2, var3 + "displayRemainingStockpile", false);
            var7.d = a(var0, var1, var2, var3 + "text", "");
            var7.e = UnitReference.parseUnitTypeOrReferenceFromConf(var0, var1, var2, var3 + "textAddUnitName", (UnitReference$UnitReferenceOrUnitType)null);
            var7.h = a((UnitConfig)var1, (String)var2, var3 + "textPostFix", (String)null);
            var7.f = UnitReference.parseUnitTypeOrReferenceFromConf(var0, var1, var2, var3 + "descriptionAddFromUnit", (UnitReference$UnitReferenceOrUnitType)null);
            var7.g = UnitReference.parseUnitTypeOrReferenceFromConf(var0, var1, var2, var3 + "descriptionAddUnitStats", (UnitReference$UnitReferenceOrUnitType)null);
            var7.i = a(var0, var1, var2, var3 + "description", "");
            var7.S = var1.d(var2, var3 + "buildSpeed", var7.S);
            if (var7.S == 0.0F) {
                var7.S = 50.0F;
            }

            var7.T = var1.getValueAsBoolean(var2, var3 + "buildSpeed_ignoreFactorySpeedModifiers", var7.T);
            boolean var50 = false;
            var7.U = var1.getValueAsBoolean(var2, var3 + "whenBuilding_cannotMove", var7.U);
            var7.V = var0.a(var1.getValueAsStaticString(var2, var3 + "whenBuilding_playAnimation", (String)null), var7.V);
            var7.W = var1.getValueAsFloatOrDefault(var2, var3 + "whenBuilding_rotateTo", var7.W);
            var7.X = var1.getValueAsBoolean(var2, var3 + "whenBuilding_rotateTo_orBackwards", var7.X);
            var7.Y = var1.getValueAsBoolean(var2, var3 + "whenBuilding_rotateTo_waitTillRotated", var7.Y);
            var7.Z = var1.getValueAsBoolean(var2, var3 + "whenBuilding_rotateTo_aimAtActionTarget", var7.Z);
            String var32 = var1.getValueAsStaticString(var2, var3 + "whenBuilding_rotateTo_rotateTurretX", (String)null);
            if (var32 != null) {
                var7.aa = var0.e(var32);
                if (var7.aa == null) {
                    throw new RuntimeException("Cannot find turret:" + var32 + " for [" + var2 + "]" + var3 + "whenBuilding_rotateTo_rotateTurretX");
                }

                if (var7.X) {
                    throw new RuntimeException("whenBuilding_rotateTo_orBackwards:true not supported with [" + var2 + "]" + var3 + "whenBuilding_rotateTo_rotateTurretX");
                }
            }

            if (var7.Z && var7.W == null) {
                var7.W = 0.0F;
            }

            var7.ab = var1.a((class_591)var0, var2, (String)(var3 + "whenBuilding_triggerAction"), (class_598)null);
            var7.Q = var1.getValueAsBoolean(var2, var3 + "convertTo_keepCurrentTags", var7.Q);
            var7.R = class_398.a((UnitConfig)var1, (String)var2, var3 + "convertTo_keepCurrentFields", (class_399[])null);
            if (var9 != null && !"NONE".equalsIgnoreCase(var9)) {
                var7.l = var0.a(var9, var3 + "whenBuilding_temporarilyConvertTo", var2);
                var7.m = var10;
                var50 = true;
            }

            if (var7.U || var7.V != null || var7.W != null || var7.l != null || var7.ab != null) {
                var0.bg = true;
            }

            var7.aM = class_1032.convert;
            if (var8 != null && !"NONE".equalsIgnoreCase(var8)) {
                var7.H = var0.a(var8, var3 + "convertTo", var2);
                var7.k = var8;
                var7.N = false;
                var50 = true;
            }

            if (var11 != null) {
                var7.ad = var11;
                var50 = true;
            }

            if (var12 != null && var12.d()) {
                var7.ae = var12;
                var50 = true;
            }

            if (var13 != null && var13.d()) {
                var7.af = var13;
                var50 = true;
            }

            var7.ah = var1.getValueAsPointFOrDefault(var2, var3 + "fireTurretXAtGround_withOffset", (PointF)null);
            var7.ai = var1.b(var0, var2, var3 + "fireTurretXAtGround_withTarget", (LogicBoolean)null);
            var7.ak = var1.getValueAsIntegerOrDefault(var2, var3 + "fireTurretXAtGround_count", 1);
            var7.am = class_828.a(var0, var1.getValueAsStaticString(var2, "fireTurretXAtGround_showGuideDecals", (String)null));
            if (var7.ai != null && var7.ah == null) {
                var7.ah = new PointF(0.0F, 0.0F);
            }

            String var33 = var1.getValueAsStaticString(var2, var3 + "fireTurretXAtGround_withProjectile", (String)null);
            if (var33 != null) {
                var7.aj = var0.f(var33);
                if (var7.aj == null) {
                    throw new RuntimeException("Cannot find projectile:" + var33 + " for [" + var2 + "]" + var3 + "fireTurretXAtGround_withProjectile");
                }
            }

            String var34 = var1.getValueAsStaticString(var2, var3 + "fireTurretXAtGround_onlyOverPassableTileOf", (String)null);
            if (var34 != null) {
                var7.al = MovementType.a(var34, var3 + "fireTurretXAtGround_overPassableTileOf");
            }

            if (var14 != null) {
                class_397 var35 = var0.e(var14);
                if (var35 == null) {
                    throw new RuntimeException("Cannot find turret:" + var14 + " for [" + var2 + "]" + var3 + "fireTurretXAtGround");
                }

                var7.ag = var35.e;
                if (var7.ah == null) {
                    var7.j = class_1052.targetGround;
                    if (var7.J != null) {
                        throw new RuntimeException("[" + var2 + "]guiBuildUnit and fireTurretXAtGround (without withOffset) cannot be used in the same action");
                    }
                }

                var50 = true;
            }

            var7.an = var15;
            var7.ao = var16;
            if (var17 != null && !"NONE".equalsIgnoreCase(var17)) {
                var7.ap = var0.c(var17, "alsoTriggerAction", var2);
                if (var18 != null) {
                    if (LogicBoolean.isStaticNumber(var18)) {
                        float var51 = LogicBoolean.getKnownStaticNumber(var18);
                        if (var51 == 0.0F) {
                            var7.ap = null;
                        } else if (var51 != 1.0F) {
                            var7.ar = var18;
                        }
                    } else {
                        var7.ar = var18;
                    }
                }

                var50 = true;
            }

            if (var20 != null && !"NONE".equalsIgnoreCase(var20)) {
                var7.aq = var0.c(var20, "alsoQueueAction", var2);
                var50 = true;
            }

            if (var21 != null) {
                var7.as = var0.a((String)var21, (class_605)null);
                var50 = true;
            }

            if (var22 != null) {
                var7.at = var0.a((String)var22, (class_605)null);
                var50 = true;
            }

            if (var23 != null) {
                var7.au = class_392.a(var0, var23);
                var50 = true;
            }

            if (var24 != null) {
                var7.av = class_392.a(var0, var24);
                var50 = true;
            }

            if (var25 != null) {
                var7.aw = class_392.a(var0, var25);
                var50 = true;
            }

            if (var26 != null) {
                var7.ax = class_392.a(var0, var26);
                var50 = true;
            }

            if (var27 != null) {
                var7.aH = var27;
                var50 = true;
            }

            if (var7.ac.size() > 0) {
                var50 = true;
            }

            ArrayList var52 = null;
            String var36 = var1.getValueAsStaticString(var2, var3 + "autoTriggerOnEvent", (String)null);
            Integer var37 = var1.getValueAsIntegerOrDefault(var2, var3 + "autoTriggerOnEventRecursionLimit", (Integer)null);
            if (var37 != null) {
                if (var37 < 0) {
                    throw new CustomException("[" + var2 + "]" + var3 + "autoTriggerOnEventRecursionLimit: Cannot be < 0");
                }

                if (var37 > 50) {
                    throw new CustomException("[" + var2 + "]" + var3 + "autoTriggerOnEventRecursionLimit: Cannot be > 100");
                }
            }

            Iterator var43;
            if (var36 != null) {
                ArrayList var38 = a(var2, var3 + "autoTriggerOnEvent", var36);
                if (var38 != null) {
                    if (var38.size() < 1) {
                        throw new CustomException("[" + var2 + "]" + var3 + "autoTriggerOnEvent: Expected 1 or more options, got:" + var38.size());
                    }

                    class_438 var42;
                    for(Iterator var39 = var38.iterator(); var39.hasNext(); var52.add(var42)) {
                        class_440 var40 = (class_440)var39.next();

                        GameEvent var41;
                        try {
                            var41 = (GameEvent)UnitConfig.convertStringToEnumOrDefault(var40.a, (Enum)null, GameEvent.class);
                        } catch (Exception var48) {
                            throw new CustomException("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var48.getMessage(), var48);
                        }

                        if (var52 == null) {
                            var52 = new ArrayList();
                        }

                        var42 = new class_438();
                        var42.a = var41;
                        if (var37 != null) {
                            var42.e = var37;
                        } else if (var42.a == GameEvent.newMessage) {
                            var42.e = 4;
                        }

                        String var47;
                        if (var40.b != null) {
                            for(var43 = var40.b.keySet().iterator(); var43.hasNext(); var42.d = UnitConfig.j(var2, var3 + "autoTriggerOnEvent", var47)) {
                                String var44 = (String)var43.next();
                                String var45 = (String)var40.b.get(var44);
                                boolean var46 = false;
                                if (var44.equalsIgnoreCase("withtag")) {
                                    if (var42.a != GameEvent.tookDamage && var42.a != GameEvent.newMessage) {
                                        throw new CustomException("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var42.a.name() + " doesn't support parameter: " + var44);
                                    }

                                    var46 = true;
                                }

                                if (var44.equalsIgnoreCase("withprojectiletag")) {
                                    if (var42.a != GameEvent.tookDamage) {
                                        throw new CustomException("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var42.a.name() + " doesn't support parameter: " + var44);
                                    }

                                    var46 = true;
                                }

                                if (var44.equalsIgnoreCase("withactiontag")) {
                                    if (var42.a != GameEvent.queueItemAdded && var42.a != GameEvent.queueItemCancelled) {
                                        throw new CustomException("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var42.a.name() + " doesn't support parameter: " + var44);
                                    }

                                    var46 = true;
                                }

                                if (!var46) {
                                    throw new CustomException("[" + var2 + "]" + var3 + "autoTriggerOnEvent: Unknown parameter: " + var44);
                                }

                                var47 = class_340.p(var45);
                                if (var47 == null) {
                                    throw new CustomException("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var42.a.name() + " expected quoted string, got: " + var45);
                                }

                                if (var42.d != null) {
                                    throw new CustomException("[" + var2 + "]" + var3 + "autoTriggerOnEvent: " + var42.a.name() + " tag was set twice");
                                }
                            }
                        }
                    }
                }
            }

            LogicBoolean var53 = var1.a((class_591)var0, var2, (String)(var3 + "autoTrigger"), (LogicBoolean)null);
            String var54 = var1.getValueAsStaticString(var2, var3 + "autoTrigger", (String)null);
            CheckRate var55 = (CheckRate)var1.a((String)var2, var3 + "autoTriggerCheckRate", (Enum)var0.cb, (Class)CheckRate.class);
            var7.n = var50;
            if (var50 || var7.v != null) {
                if (var53 != null && var50) {
                    class_597 var56 = new class_597();
                    var56.a = var53;
                    var56.b = var54;
                    var56.c = var55;
                    var56.d = new class_283(var7, var0.a(var7.k, "[" + var2 + "]" + var3, var2));
                    var0.fW.add(var56);
                }

                if (var52 != null && var50) {
                    class_283 var57 = new class_283(var7, var0.a(var7.k, "[" + var2 + "]" + var3, var2));
                    class_591 var58 = var0;
                    var43 = var52.iterator();

                    while(var43.hasNext()) {
                        class_438 var59 = (class_438)var43.next();
                        var59.b = var57;
                        var59.c = var58;
                        var0.gq.add(var59);
                    }
                }

                if (var7.k != null && var7.q != null && var7.q.b > 0) {
                    var0.gi = true;
                }

                var0.gh.add(var7);
            }
        }

    }

    public static String a(class_591 var0, String var1, String var2) {
        if (var2.startsWith("SHARED:")) {
            var2 = var2.substring("SHARED:".length());
            var1 = "units/shared/common.ini";
        }

        if (var2.startsWith("CORE:")) {
            var2 = var2.substring("CORE:".length());
            var1 = "units/common.ini";
        }

        if (var2.startsWith("ROOT:")) {
            var2 = var2.substring("ROOT:".length());
            if (var0.J == null) {
                var1 = "units/common.ini";
            } else {
                var1 = var0.J.q + "/common.ini";
            }
        }

        String var3;
        for(var3 = class_340.getDirctory(var1) + "/"; var2.startsWith("/") || var2.startsWith("\\"); var2 = var2.substring(1)) {
        }

        String var4 = var3 + var2;
        return var4;
    }

    public static void a(long var0, class_437 var2) {
        double var3 = (double) com.corrodinggames.rts.gameFramework.Unit.a(var0);
        var2.o += var3;
    }

    public static void i() {
        GameEngine.log("==Timing==");
        class_437[] var0 = class_437.values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            class_437 var3 = var0[var2];
            GameEngine.log(var3.name() + ": " + com.corrodinggames.rts.gameFramework.Unit.a(var3.o));
        }

    }

    public static void j() {
        class_437[] var0 = class_437.values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            class_437 var3 = var0[var2];
            var3.o = 0.0;
        }

    }

    public static TeamImageCache a(String var0, String var1, boolean var2, class_591 var3, String var4, String var5) {
        try {
            return a(var0, var1, var2, var3);
        } catch (RuntimeException var7) {
            var7.printStackTrace();
            throw new RuntimeException("[" + var4 + "]" + var5 + ": " + var7.getMessage(), var7);
        }
    }

    public static TeamImageCache a(String var0, String var1, boolean var2, class_591 var3) {
        long var4 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
        TeamImageCache var6 = b(var0, var1, var2, var3);
        a(var4, class_437.IMAGE_LOAD_OR_GET);
        return var6;
    }

    public static TeamImageCache b(String var0, String var1, boolean var2, class_591 var3) {
        if (var1 == null) {
            return null;
        } else if (var1.equalsIgnoreCase("NONE")) {
            return null;
        } else if (var1.equals("")) {
            return null;
        } else {
            boolean var4 = false;
            if (var1.startsWith("SHADOW:")) {
                var1 = var1.substring("SHADOW:".length());
                var4 = true;
            }

            if (var1.startsWith("SHARED:")) {
                var1 = var1.substring("SHARED:".length());
                var0 = "units/shared/common.ini";
            }

            if (var1.startsWith("CORE:")) {
                var1 = var1.substring("CORE:".length());
                var0 = "units/common.ini";
            }

            if (var1.startsWith("ROOT:")) {
                var1 = var1.substring("ROOT:".length());
                if (var3.J == null) {
                    var0 = "units/common.ini";
                } else {
                    var0 = var3.J.q + "/common.ini";
                }
            }

            if (var1.startsWith("SHADOW:")) {
                var1 = var1.substring("SHADOW:".length());
                var4 = true;
            }

            GameEngine var5 = GameEngine.getGameEngine();
            String var7 = class_340.getDirctory(var0) + "/";
            String var8 = "[" + var2 + "," + var4 + "]" + var7 + var1;
            TeamImageCache var9 = c(var8);
            if (var9 != null) {
                return var9;
            } else {
                AssetInputStream var6 = c(var7, var1, var3);
                int var11 = 0;
                if (e != null) {
                    var11 = e.I;
                }

                TeamImageCache var10;
                if (var11 > 5) {
                    GameEngine.log("Fast failing to oom image for this mod");
                    var10 = var5.bO.r();
                } else {
                    long var12 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();

                    try {
                        var10 = var5.bO.a(var6, true);
                    } catch (RuntimeException var16) {
                        GameEngine.log("imageStream:" + var6);
                        throw new RuntimeException("Error decode image from: " + class_697.d(var7 + var1), var16);
                    }

                    a(var12, class_437.IMAGE_LOAD);
                    if (var10.A()) {
                        GameEngine.log("oomErrors:" + l);
                        ++l;
                        if (e != null) {
                            ++e.I;
                            ++e.J;
                        }
                    } else if (e != null && !e.z && GameEngine.aZ) {
                        var10.z();
                    }
                }

                try {
                    var6.close();
                } catch (Exception var15) {
                    var15.printStackTrace();
                }

                if (var10 == null) {
                    throw new RuntimeException("Failed to decode image: " + class_697.e(var7 + var1));
                } else {
                    var10.a(var2);
                    if (var4) {
                        var10 = Unit.a(var10, var10.p, var10.q);
                    }

                    a(var10);
                    a(var8, var10);
                    return var10;
                }
            }
        }
    }

    public static void a(String var0, TeamImageCache var1) {
        g.put(var0, var1);
    }

    public static TeamImageCache c(String var0) {
        TeamImageCache var1 = (TeamImageCache)g.get(var0);
        if (var1 != null) {
            ++j;
            a(var1);
            var1.t();
            return var1;
        } else {
            if (k) {
                GameEngine.log("loadImageInConf: cache miss: " + var0);
            }

            ++i;
            return null;
        }
    }

    public static class_355 a(String var0, String var1, class_591 var2) {
        long var3 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
        class_355 var5 = b(var0, var1, var2);
        a(var3, class_437.SOUND_LOAD_OR_GET);
        return var5;
    }

    public static class_355 b(String var0, String var1, class_591 var2) {
        if (var1 == null) {
            return null;
        } else if (var1.equalsIgnoreCase("NONE")) {
            return null;
        } else {
            GameEngine var3 = GameEngine.getGameEngine();
            if (!var1.contains(".")) {
                class_355 var15 = var3.bM.a(var1);
                return var15;
            } else {
                if (var1.startsWith("ROOT:")) {
                    var1 = var1.substring("ROOT:".length());
                    if (var2.J == null) {
                        var0 = "units/common.ini";
                    } else {
                        var0 = var2.J.q + "/common.ini";
                    }
                }

                if (var1.startsWith("CORE:")) {
                    var1 = var1.substring("CORE:".length());
                    var0 = "units/common.ini";
                }

                if (var1.startsWith("SHARED:")) {
                    var1 = var1.substring("SHARED:".length());
                    var0 = "units/shared/common.ini";
                }

                boolean var4 = false;
                String var5 = class_340.getDirctory(var0) + "/";
                String var6 = var5 + var1;
                class_355 var7 = (class_355)h.get(var6);
                if (var7 != null) {
                    a(var7);
                    return var7;
                } else if (!var1.toLowerCase(Locale.ROOT).endsWith(".ogg") && !var1.toLowerCase(Locale.ROOT).endsWith(".wav")) {
                    throw new RuntimeException("Failed to open sound: " + var5 + "" + var1 + " only the ogg & wav sound formats are supported.");
                } else {
                    AssetInputStream var8 = c(var5, var1, var2);
                    long var9 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                    class_355 var11 = var3.bM.a(var1, var8, var4);

                    try {
                        var8.close();
                    } catch (Exception var14) {
                        var14.printStackTrace();
                    }

                    a(var9, class_437.SOUND_LOAD);
                    if (var11 == null) {
                        boolean var12 = var1.toLowerCase(Locale.ROOT).endsWith(".ogg");
                        String var13 = "Sound file found but failed to load: " + var6;
                        if (var12) {
                            var13 = var13 + " - Check if this file is truly a ogg";
                        }

                        var2.r(var13);
                        return var3.bM.b("Failed to load");
                    } else {
                        a(var11);
                        h.put(var6, var11);
                        return var11;
                    }
                }
            }
        }
    }

    @SneakyThrows
    public static boolean a(String var0, String var1, String var2, class_800 var3) {
        if (var1 == null) {
            return true;
        } else if (!var1.contains("..")) {
            return true;
        } else if (GameEngine.at()) {
            return true;
        } else {
            File var4 = new File(class_697.e(var2));
            String var5 = var4.getCanonicalPath();
            String var6 = (new File(class_697.e("units"))).getCanonicalPath();
            if (var5.startsWith(var6)) {
                return true;
            } else {
                String var7 = var3.k();
                boolean var8 = var5.startsWith(var7);
                if (!var8) {
                    GameEngine.print("File: '" + var5 + "' is not within mod: '" + var7 + "'");
                }

                return var8;
            }
        }
    }

    public static String a(String var0, String var1) {
        if (!var0.endsWith("/")) {
            var0 = var0 + "/";
        }

        while(var1.startsWith("/") || var1.startsWith("\\")) {
            var1 = var1.substring(1);
        }

        return var0 + var1;
    }

    public static AssetInputStream c(String var0, String var1, class_591 var2) {
        String var3 = a(var0, var1);
        class_800 var4 = null;
        if (var2 != null) {
            var4 = var2.J;
        } else {
            GameEngine.warn("findAssetSteam meta==null");
        }

        try {
            if (var4 != null && !a(var0, var1, var3, var4)) {
                throw new RuntimeException("File is outside mod: " + var3);
            }
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }

        AssetInputStream var5 = class_697.k(var3);
        if (var5 == null) {
            GameEngine.log("Orginal path: " + var3);
            throw new RuntimeException("IO Error: Failed to open: " + a(var4, var3, true));
        } else {
            return var5;
        }
    }

    public static void b(class_591 var0) {
        class_431[] var1 = var0.ax;

        for(int var2 = 0; var2 < var1.length; ++var2) {
            class_431 var3 = var1[var2];
            float var4 = -1.0F;
            class_431 var5 = null;
            float var6 = 1.0F;
            if (var3.o) {
                var6 = 0.1F;
            }

            for(int var7 = 0; var7 < var1.length; ++var7) {
                class_431 var8 = var1[var7];
                if (var3 != var8 && !var8.l) {
                    float var9 = class_340.a(var3.d * var6, var3.e, var8.d * var6, var8.e);
                    if (var5 == null || var9 < var4) {
                        var4 = var9;
                        var5 = var8;
                    }
                }
            }

            var4 = class_340.a(var4) + 2.0F;
            var4 *= var4;
            ArrayList var11 = new ArrayList();

            int var12;
            for(var12 = 0; var12 < var1.length; ++var12) {
                class_431 var13 = var1[var12];
                if (var3 != var13 && !var13.l) {
                    float var10 = class_340.a(var3.d * var6, var3.e, var13.d * var6, var13.e);
                    if (var10 <= var4) {
                        var11.add(var13.a);
                    }
                }
            }

            var3.S = new int[var11.size()];

            for(var12 = 0; var12 < var11.size(); ++var12) {
                var3.S[var12] = (Integer)var11.get(var12);
            }
        }

    }

    public static String k() {
        return "builtin_mods";
    }

    public static String l() {
        return "builtin_mods_enabled";
    }

    public static String m() {
        String var0;
        if (GameEngine.isModsInSD) {
            var0 = "/SD/mods/units";
        } else {
            var0 = "/SD/rustedWarfare/units";
        }

        return var0;
    }

    @SneakyThrows
    public static ArrayList a(String var0, String var1, String var2) {
        if (var2 != null && !"".equals(var2) && !"NONE".equalsIgnoreCase(var2)) {
            ArrayList var3 = new ArrayList();
            ArrayList var4 = class_675.a(var2, ",", false);
            Iterator var5 = var4.iterator();

            while(true) {
                String var6;
                do {
                    if (!var5.hasNext()) {
                        return var3;
                    }

                    var6 = (String)var5.next();
                    var6 = var6.trim();
                } while("".equals(var6));

                String var7 = var6;
                String var8 = null;
                if (var6.contains("(") && var6.contains(")")) {
                    String[] var9 = class_675.b(var6, "(");
                    if (var9 == null) {
                        throw new CustomException("[" + var0 + "]" + var1 + ": Unexpected format for '" + var6 + "' of " + var2);
                    }

                    var6 = var9[0];
                    var8 = var9[1].trim();
                }

                class_440 var16 = new class_440();
                var16.a = var6;
                if (var8 != null) {
                    if (!var8.endsWith(")")) {
                        throw new CustomException("[" + var0 + "]" + var1 + ": Expected ')' in '" + var7 + "' of " + var2);
                    }

                    var8 = var8.substring(0, var8.length() - 1);
                    ArrayList var10 = class_675.a(var8, ",", false, false);
                    Iterator var11 = var10.iterator();

                    while(var11.hasNext()) {
                        String var12 = (String)var11.next();
                        if (!var12.trim().equals("")) {
                            String[] var13 = class_675.b(var12, "=");
                            if (var13 == null) {
                                throw new RuntimeException("[" + var0 + "]" + var1 + ": Unexpected key format for '" + var7 + "' of " + var2);
                            }

                            String var14 = var13[0].trim();
                            String var15 = var13[1].trim();
                            if (var16.b == null) {
                                var16.b = new HashMap();
                            }

                            var16.b.put(var14, var15);
                        }
                    }
                }

                var3.add(var16);
            }
        } else {
            return null;
        }
    }
}
