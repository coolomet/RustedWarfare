package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import net.rudp.class_766;

class ServerAcceptRunnable$1 extends class_766 {
    // $FF: synthetic field
    final ServerAcceptRunnable a;

    ServerAcceptRunnable$1(ServerAcceptRunnable var1) {
        this.a = var1;
    }

    public strictfp boolean a(SocketAddress var1) {
        if (var1 instanceof InetSocketAddress) {
            return this.a.a(((InetSocketAddress)var1).getAddress(), false);
        } else {
            GameEngine.log("AcceptFilter: Unhandled SocketAddress type:" + var1.getClass().getName());
            return true;
        }
    }
}
