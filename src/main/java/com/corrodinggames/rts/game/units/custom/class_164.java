package com.corrodinggames.rts.game.units.custom;

import android.graphics.Color;
import android.graphics.PointF;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.class_163;
import com.corrodinggames.rts.game.class_168;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bh
public strictfp class class_164 extends class_163 {
    public String bh;
    public int bi;
    public class_591 bj;

    public static void a(class_164 var0, class_591 var1, UnitConfig var2, String var3) {
        String var4 = var3;
        Integer var5 = var2.getValueAsIntegerOrDefault(var3, "directDamage", (Integer)null);
        Integer var6 = var2.getValueAsIntegerOrDefault(var3, "areaDamage", (Integer)null);
        if (var5 == null && var6 == null) {
            throw new RuntimeException("[" + var3 + "]: directDamage or areaDamage must be set");
        } else {
            var0.s = var2.getValueAsBoolean(var3, "targetGround", var0.s);
            var0.t = var2.getValueAsBoolean(var3, "targetGround_includeTargetHeight", var0.t);
            Integer var7 = var2.getValueAsIntegerOrDefault(var3, "areaRadius", (Integer)null);
            if (var7 != null) {
                var0.i = var7;
            }

            var0.b = var2.getValueAsIntegerOrDefault(var3, "directDamage", var0.b);
            var0.c = var2.getValueAsIntegerOrDefault(var3, "areaDamage", var0.c);
            var0.d = var2.getValueAsBoolean(var3, "interceptProjectile_removeTargetLifeOnly", var0.d);
            var0.g = var2.getValueAsBoolean(var3, "areaDamageNoFalloff", var0.g);
            var0.j = var2.getValueAsFloatOrDefault(var3, "areaIgnoreUnitsCloserThan", var0.j);
            var0.h = var2.getValueAsBoolean(var3, "areaRadiusFromEdge", var0.h);
            if ("only-ignoreEnemy".equalsIgnoreCase(var2.getValueAsStaticString(var3, "friendlyFire", (String)null))) {
                var0.l = true;
            } else {
                Boolean var8 = var2.getValueAsBoolean(var3, "friendlyFire", (Boolean)null);
                if (var8 != null) {
                    var0.l = false;
                    var0.k = var8;
                }
            }

            var0.m = var2.getValueAsBoolean(var3, "areaHitAirAndLandAtSameTime", var0.m);
            var0.n = var2.getValueAsBoolean(var3, "areaHitUnderwaterAlways", var0.n);
            var0.o = var2.getValueAsFloatOrDefault(var3, "deflectionPower", var0.o);
            var0.p = var2.getValueAsBoolean(var3, "nukeWeapon", var0.p);
            var0.q = var2.getValueAsBoolean(var3, "shouldRevealFog", var0.q);
            var0.r = var2.getValueAsBoolean(var3, "alwaysVisibleInFog", var0.r);
            var0.v = var2.getValueAsFloat(var3, "life");
            var0.u = var2.b(var3, "delayedStartTimer", 0.0F);
            var0.w = var2.getValueAsFloatOrDefault(var3, "speed", var0.w);
            var0.x = var2.getValueAsShortOrDefault(var3, "frame", var0.x);
            var0.y = var2.getValueAsShortOrDefault(var3, "drawType", var0.y);
            var0.z = var2.getValueAsShortOrDefault(var3, "shadowFrame", var0.z);
            TeamImageCache var28 = var1.a(var2, var3, "image");
            if (var28 != null) {
                var0.B = var28;
            }

            TeamImageCache var9 = var1.a(var2, var3, "shadowImage");
            if (var9 != null) {
                var0.C = var9;
            }

            var0.ad = var2.getValueAsFloatOrDefault(var3, "beamImageOffsetRate", var0.ad);
            TeamImageCache var10 = var1.a(var2, var3, "beamImage");
            if (var10 != null) {
                var0.Y = var10;
                var0.X = true;
                if (var10.q < 20 && !GameEngine.ax()) {
                    throw new RuntimeException("beamImage height must currently be 20 pixels or greater (performance when tiling)");
                }
            }

            TeamImageCache var11 = var1.a(var2, var3, "beamImageStart");
            if (var11 != null) {
                var0.Z = var11;
                if (var10 == null) {
                    throw new RuntimeException("beamImageStart requires beamImage to be set");
                }
            }

            var0.aa = var2.getValueAsBoolean(var3, "beamImageStartRotated", false);
            TeamImageCache var12 = var1.a(var2, var3, "beamImageEnd");
            if (var12 != null) {
                var0.ab = var12;
                if (var10 == null) {
                    throw new RuntimeException("beamImageEnd requires beamImage to be set");
                }
            }

            var0.ac = var2.getValueAsBoolean(var3, "beamImageEndRotated", false);
            var0.A = var2.getValueAsBoolean(var3, "invisible", var0.A);
            var0.D = var2.getValueAsFloatOrDefault(var3, "initialUnguidedSpeedHeight", var0.D);
            var0.E = var2.getValueAsFloatOrDefault(var3, "initialUnguidedSpeedX", var0.E);
            var0.F = var2.getValueAsFloatOrDefault(var3, "initialUnguidedSpeedY", var0.F);
            var0.G = var2.getValueAsFloatOrDefault(var3, "gravity", var0.G);
            var0.H = var2.getValueAsFloatOrDefault(var3, "trueGravity", var0.H);
            var0.I = var2.getValueAsBoolean(var3, "instant", var0.I);
            var0.L = var2.getValueAsBoolean(var3, "instantReuseLast", var0.L);
            var0.M = var2.getValueAsBoolean(var3, "instantReuseLast_alsoChangeTurretAim", var0.M);
            if (var0.M) {
                if (!var0.L) {
                    throw new RuntimeException("[" + var3 + "]instantReuseLast_alsoChangeTurretAim also requires instantReuseLast");
                }

                var1.eA = true;
            }

            var0.N = var2.getValueAsBoolean(var3, "instantReuseLast_keepAreaDamageList", var0.N);
            var0.T = var2.getValueAsBoolean(var3, "moveWithParent", var0.T);
            var0.J = var2.getValueAsBoolean(var3, "disableLeadTargeting", var0.J);
            var0.K = var2.getValueAsFloatOrDefault(var3, "leadTargetingSpeedCalculation", var0.K);
            var0.ae = var2.getValueAsBoolean(var3, "ballistic", var0.ae);
            String var13 = var2.getValueAsStaticString(var3, "trailEffect", (String)null);
            if (var13 != null) {
                if (var13.equalsIgnoreCase("true")) {
                    var0.af = true;
                } else if (var13.equalsIgnoreCase("false")) {
                    var0.af = false;
                } else {
                    var0.af = false;
                    var0.ah = var1.a((String)var13, (class_605)null);
                }
            }

            String var14 = var2.getValueAsStaticString(var3, "effectOnCreate", (String)null);
            if (var14 != null) {
                var0.ai = var1.a((String)var14, (class_605)null);
            }

            var0.ag = var2.getValueAsFloatOrDefault(var3, "trailEffectRate", var0.ag);
            if (var0.af) {
                var0.ao = -1118720;
            }

            var0.am = var2.getValueAsFloatOrDefault(var3, "wobbleAmplitude", var0.am);
            var0.an = var2.b(var3, "wobbleFrequency", var0.an);
            if (var0.an <= 0.0F) {
                throw new RuntimeException("wobbleFrequency must be greater than 0");
            } else {
                var0.ak = class_390.a((class_591)var1, (UnitConfig)var2, (String)var3, (String)"spawnProjectilesOnEndOfLife", (class_390)null);
                var0.aj = class_390.a((class_591)var1, (UnitConfig)var2, (String)var3, (String)"spawnProjectilesOnExplode", (class_390)null);
                var0.al = class_390.a((class_591)var1, (UnitConfig)var2, (String)var3, (String)"spawnProjectilesOnCreate", (class_390)null);
                var0.ao = var2.a(var3, "lightColor", var0.ao);
                var0.ap = var2.getValueAsFloatOrDefault(var3, "lightSize", var0.ap);
                var0.aq = var2.getValueAsBoolean(var3, "lightCastOnGround", var0.aq);
                var0.ar = var2.getValueAsBoolean(var3, "largeHitEffect", var0.ar);
                var0.O = var2.getValueAsFloatOrDefault(var3, "turnSpeed", var0.O);
                var0.P = var2.getValueAsFloatOrDefault(var3, "turnSpeedWhenNear", var0.P);
                var0.Q = var2.getValueAsFloatOrDefault(var3, "sweepSpeed", var0.Q);
                var0.R = var2.getValueAsFloatOrDefault(var3, "sweepOffset", var0.R);
                var0.S = var2.getValueAsFloatOrDefault(var3, "sweepOffsetFromTargetRadius", var0.S);
                var0.U = var2.getValueAsBoolean(var3, "drawUnderUnits", var0.U);
                var0.V = var2.getValueAsBoolean(var3, "lightingEffect", var0.V);
                var0.W = var2.getValueAsBoolean(var3, "laserEffect", var0.W);
                if (var0.W && var0.Y == null) {
                    var0.aE = Color.a(80, 255, 0, 0);
                }

                if (var0.V && var0.s) {
                    throw new RuntimeException("lightingEffect must be targeted, cannot be targetGround");
                } else if (var0.W && var0.s) {
                    throw new RuntimeException("laserEffect must be targeted, cannot be targetGround");
                } else {
                    var0.as = var2.getValueAsFloatOrDefault(var3, "ballistic_delaymove_height", var0.as);
                    var0.at = var2.getValueAsFloatOrDefault(var3, "ballistic_height", var0.at);
                    var0.au = var2.getValueAsFloatOrDefault(var3, "targetSpeed", var0.au);
                    var0.av = var2.getValueAsFloatOrDefault(var3, "targetSpeedAcceleration", var0.av);
                    var0.aw = var2.getValueAsBoolean(var3, "autoTargetingOnDeadTarget", var0.aw);
                    var0.ax = var2.getValueAsFloatOrDefault(var3, "autoTargetingOnDeadTargetRange", var0.ax);
                    var0.ay = var2.getValueAsFloatOrDefault(var3, "autoTargetingOnDeadTargetLead", var0.ay);
                    var0.az = var2.getValueAsBoolean(var3, "retargetingInFlight", var0.az);
                    var0.aA = var2.getValueAsFloatOrDefault(var3, "retargetingInFlightSearchDelay", var0.aA);
                    var0.aB = var2.getValueAsFloatOrDefault(var3, "retargetingInFlightSearchRange", var0.aB);
                    var0.aC = var2.getValueAsFloatOrDefault(var3, "retargetingInFlightSearchLead", var0.aC);
                    var0.aD = var2.a((class_591)var1, var3, (String)"retargetingInFlightSearchOnlyTags", (class_588)null);
                    if (var0.ax > 1500.0F) {
                        throw new RuntimeException("for performance autoTargetingOnDeadTargetRange cannot be >1500");
                    } else if (var0.aB > 1500.0F) {
                        throw new RuntimeException("for performance retargetingInFlightSearchRange cannot be >1500");
                    } else {
                        var0.aE = var2.a(var3, "color", var0.aE);
                        var0.aG = var2.getValueAsFloatOrDefault(var3, "teamColorRatio", var0.aG);
                        if (!(var0.aG < 0.0F) && !(var0.aG > 1.0F)) {
                            var0.aH = var2.getValueAsFloatOrDefault(var3, "teamColorRatio_sourceRatio", 1.0F - var0.aG);
                            if (!(var0.aH < 0.0F) && !(var0.aH > 1.0F)) {
                                if (var0.aG == 0.0F && var0.aH != 1.0F) {
                                    throw new RuntimeException("teamColorRatio_sourceRatio requires teamColorRatio");
                                } else {
                                    var0.aF = var2.getValueAsFloatOrDefault(var3, "drawSize", var0.aF);
                                    var0.aI = var2.getValueAsBoolean(var3, "flameWeapon", var0.aI);
                                    var0.aJ = var2.getValueAsBoolean(var3, "hitSound", var0.aJ);
                                    var0.aL = var2.getValueAsFloatOrDefault(var3, "targetGroundHeightOffset", var0.aL);
                                    var0.aK = var2.getValueAsFloatOrDefault(var3, "targetGroundSpread", var0.aK);
                                    var0.aM = var2.getValueAsFloatOrDefault(var3, "speedSpread", var0.aM);
                                    var0.aO = var2.getValueAsBoolean(var3, "explodeOnEndOfLife", var0.aO);
                                    var0.aN = var2.getValueAsBoolean(var3, "ignoreParentShootDamageMultiplier", var0.aN);
                                    var0.aP = var2.getValueAsFloatOrDefault(var3, "pushForce", var0.aP);
                                    var0.aQ = var2.getValueAsFloatOrDefault(var3, "pushVelocity", var0.aQ);
                                    var0.aR = var2.getValueAsFloatOrDefault(var3, "buildingDamageMultiplier", var0.aR);
                                    var0.aS = var2.getValueAsFloatOrDefault(var3, "shieldDamageMultiplier", var0.aS);
                                    var0.aT = var2.getValueAsFloatOrDefault(var3, "shieldDefectionMultiplier", var0.aT);
                                    var0.aU = var2.getValueAsFloatOrDefault(var3, "hullDamageMultiplier", var0.aU);
                                    var0.aV = var2.getValueAsFloatOrDefault(var3, "armourIgnoreAmount", var0.aV);
                                    var0.aW = var2.getValueAsFloatOrDefault(var3, "areaExpandTime", var0.aW);
                                    String var15 = var2.getValueAsStaticString(var3, "explodeEffect", (String)null);
                                    if (var15 != null) {
                                        var0.aX = var1.a((String)var15, (class_605)null);
                                    }

                                    String var16 = var2.getValueAsStaticString(var3, "explodeEffectOnShield", (String)null);
                                    if (var16 != null) {
                                        var0.aY = var1.a((String)var16, (class_605)null);
                                    }

                                    class_395 var17 = class_395.a(var1, var2, var3, "spawnUnit");
                                    if (var17 != null && !var17.b()) {
                                        var0.aZ = var17;
                                    }

                                    var0.ba = var2.getValueAsIntegerOrDefault(var3, "unloadUpToXUnitsFromSource", var0.ba);
                                    var0.bb = var2.getValueAsBoolean(var3, "teleportSource", var0.bb);
                                    var0.bc = var2.getValueAsBoolean(var3, "convertHitToSourceTeam", var0.bc);
                                    var0.bd = class_585.a(var2.getValueAsStaticString(var3, "tags", (String)null));
                                    class_684 var18 = var2.k(var3, "mutator");
                                    class_684 var19 = new class_684();
                                    Iterator var20 = var18.iterator();

                                    String var21;
                                    while(var20.hasNext()) {
                                        var21 = (String)var20.next();
                                        String[] var22 = var21.split("_");
                                        if (var22.length > 1) {
                                            String var23 = var22[0];
                                            String var24 = var23 + "_";
                                            if (!var19.contains(var24) && var23.length() > "mutator".length()) {
                                                var19.add(var24);
                                            }
                                        }
                                    }

                                    var20 = var19.iterator();

                                    while(var20.hasNext()) {
                                        var21 = (String)var20.next();
                                        class_168 var29 = new class_168();
                                        var29.a = class_585.a(var2.getValueAsStaticString(var4, var21 + "ifUnitWithTags", (String)null));
                                        var29.b = class_585.a(var2.getValueAsStaticString(var4, var21 + "ifUnitWithoutTags", (String)null));
                                        if (var29.a == null && var29.b == null) {
                                            throw new RuntimeException("[" + var4 + "]" + var21 + " requires: unitWithTags and/or unitWithoutTags");
                                        }

                                        var29.c = var2.getValueAsFloatOrDefault(var4, var21 + "directDamageMultiplier", 1.0F);
                                        var29.d = var2.getValueAsFloatOrDefault(var4, var21 + "areaDamageMultiplier", 1.0F);
                                        class_447 var30 = class_447.a(var1, var2, var3, var21 + "addResourcesDirectHit", true);
                                        if (var30 != null && var30.d()) {
                                            var29.e = var30;
                                            if (var0.s) {
                                                throw new RuntimeException("[" + var4 + "]" + var21 + "addResourcesDirectHit doesn't work with targetGround, as it will never get direct hits (use addResourcesAreaHit)");
                                            }
                                        }

                                        class_447 var31 = class_447.a(var1, var2, var3, var21 + "addResourcesAreaHit", true);
                                        if (var31 != null && var31.d()) {
                                            var29.f = var31;
                                            if (var7 == null) {
                                                throw new RuntimeException("[" + var4 + "]" + var21 + "addResourcesAreaHit requires areaRadius to be set");
                                            }
                                        }

                                        String var25 = var2.getValueAsStaticString(var4, var21 + "changedExplodeEffect", (String)null);
                                        if (var25 != null) {
                                            var29.g = var1.a((String)var25, (class_605)null);
                                            if (var29.g != null && !var29.g.a()) {
                                                var29.g = null;
                                            }
                                        }

                                        boolean var26 = false;
                                        boolean var27 = false;
                                        if (!class_340.k(var29.c, 1.0F)) {
                                            var26 = true;
                                        }

                                        if (!class_340.k(var29.d, 1.0F) && var0.c != 0 && var0.i > 0) {
                                            var27 = true;
                                        }

                                        if (var29.e != null) {
                                            var26 = true;
                                        }

                                        if (var29.f != null) {
                                            var27 = true;
                                        }

                                        if (var26) {
                                            if (var0.be == null) {
                                                var0.be = new class_684();
                                            }

                                            var0.be.add(var29);
                                        }

                                        if (var27) {
                                            if (var0.bf == null) {
                                                var0.bf = new class_684();
                                            }

                                            var0.e = true;
                                            var0.bf.add(var29);
                                        }

                                        if (var29.g != null) {
                                            if (var0.bg == null) {
                                                var0.bg = new class_684();
                                            }

                                            var0.bg.add(var29);
                                        }
                                    }

                                    if (var0.c != 0 && var0.i > 0) {
                                        var0.e = true;
                                    }

                                    if ((var0.aP != 0.0F || var0.aQ != 0.0F) && var0.i > 0) {
                                        var0.e = true;
                                    }

                                    var0.f = !var0.e;
                                    var1.fT.add(var0);
                                }
                            } else {
                                throw new RuntimeException("teamColorRatio_sourceRatio should be between 0-1 got:" + var0.aH);
                            }
                        } else {
                            throw new RuntimeException("teamColorRatio should be between 0-1 got:" + var0.aG);
                        }
                    }
                }
            }
        }
    }

    public static void a(class_164 var0, GameOutputStream var1) {
        var1.a((class_31)var0.bj);
        var1.writeString(var0.bh);
    }

    public static class_163 b(GameInputStream var0) {
        class_31 var1 = var0.q();
        String var2 = var0.readString();
        if (var1 == null) {
            return null;
        } else if (!(var1 instanceof class_591)) {
            GameEngine.print("ProjectileTemplate:readInLinkCustom: Got non CustomUnitMetadata object of:" + var1.i() + " loading real_meta");
            return null;
        } else {
            class_591 var3 = (class_591)var1;
            class_164 var4 = var3.f(var2);
            if (var4 == null) {
                GameEngine.print("ProjectileTemplate:readInLinkCustom: Could not find projectile with name:" + var2);
                return null;
            } else {
                return var4;
            }
        }
    }

    public void a(Unit var1, Projectile var2, Unit var3, float var4, float var5, float var6) {
        if (var3 == null) {
            var2.aC = true;
            var2.n = var4;
            var2.o = var5;
            if (this.aK != 0.0F) {
                var2.n += (float)class_340.a((GameObject) var1, (int)(-this.aK * 100.0F), (int)(this.aK * 100.0F), 2) / 100.0F;
                var1.bC = (int)((float)var1.bC + var2.n);
                var2.o += (float)class_340.a((GameObject) var1, (int)(-this.aK * 100.0F), (int)(this.aK * 100.0F), 3) / 100.0F;
                var1.bC = (int)((float)var1.bC + var2.o);
            }

            var2.p = 0.0F;
            var2.p += this.aL;
        } else if (var2.m) {
            var2.aC = true;
            if (!this.J) {
                float var8 = var2.t;
                if (this.au != -1.0F) {
                    var8 = this.au;
                }

                if (this.K >= 0.0F) {
                    var8 = this.K;
                }

                PointF var9 = var3.a(var2.xCord, var2.yCord, var8, var2.h, var6);
                var2.n = var9.x;
                var2.o = var9.y;
            } else {
                var2.n = var3.xCord;
                var2.o = var3.yCord;
            }

            if (this.t) {
                var2.p = var3.zCord;
            } else {
                var2.p = 0.0F;
            }

            var2.p += this.aL;
            if (this.aK != 0.0F) {
                var2.n += (float)class_340.a((GameObject) var1, (int)(-this.aK * 100.0F), (int)(this.aK * 100.0F), 2) / 100.0F;
                var2.o += (float)class_340.a((GameObject) var1, (int)(-this.aK * 100.0F), (int)(this.aK * 100.0F), 7) / 100.0F;
            }
        } else {
            var2.l = var3;
        }

    }
}
