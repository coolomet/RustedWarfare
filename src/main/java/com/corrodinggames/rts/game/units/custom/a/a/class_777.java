package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$MemoryNames;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$MemoryWriter;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableData;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableDataArray;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableDefinition;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$VariableName;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import lombok.SneakyThrows;

import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.h
public strictfp class class_777 extends class_776 {
    VariableScope$CachedWriter a;
    boolean b;
    LogicBoolean c;
    LogicBoolean d;
    VariableScope$MemoryNames e;

    @SneakyThrows
    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        boolean var7 = var1.getValueAsBoolean(var2, var3 + "swapCustomTarget1And2", false);
        LogicBoolean var8 = var1.b(var0, var2, var3 + "setCustomTarget1", (LogicBoolean)null);
        LogicBoolean var9 = var1.b(var0, var2, var3 + "setCustomTarget2", (LogicBoolean)null);
        VariableScope$MemoryWriter var10 = null;
        String var11 = var1.getValueAsStaticString(var2, var3 + "setUnitMemory", (String)null);
        if (var11 != null) {
            var10 = VariableScope.createMemoryWriter(var11, var0, var2, var3 + "setUnitMemory");
        }

        String var12 = var1.getValueAsStaticString(var2, var3 + "shrinkArrays", (String)null);
        VariableScope$MemoryNames var13 = null;
        if (var12 != null) {
            var13 = VariableScope.createMemoryNameList(var12, var0, (LogicBoolean$ReturnType)null, var2, var3 + "shrinkArrays");
            Iterator var14 = var13.names.iterator();

            while(var14.hasNext()) {
                VariableScope$VariableName var15 = (VariableScope$VariableName)var14.next();
                VariableScope$VariableDefinition var16 = var0.r.get(var15);
                if (var16 == null) {
                    throw new CustomException("Failed to find defined memory: " + var15, var2, var3 + "shrinkArrays");
                }

                if (!LogicBoolean$ReturnType.isArrayType(var16.type)) {
                    throw new CustomException("Memory: " + var15 + " is type: " + var16.type + " expected an array type", var2, var3 + "shrinkArrays");
                }

                if (var16.type != LogicBoolean$ReturnType.numberArray && var16.type != LogicBoolean$ReturnType.unitArray) {
                    throw new CustomException("Memory: " + var15 + " is type: " + var16.type + " only number and unit arrays are supported by shrinkArrays", var2, var3 + "shrinkArrays");
                }
            }
        }

        if (var7 || var8 != null || var9 != null || var10 != null || var13 != null) {
            class_777 var17 = new class_777();
            var17.a = var10;
            var17.b = var7;
            var17.c = var8;
            var17.d = var9;
            var17.e = var13;
            var4.ac.add(var17);
        }

    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        if (this.a != null) {
            this.a.writeToUnit(var1);
        }

        Unit var6;
        if (this.b) {
            var6 = var1.bu;
            var1.bu = var1.bv;
            var1.bv = var6;
        }

        if (this.c != null) {
            var6 = this.c.readUnit(var1);
            var6 = VariableScope.getSafeUnitReferenceForStorage(var6);
            var1.bu = var6;
        }

        if (this.d != null) {
            var6 = this.d.readUnit(var1);
            var6 = VariableScope.getSafeUnitReferenceForStorage(var6);
            var1.bv = var6;
        }

        if (this.e != null) {
            a(var1, this.e);
        }

        return true;
    }

    public static void a(class_113 var0, VariableScope$MemoryNames var1) {
        if (var0.bw != null) {
            Iterator var2 = var1.names.iterator();

            while(var2.hasNext()) {
                VariableScope$VariableName var3 = (VariableScope$VariableName)var2.next();
                VariableScope$VariableData var4 = var0.bw.getDataObjectRaw(var3);
                if (var4 != null && var4 instanceof VariableScope$VariableDataArray) {
                    VariableScope$VariableDataArray var5 = (VariableScope$VariableDataArray)var4;
                    var5.shrink();
                }
            }

        }
    }
}
