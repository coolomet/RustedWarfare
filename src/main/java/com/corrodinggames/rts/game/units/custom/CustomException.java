package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bo
public strictfp class CustomException extends Exception {
    public String b;
    public String c;
    public String d;

    public CustomException(String var1, String var2) {
        super(var1);
        this.b = var2;
    }

    public CustomException(String var1) {
        super(var1);
    }

    public CustomException(String var1, String var2, String var3) {
        super(var1);
        this.c = var2;
        this.d = var3;
    }

    public CustomException(String var1, Exception var2) {
        super(var1, var2);
    }
}
