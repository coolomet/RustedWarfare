package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import java.util.ArrayList;

public strictfp class LogicBooleanLoader$ArrayContextReader$ArrayContains extends LogicBooleanLoader$ArrayContextReader$ArrayFunction {
    public LogicBoolean value;
    LogicBoolean targetArray;
    public LogicBoolean$ReturnType elementType;

    public LogicBooleanLoader$LogicBooleanContext createContext() {
        return LogicBooleanLoader.voidNumberContextReader;
    }

    public void setArrayTarget(LogicBoolean var1) {
        this.targetArray = var1;
        LogicBoolean$ReturnType var2 = var1.getReturnType();
        this.elementType = LogicBoolean$ReturnType.getArrayBaseType(var2);
        if (this.value.getReturnType() != this.elementType) {
            throw new BooleanParseException("Expected value of type: " + this.elementType + " (got:" + this.value.getReturnType() + ")");
        }
    }

    public void setArgumentsRaw(String var1, class_591 var2, String var3) {
        if (var1 != null && !"".equals(var1)) {
            ArrayList var4 = class_675.a(var1, ",", false);
            this.validateNumberOfArguments(var4.size());
            this.value = LogicBooleanLoader.parseBooleanBlock(var2, (String)var4.get(0), false);
            if (this.value == null) {
                throw new BooleanParseException("Expected non-null argument");
            }
        } else {
            this.validateNumberOfArguments(0);
        }
    }

    public void validateNumberOfArguments(int var1) {
        if (var1 != 1) {
            throw new BooleanParseException("Expected 1 argument");
        }
    }

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (this.value == null) {
            throw new BooleanParseException("No value");
        }
    }

    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.bool;
    }

    public boolean read(OrderableUnit var1) {
        int var2 = indexOf(var1, this.targetArray, this.value);
        return var2 != -1;
    }

    public static final int indexOf(OrderableUnit var0, LogicBoolean var1, LogicBoolean var2) {
        int var3 = var1.getArraySize(var0);
        LogicBoolean$ReturnType var4 = var2.getReturnType();
        int var6;
        LogicBoolean var7;
        if (var4 == LogicBoolean$ReturnType.bool) {
            boolean var5 = var2.read(var0);

            for(var6 = 0; var6 < var3; ++var6) {
                var7 = var1.readArrayElement(var0, var6);
                if (var7.read(var0) == var5) {
                    return var6;
                }
            }
        } else if (var4 == LogicBoolean$ReturnType.number) {
            float var12 = var2.readNumber(var0);

            for(var6 = 0; var6 < var3; ++var6) {
                var7 = var1.readArrayElement(var0, var6);
                float var8 = var7.readNumber(var0);
                if (class_340.j(var12, var8)) {
                    return var6;
                }
            }
        } else if (var4 == LogicBoolean$ReturnType.unit) {
            Unit var13 = var2.readUnit(var0);
            if (VariableScope.isMarker(var13)) {
                if (var13 == null) {
                    return -1;
                }

                float var14 = var13.xCord;
                float var15 = var13.yCord;
                int var16 = var13.bX.site;
                var13 = null;

                for(int var9 = 0; var9 < var3; ++var9) {
                    LogicBoolean var10 = var1.readArrayElement(var0, var9);
                    Unit var11 = var10.readUnit(var0);
                    if (var11 != null && class_340.j(var14, var11.xCord) && class_340.j(var15, var11.yCord) && var16 == var11.bX.site) {
                        return var9;
                    }
                }
            } else {
                for(var6 = 0; var6 < var3; ++var6) {
                    var7 = var1.readArrayElement(var0, var6);
                    Unit var17 = var7.readUnit(var0);
                    if (var13 == var17) {
                        return var6;
                    }
                }
            }
        }

        return -1;
    }

    public String getName() {
        return "contains";
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        String var2 = "";
        if (this.targetArray != null) {
            var2 = var2 + this.targetArray.getMatchFailReasonForPlayer(var1);
        }

        String var3 = null;
        if (var3 != null) {
            var3 = this.value.getMatchFailReasonForPlayer(var1);
        }

        var2 = var2 + "." + this.getName() + "(" + var3 + ")";
        var2 = var2 + "=" + this.valueToStringDebug(var1);
        return var2;
    }
}
