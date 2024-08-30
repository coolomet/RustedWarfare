package com.corrodinggames.rts.game.units;

import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.PointF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_231;
import com.corrodinggames.rts.game.units.a.class_241;
import com.corrodinggames.rts.game.units.a.class_661;
import com.corrodinggames.rts.game.units.custom.class_436;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.buildings.NukeLaucher;
import com.corrodinggames.rts.game.units.buildings.class_8;
import com.corrodinggames.rts.game.units.land.class_120;
import com.corrodinggames.rts.game.units.land.Builder;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.i.class_800;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.h
public strictfp class EditorOrBuilder extends class_120 implements class_26 {
    PointF[] a = new PointF[6];
    PointF[] b;
    boolean c;
    static Paint d;
    static Paint e;
    static Paint f;
    static TeamImageCache g;
    static class_226 h = new class_252("reloadUnits");
    static class_226 i = new class_236("reloadOnlyActiveUnits");
    static class_226 j = new class_244("unitClone");
    static class_226 k = new class_245("removeUnits");
    static class_226 l = new class_246("killUnits");
    static class_226 m = new class_247("finishQueue");
    static class_226 n = new class_248("nukeAt");
    static class_226 o = new class_260("freezeAI");
    static class_226 p = new class_261("changeAlliance");
    static class_226 q = new class_273("startRecording");
    String r;
    static class_226 s = new class_274("startReplayPlayback");
    static class_226 t = new class_275("hideInterface");
    static class_226 u = new class_276("freezeAllAI");
    static class_226 v = new class_277("pauseGame");
    static class_226 w = new class_278("slowGame");
    static class_226 x = new class_279("fastForward");
    static class_226 y = new class_280("search");
    static class_226 z = new class_256("enableDebug");
    static class_226 A = new class_257("enableAIDebug");
    static class_226 B = new class_258("enableTriggerDebug");
    static class_226 C = new class_259("clearSaveHistory");
    static ArrayList D;
    class_800 E;
    class_819 F;
    class_812 G;
    String H;
    boolean I;
    String J;
    static class_661 K = new class_662();

    public strictfp UnitType f() {
        return UnitType.editorOrBuilder;
    }

    public static strictfp boolean w() {
        GameEngine var0 = GameEngine.getGameEngine();
        return var0.replayEngine.i();
    }

    public strictfp PointF[] b() {
        return this.a;
    }

    public strictfp PointF[] e_() {
        return this.b;
    }

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : dN[this.bX.R()];
    }

    public static strictfp void K() {
        GameEngine var0 = GameEngine.getGameEngine();
        g = var0.bO.a(AssetsID$drawable.icon_search);
    }

    public strictfp boolean a(Unit var1) {
        return true;
    }

    public strictfp TeamImageCache d() {
        return this.bV ? Builder.b : Builder.d[this.bX.R()];
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public strictfp TeamImageCache d(int var1) {
        return null;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bR.b(this.xCord, this.yCord, this.zCord);
        this.M = Builder.b;
        this.S(0);
        this.bT = false;
        var1.bM.a(class_648.o, 0.8F, this.xCord, this.yCord);
        this.bq();
        return true;
    }

    public EditorOrBuilder(boolean var1) {
        super(var1);
        this.b = new PointF[this.a.length];
        d = new Paint();
        d.a(40, 0, 255, 0);
        d.a(true);
        d.a(2.0F);
        d.a(Paint$Cap.b);
        e = new Paint();
        e.a(d);
        e.a(55, 255, 60, 60);
        f = new Paint();
        f.a(60, 255, 255, 255);
        this.E = null;
        this.F = class_819.a;
        this.G = class_812.a;
        this.I = true;
        this.T(20);
        this.U(20);
        this.cj = 10.0F;
        this.xCord = -1000.0F;
        this.yCord = -1000.0F;
        this.ck = this.cj;
        this.totalHealth = 170000.0F;
        this.health = this.totalHealth;
        this.M = Builder.b;

        for(int var2 = 0; var2 < this.a.length; ++var2) {
            this.a[var2] = new PointF();
            this.b[var2] = new PointF();
        }

    }

    public static strictfp void a(float var0, class_26 var1) {
        OrderableUnit var2 = (OrderableUnit)var1;
        PointF[] var3 = var1.b();
        PointF[] var4 = var1.e_();
        Unit var5 = var2.X();
        var2.aN = var5 != null;
        int var6;
        PointF var7;
        PointF var8;
        if (var5 != null) {
            for(var6 = 0; var6 < var3.length; ++var6) {
                var7 = var3[var6];
                var8 = var4[var6];
                var7.x = class_340.a(var7.x, var8.x, 0.1F * var0);
                var7.y = class_340.a(var7.y, var8.y, 0.1F * var0);
                var7.x += (var8.x - var7.x) * 0.04F * var0;
                var7.y += (var8.y - var7.y) * 0.04F * var0;
                float var9 = var5.cj * 0.75F;
                if (class_340.c(var7.x - var8.x) < 1.0F) {
                    var8.x = class_340.d(-var9, var9);
                }

                if (class_340.c(var7.y - var8.y) < 1.0F) {
                    var8.y = class_340.d(-var9, var9);
                }
            }
        } else if (var3[0].x != 0.0F || var3[0].y != 0.0F) {
            for(var6 = 0; var6 < var3.length; ++var6) {
                var7 = var3[var6];
                var8 = var4[var6];
                var7.x = 0.0F;
                var7.y = 0.0F;
                var8.x = 0.0F;
                var8.y = 0.0F;
            }
        }

    }

    public strictfp void a(float var1) {
        if (var1 < 0.3F) {
            var1 = 0.3F;
        }

        if (this.ax && this.bX.b()) {
            for(int var2 = 0; var2 < PlayerData.c; ++var2) {
                PlayerData var3 = PlayerData.getPlayerData(var2);
                if (var3 != null && !var3.b()) {
                    this.e(var3);
                    break;
                }
            }
        }

        super.a(var1);
        if (!this.bV) {
            a(var1, this);
        }

        this.health = this.totalHealth;
    }

    public strictfp void a(float var1, boolean var2) {
        if (!this.bV) {
        }

    }

    public strictfp float e(int var1) {
        return 0.0F;
    }

    public strictfp float f(int var1) {
        return 0.0F;
    }

    public strictfp boolean c(float var1) {
        if (!super.c(var1)) {
            return false;
        } else {
            GameEngine var2 = GameEngine.getGameEngine();
            return true;
        }
    }

    public strictfp void a(Unit var1, int var2) {
    }

    public strictfp boolean b_() {
        return false;
    }

    public strictfp int y() {
        return 850000;
    }

    public strictfp float b(Unit var1) {
        return 1.0E7F;
    }

    public strictfp float c(Unit var1) {
        return 1.0E7F;
    }

    public strictfp float attackRange() {
        return 30.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 100.0F;
    }

    public strictfp float speed() {
        return 0.0F;
    }

    public strictfp float turnSpeed() {
        return 9.8F;
    }

    public strictfp float B() {
        return 9.35F;
    }

    public strictfp float c(int var1) {
        return 99.0F;
    }

    public strictfp boolean l() {
        return false;
    }

    public strictfp float C() {
        return 0.04F;
    }

    public strictfp float D() {
        return 0.1F;
    }

    public strictfp void a(class_226 var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        boolean var5;
        if (var1 instanceof class_267) {
            class_267 var4 = (class_267)var1;
            var5 = true;
            if (var2) {
                var5 = !var5;
            }

            if (var4.a) {
                var5 = !var5;
            }

            int var7;
            PlayerData var8;
            if (var5) {
                Object var6 = null;

                for(var7 = this.bX.site + 1; var7 < PlayerData.c; ++var7) {
                    var8 = PlayerData.getPlayerData(var7);
                    if (var8 != null && !var8.b()) {
                        var6 = var8;
                        break;
                    }
                }

                if (var6 == null && this.bX.site < 4) {
                    var6 = PlayerData.getPlayerData(this.bX.site + 1);
                    if (var6 == null) {
                        GameEngine.log("Sandbox adding new team:" + this.bX.site);
                        class_138 var14 = new class_138(this.bX.site + 1);
                        var6 = var14;
                        var14.team = 1;
                        var14.F = true;
                        var14.G = true;
                        if (!this.c) {
                            var14.bG = 0.0F;
                        } else {
                            var14.bG = Float.MAX_VALUE;
                        }
                    }
                }

                if (var6 == null) {
                    for(var7 = 0; var7 < PlayerData.c; ++var7) {
                        var8 = PlayerData.getPlayerData(var7);
                        if (var8 != null && !var8.b()) {
                            var6 = var8;
                            break;
                        }
                    }
                }

                if (var6 != null) {
                    this.e((PlayerData)var6);
                    if (!var3.replayEngine.j()) {
                        var3.playerTeam = (PlayerData)var6;
                    }
                }
            } else {
                PlayerData var15 = null;

                for(var7 = this.bX.site - 1; var7 >= 0; --var7) {
                    var8 = PlayerData.getPlayerData(var7);
                    if (var8 != null && !var8.b()) {
                        var15 = var8;
                        break;
                    }
                }

                if (var15 == null) {
                    for(var7 = PlayerData.c - 1; var7 >= 0; --var7) {
                        var8 = PlayerData.getPlayerData(var7);
                        if (var8 != null && !var8.b()) {
                            var15 = var8;
                            break;
                        }
                    }
                }

                if (var15 != null) {
                    this.e(var15);
                    if (!var3.replayEngine.j()) {
                        var3.playerTeam = var15;
                    }
                }
            }
        }

        if (var1 instanceof class_268) {
            class_268 var12 = (class_268)var1;
            var5 = true;
            if (var2) {
                var5 = !var5;
            }

            if (var12.a) {
                var5 = !var5;
            }

            ArrayList var19 = var3.bZ.j();
            if (var19.size() == 0) {
                this.E = null;
            } else {
                boolean var17;
                class_800 var18;
                if (var5) {
                    if (this.E == null) {
                        this.E = (class_800)var19.get(0);
                    } else {
                        var18 = null;
                        var17 = false;
                        Iterator var9 = var19.iterator();

                        while(var9.hasNext()) {
                            class_800 var10 = (class_800)var9.next();
                            if (var17) {
                                var18 = var10;
                                break;
                            }

                            if (var10 == this.E) {
                                var17 = true;
                            }
                        }

                        this.E = var18;
                    }
                } else if (this.E == null) {
                    this.E = (class_800)var19.get(var19.size() - 1);
                } else {
                    var18 = null;
                    var17 = false;
                    ArrayList var16 = new ArrayList();
                    var16.addAll(var19);
                    Collections.reverse(var16);
                    Iterator var20 = var16.iterator();

                    while(var20.hasNext()) {
                        class_800 var11 = (class_800)var20.next();
                        if (var17) {
                            var18 = var11;
                            break;
                        }

                        if (var11 == this.E) {
                            var17 = true;
                        }
                    }

                    this.E = var18;
                }
            }
        }

        if (var1 instanceof class_266) {
            class_266 var13 = (class_266)var1;
            var5 = true;
            if (var2) {
                var5 = !var5;
            }

            if (var13.a) {
                var5 = !var5;
            }

            this.F = this.F.a(!var5);
        }

        if (var1 instanceof class_264) {
            this.bX.d(10000.0F);
        }

        if (var1 instanceof class_265) {
            ((class_265)var1).n();
        }

    }

    static strictfp EditorOrBuilder L() {
        GameEngine var0 = GameEngine.getGameEngine();
        return var0.bS.i();
    }

    public strictfp void a(class_226 var1, boolean var2, PointF var3, Unit var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        if (var1 instanceof class_231) {
            var1 = ((class_231)var1).q_();
        }

        Iterator var6;
        PlayerData var7;
        if (var1 == h) {
            if (w()) {
                GameEngine.print("Not reloading units: Need to keep network sync");
                var5.bS.b("Not reloading units: Need to keep network sync");
                return;
            }

            if (var2) {
                return;
            }

            if (var5.bZ.h() == 0) {
                var5.bS.b("No custom units to reload");
                return;
            }

            GameEngine.log("Reload units requested");
            var5.bZ.a(true, false);
            var6 = PlayerData.c().iterator();

            while(var6.hasNext()) {
                var7 = (PlayerData)var6.next();
                if (var7 instanceof class_138) {
                    ((class_138)var7).al();
                }
            }

            var5.bS.b("All custom unit files reloaded");
        }

        int var13;
        if (var1 == i) {
            if (w()) {
                GameEngine.print("Not reloading units: Need to keep network sync");
                return;
            }

            if (var2) {
                return;
            }

            if (var5.bZ.h() == 0) {
                var5.bS.b("No custom units to reload");
                return;
            }

            GameEngine.log("Reload active only requested");
            var5.bZ.a(true, true);
            var6 = PlayerData.c().iterator();

            while(var6.hasNext()) {
                var7 = (PlayerData)var6.next();
                if (var7 instanceof class_138) {
                    ((class_138)var7).al();
                }
            }

            var13 = class_436.d;
            short var15 = 100;
            String var8 = "Quick reloaded changed data for " + var13 + " units active on map.";
            if (var5.settingsEngine.liveReloading && var13 == 0) {
                var8 = var8 + " (Note: Live reloading is currently enabled, so changed units may have already be reloaded)";
                var15 = 170;
            }

            var5.bS.a(var8, var15);
        }

        if (var1 != k && var1 != l && var1 != j) {
            if (var1 == n) {
                if (var2) {
                    return;
                }

                Projectile var14 = NukeLaucher.a(this, var3.x, var3.y, var3.x, var3.y);
                if (var14 != null) {
                    var14.zCord = 100.0F;
                    var14.j = null;
                }
            }

            if (var1 == m) {
                if (!var2) {
                    var6 = Unit.bF().iterator();

                    while(var6.hasNext()) {
                        GameObject var26 = (GameObject)var6.next();
                        if (var26 instanceof OrderableUnit && var26 instanceof class_8 && class_340.a(var26.xCord, var26.yCord, var3.x, var3.y) < 2500.0F) {
                            class_8 var28 = (class_8)var26;
                            var28.dz();
                        }
                    }

                }
            } else {
                PlayerData var16;
                if (var1 == o) {
                    var16 = this.bX;
                    if (var16 instanceof class_138) {
                        class_138 var20 = (class_138)var16;
                        if (var20.bG > 0.0F) {
                            var20.bG = 0.0F;
                        } else {
                            var20.bG = 10800.0F;
                        }
                    }
                }

                if (var1 == p) {
                    var16 = this.bX;
                    ++var16.team;
                    if (var16.team > 4) {
                        var16.team = 0;
                    }
                }

                if (var1 == u) {
                    boolean var18 = false;
                    boolean var21 = false;
                    Iterator var22 = PlayerData.c().iterator();

                    while(var22.hasNext()) {
                        PlayerData var23 = (PlayerData)var22.next();
                        if (var23 instanceof class_138) {
                            class_138 var27 = (class_138)var23;
                            if (var27.bG > 0.0F) {
                                var18 = true;
                            }

                            var21 = true;
                        }
                    }

                    boolean var25 = !var18;
                    if (!var21) {
                        var25 = !this.c;
                    }

                    this.c = var25;
                    this.M();
                }

                if (var1 == v) {
                }

                if (var1 == w) {
                }

                if (var1 == x) {
                }

                if (var1 == z) {
                    var5.bl = !var5.bl;
                }

                if (var1 == A) {
                    class_138.as = !class_138.as;
                }

                if (var1 == B) {
                    var5.bn = !var5.bn;
                }

                if (var1 == C) {
                    var5.stats.a();
                }

                if (var1 instanceof class_250) {
                    class_250 var24 = (class_250)var1;
                    class_825.a(var24.a, var3);
                }

                super.a(var1, var2, var3, var4);
            }
        } else {
            var13 = 0;
            if (!var2) {
                Iterator var17 = Unit.bF().iterator();

                while(var17.hasNext()) {
                    Unit var19 = (Unit)var17.next();
                    if (var19 instanceof Unit) {
                        Unit var9 = var19;
                        if (class_340.a(var19.xCord, var19.yCord, var3.x, var3.y) < 2500.0F) {
                            if (var1 == k) {
                                if (var19.cN == null && var19.cO == null) {
                                    var19.ci();
                                    if (var19 instanceof OrderableUnit && var19.bI()) {
                                        var5.bU.a((OrderableUnit)var19);
                                    }
                                }
                            } else if (var1 == l) {
                                if (var19.cN == null && var19.cO == null) {
                                    var19.health = -1.0F;
                                }
                            } else if (var1 == j) {
                                if (var13 > 4) {
                                    break;
                                }

                                if (!var19.bI() && !(var19 instanceof Tree) && !var19.bV && var19.cN == null && var19.cO == null) {
                                    ++var13;
                                    class_31 var10 = var19.r();

                                    for(int var11 = -25; var11 < 25; ++var11) {
                                        Unit var12 = var10.a();
                                        var12.xCord = var9.xCord + (float)var11 * 0.5F + 1.0F;
                                        var12.yCord = var9.yCord + (float)var11 * 0.5F + 1.0F;
                                        var12.b(var9.bX);
                                        PlayerData.c(var12);
                                        var12.cg = (float)class_340.a((GameObject)var9, -180, 180, 25 + var11);
                                        if (var12 instanceof OrderableUnit) {
                                            ((OrderableUnit)var12).ay = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    public strictfp void M() {
        Iterator var1 = PlayerData.c().iterator();

        while(var1.hasNext()) {
            PlayerData var2 = (PlayerData)var1.next();
            if (var2 instanceof class_138) {
                class_138 var3 = (class_138)var2;
                if (!this.c) {
                    var3.bG = 0.0F;
                } else {
                    var3.bG = Float.MAX_VALUE;
                }
            }
        }

    }

    public static strictfp boolean a(class_226 var0, Unit var1) {
        if (var0 instanceof class_231) {
            var0 = ((class_231)var0).q_();
        }

        if (var0 == o) {
            return true;
        } else if (var0 == w) {
            return true;
        } else if (var0 == x) {
            return true;
        } else if (var0 == m) {
            return true;
        } else if (var0 == k) {
            return true;
        } else if (var0 == j) {
            return true;
        } else if (var0 == z) {
            return true;
        } else if (var0 == p) {
            return true;
        } else if (var0 == q) {
            return true;
        } else if (var0 == s) {
            return true;
        } else if (var0 == t) {
            return true;
        } else if (var0 == B) {
            return true;
        } else {
            return var0 == C;
        }
    }

    public static strictfp void a(ArrayList var0, int var1) {
        if (var1 == 1) {
            D = new ArrayList();
            D.add(new class_267(true, false));
            D.add(new class_267(true, true));
            D.add(new class_267(false, false));
            D.add(new class_265(true, false));
            class_265 var2 = new class_265(true, true);
            D.add(var2);
            D.add(new class_265(false, false));
            D.add(new class_268(true, false));
            D.add(new class_268(true, true));
            D.add(new class_268(false, false));
            D.add(new class_266(true, false));
            D.add(new class_266(true, true));
            D.add(new class_266(false, false));
            D.add(new class_250(class_143.GRASS));
            D.add(new class_250(class_143.SEA));
            D.add(new class_250(class_143.SAND));
            D.add(new class_250(class_143.DUST));
            ArrayList var3 = new ArrayList();
            var3.add(new class_264());
            var3.add(y);
            var3.add(h);
            var3.add(i);
            var3.add(k);
            var3.add(j);
            var3.add(l);
            var3.add(n);
            var3.add(m);
            var3.add(u);
            var3.add(v);
            var3.add(w);
            var3.add(x);
            var3.add(z);
            var3.add(p);
            var3.add(q);
            var3.add(s);
            var3.add(t);
            if (GameEngine.at) {
                var3.add(A);
            }

            var3.add(B);
            var3.add(C);
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
                class_226 var5 = (class_226)var4.next();
                boolean var6 = true;
                class_231 var7 = new class_231(var5, K, var6);
                D.add(var7);
            }

            ArrayList var12 = new ArrayList();
            var12.addAll(UnitType.ae);
            Collections.sort(var12, new class_1055());
            Iterator var13 = var12.iterator();

            while(true) {
                class_591 var8;
                class_31 var14;
                do {
                    Unit var15;
                    do {
                        do {
                            do {
                                do {
                                    do {
                                        do {
                                            do {
                                                do {
                                                    do {
                                                        do {
                                                            do {
                                                                do {
                                                                    do {
                                                                        if (!var13.hasNext()) {
                                                                            return;
                                                                        }

                                                                        var14 = (class_31)var13.next();
                                                                    } while(var14 == UnitType.wall_v);
                                                                } while(var14.i().equals("test_tank"));
                                                            } while(var14.i().equals("missing"));
                                                        } while(var14 == UnitType.tankDestroyer);
                                                    } while(var14 == UnitType.megaTank);
                                                } while(var14 == UnitType.fogRevealer);
                                            } while(var14 == UnitType.crystalResource);
                                        } while(var14 == UnitType.damagingBorder);
                                    } while(var14 == UnitType.zoneMarker);
                                } while(var14 == UnitType.editorOrBuilder);
                            } while(var14 == UnitType.dummyNonUnitWithTeam);
                        } while(var14 == UnitType.supplyDepot);

                        var15 = Unit.c(var14);
                    } while(!(var15 instanceof OrderableUnit));

                    if (!(var14 instanceof class_591)) {
                        break;
                    }

                    var8 = (class_591)var14;
                } while(!var8.aF);

                class_241 var16 = new class_241(var14, 1, (Integer)null);
                class_231 var17 = new class_231(var16, K);
                boolean var9 = false;
                Iterator var10 = D.iterator();

                while(var10.hasNext()) {
                    class_226 var11 = (class_226)var10.next();
                    if (var11.equals(var17)) {
                        var9 = true;
                    }
                }

                if (!var9) {
                    D.add(var17);
                }
            }
        }
    }

    public strictfp ArrayList N() {
        GameEngine var1 = GameEngine.getGameEngine();
        return D;
    }

    public strictfp boolean E() {
        return true;
    }

    public strictfp float g(int var1) {
        return 10.0F;
    }

    public strictfp boolean F() {
        return GameEngine.getGameEngine().settingsEngine.renderExtraShadows && !this.bV;
    }

    public strictfp float G() {
        return 1.0F;
    }

    public strictfp float H() {
        return 1.0F;
    }

    public strictfp boolean u() {
        return true;
    }

    public strictfp boolean I() {
        return false;
    }

    public strictfp boolean d(Unit var1) {
        return false;
    }

    public strictfp boolean J() {
        return true;
    }

    public strictfp float a(Unit var1, float var2, Projectile var3) {
        var2 = 0.0F;
        return super.a(var1, var2, var3);
    }

    public strictfp void O() {
    }

    public strictfp boolean P() {
        return true;
    }

    public strictfp void a(EditorOrBuilder var1) {
        this.r = var1.r;
        this.c = var1.c;
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeByte(1);
        var1.writeSimilarEnum(this.G);
        var1.writeIsString(this.H);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        byte var2 = var1.readByte();
        this.G = (class_812)var1.readSimilarEnum(class_812.class);
        if (this.G == null) {
            this.G = class_812.a;
        }

        if (var2 >= 1) {
            this.H = var1.isReadString();
        }

        super.a(var1);
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.f();
    }
}
