package com.corrodinggames.rts.gameFramework;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

class RelaySaveRunnable implements Runnable {
    volatile boolean a;
    volatile int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    boolean h;
    public ConcurrentLinkedQueue i;
    public long j;
    // $FF: synthetic field
    final ReplayEngine k;

    RelaySaveRunnable(ReplayEngine var1) {
        this.k = var1;
        this.a = true;
        this.h = false;
        this.i = new ConcurrentLinkedQueue();
        this.j = 0L;
    }

    public strictfp synchronized void a(class_967 var1) {
        if (this.h) {
            GameEngine.log("Replay:addCommand skipped due to stopped recording");
        }

        this.i.add(var1);
        this.f = var1.a;
        if (var1.e != null) {
            ++this.k.A;
        }

        if (var1.f != null) {
            ++this.k.B;
        }

        this.notifyAll();
    }

    public strictfp synchronized void a() {
        this.a = false;
        GameEngine var1 = GameEngine.getGameEngine();
        ReplayEngine.a("stop requested at:" + var1.tick);
        if (!ReplayEngine.a(this.k)) {
            ReplayEngine.a("Replay stop: warning: active==false");
        }

        if (this.k.u) {
            ReplayEngine.a("Replay stop: warning: replaying==true");
        }

        this.b = var1.tick;
        this.c = var1.by;
        this.d = this.k.A;
        this.e = this.k.B;
        if (this.b < this.f) {
            GameEngine.log("Replay: stoppedFrame<lastCommandFrame: " + this.b + "<" + this.f);
            this.b = this.f;
        }

        this.j = 0L;
        this.notifyAll();
    }

    private strictfp synchronized void b() {
        try {
            if (this.a) {
                this.wait();
            }
        } catch (InterruptedException var2) {
        }

    }

    public strictfp void run() {
        GameEngine.aq();

        while(this.a) {
            if (this.i.size() > 0) {
                class_967 var1 = (class_967)this.i.remove();

                try {
                    if (var1.e != null) {
                        this.k.J.e("rc");
                        this.k.J.writeInt(var1.a);
                        var1.e.write(this.k.J);
                        this.k.J.endBlock("rc");
                        this.g = var1.a;
                    } else if (var1.c != null) {
                        this.k.J.e("cs");
                        this.k.J.writeInt(var1.a);
                        this.k.J.writeLong(var1.c);
                        this.k.J.endBlock("cs");
                    } else if (var1.d != null) {
                        this.k.J.e("wait");
                        this.k.J.writeInt(var1.a);
                        this.k.J.endBlock("wait");
                        this.k.J.e("es");
                        this.k.J.writeInt(var1.a);
                        this.k.J.a(var1.d);
                        this.k.J.endBlock("es");
                    } else if (var1.f != null) {
                        this.k.J.e("wait");
                        this.k.J.writeInt(var1.a);
                        this.k.J.endBlock("wait");
                        this.k.J.e("resync");
                        this.k.J.writeInt(var1.a);
                        this.k.J.writeInt(var1.h);
                        this.k.J.writeInt(var1.i);
                        this.k.J.writeFloat(var1.j);
                        this.k.J.writeFloat(var1.k);
                        this.k.J.a(var1.f);
                        this.k.J.endBlock("resync");
                    } else {
                        if (var1.g == null) {
                            throw new RuntimeException("Unknown saved command");
                        }

                        this.k.J.e("chat");
                        this.k.J.writeInt(var1.a);
                        this.k.J.writeInt(var1.g.a);
                        this.k.J.writeIsString(var1.g.b);
                        this.k.J.writeIsString(var1.g.c);
                        this.k.J.endBlock("chat");
                    }

                    if (this.j == 0L || this.j + 3000L < System.currentTimeMillis()) {
                        this.j = System.currentTimeMillis();
                        this.k.J.flashAll();
                    }
                } catch (Exception var5) {
                    GameEngine var3 = GameEngine.getGameEngine();
                    GameEngine.a((String)"Replay error", (Throwable)var5);
                    var3.bS.h.a("", "IO error recording replay, disabling record");
                    ReplayEngine.a(this.k, false);
                    this.h = true;
                    return;
                }
            }

            if (this.i.size() == 0) {
                this.b();
            }
        }

        try {
            this.k.J.e("wait");
            this.k.J.writeInt(this.b);
            this.k.J.endBlock("wait");
            this.k.J.e("end");
            this.k.J.endBlock("end");
            this.k.J.e("endReplayMetaData");
            this.k.J.writeByte(0);
            this.k.J.writeInt(this.b);
            this.k.J.writeInt(this.c);
            this.k.J.writeInt(this.d);
            this.k.J.writeInt(this.e);
            this.k.J.writeString("{frames:" + this.b + ",time:" + this.c + ",commandCount:" + this.d + ",resyncCount:" + this.e + "}");
            this.k.J.endBlock("endReplayMetaData");
            this.k.J.flashAll();
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }

        ReplayEngine.a("Background writer stopping");
        ReplayEngine.a("Remainding commands: " + this.i.size());
        ReplayEngine.a("last command: " + this.f);
        ReplayEngine.a("last command write: " + this.g);
        ReplayEngine.a("Commands issued: " + this.d);
        this.h = true;
    }
}
