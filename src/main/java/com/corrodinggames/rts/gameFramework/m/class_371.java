package com.corrodinggames.rts.gameFramework.m;

import android.graphics.Bitmap;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.ColoringMode;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Unit;
import com.corrodinggames.rts.gameFramework.class_338;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.m.h
public strictfp class class_371 extends TeamImageCache {
    public static Shader x;
    public static Shader y;
    public static Shader z;
    public static boolean A;
    boolean B = false;
    boolean C = false;
    private TeamImageCache H;
    private TeamImageCache I;
    int D;
    int E;
    ColoringMode F;
    public static float G;

    public static synchronized void C() {
        if (!A) {
            try {
                GameEngine.log("Loading team shaders...");
                x = new class_842("assets/shaders/pureGreenTeamColor.frag", true);
                x.a("teamColor", -1);
                x.c();
                y = new class_842("assets/shaders/hueAddTeamColor.frag", false);
                y.a("teamColorAmount", 0.15F);
                y.a("teamColor", -1);
                y.c();
                z = new class_842("assets/shaders/hueShiftTeamColor.frag", false);
                z.a("teamColor", -1);
                z.c();
            } catch (Exception var1) {
                throw new RuntimeException(var1);
            }

            A = true;
        }
    }

    public void D() {
        if (!A) {
            C();
        }

    }

    public String a() {
        return this.H == null ? "LazyColoring (error sourceBitmap==null)" : "LazyColoring(" + this.E + "):" + this.H.a();
    }

    public class_371(TeamImageCache var1, int var2, ColoringMode var3, int var4) {
        if (var1 == null) {
            throw new RuntimeException("baseImage==null");
        } else {
            this.H = var1;
            this.D = var2;
            this.F = var3;
            this.E = var4;
            this.H.a((TeamImageCache)this);
            this.k = null;
        }
    }

    public void c(boolean var1) {
        if (GameEngine.az()) {
            if (var1) {
            }

            this.D();
            if (this.F == ColoringMode.HUE_ADD) {
                this.a(y);
            } else if (this.F == ColoringMode.HUE_SHIFT) {
                this.a(z);
            } else {
                this.a(x);
            }

            this.I = this.H;
            this.C = true;
        } else if (this.H.A()) {
            GameEngine.log("Lazy loaded bitmap using errored image: " + this.H.a());
            this.I = this.H;
        } else {
            try {
                if (var1) {
                    GameEngine.log("Loading in lazy loaded bitmap:" + this.H.a() + " team:" + this.E);
                }

                long var2 = Unit.loadAllUnitsTook();
                this.H.i();
                this.I = this.H.h();
                this.I.j();
                TeamImageCache[] var4 = new TeamImageCache[]{this.I};
                int[] var5 = new int[]{this.D};
                int[] var6 = new int[]{this.E};
                long var7 = Unit.loadAllUnitsTook();
                if (this.F == ColoringMode.HUE_ADD) {
                    PlayerData.b(this.H, var4, var5);
                } else if (this.F == ColoringMode.HUE_SHIFT) {
                    PlayerData.a(this.H, var4, var5, var6);
                } else {
                    PlayerData.a(this.H, var4, var5);
                }

                double var9 = (double)Unit.a(var7);
                this.I.p();
                this.I.s();
                this.H.q();
                this.H = null;
                double var11 = (double)Unit.a(var2);
                if (var11 > 1.0) {
                    GameEngine.log((this.F == ColoringMode.PURE_GREEN ? "Standard " : "Hue ") + "Colouring took:" + Unit.a(var11) + " (" + Unit.a(var9) + ")");
                }

                G = (float)((double)G + var11);
            } catch (OutOfMemoryError var13) {
                GameEngine.log("Colouring failed with OOM");
                GameEngine.a((class_338)class_338.GAME_IMAGE_COLOR, (Throwable)var13);
                this.I = GameEngine.getGameEngine().bO.r();
            }

        }
    }

    public Bitmap b() {
        if (this.C && !GameEngine.az()) {
            GameEngine.log("Team shader coloring now disabled. Recoloring image: " + this.H.a());
            this.B = false;
            this.C = false;
            this.a((Shader)null);
        }

        if (!this.B) {
            this.c(true);
            this.B = true;
        }

        return this.I.k;
    }

    public TeamImageCache c() {
        if (this.C && !GameEngine.az()) {
            GameEngine.log("Team shader coloring now disabled. Recoloring image: " + this.H.a());
            this.B = false;
            this.C = false;
            this.a((Shader)null);
        }

        if (!this.B) {
            if (G > 60.0F) {
            }

            this.c(true);
            this.B = true;
        }

        if (this.I == null) {
            throw new RuntimeException("coloredBitmap==null");
        } else {
            return this.I;
        }
    }

    public void w() {
        if (!this.B) {
            this.c(false);
            this.B = true;
        }

    }

    public int u() {
        return !this.B & this.H != null ? this.H.u() : super.u();
    }
}
