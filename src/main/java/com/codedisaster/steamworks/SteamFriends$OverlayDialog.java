package com.codedisaster.steamworks;

public final class SteamFriends$OverlayDialog {
    public static final SteamFriends$OverlayDialog Friends = new SteamFriends$OverlayDialog("Friends", 0, "Friends");
    public static final SteamFriends$OverlayDialog Community = new SteamFriends$OverlayDialog("Community", 1, "Community");
    public static final SteamFriends$OverlayDialog Players = new SteamFriends$OverlayDialog("Players", 2, "Players");
    public static final SteamFriends$OverlayDialog Settings = new SteamFriends$OverlayDialog("Settings", 3, "Settings");
    public static final SteamFriends$OverlayDialog OfficialGameGroup = new SteamFriends$OverlayDialog("OfficialGameGroup", 4, "OfficialGameGroup");
    public static final SteamFriends$OverlayDialog Stats = new SteamFriends$OverlayDialog("Stats", 5, "Stats");
    public static final SteamFriends$OverlayDialog Achievements = new SteamFriends$OverlayDialog("Achievements", 6, "Achievements");
    private final String id;
    // $FF: synthetic field
    private static final SteamFriends$OverlayDialog[] $VALUES = new SteamFriends$OverlayDialog[]{Friends, Community, Players, Settings, OfficialGameGroup, Stats, Achievements};

    public static SteamFriends$OverlayDialog[] values() {
        return (SteamFriends$OverlayDialog[])$VALUES.clone();
    }

    private SteamFriends$OverlayDialog(String var1, int var2, String var3) {
        this.id = var3;
    }

    // $FF: synthetic method
    static String access$100(SteamFriends$OverlayDialog var0) {
        return var0.id;
    }
}
