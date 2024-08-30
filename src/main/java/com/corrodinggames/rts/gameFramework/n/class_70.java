package com.corrodinggames.rts.gameFramework.n;

import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.maps.ObjectGroup;
import com.corrodinggames.rts.game.maps.MapException;
import com.corrodinggames.rts.game.maps.class_487;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.Tree;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_388;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.buildings.CommandCenter;
import com.corrodinggames.rts.game.units.buildings.Extractor;
import com.corrodinggames.rts.game.units.buildings.turrets.Turret;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.class_62;
import com.corrodinggames.rts.gameFramework.d.class_986;
import com.corrodinggames.rts.gameFramework.d.class_996;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.n.f
public strictfp class class_70 extends class_62 {
    public static boolean a = false;
    int b;
    int c;
    PlayerData d;
    WinCondition e;
    WinCondition f;
    public ArrayList g;
    public class_388 h;
    boolean i;
    boolean j;
    public boolean k;
    public boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    public boolean q;
    public int r;
    String s;
    String t;
    int u;
    int v;
    int w;
    int x;
    public int y;
    float z;
    float A;
    float B;
    class_626 C;
    ArrayList D;
    public Paint E;
    public Paint F;
    public Paint G;
    public Paint H;
    final boolean I;
    public ArrayList J;
    PointF K;
    int L;
    float M;
    public boolean N;
    public ArrayList O;
    PointF P;
    boolean Q;
    boolean R;
    ArrayList S;
    ArrayList T;

    public class_70() {
        this.f = WinCondition.allUnitsAndBuildings;
        this.g = new ArrayList();
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = 0;
        this.v = 2;
        this.w = 1;
        this.x = 0;
        this.y = 0;
        this.z = 3000.0F;
        this.A = 0.0F;
        this.B = 0.0F;
        this.C = class_626.NORMAL;
        this.D = new ArrayList();
        this.I = true;
        this.J = new ArrayList();
        this.K = new PointF();
        this.L = 0;
        this.M = 0.0F;
        this.O = new ArrayList();
        this.P = new PointF();
        this.Q = false;
        this.R = false;
        this.S = new ArrayList();
        this.T = new ArrayList();
    }

    public void a(String var1) {
        GameEngine.b("MissionEngine", "Map warning: " + var1);
        GameNetEngine.a((String)null, (String)("Map error: " + var1));
    }

    public void a(GameOutputStream var1) {
        var1.writeBoolean(this.j);
        var1.writeInt(this.r);
        var1.writeInt(this.u);
        var1.writeInt(this.v);
        var1.writeInt(this.w);
        var1.writeInt(this.x);
        var1.writeFloat(this.z);
        var1.writeFloat(this.A);
        var1.writeFloat(this.B);
        var1.writeBoolean(this.m);
        var1.writeInt(6);
        var1.writeInt(this.J.size());
        Iterator var2 = this.J.iterator();

        while(var2.hasNext()) {
            class_637 var3 = (class_637)var2.next();
            var1.writeString(var3.c);
            var1.writeBoolean(var3.j);
            var1.writeInt(var3.k);
            var1.writeInt(var3.l);
            var1.writeBoolean(var3.m);
            var1.writeInt(var3.n);
        }

        var1.writeInt(this.y);
        var1.writeBoolean(this.l);
    }

    public void a(GameInputStream var1) {
        this.j = var1.readBoolean();
        this.r = var1.readInt();
        this.u = var1.readInt();
        this.v = var1.readInt();
        this.w = var1.readInt();
        this.x = var1.readInt();
        this.z = var1.readFloat();
        this.A = var1.readFloat();
        this.B = var1.readFloat();
        this.m = var1.readBoolean();
        int var2 = var1.readInt();
        if (var2 >= 1) {
            int var3 = var1.readInt();

            for(int var4 = 0; var4 < var3; ++var4) {
                String var5 = var1.readString();
                boolean var6 = var1.readBoolean();
                int var7 = 0;
                int var8 = 0;
                boolean var9 = false;
                int var10 = 0;
                if (var2 >= 2) {
                    var7 = var1.readInt();
                    var8 = var1.readInt();
                }

                if (var2 >= 3) {
                    var9 = var1.readBoolean();
                }

                if (var2 >= 4) {
                    var10 = var1.readInt();
                }

                class_637 var11 = this.e(var5);
                if (var11 == null) {
                    GameEngine.print("MissionEngine:readIn: Could not find saved trigger:" + var5 + " for de/activation");
                } else {
                    var11.j = var6;
                    var11.k = var7;
                    var11.l = var8;
                    var11.m = var9;
                    var11.n = var10;
                }
            }
        }

        if (var2 >= 5) {
            this.y = var1.readInt();
        }

        if (var2 >= 6) {
            this.l = var1.readBoolean();
        } else {
            this.l = true;
        }

    }

    public void b(String var1) {
        GameEngine.b("MissionEngine:triggerLog", var1);
    }

    public boolean a() {
        return this.n;
    }

    public boolean b() {
        return this.o;
    }

    @SneakyThrows
    public void a(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.q = false;
        this.b = var2.by - 1000;
        this.c = var2.by - 1000;
        this.E = new Paint();
        this.E.a(255, 255, 255, 255);
        this.E.a(true);
        this.E.a(Paint$Align.b);
        this.E.a(Typeface.a((Typeface)Typeface.c, 1));
        var2.a(this.E, 24.0F);
        this.G = new Paint();
        this.G.a(255, 255, 255, 255);
        this.G.a(true);
        this.G.a(Paint$Align.b);
        var2.a(this.G, 18.0F);
        this.H = new Paint();
        this.H.a(255, 255, 255, 255);
        this.H.a(true);
        this.H.a(Paint$Align.b);
        var2.a(this.H, 14.0F);
        this.F = new Paint();
        this.F.a(this.H);
        var2.a(this.F, 18.0F);
        this.j = true;
        boolean var3 = false;
        class_487 var4 = null;
        if (var2.bL.Q == null) {
            GameEngine.b("MissionEngine", "Error: 'triggers' object layer is missing from this map");
            var3 = true;
        } else {
            var4 = var2.bL.Q.a("map_info");
        }

        if (var4 == null) {
            GameEngine.b("MissionEngine", "Error: map_info is missing from this map");
            var3 = true;
        }

        if (var4 != null && var4.b("type") == null) {
            this.a("type is missing from map_info");
            var3 = true;
        }

        if (var3) {
            GameEngine.b("MissionEngine", "Defaulting to skirmish");
            this.n = true;
            this.e = WinCondition.noConstructionOrTech;
        } else {
            this.k = "survival".equalsIgnoreCase(var4.b("type"));
            if (this.k) {
                this.l = "true".equalsIgnoreCase(var4.b("survivalWavesClassic"));
                if (this.l) {
                    GameEngine.log("Classic survial waves selected");
                }

                this.f();
                this.p = false;
                this.y = var2.settingsEngine.aiDifficulty;
                if (!this.l) {
                    this.z = 1200.0F;
                    if (this.y < 0) {
                        this.z = 3000.0F;
                    }
                } else {
                    this.z = 3000.0F;
                }
            }

            String var5 = var4.b("survivalWaves");
            if (var5 != null) {
                this.g(var5);
            }

            String var6 = var4.b("startWithMusic");
            if (var6 != null) {
                var2.bN.a(var6);
            }

            this.n = "skirmish".equalsIgnoreCase(var4.b("type"));
            if (this.n) {
                this.e = WinCondition.noConstructionOrTech;
            }

            this.o = "true".equalsIgnoreCase(var4.b("shareFogWithAllies"));
            String var7 = var4.b("winCondition");
            if (var7 == null && !this.n) {
                throw new MapException("win condition not set");
            } else {
                if (var7 != null) {
                    if (var7.equalsIgnoreCase("none")) {
                        this.e = WinCondition.none;
                    } else if (var7.equalsIgnoreCase("allUnitsAndBuildings")) {
                        this.e = WinCondition.allUnitsAndBuildings;
                    } else if (var7.equalsIgnoreCase("allBuildings")) {
                        this.e = WinCondition.allBuildings;
                    } else if (var7.equalsIgnoreCase("mainBuilings")) {
                        this.e = WinCondition.mainBuildings;
                    } else if (var7.equalsIgnoreCase("mainBuildings")) {
                        this.e = WinCondition.mainBuildings;
                    } else if (var7.equalsIgnoreCase("commandCenter")) {
                        this.e = WinCondition.commandCenter;
                    } else {
                        if (!var7.equalsIgnoreCase("requiredObjectives")) {
                            throw new MapException("unknown win condition:" + var7);
                        }

                        this.e = WinCondition.requiredObjectives;
                    }
                }

                if (this.n) {
                    this.f = this.e;
                }

                this.h = var4.createLocaleStringFromProperty((String)"introText", (class_388)null);
                if (this.h != null) {
                    this.h.a("\\\\n", "\n");
                    if (this.h.a()) {
                        this.h = null;
                    }
                }

                if (!var2.ay() && !this.n) {
                    this.d = PlayerData.getPlayerData(3);
                    if (this.d != null) {
                        this.d.team = 0;
                    }
                }

                if (var2.ay()) {
                }

                Iterator var14 = var2.bL.Q.c.iterator();

                while(true) {
                    String var8;
                    float var21;
                    int var24;
                    Iterator var25;
                    Unit var28;
                    String var38;
                    String var41;
                    while(var14.hasNext()) {
                        var4 = (class_487)var14.next();
                        if ("team_info".equalsIgnoreCase(var4.type)) {
                            int var15 = Integer.parseInt(var4.a("team", "-2"));
                            if (var15 == -2) {
                                throw new RuntimeException("cannot find team for:" + var4.name);
                            }

                            PlayerData var19 = PlayerData.getPlayerData(var15);
                            if (var19 == null) {
                                GameEngine.print("No team loaded for:" + var15 + " skipping");
                                continue;
                            }

                            Integer var23 = var4.c("credits");
                            if (var23 != null) {
                                var19.credits = (double)var23;
                            }

                            var8 = var4.b("basicAI");
                            if (var8 != null && var2.P() && var19 instanceof class_138) {
                                GameEngine.print("Using basic AI:" + var15 + " by map request");
                                class_138 var9 = (class_138)var19;
                                var9.aY = true;
                            }

                            String var31 = var4.b("lockAiDifficulty");
                            if (var31 != null && var19 instanceof class_138) {
                                GameEngine.print("Locking lockAiDifficulty:" + var15 + " by map request to: " + var31);
                                class_138 var10 = (class_138)var19;
                                int var11 = Integer.parseInt(var31);
                                var10.x = var11;
                                var10.y = true;
                                var2.netEngine.aq();
                            }

                            var38 = var4.b("disabledAI");
                            if (var38 != null && var2.P() && var19 instanceof class_138) {
                                GameEngine.print("Disabling AI:" + var15 + " by map request");
                                class_138 var40 = (class_138)var19;
                                var40.aX = true;
                            }

                            var41 = var4.b("allyGroup");
                            if (var41 != null && var2.P()) {
                                int var12 = Integer.parseInt(var41);
                                var19.team = var12;
                            }

                            String var43 = var4.b("ai");
                            if (var43 != null) {
                                var19.U = var43.equalsIgnoreCase("survival");
                            }
                        }

                        if ("camera_start".equalsIgnoreCase(var4.name) && !var1) {
                            var2.b(var4.x, var4.y);
                            this.q = true;
                            Integer var17 = var4.c("zoomTo");
                            if (var17 != null) {
                                var2.cV = (float)var17;
                            }
                        }

                        if ("attack_point".equalsIgnoreCase(var4.name)) {
                            this.D.add(new PointF(var4.x, var4.y));
                        }

                        if ("rotate".equalsIgnoreCase(var4.type)) {
                            var5 = var4.b("dir");
                            var21 = Float.parseFloat(var5);
                            var25 = Unit.bE.iterator();

                            while(var25.hasNext()) {
                                var28 = (Unit)var25.next();
                                if (var28 instanceof OrderableUnit && !var28.bI() && var4.a(var28)) {
                                    var28.cg = var21;
                                }
                            }
                        }

                        Iterator var20;
                        Unit var22;
                        if ("fall".equalsIgnoreCase(var4.type)) {
                            var20 = Unit.bE.iterator();

                            while(var20.hasNext()) {
                                var22 = (Unit)var20.next();
                                if (var22 instanceof OrderableUnit && !var22.bI() && var4.a(var22)) {
                                    var22.dc();
                                }
                            }
                        }

                        if ("set_team".equalsIgnoreCase(var4.type)) {
                            var5 = var4.b("team");
                            var24 = Integer.parseInt(var5);
                            var25 = Unit.bE.iterator();

                            while(var25.hasNext()) {
                                var28 = (Unit)var25.next();
                                if (var28 instanceof OrderableUnit && var4.a(var28)) {
                                    var28.P(var24);
                                }
                            }
                        }

                        if ("ai_allow_full_use".equalsIgnoreCase(var4.type)) {
                            var20 = Unit.bE.iterator();

                            while(var20.hasNext()) {
                                var22 = (Unit)var20.next();
                                if (var22 instanceof OrderableUnit && var4.a(var22)) {
                                    ((OrderableUnit)var22).bM = false;
                                }
                            }
                        }

                        if ("disable_unit_ai".equalsIgnoreCase(var4.type)) {
                            var20 = Unit.bE.iterator();

                            while(var20.hasNext()) {
                                var22 = (Unit)var20.next();
                                if (var22 instanceof OrderableUnit && var4.a(var22)) {
                                    var22.bN = true;
                                }
                            }
                        }
                    }

                    var14 = Unit.bE.iterator();

                    label402:
                    while(true) {
                        Unit var16;
                        do {
                            do {
                                do {
                                    do {
                                        do {
                                            if (!var14.hasNext()) {
                                                this.J.clear();
                                                var14 = var2.bL.Q.c.iterator();

                                                while(var14.hasNext()) {
                                                    var4 = (class_487)var14.next();
                                                    if (!"team_info".equalsIgnoreCase(var4.type) && !"point".equalsIgnoreCase(var4.type) && !"camera_pan".equalsIgnoreCase(var4.type) && !"camera_start".equalsIgnoreCase(var4.name) && !"map_info".equalsIgnoreCase(var4.name) && !"attack_point".equalsIgnoreCase(var4.name) && !"rotate".equalsIgnoreCase(var4.type) && !"fall".equalsIgnoreCase(var4.type) && !"set_team".equalsIgnoreCase(var4.type) && !"ai_allow_full_use".equalsIgnoreCase(var4.type) && !"disable_unit_ai".equalsIgnoreCase(var4.type) && !"info".equalsIgnoreCase(var4.type)) {
                                                        if (var4.n == null) {
                                                            c("Error: Skipping trigger:" + var4.name + " - no properties found");
                                                        } else {
                                                            class_637 var27 = class_621.a(this, var4);
                                                            if (var27 != null) {
                                                                this.J.add(var27);
                                                            }
                                                        }
                                                    }
                                                }

                                                var14 = this.J.iterator();

                                                class_637 var18;
                                                while(var14.hasNext()) {
                                                    var18 = (class_637)var14.next();
                                                    var5 = var18.b("activateIds");
                                                    if (var5 == null) {
                                                        var5 = var18.b("alsoActivate");
                                                    }

                                                    String[] var29;
                                                    int var37;
                                                    if (var5 != null) {
                                                        String[] var30 = var5.split(",");
                                                        var29 = var30;
                                                        int var32 = var30.length;

                                                        for(var37 = 0; var37 < var32; ++var37) {
                                                            var38 = var29[var37];
                                                            class_637 var42 = this.d(var38);
                                                            if (var42 != null) {
                                                                var42.d.a(var18);
                                                            } else {
                                                                var18.g("linkedTo target not found: " + var5);
                                                                GameEngine.log("Possible IDs:");
                                                                Iterator var44 = this.J.iterator();

                                                                while(var44.hasNext()) {
                                                                    class_637 var13 = (class_637)var44.next();
                                                                    if (var13.b != null) {
                                                                        GameEngine.log(var13.b);
                                                                    }
                                                                }

                                                                GameEngine.log("--------");
                                                            }
                                                        }
                                                    }

                                                    var6 = var18.b("whenActivatedIds");
                                                    if (var6 == null) {
                                                        var6 = var18.b("activatedBy");
                                                    }

                                                    String[] var35;
                                                    int var39;
                                                    class_637 var45;
                                                    if (var6 != null) {
                                                        var29 = var6.split(",");
                                                        var35 = var29;
                                                        var37 = var29.length;

                                                        for(var39 = 0; var39 < var37; ++var39) {
                                                            var41 = var35[var39];
                                                            var45 = this.d(var41);
                                                            if (var45 == null) {
                                                                var18.g("linkedFrom target not found: " + var41);
                                                            } else {
                                                                var18.d.a(var45);
                                                            }
                                                        }
                                                    }

                                                    var6 = var18.b("deactivatedBy");
                                                    if (var6 != null) {
                                                        var29 = var6.split(",");
                                                        var35 = var29;
                                                        var37 = var29.length;

                                                        for(var39 = 0; var39 < var37; ++var39) {
                                                            var41 = var35[var39];
                                                            var45 = this.d(var41);
                                                            if (var45 == null) {
                                                                var18.g("deactivatedBy: target not found: " + var41);
                                                            } else {
                                                                var18.e.a(var45);
                                                            }
                                                        }
                                                    }
                                                }

                                                GameEngine.log("Found " + this.J.size() + " map triggers");
                                                var14 = this.J.iterator();

                                                while(var14.hasNext()) {
                                                    var18 = (class_637)var14.next();
                                                    String[] var33 = var18.t.a();
                                                    var24 = var33.length;

                                                    for(int var34 = 0; var34 < var24; ++var34) {
                                                        var8 = var33[var34];
                                                        var18.g("Key was not used: " + var8);
                                                    }
                                                }

                                                this.c();
                                                return;
                                            }

                                            var16 = (Unit)var14.next();
                                        } while(var16.u());
                                    } while(var16 instanceof Tree);
                                } while(var16.bI());
                            } while(var16.cN != null);
                        } while(var16.cO != null);

                        Unit var26 = null;
                        var21 = 4900.0F;
                        var25 = Unit.bE.iterator();

                        while(true) {
                            do {
                                do {
                                    do {
                                        if (!var25.hasNext()) {
                                            if (var26 != null) {
                                                var26.e(var16, true);
                                            }
                                            continue label402;
                                        }

                                        var28 = (Unit)var25.next();
                                    } while(!var28.cr());
                                } while(var16 == var28);
                            } while(var16.bX != PlayerData.i && !var28.bX.d(var16.bX));

                            float var36 = class_340.a(var28.xCord, var28.yCord, var16.xCord, var16.yCord);
                            if (var36 < var21 && var28.d(var16, true)) {
                                var26 = var28;
                                var21 = var36;
                            }
                        }
                    }
                }
            }
        }
    }

    public void c() {
        Iterator var1 = this.J.iterator();

        while(true) {
            class_637 var2;
            do {
                if (!var1.hasNext()) {
                    return;
                }

                var2 = (class_637)var1.next();
            } while(var2.g != class_609.a);

            boolean var3 = false;
            Iterator var4 = this.g.iterator();

            while(var4.hasNext()) {
                class_627 var5 = (class_627)var4.next();
                if (var5.a == var2) {
                    var3 = true;
                }
            }

            if (!var3) {
                class_627 var6 = new class_627();
                var6.a = var2;
                this.g.add(var6);
                GameEngine.log("Found objective: " + var6.a());
            }
        }
    }

    public static void c(String var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        GameEngine.b("MissionEngine", var0);
        GameNetEngine.g(var0);
    }

    public class_637 d(String var1) {
        var1 = var1.trim();
        Iterator var2 = this.J.iterator();

        class_637 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_637)var2.next();
        } while(var3.b == null || !var3.b.equalsIgnoreCase(var1));

        return var3;
    }

    public class_637 e(String var1) {
        var1 = var1.trim();
        Iterator var2 = this.J.iterator();

        class_637 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_637)var2.next();
        } while(!var3.c.equalsIgnoreCase(var1));

        return var3;
    }

    public PointF f(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        ObjectGroup var3 = var2.bL.Q;
        if (var3 != null) {
            Iterator var4 = var3.c.iterator();

            while(var4.hasNext()) {
                class_487 var5 = (class_487)var4.next();
                if ("point".equalsIgnoreCase(var5.type) && var5.c != null && var5.c.equalsIgnoreCase(var1)) {
                    this.K.setSite(var5.x, var5.y);
                    return this.K;
                }
            }
        }

        return null;
    }

    public void a(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
    }

    public void b(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        String var13;
        if (this.i) {
            Iterator var3 = this.J.iterator();

            while(var3.hasNext()) {
                class_637 var4 = (class_637)var3.next();
                if (var4.g == class_609.g && var4.j) {
                    float var5 = (float)var4.b() - var2.cw;
                    float var6 = (float)var4.c() - var2.cx;
                    var5 *= var2.cX;
                    var6 *= var2.cX;
                    var5 += var4.w;
                    var6 += var4.x;
                    if (var4.C) {
                        class_996 var7 = class_986.s[9];
                        var7.a(2, var5, var6, var4.B);
                        var6 -= (float)(var7.c - 2);
                    }

                    if (var4.z != null) {
                        var13 = var4.z.b();
                        if (var13 != null && !var13.equals("")) {
                            var2.bO.a(var13, var5, var6, var4.B);
                        }
                    }
                }
            }
        }

        int var12;
        String var14;
        if (this.k && !this.N) {
            boolean var8 = true;
            boolean var10 = false;
            this.B = class_340.a(this.B, var1);
            if (this.B == 0.0F && this.A != 0.0F) {
                this.A = class_340.a(this.A, var1);
                var10 = true;
            }

            if (var8) {
                if (var10) {
                    var12 = (int)(23.0F + this.E.k() / 2.0F);
                    var2.bO.a("- Wave " + this.r + " -", var2.cF / 2.0F, (float)var12, this.E);
                    if (this.s != null) {
                        var2.bO.a(this.s, var2.cF / 2.0F, (float)var12 + this.E.k() + 2.0F, this.F);
                    }
                } else {
                    var12 = (int)(23.0F + this.G.k() / 2.0F);
                    var14 = "Wave " + (this.r + 1) + " in " + class_340.f(String.valueOf((int)((double)this.z / 60.0)), 3);
                    if (this.m) {
                        var14 = "Defeat - Wave " + this.r;
                    }

                    var2.bO.a(var14, var2.cF / 2.0F, (float)var12, this.G);
                    if (this.t == null) {
                        class_623 var15;
                        if (!this.l) {
                            var15 = this.b(false);
                        } else {
                            var15 = this.c(false);
                        }

                        this.t = var15.toString();
                    }

                    var13 = this.t;
                    var2.bO.a(var13, var2.cF / 2.0F, (float)var12 + this.G.k() + 2.0F, this.H);
                }
            }
        }

        if (this.k && this.N) {
            class_625 var9 = this.d();
            if (var9 != null) {
                int var11 = var9.e - var2.by / 1000;
                var12 = (int)(23.0F + this.G.k() / 2.0F);
                var14 = "Wave " + (this.r + 1) + " in " + class_340.f(String.valueOf(var11), 3);
                if (this.m) {
                    var14 = "Defeat - Wave " + this.r;
                }

                var2.bO.a(var14, var2.cF / 2.0F, (float)var12, this.G);
                var13 = var9.f;
                if (var13 != null) {
                    var2.bO.a(var13, var2.cF / 2.0F, (float)var12 + this.G.k() + 2.0F, this.H);
                }
            }
        }

    }

    public void g(String var1) {
        GameEngine.log("Loading survival waves");
        this.N = true;
        String[] var2 = var1.split("\n");
        int var3 = 0;
        int var4 = 0;
        boolean var5 = false;
        String[] var6 = var2;
        int var7 = var2.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            String var9 = var6[var8];
            ++var4;
            class_625 var10 = new class_625(this);
            if (var10.a(var9)) {
                var10.e = var3 + (int)var10.d;
                var3 = var10.e;
                GameEngine.log("Adding wave " + var4 + " at " + var10.e);
                this.O.add(var10);
            }
        }

    }

    public class_625 d() {
        return this.r < this.O.size() ? (class_625)this.O.get(this.r) : null;
    }

    public void e() {
        this.R = true;
        int var1 = class_340.a(0, this.D.size() - 1, this.r);
        PointF var2 = (PointF)this.D.get(var1);
        this.P.setSite(var2);
    }

    public void f() {
        this.S.clear();
        this.a(this.S, "scout", 0.7F);
        this.a(this.S, (class_31) UnitType.tank, 2.1F);
        this.a(this.S, "mechGun", 1.0F);
        this.a(this.S, "lightGunship", 2.8F);
        this.a(this.S, (class_31) UnitType.hoverTank, 1.9F);
        this.a(this.S, (class_31) UnitType.helicopter, 0.8F);
        this.a(this.S, (class_31) UnitType.heavyTank, 1.0F);
        this.a(this.S, (class_31) UnitType.heavyHoverTank, 0.8F);
        this.a(this.S, (class_31) UnitType.gunShip, 0.7F);
        this.a(this.S, "plasmaTank", 0.6F);
        this.a(this.S, "missileAirship", 0.4F);
        this.T.clear();
        this.a(this.T, (class_31) UnitType.experimentalTank, 1.0F);
        this.a(this.T, (class_31) UnitType.experimentalHoverTank, 0.5F);
    }

    public void a(ArrayList var1, String var2, float var3) {
        this.a(var1, class_591.s(var2), var3);
    }

    public void a(ArrayList var1, class_31 var2, float var3) {
        if (var2 == null) {
            var2 = UnitType.tank;
        }

        class_31 var4 = class_591.c((class_31)var2);
        if (var4 != null) {
            var2 = var4;
        }

        class_628 var5 = new class_628(this);
        var5.a = (class_31)var2;
        var5.b = var3;
        var1.add(var5);
    }

    public void a(class_623 var1, int var2, float var3) {
        if (var2 < 0) {
            var2 = 0;
        }

        int var4 = this.S.size();
        if (var4 == 0) {
            GameEngine.print("error maxTypeNum: " + var4);
        } else {
            int var5 = var2 % var4;
            class_628 var6 = (class_628)this.S.get(var5);
            int var7 = (int)((double)(var2 + 3) * 0.5 * (double)var6.b * (double)var3);
            var7 = (int)class_340.e((float)var7, 0.8F);
            if (var7 < 1) {
                var7 = 1;
            }

            var1.b(var6.a, var7);
        }
    }

    public class_623 b(boolean var1) {
        class_623 var2 = new class_623(this);
        boolean var3 = false;
        int var4;
        if (this.u > 50 && (this.u + 1) % 100 == 0) {
            var4 = this.T.size();
            int var5 = this.u / 100;
            if (var4 == 0) {
                GameEngine.print("error maxTypeNum: " + var4);
            } else {
                int var6 = var5 % var4;
                class_628 var7 = (class_628)this.T.get(var6);
                int var8 = (int)((float)var5 * var7.b);
                if (var8 < 1) {
                    var8 = 1;
                }

                var2.b(var7.a, var8);
            }

            var3 = true;
        }

        var4 = 0;
        if (this.y > 0) {
            var4 = this.y;
        }

        this.a(var2, this.u + var4, 1.0F);
        if (this.u > 15 && !var3) {
            this.a(var2, (int)((float)(this.u + var4) * 1.1F) - 11, 0.5F);
        }

        if (var1) {
            ++this.u;
            ++this.v;
        }

        return var2;
    }

    public class_623 c(boolean var1) {
        class_623 var2 = new class_623(this);
        var2.a = false;
        int var3 = this.v;
        UnitType var4 = null;
        if (this.p) {
            var4 = UnitType.ladybug;
        } else {
            if (this.u == 0) {
                ++var3;
                var4 = UnitType.tank;
            }

            if (this.u == 1) {
                var4 = UnitType.hoverTank;
            }

            if (this.u == 2) {
                var4 = UnitType.helicopter;
            }

            if (this.u == 3) {
                var3 = this.w;
                var4 = UnitType.heavyTank;
            }

            if (this.u == 4) {
                var3 = this.w;
                var4 = UnitType.heavyHoverTank;
                if (this.w % 2 == 0) {
                    var4 = UnitType.gunShip;
                }
            }

            if (this.u == 5) {
                var2.a = true;
                var3 = 1;
                var4 = UnitType.experimentalTank;
            }

            if (var1) {
                ++this.u;
                boolean var5 = false;
                if (this.w == 1) {
                    if (this.u > 2) {
                        var5 = true;
                    }
                } else if (this.w < 5) {
                    if (this.u > 4) {
                        var5 = true;
                    }
                } else {
                    if (this.u > 5) {
                        var5 = true;
                    }

                    if (this.u > 4 && this.w % 2 == 0) {
                        var5 = true;
                    }
                }

                if (var5) {
                    this.u = 0;
                    this.v += 2;
                    ++this.w;
                }
            }
        }

        var2.a(var4, var3);
        return var2;
    }

    public void c(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        int var3 = var2.by;
        this.M = class_340.a(this.M, var1);
        if (var2.aq && var2.bH) {
            class_487 var4 = null;
            if (var2.bL.Q != null) {
                Iterator var5 = var2.bL.Q.c.iterator();

                while(var5.hasNext()) {
                    class_487 var6 = (class_487)var5.next();
                    if ("camera_pan".equalsIgnoreCase(var6.type) && this.L == Integer.parseInt(var6.a("index", "-1"))) {
                        var4 = var6;
                    }
                }
            }

            if (var4 == null) {
                this.L = 0;
            } else {
                float var12 = var4.x;
                float var14 = var4.y;
                if (var12 < var2.cI + 2.0F) {
                    var12 = var2.cI + 2.0F;
                }

                if (var14 < var2.cJ + 2.0F) {
                    var14 = var2.cJ + 2.0F;
                }

                if (var12 > var2.bL.i() - var2.cI - 2.0F) {
                    var12 = var2.bL.i() - var2.cI - 2.0F;
                }

                if (var14 > var2.bL.j() - var2.cJ - 2.0F) {
                    var14 = var2.bL.j() - var2.cJ - 2.0F;
                }

                float var7 = class_340.d(var2.cy + var2.cI, var2.cz + var2.cJ, var12, var14);
                float var8 = class_340.a(var2.cy + var2.cI, var2.cz + var2.cJ, var12, var14);
                if (this.M == 0.0F && (var8 < 225.0F || var2.ct)) {
                    ++this.L;
                    this.M = 50.0F;
                }

                float var9 = 0.45F * var1;
                var2.cy += class_340.k(var7) * var9;
                var2.cz += class_340.j(var7) * var9;
                var2.a(var2.cy, var2.cz);
                var2.Q();
            }
        }

        if (this.k) {
            if (!this.N) {
                if (!this.m) {
                    this.z = class_340.a(this.z, var1);
                }

                if (this.z == 0.0F && !this.m) {
                    ++this.r;
                    this.A = 180.0F;
                    int var10 = class_340.a(0, this.D.size() - 1, this.r);
                    PointF var15 = (PointF)this.D.get(var10);
                    class_623 var18;
                    if (!this.l) {
                        this.s = this.b(false).toString();
                        var18 = this.b(true);
                    } else {
                        this.s = this.c(false).toString();
                        var18 = this.c(true);
                    }

                    this.z = 1800.0F;
                    if (!this.l) {
                        if (this.y > 0) {
                            this.z -= (float)(this.y * 3 * 60);
                        } else {
                            this.z -= (float)(this.y * 9 * 60);
                        }
                    }

                    var18.a(var15.x, var15.y);
                    this.t = null;
                }
            } else if (!this.m) {
                class_625 var11 = this.d();
                if (var11 != null) {
                    if (var11.e * 1000 < var2.by) {
                        var11.a();
                        ++this.r;
                    }
                } else if (!var2.dq && !var2.replayEngine.j()) {
                    var2.bS.G();
                }
            }
        }

        if (this.j) {
            this.j = false;
            if (this.h != null) {
                var2.a("Briefing", this.h);
            }
        }

        if (var3 > this.b + 250) {
            this.b = var3;
            this.a(var3);
        }

        if (var3 > this.c + 1000) {
            this.c = var3;
            if (this.h()) {
                this.h();
                this.h();
            }

            boolean var13 = false;
            boolean var16 = false;
            if (var2.playerTeam != null) {
                if (var2.playerTeam.j()) {
                    var13 = true;
                }

                if (var2.playerTeam.b()) {
                    var16 = true;
                }
            }

            boolean var20;
            if (!var2.dq && !var2.dt && !var2.replayEngine.j() && !var16) {
                var20 = true;
                boolean var17 = true;
                Iterator var19;
                Unit var24;
                if (this.e == WinCondition.none) {
                    var20 = false;
                } else if (this.e == WinCondition.requiredObjectives) {
                    var19 = this.g.iterator();

                    while(var19.hasNext()) {
                        class_627 var23 = (class_627)var19.next();
                        if (!var23.b()) {
                            var20 = false;
                        }
                    }
                } else if (var2.playerTeam != null) {
                    var19 = Unit.bE.iterator();

                    while(var19.hasNext()) {
                        var24 = (Unit)var19.next();
                        if (var2.playerTeam.c(var24.bX) && this.a(this.e, var24)) {
                            var20 = false;
                            break;
                        }
                    }
                }

                if (this.f == WinCondition.none) {
                    var17 = false;
                } else if (this.f == WinCondition.requiredObjectives) {
                    var17 = false;
                } else if (var2.playerTeam != null) {
                    var19 = Unit.bE.iterator();

                    while(var19.hasNext()) {
                        var24 = (Unit)var19.next();
                        if (var2.playerTeam.d(var24.bX) && this.a(this.f, var24)) {
                            var17 = false;
                            break;
                        }
                    }
                }

                if (var17 && !var20) {
                    var2.bS.H();
                }

                if (var20) {
                    var2.bS.G();
                    if (var2.by > 1500) {
                        ++var2.settingsEngine.numberOfWins;
                        var2.settingsEngine.save();
                    }
                }
            }

            if (this.k && !this.m) {
                var20 = true;
                Iterator var21 = Unit.bE.iterator();

                while(true) {
                    Unit var22;
                    do {
                        if (!var21.hasNext()) {
                            if (var20) {
                                this.m = true;
                                var2.bS.H();
                            }

                            return;
                        }

                        var22 = (Unit)var21.next();
                    } while(!(var22 instanceof CommandCenter) && !var22.bP);

                    if (!var22.bV && !var22.u() && var22.bX == var2.playerTeam) {
                        var20 = false;
                    }
                }
            }
        }

    }

    public boolean a(WinCondition var1, Unit var2) {
        if (!(var2 instanceof OrderableUnit)) {
            return false;
        } else if (!var2.bV && !var2.cT()) {
            if (var1 == WinCondition.none) {
                return false;
            } else if (var1 == WinCondition.allUnitsAndBuildings) {
                return true;
            } else if (var1 == WinCondition.allBuildings) {
                return var2.bI();
            } else if (var1 == WinCondition.commandCenter) {
                return var2 instanceof CommandCenter || var2.bP;
            } else if (var1 != WinCondition.mainBuildings) {
                if (var1 == WinCondition.noConstructionOrTech) {
                    if (var2.bJ()) {
                        return true;
                    } else {
                        return var2.ak();
                    }
                } else {
                    return var1 == WinCondition.requiredObjectives ? false : false;
                }
            } else {
                return var2.bI() && var2.bJ() && !(var2 instanceof Turret) && !(var2 instanceof Extractor);
            }
        } else {
            return false;
        }
    }

    public void h(String var1) {
        GameEngine.log("Map Script: " + var1);
    }

    public void a(class_637 var1) {
        if (this.g()) {
            this.h("Activiated trigger:" + var1.a + " (id:" + var1.b + ")");
        }

    }

    public boolean g() {
        return a && GameEngine.getGameEngine().bl;
    }

    public static void i(String var0) {
        GameNetEngine.g("Map ScriptError: " + var0);
    }

    public void a(int var1) {
        Iterator var2 = this.J.iterator();

        while(var2.hasNext()) {
            class_637 var3 = (class_637)var2.next();
            if (var3.j && var3.q != -1 && var1 >= var3.k + var3.q) {
                var3.j = false;
                var3.u = false;
            }

            if (!var3.j && !var3.u && var3.d()) {
                var3.u = true;
            }

            if ((var3.j || var3.u) && var3.e.b()) {
                var3.j = false;
                var3.u = false;
                var3.m = true;
            }

            if (var3.j && var3.p > 0 && var1 >= var3.k + var3.p) {
                var3.u = true;
            }

            if (var3.u) {
                var3.u = false;

                try {
                    class_622.a(this, var3);
                } catch (Exception var5) {
                    var5.printStackTrace();
                    var3.g("Error activating trigger: " + var5.getMessage());
                }
            }
        }

    }

    public boolean h() {
        boolean var1 = false;
        GameEngine var2 = GameEngine.getGameEngine();
        Unit[] var3 = Unit.bE.a();
        int var4 = 0;

        for(int var5 = Unit.bE.size(); var4 < var5; ++var4) {
            Unit var6 = var3[var4];
            if (var6.bX == PlayerData.i && var6 instanceof OrderableUnit && var6.bT() && !var6.o()) {
                int var7 = 0;

                for(int var8 = Unit.bE.size(); var7 < var8; ++var7) {
                    Unit var9 = var3[var7];
                    boolean var10;
                    if (!var2.ay()) {
                        var10 = var9.bX == var2.playerTeam;
                    } else {
                        var10 = !var9.bX.w;
                        if (var6.cO()) {
                            var10 = true;
                        }
                    }

                    if (var9.bX != null && var9.bX.site < 0) {
                        var10 = false;
                    }

                    if (var10 && var9.bX != var6.bX && var9 instanceof OrderableUnit && !var9.i() && var9.bT() && class_340.a(var9.xCord, var9.yCord, var6.xCord, var6.yCord) < 28900.0F) {
                        var6.e(var9.bX);
                        var6.cJ = 60.0F;
                        var1 = true;
                        break;
                    }
                }
            }
        }

        return var1;
    }
}
