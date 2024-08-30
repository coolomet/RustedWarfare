package com.corrodinggames.rts.debug;

import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.librocket.scripts.ScriptEngine$Action;
import com.corrodinggames.rts.a.class_835;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

public strictfp class ScriptServerSocket implements Runnable {
    public ServerSocket a;
    public boolean b = true;
    public static boolean c = false;
    public static boolean d = false;
    static ArrayList e = new ArrayList();

    public static strictfp boolean a() {
        return c;
    }

    public static strictfp void addScriptFilePath(String var0) {
        c = true;
        e.add(var0);
    }

    public static strictfp void b() {
        if (e.size() != 0) {
            ScriptServerSocket$1 var0 = new ScriptServerSocket$1();
            Thread var1 = new Thread(var0);
            var1.start();
        }
    }

    public static strictfp void a(int var0, String var1) {
        try {
            c = true;
            GameEngine.aT = true;
            ScriptServerSocket var2 = new ScriptServerSocket();
            if (var0 != -1) {
                var2.a = new ServerSocket(var0);
                Thread var3 = new Thread(var2);
                var3.start();
            }

        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }

    private ScriptServerSocket() {
    }

    public strictfp void run() {
        try {
            while(this.b) {
                Socket var1 = this.a.accept();

                try {
                    var1.setTcpNoDelay(true);
                    class_835 var2 = new class_835(this, var1);
                    Thread var3 = new Thread(var2);
                    var3.run();
                } catch (IOException var4) {
                    GameEngine.log("Got IOException on debugSocket connection");
                    var4.printStackTrace();
                    throw new RuntimeException(var4);
                }
            }

        } catch (IOException var5) {
            throw new RuntimeException(var5);
        }
    }

    public static strictfp String b(String var0) {
        String var2 = null;
        String[] var3 = null;
        int var4 = var0.indexOf(" ");
        if (var4 == -1) {
            var4 = var0.length();
        }

        String var1 = var0.substring(0, var4).toLowerCase(Locale.ENGLISH);
        if (var4 != -1 && var0.length() >= var4 + 1) {
            var2 = var0.substring(var4 + 1);
            var3 = var2.split(" ");
        }

        if (ScriptEngine.getInstance() == null) {
            GameEngine.print("DebugSocketConnection: waiting for ScriptEngine to start....");

            for(int var5 = 0; var5 < 100; ++var5) {
                if (ScriptEngine.getInstance() != null) {
                    GameEngine.print("started");
                    break;
                }

                try {
                    Thread.sleep(100L);
                } catch (InterruptedException var12) {
                    var12.printStackTrace();
                }
            }
        }

        if (var1.equalsIgnoreCase("ping")) {
            return "pong";
        } else if (var1.equalsIgnoreCase("crash")) {
            throw new RuntimeException("test crash");
        } else {
            ScriptEngine var13;
            if (var1.equalsIgnoreCase("script")) {
                if (var2 == null) {
                    return "argString==null";
                } else {
                    var13 = ScriptEngine.getInstance();
                    ScriptEngine$Action var6 = var13.addScriptToQueue(var2);
                    boolean var14 = false;
                    String var15 = var6.waitForCompletionOrCrash(var14);
                    return var15 == null ? "done" : var15;
                }
            } else if (!var1.equalsIgnoreCase("function") && !var1.equalsIgnoreCase("functionNoTimeout")) {
                return "unknown command";
            } else if (var2 == null) {
                return "argString==null";
            } else {
                var13 = ScriptEngine.getInstance();
                ScriptServerSocket$2 var7 = new ScriptServerSocket$2(var13, var2);
                ScriptEngine$Action var8 = var13.addRunnableToQueue(var7);
                var8.tryToCatchCrash = true;
                boolean var9 = false;
                if (var1.equalsIgnoreCase("functionNoTimeout")) {
                    var9 = true;
                }

                String var10 = var8.waitForCompletionOrCrash(var9);
                String var11;
                if (var10 == null) {
                    var11 = "ok\n";
                    if (var7.c == null) {
                        var11 = var11 + "<NULL>";
                    } else {
                        var11 = var11 + "" + var7.c;
                    }

                    var11 = var11 + "\u0000";
                    return var11;
                } else {
                    var11 = "crash\n";
                    var11 = var11 + var10;
                    var11 = var11 + "\u0000";
                    return var11;
                }
            }
        }
    }
}
