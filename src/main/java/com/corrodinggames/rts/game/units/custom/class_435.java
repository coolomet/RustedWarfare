package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.i.class_800;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.ab
public strictfp class class_435 {
    String a;
    String b;
    int c;
    int d;
    String e;
    class_591 f;

    public strictfp String a() {
        String var1 = "from internal units";
        if (this.a != null) {
            var1 = "from mod:'" + this.a + "'";
        }

        class_800 var2 = GameEngine.getGameEngine().bZ.f(this.a);
        if (var2 != null) {
            if (!var2.m()) {
                var1 = var1 + " (You seem to have this mod but it is not enabled)";
            } else {
                var1 = var1 + " (You seem to have this mod but it might be a different version)";
            }
        }

        String var3 = "";
        if (this.f != null && this.e != null) {
            if (this.f.I == null) {
                var3 = " (Extra debug not enabled)";
            } else {
                String[] var4 = this.e.split("\n");
                String[] var5 = this.f.I.split("\n");
                int var6 = class_340.c(var4.length, var5.length);
                if (var4.length != var5.length) {
                    var3 = var3 + "Line length difference: " + var4.length + " vs " + var5.length;
                }

                for(int var7 = 0; var7 < var6; ++var7) {
                    if (!var4[var7].equals(var5[var7])) {
                        var3 = var3 + "Difference on line " + var7 + ": '" + var4[var7] + "' vs '" + var5[var7] + "'";
                        break;
                    }
                }
            }
        }

        return this.d == -1 ? "The server requires the unit:" + this.b + " that was not found " + var1 + var3 : "Found unit:" + this.b + " but it does not match the server's copy " + var1 + var3 + " (checksum c:" + this.d + " s:" + this.c + ")";
    }
}
