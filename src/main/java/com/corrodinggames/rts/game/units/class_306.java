package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.f.class_304;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.game.units.ah
public strictfp class class_306 extends class_304 {
    public int a;
    public float[] b = new float[31];
    public boolean[] c = new boolean[31];
    int d;
    public boolean e;
    public boolean f;

    class_306(boolean var1) {
        this.e = var1;
    }

    public strictfp int excludeTeam(OrderableUnit var1) {
        return -2;
    }

    public strictfp PlayerData onlyEnemiesOfTeam(OrderableUnit var1) {
        return var1.bX;
    }

    public strictfp void a(OrderableUnit var1) {
        float var2 = var1.b(false);
        this.d = var1.bl();

        for(int var3 = 0; var3 < this.d; ++var3) {
            float var4 = var1.z(var3);
            if (var4 > var2) {
                var4 = var2;
            }

            this.b[var3] = var4 * var4 + 1.0F;
            this.c[var3] = false;
            if (var1.v(var3) == -1 && var1.cL[var3].j == null) {
                this.c[var3] = true;
            }
        }

        this.f = true;
    }

    public strictfp void setup(OrderableUnit var1, float var2) {
        this.a = 0;
        if (!this.f) {
            throw new RuntimeException("PassiveTargetCallback not ready");
        } else {
            this.f = false;
        }
    }

    public strictfp void callback(OrderableUnit var1, float var2, Unit var3) {
        if (var1.b(var3, true)) {
            ++this.a;
            if (this.e) {
                if (!(var3 instanceof OrderableUnit)) {
                    return;
                }

                OrderableUnit var4 = (OrderableUnit)var3;
                if (!var4.l() || !var4.k(var1)) {
                    return;
                }
            }

            float var8 = class_340.a(var1.xCord, var1.yCord, var3.xCord, var3.yCord);

            for(int var5 = 0; var5 < this.d; ++var5) {
                if (this.c[var5]) {
                    boolean var6 = true;
                    boolean var7 = false;
                    if (var1.a(var5, var3, true, false) && var8 < this.b[var5] && var8 > var1.A(var5)) {
                        this.b[var5] = var8;
                        var1.cL[var5].j = var3;
                    }
                }
            }
        }

    }
}
