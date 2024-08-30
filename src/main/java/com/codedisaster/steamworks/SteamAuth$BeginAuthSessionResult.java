package com.codedisaster.steamworks;

public final class SteamAuth$BeginAuthSessionResult {
    public static final SteamAuth$BeginAuthSessionResult OK = new SteamAuth$BeginAuthSessionResult("OK", 0);
    public static final SteamAuth$BeginAuthSessionResult InvalidTicket = new SteamAuth$BeginAuthSessionResult("InvalidTicket", 1);
    public static final SteamAuth$BeginAuthSessionResult DuplicateRequest = new SteamAuth$BeginAuthSessionResult("DuplicateRequest", 2);
    public static final SteamAuth$BeginAuthSessionResult InvalidVersion = new SteamAuth$BeginAuthSessionResult("InvalidVersion", 3);
    public static final SteamAuth$BeginAuthSessionResult GameMismatch = new SteamAuth$BeginAuthSessionResult("GameMismatch", 4);
    public static final SteamAuth$BeginAuthSessionResult ExpiredTicket = new SteamAuth$BeginAuthSessionResult("ExpiredTicket", 5);
    private static final SteamAuth$BeginAuthSessionResult[] values = values();
    // $FF: synthetic field
    private static final SteamAuth$BeginAuthSessionResult[] $VALUES = new SteamAuth$BeginAuthSessionResult[]{OK, InvalidTicket, DuplicateRequest, InvalidVersion, GameMismatch, ExpiredTicket};

    public static SteamAuth$BeginAuthSessionResult[] values() {
        return (SteamAuth$BeginAuthSessionResult[])$VALUES.clone();
    }



    private SteamAuth$BeginAuthSessionResult(String var1, int var2) {
    }

    static SteamAuth$BeginAuthSessionResult byOrdinal(int var0) {
        return values[var0];
    }
}
