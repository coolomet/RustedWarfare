package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.OrderableUnit;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.al.6
final class class_507 extends class_501 {
    public boolean a(OrderableUnit var1) {
        return var1.r() == UnitType.airFactory && var1.cN == null;
    }
}
