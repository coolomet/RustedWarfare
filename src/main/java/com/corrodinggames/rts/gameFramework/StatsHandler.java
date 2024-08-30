package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.ArrayList;

public strictfp class StatsHandler {
    public static boolean a = true;
    TeamStats b = new TeamStats();
    TeamStats[] c;
    int d;
    boolean e;
    public static class_974 f = new class_974();

    public StatsHandler() {
        this.c = new TeamStats[PlayerData.e];
    }

    public strictfp void a(GameOutputStream var1) {
        var1.e("stats");
        var1.writeByte(0);
        int var2 = PlayerData.c;
        var1.writeInt(var2);

        for(int var3 = 0; var3 < var2; ++var3) {
            this.c[var3].a(var1);
        }

        var1.endBlock("stats");
    }

    public strictfp void a(GameInputStream var1, boolean var2) {
        var1.startBlock("stats");
        byte var3 = var1.readByte();
        int var4 = var1.readInt();
        this.c = new TeamStats[PlayerData.e];

        for(int var5 = 0; var5 < var4; ++var5) {
            this.c[var5] = new TeamStats();
            this.c[var5].a(var1);
        }

        var1.endBlock("stats");
    }

    public strictfp void a() {
        this.b = new TeamStats();
        this.c = new TeamStats[PlayerData.e];

        for(int var1 = 0; var1 < this.c.length; ++var1) {
            this.c[var1] = new TeamStats();
        }

        this.d = 0;
        this.e = a;
    }

    public strictfp void b() {
        int var1 = GameEngine.getGameEngine().by;
        if (this.e && this.d <= var1) {
            int var2 = 5000;
            if (var1 < 60000) {
                var2 = 1000;
            }

            if (var1 > 1800000) {
                var2 = 15000;
            }

            if (var1 > 3600000) {
                var2 = 30000;
            }

            var2 += var2;
            this.a(var1, false, false);
        }

    }

    private strictfp void a(int var1, boolean var2, boolean var3) {
        for(int var4 = 0; var4 < PlayerData.c; ++var4) {
            PlayerData var5 = PlayerData.getPlayerData(var4);
            if (var5 != null) {
                TeamHistory var6 = this.c[var4].l;
                if (!var2 || var6.c()) {
                    var6.a(var5, var1, var3);
                    var6.a(var4);
                }
            }
        }

    }

    public strictfp void c() {
        this.e = false;
        this.a(GameEngine.getGameEngine().by, true, true);
    }

    public strictfp ArrayList d() {
        ArrayList var1 = new ArrayList();

        for(int var2 = 0; var2 < PlayerData.c; ++var2) {
            if (this.c[var2].l.c()) {
                var1.add(this.c[var2]);
            }
        }

        return var1;
    }

    public strictfp TeamStats a(Unit var1) {
        return this.getTeamStatsFromTeam(var1.bX);
    }

    public strictfp TeamStats getTeamStatsFromTeam(PlayerData var1) {
        int var2 = var1.site;
        if (var2 >= 0 && var2 < this.c.length) {
            TeamStats var3 = this.c[var2];
            return var3 == null ? this.b : var3;
        } else {
            return this.b;
        }
    }

    public strictfp void a(Unit var1, Unit var2, float var3) {
        if (var1 != null) {
            boolean var4 = var2.bV;
            TeamStats var5 = this.a(var1);
            TeamStats var6 = this.a(var2);
            if (var4) {
                f.a(var1, var2);
                if (var2.bI()) {
                    ++var5.buildingsKilled;
                    ++var6.buildingsLost;
                } else if (var2.dd()) {
                    ++var5.experimentalsKilled;
                    ++var6.experimentalsLost;
                } else {
                    ++var5.unitsKilled;
                    ++var6.unitsLost;
                }
            }
        }

        GameEngine var7 = GameEngine.getGameEngine();
        if (var2.bX == var7.playerTeam) {
            var7.a(var2, var3);
        }

    }
}
