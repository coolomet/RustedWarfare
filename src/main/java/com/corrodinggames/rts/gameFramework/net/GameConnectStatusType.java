package com.corrodinggames.rts.gameFramework.net;

public enum GameConnectStatusType{
    WRONG_PASSWORD("wrongPassword", 0),
    UNKNOWN("unknown", 1);
    // $FF: synthetic field
    private static final GameConnectStatusType[] c = new GameConnectStatusType[]{WRONG_PASSWORD, UNKNOWN};
    GameConnectStatusType(String var1, int var2) {
    }
}
