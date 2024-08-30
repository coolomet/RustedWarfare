package com.corrodinggames.rts.game.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_1050;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.sea.class_114;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.SyncPacket;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.AbstractList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.a.g
public strictfp class class_68 extends class_65 {
    boolean a;
    String b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    OrderableUnit g;
    boolean h;
    int i;
    int j;
    class_69 k;
    float l;
    float m;
    float n;
    float o;
    float p;
    boolean q;
    boolean r;
    boolean s;
    float t;
    float u;
    boolean v;
    Unit w;
    float x;
    float y;
    float z;
    int A;
    boolean B;
    public int C;
    public Unit D;
    MovementType E;

    public boolean a() {
        return this.a;
    }

    public boolean b() {
        return !this.h;
    }

    public static class_68 a(class_138 var0, OrderableUnit var1) {
        class_68 var2 = new class_68(var0, false);
        var2.a = true;
        var2.c = true;
        var2.d = true;
        var2.e = true;
        var2.g = var1;
        var2.a(var1);
        var2.A = 0;
        var2.k();
        return var2;
    }

    public void a(GameOutputStream var1) {
        var1.writeBoolean(this.h);
        var1.writeInt(this.i);
        var1.writeInt(this.j);
        int var2 = this.F.size();
        var1.writeInt(var2);
        Iterator var3 = this.F.iterator();

        OrderableUnit var4;
        while(var3.hasNext()) {
            var4 = (OrderableUnit)var3.next();
            var1.a(var4);
        }

        var1.writeByte(7);
        var1.writeBoolean(false);
        var1.writeBoolean(this.s);
        var1.writeFloat(this.o);
        var1.writeInt(this.G.size());
        var3 = this.G.iterator();

        while(var3.hasNext()) {
            var4 = (OrderableUnit)var3.next();
            var1.a(var4);
        }

        var1.writeBoolean(this.B);
        var1.writeBoolean(this.a);
        var1.writeBoolean(this.c);
        var1.writeBoolean(this.d);
        var1.writeBoolean(this.e);
        var1.writeBoolean(this.f);
        var1.a(this.g);
        var1.writeInt(this.A);
        super.a(var1);
    }

    public void a(GameInputStream var1) {
        this.h = var1.readBoolean();
        this.i = var1.readInt();
        this.j = var1.readInt();
        this.q();
        int var2 = var1.readInt();

        for(int var3 = 0; var3 < var2; ++var3) {
            OrderableUnit var4 = var1.p();
            if (var4 != null) {
                this.a(var4);
            }
        }

        byte var7 = var1.readByte();
        if (var7 >= 1) {
            var1.readBoolean();
        }

        if (var7 >= 2) {
            this.s = var1.readBoolean();
        }

        if (var7 >= 3) {
            this.o = var1.readFloat();
        }

        if (var7 >= 4) {
            this.G.clear();
            int var8 = var1.readInt();

            for(int var5 = 0; var5 < var8; ++var5) {
                OrderableUnit var6 = var1.p();
                if (var6 != null) {
                    this.G.add(var6);
                }
            }
        }

        if (var7 >= 5) {
            this.B = var1.readBoolean();
        }

        if (var7 >= 6) {
            this.a = var1.readBoolean();
            this.c = var1.readBoolean();
            this.d = var1.readBoolean();
            this.e = var1.readBoolean();
            this.f = var1.readBoolean();
            this.g = var1.p();
        }

        if (var7 >= 7) {
            this.A = var1.readInt();
        }

        if (!this.B) {
            Iterator var9 = this.F.iterator();

            while(var9.hasNext()) {
                OrderableUnit var10 = (OrderableUnit)var9.next();
                if (var10 instanceof class_114) {
                    if (var10 != null && var10.aB == this) {
                        var10.aB = null;
                    }

                    if (var10 != null) {
                        this.G.remove(var10);
                    }

                    var9.remove();
                }
            }
        }

        super.a(var1);
    }

    public class_68(class_138 var1) {
        super(var1);
        this.h = true;
        this.l = 1000.0F;
        this.m = 100.0F;
        this.n = 4000.0F;
        this.o = 0.0F;
        this.p = 1000.0F;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = 0.0F;
        this.u = 0.0F;
        this.C = -9999;
        this.D = null;
        this.E = MovementType.NONE;
    }

    public class_68(class_138 var1, boolean var2) {
        this(var1);
        this.h = var2;
    }

    protected void a(OrderableUnit var1) {
        super.a(var1);
        this.E = this.j();
    }

    public void c() {
        Iterator var1 = Unit.bE.iterator();

        while(true) {
            OrderableUnit var3;
            do {
                while(true) {
                    Unit var2;
                    do {
                        do {
                            do {
                                do {
                                    do {
                                        do {
                                            do {
                                                do {
                                                    do {
                                                        if (!var1.hasNext()) {
                                                            return;
                                                        }

                                                        var2 = (Unit)var1.next();
                                                    } while(var2.bV);
                                                } while(var2.bX != this.R);
                                            } while(this.A <= this.F.size());
                                        } while(!(var2 instanceof OrderableUnit));

                                        var3 = (OrderableUnit)var2;
                                    } while(var3.bM);
                                } while(var3.bN);
                            } while(var3.aB != null);
                        } while(!this.R.h(var3));
                    } while(!this.R.i(var3));

                    if (this.B) {
                        if (var2.h() == MovementType.LAND) {
                            continue;
                        }
                    } else if (var2.h() == MovementType.WATER) {
                        continue;
                    }
                    break;
                }
            } while(!this.R.a(var3, this.S, this.T) && (this.b() || class_340.rand(0, 100) > 2));

            this.a(var3);
        }
    }

    public boolean d() {
        return this.A <= this.F.size();
    }

    public Unit a(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        return (float)var2.by - var1 * 1000.0F < (float)this.C ? this.D : null;
    }

    public Unit e() {
        Unit var1 = this.a(6.0F);
        return var1 != null ? var1 : null;
    }

    public Unit f() {
        Iterator var1 = this.F.iterator();

        Unit var3;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            OrderableUnit var2 = (OrderableUnit)var1.next();
            var3 = var2.ab();
        } while(var3 == null);

        return var3;
    }

    public void a(SyncPacket var1, boolean var2, Unit var3) {
        Iterator var4 = this.F.iterator();

        while(true) {
            OrderableUnit var5;
            do {
                do {
                    if (!var4.hasNext()) {
                        return;
                    }

                    var5 = (OrderableUnit)var4.next();
                } while(var2 && !var5.aq());
            } while(var3 != null && !this.R.a((Unit)var5, (Unit)var3));

            var1.a(var5);
        }
    }

    public void a(String var1) {
        this.b = var1;
    }

    public PointF a(Unit var1) {
        PointF var2 = new PointF();
        var2.x = this.S;
        var2.y = this.T;
        float var3 = 50.0F;
        float var4 = 100.0F;
        float var5 = (float)(Math.random() * 360.0);
        float var6 = class_340.c(var3, var4);
        var2.x += class_340.k(var5) * var6;
        var2.y += class_340.j(var5) * var6;
        if (var1 != null) {
            var3 = 100.0F;
            var4 = 200.0F;
            var5 = class_340.d(var2.x, var2.y, var1.xCord, var1.yCord);
            var6 = class_340.c(var3, var4);
            var2.x += class_340.k(var5) * -var6;
            var2.y += class_340.j(var5) * -var6;
        }

        return var2;
    }

    public void b(float var1) {
        super.b(var1);
        this.n();
        this.E = this.j();
        if (!this.f) {
            Unit var2 = this.e();
            if (var2 != null) {
                Unit var3 = this.f();
                if (var3 == null) {
                    if (this.a(var2, false)) {
                        this.a("fighting attacker");
                        GameEngine var4 = GameEngine.getGameEngine();
                        SyncPacket var5 = var4.cf.a((PlayerData)this.R);
                        this.a(var5, true, var2);
                        boolean var6 = false;
                        var5.a(var2.xCord, var2.yCord, var6);
                    } else {
                        this.a("flight from attacker");
                        PointF var7 = this.a(var2);
                        this.S = var7.x;
                        this.T = var7.y;
                        if (this.z > 200.0F) {
                            this.z = 200.0F;
                        }
                    }
                }
            }
        }

    }

    public void c(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        this.x += var1;
        Iterator var3 = this.F.iterator();

        while(var3.hasNext()) {
            OrderableUnit var4 = (OrderableUnit)var3.next();
            if (var4 != null && this.C < var4.bs) {
                this.C = var4.bs;
                this.D = var4.bt;
            }
        }

        this.n();
        if (this.d()) {
            this.l = class_340.a(this.l, var1);
        } else if (this.v) {
        }

        this.y = class_340.a(this.y, var1);
        this.z = class_340.a(this.z, var1);
        this.p = class_340.a(this.p, var1);
        if (!this.v && !this.r && !this.d() && this.y == 0.0F) {
            this.y = (float)(200 + class_340.c(200));
            this.c();
        }

        if (!this.v || this.q) {
            if (!this.q) {
                this.n = class_340.a(this.n, var1);
                if (this.n == 0.0F) {
                    if (this.k == null) {
                        this.k = this.g();
                    }

                    if (this.k != null) {
                        PointF var7 = this.k.w();
                        if (!this.a(var7.x, var7.y)) {
                            this.n = 100.0F;
                            this.a("random move: bad target");
                        } else {
                            this.n = 4000.0F;
                            this.S = var7.x;
                            this.T = var7.y;
                            this.a("random move");
                        }
                    } else {
                        this.a("random move: no linked base");
                    }
                }
            }

            if (this.z == 0.0F) {
                this.z = 800.0F;
                SyncPacket var8 = var2.cf.a((PlayerData)this.R);
                Iterator var9 = this.F.iterator();

                while(var9.hasNext()) {
                    OrderableUnit var5 = (OrderableUnit)var9.next();
                    boolean var6 = true;
                    if (this.c(var5) < 28900.0F) {
                        var6 = false;
                    }

                    if (!this.f && var5.aj() && !var5.aq()) {
                        var6 = false;
                    }

                    if (var6) {
                        var8.a(var5);
                    }
                }

                if (this.f) {
                    var8.a(this.S, this.T);
                } else {
                    var8.b(this.S, this.T);
                }
            }
        }

        if (this.h) {
            this.e(var1);
        } else {
            this.d(var1);
        }

        if (this.A == 0 && this.F.size() == 0) {
            this.p();
        }

        if (this.c && (this.g == null || this.g.bV)) {
            this.p();
        }

    }

    class_69 g() {
        float var1 = -1.0F;
        class_69 var2 = null;
        Iterator var3 = this.R.bn.iterator();

        while(true) {
            class_69 var5;
            float var6;
            do {
                do {
                    class_63 var4;
                    do {
                        if (!var3.hasNext()) {
                            return var2;
                        }

                        var4 = (class_63)var3.next();
                    } while(!(var4 instanceof class_69));

                    var5 = (class_69)var4;
                } while(!this.b(var5.S, var5.T));

                var6 = var5.d(this.S, this.T);
            } while(var2 != null && !(var6 < var1));

            var1 = var6;
            var2 = var5;
        }
    }

    public void d(float var1) {
        if (this.k == null || this.k.V) {
            this.k();
        }

        if (this.c && this.g != null) {
            if (this.e && !this.f) {
                if ((double)(this.g.health / this.g.totalHealth) < 0.5) {
                    this.f = true;
                    if (this.z > 100.0F) {
                        this.z = 100.0F;
                    }
                }

                if (this.w == null) {
                    this.k();
                }
            } else {
                if ((double)(this.g.health / this.g.totalHealth) > 0.6) {
                    this.f = false;
                }

                boolean var2 = false;
                if (this.k != null && !this.k.t) {
                    var2 = true;
                }

                if (!var2) {
                    boolean var3 = true;
                    class_69 var4 = this.R.a(this.g.h(), this.g.xCord, this.g.yCord, var3);
                    if (var4 != null) {
                        this.k = var4;
                    }

                    if (this.k != null) {
                        PointF var5 = this.k.w();
                        this.S = var5.x;
                        this.T = var5.y;
                        if (this.z > 100.0F) {
                            this.z = 100.0F;
                        }

                        this.a("moving to new base");
                    }
                }
            }
        }

        if (this.k != null) {
            for(int var6 = 0; var6 < 2; ++var6) {
                if (this.p == 0.0F) {
                    Unit var7 = this.k.g();
                    if (var7 == null) {
                        break;
                    }

                    if (this.a(var7, false)) {
                        this.w = var7;
                        this.p = 500.0F;
                        this.n = 2000.0F;
                        if (!this.f) {
                            this.S = var7.xCord;
                            this.T = var7.yCord;
                        }

                        if (this.z > 100.0F) {
                            this.z = 100.0F;
                        }

                        this.a("defending base");
                    }
                }
            }

            if (this.p == 0.0F) {
                this.f = false;
                this.w = null;
            }
        }

    }

    public void e(float var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (!this.v) {
            if (this.l == 0.0F) {
                this.v = true;
                this.q = true;
            }
        } else {
            if (this.w == null || !this.w.bT() || this.w.bV || !this.r) {
                this.w = this.R.as();
                if (this.w != null && !this.a(this.w, true)) {
                    this.w = null;
                }
            }

            if (this.w != null) {
                boolean var3;
                if (this.q) {
                    this.u += var1;
                    if (!this.r) {
                        this.t = class_340.a(this.t, var1);
                        if (this.t == 0.0F) {
                            this.t = 20.0F;
                            this.h();
                        }
                    } else {
                        var3 = false;
                        Iterator var4 = this.F.iterator();

                        OrderableUnit var5;
                        while(var4.hasNext()) {
                            var5 = (OrderableUnit)var4.next();
                            if (this.c(var5) > 28900.0F) {
                                var3 = true;
                            }
                        }

                        if (!var3) {
                            this.q = false;
                        }

                        var4 = this.F.iterator();

                        while(var4.hasNext()) {
                            var5 = (OrderableUnit)var4.next();
                            if (var5.bs > var2.by - 1000) {
                                this.q = false;
                                this.a("Not staging due to damage");
                            }
                        }
                    }

                    if (this.u > 17000.0F) {
                        this.q = false;
                        this.a("attacking target");
                    }
                } else {
                    this.o += var1;
                    if (this.z == 0.0F) {
                        this.z = 800.0F;
                        var3 = false;
                        class_684 var8 = new class_684();
                        Iterator var9 = this.F.iterator();

                        while(var9.hasNext()) {
                            OrderableUnit var6 = (OrderableUnit)var9.next();
                            boolean var7 = true;
                            if (this.w != null) {
                                if (!this.R.a((Unit)var6, (Unit)this.w)) {
                                    var7 = false;
                                }

                                if (var7 && !class_1050.a(var6, this.w)) {
                                    var7 = false;
                                }
                            }

                            if (var7) {
                                var3 = true;
                                var8.add(var6);
                            }
                        }

                        if (!var3) {
                            this.q = false;
                            this.a("cannot reach main target");
                        } else {
                            SyncPacket var10 = var2.cf.a((PlayerData)this.R);
                            var10.a((AbstractList)var8);
                            boolean var11 = true;
                            if (this.w != null && class_340.rand(0, 100) < 80) {
                                var10.a(this.w.xCord, this.w.yCord, var11);
                            } else {
                                var10.a(this.w, var11);
                            }

                            this.a("attacking main target");
                        }
                    }
                }
            }
        }

        if (this.v) {
            if (this.F.size() == 0) {
                this.p();
            }

            if (this.o > 1000.0F && this.F.size() < 3) {
                this.p();
            }

            if (this.o > 11000.0F) {
                this.p();
            }
        }

    }

    public void h() {
        float var1 = this.w.xCord;
        float var2 = this.w.yCord;
        float var3 = class_340.d(var1, var2, this.S, this.T);
        float var4 = class_340.b(var1, var2, this.S, this.T);
        if (class_340.rand(0, 100) < 80) {
            var3 += (float)class_340.rand(-110, 110);
        }

        int var5 = (int)((double)var4 * 0.6);
        if (var5 < 720) {
            var5 = 720;
        }

        float var6 = (float)class_340.rand(50, var5);
        if (class_340.rand(0, 100) < 80 && var6 < 450.0F) {
            var6 = (float)class_340.rand(450, var5);
        }

        var1 += class_340.k(var3) * var6;
        var2 += class_340.j(var3) * var6;
        boolean var7 = true;
        if (!this.a(var1, var2)) {
            var7 = false;
        }

        boolean var8 = false;
        boolean var9 = false;
        Iterator var10 = this.F.iterator();

        OrderableUnit var11;
        while(var10.hasNext()) {
            var11 = (OrderableUnit)var10.next();
            if (var11.h() == MovementType.LAND) {
                var8 = true;
            }

            if (var11.h() == MovementType.WATER) {
                var9 = true;
            }
        }

        if (var8) {
            if (this.R.aG == 0 && !this.b(var1, var2)) {
                var7 = false;
            }

            if (!this.R.a(var1, var2, this.w.xCord, this.w.yCord, MovementType.LAND) && class_340.rand(0, 100) < 98) {
                var7 = false;
            }
        }

        if (var9) {
            if (!this.b(var1, var2)) {
                var7 = false;
            }

            if (!this.R.a(var1, var2, this.w.xCord, this.w.yCord, MovementType.WATER)) {
                var7 = false;
            }
        }

        if (var7) {
            this.S = var1;
            this.T = var2;
            this.z = 0.0F;
            this.r = true;
            this.G.clear();
            var10 = this.F.iterator();

            while(var10.hasNext()) {
                var11 = (OrderableUnit)var10.next();
                if (var11.h() != MovementType.WATER && !this.R.a(var11, this.S, this.T)) {
                    this.G.add(var11);
                }
            }
        }

    }

    public MovementType i() {
        return this.E;
    }

    public MovementType j() {
        if (this.F.size() == 0) {
            return this.B ? MovementType.WATER : MovementType.LAND;
        } else {
            boolean var1 = true;
            Iterator var2 = this.F.iterator();

            while(var2.hasNext()) {
                OrderableUnit var3 = (OrderableUnit)var2.next();
                MovementType var4 = var3.h();
                if (var4 != MovementType.AIR) {
                    var1 = false;
                    break;
                }
            }

            if (var1) {
                return MovementType.AIR;
            } else {
                MovementType var5;
                boolean var6;
                Iterator var7;
                OrderableUnit var8;
                if (this.B) {
                    var6 = true;
                    var7 = this.F.iterator();

                    while(var7.hasNext()) {
                        var8 = (OrderableUnit)var7.next();
                        var5 = var8.h();
                        if (var5 == MovementType.WATER) {
                            var6 = false;
                        }
                    }

                    if (var6) {
                        return MovementType.HOVER;
                    } else {
                        return MovementType.WATER;
                    }
                } else {
                    var6 = true;
                    var7 = this.F.iterator();

                    while(true) {
                        do {
                            if (!var7.hasNext()) {
                                if (var6) {
                                    return MovementType.HOVER;
                                }

                                return MovementType.LAND;
                            }

                            var8 = (OrderableUnit)var7.next();
                            var5 = var8.h();
                        } while(var5 != MovementType.LAND && var5 != MovementType.OVER_CLIFF);

                        var6 = false;
                    }
                }
            }
        }
    }

    public boolean a(float var1, float var2) {
        return !class_694.a(var1, var2, this.i());
    }

    public boolean b(float var1, float var2) {
        Iterator var3 = this.F.iterator();

        OrderableUnit var4;
        do {
            if (!var3.hasNext()) {
                return true;
            }

            var4 = (OrderableUnit)var3.next();
        } while(this.R.a(var4, var1, var2));

        return false;
    }

    public boolean a(Unit var1, boolean var2) {
        Iterator var3 = this.F.iterator();

        OrderableUnit var4;
        do {
            do {
                if (!var3.hasNext()) {
                    return false;
                }

                var4 = (OrderableUnit)var3.next();
            } while(!var2 && !this.R.a(var4, var1.xCord, var1.yCord));
        } while(!class_1050.a(var4, var1));

        return true;
    }

    public void k() {
        boolean var1 = true;
        PointF var2 = null;
        if (this.c && this.g != null) {
            this.S = this.g.xCord;
            this.T = this.g.yCord;
            this.k = this.R.c(this.g.xCord, this.g.yCord);
        } else {
            if (var1) {
                label80:
                for(int var3 = 0; var3 < 7; ++var3) {
                    boolean var4 = var3 > 3;
                    if (var2 == null) {
                        Iterator var5 = this.R.bn.iterator();

                        while(true) {
                            class_69 var7;
                            do {
                                do {
                                    do {
                                        class_63 var6;
                                        do {
                                            if (!var5.hasNext()) {
                                                continue label80;
                                            }

                                            var6 = (class_63)var5.next();
                                        } while(!(var6 instanceof class_69));

                                        var7 = (class_69)var6;
                                    } while(var7.b != class_658.ACTIVE);
                                } while(var7.u() <= 2 && !var4);
                            } while(var2 != null && class_340.c(this.R.ay + 2) != 0);

                            for(int var8 = 0; var8 < 10; ++var8) {
                                if (var2 == null) {
                                    PointF var9 = var7.w();
                                    if (this.a(var9.x, var9.y)) {
                                        var2 = var9;
                                    }
                                }
                            }

                            this.k = var7;
                        }
                    }
                }
            }

            if (var2 == null) {
                var2 = this.R.am();
                this.k = null;
            }

            this.S = var2.x;
            this.T = var2.y;
        }
    }
}
