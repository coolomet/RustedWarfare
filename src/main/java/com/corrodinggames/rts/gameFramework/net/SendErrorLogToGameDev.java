package com.corrodinggames.rts.gameFramework.net;

import android.os.Build.VERSION;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.steam.SteamEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SendErrorLogToGameDev implements Runnable {
    String a;
    String b;

    public void run() {
        if (true) return; // no sending reports to dev!
        long var1 = GameEngine.millis();
        GameEngine var3 = GameEngine.getGameEngine();
        GameEngine.b("SendErrorReport", "Starting");
        boolean var15 = false;

        label131: {
            float var19;
            label132: {
                label133: {
                    try {
                        var15 = true;
                        ArrayList var4 = new ArrayList(2);
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "action", "error_report");
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "game_version", Integer.toString(var3.c(false)));
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "game_version_internal", Integer.toString(var3.c(true)));
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "game_version_string", var3.r());
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "package_name", var3.l());
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "installation_source", var3.m());
                        String var5 = "" + VERSION.SDK_INT;
                        if (GameEngine.av()) {
                            var5 = "s:0;";
                            if (SteamEngine.getSteamEngine().e()) {
                                var5 = "s:1;";
                            }
                        }

                        String var6;
                        if (GameEngine.av() || GameEngine.aZ) {
                            var6 = System.getProperty("os.name") + " - " + System.getProperty("os.version");
                            GameNetAPIOperate.listAddBasicNameValuePair(var4, "system_version", var6);
                        }

                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "sdk_version", var5);
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "device_model", var3.G());
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "build_version", var3.H());
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "release_version", class_340.a(GameEngine.as));
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "dedicated_server", class_340.a(GameEngine.isModsInSD));
                        var6 = "NA";
                        if (var3.netEngine != null) {
                            var6 = var3.netEngine.aR;
                        }

                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "private_token", var6);
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "private_token_2", class_340.b(class_340.b(var6)));
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "message", this.a);
                        GameNetAPIOperate.listAddBasicNameValuePair(var4, "stacktrace", this.b);
                        GameEngine.b("SendErrorReport", "making request");
                        BufferedReader var7 = GameNetAPIOperate.a((List)var4);
                        String var8 = var7.readLine();
                        if (var8 == null || !var8.contains("CORRODINGGAMES")) {
                            GameEngine.b("StartCreateOnMasterServer", "Error bad header returned from the master server: " + var8);
                            var15 = false;
                            break label131;
                        }

                        GameEngine.b("SendErrorReport", "Send trace successfully");
                        var15 = false;
                        break label133;
                    } catch (IOException var16) {
                        var16.printStackTrace();
                        var15 = false;
                        break label132;
                    } catch (Exception var17) {
                        var17.printStackTrace();
                        var15 = false;
                    } finally {
                        if (var15) {
                            float var11 = (float)(GameEngine.millis() - var1) / 1000000.0F;
                            GameEngine.b("SendErrorReport", "took: " + var11 + " seconds");
                        }
                    }

                    var19 = (float)(GameEngine.millis() - var1) / 1000000.0F;
                    GameEngine.b("SendErrorReport", "took: " + var19 + " seconds");
                    return;
                }

                var19 = (float)(GameEngine.millis() - var1) / 1000000.0F;
                GameEngine.b("SendErrorReport", "took: " + var19 + " seconds");
                return;
            }

            var19 = (float)(GameEngine.millis() - var1) / 1000000.0F;
            GameEngine.b("SendErrorReport", "took: " + var19 + " seconds");
            return;
        }

        float var9 = (float)(GameEngine.millis() - var1) / 1000000.0F;
        GameEngine.b("SendErrorReport", "took: " + var9 + " seconds");
    }
}
