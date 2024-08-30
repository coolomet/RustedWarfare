package com.corrodinggames.rts.game.units.custom.logicBooleans;

public enum LogicBoolean$ReturnType {
    undefined("undefined", 0),
    voidReturn("voidReturn", 1),
    bool("bool", 2),
    number("number", 3),
    unit("unit", 4),
    string("string", 5),
    point("point", 6),
    boolArray("boolArray", 7),
    numberArray("numberArray", 8),
    unitArray("unitArray", 9);
    // $FF: synthetic field
    private static final LogicBoolean$ReturnType[] $VALUES = new LogicBoolean$ReturnType[]{undefined, voidReturn, bool, number, unit, string, point, boolArray, numberArray, unitArray};
    LogicBoolean$ReturnType(String var1, int var2) {
    }

    public static boolean canBeNull(LogicBoolean$ReturnType var0) {
        boolean var1 = false;
        if (var0 == string) {
            var1 = true;
        }

        if (var0 == point) {
            var1 = true;
        }

        if (var0 == unit) {
            var1 = true;
        }

        if (var0 == numberArray) {
            var1 = true;
        }

        if (var0 == boolArray) {
            var1 = true;
        }

        if (var0 == unitArray) {
            var1 = true;
        }

        return var1;
    }

    public static boolean isArrayType(LogicBoolean$ReturnType var0) {
        if (var0 == numberArray) {
            return true;
        } else if (var0 == boolArray) {
            return true;
        } else {
            return var0 == unitArray;
        }
    }

    public static LogicBoolean$ReturnType getArrayBaseType(LogicBoolean$ReturnType var0) {
        if (var0 == boolArray) {
            return bool;
        } else if (var0 == numberArray) {
            return number;
        } else {
            return var0 == unitArray ? unit : null;
        }
    }

    public static LogicBoolean$ReturnType getArrayTypeFromBase(LogicBoolean$ReturnType var0) {
        if (var0 == bool) {
            return boolArray;
        } else if (var0 == number) {
            return numberArray;
        } else {
            return var0 == unit ? unitArray : null;
        }
    }

    public static String toUserString(LogicBoolean$ReturnType var0) {
        if (var0 == null) {
            return "<NULL TYPE>";
        } else if (var0 == numberArray) {
            return "number[]";
        } else if (var0 == boolArray) {
            return "bool[]";
        } else {
            return var0 == unitArray ? "unit[]" : var0.name();
        }
    }
}
