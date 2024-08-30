package com.corrodinggames.rts.game.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.buildings.class_88;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.class_62;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_694;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.game.a.o
public abstract strictfp class class_63 extends class_62 {
    public int Q;
    protected final class_138 R;
    public float S;
    public float T;
    public float U;
    public boolean V;
    static final ArrayList W = new ArrayList();

    public void a(GameOutputStream var1) {
        var1.writeFloat(this.S);
        var1.writeFloat(this.T);
        var1.writeFloat(this.U);
    }

    public void a(GameInputStream var1) {
        this.S = var1.readFloat();
        this.T = var1.readFloat();
        this.U = var1.readFloat();
    }

    public class_63(class_138 var1) {
        ++var1.aI;
        this.Q = var1.aI;
        this.R = var1;
        this.R.bm.add(this);
        this.R.bn.add(this);
    }

    public class_63(class_138 var1, float var2, float var3) {
        this(var1);
        this.S = var2;
        this.T = var3;
    }

    public void p() {
        this.R.bm.remove(this);
        this.R.bn.remove(this);
        this.V = true;
    }

    public boolean c(float var1, float var2) {
        float var3 = class_340.a(this.S, this.T, var1, var2);
        float var4 = this.U;
        return var3 < var4 * var4;
    }

    public boolean b(Unit var1) {
        float var2 = class_340.a(this.S, this.T, var1.xCord, var1.yCord);
        float var3 = this.U + var1.cj;
        return var2 < var3 * var3;
    }

    public boolean a(Unit var1, float var2) {
        float var3 = class_340.a(this.S, this.T, var1.xCord, var1.yCord);
        float var4 = this.U + var1.cj + var2;
        return var3 < var4 * var4;
    }

    public float c(Unit var1) {
        return class_340.a(this.S, this.T, var1.xCord, var1.yCord);
    }

    public float a(class_69 var1) {
        return class_340.a(this.S, this.T, var1.S, var1.T);
    }

    public float d(float var1, float var2) {
        return class_340.a(this.S, this.T, var1, var2);
    }

    public PointF w() {
        PointF var1 = new PointF();
        float var2 = (float)(Math.random() * 360.0);
        float var3 = (float)(Math.random() * (double)this.U);
        var1.setSite(this.S + class_340.k(var2) * var3, this.T + class_340.j(var2) * var3);
        return var1;
    }

    public PointF e(class_31 var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        PointF var3 = new PointF();
        float var4 = this.U;
        MovementType var5 = MovementType.LAND;
        Unit var6 = null;
        if (var1 == UnitType.seaFactory) {
            var4 = 600.0F;
            var5 = MovementType.WATER;
        }

        for(int var7 = 0; var7 < 15; ++var7) {
            UnitType var8 = null;
            boolean var9 = false;
            boolean var10 = false;
            int var13;
            if (this instanceof class_69) {
                class_69 var11 = (class_69)this;
                if (var7 < 6 && var1 == UnitType.fabricator) {
                    var8 = UnitType.fabricator;
                }

                if (var8 != null) {
                    OrderableUnit var12 = null;
                    if (var6 == null) {
                        var6 = Unit.c(var1);
                    }

                    if (var6 instanceof OrderableUnit) {
                        var12 = (OrderableUnit)var6;
                    }

                    var13 = var11.c(var8);
                    if (var12 != null && var13 > 1) {
                        int var14 = -1;
                        int var15 = class_340.rand(0, var13 - 1);
                        Unit[] var16 = Unit.bE.a();
                        int var17 = 0;

                        for(int var18 = Unit.bE.size(); var17 < var18; ++var17) {
                            Unit var19 = var16[var17];
                            if (var19.bX == this.R && var11.a(var19) && var19.bT() && this.R.i(var19) && var19.r() == var8) {
                                ++var14;
                                if (var14 == var15) {
                                    float var20 = var19.xCord;
                                    float var21 = var19.yCord;
                                    boolean var22 = class_340.rand(0, 1) == 0;
                                    float var23 = var20;
                                    float var24 = var21;
                                    if (var22) {
                                        var24 = var21 + class_340.c(-150.0F, 150.0F);
                                    } else {
                                        var23 = var20 + class_340.c(-150.0F, 150.0F);
                                    }

                                    boolean var25 = false;
                                    W.clear();
                                    Object var26 = null;
                                    var2.bS.a(var12, var20, var21, var23, var24, var25, W, (Unit)var26);
                                    if (W.size() > 0) {
                                        PointF var27 = (PointF)W.get(0);
                                        var3.setSite(var27.x, var27.y);
                                        var9 = true;
                                    } else {
                                        var10 = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (!var10) {
                if (!var9) {
                    float var28 = (float)(Math.random() * 360.0);
                    float var30 = (float)(Math.random() * (double)var4);
                    var3.setSite(this.S + class_340.k(var28) * var30, this.T + class_340.j(var28) * var30);
                }

                var2.bL.a(var3.x, var3.y);
                int var29 = var2.bL.T;
                int var31 = var2.bL.U;
                if (var2.bL.c(var29, var31)) {
                    var13 = class_694.c((float)var29, (float)var31, var5);
                    if ((var13 > 5 || var13 == 0) && class_88.a(var1, var3.x, var3.y, this.R)) {
                        return var3;
                    }
                }

                if (var1 == UnitType.seaFactory) {
                    var4 += 100.0F;
                }
            }
        }

        return null;
    }
}
