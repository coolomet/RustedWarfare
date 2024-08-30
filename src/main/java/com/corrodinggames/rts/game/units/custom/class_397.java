package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.b.class_830;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bn
public strictfp class class_397 {
    public String a;
    public String b;
    public boolean c;
    public boolean d;
    public int e;
    public float f;
    public float g;
    public float h;
    public float i = 1.0F;
    public float j;
    public float k;
    public boolean l;
    public float m = -1.0F;
    public float n = 0.0F;
    public float o = 4.0F;
    public float p = 0.0F;
    public float q = 4.0F;
    public float r = 7.0F;
    public boolean s = false;
    public float t;
    public float u = 0.0F;
    public class_447 v;
    public int w = -1;
    public int x = -1;
    public class_397 y;
    public class_397 z;
    public boolean A;
    public boolean B = true;
    public LogicBoolean C;
    public class_392 D;
    public class_605 E;
    public class_605 F;
    public Integer G;
    public boolean H;
    public boolean I;
    public LogicBoolean J;
    public LogicBoolean K;
    public LogicBoolean L;
    public LogicBoolean M;
    public LogicBoolean N;
    public class_588 O;
    public class_588 P;
    public float Q = 5.0F;
    public int R = 0;
    public int S = -1;
    public LogicBoolean T;
    public Float U;
    public float V = -1.0F;
    public float W = -1.0F;
    public float X;
    public float Y;
    public float Z = 0.0F;
    public float aa;
    public float ab = 99999.0F;
    public Boolean ac;
    public float ad;
    public float ae;
    public float af;
    public float ag = -1.0F;
    public float ah = -1.0F;
    public float ai = -1.0F;
    public Float aj;
    public class_588 ak;
    public float al = -1.0F;
    public float am = 2000.0F;
    public float an = -999.0F;
    public class_397 ao;
    public int ap = -1;
    public boolean aq = true;
    public float ar = 0.0F;
    public float as = 0.0F;
    public float at = 10.0F;
    public float au;
    public LogicBoolean av;
    public float aw = -1.0F;
    public float ax;
    public boolean ay;
    public int az;
    public class_592 aA;
    public float aB;
    public class_598 aC;
    public TeamImageCache aD;
    public TeamImageCache[] aE;
    public TeamImageCache aF;
    public float aG;
    public float aH;
    public int aI;
    public class_588 aJ;

    public int a(class_113 var1) {
        return this.S >= 0 && this.T.read(var1) ? this.S : this.R;
    }

    public void a(class_397 var1) {
        this.f = var1.f;
        this.g = var1.g;
        this.h = var1.h;
        this.j = var1.j;
        this.k = var1.k;
        this.l = var1.l;
        this.m = var1.m;
        this.n = var1.n;
        this.o = var1.o;
        this.u = var1.u;
        this.v = var1.v;
        this.aI = var1.aI;
        this.aJ = var1.aJ;
        this.s = var1.s;
        this.t = var1.t;
        this.p = var1.p;
        this.q = var1.q;
        this.r = var1.r;
        this.y = var1.y;
        this.A = var1.A;
        this.B = var1.B;
        this.C = var1.C;
        this.D = var1.D;
        this.E = var1.E;
        this.G = var1.G;
        this.F = var1.F;
        this.J = var1.J;
        this.K = var1.K;
        this.L = var1.L;
        this.M = var1.M;
        this.N = var1.N;
        this.O = var1.O;
        this.P = var1.P;
        this.Q = var1.Q;
        this.aD = var1.aD;
        this.aE = var1.aE;
        this.aF = var1.aF;
        this.R = var1.R;
        this.S = var1.S;
        this.T = var1.T;
        this.U = var1.U;
        this.V = var1.V;
        this.W = var1.W;
        this.X = var1.X;
        this.Y = var1.Y;
        this.Z = var1.Z;
        this.aa = var1.aa;
        this.ao = var1.ao;
        this.aq = var1.aq;
        this.as = var1.as;
        this.at = var1.at;
        this.au = var1.au;
        this.av = var1.av;
        this.aw = var1.aw;
        this.ax = var1.ax;
        this.ab = var1.ab;
        this.ag = var1.ag;
        this.ai = var1.ai;
        this.af = var1.af;
        this.ay = var1.ay;
        this.az = var1.az;
        this.ak = var1.ak;
        this.al = var1.al;
        this.am = var1.am;
        this.an = var1.an;
        this.aA = var1.aA;
        this.aG = var1.aG;
        this.aH = var1.aH;
    }

    public static void a(class_397 var0, class_591 var1, UnitConfig var2, String var3) {
        var0.c = true;
        if (!var0.d) {
            Float var5 = var2.i(var3, "x");
            Float var6 = var2.i(var3, "y");
            String var7 = var2.getValueAsStaticString(var3, "copyFrom", (String)null);
            if (var7 != null) {
                class_397 var8 = var1.e(var7);
                if (var8 == null) {
                    throw new RuntimeException("[" + var3 + "] Could not find copy turret target with name:" + var7);
                }

                if (var8.c && !var8.d) {
                    throw new RuntimeException("[" + var3 + "] Infinite loop detected with turret copies:" + var7);
                }

                if (!var8.d) {
                    a(var8, var1, var2, var8.b);
                }

                var0.a(var8);
            } else {
                var0.af = var1.ez;
                var0.X = var1.ea;
            }

            var0.f = var5;
            var0.g = var6;
            var0.h = var2.getValueAsFloatOrDefault(var3, "height", 0.0F);
            var0.i = var2.getValueAsFloatOrDefault(var3, "yAxisScaling", 1.0F);
            String var29 = var2.getValueAsStaticString(var3, "linkDelayWithTurret", (String)null);
            if (var29 != null) {
                var0.ao = var1.e(var29);
                if (var0.ao == null) {
                    throw new RuntimeException("[" + var3 + "] Could not find 'linkDelayWithTurret' turret target with name:" + var29);
                }

                var0.m = 9000.0F;
            }

            Float var9 = var2.b(var3, "delay", (Float)null);
            if (var9 != null) {
                var0.m = var9;
            }

            if (var0.m == -1.0F) {
                var0.m = var1.dM;
            }

            Float var10 = var2.b(var3, "warmup", (Float)null);
            if (var10 != null) {
                var0.n = var10;
            }

            Float var11 = var2.getValueAsFloatOrDefault(var3, "warmupCallDownRate", (Float)null);
            if (var11 != null) {
                var0.o = var11;
            }

            Boolean var12 = var2.getValueAsBoolean(var3, "warmupNoReset", (Boolean)null);
            if (var12 != null) {
                var0.s = var12;
            }

            Float var13 = var2.getValueAsFloatOrDefault(var3, "warmupShootDelayTransfer", (Float)null);
            if (var13 != null) {
                var0.t = var13;
            }

            var0.p = var2.getValueAsFloatOrDefault(var3, "recoilOffset", var0.p);
            var0.q = var2.getValueAsFloatOrDefault(var3, "recoilOutTime", var0.q);
            var0.r = var2.b(var3, "recoilReturnTime", var0.r);
            Float var14 = var2.getValueAsFloatOrDefault(var3, "energyUsage", (Float)null);
            if (var14 != null) {
                var0.u = var14;
            }

            var0.aI = var2.getValueAsIntegerOrDefault(var3, "unloadUpToXUnitsAndGiveAttackOrder", var0.aI);
            class_447 var15 = class_447.a(var1, var2, var3, "resourceUsage", true);
            if (var15 != null && var15.d()) {
                var0.v = var15;
                var1.a(var15);
            }

            String var16 = var2.getValueAsStaticString(var3, "attachedTo", (String)null);
            if (var16 != null) {
                var0.y = var1.e(var16);
                if (var0.y == null) {
                    throw new RuntimeException("[" + var3 + "] Could not find attachedTo turret target:" + var16);
                }

                if (var0.y == var0) {
                    throw new RuntimeException("Turret cannot be attachedTo self");
                }

                var1.fU = true;
            }

            Float var17 = var2.getValueAsFloatOrDefault(var3, "idleDir", (Float)null);
            if (var17 != null) {
                var0.j = var17;
            }

            Float var18 = var2.getValueAsFloatOrDefault(var3, "idleDirReversing", (Float)null);
            if (var18 != null) {
                var0.k = var18;
                var0.l = true;
            } else if (!var0.l) {
                if (var0.y != null) {
                    var0.k = 0.0F;
                } else {
                    var0.k = var0.j + 180.0F;
                }
            }

            Boolean var19 = var2.getValueAsBoolean(var3, "canShoot", (Boolean)null);
            Boolean var20 = var2.getValueAsBoolean(var3, "canAttack", (Boolean)null);
            if (var19 != null && var20 != null) {
                throw new RuntimeException("[" + var3 + "] Cannot use canShoot and canAttack at the same time, they have the same meaning");
            } else {
                if (var19 != null) {
                    var0.B = var19;
                } else if (var20 != null) {
                    var0.B = var20;
                }

                var0.D = class_392.a(var1, var2.getValueAsStaticString(var3, "shoot_sound", (String)null), var0.D);
                Float var21 = var2.getValueAsFloatOrDefault(var3, "shoot_sound_vol", (Float)null);
                if (var21 != null) {
                    var0.D.a(var21);
                }

                var0.E = var1.a(var2.getValueAsStaticString(var3, "shoot_flame", (String)null), var0.E);
                var0.G = var2.a(var3, "shoot_light", var0.G);
                var0.F = var1.a(var2.getValueAsStaticString(var3, "warmupStartEffect", (String)null), var0.F);
                var0.A = var2.getValueAsBoolean(var3, "slave", var0.A);
                if (var0.A) {
                    if (var0.y == null) {
                        throw new RuntimeException("Turret cannot be a slave without being 'attachedTo' to another turret");
                    }

                    var0.z = var0.y;
                }

                var0.C = var2.a(var1, var3, "invisible", var0.C);
                var0.J = var2.a(var1, var3, "canAttackFlyingUnits", var0.J);
                var0.K = var2.a(var1, var3, "canAttackLandUnits", var0.K);
                var0.L = var2.a(var1, var3, "canAttackUnderwaterUnits", var0.L);
                var0.M = var2.a(var1, var3, "canAttackNotTouchingWaterUnits", var0.M);
                var0.N = var2.a(var1, var3, "canAttackCondition", var0.N);
                var0.O = var2.a(var1, var3, "canOnlyAttackUnitsWithTags", var0.O);
                var0.P = var2.a(var1, var3, "canOnlyAttackUnitsWithoutTags", var0.P);
                String var22 = var2.getValueAsStaticString(var3, "projectile", (String)null);
                if (var22 != null) {
                    class_164 var23 = var1.f(var22);
                    if (var23 == null) {
                        if (!"0".equals(var22) || var1.fT.size() != 1 || var1.f("1") == null) {
                            throw new RuntimeException("[" + var3 + "] Could not find projectile with name:" + var22);
                        }

                        var0.R = 0;
                    } else {
                        var0.R = var23.bi;
                    }
                }

                String var30 = var2.getValueAsStaticString(var3, "altProjectile", (String)null);
                if (var30 != null) {
                    class_164 var24 = var1.f(var30);
                    if (var24 == null) {
                        throw new RuntimeException("[" + var3 + "]altProjectile: Could not find projectile with name:" + var30);
                    }

                    var0.S = var24.bi;
                }

                var0.T = var2.a(var1, var3, "altProjectileCondition", var0.T);
                if (var0.S >= 0 && var0.T == null) {
                    throw new RuntimeException("[" + var3 + "]altProjectileCondition is required with altProjectile");
                } else {
                    var0.Q = var2.getValueAsFloatOrDefault(var3, "canAttackMaxAngle", var0.Q);
                    var0.U = var2.getValueAsFloatOrDefault(var3, "turnSpeed", var0.U);
                    var0.V = var2.getValueAsFloatOrDefault(var3, "turnSpeedAcceleration", var0.V);
                    var0.W = var2.getValueAsFloatOrDefault(var3, "turnSpeedDeceleration", var0.W);
                    Float var31 = var2.getValueAsFloatOrDefault(var3, "barrelY", (Float)null);
                    Float var25 = var2.getValueAsFloatOrDefault(var3, "size", (Float)null);
                    if (var31 != null && var25 != null) {
                        throw new RuntimeException("Turret [" + var3 + "]: barrelY and size can not both be used at the same time as they have the same meaning");
                    } else {
                        if (var31 != null) {
                            var0.X = var31;
                        }

                        if (var25 != null) {
                            var0.X = var25;
                        }

                        var0.Y = var2.getValueAsFloatOrDefault(var3, "barrelX", var0.Y);
                        var0.Z = var2.getValueAsFloatOrDefault(var3, "barrelOffsetX_onOddShots", var0.Z);
                        var0.aa = var2.getValueAsFloatOrDefault(var3, "barrelHeight", var0.aa);
                        var0.ab = var2.getValueAsFloatOrDefault(var3, "limitingRange", var0.ab);
                        var0.ai = var2.getValueAsFloatOrDefault(var3, "limitingAngle", var0.ai);
                        var0.ag = var2.getValueAsFloatOrDefault(var3, "limitingMinRange", var0.ag);
                        var0.af = var2.getValueAsFloatOrDefault(var3, "aimOffsetSpread", var0.af);
                        if (var0.ai >= 0.0F) {
                            var1.bG = true;
                        }

                        if (var0.ab < 99999.0F) {
                            var0.ad = var0.ab;
                        } else {
                            var0.ad = var1.cL.i;
                        }

                        var0.ae = var0.ad * var0.ad;
                        if (var0.ag > 0.0F) {
                            var0.ah = var0.ag * var0.ag;
                        } else {
                            var0.ah = -1.0F;
                        }

                        var0.ac = var2.getValueAsBoolean(var3, "showRangeUIGuide", (Boolean)null);
                        var0.aj = var2.getValueAsFloatOrDefault(var3, "laserDefenceEnergyUse", var0.aj);
                        if (var0.aj != null) {
                            var1.bE = true;
                            var1.a(class_830.a);
                        }

                        var0.ak = class_585.a(var2.getValueAsStaticString(var3, "interceptProjectiles_withTags", (String)null), var0.ak);
                        if (var0.ak != null) {
                            var1.bF = true;
                            var1.a(class_830.a);
                            var0.al = var2.getValueAsFloatOrDefault(var3, "interceptProjectiles_andTargetingGroundUnderDistance", var0.al);
                            var0.am = var2.getValueAsFloatOrDefault(var3, "interceptProjectiles_andUnderDistance", var0.am);
                            var0.an = var2.getValueAsFloatOrDefault(var3, "interceptProjectiles_andOverHeight", var0.an);
                        }

                        var0.aq = var2.getValueAsBoolean(var3, "shouldResetTurret", var0.aq);
                        var0.ar = var2.getValueAsFloatOrDefault(var3, "idleSpin", var0.ar);
                        var0.as = var2.getValueAsFloatOrDefault(var3, "idleSweepAngle", var0.as);
                        var0.at = var2.getValueAsFloatOrDefault(var3, "idleSweepDelay", var0.at);
                        var0.au = var2.getValueAsFloatOrDefault(var3, "idleSweepSpeed", var0.au);
                        var0.av = var2.a(var1, var3, "idleSweepCondition", var0.av);
                        var0.av = LogicBoolean.convertAlwaysTrueToNull(var0.av);
                        var0.aw = var2.getValueAsFloatOrDefault(var3, "idleSweepAddRandomDelay", var0.aw);
                        if (var0.aw < 0.0F) {
                            float var26 = 1.0F;
                            if (var0.at > 200.0F) {
                                var26 = 20.0F;
                            } else if (var0.at > 50.0F) {
                                var26 = 5.0F;
                            }

                            var0.aw = var26;
                        }

                        var0.ax = var2.getValueAsFloatOrDefault(var3, "idleSweepAddRandomAngle", var0.ax);
                        if (var0.ax < 0.0F) {
                            throw new RuntimeException("Turret [" + var3 + "]: idleSweepAddRandomAngle must be >= 0");
                        } else if (var0.as < 0.0F) {
                            throw new RuntimeException("Turret [" + var3 + "]: idleSweepAngle must be >= 0");
                        } else {
                            var0.ay = var2.getValueAsBoolean(var3, "clearTurretTargetAfterFiring", var0.ay);
                            var0.aA = var1.a(var2.getValueAsStaticString(var3, "onShoot_playAnimation", (String)null), var0.aA);
                            var0.aB = var2.b(var3, "onShoot_freezeBodyMovementFor", var0.aB);
                            var0.aC = var2.a(var1, var3, "onShoot_triggerActions", var0.aC);
                            if (var2.getValueAsBoolean(var3, "isMainNanoTurret", false)) {
                                var1.fV = var0;
                            }

                            TeamImageCache var32 = var1.a(var2, var3, "image");
                            if (var32 != null) {
                                var0.aD = var32;
                                boolean var27 = var1.s;
                                Boolean var28 = var2.getValueAsBoolean(var3, "image_applyTeamColors", (Boolean)null);
                                if (var28 != null) {
                                    var27 = var28;
                                }

                                if (var27) {
                                    var0.aE = var1.a(var0.aD, var1.ac);
                                } else {
                                    var0.aE = null;
                                }
                            }

                            var0.aG = var2.getValueAsFloatOrDefault(var3, "image_drawOffsetX", var0.aG);
                            var0.aH = var2.getValueAsFloatOrDefault(var3, "image_drawOffsetY", var0.aH);
                            TeamImageCache var33 = var1.a(var2, var3, "chargeEffectImage");
                            if (var33 != null) {
                                var0.aF = var33;
                                var1.fP = true;
                            }

                            if (var1.fR[var0.R] == null) {
                                throw new RuntimeException("Turret [" + var3 + "]: cannot find linked projectile:" + var0.R);
                            } else if (var0.S >= 0 && var1.fR[var0.S] == null) {
                                throw new RuntimeException("Turret [" + var3 + "]altProjectile: cannot find linked projectile");
                            } else {
                                var0.J = LogicBoolean.convertAlwaysTrueToNull(var0.J);
                                var0.K = LogicBoolean.convertAlwaysTrueToNull(var0.K);
                                var0.L = LogicBoolean.convertAlwaysTrueToNull(var0.L);
                                var0.M = LogicBoolean.convertAlwaysTrueToNull(var0.M);
                                var0.N = LogicBoolean.convertAlwaysTrueToNull(var0.N);
                                if (var0.ai != -1.0F || var0.J != null || var0.K != null || var0.L != null || var0.M != null || var0.N != null) {
                                    var0.H = true;
                                }

                                if (var0.ab < 99999.0F || var0.ag > 0.0F) {
                                    var0.H = true;
                                    var0.I = true;
                                }

                                if (var0.O != null || var0.P != null) {
                                    var0.H = true;
                                }

                                var0.d = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
