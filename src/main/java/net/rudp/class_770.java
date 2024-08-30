package net.rudp;

import java.io.IOException;
import net.rudp.p002a.ACKSegment;
import net.rudp.p002a.EAKSegment;
import net.rudp.p002a.SYNSegment;
import net.rudp.p002a.Segment;

// $FF: renamed from: net.rudp.m
class class_770 extends Thread {
    // $FF: synthetic field
    final ReliableSocket a;

    public class_770(ReliableSocket var1) {
        super("ReliableSocket");
        this.a = var1;
        this.setDaemon(true);
    }

    public void run() {
        while(true) {
            try {
                Segment var1;
                if ((var1 = ReliableSocket.f(this.a)) != null) {
                    if (var1 instanceof SYNSegment) {
                        this.a.a((SYNSegment)var1);
                    } else if (var1 instanceof EAKSegment) {
                        ReliableSocket.a(this.a, (EAKSegment)var1);
                    } else if (!(var1 instanceof ACKSegment)) {
                        ReliableSocket.a(this.a, var1);
                    }

                    this.a.c(var1);
                    continue;
                }
            } catch (Exception var3) {
                var3.printStackTrace();
            }

            return;
        }
    }
}
