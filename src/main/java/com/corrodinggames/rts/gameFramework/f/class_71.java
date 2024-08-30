package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Paint$Style;
import android.graphics.PointF;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.PorterDuff.Mode;
import android.view.Menu;
import android.view.MenuItem;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.appFramework.class_0;
import com.corrodinggames.rts.appFramework.class_198;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_1057;
import com.corrodinggames.rts.game.units.EditorOrBuilder;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.class_81;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_227;
import com.corrodinggames.rts.game.units.a.class_230;
import com.corrodinggames.rts.game.units.a.class_231;
import com.corrodinggames.rts.game.units.a.class_235;
import com.corrodinggames.rts.game.units.a.class_242;
import com.corrodinggames.rts.game.units.a.class_243;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.e.class_1067;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.g.class_794;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.class_62;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_987;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.f.a.class_186;
import com.corrodinggames.rts.gameFramework.f.a.class_188;
import com.corrodinggames.rts.gameFramework.g.class_162;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.i.class_800;
import com.corrodinggames.rts.gameFramework.l.class_1039;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.m.class_936;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.a
public strictfp class class_71 extends class_62 {
    InterfaceEngine a;
    GameEngine b;
    public boolean c = false;
    public boolean d = false;
    public boolean e;
    public float f;
    Paint g = new Paint();
    Paint h = new Paint();
    Paint i = new Paint();
    Paint j = new Paint();
    Paint k = new Paint();
    Paint l = new Paint();
    Paint m = new Paint();
    class_525 n;
    class_525 o;
    Paint p = new Paint();
    Paint q;
    Paint r;
    Rect s = new Rect();
    RectF t = new RectF();
    Rect u = new Rect();
    Rect v = new Rect();
    Rect w = new Rect();
    RectF x = new RectF();
    RectF y = new RectF();
    Rect z = new Rect();
    RectF A = new RectF();
    Rect B = new Rect();
    RectF C = new RectF();
    boolean D;
    float E;
    float F;
    float G;
    int H;
    boolean I;
    float J;
    float K;
    float L;
    float M;
    float N;
    float O;
    int P;
    float Q;
    float R;
    TeamImageCache S = null;
    TeamImageCache T = null;
    TeamImageCache U = null;
    TeamImageCache V = null;
    TeamImageCache W = null;
    TeamImageCache X = null;
    static Paint Y = new Paint();
    static PorterDuffColorFilter Z;
    Unit aa;
    class_226 ab;
    float ac;
    long ad;
    float ae;
    float af;
    String ag;
    String ah;
    String ai;
    String aj;
    String ak;
    public String al;
    String am = null;
    float an = 0.0F;
    public float ao;
    public boolean ap;
    ArrayList aq = new ArrayList();
    class_242 ar = new class_242(false);
    class_242 as = new class_242(true);
    class_227 at = new class_227();
    ArrayList au = new ArrayList();
    ArrayList av = new ArrayList();
    class_684 aw = new class_684();
    ArrayList ax = new ArrayList();
    RectF ay = new RectF();
    HashMap az = new HashMap();
    ArrayList aA = new ArrayList();
    Rect aB = new Rect();
    float aC;
    class_540 aD = new class_540();

    class_71(GameEngine var1, InterfaceEngine var2) {
        this.a = var2;
        this.b = var1;
        this.b();
    }

    public void a() {
        this.ag = class_1009.a("gui.unselectall");
        this.ah = class_1009.a("gui.common.allyUnit");
        this.ai = class_1009.a("gui.common.enemyUnit");
        this.aj = class_1009.a("gui.common.neutralUnit");
        this.ak = class_1009.a("gui.infoText.ownedBy");
        this.al = class_1009.a("gui.infoText.unitCapReached");
    }

    public void b() {
        this.a();
        this.S = this.b.bO.a(AssetsID$drawable.zoom_button);
        this.T = this.b.bO.a(AssetsID$drawable.lock_icon_menu);
        this.U = this.b.bO.a(AssetsID$drawable.pause);
        this.V = this.b.bO.a(AssetsID$drawable.replay_pause);
        this.W = this.b.bO.a(AssetsID$drawable.fast);
        this.X = this.b.bO.a(AssetsID$drawable.replay_leaderboard);
        Y.a(255, 30, 30, 30);
        Y.a((ColorFilter)Z);
        Y.d(true);
        this.q = new Paint();
        this.q.a(255, 255, 255, 255);
        this.q.a(Paint$Align.a);
        this.q.c(true);
        this.q.a(true);
        this.r = new Paint();
        this.r.a(255, 255, 255, 255);
        this.r.a(Paint$Align.a);
        this.r.c(true);
        this.r.a(true);
        this.n = new class_525();
        this.n.b(Color.a(190, 255, 255, 255));
        this.n.o();
        this.o = new class_525();
        this.o.b(Color.a(133, 255, 255, 255));
        this.o.o();
        this.aA.clear();

        for(int var1 = 0; var1 < 10; ++var1) {
            this.aA.add(new class_72(this, var1 < 3));
        }

    }

    private float p() {
        float var1 = 4.6F / this.b.cY;
        if (var1 > 4.6F) {
            var1 = 4.6F;
        }

        return var1;
    }

    private float q() {
        return this.r() / this.b.cY;
    }

    private float r() {
        return this.b.cF / this.b.bL.i() < this.b.cH / this.b.bL.j() ? this.b.cF / this.b.bL.i() : this.b.cH / this.b.bL.j();
    }

    void a(float var1) {
        float var2;
        float var5;
        float var6;
        float var7;
        float var8;
        float var9;
        float var10;
        if (this.b.settingsEngine.showZoomButton) {
            var2 = this.b.cj * 0.7F;
            int var3 = (int)(50.0F * var2);
            int var4 = (int)this.b.cp;
            var5 = class_1039.c();
            if (var5 > 20.0F) {
                var3 = (int)((float)var3 + (var5 - 20.0F));
            }

            if (this.D) {
                this.s.a(var3 - 4, (int)((float)var4 - 50.0F * this.b.cj), var3 + 4, (int)((float)var4 + 50.0F * this.b.cj));
                this.i.a();
                this.i.b(Color.a(255, 0, 0, 0));
                this.b.bO.b(this.s, this.i);
            }

            var6 = (float)var4;
            if (this.b.cV > 1.0F) {
                var6 -= (this.b.cV - 1.0F) * 3.0F * this.b.cj;
            } else {
                var7 = 20.0F;
                var6 += (this.b.cV * -var7 + var7 + 1.0F) * this.b.cj;
            }

            var7 = 48.0F * var2;
            var8 = 54.0F * var2;
            var9 = var7 / 2.0F;
            var10 = var8 / 2.0F;
            if (var6 < var10) {
                var6 = var10;
            }

            if (var6 > this.b.cm - var10) {
                var6 = (float)((int)(this.b.cm - var10));
            }

            this.s.a((int)((float)var3 - var9), (int)(var6 - var10), (int)((float)var3 + var9), (int)(var6 + var10));
            if (!this.D) {
                Y.a(140, 215, 215, 215);
            } else {
                Y.a(255, 255, 255, 255);
            }

            this.b.bO.a(this.S, (float)this.s.a, (float)this.s.b, Y, 0.0F, var2);
            boolean var11 = this.D;
            if (!this.D && this.a.b(this.s.a, this.s.b, this.s.b(), this.s.c(), class_551.ZOOM_BUTTON)) {
                this.D = true;
                this.E = this.a.y;
            }

            if (!this.a.I) {
                this.D = false;
            }

            if (this.D) {
                this.F += var1;
                this.a.d();
                float var12 = this.a.y - this.E;
                if (var12 > 180.0F) {
                    var12 = 180.0F;
                }

                if (var12 < -180.0F) {
                    var12 = -180.0F;
                }

                var12 *= this.b.cV;
                if (var12 > 2.0F) {
                    this.b.cV -= 5.0E-4F * class_340.c(var12) * var1;
                    this.b.cW = false;
                    if (this.b.cV < this.q()) {
                        this.b.cV = this.q();
                        this.b.cW = true;
                    }
                } else if (var12 < -2.0F) {
                    this.b.cV += 5.0E-4F * class_340.c(var12) * var1;
                    this.b.cW = false;
                    if (this.b.cV > this.p()) {
                        this.b.cV = this.p();
                        this.b.cW = true;
                    }
                }
            } else {
                if (var11 && this.F < 12.0F) {
                }

                this.F = 0.0F;
            }
        }

        float var14;
        GameEngine var10000;
        if (this.b.settingsEngine.mouseSupport) {
            if (this.a.a(this.b.af(), this.b.ag()) && !this.a.L) {
                int var13 = this.b.ai();
                if (var13 != 0) {
                    this.G += (float)var13 / 120.0F * 0.18F;
                }

                if (this.G > 1.0F) {
                    this.G = 1.0F;
                }

                if (this.G < -1.0F) {
                    this.G = -1.0F;
                }
            }

            if (this.G != 0.0F) {
                var2 = 0.0032F * var1;
                if (this.G < 0.0F) {
                    var2 = -var2;
                }

                var2 += this.G * 0.18F * var1;
                var14 = this.G;
                this.G = class_340.a(this.G, class_340.c(var2));
                if (this.G == 0.0F) {
                    var2 = var14;
                }

                var2 *= this.b.cV;
                var10000 = this.b;
                var10000.cV += var2;
                this.b.cZ = true;
                this.b.da = this.b.af();
                this.b.db = this.b.ag();
                if (var2 != 0.0F) {
                    this.b.cW = false;
                }
            }
        }

        if (this.b.settingsEngine.gestureZoom && this.b.ac() && this.b.ae() >= 3) {
            this.R = 20.0F;
        }

        if (this.R < 10.0F) {
            this.I = false;
        }

        if (this.R > 0.0F) {
            this.R = class_340.a(this.R, var1);
            boolean var16 = this.b.ac() && this.b.ae() >= 3;
            this.a.aU = 3.0F;
            var14 = 0.0F;
            float var15 = 0.0F;
            var5 = 0.0F;
            if (!var16) {
                var14 = this.M;
                var15 = this.N;
                var5 = this.O;
            } else {
                int var17;
                for(var17 = 0; var17 < this.b.ae(); ++var17) {
                    var14 += this.b.b(var17);
                    var15 += this.b.c(var17);
                }

                var14 /= (float)this.b.ae();
                var15 /= (float)this.b.ae();
                var5 = 0.0F;

                for(var17 = 0; var17 < this.b.ae(); ++var17) {
                    var7 = this.b.b(var17);
                    var8 = this.b.c(var17);
                    var5 += class_340.b(var14, var15, var7, var8);
                }
            }

            if (this.I && this.P != this.b.ae()) {
                this.I = false;
            }

            if (!this.I && var16) {
                this.I = true;
                this.J = var14;
                this.K = var15;
                this.L = var5;
                this.Q = this.b.cV;
                this.M = var14;
                this.N = var15;
                this.O = var5;
                this.P = this.b.ae();
            }

            if (var16) {
                var6 = this.N - var15;
                var6 *= 2.0F;
                var6 *= this.b.cV;
                var10000 = this.b;
                var10000.cV += var6 / 250.0F / this.b.cj;
                this.b.cW = false;
                var7 = this.O - var5;
                boolean var18 = false;
                if (var18) {
                    var10000 = this.b;
                    var10000.cV -= var7 / 350.0F / this.b.cj;
                    this.b.cW = false;
                }

                this.M = var14;
                this.N = var15;
                this.O = var5;
                this.P = this.b.ae();

                for(int var19 = 0; var19 < this.b.ae(); ++var19) {
                    var10 = this.b.b(var19);
                    float var20 = this.b.c(var19);
                    this.b.bO.a(var14, var15, var10, var20, this.a.aN);
                }

                var9 = 6.0F;
                this.b.bO.a(var14, var15, var14, this.K, this.a.aO);
                this.b.bO.a(var14, var15, var9, this.a.aN);
            }
        }

        if (this.b.cV > this.p()) {
            this.b.cV = this.p();
            this.b.cW = true;
        }

        if (this.b.cV < this.q()) {
            this.b.cV = this.q();
            this.b.cW = true;
        }

    }

    void b(float var1) {
        this.e = false;
        boolean var2 = false;
        boolean var3 = false;
        boolean var4 = false;
        byte var5 = 7;
        if (GameEngine.aw()) {
            var5 = 14;
        }

        boolean var6;
        if (this.b.ac() && this.a.ac == null) {
            var6 = this.a.c(this.b);
            byte var7 = 1;
            if (this.b.settingsEngine.mouseOrders == 2) {
                var7 = 2;
            }

            int var8 = this.b.f(var7);
            if (var6 || this.b.settingsEngine.mouseSupport && var8 != -1 && !this.a.J && !this.a.K) {
                float var9 = this.b.b(0);
                float var10 = this.b.c(0);
                if (var8 != -1) {
                    var9 = this.b.b(var8);
                    var10 = this.b.c(var8);
                }

                if (!this.c) {
                    var3 = true;
                    this.y.a = (float)((int)var9);
                    this.y.b = (float)((int)var10);
                }

                this.y.c = (float)((int)var9);
                this.y.d = (float)((int)var10);
                if (Math.abs(this.y.a - this.y.c) > (float)var5 || Math.abs(this.y.b - this.y.d) > (float)var5) {
                    this.d = true;
                }

                var2 = true;
            } else if (this.b.ae() == 2 && this.R == 0.0F) {
                this.y.a = (float)((int)this.b.b(0));
                this.y.b = (float)((int)this.b.c(0));
                this.y.c = (float)((int)this.b.b(1));
                this.y.d = (float)((int)this.b.c(1));
                this.d = false;
                var2 = true;
            }

            if (var2) {
                this.f += var1;
                if (this.f < 18.0F) {
                    var4 = true;
                }
            } else {
                this.f = 0.0F;
            }

            if (var2) {
                this.c = true;
                if (Math.abs(this.y.a - this.y.c) > (float)var5 || Math.abs(this.y.b - this.y.d) > (float)var5) {
                    this.z.d = (int)this.y.d;
                    this.z.b = (int)this.y.b;
                    this.z.a = (int)this.y.a;
                    this.z.c = (int)this.y.c;
                    class_340.a(this.z);
                    this.g.b(Color.a(255, 0, 255, 0));
                    this.g.a(Paint$Style.b);
                    this.g.a(1.0F);
                    this.b.bO.b(this.z, this.g);
                    this.e = true;
                }
            }
        }

        var6 = false;
        boolean var17 = false;
        if (this.c && !var2) {
            if (var4 && this.b.ae() == 3) {
                var17 = true;
            } else {
                var6 = true;
            }
        }

        if (var17) {
            this.d = false;
            this.c = false;
        }

        if (var2 && !var4 || var6) {
            if (var3) {
                Iterator var18 = GameObject.er.iterator();

                while(var18.hasNext()) {
                    GameObject var20 = (GameObject)var18.next();
                    if (var20 instanceof class_81) {
                        class_81 var22 = (class_81)var20;
                        var22.cI = var22.cG;
                    }
                }
            }

            if (var6) {
                this.d = false;
                this.c = false;
            }

            this.A.a(this.y);
            class_340.a(this.A);
            if (Math.abs(this.A.a - this.A.c) > (float)var5 || Math.abs(this.A.b - this.A.d) > (float)var5) {
                RectF var10000 = this.A;
                var10000.d /= this.b.cX;
                var10000 = this.A;
                var10000.b /= this.b.cX;
                var10000 = this.A;
                var10000.a /= this.b.cX;
                var10000 = this.A;
                var10000.c /= this.b.cX;
                this.A.a((float)this.b.cu, (float)this.b.cv);
                this.a.aU = 4.0F;
                this.a.aV = 40.0F;
                this.a.U = false;
                boolean var19 = this.a.a(this.b);
                boolean var21 = this.a.b(this.b);
                boolean var23 = true;
                boolean var11 = true;
                boolean var12 = false;
                Iterator var13;
                GameObject var14;
                if (this.b.settingsEngine.smartSelection_v2) {
                    var13 = GameObject.er.iterator();

                    label202:
                    while(true) {
                        OrderableUnit var15;
                        do {
                            do {
                                do {
                                    if (!var13.hasNext()) {
                                        break label202;
                                    }

                                    var14 = (GameObject)var13.next();
                                } while(!(var14 instanceof OrderableUnit));

                                var15 = (OrderableUnit)var14;
                            } while(!this.a((class_81)var15));
                        } while(var19 && var15.cI);

                        if (!var15.bI()) {
                            var23 = false;
                        }

                        if (var15.aS() && var15.l()) {
                            var11 = false;
                        }
                    }
                }

                if (var21) {
                    var23 = true;
                }

                var13 = GameObject.er.iterator();

                while(true) {
                    class_81 var24;
                    do {
                        do {
                            do {
                                while(true) {
                                    do {
                                        if (!var13.hasNext()) {
                                            if (var12) {
                                                var13 = GameObject.er.iterator();

                                                while(var13.hasNext()) {
                                                    var14 = (GameObject)var13.next();
                                                    if (var14 instanceof class_81) {
                                                        var24 = (class_81)var14;
                                                        var24.cH = this.b.bA;
                                                    }
                                                }
                                            }

                                            this.a.E();
                                            return;
                                        }

                                        var14 = (GameObject)var13.next();
                                    } while(!(var14 instanceof class_81));

                                    var24 = (class_81)var14;
                                    boolean var16 = false;
                                    if (this.a(var24)) {
                                        var16 = true;
                                        if (!var23 && var24.bI()) {
                                            var16 = false;
                                        }

                                        if (!var11 && var24.ak() && !var24.l()) {
                                            var16 = false;
                                        }
                                    }

                                    if (var21) {
                                        if (var16) {
                                            var16 = !var24.cI;
                                        } else if (var24.cI) {
                                            var16 = true;
                                        }
                                    } else if (var19 && var24.cI) {
                                        var16 = true;
                                    }

                                    if (var16) {
                                        this.a.j(var24);
                                        break;
                                    }

                                    this.a.l(var24);
                                }
                            } while(!var6);
                        } while(var24.cH + 900 >= this.b.bA);
                    } while((var19 || var21) && var24.cI);

                    var12 = true;
                }
            }
        }

    }

    private boolean a(class_81 var1) {
        if (!var1.bV && var1.cN == null) {
            float var2 = var1.xCord;
            float var3 = var1.yCord - var1.zCord;
            if (var3 <= 0.0F) {
                var3 += var1.zCord;
            }

            if (this.A.b(var2, var3) && (this.a.m(var1) || this.b.playerTeam.b()) && !var1.t()) {
                return true;
            }
        }

        return false;
    }

    public void a(String var1, int var2) {
        this.am = var1;
        this.an = (float)var2;
    }

    public void b(String var1, int var2) {
        if (this.an <= 0.0F || var1.equals(this.am)) {
            this.am = var1;
            this.an = (float)var2;
        }

    }

    public void a(String var1) {
        if (this.an > 0.0F && var1.equals(this.am)) {
            this.an = 0.0F;
        }

    }

    public void c(float var1) {
        if (this.an > 0.0F && this.am != null) {
            this.an = class_340.a(this.an, var1);
            this.b.bO.a(this.am, this.b.co, this.b.cp, this.a.aD, this.a.aI, 8.0F);
        }

    }

    public static boolean a(class_226 var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.ar && var0.n_();
    }

    public void c() {
        this.H = 0;
    }

    public class_987 a(class_226 var1, int var2, ArrayList var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        if (!GameEngine.av()) {
            return null;
        } else if (var1.M() != null) {
            return var1.M();
        } else if (var1 instanceof class_235) {
            return null;
        } else if (var1 instanceof class_227) {
            return null;
        } else if (var1.f() == DisplayType.rally) {
            return var4.bT.T;
        } else if (var1.e() == class_1052.patrol) {
            return var4.bT.Q;
        } else if (var1.e() == class_1052.guardUnit) {
            return var4.bT.P;
        } else if (var1.e() == class_1052.reclaimTarget) {
            return var4.bT.R;
        } else {
            if (var1.f() == DisplayType.upgrade) {
                int var5 = 0;
                Iterator var6 = var3.iterator();

                while(var6.hasNext()) {
                    class_226 var7 = (class_226)var6.next();
                    if (var7 != var1 && var7.f() == DisplayType.upgrade && this.a.b(var7)) {
                        ++var5;
                    }
                }

                if (var5 == 0) {
                    return var4.bT.S;
                }
            }

            DisplayType var8 = var1.f();
            if (var8 != DisplayType.infoOnly && var8 != DisplayType.infoOnlyNoBox && var8 != DisplayType.infoOnlyStockpile) {
                class_987 var9 = null;
                class_987[] var10 = var4.bT.ag;
                if (this.H < var10.length) {
                    var9 = var10[this.H];
                    ++this.H;
                }

                return var9;
            } else {
                return null;
            }
        }
    }

    public ArrayList d() {
        this.au.clear();
        Unit[] var1 = this.a.bZ.a();
        int var2 = 0;

        for(int var3 = this.a.bZ.size(); var2 < var3; ++var2) {
            Unit var4 = var1[var2];
            class_31 var5 = var4.r();
            if (!this.au.contains(var5)) {
                this.au.add(var5);
            }
        }

        return this.au;
    }

    public ArrayList a(Unit var1, ArrayList var2) {
        int var3 = 0;
        this.aq.clear();
        int var4 = this.a.q();
        if (var4 == 0) {
            if (this.b.settingsEngine.showChatAndPingShortcuts && this.b.M()) {
                this.aq.add(var3, this.a.q);
                this.aq.add(var3, this.a.r);
            }

            return this.aq;
        } else {
            if (InterfaceEngine.bO && var1 != null && !(var1 instanceof EditorOrBuilder)) {
                this.aq.add(this.ar);
                this.aq.add(this.as);
            }

            if (var1 == null) {
            }

            int var6;
            ArrayList var8;
            Iterator var9;
            class_226 var10;
            Iterator var12;
            if (var1 != null) {
                var3 = this.aq.size();
                if (var1.cG) {
                    ArrayList var5;
                    if (this.a.m(var1)) {
                        var5 = var1.N();
                        if (var5 != null) {
                            this.aq.addAll(var5);
                        }
                    } else {
                        var5 = var1.N();
                        if (var5 != null) {
                            this.aq.addAll(var5);
                        }
                    }
                }

                int var14 = 0;

                for(var6 = var2.size(); var14 < var6; ++var14) {
                    Unit var7 = (Unit)var2.get(var14);
                    if (this.a.m(var7) && (var7.r() != var1.r() || var7.V() != var1.V())) {
                        var8 = var7.N();
                        if (var8 != null) {
                            var9 = var8.iterator();

                            while(var9.hasNext()) {
                                var10 = (class_226)var9.next();
                                boolean var11 = false;
                                var12 = this.aq.iterator();

                                while(var12.hasNext()) {
                                    class_226 var13 = (class_226)var12.next();
                                    if (var13.N().equals(var10.N())) {
                                        var11 = true;
                                    }
                                }

                                if (!var11) {
                                    this.aq.add(var10);
                                }
                            }
                        }
                    }
                }
            }

            boolean var15 = false;
            var6 = 0;

            for(int var17 = var2.size(); var6 < var17; ++var6) {
                Unit var19 = (Unit)var2.get(var6);
                if (this.a.m(var19) && var19 instanceof OrderableUnit) {
                    OrderableUnit var21 = (OrderableUnit)var19;
                    if (!var21.aS()) {
                        var15 = true;
                    }
                }
            }

            Unit var16 = this.e();
            if (!var15 && var16 != null && this.a.m(var16)) {
                this.aq.add(var3, this.a.m);
                this.aq.add(var3, this.a.n);
            }

            boolean var18 = false;
            if (InterfaceEngine.bO && (this.b.settingsEngine.showSelectedUnitsList || var4 == 1)) {
                var18 = true;
            }

            if (GameEngine.at() && var4 > 0) {
                var18 = true;
            }

            if (var18 && !(var1 instanceof EditorOrBuilder)) {
                if (var4 == 1 && var16 != null) {
                    class_684 var20 = var16.e(true);
                    if (var20 != null && var20.size() > 0) {
                        int var22 = 0;

                        label152:
                        while(true) {
                            if (var22 >= var20.a) {
                                this.aw.clear();
                                var9 = var20.iterator();

                                while(true) {
                                    if (!var9.hasNext()) {
                                        break label152;
                                    }

                                    var10 = (class_226)var9.next();
                                    if (var10 instanceof class_230) {
                                        this.aw.add((class_230)var10);
                                    }

                                    this.aq.add(var10);
                                }
                            }

                            var10 = (class_226)var20.get(var22);
                            if (var10 instanceof class_230) {
                                class_230 var25 = (class_230)var10;
                                var12 = this.aw.iterator();

                                while(var12.hasNext()) {
                                    class_230 var27 = (class_230)var12.next();
                                    if (var27.a(var25)) {
                                        var20.set(var22, var27);
                                    }
                                }
                            }

                            ++var22;
                        }
                    }
                }

                var8 = this.d();
                this.av.clear();
                var9 = var8.iterator();

                while(var9.hasNext()) {
                    class_31 var23 = (class_31)var9.next();
                    class_243 var26 = var23.d();
                    var26.K();
                    this.av.add(var26);
                }

                Collections.sort(this.av);
                if (InterfaceEngine.bO) {
                    Collections.reverse(this.av);
                }

                var9 = this.av.iterator();

                while(var9.hasNext()) {
                    class_243 var24 = (class_243)var9.next();
                    if (InterfaceEngine.bO) {
                        this.aq.add(0, var24);
                    } else {
                        this.aq.add(var24);
                    }
                }
            }

            return this.aq;
        }
    }

    Unit e() {
        return this.a.bZ.size() > 0 ? this.a.bZ.a(0) : null;
    }

    Unit f() {
        Unit var1 = null;
        if (this.a.aX > 0) {
            Unit[] var2 = this.a.bZ.a();
            int var3 = 0;

            for(int var4 = this.a.bZ.size(); var3 < var4; ++var3) {
                Unit var5 = var2[var3];
                if (var5.cG) {
                    if (var1 == null) {
                        var1 = var5;
                    } else {
                        if (!a(var1, var5)) {
                            var1 = null;
                            break;
                        }

                        if (var1.V() > var5.V()) {
                            var1 = var5;
                        }
                    }
                }
            }
        }

        return var1;
    }

    public static boolean a(Unit var0, Unit var1) {
        class_31 var2 = var0.r();
        class_31 var3 = var1.r();
        if (var2 == var3) {
            return true;
        } else {
            if (var2 instanceof class_591 && var3 instanceof class_591) {
                class_591 var4 = (class_591)var2;
                class_591 var5 = (class_591)var3;
                if (var4.fL.contains(var3)) {
                    return true;
                }

                if (var4.fO != null && class_585.a(var4.fO, var5.x())) {
                    return true;
                }

                if (var5.fO != null && class_585.a(var5.fO, var4.x())) {
                    return true;
                }
            }

            return false;
        }
    }

    ArrayList g() {
        this.ax.clear();
        Unit[] var1 = this.a.bZ.a();
        int var2 = 0;

        for(int var3 = this.a.bZ.size(); var2 < var3; ++var2) {
            Unit var4 = var1[var2];
            if (var4 instanceof OrderableUnit) {
                this.ax.add((OrderableUnit)var4);
            }
        }

        return this.ax;
    }

    float h() {
        float var1 = this.b.cm / 14.0F / this.b.cj;
        var1 = class_340.b(var1, 25.0F * this.b.cj, 40.0F * this.b.cj);
        return var1;
    }

    private boolean c(class_226 var1) {
        if (var1.s()) {
            return true;
        } else if (var1 instanceof class_230) {
            class_230 var7 = (class_230)var1;
            return this.a.m(var7.b);
        } else {
            ArrayList var2 = this.g();
            class_1059 var3 = var1.N();
            Iterator var4 = var2.iterator();

            OrderableUnit var5;
            class_226 var6;
            do {
                if (!var4.hasNext()) {
                    return false;
                }

                var5 = (OrderableUnit)var4.next();
                var6 = var5.a((class_1059)var3);
            } while(var6 == null || !this.a.m(var5));

            return true;
        }
    }

    private boolean a(class_226 var1, ArrayList var2) {
        class_231 var3 = null;
        if (var1 instanceof class_231) {
            var3 = (class_231)var1;
        }

        if (var3 != null && var3.d == InterfaceEngine.cd) {
            return var3.e;
        } else {
            boolean var4 = this.b(var1, var2);
            if (var3 != null) {
                var3.d = InterfaceEngine.cd;
                var3.e = var4;
            }

            return var4;
        }
    }

    private boolean b(class_226 var1, ArrayList var2) {
        if (var1.s()) {
            return true;
        } else if (var1 instanceof class_230) {
            class_230 var7 = (class_230)var1;
            if (!var7.r(var7.b)) {
                return false;
            } else {
                return this.a.m(var7.b) || var7.a(var7.b, (PlayerData)this.b.playerTeam);
            }
        } else {
            class_1059 var3 = var1.N();
            Iterator var4 = var2.iterator();

            OrderableUnit var5;
            class_226 var6;
            do {
                do {
                    do {
                        if (!var4.hasNext()) {
                            return false;
                        }

                        var5 = (OrderableUnit)var4.next();
                        var6 = var5.a((class_1059)var3);
                    } while(var6 == null);
                } while(!var6.r(var5));
            } while(!this.a.m(var5) && !var6.a((Unit)var5, (PlayerData)this.b.playerTeam));

            return true;
        }
    }

    private boolean c(class_226 var1, ArrayList var2) {
        if (var1.s()) {
            return true;
        } else {
            if (var1 instanceof class_230) {
                class_230 var3 = (class_230)var1;
                if (var3.a(var3.b, true)) {
                    return true;
                }
            }

            Iterator var6 = var2.iterator();

            OrderableUnit var4;
            class_226 var5;
            do {
                if (!var6.hasNext()) {
                    return false;
                }

                var4 = (OrderableUnit)var6.next();
                var5 = var4.a((class_1059)var1.N());
            } while(var5 == null || !var5.a(var4, true));

            return true;
        }
    }

    private float d(class_226 var1, ArrayList var2) {
        int var3 = 0;
        float var4 = -1.0F;
        if (var1.o_()) {
            return -1.0F;
        } else {
            Iterator var5 = var2.iterator();

            while(var5.hasNext()) {
                OrderableUnit var6 = (OrderableUnit)var5.next();
                class_226 var7 = var6.a((class_1059)var1.N());
                if (var7 != null) {
                    float var8 = var7.p(var6);
                    if (var8 > var4) {
                        var4 = var8;
                        ++var3;
                    }
                }
            }

            return var4;
        }
    }

    private class_794 d(class_226 var1) {
        float var2 = -1.0F;
        class_794 var3 = null;
        if (var1.o_()) {
            return null;
        } else {
            if (var1 instanceof class_230) {
                class_230 var4 = (class_230)var1;
                class_794 var5 = class_794.b(var4.b, var1.N());
                if (var5 == null) {
                    return null;
                }

                if (var2 < (float)var5.a()) {
                    var2 = (float)var5.a();
                    var3 = var5;
                }
            }

            Iterator var9 = this.a.bZ.iterator();

            while(var9.hasNext()) {
                Unit var10 = (Unit)var9.next();
                if (var10 instanceof OrderableUnit) {
                    OrderableUnit var6 = (OrderableUnit)var10;
                    class_226 var7 = var6.a((class_1059)var1.N());
                    if (var7 != null) {
                        class_794 var8 = class_794.b(var6, var1.N());
                        if (var8 == null) {
                            return null;
                        }

                        if (var2 < (float)var8.a()) {
                            var2 = (float)var8.a();
                            var3 = var8;
                        }
                    }
                }
            }

            if (var3 == null) {
                return null;
            } else {
                return var3;
            }
        }
    }

    private float e(class_226 var1) {
        class_794 var2 = this.d(var1);
        return var2 == null ? 0.0F : var2.c();
    }

    float b(class_226 var1) {
        class_794 var2 = this.d(var1);
        return var2 == null ? 0.0F : (float)var2.d();
    }

    int d(float var1) {
        this.ap = false;
        byte var2 = 1;
        if (InterfaceEngine.bP) {
            var2 = 2;
        }

        boolean var3 = false;
        int var4 = 0;
        boolean var5 = false;
        class_549.a(var1);
        ArrayList var6 = this.g();
        Unit var7 = this.f();
        ArrayList var8 = null;
        if (this.a.ac != null) {
            var8 = this.a.ac.q(var7);
        }

        ArrayList var9;
        if (var8 != null) {
            var9 = var8;
        } else {
            var9 = this.a(var7, var6);
        }

        if (var7 == null && var9.size() > 0) {
            var7 = this.e();
            if (var7 == null && class_591.b != null) {
                var7 = Unit.c((class_31)class_591.b);
            }
        }

        this.a.t = false;
        if (var9.contains(this.a.m)) {
            this.a.t = true;
        }

        if (var7 == null) {
            var7 = this.e();
        }

        boolean var10 = true;
        if (var7 == null) {
            this.ad = -1L;
        }

        if (var7 != null) {
            int var11 = var9.size();
            if (var11 > 0) {
                ArrayList var12 = var9;
                float var13 = 2.0F;
                float var14 = this.h();
                float var15 = 2.0F;
                float var16 = var14 + var15;
                boolean var20 = false;
                float var17;
                float var18;
                float var19;
                if (!InterfaceEngine.bR) {
                    var19 = (float)(this.b.bW.b() + 2);
                    var18 = this.b.cl - this.b.bW.c;
                    var17 = this.b.bW.c;
                } else {
                    var19 = this.b.bW.b;
                    var18 = this.b.bW.c;
                    var17 = this.b.bW.c;
                    var20 = true;
                }

                if (InterfaceEngine.bO) {
                    var14 += 15.0F * this.b.cj;
                    var16 += 15.0F * this.b.cj;
                    var13 = 2.0F * this.b.cj;
                    if (GameEngine.au()) {
                        var13 = 2.0F * this.b.cj;
                    }

                    var16 += 2.0F;
                    var15 += 2.0F;
                    var19 += 3.0F;
                }

                float var22;
                if (!InterfaceEngine.a) {
                    boolean var21 = true;
                    if (this.a.f != null && this.a.aX == 1 && this.a.f.cG) {
                        var21 = false;
                    }

                    if (var21) {
                        var22 = this.i();
                        var19 += var22;
                        var19 += 2.0F;
                    }
                }

                int var82 = 0;
                var22 = 0.0F;
                float var23 = 0.0F;
                float var24 = 0.0F;
                Iterator var25 = var9.iterator();

                float var27;
                float var29;
                boolean var30;
                while(var25.hasNext()) {
                    class_226 var26 = (class_226)var25.next();
                    if (this.a(var26, var6)) {
                        ++var82;
                        var27 = var16 * var26.l();
                        int var28 = var2;
                        if (var26.m() > 0) {
                            var28 = var26.m();
                        }

                        var29 = var17 / (float)var28;
                        var30 = false;
                        if (var23 + var29 - 0.1F >= var17) {
                            var30 = true;
                        }

                        if (!var30 && var22 > 0.0F && var27 + 0.1F < var22) {
                            var30 = true;
                        }

                        if (var30) {
                            var24 += var22;
                            var22 = 0.0F;
                            var23 = 0.0F;
                        }

                        if (var22 < var27) {
                            var22 = var27;
                        }

                        var23 += var29;
                    }
                }

                if (var23 > 0.0F) {
                    var24 += var22;
                }

                float var83 = var19 + var24;
                float var84 = var19++;
                if (this.b.settingsEngine.showUnitGroups) {
                    var27 = this.b.cH - 34.0F * this.b.cj;
                } else {
                    var27 = this.b.cH;
                }

                this.ad = var7.id;
                var19 -= (float)((int)var7.br);
                float var85 = 0.0F;
                var29 = 1.0F + var14 * 0.25F;
                var30 = var83 - var7.br > var27 + var29;
                boolean var31 = var7.br > var29;
                this.ap = var30 || var31;
                if (this.b.settingsEngine.mouseSupport && !this.a.a(this.b.af(), this.b.ag())) {
                    int var32 = this.b.ai();
                    if (var32 != 0) {
                        var85 = -((float)var32 / 120.0F);
                    }
                }

                float var86 = 0.0F;
                if (var85 > 0.0F) {
                    this.ao = (float)((double)this.ao + 0.5 * (double)var16);
                }

                if (var85 < 0.0F) {
                    this.ao = (float)((double)this.ao - 0.5 * (double)var16);
                }

                float var33;
                if (var30) {
                    var33 = 0.4F;
                    this.s.a = (int)(var18 + 2.0F);
                    this.s.c = (int)(var18 + var17 - 2.0F);
                    this.s.b = (int)(var27 - var14 * var33);
                    this.s.d = (int)((float)this.s.b + var14 * var33);
                    if (this.a.a(this.s.a, this.s.b, this.s.b(), this.s.c(), "\\/", class_551.NONE, false, Color.a(80, 100, 150, 100), this.a.aC, (class_186)null) && this.a.J()) {
                        var86 += 3.0F * var16;
                        this.a.U = false;
                    }

                    var27 -= var16 * var33 + 2.0F;
                }

                if (var31) {
                    var33 = 0.4F;
                    this.s.a = (int)(var18 + 2.0F);
                    this.s.c = (int)(var18 + var17 - 2.0F);
                    this.s.b = (int)var84;
                    this.s.d = (int)((float)this.s.b + var14 * var33);
                    if (this.a.a(this.s.a, this.s.b, this.s.b(), this.s.c(), "/\\", class_551.NONE, false, Color.a(80, 100, 150, 100), this.a.aC, (class_186)null) && this.a.J()) {
                        var86 -= 3.0F * var16;
                        this.a.U = false;
                    }

                    var84 += var16 * var33 + 2.0F;
                }

                this.b.bO.i();
                this.ay.a(0.0F, var84 - 1.0F, this.b.cl, var27 + 1.0F);
                this.b.bO.a(this.ay);
                if (GameEngine.au()) {
                    if (this.ad != var7.id) {
                        this.ae = 0.0F;
                        this.af = var7.br;
                    } else if (this.ao != 0.0F) {
                        this.ae = this.ao;
                    } else {
                        if (!this.a.I) {
                            this.ao += this.ae * var1;
                        }

                        this.ae = class_340.a(this.ae, var1);
                    }
                }

                var7.br += this.ao + var86;
                this.ao = 0.0F;
                var33 = 0.0F;
                int var34 = (int)(var83 - var27);
                if (var34 > 0) {
                    if (var7.br > (float)var34 + var33) {
                        var7.br = (float)var34 + var33;
                    }

                    if (var7.br < 0.0F - var33) {
                        var7.br = 0.0F - var33;
                    }
                } else {
                    var7.br = 0.0F;
                }

                var3 = true;
                int var35 = -1;
                float var36 = 0.0F;
                var22 = 0.0F;
                var23 = 0.0F;
                this.c();
                Iterator var37 = var9.iterator();

                label760:
                while(true) {
                    class_226 var38;
                    do {
                        if (!var37.hasNext()) {
                            this.b.bO.j();
                            this.ay.f();
                            break label760;
                        }

                        var38 = (class_226)var37.next();
                    } while(!this.a(var38, var6));

                    ++var4;
                    boolean var39 = this.c(var38, var6);
                    ++var35;
                    float var40 = var14 * var38.l();
                    int var41 = var2;
                    if (var38.m() > 0) {
                        var41 = var38.m();
                    }

                    float var42 = var17 / (float)var41;
                    float var43;
                    float var44;
                    if (!var20) {
                        var43 = var40;
                        var44 = var42;
                    } else {
                        var43 = var42;
                        var44 = var40;
                    }

                    boolean var45 = false;
                    if (var23 + var44 - 0.1F > var17) {
                        var45 = true;
                    }

                    if (!var45 && var22 > 0.0F && var43 + 0.1F < var22) {
                        var45 = true;
                    }

                    if (var45) {
                        var36 += var22 + var15;
                        var22 = 0.0F;
                        var23 = 0.0F;
                    }

                    if (var22 < var43) {
                        var22 = var43;
                    }

                    if (!var20) {
                        this.s.a = (int)(var18 + var13);
                        this.s.c = (int)((float)this.s.a + var42 - var13 * 2.0F);
                        this.s.b = (int)(var36 + var19);
                        this.s.d = (int)((float)this.s.b + var40);
                        this.s.a((int)var23, 0);
                    } else {
                        this.s.a = (int)(var18 + var13 + var36);
                        this.s.c = (int)((float)this.s.a + var42 - var13 * 2.0F);
                        this.s.b = (int)var19;
                        this.s.d = (int)((float)this.s.b + var40);
                        this.s.a(0, (int)var23);
                    }

                    boolean var46 = true;
                    this.t.a(this.s);
                    if (!this.t.b(this.ay)) {
                        var46 = false;
                    }

                    var23 += var44;
                    DisplayType var47 = var38.f();
                    boolean var48 = false;
                    if (var47 == DisplayType.infoOnly || var47 == DisplayType.infoOnlyNoBox || var47 == DisplayType.infoOnlyStockpile) {
                        var48 = true;
                    }

                    boolean var50 = a(var38);
                    boolean var51 = var38.G();
                    Paint var52 = this.j;
                    boolean var53 = var39;
                    if (var47 == DisplayType.infoOnlyStockpile) {
                        var53 = true;
                    }

                    if (var53) {
                        var52.b(Color.a(70, 100, 100, 100));
                    } else {
                        var52.b(Color.a(50, 170, 100, 100));
                    }

                    if (var50) {
                        var52.b(Color.a(100, 180, 100, 100));
                    }

                    boolean var54 = false;
                    boolean var55 = false;
                    if (this.aa == var7 && this.ab == var38) {
                        var54 = true;
                    }

                    if (this.a.ac == var38) {
                        var54 = true;
                        var55 = true;
                    }

                    if (var54) {
                        var52.b(Color.a(80, 100, 100, 200));
                    }

                    if (var55) {
                        var52.b(Color.a(80, 100, 200, 100));
                    }

                    class_525 var56;
                    if (var51) {
                        var52.c((int)((float)var52.f() * 0.7F));
                        var56 = this.o;
                    } else {
                        var56 = this.n;
                    }

                    float var57 = 0.0F;
                    float var60;
                    if (var46) {
                        var57 = class_549.b(var7, var38, false);
                        if (var38.f() != DisplayType.infoOnlyNoBox) {
                            boolean var58 = this.a.a(var38);
                            float var59 = 0.0F;
                            if (var58) {
                                var60 = (float)(GameEngine.millis() % 1000L) / 1000.0F;
                                var59 = class_340.c(class_340.k(var60 * 180.0F));
                            }

                            int var61;
                            if (var57 != 0.0F) {
                                var60 = class_340.c(var57) * 0.7F - 0.3F;
                                var60 = class_340.b(var60, 0.0F, 1.0F);
                                if (var57 > 0.0F) {
                                    var61 = Color.a(110, 210, 210, 210);
                                } else {
                                    var61 = Color.a(110, 210, 110, 110);
                                }

                                int var62 = class_340.a(var61, var52.e(), var60);
                                var52 = this.i;
                                var52.b(var62);
                            }

                            this.a.a(this.s, var52, var56);
                            var60 = this.d(var38, var6);
                            Rect var10000;
                            if (var60 >= 0.0F) {
                                this.l.a(80, 0, 0, 100);
                                this.B.a(this.s);
                                var10000 = this.B;
                                var10000.c = (int)((float)var10000.c - (1.0F - var60) * (float)this.B.b());
                                this.b.bO.b(this.B, this.l);
                                this.m.a(190, 148, 189, 255);
                                this.b.bO.a((float)this.B.c, (float)this.B.b, (float)this.B.c, (float)this.B.d, this.l);
                            } else {
                                float var91 = this.e(var38);
                                if (var91 > 0.0F) {
                                    this.l.a(80, 100, 0, 0);
                                    this.B.a(this.s);
                                    var10000 = this.B;
                                    var10000.c = (int)((float)var10000.c - (1.0F - var91) * (float)this.B.b());
                                    this.b.bO.b(this.B, this.l);
                                    this.m.a(190, 148, 189, 255);
                                    this.b.bO.a((float)this.B.c, (float)this.B.b, (float)this.B.c, (float)this.B.d, this.l);
                                }
                            }

                            var61 = Color.a(255, 0, 0, 0);
                            if (InterfaceEngine.bO) {
                                var61 = Color.a(100, 0, 0, 0);
                                if (var51) {
                                    var61 = Color.a(50, 155, 155, 155);
                                }
                            }

                            boolean var92 = false;
                            if (var58) {
                                var92 = true;
                                var61 = Color.a((int)(100.0F + 150.0F * var59), 255, 255, 255);
                            }

                            this.a.a(this.s, var61, var92);
                        }
                    }

                    class_987 var87 = this.a(var38, var35, var12);
                    if (var87 != null && var46) {
                        String var88 = var87.c();
                        var60 = (float)this.b.bO.a("A", this.a.az);
                        this.b.bO.a(var88, (float)(this.s.a + 3), (float)this.s.b + var60 + 1.0F, this.a.az);
                    }

                    boolean var89 = false;
                    class_31 var90 = var38.i();
                    TeamImageCache var95 = var38.j();
                    Unit var93 = var38.i(var7);
                    if (var93 != null) {
                        var90 = var93.r();
                    }

                    if (var95 == null && var90 != null) {
                        var95 = var90.z();
                    }

                    float var64;
                    float var65;
                    float var66;
                    float var67;
                    boolean var69;
                    boolean var70;
                    int var72;
                    int var99;
                    if (var95 != null) {
                        Rect var94 = var38.v();
                        if (var94 == null) {
                            var94 = this.B;
                            var94.a(0, 0, var95.m(), var95.l());
                        }

                        var64 = (float)this.s.c() * 0.7F / (float)var94.c();
                        int var97 = (int)((float)this.s.d() - (float)var94.b() * 0.5F * var64);
                        var99 = (int)((float)this.s.e() - (float)var94.c() * 0.5F * var64);
                        this.p.a(100, 255, 255, 255);
                        RectF var102 = this.C;
                        var102.a((float)var97, (float)var99, (float)var97 + (float)var94.b() * var64, (float)var99 + (float)var94.c() * var64);
                        this.b.bO.a(var95, var94, var102, this.p);
                        var89 = true;
                    } else if (var90 != null) {
                        float var63 = (float)this.s.d();
                        var64 = (float)this.s.e();
                        if ((double)var57 > 0.5) {
                            ++var64;
                        }

                        if ((double)var57 < -0.5) {
                            --var64;
                        }

                        var65 = (float)this.s.c() * 0.7F;
                        var66 = (float)this.s.c() * 0.95F;
                        if (InterfaceEngine.bO) {
                            var65 = (float)this.s.c() * 0.4F;
                            var66 = (float)this.s.c() * 0.85F;
                        }

                        this.x.a(this.s);
                        if (this.x.b(this.ay)) {
                            this.b.bO.i();
                            this.b.bO.a(this.x);
                            UnitType.a(var90, var63, var64, 0.0F, 0.0F, var7.bX, var65, var66, false, false, var38.t(), var93);
                            if (var93 != null) {
                                var67 = var93.x();
                                float var68 = var93.bV();
                                int var71;
                                Paint var73;
                                Paint var74;
                                byte var75;
                                int var76;
                                byte var77;
                                int var78;
                                if (var68 != -1.0F && var38.t(var7)) {
                                    var69 = true;
                                    var70 = true;
                                    var71 = class_340.b(200, 0, 0, 150);
                                    var72 = class_340.b(120, 0, 0, 230);
                                    var73 = class_694.a(var71, Paint$Style.a);
                                    var74 = class_694.a(var72, Paint$Style.b);
                                    var75 = 3;
                                    var76 = (int)(this.x.b() / 3.0F) - 3;
                                    var77 = 0;
                                    var78 = var76 * 2;
                                    this.C.a(var63 - (float)var76, var64 + (float)var77, var63 - (float)var76 + (float)var78 * var68, var64 + (float)var77 + (float)var75);
                                    this.b.bO.a(this.C, var73);
                                    this.C.a(var63 - (float)var76, var64 + (float)var77, var63 - (float)var76 + (float)var78, var64 + (float)var77 + (float)var75);
                                    this.b.bO.a(this.C, var74);
                                } else if (var67 != -1.0F && var38.s(var7)) {
                                    var69 = true;
                                    var70 = true;
                                    var71 = class_340.b(200, 0, 150, 0);
                                    var72 = class_340.b(120, 0, 230, 0);
                                    var73 = class_694.a(var71, Paint$Style.a);
                                    var74 = class_694.a(var72, Paint$Style.b);
                                    var75 = 3;
                                    var76 = (int)(this.x.b() / 3.0F) - 3;
                                    var77 = 0;
                                    var78 = var76 * 2;
                                    this.C.a(var63 - (float)var76, var64 + (float)var77, var63 - (float)var76 + (float)var78 * var67, var64 + (float)var77 + (float)var75);
                                    this.b.bO.a(this.C, var73);
                                    this.C.a(var63 - (float)var76, var64 + (float)var77, var63 - (float)var76 + (float)var78, var64 + (float)var77 + (float)var75);
                                    this.b.bO.a(this.C, var74);
                                }
                            }

                            this.b.bO.j();
                        }

                        var89 = true;
                    }

                    TeamImageCache var96 = var38.h(var7);
                    if (var96 != null) {
                        Rect var98 = var38.v();
                        if (var98 == null) {
                            var98 = this.B;
                            var98.a(0, 0, var96.m(), var96.l());
                        }

                        var65 = (float)this.s.c() * 0.7F / (float)var98.c();
                        var99 = (int)((float)this.s.d() - (float)var98.b() * 0.5F * var65);
                        int var104 = (int)((float)this.s.e() - (float)var98.c() * 0.5F * var65);
                        this.p.b(var38.J());
                        RectF var106 = this.C;
                        var106.a((float)var99, (float)var104, (float)var99 + (float)var98.b() * var65, (float)var104 + (float)var98.c() * var65);
                        this.b.bO.a(var96, var98, var106, this.p);
                        var89 = true;
                    }

                    if (var46) {
                        String var100 = var38.d();
                        if (var50) {
                            this.b.bO.a((TeamImageCache)this.T, (float)(this.s.a + 25), this.s.g(), (Paint)null);
                        }

                        var65 = (float)this.b.bO.b(var100, this.a.aC);
                        if (var65 > (float)(this.s.b() - 2)) {
                            var66 = (float)this.b.bO.b(var100, this.a.aB);
                            if (var66 > (float)(this.s.b() - 2)) {
                                this.i.a(this.a.aA);
                            } else {
                                this.i.a(this.a.aB);
                            }
                        } else {
                            this.i.a(this.a.aC);
                        }

                        if (!var53) {
                            this.i.b(Color.a(255, 0, 100, 0));
                        }

                        if (var47 == DisplayType.rally) {
                            this.i.a(255, 255, 255, 255);
                        } else if (var47 != DisplayType.upgrade && var47 != DisplayType.action) {
                            if (var47 == DisplayType.queueUnit) {
                                class_31 var105 = var38.i();
                                if (var105 != null && var105.g() > 1) {
                                    if (!var53) {
                                        this.i.a(255, 117, 120, 15);
                                    } else {
                                        this.i.a(255, 235, 240, 30);
                                    }
                                }
                            } else if (var48) {
                                this.i.a(155, 255, 255, 255);
                            }
                        } else if (!var53) {
                            this.i.a(255, 19, 101, 94);
                        } else {
                            this.i.a(255, 39, 202, 189);
                        }

                        var99 = this.b.bO.a(var100, this.i);
                        var67 = this.s.g() + (float)(var99 / 2);
                        if (var48) {
                            var67 = this.s.g();
                        }

                        if (var89 && !var100.contains("\n")) {
                            if (var48) {
                                var67 = (float)(this.s.d - var99 / 2 - 1);
                            } else {
                                var67 = (float)(this.s.d - 6);
                            }
                        }

                        if (var48) {
                            class_936.a(var100, this.s.f(), var67, this.i);
                        } else {
                            this.b.bO.a(var100, this.s.f(), var67, this.i);
                        }
                    }

                    boolean var103 = false;
                    boolean var101 = false;
                    boolean var107 = false;
                    if (var87 != null && var87.a()) {
                        var103 = true;
                        var107 = true;
                    }

                    this.u.a(this.s);
                    if (GameEngine.au()) {
                        class_340.b(this.u, 2.0F);
                    }

                    this.a.a((float)this.u.a, (float)this.u.b, (float)this.u.b(), (float)this.u.c());
                    if (!this.d && this.u.b((int)this.a.z, (int)this.a.A) && this.ay.b((float)((int)this.a.z), (float)((int)this.a.A))) {
                        var5 = true;
                        if (GameEngine.av()) {
                            var101 = true;
                        }

                        if ((this.a.U || this.a.I) && this.a.U && this.a.J()) {
                            this.a.U = false;
                            var103 = true;
                        }
                    }

                    if (GameEngine.av() && this.a.ac == null) {
                        if (var101) {
                            this.aa = var7;
                            this.ab = var38;
                            this.ac = var36 + var19;
                        } else if (class_226.a(this.ab, var38)) {
                            this.aa = null;
                            this.ab = null;
                        }
                    }

                    boolean var110 = false;
                    if (var103 && !var107 && this.b.settingsEngine.mouseSupport && this.b.e(2)) {
                        var110 = true;
                    }

                    if (var103) {
                        InterfaceEngine.K();
                        if (var38.c(var7, var110)) {
                            var103 = false;
                        }

                        if (this.b.replayEngine.j()) {
                            var103 = false;
                        }

                        if (!this.c(var38)) {
                            var103 = false;
                        }
                    }

                    if (var103) {
                        boolean var108;
                        if (var38.e() != class_1052.none && var38.e() != class_1052.popupQueue) {
                            if (var38.e() != class_1052.patrol && var38.e() != class_1052.guardUnit && var38.e() != class_1052.pingMap) {
                                if (var38.e() != class_1052.setRally && var38.e() != class_1052.reclaimTarget && var38.e() != class_1052.repairTarget && var38.e() != class_1052.targetGround) {
                                    if (var38.e() == class_1052.placeBuilding) {
                                        if (a(var38)) {
                                            this.b.bM.b(class_648.l, 0.8F);
                                        } else if (!var39) {
                                            this.b.bM.b(class_648.l, 0.8F);
                                        } else {
                                            this.b.bM.b(class_648.g, 0.8F);
                                        }

                                        class_549.a(var7, var38, false, false);
                                        this.aa = null;
                                        this.ab = null;
                                        if (this.a.ac == null) {
                                            this.a.ai = false;
                                        }

                                        this.a.aa = var7;
                                        this.a.ac = var38;
                                        this.a.af = 0.0F;
                                        this.a.aq = -99.0F;
                                        this.a.ar = -99.0F;
                                        if (!this.a.ae) {
                                            this.a.ag = this.b.cI * this.b.cX;
                                            this.a.ah = this.b.cJ * this.b.cX;
                                        }

                                        this.a.ae = true;
                                        this.b.bL.e();
                                    } else if (var38.e() == class_1052.directToAction) {
                                        class_549.a(var7, var38, false, false);
                                        var38.c(var7);
                                    } else {
                                        if (var38.e() != class_1052.infoOnly) {
                                            throw new RuntimeException("unknown gui action:" + var38.e());
                                        }

                                        if (var38.C()) {
                                            this.aa = var7;
                                            this.ab = var38;
                                            this.ac = var36 + var19;
                                            this.a.ac = null;
                                        }
                                    }
                                } else {
                                    var108 = false;
                                    var69 = false;
                                    if (var38.e() == class_1052.targetGround) {
                                        var69 = true;
                                    }

                                    if (var110 && var69) {
                                        var108 = true;
                                    }

                                    if (var108) {
                                        SyncPacket var112 = this.a.x();
                                        if (!var38.I()) {
                                            this.a.a(var112, var38);
                                        } else {
                                            this.a.a(var112, var38, var108);
                                        }

                                        var112.g = true;
                                        var112.a(var38.z());
                                    } else {
                                        GameEngine.log("Clicked button: actionActive: " + var39);
                                        if (!var39) {
                                            this.b.bM.b(class_648.l, 0.8F);
                                        } else {
                                            class_549.a(var7, var38, false, false);
                                            this.aa = null;
                                            this.ab = null;
                                            this.a.ac = var38;
                                        }
                                    }
                                }
                            } else if (var110) {
                                if (var38 != null && var38.equals(this.a.ac)) {
                                    this.a.l();
                                }
                            } else if (!var39) {
                                this.b.bM.b(class_648.l, 0.8F);
                            } else {
                                class_549.a(var7, var38, false, false);
                                this.aa = null;
                                this.ab = null;
                                this.a.ac = var38;
                            }
                        } else {
                            this.a.ac = null;
                            var108 = false;
                            if (var107) {
                                var108 = true;
                            } else if (!var38.u()) {
                                var108 = true;
                            } else {
                                if (var38.k(var7)) {
                                    var108 = true;
                                } else if (this.aa == var7 && class_226.a(this.ab, var38)) {
                                    var108 = true;
                                }

                                this.aa = var7;
                                this.ab = var38;
                                this.ac = var36 + var19;
                            }

                            if (var108) {
                                byte var109 = 1;
                                if (var38.g()) {
                                    if (this.a.a(this.b)) {
                                        var109 = 5;
                                    }

                                    if (this.a.b(this.b)) {
                                        var109 = 10;
                                    }
                                }

                                var70 = false;
                                boolean var111;
                                if (!var107) {
                                    var111 = false;
                                    if (var7 != null && var38.b(var7, false) != -1) {
                                        var111 = true;
                                    }

                                    if (var110 && var111) {
                                        var70 = true;
                                    }
                                }

                                if (a(var38)) {
                                    this.b.bM.b(class_648.l, 0.8F);
                                } else if (!var39 && !var70) {
                                    this.b.bM.b(class_648.l, 0.8F);
                                } else {
                                    var111 = var38.g();
                                    if (var111 && !var70 && this.b.playerTeam.x() <= this.b.playerTeam.w()) {
                                        this.a.b(this.al);
                                    }

                                    if (var111) {
                                        if (!var70) {
                                            this.b.bM.b(class_648.h, 0.5F);
                                        } else {
                                            this.b.bM.b(class_648.i, 0.5F);
                                        }
                                    } else {
                                        this.b.bM.b(class_648.g, 0.8F);
                                    }

                                    class_549.a(var7, var38, var70, false);

                                    for(var72 = 0; var72 < var109; ++var72) {
                                        SyncPacket var113 = this.a.x();
                                        if (!var38.I()) {
                                            this.a.a(var113, var38);
                                        } else {
                                            this.a.a(var113, var38, var70);
                                        }

                                        if (var70) {
                                            var113.g = true;
                                        }

                                        var113.a(var38.z());
                                        if (!var70) {
                                            this.a.a((class_226)var38, (PointF)null, (Unit)null, (SyncPacket)var113);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (this.ab == var38) {
                        var10 = var39;
                    }
                }
            }
        }

        if (var7 != null && var7 == this.aa) {
            if (this.ab != null) {
                boolean var79 = true;
                if (GameEngine.av()) {
                    var79 = false;
                }

                boolean var80 = false;
                if (this.ab.u()) {
                    var80 = true;
                }

                if (GameEngine.av() && this.ab.h()) {
                    var80 = true;
                }

                if (var80) {
                    boolean var81 = true;
                    if (!var10) {
                        var81 = false;
                    }

                    if (this.a.a(this.ab, var79, this.aa, !var81, true, this.ac, false)) {
                        this.aa = null;
                    }
                }
            }
        } else {
            this.aa = null;
        }

        if (GameEngine.av() && !var5) {
            this.aa = null;
            this.ab = null;
        }

        return var4;
    }

    float i() {
        float var1 = this.b.cm / 14.0F / this.b.cj;
        var1 = class_340.b(var1, 25.0F * this.b.cj, 40.0F * this.b.cj);
        var1 = (float)((double)var1 * 0.9);
        return var1;
    }

    void a(float var1, int var2) {
        boolean var3 = true;
        if (var2 == 0) {
            var3 = true;
        }

        if (InterfaceEngine.a) {
            var3 = false;
        }

        if (this.a.aX > 0) {
            if (this.a.f != null && this.a.aX == 1 && this.a.f.cG) {
                var3 = false;
            }

            if (var3) {
                float var4 = this.i();
                if (this.a.b((int)(this.b.cl - this.b.bW.c + 2.0F), this.b.bW.b() + 2, (int)(this.b.bW.c - 4.0F), (int)var4, this.ag, class_551.UNSELECT_ALL_BUTTON, false, Color.a(140, 100, 100, 100)) && !this.a.T) {
                    this.a.d();
                    this.a.l();
                    this.a.y();
                }
            }

            PlayerData var18 = null;
            boolean var5 = false;
            this.az.clear();
            Unit var6 = null;
            Unit[] var7 = this.a.bZ.a();
            int var8 = 0;

            int var9;
            for(var9 = this.a.bZ.size(); var8 < var9; ++var8) {
                Unit var10 = var7[var8];
                if (var10.cG) {
                    var6 = var10;
                    if (this.a.m(var10)) {
                        class_31 var11 = var10.r();
                        Integer var12 = (Integer)this.az.get(var11);
                        if (var12 == null) {
                            this.az.put(var11, 1);
                        } else {
                            this.az.put(var11, var12 + 1);
                        }

                        var5 = true;
                    } else {
                        var18 = var10.bX;
                    }
                }
            }

            boolean var19 = this.b.bv;
            if (var18 != null && this.b.playerTeam != null && var18.b(this.b.playerTeam)) {
                var19 = true;
            }

            var9 = (int)this.h();
            int var20 = var9 + 2;
            int var21 = (int)(10.0F * this.b.cj);
            float var22 = (float)(this.b.bW.b() + var9 + 30);
            float var14 = this.b.cl - this.b.cq + (float)var21;
            float var13 = var22 + 5.0F;
            if (var6 != null) {
                var13 += (float)var20;
                var13 += (float)(var20 * var2);
                if (this.a.t) {
                    var13 -= (float)(2 * var20) * 0.4F;
                }
            }

            this.s.a((int)var14, (int)var13, (int)(var14 + this.b.cq - (float)(var21 * 2)), (int)(var13 + (float)var9));
            boolean var15 = false;
            if (!InterfaceEngine.bQ) {
                if (var2 < 3 && !var5 && var18 != null) {
                    Paint var16 = this.a.aF;
                    if (this.b.playerTeam.d(var18)) {
                        var16 = this.a.aG;
                    }

                    String var17 = this.a(var18);
                    this.a.a(var17, this.s, var16, var16);
                    var15 = true;
                }

                if (this.a.q() == 1 && var6 != null && (var6.cq() <= 3 || var18 != null && !var19)) {
                    String var23 = this.a(var6, false);
                    if (var15) {
                        var23 = "\n" + var23;
                        var23 = "\n" + var23;
                        var23 = "\n" + var23;
                    }

                    Paint var24 = this.i;
                    var24.a();
                    var24.b(Color.a(50, 100, 100, 100));
                    this.a.a(var23, this.s, this.a.aH, this.a.aH);
                }
            }
        }

    }

    public String a(PlayerData var1) {
        String var2 = "";
        boolean var3 = false;
        if (this.b.playerTeam.b()) {
            var3 = true;
        } else if (this.b.playerTeam.d(var1)) {
            var2 = var2 + this.ah;
        } else if (this.b.playerTeam.c(var1)) {
            var2 = var2 + this.ai;
        } else {
            var3 = true;
        }

        if (var3) {
            if (var1 == PlayerData.i) {
                var2 = var2 + this.aj;
            } else {
                var2 = var2 + "Team - " + var1.getPlayerTeamName();
            }
        }

        var2 = var2 + "\n";
        if (var1.name != null) {
            var2 = var2 + var1.name;
        }

        if (!var1.w && this.b.N() && var1.isTimeOut()) {
            var2 = var2 + "\n";
            var2 = var2 + "(disconnected)";
        }

        return var2;
    }

    public String a(Unit var1, boolean var2) {
        String var3 = "";
        if (var2) {
            var3 = var3 + var1.r().e() + "\n";
        }

        class_447 var4;
        if (var1.g() > 0.0F) {
            var4 = var1.cM();
            float var5 = var1.health / var1.totalHealth;
            class_447 var6 = class_447.a(var4, var5);
            boolean var7 = false;
            String var8 = var6.a(true, true, 3, var7);
            var3 = var3 + var8;
        } else {
            var3 = var3 + (int)Math.ceil((double)var1.health) + "/" + (int)var1.totalHealth + "\n";
        }

        if (var1.cA != 0.0F) {
            var3 = var3 + "(" + (int)var1.cx + "/" + (int)var1.cA + ")\n";
        }

        var4 = var1.dq();
        class_1069 var9 = var1.cz();
        if (var4 != null) {
            var9 = class_1069.d(var9);
            var9.a(var4);
        }

        if (!var9.c()) {
            Iterator var10 = var9.b.iterator();

            while(var10.hasNext()) {
                class_1067 var11 = (class_1067)var10.next();
                if (var11.b != 0.0 && !var11.a.a()) {
                    var3 = var3 + var11.a.a(var11.b, true, false) + "\n";
                }
            }
        }

        var3 = class_340.j(var3);
        return var3;
    }

    public static String a(class_226 var0, boolean var1) {
        String var2;
        if (var1) {
            var2 = "\n";
        } else {
            var2 = " | ";
        }

        String var3 = "";
        if (var0 instanceof class_281) {
            class_281 var4 = (class_281)var0;
            float var5 = var4.K();
            if (var5 < 1.0F) {
                GameEngine var6 = GameEngine.getGameEngine();
                float var7 = -1.0F;
                Unit[] var8 = var6.bS.bZ.a();
                int var9 = 0;

                for(int var10 = var6.bS.bZ.size(); var9 < var10; ++var9) {
                    Unit var11 = var8[var9];
                    float var12 = var11.cx();
                    if (var7 == -1.0F || var12 < var7) {
                        var7 = var12;
                    }
                }

                if (var7 == -1.0F) {
                    var7 = 1.0F;
                }

                float var13 = 1.0F / (var4.K() * var7 * 60.0F) + 1.0E-4F;
                var3 = var3 + class_340.h(var13) + var2;
            }
        }

        var3 = class_340.a(var3, var2);
        return var3;
    }

    public static String a(Unit var0, boolean var1, boolean var2, boolean var3) {
        String var4;
        if (var2) {
            var4 = "\n";
        } else {
            var4 = " | ";
        }

        String var5 = "";
        class_113 var6 = null;
        class_591 var7 = null;
        if (var0 instanceof class_113) {
            var6 = (class_113)var0;
            var7 = var6.x;
        }

        if (var1) {
            var5 = var5 + var0.r().e() + var4;
        }

        if (var7 == null || !var7.aO) {
            if (!var3) {
                var5 = var5 + "HP: " + (int)Math.ceil((double)var0.health) + "/" + (int)var0.totalHealth + var4;
            } else {
                var5 = var5 + "HP: " + (int)var0.totalHealth + var4;
            }
        }

        if (var0.cA != 0.0F) {
            if (!var3) {
                var5 = var5 + "Shield: " + (int)var0.cx + "/" + (int)var0.cA + var4;
            } else {
                var5 = var5 + "Shield: " + (int)var0.cA + var4;
            }
        }

        if (var6 != null) {
            float var8 = var6.y.l;
            if (var8 >= 1.0F) {
                var5 = var5 + "Armour: " + (int)var8 + var4;
            }
        }

        class_447 var16 = var0.dq();
        float var9 = var0.cy();
        if (var16 != null) {
            var9 += (float)var16.a();
        }

        if (var9 != 0.0F) {
            if (var9 < 0.0F) {
                var5 = var5 + "Income: -$" + class_340.a(-var9, 1) + var4;
            } else {
                var5 = var5 + "Income: +$" + class_340.a(var9, 1) + var4;
            }
        }

        if (var0 instanceof OrderableUnit) {
            OrderableUnit var10 = (OrderableUnit)var0;
            if (var10.bd() != 0.0F && !var3) {
                var5 = var5 + "Energy: " + class_340.g(var0.cB) + "/" + class_340.g(var10.bd()) + var4;
            }

            float var11 = var10.speed();
            if (!var10.aR()) {
                var11 = 0.0F;
            }

            if (var11 != 0.0F) {
                var5 = var5 + "Speed: " + class_340.g(var11) + var4;
            }

            if (var10.l()) {
                ArrayList var12 = var10.aX();
                if (var12.size() > 0) {
                    var5 = var5 + "Attack: ";
                    boolean var13 = true;

                    class_1057 var15;
                    for(Iterator var14 = var12.iterator(); var14.hasNext(); var5 = var5 + "/" + class_340.g(var15.a()) + "s") {
                        var15 = (class_1057)var14.next();
                        if (!var13) {
                            var5 = var5 + ", ";
                        }

                        var13 = false;
                        var5 = var5 + class_340.g(var15.a);
                        if (var15.d > 1) {
                            var5 = var5 + "x" + var15.d;
                        }
                    }

                    var5 = var5 + var4;
                }
            }

            float var20 = var10.attackRange();
            if (!var10.l()) {
                var20 = 0.0F;
            }

            if (var20 != 0.0F) {
                var5 = var5 + "Range: " + class_340.g(var20) + var4;
            }

            if (var3 && var10.ck()) {
                var5 = var5 + "Upgradable" + var4;
            }
        }

        if (!var3 && var0.cU > 0) {
            var5 = var5 + "Kills: " + var0.cU + var4;
        }

        boolean var17 = false;
        String var23;
        if (GameEngine.getGameEngine().bl) {
            var5 = var5 + "\n";
            var5 = var5 + "--Debug--" + var4;
            class_31 var18 = var0.r();
            var5 = var5 + "name: " + var18.i() + var4;
            if (var18 instanceof class_591) {
                class_800 var21 = ((class_591)var18).J;
                if (var21 != null) {
                    String var22 = var21.modName();
                    var22 = class_340.a((String)var22, (int)30);
                    var5 = var5 + "(mod: " + var22 + ")" + var4;
                }
            }

            if (var0.id != 0L) {
                var5 = var5 + "id: " + var0.id + var4;
            }

            if (var0.cF != 0) {
                var23 = "";

                for(int var24 = 0; var24 < 32; ++var24) {
                    if (class_447.a(var0.cF, var24)) {
                        if (var23.length() > 0) {
                            var23 = var23 + ",";
                        }

                        var23 = var23 + var24;
                    }
                }

                var5 = var5 + "flags: " + var23 + var4;
            }

            if (var0.cE != 0) {
                var5 = var5 + "ammo: " + var0.cE + var4;
            }

            if (!var0.cp) {
                var5 = var5 + "x: " + class_340.g(var0.xCord) + var4;
                var5 = var5 + "y: " + class_340.g(var0.yCord) + var4;
            }

            if (var0.cc != 0.0F || var0.cd != 0.0F) {
                var5 = var5 + "x/y speed: " + class_340.g(var0.cc) + ", " + class_340.g(var0.cd) + var4;
            }

            if (!var0.cp) {
                var5 = var5 + "height: " + class_340.g(var0.zCord) + var4;
                var5 = var5 + "dir: " + class_340.g(var0.cg) + var4;
            }

            if (var0.cm < 1.0F) {
                var5 = var5 + "built: " + class_340.g(var0.cm) + var4;
            }

            if (var0 instanceof class_113) {
                class_113 var25 = (class_113)var0;
                var5 = var5 + "frame: " + var25.a + var4;
                var5 = var5 + "drawLayer: " + var25.em + var4;
                if (var25.de() != null) {
                    var5 = var5 + "tags: " + var25.de() + var4;
                }

                if (var25.cO != null) {
                    var5 = var5 + "attachedTo: " + var25.cO.cB() + var4;
                }

                if (var25.bu != null && !var25.bu.bV) {
                    var5 = var5 + "customTarget1: " + var25.bu.cB() + var4;
                }

                if (var25.bv != null && !var25.bv.bV) {
                    var5 = var5 + "customTarget2: " + var25.bv.cB() + var4;
                }

                if (var25.bA != -9999) {
                    var5 = var5 + "customTimer: " + class_340.h((float)var25.bA / 1000.0F) + var4;
                }

                if (var25.bw != null && !var25.bw.isEmpty()) {
                    var5 = var5 + "-- memory --: " + var4 + var25.bw.debugMemory(true, true) + var4;
                }
            }

            var17 = true;
        }

        class_1069 var19 = var0.df();
        if (var19 != null && !var19.c()) {
            var23 = var19.a(var2, true, 10, var17, false);
            if (!var23.equals("")) {
                var5 = var5 + var23 + var4;
            }
        }

        var5 = class_340.a(var5, var4);
        return var5;
    }

    void j() {
        class_72 var2;
        for(Iterator var1 = this.aA.iterator(); var1.hasNext(); var2.h = true) {
            var2 = (class_72)var1.next();
        }

    }

    void k() {
        Iterator var1 = this.aA.iterator();

        while(var1.hasNext()) {
            class_72 var2 = (class_72)var1.next();
            var2.b();
        }

        this.am = null;
        this.an = 0.0F;
    }

    void a(int var1, int var2, int var3, String var4, String var5, Paint var6, float var7) {
        int var8 = (int)((double)var3 * 2.5);
        int var9 = (int)(40.0F * this.b.cj);
        int var10 = var1 + var3 / 2;
        int var11 = (int)((float)(var2 - var9) - 35.0F * this.b.cj);
        this.aB.a(var10 - var8 / 2, var11, var8, var9);
        this.a.a(this.aB.a, this.aB.b, this.aB.c, this.aB.d, "", Color.a(180, 100, 100, 100), this.a.aC, false, (class_186)null, (class_188)null);
        this.s.a(this.aB.a, this.aB.b, this.aB.c, this.aB.d);
        Rect var10000 = this.s;
        var10000.c = (int)((float)var10000.c * var7);
        this.b.bO.c(this.s, var6);
        this.b.bO.a(var4, (float)var10, (float)var11 + (this.a.aC.k() + 5.0F) * 1.0F, this.a.aC);
        this.b.bO.a(var5, (float)var10, (float)var11 + (this.a.aC.k() + 5.0F) * 2.0F, this.a.aC);
    }

    void a(float var1, boolean var2) {
        float var3 = this.b.cj * 0.7F;
        if (GameEngine.au() && (double)var3 < 0.7) {
            var3 = 0.7F;
        }

        int var4 = this.U.m();
        int var5 = (int)((float)var4 * var3);
        int var6 = 4 + var5 / 2;
        int var7 = 4 + var5 / 2;
        if (this.b.g(111)) {
            boolean var8 = false;
            if (!this.a.u) {
                var8 = this.a.l();
            }

            if (!var8) {
                this.a.u = !this.a.u;
            }
        }

        if (this.a.u) {
            this.aC += 0.008F * var1;
            if (this.aC > 1.0F) {
                this.aC = 0.0F;
            }

            float var21 = class_340.j(this.aC * 180.0F);
            this.h.c(150 + (int)(100.0F * var21));
        } else {
            this.aC = 0.0F;
            this.h.c(80);
        }

        this.v.a(var6, var7, var6 + var5, var7 + var5);
        this.v.a(-(var5 / 2), -(var5 / 2));
        if (var2) {
            this.b.bO.a(this.U, (float)this.v.a, (float)this.v.b, this.h, 0.0F, var3);
            if (this.b.settingsEngine.newRender) {
                this.B.a(this.v.d() - 4, this.v.e() - 4, this.v.d() + 4, this.v.e() + 4);
                this.p.a(100, 0, 155, 0);
                this.b.bO.b(this.B, this.p);
            }
        }

        if (GameEngine.au()) {
            class_340.a(this.v, 4.0F);
        }

        if (this.a.U && !this.a.T && this.v.b((int)this.a.x, (int)this.a.y)) {
            this.a.U = false;
            this.a.u = !this.a.u;
        }

        this.a.a(this.v);
        if (this.b.replayEngine.j()) {
            this.h.c(80);
            if (this.b.replayEngine.v != 1) {
                this.h.c(200);
            }

            var4 = this.W.q;
            var5 = (int)((float)var4 * this.b.cj * 1.6F);
            var6 = (int)(this.b.cF / 2.0F);
            var7 = 7 + (int)this.a.aE.k();
            String var22 = class_340.a((long)(this.b.by / 1000));
            this.b.bO.a(var22, (float)var6, (float)var7, this.a.aE);
            var7 += var5 / 2 + 10;
            var6 += var5 / 2 + 5;
            this.v.a(var6, var7, var6 + var5, var7 + var5);
            this.v.a(-this.v.b() / 2, -this.v.c() / 2);
            if (var2) {
                this.b.bO.a(this.W, (float)this.v.a, (float)this.v.b, this.h, 0.0F, (float)(var5 / var4));
            }

            if (this.a.U && !this.a.T && this.v.b((int)this.a.x, (int)this.a.y)) {
                this.a.U = false;
                this.b.replayEngine.b();
            }

            if (this.b.bt != 1.0F && var2) {
                this.b.bO.a("x" + this.b.bt, (float)(this.v.d() + var5 / 2), (float)this.v.e(), this.a.aC);
            }

            TeamImageCache var9 = this.V;
            var4 = var9.q;
            var5 = (int)((float)var4 * this.b.cj * 1.6F);
            var6 -= var5 + 5;
            this.v.a(var6, var7, var6 + var5, var7 + var5);
            this.v.a(-this.v.b() / 2, -this.v.c() / 2);
            if (var2) {
                this.b.bO.a(var9, (float)this.v.a, (float)this.v.b, this.h, 0.0F, (float)(var5 / var4));
            }

            if (this.a.U && !this.a.T && this.v.b((int)this.a.x, (int)this.a.y)) {
                this.a.U = false;
                this.b.replayEngine.a();
            }

            var9 = this.X;
            var6 = (int)(this.b.cl - this.b.cq - (float)(var5 + 5));
            this.v.a(var6, var7, var6 + var5, var7 + var5);
            this.v.a(-this.v.b() / 2, -this.v.c() / 2);
            if (var2) {
                this.b.bO.a(var9, (float)this.v.a, (float)this.v.b, this.h, 0.0F, (float)(var5 / var4));
            }

            if (this.a.U && !this.a.T && this.v.b((int)this.a.x, (int)this.a.y)) {
                class_162 var10 = this.b.cg;
                if (var10 != null) {
                    var10.c();
                }
            }
        }

        if (this.a.u) {
            this.b.cU = false;
            int var23 = this.b.a(190);
            this.s.a = (int)(this.b.cF / 2.0F - (float)(var23 / 2));
            this.s.c = (int)(this.b.cF / 2.0F + (float)(var23 / 2));
            int var24 = this.b.a(34);
            int var25 = var24 + this.b.a(15);
            Menu var11 = this.o();
            int var12 = 1 + var11.size();
            int var13 = this.b.a(50) + var25 * var12;
            this.s.b = (int)(this.b.cp - (float)(var13 / 2));
            this.s.d = (int)(this.b.cp + (float)(var13 / 2));
            if (var2) {
                this.a.bt.c(this.b.bO, this.s);
            }

            int var14 = this.s.b + this.b.a(40);
            int var15 = this.b.a(152);
            int var16 = (int)(this.b.cF / 2.0F - (float)(var15 / 2));
            int var18 = Color.a(140, 100, 100, 100);
            if (this.a.a(var16, var14, var15, var24, class_1009.a("menus.ingame.resume"), class_551.NONE, false, var18, this.a.aD, this.a.br)) {
                this.a.U = false;
                this.a.aV = 40.0F;
                this.a.u = false;
            }

            int var17 = var14 + var25;

            for(int var19 = 0; var19 < var11.size(); ++var19) {
                MenuItem var20 = var11.getItem(var19);
                if (this.a.a(var16, var17, var15, var24, var20.getTitle().toString(), class_551.NONE, false, var18, this.a.aD, this.a.br)) {
                    this.a(var20.getItemId());
                    this.a.U = false;
                    this.a.aV = 40.0F;
                }

                var17 += var25;
            }

            this.a.a(this.s);
        }

    }

    public void l() {
        this.a(20);
    }

    public void m() {
        this.a(21);
    }

    public void n() {
        this.a(16);
    }

    void a(int var1) {
        class_0 var2 = this.b.ao;
        if (var2 == null) {
            GameEngine.print("selectMenuOption: gameView==null");
        } else {
            class_198 var3 = var2.i();
            if (var3 == null) {
                GameEngine.print("selectMenuOption: inGameActivity==null");
            } else {
                var3.c(var1);
            }
        }
    }

    Menu o() {
        this.aD.clear();
        class_0 var1 = this.b.ao;
        if (var1 == null) {
            GameEngine.print("selectMenuOption: gameView==null");
            return this.aD;
        } else {
            class_198 var2 = var1.i();
            if (var2 == null) {
                GameEngine.print("selectMenuOption: inGameActivity==null");
                return this.aD;
            } else {
                var2.a((Menu)this.aD);
                return this.aD;
            }
        }
    }

    void e(float var1) {
        float var2 = 30.0F * this.b.cj;
        int var3 = (int)(this.b.cH - var2);
        int var4 = var3;
        int var5 = (int)(this.b.cl - this.b.cq + 10.0F);
        int var6 = (int)(this.b.cq - 20.0F) / 3;
        int var7 = var6 - 5;
        boolean var8 = true;
        boolean var9 = true;

        for(int var10 = 0; var10 < this.aA.size(); ++var10) {
            class_72 var11 = (class_72)this.aA.get(var10);
            if (var11.h) {
                var11.e();
                var11.h = false;
            }

            var11.d();
            if (this.b.settingsEngine.keyboardSupport && var10 < this.b.bT.ai.length) {
                if (this.b.bT.ak[var10].a()) {
                    var11.b();
                    var11.c();
                }

                if (this.b.bT.aj[var10].a()) {
                    this.a.l();
                    var11.a();
                }

                if (this.b.bT.ai[var10].a()) {
                    this.a.l();
                    this.a.y();
                    var11.a();
                }
            }

            if (this.b.settingsEngine.showUnitGroups && var10 < 3) {
                String var12;
                if (var11.a.size() == 0) {
                    if (this.a.bN) {
                        var12 = "Empty";
                    } else {
                        var12 = "(" + (var10 + 1) + ")";
                    }
                } else {
                    var12 = "" + var11.a.size();
                }

                boolean var13 = false;
                var11.d = class_340.a(var11.d, 0.01F * var1);
                var11.e = class_340.a(var11.e, 0.01F * var1);
                var11.f = class_340.a(var11.f, 0.01F * var1);
                int var14 = Color.a(50, (int)(100.0F + var11.f * 100.0F), (int)(100.0F + var11.e * 100.0F), (int)(100.0F + var11.d * 100.0F));
                if (this.a.a(var5, var4, var7, (int)(31.0F * this.b.cj), var12, class_551.NONE, true, var14) && this.a.ac == null && !this.a.T) {
                    var13 = true;
                    var11.b += var1;
                    this.a.d();
                    float var15 = 1.0F;
                    this.i.a();
                    this.i.b(Color.a(120, 200, 0, 0));
                    if (var11.b < 50.0F) {
                        var15 = var11.b / 50.0F;
                        this.i.b(Color.a((int)(150.0F + var15 * 40.0F), 0, 200, 0));
                        this.a(var5, var4, var7, "Select Group", "(Hold for more..)", this.i, var15);
                    } else if (var11.b < 100.0F) {
                        var15 = (var11.b - 50.0F) / 50.0F;
                        this.i.b(Color.a((int)(150.0F + var15 * 40.0F), 200, 0, 0));
                        this.a(var5, var4, var7, "Add to Group", "(Hold for more..)", this.i, var15);
                    } else {
                        this.a(var5, var4, var7, "Replace Group", "", this.i, 0.0F);
                    }

                    int var16 = (int)(31.0F * this.b.cj);
                    this.s.a(var5, (int)((float)(var4 + var16) - (float)var16 * var15), var5 + var7, var4 + var16);
                    this.b.bO.b(this.s, this.i);
                }

                if (!var13) {
                    if (var11.b != 0.0F && !this.a.I) {
                        if (var11.b > 100.0F) {
                            var11.b();
                            var11.c();
                            var11.f = 1.0F;
                        } else if (var11.b > 50.0F) {
                            var11.c();
                            this.a.l();
                            this.a.y();
                            var11.a();
                            var11.e = 1.0F;
                        } else if (var11.a.size() != 0) {
                            this.a.l();
                            this.a.y();
                            var11.a();
                            var11.d = 1.0F;
                        } else {
                            var11.b();
                            var11.c();
                            var11.e = 1.0F;
                        }
                    }

                    if (!var13) {
                        var11.b = 0.0F;
                    }
                }

                var5 += var6;
            }
        }

    }

    public void a(GameOutputStream var1) {
        int var2 = this.aA.size();
        var1.writeInt(var2);
        Iterator var3 = this.aA.iterator();

        while(var3.hasNext()) {
            class_72 var4 = (class_72)var3.next();
            var4.a(var1);
        }

        var1.writeByte(0);
    }

    public void a(GameInputStream var1, boolean var2) {
        if (!var2) {
            this.aA.clear();
        }

        int var3 = var1.readInt();

        for(int var4 = 0; var4 < var3; ++var4) {
            class_72 var5 = new class_72(this, var4 < 3);
            var5.a(var1);
            if (!var2) {
                this.aA.add(var5);
            }
        }

        var1.readByte();
    }

    static {
        Z = new PorterDuffColorFilter(Color.a(200, 255, 200), Mode.MULTIPLY);
    }
}
