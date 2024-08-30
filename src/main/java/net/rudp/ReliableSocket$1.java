package net.rudp;

class ReliableSocket$1 extends Thread {
    // $FF: synthetic field
    final ReliableSocket a;

    ReliableSocket$1(ReliableSocket var1) {
        this.a = var1;
    }

    public void run() {
        ReliableSocket.a(this.a).f();
        ReliableSocket.b(this.a).f();

        try {
            Thread.sleep((long)(this.a.g.g() * 2));
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

        ReliableSocket.c(this.a).f();
        ReliableSocket.d(this.a).f();
        this.a.b();
        ReliableSocket.e(this.a);
    }
}
