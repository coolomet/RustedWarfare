package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.class_83;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.x
public strictfp class class_87 extends class_83 {
    class_1069 a = new class_1069();

    public UnitType b() {
        return UnitType.fogRevealer;
    }

    public class_87() {
        super(true);
        this.bX = PlayerData.i;
    }

    public void a(float var1) {
        super.a(var1);
        GameEngine.a("PlaceholderUnit was updated");
        this.ci();
    }

    public strictfp boolean t() {
        return true;
    }

    public strictfp boolean u() {
        return true;
    }

    public class_1069 df() {
        return this.a;
    }

    public void a(class_1069 var1) {
        this.a = var1;
    }

    // $FF: synthetic method
    public class_31 r() {
        return this.b();
    }
}
