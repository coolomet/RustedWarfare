package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Timer;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.af
// maybe error
final class class_981 implements Runnable {
    boolean a;
    DatagramSocket b;
    Timer c;
    // $FF: synthetic field
    GameNetEngine d = GameEngine.getGameEngine().netEngine;

    public strictfp void run() {
        try {
            this.d.printLog("starting socket for broadcast..");
            this.b = new DatagramSocket((SocketAddress)null);
            this.b.setReuseAddress(true);
            this.b.bind(new InetSocketAddress(this.d.t));
            this.d.printLog("reading..");
            byte[] var1 = new byte[1500];
            DatagramPacket var2 = new DatagramPacket(var1, var1.length);
            class_1043 var3 = new class_1043(this);
            this.c = new Timer();
            this.c.scheduleAtFixedRate(var3, 20L, 5000L);

            while(this.a) {
                this.b.receive(var2);
                String var4 = new String(var2.getData(), var2.getOffset(), var2.getLength());
                this.d.printLog("accepted udp socket..");
                GameInputStream var5 = new GameInputStream(var4);
                if (!var5.readString().equals("com.corrodinggames.rts")) {
                    this.d.printLog("ignoring udp packet: MAGIC_GAME_ID doesn't match");
                } else {
                    int var6 = var5.readInt();
                    var5.readInt();
                    String var7 = var5.readString();
                    if (var7.equals("ping")) {
                        this.d.printLog("got ping");
                        if (this.d.isServer) {
                            GameOutputStream var8 = new GameOutputStream();
                            var8.writeString("com.corrodinggames.rts");
                            var8.writeInt(this.d.e);
                            var8.writeInt(0);
                            var8.writeString("pong");
                            var8.writeInt(this.d.port);
                            String var9 = var8.toString();
                            DatagramPacket var10 = new DatagramPacket(var9.getBytes(), var9.length(), var2.getAddress(), this.d.t);
                            this.b.send(var10);
                        } else {
                            this.d.printLog("not server");
                        }
                    } else if (!var7.equals("pong")) {
                        this.d.printLog("got pong");
                        ListRoomInfo var13 = new ListRoomInfo();
                        var13.a = true;
                        var13.g = var5.readInt();
                        var13.c = var2.getAddress().toString();
                        var13.j = "" + var6;
                        this.d.a(var13);
                    } else {
                        this.d.printLog("ignoring udp packet: unknown mode:" + var7);
                    }
                }
            }
        } catch (SocketException var11) {
            if (this.a) {
                throw new RuntimeException(var11);
            }

            var11.printStackTrace();
        } catch (IOException var12) {
            throw new RuntimeException(var12);
        }

    }

    public strictfp void a() {
        this.d.printLog("sending ping");
        if (this.b == null) {
            this.d.printLog("failed to send a broadcast ping: datagramSocket is null");
        } else {
            InetAddress var1 = this.d.al();
            if (var1 == null) {
                this.d.printLog("failed to send a broadcast ping: could not get a broadcast address");
            } else {
                try {
                    GameOutputStream var2 = new GameOutputStream();
                    var2.writeString("com.corrodinggames.rts");
                    var2.writeInt(this.d.e);
                    var2.writeInt(0);
                    var2.writeString("ping");
                    String var3 = var2.toString();
                    this.d.printLog("sending ping on :" + var1.toString());
                    DatagramPacket var4 = new DatagramPacket(var3.getBytes(), var3.length(), var1, this.d.t);
                    this.b.send(var4);
                } catch (IOException var5) {
                    var5.printStackTrace();
                    this.d.printLog("failed to send a broadcast ping, IOException");
                }
            }
        }
    }

    public strictfp void b() {
        this.a = false;
        if (this.b != null) {
            this.b.close();
        }

        if (this.c != null) {
            this.c.cancel();
        }

    }
}
