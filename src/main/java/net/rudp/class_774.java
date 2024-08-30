package net.rudp;

import java.io.IOException;
import java.util.Iterator;
import net.rudp.p002a.Segment;

// $FF: renamed from: net.rudp.n
class class_774 implements Runnable {
    // $FF: synthetic field
    final ReliableSocket a;

    private class_774(ReliableSocket var1) {
        this.a = var1;
    }

    public void run() {
        synchronized(ReliableSocket.g(this.a)) {
            Iterator var2 = ReliableSocket.g(this.a).iterator();

            while(var2.hasNext()) {
                Segment var3 = (Segment)var2.next();

                try {
                    ReliableSocket.c(this.a, var3);
                } catch (Exception var6) {
                    var6.printStackTrace();
                }
            }

        }
    }

    // $FF: synthetic method
    class_774(ReliableSocket var1, ReliableSocket$1 var2) {
        this(var1);
    }
}
