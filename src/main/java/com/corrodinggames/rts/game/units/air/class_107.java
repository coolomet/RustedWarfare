package com.corrodinggames.rts.game.units.air;

import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.ExplodeType;
import com.corrodinggames.rts.game.units.class_106;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.b.b
public abstract strictfp class class_107 extends class_106 {
    float h;
    boolean i = false;
    float j;
    Boolean k;
    Boolean l;
    public static TeamImageCache m = null;
    public static TeamImageCache[] n = new TeamImageCache[10];

    public class_107(boolean var1) {
        super(var1);
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.h);
        var1.writeBoolean(this.i);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.h = var1.readFloat();
        this.i = var1.readBoolean();
        super.a(var1);
    }

    public strictfp TeamImageCache v() {
        return this.bX.site == -1 ? null : n[this.bX.R()];
    }

    public static strictfp void K() {
        GameEngine var0 = GameEngine.getGameEngine();
        m = var0.bO.a(AssetsID$drawable.unit_icon_air);
        n = PlayerData.a(m);
    }

    public strictfp MovementType h() {
        return MovementType.AIR;
    }

    public strictfp void a(float var1) {
        super.a(var1);
        if (this.bV) {
            if (this.zCord > 0.0F) {
                this.h += 0.06F * var1;
                this.zCord -= this.h * var1;
            } else {
                if (this.k == null) {
                    this.k = this.cK();
                }

                if (this.l == null) {
                    this.l = this.cJ();
                }

                if (!this.i) {
                    this.i = true;
                    if (this.k) {
                        this.a((ExplodeType) ExplodeType.verysmall);
                        if (this.l) {
                            GameEngine.getGameEngine().bR.a(this.xCord, this.yCord, 0.0F, 0, 0.0F, 0.0F, this.cg);
                        }
                    } else {
                        this.a((ExplodeType) ExplodeType.small);
                    }

                    this.h = 0.0F;
                } else if (this.k) {
                    if (this.zCord > -10.0F) {
                        this.h += 8.0E-4F * var1;
                        this.zCord -= this.h * var1;
                        if (this.l) {
                            this.j += var1;
                            if (this.j > 30.0F) {
                                this.j = 0.0F;
                                if (this.s_()) {
                                    GameEngine var2 = GameEngine.getGameEngine();
                                    class_998 var3 = var2.bR.b(this.xCord, this.yCord, this.zCord, this.cg);
                                    if (var3 != null) {
                                        var3.P = 0.0F;
                                        var3.Q = -0.1F;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.zCord = 0.0F;
                }
            }

        }
    }

    public strictfp boolean e() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.zCord > -1.0F) {
            for(int var2 = 0; var2 < 3; ++var2) {
                var1.bR.e(this.xCord, this.yCord, this.zCord);
            }
        }

        return super.e();
    }
}
