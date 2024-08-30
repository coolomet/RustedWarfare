package com.codedisaster.steamworks;

public final class SteamFriends$PersonaChange {
    public static final SteamFriends$PersonaChange Name = new SteamFriends$PersonaChange("Name", 0, 1);
    public static final SteamFriends$PersonaChange Status = new SteamFriends$PersonaChange("Status", 1, 2);
    public static final SteamFriends$PersonaChange ComeOnline = new SteamFriends$PersonaChange("ComeOnline", 2, 4);
    public static final SteamFriends$PersonaChange GoneOffline = new SteamFriends$PersonaChange("GoneOffline", 3, 8);
    public static final SteamFriends$PersonaChange GamePlayed = new SteamFriends$PersonaChange("GamePlayed", 4, 16);
    public static final SteamFriends$PersonaChange GameServer = new SteamFriends$PersonaChange("GameServer", 5, 32);
    public static final SteamFriends$PersonaChange Avatar = new SteamFriends$PersonaChange("Avatar", 6, 64);
    public static final SteamFriends$PersonaChange JoinedSource = new SteamFriends$PersonaChange("JoinedSource", 7, 128);
    public static final SteamFriends$PersonaChange LeftSource = new SteamFriends$PersonaChange("LeftSource", 8, 256);
    public static final SteamFriends$PersonaChange RelationshipChanged = new SteamFriends$PersonaChange("RelationshipChanged", 9, 512);
    public static final SteamFriends$PersonaChange NameFirstSet = new SteamFriends$PersonaChange("NameFirstSet", 10, 1024);
    public static final SteamFriends$PersonaChange FacebookInfo = new SteamFriends$PersonaChange("FacebookInfo", 11, 2048);
    public static final SteamFriends$PersonaChange Nickname = new SteamFriends$PersonaChange("Nickname", 12, 4096);
    public static final SteamFriends$PersonaChange SteamLevel = new SteamFriends$PersonaChange("SteamLevel", 13, 8192);
    private final int bits;
    // $FF: synthetic field
    private static final SteamFriends$PersonaChange[] $VALUES = new SteamFriends$PersonaChange[]{Name, Status, ComeOnline, GoneOffline, GamePlayed, GameServer, Avatar, JoinedSource, LeftSource, RelationshipChanged, NameFirstSet, FacebookInfo, Nickname, SteamLevel};

    public static SteamFriends$PersonaChange[] values() {
        return (SteamFriends$PersonaChange[])$VALUES.clone();
    }

    private SteamFriends$PersonaChange(String var1, int var2, int var3) {
        this.bits = var3;
    }

    static boolean isSet(SteamFriends$PersonaChange var0, int var1) {
        return (var0.bits & var1) == var0.bits;
    }
}
