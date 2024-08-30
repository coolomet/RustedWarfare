package com.codedisaster.steamworks;

public interface SteamUserCallback {
    void onValidateAuthTicket(SteamID var1, SteamAuth$AuthSessionResponse var2, SteamID var3);

    void onMicroTxnAuthorization(int var1, long var2, boolean var4);
}
