package com.corrodinggames.rts.game;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.FogRevealer;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_395;
import com.corrodinggames.rts.game.units.custom.class_429;
import com.corrodinggames.rts.game.units.custom.EffectType;
import com.corrodinggames.rts.game.units.custom.GameEvent;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_605;
import com.corrodinggames.rts.game.units.buildings.class_88;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_75;
import com.corrodinggames.rts.gameFramework.a.class_648;
import com.corrodinggames.rts.gameFramework.d.Emitter;
import com.corrodinggames.rts.gameFramework.d.class_989;
import com.corrodinggames.rts.gameFramework.d.class_996;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.net.class_215;
import com.corrodinggames.rts.gameFramework.utility.Point3DF;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_692;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.Iterator;

public strictfp class  Projectile extends class_75 {
    public static final class_684 a = new class_684();
    private static final Projectile bm = new Projectile(true);
    static TeamImageCache b = null;
    static TeamImageCache c = null;
    static TeamImageCache d = null;
    static final Rect e = new Rect();
    static final RectF f = new RectF();
    public class_163 g;
    public float h;
    public float i;
    public Unit j;
    public short k;
    public Unit l;
    public boolean m;
    public float n;
    public float o;
    public float p;
    public Projectile q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public boolean z;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public float F;
    public boolean G;
    public float H;
    public float I;
    public float J;
    public float K;
    public float L;
    public boolean M;
    public float N;
    public float[] O;
    public short P;
    public short Q;
    public short R;
    public boolean S;
    public boolean T;
    public float U;
    public boolean V;
    public float W;
    public float X;
    public float Y;
    public float Z;
    public boolean aa;
    public boolean ab;
    public boolean ac;
    public boolean ad;
    public boolean ae;
    public boolean af;
    public float ag;
    public float ah;
    public float ai;
    public float aj;
    public float ak;
    public float al;
    public float am;
    public float an;
    public boolean ao;
    public class_684 ap;
    static final int aq = Color.a(255, 255, 255, 255);
    public int ar;
    public boolean as;
    public boolean at;
    public GameObject au;
    public int av;
    public float aw;
    public float ax;
    public float ay;
    public float az;
    public float aA;
    public boolean aB;
    public boolean aC;
    public int aD;
    public class_588 aE;
    public float aF;
    public boolean aG;
    public boolean aH;
    public float aI;
    public float aJ;
    public boolean aK;
    public float aL;
    public boolean aM;
    public float aN;
    public float aO;
    public class_998 aP;
    public boolean aQ;
    public boolean aR;
    private boolean bn;
    public boolean aS;
    public float aT;
    public boolean aU;
    float aV;
    float aW;
    float aX;
    public boolean aY;
    public boolean aZ;
    public static final class_525 ba = new class_525();
    public static final Paint bb = new Paint();
    public static final Paint bc = new class_525();
    public static final Paint bd = new Paint();
    public static final Paint be = new Paint();
    public static final Paint bf = new Paint();
    public static final Paint bg = new Paint();
    public static final Paint bh = new Paint();
    public static final class_692 bi;
    public class_525 bj;
    public static class_525 bk;
    public static int bl;

    public Projectile(boolean var1) {
        super(var1);
        this.g = class_163.a;
        this.k = -1;
        this.r = -1.0F;
        this.s = 0.1F;
        this.x = 2.0F;
        this.y = -1.0F;
        this.z = true;
        this.H = 1.0F;
        this.P = -1;
        this.Q = -1;
        this.R = 0;
        this.S = true;
        this.V = false;
        this.W = 0.0F;
        this.X = 0.0F;
        this.ab = false;
        this.ac = false;
        this.ad = false;
        this.ae = true;
        this.ai = 1.0F;
        this.aj = 1.0F;
        this.ak = 1.0F;
        this.al = 1.0F;
        this.am = 1.0F;
        this.ar = aq;
        this.av = -1;
        this.aI = 40.0F;
        this.aJ = 60.0F;
        this.aK = false;
        this.aL = 2.0F;
        this.aR = true;
        this.aT = 0.0F;
        if (!var1) {
            a.add(this);
        }

    }

    public strictfp void a() {
        a.remove(this);
        super.a();
    }

    public static strictfp Projectile a(Projectile var0) {
        Projectile var1 = bm;
        var1.aD = -1;
        if (var0 == null) {
            var1.am = 1.0F;
            var1.ak = 1.0F;
            var1.al = 1.0F;
            var1.an = 0.0F;
        } else {
            var1.am = var0.am;
            var1.ak = var0.ak;
            var1.al = var0.al;
            var1.an = var0.an;
        }

        return var1;
    }

    public strictfp void a(Unit var1, float var2, float var3, float var4) {
        this.j = var1;
        this.xCord = var2;
        this.yCord = var3;
        this.zCord = var4;
        this.bn = false;
        this.V = false;
    }

    public strictfp void b() {
        if (this.D) {
            GameEngine var1 = GameEngine.getGameEngine();
            class_998 var2 = var1.bR.d(this.xCord, this.yCord, this.zCord, 0);
            if (var2 != null) {
                var2.G = 0.7F;
                var2.F = 2.1F;
                var2.ar = 2;
                var2.V = 90.0F;
                var2.W = var2.V;
            }

            var1.bM.a(class_648.p, 0.8F, this.xCord, this.yCord);
        }

        this.a();
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.h);
        var1.a(this.j);
        var1.a(this.l);
        var1.writeFloat(this.t);
        var1.writeInt(99);
        var1.writeBoolean(this.A);
        var1.writeBoolean(this.B);
        var1.writeBoolean(this.S);
        var1.writeBoolean(this.T);
        var1.writeFloat(this.U);
        var1.writeFloat(this.Y);
        var1.writeFloat(this.Z);
        var1.writeInt(this.ar);
        var1.writeBoolean(this.aH);
        var1.writeFloat(this.aI);
        var1.writeFloat(this.aJ);
        var1.writeBoolean(this.aK);
        var1.writeFloat(this.aL);
        var1.writeBoolean(this.aM);
        var1.writeFloat(this.aN);
        var1.writeBoolean(this.aQ);
        var1.writeBoolean(this.aR);
        var1.writeBoolean(this.bn);
        var1.writeBoolean(this.aS);
        var1.writeBoolean(this.M);
        var1.a(this.P);
        var1.writeFloat(this.r);
        var1.writeFloat(this.s);
        var1.writeBoolean(this.as);
        var1.writeBoolean(this.at);
        var1.writeFloat(this.az);
        var1.writeFloat(this.aA);
        var1.writeBoolean(this.aB);
        var1.writeBoolean(this.aC);
        var1.writeBoolean(false);
        var1.writeFloat(0.0F);
        var1.writeFloat(0.0F);
        var1.writeBoolean(this.E);
        var1.writeFloat(this.F);
        var1.writeFloat(this.J);
        var1.writeFloat(this.K);
        var1.writeFloat(this.L);
        var1.writeBoolean(this.m);
        var1.writeFloat(this.n);
        var1.writeFloat(this.o);
        var1.writeBoolean(this.C);
        var1.writeBoolean(this.D);
        var1.a((GameObject)this.q);
        var1.writeFloat(this.aV);
        var1.writeFloat(this.aW);
        var1.writeFloat(this.aX);
        var1.writeBoolean(this.V);
        var1.writeFloat(this.W);
        var1.writeFloat(this.X);
        var1.writeBoolean(this.aU);
        var1.a(this.R);
        var1.writeBoolean(this.ao);
        var1.a(this.ap);
        var1.a(this.Q);
        var1.writeFloat(this.x);
        var1.writeBoolean(this.aa);
        var1.writeBoolean(this.ad);
        var1.writeBoolean(this.G);
        var1.writeFloat(this.H);
        var1.writeBoolean(this.ae);
        var1.writeBoolean(this.aG);
        var1.writeBoolean(this.z);
        var1.writeFloat(this.y);
        var1.writeFloat(this.aO);
        var1.writeFloat(this.i);
        var1.writeBoolean(this.aY);
        var1.writeBoolean(this.af);
        var1.writeFloat(this.ag);
        var1.writeFloat(this.ah);
        var1.writeFloat(this.ai);
        var1.writeFloat(this.aj);
        var1.writeInt(0);
        var1.writeFloat(0.0F);
        var1.writeFloat(0.0F);
        var1.a((class_31)null);
        var1.writeInt(0);
        var1.writeBoolean(false);
        class_585.a(this.aE, var1);
        var1.writeFloat(this.ak);
        var1.writeFloat(this.al);
        var1.writeBoolean(this.ab);
        var1.writeBoolean(this.ac);
        var1.writeFloat(this.an);
        var1.writeBoolean(false);
        class_163.a(this.g, var1);
        boolean var2 = this.au != null && !this.au.ej;
        var1.writeBoolean(var2);
        if (var2) {
            var1.a(this.au);
            var1.writeFloat(this.aw);
            var1.writeFloat(this.ax);
            var1.writeFloat(this.ay);
        }

        var1.a(this.k);
        var1.writeInt(this.aD);
        var1.writeFloat(this.am);
        var1.writeFloat(this.p);
        var1.writeInt(this.av);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.h = var1.readFloat();
        this.j = var1.o();
        this.l = var1.a(class_215.EXPECTED);
        this.t = var1.readFloat();
        this.x = (float)var1.readInt();
        this.A = var1.readBoolean();
        this.B = var1.readBoolean();
        this.S = var1.readBoolean();
        this.T = var1.readBoolean();
        this.U = var1.readFloat();
        this.Y = var1.readFloat();
        this.Z = var1.readFloat();
        this.ar = var1.readInt();
        this.aH = var1.readBoolean();
        this.aI = var1.readFloat();
        this.aJ = var1.readFloat();
        this.aK = var1.readBoolean();
        this.aL = var1.readFloat();
        this.aM = var1.readBoolean();
        this.aN = var1.readFloat();
        this.aQ = var1.readBoolean();
        this.aR = var1.readBoolean();
        this.bn = var1.readBoolean();
        if (var1.b() >= 7) {
            this.aS = var1.readBoolean();
        }

        if (var1.b() >= 13) {
            this.M = var1.readBoolean();
            this.P = var1.readShort();
        }

        if (var1.b() >= 16) {
            this.r = var1.readFloat();
            this.s = var1.readFloat();
        }

        if (var1.b() >= 17) {
            this.as = var1.readBoolean();
            this.at = var1.readBoolean();
            this.az = var1.readFloat();
            this.aA = var1.readFloat();
            this.aB = var1.readBoolean();
            this.aC = var1.readBoolean();
        }

        if (var1.b() >= 18) {
            var1.readBoolean();
            var1.readFloat();
            var1.readFloat();
        }

        if (var1.b() >= 28) {
            this.E = var1.readBoolean();
            this.F = var1.readFloat();
            this.J = var1.readFloat();
            this.K = var1.readFloat();
            this.L = var1.readFloat();
        }

        if (var1.b() >= 29) {
            this.m = var1.readBoolean();
            this.n = var1.readFloat();
            this.o = var1.readFloat();
            this.C = var1.readBoolean();
            this.D = var1.readBoolean();
            this.q = (Projectile)var1.a(Projectile.class);
            this.aV = var1.readFloat();
            this.aW = var1.readFloat();
            this.aX = var1.readFloat();
            this.V = var1.readBoolean();
            this.W = var1.readFloat();
            this.X = var1.readFloat();
            this.aU = var1.readBoolean();
            this.R = var1.readShort();
            this.ao = var1.readBoolean();
            class_684 var2 = new class_684();
            var1.a(var2, Unit.class);
            if (var2.size() > 0) {
                this.ap = var2;
            }

            this.Q = var1.readShort();
        }

        if (var1.b() >= 35) {
            this.x = var1.readFloat();
            this.aa = var1.readBoolean();
            this.ad = var1.readBoolean();
            this.G = var1.readBoolean();
        }

        if (var1.b() >= 38) {
            this.H = var1.readFloat();
        }

        if (var1.b() >= 39) {
            this.ae = var1.readBoolean();
        }

        if (var1.b() >= 41) {
            this.aG = var1.readBoolean();
        }

        if (var1.b() >= 43) {
            this.z = var1.readBoolean();
            this.y = var1.readFloat();
        }

        if (var1.b() >= 44) {
            this.aO = var1.readFloat();
        }

        if (var1.b() >= 47) {
            this.i = var1.readFloat();
        }

        if (var1.b() >= 48) {
            this.aY = var1.readBoolean();
        }

        if (var1.b() >= 59) {
            this.af = var1.readBoolean();
            this.ag = var1.readFloat();
            this.ah = var1.readFloat();
            this.ai = var1.readFloat();
        }

        if (var1.b() >= 60) {
            this.aj = var1.readFloat();
            var1.readInt();
            var1.readFloat();
            var1.readFloat();
        }

        if (var1.b() >= 62) {
            var1.q();
            var1.readInt();
            var1.readBoolean();
        }

        if (var1.b() >= 63) {
            this.aE = class_585.a(var1);
        }

        if (var1.b() >= 64) {
            this.ak = var1.readFloat();
            this.al = var1.readFloat();
        }

        if (var1.b() >= 66) {
            this.ab = var1.readBoolean();
            this.ac = var1.readBoolean();
        }

        if (var1.b() >= 67 && var1.b() < 78) {
            class_395.a(var1, true);
        }

        if (var1.b() >= 68) {
            this.an = var1.readFloat();
        }

        if (var1.b() >= 77) {
            var1.readBoolean();
        }

        if (var1.b() >= 78) {
            this.g = class_163.a(var1);
        }

        if (var1.b() >= 81) {
            boolean var3 = var1.readBoolean();
            if (var3) {
                this.au = var1.a(GameObject.class);
                this.aw = var1.readFloat();
                this.ax = var1.readFloat();
                this.ay = var1.readFloat();
            }
        }

        if (var1.b() >= 83) {
            this.k = var1.readShort();
            this.aD = var1.readInt();
        }

        if (var1.b() >= 88) {
            this.am = var1.readFloat();
        }

        if (var1.b() >= 89) {
            this.p = var1.readFloat();
            this.av = var1.readInt();
        }

        super.a(var1);
    }

    public static strictfp void load() {
        GameEngine var0 = GameEngine.getGameEngine();
        b = var0.bO.a(AssetsID$drawable.projectiles);
        c = var0.bO.a(AssetsID$drawable.projectiles2);
        d = var0.bO.a(AssetsID$drawable.projectiles_large);
    }

    public strictfp void d() {
        this.aS = true;
    }

    public static strictfp Projectile a(Unit var0, float var1, float var2) {
        Projectile var3 = new Projectile(false);
        var3.j = var0;
        var3.xCord = var1;
        var3.yCord = var2;
        var3.ar = Color.a(255, 100, 30, 30);
        var3.en = var0.en + 1;
        var3.em = 4;
        return var3;
    }

    public static strictfp Projectile a(Unit var0, float var1, float var2, float var3, int var4) {
        Projectile var5 = a(var0, var1, var2);
        var5.zCord = var3;
        var5.k = (short)var4;
        var5.I = class_340.b(var0, 0.0F, 1.0F, var0.bC);
        ++var0.bC;
        return var5;
    }

    public strictfp void a(Unit var1) {
        if (this.ag != 0.0F || this.ah != 0.0F) {
            if (var1.bI()) {
                return;
            }

            float var2 = class_340.a(this.aV, this.aW, var1.xCord, var1.yCord);
            float var3;
            if (var2 > 100.0F) {
                var3 = class_340.d(this.aV, this.aW, var1.xCord, var1.yCord);
            } else {
                var3 = this.az;
            }

            float var4 = this.ah;
            var4 += this.ag / var1.mass();
            var1.cc += class_340.k(var3) * var4;
            var1.cd += class_340.j(var3) * var4;
        }

    }

    public static strictfp void a(Unit var0, Unit var1, float var2, Projectile var3, boolean var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        if (var5.bw && var2 > 0.0F) {
            var2 = 0.0F;
        }

        if (var1 != null && !var1.bV) {
            if (var3 != null && var3.g.bc && var0 != null) {
                var1.e(var0.bX);
            }

            if (var3 != null) {
                if (var3.ai != 1.0F && var1.bI()) {
                    var2 *= var3.ai;
                }

                if (var3.aj != 1.0F && var1.i()) {
                    var2 *= var3.aj;
                }
            }

            float var8;
            if (var2 < 0.0F) {
                var1.b(var0, -var2, var3);
            } else {
                boolean var6 = !var1.bV && var1.health > 0.0F;
                var1.a(var0, var2, var3);
                var8 = var2;
                if (var1.J()) {
                    var8 = 0.0F;
                }

                if (var8 > 0.0F) {
                    var5.stats.a(var0, var1, var8);
                }

                if (var0 != null) {
                    var0.cV += var8;
                    if (var6 && (var1.bV || var1.health < 0.0F)) {
                        ++var0.cU;
                        var0.a(GameEvent.killedAnyUnit, var1);
                    }
                }
            }

            if (var3 != null && !var1.bV) {
                float var9 = var1.bQ();
                if (var9 != -1.0F) {
                    float var7 = 100.0F;
                    var8 = class_340.d(var3.xCord, var3.yCord, var1.xCord, var1.yCord);
                    var7 /= var9;
                    var1.cc += class_340.k(var8) * var7;
                    var1.cd += class_340.j(var8) * var7;
                }
            }
        }

    }

    public strictfp float e() {
        float var1 = 1.0F;
        if (this.J < this.F) {
            var1 = this.J / this.F;
        }

        return var1;
    }

    public strictfp void a(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.aS) {
            this.a();
        }

        if (this.l == null && !this.aC) {
            this.a();
        } else {
            if (this.i > 0.0F) {
                this.i = class_340.a(this.i, var1);
                if (this.i > 0.0F) {
                    return;
                }
            }

            class_163 var3 = this.g;
            class_998 var8;
            if (this.i == 0.0F) {
                this.i = -1.0F;
                if (var3.al != null) {
                    Object var4 = null;
                    boolean var5 = false;
                    Unit var6 = this.j;
                    var8 = null;
                    var3.al.a(this.xCord, this.yCord, this.zCord, this.az, var6, (class_684)var4, var5, this.aD + 1, this, null);
                }
            }

            this.h = class_340.a(this.h, var1);
            boolean var28 = false;
            if (this.aG) {
                if (this.l == null) {
                    var28 = true;
                } else if (this.l.bV) {
                    var28 = true;
                }
            }

            if (var28) {
                this.a(var3.ax, var3.ay, (class_588)null);
            }

            if (var3.az) {
                this.aF = class_340.a(this.aF, var1);
                if (this.aF == 0.0F) {
                    this.aF = var3.aA;
                    var28 = true;
                    this.a(var3.aB, var3.aC, var3.aD);
                }
            }

            float var29;
            if (var3.R != 0.0F || var3.S != 0.0F) {
                var29 = var3.R;
                if (this.l != null) {
                    var29 += this.l.cj * var3.S;
                }

                this.K = class_340.j((360.0F * this.I + this.J * 1.0F) % 360.0F) * var29;
                this.L = class_340.j((360.0F * this.I + this.J * 1.5F) % 360.0F) * var29;
            }

            float var30;
            if (this.E && this.l != null) {
                this.K = class_340.j(this.J * 1.0F % 360.0F) * this.l.cj * 0.4F;
                this.L = class_340.j(this.J * 1.5F % 360.0F) * this.l.cj * 0.4F;
                var29 = this.l.xCord + this.K;
                var30 = this.l.yCord + this.L;
                if (this.el) {
                    this.aN += var1;
                    this.aO += var1;
                    if (this.aN > 11.0F) {
                        this.aN = class_340.c(1.0F, 4.0F);
                        boolean var7 = false;
                        var8 = var2.bR.b(var29, var30, this.l.zCord, class_989.CUSTOM, var7, Priority.low);
                        if (var8 != null) {
                            var8.aq = 0;
                            var8.ap = 0;
                            var8.ar = 2;
                            var8.r = true;
                            var8.E = 0.5F;
                            var8.W = 60.0F;
                            var8.V = 60.0F;
                            var8.G = 0.7F;
                            var8.F = 0.3F;
                            var8.as = false;
                            var8.P = class_340.c(-0.3F, 0.3F);
                            var8.Q = -0.9F + class_340.c(-0.3F, 0.3F);
                        }
                    }

                    if (this.aO > 75.0F) {
                        this.aO = class_340.c(1.0F, 20.0F);
                        var2.bR.b(var29, var30, this.l.zCord);
                    }
                }
            }

            float var9 = 5.0F;
            boolean var10 = false;
            boolean var11 = false;
            float var12;
            float var13;
            float var14;
            float var31;
            float var32;
            if (!this.aC) {
                var12 = this.l.xCord + this.K;
                var13 = this.l.yCord + this.L;
                var14 = this.l.zCord;
                var29 = class_340.d(this.xCord, this.yCord, var12, var13);
                var30 = class_340.a(this.xCord, this.yCord, var12, var13);
                var32 = var14;
                var31 = var14 - this.zCord;
                var9 = this.l.cj;
                var10 = this.l instanceof class_88;
                var11 = this.l.cx > 10.0F + this.U;
            } else {
                var30 = 999.0F;
                var31 = 0.0F;
                var29 = this.az;
                var32 = 0.0F;
                if (this.q != null) {
                    var12 = this.q.xCord + this.K;
                    var13 = this.q.yCord + this.L;
                    var14 = this.q.zCord;
                    var29 = class_340.d(this.xCord, this.yCord, var12, var13);
                    var30 = class_340.a(this.xCord, this.yCord, var12, var13);
                    var32 = var14;
                    var31 = var14 - this.zCord;
                } else if (this.l != null) {
                    var12 = this.l.xCord + this.K;
                    var13 = this.l.yCord + this.L;
                    var14 = this.l.zCord;
                    var29 = class_340.d(this.xCord, this.yCord, var12, var13);
                    var30 = class_340.a(this.xCord, this.yCord, var12, var13);
                    var32 = var14;
                    var31 = var14 - this.zCord;
                    var9 = this.l.cj;
                    var10 = this.l instanceof class_88;
                    var11 = this.l.cx > 10.0F + this.U;
                } else if (this.m) {
                    var12 = this.n + this.K;
                    var13 = this.o + this.L;
                    var14 = this.p;
                    var29 = class_340.d(this.xCord, this.yCord, var12, var13);
                    var30 = class_340.a(this.xCord, this.yCord, var12, var13);
                    var32 = var14;
                    var31 = var14 - this.zCord;
                } else {
                    var12 = this.n + this.K;
                    var13 = this.o + this.L;
                    var14 = 0.0F;
                    var29 = class_340.d(this.xCord, this.yCord, var12, var13);
                    var30 = class_340.a(this.xCord, this.yCord, var12, var13);
                    var32 = var14;
                    var31 = var14 - this.zCord;
                }
            }

            var12 = var3.O;
            if (var30 < 225.0F) {
                var12 = var3.P;
            }

            if (var12 >= 0.0F) {
                var13 = class_340.c(this.az, var29, var12 * var1);
                this.az += var13;
                var29 = this.az;
            } else {
                this.az = var29;
            }

            boolean var33 = false;
            boolean var34 = false;
            float var15 = var29;
            float var16;
            float var17;
            Point3DF var20;
            float var21;
            float var36;
            float var40;
            if (this.au != null && !this.au.ej) {
                float var18;
                if (this.av >= 0) {
                    OrderableUnit var19 = (OrderableUnit)this.au;
                    if (this.av >= var19.bl()) {
                        this.av = 0;
                    }

                    var20 = var19.D(this.av);
                    var16 = var20.x;
                    var17 = var20.y;
                    var18 = this.j.zCord + var20.z;
                } else {
                    var16 = this.au.xCord;
                    var17 = this.au.yCord;
                    var18 = this.au.zCord;
                }

                var36 = var16 - this.aw;
                var40 = var17 - this.ax;
                var21 = var18 - this.ay;
                this.xCord += var36;
                this.yCord += var40;
                this.zCord += var21;
                this.aw = var16;
                this.ax = var17;
                this.ay = var18;
            }

            if (!this.A) {
                this.xCord += this.u * var1;
                this.yCord += this.v * var1;
                if (this.w != 0.0F) {
                    var16 = this.w * var1;
                    this.zCord += var16;
                    var31 = var32 - this.zCord;
                }

                if (this.zCord > 0.0F) {
                    if (var3.G != 0.0F) {
                        this.zCord -= var3.G * var1;
                        var31 = var32 - this.zCord;
                    }

                    if (var3.H != 0.0F) {
                        this.w -= var3.H * var1;
                    }
                }

                if (!this.aH || this.aI < this.zCord || this.aK) {
                    var16 = this.t * var1;
                    var33 = true;
                    if (var30 < var16 * var16) {
                        var16 = class_340.a(var30);
                        var30 = 0.0F;
                    }

                    this.xCord += class_340.k(var29) * var16;
                    this.yCord += class_340.j(var29) * var16;
                }

                if (this.aH) {
                    if (this.aL < 0.0F) {
                        var16 = this.t * var1;
                        var33 = true;
                    } else {
                        var16 = this.aL * var1;
                    }

                    if (!this.aK) {
                        this.zCord = class_340.a(this.zCord, this.aJ, var16);
                        if (this.zCord < this.aI) {
                            var15 = -90.0F;
                        }

                        if (this.zCord >= this.aJ) {
                            this.aK = true;
                        }
                    } else if (var30 < 400.0F) {
                        this.zCord = class_340.a(this.zCord, var32, var16);
                        if (class_340.c(this.zCord - var32) > 0.5F) {
                            var15 = 90.0F;
                            var34 = true;
                        }
                    }
                } else {
                    var17 = this.t * var1;
                    var33 = true;
                    if (var31 != 0.0F) {
                        if ((double)var30 > 0.1) {
                            var17 = class_340.c(var31) / class_340.a(var30) * this.t * var1;
                            var17 = class_340.b(var17, this.t * var1);
                        }

                        this.zCord += class_340.b(var31, var17);
                        var31 = var32 - this.zCord;
                    }
                }
            }

            if (var33 && this.r > 0.0F) {
                this.t = class_340.a(this.t, this.r, this.s * var1);
            }

            if (var3.am != 0.0F) {
                var16 = class_340.j((this.J * 360.0F / var3.an + 360.0F * this.I) % 360.0F);
                var16 = var16 * var3.am * var1;
                this.xCord += class_340.k(var29 + 90.0F) * var16;
                this.yCord += class_340.j(var29 + 90.0F) * var16;
            }

            boolean var41;
            if (this.el && (this.aM || var3.ah != null) && !this.bn) {
                this.aN += var1;
                if (this.aN > var3.ag) {
                    this.aN = 0.0F;
                    var41 = false;
                    if (this.D) {
                        var41 = true;
                    }

                    if (var3.ah != null) {
                        var3.ah.a(this.xCord, this.yCord, this.zCord, this.aT, this);
                    }

                    if (this.aM) {
                        class_998 var37 = var2.bR.b(this.xCord, this.yCord, this.zCord, class_989.CUSTOM, var41, Priority.low);
                        if (var37 != null) {
                            if (this.zCord >= 0.0F) {
                                var37.aq = 0;
                                var37.ap = 0;
                                var37.ar = 2;
                                var37.r = true;
                                var37.E = 0.5F;
                                var37.V = 70.0F;
                                var37.W = var37.V;
                                var37.as = true;
                                if (var34) {
                                    var37.as = false;
                                }

                                var37.Q = 0.1F;
                                var37.s = true;
                                var37.t = 5.0F;
                                var37.G = 0.5F;
                                var37.F = 1.2F;
                                var37.Y = class_340.c(-180.0F, 180.0F);
                                if (this.D) {
                                    var37.G = 0.5F;
                                    var37.F = 2.1F;
                                }
                            } else {
                                var37.aq = 9;
                                var37.ap = 1;
                                var37.ar = 1;
                                var37.r = true;
                                var37.E = 0.5F;
                                var37.W = 60.0F;
                                var37.V = 60.0F;
                                var37.Q = 0.1F;
                            }
                        }
                    }
                }
            }

            if (!this.bn) {
                var41 = false;
                Unit var38 = null;
                boolean var35 = false;
                var36 = 6.0F;
                if (var10) {
                    var36 = var9 * 0.8F;
                    if (var36 < 6.0F) {
                        var36 = 6.0F;
                    }
                }

                if (var11) {
                    var36 = var9 * 1.1F;
                }

                var40 = 3.0F;
                if (this.w != 0.0F || var3.G != 0.0F) {
                    var40 += class_340.c(this.w * var1) + class_340.c(var3.G * var1);
                }

                if (var30 < var36 * var36 && class_340.c(var31) < var40) {
                    var41 = true;
                    var38 = this.l;
                }

                if (this.A) {
                    var41 = true;
                    var38 = this.l;
                }

                if (this.af && this.h == 0.0F) {
                    var41 = true;
                }

                int var24;
                Unit var25;
                if (this.as) {
                    var21 = this.aA + 50.0F;
                    Unit[] var22 = Unit.bE.a();
                    int var23 = 0;

                    for(var24 = Unit.bE.size(); var23 < var24; ++var23) {
                        var25 = var22[var23];
                        if (var25.xCord + var21 > this.xCord && var25.xCord - var21 < this.xCord && var25.yCord + var21 > this.yCord && var25.yCord - var21 < this.yCord && var25.bT && !var25.i() && var25.cN == null) {
                            float var26 = class_340.a(this.xCord, this.yCord, var25.xCord, var25.yCord);
                            float var27 = this.aA + var25.cj;
                            if (var26 < var27 * var27) {
                                var41 = true;
                                var38 = var25;
                            }
                        }
                    }
                }

                if (this.at) {
                    var2.bL.a(this.xCord, this.yCord);
                    int var43 = var2.bL.T;
                    int var45 = var2.bL.U;
                    if (var2.bU.a(MovementType.HOVER, var43, var45)) {
                        var41 = true;
                        var35 = true;
                    }
                }

                if (this.aC) {
                }

                if (this.aY && (this.aH && var34 && this.zCord < 30.0F || var41) && this.j != null) {
                    this.aY = false;
                    FogRevealer var44 = new FogRevealer(false);
                    var44.xCord = this.xCord;
                    var44.yCord = this.yCord;
                    var44.b(this.j.bX);
                    var44.a = 15;
                    var44.b = 360.0F;
                    PlayerData.c((Unit)var44);
                }

                if (var41) {
                    this.bn = true;
                    this.aV = this.xCord;
                    this.aW = this.yCord;
                    this.aX = this.zCord;
                    if (this.A) {
                        if (this.aC) {
                            this.aV = this.n;
                            this.aW = this.o;
                            this.aX = 0.0F;
                        }

                        if (this.l != null) {
                            this.aV = this.l.xCord + this.K;
                            this.aW = this.l.yCord + this.L;
                            this.aX = this.l.zCord;
                        }
                    }

                    if (!this.B && !this.M && !var3.X) {
                        this.S = false;
                    }

                    boolean var46 = false;
                    if (this.l != null) {
                        var46 = this.l.cx > 10.0F;
                    }

                    class_605 var47 = var3.aX;
                    if (var46) {
                        var47 = var3.aY;
                    }

                    class_605 var48;
                    if (this.l != null) {
                        var48 = var3.a(this.l);
                        if (var48 != null) {
                            var47 = var48;
                        }
                    }

                    if (var47 != null) {
                        var47.a(this.aV, this.aW, this.aX, this.aT, this.l);
                    }

                    if (var3.aj != null) {
                        var48 = null;
                        boolean var50 = false;
                        var25 = this.j;
                        Unit var60 = this.l;
                        var3.aj.a(this.xCord, this.yCord, this.zCord, this.az, var25, null, var50, this.aD + 1, this, var60);
                    }

                    if (var3.aZ != null && this.j != null) {
                        var3.aZ.spawnUnitsAt(this.aV, this.aW, 0.0F, this.az, this.j.bX, false, this.j);
                    }

                    if (var3.ba > 0 && this.j != null && this.j instanceof class_113) {
                        class_113 var51 = (class_113)this.j;

                        for(var24 = 0; var24 < var3.ba; ++var24) {
                            if (var51.B != null && var51.B.size() > 0) {
                                var25 = (Unit)var51.B.remove(var51.B.size() - 1);
                                class_694.a((Unit)var25, (OrderableUnit)var51);
                                var25.xCord = this.aV;
                                var25.yCord = this.aW;
                                var25.cg = this.az;
                                var25.cd = 0.0F;
                                var25.cc = 0.0F;
                                var25.bZ = 0.0F;
                                var25.ca = 0.0F;
                                if (var25 instanceof OrderableUnit) {
                                    OrderableUnit var57 = (OrderableUnit)var25;
                                    var57.az();
                                    var57.j(var25.cg);
                                    if (var25 instanceof class_113) {
                                        ((class_113)var25).dF();
                                    }
                                }

                                var51.D(var25);
                            }
                        }
                    }

                    if (var3.bb && this.j != null) {
                        this.j.f(this.aV, this.aW);
                    }

                    if (!var35 && var38 != null) {
                        float var52;
                        if (this.E) {
                            this.bn = false;
                            var52 = this.U / 60.0F * var1 * this.e();
                            if (this.Z == 0.0F) {
                                this.a(var38);
                            }

                            var52 = var3.a(var38, var52, true);
                            a(this.j, var38, var52, this, false);
                        } else {
                            if (this.Z == 0.0F) {
                                this.a(var38);
                            }

                            var52 = this.U;
                            var52 = var3.a(var38, var52, false);
                            a(this.j, var38, var52, this, false);
                        }
                    }

                    if (this.q != null) {
                        if (var3.d) {
                            this.q.h = 0.0F;
                        } else {
                            this.q.b();
                        }

                        this.a();
                    }

                    if (!this.E) {
                        boolean var55 = true;
                        class_998 var53;
                        if (this.l != null && this.l.cx > 10.0F) {
                            var55 = false;
                            if (var3.aY == null) {
                                var53 = var2.bR.d(this.aV, this.aW, this.aX, -1127220);
                                if (var53 != null) {
                                    var53.V = 10.0F;
                                    var53.F = 0.5F;
                                    if (this.aQ) {
                                        var53.V = 25.0F;
                                        var53.F = 1.0F;
                                    }

                                    var53.ar = 2;
                                    var53.W = var53.V;
                                }
                            }
                        }

                        if (this.G) {
                            var55 = false;
                            Emitter var54 = Emitter.b(this.xCord, this.yCord);
                            var54.a = 21.0F;
                        }

                        if (var55) {
                            float var58;
                            if (!this.aQ) {
                                if (var3.aX == null) {
                                    var2.bR.c(this.aV, this.aW, this.aX);
                                }
                            } else if (var3.aX == null) {
                                if (this.Z > 10.0F) {
                                    var53 = var2.bR.d(this.aV, this.aW, this.aX, 0);
                                    if (var53 != null) {
                                        var53.F = this.Z / 25.0F;
                                        var53.E = 0.7F;
                                        if (this.aX > 5.0F) {
                                            var53.ar = 2;
                                        }
                                    }
                                }

                                var2.bR.b(this.aV, this.aW, this.aX);
                                if (this.aR && !this.D) {
                                    var58 = 1.0F + class_340.c(-0.06F, 0.06F);
                                    var2.bM.a(class_648.n, 0.5F, var58, this.aV, this.aW);
                                }
                            }

                            if (this.D && var3.aX == null) {
                                var58 = 0.7F;
                                var2.bM.a(class_648.C, 1.6F, var58, this.aV, this.aW);
                                var2.bR.b(Priority.critical);
                                class_998 var56 = var2.bR.a(this.aV, this.aW, this.zCord, Color.a(255, 255, 255, 255));
                                if (var56 != null) {
                                    var56.G = 14.0F;
                                    var56.F = 8.0F;
                                    var56.E = 0.9F;
                                    var56.V = 35.0F;
                                    var56.W = var56.V;
                                    var56.r = true;
                                }

                                var2.bR.b(Priority.critical);
                                var56 = var2.bR.c(this.aV, this.aW, this.aX, -1127220);
                                if (var56 != null) {
                                    var56.G = 1.5F;
                                    var56.F = 3.0F;
                                    var56.ar = 2;
                                    var56.V = 20.0F;
                                    var56.W = var56.V;
                                    var56.U = 0.0F;
                                }

                                var2.bR.b(Priority.critical);
                                var56 = var2.bR.c(this.aV, this.aW, this.aX, -1127220);
                                if (var56 != null) {
                                    var56.G = 0.2F;
                                    var56.F = 5.0F;
                                    var56.ar = 2;
                                    var56.V = 65.0F;
                                    var56.W = var56.V;
                                    var56.U = 0.0F;
                                }

                                var2.bR.b(Priority.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.zCord, Color.a(255, 255, 255, 255));
                                if (var56 != null) {
                                    var56.G = 3.0F;
                                    var56.F = 6.0F;
                                    var56.E = 0.9F;
                                    var56.V = 290.0F;
                                    var56.W = var56.V;
                                }

                                var2.bR.b(Priority.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.zCord, Color.a(255, 255, 244, 230));
                                if (var56 != null) {
                                    var56.G = 2.0F;
                                    var56.F = 6.0F;
                                    var56.E = 0.5F;
                                    var56.V = 370.0F;
                                    var56.W = var56.V;
                                    var56.U = 10.0F;
                                }

                                int var59;
                                for(var59 = 0; var59 < 1; ++var59) {
                                    var2.bR.b(Priority.critical);
                                    var56 = var2.bR.a(this.aV, this.aW, this.zCord, Color.a(255, 255, 244, 230));
                                    if (var56 != null) {
                                        var56.G = 0.2F;
                                        var56.F = 9.0F;
                                        var56.E = 0.7F;
                                        var56.V = 210.0F;
                                        var56.W = var56.V;
                                        var56.U = (float)(20 + var59 * 110);
                                    }
                                }

                                var2.bR.b(Priority.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.zCord, Color.a(255, 255, 255, 255));
                                if (var56 != null) {
                                    var56.G = 3.0F;
                                    var56.F = 4.0F;
                                    var56.E = 0.2F;
                                    var56.V = 870.0F;
                                    var56.W = var56.V;
                                    var56.r = true;
                                    var56.U = 70.0F;
                                }

                                var2.bR.b(Priority.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.zCord, Color.a(255, 206, 255, 239));
                                if (var56 != null) {
                                    var56.G = 4.0F;
                                    var56.F = 1.0F;
                                    var56.E = 0.9F;
                                    var56.V = 320.0F;
                                    var56.W = var56.V;
                                }

                                var2.bR.b(Priority.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.zCord, Color.a(255, 255, 242, 129));
                                if (var56 != null) {
                                    var56.G = 2.0F;
                                    var56.F = 1.0F;
                                    var56.E = 1.0F;
                                    var56.V = 340.0F;
                                    var56.W = var56.V;
                                    var56.s = true;
                                    var56.t = 20.0F;
                                }

                                var2.bR.b(Priority.critical);
                                var56 = var2.bR.a(this.aV, this.aW, this.zCord, Color.a(245, 255, 182, 110));
                                if (var56 != null) {
                                    var56.G = 1.5F;
                                    var56.F = 1.5F;
                                    var56.E = 0.3F;
                                    var56.V = 1340.0F;
                                    var56.W = var56.V;
                                    var56.s = true;
                                    var56.t = 40.0F;
                                    var56.U = 140.0F;
                                }

                                for(var59 = 0; var59 < 4; ++var59) {
                                    var2.bR.b(Priority.critical);
                                    var56 = var2.bR.a(this.aV, this.aW, this.zCord, Color.a(225, 255, 242, 129));
                                    if (var56 != null) {
                                        var56.G = 1.5F;
                                        var56.F = 1.4F;
                                        var56.E = 1.3F;
                                        var56.V = 340.0F;
                                        var56.W = var56.V;
                                        var56.Q = -0.29F;
                                        var56.s = true;
                                        var56.t = 50.0F;
                                        var56.U = (float)(30 + var59 * 40);
                                    }
                                }

                                for(var59 = 0; var59 < 2; ++var59) {
                                    var2.bR.b(Priority.critical);
                                    var56 = var2.bR.a(this.aV, this.aW, this.zCord, Color.a(185, 255, 242, 129));
                                    if (var56 != null) {
                                        var56.G = 1.3F;
                                        var56.F = 1.0F;
                                        var56.E = 1.0F;
                                        var56.V = 340.0F;
                                        var56.W = var56.V;
                                        var56.Q = -0.14F;
                                        var56.s = true;
                                        var56.t = 50.0F;
                                        var56.U = (float)(70 + var59 * 70);
                                    }
                                }

                                for(var59 = 0; var59 < 4; ++var59) {
                                    var2.bR.b(Priority.critical);
                                    var56 = var2.bR.a(this.aV, this.aW - 30.0F, this.zCord, -16711936);
                                    if (var56 != null) {
                                        var56.G = 1.5F;
                                        var56.F = 2.6F;
                                        var56.E = 1.3F;
                                        var56.V = 510.0F;
                                        var56.W = var56.V;
                                        var56.Q = -0.2F;
                                        var56.s = true;
                                        var56.t = 50.0F;
                                        var56.B = null;
                                        var56.x = Color.a(175, 235, 235, 235);
                                        var56.U = (float)(20 + var59 * 40);
                                    }
                                }

                                for(var59 = 0; var59 < 2; ++var59) {
                                    var2.bR.b(Priority.critical);
                                    var56 = var2.bR.a(this.aV, this.aW - 30.0F, this.zCord, -16711936);
                                    if (var56 != null) {
                                        var56.G = 1.5F;
                                        var56.F = 3.8F;
                                        var56.E = 0.8F;
                                        var56.V = 590.0F;
                                        var56.W = var56.V;
                                        var56.Q = -0.2F;
                                        var56.s = true;
                                        var56.t = 50.0F;
                                        var56.B = null;
                                        var56.x = Color.a(105, 115, 115, 115);
                                        var56.U = (float)(20 + var59 * 40);
                                    }
                                }

                                for(var59 = 0; var59 < 1; ++var59) {
                                    Emitter var61 = Emitter.a(this.aV + class_340.a(-10.0F, 10.0F, (int)this.id), this.aW + class_340.a(-10.0F, 10.0F, (int)this.id + var59));
                                    if (var61 != null) {
                                        var61.t = (float)(200 + var59 * 70);
                                        var61.a = (float)(980 + var59 * 800);
                                    }
                                }

                                if (!class_694.d(this.aV, this.aW)) {
                                    ScorchMark.a(this.aV, this.aW, NukeMode.NUKE);
                                }

                                if (GameEngine.aB()) {
                                    if (var2.bR.m == null) {
                                        var2.bR.m = var2.bO.a(AssetsID$drawable.shockwave_normal_256, true);
                                    }

                                    var2.bR.b(Priority.critical);
                                    var56 = var2.bR.a(this.aV, this.aW, this.zCord, -1);
                                    if (var56 != null && var2.bR.m != null) {
                                        var56.a = new class_429((EffectType)null);
                                        var56.a.imageStrip = new class_996();
                                        var56.a.imageStrip.k = true;
                                        var56.a.imageStrip.i = var2.bR.m;
                                        var56.a.imageStrip.b = var56.a.imageStrip.i.m();
                                        var56.a.imageStrip.c = var56.a.imageStrip.i.l();
                                        var56.ar = 3;
                                        var56.G = 0.5F;
                                        var56.F = 3.5F;
                                        var56.E = 0.5F;
                                        var56.V = 60.0F;
                                        var56.W = var56.V;
                                        var56.Q = -0.2F;
                                        var56.s = true;
                                        var56.t = 1.0F;
                                        var56.B = null;
                                        var56.U = 0.0F;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (this.bn && !this.V) {
                this.W = class_340.a(this.W, var1);
                if (this.ao) {
                    var16 = 1.0F - this.W / this.X;
                    this.b(var16);
                }

                if (this.W == 0.0F) {
                    this.V = true;
                    this.b(1.0F);
                    if (!this.B && !this.M && !var3.X) {
                        this.a();
                    }
                }
            }

            this.J += var1;
            if (this.h == 0.0F && (!this.bn || this.V)) {
                if (var3.ak != null) {
                    Object var49 = null;
                    boolean var42 = false;
                    Unit var39 = this.j;
                    var20 = null;
                    var3.ak.a(this.xCord, this.yCord, this.zCord, this.az, var39, (class_684)var49, var42, this.aD + 1, this, null);
                }

                this.a();
            }

            if (!this.aU) {
                this.aT = var15;
                this.aU = true;
            }

            var16 = class_340.c(this.aT, var15, 12.0F * var1);
            this.aT += var16;
        }
    }

    public strictfp void b(float var1) {
        boolean var2 = false;
        if (!this.g.f) {
            if (this.g.e) {
                var2 = true;
            }

            if (!var2) {
                if (this.Y != 0.0F && this.Z > 0.0F) {
                    var2 = true;
                }

                if ((this.ag != 0.0F || this.ah != 0.0F) && this.Z > 0.0F) {
                    var2 = true;
                }
            }

            if (var2) {
                float var3 = this.Z * var1;
                float var4 = var3;
                if (this.g.h) {
                    var4 = var3 + 150.0F;
                }

                GameEngine var5 = GameEngine.getGameEngine();
                bi.clear();
                var5.cc.b(this.aV, this.aW, var4, bi);
                Unit[] var6 = bi.a();
                int var7 = bi.size();

                for(int var8 = 0; var8 < var7; ++var8) {
                    Unit var9 = var6[var8];
                    this.b(var9, var1, var3);
                }

                bi.clear();
            }
        }
    }

    public strictfp void b(Unit var1, float var2, float var3) {
        if (var1.cN == null) {
            if (this.ap == null || !this.ap.contains(var1)) {
                if (this.j != null) {
                    PlayerData var4 = this.j.bX;
                    PlayerData var5 = var1.bX;
                    if (var5 != var4 && var4.d(var5)) {
                        return;
                    }

                    if (this.aa && !var4.c(var5)) {
                        return;
                    }

                    if (this.ab && var4.c(var5)) {
                        return;
                    }
                }

                if (!(var1.zCord < -5.0F) || !(this.aX >= -2.0F) || this.ac) {
                    if (this.ae) {
                        boolean var6 = this.aX >= 5.0F;
                        if (var1.i() != var6) {
                            return;
                        }
                    } else if (!this.ad && var1.i()) {
                        return;
                    }

                    float var7 = class_340.a(this.aV, this.aW, var1.xCord, var1.yCord);
                    if (!(var7 > var3 * var3) || this.g.h) {
                        float var8 = (float)StrictMath.sqrt((double)var7);
                        if (this.g.h) {
                            var8 -= var1.cj;
                            if (var8 < 0.0F) {
                                var8 = 0.0F;
                            }
                        }

                        if (!(var8 > var3)) {
                            if (!(var8 < this.g.j)) {
                                this.a(var2, var1, var8);
                            }
                        }
                    }
                }
            }
        }
    }

    public strictfp void a(float var1, Unit var2, float var3) {
        float var4 = 1.0F - var3 / this.Z;
        var4 = (float)((double)var4 + 0.1);
        if (var4 > 1.0F) {
            var4 = 1.0F;
        }

        if (this.g.g) {
            var4 = 1.0F;
        }

        float var5 = var4 * this.Y;
        this.a(var2);
        var5 = this.g.a(var2, var5, true);
        a(this.j, var2, var5, this, true);
        if (this.ao) {
            if (this.ap == null) {
                this.ap = new class_684();
            }

            this.ap.add(var2);
        }

    }

    public strictfp boolean a(GameEngine var1) {
        if (var1.cO.b(this.xCord, this.yCord)) {
            return true;
        } else {
            return (this.B || this.E || this.g.X) && this.l != null && var1.cO.b(this.l.xCord, this.l.yCord);
        }
    }

    public strictfp boolean c(float var1) {
        if (!this.S) {
            return false;
        } else if (this.i > 0.0F) {
            return false;
        } else {
            class_163 var2 = this.g;
            GameEngine var3 = GameEngine.getGameEngine();
            class_28 var4 = var3.bO;
            float var5 = this.xCord - var3.cw;
            float var6 = this.yCord - var3.cx;
            float var7;
            float var8;
            float var9;
            if (this.l != null) {
                var7 = this.l.xCord;
                var8 = this.l.yCord;
                var9 = this.l.zCord;
            } else {
                var7 = this.n;
                var8 = this.o;
                var9 = this.p;
            }

            if (!this.aZ && !this.D) {
                boolean var10 = false;
                if (this.A) {
                    if (this.l != null) {
                        if (!var3.bL.a(this.l.xCord, this.l.yCord, var3.playerTeam)) {
                            var10 = true;
                        }
                    } else if (this.m && !var3.bL.a(this.n, this.o, var3.playerTeam)) {
                        var10 = true;
                    }
                }

                if (!var3.bL.a(this.xCord, this.yCord, var3.playerTeam) && !var10) {
                    return false;
                }

                this.aZ = true;
            }

            float var11;
            float var12;
            float var13;
            float var14;
            float var16;
            float var17;
            float var18;
            float var19;
            float var20;
            float var27;
            if (!this.E && !var2.X) {
                if (this.B) {
                    var27 = var7 - var3.cw + this.K;
                    var11 = var8 - var9 - var3.cx + this.L;
                    bd.b(this.ar);
                    be.b(this.ar);
                    be.c((int)((float)be.f() * 0.5F));
                    var4.a(this.xCord - var3.cw, this.yCord - var3.cx - this.zCord, var27, var11, be);
                    var4.a(this.xCord - var3.cw, this.yCord - var3.cx - this.zCord, var27, var11, bd);
                    var4.a(var27, var11, 5.0F, bd);
                } else {
                    int var35;
                    if (this.M) {
                        this.N = class_340.a(this.N, var1);
                        if (this.O == null) {
                            this.O = new float[20];
                            this.N = 0.0F;
                        }

                        if (this.N == 0.0F) {
                            this.N = 4.0F;

                            for(int var29 = 0; var29 < this.O.length; ++var29) {
                                this.O[var29] = class_340.c(-10.0F, 10.0F);
                            }
                        }

                        var27 = this.xCord - var3.cw;
                        var11 = this.yCord - var3.cx - this.zCord;
                        var12 = var7 - var3.cw;
                        var13 = var8 - var9 - var3.cx;
                        var14 = (float)class_340.c(var27, var11, var12, var13);
                        var35 = this.O.length;
                        if (var14 < 200.0F) {
                            var35 = class_340.b(0, var35 - 5);
                        } else if (var14 < 100.0F) {
                            var35 = class_340.b(0, var35 - 10);
                        }

                        var16 = var14 / (float)(var35 - 1);
                        var17 = class_340.d(var27, var11, var12, var13);
                        var18 = var27;
                        var19 = var11;
                        var20 = class_340.k(var17);
                        float var21 = class_340.j(var17);

                        for(int var22 = 0; var22 < var35; ++var22) {
                            float var23 = this.O[var22];
                            float var24 = var27 + var20 * (float)var22 * var16;
                            float var25 = var11 + var21 * (float)var22 * var16;
                            if (var22 != var35 - 1) {
                                var24 -= var21 * var23;
                                var25 += var20 * var23;
                            }

                            var4.a(var18, var19, var24, var25, bg);
                            var18 = var24;
                            var19 = var25;
                        }
                    } else if (this.P != -1) {
                        TeamImageCache var30 = b;
                        int var28 = 20;
                        int var31 = 20;
                        if (this.R == 1) {
                            var30 = d;
                            var28 = 60;
                            var31 = 60;
                        } else if (this.R == 2) {
                            var30 = c;
                            var28 = 20;
                            var31 = 20;
                        }

                        if (var2.C != null) {
                            TeamImageCache var32 = var2.C;
                            int var34 = var2.C.p;
                            var35 = var2.C.q;
                            byte var36 = 0;
                            class_694.a(var32, var5, var6, 0.0F, this.aT, this.x, bc, var34, var35, var36);
                        } else if (this.Q != -1 && this.z) {
                            class_694.a(var30, var5, var6, 0.0F, this.aT, this.x, bc, var28, var31, this.Q);
                        }

                        if (var2.B != null) {
                            var30 = var2.B;
                            var28 = var2.B.p;
                            var31 = var2.B.q;
                        }

                        Paint var33 = this.f();
                        class_694.a(var30, var5, var6, this.zCord, this.aT, this.x, var33, var28, var31, this.P);
                    } else {
                        bb.b(this.ar);
                        if (this.zCord > 0.0F && this.z) {
                            var4.a(var5, var6, this.x, bc);
                        }

                        var4.a(var5, var6 - this.zCord, this.x, bb);
                        if (this.y > 0.0F) {
                            bb.c(bb.f() / 3);
                            var4.a(var5, var6 - this.zCord, this.y, bb);
                        }
                    }
                }
            } else if (var2.Y != null) {
                Paint var26 = this.f();
                var11 = 0.0F;
                var12 = 0.0F;
                if (var2.ad != 0.0F) {
                    var12 += var2.ad * this.J;
                }

                var13 = this.xCord - var3.cw;
                var14 = this.yCord - var3.cx - this.zCord;
                float var15 = var7 - var3.cw + this.K;
                var16 = var8 - var9 - var3.cx + this.L;
                var17 = (var15 + var13) * 0.5F;
                var18 = (var16 + var14) * 0.5F;
                var19 = class_340.b(var17, var18, var15, var16);
                var20 = class_340.d(var17, var18, var15, var16);
                var4.k();
                f.a(var17 - (float)var2.Y.r, var18 - var19, var17 + (float)var2.Y.r, var18 + var19);
                var4.a(var20 + 90.0F, var17, var18);
                var4.a(var2.Y, f, var26, var11, var12, 0, 0);
                var4.l();
                if (var2.Z != null) {
                    if (var2.aa) {
                        var4.k();
                        var4.a(var20 + 90.0F, var13, var14);
                        var4.a(var2.Z, var13, var14, var26);
                        var4.l();
                    } else {
                        var4.a(var2.Z, var13, var14, var26);
                    }
                }

                if (var2.ab != null) {
                    if (var2.ac) {
                        var4.k();
                        var4.a(var20 + 90.0F, var15, var16);
                        var4.a(var2.ab, var15, var16, var26);
                        var4.l();
                    } else {
                        var4.a(var2.ab, var15, var16, var26);
                    }
                }
            } else {
                bf.c((int)(60.0F + this.e() * 60.0F));
                var27 = var7 - var3.cw + this.K;
                var11 = var8 - var9 - var3.cx + this.L;
                bf.a(6.0F);
                var4.a(this.xCord - var3.cw, this.yCord - var3.cx - this.zCord, var27, var11, bf);
                bf.a(3.0F);
                var4.a(this.xCord - var3.cw, this.yCord - var3.cx - this.zCord, var27, var11, bf);
                var4.a(var27, var11, 8.0F, bf);
                var4.a(var27, var11, 5.0F, bf);
            }

            return true;
        }
    }

    public strictfp void a(float var1, boolean var2) {
    }

    public strictfp void d(float var1) {
    }

    public strictfp void e(float var1) {
    }

    public strictfp boolean f(float var1) {
        return false;
    }

    public strictfp Paint f() {
        Object var1;
        if (this.ar != aq) {
            if (GameEngine.at()) {
                var1 = this.a(this.ar);
            } else {
                var1 = bb;
                ((Paint)var1).b(this.ar);
            }
        } else {
            var1 = ba;
        }

        return (Paint)var1;
    }

    public strictfp class_525 a(int var1) {
        if (this.bj != null) {
            return this.bj;
        } else if (bk != null && bl == var1) {
            this.bj = bk;
            return this.bj;
        } else {
            class_525 var2 = new class_525();
            var2.a((ColorFilter)(new LightingColorFilter(var1, 0)));
            var2.b(var1);
            bk = var2;
            bl = var1;
            this.bj = var2;
            return this.bj;
        }
    }

    public strictfp void a(float var1, float var2, class_588 var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        if (this.j == null) {
            GameEngine.print("Projectile: cannot Retarget: source==null");
        } else {
            float var5 = this.xCord + class_340.k(this.az) * var2;
            float var6 = this.yCord + class_340.j(this.az) * var2;
            float var8 = var1 * var1;
            float var9 = -1.0F;
            OrderableUnit var10 = null;
            Unit var11 = null;
            if (this.j instanceof OrderableUnit) {
                var10 = (OrderableUnit)this.j;
                var11 = var10.ab();
            }

            Iterator var12 = var4.cc.a(var5, var6, var1).iterator();

            while(true) {
                Unit var13;
                boolean var14;
                do {
                    do {
                        if (!var12.hasNext()) {
                            return;
                        }

                        var13 = (Unit)var12.next();
                    } while(this.j.bX == var13.bX);

                    var14 = true;
                    if (var10 != null) {
                        var14 = var10.b(var13, true);
                    }

                    if (var14 && this.k >= 0 && var10 != null && this.k < var10.bl() && !var10.a(this.k, var13, true, false)) {
                        var14 = false;
                    }

                    if (var3 != null && !class_585.a(var3, var13.de())) {
                        var14 = false;
                    }
                } while(!var14);

                float var15 = class_340.a(var5, var6, var13.xCord, var13.yCord);
                boolean var16 = false;
                if (var9 == -1.0F || var15 < var9) {
                    var16 = true;
                }

                if (var11 == var13) {
                    var16 = true;
                }

                if (var16 && var15 < var8) {
                    var9 = var15;
                    this.l = var13;
                }
            }
        }
    }

    static {
        bc.b(-16777216);
        bc.c(108);
        bd.a(80, 255, 0, 0);
        bd.a(true);
        bd.a(5.0F);
        be.a(30, 255, 0, 0);
        be.a(true);
        be.a(8.0F);
        bf.a(80, 128, 166, 255);
        bf.a(true);
        bf.a(5.0F);
        bg.a(150, 224, 239, 255);
        bg.a(true);
        bg.a(3.0F);
        bh.a(110, 224, 239, 255);
        bh.a(true);
        bh.a(8.0F);
        bi = new class_692();
        bk = null;
        bl = 0;
    }
}
