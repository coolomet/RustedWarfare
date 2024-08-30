package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.f.class_304;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bf
public strictfp class class_313 extends class_304 {
    public float a;
    public float b;
    public class_391 c;
    public int d;

    public void setup(OrderableUnit var1, float var2) {
    }

    public int excludeTeam(OrderableUnit var1) {
        return -2;
    }

    public PlayerData onlyEnemiesOfTeam(OrderableUnit var1) {
        return null;
    }

    public PlayerData onlyTeam(OrderableUnit var1) {
        return null;
    }

    public void callback(OrderableUnit var1, float var2, Unit var3) {
        if (var1 != var3) {
            class_588 var4 = var3.de();
            class_588 var5 = this.c.c;
            if (var5 == null || var4 != null && class_585.a(var5, var4)) {
                float var6 = class_340.a(this.a, this.b, var3.xCord, var3.yCord);
                if (var6 < this.c.f) {
                    if (var3.cm < 1.0F && this.c.i) {
                        return;
                    }

                    if (this.c.j && !var3.bI()) {
                        return;
                    }

                    if (this.c.d != null && !var1.bX.a(this.c.d, var3.bX)) {
                        return;
                    }

                    ++this.d;
                }
            }

        }
    }
}
