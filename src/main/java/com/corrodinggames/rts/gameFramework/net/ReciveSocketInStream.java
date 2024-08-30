package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

final class ReciveSocketInStream implements Runnable {
    Boolean a;
    // $FF: synthetic field
    final PlayerConnect b;

    private ReciveSocketInStream(PlayerConnect var1) {
        this.b = var1;
        this.a = true;
    }

    public strictfp void run() {
        GameEngine.aq();
        Thread.currentThread().setName("ReceiveWorker-" + this.b.g());

        try {
            this.a();
        } catch (EOFException var4) {
            this.b.a("network:ReceiveWorker: EOF reading packet", var4);
        } catch (IOException var5) {
            if (!this.b.a) {
                var5.printStackTrace();
            }

            if (GameEngine.aZ && var5 instanceof SocketException && !this.b.a) {
                GameEngine var2 = GameEngine.getGameEngine();
                if (!var2.netEngine.isServer && var2.netEngine.ingame) {
                    String var3 = var5.getMessage();
                    if (var3 != null && var3.contains("EBADF")) {
                        var2.i("Warning: This disconnect likely due to iOS removing sockets of background apps. Avoid minimising the game in multiplayer. Note: Games can be rejoined.");
                    }
                }
            }

            this.b.c("network:ReceiveWorker: " + var5.getMessage());
        } catch (OutOfMemoryError var6) {
            GameEngine.c((Throwable)var6);
            this.b.c("network:ReceiveWorker OutOfMemoryError: " + var6.getMessage());
        }

        PlayerConnect.a(this.b, true, false);
    }

    strictfp void a() throws IOException {
        InputStream var1 = this.b.socket.getInputStream();
        DataInputStream var2 = new DataInputStream(var1);

        while(this.a && !this.b.a && !this.b.socket.isClosed()) {
            int var3 = var2.readInt();
            int var4 = var2.readInt();
            if (var3 > 20000000) {
                this.b.b("readData(): new packet of type:" + var4 + " has size of:" + var3);
            }

            if (var3 > 10000) {
                int var5 = 50000000;
                if (PlayerConnect.a(this.b).isServer) {
                    var5 = 1000000;
                }

                if (!this.b.p) {
                    var5 = 10000;
                }

                if (var3 > var5) {
                    this.b.b("Requested packet too large rejecting (max:" + var5 + ")");
                    return;
                }
            }

            if (var3 < 0) {
                this.b.b("Requested packet negative size:" + var3 + " rejecting");
                return;
            }

            Packet var8 = new Packet(var4);
            var8.bytes = new byte[var3];
            this.b.V = 0;
            this.b.U = var3;
            int var6 = 0;

            for(var8.playerConnect = this.b; var6 < var3 && !this.b.a; this.b.V = var6) {
                int var7 = var2.read(var8.bytes, var6, var3 - var6);
                if (var7 == -1) {
                    this.b.b("we got to the end of the stream?!?");
                    return;
                }

                var6 += var7;
                ++this.b.P;
            }

            this.b.U = 0;
            this.b.V = 0;
            if (!this.b.a) {
                if (var8.type > 100) {
                    PlayerConnect.a(this.b).resolveCommandPacket(var8);
                } else {
                    PlayerConnect.a(this.b).aN.add(var8);
                }
            }
        }

    }

    // $FF: synthetic method
    ReciveSocketInStream(PlayerConnect var1, PlayerConnect$1 var2) {
        this(var1);
    }
}
