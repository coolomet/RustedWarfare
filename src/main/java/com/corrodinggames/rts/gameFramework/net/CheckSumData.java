package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_1042;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.buildings.CommandCenter;
import com.corrodinggames.rts.gameFramework.GameObject;
import java.util.ArrayList;
import java.util.Iterator;

public strictfp class CheckSumData {
    public long allSum;
    public ArrayList b = new ArrayList();
    public ChecksumItem c = new ChecksumItem(this, "Unit Pos");
    public ChecksumItem d = new ChecksumItem(this, "Unit Dir", false);
    public ChecksumItem e = new ChecksumItem(this, "Unit Hp");
    public ChecksumItem f = new ChecksumItem(this, "Unit Id");
    public ChecksumItem g = new ChecksumItem(this, "Waypoints");
    public ChecksumItem h = new ChecksumItem(this, "Waypoints Pos");
    public ChecksumItem i = new ChecksumItem(this, "Team Credits");
    public ChecksumItem j = new ChecksumItem(this, "UnitPaths");
    public ChecksumItem k = new ChecksumItem(this, "Unit Count");
    public ChecksumItem l = new ChecksumItem(this, "Team Info", false);
    public ChecksumItem m = new ChecksumItem(this, "Team 1 Credits", false);
    public ChecksumItem n = new ChecksumItem(this, "Team 2 Credits", false);
    public ChecksumItem o = new ChecksumItem(this, "Team 3 Credits", false);
    public ChecksumItem p = new ChecksumItem(this, "Command center2", false);
    public ChecksumItem q = new ChecksumItem(this, "Command center3", false);

    public strictfp void a() {
        ChecksumItem var2;
        for(Iterator var1 = this.b.iterator(); var1.hasNext(); var2.b = 0L) {
            var2 = (ChecksumItem)var1.next();
        }

    }

    public strictfp void b() {
        this.allSum = 0L;
        this.a();
        Iterator var1 = GameObject.er.iterator();

        ChecksumItem var10000;
        while(var1.hasNext()) {
            GameObject var2 = (GameObject)var1.next();
            if (var2 instanceof OrderableUnit) {
                OrderableUnit var3 = (OrderableUnit)var2;
                this.allSum = (long)((float)this.allSum + var3.xCord * 1000.0F);
                this.allSum = (long)((float)this.allSum + var3.yCord * 1000.0F);
                this.allSum = (long)((float)this.allSum + var3.health * 1.0F);
                this.allSum += var3.id;
                var10000 = this.c;
                var10000.b += (long)Float.floatToRawIntBits(var3.xCord);
                var10000 = this.c;
                var10000.b += (long)Float.floatToRawIntBits(var3.yCord);
                var10000 = this.d;
                var10000.b += (long)Float.floatToRawIntBits(var3.cg);
                var10000 = this.e;
                var10000.b = (long)((float)var10000.b + var3.health);
                var10000 = this.f;
                var10000.b += var3.id;
                if (var2 instanceof CommandCenter) {
                    CommandCenter var4 = (CommandCenter)var3;
                    var10000 = this.p;
                    var10000.b = (long)((float)var10000.b + var4.f * 2.0F);
                    var10000 = this.q;
                    var10000.b += (long)var4.h;
                }

                class_1042 var7 = var3.ar();
                if (var7 != null) {
                    var10000 = this.g;
                    var10000.b += var7.j();
                    var10000 = this.h;
                    var10000.b = (long)((float)var10000.b + var7.g() * 1000.0F);
                }

                var10000 = this.j;
                var10000.b += var3.aL();
            }
        }

        for(int var5 = 0; var5 < PlayerData.c; ++var5) {
            PlayerData var6 = PlayerData.getPlayerData(var5);
            if (var6 != null) {
                var10000 = this.i;
                var10000.b += (long)((int)var6.credits);
                if (var5 == 0) {
                    var10000 = this.m;
                    var10000.b += (long)((int)var6.credits);
                }

                if (var5 == 1) {
                    var10000 = this.n;
                    var10000.b += (long)((int)var6.credits);
                }

                if (var5 == 2) {
                    var10000 = this.o;
                    var10000.b += (long)((int)var6.credits);
                }

                var10000 = this.k;
                var10000.b += (long)var6.w();
                var10000 = this.l;
                var10000.b += (long)(var5 + var6.x * 100 + var6.team * 1000 + (var6.w ? var5 : 0) * 10000);
            }
        }

    }
}
