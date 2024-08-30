package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.appFramework.class_195;
import com.corrodinggames.rts.game.Player;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public strictfp class PlayerConnect {
    private final GameNetEngine gameNetEngine;
    volatile boolean a = false;
    volatile boolean b = false;
    public int connectIndex;
    public Socket socket;
    InetAddress e;
    ConcurrentLinkedQueue f = new ConcurrentLinkedQueue();
    public long g;
    public boolean h;
    public boolean i;
    public PlayerConnect j;
    public int k = -1;
    Packet l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean desyncCountFlag;
    public boolean fastSyncFlag;
    public int x;
    public int desyncCount;
    public Player player;
    int A = -1;
    long B = -1L;
    boolean C = false;
    boolean D = false;
    public int clientVersion = 999999;
    ReciveSocketInStream inStream;
    SendSocketOutStream outStream;
    Thread inStreamThread;
    Thread outStreamThread;
    boolean J = false;
    boolean K = false;
    public String L;
    public int connectKey;
    public boolean N;
    public boolean O;
    public int P;
    public boolean Q;
    public int R;
    public long S;
    public boolean T;
    volatile int U;
    volatile int V;

    public PlayerConnect(GameNetEngine var1, Socket var2) {
        this.gameNetEngine = var1;
        this.socket = var2;
        synchronized(this.gameNetEngine.indexSync) {
            this.connectIndex = this.gameNetEngine.connectIndex++;
        }

        this.connectKey = class_340.rand(1, 1000000);
    }

    public strictfp boolean a() {
        if (this.S < System.currentTimeMillis() - 10000L) {
            this.S = System.currentTimeMillis();
            this.R = 0;
        }

        if (this.R > 100) {
            if (!this.T) {
                this.T = true;
                this.c("Command limit was reached");
            }

            return true;
        } else {
            ++this.R;
            return false;
        }
    }

    public strictfp int b() {
        if (this.B == -1L) {
            return -2;
        } else {
            return this.B < System.currentTimeMillis() - 5000L ? -1 : this.A;
        }
    }

    strictfp int c() {
        Player var1 = this.player;
        return var1 != null ? var1.site : -1;
    }

    public strictfp synchronized void d() {
        this.outStream = new SendSocketOutStream(this);
        this.outStreamThread = new Thread(this.outStream);
        this.outStreamThread.setDaemon(true);
        this.outStreamThread.start();
        this.inStream = new ReciveSocketInStream(this, (PlayerConnect$1)null);
        this.inStreamThread = new Thread(this.inStream);
        this.inStreamThread.setDaemon(true);
        this.inStreamThread.start();
    }

    private strictfp void i() {
        this.a = true;
        if (this.gameNetEngine.isServer && !this.gameNetEngine.n()) {
            Player var1 = this.player;
            if (var1 != null) {
                this.player = null;
                PlayerConnect var2 = this.gameNetEngine.d((PlayerData)var1);
                if (var2 == null) {
                    var1.I();
                    this.gameNetEngine.P();
                    class_195.o();
                }
            }
        }

        if (this.inStreamThread != null) {
            this.inStreamThread.interrupt();
        }

        this.gameNetEngine.b(this);
        this.p = false;
        if (this.q) {
            this.gameNetEngine.c(this, "Closing");
        }

    }

    private strictfp synchronized void j() {
        if (!this.a) {
            this.b = true;
            if (this.outStream != null) {
                this.outStream.a();
            }

            if (this.inStreamThread != null) {
                this.inStreamThread.interrupt();
            }

            this.gameNetEngine.b(this);
        }
    }

    public strictfp void a(String var1) {
        GameOutputStream var2 = new GameOutputStream();

        try {
            if (var1 == null) {
                var1 = "NULL";
            }

            var2.writeString(var1);
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }

        this.a(var2.getPacket(111));
        this.j();
    }

    private strictfp synchronized void a(boolean var1, boolean var2) {
        this.a(var1, var2, "Time out");
    }

    public strictfp String getName() {
        String var1 = "<null>";
        if (this.player != null) {
            var1 = this.player.name;
        }

        return var1;
    }

    public strictfp String f() {
        if (this.j != null) {
            return this.n;
        } else {
            try {
                Socket var1 = this.socket;
                if (var1 != null) {
                    InetAddress var2 = var1.getInetAddress();
                    if (var2 != null) {
                        return var2.getHostAddress();
                    }
                }

                return null;
            } catch (Exception var3) {
                var3.printStackTrace();
                return null;
            }
        }
    }

    public strictfp String g() {
        if (this.j != null) {
            return this.n == null ? "<forwarded unknown>" : this.n;
        } else {
            String var1 = "<no socket>";

            try {
                Socket var2 = this.socket;
                if (var2 != null) {
                    var1 = "<no bond socket>";
                    InetAddress var3 = var2.getInetAddress();
                    if (var3 != null) {
                        var1 = var3.getHostAddress();
                    }
                }

                return var1;
            } catch (Exception var4) {
                var4.printStackTrace();
                return "<socket error>";
            }
        }
    }

    public strictfp synchronized void a(boolean var1, boolean var2, String var3) {
        if (!this.a) {
            this.c("handleRemoteDisconnect");
            String var4 = null;
            if (this.player != null) {
                var4 = this.player.name;
            }

            String var5 = null;
            if (this.player != null) {
                String var6 = "player";
                String var7 = "";
                if (this.player.b()) {
                    var6 = "spectator";
                } else if (this.gameNetEngine.ingame) {
                    int var8 = this.player.a(false, false);
                    if (var8 == 0) {
                        var7 = " (Had no units)";
                    } else {
                        var7 = " (Team " + this.player.getPlayerTeamName() + ")";
                    }
                }

                var5 = var6 + " '" + this.player.name + "' disconnected" + var7;
            } else if (this.p) {
                if (this.s && this.q) {
                    var5 = "relay server disconnected";
                } else {
                    var5 = "a player disconnected";
                }
            }

            if (!this.gameNetEngine.isServer) {
                var5 = "The server disconnected";
            }

            if (var5 != null && var3 != null) {
                var5 = var5 + "  (" + GameNetEngine.i(var3) + ")";
            }

            this.i();
            if (var5 != null) {
                boolean var10 = false;
                if (this.player != null && this.gameNetEngine.isServer) {
                    PlayerConnect var11 = this.gameNetEngine.d((PlayerData)this.player);
                    if (var11 != null) {
                        var10 = true;
                    }
                }

                if (!var10) {
                    if (!this.gameNetEngine.isServer) {
                        this.gameNetEngine.f(var5);
                    } else {
                        this.gameNetEngine.j(var5);
                    }
                } else {
                    this.c("Not sending: '" + var5 + "' still another active connection");
                }
            }

            this.gameNetEngine.d.b(this, var4);
        } else {
            this.c("handleRemoteDisconnect: connection is already disconnecting");
        }

        if (!var2 && this.outStream != null) {
            this.outStream.a();
        }

        if (var2) {
            this.J = true;
        }

        if (var1) {
            this.K = true;
        }

        if (this.J && this.K) {
            try {
                this.socket.close();
            } catch (IOException var9) {
                GameEngine.a((String)"Error while closing network socket", (Throwable)var9);
            }

            this.outStreamThread = null;
            this.inStreamThread = null;
            this.outStream = null;
            this.inStream = null;
            if (this.f != null) {
                this.f.clear();
            }
        }

    }

    public strictfp void a(String var1, Throwable var2) {
        GameEngine.a(this.d(var1), var2);
    }

    public strictfp void b(String var1) {
        GameEngine.print(this.d(var1));
    }

    public strictfp void c(String var1) {
        GameEngine.log(this.d(var1));
    }

    public strictfp String d(String var1) {
        var1 = "id:" + this.connectIndex + ": " + var1;
        Player var2 = this.player;
        if (var2 != null) {
            var1 = var1 + " (Player:" + var2.name + ")";
        }

        return var1;
    }

    public strictfp void a(Packet var1) {
        if (this.outStream != null || !this.a) {
            this.outStream.a(var1);
        }
    }

    public strictfp boolean h() {
        return !this.a;
    }

    public strictfp void finalize() {
        try {
            if (this.socket == null || this.socket.isClosed()) {
                return;
            }

            GameEngine.log("Connection::finalize called on unclosed socket (index:" + this.connectIndex + ")");
            if (this.socket.getInetAddress() == null) {
                GameEngine.log("Skipping possible steam socket");
            }

            try {
                this.socket.close();
            } catch (IOException var2) {
                var2.printStackTrace();
            }
        } catch (RuntimeException var3) {
            var3.printStackTrace();
        }

    }

    // $FF: synthetic method
    static void a(PlayerConnect var0, boolean var1, boolean var2) {
        var0.a(var1, var2);
    }

    // $FF: synthetic method
    static GameNetEngine a(PlayerConnect var0) {
        return var0.gameNetEngine;
    }
}
