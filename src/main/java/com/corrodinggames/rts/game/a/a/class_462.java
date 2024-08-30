package com.corrodinggames.rts.game.a.a;

// $FF: renamed from: com.corrodinggames.rts.game.a.a.b
public abstract strictfp class class_462 {
    public static final class_462 UNKNOWN = new class_463("unknown", 0);
    public static final class_462 NUKING = new class_464("nuking", 1);
    // $FF: synthetic field
    private static final class_462[] c = new class_462[]{UNKNOWN, NUKING};

    public static class_462[] values() {
        return (class_462[])c.clone();
    }
    private final String name;
    public String name() { return name; }
    private class_462(String var1, int var2) {
        name = var1;
    }

    public abstract class_1002 a();

    // $FF: synthetic method
    class_462(String var1, int var2, class_639 var3) {
        this(var1, var2);
    }
}
