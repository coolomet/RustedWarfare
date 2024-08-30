package com.corrodinggames.rts.game.units.custom.c;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.net.class_215;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.c.c
public strictfp class class_635 {
    static final Rect a = new Rect();
    static final RectF b = new RectF();
    static final Paint c = new Paint();
    class_684 d = new class_684();
    static Paint e = new Paint();
    public static class_311 f;

    public strictfp void a(class_591 var1) {
        Object[] var2 = this.d.a();

        for(int var3 = this.d.a - 1; var3 >= 0; --var3) {
            class_630 var4 = (class_630)var2[var3];
            class_634 var5 = var1.a(var4.a.g);
            if (var5 != null) {
                var4.a = var5;

                while(var4.b.size() > var4.a.d) {
                    var4.b.remove(var4.b.size() - 1);
                }
            } else {
                this.d.remove(var3);
            }
        }

    }

    public strictfp class_630 a(class_634 var1, boolean var2) {
        int var3 = this.d.a;
        Object[] var4 = this.d.a();

        for(int var5 = 0; var5 < var3; ++var5) {
            class_630 var6 = (class_630)var4[var5];
            if (var6.a == var1) {
                return var6;
            }
        }

        if (var2) {
            class_630 var7 = new class_630(var1);
            this.d.add(var7);
            return var7;
        } else {
            return null;
        }
    }

    public strictfp int a(class_634 var1) {
        class_630 var2 = this.a(var1, false);
        return var2 == null ? 0 : var2.b.a;
    }

    public strictfp void a(float var1, Unit var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        int var4 = this.d.a;
        if (var4 != 0) {
            Object[] var5 = this.d.a();

            for(int var6 = 0; var6 < var4; ++var6) {
                class_630 var7 = (class_630)var5[var6];
                class_634 var8 = var7.a;
                int var9 = var7.b.a;
                Object[] var10 = var7.b.a();

                for(int var11 = var9 - 1; var11 >= 0; --var11) {
                    class_631 var12 = (class_631)var10[var11];
                    if (var12.c) {
                        Unit var13 = var12.a;
                        if (var8.e != null) {
                            TeamImageCache var14 = var8.e;
                            float var15 = var2.xCord - GameEngine.getGameEngine().cw;
                            float var16 = var2.yCord - GameEngine.getGameEngine().cx - var2.zCord - 10.0F;
                            float var17 = var14.u;
                            float var18 = class_340.d(var2.xCord, var2.yCord - var2.zCord, var13.xCord, var13.yCord - var13.zCord);
                            float var19 = class_340.a(var2.xCord, var2.yCord - var2.zCord, var13.xCord, var13.yCord - var13.zCord);
                            if (var19 < (float)((var14.q - 2) * (var14.q - 2))) {
                                var17 = (float)class_340.a((int)var19);
                            }

                            var3.bO.k();
                            var3.bO.a(var18 + 90.0F, var15, var16);
                            a.a(0, (int)((float)var14.q - var17), var14.p, var14.q);
                            b.a(var15 - (float)var14.r, var16 - var17, var15 + (float)var14.r, var16);
                            Object var20 = class_525.r;
                            if (var12.d != 0.0F) {
                                var20 = c;
                                int var21 = (int)Math.abs(var12.d * 5.0F);
                                if (var21 > 250) {
                                    var21 = 250;
                                }

                                ((Paint)var20).a(255, 255, 255 - var21, 255 - var21);
                            }

                            var3.bO.a(var14, a, (RectF)b, (Paint)var20);
                            var3.bO.l();
                        }

                        if (var8.f != null) {
                            var3.bO.a(var2.xCord - var3.cw, var2.yCord - var3.cx - var2.zCord, var13.xCord - var3.cw, var13.yCord - var3.cx - var13.zCord, var8.f);
                        }
                    }
                }
            }

        }
    }

    public strictfp void a(GameOutputStream var1) {
        if (this.d.a == 0) {
            var1.writeByte(-1);
        } else {
            var1.writeByte(0);
            short var2 = (short)this.d.size();
            var1.a(var2);
            Object[] var3 = this.d.a();

            for(int var4 = 0; var4 < var2; ++var4) {
                class_630 var5 = (class_630)var3[var4];
                var1.a(var5.a.g);
                var1.a((short)var5.b.size());
                Iterator var6 = var5.b.iterator();

                while(var6.hasNext()) {
                    class_631 var7 = (class_631)var6.next();
                    var1.a(var7.a);
                    var1.writeBoolean(var7.b);
                    var1.writeBoolean(var7.c);
                }
            }

        }
    }

    public strictfp void a(Unit var1, GameInputStream var2) {
        byte var3 = var2.readByte();
        if (var3 != -1) {
            short var4 = var2.readShort();
            this.d.clear();

            for(int var5 = 0; var5 < var4; ++var5) {
                class_585 var6 = var2.m();
                class_634 var7 = null;
                if (var1 instanceof class_113) {
                    var7 = ((class_113)var1).x.a(var6);
                }

                class_630 var8 = null;
                if (var7 != null) {
                    var8 = new class_630(var7);
                    this.d.add(var8);
                }

                short var9 = var2.readShort();

                for(int var10 = 0; var10 < var9; ++var10) {
                    class_631 var11 = new class_631();
                    var11.a = var2.a(class_215.EXPECTED);
                    var11.b = var2.readBoolean();
                    var11.c = var2.readBoolean();
                    if (var11.a != null && var8 != null) {
                        var8.b.add(var11);
                    }
                }
            }

        }
    }

    static {
        e.a(255, 0, 0, 200);
        f = new class_311();
    }
}
