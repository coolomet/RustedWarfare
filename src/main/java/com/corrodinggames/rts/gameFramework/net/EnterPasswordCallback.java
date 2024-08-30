package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;

public strictfp class EnterPasswordCallback {
    public String b;
    public int c;
    public boolean d;
    public String e;
    public String f;
    public String g;

    public strictfp void a(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.d) {
            GameOutputStream var3;
            try {
                var3 = new GameOutputStream();
                var3.writeByte(1);
                var3.writeInt(this.c);
                var3.writeString(var1);
            } catch (Exception var5) {
                throw new RuntimeException(var5);
            }

            Packet var4 = var3.getPacket(118);
            var2.netEngine.d(var4);
        } else if (var2.netEngine.isServer) {
            GameEngine.a("Cannot enter a password when we are a server");
        } else {
            var2.netEngine.passwd = var1;
            var2.netEngine.X();
        }
    }

    public strictfp void a() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.netEngine.closeServer("exited password");
        var1.netEngine.K();
    }
}
