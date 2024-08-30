package com.corrodinggames.rts.appFramework;

import android.os.Handler;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.net.GameNetAPIOperate;
import com.corrodinggames.rts.gameFramework.net.ListRoomInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.appFramework.p
public strictfp class class_196 extends class_194 {
    static class_196 c;
    Handler d;// maybe error
    private Runnable e;

    public static void l() {
        if (c != null) {
            c.d.a(c.e);
        }

    }

    public static ArrayList m() {
        synchronized(GameNetAPIOperate.f) {
            GameEngine var1 = GameEngine.getGameEngine();
            ArrayList var2 = new ArrayList();
            Iterator var3 = var1.netEngine.bi.iterator();

            while(var3.hasNext()) {
                ListRoomInfo var4 = (ListRoomInfo)var3.next();
                var2.add(var4);
            }

            Collections.sort(var2, new class_57());
            return var2;
        }
    }
}
