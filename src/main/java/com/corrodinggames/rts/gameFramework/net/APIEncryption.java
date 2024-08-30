package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import java.util.List;

public strictfp class APIEncryption {
    public static APIEncryption a = new APIEncryption();
    public static int b = 2;
    static int c = 3;
    static int d = 2;
    static int e = 3;
    public static int f = 4;
    static String g = "tx";
    static String h = "_";
    public static int i = 55;
    public static int j = 66;
    public static int k = 100;
    public static boolean l = true;

    public static float a(float var0, float var1, float var2) {
        return var0 + (var1 - var0) * var2;
    }

    public void a(String var1, List var2) {
        long var3 = GameEngine.millis();
        GameNetAPIOperate.listAddBasicNameValuePair(var2, h + "1", "" + var3);
        GameNetAPIOperate.listAddBasicNameValuePair(var2, g + "2", class_340.d("_" + var1 + (b + c)));
        GameNetAPIOperate.listAddBasicNameValuePair(var2, g + "3", class_340.d("_" + var1 + ((long)(b + c) + var3)));
    }

    public void b(String var1, List var2) {
        GameNetAPIOperate.listAddBasicNameValuePair(var2, g + "3", class_340.d("-" + var1 + (d + e) + f));
    }

    public void c(String var1, List var2) {
        if (f > 1000) {
            GameNetAPIOperate.listAddBasicNameValuePair(var2, g + "4", class_340.d("+" + var1 + (d + e) + f));
        }

    }

    public static void a(PlayerConnect var0) {
        if (var0.N) {
            long var1 = GameEngine.millis();
            if (GameEngine.getGameEngine().tick > -5) {
                var0.O = class_340.a(0.0F, 0.0F, (float)k, 0.0F) > 10.0F;
            }
        }

    }
}
