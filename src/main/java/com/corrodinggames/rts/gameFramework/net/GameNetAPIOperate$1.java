package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.List;
import java.util.concurrent.Callable;

final class GameNetAPIOperate$1 implements Callable {
    // $FF: synthetic field
    final String a;
    // $FF: synthetic field
    final List b;
    // $FF: synthetic field
    final boolean c;
    // $FF: synthetic field
    final boolean d;

    GameNetAPIOperate$1(String var1, List var2, boolean var3, boolean var4) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
        this.d = var4;
    }

    public class_182 a() {
        try {
            GameNetAPIOperate.a("Running doSingleRequest:" + this.a);
            return GameNetAPIOperate.a(this.b, this.a, this.c);
        } catch (Exception var2) {
            GameEngine.log("Error on doSingleRequest:" + this.a + " - " + var2.getMessage());
            if (this.d) {
                var2.printStackTrace();
            }

            return null;
        }
    }

    // $FF: synthetic method
    public Object call() {
        return this.a();
    }
}
