package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ListOperate_RemoveRoom implements Runnable {
    public void run() {
        GameEngine.aq();
        GameEngine var1 = GameEngine.getGameEngine();
        GameEngine.b("startRemoveOnMasterServer", "Starting remove");

        try {
            ArrayList var2 = new ArrayList(2);
            GameNetAPIOperate.listAddBasicNameValuePair(var2, "action", "remove");
            String var3 = var1.netEngine.aS;
            if (var3 == null) {
                GameEngine.b("startRemoveOnMasterServer", "No game id");
                return;
            }

            GameNetAPIOperate.listAddBasicNameValuePair(var2, "id", var3);
            GameNetAPIOperate.listAddBasicNameValuePair(var2, "private_token", var1.netEngine.aR);
            BufferedReader var4 = GameNetAPIOperate.a((List)var2);
            String var5 = var4.readLine();
            if (var5 == null || !var5.contains("CORRODINGGAMES")) {
                GameEngine.b("startRemoveOnMasterServer", "Error bad header returned from the master server: " + var5);
                return;
            }

            String var6 = var4.readLine();
            GameEngine.b("startRemoveOnMasterServer", "Remove server response was:" + var6);
            GameEngine.b("startRemoveOnMasterServer", "Completed load from master server without error");
        } catch (IOException var7) {
            GameEngine.b("startRemoveOnMasterServer", "Remove failed");
            var7.printStackTrace();
        }

    }
}
