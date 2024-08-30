package com.corrodinggames.rts.java.steam;

import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamNetworking$P2PSend;
import com.corrodinggames.rts.gameFramework.GameEngine;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public strictfp class SteamSocketOutStream extends OutputStream {
    boolean a;
    // $FF: synthetic field
    final SteamSocket b;

    public SteamSocketOutStream(SteamSocket var1) {
        this.b = var1;
        this.a = true;
    }

    public void write(int var1) {
        GameEngine.warn("SteamSocketOutputStream: Slow write: " + var1);
        byte[] var2 = new byte[]{(byte)var1};
        this.write(var2);
    }

    @SneakyThrows
    public void write(byte[] var1, int var2, int var3) {
        if (this.b.b) {
            GameEngine.log("cannot write steam socket closed");
        } else if (var3 > 307200) {
            GameEngine.log("Steam spliting large packet to:" + this.b.e + " len:" + var3);
            int var10 = var3;

            do {
                int var5 = var10;
                if (var10 > 256000) {
                    var5 = 256000;
                }

                this.write(var1, var2, var5);
                var2 += var5;
                var10 -= var5;
            } while(var10 > 0);

        } else {
            ByteBuffer var4 = ByteBuffer.allocateDirect(var3);
            var4.put(var1, var2, var3);
            var4.flip();
            synchronized(this.b.a) {
                try {
                    if (this.a) {
                        this.a = false;
                        GameEngine.log("First packet to:" + this.b.e);
                    }

                    boolean var6 = this.b.a.h.sendP2PPacket(this.b.e, var4, SteamNetworking$P2PSend.Reliable, 0);
                    if (!var6) {
                        GameEngine.log("steam sendP2PPacket failed (size: " + var3 + " to:" + this.b.e + ")");
                    }
                } catch (Exception var8) {
                    throw new IOException(var8);
                }

            }
        }
    }

    public void write(byte[] var1) {
        this.write(var1, 0, var1.length);
    }
}
