package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.b.class_826;
import com.corrodinggames.rts.gameFramework.utility.class_649;

public final strictfp class LogicBooleanGameFunctions$NumberOfAttachedUnitsBoolean extends LogicBoolean$AbstractNumberBoolean {
    public class_585 _withTag;
    short attachmentId = -1;
    class_591 meta;

    public void forMeta(class_591 var1) {
        if (var1 == null) {
            throw new class_649("NumberOfAttachedUnitsBoolean requires metadata");
        } else {
            this.meta = var1;
        }
    }

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (var4 != null && var4 != LogicBooleanLoader.defaultContextReader && this.attachmentId != -1) {
            throw new BooleanParseException("Function:" + var1 + " only supports use with 'self.' when using 'slot'");
        }
    }

    @LogicBoolean$Parameter
    public void withTag(String var1) {
        this._withTag = class_585.c(var1);
    }

    @LogicBoolean$Parameter
    public void slot(String var1) {
        class_826 var2 = this.meta.i(var1);
        if (var2 == null) {
            throw new class_649("No attachment slot with name: " + var1 + " found");
        } else {
            this.attachmentId = var2.a();
        }
    }

    public String getName() {
        String var1 = "";
        if (this._withTag != null) {
            var1 = var1 + "tag=" + this._withTag;
        }

        if (this.attachmentId != -1) {
            var1 = var1 + " attachmentId=" + this.attachmentId;
        }

        return "NumberOfAttachedUnits(" + var1 + ")";
    }

    public float getValue(OrderableUnit var1) {
        if (!(var1 instanceof class_113)) {
            return 0.0F;
        } else {
            class_113 var2 = (class_113)var1;
            if (var2.C == null) {
                return 0.0F;
            } else {
                int var3 = 0;
                Object[] var4 = var2.C.a();

                for(int var5 = var2.C.a - 1; var5 >= 0; --var5) {
                    OrderableUnit var6 = (OrderableUnit)var4[var5];
                    if (var6 != null && (this.attachmentId == -1 || var5 == this.attachmentId)) {
                        if (this._withTag != null) {
                            class_588 var7 = var6.de();
                            if (!class_585.a(this._withTag, var7)) {
                                continue;
                            }
                        }

                        ++var3;
                    }
                }

                return (float)var3;
            }
        }
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
