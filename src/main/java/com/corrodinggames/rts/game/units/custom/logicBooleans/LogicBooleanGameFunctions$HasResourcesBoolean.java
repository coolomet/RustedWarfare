package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.d.class_447;

public final strictfp class LogicBooleanGameFunctions$HasResourcesBoolean extends LogicBoolean {
    class_447 requiredResources;
    class_591 meta;

    public void forMeta(class_591 var1) {
        if (var1 == null) {
            throw new BooleanParseException("HasResourcesBoolean requires metadata");
        } else {
            this.meta = var1;
        }
    }

    public void setArgumentsRaw(String var1, class_591 var2, String var3) {
        try {
            this.requiredResources = class_447.b(this.meta, var1);
        } catch (Exception var5) {
            throw new BooleanParseException(var5.getMessage(), var5);
        }
    }

    public boolean read(OrderableUnit var1) {
        boolean var2 = false;
        if (this.requiredResources.b((Unit)var1)) {
            var2 = true;
        }

        return var2;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "HasResources(" + this.requiredResources.a(false, true, 8, true) + ")";
    }
}
