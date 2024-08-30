package com.codedisaster.steamworks;

public final class SteamNetworking$API {
    public static final SteamNetworking$API Client = new SteamNetworking$API("Client", 0);
    public static final SteamNetworking$API Server = new SteamNetworking$API("Server", 1);
    // $FF: synthetic field
    private static final SteamNetworking$API[] $VALUES = new SteamNetworking$API[]{Client, Server};

    public static SteamNetworking$API[] values() {
        return (SteamNetworking$API[])$VALUES.clone();
    }
    private SteamNetworking$API(String var1, int var2) {
    }
}
