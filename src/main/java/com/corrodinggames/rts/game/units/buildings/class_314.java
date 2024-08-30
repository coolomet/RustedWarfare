package com.corrodinggames.rts.game.units.buildings;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.f.class_304;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.s
public strictfp class class_314 extends class_304 {
    public float a;
    public boolean b;
    public boolean c;
    PlayerData d;
    Unit e;
    float f;
    float g;
    boolean h;

    class_314(boolean var1) {
        this.b = var1;
    }

    public strictfp int excludeTeam(OrderableUnit var1) {
        return -2;
    }

    public strictfp PlayerData onlyEnemiesOfTeam(OrderableUnit var1) {
        return null;
    }

    public strictfp void a(float var1, boolean var2) {
        this.a = var1 * var1;
        this.h = var2;
        this.c = true;
    }

    public strictfp void setup(OrderableUnit var1, float var2) {
        this.e = null;
        this.f = -1.0F;
        this.g = -1.0F;
        this.d = var1.bX;
        if (!this.c) {
            throw new RuntimeException("AutoRepairCallback not ready");
        } else {
            this.c = false;
        }
    }

    public strictfp void callback(OrderableUnit var1, float var2, Unit var3) {
        if (var1 != var3) {
            if ((var3.health < var3.totalHealth || var3.cm < 1.0F) && !var3.bV && var3.cN == null && this.d.d(var3.bX) && var1.a(var3)) {
                float var4 = class_340.a(var1.xCord, var1.yCord, var3.xCord, var3.yCord);
                if (var4 < this.a) {
                    if (var3.cm < 1.0F) {
                        class_447 var5 = var1.g(var3);
                        if (var5 != null) {
                            return;
                        }
                    }

                    boolean var6 = false;
                    if (!this.h) {
                        if (this.f == -1.0F || this.f > var3.health) {
                            var6 = true;
                        }
                    } else if (this.g == -1.0F || this.g > var4) {
                        var6 = true;
                    }

                    if (var6 && var3.g() == 0.0F) {
                        this.f = var3.health;
                        this.g = var4;
                        this.e = var3;
                    }
                }
            }

        }
    }
}
