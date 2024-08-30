package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.Side;
import com.corrodinggames.rts.game.units.WaypointType;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.class_598;
import com.corrodinggames.rts.game.units.custom.class_601;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_684;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.b
public strictfp class class_786 extends class_776 {
    public boolean a;
    public boolean b;
    public WaypointType c;
    public class_601 d;
    public boolean e;
    public class_588 f;
    public Side g;
    public float h;
    public boolean i;
    public class_588 j;
    public Side k;
    public float l;
    public boolean m;
    public boolean n;
    public PointF o;
    public PointF p;
    public PointF q;
    public LogicBoolean r;
    public float s = -1.0F;
    public class_598 t;
    public class_598 u;
    public static class_1042 v = new class_1042();
    public static final class_309 w = new class_309();

    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        boolean var7 = false;
        boolean var8 = var1.getValueAsBoolean(var2, var3 + "clearAllWaypoints", false);
        if (var8) {
            var7 = true;
        }

        boolean var9 = var1.getValueAsBoolean(var2, var3 + "clearActiveWaypoint", false);
        if (var9) {
            var7 = true;
        }

        WaypointType var10 = (WaypointType)var1.a((String)var2, "addWaypoint_type", (Enum)null, (Class) WaypointType.class);
        boolean var11 = var1.getValueAsBoolean(var2, var3 + "addWaypoint_prepend", false);
        class_588 var12 = var1.a((class_591)var0, var2, (String)(var3 + "addWaypoint_target_nearestUnit_tagged"), (class_588)null);
        Side var13 = (Side)var1.a((String)var2, "addWaypoint_target_nearestUnit_team", (Enum) Side.OWN, (Class)Side.class);
        float var14 = var1.getValueAsFloatOrDefault(var2, var3 + "addWaypoint_target_nearestUnit_maxRange", 10000.0F);
        class_588 var15 = var1.a((class_591)var0, var2, (String)(var3 + "addWaypoint_target_randomUnit_tagged"), (class_588)null);
        Side var16 = (Side)var1.a((String)var2, "addWaypoint_target_randomUnit_team", (Enum) Side.OWN, (Class)Side.class);
        float var17 = var1.getValueAsFloatOrDefault(var2, var3 + "addWaypoint_target_randomUnit_maxRange", 10000.0F);
        float var18 = var1.b(var2, var3 + "addWaypoint_maxTime", -1.0F);
        class_598 var19 = var1.a((class_591)var0, var2, (String)(var3 + "addWaypoint_triggerActionIfFailed"), (class_598)null);
        class_598 var20 = var1.a((class_591)var0, var2, (String)(var3 + "addWaypoint_triggerActionIfMatched"), (class_598)null);
        PointF var21 = var1.getValueAsPointFOrDefault(var2, var3 + "addWaypoint_position_offsetFromSelf", (PointF)null);
        PointF var22 = var1.getValueAsPointFOrDefault(var2, var3 + "addWaypoint_position_relativeOffsetFromSelf", (PointF)null);
        PointF var23 = var1.getValueAsPointFOrDefault(var2, var3 + "addWaypoint_position_randomOffsetFromSelf", (PointF)null);
        boolean var24 = var21 != null || var22 != null || var23 != null;
        boolean var25 = var12 != null;
        boolean var26 = var15 != null;
        boolean var27 = var1.getValueAsBoolean(var2, var3 + "addWaypoint_position_fromAction", false);
        LogicBoolean var28 = var1.b(var0, var2, var3 + "addWaypoint_target_fromReference", (LogicBoolean)null);
        if (var28 != null) {
            var7 = true;
            if (var25 || var26) {
                throw new RuntimeException("[" + var2 + "] addWaypoint_target_nearestUnit/randomUnit and addWaypoint_target_fromReference cannot be used together");
            }

            if (var24) {
                throw new RuntimeException("[" + var2 + "] addWaypoint_position_offset* and addWaypoint_target_fromReference cannot be used together");
            }

            if (var27) {
                throw new RuntimeException("[" + var2 + "] addWaypoint_position_fromAction and addWaypoint_target_fromReference cannot be used together");
            }
        }

        if (var27) {
            var7 = true;
            if (var25 || var26) {
                throw new RuntimeException("[" + var2 + "] addWaypoint_target_* and addWaypoint_position_fromAction cannot be used together");
            }

            if (var24) {
                throw new RuntimeException("[" + var2 + "] addWaypoint_position_offset* and addWaypoint_position_fromAction cannot be used together");
            }
        }

        if ((var25 || var26 || var24 || var28 != null) && var10 == null) {
            throw new RuntimeException("[" + var2 + "] addWaypoint_type is required when using addWaypoint_*");
        } else {
            if (var10 != null) {
                var7 = true;
                if (!var25 && !var26 && !var24 && !var27 && var28 == null) {
                    throw new RuntimeException("[" + var2 + "] addWaypoint_target_nearestUnit_tagged, addWaypoint_position_offsetFromSelf or addWaypoint_target_fromReference is required when using addWaypoint_*");
                }
            }

            if (var24) {
                var7 = true;
                if (var25 || var26) {
                    throw new RuntimeException("[" + var2 + "] addWaypoint_target_* and addWaypoint_position_* cannot be used together");
                }

                if (var10 != WaypointType.move && var10 != WaypointType.attackMove) {
                    throw new RuntimeException("[" + var2 + "] addWaypoint_position_* only supports position based waypoints (eg: move, attackMove)");
                }
            }

            if (var25 && var26) {
                throw new RuntimeException("[" + var2 + "] addWaypoint_target_nearestUnit_* and addWaypoint_target_randomUnit_* cannot be used together");
            } else {
                if (var7) {
                    class_786 var29 = new class_786();
                    var29.a = var8;
                    var29.b = var9;
                    if (var10 != null) {
                        var29.c = var10;
                        if (var29.c == WaypointType.build) {
                            var29.d = var0.a(var1.getValueAsStaticString(var2, var3 + "addWaypoint_unitType", (String)null), var3 + "addWaypoint_unitType", var2);
                            if (var29.d == null) {
                                throw new RuntimeException("[" + var2 + "] addWaypoint_type: build requires addWaypoint_unitType");
                            }
                        }

                        var29.e = var11;
                        var29.f = var12;
                        var29.g = var13;
                        var29.h = var14;
                        var29.j = var15;
                        var29.k = var16;
                        var29.l = var17;
                        if (var26) {
                            var29.i = true;
                        }

                        var29.m = var1.getValueAsBoolean(var2, var3 + "addWaypoint_target_mapMustBeReachable", true);
                        var29.o = var21;
                        var29.p = var22;
                        var29.q = var23;
                        var29.n = var27;
                        var29.r = var28;
                        var29.s = var18;
                        var29.t = var19;
                        var29.u = var20;
                    }

                    var4.ac.add(var29);
                }

            }
        }
    }

    public class_1042 a(class_113 var1, float var2, float var3, Unit var4, int var5) {
        class_1042 var6;
        if (this.s == 0.0F) {
            var6 = v;
            var6.e();
        } else if (this.e) {
            var6 = var1.ao();
            var1.aD();
            var1.aB();
        } else {
            var6 = var1.ap();
        }

        if (this.c == WaypointType.move) {
            var6.a(var2, var3);
        } else if (this.c == WaypointType.attackMove) {
            var6.b(var2, var3);
        } else if (this.c == WaypointType.guard && var4 != null) {
            var6.c(var4);
        } else if (this.c == WaypointType.follow && var4 != null) {
            var6.e(var4);
        } else if (this.c == WaypointType.loadInto && var4 != null) {
            var6.g(var4);
        } else if (this.c == WaypointType.loadUp && var4 != null) {
            var6.h(var4);
        } else if (this.c == WaypointType.attack && var4 != null) {
            var6.a(var4);
        } else if (this.c == WaypointType.reclaim && var4 != null) {
            var6.f(var4);
        } else if (this.c == WaypointType.repair && var4 != null) {
            var6.b(var4);
        } else if (this.c == WaypointType.touchTarget && var4 != null) {
            var6.d(var4);
        } else if (this.c == WaypointType.build) {
            var6.a(var2, var3, this.d.c(), 1);
        } else {
            var1.ay();
        }

        var6.l = this.s;
        var6.n = true;
        if (this.u != null) {
            PointF var7 = new PointF(var6.g(), var6.h());
            this.u.a(var1, var7, var6.i(), var5 + 1, 0);
        }

        return var6;
    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        if (this.a) {
            var1.az();
        } else if (this.b) {
            var1.ay();
        }

        if (this.c != null) {
            if (this.r != null) {
                Unit var6 = this.r.readUnit(var1);
                if (var6 != null) {
                    this.a(var1, var6.xCord, var6.yCord, var6, var5);
                } else if (this.t != null) {
                    this.t.a(var1, var3, var4, var5 + 1, 0);
                }
            } else if (this.n) {
                if (var3 == null) {
                    if (this.t != null) {
                        this.t.a(var1, var3, var4, var5 + 1, 0);
                    }
                } else {
                    this.a(var1, var3.x, var3.y, (Unit)null, var5);
                }
            } else if (this.o == null && this.p == null && this.q == null) {
                GameEngine var16;
                if (this.i) {
                    w.c = this.l * this.l;
                    w.b = this.j;
                    w.d = false;
                    w.h = null;
                    w.e = this.k;
                    w.a = this.m;
                    w.f = true;
                    w.g.clear();
                    var16 = GameEngine.getGameEngine();
                    var16.cc.a(var1.xCord, var1.yCord, this.l, var1, 0.0F, w);
                    if (w.g.size() == 0) {
                        if (this.t != null) {
                            this.t.a(var1, var3, var4, var5 + 1, 0);
                        }
                    } else {
                        class_684 var17 = w.g;
                        int var15 = class_340.a((GameObject) var1, 0, var17.size(), 0);
                        ++var1.bC;
                        if (var15 > var17.size() - 1) {
                            var15 = var17.size() - 1;
                        }

                        Unit var18 = (Unit)var17.get(var15);
                        this.a(var1, var18.xCord, var18.yCord, var18, var5);
                    }
                } else {
                    w.c = this.h * this.h;
                    w.b = this.f;
                    w.d = false;
                    w.h = null;
                    w.e = this.g;
                    w.a = this.m;
                    w.f = false;
                    var16 = GameEngine.getGameEngine();
                    var16.cc.a(var1.xCord, var1.yCord, this.h, var1, 0.0F, w);
                    if (w.h == null) {
                        if (this.t != null) {
                            this.t.a(var1, var3, var4, var5 + 1, 0);
                        }
                    } else {
                        Unit var19 = w.h;
                        this.a(var1, var19.xCord, var19.yCord, var19, var5);
                    }
                }
            } else {
                float var14 = var1.xCord;
                float var7 = var1.yCord;
                if (this.o != null) {
                    var14 += this.o.x;
                    var7 += this.o.y;
                }

                if (this.p != null) {
                    float var8 = this.p.x;
                    float var9 = this.p.y;
                    float var10 = class_340.k(var1.cg);
                    float var11 = class_340.j(var1.cg);
                    float var12 = var10 * var9 - var11 * var8;
                    float var13 = var11 * var9 + var10 * var8;
                    var14 += var12;
                    var7 += var13;
                }

                if (this.q != null) {
                    var14 += (float)class_340.a((GameObject)var1, -((int)this.q.x), (int)this.q.x, var5 + 1);
                    var7 += (float)class_340.a((GameObject)var1, -((int)this.q.y), (int)this.q.y, var5 + 2);
                }

                this.a(var1, var14, var7, (Unit)null, var5);
            }
        }

        return true;
    }
}
