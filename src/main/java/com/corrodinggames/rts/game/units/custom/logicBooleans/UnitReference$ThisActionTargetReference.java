package com.corrodinggames.rts.game.units.custom.logicBooleans;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_113;

public strictfp class UnitReference$ThisActionTargetReference extends UnitReference {
    public Unit getSingleRaw(OrderableUnit var1) {
        Unit var2 = class_113.dN;
        if (var2 != null) {
            return var2;
        } else {
            PointF var3 = class_113.dM;
            if (var3 != null) {
                OrderableUnit var4 = PlayerData.i.t;
                var4.cg = 0.0F;
                var4.xCord = var3.x;
                var4.yCord = var3.y;
                var4.zCord = 0.0F;
                return var4;
            } else {
                return null;
            }
        }
    }

    public String getClassDebugName() {
        return "ThisActionTarget";
    }
}
