package com.codedisaster.steamworks;

public final class SteamMatchmaking$LobbyComparison {
    public static final SteamMatchmaking$LobbyComparison EqualToOrLessThan = new SteamMatchmaking$LobbyComparison("EqualToOrLessThan", 0, -2);
    public static final SteamMatchmaking$LobbyComparison LessThan = new SteamMatchmaking$LobbyComparison("LessThan", 1, -1);
    public static final SteamMatchmaking$LobbyComparison Equal = new SteamMatchmaking$LobbyComparison("Equal", 2, 0);
    public static final SteamMatchmaking$LobbyComparison GreaterThan = new SteamMatchmaking$LobbyComparison("GreaterThan", 3, 1);
    public static final SteamMatchmaking$LobbyComparison EqualToOrGreaterThan = new SteamMatchmaking$LobbyComparison("EqualToOrGreaterThan", 4, 2);
    public static final SteamMatchmaking$LobbyComparison NotEqual = new SteamMatchmaking$LobbyComparison("NotEqual", 5, 3);
    private final int value;
    // $FF: synthetic field
    private static final SteamMatchmaking$LobbyComparison[] $VALUES = new SteamMatchmaking$LobbyComparison[]{EqualToOrLessThan, LessThan, Equal, GreaterThan, EqualToOrGreaterThan, NotEqual};
    private SteamMatchmaking$LobbyComparison(String var1, int var2, int var3) {
        this.value = var3;
    }

    // $FF: synthetic method
    static int access$000(SteamMatchmaking$LobbyComparison var0) {
        return var0.value;
    }
}
