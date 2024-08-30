package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ListOperate_AddRoom implements Runnable {
    public void run() {
        GameEngine.aq();
        long var1 = GameEngine.millis();
        GameEngine var3 = GameEngine.getGameEngine();
        GameEngine.b("StartCreateOnMasterServer", "Starting create");
        boolean var19 = false;

        label135: {
            float var24;
            label136: {
                try {
                    var19 = true;
                    ArrayList var4 = new ArrayList(2);
                    GameNetAPIOperate.listAddBasicNameValuePair(var4, "action", "add");
                    String var5 = "u_" + class_340.b();
                    GameNetAPIOperate.listAddBasicNameValuePair(var4, "user_id", var5);
                    APIEncryption.a.a(var5, var4);
                    GameNetAPIOperate.listAddBasicNameValuePair(var4, "game_name", "Unnamed");
                    GameNetAPIOperate.listAddBasicNameValuePair(var4, "game_version", Integer.toString(var3.c(true)));
                    if (!var3.netEngine.v) {
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "game_version_string", var3.v());
                    } else {
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "game_version_string", "ANY");
                    }

                    GameNetAPIOperate.listAddBasicNameValuePair(var4, "game_version_beta", class_340.a(var3.n()));
                    String var6 = var3.netEngine.au();
                    if (var6 != null) {
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "game_mods", var6);
                    }

                    GameNetAPIOperate.listAddBasicNameValuePair(var4, "private_token", var3.netEngine.aR);
                    GameNetAPIOperate.listAddBasicNameValuePair(var4, "private_token_2", class_340.b(class_340.b(var3.netEngine.aR)));
                    GameNetAPIOperate.listAddBasicNameValuePair(var4, "confirm", class_340.b("a" + class_340.b(var3.netEngine.aR)));
                    GameNetAPIOperate.b((List)var4);
                    BufferedReader var7 = GameNetAPIOperate.a(var4, 15);
                    String var8 = var7.readLine();
                    if (var8 == null || !var8.contains("CORRODINGGAMES")) {
                        GameEngine.b("StartCreateOnMasterServer", "Error bad header returned from the master server: " + var8);
                        var19 = false;
                        break label135;
                    }

                    String var9 = var7.readLine();
                    String[] var10 = var9.split(",");
                    if (var10.length < 1) {
                        GameEngine.b("StartCreateOnMasterServer", "columns.length too short at:" + var10.length);
                    }

                    String var11 = var10[0];

                    try {
                        GameEngine.b("StartCreateOnMasterServer", "Created server is:" + var11);
                        var3.netEngine.aS = var11;
                    } catch (NumberFormatException var21) {
                        GameEngine.b("StartCreateOnMasterServer", "failed to load server");
                        var21.printStackTrace();
                    }

                    if (var10.length >= 2) {
                        try {
                            APIEncryption.f = Integer.parseInt(var10[1]);
                        } catch (NumberFormatException var20) {
                            APIEncryption.f = -1;
                        }
                    }

                    GameEngine.b("StartCreateOnMasterServer", "Completed create from master server without error");
                    var19 = false;
                    break label136;
                } catch (IOException var22) {
                    var22.printStackTrace();
                    var19 = false;
                } finally {
                    if (var19) {
                        float var14 = (float)(GameEngine.millis() - var1) / 1000000.0F;
                        GameEngine.b("StartCreateOnMasterServer", "create took: " + var14 + " seconds");
                    }
                }

                var24 = (float)(GameEngine.millis() - var1) / 1000000.0F;
                GameEngine.b("StartCreateOnMasterServer", "create took: " + var24 + " seconds");
                return;
            }

            var24 = (float)(GameEngine.millis() - var1) / 1000000.0F;
            GameEngine.b("StartCreateOnMasterServer", "create took: " + var24 + " seconds");
            return;
        }

        float var25 = (float)(GameEngine.millis() - var1) / 1000000.0F;
        GameEngine.b("StartCreateOnMasterServer", "create took: " + var25 + " seconds");
    }
}
