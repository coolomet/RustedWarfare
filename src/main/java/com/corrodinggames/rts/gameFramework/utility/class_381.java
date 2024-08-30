package com.corrodinggames.rts.gameFramework.utility;

import android.util.Log;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.d.2
final class class_381 implements class_22 {
    public void a(InterruptedException var1) {
        Log.c("ANRWatchdog", "Interrupted: " + var1.getMessage());
    }
}
