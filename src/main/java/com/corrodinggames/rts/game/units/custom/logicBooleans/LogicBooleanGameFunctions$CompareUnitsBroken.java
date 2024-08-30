package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;

public strictfp class LogicBooleanGameFunctions$CompareUnitsBroken extends LogicBoolean {
    class_591 meta;
    UnitReference sameUnitAs;

    public void forMeta(class_591 var1) {
        if (var1 == null) {
            throw new BooleanParseException("SameUnitAs requires metadata");
        } else {
            this.meta = var1;
        }
    }

    @LogicBoolean$Parameter
    public void sameUnitAs(String var1) {
        try {
            this.sameUnitAs = UnitReference.parseUnitReference(this.meta, var1, "", "", (UnitReference)null, false);
        } catch (Exception var3) {
            throw new BooleanParseException(var3.getMessage(), var3);
        }
    }

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (this.sameUnitAs == null) {
            LogicBooleanLoader$ParameterMapping var6 = this.getParameters();
            throw new BooleanParseException("Missing required parameters (Possible parameters:" + var6.allParametersString + ")");
        }
    }

    public boolean read(OrderableUnit var1) {
        boolean var2 = true;
        return var2;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "SameUnitAs";
    }
}
