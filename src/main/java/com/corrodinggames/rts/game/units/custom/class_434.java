package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.gameFramework.FileChangeEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.aa
class class_434 {
    public long a;
    public String b;

    public class_434(String var1) {
        this.b = var1;
        this.a = this.a(true);
    }

    public strictfp long a(boolean var1) {
        if (GameEngine.au()) {
            return 0L;
        } else {
            long var2 = FileChangeEngine.a(this.b, var1);
            if (var1 && var2 == 0L) {
                GameEngine.log("Failed to watch: " + this.b);
            }

            return var2;
        }
    }
}
