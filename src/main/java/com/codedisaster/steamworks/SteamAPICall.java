package com.codedisaster.steamworks;

public class SteamAPICall extends SteamNativeHandle {
    SteamAPICall(long var1) {
        super(var1);
    }

    public boolean isValid() {
        return this.handle != 0L;
    }
}
