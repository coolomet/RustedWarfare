package com.corrodinggames.rts.game.units;

// $FF: renamed from: com.corrodinggames.rts.game.units.o.5
final class class_824 extends class_819 {
    class_824(String var1, int var2) {
        super(var1, var2, (class_252)null);
    }

    public boolean a(class_31 var1) {
        if (var1 == null) {
            return false;
        } else {
            Unit var2 = Unit.c(var1);
            return var2.bO();
        }
    }
}
