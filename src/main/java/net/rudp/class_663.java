package net.rudp;

import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.ArrayList;
import net.rudp.p002a.Segment;

// $FF: renamed from: net.rudp.e
class class_663 extends ReliableSocket {
    boolean a;
    private ArrayList i;
    // $FF: synthetic field
    final ReliableServerSocket b;

    public class_663(ReliableServerSocket var1, DatagramSocket var2, SocketAddress var3) {
        super(var2);
        this.b = var1;
        this.d = var3;
    }

    protected void a(DatagramSocket var1, ReliableSocketProfile var2) {
        this.i = new ArrayList();
        this.c = var1;
        this.g = var2;
    }

    protected Segment a() {
        synchronized(this.i) {
            while(this.i.isEmpty()) {
                try {
                    this.i.wait();
                } catch (InterruptedException var4) {
                    var4.printStackTrace();
                }
            }

            return (Segment)this.i.remove(0);
        }
    }

    protected void a(Segment var1) {
        synchronized(this.i) {
            if (!this.a) {
                this.a = true;
                super.a(this.c, this.g);
            }

            this.i.add(var1);
            this.i.notify();
        }
    }

    protected void b() {
        synchronized(this.i) {
            this.i.clear();
            this.i.add((Object)null);
            this.i.notify();
        }
    }

    protected void a(String var1) {
        System.out.println(this.getPort() + ": " + var1);
    }
}
