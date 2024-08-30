package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.c.class_634;

public final strictfp class LogicBooleanGameFunctions$NumberOfConnectionsBoolean extends LogicBoolean$AbstractNumberBoolean {
    class_591 meta;
    class_634 connectionMetadata;

    public void forMeta(class_591 var1) {
        if (var1 == null) {
            throw new BooleanParseException("NumberOfConnectionsBoolean requires metadata");
        } else {
            this.meta = var1;
        }
    }

    @LogicBoolean$Parameter
    public void name(String var1) {
        this.connectionMetadata = this.meta.l(var1);
        if (this.connectionMetadata == null) {
            throw new BooleanParseException("Could not find connection type with name: " + var1);
        }
    }

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (var4 != null && var4 != LogicBooleanLoader.defaultContextReader) {
            throw new BooleanParseException("Function:" + var1 + " only supports use with 'self.'");
        } else if (this.connectionMetadata == null) {
            throw new BooleanParseException("requires connection name");
        }
    }

    public String getName() {
        return "NumberOfConnections";
    }

    public float getValue(OrderableUnit var1) {
        return (float)var1.dI.a(this.connectionMetadata);
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
