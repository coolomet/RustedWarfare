package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

public strictfp class TeamStats {
    public int a;
    public int b;
    public int unitsKilled;
    public int buildingsKilled;
    public int experimentalsKilled;
    public int unitsLost;
    public int buildingsLost;
    public int experimentalsLost;
    public int i;
    public int j;
    public long k;
    public TeamHistory l = new TeamHistory();
    private static final byte m;

    public strictfp void a(GameOutputStream var1) {
        var1.writeByte(m);
        var1.e();
        var1.writeInt(this.a);
        var1.writeInt(this.b);
        var1.writeInt(this.unitsKilled);
        var1.writeInt(this.buildingsKilled);
        var1.writeInt(this.experimentalsKilled);
        var1.writeInt(this.unitsLost);
        var1.writeInt(this.buildingsLost);
        var1.writeInt(this.experimentalsLost);
        var1.writeInt(this.i);
        var1.writeInt(this.j);
        var1.writeLong(this.k);
        this.l.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        byte var2 = var1.readByte();
        var1.checkMark("stats start");
        this.a = var1.readInt();
        this.b = var1.readInt();
        this.unitsKilled = var1.readInt();
        this.buildingsKilled = var1.readInt();
        this.experimentalsKilled = var1.readInt();
        this.unitsLost = var1.readInt();
        this.buildingsLost = var1.readInt();
        this.experimentalsLost = var1.readInt();
        this.i = var1.readInt();
        this.j = var1.readInt();
        this.k = var1.readLong();
        if (var2 >= class_963.b.ordinal()) {
            this.l.a(var1);
        }

    }

    static {
        m = (byte)class_963.b.ordinal();
    }
}
