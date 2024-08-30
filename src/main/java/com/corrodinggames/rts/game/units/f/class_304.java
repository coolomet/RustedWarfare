package com.corrodinggames.rts.game.units.f;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;

// $FF: renamed from: com.corrodinggames.rts.game.units.f.i
public abstract strictfp class class_304 extends class_302 {
    public abstract int excludeTeam(OrderableUnit var1);

    public abstract PlayerData onlyEnemiesOfTeam(OrderableUnit var1);

    public PlayerData onlyTeam(OrderableUnit var1) {
        return null;
    }

    public void setup(OrderableUnit var1, float var2) {
    }

    public Unit getResult() {
        return null;
    }
}
