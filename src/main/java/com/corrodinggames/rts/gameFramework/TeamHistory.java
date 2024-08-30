package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.bn
public strictfp class TeamHistory {
    private int a = -1;
    private class_971[] b = new class_971[class_972.values().length];

    public TeamHistory() {
        this.a();
    }

    public strictfp void a() {
        for(int var1 = 0; var1 < this.b.length; ++var1) {
            this.b[var1] = new class_971();
        }

    }

    public strictfp void a(GameInputStream var1) {
        boolean var2 = var1.readBoolean();
        if (var2) {
            var1.checkMark("History");
            var1.readByte();
            this.a = var1.readInt();
            boolean var3 = var1.readBoolean();
            byte var4 = var1.readByte();
            this.a();

            for(int var5 = 0; var5 < var4; ++var5) {
                int var6 = 0;
                int var7 = 0;
                short var8 = var1.readShort();

                for(int var9 = 0; var9 < var8; ++var9) {
                    int var10;
                    int var11;
                    if (var3) {
                        var10 = var1.readInt() + var6;
                        var11 = var1.readInt() + var7;
                        var6 = var10;
                        var7 = var11;
                    } else {
                        var10 = var1.readInt();
                        var11 = var1.readInt();
                    }

                    if (var5 < this.b.length) {
                        this.b[var5].add(new class_970(var10, var11));
                    }
                }
            }
        }

    }

    public strictfp void a(GameOutputStream var1) {
        boolean var2 = true;
        var1.writeBoolean(var2);
        if (var2) {
            var1.e();
            var1.writeByte(0);
            var1.writeInt(this.a);
            boolean var3 = true;
            var1.writeBoolean(var3);
            var1.writeByte(this.b.length);
            int var4 = 0;
            class_971[] var5 = this.b;
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                class_971 var8 = var5[var7];
                short var9 = (short)var8.size();
                var1.a(var9);
                int var10 = 0;
                int var11 = 0;

                for(int var12 = 0; var12 < var9; ++var12) {
                    ++var4;
                    class_970 var13 = (class_970)var8.get(var12);
                    if (var3) {
                        int var14 = var13.a;
                        int var15 = var13.b;
                        var1.writeInt(var14 - var10);
                        var1.writeInt(var15 - var11);
                        var10 = var14;
                        var11 = var15;
                    } else {
                        var1.writeInt(var13.a);
                        var1.writeInt(var13.b);
                    }
                }
            }

            GameEngine.log("TeamHistory(" + this.a + "): totalValues written:" + var4);
        }

    }

    public strictfp void a(PlayerData var1, int var2, boolean var3) {
        class_972[] var4 = class_972.values();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            class_972 var7 = var4[var6];
            int var8 = var7.e.a(var1);
            class_971 var9 = this.b[var7.ordinal()];
            if (var9.isEmpty() || var3 || ((class_970)var9.get(var9.size() - 1)).b != var8) {
                var9.add(new class_970(var2, var8));
            }
        }

    }

    public strictfp void a(int var1) {
        this.a = var1;
    }

    public strictfp int b() {
        return this.a;
    }

    public strictfp class_971 a(class_972 var1) {
        return this.b[var1.ordinal()];
    }

    public strictfp boolean c() {
        if (this.a < 0) {
            return false;
        } else {
            class_971[] var1 = this.b;
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                class_971 var4 = var1[var3];
                if (var4.size() > 1) {
                    return true;
                }
            }

            return false;
        }
    }

    public strictfp int a(class_972 var1, int var2) {
        return this.b[var1.ordinal()].a(var2);
    }

    public strictfp void a(TeamHistory var1) {
        for(int var2 = 0; var2 < this.b.length; ++var2) {
            this.b[var2] = this.a(this.b[var2], var1.b[var2]);
        }

    }

    private strictfp class_971 a(class_971 var1, class_971 var2) {
        if (var1.isEmpty()) {
            var1.addAll(var2);
            return var1;
        } else {
            class_971 var3 = new class_971();
            int var4 = 0;
            int var5 = 0;
            int var6 = 0;
            Iterator var7 = var1.iterator();

            while(true) {
                while(var7.hasNext()) {
                    class_970 var8 = (class_970)var7.next();
                    int var9 = var8.a;
                    int var10 = var8.b;
                    if (var4 < var2.size()) {
                        class_970 var11 = (class_970)var2.get(var4);

                        while(var11.a < var9) {
                            var6 = var11.b;
                            var3.add(new class_970(var11.a, var5 + var6));
                            ++var4;
                            if (var4 < var2.size()) {
                                var11 = (class_970)var2.get(var4);
                            }
                        }

                        if (var11.a == var9) {
                            var6 = var11.b;
                            var5 = var10;
                            var3.add(new class_970(var9, var10 + var6));
                            ++var4;
                        } else if (var11.a > var9) {
                            var5 = var10;
                            var3.add(new class_970(var9, var10 + var6));
                        }
                    } else {
                        var5 = var10;
                        var3.add(new class_970(var9, var10 + var6));
                    }
                }

                while(var4 < var2.size()) {
                    class_970 var12 = (class_970)var2.get(var4);
                    var6 = var12.b;
                    var3.add(new class_970(var12.a, var5 + var6));
                    ++var4;
                }

                return var3;
            }
        }
    }
}
