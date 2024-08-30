package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Paint$Cap;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.TeamStats;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.class_775;
import com.corrodinggames.rts.gameFramework.class_970;
import com.corrodinggames.rts.gameFramework.class_971;
import com.corrodinggames.rts.gameFramework.class_972;
import com.corrodinggames.rts.gameFramework.TeamHistory;
import com.corrodinggames.rts.gameFramework.g.class_162;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.y
public strictfp class class_542 {
    private ArrayList e;
    private ChartType f;
    private class_543 g;
    private ArrayList h;
    private class_520[] i;
    private ArrayList j;
    private class_520[] k;
    private ArrayList l;
    private class_520[] m;
    class_524 a;
    private long n;
    private TeamImageCache o;
    private TeamImageCache[] p;
    private Rect q;
    private Rect r;
    private ArrayList s;
    private ArrayList t;
    private int u;
    private int v;
    private int w;
    Rect b;
    Paint c;
    Paint d;

    public static class_542 a() {
        GameEngine var0 = GameEngine.getGameEngine();
        ArrayList var1 = var0.stats.d();
        ArrayList var2 = DisplayedStat.a();
        return new class_542(var1, var2);
    }

    private class_542(ArrayList var1, ArrayList var2) {
        this.f = ChartType.overallStats;
        this.g = class_543.ABSOLUTE;
        this.h = new ArrayList();
        this.i = new class_520[class_972.values().length];
        this.j = new ArrayList();
        this.k = new class_520[class_972.values().length];
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.b = new Rect();
        this.e = var2;
        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            TeamStats var4 = (TeamStats)var3.next();
            PlayerData var5 = PlayerData.getPlayerData(var4.l.b());
            this.h.add(new class_524(var4.l, var5.name, var5.K()));
        }

        ArrayList var10 = PlayerData.f();
        Iterator var11 = var10.iterator();

        while(var11.hasNext()) {
            Integer var13 = (Integer)var11.next();
            ArrayList var6 = new ArrayList();
            Iterator var7 = var1.iterator();

            while(var7.hasNext()) {
                TeamStats var8 = (TeamStats)var7.next();
                PlayerData var9 = PlayerData.getPlayerData(var8.l.b());
                if (var9.team == var13) {
                    var6.add(var8);
                }
            }

            if (!var6.isEmpty()) {
                class_775 var16 = new class_775(var6);
                this.j.add(new class_524(var16.l, "Team " + PlayerData.getTeamName(var13), PlayerData.i(var13)));
            }
        }

        class_972[] var12 = class_972.values();
        int var14 = var12.length;

        for(int var15 = 0; var15 < var14; ++var15) {
            class_972 var17 = var12[var15];
            this.i[var17.ordinal()] = new class_520(var17, this.h);
            this.k[var17.ordinal()] = new class_520(var17, this.j);
        }

        this.l = this.h;
        this.m = this.i;
        this.b();
    }

    public void b() {
        this.f = ChartType.overallStats;
        GameEngine var1 = GameEngine.getGameEngine();
        this.c = new Paint();
        this.c.a(true);
        this.c.a(Paint$Align.a);
        this.c.a(255, 0, 255, 0);
        var1.b(this.c, 16.0F);
        this.d = new Paint();
        this.d.a(true);
        this.d.a(Paint$Align.c);
        this.d.a(255, 0, 255, 0);
        var1.b(this.d, 16.0F);
        this.c();
    }

    private void c() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.p = new TeamImageCache[ChartType.values().length + 2];
        this.p[0] = var1.bO.a(AssetsID$drawable.stats_button_info);
        this.p[1] = var1.bO.a(AssetsID$drawable.stats_button_income);
        this.p[2] = var1.bO.a(AssetsID$drawable.stats_button_armyvalue);
        this.p[3] = var1.bO.a(AssetsID$drawable.stats_button_buildingvalue);
        this.p[4] = var1.bO.a(AssetsID$drawable.stats_button_totalvalue);
        this.p[5] = var1.bO.a(AssetsID$drawable.stats_toggle_relative);
        this.p[6] = var1.bO.a(AssetsID$drawable.stats_toggle_teams);
        this.r = new Rect(0, 0, this.p[0].m(), this.p[0].l());
    }

    public void a(Rect var1, Rect var2, float var3, boolean var4, boolean var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        InterfaceEngine var7 = var6.bS;
        boolean var8 = true;
        if (var5) {
            int var9 = ChartType.values().length;
            int var10 = var6.a(30);
            int var11 = var10 * 2;
            int var12 = var6.a(20);
            int var13 = var2.d - var10 - var12;
            byte var14 = 2;
            int var15;
            if (var7.c) {
                var15 = var9 + var14;
            } else {
                var15 = var9 - 1;
            }

            int var16 = var11 * var15 + var12 * (var15 - 1);
            int var17 = (int)(var6.cF / 2.0F - (float)(var16 / 2));
            Paint var18 = new Paint();
            Paint var19 = new Paint();
            var19.a(100, 255, 255, 255);

            Paint var22;
            for(int var20 = 0; var20 < var9; ++var20) {
                ChartType var21 = ChartType.values()[var20];
                if (var7.c || var21 != ChartType.overallStats) {
                    if (var7.a(var17, var13, var11, var10, class_551.NONE, false)) {
                        if (this.f != var21) {
                            this.f = var21;
                            this.n = System.currentTimeMillis();
                            this.u = -1;
                            this.v = -1;
                            this.w = -1;
                        }

                        if (this.f != ChartType.overallStats) {
                            var7.c = true;
                        }
                    }

                    this.b.a(var17, var13, var17 + var11, var13 + var10);
                    var6.bO.a(var6.bS.bn, this.r, this.b, var18);
                    var22 = var19;
                    if (!var7.c || this.f == var21) {
                        var22 = var18;
                    }

                    var6.bO.a(this.p[var20], this.r, this.b, var22);
                    var17 += var12 + var11;
                }
            }

            var17 += var12;
            if (var7.c) {
                boolean var23 = this.g != class_543.ABSOLUTE;
                if (var7.a(var17, var13, var11, var10, class_551.NONE, false)) {
                    this.g = !var23 ? class_543.RELATIVE : class_543.ABSOLUTE;
                    this.n = System.currentTimeMillis();
                }

                this.b.a(var17, var13, var17 + var11, var13 + var10);
                Paint var24 = var18;
                if (this.f == ChartType.overallStats) {
                    var24 = var19;
                }

                var6.bO.a(var6.bS.bn, this.r, this.b, var24);
                var22 = var18;
                if (!var23 || this.f == ChartType.overallStats) {
                    var22 = var19;
                }

                var6.bO.a(this.p[5], this.r, this.b, var22);
                var17 += var12 + var11;
                var23 = this.l == this.j;
                if (var7.a(var17, var13, var11, var10, class_551.NONE, false)) {
                    if (!var23) {
                        this.l = this.j;
                        this.m = this.k;
                    } else {
                        this.l = this.h;
                        this.m = this.i;
                    }

                    this.n = System.currentTimeMillis();
                }

                this.b.a(var17, var13, var17 + var11, var13 + var10);
                var24 = var18;
                if (this.f == ChartType.overallStats) {
                    var24 = var19;
                }

                var6.bO.a(var6.bS.bn, this.r, this.b, var24);
                var22 = var18;
                if (!var23 || this.f == ChartType.overallStats) {
                    var22 = var19;
                }

                var6.bO.a(this.p[6], this.r, this.b, var22);
                int var10000 = var17 + var12 + var11;
            }

            if (this.f == ChartType.overallStats) {
                var8 = true;
            } else {
                var8 = false;
                var1.d = var13 - var6.a(10);
                if (var4) {
                    this.a(this.f.a(), this.g, var1);
                }
            }
        }

        if (var8) {
            this.a(var1, var3);
        }

    }

    private void a(Rect var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        float var4 = 1.5F;
        int var5 = var1.b + var3.a(25);
        int var6 = var1.d();
        String var7 = "123|";
        this.c.a((String)var7, 0, var7.length(), (Rect)this.b);
        float var8 = (float)(this.b.c() + 6);

        for(Iterator var9 = this.e.iterator(); var9.hasNext(); var5 = (int)((float)var5 + var8)) {
            DisplayedStat var10 = (DisplayedStat)var9.next();
            if (var10.d != 1.0F && var4 > 0.0F) {
                var10.d = class_340.a(var10.d, 1.0F, 0.01F * var4 * var2);
                var4 -= 1.0F - var10.d;
            }

            float var11 = var10.d;
            var11 = class_340.b(var11, 0.0F, 1.0F);
            String var12 = "";
            if (var10.b != null) {
                var12 = var10.b;
            } else {
                var12 = "" + (int)(var10.c * var11);
                if (var11 <= 0.0F) {
                    var12 = " ";
                }
            }

            String var13 = var10.a;
            float var14 = var10.d * 2.2F;
            var14 = class_340.b(var14, 0.0F, 1.0F);
            int var15 = 0;
            if (var14 > 0.0F) {
                var15 = (int)((float)var13.length() * var14);
            }

            var15 = class_340.b(var15, 0, var13.length());
            String var16 = "";
            if (var15 > 0 && var15 < var13.length() - 1) {
                var16 = "_";
            }

            var13 = var13.substring(0, var15) + var16 + class_340.d(" ", var13.length() + var16.length() - var15);
            var3.bO.a(var13, (float)var6 - 8.0F * this.c.k(), (float)var5, this.c);
            var3.bO.a(var12, (float)var6 + 8.0F * this.c.k(), (float)var5, this.d);
        }

    }

    private void a(class_972 var1, class_543 var2, Rect var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        this.a(var4.bO, var1, var2, var3);
    }

    private void a(class_28 var1, class_972 var2, class_543 var3, Rect var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        InterfaceEngine var6 = var5.bS;
        class_520 var7 = this.m[var2.ordinal()];
        float var8 = (float)(System.currentTimeMillis() - this.n) / 250.0F;
        Paint var9 = new Paint();
        var9.a(255, 0, 255, 0);
        var9.a(true);
        var9.c(true);
        var9.a(Typeface.a((Typeface)Typeface.c, 0));
        var5.b(var9, 14.0F);
        Paint var10 = new Paint(var9);
        var10.a(Paint$Align.b);
        var5.b(var10, 14.0F);
        Paint var11 = new Paint();
        var11.a(2.0F);
        if (GameEngine.aZ) {
            var11.a(3.0F);
        }

        var11.a(Paint$Cap.b);
        Rect var12 = new Rect();
        Paint var14 = var6.aD;
        String var15 = class_1009.a("gui.leaderboard.type." + var2.name());
        var14.a((String)var15, 0, var15.length(), (Rect)this.b);
        var1.a(var15, (float)var4.d(), (float)(var4.b + this.b.c()), var14);
        var12.b = var4.b + this.b.c() + 3;
        var12.d = var4.d - this.b.c() - 3;
        int var35 = Math.max(1, class_520.a(var7) - class_520.b(var7));
        float var36 = (float)var12.c() / (float)var35;
        String var16 = class_340.a(0L);
        int var13 = var1.b(var16, var10);
        var1.a(var16, (float)(var4.a + var13 / 2), (float)var4.d, var10);
        var12.a = var4.a + var13 / 2;
        String var17 = "123|";
        var9.a((String)var17, 0, var17.length(), (Rect)this.b);
        int var18 = this.b.c();
        String var19;
        int var21;
        int var22;
        if (var3 == class_543.ABSOLUTE) {
            var19 = class_162.a(class_520.c(var7).a(), class_520.a(var7));
            String var20 = class_162.a(class_520.c(var7).a(), class_520.b(var7));
            var13 = Math.max(var1.b(var19, var9), var1.b(var20, var9));
            var12.c = var4.c - var13 - 2;
            var21 = var18 / 2;
            var1.b(var12, var6.aM);
            var11.b(-13619152);

            for(var22 = 0; var22 <= 4; ++var22) {
                float var23 = (float)class_520.b(var7) + (float)var35 * (float)var22 / 4.0F;
                float var24 = (float)var12.d - (var23 - (float)class_520.b(var7)) * var36;
                String var25 = class_162.a(class_520.c(var7).a(), (int)var23);
                var1.a(var25, (float)(var12.c + 2), var24 + (float)var21, var9);
                if (var22 > 0 && var22 < 4) {
                    var1.a((float)var12.a, var24, (float)var12.c, var24, var11);
                }
            }
        } else {
            var12.c = var4.c - var5.a(10);
        }

        var19 = class_340.a((long)(class_520.d(var7) / 1000));
        var1.b(var19, var10);
        var1.a(var19, (float)var12.c, (float)var4.d, var10);
        float var37 = (float)var12.b() / (float)class_520.d(var7);
        float var29;
        int var30;
        float var31;
        float var32;
        int var42;
        int var46;
        float var52;
        int var56;
        float var63;
        if (var3 == class_543.ABSOLUTE) {
            label170:
            for(var21 = 0; var21 <= 2; ++var21) {
                Iterator var39 = this.l.iterator();

                while(true) {
                    boolean var26;
                    class_524 var41;
                    class_971 var43;
                    while(true) {
                        while(true) {
                            if (!var39.hasNext()) {
                                continue label170;
                            }

                            var41 = (class_524)var39.next();
                            var43 = var41.a.a(var2);
                            var26 = var21 == 0;
                            if (!var26) {
                                var46 = 220;
                                if (this.a != null) {
                                    if (var41 == this.a) {
                                        var46 = 255;
                                    } else {
                                        var46 = 50;
                                    }
                                }
                                break;
                            }

                            if (var41.c == -16777216) {
                                var46 = 255;
                                if (this.a != null) {
                                    if (var41 == this.a) {
                                        var46 = 255;
                                    } else {
                                        var46 = 50;
                                    }
                                }
                                break;
                            }
                        }

                        if (var21 == 2) {
                            if (var41 != this.a) {
                                continue;
                            }
                            break;
                        } else if (var21 != 1 || var41 != this.a) {
                            break;
                        }
                    }

                    class_970 var27 = (class_970)var43.get(0);
                    float var28 = (float)var12.a;
                    var29 = (float)var12.d - var36 * (float)(var27.b - class_520.b(var7));

                    for(var30 = 1; var30 < var43.size(); ++var30) {
                        var27 = (class_970)var43.get(var30);
                        var31 = (float)var12.a + var37 * (float)var27.a;
                        var32 = (float)var12.d - var36 * (float)(var27.b - class_520.b(var7));
                        int var33 = (int)((float)var46 * Math.min(1.0F, Math.max(0.0F, var8 - (float)var27.a / (float)class_520.d(var7))));
                        class_525 var34 = var41.a(var33, var26);
                        var1.a(var28, var29, var31, var29, var34);
                        var1.a(var31, var29, var31, var32, var34);
                        var28 = var31;
                        var29 = var32;
                    }
                }
            }
        } else {
            ArrayList var38 = class_520.e(var7);
            class_522 var40 = (class_522)var38.get(0);

            for(var42 = 1; var42 < var38.size(); ++var42) {
                class_522 var44 = (class_522)var38.get(var42);
                var52 = (float)var12.a + var37 * (float)class_522.a(var40);
                float var48 = (float)var12.a + var37 * (float)class_522.a(var44);
                float var53 = (float)var12.d;

                for(var56 = 0; var56 < this.l.size(); ++var56) {
                    var29 = var40.a(var56);
                    var63 = var53 - (float)var12.c() * var29;
                    if (var29 > 0.0F) {
                        class_524 var64 = (class_524)this.l.get(var56);
                        var32 = Math.min(1.0F, Math.max(0.0F, var8 - (float)class_522.a(var40) / (float)class_520.d(var7)));
                        class_525 var66 = var64.a((int)(var32 * 255.0F), false);
                        this.b.a((int)var52, (int)(var63 + 0.5F), (int)var48, (int)(var53 + 0.5F));
                        if (this.o != null) {
                            var1.a(this.o, this.q, (Rect)this.b, var66);
                        } else {
                            var1.b((Rect)this.b, var66);
                        }
                    }

                    var53 = var63;
                }

                var40 = var44;
            }
        }

        if (var12.b((int)var6.x, (int)var6.y)) {
            var6.a((float)var12.a, (float)var12.b, (float)var12.b(), (float)var12.c());
            var11.b(-1);
            var1.a(var6.x, (float)var12.b, var6.x, (float)var12.d, var11);
            var21 = (int)var6.x;
            var22 = (int)var6.y;
            var42 = (int)((var6.x - (float)var12.a) / var37);
            Iterator var57;
            if (this.v != var21 || this.w != var22) {
                this.v = var21;
                this.w = var22;
                this.u = var42;
                this.s.clear();
                this.t.clear();
                this.s.add(class_340.a((long)(this.u / 1000)));
                this.t.add(-1);
                class_524 var45 = null;
                if (var3 == class_543.ABSOLUTE) {
                    var52 = 30.0F;
                    Iterator var49 = this.l.iterator();

                    while(var49.hasNext()) {
                        class_524 var55 = (class_524)var49.next();
                        TeamHistory var60 = var55.a;
                        int var61 = var60.a(var2, this.u);
                        var63 = (float)var12.d - var36 * (float)(var61 - class_520.b(var7));
                        var31 = class_340.c(var63 - var6.y);
                        if (var31 < var52) {
                            var52 = var31;
                            var45 = var55;
                        }
                    }
                }

                this.a = var45;

                for(var57 = this.l.iterator(); var57.hasNext(); this.t.add(var30)) {
                    class_524 var50 = (class_524)var57.next();
                    TeamHistory var58 = var50.a;
                    var56 = var58.a(var2, this.u);
                    String var62 = class_162.a(class_520.c(var7).a(), var56) + " " + var50.b;
                    this.s.add(var62);
                    var30 = var50.c;
                    if (this.a != null && this.a != var50) {
                        byte var65 = 60;
                        var30 = Color.a(var65, Color.b(var30), Color.c(var30), Color.d(var30));
                    }
                }
            }

            this.b.a = var12.a + var5.a(5);
            this.b.b = var12.b + var5.a(5);
            this.b.d = this.b.b + var5.a(5) + var18 * this.s.size();
            String var47 = "";
            var57 = this.s.iterator();

            while(var57.hasNext()) {
                String var51 = (String)var57.next();
                if (var47.length() < var51.length()) {
                    var47 = var51;
                }
            }

            var46 = var1.b(var47, var9);
            this.b.c = this.b.a + var5.a(10) + var46;
            var1.b(this.b, var6.aL);
            int var54 = this.b.b + var18 + 3;

            for(int var59 = 0; var59 < this.s.size(); ++var59) {
                var9.b((Integer)this.t.get(var59));
                var1.a((String)this.s.get(var59), (float)(this.b.a + 3), (float)var54, var9);
                var54 += var18;
            }
        } else {
            this.a = null;
        }

    }
}
