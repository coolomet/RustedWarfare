package com.corrodinggames.rts.game;

public strictfp class Player extends PlayerData {
    public Player(int var1) {
        super(var1);
    }

    public Player(int var1, boolean var2) {
        super(var1, var2);
    }

    public Player(int var1, boolean var2, String var3) {
        super(var1, var2);
        this.name = var3;
    }

    public strictfp void a(float var1) {
        super.a(var1);
    }
}
