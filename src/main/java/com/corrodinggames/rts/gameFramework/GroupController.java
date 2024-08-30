package com.corrodinggames.rts.gameFramework;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

public strictfp class GroupController extends class_62 {
    int a;
    PointF b = new PointF();

    public void a() {
        this.a = 1;
    }

    public void a(GameOutputStream var1) {
        var1.writeInt(0);
        var1.writeInt(this.a);
    }

    public void a(GameInputStream var1) {
        var1.readInt();
        this.a = var1.readInt();
    }

    public void a(float var1) {
    }

    public class_984 b() {
        class_984 var1 = new class_984(this);
        var1.e = this.a++;
        return var1;
    }

    public class_984 c() {
        class_984 var1 = new class_984(this);
        var1.e = -1;
        var1.b = true;
        return var1;
    }

    public void a(class_684 var1, OrderableUnit var2, class_684 var3, float var4, int var5) {
        int var6 = 0;

        while(!var3.isEmpty()) {
            OrderableUnit var7 = null;
            float var8 = -1.0F;
            PointF var9 = null;
            int var10 = -1;
            Object[] var11 = var3.a();
            Object[] var12 = var1.a();
            int var13 = 0;

            for(int var14 = var1.size(); var13 < var14; ++var13) {
                OrderableUnit var15 = (OrderableUnit)var12[var13];
                if (var15.ad == var2 && !var15.aj) {
                    float var16 = -1.0F;
                    PointF var17 = null;
                    int var18 = -1;

                    for(int var19 = 0; var19 < var3.a; ++var19) {
                        PointF var20 = (PointF)var11[var19];
                        float var21 = var2.xCord + var20.x;
                        float var22 = var2.yCord + var20.y;
                        float var23 = class_340.a(var15.xCord, var15.yCord, var21, var22);
                        if (var16 == -1.0F || var23 < var16) {
                            var16 = var23;
                            var17 = var20;
                            var18 = var19;
                        }
                    }

                    if (var16 > var8) {
                        var7 = var15;
                        var8 = var16;
                        var9 = var17;
                        var10 = var18;
                    }
                }
            }

            if (var7 == null) {
                break;
            }

            ++var6;
            var7.aj = true;
            var7.ak = var9.x;
            var7.al = var9.y;
            var7.am = var4;
            var7.ao = var8;
            var7.ah = (short)(var5 + 1);
            var3.remove(var10);
        }

    }

    public void a(class_684 var1, OrderableUnit var2) {
        boolean var3 = false;

        label64:
        while(true) {
            OrderableUnit var4 = null;
            Iterator var5 = var1.iterator();

            while(true) {
                OrderableUnit var6;
                do {
                    do {
                        do {
                            if (!var5.hasNext()) {
                                if (var4 == null) {
                                    return;
                                }

                                var4.aj = false;
                                OrderableUnit var14 = null;
                                float var15 = 0.0F;
                                OrderableUnit var7 = var4;
                                int var8 = class_340.a((int)var4.ao);
                                Iterator var9 = var1.iterator();

                                while(var9.hasNext()) {
                                    OrderableUnit var10 = (OrderableUnit)var9.next();
                                    if (var10.ad == var2 && var10.ao > 0.0F && var10 != var7) {
                                        int var11 = class_340.a((int)var10.ao) + var8;
                                        int var12 = 0;
                                        var12 += class_340.c(var7.xCord, var7.yCord, var2.xCord + var10.ak, var2.yCord + var10.al);
                                        var12 += class_340.c(var10.xCord, var10.yCord, var2.xCord + var7.ak, var2.yCord + var7.al);
                                        float var13 = (float)(var12 - var11);
                                        if (var13 < var15) {
                                            var15 = var13;
                                            var14 = var10;
                                        }
                                    }
                                }

                                if (var14 != null) {
                                    float var16 = var7.ak;
                                    float var17 = var7.al;
                                    var7.ak = var14.ak;
                                    var7.al = var14.al;
                                    var7.ao = class_340.a(var7.xCord, var7.yCord, var2.xCord + var7.ak, var2.yCord + var7.al);
                                    var14.ak = var16;
                                    var14.al = var17;
                                    var14.ao = class_340.a(var14.xCord, var14.yCord, var2.xCord + var14.ak, var2.yCord + var14.al);
                                }
                                continue label64;
                            }

                            var6 = (OrderableUnit)var5.next();
                        } while(var6.ad != var2);
                    } while(!(var6.ao > 0.0F));
                } while(var4 != null && !(var6.ao > var4.ao));

                if (var6.aj && var6.ao > 100.0F) {
                    var4 = var6;
                }
            }
        }
    }

    public class_684 a(int var1, float var2, float var3) {
        int var4 = 1;
        int var5 = 0;
        byte var6 = 6;
        int var7 = var6 / 2;
        float var8 = 2.0F + var2 * 2.0F * 1.5F;
        class_684 var9 = new class_684();
        int var10 = var1;
        if (var1 % 2 != 0) {
            var10 = var1 + 1;
        }

        float var11 = class_340.k(var3);
        float var12 = class_340.j(var3);

        for(int var13 = 0; var13 < var10; ++var13) {
            int var14;
            if (var4 % 2 == 0) {
                var14 = var7 + var4 / 2;
            } else {
                var14 = var7 - (var4 + 1) / 2;
            }

            float var15 = (float)(var14 - var7) * var8;
            float var16 = (float)(-var5) * var8;
            float var17 = var16 * var11 - var15 * var12;
            float var18 = var15 * var11 + var16 * var12;
            var9.add(new PointF(var17, var18));
            ++var4;
            if (var4 > var6) {
                var4 = 0;
                ++var5;
            }
        }

        return var9;
    }
}
