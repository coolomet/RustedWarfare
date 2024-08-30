package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.OrderableUnit;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.al.4
final class class_505 extends class_501 {
    public boolean a(OrderableUnit var1) {
        return var1.r() == UnitType.fabricator && var1.V() < 3 && var1.cN == null;
    }
}
