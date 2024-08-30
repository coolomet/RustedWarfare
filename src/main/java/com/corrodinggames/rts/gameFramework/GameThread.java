package com.corrodinggames.rts.gameFramework;

import android.os.Process;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.z
public strictfp class GameThread extends Thread {
    static int a = 0;
    public boolean b = true;
    long c;

    public strictfp synchronized void a(boolean var1) {
        this.b = var1;
    }

    public GameThread() {
        super("GameThread" + a);
        ++a;
    }

    public strictfp void run() {
        GameEngine.aq();
        if (!GameEngine.isModsInSD) {
            Process.setThreadPriority(-4);
        }

        float var1 = 1.0F;
        this.a();
        long var2 = this.c;
        GameEngine var4 = GameEngine.getGameEngine();

        while(true) {
            long var10;
            do {
                if (!this.b) {
                    return;
                }

                long var5 = System.nanoTime();
                var2 = this.c;
                this.a();
                var1 = (float)(this.c - var2) * 0.060000002F;
                int var7 = (int)(this.c - var2);
                var4.a(var1, var7);
                if (!var4.settingsEngine.batterySaving) {
                }

                long var8;
                if (var4.settingsEngine.batterySaving) {
                    var8 = 32258064L;
                } else if (var4.settingsEngine.highRefreshRate) {
                    var8 = 3333333L;
                } else {
                    var8 = 16393442L;
                }

                var10 = (long)Math.round((float)(var8 - (System.nanoTime() - var5)));
            } while(var10 <= 0L);

            long var12 = System.nanoTime();

            while(true) {
                long var14 = System.nanoTime() - var12;
                if (var14 > var10 || var14 < 0L) {
                    break;
                }

                long var16 = (long)((double)(var10 - var14) / 1000000.0);
                if (var16 <= 1L) {
                    break;
                }

                try {
                    Thread.sleep(var16);
                } catch (Exception var19) {
                }
            }
        }
    }

    public strictfp void a() {
        this.c = System.currentTimeMillis();
    }
}
