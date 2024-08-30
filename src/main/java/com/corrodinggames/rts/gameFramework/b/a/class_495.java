package com.corrodinggames.rts.gameFramework.b.a;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.a.a
public final strictfp class class_495 {
    public static final class_495 a = new class_495("A_Position", 0, 1, "a_Position");
    public static final class_495 b = new class_495("A_TexCoordinate", 1, 2, "a_TexCoordinate");
    private int c;
    private String d;
    // $FF: synthetic field
    private static final class_495[] e = new class_495[]{a, b};

    public static class_495[] values() {
        return (class_495[])e.clone();
    }

    private class_495(String var1, int var2, int var3, String var4) {
        this.c = var3;
        this.d = var4;
    }

    public int a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }
}
