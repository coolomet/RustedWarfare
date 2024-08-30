package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.gameFramework.utility.class_684;

public strictfp class LogicBooleanGameFunctions$TransportingCountBoolean extends LogicBoolean$AbstractNumberBoolean {
    public class_585 _withTag;
    public boolean filtered;
    @LogicBoolean$Parameter
    public int slot = -1;

    public String getName() {
        return "TransportingCount";
    }

    @LogicBoolean$Parameter
    public void withTag(String var1) {
        this._withTag = class_585.c(var1);
    }

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (this._withTag != null || this.slot != -1) {
            this.filtered = true;
        }

    }

    public float getValue(OrderableUnit var1) {
        int var2;
        if (!this.filtered) {
            var2 = var1.bB();
        } else {
            var2 = 0;
            class_684 var3 = var1.bz();
            if (var3 != null) {
                Object[] var4 = var3.a();

                for(int var5 = var3.a - 1; var5 >= 0; --var5) {
                    OrderableUnit var6 = (OrderableUnit)var4[var5];
                    if (var6 != null && (this.slot == -1 || var5 == this.slot)) {
                        if (this._withTag != null) {
                            class_588 var7 = var6.de();
                            if (!class_585.a(this._withTag, var7)) {
                                continue;
                            }
                        }

                        ++var2;
                    }
                }
            }
        }

        return (float)var2;
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
