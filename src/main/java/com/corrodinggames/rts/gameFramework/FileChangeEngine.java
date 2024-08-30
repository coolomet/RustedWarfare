package com.corrodinggames.rts.gameFramework;

import java.io.File;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

public strictfp class FileChangeEngine {
    static ConcurrentHashMap a = new ConcurrentHashMap();
    static AutoUpdateModLastModified b;

    public static long a(String var0, boolean var1) {
        Long var2 = (Long)a.get(var0);
        if (var2 != null) {
            return var2;
        } else {
            var2 = a(var0);
            if (!var1) {
                a.put(var0, var2);
                if (b == null) {
                }
            }

            return var2;
        }
    }

    private static long a(String var0) {
        File var1 = new File(var0);
        return var1.lastModified();
    }

    public static synchronized void a() {
        startFileChangeEngine(GameEngine.getGameEngine().settingsEngine.liveReloading);
    }

    public static synchronized void startFileChangeEngine(boolean var0) {
        if (GameEngine.av()) {
            if (var0) {
                if (b != null) {
                    GameEngine.log("FileChangeEngine: Already running");
                    return;
                }

                GameEngine.log("FileChangeEngine: Starting");
                b = new AutoUpdateModLastModified();
                b.start();
            } else if (b != null) {
                b.a = false;
                b = null;
            }

        }
    }

    public static void writeLastModified() {
        int var0 = 0;
        Enumeration var1 = a.keys();

        while(var1.hasMoreElements()) {
            String var2 = (String)var1.nextElement();
            long var3 = a(var2);
            Long var5 = (Long)a.get(var2);
            if (var5 == null) {
                GameEngine.log("FileChangeEngine: old lastModified null for " + var2);
            } else if (var5 != var3) {
                GameEngine.log("FileChangeEngine: Detected change to:" + var2 + " now " + var3);
            }

            a.put(var2, var3);
            ++var0;
            if (var0 > 50) {
                var0 = 0;

                try {
                    Thread.sleep(2L);
                } catch (InterruptedException var7) {
                }
            }
        }

    }
}
