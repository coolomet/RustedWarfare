package net.rudp;

// $FF: renamed from: net.rudp.f
class class_769 implements ReliableSocketStateListener {
    // $FF: synthetic field
    final ReliableServerSocket a;

    private class_769(ReliableServerSocket var1) {
        this.a = var1;
    }

    public void a(ReliableSocket var1) {
        if (var1 instanceof class_663) {
            synchronized(ReliableServerSocket.e(this.a)) {
                while(ReliableServerSocket.e(this.a).size() > 50) {
                    try {
                        ReliableServerSocket.e(this.a).wait();
                    } catch (InterruptedException var5) {
                        var5.printStackTrace();
                    }
                }

                ReliableServerSocket.e(this.a).add((class_663)var1);
                ReliableServerSocket.e(this.a).notify();
            }
        }

    }

    public void b(ReliableSocket var1) {
    }

    public void c(ReliableSocket var1) {
        if (var1 instanceof class_663) {
            ReliableServerSocket.a(this.a, ((class_663)var1).c());
        }

    }

    public void d(ReliableSocket var1) {
        if (var1 instanceof class_663) {
            ReliableServerSocket.a(this.a, ((class_663)var1).c());
        }

    }

    public void e(ReliableSocket var1) {
    }

    // $FF: synthetic method
    class_769(ReliableServerSocket var1, ReliableServerSocket$1 var2) {
        this(var1);
    }
}
