package com.corrodinggames.rts.gameFramework.n;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.n.i
class class_623 {
    boolean a;
    class_684 b;
    // $FF: synthetic field
    final class_70 c;

    class_623(class_70 var1) {
        this.c = var1;
        this.b = new class_684();
    }

    public void a(class_31 var1, int var2) {
        class_31 var3 = class_591.c(var1);
        if (var3 != null) {
            var1 = var3;
        }

        this.b(var1, var2);
    }

    public void b(class_31 var1, int var2) {
        Iterator var3 = this.b.iterator();

        class_624 var4;
        do {
            if (!var3.hasNext()) {
                class_624 var5 = new class_624(this);
                var5.a = var1;
                var5.b = var2;
                this.b.add(var5);
                return;
            }

            var4 = (class_624)var3.next();
        } while(var4.a != var1);

        var4.b += var2;
    }

    public strictfp void a(float var1, float var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        int var4 = 0;
        Object var5 = PlayerData.getPlayerData(1);
        if (var5 == null) {
            GameEngine.log("Warning: Creating missing wave team AI");
            var5 = new class_138(1);
            ((PlayerData)var5).team = 100;
            ((PlayerData)var5).U = true;
        }

        Iterator var6 = this.b.iterator();

        while(var6.hasNext()) {
            class_624 var7 = (class_624)var6.next();

            for(int var8 = 0; var8 < var7.b; ++var8) {
                Unit var9 = var7.a.a();
                byte var10 = 85;
                var9.xCord = var1 + (float)class_340.a(-var10, var10, var4 + 0);
                var9.yCord = var2 + (float)class_340.a(-var10, var10, var4 + 1);
                var9.cg = (float)class_340.a(-180, 180, var4 + 2);
                var4 += 3;
                var9.b((PlayerData)var5);
                if (var9.xCord < 0.0F) {
                    var9.xCord = 0.0F;
                }

                if (var9.yCord < 0.0F) {
                    var9.yCord = 0.0F;
                }

                if (var9.xCord > var3.bL.i()) {
                    var9.xCord = var3.bL.i();
                }

                if (var9.yCord > var3.bL.j()) {
                    var9.yCord = var3.bL.j();
                }

                if (var8 == 0) {
                    var3.bW.a(var9);
                }
            }
        }

    }

    public String toString() {
        if (this.b.size() == 0) {
            return "No units";
        } else {
            String var1 = "";
            boolean var2 = true;

            class_624 var4;
            for(Iterator var3 = this.b.iterator(); var3.hasNext(); var1 = var1 + var4.a.e()) {
                var4 = (class_624)var3.next();
                if (!var2) {
                    var1 = var1 + ", ";
                }

                var2 = false;
                var1 = var1 + var4.b + "x ";
            }

            return var1;
        }
    }
}
