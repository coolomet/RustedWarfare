package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.GameEvent;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$MemoryWriter;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.i
public strictfp class class_778 extends class_776 {
    VariableScope$MemoryWriter a;
    LogicBoolean b;
    class_588 c;

    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        LogicBoolean var7 = var1.b(var0, var2, var3 + "sendMessageTo", (LogicBoolean)null);
        VariableScope$MemoryWriter var8 = null;
        String var9 = var1.getValueAsStaticString(var2, var3 + "sendMessageWithData", (String)null);
        if (var9 != null) {
            var8 = VariableScope.createGenericKeyValueWriter(var9, var0, var2, var3 + "sendMessageWithData");
        }

        class_588 var10 = var1.a((class_591)var0, var2, (String)(var3 + "sendMessageWithTags"), (class_588)null);
        if (var7 != null) {
            class_778 var11 = new class_778();
            var11.b = var7;
            var11.a = var8;
            var11.c = var10;
            var4.ac.add(var11);
        }

    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        if (this.b != null) {
            Unit var6 = this.b.readUnit(var1);
            if (var6 != null) {
                VariableScope var7 = null;
                if (this.a != null) {
                    var7 = new VariableScope();
                    this.a.writeToMemory(var7, var1);
                }

                var6.a(GameEvent.newMessage, var1, this.c, var7);
            }
        }

        return true;
    }
}
