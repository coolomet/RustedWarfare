package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import java.io.BufferedReader;
import java.net.UnknownHostException;
import java.util.List;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.u
class class_181 implements Runnable {
    int a;
    List b;
    class_219 c;
    String d;
    boolean e;

    public class_181(List var1, class_219 var2, String var3, boolean var4, int var5) {
        this.a = var5;
        this.b = var1;
        this.c = var2;
        this.d = var3;
        this.e = var4;
    }

    public void run() {
        GameEngine var1 = GameEngine.getGameEngine();

        try {
            if (GameNetAPIOperate.a) {
                GameEngine.b("LoadFromMasterServer", this.a + ": Started doSingleRequest");
            }

            BufferedReader var2 = GameNetAPIOperate.a(this.b, this.d, this.e).a;
            if (GameNetAPIOperate.a) {
                GameEngine.b("LoadFromMasterServer", this.a + ": Ended doSingleRequest");
            }

            this.c.a(var2, this.a, this.d);
        } catch (Exception var7) {
            var7.printStackTrace();
            String var3 = class_340.a(var7, true);
            if (var7 instanceof UnknownHostException) {
                var3 = "DNS lookup failed, check your internet connection";
            }

            if (var3 != null && var3.contains("Cleartext HTTP traffic")) {
                var3 = var3 + " ( Broken apk file? - " + var1.l() + ")";
            }

            this.c.d = "#" + this.a + ": " + var3;
            String var4 = "Error getting game list from server #" + this.a;
            GameEngine.log(var4);
            if (var1.p()) {
                var1.log("Error getting game list from server #" + this.a, 1);
            }
        }

        synchronized(this.c) {
            --this.c.f;
            if (this.c.f == 0) {
                this.c.a();
            }

        }
    }
}
