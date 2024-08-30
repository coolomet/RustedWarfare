package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import java.util.ArrayList;

class LogicString$StringCast extends LogicString {
    LogicBoolean child;
    LogicBoolean$ReturnType sourceType;

    public void setArgumentsRaw(String var1, class_591 var2, String var3) {
        if (var1 != null && !"".equals(var1)) {
            ArrayList var4 = class_675.a(var1, ",", false);
            this.validateNumberOfArguments(var4.size());
            this.child = LogicBooleanLoader.parseBooleanBlock(var2, (String)var4.get(0), false);
            if (this.child == null) {
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

    public LogicString$StringCast() {
    }

    public static LogicBoolean createStringCast(LogicBoolean var0) {
        LogicString$StringCast var1 = new LogicString$StringCast();
        var1.child = var0;
        return var1.validateAndOptimize("cast", "", "", (LogicBooleanLoader$LogicBooleanContext)null, false);
    }

    public LogicBoolean validateAndOptimize(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        this.sourceType = this.child.getReturnType();
        if (this.child instanceof LogicString$StaticString) {
            return this.child;
        } else if (this.child instanceof LogicBoolean$StaticBoolean) {
            return new LogicString$StaticString(this.readString((OrderableUnit)null));
        } else {
            return (LogicBoolean)(this.child instanceof LogicBoolean$StaticValueBoolean ? new LogicString$StaticString(this.readString((OrderableUnit)null)) : super.validateAndOptimize(var1, var2, var3, var4, var5));
        }
    }

    public String readString(OrderableUnit var1) {
        return castToString(this.sourceType, this.child, var1);
    }

    public static String castToString(LogicBoolean$ReturnType var0, LogicBoolean var1, OrderableUnit var2) {
        if (var0 == LogicBoolean$ReturnType.number) {
            float var5 = var1.readNumber(var2);
            return class_340.a(var5, 2);
        } else if (var0 == LogicBoolean$ReturnType.unit) {
            return Unit.A(var1.readUnit(var2));
        } else {
            String var4;
            if (var0 == LogicBoolean$ReturnType.string) {
                var4 = var1.readString(var2);
                return var4;
            } else if (var0 == LogicBoolean$ReturnType.numberArray) {
                var4 = arrayToString(var2, var1);
                return var4;
            } else if (var0 == LogicBoolean$ReturnType.boolArray) {
                var4 = arrayToString(var2, var1);
                return var4;
            } else {
                boolean var3 = var1.read(var2);
                return var3 ? "true" : "false";
            }
        }
    }
}
