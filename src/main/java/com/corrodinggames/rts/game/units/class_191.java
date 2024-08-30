package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.a.class_177;
import com.corrodinggames.rts.gameFramework.f.a.class_183;
import com.corrodinggames.rts.gameFramework.f.a.class_189;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.3.2
class class_191 extends class_189 {
    // $FF: synthetic field
    final class_177 a;
    // $FF: synthetic field
    final GameEngine b;
    // $FF: synthetic field
    final Runnable c;
    // $FF: synthetic field
    final class_274 d;

    class_191(class_274 var1, class_177 var2, GameEngine var3, Runnable var4) {
        this.d = var1;
        this.a = var2;
        this.b = var3;
        this.c = var4;
    }

    public boolean a(class_183 var1) {
        this.a.i();
        this.b.a(this.c);
        return true;
    }
}
