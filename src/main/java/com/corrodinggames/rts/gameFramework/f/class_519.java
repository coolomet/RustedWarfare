package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.ap
public strictfp class class_519 {
    private GameEngine a;
    private Paint b;
    private ArrayList c = new ArrayList();

    public class_519(GameEngine var1) {
        this.a = var1;
        this.a();
    }

    public strictfp void a() {
        this.b = new Paint();
        this.b.a(255, 255, 255, 255);
        this.b.a(true);
        this.b.c(true);
        this.b.a(Typeface.a((Typeface)Typeface.c, 1));
        this.a.a(this.b, 14.0F);
    }

    public strictfp synchronized void b() {
        this.c.clear();
    }

    public strictfp synchronized void a(Unit var1) {
        class_515 var2 = new class_515(var1.xCord, var1.yCord, var1.r());
        var2.c = GameEngine.millis();
        this.a((class_512)var2);
    }

    public strictfp synchronized void b(Unit var1) {
        class_516 var2 = new class_516(var1.xCord, var1.yCord, var1.r());
        var2.c = GameEngine.millis();
        this.a((class_512)var2);
    }

    public strictfp synchronized void c(Unit var1) {
        class_514 var2 = new class_514(var1.xCord, var1.yCord, var1.bI());
        var2.c = GameEngine.millis();
        this.a((class_512)var2);
    }

    public strictfp synchronized void a(String var1) {
        class_513 var2 = new class_513(var1);
        var2.c = GameEngine.millis();
        this.a((class_512)var2);
    }

    public strictfp synchronized void a(String var1, int var2) {
        class_513 var3 = new class_513(var1);
        var3.c = GameEngine.millis();
        var3.d = (long)var2;
        var3.i = true;
        this.a((class_512)var3);
    }

    private strictfp void a(class_512 var1) {
        boolean var2 = false;
        Iterator var3 = this.c.iterator();

        while(var3.hasNext()) {
            class_512 var4 = (class_512)var3.next();
            if (var4.a(var1)) {
                var4.b(var1);
                var2 = true;
                break;
            }
        }

        if (var2) {
            Collections.sort(this.c);
        } else {
            this.c.add(0, var1);
        }

    }

    public strictfp synchronized void a(float var1) {
        this.c();
        GameEngine var2 = GameEngine.getGameEngine();
        int var3 = (int)(var2.cm - 130.0F * var2.cj);
        byte var4 = 20;
        int var5 = (int)(20.0F * var2.cj);
        Iterator var6 = this.c.iterator();

        while(var6.hasNext()) {
            class_512 var7 = (class_512)var6.next();
            String var8 = var7.type();
            if (var2.settingsEngine.showWarLogOnScreen || var7.i) {
                if (var7.c + var7.d < System.currentTimeMillis()) {
                    break;
                }

                if (var7.h) {
                    this.b.a(255, 160, 160, 160);
                } else {
                    this.b.a(255, 255, 255, 255);
                }

                var2.bO.a(var8, (float)var4, (float)var3, this.b);
                var3 -= var5;
            }
        }

    }

    public strictfp synchronized void c() {
        Iterator var1 = this.c.iterator();

        while(var1.hasNext()) {
            class_512 var2 = (class_512)var1.next();
            if (var2.c + 20000L < System.currentTimeMillis()) {
                var1.remove();
            }
        }

    }

    public strictfp synchronized void d() {
        if (!this.c.isEmpty()) {
            Iterator var1 = this.c.iterator();

            while(var1.hasNext()) {
                class_512 var2 = (class_512)var1.next();
                if (!var2.h) {
                    var2.h = true;
                    this.a.b(var2.e, var2.f);
                    break;
                }
            }

        }
    }
}
