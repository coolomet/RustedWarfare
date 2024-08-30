package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.WaypointType;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_649;

public strictfp class LogicBooleanGameFunctions$HasActiveWaypoint extends LogicBoolean {
    WaypointType type;

    @LogicBoolean$Parameter
    public void type(String var1) {
        try {
            this.type = (WaypointType)UnitConfig.convertStringToEnumOrDefault(var1, (Enum)null, WaypointType.class);
        } catch (Exception var3) {
            throw new class_649(var3.getMessage(), var3);
        }
    }

    public boolean read(OrderableUnit var1) {
        boolean var2 = false;
        class_1042 var3 = var1.ar();
        if (var3 != null) {
            if (this.type == null) {
                var2 = true;
            } else {
                var2 = var3.d() == this.type;
            }
        }

        return var2;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "HasActiveWaypoint(type=" + this.type + ")";
    }
}
