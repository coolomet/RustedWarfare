package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.AttackMode;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.d
public strictfp class class_227 extends class_226 {
    int a;
    AttackMode b;

    public class_227() {
        super("c_7");
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public int c() {
        return 0;
    }

    public UnitType n() {
        return null;
    }

    public class_1052 e() {
        return class_1052.directToAction;
    }

    public DisplayType f() {
        return DisplayType.none;
    }

    public boolean g() {
        return false;
    }

    public String type() {
        return "Attack Mode";
    }

    public String b() {
        AttackMode var1 = this.q();
        return var1 != null ? var1.name() : "NA";
    }

    public boolean h_() {
        return false;
    }

    public void c(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        AttackMode var3 = this.r();
        AttackMode var4 = this.a(var3);
        PlayerData var5 = null;
        var5 = var1.bX;
        SyncPacket var6 = var2.cf.b(var5);
        Iterator var7 = Unit.bE.iterator();

        while(var7.hasNext()) {
            Unit var8 = (Unit)var7.next();
            if (var8 instanceof OrderableUnit) {
                OrderableUnit var9 = (OrderableUnit)var8;
                if (var9.cG) {
                    var6.a(var9);
                }
            }
        }

        var6.a(var4);
        this.a = var2.bS.Y;
        this.b = var4;
    }

    public AttackMode a(AttackMode var1) {
        if (var1 == AttackMode.onlyInRange) {
            return AttackMode.guardArea;
        } else {
            return var1 == AttackMode.onlyInRange ? AttackMode.aggressive : AttackMode.onlyInRange;
        }
    }

    public AttackMode q() {
        GameEngine var1 = GameEngine.getGameEngine();
        AttackMode var2 = this.r();
        this.a = var1.bS.Y;
        this.b = var2;
        return var2;
    }

    public AttackMode r() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.a == var1.bS.Y && this.b != null) {
            return this.b;
        } else {
            AttackMode var2 = null;
            boolean var3 = false;
            boolean var4 = false;
            Iterator var5 = Unit.bE.iterator();

            while(true) {
                while(true) {
                    OrderableUnit var7;
                    do {
                        Unit var6;
                        do {
                            if (!var5.hasNext()) {
                                return var2;
                            }

                            var6 = (Unit)var5.next();
                        } while(!(var6 instanceof OrderableUnit));

                        var7 = (OrderableUnit)var6;
                    } while(!var7.cG);

                    if (var2 != null && var2 != var7.P) {
                        var2 = AttackMode.mixed;
                    } else {
                        var2 = var7.P;
                    }
                }
            }
        }
    }

    public boolean b(Unit var1) {
        return true;
    }

    public String d() {
        return this.b();
    }

    public boolean s() {
        return true;
    }

    // $FF: synthetic method
    public class_31 i() {
        return this.n();
    }
}
