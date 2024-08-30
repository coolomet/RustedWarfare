package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;

public final strictfp class LogicBooleanGameFunctions$ResourceCountBoolean extends LogicBoolean$AbstractNumberBoolean {
    class_591 meta;
    BuiltInResource type;

    public void forMeta(class_591 var1) {
        if (var1 == null) {
            throw new BooleanParseException("ResourceCountBoolean requires metadata");
        } else {
            this.meta = var1;
        }
    }

    @LogicBoolean$Parameter(
        positional = 0
    )
    public void type(String var1) {
        this.type = this.meta.j(var1);
        if (this.type == null) {
            throw new BooleanParseException("Could not find resource type: '" + var1 + "'");
        }
    }

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (this.type == null) {
        }

    }

    public String getName() {
        return this.type + "";
    }

    public float getValue(OrderableUnit var1) {
        return this.type == null ? 0.0F : (float)this.type.a((Unit)var1);
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }

    public LogicBooleanLoader$LogicBooleanContext createContext() {
        return new LogicBooleanGameFunctions$ResourceScope();
    }

    public LogicBoolean$ReturnType getReturnType() {
        if (this.type == null) {
            return LogicBoolean$ReturnType.voidReturn;
        } else {
            return this.greaterThan == -1.0F && this.lessThan == -1.0F && !this.full && !this.empty ? LogicBoolean$ReturnType.number : LogicBoolean$ReturnType.bool;
        }
    }

    public void throwVoidReturnError(String var1) {
        throw new RuntimeException("'" + var1 + "' requires type");
    }

    public LogicBoolean setChild(LogicBoolean var1) {
        return var1;
    }
}
