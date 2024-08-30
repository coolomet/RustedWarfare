package com.corrodinggames.rts.gameFramework.net;

public strictfp class Unk_Packet extends Packet {
    public Packet f;
    public int g;

    public Unk_Packet(int var1, Packet var2) {
        super(175);
        this.g = var1;
        this.f = var2;
    }
}
