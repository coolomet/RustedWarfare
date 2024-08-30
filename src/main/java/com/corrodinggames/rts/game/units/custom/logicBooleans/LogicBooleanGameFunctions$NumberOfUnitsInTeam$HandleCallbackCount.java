package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.f.class_304;
import com.corrodinggames.rts.gameFramework.class_340;

public strictfp class LogicBooleanGameFunctions$NumberOfUnitsInTeam$HandleCallbackCount extends class_304 {
    public class_585 tag;
    public int count;
    public float withinRangeSq;
    public boolean incompleteBuildings;
    public PlayerData targetTeam;

    public void setup(OrderableUnit var1, float var2) {
    }

    public int excludeTeam(OrderableUnit var1) {
        return -1;
    }

    public PlayerData onlyEnemiesOfTeam(OrderableUnit var1) {
        return null;
    }

    public PlayerData onlyTeam(OrderableUnit var1) {
        return this.targetTeam;
    }

    public void callback(OrderableUnit var1, float var2, Unit var3) {
        class_588 var4 = var3.de();
        if (this.tag == null || var4 != null && class_585.a(this.tag, var4)) {
            float var5 = class_340.a(var1.xCord, var1.yCord, var3.xCord, var3.yCord);
            if (var5 < this.withinRangeSq) {
                if (var3.cm < 1.0F && !this.incompleteBuildings) {
                    return;
                }

                ++this.count;
            }
        }

    }
}
