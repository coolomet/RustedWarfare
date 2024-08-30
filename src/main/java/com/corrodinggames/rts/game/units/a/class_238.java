package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.EditorOrBuilder;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.p
public abstract strictfp class class_238 extends class_226 {
    public class_238(String var1) {
        super("c__cut_" + var1);
        this.g = 0.0F;
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public int c() {
        return 0;
    }

    public class_31 i() {
        return null;
    }

    public class_1052 e() {
        return class_1052.infoOnly;
    }

    public DisplayType f() {
        return DisplayType.infoOnly;
    }

    public boolean g() {
        return false;
    }

    public OrderableUnit K() {
        OrderableUnit var1 = null;
        Iterator var2 = GameObject.er.iterator();

        while(var2.hasNext()) {
            GameObject var3 = (GameObject)var2.next();
            if (var3 instanceof OrderableUnit) {
                OrderableUnit var4 = (OrderableUnit)var3;
                if (var4.cG) {
                    var1 = var4;
                }
            }
        }

        return var1;
    }

    public boolean L() {
        GameEngine var1 = GameEngine.getGameEngine();
        OrderableUnit var2 = this.K();
        if (var2 != null) {
            if (var2 instanceof EditorOrBuilder) {
                return true;
            } else {
                return var1.playerTeam == var2.bX;
            }
        } else {
            return false;
        }
    }

    public String d() {
        return this.b();
    }

    public boolean h_() {
        return false;
    }

    public boolean s() {
        return !this.L();
    }

    public boolean G() {
        return false;
    }

    public float l() {
        return !InterfaceEngine.bP ? 1.0F : 1.0F;
    }
}
