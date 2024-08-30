package net.rudp;

// $FF: renamed from: net.rudp.j
class class_773 implements Runnable {
    // $FF: synthetic field
    final ReliableSocket a;

    private class_773(ReliableSocket var1) {
        this.a = var1;
    }

    public void run() {
        ReliableSocket.i(this.a);
    }

    // $FF: synthetic method
    class_773(ReliableSocket var1, ReliableSocket$1 var2) {
        this(var1);
    }
}
