package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;
import java.net.Socket;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.an
public strictfp class class_1016 implements Runnable {
    String a;
    boolean b;
    boolean c;
    Thread d;
    public String e;
    Runnable f;
    public Socket g;
    boolean h = false;

    public class_1016(String var1, boolean var2, Runnable var3) {
        this.a = var1;
        this.b = var2;
        this.f = var3;
    }

    public strictfp boolean a() {
        if (!this.c) {
            return false;
        } else {
            this.h = true;
            return true;
        }
    }

    public strictfp void b() {
        this.c = true;
        this.d = new Thread(this);
        this.d.start();
    }

    public strictfp void run() {
        try {
            this.g = GameNetEngine.getSocketAndResolveIp(this.a, this.b);
            return;
        } catch (Exception ex) {
            if (ex instanceof IOException) {
                String var2 = ex.getMessage();
                this.e = var2;
                ex.printStackTrace();
            } else if (ex instanceof class_980) {
                GameEngine.log("Cancelled connectSocketToServer");
                this.e = "CANCELLED";
                return;
            }
        } finally {
            this.c = false;
            if (this.h) {
                if (this.g != null) {
                    try {
                        this.g.close();
                        this.g = null;
                        this.e = "cancelled";
                    } catch (IOException var13) {
                        var13.printStackTrace();
                    }
                }
            } else {
                this.f.run();
            }

        }

    }
}
