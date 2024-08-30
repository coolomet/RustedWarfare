package com.corrodinggames.rts.appFramework;

import android.app.Activity;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g.11
class class_557 implements Runnable {
    // $FF: synthetic field
    final Activity a;
    // $FF: synthetic field
    final class_198 b;

    class_557(class_198 var1, Activity var2) {
        this.b = var1;
        this.a = var2;
    }

    public void run() {
        if (class_208.b(this.a)) {
            class_198.a(this.b, (String)null);
        }

    }
}
