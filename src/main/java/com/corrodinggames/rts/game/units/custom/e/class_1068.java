package com.corrodinggames.rts.game.units.custom.e;

import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_388;
import com.corrodinggames.rts.game.units.custom.class_436;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e.d
public strictfp class class_1068 {
    public String a;
    public BuiltInResource b;
    public float c;
    public Integer d;
    public boolean e;
    public boolean f;
    class_388 g;
    class_388 h;
    boolean i;
    boolean j;
    public boolean k;
    public boolean l;
    public float m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public GroupingStyle r;
    public int s;
    public class_388 t;
    public class_388 u;
    public String v;
    public BuiltInResource w;
    public boolean x;
    public boolean y;
    public String z;
    public BuiltInResource A;
    public TeamImageCache B;
    public boolean C;

    public class_1068(boolean var1) {
        this.r = GroupingStyle.NONE;
        this.f = var1;
    }

    @SneakyThrows
    public strictfp void a(class_591 var1, UnitConfig var2, String var3, String var4) {
        this.a = var4;
        this.g = class_436.a((UnitConfig)var2, (String)var3, "displayName", (String)null);
        this.h = class_436.a((UnitConfig)var2, (String)var3, "displayNameShort", (String)null);
        if (this.h == null) {
            this.h = this.g;
        }

        this.i = var2.getValueAsBoolean(var3, "displayNameHideWhenIconShownInHUD", false);
        this.j = var2.getValueAsBoolean(var3, "displayNameHideWhenIconShownInText", false);
        this.l = var2.getValueAsBoolean(var3, "hidden", false);
        float var6 = 1.0F;
        boolean var7 = var2.getValueAsBoolean(var3, "includeInStats", true);
        if (!var7) {
            var6 = 0.0F;
        }

        if (this.l || !this.f) {
            var6 = 0.0F;
        }

        this.m = var2.getValueAsFloatOrDefault(var3, "valueInStats", var6);
        if (!var7 && this.m != 0.0F) {
            throw new CustomException("[" + var3 + "]includeInStats==false expects valueInStats==0");
        } else if (this.m < 0.0F) {
            throw new CustomException("[" + var3 + "]valueInStats cannot be < 0 (is:" + this.m + ")");
        } else {
            this.k = var2.getValueAsBoolean(var3, "stackHorizontal", false);
            this.c = var2.getValueAsFloatOrDefault(var3, "priority", 0.0F);
            this.d = var2.a((String)var3, "displayColor", (Integer)null);
            this.e = var2.getValueAsBoolean(var3, "displayColorUseInText", true);
            this.n = var2.getValueAsBoolean(var3, "displayWithRounding", true);
            this.o = var2.getValueAsBoolean(var3, "displayRoundedDown", false);
            this.p = var2.getValueAsBoolean(var3, "displayWhenZero", false);
            boolean var8 = !this.l && this.f;
            this.q = var2.getValueAsBoolean(var3, "displayInHud", var8);
            if (this.q && !this.f) {
                throw new CustomException("[" + var3 + "]displayInHud:true currently only supported on global resources");
            } else if (this.q && this.l) {
                throw new CustomException("[" + var3 + "]displayInHud:true only supported non-hidden resources");
            } else {
                this.s = var2.getValueAsIntegerOrDefault(var3, "displayPos", 0);
                this.r = (GroupingStyle)var2.a((String)var3, "displayDigitGrouping", (Enum) GroupingStyle.NONE, (Class)GroupingStyle.class);
                this.t = class_436.a((UnitConfig)var2, (String)var3, "displayTextPrefix", (String)null);
                this.u = class_436.a((UnitConfig)var2, (String)var3, "displayTextPostfix", (String)null);
                class_388 var9 = class_436.a((UnitConfig)var2, (String)var3, "displayPrefixInHUD", (String)null);
                if (var9 != null) {
                    if (this.t != null) {
                        throw new CustomException("[" + var3 + "]displayPrefixInHUD and displayTextPrefix are aliases, don't use both");
                    }

                    this.t = var9;
                }

                class_388 var10 = class_436.a((UnitConfig)var2, (String)var3, "displayPostfixInHUD", (String)null);
                if (var10 != null) {
                    if (this.u != null) {
                        throw new CustomException("[" + var3 + "]displayPostfixInHUD and displayTextPostfix are aliases, don't use both");
                    }

                    this.u = var10;
                }

                this.v = var2.getValueAsStaticString(var3, "displayTextAppendResource", (String)null);
                String var11 = var2.getValueAsStaticString(var3, "appendResourceInHUD", (String)null);
                if (var11 != null) {
                    if (this.v != null) {
                        throw new CustomException("[" + var3 + "]displayTextAppendResource and appendResourceInHUD are aliases, don't use both");
                    }

                    this.v = var11;
                }

                this.x = var2.getValueAsBoolean(var3, "displayTextAppendResourceWithGap", false);
                this.y = var2.getValueAsBoolean(var3, "appendResourceInHUD_whenThisZero", true);
                this.B = var1.a(var2, var3, "iconImage", true);
                if (this.B != null && (this.B.m() > 100 || this.B.l() > 100)) {
                    throw new CustomException("[" + var3 + "]iconImage: Image is too big, keep under 100x100");
                } else {
                    this.C = var2.getValueAsBoolean(var3, "iconImageUseInText", true);
                    if (this.i && this.B == null) {
                        throw new CustomException("[" + var3 + "]displayNameHideWhenIconShownInHUD: Cannot use without iconImage");
                    } else if (this.j && this.B == null) {
                        throw new CustomException("[" + var3 + "]displayNameHideWhenIconShownInText: Cannot use without iconImage");
                    } else {
                        String var5 = this.f ? "g_" : "l_";
                        var5 = var5 + this.a;
                        this.b = BuiltInResource.a(var5, false, this.f);
                        if (this.b.u) {
                            throw new RuntimeException("Cannot define resource with a built-in name: " + var5);
                        } else {
                            if (!this.f) {
                                String var12 = var2.getValueAsStaticString(var3, "equivalentGlobalResourceForAI", (String)null);
                                this.z = var12;
                            }

                        }
                    }
                }
            }
        }
    }

    @SneakyThrows
    public strictfp void a(class_591 var1) {
        if (this.z != null) {
            this.A = var1.k(this.z);
            if (this.A == null) {
                throw new CustomException("[resource]equivalentGlobalResourceForAI: Failed to find resource: " + this.z);
            }

            if (!this.A.t) {
                throw new CustomException("[resource]equivalentGlobalResourceForAI: Expected global resource for: " + this.z);
            }
        }

        if (this.v != null) {
            this.w = var1.k(this.v);
            if (this.w == null) {
                throw new CustomException("[resource]displayTextAppendResource: Failed to find resource: " + this.v);
            }
        }

    }
}
