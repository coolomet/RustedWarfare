package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.OrderableUnit;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.al.5
final class class_504 extends class_501 {
    public boolean a(OrderableUnit var1) {
        return var1.r() == UnitType.landFactory && var1.cN == null;
    }
}
