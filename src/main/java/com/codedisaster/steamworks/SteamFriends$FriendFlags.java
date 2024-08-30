package com.codedisaster.steamworks;

import java.util.Collection;
import java.util.Iterator;

public final class SteamFriends$FriendFlags {
    public static final SteamFriends$FriendFlags None = new SteamFriends$FriendFlags("None", 0, 0);
    public static final SteamFriends$FriendFlags Blocked = new SteamFriends$FriendFlags("Blocked", 1, 1);
    public static final SteamFriends$FriendFlags FriendshipRequested = new SteamFriends$FriendFlags("FriendshipRequested", 2, 2);
    public static final SteamFriends$FriendFlags Immediate = new SteamFriends$FriendFlags("Immediate", 3, 4);
    public static final SteamFriends$FriendFlags ClanMember = new SteamFriends$FriendFlags("ClanMember", 4, 8);
    public static final SteamFriends$FriendFlags OnGameServer = new SteamFriends$FriendFlags("OnGameServer", 5, 16);
    public static final SteamFriends$FriendFlags RequestingFriendship = new SteamFriends$FriendFlags("RequestingFriendship", 6, 128);
    public static final SteamFriends$FriendFlags RequestingInfo = new SteamFriends$FriendFlags("RequestingInfo", 7, 256);
    public static final SteamFriends$FriendFlags Ignored = new SteamFriends$FriendFlags("Ignored", 8, 512);
    public static final SteamFriends$FriendFlags IgnoredFriend = new SteamFriends$FriendFlags("IgnoredFriend", 9, 1024);
    public static final SteamFriends$FriendFlags ChatMember = new SteamFriends$FriendFlags("ChatMember", 10, 4096);
    public static final SteamFriends$FriendFlags All = new SteamFriends$FriendFlags("All", 11, 65535);
    private final int bits;
    // $FF: synthetic field
    private static final SteamFriends$FriendFlags[] $VALUES = new SteamFriends$FriendFlags[]{None, Blocked, FriendshipRequested, Immediate, ClanMember, OnGameServer, RequestingFriendship, RequestingInfo, Ignored, IgnoredFriend, ChatMember, All};

    public static SteamFriends$FriendFlags[] values() {
        return (SteamFriends$FriendFlags[])$VALUES.clone();
    }

    private SteamFriends$FriendFlags(String var1, int var2, int var3) {
        this.bits = var3;
    }

    static int asBits(Collection var0) {
        int var1 = 0;

        SteamFriends$FriendFlags var3;
        for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 |= var3.bits) {
            var3 = (SteamFriends$FriendFlags)var2.next();
        }

        return var1;
    }

    // $FF: synthetic method
    static int access$000(SteamFriends$FriendFlags var0) {
        return var0.bits;
    }
}
