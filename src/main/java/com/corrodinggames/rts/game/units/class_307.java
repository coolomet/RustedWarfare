package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.f.class_304;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.game.units.ae
public strictfp class class_307 extends class_304 {
    public int a;
    public float b;
    public boolean c;
    public boolean d;

    class_307(boolean var1) {
        this.c = var1;
    }

    public strictfp int excludeTeam(OrderableUnit var1) {
        return -2;
    }

    public strictfp PlayerData onlyEnemiesOfTeam(OrderableUnit var1) {
        return var1.bX;
    }

    public strictfp void a(float var1) {
        this.b = var1 * var1 + 1.0F;
        this.d = true;
    }

    public strictfp void setup(OrderableUnit var1, float var2) {
        this.a = 0;
        if (!this.d) {
            throw new RuntimeException("PassiveTargetCallback not ready");
        } else {
            this.d = false;
        }
    }

    public strictfp void callback(OrderableUnit var1, float var2, Unit var3) {
        if (var1.b(var3, true)) {
            ++this.a;
            if (this.c) {
                if (!(var3 instanceof OrderableUnit)) {
                    return;
                }

                OrderableUnit var4 = (OrderableUnit)var3;
                if (!var4.l() || !var4.k(var1)) {
                    return;
                }
            }

            float var5 = class_340.a(var1.xCord, var1.yCord, var3.xCord, var3.yCord);
            if (var5 < this.b) {
                this.b = var5;
                var1.R = var3;
            }
        }

    }
}
