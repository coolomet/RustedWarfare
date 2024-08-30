package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ListOperate_UpdateRoom implements Runnable {
    public void run() {
        GameEngine.aq();
        GameEngine var1 = GameEngine.getGameEngine();

        try {
            ArrayList var2 = new ArrayList(2);
            GameNetAPIOperate.listAddBasicNameValuePair(var2, "action", "update");
            String var3 = var1.netEngine.aS;
            if (var3 == null) {
                GameEngine.b("startUpdateOnMasterServer", "No game id");
                return;
            }

            GameNetAPIOperate.listAddBasicNameValuePair(var2, "id", var3);
            GameNetAPIOperate.listAddBasicNameValuePair(var2, "private_token", var1.netEngine.aR);
            if (GameEngine.ax()) {
                GameNetAPIOperate.listAddBasicNameValuePair(var2, "check_port", "false");
            }

            GameNetAPIOperate.b((List)var2);
            BufferedReader var4 = GameNetAPIOperate.a((List)var2);
            String var5 = var4.readLine();
            if (var5 == null || !var5.contains("CORRODINGGAMES")) {
                GameEngine.b("startUpdateOnMasterServer", "Error bad header returned from the master server: " + var5);
                return;
            }

            String var6 = var4.readLine();
            if (!"GAME UPDATED".equals(var6)) {
                GameEngine.b("startUpdateOnMasterServer", "Update server response was:" + var6);
            }
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }
}
