package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.f.class_304;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bj
public strictfp class class_312 extends class_304 {
    Projectile a;
    class_394 b;
    Unit c;
    Projectile d;
    Unit e;

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
    }
}
