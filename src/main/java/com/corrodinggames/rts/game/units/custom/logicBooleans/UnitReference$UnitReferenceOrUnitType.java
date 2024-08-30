package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_601;

public strictfp class UnitReference$UnitReferenceOrUnitType {
    class_601 unitType;
    UnitReference unitReference;

    UnitReference$UnitReferenceOrUnitType(class_601 var1) {
        this.unitType = var1;
    }

    UnitReference$UnitReferenceOrUnitType(UnitReference var1) {
        this.unitReference = var1;
    }

    public Unit getUnitOrSharedUnit(Unit var1) {
        if (this.unitType != null) {
            return Unit.c(this.unitType.c());
        } else {
            if (this.unitReference != null) {
                Unit var2 = this.unitReference.get(var1);
                if (var2 != null) {
                    return var2;
                }
            }

            return null;
        }
    }

    public Unit getUnitReferenceOrNull(Unit var1) {
        if (this.unitReference != null) {
            Unit var2 = this.unitReference.get(var1);
            if (var2 != null) {
                return var2;
            }
        }

        return null;
    }

    public class_31 getTypeOrNull(Unit var1) {
        if (this.unitType != null) {
            return this.unitType.c();
        } else {
            if (this.unitReference != null) {
                Unit var2 = this.unitReference.get(var1);
                if (var2 != null) {
                    return var2.r();
                }
            }

            return null;
        }
    }
}
