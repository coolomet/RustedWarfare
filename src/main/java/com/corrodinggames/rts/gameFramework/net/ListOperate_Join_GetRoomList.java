package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import java.util.ArrayList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;

class ListOperate_Join_GetRoomList implements Runnable {
    Runnable a;

    ListOperate_Join_GetRoomList(Runnable var1) {
        this.a = var1;
    }

    public void run() {
        GameEngine.aq();
        GameEngine var1 = GameEngine.getGameEngine();
        GameEngine.b("LoadFromMasterServer", "Starting load");
        int var2 = GameNetAPIOperate.e++;

        try {
            Timer var3 = new Timer();
            var3.schedule(new class_217(var2), 5000L);
            ArrayList var4 = new ArrayList(2);
            var4.add(new BasicNameValuePair("action", "list"));
            var4.add(new BasicNameValuePair("game_version", Integer.toString(var1.c(true))));
            var4.add(new BasicNameValuePair("game_version_beta", class_340.a(var1.n())));
            boolean var5 = false;
            GameNetAPIOperate.a(var4, false, new ListOperate_Join_GetRoomList$1(this, var2, var1));
        } catch (Exception var6) {
            var6.printStackTrace();
            var1.log("Error getting game list from server", 1);
        }

    }
}
