package com.corrodinggames.librocket.scripts;

import com.corrodinggames.rts.gameFramework.net.PlayerConnect;
import java.util.Iterator;

class Debug$1 implements Runnable {
    // $FF: synthetic field
    final Debug this$0;

    Debug$1(Debug var1) {
        this.this$0 = var1;
    }

    public void run() {
        PlayerConnect var2;
        for(Iterator var1 = this.this$0.backgroundClientConnections.iterator(); var1.hasNext(); var2 = (PlayerConnect)var1.next()) {
        }

    }
}
