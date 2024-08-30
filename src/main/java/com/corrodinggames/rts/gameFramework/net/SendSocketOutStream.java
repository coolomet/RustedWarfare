package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.class_690;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import lombok.SneakyThrows;
import net.rudp.ReliableSocket;

final class SendSocketOutStream implements Runnable {
    Boolean a;
    OutputStream b;
    BufferedOutputStream c;
    DataOutputStream d;
    class_690 e;
    // $FF: synthetic field
    final PlayerConnect f;

    public strictfp synchronized void a(Packet var1) {
        if (!this.f.a) {
            this.f.f.add(var1);
            this.notifyAll();
        }
    }

    public strictfp synchronized void a() {
        this.notifyAll();
    }

    public strictfp synchronized void b() {
        try {
            if (this.f.f.isEmpty() && !this.f.a && !this.f.b) {
                this.wait(10000L);
            }
        } catch (InterruptedException var2) {
        }

    }

    @SneakyThrows
    SendSocketOutStream(PlayerConnect var1) {
        this.f = var1;
        this.a = true;
        this.e = new class_690();
        this.b = var1.socket.getOutputStream();
        this.c = new BufferedOutputStream(this.b);
        this.d = new DataOutputStream(this.c);
    }

    public strictfp void run() {
        GameEngine.aq();
        Thread.currentThread().setName("SendWorker-" + this.f.g());

        try {
            while(this.a && !this.f.a) {
                while(!this.f.f.isEmpty() && !this.f.a) {
                    Packet var1 = (Packet)this.f.f.remove();
                    if (var1 instanceof Unk_Packet) {
                        Unk_Packet var2 = (Unk_Packet)var1;
                        GameOutputStream var3;
                        if (this.f.l == var2.f && this.f.r) {
                            var3 = new GameOutputStream();
                            var3.writeInt(var2.g);
                            var1 = var3.getPacket(176);
                        } else {
                            var3 = new GameOutputStream();
                            var3.writeInt(var2.g);
                            var3.writeInt(var2.f.type);
                            var3.a(var2.f.bytes);
                            var1 = var3.getPacket(175);
                        }

                        this.f.l = var2.f;
                    } else if (this.f.q) {
                        this.f.l = var1;
                    }

                    if (this.f.socket instanceof RelayForwardedSocket) {
                        RelayForwardedSocket var9 = (RelayForwardedSocket)this.f.socket;
                        var9.a(var1);
                    } else if (this.f.socket instanceof ReliableSocket) {
                        boolean var10 = false;
                        class_690 var11;
                        if (var1.bytes.length > 500) {
                            var11 = new class_690(8 + var1.bytes.length);
                            var10 = true;
                        } else {
                            var11 = this.e;
                            var11.a();
                        }

                        boolean var4 = var1.e;
                        DataOutputStream var5 = new DataOutputStream(var11);
                        var5.writeInt(var1.bytes.length);
                        var5.writeInt(var1.type);
                        var5.write(var1.bytes);
                        var5.flush();
                        var5.close();
                        ReliableSocket var6 = (ReliableSocket)this.f.socket;
                        var6.a(var11.a, 0, var11.b(), var4);
                        if (var10) {
                            var11.close();
                        }
                    } else {
                        this.d.writeInt(var1.bytes.length);
                        this.d.writeInt(var1.type);
                        this.d.write(var1.bytes);
                        this.d.flush();
                    }

                    if (var1.f7548d != -1) {
                        try {
                            Thread.sleep((long)var1.f7548d);
                        } catch (InterruptedException var7) {
                        }
                    }
                }

                if (this.f.b) {
                    this.f.a = true;
                    break;
                }

                this.b();
            }
        } catch (IOException var8) {
            var8.printStackTrace();
            GameEngine.b("network:SendWorker", var8.getMessage());
        }

        PlayerConnect.a(this.f, false, true);
    }
}
