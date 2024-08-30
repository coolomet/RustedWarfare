package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_984;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.units.au
public final strictfp class class_1042 {
    WaypointType a;
    class_31 b;
    class_1059 c;
    int d;
    float e = 1.0F;
    float f = 1.0F;
    long g = -1L;
    Unit h;
    public class_984 i;
    public boolean j;
    public float k = -1.0F;
    public float l = -1.0F;
    public boolean m;
    public boolean n;

    public strictfp boolean a(class_1042 var1) {
        return !(class_340.c(this.e - var1.e) > 3.0F) && !(class_340.c(this.f - var1.f) > 3.0F);
    }

    public strictfp boolean b(class_1042 var1) {
        if (var1 == null) {
            return false;
        } else if (this.a != var1.a) {
            return false;
        } else if (this.b != var1.b) {
            return false;
        } else if (!(class_340.c(this.e - var1.e) > 1.0F) && !(class_340.c(this.f - var1.f) > 1.0F)) {
            if (this.d != var1.d) {
                return false;
            } else {
                return this.h == var1.h;
            }
        } else {
            return false;
        }
    }

    public strictfp class_31 a() {
        return this.b;
    }

    public strictfp int b() {
        return this.d;
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeEnum(this.a);
        var1.a(this.b);
        var1.writeFloat(this.e);
        var1.writeFloat(this.f);
        if (this.g != -1L) {
            var1.writeLong(this.g);
        } else {
            var1.a(this.h);
        }

        var1.writeByte(this.d);
        var1.writeFloat(this.k);
        var1.writeFloat(this.l);
        var1.writeBoolean(this.m);
        var1.writeBoolean(this.j);
        var1.writeBoolean(this.n);
        class_1059.a(var1, this.c);
    }

    public strictfp void a(GameInputStream var1) {
        this.a = (WaypointType)var1.readEnum(WaypointType.class);
        this.b = var1.q();
        this.e = var1.readFloat();
        this.f = var1.readFloat();
        this.g = var1.m5452n();
        this.h = null;
        if (var1.b() >= 40) {
            this.d = var1.readByte();
        }

        if (var1.b() >= 46) {
            this.k = var1.readFloat();
            this.l = var1.readFloat();
        }

        if (var1.b() >= 58) {
            this.m = var1.readBoolean();
        }

        if (var1.b() >= 65) {
            this.j = var1.readBoolean();
        }

        if (var1.b() >= 79) {
            this.n = var1.readBoolean();
        }

        if (var1.b() >= 82) {
            this.c = class_1059.a(var1);
        }

    }

    public strictfp void convertUnitIds() {
        if (this.g != -1L) {
            this.h = GameObject.a(this.g, true);
            if (this.h == null) {
                GameEngine.print("convertUnitIds failed");
                if (this.a != null) {
                    GameEngine.print("convertUnitIds: type:" + this.a.toString());
                }

                if (this.b != null) {
                    GameEngine.print("convertUnitIds: build:" + this.b.toString());
                }

                GameEngine.print("convertUnitIds: x:" + this.e + ", y:" + this.f);
            }

            this.g = -1L;
        }

    }

    public strictfp WaypointType d() {
        return this.a;
    }

    public strictfp void e() {
        this.a = WaypointType.move;
        this.b = null;
        this.d = 1;
        this.e = 2.0F;
        this.f = 2.0F;
        this.g = -1L;
        this.h = null;
        this.i = null;
        this.k = -1.0F;
        this.l = -1.0F;
        this.m = false;
        this.j = false;
        this.n = false;
        this.c = null;
    }

    public strictfp boolean f() {
        return this.a == WaypointType.attack || this.a == WaypointType.repair || this.a == WaypointType.reclaim || this.a == WaypointType.loadInto || this.a == WaypointType.loadUp || this.a == WaypointType.guard || this.a == WaypointType.touchTarget || this.a == WaypointType.follow;
    }

    public strictfp float g() {
        return this.f() && this.h != null ? this.h.xCord : this.e;
    }

    public strictfp float h() {
        return this.f() && this.h != null ? this.h.yCord : this.f;
    }

    public strictfp Unit i() {
        return this.h;
    }

    public strictfp void a(float var1, float var2) {
        this.e();
        this.a = WaypointType.move;
        this.e = var1;
        this.f = var2;
    }

    public strictfp void b(float var1, float var2) {
        this.e();
        this.a = WaypointType.attackMove;
        this.e = var1;
        this.f = var2;
    }

    public strictfp void a(Unit var1) {
        this.e();
        this.a = WaypointType.attack;
        this.h = var1;
    }

    public strictfp void a(float var1, float var2, class_31 var3, int var4) {
        this.e();
        this.a = WaypointType.build;
        this.e = var1;
        this.f = var2;
        this.b = var3;
        byte var5 = (byte)var4;
        this.d = var5;
    }

    public strictfp void b(Unit var1) {
        this.e();
        this.a = WaypointType.repair;
        this.h = var1;
    }

    public strictfp void c(Unit var1) {
        this.e();
        this.a = WaypointType.guard;
        this.h = var1;
    }

    public strictfp void d(Unit var1) {
        this.e();
        this.a = WaypointType.touchTarget;
        this.h = var1;
    }

    public strictfp void e(Unit var1) {
        this.e();
        this.a = WaypointType.follow;
        this.h = var1;
    }

    public strictfp void c(float var1, float var2) {
        this.e();
        this.a = WaypointType.patrol;
        this.e = var1;
        this.f = var2;
    }

    public strictfp void f(Unit var1) {
        this.e();
        this.a = WaypointType.reclaim;
        this.h = var1;
    }

    public strictfp void g(Unit var1) {
        this.e();
        this.a = WaypointType.loadInto;
        this.h = var1;
    }

    public strictfp void h(Unit var1) {
        this.e();
        this.a = WaypointType.loadUp;
        this.h = var1;
    }

    public strictfp void c(class_1042 var1) {
        this.e();
        this.a = var1.a;
        this.b = var1.b;
        this.e = var1.e;
        this.f = var1.f;
        this.h = var1.h;
        this.i = var1.i;
        this.d = var1.d;
        this.j = var1.j;
        this.c = var1.c;
    }

    public strictfp long j() {
        long var1 = 0L;
        if (this.a != null) {
            var1 += (long)this.a.ordinal();
        }

        return var1;
    }

    public strictfp void k() {
        if (this.h != null) {
            this.g = this.h.id;
            this.h = null;
        }

        this.i = null;
    }

    public strictfp Unit l() {
        if (this.f()) {
            Unit var2 = this.i();
            return var2;
        } else {
            OrderableUnit var1 = PlayerData.i.t;
            var1.cg = 0.0F;
            var1.xCord = this.e;
            var1.yCord = this.f;
            var1.zCord = 0.0F;
            return var1;
        }
    }
}
