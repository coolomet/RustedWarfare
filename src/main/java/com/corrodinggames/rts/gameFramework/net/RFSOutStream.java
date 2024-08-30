package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.OutputStream;

public strictfp class RFSOutStream extends OutputStream {
    boolean a;
    // $FF: synthetic field
    final RelayForwardedSocket b;

    public RFSOutStream(RelayForwardedSocket var1) {
        this.b = var1;
        this.a = true;
    }

    public void write(int var1) {
        GameEngine.warn("SteamSocketOutputStream: Slow write: " + var1);
        byte[] var2 = new byte[]{(byte)var1};
        this.write(var2);
    }

    public void write(byte[] var1, int var2, int var3) {
        if (this.b.c) {
            GameEngine.log("cannot write steam socket closed");
        } else {
            GameEngine.log("Forwarded message to client: " + this.b.b + " with old method");
        }
    }

    public void write(byte[] var1) {
        this.write(var1, 0, var1.length);
    }
}
