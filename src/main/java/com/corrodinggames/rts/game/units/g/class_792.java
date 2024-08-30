package com.corrodinggames.rts.game.units.g;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.g.a
public abstract strictfp class class_792 {
    int a;

    public class_792() {
    }

    public class_792(int var1) {
        this.a = var1;
    }

    public int a() {
        return this.a;
    }

    public abstract StatusEffectType b();

    public void a(OrderableUnit var1, float var2) {
    }

    public void a(OrderableUnit var1, GameOutputStream var2) {
        var2.writeInt(this.a);
    }

    public void a(OrderableUnit var1, GameInputStream var2) {
        this.a = var2.readInt();
    }
}
