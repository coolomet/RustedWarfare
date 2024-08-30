package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.TeamStats;
import com.corrodinggames.rts.gameFramework.class_340;
import java.util.ArrayList;

public strictfp class DisplayedStat {
    public String a;
    public String b;
    public float c;
    public float d;

    public DisplayedStat(String var1, String var2) {
        this.a = var1;
        this.b = var2;
    }

    public DisplayedStat(String var1, float var2) {
        this.a = var1;
        this.c = var2;
        this.b = null;
    }

    public static ArrayList a() {
        GameEngine var0 = GameEngine.getGameEngine();
        ArrayList var1 = new ArrayList();
        TeamStats var2 = null;
        if (var0.playerTeam != null) {
            var2 = var0.stats.getTeamStatsFromTeam(var0.playerTeam);
        }

        if (var2 != null) {
            DisplayedStat var3;
            if (var0.ce != null && var0.ce.k) {
                var3 = new DisplayedStat("Lasted till wave: " + var0.ce.r, "");
                var1.add(var3);
                if (!var0.ce.l) {
                    var3 = new DisplayedStat("Wave difficulty: " + var0.netEngine.c(var0.ce.y), "");
                    var1.add(var3);
                }
            }

            var3 = new DisplayedStat("Game Time", class_340.a((long)(var0.by / 1000)));
            var1.add(var3);
            var3 = new DisplayedStat("=============================", "");
            var1.add(var3);
            var3 = new DisplayedStat("Units Killed", (float)var2.unitsKilled);
            var1.add(var3);
            var3 = new DisplayedStat("Buildings Killed", (float)var2.buildingsKilled);
            var1.add(var3);
            var3 = new DisplayedStat("Experimentals Killed", (float)var2.experimentalsKilled);
            var1.add(var3);
            var3 = new DisplayedStat("=============================", "");
            var1.add(var3);
            var3 = new DisplayedStat("Units Lost", (float)var2.unitsLost);
            var1.add(var3);
            var3 = new DisplayedStat("Buildings Lost", (float)var2.buildingsLost);
            var1.add(var3);
            var3 = new DisplayedStat("Experimentals Lost", (float)var2.experimentalsLost);
            var1.add(var3);
            var3 = new DisplayedStat("=============================", "");
            var1.add(var3);
        }

        return var1;
    }
}
