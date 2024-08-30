package com.corrodinggames.rts.gameFramework.g;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.custom.e.a.CreditsResource;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.g.a
public strictfp class class_162 {
    private final class_173 a;
    private final class_169 b;
    private final ArrayList c;

    public class_162() {
        this(class_173.none, class_169.PLAYER);
    }

    public class_162(class_173 var1, class_169 var2) {
        this.c = new ArrayList();
        this.a = var1;
        this.b = var2;
    }

    public void a() {
        if (this.a != class_173.none) {
            ArrayList var1 = PlayerData.b(false);
            if (this.b == class_169.PLAYER) {
                Iterator var2 = var1.iterator();

                while(var2.hasNext()) {
                    PlayerData var3 = (PlayerData)var2.next();
                    this.c.add(new class_167(var3));
                }
            } else if (this.b == class_169.ALLY_GROUP) {
                ArrayList var9 = PlayerData.f();
                Iterator var11 = var9.iterator();

                while(var11.hasNext()) {
                    Integer var4 = (Integer)var11.next();
                    ArrayList var5 = new ArrayList();
                    Iterator var6 = var1.iterator();

                    while(var6.hasNext()) {
                        PlayerData var7 = (PlayerData)var6.next();
                        if (var7.team == var4) {
                            var5.add(var7);
                        }
                    }

                    this.c.add(new class_166(var4, var5));
                }
            } else if (this.b == class_169.COMBINED_PLAYER_AND_GROUP) {
                int var10 = 0;
                ArrayList var12 = PlayerData.f();
                Iterator var13 = var12.iterator();

                PlayerData var8;
                Integer var14;
                ArrayList var16;
                Iterator var17;
                while(var13.hasNext()) {
                    var14 = (Integer)var13.next();
                    var16 = new ArrayList();
                    var17 = var1.iterator();

                    while(var17.hasNext()) {
                        var8 = (PlayerData)var17.next();
                        if (var8.team == var14) {
                            var16.add(var8);
                        }
                    }

                    if (var10 < var16.size()) {
                        var10 = var16.size();
                    }
                }

                if (var10 <= 1) {
                    var13 = var1.iterator();

                    while(var13.hasNext()) {
                        PlayerData var15 = (PlayerData)var13.next();
                        this.c.add(new class_167(var15));
                    }
                } else {
                    var13 = var12.iterator();

                    while(var13.hasNext()) {
                        var14 = (Integer)var13.next();
                        var16 = new ArrayList();
                        var17 = var1.iterator();

                        while(var17.hasNext()) {
                            var8 = (PlayerData)var17.next();
                            if (var8.team == var14) {
                                var16.add(var8);
                            }
                        }

                        this.c.add(new class_166(var14, var16));
                        var17 = var16.iterator();

                        while(var17.hasNext()) {
                            var8 = (PlayerData)var17.next();
                            this.c.add(new class_167(var8));
                        }
                    }
                }
            }

            this.b();
        }
    }

    public void b() {
        Iterator var1 = this.c.iterator();

        while(var1.hasNext()) {
            class_165 var2 = (class_165)var1.next();
            var2.b(this.a);
        }

    }

    public void c() {
        int var1 = this.a.ordinal() + 1;
        if (var1 >= class_173.values().length) {
            var1 = 0;
        }

        class_173 var2 = class_173.values()[var1];
        class_169 var3 = class_169.COMBINED_PLAYER_AND_GROUP;
        GameEngine var4 = GameEngine.getGameEngine();
        var4.a(var2, var3);
    }

    public String a(class_165 var1) {
        return this.b == class_169.COMBINED_PLAYER_AND_GROUP && var1 instanceof class_167 ? "   " + a(this.a, class_165.b(var1)) : a(this.a, class_165.b(var1));
    }

    public static String a(class_173 var0, int var1) {
        switch (var0) {
            case none: {
                return "" + var1;
            }
            case income: {
                return "+" + CreditsResource.D.a(var1, true);
            }
        }
        return CreditsResource.D.a(var1, true);
    }

    public ArrayList d() {
        return this.c;
    }

    public class_173 e() {
        return this.a;
    }

    public class_169 f() {
        return this.b;
    }
}
