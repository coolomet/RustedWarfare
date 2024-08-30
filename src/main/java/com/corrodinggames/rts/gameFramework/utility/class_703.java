package com.corrodinggames.rts.gameFramework.utility;

import java.io.Serializable;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.b
class class_703 implements Serializable {
    private final String a;
    private final StackTraceElement[] b;

    private class_703(String var1, StackTraceElement[] var2) {
        this.a = var1;
        this.b = var2;
    }

    // $FF: synthetic method
    static String a(class_703 var0) {
        return var0.a;
    }

    // $FF: synthetic method
    static StackTraceElement[] b(class_703 var0) {
        return var0.b;
    }

    // $FF: synthetic method
    class_703(String var1, StackTraceElement[] var2, class_1070 var3) {
        this(var1, var2);
    }
}
