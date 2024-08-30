package com.corrodinggames.rts.game.units;

// $FF: renamed from: com.corrodinggames.rts.game.units.r
public abstract strictfp class class_143 {
    public static final class_143 GRASS = new class_144("grass", 0);
    public static final class_143 SEA = new class_145("sea", 1);
    public static final class_143 SAND = new class_146("sand", 2);
    public static final class_143 DUST = new class_147("dust", 3);
    // $FF: synthetic field
    private static final class_143[] e = new class_143[]{GRASS, SEA, SAND, DUST};

    public static class_143[] values() {
        return (class_143[])e.clone();
    }

    private final String name;
    private final int ordinal;
    private class_143(String var1, int var2) {
        name = var1;
        ordinal = var2;
    }
    public String name() { return name; }
    public int ordinal() { return ordinal; }

    public abstract String type();

    public abstract String b();

    // $FF: synthetic method
    class_143(String var1, int var2, class_799 var3) {
        this(var1, var2);
    }
}
