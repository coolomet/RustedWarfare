package net.rudp;

import java.io.IOException;
import net.rudp.p002a.NULSegment;

// $FF: renamed from: net.rudp.l
class class_771 implements Runnable {
    // $FF: synthetic field
    final ReliableSocket a;

    private class_771(ReliableSocket var1) {
        this.a = var1;
    }

    public void run() {
        synchronized(ReliableSocket.g(this.a)) {
            if (ReliableSocket.g(this.a).isEmpty()) {
                try {
                    ReliableSocket.b(this.a, new NULSegment(ReliableSocket.h(this.a).a()));
                } catch (Exception var4) {
                    if (ReliableSocket.h()) {
                        var4.printStackTrace();
                    }
                }
            }

        }
    }

    // $FF: synthetic method
    class_771(ReliableSocket var1, ReliableSocket$1 var2) {
        this(var1);
    }
}
