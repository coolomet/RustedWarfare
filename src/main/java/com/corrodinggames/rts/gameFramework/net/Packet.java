package com.corrodinggames.rts.gameFramework.net;

public strictfp class Packet {
    public PlayerConnect playerConnect = null;
    public int type;
    public byte[] bytes;
    public int f7548d = -1;
    public boolean e;

    public Packet(int var1) {
        this.type = var1;
    }
}
