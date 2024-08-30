package com.corrodinggames.rts.gameFramework.net;

import java.util.TimerTask;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.af.1
class class_1043 extends TimerTask {
    // $FF: synthetic field
    final class_981 a;

    class_1043(class_981 var1) {
        this.a = var1;
    }

    public strictfp void run() {
        if (!this.a.d.isServer) {
            this.a.a();
        }

    }
}
