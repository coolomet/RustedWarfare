package com.corrodinggames.rts.gameFramework.utility;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.d.3
class class_379 implements Runnable {
    // $FF: synthetic field
    final class_700 a;

    class_379(class_700 var1) {
        this.a = var1;
    }

    public void run() {
        class_700.a(this.a, (class_700.a(this.a) + 1) % Integer.MAX_VALUE);
    }
}
