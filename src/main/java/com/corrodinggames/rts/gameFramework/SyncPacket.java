package com.corrodinggames.rts.gameFramework;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.WaypointType;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.class_122;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.AttackMode;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.a.class_1059;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.a.class_233;
import com.corrodinggames.rts.game.units.buildings.class_8;
import com.corrodinggames.rts.gameFramework.f.class_517;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Iterator;

public strictfp class SyncPacket {
    public boolean a;
    public String b;
    public int localTick;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public PlayerData i;
    public class_1042 j;
    public class_1059 k;
    public PointF l;
    public Unit m;
    public AttackMode n;
    private PointF z;
    public boolean o;
    public PlayerData p;
    public short q;
    public boolean r;
    public float s;
    public float t;
    public int u;
    private class_684 A;
    class_684 v;
    class_684 w;
    public boolean x;
    // $FF: synthetic field
    final CommandController y;

    public SyncPacket(CommandController var1) {
        this.y = var1;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.k = class_226.i;
        this.o = false;
        this.A = new class_684();
        this.v = new class_684();
        this.w = new class_684();
        this.x = false;
    }

    public strictfp boolean a() {
        Iterator var1 = this.w.iterator();

        class_353 var2;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            var2 = (class_353)var1.next();
        } while(var2.a.a() != null);

        return false;
    }

    public strictfp void b() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.x = true;
        class_984 var2 = var1.bV.c();
        Iterator var3 = this.v.iterator();

        while(var3.hasNext()) {
            OrderableUnit var4 = (OrderableUnit)var3.next();
            var2.a.add(var4);
        }

        if (this.j != null) {
            float var15 = this.j.g();
            float var16 = this.j.h();
            if (this.j.d() == WaypointType.move || this.j.d() == WaypointType.attackMove || this.j.d() == WaypointType.attack) {
                class_684 var5 = var2.a(var15, var16, this.j.j);
                Iterator var6 = var5.iterator();

                while(true) {
                    OrderableUnit var7;
                    do {
                        do {
                            do {
                                if (!var6.hasNext()) {
                                    return;
                                }

                                var7 = (OrderableUnit)var6.next();
                            } while(var7.aK());
                        } while(!var7.I());
                    } while(this.e && var7.ar() != null);

                    int var10 = 0;
                    if (this.j.d() == WaypointType.attack) {
                        var10 = var7.q(this.j.i());
                    }

                    boolean var11 = true;
                    class_353 var12 = new class_353();
                    var12.b = var7.id;
                    var12.c = var7.xCord;
                    var12.d = var7.yCord;
                    var12.e = var15;
                    var12.f = var16;
                    var12.g = var1.tick;
                    var12.h = var7.h();
                    boolean var13 = false;
                    boolean var14 = false;
                    var12.a = var7.a(var15, var16, var10, var11, var13, var14);
                    var12.a.t = 120.0F;
                    var12.a.s = var12.a.t;
                    var12.a.u = true;
                    this.w.add(var12);
                }
            }
        }
    }

    public strictfp PlayerData c() {
        return this.i;
    }

    public strictfp int d() {
        return this.A.size() + this.v.size();
    }

    public strictfp boolean e() {
        if (class_226.c(this.k)) {
            return false;
        } else {
            return this.d() == 0;
        }
    }

    public strictfp synchronized SyncPacket clone() {
        try {
            GameOutputStream var1 = new GameOutputStream();
            this.write(var1);
            GameInputStream var2 = new GameInputStream(var1.toByteArray());
            SyncPacket var3 = new SyncPacket(this.y);
            var3.localTick = this.localTick;
            var3.read(var2);
            return var3;
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    public strictfp void g() {
        if (this.j != null) {
            Iterator var1 = this.v.iterator();

            while(var1.hasNext()) {
                OrderableUnit var2 = (OrderableUnit)var1.next();
                this.A.add(var2.id);
            }

            this.v.clear();
            this.j.k();
        }

    }

    public strictfp synchronized void write(GameOutputStream var1) {
        var1.e("c");
        var1.writeByte(this.i.site);
        var1.writeBoolean(this.j != null);
        if (this.j != null) {
            this.j.a(var1);
        }

        var1.writeBoolean(this.e);
        var1.writeBoolean(this.g);
        var1.writeInt(-1);
        var1.writeEnum(this.n);
        var1.writeBoolean(this.z != null);
        if (this.z != null) {
            var1.writeFloat(this.z.x);
            var1.writeFloat(this.z.y);
        }

        var1.writeBoolean(this.o);
        var1.writeInt(this.v.size() + this.A.size());
        Iterator var2 = this.v.iterator();

        while(var2.hasNext()) {
            OrderableUnit var3 = (OrderableUnit)var2.next();
            var1.writeLong(var3.id);
        }

        var2 = this.A.iterator();

        while(var2.hasNext()) {
            long var6 = (Long)var2.next();
            var1.writeLong(var6);
        }

        var1.writeBoolean(this.p != null);
        if (this.p != null) {
            var1.a(this.p);
        }

        var1.writeBoolean(this.l != null);
        if (this.l != null) {
            var1.writeFloat(this.l.x);
            var1.writeFloat(this.l.y);
        }

        var1.a(this.m);
        var1.writeString(this.k.a());
        var1.writeBoolean(this.f);
        var1.a(this.q);
        var1.writeBoolean(this.r);
        if (this.r) {
            var1.writeByte(0);
            var1.writeFloat(this.s);
            var1.writeFloat(this.t);
            var1.writeInt(this.u);
        }

        var1.writeInt(this.w.size());

        for(int var5 = 0; var5 < this.w.size(); ++var5) {
            class_353 var7 = (class_353)this.w.get(var5);
            var7.a(var1);
        }

        var1.writeBoolean(this.h);
        var1.endBlock("c");
    }

    @SneakyThrows
    public strictfp void read(GameInputStream var1) {
        var1.startBlock("c");
        this.i = PlayerData.getPlayerData(var1.readByte());
        if (this.i == null) {
            throw new IOException("team==null");
        } else {
            boolean var2 = var1.readBoolean();
            if (var2) {
                this.j = new class_1042();
                this.j.a(var1);
            }

            this.e = var1.readBoolean();
            this.g = var1.readBoolean();
            this.k = class_1059.a(String.valueOf(var1.readInt()));
            this.n = (AttackMode)var1.readEnum(AttackMode.class);
            boolean var3 = var1.readBoolean();
            if (var3) {
                this.z = new PointF();
                this.z.x = var1.readFloat();
                this.z.y = var1.readFloat();
            }

            this.o = var1.readBoolean();
            int var4 = var1.readInt();

            int var5;
            for(var5 = 0; var5 < var4; ++var5) {
                this.A.add(var1.m5452n());
            }

            if (var1.b() >= 16) {
                this.p = null;
                if (var1.readBoolean()) {
                    this.p = var1.s();
                }
            }

            if (var1.b() >= 29) {
                boolean var8 = var1.readBoolean();
                if (var8) {
                    this.l = new PointF();
                    this.l.x = var1.readFloat();
                    this.l.y = var1.readFloat();
                }

                this.m = var1.o();
            }

            if (var1.b() >= 33) {
                this.k = class_1059.a(var1.readString());
            }

            if (var1.b() >= 37) {
                this.f = var1.readBoolean();
            }

            if (var1.b() >= 52) {
                this.q = var1.readShort();
            }

            if (var1.b() >= 53) {
                this.r = var1.readBoolean();
                if (this.r) {
                    var1.readByte();
                    this.s = var1.readFloat();
                    this.t = var1.readFloat();
                    this.u = var1.readInt();
                }

                var5 = var1.readInt();
                this.w.clear();

                for(int var6 = 0; var6 < var5; ++var6) {
                    class_353 var7 = new class_353();
                    var7.a(var1);
                    this.w.add(var7);
                }
            }

            if (var1.b() >= 80) {
                this.h = var1.readBoolean();
            }

            var1.endBlock("c");
        }
    }

    public strictfp void a(AbstractList var1) {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            OrderableUnit var3 = (OrderableUnit)var2.next();
            this.a(var3);
        }

    }

    public strictfp void a(OrderableUnit var1) {
        if (var1 == null) {
            throw new RuntimeException("unit cannot be null");
        } else {
            if (var1.bX != this.i) {
            }

            if (this.i.w) {
                if (var1.bX != this.i && GameEngine.getGameEngine().playerTeam != this.i) {
                    GameEngine.b("CommandController", "Warning AI: " + this.i.site + " gave an order to unit with team:" + var1.bX.site + " type:" + var1.r().i());
                    GameEngine.warn("");
                }

                if (var1.cW()) {
                    GameEngine.b("CommandController", "Warning AI: " + this.i.site + " gave an order to unit with canNotBeGivenOrdersByPlayer: " + var1.r().i());
                }
            }

            this.v.add(var1);
        }
    }

    public strictfp void h() {
        this.o = true;
    }

    public strictfp void a(float var1, float var2) {
        this.j = new class_1042();
        this.j.a(var1, var2);
    }

    public strictfp void b(float var1, float var2) {
        this.j = new class_1042();
        this.j.b(var1, var2);
    }

    public strictfp void a(Unit var1) {
        this.j = new class_1042();
        this.j.a(var1);
    }

    public strictfp void a(float var1, float var2, boolean var3) {
        this.j = new class_1042();
        this.j.b(var1, var2);
        this.j.j = var3;
    }

    public strictfp void a(Unit var1, boolean var2) {
        this.j = new class_1042();
        this.j.a(var1);
        this.j.j = var2;
    }

    public strictfp void a(float var1, float var2, class_31 var3, int var4) {
        this.j = new class_1042();
        this.j.a(var1, var2, var3, var4);
    }

    public strictfp void b(Unit var1) {
        this.j = new class_1042();
        this.j.b(var1);
    }

    public strictfp void c(Unit var1) {
        this.j = new class_1042();
        this.j.c(var1);
    }

    public strictfp void c(float var1, float var2) {
        this.j = new class_1042();
        this.j.c(var1, var2);
    }

    public strictfp void d(Unit var1) {
        this.j = new class_1042();
        this.j.f(var1);
    }

    public strictfp void e(Unit var1) {
        this.j = new class_1042();
        this.j.g(var1);
    }

    public strictfp void f(Unit var1) {
        this.j = new class_1042();
        this.j.h(var1);
    }

    public strictfp void a(class_1059 var1) {
        this.k = var1;
    }

    public strictfp void a(class_1059 var1, PointF var2, Unit var3) {
        this.k = var1;
        this.l = var2;
        this.m = var3;
    }

    public strictfp void a(AttackMode var1) {
        this.n = var1;
    }

    public strictfp void a(PointF var1) {
        this.z = var1;
    }

    public strictfp synchronized void i() {
        Iterator var1 = this.A.iterator();

        while(var1.hasNext()) {
            Long var2 = (Long)var1.next();
            OrderableUnit var3 = GameObject.b(var2, true);
            if (var3 != null) {
                this.v.add(var3);
            }
        }

        this.A.clear();
        var1 = this.v.iterator();

        while(var1.hasNext()) {
            OrderableUnit var4 = (OrderableUnit)var1.next();
            if (var4.bV) {
                var1.remove();
            }
        }

    }

    public strictfp void j() {
        if (class_226.c(this.k)) {
            Iterator var1 = this.v.iterator();

            while(var1.hasNext()) {
                OrderableUnit var2 = (OrderableUnit)var1.next();
                var2.b((class_226)var2.a((class_1059)this.k), this.g);
            }
        }

    }

    public strictfp void k() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (!var1.replayEngine.j() || this.a) {
            this.i();
            OrderableUnit var6;
            Iterator var8;
            boolean var13;
            OrderableUnit var16;
            if (this.r) {
                if (this.s != 0.0F) {
                    GameEngine.log("issueCommand: changeStepRate:" + this.s);
                    var1.netEngine.setCurrentStepRate(this.s, "command");
                } else if (this.u != 0) {
                    GameEngine.log("system action:" + this.u);
                    class_122 var20;
                    if (this.u == 1) {
                        GameEngine.log("new DebugDesyncDetector");
                        var20 = new class_122(false);
                        var20.b(PlayerData.i);
                    } else if (this.u == 2) {
                        GameEngine.log("new DebugDesyncDetector (stress test)");
                        var20 = new class_122(false);
                        var20.b(PlayerData.i);
                        var20.a = true;
                    } else if (this.u == 100) {
                        GameEngine.log("team surrender");
                        if (this.i == null) {
                            GameEngine.log("team not found");
                        } else {
                            if (var1.netEngine.isServer) {
                                var1.netEngine.j("'" + this.i.name + "' has surrendered");
                            }

                            this.i.E = true;
                            var8 = Unit.bE.iterator();

                            while(var8.hasNext()) {
                                Unit var22 = (Unit)var8.next();
                                if (var22.bX == this.i && var22 instanceof OrderableUnit) {
                                    var16 = (OrderableUnit)var22;
                                    var16.c(false);
                                }
                            }

                        }
                    } else if (this.u == 200) {
                        GameEngine.log("queue quick resync");
                        var1.netEngine.N = true;
                    } else if (this.u == 5) {
                        GameEngine.log("system command spawn");
                        if (this.j != null && this.j.d() == WaypointType.build && this.j.a() != null) {
                            int var18 = this.j.b();
                            class_31 var19 = this.j.a();
                            var13 = false;
                            if (this.i != null && this.i == var1.playerTeam && var1.playerTeam.a(false, false) == 0) {
                                var13 = true;
                            }

                            Unit var24 = var19.a();
                            var24.xCord = this.j.g();
                            var24.yCord = this.j.h();
                            if (this.i != null) {
                                var24.f(this.i);
                            } else {
                                var24.f(PlayerData.i);
                            }

                            var24.B((Unit)null);
                            if (var18 != 1 && var24 instanceof OrderableUnit) {
                                ((OrderableUnit)var24).a(var18);
                            }

                            var24.cP();
                            if (var24 instanceof OrderableUnit) {
                                var6 = (OrderableUnit)var24;
                                var6.br();
                                if (var24.bI()) {
                                    var1.bU.a(var6);
                                }
                            }

                            PlayerData.c(var24);
                            if (var1.playerTeam == var24.bX && var24.bX != PlayerData.i && !var24.u() && var13) {
                                var1.b(var24.xCord, var24.yCord);
                                var1.bS.j(var24);
                            }

                        } else {
                            GameEngine.log("system command spawn - failed");
                        }
                    } else {
                        GameEngine.log("issueCommand: unknown system action:" + this.u);
                    }
                } else {
                    GameEngine.log("issueCommand: Null System action");
                }
            } else {
                if (this.p != null) {
                    this.p.Y = System.currentTimeMillis();
                    this.p.Z = var1.by;
                }

                OrderableUnit var3;
                String var15;
                if (this.p != null) {
                    String var2 = null;
                    var3 = null;
                    Iterator var4 = this.v.iterator();

                    while(true) {
                        while(var4.hasNext()) {
                            OrderableUnit var5 = (OrderableUnit)var4.next();
                            if (var5.bX != this.p && !this.a(this.p, var5.bX)) {
                                if (var2 == null) {
                                    var2 = "";
                                } else {
                                    var2 = var2 + ", ";
                                }

                                if (var3 == null) {
                                    var3 = var5;
                                }

                                var2 = var2 + var5.id;
                                var4.remove();
                            } else if (var5.cW()) {
                                CommandController.a("Warning unit: " + var5.id + " has canNotBeGivenOrdersByPlayer set");
                                var4.remove();
                            }
                        }

                        if (var2 != null) {
                            GameNetEngine.a("Player(" + this.p.site + ") " + this.p.name + " cannot control units: " + var2, true);
                            if (var3 != null) {
                                var15 = "";
                                if (var3.bX != null) {
                                    var15 = var15 + " targetUnitTeamId: " + var3.bX.site + " targetUnitTeamName: " + var3.bX.name;
                                }

                                CommandController.a(var15);
                            }
                        }
                        break;
                    }
                }

                if (this.o) {
                    for(var8 = this.v.iterator(); var8.hasNext(); var3.R = null) {
                        var3 = (OrderableUnit)var8.next();
                        var3.az();
                    }
                }

                if (this.j != null) {
                    this.j.convertUnitIds();
                    class_984 var14 = var1.bV.b();
                    var14.g = this.w;

                    label247:
                    for(int var12 = 0; var12 <= 1; ++var12) {
                        var13 = var12 == 1;
                        Iterator var21 = this.v.iterator();

                        while(true) {
                            while(true) {
                                do {
                                    if (!var21.hasNext()) {
                                        continue label247;
                                    }

                                    var6 = (OrderableUnit)var21.next();
                                } while(var6.ae != var13);

                                if (this.f) {
                                    var6.aA();
                                } else if (!this.e) {
                                    var6.az();
                                } else if (this.h && this.j != null) {
                                    class_1042 var7 = var6.at();
                                    if (var7 != null && this.j.a(var7) && (var7.d() == WaypointType.attackMove || var7.d() == WaypointType.move) && (this.j.d() == WaypointType.attackMove || this.j.d() == WaypointType.move)) {
                                        var6.au();
                                    }
                                }
                            }
                        }
                    }

                    Iterator var17 = this.v.iterator();

                    while(var17.hasNext()) {
                        var16 = (OrderableUnit)var17.next();
                        if (!var16.a(this.j, CommandController.e < 5)) {
                            var15 = "";
                            if (this.p != null) {
                                var15 = "Player(" + this.p.site + ") " + this.p.name + ": ";
                            }

                            CommandController.a(var15 + "isValidNewWaypoint==false on: " + var16.c());
                        } else {
                            class_1042 var23 = var16.d(this.j);
                            var14.a(var16, var23);
                            var16.a(var23);
                        }
                    }

                    var14.b();
                } else {
                    if (class_226.c(this.k)) {
                        var8 = this.v.iterator();

                        while(var8.hasNext()) {
                            var3 = (OrderableUnit)var8.next();
                            class_226 var10 = var3.a((class_1059)this.k);
                            if (var10 == null) {
                                CommandController.a("Could not find specialAction:" + this.k.a() + " on " + var3.r().i());
                            } else if (!var10.b((Unit)var3)) {
                                CommandController.a("!isAvailable specialAction:" + this.k.a() + " on " + var3.r().i() + " (action being skipped)");
                                if (CommandController.a) {
                                    CommandController.a("Command source:" + this.b);
                                }
                            } else {
                                var3.a((class_226)var10);
                                class_517.a(var3, var10);
                                var3.a(var10, this.g, this.l, this.m);
                            }
                        }

                        class_233 var9 = class_233.a(this.k);
                        if (var9 != null) {
                            if (var1.playerTeam != null && this.i != null) {
                                if (this.i.d(var1.playerTeam)) {
                                    var1.bS.a(this.l.x, this.l.y, this.i, var9);
                                }
                            } else {
                                CommandController.a("PingMapAction failed: game.playerTeam==null or this.team==null");
                            }
                        }
                    }

                    if (this.n != null) {
                        for(var8 = this.v.iterator(); var8.hasNext(); var3.P = this.n) {
                            var3 = (OrderableUnit)var8.next();
                        }
                    }

                    if (this.z != null) {
                        var8 = this.v.iterator();

                        while(var8.hasNext()) {
                            var3 = (OrderableUnit)var8.next();
                            if (var3 instanceof class_8) {
                                class_8 var11 = (class_8)var3;
                                var11.a(this.z);
                            }
                        }
                    }

                }
            }
        }
    }

    public strictfp boolean a(PlayerData var1, PlayerData var2) {
        if (var1 != null && var2 != null) {
            if (!var2.d(var1)) {
                return false;
            } else {
                return (this.q & 1 << var2.site) != 0;
            }
        } else {
            return false;
        }
    }

    public strictfp boolean l() {
        this.q = 0;

        for(int var1 = 0; var1 < PlayerData.c; ++var1) {
            PlayerData var2 = PlayerData.getPlayerData(var1);
            if (var2 != null && var2.p()) {
                this.q = (short)(this.q | 1 << var1);
            }
        }

        GameEngine var4 = GameEngine.getGameEngine();
        if (var4.c(true) < 127 && this.j != null && this.j.d() == WaypointType.build) {
            class_31 var5 = this.j.a();
            if (var5 != null) {
                Unit var3 = Unit.a(var5);
                if (var3 != null && !(var3 instanceof OrderableUnit)) {
                    GameEngine.log("Rejecting non OrderableUnit build order: " + var5.i());
                    return false;
                }
            }
        }

        if (this.j != null && this.j.n) {
            GameEngine.log("Rejecting waypoint with addedByAction true");
            return false;
        } else {
            return true;
        }
    }
}
