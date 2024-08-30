package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter$Operator;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter$WriterElement;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$CachedWriter$WriterFactory;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.au
public strictfp class class_58 extends VariableScope$CachedWriter$WriterFactory {
    class_591 a;

    public class_58(class_591 var1) {
        this.a = var1;
    }

    @SneakyThrows
    public VariableScope$CachedWriter$WriterElement createWriterElement(String var1, String var2, String var3, String var4) {
        if (!var2.equals("=") && !var2.equals("+=") && !var2.equals("-=")) {
            throw new CustomException("Only '=','+=','-='  is supported here, got:" + var2);
        } else if (var3 == null) {
            throw new CustomException("Expected a value for: " + var1 + " (likely missing '=')");
        } else {
            VariableScope$CachedWriter$Operator var5 = VariableScope$CachedWriter$Operator.set;
            if (var2.equals("+=")) {
                var5 = VariableScope$CachedWriter$Operator.add;
            }

            if (var2.equals("-=")) {
                var5 = VariableScope$CachedWriter$Operator.subtract;
            }

            LogicBoolean var6;
            try {
                var6 = LogicBooleanLoader.parseBooleanBlock(this.a, var3, false);
            } catch (RuntimeException var9) {
                throw new RuntimeException("LogicBoolean - Error: " + var9.getMessage() + ", [parsing: '" + var3 + "']", var9);
            }

            if (var4 != null) {
                throw new RuntimeException("Unexpected array [] index operator on " + var1);
            } else {
                class_399 var7 = (class_399)class_398.s.get(var1);
                if (var7 == null) {
                    var7 = (class_399)class_398.s.get("core." + var1);
                }

                if (var7 == null) {
                    throw new CustomException("Unknown key: " + var1 + "");
                } else {
                    class_59 var8 = new class_59();
                    var8.a = var7;
                    var8.b = var6;
                    var8.c = var5;
                    if (var6.getReturnType() != var7.a()) {
                        throw new CustomException("Field: " + var1 + " expects " + var7.a() + " type getting: " + var6.getReturnType() + " from: " + var3);
                    } else {
                        return var8;
                    }
                }
            }
        }
    }
}
