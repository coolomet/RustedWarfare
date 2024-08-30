package com.codedisaster.steamworks;

public final class SteamFriends$FriendRelationship {
    public static final SteamFriends$FriendRelationship None = new SteamFriends$FriendRelationship("None", 0);
    public static final SteamFriends$FriendRelationship Blocked = new SteamFriends$FriendRelationship("Blocked", 1);
    public static final SteamFriends$FriendRelationship Recipient = new SteamFriends$FriendRelationship("Recipient", 2);
    public static final SteamFriends$FriendRelationship Friend = new SteamFriends$FriendRelationship("Friend", 3);
    public static final SteamFriends$FriendRelationship RequestInitiator = new SteamFriends$FriendRelationship("RequestInitiator", 4);
    public static final SteamFriends$FriendRelationship Ignored = new SteamFriends$FriendRelationship("Ignored", 5);
    public static final SteamFriends$FriendRelationship IgnoredFriend = new SteamFriends$FriendRelationship("IgnoredFriend", 6);
    public static final SteamFriends$FriendRelationship Suggested_DEPRECATED = new SteamFriends$FriendRelationship("Suggested_DEPRECATED", 7);
    public static final SteamFriends$FriendRelationship Max = new SteamFriends$FriendRelationship("Max", 8);
    private static final SteamFriends$FriendRelationship[] values = values();
    // $FF: synthetic field
    private static final SteamFriends$FriendRelationship[] $VALUES = new SteamFriends$FriendRelationship[]{None, Blocked, Recipient, Friend, RequestInitiator, Ignored, IgnoredFriend, Suggested_DEPRECATED, Max};

    public static SteamFriends$FriendRelationship[] values() {
        return (SteamFriends$FriendRelationship[])$VALUES.clone();
    }
    private SteamFriends$FriendRelationship(String var1, int var2) {
    }

    static SteamFriends$FriendRelationship byOrdinal(int var0) {
        return values[var0];
    }
}
