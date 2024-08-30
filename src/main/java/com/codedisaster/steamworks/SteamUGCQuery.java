package com.codedisaster.steamworks;

public class SteamUGCQuery extends SteamNativeHandle {
    public SteamUGCQuery(long var1) {
        super(var1);
    }

    public boolean isValid() {
        return this.handle != -1L;
    }
}
