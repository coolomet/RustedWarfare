package com.corrodinggames.rts.gameFramework.f;

import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Rect;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.ae
public strictfp class class_523 {
    static class_525 a = new class_525();
    static class_525 b = new class_525();
    static class_525 c = new class_525();
    public Paint d;
    public Paint e;
    static Paint f = new Paint();
    public Paint g;
    static Paint h;
    class_684 i;

    public class_523() {
        this.d = a;
        this.e = a;
        this.g = this.d;
        this.i = new class_684();
    }

    public void a(Paint var1) {
        if (var1 == null) {
            this.g = this.d;
        } else {
            this.g = var1;
        }
    }

    public void a(boolean var1) {
        if (var1) {
            this.g = this.e;
        } else {
            this.g = this.d;
        }

    }

    public String a() {
        StringBuilder var1 = new StringBuilder();
        Iterator var2 = this.i.iterator();

        while(var2.hasNext()) {
            class_508 var3 = (class_508)var2.next();
            if (var3 instanceof class_510) {
                var1.append(((class_510)var3).d);
            }
        }

        return var1.toString();
    }

    public void a(String var1) {
        if (this.i.size() > 0) {
            int var2 = this.i.size() - 1;
            class_508 var3 = (class_508)this.i.get(var2);
            if (var3 instanceof class_510) {
                class_510 var4 = (class_510)var3;
                String var5 = class_340.a(var4.d, var1);
                if (!var4.d.equals(var5)) {
                    this.i.set(var2, var4.b(var5));
                }
            }
        }

    }

    public void b() {
        this.i.clear();
    }

    public void a(class_508 var1) {
        this.i.add(var1);
    }

    public void b(String var1) {
        if (this.g != null && this.g != this.d) {
            this.a(var1, this.g);
        } else {
            this.a((class_508)(new class_510(this, var1)));
        }
    }

    public void a(String var1, Paint var2) {
        this.a((class_508)(new class_511(this, var1, var2)));
    }

    public void a(String var1, int var2) {
        if (this.g != null && this.g != this.d) {
            this.a((class_508)(new class_511(this, var1, this.g, var2)));
        } else {
            this.a((class_508)(new class_511(this, var1, (Paint)null, var2)));
        }
    }

    public void a(String var1, int var2, boolean var3) {
        Paint var4 = this.d;
        if (var3) {
            var4 = this.e;
        }

        this.a((class_508)(new class_511(this, var1, var4, var2)));
    }

    public void a(TeamImageCache var1, int var2, int var3) {
        class_509 var4 = new class_509(this);
        var4.a = var1;
        float var5 = class_550.a(var1, (float)var2, (float)var3);
        var4.c = (int)((float)var1.p * var5);
        var4.d = (int)((float)var1.q * var5);
        var4.b = var5;
        this.i.add(var4);
    }

    public int c() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.bO.a("A", this.g);
    }

    public class_499 a(int var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        Rect var4 = new Rect(-var1 / 2, 0, var1 / 2, 10);
        class_684 var5 = new class_684();
        class_500 var6 = new class_500();
        Paint var7 = this.d;
        int var8 = var1 - 5;
        Iterator var9 = this.i.iterator();

        label108:
        while(var9.hasNext()) {
            class_508 var10 = (class_508)var9.next();
            if (var6.b >= var8 - 5) {
                if (var6.a.size() > 0) {
                    var5.add(var6);
                }

                var6 = new class_500();
            }

            if (!(var10 instanceof class_510)) {
                var6.a(var10);
                var6.b += var10.a(this.d);
            } else {
                class_510 var11 = (class_510)var10;
                String var12 = var11.d;
                int var13 = 0;

                while(true) {
                    while(true) {
                        if (var13 >= var12.length()) {
                            continue label108;
                        }

                        if (var12.charAt(var13) == '\n') {
                            ++var13;
                            var5.add(var6);
                            var6 = new class_500();
                        } else {
                            int var14 = var7.a(var12, var13, var12.length(), true, (float)(var8 - var6.b), (float[])null);
                            if (var14 == 0) {
                                continue label108;
                            }

                            boolean var15 = true;
                            int var16 = var12.indexOf("\n", var13 + 1);
                            String var17;
                            if (var16 != -1 && var16 < var13 + var14) {
                                var14 = var16 - var13;
                            } else {
                                if (var13 + var14 < var12.length()) {
                                    var17 = var12.substring(var13, var13 + var14);
                                    int var18 = var17.lastIndexOf(" ");
                                    if (var18 != -1 && var18 != 0) {
                                        var14 = var18;
                                    }
                                }

                                if (var13 + var14 == var12.length()) {
                                    var15 = false;
                                }
                            }

                            var17 = var12.substring(var13, var13 + var14);
                            if (class_340.c(var17, "\\n")) {
                                var17 = var17.replaceAll("(\\n)", "");
                            }

                            class_510 var25 = var11.b(var17);
                            var6.a(var25);
                            var6.b += var25.a(this.d);
                            var13 += var14;
                            if (var13 < var12.length() && var12.charAt(var13) == '\n') {
                                ++var13;
                            }

                            if (var15 || var6.b >= var8 - 5) {
                                if (var6.a.size() > 0) {
                                    var5.add(var6);
                                }

                                var6 = new class_500();
                            }
                        }
                    }
                }
            }
        }

        if (var6.a.size() > 0) {
            var5.add(var6);
        }

        var6 = null;
        if (var5.size() > 0) {
            class_500 var19 = (class_500)var5.get(var5.size() - 1);
            if (var19.a.size() == 0) {
                var5.remove(var5.size() - 1);
            }
        }

        var4.d = var4.b + var5.size() * class_550.a(var7);
        if (var2) {
            float var20 = (float)var4.d();
            float var22 = 0.0F;
            Iterator var23 = var5.iterator();

            while(var23.hasNext()) {
                class_500 var24 = (class_500)var23.next();
                if ((float)var24.b > var22) {
                    var22 = (float)var24.b;
                }
            }

            if (var22 < (float)var4.b()) {
                var4.a = (int)(var20 - var22 / 2.0F);
                var4.c = (int)(var20 + var22 / 2.0F);
            }
        }

        class_499 var21 = new class_499();
        var21.a = var5;
        var21.b = var4;
        var21.c = this.d;
        var21.d = this.e;
        return var21;
    }

    static {
        c.a(true);
        h = new Paint();
        h.b(-65536);
        h.a(Paint$Style.b);
    }
}
