package com.codedisaster.steamworks;

public interface SteamNetworkingCallback {
    void onP2PSessionConnectFail(SteamID var1, SteamNetworking$P2PSessionError var2);

    void onP2PSessionRequest(SteamID var1);
}
