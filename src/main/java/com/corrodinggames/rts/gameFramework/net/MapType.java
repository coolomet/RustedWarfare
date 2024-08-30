package com.corrodinggames.rts.gameFramework.net;

public abstract strictfp class MapType {;
    public static final MapType skirmishMap = new class_154("skirmishMap", 0);
    public static final MapType customMap = new MapType$2("customMap", 1);
    public static final MapType savedGame = new MapType$3("savedGame", 2);
    // $FF: synthetic field
    private static final MapType[] d = new MapType[]{skirmishMap, customMap, savedGame};

    public static strictfp MapType[] values() {
        return (MapType[])d.clone();
    }
    private final String name;
    private final int ordinal;
    private MapType(String var1, int var2) {
        name = var1;
        ordinal = var2;
    }
    public String name() { return name; }
    public int ordinal() { return ordinal; }
    public abstract String type();

    // $FF: synthetic method
    MapType(String var1, int var2, GameNetEngine$1 var3) {
        this(var1, var2);
    }
}
