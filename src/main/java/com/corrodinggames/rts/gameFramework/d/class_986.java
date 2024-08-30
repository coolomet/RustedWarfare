package com.corrodinggames.rts.gameFramework.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Cap;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.maps.class_482;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.Shader;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.d.c
public final strictfp class class_986 {
    public int a = 0;
    public int b = 80;
    public int c = 100;
    public int d = 110;
    public int e = 120;
    public static class_998[] f = new class_998[0];
    public static int g = 0;
    public static boolean h;
    public int i;
    public int j;
    private boolean[] y = new boolean[5];
    public static Shader k;
    public TeamImageCache l;
    public TeamImageCache m;
    public static final RectF n = new RectF();
    public static final Rect o = new Rect();
    public static final Rect p = new Rect();
    public static final Paint q = new Paint();
    public static final Paint r = new Paint();
    public static class_996[] s;
    Priority t = null;
    boolean u = false;
    boolean v = false;
    public final Paint w = new Paint();
    float x = 0.0F;

    public class_998 a(Priority var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        int var3 = 0;
        int var4 = var2.b();
        if (var4 < 13) {
            var3 = -this.j;
        } else if (var4 < 28) {
            var3 = -this.i;
        }

        int var5 = this.a;
        if (var1 == Priority.verylow && var5 > this.b + var3) {
            return null;
        } else if (var1 == Priority.low && var5 > this.c + var3) {
            return null;
        } else if (var1 == Priority.high && var5 > this.d + var3) {
            return null;
        } else if (var1 == Priority.veryhigh && var5 > this.e + var3) {
            return null;
        } else {
            class_998 var6 = null;
            var6 = this.a(true, (Priority)null);
            if (var6 == null && (var1 == Priority.critical || var1 == Priority.veryhigh)) {
                var6 = this.a(false, Priority.high);
            }

            if (var6 != null) {
                if (!var6.o) {
                    var6.o = true;
                    ++this.a;
                }

                return var6;
            } else {
                return null;
            }
        }
    }

    private class_998 a(boolean var1, Priority var2) {
        class_998[] var3 = f;
        int var4 = var3.length;
        int var5;
        class_998 var6;
        if (var1 && var2 == null) {
            for(var5 = 0; var5 < var4; ++var5) {
                var6 = var3[var5];
                if (!var6.o) {
                    if (g == var5) {
                        ++g;
                    }

                    return var6;
                }
            }

            return null;
        } else {
            for(var5 = 0; var5 < var4; ++var5) {
                var6 = var3[var5];
                if ((!var1 || !var6.o) && (var2 == null || var6.q.a(var2))) {
                    return var6;
                }
            }

            return null;
        }
    }

    public void a(float var1, float var2, float var3) {
        this.a(var1, var2, var3, 0.0F, 20.0F);
    }

    public void a(float var1, float var2, float var3, float var4, float var5) {
        for(int var6 = 0; var6 < 7; ++var6) {
            class_998 var7 = this.b(var1 + class_340.c(-20.0F, 20.0F), var2 + class_340.c(-20.0F, 20.0F), var3);
            if (var7 != null) {
                var7.U = var4 + class_340.c(0.0F, var5);
                var7.aj = class_340.c(0.3F, 0.6F);
            }
        }

    }

    public float a(float var1, float var2) {
        return class_340.c(var1, var2);
    }

    public class_998 b(float var1, float var2, float var3) {
        this.a();
        class_998 var4 = this.b(var1, var2, var3, class_989.CUSTOM, false, Priority.high);
        if (var4 != null) {
            var4.aq = 1;
            var4.ae = true;
            var4.ak = 0.0F;
            var4.aj = 0.5F;
            var4.ag = 12;
            var4.ap = 0;
            var4.V = 35.0F;
            var4.W = var4.V - 10.0F;
            var4.r = true;
            var4.E = 0.7F;
            var4.Y = this.a(-180.0F, 180.0F);
            float var5 = this.a(0.8F, 1.0F);
            var4.G = var5;
            var4.F = var5;
        }

        return var4;
    }

    public class_998 c(float var1, float var2, float var3) {
        this.a();
        class_998 var4 = this.b(var1, var2, var3, class_989.CUSTOM, false, Priority.high);
        if (var4 != null) {
            var4.aq = 13;
            var4.ae = true;
            var4.ak = 3.0F;
            var4.aj = 0.5F;
            var4.ag = 7;
            var4.ap = 0;
            var4.V = 35.0F;
            var4.W = var4.V - 10.0F;
            var4.r = true;
            var4.E = 1.0F;
            var4.G = 0.5F;
            var4.F = 0.5F;
        }

        return var4;
    }

    public class_998 a(float var1, float var2, float var3, float var4, float var5, float var6) {
        GameEngine var7 = GameEngine.getGameEngine();
        if (!var7.bL.a(var1, var2, var7.playerTeam) && !var7.bL.a(var4, var5, var7.playerTeam)) {
            return null;
        } else {
            class_998 var8 = this.b(var1, var2, var3, class_989.CUSTOM, true, Priority.high);
            if (var8 != null) {
                var8.an = false;
                var8.V = 5.0F;
                var8.W = var8.V;
                var8.r = true;
                var8.E = 1.0F;
                var8.L = true;
                var8.M = var4;
                var8.N = var5;
                var8.O = var6;
            }

            return var8;
        }
    }

    public class_998 a(float var1, float var2, float var3, float var4) {
        return this.a(var1, var2, var3, var4, 0);
    }

    public class_998 a(float var1, float var2, float var3, float var4, int var5) {
        return this.a(var1, var2, var3, var4, var5, 0);
    }

    public class_998 b(float var1, float var2, float var3, float var4, int var5) {
        return this.a(var1, var2, var3, var4, var5, 1);
    }

    public class_998 a(float var1, float var2, float var3, float var4, int var5, int var6) {
        this.a();
        class_998 var7 = this.b(var1, var2, var3, class_989.CUSTOM, false, Priority.high);
        if (var7 != null) {
            var7.g = class_998.j;
            var7.ae = true;
            if (var6 == 1) {
                var7.aq = 3;
                var7.ak = 1.0F;
                var7.aj = 0.4F;
                var7.ag = 4;
            } else {
                var7.aq = 3;
                var7.ak = 0.0F;
                var7.aj = 0.5F;
                var7.ag = 3;
            }

            var7.Y = var4;
            var7.ap = 0;
            var7.V = 20.0F;
            var7.W = var7.V;
            var7.r = false;
            if (var5 != 0) {
                var7.B = new LightingColorFilter(var5, 0);
            }
        }

        return var7;
    }

    public class_998 c(float var1, float var2, float var3, float var4, int var5) {
        class_998 var6 = this.b(var1, var2, var3, class_989.CUSTOM, false, Priority.verylow);
        if (var6 != null) {
            var6.aq = 4;
            var6.g = class_998.i;
            var6.ap = class_340.rand(0, 2);
            var6.Y = var4;
            var6.an = true;
            var6.P = class_340.k(var4) * 0.15F;
            var6.Q = class_340.j(var4) * 0.15F;
            var6.V = 30.0F;
            var6.W = var6.V;
            var6.r = true;
            var6.ar = 1;
            var6.G = 0.8F;
            var6.F = 2.3F;
            if (var5 != 0) {
                var6.B = new LightingColorFilter(var5, 0);
            }
        }

        return var6;
    }

    public static void a(class_998 var0, GameObject var1) {
        if (var0 != null) {
            var0.b = var1;
            var0.I -= var1.xCord;
            var0.J -= var1.yCord;
            var0.K -= var1.zCord;
        }
    }

    public class_998 a(GameObject var1, int var2) {
        return this.a(var1, var2, 0.5F);
    }

    public class_998 a(GameObject var1, int var2, float var3) {
        this.b();
        class_998 var4 = this.b(var1.xCord, var1.yCord, var1.zCord, var2);
        if (var4 != null) {
            var4.I = 0.0F;
            var4.J = 0.0F;
            var4.K = 0.0F;
            var4.V = 400.0F;
            var4.W = var4.V;
            var4.E = 0.3F;
            var4.G = var3;
            var4.b = var1;
        }

        return var4;
    }

    public class_998 a(float var1, float var2, float var3, int var4) {
        if (this.t == null && !this.v) {
            this.a();
        }

        return this.b(var1, var2, var3, var4);
    }

    public class_998 b(float var1, float var2, float var3, int var4) {
        class_998 var5 = this.b(var1, var2, var3, class_989.CUSTOM, true, Priority.low);
        if (var5 != null) {
            var5.e = false;
            var5.g = class_998.h;
            var5.aq = 2;
            var5.V = 10.0F;
            var5.W = var5.V;
            var5.r = true;
            var5.E = 0.5F;
            var5.ar = 2;
            var5.d = true;
            if (var4 != 0) {
                var5.x = var4;
                var5.B = new LightingColorFilter(var4, 0);
            }
        }

        return var5;
    }

    public class_998 b(float var1, float var2, float var3, float var4) {
        this.a();
        class_998 var5 = this.b(var1, var2, var3, class_989.CUSTOM, false, Priority.low);
        if (var5 != null) {
            var5.g = class_998.l;
            var5.aq = 0;
            var5.ap = 13;
            var5.ar = 1;
            var5.r = true;
            var5.E = 0.8F;
            var5.W = 80.0F;
            var5.V = var5.W;
            var5.Y = class_340.c(-180.0F, 180.0F);
            var5.G = class_340.c(0.6F, 0.8F);
            var5.F = 1.5F;
            var5.P = class_340.k(var4) * 0.13F * class_340.c(1.0F, 1.5F) + class_340.c(-0.01F, 0.01F);
            var5.Q = class_340.j(var4) * 0.13F * class_340.c(1.0F, 1.5F) + class_340.c(-0.01F, 0.01F);
        }

        return var5;
    }

    public class_998 a(float var1, float var2, float var3, int var4, float var5, float var6) {
        class_998 var7 = this.b(var1, var2, var3, class_989.CUSTOM, false, Priority.high);
        if (var7 != null) {
            var7.g = class_998.l;
            var7.aq = 6;
            var7.V = 120.0F;
            var7.W = var7.V;
            var7.r = true;
            var7.G = 0.2F;
            var7.F = 0.9F;
            var7.ar = 1;
            var7.E = 0.5F;
            var7.P = var5;
            var7.Q = var6;
            if (var4 != 0) {
                var4 = Color.a(255, 0, 0, 200);
            }

            if (var4 != 0) {
                var7.B = new LightingColorFilter(var4, 0);
            }
        }

        return var7;
    }

    public void a(float var1, float var2, float var3, int var4, float var5, float var6, float var7) {
        this.a(var1, var2, 0.0F, 0, 0.0F, 0.0F);

        for(int var8 = -180; var8 < 180; var8 += 45) {
            float var9 = var7 + (float)var8;
            float var10 = var1 + class_340.k(var9) * -5.0F;
            float var11 = var2 + class_340.j(var9) * -5.0F;
            class_998 var12 = this.b(var10, var11, 0.0F, var9);
            if (var12 != null) {
                var12.ar = 2;
                var12.s = true;
                var12.t = 7.0F;
            }
        }

    }

    public class_998 c(float var1, float var2, float var3, int var4) {
        class_998 var5 = this.d(var1, var2, var3, var4);
        if (var5 != null) {
            var5.aq = 11;
        }

        return var5;
    }

    public class_998 d(float var1, float var2, float var3, int var4) {
        this.a();
        class_998 var5 = this.b(var1, var2, var3, class_989.CUSTOM, false, Priority.high);
        if (var5 != null) {
            var5.aq = 6;
            var5.V = 30.0F;
            var5.W = var5.V;
            var5.r = true;
            var5.G = 0.2F;
            var5.F = 1.3F;
            var5.ar = 1;
            if (var4 != 0) {
                var5.B = new LightingColorFilter(var4, 0);
            }
        }

        return var5;
    }

    public class_998 d(float var1, float var2, float var3) {
        class_998 var4 = this.b(var1, var2, var3, 0.3F, 0.7F);
        if (var4 != null) {
            var4.aq = 14;
            var4.ap = class_340.rand(0, 5);
            var4.w = 0.5F;
        }

        return var4;
    }

    public class_998 e(float var1, float var2, float var3) {
        class_998 var4 = this.b(var1, var2, var3, 1.0F, 1.0F);
        if (var4 != null) {
        }

        return var4;
    }

    public class_998 b(float var1, float var2, float var3, float var4, float var5) {
        this.b();
        class_998 var6 = this.b(var1, var2, var3, class_989.CUSTOM, false, Priority.high);
        if (var6 != null) {
            var6.g = class_998.m;
            var6.aq = 12;
            var6.ap = class_340.rand(0, 7);
            var6.V = class_340.c(400.0F, 800.0F);
            var6.W = var6.V - 150.0F;
            var6.r = true;
            float var7 = class_340.c(0.6F, 1.0F);
            var6.G = var7;
            var6.F = var7;
            var6.ar = 2;
            var6.v = true;
            var6.as = true;
            float var8 = class_340.c(-180.0F, 180.0F);
            float var9 = class_340.c(0.4F, 1.2F) * var4;
            var6.P = class_340.k(var8) * var9;
            var6.Q = class_340.j(var8) * var9;
            var6.R = class_340.c(0.6F, 2.7F) * var5;
            var6.Y = class_340.c(-180.0F, 180.0F);
            ++var6.K;
        }

        return var6;
    }

    public class_998 f(float var1, float var2, float var3) {
        class_998 var4 = this.b(var1, var2, var3, class_989.CUSTOM, false, Priority.low);
        if (var4 != null) {
            var4.aq = 8;
            var4.V = 480.0F;
            var4.W = var4.V;
            var4.r = false;
            var4.ar = 1;
            var4.ae = true;
            var4.ak = 0.0F;
            var4.G = 0.5F;
            var4.G = 1.0F;
            int var5 = class_340.rand(0, 100);
            if (var5 > 80) {
                var4.aj = class_340.c(0.1F, 0.15F);
                var4.ag = 15;
            } else if (var5 > 60) {
                var4.aj = class_340.c(0.06F, 0.16F);
                var4.ah = true;
                var4.ag = 6;
                var4.r = true;
            } else {
                var4.aj = class_340.c(0.06F, 0.16F);
                var4.ah = true;
                var4.ag = 3;
                var4.r = true;
            }
        }

        return var4;
    }

    public void b(Priority var1) {
        this.t = var1;
    }

    public void a() {
        this.u = true;
    }

    public void b() {
        this.v = true;
    }

    public class_998 a(float var1, float var2, float var3, class_989 var4, boolean var5, Priority var6) {
        class_998 var7 = this.b(var1, var2, var3, var4, var5, var6);
        if (var7 != null) {
            var7.p = true;
        }

        return var7;
    }

    public class_998 b(float var1, float var2, float var3, class_989 var4, boolean var5, Priority var6) {
        GameEngine var7 = GameEngine.getGameEngine();
        if (this.t != null) {
            var6 = this.t;
            this.t = null;
        }

        boolean var8 = this.v;
        this.v = false;
        if (this.u) {
            this.u = false;
            if (!var7.cP.b(var1, var2)) {
                return null;
            }
        }

        if (!var5 && var7.bL != null && !var7.bL.a(var1, var2, var7.playerTeam)) {
            return null;
        } else {
            if (var7.cO.b(var1, var2)) {
                if (var6 == Priority.verylow) {
                    var6 = Priority.low;
                } else if (var6 == Priority.low) {
                    var6 = Priority.high;
                } else if (var6 == Priority.high) {
                    var6 = Priority.veryhigh;
                }
            } else if (!var8 && !var7.cP.b(var1, var2)) {
            }

            class_998 var9 = this.a(var6);
            if (var9 == null) {
                return null;
            } else {
                var9.c();
                var9.q = var6;
                var9.aq = 0;
                var9.an = true;
                var9.I = var1;
                var9.J = var2;
                var9.K = var3;
                var9.E = 1.0F;
                if (var4 == class_989.HIT_GROUND || var4 == class_989.PLAYER_LAND || var4 == class_989.PLAYER_JUMP) {
                    var9.ap = 7;
                    var9.V = 12.0F;
                    var9.r = true;
                    var9.Q = -0.3F;
                    var9.E = 0.7F;
                    if (var4 == class_989.PLAYER_JUMP) {
                        var9.ap = 3;
                        var9.Q = -0.7F;
                        var9.V = 24.0F;
                        var9.E = 0.7F;
                    }

                    if (var4 == class_989.PLAYER_LAND) {
                        var9.ap = 4;
                        var9.V = 15.0F;
                        var9.E = 0.4F;
                    }
                }

                if (var4 == class_989.TELEPORT) {
                    var9.ap = 1;
                    var9.V = 25.0F;
                    var9.r = true;
                }

                if (var4 == class_989.GEM_COLLECT) {
                    var9.ap = 5;
                    var9.V = 42.0F;
                    var9.r = true;
                    var9.Q = 0.1F;
                    var9.E = 2.0F;
                }

                if (var4 == class_989.KEY_DOOR_OPEN) {
                    var9.ap = 6;
                    var9.V = 39.0F;
                    var9.r = true;
                    var9.Q = 0.1F;
                    var9.E = 2.0F;
                }

                if (var4 == class_989.BLOOD) {
                    var9.ap = 14;
                    var9.V = 39.0F;
                    var9.r = true;
                    var9.Q = 0.1F;
                    var9.E = 0.7F;
                }

                var9.W = var9.V;
                return var9;
            }
        }
    }

    public void a(Context var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.w.a(130, 200, 0, 0);
        this.w.a(true);
        this.w.a(2.0F);
        this.w.a(Paint$Cap.b);
        if (GameEngine.aW) {
            this.w.a(3.0F);
        }

        s = new class_996[20];
        class_996 var3 = new class_996();
        var3.b = 25;
        var3.c = 25;
        var3.d = 1;
        var3.e = 1;
        var3.f = 26;
        var3.g = 26;
        var3.i = var2.bO.a(AssetsID$drawable.effects, true);
        var3.a = "effects";
        var3.a();
        s[0] = var3;
        var3 = new class_996();
        var3.b = 39;
        var3.c = 40;
        var3.d = 1;
        var3.e = 1;
        var3.f = 40;
        var3.g = 41;
        var3.i = var2.bO.a(AssetsID$drawable.explode_big, true);
        var3.a = "explode_big";
        s[1] = var3;
        var3 = new class_996();
        var3.k = true;
        var3.i = var2.bO.a(AssetsID$drawable.light_50, true);
        var3.a = "light_50";
        s[2] = var3;
        var3 = new class_996();
        var3.b = 20;
        var3.c = 25;
        var3.d = 0;
        var3.e = 0;
        var3.f = 20;
        var3.g = 25;
        var3.i = var2.bO.a(AssetsID$drawable.flame, true);
        var3.a = "flame";
        s[3] = var3;
        var3 = new class_996();
        var3.b = 20;
        var3.c = 25;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.dust, true);
        var3.a = "dust";
        s[4] = var3;
        var3 = new class_996();
        var3.b = 50;
        var3.c = 40;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.smoke_black, true);
        var3.a = "smoke_black";
        var3.a();
        s[5] = var3;
        var3 = new class_996();
        var3.b = 50;
        var3.c = 50;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.shockwave, true);
        var3.a = "shockwave";
        s[6] = var3;
        var3 = new class_996();
        var3.b = 20;
        var3.c = 20;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.fire, true);
        var3.a = "fire";
        s[7] = var3;
        var3 = new class_996();
        var3.b = 20;
        var3.c = 30;
        var3.f = var3.b + 2;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.lava_bubble, true);
        var3.a = "lava_bubble";
        s[8] = var3;
        var3 = new class_996();
        var3.b = 28;
        var3.c = 28;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b + 1;
        var3.g = var3.c + 1;
        var3.i = var2.bO.a(AssetsID$drawable.effects2, true);
        var3.a = "effects2";
        s[9] = var3;
        var3 = new class_996();
        var3.b = 20;
        var3.c = 25;
        var3.d = 0;
        var3.e = 0;
        var3.f = 20;
        var3.g = 25;
        var3.i = var2.bO.a(AssetsID$drawable.plasma_shot, true);
        var3.a = "plasma_shot";
        s[10] = var3;
        var3 = new class_996();
        var3.b = 104;
        var3.c = 104;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.shockwave_large, true);
        var3.a = "shockwave_large";
        s[11] = var3;
        var3 = new class_996();
        var3.b = 20;
        var3.c = 20;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.explode_bits, true);
        var3.a = "explode_bits";
        var3.a();
        s[12] = var3;
        var3 = new class_996();
        var3.b = 39;
        var3.c = 40;
        var3.d = 1;
        var3.e = 1;
        var3.f = 40;
        var3.g = 41;
        var3.i = var2.bO.a(AssetsID$drawable.explode_big2, true);
        var3.a = "explode_big2";
        s[13] = var3;
        var3 = new class_996();
        var3.b = 20;
        var3.c = 20;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.explode_bits_bug, true);
        var3.a = "explode_bits_bug";
        var3.a();
        s[14] = var3;
        var3 = new class_996();
        var3.b = 20;
        var3.c = 20;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.projectiles, true);
        var3.a = "projectiles";
        var3.a();
        s[15] = var3;
        var3 = new class_996();
        var3.b = 20;
        var3.c = 20;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.projectiles2, true);
        var3.a = "projectiles2";
        var3.a();
        s[16] = var3;
        var3 = new class_996();
        var3.b = 30;
        var3.c = 30;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b + 1;
        var3.g = var3.c + 1;
        var3.i = var2.bO.a(AssetsID$drawable.effects3, true);
        var3.a = "effects3";
        s[17] = var3;
        var3 = new class_996();
        var3.b = 50;
        var3.c = 40;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.smoke_white, true);
        var3.a = "smoke_white";
        var3.a();
        s[18] = var3;
        var3 = new class_996();
        var3.b = 56;
        var3.c = 56;
        var3.d = 0;
        var3.e = 0;
        var3.f = var3.b;
        var3.g = var3.c;
        var3.i = var2.bO.a(AssetsID$drawable.shockwave2, true);
        var3.a = "shockwave2";
        var3.a();
        s[19] = var3;
        short var4;
        if (GameEngine.av()) {
            var4 = 500;
            this.i = 90;
            this.j = 210;
        } else {
            var4 = 350;
            this.i = 90;
            this.j = 170;
        }

        f = new class_998[var4];
        this.b = var4 - 60;
        this.c = var4 - 30;
        this.d = var4 - 20;
        this.e = var4 - 10;

        for(int var5 = 0; var5 < f.length; ++var5) {
            f[var5] = new class_998(this);
        }

    }

    public int a(String var1) {
        for(int var2 = 0; var2 < s.length; ++var2) {
            if (s[var2] != null) {
                if (s[var2].a != null && s[var2].a.equalsIgnoreCase(var1)) {
                    return var2;
                }

                if (("" + var2).equals(var1)) {
                    return var2;
                }
            }
        }

        return -1;
    }

    public void a(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_998[] var3 = f;

        int var4;
        for(var4 = 0; var4 < g; ++var4) {
            class_998 var5 = var3[var4];
            if (var5.o && !var5.p) {
                var5.b(var1);
            }
        }

        if (h) {
            while(g > 0) {
                class_998 var9 = var3[g - 1];
                if (var9.o) {
                    break;
                }

                --g;
            }
        }

        this.x += var1;
        if (this.x > 10.0F) {
            this.x = 0.0F;
            var4 = var2.cu + class_340.rand(0, (int)var2.cA);
            int var10 = var2.cv + class_340.rand(0, (int)var2.cB);
            var2.bL.a((float)var4, (float)var10);
            int var6 = var2.bL.T;
            int var7 = var2.bL.U;
            class_482 var8 = var2.bL.d(var6, var7);
            if (var8 != null && var8.g && !var8.h) {
                var2.bL.a(var6, var7);
                this.f((float)(var2.bL.T + 10), (float)(var2.bL.U - 10 + 10), 0.0F);
            }
        }

    }

    public int b(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        int var3 = 0;

        int var4;
        for(var4 = 0; var4 < this.y.length; ++var4) {
            this.y[var4] = false;
        }

        for(var4 = 0; var4 < g; ++var4) {
            class_998 var5 = f[var4];
            if (var5.o) {
                if (!this.y[var5.ar]) {
                    this.y[var5.ar] = true;
                }

                if (var5.p) {
                    var5.b(var1);
                }

                if (var5.as) {
                    boolean var6 = var5.a(var2, true);
                    if (var6) {
                        ++var3;
                    }
                }
            }
        }

        return var3;
    }

    public int a(float var1, int var2) {
        if (!this.y[var2]) {
            return 0;
        } else {
            GameEngine var3 = GameEngine.getGameEngine();
            int var4 = 0;
            class_998[] var5 = f;

            for(int var6 = 0; var6 < g; ++var6) {
                class_998 var7 = var5[var6];
                if (var7.o && var7.ar == var2) {
                    boolean var8 = var7.a(var3, false);
                    if (var8) {
                        ++var4;
                    }
                }
            }

            return var4;
        }
    }

    public void a(boolean var1) {
        if (!var1) {
            for(int var2 = 0; var2 < f.length; ++var2) {
                class_998 var3 = f[var2];
                if (var3.o) {
                    var3.o = false;
                    --this.a;
                }
            }

            if (this.a != 0) {
                GameEngine.a("EffectEngine::removeAll: effectListActiveSize == " + this.a);
            }

            g = 0;
        }
    }
}
