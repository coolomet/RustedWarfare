package com.corrodinggames.rts.game.a;

import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.a.d
public abstract strictfp class class_564 {
    String b;
    public ArrayList c;
    private ArrayList a;
    // $FF: synthetic field
    final class_138 d;

    public class_564(class_138 var1, String var2) {
        this.d = var1;
        this.c = new ArrayList();
        this.a = new ArrayList();
        this.b = var2;
        var1.bq.add(this);
    }

    public boolean b(class_31 var1) {
        Iterator var2 = this.c.iterator();

        class_659 var3;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            var3 = (class_659)var2.next();
        } while(var3.a != var1);

        return true;
    }

    public abstract boolean a(class_31 var1);

    public float c(class_31 var1) {
        return 10.0F;
    }

    public ArrayList a() {
        Collections.shuffle(this.a);
        return this.a;
    }

    public void b() {
        this.c = new ArrayList();
        float var1 = 0.0F;
        Iterator var2 = UnitType.ae.iterator();

        while(var2.hasNext()) {
            class_31 var3 = (class_31)var2.next();
            if (this.a(var3)) {
                float var4 = this.c(var3);
                var1 += var4;
                this.c.add(new class_659(this, var3, var4));
            }
        }

        this.a = new ArrayList(this.c);
        if (this.c.size() == 0) {
            GameEngine.log("AI: rebuildUnitMix: no units in unitMix:" + this.b);
        }

    }

    public class_31 c() {
        return this.a((MovementType)null, -1);
    }

    public class_31 a(MovementType var1) {
        return this.a(var1, -1);
    }

    public boolean a(class_31 var1, MovementType var2) {
        if (var2 == null) {
            return true;
        } else {
            MovementType var3 = var1.o();
            if (var3 == MovementType.OVER_CLIFF) {
                var3 = MovementType.LAND;
            }

            if (var3 == MovementType.OVER_CLIFF_WATER) {
                var3 = MovementType.HOVER;
            }

            return var3 == var2;
        }
    }

    public class_31 a(MovementType var1, int var2) {
        if (this.c.size() == 0) {
            GameEngine.log("AI: getRandomUnitType: no units in unitMix:" + this.b);
            return null;
        } else {
            float var3 = 0.0F;
            int var4 = 0;
            Iterator var5 = this.c.iterator();

            while(true) {
                class_659 var6;
                do {
                    do {
                        if (!var5.hasNext()) {
                            if (var4 == 0) {
                                return null;
                            }

                            float var9 = class_340.c(0.0F, var3);
                            float var10 = 0.0F;
                            Iterator var7 = this.c.iterator();

                            class_659 var8;
                            do {
                                do {
                                    do {
                                        if (!var7.hasNext()) {
                                            GameEngine.log("Did not find getRandomUnit, this should only happen very rarely, name:" + this.b + " unitMix.size:" + this.c.size() + " minPrice:" + var2 + " movementType:" + var1 + " totalUnits:" + var4);
                                            return ((class_659)this.c.get(this.c.size() - 1)).a;
                                        }

                                        var8 = (class_659)var7.next();
                                    } while(!this.a(var8.a, var1));
                                } while(var2 != -1 && var8.a.price() > var2);

                                var10 += var8.b;
                            } while(!(var10 > var9));

                            return var8.a;
                        }

                        var6 = (class_659)var5.next();
                    } while(!this.a(var6.a, var1));
                } while(var2 != -1 && var6.a.price() > var2);

                var3 += var6.b;
                ++var4;
            }
        }
    }
}
