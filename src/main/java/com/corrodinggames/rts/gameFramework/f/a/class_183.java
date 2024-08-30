package com.corrodinggames.rts.gameFramework.f.a;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.a.c
public strictfp class class_183 {
    public int a;
    public int b;
    public class_185 c;
    public int d = -1;

    public static class_183 a(int var0, int var1) {
        class_183 var2 = new class_183();
        var2.a = var0;
        var2.b = var1;
        var2.c = class_185.MOUSE_CLICK;
        var2.d = 1;
        return var2;
    }

    public static class_183 b(int var0, int var1) {
        class_183 var2 = new class_183();
        var2.a = var0;
        var2.b = var1;
        var2.c = class_185.MOUSE_MOVE;
        var2.d = 1;
        return var2;
    }

    public boolean a() {
        return this.c == class_185.MOUSE_CLICK;
    }

    public boolean b() {
        return this.c == class_185.MOUSE_MOVE;
    }
}
