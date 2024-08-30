package com.corrodinggames.rts.game.units.custom;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.d.Emitter;
import com.corrodinggames.rts.gameFramework.d.class_986;
import com.corrodinggames.rts.gameFramework.d.class_989;
import com.corrodinggames.rts.gameFramework.d.class_996;
import com.corrodinggames.rts.gameFramework.d.Priority;
import com.corrodinggames.rts.gameFramework.d.class_998;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import lombok.SneakyThrows;

import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.ay
public strictfp class class_429 {
    public static final class_429 defaultEffectTemplate = new class_429("default");
    public String name;
    private EffectType builtInEffect = null;
    public class_996 imageStrip;
    public boolean createWhenOffscreen;
    public boolean createWhenZoomedOut;
    public boolean createWhenOverLiquid;
    public boolean createWhenOverLand;
    public float spawnChance = 1.0F;
    class_605 ifSpawnFailsEmitEffects;
    public float life = 200.0F;
    public float lifeRandom;
    public boolean showInFog;
    public float xOffsetRelative;
    public float yOffsetRelative;
    public float hOffset;
    public boolean alwayStartDirAtZero;
    public float pivotOffset;
    public float pivotOffsetRandom;
    public float dirOffset;
    public float xOffsetRelativeRandom;
    public float yOffsetRelativeRandom;
    public float hOffsetRandom;
    public float dirOffsetRandom;
    public float xOffsetAbsolute;
    public float yOffsetAbsolute;
    public float xOffsetAbsoluteRandom;
    public float yOffsetAbsoluteRandom;
    public float xSpeedRelative;
    public float ySpeedRelative;
    public float hSpeed;
    public float dirSpeed;
    public float xSpeedRelativeRandom;
    public float ySpeedRelativeRandom;
    public float hSpeedRandom;
    public float dirSpeedRandom;
    public float xSpeedAbsolute;
    public float ySpeedAbsolute;
    public float xSpeedAbsoluteRandom;
    public float ySpeedAbsoluteRandom;
    public Priority priority;
    public float scaleTo;
    public float scaleFrom;
    public float alpha;
    public int color;
    public LightingColorFilter cachedLightingColorFilter;
    public float teamColorRatio;
    public boolean shadow;
    public short drawLayer;
    public float fadeInTime;
    public boolean fadeOut;
    public float delayedStartTimer;
    public float delayedStartTimerRandom;
    public int frameIndex;
    public int frameIndexRandom;
    public int stripIndex;
    public boolean attachedToUnit;
    public boolean liveAfterAttachedDies;
    public boolean atmospheric;
    public boolean physics;
    public float physicsGravity;
    public int animateFrameStart;
    public int animateFrameEnd;
    public int animateFrameStartRandomAdd;
    public boolean animateFramePingPong;
    public boolean animateFrameLooping;
    public float animateFrameSpeed;
    public float animateFrameSpeedRandom;
    public class_605 alsoEmitEffects;
    public class_605 alsoEmitEffectsOnDeath;
    public class_605 trailEffect;
    public float trailEffectRate;
    public class_392 alsoPlaySound;
    public static ArrayList fields;

    public class_429(EffectType var1) {
        this.priority = Priority.high;
        this.scaleTo = 1.0F;
        this.scaleFrom = 1.0F;
        this.alpha = 1.0F;
        this.color = -1;
        this.teamColorRatio = 0.0F;
        this.drawLayer = 2;
        this.physicsGravity = 1.0F;
        this.builtInEffect = var1;
    }

    class_429(String var1) {
        this.priority = Priority.high;
        this.scaleTo = 1.0F;
        this.scaleFrom = 1.0F;
        this.alpha = 1.0F;
        this.color = -1;
        this.teamColorRatio = 0.0F;
        this.drawLayer = 2;
        this.physicsGravity = 1.0F;
        this.name = var1;
    }

    public class_998 a(float var1, float var2, float var3, float var4, GameObject var5, int var6, short var7) {
        GameEngine var8 = GameEngine.getGameEngine();
        if (this.spawnChance < 1.0F && class_340.c(0.0F, 1.0F) > this.spawnChance) {
            if (var6 < 5 && this.ifSpawnFailsEmitEffects != null) {
                this.ifSpawnFailsEmitEffects.a(var1, var2, var3, var4, var5, var6 + 1, var7);
            }

            return null;
        } else if (this.builtInEffect != null) {
            class_998 var22;
            if (this.builtInEffect == EffectType.SMALL) {
                var22 = var8.bR.a(var1, var2, var3, var4);
            } else if (this.builtInEffect == EffectType.MEDIUM) {
                var22 = var8.bR.b(var1, var2, var3, var4, 0);
                if (var22 != null) {
                    var22.G = 0.75F;
                    var22.F = 0.75F;
                }
            } else if (this.builtInEffect == EffectType.LARGE) {
                var22 = var8.bR.b(var1, var2, var3, var4, 0);
            } else if (this.builtInEffect == EffectType.SMOKE) {
                var22 = var8.bR.c(var1, var2, var3, var4, 0);
            } else if (this.builtInEffect == EffectType.SHOCKWAVE) {
                var22 = var8.bR.d(var1, var2, var3, 0);
            } else if (this.builtInEffect == EffectType.LARGE_EXPLOSION) {
                var8.bR.a(var1, var2, var3);
                var22 = null;
            } else if (this.builtInEffect == EffectType.SMALL_EXPLOSION) {
                var22 = var8.bR.b(var1, var2, var3);
            } else {
                if (this.builtInEffect != EffectType.RESOURCE_POOL_SMOKE) {
                    if (this.builtInEffect == EffectType.NONE_EXPLOSION) {
                        return null;
                    }

                    throw new RuntimeException("Unhandled built-in type:" + this.builtInEffect);
                }

                Emitter var23 = Emitter.a(var1, var2);
                var23.j = -6684775;
                Emitter var24 = Emitter.b(var1, var2);
                var24.a = 500.0F;
                var24.j = -6684775;
                var8.bR.b(Priority.critical);
                class_998 var27 = var8.bR.c(var1, var2, var3, -1127220);
                if (var27 != null) {
                    var27.G = 0.15F;
                    var27.F = 1.0F;
                    var27.ar = 2;
                    var27.V = 35.0F;
                    var27.W = var27.V;
                    var27.U = 0.0F;
                    var27.x = -13378253;
                }

                var22 = null;
            }

            if (var22 == null) {
                return null;
            } else {
                var22.ar = 2;
                if (var5 != null) {
                    class_986.a(var22, var5);
                }

                return var22;
            }
        } else if (!this.createWhenZoomedOut && !var8.dc) {
            return null;
        } else if (!this.createWhenOverLiquid && class_694.d(var1, var2)) {
            return null;
        } else if (!this.createWhenOverLand && !class_694.d(var1, var2)) {
            return null;
        } else {
            if (this.createWhenOffscreen) {
                var8.bR.b();
            } else {
                var8.bR.a();
            }

            boolean var12 = this.showInFog;
            boolean var13 = false;
            if (!var12 && this.attachedToUnit) {
                var13 = true;
                var12 = true;
            }

            class_998 var14 = var8.bR.b(var1, var2, var3, class_989.CUSTOM, var12, this.priority);
            if (var14 == null) {
                return null;
            } else {
                var14.a = this;
                var14.A = (short)(var7 + 1);
                if (var13 && !this.showInFog) {
                    var14.e = false;
                }

                var14.V = this.life;
                var14.V += this.a(this.lifeRandom);
                var14.W = var14.V;
                var14.aq = this.stripIndex;
                if (this.imageStrip != null) {
                }

                var14.ap = this.frameIndex;
                if (this.frameIndexRandom != 0) {
                    var14.ap += class_340.rand(-this.frameIndexRandom, this.frameIndexRandom);
                    if (var14.ap < 0) {
                        var14.ap = 0;
                    }
                }

                var4 += this.pivotOffset;
                var4 += this.a(this.pivotOffsetRandom);
                if (this.alwayStartDirAtZero) {
                    var14.Y = 0.0F;
                } else {
                    var14.Y = var4;
                }

                var14.Y += this.dirOffset;
                var14.Y += this.a(this.dirOffsetRandom);
                float var15;
                float var16;
                if (this.xOffsetAbsoluteRandom != 0.0F || this.yOffsetAbsoluteRandom != 0.0F || this.xOffsetAbsolute != 0.0F || this.yOffsetAbsolute != 0.0F) {
                    var15 = this.xOffsetAbsolute + this.a(this.xOffsetAbsoluteRandom);
                    var16 = this.yOffsetAbsolute + this.a(this.yOffsetAbsoluteRandom);
                    var14.I += var15;
                    var14.J += var16;
                }

                float var17;
                float var18;
                if (this.xOffsetRelativeRandom != 0.0F || this.yOffsetRelativeRandom != 0.0F || this.xOffsetRelative != 0.0F || this.yOffsetRelative != 0.0F) {
                    var15 = class_340.k(var4);
                    var16 = class_340.j(var4);
                    var17 = this.xOffsetRelative + this.a(this.xOffsetRelativeRandom);
                    var18 = this.yOffsetRelative + this.a(this.yOffsetRelativeRandom);
                    var14.I += var15 * var18 - var16 * var17;
                    var14.J += var16 * var18 + var15 * var17;
                }

                var14.K += this.hOffset + this.a(-this.hOffsetRandom, this.hOffsetRandom);
                var14.an = true;
                var14.r = true;
                var14.ar = this.drawLayer;
                var14.G = this.scaleFrom;
                var14.F = this.scaleTo;
                var14.E = this.alpha;
                var14.x = this.color;
                var14.B = this.cachedLightingColorFilter;
                if (this.teamColorRatio != 0.0F && var5 != null) {
                    PlayerData var25 = null;
                    if (var5 instanceof Unit) {
                        var25 = ((Unit)var5).bX;
                    }

                    if (var5 instanceof Projectile) {
                        Unit var26 = ((Projectile)var5).j;
                        if (var26 != null) {
                            var25 = var26.bX;
                        }
                    }

                    if (var25 != null) {
                        var16 = 1.0F - this.teamColorRatio;
                        int var28 = Color.a(var14.x);
                        int var29 = (int)((float)Color.b(var14.x) * var16);
                        int var19 = (int)((float)Color.c(var14.x) * var16);
                        int var20 = (int)((float)Color.d(var14.x) * var16);
                        int var21 = var25.K();
                        var29 = (int)((float)var29 + (float)Color.b(var21) * this.teamColorRatio);
                        var19 = (int)((float)var19 + (float)Color.c(var21) * this.teamColorRatio);
                        var20 = (int)((float)var20 + (float)Color.d(var21) * this.teamColorRatio);
                        var29 = class_340.b(var29, 0, 255);
                        var19 = class_340.b(var19, 0, 255);
                        var20 = class_340.b(var20, 0, 255);
                        var14.x = Color.a(var28, var29, var19, var20);
                        if (GameEngine.at()) {
                            var14.B = new LightingColorFilter(var14.x, 0);
                        }
                    }
                }

                if (this.fadeInTime != 0.0F) {
                    var14.s = true;
                    var14.t = this.fadeInTime;
                }

                var14.as = this.shadow;
                var14.r = this.fadeOut;
                var14.U = this.delayedStartTimer;
                var14.U += this.a(-this.delayedStartTimerRandom, this.delayedStartTimerRandom);
                var14.u = this.atmospheric;
                var14.v = this.physics;
                var14.w = this.physicsGravity;
                var14.q = this.priority;
                var14.P = this.xSpeedAbsolute + this.a(this.xSpeedAbsoluteRandom);
                var14.Q = this.ySpeedAbsolute + this.a(this.ySpeedAbsoluteRandom);
                if (this.xSpeedRelative != 0.0F || this.ySpeedRelative != 0.0F || this.xSpeedRelativeRandom != 0.0F || this.ySpeedRelativeRandom != 0.0F) {
                    var15 = class_340.k(var4);
                    var16 = class_340.j(var4);
                    var17 = this.xSpeedRelative + this.a(this.xSpeedRelativeRandom);
                    var18 = this.ySpeedRelative + this.a(this.ySpeedRelativeRandom);
                    var14.P += var15 * var18 - var16 * var17;
                    var14.Q += var16 * var18 + var15 * var17;
                }

                var14.R = this.hSpeed + this.a(this.hSpeedRandom);
                var14.Z = this.dirSpeed + this.a(this.dirSpeedRandom);
                if (this.animateFrameStart != this.animateFrameEnd) {
                    var14.ae = true;
                }

                var14.af = this.animateFrameStart;
                if (this.animateFrameStartRandomAdd != 0) {
                    var14.af += class_340.rand(0, this.animateFrameStartRandomAdd);
                }

                var14.ag = this.animateFrameEnd;
                var14.ak = (float)this.animateFrameStart;
                var14.ah = this.animateFramePingPong;
                var14.ai = this.animateFrameLooping;
                var14.aj = this.animateFrameSpeed;
                var14.aj += this.a(this.animateFrameSpeedRandom);
                if (var5 != null && this.attachedToUnit) {
                    class_986.a(var14, var5);
                }

                if (this.alsoPlaySound != null) {
                    this.alsoPlaySound.a(var1, var2, 1.0F);
                }

                if (var6 < 5 && this.alsoEmitEffects != null) {
                    this.alsoEmitEffects.a(var1, var2, var3, var4, var5, var6 + 1, (short)0);
                }

                return var14;
            }
        }
    }

    public final float a(float var1) {
        return var1 == 0.0F ? 0.0F : class_340.c(-var1, var1);
    }

    public final float a(float var1, float var2) {
        return var1 == var2 ? var1 : class_340.c(var1, var2);
    }

    @SneakyThrows
    public void a(class_591 var1, UnitConfig var2, String var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        this.createWhenOffscreen = var2.getValueAsBoolean(var3, "createWhenOffscreen", false);
        this.createWhenZoomedOut = var2.getValueAsBoolean(var3, "createWhenZoomedOut", true);
        this.createWhenOverLiquid = var2.getValueAsBoolean(var3, "createWhenOverLiquid", true);
        this.createWhenOverLand = var2.getValueAsBoolean(var3, "createWhenOverLand", true);
        if (!this.createWhenOverLiquid && !this.createWhenOverLand) {
            throw new RuntimeException(var3 + " effect cannot have both createWhenOverLiquid and createWhenOverLand set to false, it would never be created");
        } else {
            this.spawnChance = var2.getValueAsFloatOrDefault(var3, "spawnChance", 1.0F);
            this.life = var2.getValueAsFloatOrDefault(var3, "life", 200.0F);
            this.lifeRandom = var2.getValueAsFloatOrDefault(var3, "lifeRandom", 0.0F);
            this.showInFog = var2.getValueAsBoolean(var3, "showInFog", false);
            this.xOffsetRelative = var2.getValueAsFloatOrDefault(var3, "xOffsetRelative", 0.0F);
            this.yOffsetRelative = var2.getValueAsFloatOrDefault(var3, "yOffsetRelative", 0.0F);
            this.hOffset = var2.getValueAsFloatOrDefault(var3, "hOffset", 0.0F);
            this.alwayStartDirAtZero = var2.getAltValueAsBoolean(var3, "alwaysStartDirAtZero", "alwayStartDirAtZero", false);
            this.pivotOffset = var2.getValueAsFloatOrDefault(var3, "pivotOffset", 0.0F);
            this.pivotOffsetRandom = var2.getValueAsFloatOrDefault(var3, "pivotOffsetRandom", 0.0F);
            this.dirOffset = var2.getValueAsFloatOrDefault(var3, "dirOffset", 0.0F);
            this.xOffsetRelativeRandom = var2.getValueAsFloatOrDefault(var3, "xOffsetRelativeRandom", 0.0F);
            this.yOffsetRelativeRandom = var2.getValueAsFloatOrDefault(var3, "yOffsetRelativeRandom", 0.0F);
            this.hOffsetRandom = var2.getValueAsFloatOrDefault(var3, "hOffsetRandom", 0.0F);
            this.dirOffsetRandom = var2.getValueAsFloatOrDefault(var3, "dirOffsetRandom", 0.0F);
            this.xOffsetAbsolute = var2.getValueAsFloatOrDefault(var3, "xOffsetAbsolute", 0.0F);
            this.yOffsetAbsolute = var2.getValueAsFloatOrDefault(var3, "yOffsetAbsolute", 0.0F);
            this.xOffsetAbsoluteRandom = var2.getValueAsFloatOrDefault(var3, "xOffsetAbsoluteRandom", 0.0F);
            this.yOffsetAbsoluteRandom = var2.getValueAsFloatOrDefault(var3, "yOffsetAbsoluteRandom", 0.0F);
            this.xSpeedRelative = var2.getValueAsFloatOrDefault(var3, "xSpeedRelative", 0.0F);
            this.ySpeedRelative = var2.getValueAsFloatOrDefault(var3, "ySpeedRelative", 0.0F);
            this.hSpeed = var2.getValueAsFloatOrDefault(var3, "hSpeed", 0.0F);
            this.dirSpeed = var2.getValueAsFloatOrDefault(var3, "dirSpeed", 0.0F);
            this.xSpeedRelativeRandom = var2.getValueAsFloatOrDefault(var3, "xSpeedRelativeRandom", 0.0F);
            this.ySpeedRelativeRandom = var2.getValueAsFloatOrDefault(var3, "ySpeedRelativeRandom", 0.0F);
            this.hSpeedRandom = var2.getValueAsFloatOrDefault(var3, "hSpeedRandom", 0.0F);
            this.dirSpeedRandom = var2.getValueAsFloatOrDefault(var3, "dirSpeedRandom", 0.0F);
            this.xSpeedAbsolute = var2.getValueAsFloatOrDefault(var3, "xSpeedAbsolute", 0.0F);
            this.ySpeedAbsolute = var2.getValueAsFloatOrDefault(var3, "ySpeedAbsolute", 0.0F);
            this.xSpeedAbsoluteRandom = var2.getValueAsFloatOrDefault(var3, "xSpeedAbsoluteRandom", 0.0F);
            this.ySpeedAbsoluteRandom = var2.getValueAsFloatOrDefault(var3, "ySpeedAbsoluteRandom", 0.0F);
            this.scaleTo = var2.getValueAsFloatOrDefault(var3, "scaleTo", this.scaleTo);
            this.scaleFrom = var2.getValueAsFloatOrDefault(var3, "scaleFrom", this.scaleFrom);
            this.alpha = var2.getValueAsFloatOrDefault(var3, "alpha", this.alpha);
            this.color = var2.a(var3, "color", this.color);
            if (GameEngine.at() && this.color != 0 && this.color != -1) {
                this.cachedLightingColorFilter = new LightingColorFilter(this.color, 0);
            }

            this.teamColorRatio = var2.getValueAsFloatOrDefault(var3, "teamColorRatio", this.teamColorRatio);
            if (!(this.teamColorRatio < 0.0F) && !(this.teamColorRatio > 1.0F)) {
                this.shadow = var2.getValueAsBoolean(var3, "shadow", false);
                this.drawLayer = 2;
                if (var2.getValueAsBoolean(var3, "drawUnderUnits", false)) {
                    this.drawLayer = 1;
                }

                String var5 = var2.getValueAsStaticString(var3, "drawType", (String)null);
                if (var5 != null && !var5.equals("normal")) {
                    if (!var5.equals("displacement")) {
                        throw new CustomException("Unknown drawType: " + var5);
                    }

                    this.drawLayer = 3;
                }

                this.fadeInTime = var2.getValueAsFloatOrDefault(var3, "fadeInTime", 0.0F);
                this.fadeOut = var2.getValueAsBoolean(var3, "fadeOut", true);
                this.delayedStartTimer = var2.b(var3, "delayedStartTimer", 0.0F);
                this.delayedStartTimerRandom = var2.getValueAsFloatOrDefault(var3, "delayedStartTimerRandom", 0.0F);
                this.frameIndex = var2.getValueAsIntegerOrDefault(var3, "frameIndex", 0);
                this.frameIndexRandom = var2.getValueAsIntegerOrDefault(var3, "frameIndexRandom", 0);
                String var6 = var2.getValueAsStaticString(var3, "stripIndex", "0");
                this.stripIndex = var4.bR.a(var6);
                if (this.stripIndex == -1) {
                    throw new RuntimeException("Failed to find stripIndex with name:" + var6);
                } else {
                    this.attachedToUnit = var2.getValueAsBoolean(var3, "attachedToUnit", true);
                    this.liveAfterAttachedDies = var2.getValueAsBoolean(var3, "liveAfterAttachedDies", true);
                    this.atmospheric = var2.getValueAsBoolean(var3, "atmospheric", false);
                    this.physics = var2.getValueAsBoolean(var3, "physics", false);
                    this.physicsGravity = var2.getValueAsFloatOrDefault(var3, "physicsGravity", 1.0F);
                    String var7 = var2.getValueAsStaticString(var3, "priority", (String)null);
                    if (var7 != null) {
                        try {
                            this.priority = Priority.valueOf(var7);
                        } catch (IllegalArgumentException var11) {
                            throw new RuntimeException("Unknown priority:" + var7);
                        }
                    }

                    int var8 = var2.getValueAsIntegerOrDefault(var3, "total_frames", 1);
                    if (var8 < 1) {
                        throw new CustomException("TOTAL_FRAMES cannot be: " + var8 + " (must be 1 or more)");
                    } else {
                        TeamImageCache var9 = var1.a(var2, var3, "image");
                        if (var9 != null) {
                            this.imageStrip = new class_996();
                            this.imageStrip.i = var9;
                            this.imageStrip.b = this.imageStrip.i.m() / var8;
                            this.imageStrip.c = this.imageStrip.i.l();
                            this.imageStrip.b = var2.getValueAsIntegerOrDefault(var3, "frame_width", this.imageStrip.b);
                            this.imageStrip.c = var2.getValueAsIntegerOrDefault(var3, "frame_height", this.imageStrip.c);
                            if (var8 == 1 && this.imageStrip.b >= this.imageStrip.i.m()) {
                                this.imageStrip.k = true;
                            } else if (this.imageStrip.c < this.imageStrip.i.l()) {
                                this.imageStrip.h = this.imageStrip.i.m() / this.imageStrip.b;
                                if (this.imageStrip.h < 1) {
                                    this.imageStrip.h = 1;
                                }
                            }

                            this.imageStrip.d = 0;
                            this.imageStrip.e = 0;
                            this.imageStrip.f = this.imageStrip.b;
                            this.imageStrip.g = this.imageStrip.c;
                            String var10 = var2.getValueAsStaticString(var3, "imageShadow", (String)null);
                            if (var10 != null) {
                                this.imageStrip.j = class_436.a(var1.F, var10, var1.ab, var1, var3, "imageShadow");
                                this.shadow = true;
                            }

                            if (this.shadow && this.imageStrip.j == null) {
                                throw new CustomException("imageShadow is required if image and shadow:true is used");
                            }
                        }

                        this.animateFrameStart = var2.getValueAsIntegerOrDefault(var3, "animateFrameStart", 0);
                        this.animateFrameStartRandomAdd = var2.getValueAsIntegerOrDefault(var3, "animateFrameStartRandomAdd", 0);
                        this.animateFrameEnd = var2.getValueAsIntegerOrDefault(var3, "animateFrameEnd", 0);
                        this.animateFramePingPong = var2.getValueAsBoolean(var3, "animateFramePingPong", false);
                        this.animateFrameLooping = var2.getValueAsBoolean(var3, "animateFrameLooping", false);
                        this.animateFrameSpeed = var2.b(var3, "animateFrameSpeed", 0.5F);
                        this.animateFrameSpeedRandom = var2.b(var3, "animateFrameSpeedRandom", 0.0F);
                        if (var9 != null && (this.imageStrip.b >= this.imageStrip.i.m() || var8 != 1) && this.animateFrameEnd > var8) {
                            throw new CustomException("animateFrameEnd:" + this.animateFrameEnd + " cannot be larger than TOTAL_FRAMES: " + var8 + " (when using custom image)");
                        } else {
                            this.alsoEmitEffects = var1.c(var2.getValueAsStaticString(var3, "alsoEmitEffects", (String)null));
                            this.alsoEmitEffectsOnDeath = var1.c(var2.getValueAsStaticString(var3, "alsoEmitEffectsOnDeath", (String)null));
                            this.trailEffect = var1.c(var2.getValueAsStaticString(var3, "trailEffect", (String)null));
                            this.trailEffectRate = var2.b(var3, "trailEffectRate", 6.0F);
                            this.ifSpawnFailsEmitEffects = var1.c(var2.getValueAsStaticString(var3, "ifSpawnFailsEmitEffects", (String)null));
                            this.alsoPlaySound = class_392.a(var1, var2.getValueAsStaticString(var3, "alsoPlaySound", (String)null), (class_392)null);
                        }
                    }
                }
            } else {
                throw new RuntimeException(var3 + " teamColorRatio should be between 0-1 got:" + this.teamColorRatio);
            }
        }
    }
}
