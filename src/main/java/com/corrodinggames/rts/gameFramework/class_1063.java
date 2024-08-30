package com.corrodinggames.rts.gameFramework;

import android.util.Log;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.am.1
class class_1063 extends Thread {
    // $FF: synthetic field
    final class_1001 a;

    class_1063(class_1001 var1) {
        this.a = var1;
    }

    public void run() {
        if (this.a.j) {
            Log.a("RustedWarfare", "Music:pause() unsynchronized");
            this.a.g();
        } else {
            synchronized(this.a.b) {
                Log.a("RustedWarfare", "Music:pause() synchronized");
                this.a.g();
            }
        }

    }
}
