package com.codedisaster.steamworks;

public final class SteamFriends$PersonaState {
    public static final SteamFriends$PersonaState Offline = new SteamFriends$PersonaState("Offline", 0);
    public static final SteamFriends$PersonaState Online = new SteamFriends$PersonaState("Online", 1);
    public static final SteamFriends$PersonaState Busy = new SteamFriends$PersonaState("Busy", 2);
    public static final SteamFriends$PersonaState Away = new SteamFriends$PersonaState("Away", 3);
    public static final SteamFriends$PersonaState Snooze = new SteamFriends$PersonaState("Snooze", 4);
    public static final SteamFriends$PersonaState LookingToTrade = new SteamFriends$PersonaState("LookingToTrade", 5);
    public static final SteamFriends$PersonaState LookingToPlay = new SteamFriends$PersonaState("LookingToPlay", 6);
    // $FF: synthetic field
    private static final SteamFriends$PersonaState[] $VALUES = new SteamFriends$PersonaState[]{Offline, Online, Busy, Away, Snooze, LookingToTrade, LookingToPlay};

    private SteamFriends$PersonaState(String var1, int var2) {
    }

    static SteamFriends$PersonaState byOrdinal(int var0) {
        return $VALUES[var0];
    }
}
