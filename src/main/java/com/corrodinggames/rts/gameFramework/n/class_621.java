package com.corrodinggames.rts.gameFramework.n;

import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Typeface;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.MapException;
import com.corrodinggames.rts.game.maps.class_487;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_388;
import com.corrodinggames.rts.game.units.custom.class_395;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.n.a.class_1005;
import com.corrodinggames.rts.gameFramework.n.a.class_1006;
import com.corrodinggames.rts.gameFramework.n.a.class_1007;
import lombok.SneakyThrows;

import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.n.c
public strictfp class class_621 {
    @SneakyThrows
    public static class_637 a(class_70 var0, class_487 var1) {
        try {
            GameEngine var2 = GameEngine.getGameEngine();
            String var3 = var1.name;
            if (var3 == null) {
                var3 = "NULL";
            }

            String var4 = var1.b("id");
            if (var4 != null && !var4.equals("")) {
                var3 = var4;
            }

            var3 = var3.trim();
            String var6 = var1.type;
            if (var6 == null) {
                class_70.c("Error: no type field set for: " + var3);
                return null;
            } else {
                class_609 var5 = class_609.a(var6);
                if (var5 == null) {
                    class_70.c("Error: Unknown type:" + var6 + " found on " + var3);
                    return null;
                } else {
                    class_637 var7 = new class_637();
                    var7.t = var1;
                    var7.g = var5;
                    var7.b = var3;
                    int var8 = 0;
                    Iterator var9 = var0.J.iterator();

                    while(var9.hasNext()) {
                        class_637 var10 = (class_637)var9.next();
                        if (var10.b.equalsIgnoreCase(var7.b)) {
                            ++var8;
                        }
                    }

                    var7.c = var7.b;
                    if (var8 != 0) {
                        var7.c = var7.c + "_" + var8;
                    }

                    var7.a = var1.name;
                    Integer var16 = var7.d("team");
                    if (var16 != null) {
                        var7.y = PlayerData.getPlayerData(var16);
                        if (var7.y == null) {
                            var7.g("Cannot find team:" + var16);
                            return null;
                        }
                    }

                    var7.r = var7.b("delay", var7.r);
                    var7.p = var7.b("repeatDelay", var7.p);
                    var7.o = var7.a("repeatCount", var7.o);
                    var7.q = var7.b("resetActivationAfter", var7.q);
                    var7.h = var7.a("allToActivate", false);
                    var7.d.b = var7.h;
                    var7.s = var7.b("warmup", var7.s);
                    var7.A = var7.a("globalMessage", (class_388)null);
                    var7.w = var7.a("textOffsetX", 0.0F);
                    var7.x = var7.a("textOffsetY", 0.0F);
                    if (var7.g == class_609.g || var7.g == class_609.a) {
                        var7.z = var7.a("text", (class_388)null);
                    }

                    String var12;
                    if (var7.g == class_609.g) {
                        var0.i = true;
                        var7.B = new Paint();
                        var7.B.a(true);
                        var7.B.a(Paint$Align.b);
                        var7.B.a(Typeface.a((Typeface)Typeface.c, 1));
                        int var17 = var7.c("textColor", -1);
                        var7.B.b(var17);
                        int var11 = var7.a("textSize", 20);
                        var2.b(var7.B, (float)var11);
                        if (var7.B.f() == 0) {
                            var7.g("Text has an alpha of 0");
                        }

                        var12 = var7.b("style");
                        if (var12 != null && !var12.equals("")) {
                            if (var12.equalsIgnoreCase("arrow")) {
                                var7.C = true;
                            } else {
                                var7.g("Unknown style: " + var12);
                            }
                        }
                    }

                    if (var7.g == class_609.e) {
                        String var18 = var7.b("spawnUnits");
                        String var19 = "<unitAdd>";
                        var12 = "spawnUnits";

                        try {
                            var7.v = class_395.a(var18, var19, var12);
                        } catch (Exception var14) {
                            class_70.c(var14.getMessage());
                            return null;
                        }

                        if (var7.a() == null) {
                            var7.g("No team set");
                        }
                    }

                    if (var7.g == class_609.d) {
                        var7.a("addTeamTags");
                        var7.a("removeTeamTags");
                    }

                    if (var7.g == class_609.c) {
                        var7.a("add");
                        var7.a("set");
                    }

                    if (var7.g == class_609.i) {
                        var7.a((class_1005)class_1006.d(var7));
                    }

                    if (var7.g == class_609.j) {
                        var7.a((class_1005)class_1007.d(var7));
                    }

                    var7.a("comment");
                    var7.a("team");
                    var7.a("globalMessage");
                    var7.a("globalMessage_delayPerChar");
                    var7.a("globalMessage_textColor");
                    var7.a("debugMessage");
                    var7.a("showOnMap");
                    var7.a("text");
                    var7.a("target");
                    var7.a("onlyIfEmpty");
                    if (var7.g == class_609.b) {
                        var7.a("unload");
                    }

                    if (var7.g == class_609.f) {
                        var7.a("onlyIfEmpty");
                    }

                    return var7;
                }
            }
        } catch (RuntimeException var15) {
            throw new MapException("Error while reading: " + var1.b(), var15);
        }
    }
}
