package com.corrodinggames.rts.gameFramework.g;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;

import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.g.f
public enum class_173 {
    none,
    income,
    armyValue,
    buildingValue,
    totalValue,
    credits;

    public int a(PlayerData var1) { // get money?
        switch (this) {
            default: {
                return 0;
            }
            case income: {
                int n = var1.v();
                ArrayList<BuiltInResource> arrayList = BuiltInResource.f();
                for (BuiltInResource a2 : arrayList) {
                    float f2;
                    if (!a2.d() || (f2 = a2.b()) == 0.0f) continue;
                    n = (int)((float)n + f2 * (float)var1.b(a2));
                }
                return n;
            }
            case armyValue: {
                return var1.T.n;
            }
            case buildingValue: {
                return var1.T.o;
            }
            case totalValue: {
                return var1.T.n + var1.T.o;
            }
            case credits:
        }
        return (int)var1.credits;
    }
}
