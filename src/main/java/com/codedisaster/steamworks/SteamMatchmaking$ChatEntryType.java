package com.codedisaster.steamworks;

public final class SteamMatchmaking$ChatEntryType {
    public static final SteamMatchmaking$ChatEntryType Invalid = new SteamMatchmaking$ChatEntryType("Invalid", 0, 0);
    public static final SteamMatchmaking$ChatEntryType ChatMsg = new SteamMatchmaking$ChatEntryType("ChatMsg", 1, 1);
    public static final SteamMatchmaking$ChatEntryType Typing = new SteamMatchmaking$ChatEntryType("Typing", 2, 2);
    public static final SteamMatchmaking$ChatEntryType InviteGame = new SteamMatchmaking$ChatEntryType("InviteGame", 3, 3);
    public static final SteamMatchmaking$ChatEntryType Emote = new SteamMatchmaking$ChatEntryType("Emote", 4, 4);
    public static final SteamMatchmaking$ChatEntryType LeftConversation = new SteamMatchmaking$ChatEntryType("LeftConversation", 5, 6);
    public static final SteamMatchmaking$ChatEntryType Entered = new SteamMatchmaking$ChatEntryType("Entered", 6, 7);
    public static final SteamMatchmaking$ChatEntryType WasKicked = new SteamMatchmaking$ChatEntryType("WasKicked", 7, 8);
    public static final SteamMatchmaking$ChatEntryType WasBanned = new SteamMatchmaking$ChatEntryType("WasBanned", 8, 9);
    public static final SteamMatchmaking$ChatEntryType Disconnected = new SteamMatchmaking$ChatEntryType("Disconnected", 9, 10);
    public static final SteamMatchmaking$ChatEntryType HistoricalChat = new SteamMatchmaking$ChatEntryType("HistoricalChat", 10, 11);
    public static final SteamMatchmaking$ChatEntryType Reserved1 = new SteamMatchmaking$ChatEntryType("Reserved1", 11, 12);
    public static final SteamMatchmaking$ChatEntryType Reserved2 = new SteamMatchmaking$ChatEntryType("Reserved2", 12, 13);
    public static final SteamMatchmaking$ChatEntryType LinkBlocked = new SteamMatchmaking$ChatEntryType("LinkBlocked", 13, 14);
    private final int code;
    // $FF: synthetic field
    private static final SteamMatchmaking$ChatEntryType[] $VALUES = new SteamMatchmaking$ChatEntryType[]{Invalid, ChatMsg, Typing, InviteGame, Emote, LeftConversation, Entered, WasKicked, WasBanned, Disconnected, HistoricalChat, Reserved1, Reserved2, LinkBlocked};

    private SteamMatchmaking$ChatEntryType(String var1, int var2, int var3) {
        this.code = var3;
    }

    static SteamMatchmaking$ChatEntryType byCode(int var0) {
        SteamMatchmaking$ChatEntryType[] var1 = $VALUES;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SteamMatchmaking$ChatEntryType var4 = var1[var3];
            if (var4.code == var0) {
                return var4;
            }
        }

        return Invalid;
    }
}
