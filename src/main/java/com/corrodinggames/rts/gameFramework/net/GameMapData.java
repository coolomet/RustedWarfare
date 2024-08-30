package com.corrodinggames.rts.gameFramework.net;

public strictfp class GameMapData implements Cloneable {
    public MapType mapType;
    public String mapName;
    public int credits;
    public int fog;
    public boolean e;
    public int aidiff;
    public int initUnit;
    public float income;
    public boolean nukes;
    public boolean j;
    public boolean k;
    public boolean sharedControl;
    public boolean m;
    public boolean n;
    public boolean spectators;
    public boolean p;
    public int q;

    public GameMapData() {
        this.mapType = MapType.skirmishMap;
        this.mapName = "[z;p10]Crossing Large (10p).tmx";
        this.credits = 0;
        this.fog = 2;
        this.e = true;
        this.aidiff = 1;
        this.initUnit = 1;
        this.income = 1.0F;
        this.nukes = false;
        this.j = false;
        this.k = false;
        this.m = false;
        this.n = false;
        this.spectators = true;
        this.p = false;
    }

    public strictfp void a() {
        this.mapType = MapType.skirmishMap;
        this.mapName = "[z;p10]Crossing Large (10p).tmx";
    }

    public strictfp String b() {
        String var1 = "";
        String var2 = "\n";
        var1 = var1 + "startingCredits: " + this.credits + var2;
        var1 = var1 + "fogMode: " + this.fog + var2;
        var1 = var1 + "revealedMap: " + this.e + var2;
        var1 = var1 + "aiDifficulty: " + this.aidiff + var2;
        var1 = var1 + "startingUnits: " + this.initUnit + var2;
        var1 = var1 + "incomeMultiplier: " + this.income + var2;
        var1 = var1 + "noNukes: " + this.nukes + var2;
        var1 = var1 + "sharedControl: " + this.sharedControl + var2;
        var1 = var1 + "allowSpectators: " + this.spectators + var2;
        var1 = var1 + "lockedRoom: " + this.p + var2;
        var1 = var1 + "randomSeed: " + this.q + var2;
        return var1;
    }

    public strictfp GameMapData c() {
        try {
            return (GameMapData)super.clone();
        } catch (CloneNotSupportedException var2) {
            throw new RuntimeException(var2);
        }
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeByte(4);
        var1.writeInt(this.fog);
        var1.writeInt(this.credits);
        var1.writeBoolean(this.e);
        var1.writeInt(this.aidiff);
        var1.writeInt(this.initUnit);
        var1.writeFloat(this.income);
        var1.writeBoolean(this.nukes);
        var1.writeBoolean(this.j);
        var1.writeBoolean(this.sharedControl);
        var1.writeBoolean(this.m);
        var1.writeBoolean(this.n);
        var1.writeBoolean(this.spectators);
        var1.writeBoolean(this.p);
        var1.writeInt(this.q);
    }

    public strictfp void a(GameInputStream var1) {
        byte var2 = var1.readByte();
        this.fog = var1.readInt();
        this.credits = var1.readInt();
        this.e = var1.readBoolean();
        this.aidiff = var1.readInt();
        this.initUnit = var1.readInt();
        this.income = var1.readFloat();
        this.nukes = var1.readBoolean();
        this.j = var1.readBoolean();
        this.sharedControl = var1.readBoolean();
        if (var2 >= 1) {
            this.m = var1.readBoolean();
        }

        if (var2 >= 2) {
            this.n = var1.readBoolean();
        }

        if (var2 >= 3) {
            this.spectators = var1.readBoolean();
            this.p = var1.readBoolean();
        }

        if (var2 >= 4) {
            this.q = var1.readInt();
        }

    }

    // $FF: synthetic method
    public Object clone() {
        return this.c();
    }
}
