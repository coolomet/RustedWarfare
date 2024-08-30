package com.corrodinggames.rts.gameFramework.net;

import java.io.IOException;
import java.util.TimerTask;

class PingTask extends TimerTask {
    private final GameNetEngine gameNetEngine;
    public boolean a = true;
    public long b = 0L;

    PingTask(GameNetEngine var1) {
        this.gameNetEngine = var1;
    }

    public void run() {
        try {
            long var1 = System.currentTimeMillis();
            if (this.gameNetEngine.au != 0L && (var1 > this.gameNetEngine.au + 5L || var1 < this.gameNetEngine.au)) {
                this.gameNetEngine.au = 0L;
                this.gameNetEngine.Q();
            }

            if (var1 > this.b + 1000L || var1 < this.b) {
                this.b = var1;
                if (this.a) {
                    GameOutputStream var3 = new GameOutputStream();
                    var3.writeLong(System.currentTimeMillis());
                    var3.writeByte(0);
                    Packet var4 = var3.getPacket(108);
                    this.gameNetEngine.sendPacket(var4);
                } else {
                    this.gameNetEngine.P();
                }

                this.a = !this.a;
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }
}
