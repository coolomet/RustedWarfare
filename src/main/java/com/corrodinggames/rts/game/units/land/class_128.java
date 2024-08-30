package com.corrodinggames.rts.game.units.land;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.d.class_989;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.h
public abstract strictfp class class_128 extends class_120 {
    float l;
    public static TeamImageCache m = null;
    public static TeamImageCache[] n = new TeamImageCache[10];

    public class_128(boolean var1) {
        super(var1);
    }

    public strictfp TeamImageCache v() {
        if (this.bX.site == -1) {
            return null;
        } else {
            return this.dd() ? class_120.dO[this.bX.R()] : n[this.bX.R()];
        }
    }

    public static strictfp void K() {
        GameEngine var0 = GameEngine.getGameEngine();
        m = var0.bO.a(AssetsID$drawable.unit_icon_hover);
        n = PlayerData.a(m);
    }

    public strictfp MovementType h() {
        return MovementType.HOVER;
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.bT() && !this.bV) {
            if (this.cK()) {
                if (this.cf > 0.0F) {
                    this.l += var1;
                }

                if (this.l > 10.0F) {
                    this.l = 0.0F;
                    if (this.s_()) {
                        GameEngine var2 = GameEngine.getGameEngine();
                        float var3 = this.xCord + class_340.k(this.cg) * 4.0F;
                        float var4 = this.yCord + class_340.j(this.cg) * 4.0F;
                        class_998 var5 = var2.bR.b(var3, var4, 0.0F, class_989.CUSTOM, false, Priority.low);
                        if (var5 != null) {
                            var5.aq = 0;
                            var5.ap = 13;
                            var5.ar = 1;
                            var5.r = true;
                            var5.E = 0.8F;
                            var5.W = 80.0F;
                            var5.V = 80.0F;
                            var5.P = -class_340.k(this.cg) * 0.1F;
                            var5.Q = -class_340.j(this.cg) * 0.1F;
                            var5.Y = class_340.c(-180.0F, 180.0F);
                        }
                    }
                }
            }

        }
    }
}
