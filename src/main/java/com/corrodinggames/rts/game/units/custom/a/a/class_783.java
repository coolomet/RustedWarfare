package com.corrodinggames.rts.game.units.custom.a.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_226;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_436;
import com.corrodinggames.rts.game.units.custom.class_441;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.a.class_1037;
import com.corrodinggames.rts.game.units.custom.a.class_776;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import java.util.regex.Pattern;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.a.f
public strictfp class class_783 extends class_776 {
    class_441 a;
    class_441 b;
    class_441 c;
    class_441 d;
    class_441 e;
    class_441 f;
    static final Pattern g = Pattern.compile("%\\{([^\\]]*?)\\}");

    public static void a(class_591 var0, UnitConfig var1, String var2, String var3, class_1037 var4, String var5, boolean var6) {
        class_441 var7 = class_436.a(var0, var1, var2, "showMessageToPlayer", (String)null);
        class_441 var8 = class_436.a(var0, var1, var2, "showMessageToAllPlayers", (String)null);
        class_441 var9 = class_436.a(var0, var1, var2, "showMessageToAllEnemyPlayers", (String)null);
        class_441 var10 = class_436.a(var0, var1, var2, "showQuickWarLogToPlayer", (String)null);
        class_441 var11 = class_436.a(var0, var1, var2, "showQuickWarLogToAllPlayers", (String)null);
        class_441 var12 = class_436.a(var0, var1, var2, "debugMessage", (String)null);
        if (var7 != null || var8 != null || var9 != null || var10 != null || var11 != null || var12 != null) {
            class_783 var13 = new class_783();
            var13.a = var7;
            var13.b = var8;
            var13.c = var9;
            var13.d = var10;
            var13.e = var11;
            var13.f = var12;
            var4.ac.add(var13);
        }

    }

    public String a(class_113 var1, String var2) {
        if (var2 == null) {
            var2 = null;
        }

        return var2;
    }

    public boolean a(class_113 var1, class_226 var2, PointF var3, Unit var4, int var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        if (this.a != null && var1.bX == var6.playerTeam) {
            GameNetEngine.a((String)null, (String)this.a(var1, this.a.b(var1)));
        }

        if (this.b != null) {
            GameNetEngine.a((String)null, (String)this.a(var1, this.b.b(var1)));
        }

        if (this.c != null && var6.playerTeam != null && var1.bX.c(var6.playerTeam)) {
            GameNetEngine.a((String)null, (String)this.a(var1, this.c.b(var1)));
        }

        if (this.d != null && var1.bX == var6.playerTeam) {
            var6.bS.i.a(this.a(var1, this.d.b(var1)));
        }

        if (this.e != null) {
            var6.bS.i.a(this.a(var1, this.e.b(var1)));
        }

        if (this.f != null && var6.bv && var6.bl) {
            String var7 = var1.dt().i() + "(" + var1.id + ") Debug: " + this.a(var1, this.f.b(var1));
            GameNetEngine.a((String)null, (String)var7);
        }

        return true;
    }
}
