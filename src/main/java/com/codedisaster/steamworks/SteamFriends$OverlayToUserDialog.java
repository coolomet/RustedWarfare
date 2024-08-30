package com.codedisaster.steamworks;

public final class SteamFriends$OverlayToUserDialog {
    public static final SteamFriends$OverlayToUserDialog SteamID = new SteamFriends$OverlayToUserDialog("SteamID", 0, "steamid");
    public static final SteamFriends$OverlayToUserDialog Chat = new SteamFriends$OverlayToUserDialog("Chat", 1, "chat");
    public static final SteamFriends$OverlayToUserDialog JoinTrade = new SteamFriends$OverlayToUserDialog("JoinTrade", 2, "jointrade");
    public static final SteamFriends$OverlayToUserDialog Stats = new SteamFriends$OverlayToUserDialog("Stats", 3, "stats");
    public static final SteamFriends$OverlayToUserDialog Achievements = new SteamFriends$OverlayToUserDialog("Achievements", 4, "achievements");
    public static final SteamFriends$OverlayToUserDialog FriendAdd = new SteamFriends$OverlayToUserDialog("FriendAdd", 5, "friendadd");
    public static final SteamFriends$OverlayToUserDialog FriendRemove = new SteamFriends$OverlayToUserDialog("FriendRemove", 6, "friendremove");
    public static final SteamFriends$OverlayToUserDialog FriendRequestAccept = new SteamFriends$OverlayToUserDialog("FriendRequestAccept", 7, "friendrequestaccept");
    public static final SteamFriends$OverlayToUserDialog FriendRequestIgnore = new SteamFriends$OverlayToUserDialog("FriendRequestIgnore", 8, "friendrequestignore");
    private final String id;
    // $FF: synthetic field
    private static final SteamFriends$OverlayToUserDialog[] $VALUES = new SteamFriends$OverlayToUserDialog[]{SteamID, Chat, JoinTrade, Stats, Achievements, FriendAdd, FriendRemove, FriendRequestAccept, FriendRequestIgnore};

    public static SteamFriends$OverlayToUserDialog[] values() {
        return (SteamFriends$OverlayToUserDialog[])$VALUES.clone();
    }

    private SteamFriends$OverlayToUserDialog(String var1, int var2, String var3) {
        this.id = var3;
    }

    // $FF: synthetic method
    static String access$200(SteamFriends$OverlayToUserDialog var0) {
        return var0.id;
    }
}
