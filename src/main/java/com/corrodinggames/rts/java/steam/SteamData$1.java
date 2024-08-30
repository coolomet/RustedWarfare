package com.corrodinggames.rts.java.steam;

import com.corrodinggames.librocket.class_804;
import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.librocket.scripts.ScriptEngine;

class SteamData$1 implements Runnable {
    // $FF: synthetic field
    final SteamData a;

    SteamData$1(SteamData var1) {
        this.a = var1;
    }

    public void run() {
        Root var1 = ScriptEngine.getInstance().getRoot();
        class_804 var2 = new class_804("Join", this.a);
        var1.showPopupWithButtons("Invite", "'" + this.a.b + "' has invited you to join a game", true, var2, (class_804)null);
    }
}
