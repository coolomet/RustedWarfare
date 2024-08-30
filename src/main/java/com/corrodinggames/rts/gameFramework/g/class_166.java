package com.corrodinggames.rts.gameFramework.g;

import com.corrodinggames.rts.game.PlayerData;
import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.g.b
public strictfp class class_166 extends class_165 {
    private final String a;
    private final int b;
    private final ArrayList c;

    public class_166(int var1, ArrayList var2) {
        this.b = var1;
        this.c = var2;
        this.a = "Team " + PlayerData.getTeamName(var1);
    }

    public boolean a() {
        return true;
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return PlayerData.i(this.b);
    }

    public int d() {
        return PlayerData.i(this.b);
    }

    public int a(class_173 var1) {
        int var2 = 0;

        PlayerData var4;
        for(Iterator var3 = this.c.iterator(); var3.hasNext(); var2 += var1.a(var4)) {
            var4 = (PlayerData)var3.next();
        }

        return var2;
    }
}
