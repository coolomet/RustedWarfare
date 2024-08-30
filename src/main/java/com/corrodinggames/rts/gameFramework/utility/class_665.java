package com.corrodinggames.rts.gameFramework.utility;

import java.util.concurrent.ConcurrentLinkedQueue;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.aj
public strictfp class class_665 {
    ConcurrentLinkedQueue a = new ConcurrentLinkedQueue();

    public void a(Runnable var1) {
        this.a.add(var1);
    }

    public void a() {
        while(true) {
            Runnable var1 = (Runnable)this.a.poll();
            if (var1 == null) {
                return;
            }

            var1.run();
        }
    }
}
