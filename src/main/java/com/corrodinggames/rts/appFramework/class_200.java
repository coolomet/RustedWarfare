package com.corrodinggames.rts.appFramework;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import com.corrodinggames.rts.game.Player;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_337;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.i.class_800;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $FF: renamed from: com.corrodinggames.rts.appFramework.i
public strictfp class class_200 extends class_194 {
    boolean c;
    String d;

    public void b() {
        super.b();
        class_208.a(this, true);
    }

    public static String d(String var0) {
        if (var0 == null) {
            return null;
        } else {
            int var2;
            if (var0.contains("/MOD|")) {
                var2 = var0.indexOf("/MOD|");
                return var0.substring(var2);
            } else if (var0.contains("/NEW_PATH|")) {
                var2 = var0.indexOf("/NEW_PATH|");
                return var0.substring(var2);
            } else {
                String[] var1 = var0.split("/");
                return var1[var1.length - 1];
            }
        }
    }

    public static boolean a(String var0, String var1) {
        Pattern var2 = Pattern.compile(".*\\[(.*)\\].*");
        Matcher var3 = var2.matcher(var0);
        String var4;
        if (var3.matches()) {
            var4 = var3.group(1);
            if ((var4.toLowerCase(Locale.ENGLISH) + "|").contains("demo|")) {
                return true;
            }
        }

        var4 = var1.replace(".tmx", "");
        var4 = var4 + "_demo";
        return class_697.i(var4);
    }

    public static String e(String var0) {
        return class_208.b(var0);
    }

    public static boolean f(String var0) {
        return var0.contains("skirmish/");
    }

    public static boolean g(String var0) {
        return var0.contains("SD/");
    }

    public static void a(String var0, boolean var1, int var2, int var3, boolean var4, boolean var5) {
        GameEngine var6 = GameEngine.getGameEngine();
        var6.bS.g();
        if (!var1 && !var5) {
            var6.L();
            synchronized(var6) {
                var6.dm = null;
                var6.dl = var0;
            }

            if (!var5) {
                var6.a(true, class_337.NORMAL);
            }
        } else {
            int var7 = 0;
            var6.L();
            synchronized(var6) {
                var6.dm = null;
                var6.dl = var0;
                int var9 = PlayerData.c - 1;
                int var10 = class_208.a(var0);
                GameEngine.log("Max teams on map: " + var0 + " = " + var10);
                if (var10 > 0 && var10 - 1 < var9) {
                    var9 = var10 - 1;
                }

                PlayerData.F();
                var6.playerTeam = new Player(0);
                var6.playerTeam.name = "Player";

                int var11;
                int var12;
                for(var11 = 0; var11 <= 1; ++var11) {
                    for(var12 = 1; var12 <= var9; ++var12) {
                        boolean var13 = var12 % 2 == 0 || var11 == 1;
                        if (var7 < var3 && var13) {
                            PlayerData var14 = PlayerData.getPlayerData(var12);
                            if (var14 == null) {
                                class_138 var22 = new class_138(var12);
                                var22.name = "AI";
                                var22.team = 0;
                                ++var7;
                            }
                        }
                    }
                }

                GameEngine.log("Allies: " + var7 + "/" + var3);
                var11 = 0;
                var12 = var2 - var3;

                for(int var21 = 0; var21 <= 1; ++var21) {
                    for(int var23 = 1; var23 <= var9; ++var23) {
                        boolean var15 = var23 % 2 == 1 || var21 == 1;
                        if (!var4) {
                            var15 = true;
                        }

                        if (var11 < var12 && var15) {
                            PlayerData var16 = PlayerData.getPlayerData(var23);
                            if (var16 == null) {
                                class_138 var24 = new class_138(var23);
                                var24.name = "AI";
                                ++var11;
                                if (var4) {
                                    var24.team = 1;
                                }
                            }
                        }
                    }
                }

                var6.netEngine.aq();
                if (!var5) {
                    var6.a(false, class_337.NORMAL);
                }
            }
        }

    }

    public void onCreateContextMenu(ContextMenu var1, View var2, ContextMenu.ContextMenuInfo var3) {
        super.onCreateContextMenu(var1, var2, var3);
        AdapterView.AdapterContextMenuInfo var4 = (AdapterView.AdapterContextMenuInfo)var3;
        View var5 = var4.targetView;
        String var6 = (String)var5.getTag();
        GameEngine var7 = GameEngine.getGameEngine();
        String var8 = e(var6);
        class_800 var9;
        if (var6 != null) {
            var9 = var7.bZ.h(var6);
        } else {
            var9 = null;
        }

        this.d = var6;
        var1.setHeaderTitle(var8);
        MenuItem var10 = var1.add(0, var5.getId(), 0, "Export");
        if (var9 != null) {
            var10.setTitle("Export (Standalone maps only)");
            var10.setEnabled(false);
        }

        MenuItem var11 = var1.add(2, var5.getId(), 0, "Delete");
        if (var9 != null) {
            var11.setTitle("Delete (Standalone maps only)");
            var11.setEnabled(false);
        }

        if (var9 != null) {
            MenuItem var12 = var1.add(4, var5.getId(), 0, "From Mod: " + var9.b());
            var12.setEnabled(false);
        }

        if (var9 == null && this.c) {
            String var14 = class_697.n(var6);
            MenuItem var13 = var1.add(3, var2.getId(), 0, "Storage: " + var14);
            if (var13 != null) {
                var13.setEnabled(false);
            }
        }

    }
}
