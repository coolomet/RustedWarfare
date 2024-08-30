package com.corrodinggames.rts.game.units.custom.a.a;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Side;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.f.class_304;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.c
public strictfp class class_309 extends class_304 {
    public boolean a;
    public class_588 b;
    public float c;
    public boolean d;
    public Side e;
    public boolean f;
    public class_684 g = new class_684();
    public Unit h;

    public void setup(OrderableUnit var1, float var2) {
    }

    public int excludeTeam(OrderableUnit var1) {
        return -2;
    }

    public PlayerData onlyEnemiesOfTeam(OrderableUnit var1) {
        return null;
    }

    public PlayerData onlyTeam(OrderableUnit var1) {
        return null;
    }

    public void callback(OrderableUnit var1, float var2, Unit var3) {
        class_588 var4 = var3.de();
        if (this.b == null || var4 != null && class_585.a(this.b, var4)) {
            float var5 = class_340.a(var1.xCord, var1.yCord, var3.xCord, var3.yCord);
            if (var5 < this.c) {
                if (var3.cm < 1.0F && !this.d) {
                    return;
                }

                if (this.e != null && !var1.bX.a(this.e, var3.bX)) {
                    return;
                }

                if (this.a && !class_694.b(var1, var3.xCord, var3.yCord)) {
                    return;
                }

                if (!this.f) {
                    this.h = var3;
                    this.c = var5;
                } else {
                    this.g.add(var3);
                }
            }
        }

    }
}
