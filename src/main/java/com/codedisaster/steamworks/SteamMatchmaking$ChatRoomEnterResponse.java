package com.codedisaster.steamworks;

public final class SteamMatchmaking$ChatRoomEnterResponse {
    public static final SteamMatchmaking$ChatRoomEnterResponse Success = new SteamMatchmaking$ChatRoomEnterResponse("Success", 0, 1);
    public static final SteamMatchmaking$ChatRoomEnterResponse DoesntExist = new SteamMatchmaking$ChatRoomEnterResponse("DoesntExist", 1, 2);
    public static final SteamMatchmaking$ChatRoomEnterResponse NotAllowed = new SteamMatchmaking$ChatRoomEnterResponse("NotAllowed", 2, 3);
    public static final SteamMatchmaking$ChatRoomEnterResponse Full = new SteamMatchmaking$ChatRoomEnterResponse("Full", 3, 4);
    public static final SteamMatchmaking$ChatRoomEnterResponse Error = new SteamMatchmaking$ChatRoomEnterResponse("Error", 4, 5);
    public static final SteamMatchmaking$ChatRoomEnterResponse Banned = new SteamMatchmaking$ChatRoomEnterResponse("Banned", 5, 6);
    public static final SteamMatchmaking$ChatRoomEnterResponse Limited = new SteamMatchmaking$ChatRoomEnterResponse("Limited", 6, 7);
    public static final SteamMatchmaking$ChatRoomEnterResponse ClanDisabled = new SteamMatchmaking$ChatRoomEnterResponse("ClanDisabled", 7, 8);
    public static final SteamMatchmaking$ChatRoomEnterResponse CommunityBan = new SteamMatchmaking$ChatRoomEnterResponse("CommunityBan", 8, 9);
    public static final SteamMatchmaking$ChatRoomEnterResponse MemberBlockedYou = new SteamMatchmaking$ChatRoomEnterResponse("MemberBlockedYou", 9, 10);
    public static final SteamMatchmaking$ChatRoomEnterResponse YouBlockedMember = new SteamMatchmaking$ChatRoomEnterResponse("YouBlockedMember", 10, 11);
    private final int code;
    // $FF: synthetic field
    private static final SteamMatchmaking$ChatRoomEnterResponse[] $VALUES = new SteamMatchmaking$ChatRoomEnterResponse[]{Success, DoesntExist, NotAllowed, Full, Error, Banned, Limited, ClanDisabled, CommunityBan, MemberBlockedYou, YouBlockedMember};
    private SteamMatchmaking$ChatRoomEnterResponse(String var1, int var2, int var3) {
        this.code = var3;
    }

    static SteamMatchmaking$ChatRoomEnterResponse byCode(int var0) {
        SteamMatchmaking$ChatRoomEnterResponse[] var1 = $VALUES;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SteamMatchmaking$ChatRoomEnterResponse var4 = var1[var3];
            if (var4.code == var0) {
                return var4;
            }
        }

        return Error;
    }
}
