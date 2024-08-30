package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.k
class class_267 extends class_253 {
    boolean a;
    boolean b;

    public class_267(boolean var1, boolean var2) {
        super("changeTeam" + var1 + "d:" + var2);
        this.a = var1;
        this.b = var2;
    }

    public strictfp String b() {
        if (this.b) {
            return "Selected player";
        } else {
            return this.a ? "<- Set player" : "Set player ->";
        }
    }

    public strictfp String d() {
        if (!this.b) {
            return this.a ? "<-" : "->";
        } else {
            GameEngine var1 = GameEngine.getGameEngine();
            PlayerData var2 = null;
            Iterator var3 = var1.bS.bZ.iterator();

            while(var3.hasNext()) {
                Unit var4 = (Unit)var3.next();
                if (var4 instanceof OrderableUnit) {
                    OrderableUnit var5 = (OrderableUnit)var4;
                    if (var5.cG && var1.bS.m(var5)) {
                        var2 = var5.bX;
                    }
                }
            }

            String var6 = "";
            if (var2 != null) {
                var6 = var6 + "Team - " + (var2.site + 1) + "";
            }

            return var6;
        }
    }

    public strictfp String type() {
        return "Change targeted player for editor";
    }

    public strictfp float l() {
        return !InterfaceEngine.bP ? 0.8F : 0.5F;
    }

    public strictfp int m() {
        return this.b ? 2 : 4;
    }

    public strictfp DisplayType f() {
        return this.b ? DisplayType.infoOnly : super.f();
    }

    public strictfp class_1052 e() {
        return this.b ? class_1052.infoOnly : super.e();
    }
}
