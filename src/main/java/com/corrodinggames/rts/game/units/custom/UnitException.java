package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bd
public strictfp class UnitException extends CustomException {
    public String a;

    public UnitException(String var1, String var2) {
        super(var1, var2);
        this.b = var2;
    }
}
