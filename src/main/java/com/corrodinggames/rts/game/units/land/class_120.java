package com.corrodinggames.rts.game.units.land;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_106;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.e.j
public abstract strictfp class class_120 extends class_106 {
    float dK;
    public static TeamImageCache dL = null;
    public static TeamImageCache dM = null;
    public static TeamImageCache[] dN = new TeamImageCache[10];
    public static TeamImageCache[] dO = new TeamImageCache[10];

    public class_120(boolean var1) {
        super(var1);
    }

    public strictfp TeamImageCache v() {
        if (this.bX.site == -1) {
            return null;
        } else {
            return this.dd() ? dO[this.bX.R()] : dN[this.bX.R()];
        }
    }

    public static strictfp void dt() {
        GameEngine var0 = GameEngine.getGameEngine();
        dL = var0.bO.a(AssetsID$drawable.unit_icon_land);
        if (dL == null) {
            throw new RuntimeException("IMAGE_ICON is null");
        } else {
            dN = PlayerData.a(dL);
            dM = var0.bO.a(AssetsID$drawable.unit_icon_land_exp);
            if (dM == null) {
                throw new RuntimeException("IMAGE_ICON_EXP is null");
            } else {
                dO = PlayerData.a(dM);
            }
        }
    }

    public strictfp void a(float var1) {
        super.a(var1);
        float var2;
        if (this.bV) {
            var2 = 0.0F;
            if (this.cK()) {
                var2 = -10.0F;
            }

            if (this.zCord > var2) {
                if (this.zCord > 0.0F && this.dK < 0.4F) {
                    this.dK = 0.4F;
                }

                this.dK += 0.002F * var1;
                this.zCord -= this.dK * var1;
                if (this.zCord <= var2) {
                    this.zCord = var2;
                }
            }
        }

        if (this.bT() && !this.bV) {
            if (!(this instanceof class_128)) {
                var2 = 0.0F;
                if (this.zCord < var2) {
                    this.zCord += 0.2F * var1;
                    if (this.zCord >= var2) {
                        this.zCord = var2;
                    }
                }

                if (this.zCord > 0.0F) {
                    this.dK += 0.03F * var1;
                    if (this.zCord < 0.0F) {
                        this.dK = class_340.b(this.dK, 0.2F);
                    }

                    this.zCord -= this.dK * var1;
                    if (this.zCord <= 0.0F) {
                        if (this.zCord < 0.0F) {
                            this.zCord = 0.0F;
                        }

                        this.dK = 0.0F;
                    }
                }
            }

        }
    }

    public strictfp MovementType h() {
        return MovementType.LAND;
    }
}
