package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.Side;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_649;

public strictfp class UnitReference$NearestUnitReference extends UnitReference {
    public float withinRange = 500.0F;
    public float withinRangeSq;
    public class_585 _withTag;
    public class_585 _withoutTag;
    public Side relation;
    @LogicBoolean$Parameter
    public boolean incompleteBuildings;
    public static final UnitReference$NearestUnitReference$HandleCallbackNearest handleCallbackNearest = new UnitReference$NearestUnitReference$HandleCallbackNearest();

    public UnitReference$NearestUnitReference() {
        this.withinRangeSq = this.withinRange * this.withinRange;
        this.relation = Side.ANY;
    }

    public String getClassDebugName() {
        return "NearestUnit";
    }

    @LogicBoolean$Parameter
    public void withinRange(float var1) {
        if (var1 > 1500.0F) {
            throw new class_649("NearestUnit distance cannot be over 1500 is: " + var1);
        } else {
            this.withinRange = var1;
            this.withinRangeSq = var1 * var1;
        }
    }

    @LogicBoolean$Parameter
    public void withTag(String var1) {
        this._withTag = class_585.c(var1);
    }

    @LogicBoolean$Parameter
    public void withoutTag(String var1) {
        this._withoutTag = class_585.c(var1);
    }

    @LogicBoolean$Parameter
    public void relation(String var1) {
        try {
            this.relation = (Side)UnitConfig.convertStringToEnumOrDefault(var1, Side.ANY, Side.class);
        } catch (Exception var3) {
            throw new class_649(var3.getMessage(), var3);
        }
    }

    public Unit getSingleRaw(OrderableUnit var1) {
        handleCallbackNearest.nearest = null;
        handleCallbackNearest.withinRangeSq = this.withinRangeSq;
        handleCallbackNearest.tag = this._withTag;
        handleCallbackNearest.withoutTag = this._withoutTag;
        handleCallbackNearest.incompleteBuildings = this.incompleteBuildings;
        handleCallbackNearest.relation = this.relation;
        GameEngine var2 = GameEngine.getGameEngine();
        var2.cc.a(var1.xCord, var1.yCord, this.withinRange, var1, 0.0F, handleCallbackNearest);
        return handleCallbackNearest.nearest;
    }
}
