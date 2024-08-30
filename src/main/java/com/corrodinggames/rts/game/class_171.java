package com.corrodinggames.rts.game;

import android.graphics.Paint;
import android.graphics.Rect;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_338;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.m.Shader;
import java.io.IOException;

// $FF: renamed from: com.corrodinggames.rts.game.j
public strictfp class class_171 {
    public TeamImageCache a;
    class_28 b;
    class_525 c;
    Shader d;
    Paint e;
    Rect f;
    boolean g;

    public class_171() {
        this.e = new Paint();
        this.f = new Rect(-101, 0, -1, 100);
        this.c = new class_525();
    }

    public class_171(String var1) {
        this();

        try {
            this.d = new Shader(var1);
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }

        this.c.a(this.d);
        if (this.d.o != 0) {
            this.g = true;
        }

    }

    public strictfp boolean a() {
        if (this.d != null && this.d.o != 0) {
            return true;
        } else {
            return this.g;
        }
    }

    public strictfp void a(class_28 var1) {
        this.a(var1, var1.m(), var1.n(), 10);
    }

    public strictfp void a(class_28 var1, int var2, int var3, int var4) {
        if (!this.g) {
            if (this.a != null && (var2 > this.a.m() || var3 > this.a.l())) {
                this.a.o();
                this.a = null;
                this.b = null;
            }

            if (this.a == null) {
                try {
                    this.a = var1.a(var2 + var4, var3 + var4, true);
                    this.b = var1.a(this.a);
                } catch (OutOfMemoryError var6) {
                    this.g = true;
                    GameEngine.a((class_338)class_338.GAME_IMAGE_CREATE, (Throwable)var6);
                    return;
                }
            }

            this.b.a(var2, var3);
        }
    }

    public strictfp void b() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bO.b(this.f, this.e);
        var1.bO.b(this.a, 0.0F, 0.0F, this.c);
    }
}
