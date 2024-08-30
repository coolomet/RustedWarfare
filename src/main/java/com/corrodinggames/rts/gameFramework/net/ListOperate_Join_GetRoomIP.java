package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;

class ListOperate_Join_GetRoomIP implements Runnable {
    class_184 a;
    String b;
    int c;
    String d;

    public void run() {
        GameEngine.aq();
        GameEngine var1 = GameEngine.getGameEngine();
        GameEngine.b("getGameServerInfoFromMasterServer", "Starting getGameServerInfoFromMasterServer");
        String var2 = GameNetAPIOperate.a(this.c);
        boolean var3 = false;
        String var4 = null;
        if (this.d != null) {
            var4 = class_340.c(this.b + this.d, (int)3);
        }

        try {
            ArrayList var5 = new ArrayList(2);
            var5.add(new BasicNameValuePair("action", "get"));
            var5.add(new BasicNameValuePair("game_id", this.b));
            var5.add(new BasicNameValuePair("c", var2));
            var5.add(new BasicNameValuePair("p_hash", var4));
            BufferedReader var6 = GameNetAPIOperate.a((List)var5);
            String var7 = var6.readLine();
            if (var7 != null && var7.contains("CORRODINGGAMES")) {
                String var8 = var6.readLine();
                if (var8 == null) {
                    throw new IOException("Unexpected end of response");
                } else {
                    String var9;
                    if (var7.contains("[FAILED]")) {
                        GameEngine.print("Got failed header with status:" + var8);
                        var9 = "Failed to get server connection data - unknown";
                        GameConnectStatusType var30 = GameConnectStatusType.UNKNOWN;
                        if (var8.startsWith("ERROR_OTHER")) {
                            String[] var31 = var8.split(",");
                            if (var31.length >= 2) {
                                var9 = var31[1];
                            }

                            var30 = GameConnectStatusType.UNKNOWN;
                        } else if (var8.startsWith("ERROR_MISSING")) {
                            var9 = "Request missing required fields";
                        } else if (!var8.startsWith("ERROR_WRONG_C")) {
                            if (var8.startsWith("ERROR_MISSING_PASSWORD")) {
                                var9 = "Missing password";
                                var30 = GameConnectStatusType.UNKNOWN;
                            } else if (var8.startsWith("ERROR_WRONG_PASSWORD")) {
                                var9 = "Wrong password";
                                var30 = GameConnectStatusType.WRONG_PASSWORD;
                            }
                        }

                        this.a.a(var9, var30, (Exception)null);
                    } else {
                        var9 = var6.readLine();
                        if (var9 == null) {
                            throw new IOException("Unexpected end of response");
                        } else {
                            String var10 = class_340.c("game_" + var2).toLowerCase(Locale.ROOT);
                            if (!var9.toLowerCase(Locale.ROOT).contains(var10)) {
                                GameEngine.b("getGameServerInfoFromMasterServerRunnable", "Error bad header returned from the master server: " + var9);
                                this.a.a("Unexpected return from master server", GameConnectStatusType.UNKNOWN, (Exception)null);
                            } else {
                                String var11 = var6.readLine();
                                String var12 = var6.readLine();
                                if (var12 == null) {
                                    throw new IOException("Unexpected end of response");
                                } else {
                                    String[] var13 = var12.split(",");
                                    if (var13.length <= 18) {
                                        throw new RuntimeException("getGameServerInfoFromMasterServerRunnable: columns.length too short at:" + var13.length);
                                    } else {
                                        String var14 = var13[3];
                                        String var15 = var13[4];
                                        String var16 = var13[5];
                                        String var17 = var13[6];
                                        String var18 = var13[7];
                                        String var19 = var13[8];
                                        String var20 = var13[9];
                                        String var21 = var13[10];
                                        String var22 = var13[11];
                                        String var23 = var13[12];
                                        String var24 = var13[13];
                                        String var25 = var13[15];
                                        String var26 = var13[16];
                                        String var27 = var13[17];
                                        String var28 = var13[18];
                                        GameEngine.b("getGameServerInfoFromMasterServerRunnable", "got ");
                                        GameEngine.b("getGameServerInfoFromMasterServerRunnable", "Completed get from master server without error");
                                        var3 = true;
                                        this.a.a(var14 + ":" + var16);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                GameEngine.b("getGameServerInfoFromMasterServerRunnable", "Error bad header returned from the master server: " + var7);
                this.a.a("Unexpected header from master server", GameConnectStatusType.UNKNOWN, (Exception)null);
            }
        } catch (IOException var29) {
            GameEngine.a((String)"getGameServerInfoFromMasterServerRunnable Failed", (Exception)var29);
            this.a.a(var29.getMessage(), GameConnectStatusType.UNKNOWN, var29);
        }
    }
}
