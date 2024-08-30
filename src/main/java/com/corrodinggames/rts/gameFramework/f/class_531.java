package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.m
public strictfp class class_531 {
    public static int a = 95;
    InterfaceEngine b;
    GameEngine c;
    Paint d;
    boolean e;
    ArrayList f = new ArrayList();

    class_531(GameEngine var1, InterfaceEngine var2) {
        this.b = var2;
        this.c = var1;
        this.a();
    }

    public void a() {
        this.d = new Paint();
        this.d.a(255, 255, 255, 255);
        this.d.a(true);
        this.d.c(true);
        this.d.a(Typeface.a((Typeface)Typeface.c, 1));
        this.c.a(this.d, 16.0F);
    }

    public synchronized void b() {
        this.e = false;
        this.f.clear();
    }

    public synchronized void c() {
        Iterator var1 = this.f.iterator();

        while(var1.hasNext()) {
            class_532 var2 = (class_532)var1.next();
            if (this.f.size() > 15) {
                var1.remove();
            }
        }

    }

    public synchronized class_532 a(String var1, String var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        class_532 var4 = new class_532();
        var4.a = var1;
        var4.b = var2;
        var4.c = System.currentTimeMillis();
        var4.d = (new SimpleDateFormat("HH:mm:ss")).format(new Date());
        if (var1 != null && !var1.equals("") && !var3.settingsEngine.showPlayerChatInGame) {
            if (!this.e) {
                this.e = true;
                this.a((String)null, "[WARNING: A player send a chat message, but you have chat muted in your settings]");
            }

            return var4;
        } else {
            this.c();
            this.f.add(var4);
            return var4;
        }
    }

    public synchronized int a(float var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        this.c();
        byte var4 = 20;
        int var5 = (int)(20.0F * var3.cj);
        boolean var6 = var3.a();

        for(int var7 = this.f.size() - 1; var7 >= 0; --var7) {
            class_532 var8 = (class_532)this.f.get(var7);
            if (var8.b()) {
                String var9;
                if (var8.a != null && !var8.a.equals("")) {
                    var9 = var8.a + ": " + var8.b;
                } else {
                    var9 = var8.b;
                }

                if (var6) {
                    var9 = var8.d + ": " + var9;
                }

                if (var8.e > 0) {
                    int var10 = var8.a();
                    int var11 = var10 / var8.e;
                    if (var11 < 0) {
                        var11 = 0;
                    }

                    if (var11 < var9.length()) {
                        var9 = var9.substring(0, var11);
                    }
                }

                this.d.b(var8.f);
                var3.bO.a(var9, (float)var4, (float)var2, this.d);
                var2 += var5;
            }
        }

        return var2;
    }
}
