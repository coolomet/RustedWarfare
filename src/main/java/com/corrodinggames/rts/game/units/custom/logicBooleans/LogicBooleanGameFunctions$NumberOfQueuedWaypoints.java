package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.WaypointType;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_649;

public strictfp class LogicBooleanGameFunctions$NumberOfQueuedWaypoints extends LogicBoolean$AbstractNumberBoolean {
    WaypointType type;

    @LogicBoolean$Parameter
    public void type(String var1) {
        try {
            this.type = (WaypointType)UnitConfig.convertStringToEnumOrDefault(var1, (Enum)null, WaypointType.class);
        } catch (Exception var3) {
            throw new class_649(var3.getMessage(), var3);
        }
    }

    public String getName() {
        return "NumberOfQueuedWaypoints";
    }

    public float getValue(OrderableUnit var1) {
        if (this.type == null) {
            return (float)var1.av();
        } else {
            int var2 = 0;
            int var3 = var1.av();

            for(int var4 = 0; var4 < var3; ++var4) {
                class_1042 var5 = var1.k(var4);
                if (var5 != null) {
                    boolean var6 = var5.d() == this.type;
                    if (var6) {
                        ++var2;
                    }
                }
            }

            return (float)var2;
        }
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
