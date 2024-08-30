package com.codedisaster.steamworks;

class SteamGameServerStatsCallbackAdapter extends SteamCallbackAdapter {
    SteamGameServerStatsCallbackAdapter(SteamGameServerStatsCallback var1) {
        super(var1);
    }

    void onStatsReceived(int var1, long var2) {
        ((SteamGameServerStatsCallback)this.callback).onStatsReceived(SteamResult.byValue(var1), new SteamID(var2));
    }

    void onStatsStored(int var1, long var2) {
        ((SteamGameServerStatsCallback)this.callback).onStatsStored(SteamResult.byValue(var1), new SteamID(var2));
    }

    void onStatsUnloaded(long var1) {
        ((SteamGameServerStatsCallback)this.callback).onStatsUnloaded(new SteamID(var1));
    }
}
