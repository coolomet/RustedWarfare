package com.corrodinggames.rts.game.units;

// $FF: renamed from: com.corrodinggames.rts.game.units.o.2
final class class_821 extends class_819 {
    class_821(String var1, int var2) {
        super(var1, var2, (class_252)null);
    }

    public boolean a(class_31 var1) {
        if (var1 == null) {
            return false;
        } else {
            Unit var2 = Unit.c(var1);
            if (!var2.bO() && !var1.j()) {
                return var2.h() == MovementType.AIR;
            } else {
                return false;
            }
        }
    }
}
