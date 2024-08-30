package com.corrodinggames.rts.game;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;

public strictfp class ScorchMark extends GameObject {
    int a;
    int b;
    int c = 50;
    int d = 40;
    NukeMode e;
    int f;
    int g = -1;
    static final Rect h = new Rect();
    static final Rect i = new Rect();
    static final Paint j = class_694.b();
    static TeamImageCache k = null;
    static TeamImageCache l = null;
    static TeamImageCache m = null;
    static final RectF n = new RectF();

    public static strictfp void load() {
        GameEngine var0 = GameEngine.getGameEngine();
        k = var0.bO.a(AssetsID$drawable.scorch_mark, true);
        k.m = true;
        l = var0.bO.a(AssetsID$drawable.scorch_mark_nuke, true);
        l.m = true;
        m = var0.bO.a(AssetsID$drawable.blood_mark, true);
        m.m = true;
    }

    public ScorchMark() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.S(-1);
        this.f = var1.by;
    }

    public static strictfp void a(float var0, float var1) {
        a(var0, var1, NukeMode.NORMAL);
    }

    public static strictfp void a(float var0, float var1, NukeMode var2) {
        if (b(var0, var1, var2)) {
            ScorchMark var3 = new ScorchMark();
            var3.xCord = var0;
            var3.yCord = var1;
            if (var2 == NukeMode.NORMAL) {
                var3.a = 0;
                var3.b = class_340.a(var3, 0, 3, 0);
            } else {
                var3.a = 2;
            }

            if (var3.a == 2) {
                var3.c = l.m();
                var3.d = l.l();
            }

            var3.e = var2;
            var3.d();
        }
    }

    public static strictfp void a(OrderableUnit var0, int var1) {
        if (!var0.cJ()) {
            NukeMode var2 = var1 == 2 ? NukeMode.NUKE : NukeMode.NORMAL;
            if (!b(var0.xCord, var0.yCord, var2)) {
                return;
            }

            ScorchMark var3 = new ScorchMark();
            var3.a = var1;
            if (var3.a == 2) {
                var3.c = l.m();
                var3.d = l.l();
            }

            var3.xCord = var0.xCord;
            var3.yCord = var0.yCord;
            var3.e = var2;
            var3.b = class_340.a(var3, 0, 3, 0);
            var3.d();
        }

    }

    public static strictfp boolean b(float var0, float var1, NukeMode var2) {
        int var3 = 0;
        int var4 = 0;
        byte var5 = 5;
        byte var6 = 25;
        if (var2 == NukeMode.NUKE) {
            var6 = 45;
        }

        GameObject[] var7 = GameObject.er.a();
        int var8 = GameObject.er.size();

        for(int var9 = 0; var9 < var8; ++var9) {
            GameObject var10 = var7[var9];
            if (var10 instanceof ScorchMark) {
                ScorchMark var11 = (ScorchMark)var10;
                if (class_340.c(var11.xCord - var0) < (float)var6 && class_340.c(var11.yCord - var1) < (float)var6 && var11.e == var2) {
                    ++var3;
                    if (class_340.c(var11.xCord - var0) < (float)var5 && class_340.c(var11.yCord - var1) < (float)var5) {
                        ++var4;
                    }
                }
            }
        }

        if (var3 >= 3) {
            return false;
        } else if (var4 >= 1) {
            return false;
        } else {
            return true;
        }
    }

    public strictfp boolean a(GameEngine var1) {
        return false;
    }

    public strictfp boolean f(float var1) {
        return false;
    }

    public strictfp boolean c(float var1) {
        return true;
    }

    public strictfp RectF c() {
        n.a = this.xCord - (float)this.c * 0.5F;
        n.c = this.xCord + (float)this.c * 0.5F;
        n.b = this.yCord - (float)this.d * 0.5F;
        n.d = this.yCord + (float)this.d * 0.5F;
        return n;
    }

    public strictfp void a(class_28 var1, int var2, int var3, float var4) {
        int var5 = this.b * this.c;
        byte var6 = 0;
        TeamImageCache var7 = null;
        int var8 = this.c;
        int var9 = this.d;
        if (this.a == 0) {
            var7 = k;
        } else if (this.a == 1) {
            var7 = m;
        } else if (this.a == 2) {
            var7 = l;
        }

        Rect var10 = h;
        Rect var11 = i;
        var11.a = var5;
        var11.b = var6;
        var11.c = var5 + var8;
        var11.d = var6 + var9;
        int var12 = (int)this.xCord;
        int var13 = (int)this.yCord;
        var12 -= var2;
        var13 -= var3;
        int var14 = var8 >> 1;
        int var15 = var9 >> 1;
        float var16 = (float)(var12 - var14);
        float var17 = (float)(var13 - var15);
        float var18 = (float)(var12 + var14);
        float var19 = (float)(var13 + var15);
        var10.a = (int)(var16 * var4);
        var10.b = (int)(var17 * var4);
        var10.c = (int)(var18 * var4);
        var10.d = (int)(var19 * var4);
        var1.b(var7, var11, var10, j);
    }

    private strictfp void d() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bL.a(this);
    }

    public strictfp void e(float var1) {
    }

    public strictfp void a(float var1, boolean var2) {
    }

    public strictfp void d(float var1) {
    }

    public strictfp void a(float var1) {
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.xCord);
        var1.writeFloat(this.yCord);
        var1.writeInt(this.a);
        var1.writeInt(this.b);
        var1.writeInt(this.c);
        var1.writeInt(this.d);
        var1.writeEnum(this.e);
        var1.writeInt(this.f);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.xCord = var1.readFloat();
        this.yCord = var1.readFloat();
        this.a = var1.readInt();
        this.b = var1.readInt();
        this.c = var1.readInt();
        this.d = var1.readInt();
        if (var1.b() >= 87) {
            this.e = (NukeMode)var1.readEnum(NukeMode.class);
            this.f = var1.readInt();
        } else {
            this.e = this.a == 2 ? NukeMode.NUKE : NukeMode.NORMAL;
            if (this.a == 2) {
                this.c = l.m();
                this.d = l.l();
            }
        }

        super.a(var1);
    }
}
