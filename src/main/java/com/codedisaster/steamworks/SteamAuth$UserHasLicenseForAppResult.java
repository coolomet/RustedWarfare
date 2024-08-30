package com.codedisaster.steamworks;

public final class SteamAuth$UserHasLicenseForAppResult {
    public static final SteamAuth$UserHasLicenseForAppResult HasLicense = new SteamAuth$UserHasLicenseForAppResult("HasLicense", 0);
    public static final SteamAuth$UserHasLicenseForAppResult DoesNotHaveLicense = new SteamAuth$UserHasLicenseForAppResult("DoesNotHaveLicense", 1);
    public static final SteamAuth$UserHasLicenseForAppResult NoAuth = new SteamAuth$UserHasLicenseForAppResult("NoAuth", 2);
    private static final SteamAuth$UserHasLicenseForAppResult[] values = values();
    // $FF: synthetic field
    private static final SteamAuth$UserHasLicenseForAppResult[] $VALUES = new SteamAuth$UserHasLicenseForAppResult[]{HasLicense, DoesNotHaveLicense, NoAuth};

    public static SteamAuth$UserHasLicenseForAppResult[] values() {
        return (SteamAuth$UserHasLicenseForAppResult[])$VALUES.clone();
    }
    private SteamAuth$UserHasLicenseForAppResult(String var1, int var2) {
    }

    static SteamAuth$UserHasLicenseForAppResult byOrdinal(int var0) {
        return values[var0];
    }
}
