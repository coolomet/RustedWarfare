package com.corrodinggames.rts.java.steam;

import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamNetworking$P2PSessionError;
import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.IOException;

public strictfp class SteamNetworkingCallback implements com.codedisaster.steamworks.SteamNetworkingCallback {
    SteamEngine a;

    public SteamNetworkingCallback(SteamEngine var1) {
        this.a = var1;
    }

    public void onP2PSessionConnectFail(SteamID var1, SteamNetworking$P2PSessionError var2) {
        GameEngine.log("onP2PSessionConnectFail:" + var2);
        SteamSocket var3 = (SteamSocket)this.a.l.get(var1);
        if (var3 != null && !var3.isClosed()) {
            GameEngine.log("onP2PSessionConnectFail: closing active socket");

            try {
                var3.close();
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        }

    }

    public void onP2PSessionRequest(SteamID var1) {
        GameEngine.log("onP2PSessionRequest:" + var1);
        this.a.h.acceptP2PSessionWithUser(var1);
    }
}
