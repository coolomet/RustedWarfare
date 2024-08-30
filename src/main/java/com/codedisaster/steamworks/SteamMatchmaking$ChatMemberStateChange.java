package com.codedisaster.steamworks;

public final class SteamMatchmaking$ChatMemberStateChange {
    public static final SteamMatchmaking$ChatMemberStateChange Entered = new SteamMatchmaking$ChatMemberStateChange("Entered", 0, 1);
    public static final SteamMatchmaking$ChatMemberStateChange Left = new SteamMatchmaking$ChatMemberStateChange("Left", 1, 2);
    public static final SteamMatchmaking$ChatMemberStateChange Disconnected = new SteamMatchmaking$ChatMemberStateChange("Disconnected", 2, 4);
    public static final SteamMatchmaking$ChatMemberStateChange Kicked = new SteamMatchmaking$ChatMemberStateChange("Kicked", 3, 8);
    public static final SteamMatchmaking$ChatMemberStateChange Banned = new SteamMatchmaking$ChatMemberStateChange("Banned", 4, 16);
    private final int bits;
    // $FF: synthetic field
    public static final SteamMatchmaking$ChatMemberStateChange[] $VALUES = new SteamMatchmaking$ChatMemberStateChange[]{Entered, Left, Disconnected, Kicked, Banned};

    private SteamMatchmaking$ChatMemberStateChange(String var1, int var2, int var3) {
        this.bits = var3;
    }

    static boolean isSet(SteamMatchmaking$ChatMemberStateChange var0, int var1) {
        return (var0.bits & var1) == var0.bits;
    }
}
