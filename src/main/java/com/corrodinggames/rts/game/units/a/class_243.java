package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.units.EditorOrBuilder;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.z
public strictfp class class_243 extends class_226 {
    class_31 a;
    ArrayList b = new ArrayList();
    int c = 0;
    boolean d;
    OrderableUnit e = null;
    int f;

    public class_243(class_31 var1) {
        super("s_" + var1.v());
        this.g = -9999.0F;
        this.a = var1;
    }

    public int b(Unit var1, boolean var2) {
        return -1;
    }

    public int c() {
        return 0;
    }

    public class_31 i() {
        return this.a;
    }

    public class_1052 e() {
        return class_1052.infoOnly;
    }

    public DisplayType f() {
        return GameEngine.at() && !InterfaceEngine.bO ? DisplayType.infoOnlyNoBox : DisplayType.infoOnly;
    }

    public boolean g() {
        return false;
    }

    public boolean c(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (!var2) {
            if (var3.bS.q() == 1) {
                return false;
            }

            boolean var4 = false;
            Iterator var5 = Unit.bE.iterator();

            while(var5.hasNext()) {
                Unit var6 = (Unit)var5.next();
                if (var6.cG && var6.r() != this.a) {
                    var3.bS.l(var6);
                    var4 = true;
                }
            }

            if (!var4) {
                return false;
            }
        } else {
            Iterator var7 = Unit.bE.iterator();

            while(var7.hasNext()) {
                Unit var8 = (Unit)var7.next();
                if (var8.cG && var8.r() == this.a) {
                    var3.bS.l(var8);
                }
            }
        }

        return true;
    }

    public String d() {
        String var1 = "UnitInfo";
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.e instanceof EditorOrBuilder) {
            return "Editor";
        } else {
            var1 = "" + this.a.e() + " x" + this.c;
            return var1;
        }
    }

    public String b() {
        return "UnitInfo";
    }

    public String w(Unit var1) {
        return this.e instanceof EditorOrBuilder ? "Editor" : this.a.e();
    }

    public boolean h_() {
        return true;
    }

    public boolean s() {
        return true;
    }

    public boolean u() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public String type() {
        String var1 = "";
        if (this.e instanceof EditorOrBuilder) {
            return "";
        } else {
            if (this.d) {
                var1 = "(Left click to exclusively select / Right click to unselect)\n";
            }

            return var1 + this.a.f();
        }
    }

    public void K() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.f != var1.bS.Y) {
            this.f = var1.bS.Y;
            this.c = 0;
            this.d = false;
            this.e = null;
            Unit[] var2 = var1.bS.bZ.a();
            int var3 = 0;

            for(int var4 = var1.bS.bZ.size(); var3 < var4; ++var3) {
                Unit var5 = var2[var3];
                if (var5 instanceof OrderableUnit) {
                    OrderableUnit var6 = (OrderableUnit)var5;
                    if (var6.cG) {
                        if (var6.r() == this.a) {
                            ++this.c;
                            if (this.e == null) {
                                this.e = var6;
                            }
                        } else {
                            this.d = true;
                        }
                    }
                }
            }

        }
    }

    public float m_() {
        return this.g - (float)this.c;
    }

    public boolean G() {
        return true;
    }

    public boolean o_() {
        return true;
    }
}
