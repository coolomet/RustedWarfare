package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.f.class_304;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.game.units.ac
public strictfp class class_308 extends class_304 {
    public float a;
    public float b;
    public class_588 c;
    public float d;
    public Unit e;
    public boolean f;
    public boolean g = false;

    public strictfp void setup(OrderableUnit var1, float var2) {
    }

    public strictfp int excludeTeam(OrderableUnit var1) {
        return -2;
    }

    public strictfp PlayerData onlyEnemiesOfTeam(OrderableUnit var1) {
        return null;
    }

    public strictfp PlayerData onlyTeam(OrderableUnit var1) {
        return null;
    }

    public strictfp void callback(OrderableUnit var1, float var2, Unit var3) {
        if (!this.f || !(var3.g() <= 0.0F)) {
            float var4 = class_340.a(this.a, this.b, var3.xCord, var3.yCord);
            if (var4 < this.d) {
                if (var3.cm < 1.0F && !this.g) {
                    return;
                }

                if (this.c != null && !class_585.a(this.c, var3.de())) {
                    return;
                }

                if (this.f && !var1.g(var3, true)) {
                    return;
                }

                if (var3.cN != null) {
                    return;
                }

                this.e = var3;
                this.d = var4;
            }

        }
    }
}
