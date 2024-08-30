package com.corrodinggames.rts.gameFramework.utility;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.c
class class_699 extends Throwable {
    // $FF: synthetic field
    final class_703 a;

    private class_699(class_703 var1, class_699 var2) {
        super(class_703.a(var1), var2);
        this.a = var1;
    }

    public Throwable fillInStackTrace() {
        this.setStackTrace(class_703.b(this.a));
        return this;
    }

    // $FF: synthetic method
    class_699(class_703 var1, class_699 var2, class_1070 var3) {
        this(var1, var2);
    }
}
