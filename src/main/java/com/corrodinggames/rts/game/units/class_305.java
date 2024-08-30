package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.f.class_304;

// $FF: renamed from: com.corrodinggames.rts.game.units.aj
public strictfp class class_305 extends class_304 {
    float a;
    float b;
    public SpreadingFire c;

    class_305() {
    }

    public int excludeTeam(OrderableUnit var1) {
        return -2;
    }

    public PlayerData onlyEnemiesOfTeam(OrderableUnit var1) {
        return null;
    }

    public void setup(OrderableUnit var1, float var2) {
        this.c = null;
    }

    public void a(float var1, float var2) {
        this.a = var1;
        this.b = var2;
    }

    public void callback(OrderableUnit var1, float var2, Unit var3) {
        if (var3 instanceof SpreadingFire && !var3.bV && var3.c(this.a, this.b, 0.0F)) {
            this.c = (SpreadingFire)var3;
        }

    }
}
