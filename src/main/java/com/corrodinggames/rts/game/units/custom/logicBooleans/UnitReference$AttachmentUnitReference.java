package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.b.class_826;
import com.corrodinggames.rts.gameFramework.utility.class_649;

public strictfp class UnitReference$AttachmentUnitReference extends UnitReference {
    class_591 meta;
    class_585 _withTag;
    short attachmentId = -1;

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (var4 != null && var4 != LogicBooleanLoader.defaultContextReader && this.attachmentId != -1) {
            throw new BooleanParseException("Function:" + var1 + " only supports use with 'self.' when using 'slot'");
        }
    }

    public void forMeta(class_591 var1) {
        if (var1 == null) {
            throw new class_649("AttachmentUnitReference requires metadata");
        } else {
            this.meta = var1;
        }
    }

    @LogicBoolean$Parameter
    public void withTag(String var1) {
        this._withTag = class_585.c(var1);
    }

    @LogicBoolean$Parameter
    public void slot(String var1) {
        class_826 var2 = this.meta.i(var1);
        if (var2 == null) {
            throw new class_649("No attachment slot with name: " + var1 + " found");
        } else {
            this.attachmentId = var2.a();
        }
    }

    public Unit getSingleRaw(OrderableUnit var1) {
        if (!(var1 instanceof class_113)) {
            return null;
        } else {
            class_113 var2 = (class_113)var1;
            if (var2.C == null) {
                return null;
            } else {
                Object[] var3 = var2.C.a();
                int var4 = var2.C.a - 1;

                OrderableUnit var5;
                while(true) {
                    if (var4 < 0) {
                        return null;
                    }

                    var5 = (OrderableUnit)var3[var4];
                    if (var5 != null && (this.attachmentId == -1 || var4 == this.attachmentId)) {
                        if (this._withTag == null) {
                            break;
                        }

                        class_588 var6 = var5.de();
                        if (class_585.a(this._withTag, var6)) {
                            break;
                        }
                    }

                    --var4;
                }

                return var5;
            }
        }
    }

    public String getClassDebugName() {
        return "attachment";
    }
}
