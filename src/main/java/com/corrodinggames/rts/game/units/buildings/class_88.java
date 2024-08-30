package com.corrodinggames.rts.game.units.buildings;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.class_482;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_387;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.d.class_990;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.d
public abstract strictfp class class_88 extends OrderableUnit {
    TeamImageCache m;
    public Rect n = new Rect();
    public Rect o = new Rect();
    public static TeamImageCache p = null;
    public static TeamImageCache[] q = new TeamImageCache[10];
    int r = 1;
    int s = 0;

    public strictfp boolean ds() {
        return false;
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeInt(this.r);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        if (var1.b() >= 15) {
            int var2 = var1.readInt();
            this.R(var2);
        }

        super.a(var1);
    }

    public static strictfp boolean a(class_31 var0, float var1, float var2, PlayerData var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        OrderableUnit var5 = (OrderableUnit) Unit.a(var0);
        var4.bL.b(var1, var2);
        var5.xCord = (float)var4.bL.T + var5.cZ();
        var5.yCord = (float)var4.bL.U + var5.cZ();
        var5.b(var3);
        boolean var6 = var5.c((PlayerData)null);
        return var6;
    }

    public strictfp void R(int var1) {
        this.r = var1;
    }

    public strictfp TeamImageCache d(int var1) {
        return null;
    }

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : q[this.bX.R()];
    }

    public static strictfp void dt() {
        GameEngine var0 = GameEngine.getGameEngine();
        p = var0.bO.a(AssetsID$drawable.unit_icon_building);
        q = PlayerData.a(p);
    }

    public class_88(boolean var1) {
        super(var1);
        this.cg = -90.0F;
        this.bT = false;
    }

    public strictfp void f_() {
        this.bT = false;
    }

    public strictfp boolean L() {
        this.a((ExplodeType) ExplodeType.large);
        return false;
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bU.a((OrderableUnit)this);
        if (this.cm < 1.0F) {
            this.a((ExplodeType) ExplodeType.verysmall);
            return false;
        } else {
            this.s = 0;
            return this.L();
        }
    }

    public strictfp Rect cd() {
        return this.o;
    }

    public strictfp Rect cc() {
        return this.n;
    }

    public static strictfp boolean a(OrderableUnit var0, class_31 var1, MovementType var2, int var3, int var4, int var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        class_484 var7 = var6.bL;
        if (!var7.c(var3, var4)) {
            return false;
        } else {
            boolean var8 = false;
            if (var7.E && var6.playerTeam.N != null) {
                if (!var7.G && var6.playerTeam.N[var3][var4] == 10) {
                    return false;
                }

                var8 = var6.playerTeam.N[var3][var4] >= 5;
            }

            if (a(var0, var1, var2, var3, var4, var8)) {
                if (var1.p()) {
                    class_482 var9 = var7.e(var3, var4);
                    return var9 != null && var9.i;
                } else {
                    return !class_990.a(var6.playerTeam, var3, var4, var5);
                }
            } else {
                return false;
            }
        }
    }

    public static strictfp boolean a(OrderableUnit var0, class_31 var1, MovementType var2, int var3, int var4, boolean var5) {
        return a(var0, var1, var2, var3, var4, var5, (PlayerData)null) == null;
    }

    public static strictfp String a(OrderableUnit var0, class_31 var1, MovementType var2, int var3, int var4, boolean var5, PlayerData var6) {
        GameEngine var7 = GameEngine.getGameEngine();
        if (!var7.bL.c(var3, var4)) {
            return "{0}";
        } else {
            class_387 var8 = var1.q();
            if (var8 != null) {
                String var9 = var8.a(var0, var3, var4);
                if (var9 != null) {
                    return var9;
                }
            }

            if (var1 != UnitType.seaFactory && var2 != MovementType.WATER) {
                class_482 var11 = var7.bL.e(var3, var4);
                if (var11 != null && var11.i) {
                    return var1.p() ? null : "{0}";
                } else if (var2 == MovementType.AIR) {
                    return null;
                } else if (var2 == MovementType.HOVER) {
                    return !var7.bU.a(var7.bU.C, var3, var4) ? null : "{0}";
                } else if (var2 == MovementType.OVER_CLIFF) {
                    return !var7.bU.a(var7.bU.D, var3, var4) ? null : "{0}";
                } else if (var2 == MovementType.OVER_CLIFF_WATER) {
                    return !var7.bU.a(var7.bU.E, var3, var4) ? null : "{0}";
                } else {
                    if (var7.bU.a(var7.bU.z, var3, var4, var5)) {
                        boolean var10 = false;
                        if (var6 != null && !var7.bL.a(var3, var4, var6)) {
                            var10 = true;
                        }

                        if (!var10) {
                            return "{0}";
                        }
                    }

                    return null;
                }
            } else {
                return !var7.bU.a(var7.bU.A, var3, var4) ? null : "{3}";
            }
        }
    }

    public static strictfp Unit b(int var0, int var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var2.bL.a(var0, var1);
        float var3 = (float)(var2.bL.T + var2.bL.p);
        float var4 = (float)(var2.bL.U + var2.bL.q);
        Iterator var5 = var2.cc.b(var3, var4, 0.0F).iterator();

        Unit var6;
        do {
            if (!var5.hasNext()) {
                return null;
            }

            var6 = (Unit)var5.next();
        } while(!var6.bI() || var6.bV || !var6.c(var3, var4, 0.0F));

        return var6;
    }

    public strictfp void a(int var1) {
    }

    public static strictfp Unit g(class_31 var0) {
        if (var0 == null) {
            throw new RuntimeException("type is null");
        } else {
            return var0.a();
        }
    }

    public strictfp boolean I() {
        return false;
    }

    public strictfp MovementType h() {
        return MovementType.NONE;
    }

    public strictfp boolean i() {
        return false;
    }

    public strictfp boolean Q() {
        return false;
    }

    public strictfp float speed() {
        return 0.0F;
    }

    public strictfp float turnSpeed() {
        return 0.0F;
    }

    public strictfp boolean b_() {
        return false;
    }

    public strictfp Paint f() {
        GameEngine var1 = GameEngine.getGameEngine();
        PorterDuffColorFilter var2 = null;
        int var3;
        if (this.cm < 1.0F) {
            var3 = Color.a((int)(40.0F + this.cm * 200.0F), 140, 255, 140);
            var2 = aX;
        } else {
            var3 = Color.a(255, 255, 255, 255);
        }

        if (this.cp) {
            if (this.cs) {
                var3 = Color.a(200, 20, 255, 20);
                var2 = aY;
            }

            if (this.ct) {
                var3 = Color.a(200, 255, 20, 20);
                var2 = aZ;
            }

            if (this.cq) {
                var3 = Color.a(70, 70, 70, 245);
                var2 = ba;
                if (this.ct) {
                    var3 = Color.a(70, 255, 20, 20);
                    var2 = aZ;
                }
            }

            if (this.cr) {
                var3 = Color.a(150, 100, 100, 100);
            }
        }

        boolean var4 = var1.settingsEngine.renderAntiAlias;
        if (!this.dk()) {
            var4 = false;
            if (var1.cX < 1.0F) {
                var4 = true;
            }
        }

        if (this.co) {
            var4 = UnitType.ag;
        }

        return this.a(var3, var2, var4);
    }

    public strictfp boolean c(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        int var3 = this.s * this.es;
        byte var4 = 0;
        RectF var5 = this.cF();
        dv.a(var3, var4, var3 + this.es, var4 + this.et);
        var2.bO.a(this.M, dv, var5, this.f());
        return true;
    }

    public strictfp void d(float var1) {
        super.d(var1);
        if (this.m != null) {
            GameEngine var2 = GameEngine.getGameEngine();
            if (this.ds()) {
                var2.bO.b(this.m, this.xCord - (float)((int)(this.m.t + 0.1F)) - var2.cw, this.yCord - (float)((int)(this.m.u + 0.1F)) - var2.cx, this.f());
            } else {
                byte var3 = 0;
                byte var4 = 0;
                RectF var5 = this.cF();
                dv.a(var3, var4, var3 + this.es, var4 + this.et);
                var2.bO.a(this.m, dv, var5, this.f());
            }

        }
    }

    public strictfp boolean bI() {
        return true;
    }
}
