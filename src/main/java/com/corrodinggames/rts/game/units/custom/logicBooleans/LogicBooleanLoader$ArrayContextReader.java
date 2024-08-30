package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.custom.class_591;
import java.util.HashMap;
import java.util.Locale;

public final strictfp class LogicBooleanLoader$ArrayContextReader extends LogicBooleanLoader$LogicBooleanContextWithDefault {
    LogicBoolean$ReturnType arrayType;
    static HashMap arrayFunctions = new HashMap();
    static HashMap arrayFunctionsUnit;

    public LogicBooleanLoader$ArrayContextReader(LogicBoolean$ReturnType var1) {
        this.arrayType = var1;
    }

    public static void addContextFunction(HashMap var0, LogicBoolean var1, String... var2) {
        String[] var3 = var2;
        int var4 = var2.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String var6 = var3[var5];
            var6 = var6.toLowerCase(Locale.ROOT);
            if (var0.get(var6) != null) {
                throw new RuntimeException("logicBoolean: " + var6 + " already exists");
            }

            var0.put(var6, var1);
        }

    }

    public LogicBoolean parseNextElementInChain(String var1, class_591 var2, String var3, boolean var4, String var5, String var6, LogicBoolean var7) {
        LogicBoolean var8;
        if (this.arrayType == LogicBoolean$ReturnType.unitArray) {
            var8 = defaultParseNextElementInChain(this, (String)null, var2, var3, var4, var5, var6, var7, arrayFunctionsUnit);
        } else {
            var8 = defaultParseNextElementInChain(this, (String)null, var2, var3, var4, var5, var6, var7, arrayFunctions);
        }

        if (var8 == null) {
            return null;
        } else if (!(var8 instanceof LogicBooleanLoader$ArrayContextReader$ArrayFunction)) {
            throw new RuntimeException("Expected array function.");
        } else {
            LogicBooleanLoader$ArrayContextReader$ArrayFunction var9 = (LogicBooleanLoader$ArrayContextReader$ArrayFunction)var8;
            var9.setArrayTarget(var7);
            return var9;
        }
    }

    static {
        addContextFunction(arrayFunctions, new LogicBooleanLoader$ArrayContextReader$ArrayGet(), "get");
        addContextFunction(arrayFunctions, new LogicBooleanLoader$ArrayContextReader$ArraySize(), "size");
        addContextFunction(arrayFunctions, new LogicBooleanLoader$ArrayContextReader$ArraySize(), "length");
        addContextFunction(arrayFunctions, new LogicBooleanLoader$ArrayContextReader$ArrayContains(), "contains");
        arrayFunctionsUnit = new HashMap();
        addContextFunction(arrayFunctionsUnit, new LogicBooleanLoader$ArrayContextReader$ArrayGetUnit(), "get");
        addContextFunction(arrayFunctionsUnit, new LogicBooleanLoader$ArrayContextReader$ArraySize(), "size");
        addContextFunction(arrayFunctionsUnit, new LogicBooleanLoader$ArrayContextReader$ArraySize(), "length");
        addContextFunction(arrayFunctionsUnit, new LogicBooleanLoader$ArrayContextReader$ArrayContains(), "contains");
    }
}
