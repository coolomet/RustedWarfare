package com.corrodinggames.rts.game.units.g;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;

// $FF: renamed from: com.corrodinggames.rts.game.units.g.e
public strictfp class class_794 extends class_792 {
    int b;
    class_1059 c;

    public class_794() {
        this.c = class_1059.a;
    }

    public class_794(int var1, class_1059 var2) {
        super(var1);
        this.c = class_1059.a;
        this.c = var2;
        GameEngine var3 = GameEngine.getGameEngine();
        int var4 = var3.by;
        this.b = var4;
    }

    public StatusEffectType b() {
        return StatusEffectType.SPECIAL_ACTION_BLOCK;
    }

    public boolean a(class_1059 var1) {
        if (this.c == class_1059.a) {
            return true;
        } else {
            return this.c == var1;
        }
    }

    public float c() {
        int var1 = this.a - this.b;
        if (var1 <= 0) {
            return 1.0F;
        } else {
            GameEngine var2 = GameEngine.getGameEngine();
            int var3 = var2.by;
            int var4 = this.a - var3;
            return (float)var4 / (float)var1;
        }
    }

    public static void a(OrderableUnit var0, class_1059 var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        int var4 = var3.by + var2;
        class_794 var5 = new class_794(var4, var1);
        class_795.a(var0, (class_792)var5);
    }

    public static int a(Unit var0, class_1059 var1) {
        if (!(var0 instanceof OrderableUnit)) {
            return 0;
        } else {
            OrderableUnit var2 = (OrderableUnit)var0;
            class_684 var3 = var2.bp;
            if (var3 == null) {
                return 0;
            } else {
                class_794 var4 = b(var0, var1);
                if (var4 == null) {
                    return 0;
                } else {
                    int var5 = var4.d();
                    return var5;
                }
            }
        }
    }

    public int d() {
        GameEngine var1 = GameEngine.getGameEngine();
        int var2 = var1.by;
        int var3 = this.a - var2;
        return var3;
    }

    public static class_794 b(Unit var0, class_1059 var1) {
        if (!(var0 instanceof OrderableUnit)) {
            return null;
        } else {
            OrderableUnit var2 = (OrderableUnit)var0;
            class_684 var3 = var2.bp;
            if (var3 == null) {
                return null;
            } else {
                GameEngine var4 = GameEngine.getGameEngine();
                int var5 = var4.by;
                class_794 var6 = null;
                Object[] var7 = var3.a();

                for(int var8 = var3.a - 1; var8 >= 0; --var8) {
                    class_792 var9 = (class_792)var7[var8];
                    if (var9 instanceof class_794) {
                        class_794 var10 = (class_794)var9;
                        if (var10.a(var1) && var10.a > var5) {
                            var5 = var10.a;
                            var6 = var10;
                        }
                    }
                }

                if (var6 == null) {
                    return null;
                } else {
                    return var6;
                }
            }
        }
    }

    public void a(OrderableUnit var1, GameOutputStream var2) {
        class_1059.a(var2, this.c);
        var2.writeInt(this.b);
        super.a(var1, var2);
    }

    public void a(OrderableUnit var1, GameInputStream var2) {
        this.c = class_1059.a(var2);
        if (this.c == null) {
            this.c = class_1059.a;
        }

        this.b = var2.readInt();
        super.a(var1, var2);
    }

    public static void c(Unit var0, class_1059 var1) {
        if (var0 instanceof OrderableUnit) {
            OrderableUnit var2 = (OrderableUnit)var0;
            class_684 var3 = var2.bp;
            if (var3 != null) {
                GameEngine var4 = GameEngine.getGameEngine();
                int var5 = var4.by;
                Object[] var6 = var3.a();

                for(int var7 = var3.a - 1; var7 >= 0; --var7) {
                    class_792 var8 = (class_792)var6[var7];
                    if (var8 instanceof class_794) {
                        class_794 var9 = (class_794)var8;
                        if (var1 == class_1059.a || var9.a(var1)) {
                            var9.a = var5 - 1;
                        }
                    }
                }

            }
        }
    }
}
