package com.corrodinggames.rts.game.units.buildings;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_281;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.class_62;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.d.k
public strictfp class class_320 {
    OrderableUnit a;
    public PointF b = null;
    public final class_684 c = new class_684();
    final class_684 d = new class_684();
    public float e;
    class_73 f;

    public class_320(OrderableUnit var1) {
        this.a = var1;
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeFloat(this.e);
        var1.writeInt(this.c.size());
        Iterator var2 = this.c.iterator();

        while(var2.hasNext()) {
            class_62 var3 = (class_62)var2.next();
            var3.a(var1);
        }

        var1.writeBoolean(this.b != null);
        if (this.b != null) {
            var1.writeFloat(this.b.x);
            var1.writeFloat(this.b.y);
        }

    }

    public strictfp void a(GameInputStream var1) {
        this.e = var1.readFloat();
        int var2 = var1.readInt();
        this.c.clear();

        for(int var3 = 0; var3 < var2; ++var3) {
            class_73 var4 = new class_73();
            var4.a(var1);
            if (class_226.c(var4.j)) {
                class_226 var5 = this.a.a((class_1059)var4.j);
                if (var5 == null) {
                    GameEngine.b("Factory", this.a.r() + " no longer has the action:" + var4.j);
                } else {
                    this.c.add(var4);
                }
            } else {
                GameEngine.b("Factory", "buildQueue has uIndex of -1, skipping");
            }
        }

        if (var1.b() >= 5) {
            boolean var6 = var1.readBoolean();
            if (var6) {
                if (this.b == null) {
                    this.b = new PointF();
                }

                this.b.x = var1.readFloat();
                this.b.y = var1.readFloat();
            } else {
                this.b = null;
            }
        }

    }

    public strictfp Unit a(class_73 var1, float var2, boolean var3, float var4) {
        class_226 var5 = this.a.a((class_1059)var1.j);
        if (var5 == null) {
            GameNetEngine.a("specialAction=null on completeQueueItem for item.uIndex:" + var1.j + " id:" + this.a.id, true);
            return null;
        } else {
            class_31 var6 = var5.i();
            if (var6 == null) {
                GameNetEngine.a("unitType=null on completeQueueItem for item.uIndex:" + var1.j + " id:" + this.a.id, false);
                return null;
            } else {
                return this.a(var6, var2, var3, var4);
            }
        }
    }

    public strictfp void a(Unit var1, float var2, boolean var3) {
        var1.cl = 30.0F;
        if (this.a instanceof ExperimentalLandFactory) {
            var1.cl += 40.0F;
        }

        if (var1 instanceof OrderableUnit) {
            OrderableUnit var4 = (OrderableUnit)var1;
            var4.j(90.0F);
            if ((double)var4.speed() < 0.75) {
                var1.cl += 30.0F;
            }

            if ((double)var4.speed() < 0.55) {
                var1.cl += 20.0F;
            }

            float var5 = var3 ? 0.0F : 1.0F;
            float var7 = this.a.xCord + class_340.k(var1.cg) * var2;
            float var8 = this.a.yCord + class_340.j(var1.cg) * var2;
            if (this.b != null) {
                if (var2 != 0.0F) {
                    var4.d(var7, var8);
                }

                var4.d(this.b.x + var5, this.b.y);
            } else {
                var7 -= class_340.j(var1.cg) * var5;
                var8 += class_340.k(var1.cg) * var5;
                if (var2 != 0.0F) {
                    var4.d(var7, var8);
                }
            }
        }

    }

    public strictfp Unit a(class_31 var1, float var2, boolean var3, float var4) {
        Unit var5 = null;
        var5 = var1.a();
        var5.xCord = this.a.xCord;
        var5.yCord = this.a.yCord + 5.0F;
        var5.cg = 90.0F + var4;
        var5.f(this.a.bX);
        var5.B(this.a);
        this.a(var5, var2, var3);
        GameEngine var6 = GameEngine.getGameEngine();
        if (var5.bX == var6.playerTeam) {
            var6.bS.i.a(var5);
        }

        return var5;
    }

    public final strictfp boolean a() {
        return this.c.a == 0;
    }

    public strictfp class_73 a(class_281 var1, boolean var2) {
        return this.a((class_281)var1, var2, (PointF)null, (Unit)null);
    }

    public strictfp class_73 a(class_281 var1, boolean var2, PointF var3, Unit var4) {
        class_73 var5 = new class_73();
        var5.j = var1.N();
        var5.h = var3;
        var5.i = var4;
        if (var5.j == null) {
            throw new RuntimeException("item.uIndex==null??");
        } else {
            var5.a = 1;
            var5.b = var1.K();
            var5.c = var1.B();
            var5.d = var1.r_();
            var5.e = var1.P();
            var5.f = var1.g();
            var5.g = var1.i();
            var5.l = var1.H();
            if (!var2) {
                PlayerData.b((Unit)this.a);
                if (!var5.l) {
                    this.c.add(var5);
                } else {
                    int var6 = 0;

                    for(int var7 = 0; var7 < this.c.size() && ((class_73)this.c.get(var7)).l; ++var7) {
                        var6 = var7 + 1;
                    }

                    if (var6 == 0 && this.c.size() != 0) {
                    }

                    this.c.add(var6, var5);
                }

                PlayerData.c((Unit)this.a);
            } else {
                this.d.add(var5);
            }

            return var5;
        }
    }

    public strictfp class_73 b(class_281 var1, boolean var2) {
        if (var2) {
            if (this.a(var1.N(), true) > 0) {
                class_73 var6 = this.a(var1, true);
                var6.k = true;
                return var6;
            } else {
                return null;
            }
        } else {
            class_684 var3 = this.c;
            ListIterator var4 = var3.listIterator(var3.size());

            class_73 var5;
            do {
                if (!var4.hasPrevious()) {
                    return null;
                }

                var5 = (class_73)var4.previous();
            } while(!var5.j.equals(var1.N()));

            PlayerData.b((Unit)this.a);
            var4.remove();
            PlayerData.c((Unit)this.a);
            return var5;
        }
    }

    public strictfp void a(class_73 var1) {
        this.f = var1;
        this.a.bC();
    }

    public strictfp class_73 b() {
        return this.f;
    }

    public strictfp class_447 c() {
        if (this.f == null) {
            return null;
        } else if (this.f.d == null) {
            return null;
        } else {
            float var1 = this.f.b * this.a.cx() * 60.0F;
            return class_447.a(this.f.d, -var1);
        }
    }

    public strictfp class_226 d() {
        if (this.f != null) {
            class_226 var1 = this.a.a((class_1059)this.f.j);
            return var1;
        } else {
            return null;
        }
    }

    public strictfp void a(float var1) {
        class_73 var2;
        if (!this.a()) {
            var2 = (class_73)this.f().get(0);
            if (this.f != var2) {
                if (var2.m < 0.0F) {
                    var2.m = 0.0F;
                    ((class_8)this.a).b(var2);
                }

                if (this.f != null) {
                    this.e = var2.m;
                }

                this.a(var2);
            }

            float var3 = var2.b * this.a.cx() * var1;
            boolean var4 = false;
            if (var2.d != null) {
                if (this.e + var3 > 1.0F) {
                    var3 = 1.0F - this.e;
                    var4 = true;
                }

                double var5 = (double)(this.e + var3) - var2.n;
                double var7 = 0.0;
                if (var4) {
                    var7 = 1.0 - var2.n;
                } else {
                    double var9 = 0.009999999776482582;
                    if (var5 >= var9) {
                        int var11 = (int)(var5 / var9);
                        var7 = (double)var11 * var9;
                    }
                }

                boolean var14 = false;
                if (var7 > 0.0 && this.a.bX.am.a(var2.d)) {
                    var14 = true;
                }

                if (var14 || !(var7 <= 0.0) && !var2.d.c(this.a, var7)) {
                    if (!var14) {
                        this.a.bX.am.a((class_447)var2.d, this.a, var7);
                    }

                    var3 = 0.0F;
                    var4 = false;
                } else {
                    var2.n += var7;
                }
            }

            this.e += var3;
            if (var4) {
                this.e = 1.0F;
            }

            var2.m = this.e;
            if (this.e >= 1.0F) {
                if (var2.f && ((class_8)this.a).dA()) {
                    this.e = 1.0F;
                } else {
                    PlayerData.b((Unit)this.a);
                    this.e = 0.0F;
                    --var2.a;
                    if (var2.a <= 0) {
                        List var13 = this.f();
                        if (var13.size() == 0) {
                            GameEngine.print("-------------buildQueue empty for:" + var2.j);
                            GameEngine.print("-------------");
                        } else {
                            var13.remove(0);
                        }
                    }

                    PlayerData.c((Unit)this.a);
                    ((class_8)this.a).a(var2);
                }
            }
        } else {
            this.a((class_73)null);
            this.e = 0.0F;
            if (this.d.a > 0) {
                var2 = (class_73)this.d.get(0);
                if (var2.b > 10.0F && var2.m <= 0.0F) {
                    var2.m = 1.0F;
                    class_226 var12 = this.a.a((class_1059)var2.j);
                    if (var12 != null && var12.Q()) {
                        var12.a(this.a);
                    }
                }
            }
        }

    }

    public strictfp void e() {
        Iterator var1 = this.c.iterator();

        while(var1.hasNext()) {
            class_73 var2 = (class_73)var1.next();
            class_226 var3 = this.a.a((class_1059)var2.j);
            if (var3 == null) {
                this.b(var2);
                this.c(var2);
                var1.remove();
            }
        }

    }

    public strictfp void a(boolean var1) {
        Iterator var2 = this.c.iterator();

        while(var2.hasNext()) {
            class_73 var3 = (class_73)var2.next();
            if (var1) {
                this.b(var3);
            }

            this.c(var3);
            var2.remove();
        }

    }

    private strictfp void b(class_73 var1) {
        if (((class_8)this.a).c(var1)) {
            if (var1.d != null && var1.n > 0.0) {
                var1.d.a(this.a, var1.n, true);
            }

            var1.c.h(this.a);
        }

    }

    private strictfp void c(class_73 var1) {
    }

    public strictfp int a(class_31 var1) {
        int var2 = 0;
        int var3 = this.c.a;
        if (var3 != 0) {
            Object[] var4 = this.c.a();

            for(int var5 = 0; var5 < var3; ++var5) {
                class_73 var6 = (class_73)var4[var5];
                if (var6.f) {
                    class_31 var7 = var6.g;
                    if (var7 == var1) {
                        var2 += var6.a;
                    }
                }
            }
        }

        return var2;
    }

    public strictfp int a(class_1059 var1, boolean var2) {
        return this.a(var1, var2, false);
    }

    public strictfp int a(class_585 var1) {
        if (var1 == null) {
            return this.c.a;
        } else {
            int var2 = 0;
            Iterator var3 = this.c.iterator();

            while(var3.hasNext()) {
                class_73 var4 = (class_73)var3.next();
                if (class_585.a(var1, var4.e)) {
                    ++var2;
                }
            }

            return var2;
        }
    }

    public strictfp int a(class_1059 var1, boolean var2, boolean var3) {
        int var4 = 0;
        Iterator var5;
        class_73 var6;
        if (this.c.a != 0) {
            var5 = this.c.iterator();

            label64:
            while(true) {
                do {
                    do {
                        if (!var5.hasNext()) {
                            break label64;
                        }

                        var6 = (class_73)var5.next();
                    } while(class_226.i != var1 && !var6.j.equals(var1));
                } while(var3 && !var6.f);

                var4 += var6.a;
            }
        }

        if (var2 && this.d.a != 0) {
            var5 = this.d.iterator();

            while(true) {
                do {
                    do {
                        if (!var5.hasNext()) {
                            return var4;
                        }

                        var6 = (class_73)var5.next();
                    } while(class_226.i != var1 && !var6.j.equals(var1));
                } while(var3 && !var6.f);

                if (!var6.k) {
                    var4 += var6.a;
                } else {
                    var4 -= var6.a;
                }
            }
        } else {
            return var4;
        }
    }

    public strictfp class_226 b(class_31 var1) {
        ArrayList var2 = this.a.N();
        int var3 = 0;

        for(int var4 = var2.size(); var3 < var4; ++var3) {
            class_226 var5 = (class_226)var2.get(var3);
            if (var5 != null && var5 instanceof class_281) {
                class_281 var6 = (class_281)var5;
                if (var6.i() == var1) {
                    return var6;
                }
            }
        }

        return null;
    }

    public strictfp class_73 a(class_226 var1, boolean var2, PointF var3, Unit var4) {
        if (var1 instanceof class_281) {
            class_281 var5 = (class_281)var1;
            if (!var2) {
                if (var1.a(this.a, false) && var1.b((Unit)this.a) && (!var5.g() || this.a.bX.w() < this.a.bX.x()) && var5.B().c(this.a)) {
                    return this.a(var5, false, var3, var4);
                }
            } else {
                class_73 var6 = this.b(var5, false);
                if (var6 != null) {
                    this.b(var6);
                    this.c(var6);
                    return var6;
                }
            }
        }

        return null;
    }

    public strictfp void a(class_226 var1, boolean var2) {
        if (var1 instanceof class_281) {
            class_281 var3 = (class_281)var1;
            if (!var2) {
                if (var1.a(this.a, true) && (!var3.g() || this.a.bX.w() < this.a.bX.x()) && var3.B().b(this.a, var1.Q())) {
                    this.a(var3, true);
                }
            } else if (this.b(var3, true) != null) {
                var3.B().e(this.a, var1.Q());
            }
        }

    }

    public strictfp void a(class_226 var1) {
        if (this.d.size() != 0) {
            class_73 var2 = null;
            Iterator var3 = this.d.iterator();

            while(var3.hasNext()) {
                class_73 var4 = (class_73)var3.next();
                if (var4.j.equals(var1.N())) {
                    var2 = var4;
                }
            }

            if (var2 != null) {
                if (!var2.k) {
                    var2.c.e(this.a, var1.Q());
                } else {
                    var2.c.d(this.a, var1.Q());
                }

                this.d.remove(var2);
            }
        }

    }

    public strictfp List f() {
        return this.c;
    }

    public strictfp class_684 g() {
        return this.c;
    }
}
