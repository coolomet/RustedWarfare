package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.game.units.Unit;

public strictfp class Unknown_GameOutBlockStream extends GameOutputStream {
    public String a = "";

    public strictfp void writeInt(int var1) {
        this.a = this.a + "|" + var1;
        super.writeInt(var1);
    }

    public strictfp void writeFloat(float var1) {
        this.a = this.a + "|" + var1;
        super.writeFloat(var1);
    }

    public strictfp void a(short var1) {
        this.a = this.a + "|" + var1;
        super.a(var1);
    }

    public strictfp void writeBoolean(boolean var1) {
        this.a = this.a + "|" + var1;
        super.writeBoolean(var1);
    }

    public strictfp void startBlock(String var1, boolean var2) {
        this.a = this.a + "<" + var1 + ">";
        super.startBlock(var1, var2);
    }

    public strictfp void endBlock(String var1) {
        this.a = this.a + "</" + var1 + ">";
        super.endBlock(var1);
    }

    public strictfp void a(Unit var1) {
        this.a = this.a + "|u:" + var1;
        super.a(var1);
    }
}
