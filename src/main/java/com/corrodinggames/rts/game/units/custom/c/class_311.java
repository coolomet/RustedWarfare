package com.corrodinggames.rts.game.units.custom.c;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.f.class_304;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.c.f
public strictfp class class_311 extends class_304 {
    public class_635 a;
    public class_634 b;
    public Unit c;
    public float d;

    public strictfp void setup(OrderableUnit var1, float var2) {
    }

    public strictfp int excludeTeam(OrderableUnit var1) {
        return -3;
    }

    public strictfp PlayerData onlyEnemiesOfTeam(OrderableUnit var1) {
        return null;
    }

    public strictfp PlayerData onlyTeam(OrderableUnit var1) {
        return var1.bX;
    }

    public strictfp void callback(OrderableUnit var1, float var2, Unit var3) {
        if (var1 != var3) {
            class_588 var4 = var3.dh();
            if (var4 != null && class_585.a(this.b.a, var4)) {
                if (var1.bX != var3.bX) {
                    if (var1.bX.d(var3.bX)) {
                        if (!this.b.b) {
                            return;
                        }
                    } else {
                        if (!var1.bX.c(var3.bX)) {
                            return;
                        }

                        if (!this.b.c) {
                            return;
                        }
                    }
                }

                float var5 = class_340.a(var1.xCord, var1.yCord, var3.xCord, var3.yCord);
                if (var5 < this.d) {
                    class_630 var6 = this.a.a(this.b, false);
                    if (var6 == null || var6.a(var3) == null) {
                        this.c = var3;
                        this.d = var5;
                    }
                }
            }

        }
    }
}
