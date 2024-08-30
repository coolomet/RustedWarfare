package com.corrodinggames.rts.gameFramework.a;

import android.content.Context;
import com.corrodinggames.rts.AssetsID$raw;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_338;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.a.e
// SoundManager?
public strictfp class class_648 {
    ArrayList a = new ArrayList();
    public boolean b;
    public static class_349 c = new class_351();
    public static class_355 d;
    public static class_355 e;
    public static class_355 f;
    public static class_355 g;
    public static class_355 h;
    public static class_355 i;
    public static class_355 j;
    public static class_355 k;
    public static class_355 l;
    public static class_355 m;
    public static class_355 n;
    public static class_355 o;
    public static class_355 p;
    public static class_355 q;
    public static class_355 r;
    public static class_355 s;
    public static class_355 t;
    public static class_355 u;
    public static class_355 v;
    public static class_355 w;
    public static class_355 x;
    public static class_355 y;
    public static class_355 z;
    public static class_355 A;
    public static class_355 B;
    public static class_355 C;
    public static class_355 D;
    public static class_355 E;
    public static class_355 F;

    public boolean a(class_355 var1, float var2) {
        if (this.a.contains(var1)) {
            return false;
        } else {
            this.a.add(var1);
            return true;
        }
    }

    public boolean a() {
        GameEngine var1 = GameEngine.getGameEngine();
        return this.a(var1.settingsEngine.masterVolume * var1.settingsEngine.gameVolume);
    }

    public boolean a(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (var1 < 0.01F) {
            return false;
        } else {
            return this.b ? false : var2.settingsEngine.enableSounds;
        }
    }

    public static void b() {
    }

    public void a(Context var1) {
        c.a(var1);
        e = c.a(AssetsID$raw.attack);
        e.d = 0.2F;
        d = c.a(AssetsID$raw.attack2);
        f = c.a(AssetsID$raw.move);
        g = c.a(AssetsID$raw.click);
        h = c.a(AssetsID$raw.click_add);
        i = c.a(AssetsID$raw.click_remove);
        j = c.a(AssetsID$raw.warning);
        k = c.a(AssetsID$raw.message);
        m = c.a(AssetsID$raw.missile_fire);
        n = c.a(AssetsID$raw.missile_hit);
        o = c.a(AssetsID$raw.unit_explode);
        p = c.a(AssetsID$raw.buiding_explode);
        q = c.a(AssetsID$raw.tank_firing);
        r = c.a(AssetsID$raw.cannon_firing);
        s = c.a(AssetsID$raw.gun_fire);
        x = c.a(AssetsID$raw.lighting_burst);
        y = c.a(AssetsID$raw.plasma_fire);
        z = c.a(AssetsID$raw.plasma_fire2);
        t = c.a(AssetsID$raw.firing3);
        u = c.a(AssetsID$raw.firing4);
        v = c.a(AssetsID$raw.large_gun_fire1);
        w = c.a(AssetsID$raw.large_gun_fire2);
        A = c.a(AssetsID$raw.bug_die);
        B = c.a(AssetsID$raw.bug_attack);
        l = c.a(AssetsID$raw.interface_error);
        C = c.a(AssetsID$raw.nuke_explode);
        D = c.a(AssetsID$raw.nuke_launch);
        E = c.a(AssetsID$raw.laser_deflect);
        F = c.a(AssetsID$raw.laser_deflect2);
        c.a();
    }

    public class_355 a(String var1) {
        class_355 var2 = (class_355)c.h.get(var1);
        if (var2 == null) {
            throw new RuntimeException("Could not find sound:" + var1);
        } else {
            return var2;
        }
    }

    public void b(class_355 var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        var2 *= var3.settingsEngine.masterVolume * var3.settingsEngine.interfaceVolume;
        var2 *= var1.d;
        if (this.a(var2)) {
            if (!((double)var2 < 0.01)) {
                if (this.a(var1, var2)) {
                    if (var3.aq) {
                        var2 /= 20.0F;
                    }

                    var1.a(var2, var2, 1, 0, 1.0F);
                }
            }
        }
    }

    public void c(class_355 var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        var2 *= var3.settingsEngine.masterVolume * var3.settingsEngine.gameVolume;
        var2 *= var1.d;
        if (this.a(var2)) {
            if (var3.aq) {
                var2 /= 20.0F;
            }

            if (this.a(var1, var2)) {
                var1.a(var2, var2, 1, 0, 1.0F);
            }
        }
    }

    public void a(class_355 var1, float var2, float var3, float var4) {
        this.a(var1, var2, 1.0F, var3, var4);
    }

    public void a(class_355 var1, float var2, float var3, float var4, float var5) {
        if (this.a()) {
            GameEngine var6 = GameEngine.getGameEngine();
            if (var6.aq) {
                var2 /= 20.0F;
            }

            if (var6.replayEngine.j() && (double)var6.bt > 1.5) {
                var2 /= var6.bt;
            }

            int var7 = (int)(var6.cw + var6.cI);
            int var8 = (int)(var6.cx + var6.cJ);
            float var9 = class_340.a((float)var7, (float)var8, var4, var5);
            float var10 = var6.cI * 1.72F;
            if ((double)var6.cX < 0.5) {
                var2 *= 4.0F;
                var2 *= var6.cX * var6.cX;
            }

            if (!(var2 <= 1.0F) || var1.f || !(var9 > var10 * var10)) {
                float var11 = (float)Math.sqrt((double)var9);
                float var12 = 1.0F;
                if (var11 > var6.cI) {
                    var12 = 1.0F - (var11 - var6.cI) / var6.cI;
                }

                float var13 = var12 * var2;
                if (!((double)var13 <= 0.05) || var1.f) {
                    if (var13 > 1.0F) {
                        var13 = 1.0F;
                    }

                    var13 *= var6.settingsEngine.masterVolume * var6.settingsEngine.gameVolume;
                    var13 *= var1.d;
                    if (this.a(var1, var13)) {
                        var1.a(var13, var13, 1, 0, var3);
                    }
                }
            }
        }
    }

    public class_355 a(String var1, AssetInputStream var2, boolean var3) {
        try {
            return c.a(var1, var2, var3);
        } catch (OutOfMemoryError var5) {
            GameEngine.a((class_338)class_338.GAME_SOUND, (Throwable)var5);
            return class_350.b();
        }
    }

    public class_355 b(String var1) {
        return class_350.a(var1);
    }

    public void b(float var1) {
        this.a.clear();
    }
}
