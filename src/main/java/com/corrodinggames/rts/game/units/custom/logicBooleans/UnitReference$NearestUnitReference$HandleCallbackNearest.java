package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Side;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.f.class_304;
import com.corrodinggames.rts.gameFramework.class_340;

public strictfp class UnitReference$NearestUnitReference$HandleCallbackNearest extends class_304 {
    public class_585 tag;
    public class_585 withoutTag;
    public float withinRangeSq;
    public boolean incompleteBuildings;
    public Side relation;
    public Unit nearest;

    public UnitReference$NearestUnitReference$HandleCallbackNearest() {
        this.relation = Side.ANY;
    }

    public void setup(OrderableUnit var1, float var2) {
    }

    public int excludeTeam(OrderableUnit var1) {
        return -3;
    }

    public PlayerData onlyEnemiesOfTeam(OrderableUnit var1) {
        return null;
    }

    public PlayerData onlyTeam(OrderableUnit var1) {
        return null;
    }

    public void callback(OrderableUnit var1, float var2, Unit var3) {
        if (this.relation == Side.ANY || var1.bX.a(this.relation, var3.bX)) {
            if (var1 != var3) {
                class_588 var4 = var3.de();
                if (this.tag == null || var4 != null && class_585.a(this.tag, var4)) {
                    float var5 = class_340.a(var1.xCord, var1.yCord, var3.xCord, var3.yCord);
                    if (var5 < this.withinRangeSq) {
                        if (var3.cm < 1.0F && !this.incompleteBuildings) {
                            return;
                        }

                        if (this.withoutTag != null && var4 != null && class_585.a(this.withoutTag, var4)) {
                            return;
                        }

                        this.withinRangeSq = var5;
                        this.nearest = var3;
                    }
                }

            }
        }
    }
}
