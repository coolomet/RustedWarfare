package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.EditorOrBuilder;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.class_71;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.net.Unknown_GameOutBlockStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.y
public strictfp class class_242 extends class_226 {
    public boolean a;

    public class_242(boolean var1) {
        super("c_5");
        this.g = -9990.0F;
        this.a = var1;
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
        GameEngine var1 = GameEngine.getGameEngine();
        Unit[] var2 = var1.bS.bZ.a();
        int var3 = 0;

        for(int var4 = var1.bS.bZ.size(); var3 < var4; ++var3) {
            Unit var5 = var2[var3];
            if (var5 instanceof OrderableUnit) {
                OrderableUnit var6 = (OrderableUnit)var5;
                if (var6.cG) {
                    return var6;
                }
            }
        }

        return null;
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
        String var1 = "UnitInfo";
        GameEngine var2 = GameEngine.getGameEngine();
        OrderableUnit var3 = this.K();
        if (var3 != null) {
            if (var3 instanceof EditorOrBuilder) {
                return "Editor";
            }

            if (!this.a) {
                var1 = var2.bS.g.a((Unit)var3, false);
            } else {
                PlayerData var4 = var3.bX;
                var1 = var2.bS.g.a(var4);
            }
        }

        return var1;
    }

    public boolean h_() {
        return true;
    }

    public String b() {
        return "UnitInfo";
    }

    public String d(Unit var1) {
        if (this.a) {
            return "";
        } else {
            return var1 != null ? var1.r().e() : "UnitInfo";
        }
    }

    public boolean s() {
        if (this.a) {
            return !this.L();
        } else {
            return true;
        }
    }

    public boolean u() {
        return !this.a;
    }

    public boolean C() {
        return true;
    }

    public String type() {
        if (this.a) {
            return "";
        } else {
            OrderableUnit var1 = this.K();
            if (var1 != null) {
                boolean var2 = false;
                String var3 = class_71.a(var1, false, true, var2);
                boolean var4 = false;
                if (var4) {
                    Unknown_GameOutBlockStream var5 = new Unknown_GameOutBlockStream();

                    try {
                        var1.a((GameOutputStream)var5);
                    } catch (Exception var7) {
                        var7.printStackTrace();
                    }

                    var3 = var3 + "\n" + var5.a;
                }

                return var3;
            } else {
                return "";
            }
        }
    }

    public boolean G() {
        return true;
    }
}
