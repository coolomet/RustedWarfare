package com.codedisaster.steamworks;

public final class SteamUGC$MatchingUGCType {
    public static final SteamUGC$MatchingUGCType Items = new SteamUGC$MatchingUGCType("Items", 0, 0);
    public static final SteamUGC$MatchingUGCType ItemsMtx = new SteamUGC$MatchingUGCType("ItemsMtx", 1, 1);
    public static final SteamUGC$MatchingUGCType ItemsReadyToUse = new SteamUGC$MatchingUGCType("ItemsReadyToUse", 2, 2);
    public static final SteamUGC$MatchingUGCType Collections = new SteamUGC$MatchingUGCType("Collections", 3, 3);
    public static final SteamUGC$MatchingUGCType Artwork = new SteamUGC$MatchingUGCType("Artwork", 4, 4);
    public static final SteamUGC$MatchingUGCType Videos = new SteamUGC$MatchingUGCType("Videos", 5, 5);
    public static final SteamUGC$MatchingUGCType Screenshots = new SteamUGC$MatchingUGCType("Screenshots", 6, 6);
    public static final SteamUGC$MatchingUGCType AllGuides = new SteamUGC$MatchingUGCType("AllGuides", 7, 7);
    public static final SteamUGC$MatchingUGCType WebGuides = new SteamUGC$MatchingUGCType("WebGuides", 8, 8);
    public static final SteamUGC$MatchingUGCType IntegratedGuides = new SteamUGC$MatchingUGCType("IntegratedGuides", 9, 9);
    public static final SteamUGC$MatchingUGCType UsableInGame = new SteamUGC$MatchingUGCType("UsableInGame", 10, 10);
    public static final SteamUGC$MatchingUGCType ControllerBindings = new SteamUGC$MatchingUGCType("ControllerBindings", 11, 11);
    public static final SteamUGC$MatchingUGCType GameManagedItems = new SteamUGC$MatchingUGCType("GameManagedItems", 12, 12);
    public static final SteamUGC$MatchingUGCType All = new SteamUGC$MatchingUGCType("All", 13, -1);
    private final int value;
    // $FF: synthetic field
    private static final SteamUGC$MatchingUGCType[] $VALUES = new SteamUGC$MatchingUGCType[]{Items, ItemsMtx, ItemsReadyToUse, Collections, Artwork, Videos, Screenshots, AllGuides, WebGuides, IntegratedGuides, UsableInGame, ControllerBindings, GameManagedItems, All};

    public static SteamUGC$MatchingUGCType[] values() {
        return (SteamUGC$MatchingUGCType[])$VALUES.clone();
    }
    private final int ordinal;
    private SteamUGC$MatchingUGCType(String var1, int var2, int var3) {
        this.ordinal = var2;
        this.value = var3;
    }
    public int ordinal() { return ordinal; }
    // $FF: synthetic method
    static int access$000(SteamUGC$MatchingUGCType var0) {
        return var0.value;
    }
}
