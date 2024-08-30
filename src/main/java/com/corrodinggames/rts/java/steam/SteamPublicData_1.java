package com.corrodinggames.rts.java.steam;

import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamResult;
import com.corrodinggames.rts.gameFramework.GameEngine;

public strictfp class SteamPublicData_1 {
    SteamPublishedFileID a;
    Runnable b;

    public void a(SteamResult var1) {
        GameEngine.print("PendingDownload onFinish for: " + this.a);
        if (this.b != null) {
            this.b.run();
        }

    }
}
