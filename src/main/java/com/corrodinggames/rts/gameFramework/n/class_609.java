package com.corrodinggames.rts.gameFramework.n;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.n.e
public abstract strictfp class class_609 {
    public static final class_609 a = new class_610("objective", 0);
    public static final class_609 b = new class_615("event_move", 1);
    public static final class_609 c = new class_616("event_changeCredits", 2);
    public static final class_609 d = new class_613("event_teamTags", 3);
    public static final class_609 e = new class_614("event_unitAdd", 4);
    public static final class_609 f = new class_611("event_unitRemove", 5);
    public static final class_609 g = new class_612("mapText", 6);
    public static final class_609 h = new class_619("moveCamera", 7);
    public static final class_609 i = new class_620("trigger_unitDetect", 8);
    public static final class_609 j = new class_617("trigger_teamTagDetect", 9);
    public static final class_609 k = new class_618("trigger_basic", 10);
    // $FF: synthetic field
    private static final class_609[] l = new class_609[]{a, b, c, d, e, f, g, h, i, j, k};

    public static class_609[] values() {
        return (class_609[])l.clone();
    }

    private class_609(String var1, int var2) {
    }

    public abstract String type();

    public static class_609 a(String var0) {
        class_609[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            class_609 var4 = var1[var3];
            if (var4.type().equalsIgnoreCase(var0)) {
                return var4;
            }
        }

        return null;
    }

    // $FF: synthetic method
    class_609(String var1, int var2, class_610 var3) {
        this(var1, var2);
    }
}
