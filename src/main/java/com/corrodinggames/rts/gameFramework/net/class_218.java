package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.appFramework.class_196;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.p
class class_218 implements Runnable {
    public void run() {
        GameEngine.aq();
        GameEngine var1 = GameEngine.getGameEngine();
        GameEngine.b("GetOwnInfoRunnable", "Starting getOwnInfoFromMasterServer");

        try {
            ArrayList var2 = new ArrayList(2);
            var2.add(new BasicNameValuePair("action", "self_info"));
            GameNetAPIOperate.listAddBasicNameValuePair(var2, "port", Integer.toString(var1.netEngine.port));
            GameNetAPIOperate.listAddBasicNameValuePair(var2, "id", var1.netEngine.aS);
            APIEncryption.a.b(var1.netEngine.aS, var2);
            APIEncryption.a.c(var1.netEngine.aS, var2);
            BufferedReader var3 = GameNetAPIOperate.a((List)var2);
            String var4 = var3.readLine();
            if (var4 == null || !var4.contains("CORRODINGGAMES")) {
                GameEngine.b("GetOwnInfoRunnable", "Error bad header returned from the master server: " + var4);
                return;
            }

            String var5;
            while((var5 = var3.readLine()) != null) {
                String[] var6 = var5.split(",");
                if (var6.length <= 1) {
                    GameEngine.b("GetOwnInfoRunnable", "columns.length too short at:" + var6.length);
                } else {
                    String var7 = var6[0];
                    String var8 = var6[1];

                    try {
                        GameEngine.b("GetOwnInfoRunnable", "got info");
                        var1.netEngine.a(true, var7, Boolean.parseBoolean(var8));
                    } catch (NumberFormatException var10) {
                        GameEngine.b("GetOwnInfoRunnable", "failed to load server");
                        var10.printStackTrace();
                    }
                }
            }

            class_196.l();
            GameEngine.b("GetOwnInfoRunnable", "Completed load from master server without error");
        } catch (ClientProtocolException var11) {
            var1.netEngine.a(false, (String)null, (Boolean)null);
            var11.printStackTrace();
        } catch (IOException var12) {
            var1.netEngine.a(false, (String)null, (Boolean)null);
            var12.printStackTrace();
        } catch (Exception var13) {
            var1.netEngine.a(false, (String)null, (Boolean)null);
            GameEngine.a("GetOwnInfoRunnable Failed", var13);
        }

    }
}
