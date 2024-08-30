package com.corrodinggames.rts.gameFramework.net;

final class GameNetEngine$2 extends class_184 {
    // $FF: synthetic field
    final Object d;

    GameNetEngine$2(Object var1) {
        this.d = var1;
    }

    public strictfp void a(String var1) {
        super.a(var1);
        synchronized(this.d) {
            this.d.notify();
        }
    }

    public strictfp void a(String var1, GameConnectStatusType var2, Exception var3) {
        super.a(var1, var2, var3);
        synchronized(this.d) {
            this.d.notify();
        }
    }
}
