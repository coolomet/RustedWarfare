package net.rudp;

// $FF: renamed from: net.rudp.k
class class_772 implements Runnable {
    // $FF: synthetic field
    final ReliableSocket a;

    private class_772(ReliableSocket var1) {
        this.a = var1;
    }

    public void run() {
        ReliableSocket.j(this.a);
    }

    // $FF: synthetic method
    class_772(ReliableSocket var1, ReliableSocket$1 var2) {
        this(var1);
    }
}
