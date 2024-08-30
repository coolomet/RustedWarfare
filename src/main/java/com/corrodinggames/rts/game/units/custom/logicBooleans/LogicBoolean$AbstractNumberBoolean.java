package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.class_340;

public abstract strictfp class LogicBoolean$AbstractNumberBoolean extends LogicBoolean {
    @LogicBoolean$Parameter
    public boolean full;
    @LogicBoolean$Parameter
    public boolean empty;
    @LogicBoolean$Parameter
    public float greaterThan = -1.0F;
    @LogicBoolean$Parameter
    public float lessThan = -1.0F;

    @LogicBoolean$Parameter
    public void equalTo(float var1) {
        this.greaterThan = var1 - 1.0E-4F;
        this.lessThan = var1 + 1.0E-4F;
    }

    public LogicBoolean$ReturnType getReturnType() {
        return this.greaterThan == -1.0F && this.lessThan == -1.0F && !this.full && !this.empty ? LogicBoolean$ReturnType.number : LogicBoolean$ReturnType.bool;
    }

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (var5 && this.greaterThan == -1.0F && this.lessThan == -1.0F && !this.full && !this.empty) {
            throw new BooleanParseException("Expected greaterThan, lessThan, full, and/or empty to be set for function:" + var1 + " to return a boolean");
        }
    }

    public abstract String getName();

    public abstract float getValue(OrderableUnit var1);

    public abstract float getMaxValue(OrderableUnit var1);

    public float readNumber(OrderableUnit var1) {
        return this.getValue(var1);
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        String var2 = this.getName() + "=" + class_340.a(this.getValue(var1), 3) + "";
        if (this.full) {
            var2 = var2 + "(full)";
        }

        if (this.empty) {
            var2 = var2 + "(empty)";
        }

        if (this.greaterThan != -1.0F) {
            var2 = var2 + ">" + class_340.a(this.greaterThan, 3);
        }

        if (this.lessThan != -1.0F) {
            var2 = var2 + "<" + class_340.a(this.lessThan, 3);
        }

        return var2;
    }

    public boolean read(OrderableUnit var1) {
        float var2 = this.getValue(var1);
        boolean var3 = true;
        if (this.full && !(var2 >= this.getMaxValue(var1))) {
            var3 = false;
        }

        if (this.empty && !(var2 <= 0.0F)) {
            var3 = false;
        }

        if (this.greaterThan != -1.0F && !(var2 > this.greaterThan)) {
            var3 = false;
        }

        if (this.lessThan != -1.0F && !(var2 < this.lessThan)) {
            var3 = false;
        }

        return var3;
    }
}
