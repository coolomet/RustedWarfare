package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.class_976;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.java.audio.Music;
import com.corrodinggames.rts.java.audio.a.class_36;

public strictfp class LoadMusic extends class_976 {
    class_376 a;
    Music c;

    public LoadMusic(String var1, class_376 var2) {
        super(var1, var2);
        this.a = var2;
        synchronized(var2.f()) {
            this.a = var2;
            String var4 = class_697.e(var1);
            if (var4.contains(".rwmod")) {
                this.c = var2.b.newMusic(new class_36(class_697.k(var1), var4));
            } else {
                this.c = var2.b.newMusic(new class_36(var4));
            }

        }
    }
}
