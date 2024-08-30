package com.codedisaster.steamworks;

public abstract class SteamNativeHandle {
    long handle;

    SteamNativeHandle(long var1) {
        this.handle = var1;
    }

    public static long getNativeHandle(SteamNativeHandle var0) {
        return var0.handle;
    }

    public int hashCode() {
        return Long.valueOf(this.handle).hashCode();
    }

    public boolean equals(Object var1) {
        if (var1 instanceof SteamNativeHandle) {
            return this.handle == ((SteamNativeHandle)var1).handle;
        } else {
            return false;
        }
    }

    public String toString() {
        return Long.toHexString(this.handle);
    }
}
