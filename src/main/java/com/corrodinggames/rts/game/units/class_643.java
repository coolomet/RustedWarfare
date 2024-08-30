package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.2.1
class class_643 implements Runnable {
    // $FF: synthetic field
    final class_273 a;

    class_643(class_273 var1) {
        this.a = var1;
    }

    public void run() {
        GameEngine var1 = GameEngine.getGameEngine();
        boolean var2 = var1.replayEngine.k();
        if (!var2) {
            EditorOrBuilder var3 = EditorOrBuilder.L();
            var1.bS.e = true;
            if (!var1.netEngine.B) {
                long var4 = var1.netEngine.w;
                var1.netEngine.useMods = true;
                int var6 = var1.netEngine.gameMapData.fog;
                var1.netEngine.R();
                var1.netEngine.gameMapData.fog = var6;
                var1.netEngine.w = var4;
                var1.netEngine.ingame = true;
                var1.tick = 0;
                var1.netEngine.loaclTick = var1.tick + 1;
                var1.netEngine.w();
            }

            String var7 = "[sandbox]" + var1.al() + " [v" + var1.v() + "] (" + class_340.a("d MMM yyyy HH.mm.ss") + ").replay";
            var1.replayEngine.d(var7);
            var1.bS.e = false;
            GameEngine.f((String)null, "Replay started as: " + var7);
            EditorOrBuilder var5 = EditorOrBuilder.L();
            if (var5 != null && var3 != null) {
                var5.a(var3);
                var5.r = var7;
            } else {
                GameEngine.print("Failed copySettingsFromAnotherEditor");
            }
        } else {
            var1.replayEngine.close();
        }

    }
}
