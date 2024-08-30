package com.corrodinggames.rts.game.units;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.PointF;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.d.class_989;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.class_936;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.f
public strictfp class DamagingBorder extends class_83 {
    public float a = 2000.0F;
    public float b = 0.0F;
    public float c = 0.0F;
    public float d = 2000.0F;
    public float e;
    public float f;
    public boolean g = true;
    public float h = 1.0F;
    public boolean i;
    public float j;
    static Paint k = new Paint();
    static Paint l;
    static Paint m;
    static Paint n;
    static Paint o;
    static Paint p;
    boolean q;
    static final PointF r;

    public strictfp void a(GameOutputStream var1) {
        var1.writeByte(0);
        var1.writeFloat(this.a);
        var1.writeFloat(this.b);
        var1.writeFloat(this.c);
        var1.writeFloat(this.d);
        var1.writeFloat(this.e);
        var1.writeFloat(this.f);
        var1.writeBoolean(this.g);
        var1.writeFloat(this.h);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        var1.readByte();
        this.a = var1.readFloat();
        this.b = var1.readFloat();
        this.c = var1.readFloat();
        this.d = var1.readFloat();
        this.e = var1.readFloat();
        this.f = var1.readFloat();
        this.g = var1.readBoolean();
        this.h = var1.readFloat();
        super.a(var1);
        if (!this.bV) {
            GameEngine.getGameEngine().bW.a((Unit)this);
        }

    }

    public strictfp UnitType b() {
        return this.q ? UnitType.zoneMarker : UnitType.damagingBorder;
    }

    public static strictfp void d_() {
        GameEngine var0 = GameEngine.getGameEngine();
    }

    public DamagingBorder(boolean var1) {
        super(var1);
    }

    public strictfp DamagingBorder f() {
        Iterator var1 = Unit.bF().iterator();

        while(var1.hasNext()) {
            Unit var2 = (Unit)var1.next();
            if (var2 instanceof DamagingBorder && !var2.bV && var2 != this) {
                DamagingBorder var3 = (DamagingBorder)var2;
                if (var3.q == this.q) {
                    return var3;
                }
            }
        }

        return null;
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (!this.bV) {
            if (this.g) {
                this.g = false;
                DamagingBorder var2 = this.f();
                if (var2 != null) {
                    var2.e = this.xCord;
                    var2.f = this.yCord;
                    var2.d = this.d;
                    this.ci();
                } else {
                    this.e = this.xCord;
                    this.f = this.yCord;
                    if (!this.q) {
                        GameEngine.log("DamagingBorder created " + this.e + "," + this.f + " size:" + this.d);
                    }

                    GameEngine.getGameEngine().bW.a((Unit)this);
                }
            }

            float var3;
            float var4;
            float var12;
            if (this.q) {
                this.a = this.d;
                this.xCord = this.e;
                this.yCord = this.f;
            } else if (this.a > this.d) {
                this.b += 2.5E-4F * var1;
                this.a -= this.b;
                this.i = true;
                var12 = class_340.b(this.xCord, this.yCord, this.e, this.f);
                var3 = class_340.d(this.xCord, this.yCord, this.e, this.f);
                if (var12 > 1.0F) {
                    var4 = this.b;
                    if (var4 > var12 * var1) {
                        var4 = var12 * var1;
                    }

                    this.xCord += var4 * class_340.k(var3) * var1;
                    this.yCord += var4 * class_340.j(var3) * var1;
                }
            } else {
                this.i = false;
                this.xCord = (float)((double)this.xCord + (double)(this.e - this.xCord) * 0.003 * (double)var1);
                this.yCord = (float)((double)this.yCord + (double)(this.f - this.yCord) * 0.003 * (double)var1);
            }

            if (this.a < this.d) {
                this.a = this.d;
                this.b = 0.0F;
            }

            if (this.d < 0.0F) {
                this.ci();
            } else {
                this.c -= var1;
                float var5;
                if (!this.bV && this.c <= 0.0F && !this.q) {
                    this.c = 2.0F;
                    var12 = this.a * class_340.k(45.0F);
                    var3 = this.xCord - var12;
                    var4 = this.xCord + var12;
                    var5 = this.yCord - var12;
                    float var6 = this.yCord + var12;
                    float var7 = this.a * this.a;
                    Iterator var8 = Unit.bF().iterator();

                    label85:
                    while(true) {
                        Unit var9;
                        do {
                            if (!var8.hasNext()) {
                                break label85;
                            }

                            var9 = (Unit)var8.next();
                        } while(var9.xCord > var3 && var9.xCord < var4 && var9.yCord > var5 && var9.yCord < var6);

                        float var10 = class_340.a(this.xCord, this.yCord, var9.xCord, var9.yCord);
                        if (!(var10 < var7) && !var9.bV && !(var9 instanceof Tree) && !var9.u() && var9.cN == null) {
                            float var11 = 0.5F + var9.health * 0.002F + var9.totalHealth * 0.001F;
                            var11 *= this.h;
                            var9.a(this, var11, (Projectile)null);
                        }
                    }
                }

                if (!this.q) {
                    GameEngine var13 = GameEngine.getGameEngine();
                    this.j += var1;
                    if (this.j > 3.0F) {
                        this.j = 0.0F;
                        int var14 = var13.cu + class_340.rand(0, (int)var13.cA);
                        int var15 = var13.cv + class_340.rand(0, (int)var13.cB);
                        var5 = class_340.a(this.xCord, this.yCord, (float)var14, (float)var15);
                        if (var5 > (this.a + 30.0F) * (this.a + 30.0F)) {
                            var13.bL.a((float)var14, (float)var15);
                            int var16 = var13.bL.T;
                            int var17 = var13.bL.U;
                            var13.bL.a(var16, var17);
                            class_998 var18 = var13.bR.b((float)(var13.bL.T + 10), (float)(var13.bL.U - 10 + 10), 0.0F, class_989.CUSTOM, true, Priority.verylow);
                            if (var18 != null) {
                                var18.aq = 19;
                                var18.Y = class_340.c(-180.0F, 180.0F);
                                var18.r = true;
                                var18.ar = 1;
                                var18.E = 0.7F;
                                var18.V = 30.0F;
                                var18.W = var18.V;
                                var18.G = 0.2F;
                                var18.F = 1.2F;
                                var18.x = Color.a(255, 173, 12, 12);
                            }
                        }
                    }
                }

            }
        }
    }

    public strictfp int s() {
        return 0;
    }

    public strictfp boolean t() {
        return true;
    }

    public strictfp boolean u() {
        return true;
    }

    public strictfp boolean a(GameEngine var1) {
        return true;
    }

    public strictfp void a(float var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        float var4 = this.xCord - var3.cw;
        float var5 = this.yCord - var3.cx;
        Paint var6 = this.i ? m : k;
        if (this.q) {
            var6 = o;
        }

        float var7 = this.a;
        if (this.g) {
            DamagingBorder var8 = this.f();
            if (var8 != null) {
                var7 = var8.d - 300.0F;
            }
        }

        var3.bO.a(var4, var5, var7, var6);
    }

    public strictfp boolean a(int var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        var3.bO.i();
        var3.bO.a(var3.bW.w);
        float var4 = var3.bW.b(this.a);
        Paint var5 = this.i ? n : l;
        if (this.q) {
            var5 = p;
        }

        class_936.a(var3.bO, (float)var1, (float)var2, var4, var5);
        var3.bO.j();
        return true;
    }

    public strictfp void a(int var1) {
        this.a = (float)(var1 * 100);
        this.d = (float)(var1 * 100);
    }

    public strictfp boolean a(float var1, float var2) {
        float var3 = this.d * this.d;
        float var4 = class_340.a(this.e, this.f, var1, var2);
        return var4 >= var3;
    }

    public strictfp PointF a(float var1, float var2, float var3) {
        if (var3 > this.d) {
            var3 = this.d;
        }

        float var4 = class_340.d(this.xCord, this.yCord, var1, var2);
        float var5 = this.d - var3;
        float var6 = this.xCord + class_340.k(var4) * var5;
        float var7 = this.yCord + class_340.j(var4) * var5;
        r.x = var6;
        r.y = var7;
        return r;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }

    static {
        k.a(10.0F);
        k.b(Color.a(100, 160, 0, 0));
        k.a(Paint$Style.b);
        m = new Paint();
        m.a(k);
        m.b(Color.a(180, 160, 0, 0));
        l = new Paint();
        l.a(2.0F);
        l.b(Color.a(100, 160, 0, 0));
        l.a(Paint$Style.b);
        n = new Paint();
        n.a(l);
        n.b(Color.a(180, 160, 0, 0));
        o = new Paint();
        o.a(2.0F);
        o.b(Color.a(50, 255, 255, 255));
        o.a(Paint$Style.b);
        p = new Paint(o);
        r = new PointF();
    }
}
