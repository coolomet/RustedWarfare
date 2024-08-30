package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.utility.class_649;
import com.corrodinggames.rts.gameFramework.utility.class_684;

public strictfp class UnitReference$TransportingUnitReference extends UnitReference {
    class_591 meta;
    @LogicBoolean$Parameter
    public int slot = -1;

    public void forMeta(class_591 var1) {
        if (var1 == null) {
            throw new class_649("TransportingUnitReference requires metadata");
        } else {
            this.meta = var1;
        }
    }

    public Unit getSingleRaw(OrderableUnit var1) {
        Unit var2 = null;
        class_684 var3 = var1.bz();
        if (var3 != null) {
            if (this.slot == -1) {
                if (var3.size() > 0) {
                    var2 = (Unit)var3.get(0);
                }
            } else if (this.slot >= 0 && this.slot < var3.size()) {
                var2 = (Unit)var3.get(this.slot);
            }
        }

        return var2;
    }

    public String getClassDebugName() {
        return "transporting";
    }
}
