package com.corrodinggames.rts.gameFramework.c;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.c.a
public strictfp class class_39 implements Runnable {
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static float e;
    boolean f = true;
    public static boolean g = true;
    public ServerSocket h;
    public boolean i = true;
    static ArrayList j = new ArrayList();

    public static void a() {
        if (a) {
            GameEngine.log("-----");
            GameEngine.log("-----");
            GameEngine.log("----- Debug Active ----");
            GameEngine.log("-----");
            GameEngine.log("-----");
            GameEngine.aV = true;
            GameEngine.getGameEngine().s();
            class_39 var0 = new class_39();
            var0.b();
        }
    }

    public void b() {
        if (b) {
            this.a(5677, "");
        }

        GameEngine.getGameEngine().eb.a(new class_46(this));
    }

    public void a(int var1, String var2) {
        try {
            g = true;
            GameEngine.aT = true;
            GameEngine.log("");
            GameEngine.log("----- createDebugSocket ----");
            GameEngine.log("port: " + var1);
            GameEngine.log("password: " + var2);
            GameEngine.log("------------------");
            GameEngine.log("");
            if (var1 != -1) {
                this.h = new ServerSocket(var1);
                Thread var3 = new Thread(this);
                var3.start();
            }

        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }

    private class_39() {
    }

    public void run() {
        try {
            while(this.i) {
                Socket var1 = this.h.accept();

                try {
                    var1.setTcpNoDelay(true);
                    class_45 var2 = new class_45(this, var1);
                    Thread var3 = new Thread(var2);
                    var3.run();
                } catch (IOException var4) {
                    GameEngine.log("Got IOException on debug connection");
                    var4.printStackTrace();
                    throw new RuntimeException(var4);
                }
            }

        } catch (IOException var5) {
            throw new RuntimeException(var5);
        }
    }

    public static String a(String var0) {
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

        if (var1.equalsIgnoreCase("ping")) {
            return "pong";
        } else if (var1.equalsIgnoreCase("script")) {
            return "todo";
        } else {
            return !var1.equalsIgnoreCase("function") && !var1.equalsIgnoreCase("functionNoTimeout") ? "unknown command" : "todo";
        }
    }
}
