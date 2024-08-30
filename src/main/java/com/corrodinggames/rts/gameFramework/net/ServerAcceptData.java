package com.corrodinggames.rts.gameFramework.net;

import java.net.InetAddress;

class ServerAcceptData {
    InetAddress a;
    int b;
    boolean c;
    boolean d;
    // $FF: synthetic field
    final ServerAcceptRunnable e;

    ServerAcceptData(ServerAcceptRunnable var1) {
        this.e = var1;
        this.b = 1;
    }
}
