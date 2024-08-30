package com.corrodinggames.rts.game.units.custom.logicBooleans;

public abstract strictfp class LogicBoolean$LogicBooleanCommonLocking extends LogicBoolean {
    boolean locked = false;

    public LogicBoolean createLocked() {
        LogicBoolean$LogicBooleanCommonLocking var1;
        try {
            var1 = (LogicBoolean$LogicBooleanCommonLocking)this.clone();
        } catch (CloneNotSupportedException var3) {
            throw new RuntimeException(var3);
        }

        var1.locked = true;
        return var1;
    }

    public boolean isLocked() {
        return this.locked;
    }
}
