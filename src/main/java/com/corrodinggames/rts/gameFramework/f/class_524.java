package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Paint$Cap;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.TeamHistory;
import com.corrodinggames.rts.gameFramework.m.class_525;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.aa
public strictfp class class_524 {
    TeamHistory a;
    String b;
    int c;
    class_525[] d;
    class_525[] e;

    public class_525 a(int var1, boolean var2) {
        int var3 = var1 / 25;
        if (var3 < 0) {
            var3 = 0;
        }

        if (var3 > 10) {
            var3 = 10;
        }

        return var2 ? this.e[var3] : this.d[var3];
    }

    public class_524(TeamHistory var1, String var2, int var3) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
        this.d = new class_525[11];
        this.e = new class_525[11];

        for(int var4 = 0; var4 < 11; ++var4) {
            int var5 = var4 * 25;
            if (var4 == 10) {
                var5 = 255;
            }

            this.d[var4] = new class_525();
            this.d[var4].a(2.0F);
            if (GameEngine.aZ) {
                this.d[var4].a(3.0F);
            }

            this.d[var4].a((Paint$Cap)Paint$Cap.b);
            this.d[var4].b(var3);
            this.d[var4].c(var5);
            this.e[var4] = new class_525();
            this.e[var4].b(-13162713);
            this.e[var4].c(var5);
            this.e[var4].a(5.0F);
            this.e[var4].a((Paint$Cap)Paint$Cap.b);
        }

    }
}
