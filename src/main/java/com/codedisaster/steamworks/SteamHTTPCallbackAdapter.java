package com.codedisaster.steamworks;

class SteamHTTPCallbackAdapter extends SteamCallbackAdapter {
    SteamHTTPCallbackAdapter(SteamHTTPCallback var1) {
        super(var1);
    }

    void onHTTPRequestCompleted(long var1, long var3, boolean var5, int var6, int var7) {
        ((SteamHTTPCallback)this.callback).onHTTPRequestCompleted(new SteamHTTPRequestHandle(var1), var3, var5, SteamHTTP$HTTPStatusCode.byValue(var6), var7);
    }

    void onHTTPRequestHeadersReceived(long var1, long var3) {
        ((SteamHTTPCallback)this.callback).onHTTPRequestHeadersReceived(new SteamHTTPRequestHandle(var1), var3);
    }

    void onHTTPRequestDataReceived(long var1, long var3, int var5, int var6) {
        ((SteamHTTPCallback)this.callback).onHTTPRequestDataReceived(new SteamHTTPRequestHandle(var1), var3, var5, var6);
    }
}
