package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import lombok.SneakyThrows;
import net.rudp.ReliableServerSocket;
import net.rudp.class_766;

public strictfp class ServerAcceptRunnable implements Runnable {
    public final boolean a = false;
    public static boolean b = true;
    private final GameNetEngine netEngine;
    volatile boolean c = true;
    ServerSocket serverSocket;
    int port;
    boolean f;
    long g = -1L;
    final boolean h = false;
    final boolean i = true;
    final Object j = new Object();
    ArrayList k = new ArrayList();
    final Object l = new Object();
    int m = 0;
    int n = 0;
    boolean o;
    boolean p;
    boolean q;

    ServerAcceptRunnable(GameNetEngine var1) {
        this.netEngine = var1;
    }

    public strictfp boolean a(InetAddress var1, boolean var2) {
        if (var1 == null) {
            GameEngine.log("isIpAllowed: inetAddress==null");
            return true;
        } else if (!b) {
            return true;
        } else {
            long var3 = System.currentTimeMillis();
            if (var3 > this.g + 60000L) {
                this.g = var3;
                synchronized(this.l) {
                    this.k.clear();
                }

                this.m = 0;
                this.n = 0;
                this.o = false;
                this.p = false;
                this.q = false;
            }

            Iterator var7;
            synchronized(this.l) {
                boolean var6 = false;
                var7 = this.k.iterator();

                while(var7.hasNext()) {
                    ServerAcceptData var8 = (ServerAcceptData)var7.next();
                    if (var1.equals(var8.a)) {
                        ++var8.b;
                        byte var9 = 30;
                        if (this.n > 100) {
                            var9 = 10;
                        }

                        if (this.n > 250) {
                            var9 = 5;
                        }

                        if (var8.b > var9) {
                            if (!var8.c) {
                                var8.c = true;
                                GameEngine.log("DOS: Too many attempts:" + var8.b + " ip:" + var1.toString());
                            }

                            if (var8.b > 300 && !var8.d) {
                                var8.d = true;
                                GameEngine.log("DOS: Excessive attempts:" + var8.b + " ip:" + var1.toString());
                            }

                            return false;
                        }

                        var6 = true;
                        break;
                    }
                }

                if (!var6) {
                    if (var2) {
                        ++this.m;
                    }

                    ServerAcceptData var14;
                    if (this.k.size() > 200) {
                        var14 = null;
                        Iterator var15 = this.k.iterator();

                        label128:
                        while(true) {
                            ServerAcceptData var18;
                            do {
                                if (!var15.hasNext()) {
                                    if (var14 != null) {
                                        this.k.remove(var14);
                                    }
                                    break label128;
                                }

                                var18 = (ServerAcceptData)var15.next();
                            } while(var14 != null && var14.b <= var18.b);

                            var14 = var18;
                        }
                    }

                    var14 = new ServerAcceptData(this);
                    var14.a = var1;
                    this.k.add(var14);
                }
            }

            if (this.m > 500) {
                if (!this.p) {
                    this.p = true;
                    GameEngine.log("DOS: Too many unique attempts: " + this.m + ". udp:" + this.f);
                }

                return false;
            } else {
                int var5 = 0;
                int var13 = 0;
                var7 = this.netEngine.socketList.iterator();

                while(var7.hasNext()) {
                    PlayerConnect var17 = (PlayerConnect)var7.next();
                    ++var13;
                    if (var17.e != null && var1.equals(var17.e)) {
                        ++var5;
                    }
                }

                byte var16 = 20;
                if (var13 > 150) {
                    var16 = 10;
                }

                if (var13 > 200) {
                    var16 = 5;
                }

                if (var5 > var16) {
                    if (!this.q) {
                        this.q = true;
                        GameEngine.log("DOS: Too open connections from same ip:" + var1.toString() + " (count:" + var5 + ") max:" + var16);
                    }

                    return false;
                } else if (var13 > 300) {
                    if (!this.o) {
                        this.o = true;
                        GameEngine.log("DOS: Too open connections locking down:" + var1.toString() + " (count:" + var13 + ")");
                    }

                    return false;
                } else {
                    ++this.n;
                    return true;
                }
            }
        }
    }

    @SneakyThrows
    public strictfp void a() {
        this.netEngine.printLog("Recreating server socket " + (this.f ? "udp" : "tcp"));
        synchronized(this.j) {
            if (this.serverSocket != null) {
                try {
                    this.serverSocket.close();
                } catch (IOException var4) {
                    var4.printStackTrace();
                }

                this.serverSocket = null;
            }

            if (!this.c) {
                throw new IOException("recreate on non-active socket");
            } else {
                this.startServerSocket(this.f);
            }
        }
    }

    @SneakyThrows
    public strictfp void startServerSocket(boolean var1) {
        this.port = this.netEngine.port;
        this.netEngine.printLog("starting socket.. " + (var1 ? "udp" : "tcp") + " port: " + this.port);
        this.f = var1;
        if (!var1) {
            this.serverSocket = new ServerSocket(this.port);
        } else {
            ReliableServerSocket var2 = new ReliableServerSocket(this.netEngine.port, 0, (InetAddress)null, true);
            var2.a((class_766)(new ServerAcceptRunnable$1(this)));
            this.serverSocket = var2;
        }

    }

    public strictfp void run() {
        GameEngine.aq();
        Thread.currentThread().setName("NewConnectionWorker-" + (this.f ? "udp" : "tcp") + " - " + this.port);
        int var1 = 0;
        int var2 = 0;
        this.netEngine.printLog("reading..");

        while(this.c) {
            Socket var3;
            String var7;
            try {
                var3 = this.serverSocket.accept();
            } catch (IOException var10) {
                if (!this.c) {
                    GameEngine.log("ServerSocket-accept(" + (this.f ? "udp" : "tcp") + "): Got expected IOException after closed socket");
                    break;
                }

                GameEngine var5 = GameEngine.getGameEngine();
                ++var1;
                GameEngine.log("ServerSocket-accept(" + (this.f ? "udp" : "tcp") + ") failed: " + var10.getMessage() + " (closed:" + this.serverSocket.isClosed() + ")");
                if (var1 > 100) {
                    GameEngine.log("Too many server socket fails");
                    this.b();
                    return;
                }

                try {
                    this.a();
                } catch (Exception var9) {
                    var9.printStackTrace();
                    GameEngine.getGameEngine().i("Warning server socket got closed and could not be recreated");
                    this.b();
                    return;
                }

                if (var2 < 3) {
                    int var6 = var5.netEngine.D();
                    if (var6 > 0) {
                        var7 = "Warning: server socket got closed and needed to be recreated, players were likely disconnected (but can rejoin).";
                        if (GameEngine.aZ) {
                            var7 = var7 + "\n This likely due to iOS removing sockets of background apps. Avoid minimising the game when hosting.";
                        }

                        GameEngine.getGameEngine().i(var7);
                        ++var2;
                    }
                }
                continue;
            }

            try {
                var3.setTcpNoDelay(true);
                var3.setSoTimeout(15000);
                String var4 = "<unknown>";
                InetAddress var11 = var3.getInetAddress();
                if (var11 != null) {
                    var4 = var11.getHostAddress();
                }

                if (!this.a(var11, true)) {
                    var3.close();
                } else {
                    PlayerConnect var12 = new PlayerConnect(this.netEngine, var3);
                    var7 = "Accepted new connection id:" + var12.connectIndex + ".. (ip:" + var4 + ")";
                    if (this.f) {
                        var7 = var7 + " (udp)";
                    }

                    this.netEngine.printLog(var7);
                    var12.h = this.f;
                    var12.e = var11;
                    var12.d();
                    this.netEngine.socketList.add(var12);
                }
            } catch (IOException var8) {
                GameEngine.log("Got IOException on new player connection");
                var8.printStackTrace();
            }
        }

    }

    public strictfp void b() {
        synchronized(this.j) {
            this.c = false;
            if (this.serverSocket != null) {
                try {
                    this.serverSocket.close();
                } catch (IOException var4) {
                    var4.printStackTrace();
                }

                this.serverSocket = null;
            }

        }
    }
}
