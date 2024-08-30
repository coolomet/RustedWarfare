package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import java.util.Locale;

public strictfp class LogicString$LowerString extends LogicString {
    @LogicBoolean$Parameter(
        required = true,
        positional = 0
    )
    public LogicBoolean text;

    public LogicBoolean validateAndOptimize(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        if (this.text == null) {
            throw new BooleanParseException("Expected argument text");
        } else if (this.text.getReturnType() != LogicBoolean$ReturnType.string) {
            throw new BooleanParseException("Expected string argument");
        } else {
            return super.validateAndOptimize(var1, var2, var3, var4, var5);
        }
    }

    public String readString(OrderableUnit var1) {
        String var2 = this.text.readString(var1);
        var2 = var2.toLowerCase(Locale.ROOT);
        return var2;
    }
}
