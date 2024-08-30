package com.corrodinggames.rts.game.units.sea;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_106;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.f
public abstract strictfp class class_114 extends class_106 {
    float m;
    float n;
    boolean o = false;
    public static TeamImageCache p = null;
    public static TeamImageCache[] q = new TeamImageCache[10];

    public class_114(boolean var1) {
        super(var1);
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.n);
        var1.writeBoolean(this.o);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.n = var1.readFloat();
        this.o = var1.readBoolean();
        super.a(var1);
    }

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : q[this.bX.R()];
    }

    public static strictfp void M() {
        GameEngine var0 = GameEngine.getGameEngine();
        p = var0.bO.a(AssetsID$drawable.unit_icon_water);
        q = PlayerData.a(p);
    }

    public strictfp MovementType h() {
        return MovementType.WATER;
    }

    public strictfp boolean cv() {
        return true;
    }

    public strictfp boolean K() {
        return true;
    }

    public strictfp void s(float var1) {
        float var2 = 0.0F;
        if (this.zCord != var2) {
            this.zCord = class_340.a(this.zCord, var2, 0.2F * var1);
        }

    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.bV) {
            if (this.zCord > -10.0F) {
                this.n += 0.002F * var1;
                this.zCord -= this.n * var1;
            } else {
                this.zCord = -10.0F;
                if (!this.o) {
                    this.o = true;
                }
            }

        } else if (this.bT() && !this.bV) {
            this.s(var1);
            if (this.K()) {
                if (this.cf != 0.0F) {
                    this.m += var1;
                }

                if (this.m > 10.0F) {
                    this.m = 0.0F;
                    if (this.s_()) {
                        GameEngine var2 = GameEngine.getGameEngine();
                        float var3 = this.cg + 180.0F;
                        if (this.cf < 0.0F) {
                            var3 += 180.0F;
                        }

                        float var4 = this.cj - 6.0F;
                        if (var4 < 4.0F) {
                            var4 = 4.0F;
                        }

                        float var5 = this.xCord + class_340.k(var3) * var4;
                        float var6 = this.yCord + class_340.j(var3) * var4;
                        var2.bR.b(var5, var6, 0.0F, var3);
                    }
                }
            }

        }
    }
}
