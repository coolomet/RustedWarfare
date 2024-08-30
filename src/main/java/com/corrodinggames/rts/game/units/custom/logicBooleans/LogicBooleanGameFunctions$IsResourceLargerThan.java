package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;

public final strictfp class LogicBooleanGameFunctions$IsResourceLargerThan extends LogicBoolean {
    class_591 meta;
    BuiltInResource source;
    BuiltInResource compareTarget;
    @LogicBoolean$Parameter
    public float byMoreThan = 0.0F;
    @LogicBoolean$Parameter
    public float multiplyTargetBy = 1.0F;

    public void forMeta(class_591 var1) {
        if (var1 == null) {
            throw new BooleanParseException("IsResourceLargerThan requires metadata");
        } else {
            this.meta = var1;
        }
    }

    @LogicBoolean$Parameter
    public void source(String var1) {
        this.source = this.meta.j(var1);
        if (this.source == null) {
            throw new BooleanParseException("Could not find custom resource type of:" + this.source);
        }
    }

    @LogicBoolean$Parameter
    public void compareTarget(String var1) {
        this.compareTarget = this.meta.j(var1);
        if (this.compareTarget == null) {
            throw new BooleanParseException("Could not find custom resource type of:" + this.compareTarget);
        }
    }

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (this.source == null) {
            throw new BooleanParseException("Requires 'source'");
        } else if (this.compareTarget == null) {
            throw new BooleanParseException("Requires 'compareTarget'");
        }
    }

    public boolean read(OrderableUnit var1) {
        double var2 = this.source.a((Unit)var1);
        double var4 = this.compareTarget.a((Unit)var1);
        var4 += (double)this.byMoreThan;
        var4 *= (double)this.multiplyTargetBy;
        boolean var6 = false;
        if (var2 > var4) {
            var6 = true;
        }

        return var6;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "IsResourceLargerThan(" + this.source.j() + " vs " + this.compareTarget.j() + ")";
    }
}
