package com.corrodinggames.rts.appFramework;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.appFramework.o
public strictfp class class_211 {
    String a;
    int b = 0;
    int c = 0;
    PlayerData d = null;
    PlayerData e = null;
    int f;
    int g;

    class_211(String var1) {
        this.a = var1;
    }

    public void a(PlayerData var1, int var2) {
        if (var2 >= this.b && this.d != null) {
            if (var2 == this.b) {
                ++this.f;
            }
        } else {
            this.b = var2;
            this.d = var1;
            this.f = 1;
        }

        if (var2 <= this.c && this.e != null) {
            if (var2 == this.c) {
                ++this.g;
            }
        } else {
            this.c = var2;
            this.e = var1;
            this.g = 1;
        }

    }

    public boolean a() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (this.b == this.c) {
            return false;
        } else if (this.d == null && this.e == null) {
            return false;
        } else {
            String var2;
            if (this.g == 1) {
                var2 = "Warning: Uneven map - Player " + (this.e.site + 1) + " on team " + this.e.getPlayerTeamName() + ": " + this.a + " is " + this.c + " vs " + this.b;
                var1.bS.h.a((String)null, var2);
                return true;
            } else {
                var2 = "Warning: Uneven map - " + this.g + " players including player " + (this.e.site + 1) + " on team " + (this.e.team + 1) + ": " + this.a + " is " + this.c + " vs " + this.b;
                var1.bS.h.a((String)null, var2);
                return true;
            }
        }
    }
}
