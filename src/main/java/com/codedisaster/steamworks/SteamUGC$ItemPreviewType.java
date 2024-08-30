package com.codedisaster.steamworks;

public final class SteamUGC$ItemPreviewType {
    public static final SteamUGC$ItemPreviewType Image = new SteamUGC$ItemPreviewType("Image", 0, 0);
    public static final SteamUGC$ItemPreviewType YouTubeVideo = new SteamUGC$ItemPreviewType("YouTubeVideo", 1, 1);
    public static final SteamUGC$ItemPreviewType Sketchfab = new SteamUGC$ItemPreviewType("Sketchfab", 2, 2);
    public static final SteamUGC$ItemPreviewType EnvironmentMap_HorizontalCross = new SteamUGC$ItemPreviewType("EnvironmentMap_HorizontalCross", 3, 3);
    public static final SteamUGC$ItemPreviewType EnvironmentMap_LatLong = new SteamUGC$ItemPreviewType("EnvironmentMap_LatLong", 4, 4);
    public static final SteamUGC$ItemPreviewType ReservedMax = new SteamUGC$ItemPreviewType("ReservedMax", 5, 255);
    public static final SteamUGC$ItemPreviewType UnknownPreviewType_NotImplementedByAPI = new SteamUGC$ItemPreviewType("UnknownPreviewType_NotImplementedByAPI", 6, -1);
    private final int value;
    private static final SteamUGC$ItemPreviewType[] values = values();
    // $FF: synthetic field
    private static final SteamUGC$ItemPreviewType[] $VALUES = new SteamUGC$ItemPreviewType[]{Image, YouTubeVideo, Sketchfab, EnvironmentMap_HorizontalCross, EnvironmentMap_LatLong, ReservedMax, UnknownPreviewType_NotImplementedByAPI};

    public static SteamUGC$ItemPreviewType[] values() {
        return (SteamUGC$ItemPreviewType[])$VALUES.clone();
    }

    private SteamUGC$ItemPreviewType(String var1, int var2, int var3) {
        this.value = var3;
    }

    static SteamUGC$ItemPreviewType byValue(int var0) {
        SteamUGC$ItemPreviewType[] var1 = values;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SteamUGC$ItemPreviewType var4 = var1[var3];
            if (var4.value == var0) {
                return var4;
            }
        }

        return UnknownPreviewType_NotImplementedByAPI;
    }
}
