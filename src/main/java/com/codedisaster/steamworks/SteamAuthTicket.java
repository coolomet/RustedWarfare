package com.codedisaster.steamworks;

public class SteamAuthTicket extends SteamNativeHandle {
    static final long AuthTicketInvalid = 0L;

    SteamAuthTicket(long var1) {
        super(var1);
    }

    public boolean isValid() {
        return this.handle != 0L;
    }
}
