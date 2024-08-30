package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.a.class_177;
import com.corrodinggames.rts.gameFramework.f.a.class_183;
import com.corrodinggames.rts.gameFramework.f.a.class_189;

class GameNetEngine$5 extends class_189 {
    // $FF: synthetic field
    final class_177 a;
    // $FF: synthetic field
    final GameEngine b;
    // $FF: synthetic field
    final GameNetEngine c;

    GameNetEngine$5(GameNetEngine var1, class_177 var2, GameEngine var3) {
        this.c = var1;
        this.a = var2;
        this.b = var3;
    }

    public strictfp boolean a(class_183 var1) {
        this.a.i();
        this.b.a((Runnable)(new GameNetEngine$5$1(this)));
        return true;
    }
}
