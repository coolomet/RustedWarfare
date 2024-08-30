package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.gameFramework.net.GameNetAPIOperate;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.i
public strictfp class class_343 implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;

    class_343(Thread.UncaughtExceptionHandler var1) {
        this.a = var1;
    }

    public synchronized void uncaughtException(Thread var1, Throwable var2) {
        boolean var3 = false;
        boolean var4 = false;
        GameEngine var5 = null;

        try {
            GameEngine.dQ = null;
            GameEngine.dR = null;
            GameEngine.dP = null;
            System.gc();

            try {
                GameEngine.log("uncaughtException start");
                var5 = GameEngine.getGameEngine();
                if (var5 != null && var2 instanceof OutOfMemoryError) {
                    GameEngine.log("Freeing memory");

                    try {
                        class_484.al = null;
                        if (var5.bL != null) {
                            var5.bL = null;
                        }

                        if (var5.bN != null) {
                            var5.bN.i();
                            var5.bN = null;
                        }

                        System.gc();
                        GameEngine.log("uncaughtException: Memory freed");
                    } catch (Throwable var17) {
                        GameEngine.log("exception freeing memory");
                        var17.printStackTrace();
                    }
                }

                GameEngine.a("gameEngine:uncaughtExceptionHandler", var2);
                String var6 = GameEngine.a(var2);
                boolean var7 = false;
                boolean var8 = false;
                if (var5 != null) {
                    SettingsEngine var9 = var5.settingsEngine;
                    if (var9 != null) {
                        var7 = var9.sendReports;
                    } else {
                        GameEngine.log("CustomExceptionHandler: no settings");
                    }
                } else {
                    GameEngine.log("CustomExceptionHandler: no game");
                }

                if (GameEngine.dO) {
                    GameEngine.log("CustomExceptionHandler: a crash was already sent");
                    var7 = false;
                    var8 = true;
                }

                GameEngine.dO = true;
                if (var7) {
                    try {
                        GameEngine.log("Starting errorReport");
                        GameNetAPIOperate.a("uncaughtException", var6);
                        GameEngine.log("waiting");
                        Thread.sleep(800L);
                    } catch (InterruptedException var16) {
                        var16.printStackTrace();
                    }
                }

                if (!var8 && var5 != null && var5.dH != null) {
                    var5.dH.a(var2);
                }

                var4 = true;
                GameEngine.e("fatal", var6);
            } catch (Exception var18) {
                GameEngine.log("exception sending crash");
                var18.printStackTrace();
            }

            if (var5 != null) {
                if (var5.dH != null && var5.dH.a()) {
                    GameEngine.log("gameCrashesDontExit=true");
                    var3 = true;
                    return;
                }

                if (var5.netEngine != null && var5.netEngine.B) {
                    GameEngine.log("Sending disconnect");
                    var5.netEngine.c("Game crash");
                }
            }

            if (!GameEngine.az) {
                if (this.a != null) {
                    GameEngine.log("CustomExceptionHandler: sending to: defaultUEH.uncaughtException");
                    this.a.uncaughtException(var1, var2);
                    GameEngine.log("CustomExceptionHandler: back from: defaultUEH.uncaughtException");
                } else {
                    GameEngine.log("CustomExceptionHandler: defaultUEH==null");
                    System.exit(2);
                }
            }

            GameEngine.av = var2;
            var3 = true;
        } catch (Throwable var19) {
            GameEngine.log("Exception in uncaughtException");
            var19.printStackTrace();
        } finally {
            if (!var3) {
                GameEngine.log("Crash was not handled, exiting");
                Runtime.getRuntime().halt(1);
            }

        }

    }
}
